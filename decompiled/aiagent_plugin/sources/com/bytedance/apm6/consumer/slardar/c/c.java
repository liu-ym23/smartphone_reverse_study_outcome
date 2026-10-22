package com.bytedance.apm6.consumer.slardar.c;

import com.bytedance.apm6.util.d;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: PersistentBuffer.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f5097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f5098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ByteBuffer f5099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FileLock f5100d;

    public c(long r7, File r9, File r10) {
        this.f5097a = r10;
        this.f5098b = r7;
        FileChannel r0 = new RandomAccessFile(r9, "rw").getChannel();     // Catch: Throwable -> L5
        this.f5100d = r0.tryLock();     // Catch: Throwable -> L5
        this.f5099c = r0.map(FileChannel.MapMode.READ_WRITE, 0, 262162);     // Catch: Throwable -> L5
        a();     // Catch: Throwable -> L5
    L8:
        if (this.f5099c != null) goto L10;
        this.f5099c = ByteBuffer.allocate(262162);
    L10:
        c();
        return;
    L5:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b(com.bytedance.apm6.consumer.slardar.a.f5054a, "create MappedByteBuffer failed. will fallback into HeapByteBuffer", th);
        goto L8
    }

    private void c() {
        this.f5099c.clear();
        this.f5099c.putShort(2082);
        this.f5099c.putLong(this.f5098b);
        this.f5099c.putInt(0);
        this.f5099c.putInt(0);
    }

    private short d() {
        return this.f5099c.getShort(0);
    }

    private long e() {
        return this.f5099c.getLong(2);
    }

    private int f() {
        return this.f5099c.getInt(10);
    }

    private void a(int r2) {
        this.f5099c.putInt(10, r2);
    }

    private int g() {
        return this.f5099c.getInt(14);
    }

    private void b(int r2) {
        this.f5099c.putInt(14, r2);
    }

    public synchronized void a(JSONObject r6) {
        monitor-enter(this);
        if (r6 != null) goto L30;
        monitor-exit(this);
        return;
    L30:
        String r0 = r6.toString();     // Catch: Throwable -> L27
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L9;
        com.bytedance.apm.doctor.a.a(r6);     // Catch: Throwable -> L27
    L9:
        byte[] r1 = r0.getBytes();     // Catch: Throwable -> L27
        int r2 = r1.length + 4;     // Catch: Throwable -> L27
        if (r2 <= 262144) goto L15;
        com.bytedance.apm6.monitor.a.a(b(r6));     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L15:
        if (r2 <= this.f5099c.remaining()) goto L17;
        a();     // Catch: Throwable -> L27
    L17:
        this.f5099c.putInt(r1.length);     // Catch: Throwable -> L27
        this.f5099c.put(r1);     // Catch: Throwable -> L27
        a(f() + 1);     // Catch: Throwable -> L27
        b(g() + r2);     // Catch: Throwable -> L27
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L21;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, String.format("push success: totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(f()), Integer.valueOf(g()), r0}));     // Catch: Throwable -> L27
    L21:
        if (this.f5099c.position() < 262134) goto L23;
    L24:
        a();     // Catch: Throwable -> L27
    L25:
        monitor-exit(this);
        return;
    L23:
        if (f() < 256) goto L25;
    L27:
        th = move-exception;
        throw th;
    }

    public synchronized void a() {
        monitor-enter(this);
        short r0 = d();     // Catch: Throwable -> L51
        long r1 = e();     // Catch: Throwable -> L51
        int r3 = f();     // Catch: Throwable -> L51
        int r4 = g();     // Catch: Throwable -> L51
        if (r0 != 2082) goto L46;
        if (r4 <= 0) goto L46;
        if (r3 <= 0) goto L46;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L11;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "flushing: headerId=" + r1 + " totalCount=" + r3 + " totalBytes=" + r4);     // Catch: Throwable -> L51
    L11:
        long r2 = System.nanoTime();     // Catch: Throwable -> L51
        FileChannel r5 = null;
        boolean r6 = false;
        String r7 = System.currentTimeMillis() + "_" + UUID.randomUUID().toString();     // Catch: Throwable -> L35
    L21:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b(com.bytedance.apm6.consumer.slardar.a.f5054a, "flushDir create error.", th);     // Catch: Throwable -> L35
    L23:
        File r8 = new File(this.f5097a, r7 + ".txt");     // Catch: Throwable -> L35
        if (r8.exists() == false) goto L26;
        com.bytedance.apm6.util.c.b.d(com.bytedance.apm6.consumer.slardar.a.f5054a, "file is exist:" + r8.getName());     // Catch: Throwable -> L35
    L26:
        r5 = new FileOutputStream(r8, false).getChannel();     // Catch: Throwable -> L35
        this.f5099c.position(r4 + 18);     // Catch: Throwable -> L35
        this.f5099c.flip();     // Catch: Throwable -> L35
        r5.write(this.f5099c);     // Catch: Throwable -> L35
        if (r8.renameTo(new File(this.f5097a, r7 + ".log")) == false) goto L29;
        r6 = true;
    L31:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L33;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "flush to file success. flushFile=" + r8.getAbsolutePath());     // Catch: Throwable -> L35
    L33:
        d.a(r5);     // Catch: Throwable -> L51
        if (r6 == true) goto L40;
        h();     // Catch: Throwable -> L51
    L40:
        c();     // Catch: Throwable -> L51
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L43;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "flush cost=" + (System.nanoTime() - r2));     // Catch: Throwable -> L51
    L43:
        monitor-exit(this);
        return;
    L29:
        com.bytedance.apm6.util.c.b.d(com.bytedance.apm6.consumer.slardar.a.f5054a, "rename error" + r8.getAbsolutePath());     // Catch: Throwable -> L35
        goto L31
    L15:
        if (this.f5097a.exists() == true) goto L23;
        File r9 = this.f5097a.getParentFile();     // Catch: Throwable -> L21
        if (r9.exists() == true) goto L19;
        r9.mkdirs();     // Catch: Throwable -> L21
    L19:
        this.f5097a.mkdirs();     // Catch: Throwable -> L21
    L35:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b(com.bytedance.apm6.consumer.slardar.a.f5054a, this.f5097a.exists() + " flush to file failed.", th);     // Catch: Throwable -> L54
    L46:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L48;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "flushing: Skipped. no data to flush. reset buffer now.");     // Catch: Throwable -> L51
    L48:
        c();     // Catch: Throwable -> L51
        monitor-exit(this);
        return;
    L51:
        th = move-exception;
        throw th;
    }

    private void h() {
        this.f5099c.position(g() + 18);
        this.f5099c.flip();
        a r3 = a.a(this.f5099c);
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L5;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "flush to memory success. logFile=" + r3);
    L5:
        com.bytedance.apm6.consumer.slardar.c.a().a(r3);
    }

    public synchronized String[] b() {
        monitor-enter(this);
        File[] r0 = com.bytedance.apm6.consumer.slardar.b.e().listFiles(new AnonymousClass1(this));     // Catch: Throwable -> L14
        if (r0 == null) goto L6;
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L14
        int r2 = r0.length;     // Catch: Throwable -> L14
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L11;
        r1.add(r0[r3].getName());     // Catch: Throwable -> L14
        r3 = r3 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        String[] r4 = (String[]) ZeusTransformUtils.preCheckCast(r1.toArray(new String[r1.size()]), String[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        monitor-exit(this);
        return r4;
    L6:
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    private com.bytedance.apm6.monitor.b b(JSONObject r3) {
        final JSONObject r0 = null;
        if (r3 == null) goto L5;
        final JSONObject r1 = r3.optJSONObject(WsConstants.KEY_SERVICE);
    L6:
        if (r3 == null) goto L9;
        r0 = r3.optJSONObject("log_type");
    L9:
        return new AnonymousClass2(this, r1, r0);
    L5:
        r1 = null;
        goto L6
    }
}
