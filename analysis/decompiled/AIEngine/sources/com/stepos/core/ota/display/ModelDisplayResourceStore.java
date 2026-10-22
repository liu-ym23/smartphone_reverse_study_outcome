package com.stepos.core.ota.display;

import ad.n;
import android.content.Context;
import android.util.Xml;
import bd.i;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.model.manager.j;
import fc.f;
import gc.o;
import gc.q;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.g;
import lb.d;
import mb.l;
import mb.m;
import mb.y;
import okhttp3.Response;
import okhttp3.h;
import org.xmlpull.v1.XmlPullParser;
import wb.c;
import wb.c.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelDisplayResourceStore {
    private static final String DEFAULT_VALUES_DIR = "values";
    public static final String DISPLAY_SUBDIR = ".display";
    private static final long FAIL_BACKOFF_MS = 600000;
    private static final String FAIL_MARKER_FILE = ".source.fail";
    public static final String LOCAL_ZIP_NAME = "model_ui_res.zip";
    private static final String MARKER_FILE = ".source";
    private static final long MAX_ENTRY_BYTES = 2097152;
    private static final long MAX_TOTAL_BYTES = 8388608;
    private static final String MIRROR_KEY_NO_SOURCE = "nosource";
    private static final String MIRROR_MARKER_FILE = ".mirror";
    private static final int RANK_LOCAL = 0;
    private static final int RANK_REMOTE = 10;
    private static final String STRINGS_FILE = "strings.xml";
    private static final String SURVIVE_CACHE_ROOT = "model_display_cache";
    private static final String TAG = "ModelDisplayResStore";
    private static final d client$delegate;
    private static final d warmExecutor$delegate;
    public static final ModelDisplayResourceStore INSTANCE = new ModelDisplayResourceStore();
    private static final List<String> ICON_CANDIDATES = m.b0("icon.xml", "icon.png", "icon.webp", "icon.jpg", "icon.jpeg");
    private static final ConcurrentHashMap<String, Object> locks = new ConcurrentHashMap<>();
    private static final CopyOnWriteArrayList<OnDisplayReadyListener> readyListeners = new CopyOnWriteArrayList<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface OnDisplayReadyListener {
        void onDisplayReady(String str);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface Source {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Local implements Source {
            private final File zip;

            public Local(File zip) {
                g.f(zip, "zip");
                this.zip = zip;
            }

            public final File getZip() {
                return this.zip;
            }

            @Override // com.stepos.core.ota.display.ModelDisplayResourceStore.Source
            public String key() {
                long jLastModified = this.zip.lastModified();
                long length = this.zip.length();
                StringBuilder sbQ = ai.onnxruntime.a.q(jLastModified, "local:", ":");
                sbQ.append(length);
                return sbQ.toString();
            }

            @Override // com.stepos.core.ota.display.ModelDisplayResourceStore.Source
            public int rank() {
                return 0;
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Remote implements Source {
            private final String url;
            private final int version;

            public Remote(String url, int i10) {
                g.f(url, "url");
                this.url = url;
                this.version = i10;
            }

            public final String getUrl() {
                return this.url;
            }

            public final int getVersion() {
                return this.version;
            }

            @Override // com.stepos.core.ota.display.ModelDisplayResourceStore.Source
            public String key() {
                int i10 = this.version;
                return i10 > 0 ? ai.onnxruntime.providers.a.a(i10, "remote:v") : ai.onnxruntime.a.k("remote:", this.url);
            }

            @Override // com.stepos.core.ota.display.ModelDisplayResourceStore.Source
            public int rank() {
                return 10;
            }
        }

        String key();

        int rank();
    }

    static {
        int i10 = 19;
        client$delegate = kotlin.b.b(new a9.b(i10));
        warmExecutor$delegate = kotlin.b.b(new a9.a(i10));
    }

    private ModelDisplayResourceStore() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n client_delegate$lambda$0() {
        n.a aVar = new n.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVar.b(5L, timeUnit);
        aVar.c(15L, timeUnit);
        return new n(aVar);
    }

    private final File downloadToTemp(Context context, String str) throws IOException {
        File fileCreateTempFile = File.createTempFile("mdisp_", ".zip", context.getCacheDir());
        h.a aVar = new h.a();
        aVar.e(str);
        aVar.c("GET", null);
        Response responseD = getClient().a(new h(aVar)).d();
        try {
            try {
                if (!responseD.r) {
                    AIEngineLogger.e(LogModule.OTA, TAG, "download failed: HTTP " + responseD.f10891d + " url=" + str);
                    fileCreateTempFile.delete();
                    return null;
                }
                InputStream inputStreamF0 = responseD.f10893j.w().F0();
                try {
                    g.c(fileCreateTempFile);
                    FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                    try {
                        jd.b.n(inputStreamF0, fileOutputStream);
                        fileOutputStream.close();
                        inputStreamF0.close();
                        return fileCreateTempFile;
                    } finally {
                    }
                } finally {
                }
            } finally {
                i.b(responseD);
            }
        } catch (Exception e10) {
            fileCreateTempFile.delete();
            throw e10;
        }
    }

    public static /* synthetic */ String ensure$default(ModelDisplayResourceStore modelDisplayResourceStore, Context context, String str, String str2, String str3, int i10, String str4, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            i10 = 0;
        }
        int i12 = i10;
        if ((i11 & 32) != 0) {
            str4 = null;
        }
        return modelDisplayResourceStore.ensure(context, str, str2, str3, i12, str4);
    }

    public static /* synthetic */ void ensureAsync$default(ModelDisplayResourceStore modelDisplayResourceStore, Context context, String str, String str2, String str3, int i10, String str4, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            i10 = 0;
        }
        int i12 = i10;
        if ((i11 & 32) != 0) {
            str4 = null;
        }
        modelDisplayResourceStore.ensureAsync(context, str, str2, str3, i12, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ensureAsync$lambda$23$lambda$22(ModelDisplayResourceStore modelDisplayResourceStore, Context context, String str, String str2, String str3, int i10, String str4) {
        Object objA;
        try {
            g.c(context);
            objA = modelDisplayResourceStore.ensure(context, str, str2, str3, i10, str4);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.OTA, TAG, ai.onnxruntime.a.k("warm ensure failed: modelId=", str), thB);
        }
    }

    private final void ensureMirror(Context context, File file, String str, String str2) {
        boolean zBooleanValue;
        Object objA;
        Object objA2;
        if (q.t0(str)) {
            return;
        }
        File fileSurviveCacheDir = surviveCacheDir(context, str);
        if (findValidDisplayRoot(fileSurviveCacheDir) == null) {
            zBooleanValue = false;
        } else if (str2 == null) {
            zBooleanValue = true;
        } else {
            try {
                objA2 = Boolean.valueOf(wb.d.Z(new File(fileSurviveCacheDir, MIRROR_MARKER_FILE), gc.a.f9106b).equals(str2));
            } catch (Throwable th) {
                objA2 = c.a(th);
            }
            Object obj = Boolean.FALSE;
            if (objA2 instanceof Result.Failure) {
                objA2 = obj;
            }
            zBooleanValue = ((Boolean) objA2).booleanValue();
        }
        if (zBooleanValue) {
            return;
        }
        if (str2 == null) {
            str2 = MIRROR_KEY_NO_SOURCE;
        }
        try {
            mirrorToSurviveCache(context, file, str, str2);
            objA = lb.n.f10413a;
        } catch (Throwable th2) {
            objA = c.a(th2);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.OTA, TAG, "ensureMirror failed: modelId=".concat(str), thB);
        }
    }

    public static /* synthetic */ String existingDisplayDir$default(ModelDisplayResourceStore modelDisplayResourceStore, Context context, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        return modelDisplayResourceStore.existingDisplayDir(context, str, str2, str3);
    }

    private final File findDisplayRoot(File file) {
        File file2 = null;
        if (!file.isDirectory()) {
            return null;
        }
        if (new File(file, "values/strings.xml").isFile()) {
            return file;
        }
        c.b bVar = wb.d.b0(file).new b();
        while (true) {
            if (!bVar.hasNext()) {
                break;
            }
            File next = bVar.next();
            File file3 = next;
            if (file3.isDirectory() && new File(file3, "values/strings.xml").isFile()) {
                file2 = next;
                break;
            }
        }
        return file2;
    }

    private final File findLocalZip(String str) {
        File file = new File(str);
        File file2 = new File(file, LOCAL_ZIP_NAME);
        Object next = null;
        if (!file2.isFile()) {
            file2 = null;
        }
        if (file2 != null) {
            return file2;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return null;
        }
        f.a aVar = new f.a(new f(new fc.q(new f(l.Z(fileArrListFiles), new com.stepos.core.common.telemetry.b(15)), new com.stepos.core.common.cloud.d(20)), new com.stepos.core.common.telemetry.b(16)));
        if (aVar.hasNext()) {
            next = aVar.next();
            if (aVar.hasNext()) {
                long jLastModified = ((File) next).lastModified();
                do {
                    Object next2 = aVar.next();
                    long jLastModified2 = ((File) next2).lastModified();
                    if (jLastModified < jLastModified2) {
                        next = next2;
                        jLastModified = jLastModified2;
                    }
                } while (aVar.hasNext());
            }
        }
        return (File) next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean findLocalZip$lambda$55(File file) {
        return file.isDirectory() && !g.b(file.getName(), DISPLAY_SUBDIR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File findLocalZip$lambda$56(File file) {
        return new File(file, LOCAL_ZIP_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean findLocalZip$lambda$57(File it) {
        g.f(it, "it");
        return it.isFile();
    }

    private final File findValidDisplayRoot(File file) {
        File fileFindDisplayRoot = findDisplayRoot(file);
        if (fileFindDisplayRoot == null || !INSTANCE.isValidPackage(fileFindDisplayRoot)) {
            return null;
        }
        return fileFindDisplayRoot;
    }

    private final void fireDisplayReady(String str) {
        Object objA;
        CopyOnWriteArrayList<OnDisplayReadyListener> copyOnWriteArrayList = readyListeners;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            try {
                ((OnDisplayReadyListener) it.next()).onDisplayReady(str);
                objA = lb.n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.w(LogModule.OTA, TAG, ai.onnxruntime.a.k("displayReady listener failed: modelId=", str), thB);
            }
        }
    }

    private final n getClient() {
        return (n) client$delegate.getValue();
    }

    private final ExecutorService getWarmExecutor() {
        return (ExecutorService) warmExecutor$delegate.getValue();
    }

    private final boolean hasIcon(File file, String str) {
        List<String> list = ICON_CANDIDATES;
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (new File(file, com.stepos.core.ota.d.i(str, "/", (String) it.next())).isFile()) {
                return true;
            }
        }
        return false;
    }

    private final boolean inFailBackoff(File file, String str) {
        Object objA;
        String str2;
        String string;
        Long lD0;
        File file2 = new File(file, FAIL_MARKER_FILE);
        if (!file2.isFile()) {
            return false;
        }
        try {
            objA = q.w0(wb.d.Z(file2, gc.a.f9106b));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        List list = (List) objA;
        if (list == null || !g.b(kotlin.collections.a.w0(0, list), str) || (str2 = (String) kotlin.collections.a.w0(1, list)) == null || (string = q.L0(str2).toString()) == null || (lD0 = gc.n.d0(string)) == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - lD0.longValue();
        return 0 <= jCurrentTimeMillis && jCurrentTimeMillis < FAIL_BACKOFF_MS;
    }

    private final boolean isForeign(File file, String str) {
        Object objA;
        try {
            objA = q.L0(wb.d.Z(file, gc.a.f9106b)).toString();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        String str2 = (String) objA;
        if (str2 == null) {
            return false;
        }
        return (str == null || str.length() == 0) ? o.k0(str2, "remote:", false) : !str2.equals(str);
    }

    private final boolean isValidPackage(File file) {
        Object objA;
        CharSequence charSequence;
        File file2 = new File(file, "values/strings.xml");
        if (!file2.isFile()) {
            return false;
        }
        try {
            objA = parseStrings(file2);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.OTA, TAG, "strings.xml not valid XML", thB);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        Map map = (Map) objA;
        if (map == null || (charSequence = (CharSequence) map.get("title")) == null || q.t0(charSequence)) {
            return false;
        }
        return hasIcon(file, "drawable") || hasIcon(file, "drawable-night");
    }

    private final boolean keyMatches(File file, String str) {
        Object objA;
        if (str == null) {
            return true;
        }
        try {
            objA = q.L0(wb.d.Z(file, gc.a.f9106b)).toString();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        String str2 = (String) objA;
        if (str2 == null) {
            return false;
        }
        return str2.equals(str);
    }

    private final Object lockOf(String str) {
        Object objComputeIfAbsent = locks.computeIfAbsent(str, new j(new com.stepos.core.common.telemetry.b(14), 1));
        g.e(objComputeIfAbsent, "computeIfAbsent(...)");
        return objComputeIfAbsent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object lockOf$lambda$1(String it) {
        g.f(it, "it");
        return new Object();
    }

    private final void markFail(File file, String str) {
        try {
            file.mkdirs();
            wb.d.e0(new File(file, FAIL_MARKER_FILE), str + "\n" + System.currentTimeMillis());
            lb.n nVar = lb.n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    private final String materialize(Context context, Source source, File file, File file2, String str, String str2) throws IOException {
        File zip;
        File file3;
        Object objA;
        if (source instanceof Source.Remote) {
            zip = downloadToTemp(context, ((Source.Remote) source).getUrl());
            if (zip == null) {
                markFail(file, str);
                return null;
            }
            file3 = zip;
        } else {
            if (!(source instanceof Source.Local)) {
                throw new NoWhenBranchMatchedException();
            }
            zip = ((Source.Local) source).getZip();
            file3 = null;
        }
        try {
            wb.d.T(file);
            file.mkdirs();
            if (unzip(zip, file)) {
                File fileFindDisplayRoot = findDisplayRoot(file);
                if (fileFindDisplayRoot != null && isValidPackage(fileFindDisplayRoot)) {
                    wb.d.e0(file2, str);
                    new File(file, FAIL_MARKER_FILE).delete();
                    try {
                        mirrorToSurviveCache(context, fileFindDisplayRoot, str2, str);
                        objA = lb.n.f10413a;
                    } catch (Throwable th) {
                        objA = kotlin.c.a(th);
                    }
                    Throwable thB = Result.b(objA);
                    if (thB != null) {
                        AIEngineLogger.w(LogModule.OTA, TAG, "mirror to survive-cache failed: modelId=" + str2, thB);
                    }
                    AIEngineLogger.i(LogModule.OTA, TAG, "display resource ready: dir=" + fileFindDisplayRoot.getAbsolutePath() + " key=" + str);
                    fireDisplayReady(str2);
                    String absolutePath = fileFindDisplayRoot.getAbsolutePath();
                    if (file3 != null) {
                        file3.delete();
                    }
                    return absolutePath;
                }
                AIEngineLogger.w(LogModule.OTA, TAG, "invalid display package, discard: key=" + str);
                wb.d.T(file);
                markFail(file, str);
                if (file3 != null) {
                    file3.delete();
                }
            } else {
                wb.d.T(file);
                markFail(file, str);
                if (file3 != null) {
                    return null;
                }
            }
            return null;
        } finally {
            if (file3 != null) {
                file3.delete();
            }
        }
    }

    private final String mirrorKeyOf(Context context, String str) {
        Object objA;
        if (!q.t0(str)) {
            File fileSurviveCacheDir = surviveCacheDir(context, str);
            if (findValidDisplayRoot(fileSurviveCacheDir) != null) {
                try {
                    objA = wb.d.Z(new File(fileSurviveCacheDir, MIRROR_MARKER_FILE), gc.a.f9106b);
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                return (String) (objA instanceof Result.Failure ? null : objA);
            }
        }
        return null;
    }

    private final void mirrorToSurviveCache(Context context, File file, String str, String str2) throws IOException {
        File fileSurviveCacheDir = surviveCacheDir(context, str);
        int iRankOfKey = rankOfKey(mirrorKeyOf(context, str));
        if (rankOfKey(str2) < iRankOfKey) {
            LogModule logModule = LogModule.OTA;
            StringBuilder sbS = ai.onnxruntime.a.s("skip mirror downgrade: modelId=", str, " incoming=", str2, " keeps rank=");
            sbS.append(iRankOfKey);
            AIEngineLogger.i(logModule, TAG, sbS.toString());
            return;
        }
        File file2 = new File(fileSurviveCacheDir.getParentFile(), a0.a.j(str, ".tmp"));
        wb.d.T(file2);
        if (!file2.mkdirs()) {
            ai.onnxruntime.a.w("mirror mkdirs failed: ", file2.getAbsolutePath(), LogModule.OTA, TAG);
            return;
        }
        String strJ = a0.a.j(file2.getCanonicalPath(), File.separator);
        c.b bVar = wb.d.b0(file).new b();
        long length = 0;
        while (bVar.hasNext()) {
            File next = bVar.next();
            String path = wb.d.a0(next, file).getPath();
            g.c(path);
            if (path.length() != 0) {
                File file3 = new File(file2, path);
                String canonicalPath = file3.getCanonicalPath();
                g.e(canonicalPath, "getCanonicalPath(...)");
                if (!o.k0(canonicalPath, strJ, false)) {
                    continue;
                } else if (next.isDirectory()) {
                    file3.mkdirs();
                } else {
                    length += next.length();
                    if (length > MAX_TOTAL_BYTES) {
                        wb.d.T(file2);
                        AIEngineLogger.w(LogModule.OTA, TAG, "mirror too large, abort: modelId=" + str + " total=" + length);
                        return;
                    }
                    File parentFile = file3.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    wb.d.S(next, file3, true);
                }
            }
        }
        File file4 = new File(fileSurviveCacheDir.getParentFile(), a0.a.j(str, ".bak"));
        wb.d.T(file4);
        boolean zExists = fileSurviveCacheDir.exists();
        if (zExists && !fileSurviveCacheDir.renameTo(file4)) {
            wb.d.T(file2);
            ai.onnxruntime.a.w("mirror stash old failed: modelId=", str, LogModule.OTA, TAG);
            return;
        }
        if (file2.renameTo(fileSurviveCacheDir)) {
            wb.d.T(file4);
            try {
                wb.d.e0(new File(fileSurviveCacheDir, MIRROR_MARKER_FILE), str2);
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
            AIEngineLogger.i(LogModule.OTA, TAG, ai.onnxruntime.a.l("mirror to survive-cache ready: modelId=", str, " key=", str2));
            return;
        }
        wb.d.T(file2);
        if (zExists && !file4.renameTo(fileSurviveCacheDir)) {
            AIEngineLogger.e(LogModule.OTA, TAG, "mirror restore failed, cache lost: modelId=" + str);
        }
        ai.onnxruntime.a.w("mirror rename failed: modelId=", str, LogModule.OTA, TAG);
    }

    private final Map<String, String> parseStrings(File file) throws IOException {
        HashMap map = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            xmlPullParserNewPullParser.setInput(fileInputStream, null);
            StringBuilder sb2 = new StringBuilder();
            String attributeValue = null;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                if (eventType != 2) {
                    if (eventType != 3) {
                        if (eventType == 4 && attributeValue != null) {
                            sb2.append(xmlPullParserNewPullParser.getText());
                        }
                    } else if (g.b(xmlPullParserNewPullParser.getName(), "string") && attributeValue != null) {
                        String string = sb2.toString();
                        g.e(string, "toString(...)");
                        map.put(attributeValue, q.L0(string).toString());
                        attributeValue = null;
                    }
                } else if (g.b(xmlPullParserNewPullParser.getName(), "string")) {
                    attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "name");
                    sb2.setLength(0);
                }
            }
            lb.n nVar = lb.n.f10413a;
            fileInputStream.close();
            return map;
        } finally {
        }
    }

    public static /* synthetic */ void purgeForeign$default(ModelDisplayResourceStore modelDisplayResourceStore, Context context, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        modelDisplayResourceStore.purgeForeign(context, str, str2, str3);
    }

    private final int rankOfKey(String str) {
        return (str != null && o.k0(str, "remote:", false)) ? 10 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stagePresetDisplayAsync$lambda$29$lambda$28(ModelDisplayResourceStore modelDisplayResourceStore, Context context, String str, File file, String str2) {
        Object objA;
        try {
            g.c(context);
            objA = modelDisplayResourceStore.stagePresetDisplay(context, str, file, str2);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.OTA, TAG, ai.onnxruntime.a.k("stage preset display failed: modelId=", str), thB);
        }
    }

    private final File surviveCacheDir(Context context, String str) {
        return new File(new File(context.getFilesDir(), SURVIVE_CACHE_ROOT), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [T, java.util.zip.ZipEntry] */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.util.zip.ZipEntry] */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.util.zip.ZipEntry] */
    private final boolean unzip(File file, File file2) throws IOException {
        String strJ = a0.a.j(file2.getCanonicalPath(), File.separator);
        FileInputStream fileInputStream = new FileInputStream(file);
        int i10 = PcmDumpBudget.HARD_MAX_DIR_MB;
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream, PcmDumpBudget.HARD_MAX_DIR_MB));
        try {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.f10076a = zipInputStream.getNextEntry();
            long j10 = 0;
            loop0: while (ref$ObjectRef.f10076a != 0) {
                File file3 = new File(file2, ((ZipEntry) ref$ObjectRef.f10076a).getName());
                String canonicalPath = file3.getCanonicalPath();
                g.e(canonicalPath, "getCanonicalPath(...)");
                if (o.k0(canonicalPath, strJ, false)) {
                    if (((ZipEntry) ref$ObjectRef.f10076a).isDirectory()) {
                        file3.mkdirs();
                    } else {
                        File parentFile = file3.getParentFile();
                        if (parentFile != null) {
                            parentFile.mkdirs();
                        }
                        Ref$LongRef ref$LongRef = new Ref$LongRef();
                        FileOutputStream fileOutputStream = new FileOutputStream(file3);
                        try {
                            byte[] bArr = new byte[i10];
                            while (true) {
                                int i11 = zipInputStream.read(bArr);
                                if (i11 < 0) {
                                    long j11 = j10;
                                    lb.n nVar = lb.n.f10413a;
                                    fileOutputStream.close();
                                    j10 = j11;
                                    break;
                                }
                                long j12 = i11;
                                long j13 = ref$LongRef.f10075a + j12;
                                ref$LongRef.f10075a = j13;
                                j10 += j12;
                                if (j13 > MAX_ENTRY_BYTES || j10 > MAX_TOTAL_BYTES) {
                                    break loop0;
                                }
                                fileOutputStream.write(bArr, 0, i11);
                            }
                            LogModule logModule = LogModule.OTA;
                            ZipEntry zipEntry = (ZipEntry) ref$ObjectRef.f10076a;
                            AIEngineLogger.e(logModule, TAG, "package too large, abort: entry=" + (zipEntry != null ? zipEntry.getName() : null));
                            fileOutputStream.close();
                            zipInputStream.close();
                            return false;
                        } finally {
                        }
                    }
                    zipInputStream.closeEntry();
                    ref$ObjectRef.f10076a = zipInputStream.getNextEntry();
                    i10 = PcmDumpBudget.HARD_MAX_DIR_MB;
                } else {
                    AIEngineLogger.w(LogModule.OTA, TAG, "skip zip-slip entry: " + ((ZipEntry) ref$ObjectRef.f10076a).getName());
                    zipInputStream.closeEntry();
                    ref$ObjectRef.f10076a = zipInputStream.getNextEntry();
                }
            }
            lb.n nVar2 = lb.n.f10413a;
            zipInputStream.close();
            return true;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                y.q(zipInputStream, th);
                throw th2;
            }
        }
    }

    private final String validSurviveRoot(Context context, String str) {
        File fileFindValidDisplayRoot;
        if (q.t0(str) || (fileFindValidDisplayRoot = findValidDisplayRoot(surviveCacheDir(context, str))) == null) {
            return null;
        }
        return fileFindValidDisplayRoot.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExecutorService warmExecutor_delegate$lambda$5() {
        return Executors.newFixedThreadPool(4, new com.stepos.aicgroup.d(6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread warmExecutor_delegate$lambda$5$lambda$4(Runnable runnable) {
        return com.stepos.core.ota.d.n(runnable, "model-disp-warm", true);
    }

    public final void addOnDisplayReadyListener(OnDisplayReadyListener listener) {
        g.f(listener, "listener");
        CopyOnWriteArrayList<OnDisplayReadyListener> copyOnWriteArrayList = readyListeners;
        if (copyOnWriteArrayList.contains(listener)) {
            return;
        }
        copyOnWriteArrayList.add(listener);
    }

    public final void dropStagedPresetDisplay(String bucketDir, String installedDir) {
        Object objA;
        g.f(bucketDir, "bucketDir");
        g.f(installedDir, "installedDir");
        if (q.t0(bucketDir) || q.t0(installedDir)) {
            return;
        }
        File file = new File(bucketDir, LOCAL_ZIP_NAME);
        if (file.isFile() && new File(installedDir, LOCAL_ZIP_NAME).isFile()) {
            try {
                objA = Boolean.valueOf(file.delete());
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.w(LogModule.OTA, TAG, "drop staged display zip failed: ".concat(bucketDir), thB);
            }
        }
    }

    public final String ensure(Context context, String modelId, String str, String modelDir, int i10, String str2) {
        String str3;
        Object objA;
        ModelDisplayResourceStore modelDisplayResourceStore;
        File fileFindDisplayRoot;
        Object objA2;
        String strValidSurviveRoot;
        g.f(context, "context");
        g.f(modelId, "modelId");
        g.f(modelDir, "modelDir");
        Object obj = null;
        if (q.t0(modelId) || q.t0(modelDir)) {
            return null;
        }
        synchronized (lockOf(modelId)) {
            try {
                File file = new File(modelDir, DISPLAY_SUBDIR);
                File file2 = new File(file, MARKER_FILE);
                ModelDisplayResourceStore modelDisplayResourceStore2 = INSTANCE;
                if (str2 == null) {
                    str3 = modelDir;
                } else {
                    str3 = !q.t0(str2) ? str2 : null;
                    if (str3 == null) {
                        str3 = modelDir;
                    }
                }
                File fileFindLocalZip = modelDisplayResourceStore2.findLocalZip(str3);
                Source local = (str == null || q.t0(str)) ? fileFindLocalZip != null ? new Source.Local(fileFindLocalZip) : null : new Source.Remote(str, i10);
                if ((local instanceof Source.Local) && modelDisplayResourceStore2.rankOfKey(modelDisplayResourceStore2.mirrorKeyOf(context, modelId)) == 10 && (strValidSurviveRoot = modelDisplayResourceStore2.validSurviveRoot(context, modelId)) != null) {
                    AIEngineLogger.i(LogModule.OTA, TAG, "keep remote survive-cache, skip local downgrade: modelId=".concat(modelId));
                    return strValidSurviveRoot;
                }
                if (local == null) {
                    File fileFindValidDisplayRoot = modelDisplayResourceStore2.findValidDisplayRoot(file);
                    if (fileFindValidDisplayRoot == null) {
                        return modelDisplayResourceStore2.validSurviveRoot(context, modelId);
                    }
                    modelDisplayResourceStore2.ensureMirror(context, fileFindValidDisplayRoot, modelId, null);
                    return fileFindValidDisplayRoot.getAbsolutePath();
                }
                String strKey = local.key();
                if (file2.isFile()) {
                    try {
                        objA = Boolean.valueOf(wb.d.Z(file2, gc.a.f9106b).equals(strKey));
                    } catch (Throwable th) {
                        objA = kotlin.c.a(th);
                    }
                    Object obj2 = Boolean.FALSE;
                    if (objA instanceof Result.Failure) {
                        objA = obj2;
                    }
                    if (((Boolean) objA).booleanValue() && (fileFindDisplayRoot = (modelDisplayResourceStore = INSTANCE).findDisplayRoot(file)) != null) {
                        modelDisplayResourceStore.ensureMirror(context, fileFindDisplayRoot, modelId, strKey);
                        return fileFindDisplayRoot.getAbsolutePath();
                    }
                }
                ModelDisplayResourceStore modelDisplayResourceStore3 = INSTANCE;
                if (modelDisplayResourceStore3.inFailBackoff(file, strKey)) {
                    AIEngineLogger.d(LogModule.OTA, TAG, "skip ensure in fail-backoff: modelId=" + modelId + " key=" + strKey);
                    return modelDisplayResourceStore3.validSurviveRoot(context, modelId);
                }
                try {
                    objA2 = modelDisplayResourceStore3.materialize(context, local, file, file2, strKey, modelId);
                } catch (Throwable th2) {
                    objA2 = kotlin.c.a(th2);
                }
                Throwable thB = Result.b(objA2);
                if (thB != null) {
                    AIEngineLogger.e(LogModule.OTA, TAG, "ensure failed: modelId=" + modelId + " key=" + strKey, thB);
                }
                if (!(objA2 instanceof Result.Failure)) {
                    obj = objA2;
                }
                String strValidSurviveRoot2 = (String) obj;
                if (strValidSurviveRoot2 == null) {
                    strValidSurviveRoot2 = INSTANCE.validSurviveRoot(context, modelId);
                }
                return strValidSurviveRoot2;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ensureAsync(android.content.Context r10, java.lang.String r11, final java.lang.String r12, final java.lang.String r13, final int r14, final java.lang.String r15) {
        /*
            r9 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.g.f(r10, r0)
            java.lang.String r0 = "modelId"
            kotlin.jvm.internal.g.f(r11, r0)
            java.lang.String r0 = "modelDir"
            kotlin.jvm.internal.g.f(r13, r0)
            boolean r0 = gc.q.t0(r11)
            if (r0 != 0) goto L56
            boolean r0 = gc.q.t0(r13)
            if (r0 == 0) goto L1c
            goto L56
        L1c:
            android.content.Context r3 = r10.getApplicationContext()
            java.util.concurrent.ExecutorService r10 = r9.getWarmExecutor()     // Catch: java.lang.Throwable -> L38
            com.stepos.core.ota.display.a r1 = new com.stepos.core.ota.display.a     // Catch: java.lang.Throwable -> L38
            r2 = r9
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r1.<init>()     // Catch: java.lang.Throwable -> L35
            r10.execute(r1)     // Catch: java.lang.Throwable -> L35
            lb.n r9 = lb.n.f10413a     // Catch: java.lang.Throwable -> L35
            goto L3f
        L35:
            r0 = move-exception
        L36:
            r9 = r0
            goto L3b
        L38:
            r0 = move-exception
            r4 = r11
            goto L36
        L3b:
            kotlin.Result$Failure r9 = kotlin.c.a(r9)
        L3f:
            java.lang.Throwable r9 = kotlin.Result.b(r9)
            if (r9 == 0) goto L56
            com.stepos.core.common.log.LogModule r10 = com.stepos.core.common.log.LogModule.OTA
            java.lang.String r11 = "warm ensure submit failed: modelId="
            java.lang.String r11 = r11.concat(r4)
            java.lang.Object[] r9 = new java.lang.Object[]{r11, r9}
            java.lang.String r11 = "ModelDisplayResStore"
            com.stepos.core.common.log.AIEngineLogger.w(r10, r11, r9)
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.display.ModelDisplayResourceStore.ensureAsync(android.content.Context, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String):void");
    }

    public final String existingDisplayDir(Context context, String modelId, String modelDir, String str) {
        File file;
        File fileFindValidDisplayRoot;
        g.f(context, "context");
        g.f(modelId, "modelId");
        g.f(modelDir, "modelDir");
        if (!q.t0(modelDir) && (fileFindValidDisplayRoot = findValidDisplayRoot((file = new File(modelDir, DISPLAY_SUBDIR)))) != null && keyMatches(new File(file, MARKER_FILE), str)) {
            return fileFindValidDisplayRoot.getAbsolutePath();
        }
        File fileSurviveCacheDir = surviveCacheDir(context, modelId);
        File fileFindValidDisplayRoot2 = findValidDisplayRoot(fileSurviveCacheDir);
        if (fileFindValidDisplayRoot2 == null || !keyMatches(new File(fileSurviveCacheDir, MIRROR_MARKER_FILE), str)) {
            return null;
        }
        return fileFindValidDisplayRoot2.getAbsolutePath();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006e A[Catch: all -> 0x005d, PHI: r2
      0x006e: PHI (r2v3 java.util.zip.ZipEntry) = (r2v2 java.util.zip.ZipEntry), (r2v11 java.util.zip.ZipEntry) binds: [B:8:0x0024, B:19:0x0064] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #4 {all -> 0x005d, blocks: (B:7:0x0020, B:9:0x0026, B:10:0x003e, B:12:0x0044, B:18:0x0061, B:24:0x006e, B:26:0x0079, B:29:0x00a3, B:31:0x00a9, B:36:0x00ba, B:40:0x00d6, B:42:0x00e2, B:55:0x00f9, B:56:0x00fc, B:53:0x00f7, B:37:0x00c8, B:39:0x00d3, B:51:0x00f3, B:52:0x00f6), top: B:77:0x0020, outer: #3, inners: #2, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean extractBundledDisplayZip$ota_release(java.io.File r9, java.io.File r10) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.display.ModelDisplayResourceStore.extractBundledDisplayZip$ota_release(java.io.File, java.io.File):boolean");
    }

    public final void purgeForeign(Context context, String modelId, String modelDir, String str) {
        g.f(context, "context");
        g.f(modelId, "modelId");
        g.f(modelDir, "modelDir");
        if (q.t0(modelId)) {
            return;
        }
        synchronized (lockOf(modelId)) {
            try {
                if (!q.t0(modelDir)) {
                    File file = new File(modelDir, DISPLAY_SUBDIR);
                    if (file.isDirectory() && INSTANCE.isForeign(new File(file, MARKER_FILE), str)) {
                        AIEngineLogger.i(LogModule.OTA, TAG, "purge foreign display data: modelId=" + modelId + " expected=" + str);
                        wb.d.T(file);
                    }
                }
                ModelDisplayResourceStore modelDisplayResourceStore = INSTANCE;
                File fileSurviveCacheDir = modelDisplayResourceStore.surviveCacheDir(context, modelId);
                if (fileSurviveCacheDir.isDirectory() && modelDisplayResourceStore.isForeign(new File(fileSurviveCacheDir, MIRROR_MARKER_FILE), str)) {
                    wb.d.T(fileSurviveCacheDir);
                }
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String remoteDisplayKey(String str, int i10) {
        if (str == null || q.t0(str)) {
            return null;
        }
        return i10 > 0 ? ai.onnxruntime.providers.a.a(i10, "remote:v") : ai.onnxruntime.a.k("remote:", str);
    }

    public final void removeOnDisplayReadyListener(OnDisplayReadyListener listener) {
        g.f(listener, "listener");
        readyListeners.remove(listener);
    }

    public final String stagePresetDisplay(Context context, String modelId, File bundleZip, String modelDir) {
        boolean zExtractBundledDisplayZip$ota_release;
        g.f(context, "context");
        g.f(modelId, "modelId");
        g.f(bundleZip, "bundleZip");
        g.f(modelDir, "modelDir");
        if (q.t0(modelId) || q.t0(modelDir)) {
            return null;
        }
        synchronized (lockOf(modelId)) {
            zExtractBundledDisplayZip$ota_release = INSTANCE.extractBundledDisplayZip$ota_release(bundleZip, new File(modelDir));
        }
        if (zExtractBundledDisplayZip$ota_release) {
            return ensure$default(this, context, modelId, null, modelDir, 0, null, 48, null);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void stagePresetDisplayAsync(android.content.Context r8, java.lang.String r9, java.io.File r10, java.lang.String r11) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.g.f(r8, r0)
            java.lang.String r0 = "modelId"
            kotlin.jvm.internal.g.f(r9, r0)
            java.lang.String r0 = "bundleZip"
            kotlin.jvm.internal.g.f(r10, r0)
            java.lang.String r0 = "modelDir"
            kotlin.jvm.internal.g.f(r11, r0)
            boolean r0 = gc.q.t0(r9)
            if (r0 != 0) goto L59
            boolean r0 = gc.q.t0(r11)
            if (r0 == 0) goto L21
            goto L59
        L21:
            android.content.Context r3 = r8.getApplicationContext()
            java.util.concurrent.ExecutorService r8 = r7.getWarmExecutor()     // Catch: java.lang.Throwable -> L3b
            com.stepos.core.ota.display.b r1 = new com.stepos.core.ota.display.b     // Catch: java.lang.Throwable -> L3b
            r2 = r7
            r4 = r9
            r5 = r10
            r6 = r11
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L38
            r8.execute(r1)     // Catch: java.lang.Throwable -> L38
            lb.n r7 = lb.n.f10413a     // Catch: java.lang.Throwable -> L38
            goto L42
        L38:
            r0 = move-exception
        L39:
            r7 = r0
            goto L3e
        L3b:
            r0 = move-exception
            r4 = r9
            goto L39
        L3e:
            kotlin.Result$Failure r7 = kotlin.c.a(r7)
        L42:
            java.lang.Throwable r7 = kotlin.Result.b(r7)
            if (r7 == 0) goto L59
            com.stepos.core.common.log.LogModule r8 = com.stepos.core.common.log.LogModule.OTA
            java.lang.String r9 = "stage preset display submit failed: modelId="
            java.lang.String r9 = r9.concat(r4)
            java.lang.Object[] r7 = new java.lang.Object[]{r9, r7}
            java.lang.String r9 = "ModelDisplayResStore"
            com.stepos.core.common.log.AIEngineLogger.w(r8, r9, r7)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.display.ModelDisplayResourceStore.stagePresetDisplayAsync(android.content.Context, java.lang.String, java.io.File, java.lang.String):void");
    }
}
