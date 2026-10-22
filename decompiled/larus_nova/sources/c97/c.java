package c97;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PolarisFileOutputStreamWrapper f22861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileLock f22862b;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        FileLock r100 = this.f22862b;     // Catch: Throwable -> L9
        if (r100 == null) goto L5;
        r100.release();     // Catch: Throwable -> L9
    L5:
        PolarisFileOutputStreamWrapper r101 = this.f22861a;
        if (r101 == null) goto L16;
        r101.close();
        return;
    L16:
        return;
    L9:
        th = move-exception;
        PolarisFileOutputStreamWrapper r102 = this.f22861a;
        if (r102 == null) goto L13;
        r102.close();
    L13:
        throw th;
    }

    public c(File r100) throws IOException {
        w87.b.c(r100);
        this.f22861a = new PolarisFileOutputStreamWrapper(r100);
        FileLock r101 = null;
        Exception e100 = null;
        int r102 = 0;
    L4:
        if (r102 >= 3) goto L19;
        r102 = r102 + 1;
        r101 = this.f22861a.getChannel().lock();     // Catch: Exception -> L12
        if (r101 == null) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L19;
    L26:
        Thread.sleep(10);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        com.bytedance.reparo.core.k.b("FileLockHelper", "getInfoLock Thread sleep exception", e);
        goto L4
    L9:
        r103 = false;
    L12:
        e100 = e;
        com.bytedance.reparo.core.k.a("FileLockHelper", "getInfoLock Thread failed time:10");
    L19:
        if (r101 == null) goto L23;
        this.f22862b = r101;
        return;
    L23:
        throw new IOException("FileLockHelper lock file failed: " + r100.getAbsolutePath(), e100);
    }
}
