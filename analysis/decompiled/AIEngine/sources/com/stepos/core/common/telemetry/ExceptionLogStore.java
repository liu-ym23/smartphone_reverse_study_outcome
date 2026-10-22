package com.stepos.core.common.telemetry;

import android.content.Context;
import android.os.SystemClock;
import android.system.Os;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.collections.EmptyList;
import lb.n;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ExceptionLogStore {
    private static final String CACHE_SUBDIR = "exp";
    private static final int DIR_MODE = 509;
    private static final int FILE_MODE = 420;
    private static final int GLOBAL_LIMIT = 50;
    private static final long GLOBAL_WINDOW_MS = 3600000;
    private static final long MAX_DIR_BYTES = 2097152;
    private static final int MAX_FILES = 20;
    private static final int MAX_FILE_BYTES = 49152;
    private static final int MAX_TRACKED_KEYS = 128;
    private static final long MODEL_LOAD_DEDUP_MS = 60000;
    private static final int SAME_KEY_LIMIT = 3;
    private static final long SAME_KEY_WINDOW_MS = 300000;
    private static final String TAG = "EmsReporter";
    private static volatile long suppressedCount;
    public static final ExceptionLogStore INSTANCE = new ExceptionLogStore();
    private static volatile String lastPersistDir = "";
    private static final HashMap<String, Window> perKeyWindows = new HashMap<>();
    private static final Window globalWindow = new Window(0, 0);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Window {
        private int count;
        private long startMs;

        public Window(long j10, int i10) {
            this.startMs = j10;
            this.count = i10;
        }

        public final boolean expired(long j10, long j11) {
            return j10 - this.startMs > j11;
        }

        public final int getCount() {
            return this.count;
        }

        public final long getStartMs() {
            return this.startMs;
        }

        public final boolean hit(long j10, long j11, int i10) {
            if (j10 - this.startMs > j11) {
                this.startMs = j10;
                this.count = 0;
            }
            int i11 = this.count;
            if (i11 >= i10) {
                return false;
            }
            this.count = i11 + 1;
            return true;
        }

        public final void setCount(int i10) {
            this.count = i10;
        }

        public final void setStartMs(long j10) {
            this.startMs = j10;
        }
    }

    private ExceptionLogStore() {
    }

    private final boolean allow(InferExceptionRecord inferExceptionRecord) {
        String strH;
        long j10;
        int i10;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashMap<String, Window> map = perKeyWindows;
        if (map.size() > 128) {
            Set<Map.Entry<String, Window>> setEntrySet = map.entrySet();
            kotlin.jvm.internal.g.e(setEntrySet, "<get-entries>(...)");
            Iterator<T> it = setEntrySet.iterator();
            while (it.hasNext()) {
                if (allow$lambda$14(jElapsedRealtime, (Map.Entry) it.next())) {
                    it.remove();
                }
            }
        }
        if (kotlin.jvm.internal.g.b(inferExceptionRecord.getFailStage(), FailStage.MODEL_LOAD)) {
            strH = com.stepos.core.ota.d.h("load#", inferExceptionRecord.getErrorCode(), inferExceptionRecord.getModelId(), "#");
            j10 = 60000;
            i10 = 1;
        } else {
            strH = inferExceptionRecord.getAbilityId() + "#" + inferExceptionRecord.getErrorCode();
            j10 = 300000;
            i10 = 3;
        }
        String str = strH;
        Window window = map.get(str);
        if (window == null) {
            window = new Window(jElapsedRealtime, 0);
            map.put(str, window);
        }
        if (window.hit(jElapsedRealtime, j10, i10)) {
            if (globalWindow.hit(jElapsedRealtime, 3600000L, 50)) {
                return true;
            }
            Log.w(TAG, "AI_EXP suppressed (global): cap=50/3600s expLogId=" + inferExceptionRecord.getExpLogId() + " suppressedTotal=" + (suppressedCount + 1));
            return false;
        }
        String expLogId = inferExceptionRecord.getExpLogId();
        long j11 = suppressedCount + 1;
        StringBuilder sbL = com.stepos.core.ota.d.l("AI_EXP suppressed (per-key): key=", j10 / 1000, str, " window=");
        sbL.append("s limit=");
        sbL.append(i10);
        sbL.append(" expLogId=");
        sbL.append(expLogId);
        sbL.append(" suppressedTotal=");
        sbL.append(j11);
        Log.w(TAG, sbL.toString());
        return false;
    }

    private static final boolean allow$lambda$14(long j10, Map.Entry it) {
        kotlin.jvm.internal.g.f(it, "it");
        return ((Window) it.getValue()).expired(j10, 300000L);
    }

    private final byte[] encodeWithinLimit(InferExceptionRecord inferExceptionRecord) {
        String json = inferExceptionRecord.toJson(true);
        Charset charset = gc.a.f9106b;
        byte[] bytes = json.getBytes(charset);
        kotlin.jvm.internal.g.e(bytes, "getBytes(...)");
        if (bytes.length <= MAX_FILE_BYTES) {
            return bytes;
        }
        List<String> lines = FailStack.INSTANCE.toLines(inferExceptionRecord.getFailStack());
        if (lines.isEmpty()) {
            return null;
        }
        byte[] bytes2 = InferExceptionRecord.copy$default(inferExceptionRecord, null, null, null, 0, null, null, null, null, null, null, null, null, false, null, 0L, 0L, 0L, 0L, 0, null, 0, null, null, null, null, kotlin.collections.a.z0(kotlin.collections.a.J0(lines.size() / 2, lines), "\n", null, null, null, 62), 0L, null, 234881023, null).toJson(true).getBytes(charset);
        kotlin.jvm.internal.g.e(bytes2, "getBytes(...)");
        if (bytes2.length <= MAX_FILE_BYTES) {
            return bytes2;
        }
        return null;
    }

    private final File expDir(boolean z) {
        Context context = l7.a.f10344a;
        if (context == null) {
            context = null;
        }
        if (context == null) {
            return null;
        }
        return resolveDir(new File(context.getCacheDir(), CACHE_SUBDIR), z);
    }

    private final void persist(InferExceptionRecord inferExceptionRecord) throws IOException {
        File fileExpDir = expDir(true);
        if (fileExpDir == null) {
            Log.e(TAG, "persist skipped: no writable exp dir");
            return;
        }
        sweep(fileExpDir);
        byte[] bArrEncodeWithinLimit = encodeWithinLimit(inferExceptionRecord);
        if (bArrEncodeWithinLimit == null) {
            a0.a.A("snapshot oversize, dropped: expLogId=", inferExceptionRecord.getExpLogId(), TAG);
            return;
        }
        File file = new File(fileExpDir, a0.a.j(inferExceptionRecord.getExpLogId(), ".json"));
        wb.d.c0(file, bArrEncodeWithinLimit);
        try {
            Os.chmod(file.getAbsolutePath(), FILE_MODE);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        lastPersistDir = fileExpDir.getAbsolutePath();
        Log.i(TAG, "persisted " + file.getAbsolutePath() + " bytes=" + bArrEncodeWithinLimit.length);
    }

    private final File resolveDir(File file, boolean z) {
        Object objA;
        boolean z3;
        if (file.isDirectory()) {
            return file;
        }
        if (!z) {
            return null;
        }
        try {
            if (file.mkdirs()) {
                try {
                    Os.chmod(file.getAbsolutePath(), DIR_MODE);
                    n nVar = n.f10413a;
                } catch (Throwable th) {
                    kotlin.c.a(th);
                }
                z3 = true;
            } else {
                z3 = false;
            }
            objA = Boolean.valueOf(z3);
        } catch (Throwable th2) {
            objA = kotlin.c.a(th2);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        if (!((Boolean) objA).booleanValue()) {
            return null;
        }
        a0.a.y("exp dir ready: ", file.getAbsolutePath(), TAG);
        return file;
    }

    private final void sweep(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            List listK0 = l.k0(fileArrListFiles, new Comparator() { // from class: com.stepos.core.common.telemetry.ExceptionLogStore$sweep$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t8, T t10) {
                    return ob.b.a(Long.valueOf(((File) t8).lastModified()), Long.valueOf(((File) t10).lastModified()));
                }
            });
            Iterator it = listK0.iterator();
            long length = 0;
            while (it.hasNext()) {
                length += ((File) it.next()).length();
            }
            for (int i10 = 0; i10 < listK0.size(); i10++) {
                if (listK0.size() - i10 < 20 && length < MAX_DIR_BYTES) {
                    return;
                }
                length -= ((File) listK0.get(i10)).length();
                ((File) listK0.get(i10)).delete();
            }
        }
    }

    public final int clear() {
        File[] fileArrListFiles;
        File fileExpDir = expDir(false);
        if (fileExpDir == null || (fileArrListFiles = fileExpDir.listFiles()) == null) {
            fileArrListFiles = new File[0];
        }
        int i10 = 0;
        for (File file : fileArrListFiles) {
            if (file.delete()) {
                i10++;
            }
        }
        perKeyWindows.clear();
        Window window = globalWindow;
        window.setStartMs(0L);
        window.setCount(0);
        suppressedCount = 0L;
        return i10;
    }

    public final String getLastPersistDir() {
        return lastPersistDir;
    }

    public final long getSuppressedCount() {
        return suppressedCount;
    }

    public final List<File> listSnapshots() {
        File[] fileArrListFiles;
        File fileExpDir = expDir(false);
        return (fileExpDir == null || (fileArrListFiles = fileExpDir.listFiles()) == null) ? EmptyList.f10001a : l.k0(fileArrListFiles, new Comparator() { // from class: com.stepos.core.common.telemetry.ExceptionLogStore$listSnapshots$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t10) {
                return ob.b.a(Long.valueOf(((File) t10).lastModified()), Long.valueOf(((File) t8).lastModified()));
            }
        });
    }

    public final String readJson(String expLogId) {
        Object objA;
        kotlin.jvm.internal.g.f(expLogId, "expLogId");
        File fileSnapshotFile = snapshotFile(expLogId);
        if (fileSnapshotFile == null) {
            return null;
        }
        try {
            objA = wb.d.Z(fileSnapshotFile, gc.a.f9106b);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return (String) (objA instanceof Result.Failure ? null : objA);
    }

    public final String readLastJson() {
        Object objA;
        File file = (File) kotlin.collections.a.v0(listSnapshots());
        if (file == null) {
            return null;
        }
        try {
            objA = wb.d.Z(file, gc.a.f9106b);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return (String) (objA instanceof Result.Failure ? null : objA);
    }

    public final File snapshotFile(String expLogId) {
        kotlin.jvm.internal.g.f(expLogId, "expLogId");
        File fileExpDir = expDir(false);
        if (fileExpDir == null) {
            return null;
        }
        File file = new File(fileExpDir, expLogId.concat(".json"));
        if (file.isFile()) {
            return file;
        }
        return null;
    }

    public final boolean write(InferExceptionRecord record) {
        Object objA;
        kotlin.jvm.internal.g.f(record, "record");
        if (!allow(record)) {
            suppressedCount++;
            return false;
        }
        Log.e(TAG, "AI_EXP " + InferExceptionRecord.toJson$default(record, false, 1, null));
        try {
            persist(record);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.w(TAG, "persist failed: expLogId=" + record.getExpLogId(), thB);
        }
        return true;
    }
}
