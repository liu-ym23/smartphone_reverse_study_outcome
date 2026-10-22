package b68;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.sva.sdk.controller.Global;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import m58.h;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f17861a = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((File) r100).lastModified()), Long.valueOf(((File) r101).lastModified()));
        }
    }

    static {
        f17861a = new b();
    }

    public b() {
    }

    public final synchronized boolean a(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "filePath");     // Catch: Throwable -> L22
        boolean r101 = false;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L11 Exception -> L13
        if (r102.exists() == false) goto L8;
        r101 = r102.delete();     // Catch: Throwable -> L11 Exception -> L13
    L8:
        int r103 = c68.b.f22600a;     // Catch: Throwable -> L22
        String r104 = "FileStreamHelper";
    L17:
        c68.b.a(r104, "#deleteFile finish");     // Catch: Throwable -> L22
        monitor-exit(this);
        return r101;
    L13:
        e = move-exception;
        e(this, e, null, 2);     // Catch: Throwable -> L11
        int r105 = c68.b.f22600a;     // Catch: Throwable -> L22
        r104 = "FileStreamHelper";
        goto L17
    L11:
        th = move-exception;
        c68.b.a("FileStreamHelper", "#deleteFile finish");     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public static void b(File r100, long r101) {
        File[] r102 = r100.listFiles();
        if (r102 == null) goto L16;
        List r103 = ArraysKt.sortedWith(r102, new a());
        if (r103 == null) goto L25;
        Iterator r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L26;
        File r105 = (File) r104.next();
        if (r105.isFile() == false) goto L9;
        if (r105.delete() == false) goto L9;
        r101 = r101 - r105.length();
        if (r101 > 0) goto L9;
        return;
    L26:
        return;
    L25:
        return;
    }

    public static String c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "basePath");
        Intrinsics.checkNotNullParameter(r101, "fileNameWithPCM");
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return null;
    L6:
        if (StringsKt.endsWith$default(r101, Global.SUFFIX_PCM_FILE, false, 2, null) == true) goto L9;
        r101 = r101 + Global.SUFFIX_PCM_FILE;
    L9:
        StringBuilder r102 = new StringBuilder();
        m58.b r103 = h.f512140k;
        if (r103 == null) goto L14;
        Application r104 = r103.getApplication();
        if (r104 == null) goto L14;
        File r105 = r104.getFilesDir();
    L15:
        r102.append(r105);
        r102.append(r100);
        String r106 = r102.toString();
        PolarisFileWrapper r107 = new PolarisFileWrapper(r106);
        if (r107.exists() == true) goto L22;
        if (r107.mkdirs() == true) goto L22;
        c68.b.b("FileStreamHelper", "Directory creation failed");
        return null;
    L22:
        return r106 + r101;
    L14:
        r105 = null;
        goto L15
    }

    public static void d(Exception r100, String r101) {
        int r102 = c68.b.f22600a;
        StringBuilder r103 = new StringBuilder("File error: ");
        if (r100 == null) goto L6;
        String r104 = r100.getMessage();
        if (r104 == null) goto L6;
    L7:
        r103.append(r104);
        r103.append(" | ");
        r103.append(r101);
        c68.b.b("FileStreamHelper", r103.toString());
        return;
    L6:
        r104 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
        goto L7
    }

    public final boolean f(String r100, long r110) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.isDirectory() == true) goto L6;
        e(this, null, "Provided path is not a directory", 1);
        return false;
    L6:
        Iterator r102 = SequencesKt.filter(FilesKt.walkTopDown(r101), new b68.a()).iterator();
        long r103 = 0;
    L8:
        if (r102.hasNext() == false) goto L10;
        r103 = r103 + ((File) r102.next()).length();
        goto L8
    L10:
        int r104 = c68.b.f22600a;
        c68.b.b("FileStreamHelper", "#isFolderSizeExceedLimit folderPath：" + r100 + ",totalSize:" + r103 + ",maxSizeInBytes:" + r110);
        if (r103 <= r110) goto L15;
        return true;
    L15:
        return false;
    }

    public final void g(PolarisFileWrapper r100, long r101) {
        long r102 = r100.length() - r101;
        if (r102 > 0) goto L5;
        return;
    L5:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100.getParent(), "temp_" + r100.getName());
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r100);
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L20
        r104.skip(r102);     // Catch: Throwable -> L15
        ByteStreamsKt.copyTo(r104, r105, (int) r101);     // Catch: Throwable -> L15
    L9:
        CloseableKt.closeFinally(r105, null);     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r104, null);
        if (r100.delete() == false) goto L13;
        r103.renameTo(r100);
        return;
    L13:
        e(this, null, "Failed to delete the original file for truncation", 1);
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);
        throw th;
    }

    public static String h(b r100, String r101, ByteArrayOutputStream r102) {
        monitor-enter(r100);
        Intrinsics.checkNotNullParameter(r101, "filePath");     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r102, "data");     // Catch: Throwable -> L28
        if (r102.size() > 0) goto L8;
        e(r100, null, "Data is empty, write to file failed", 1);     // Catch: Throwable -> L28
        monitor-exit(r100);
        return "FAILED";
    L8:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L28
        File r104 = r103.getParentFile();     // Catch: Throwable -> L28
        if (r104 != null) goto L14;
        monitor-exit(r100);
        return "FAILED";
    L14:
        if (r100.f(r104.getPath(), 10737418240L) == false) goto L31;
        b(r104, r102.size());     // Catch: Throwable -> L28
    L31:
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r101);     // Catch: IOException -> L20 Throwable -> L28
        r102.writeTo(r105);     // Catch: IOException -> L20 Throwable -> L28
        r105.close();     // Catch: IOException -> L20 Throwable -> L28
        if (r103.length() <= 10737418240L) goto L22;
        r100.g(r103, 10737418240L);     // Catch: IOException -> L20 Throwable -> L28
    L22:
        c68.b.a("FileStreamHelper", "#writeByteArrayToFile finish");     // Catch: Throwable -> L28
        monitor-exit(r100);
        return "SUCCESS";
    L20:
        e = move-exception;
        d(e, "Write to file failed");     // Catch: Throwable -> L28
        return "FAILED";
    L28:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void e(b r100, Exception r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = null;
    L8:
        r100.getClass();
        d(r101, r102);
    }
}
