package com.bytedance.retrofit2.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: MultipartTypedOutput.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f9513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f9514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9516d;

    /* JADX INFO: compiled from: MultipartTypedOutput.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f9517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f9519c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f9520d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f9521e;
        private byte[] f;
        private byte[] g;
        private boolean h;

        public a(String r3, String r4, j r5, String r6, boolean r7) {
            j r8 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.aiagent.plugin");
            this.f9518b = r3;
            this.f9519c = r4;
            this.f9517a = r8;
            this.f9520d = r7;
            this.f9521e = r6;
        }

        public void a(OutputStream r2) {
            b();
            r2.write(this.f);
            r2.write(this.g);
            this.f9517a.a(r2);
        }

        public long a() {
            b();
            if (this.f9517a.c() > (-1)) goto L5;
            return -1;
        L5:
            return (this.f9517a.c() + ((long) this.f.length)) + ((long) this.g.length);
        }

        private void b() {
            if (this.h == false) goto L5;
            return;
        L5:
            this.f = e.a(this.f9521e, this.f9520d, false);
            this.g = e.b(this.f9518b, this.f9519c, this.f9517a);
            this.h = true;
        }
    }

    @Override // com.bytedance.retrofit2.e.j
    public String a() {
        return null;
    }

    static /* synthetic */ byte[] a(String r0, boolean r1, boolean r2) {
        return b(r0, r1, r2);
    }

    static /* synthetic */ byte[] b(String r2, String r3, j r4) {
        return c(r2, r3, (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.aiagent.plugin"));
    }

    public e() {
        this(UUID.randomUUID().toString());
    }

    e(String r3) {
        this.f9513a = new LinkedList();
        this.f9515c = r3;
        byte[] r4 = b(r3, false, true);
        this.f9514b = r4;
        this.f9516d = r4.length;
    }

    public void a(String r3, j r4) {
        a(r3, "binary", (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.aiagent.plugin"));
    }

    public void a(String r7, String r8, j r9) {
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r9, j.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r7, "Part name must not be null.");
        Objects.requireNonNull(r8, "Transfer encoding must not be null.");
        Objects.requireNonNull(r3, "Part body must not be null.");
        a r10 = new a(r7, r8, r3, this.f9515c, this.f9513a.isEmpty());
        this.f9513a.add(r10);
        long r11 = r10.a();
        if (r11 != (-1)) goto L5;
        this.f9516d = -1;
        return;
    L5:
        long r2 = this.f9516d;
        if (r2 == (-1)) goto L10;
        this.f9516d = r2 + r11;
        return;
    }

    public int e() {
        return this.f9513a.size();
    }

    @Override // com.bytedance.retrofit2.e.j
    public String b() {
        return "multipart/form-data; boundary=" + this.f9515c;
    }

    @Override // com.bytedance.retrofit2.e.j
    public long c() {
        return this.f9516d;
    }

    @Override // com.bytedance.retrofit2.e.j
    public void a(OutputStream r5) {
        Iterator<a> r0 = this.f9513a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.aiagent.plugin")).a(r5);
        goto L4
    L6:
        r5.write(this.f9514b);
    }

    @Override // com.bytedance.retrofit2.e.j
    public String d() {
        if (this.f9516d != (-1)) goto L31;
        return null;
    L31:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Throwable -> L12
        a(r0);     // Catch: Throwable -> L11
        ByteArrayInputStream r4 = new ByteArrayInputStream(r0.toByteArray());     // Catch: Throwable -> L11
        String r1 = b.a(r4);     // Catch: Throwable -> L20
        r0.close();     // Catch: Throwable -> L18
    L27:
        r4.close();     // Catch: Throwable -> L19
    L10:
        return r1;
    L13:
        if (r0 != null) goto L35;
    L15:
        if (r4 != null) goto L25;
    L17:
        return null;
    L25:
        r4.close();     // Catch: Throwable -> L22
        goto L17
    L35:
        r0.close();     // Catch: Throwable -> L21
    L11:
        r4 = null;
    L12:
        r4 = null;
        r0 = null;
        goto L13
    }

    private static byte[] b(String r3, boolean r4, boolean r5) {
        StringBuilder r1 = new StringBuilder(r3.length() + 8);     // Catch: IOException -> L12
        if (r4 == true) goto L7;
        r1.append("\r\n");     // Catch: IOException -> L12
    L7:
        r1.append("--");     // Catch: IOException -> L12
        r1.append(r3);     // Catch: IOException -> L12
        if (r5 == false) goto L10;
        r1.append("--");     // Catch: IOException -> L12
    L10:
        r1.append("\r\n");     // Catch: IOException -> L12
        return r1.toString().getBytes("UTF-8");
    L12:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart boundary", e);
    }

    private static byte[] c(String r5, String r6, j r7) {
        j r8 = (j) ZeusTransformUtils.wrapperContextForParams(r7, j.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = new StringBuilder(128);     // Catch: IOException -> L11
        r0.append("Content-Disposition: form-data; name=\"");     // Catch: IOException -> L11
        r0.append(r5);     // Catch: IOException -> L11
        String r9 = r8.a();     // Catch: IOException -> L11
        if (r9 == null) goto L6;
        r0.append("\"; filename=\"");     // Catch: IOException -> L11
        r0.append(r9);     // Catch: IOException -> L11
    L6:
        r0.append("\"\r\nContent-Type: ");     // Catch: IOException -> L11
        r0.append(r8.b());     // Catch: IOException -> L11
        long r1 = r8.c();     // Catch: IOException -> L11
        if (r1 == (-1)) goto L9;
        r0.append("\r\nContent-Length: ").append(r1);     // Catch: IOException -> L11
    L9:
        r0.append("\r\nContent-Transfer-Encoding: ");     // Catch: IOException -> L11
        r0.append(r6);     // Catch: IOException -> L11
        r0.append("\r\n\r\n");     // Catch: IOException -> L11
        return r0.toString().getBytes("UTF-8");
    L11:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart header", e);
    }
}
