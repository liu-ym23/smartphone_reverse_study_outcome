package com.bytedance.crash.upload;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: HttpOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OutputStream f7798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f7799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f7800c;

    /* JADX INFO: compiled from: HttpOutputStream.java */
    static class a extends FilterOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f7801a;

        public a(OutputStream r3) {
            super(r3);
            this.f7801a = 0;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int r5) {
            this.f7801a++;
            this.out.write(r5);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] r5, int r6, int r7) {
            this.f7801a += (long) r7;
            this.out.write(r5, r6, r7);
        }

        long a() {
            return this.f7801a;
        }
    }

    /* JADX INFO: compiled from: HttpOutputStream.java */
    static class b extends DataOutputStream {
        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public b(OutputStream r1) {
            super(r1);
        }

        public void a() {
            super.close();
        }
    }

    /* JADX INFO: compiled from: HttpOutputStream.java */
    static class c extends GZIPOutputStream {
        @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.util.zip.GZIPOutputStream, java.util.zip.DeflaterOutputStream
        public void finish() {
        }

        public c(OutputStream r1) {
            super(r1);
        }

        public void a() {
            super.close();
        }

        public void b() {
            super.finish();
        }
    }

    d(OutputStream r2, boolean r3) {
        a r0 = new a(r2);
        this.f7799b = r0;
        if (r3 == false) goto L5;
        this.f7798a = new c(r0);
    L6:
        this.f7800c = r3;
        return;
    L5:
        this.f7798a = new b(r0);
        goto L6
    }

    public void a(byte[] r1) {
        this.f7798a.write(r1);
    }

    public void a(String r1) {
        this.f7798a.write(r1.getBytes());
    }

    public void a(byte[] r1, int r2, int r3) {
        this.f7798a.write(r1, r2, r3);
    }

    public void a() {
        if (this.f7800c == false) goto L5;
        c r2 = (c) ZeusTransformUtils.preCheckCast(this.f7798a, c.class, "com.obric.aiagent.plugin");
        r2.b();
        r2.a();
        return;
    L5:
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f7798a, b.class, "com.obric.aiagent.plugin");
        r3.flush();
        r3.a();
    }

    public long b() {
        return this.f7799b.a();
    }

    public void a(List<File> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        com.bytedance.crash.o.j.a(this.f7798a, r4);
    }

    static byte[] a(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
    L3:
        int r3 = r4.read(r1);
        if ((-1) == r3) goto L6;
        r0.write(r1, 0, r3);
        goto L3
    L6:
        r4.close();
        byte[] r5 = r0.toByteArray();     // Catch: Throwable -> L10
        com.bytedance.crash.o.i.a(r0);
        return r5;
    L10:
        th = move-exception;
        com.bytedance.crash.o.i.a(r0);
        throw th;
    }
}
