package com.bumptech.glide.monitor;

import com.bumptech.glide.IGlideDependency;
import com.bumptech.glide.util.GlideCommonUtils;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.framework.utils.x;
import com.ss.android.lark.log.Log;
import ebb.e;
import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u000e\u0010\u0013\u001a\u00020\u0014*\u0004\u0018\u00010\u0010H\u0002J\u001a\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0016\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bumptech/glide/monitor/GlideDiskCacheMonitor;", "", "<init>", "()V", "TAG", "", "EVENT_KEY_DISK_CACHE_DEV", "FILE_SIZE_UNITY", "", "INTERVAL_DAY_ONE", "", "dependency", "Lcom/bumptech/glide/IGlideDependency;", WidgetCostModule.TYPE_ON_START, "", "cacheDirectory", "Ljava/io/File;", "avatarDirectory", "report", "isValidDirectory", "", "countFilesOptimized", DocumentType.FOLDER_NAME, "isRecursive", "safeBlockIgnoreException", "codeBlock", "Lkotlin/Function0;", "DiskCacheInfo", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlideDiskCacheMonitor {
    private static final String EVENT_KEY_DISK_CACHE_DEV = "image_load_sdk_disk_cache_dev";
    private static final float FILE_SIZE_UNITY = 1024.0f;
    public static final GlideDiskCacheMonitor INSTANCE = null;
    private static final int INTERVAL_DAY_ONE = 86400000;
    private static final String TAG = "GlideDiskCacheMonitor";
    private static final IGlideDependency dependency = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014¨\u0006#"}, d2 = {"Lcom/bumptech/glide/monitor/GlideDiskCacheMonitor$DiskCacheInfo;", "", "time", "", "size", "", "count", "", "sizeDiff", "countDiff", "leftSpace", "<init>", "(JFIFIF)V", "getTime", "()J", "setTime", "(J)V", "getSize", "()F", "setSize", "(F)V", "getCount", "()I", "setCount", "(I)V", "getSizeDiff", "setSizeDiff", "getCountDiff", "setCountDiff", "getLeftSpace", "setLeftSpace", "toJson", "Lorg/json/JSONObject;", "report", "", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiskCacheInfo {
        private int count;
        private int countDiff;
        private float leftSpace;
        private float size;
        private float sizeDiff;
        private long time;

        public DiskCacheInfo() {
            this(0, 0.0f, 0, 0.0f, 0, 0.0f, 63, null);
        }

        private final JSONObject toJson() {
            JSONObject r100 = new JSONObject();
            r100.put("size", Float.valueOf(this.size)).put("count", this.count).put("size_diff", Float.valueOf(this.sizeDiff)).put("count_diff", this.countDiff).put("left_space", Float.valueOf(this.leftSpace));     // Catch: Exception -> L5
        L6:
            return r100;
        L5:
            Log.e(GlideDiskCacheMonitor.TAG, "to json failed");
            goto L6
        }

        public final void report() {
            IGlideDependency r100 = GlideDiskCacheMonitor.access$getDependency$p();
            if (r100 == null) goto L6;
            r100.report(GlideDiskCacheMonitor.EVENT_KEY_DISK_CACHE_DEV, toJson());
            return;
        }

        public final int getCount() {
            return this.count;
        }

        public final int getCountDiff() {
            return this.countDiff;
        }

        public final float getLeftSpace() {
            return this.leftSpace;
        }

        public final float getSize() {
            return this.size;
        }

        public final float getSizeDiff() {
            return this.sizeDiff;
        }

        public final long getTime() {
            return this.time;
        }

        public final void setCount(int r100) {
            this.count = r100;
        }

        public final void setCountDiff(int r100) {
            this.countDiff = r100;
        }

        public final void setLeftSpace(float r100) {
            this.leftSpace = r100;
        }

        public final void setSize(float r100) {
            this.size = r100;
        }

        public final void setSizeDiff(float r100) {
            this.sizeDiff = r100;
        }

        public final void setTime(long r100) {
            this.time = r100;
        }

        public DiskCacheInfo(long r100, float r101, int r102, float r103, int r104, float r105) {
            this.time = r100;
            this.size = r101;
            this.count = r102;
            this.sizeDiff = r103;
            this.countDiff = r104;
            this.leftSpace = r105;
        }

        public /* synthetic */ DiskCacheInfo(long r100, float r110, int r111, float r112, int r113, float r114, int r115, DefaultConstructorMarker r116) {
            if ((r115 & 1) == 0) goto L5;
            long r101 = 0;
        L6:
            float r102 = 0.0f;
            if ((r115 & 2) == 0) goto L9;
            float r103 = 0.0f;
        L10:
            int r104 = 0;
            if ((r115 & 4) == 0) goto L13;
            int r105 = 0;
        L15:
            if ((r115 & 8) == 0) goto L17;
            float r106 = 0.0f;
        L19:
            if ((r115 & 16) != 0) goto L23;
            r104 = r113;
        L23:
            if ((r115 & 32) != 0) goto L26;
            r102 = r114;
        L26:
            this(r101, r103, r105, r106, r104, r102);
            return;
        L17:
            r106 = r112;
            goto L19
        L13:
            r105 = r111;
            goto L15
        L9:
            r103 = r110;
            goto L10
        L5:
            r101 = r100;
            goto L6
        }
    }

    private GlideDiskCacheMonitor() {
    }

    static {
        INSTANCE = new GlideDiskCacheMonitor();
        dependency = GlideCommonUtils.getDependency();
    }

    public static final /* synthetic */ IGlideDependency access$getDependency$p() {
        return dependency;
    }

    private final boolean isValidDirectory(File r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.exists() == false) goto L8;
        if (r100.isDirectory() == false) goto L8;
        return true;
    }

    private final void safeBlockIgnoreException(Function0<Unit> r100) {
        r100.invoke();     // Catch: Exception -> L4
        return;
    }

    private final int countFilesOptimized(File r100, final boolean r101) {
        if (r100 != null) goto L5;
    L38:
        return 0;
    L5:
        if (isValidDirectory(r100) == false) goto L38;
        final Ref.IntRef r102 = new Ref.IntRef();
        final ArrayDeque r103 = new ArrayDeque();
        r103.add(r100);
        Function1<File, Unit> r104 = new GlideDiskCacheMonitor$countFilesOptimized$scanDirByFileApi$1(r102, r101, r103);
    L9:
        if ((!r103.isEmpty()) == false) goto L37;
        File r105 = (File) r103.removeFirst();
        if (x.c() == true) goto L12;
        r104.invoke(r105);
        goto L9
    L12:
        Path r106 = r105.toPath();
        if (Files.isDirectory(r106, new LinkOption[0]) == false) goto L9;
        if (Files.isSymbolicLink(r106) == true) goto L9;
        if (Files.isReadable(r106) == false) goto L9;
        if (Files.isExecutable(r106) == false) goto L9;
    L44:
        final DirectoryStream<Path> r107 = Files.newDirectoryStream(r106);     // Catch: Exception -> L25
    L26:
        if (r107 == null) goto L34;
        INSTANCE.safeBlockIgnoreException(new GlideDiskCacheMonitor$countFilesOptimized$2$1(r107, r102, r101, r103));     // Catch: Throwable -> L29
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r107, null);
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r107, th);
        throw th;
    L34:
        r104.invoke(r105);
    L25:
        r107 = null;
        goto L26
    L37:
        return r102.element;
    }

    @JvmStatic
    public static final void onStart(final File r100, final File r101) {
        IGlideDependency r102 = dependency;
        if (r102 == null) goto L8;
        if (r100 == null) goto L9;
        if (r101 == null) goto L10;
        r102.runInIOExecutor(new AnonymousClass1(r100, r101));
        return;
    L10:
        return;
    L9:
        return;
    }

    private final void report(File r110, File r111) {
        IGlideDependency r100 = dependency;
        if (r100 == null) goto L5;
        DiskCacheInfo r101 = r100.readDiskCacheInfo();
    L6:
        Object r102 = e.f471981a;
        long r103 = e.f(r110) + e.f(r111);
        int r104 = countFilesOptimized(r110, true) + countFilesOptimized(r111, true);
        DiskCacheInfo r105 = new DiskCacheInfo(0, 0.0f, 0, 0.0f, 0, 0.0f, 63, null);
        r105.setTime(System.currentTimeMillis());
        r105.setSize((r103 / FILE_SIZE_UNITY) / FILE_SIZE_UNITY);
        r105.setCount(r104);
        if (r100 == null) goto L9;
        float r106 = r100.getLeftSpace();
    L10:
        r105.setLeftSpace(r106);
        if (r101 != null) goto L13;
    L17:
        if (r100 == null) goto L19;
        r100.writeDiskCacheInfo(r105);
    L19:
        r105.report();
        return;
    L13:
        if ((r105.getTime() - r101.getTime()) > 86400000) goto L16;
        Log.i(TAG, "re load in one day");
        return;
    L16:
        r105.setSizeDiff(r105.getSize() - r101.getSize());
        r105.setCountDiff(r105.getCount() - r101.getCount());
        goto L17
    L9:
        r106 = 0.0f;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public static final /* synthetic */ void access$report(GlideDiskCacheMonitor r100, File r101, File r102) {
        r100.report(r101, r102);
    }
}
