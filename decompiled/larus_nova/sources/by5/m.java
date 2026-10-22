package by5;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f21456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteBuffer f21457b;

    public final synchronized void a() {
        monitor-enter(this);
        boolean r100 = false;
        int r101 = this.f21457b.getInt(0);     // Catch: Throwable -> L51
        int r102 = this.f21457b.getInt(4);     // Catch: Throwable -> L51
        int r103 = this.f21457b.getInt(8);     // Catch: Throwable -> L51
        int r104 = this.f21457b.getInt(12);     // Catch: Throwable -> L51
        if (r101 != 1095781686) goto L46;
        if (r104 <= 0) goto L46;
        if (r103 <= 0) goto L46;
        if (n.f21462e == false) goto L12;
        fy5.c.a("flushing: magicNumber=" + r101 + " version=" + r102 + " totalCount=" + r103 + " totalBytes=" + r104);     // Catch: Throwable -> L51
    L12:
        long r105 = System.nanoTime();     // Catch: Throwable -> L51
        FileChannel r106 = null;
        String r107 = System.currentTimeMillis() + "_" + UUID.randomUUID().toString();     // Catch: Throwable -> L35
    L22:
        th = move-exception;
        fy5.c.c("flushDir create error.", th);     // Catch: Throwable -> L35
    L24:
        PolarisFileWrapper r110 = new PolarisFileWrapper(this.f21456a, r107 + DefaultDiskStorage.FileType.TEMP);     // Catch: Throwable -> L35
        if (r110.exists() == false) goto L27;
        fy5.c.b("APM-SDK", "file is exist:" + r110.getName());     // Catch: Throwable -> L35
    L27:
        r106 = new PolarisFileOutputStreamWrapper(r110, false).getChannel();     // Catch: Throwable -> L35
        this.f21457b.position(r104 + 16);     // Catch: Throwable -> L35
        this.f21457b.flip();     // Catch: Throwable -> L35
        r106.write(this.f21457b);     // Catch: Throwable -> L35
        PolarisFileWrapper r108 = new PolarisFileWrapper(this.f21456a, r107 + ".log");     // Catch: Throwable -> L35
        if (r110.renameTo(r108) == false) goto L30;
        r100 = true;
    L32:
        if (n.f21462e == false) goto L37;
        fy5.c.a("flush to file success. flushFile=" + r108.getAbsolutePath());     // Catch: Throwable -> L35
    L37:
        xu3.c.a(r106);     // Catch: Throwable -> L51
        if (r100 == true) goto L40;
        b();     // Catch: Throwable -> L51
    L40:
        d();     // Catch: Throwable -> L51
        if (n.f21462e == false) goto L43;
        fy5.c.a("flush cost=" + (System.nanoTime() - r105));     // Catch: Throwable -> L51
    L43:
        monitor-exit(this);
        return;
    L30:
        fy5.c.b("APM-SDK", "rename error" + r110.getAbsolutePath());     // Catch: Throwable -> L35
        goto L32
    L16:
        if (this.f21456a.exists() == true) goto L24;
        File r111 = this.f21456a.getParentFile();     // Catch: Throwable -> L22
        if (r111.exists() == true) goto L20;
        r111.mkdirs();     // Catch: Throwable -> L22
    L20:
        this.f21456a.mkdirs();     // Catch: Throwable -> L22
    L35:
        th = move-exception;
        fy5.c.c(this.f21456a.exists() + " flush to file failed.", th);     // Catch: Throwable -> L54
    L46:
        if (n.f21462e == false) goto L48;
        fy5.c.a("flushing: Skipped. no data to flush. reset buffer now.");     // Catch: Throwable -> L51
    L48:
        d();     // Catch: Throwable -> L51
        monitor-exit(this);
        return;
    L51:
        th = move-exception;
        throw th;
    }

    public final void b() {
        this.f21457b.position(this.f21457b.getInt(12) + 16);
        this.f21457b.flip();
        b r100 = b.a(this.f21457b);
        if (n.f21462e == false) goto L5;
        fy5.c.a("flush to memory success. logFile=" + r100);
    L5:
        e r101 = e.a.f21426a;
        if (r100 != null) goto L8;
        r101.getClass();
        return;
    L8:
        r101.f21422b.c(r100);
    }

    public final void d() {
        this.f21457b.clear();
        this.f21457b.putInt(1095781686);
        this.f21457b.putInt(1);
        this.f21457b.putInt(0);
        this.f21457b.putInt(0);
    }

    public m(File r100, File r101) {
        this.f21456a = r101;
        this.f21457b = new RandomAccessFile(r100, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 262160);     // Catch: Throwable -> L5
        a();     // Catch: Throwable -> L5
    L8:
        if (this.f21457b != null) goto L10;
        this.f21457b = ByteBuffer.allocate(262160);
    L10:
        d();
        return;
    L5:
        th = move-exception;
        fy5.c.c("create MappedByteBuffer failed. will fallback into HeapByteBuffer", th);
        goto L8
    }

    public final synchronized void c(long r100, long r101, JSONObject r102) {
        monitor-enter(this);
        if (r102 != null) goto L33;
        monitor-exit(this);
        return;
    L33:
        String r103 = r102.toString();     // Catch: Throwable -> L30
        byte[] r104 = r103.getBytes();     // Catch: Throwable -> L30
        int r105 = (r104.length + 4) + 16;     // Catch: Throwable -> L30
        if (r105 <= 262144) goto L18;
        av3.a r106 = fy5.c.f479288a;     // Catch: Throwable -> L30
        if (r106 == null) goto L12;
        r106.a();     // Catch: Throwable -> L30
    L12:
        if (n.f21462e == true) goto L16;
        monitor-exit(this);
        return;
    L16:
        throw new RuntimeException("LogItem is too large. please check it.");     // Catch: Throwable -> L30
    L18:
        if (r105 <= this.f21457b.remaining()) goto L20;
        a();     // Catch: Throwable -> L30
    L20:
        this.f21457b.putInt(r104.length);     // Catch: Throwable -> L30
        this.f21457b.putLong(r100);     // Catch: Throwable -> L30
        this.f21457b.putLong(r101);     // Catch: Throwable -> L30
        this.f21457b.put(r104);     // Catch: Throwable -> L30
        this.f21457b.putInt(8, this.f21457b.getInt(8) + 1);     // Catch: Throwable -> L30
        this.f21457b.putInt(12, this.f21457b.getInt(12) + r105);     // Catch: Throwable -> L30
        if (n.f21462e == false) goto L24;
        fy5.c.a(String.format("push success: totalCount=%s, totalBytes=%s, logItem=%s,", new Object[]{Integer.valueOf(this.f21457b.getInt(8)), Integer.valueOf(this.f21457b.getInt(12)), r103}));     // Catch: Throwable -> L30
    L24:
        if (this.f21457b.position() < 131072) goto L26;
    L27:
        a();     // Catch: Throwable -> L30
    L28:
        monitor-exit(this);
        return;
    L26:
        if (this.f21457b.getInt(8) < 100) goto L28;
    L30:
        th = move-exception;
        throw th;
    }
}
