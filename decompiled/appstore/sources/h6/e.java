package h6;

import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class e implements TypedOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f20352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f20353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f20355d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TypedOutput f20356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f20357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f20358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f20359d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f20360e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte[] f20361f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte[] f20362g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f20363h;

        public a(String r10, String r11, TypedOutput r12, String r13, boolean r14) {
            this.f20357b = r10;
            this.f20358c = r11;
            this.f20356a = r12;
            this.f20359d = r14;
            this.f20360e = r13;
        }

        public final void a() {
            if (this.f20363h == false) goto L5;
            return;
        L5:
            this.f20361f = e.a(this.f20360e, this.f20359d, false);
            this.f20362g = e.b(this.f20357b, this.f20358c, this.f20356a);
            this.f20363h = true;
        }

        public long b() {
            a();
            if (this.f20356a.length() > (-1)) goto L5;
            return -1;
        L5:
            return (this.f20356a.length() + ((long) this.f20361f.length)) + ((long) this.f20362g.length);
        }

        public void c(OutputStream r10) {
            a();
            r10.write(this.f20361f);
            r10.write(this.f20362g);
            this.f20356a.writeTo(r10);
        }
    }

    public e() {
        this(UUID.randomUUID().toString());
    }

    public static /* synthetic */ byte[] a(String r10, boolean r11, boolean r12) {
        return e(r10, r11, r12);
    }

    public static /* synthetic */ byte[] b(String r10, String r11, TypedOutput r12) {
        return f(r10, r11, r12);
    }

    public static byte[] e(String r10, boolean r11, boolean r12) {
        StringBuilder r13 = new StringBuilder(r10.length() + 8);     // Catch: IOException -> L7
        if (r11 == true) goto L9;
        r13.append("\r\n");     // Catch: IOException -> L7
    L9:
        r13.append("--");     // Catch: IOException -> L7
        r13.append(r10);     // Catch: IOException -> L7
        if (r12 == false) goto L12;
        r13.append("--");     // Catch: IOException -> L7
    L12:
        r13.append("\r\n");     // Catch: IOException -> L7
        return r13.toString().getBytes("UTF-8");
    L7:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart boundary", e);
    }

    public static byte[] f(String r10, String r11, TypedOutput r12) {
        StringBuilder r13 = new StringBuilder(128);     // Catch: IOException -> L5
        r13.append("Content-Disposition: form-data; name=\"");     // Catch: IOException -> L5
        r13.append(r10);     // Catch: IOException -> L5
        String r14 = r12.fileName();     // Catch: IOException -> L5
        if (r14 == null) goto L7;
        r13.append("\"; filename=\"");     // Catch: IOException -> L5
        r13.append(r14);     // Catch: IOException -> L5
    L7:
        r13.append("\"\r\nContent-Type: ");     // Catch: IOException -> L5
        r13.append(r12.mimeType());     // Catch: IOException -> L5
        long r15 = r12.length();     // Catch: IOException -> L5
        if (r15 == (-1)) goto L10;
        r13.append("\r\nContent-Length: ");     // Catch: IOException -> L5
        r13.append(r15);     // Catch: IOException -> L5
    L10:
        r13.append("\r\nContent-Transfer-Encoding: ");     // Catch: IOException -> L5
        r13.append(r11);     // Catch: IOException -> L5
        r13.append("\r\n\r\n");     // Catch: IOException -> L5
        return r13.toString().getBytes("UTF-8");
    L5:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart header", e);
    }

    public void c(String r10, TypedOutput r11) {
        d(r10, "binary", r11);
    }

    public void d(String r10, String r11, TypedOutput r12) {
        if (r10 == null) goto L17;
        if (r11 == null) goto L15;
        if (r12 == null) goto L13;
        a r13 = new a(r10, r11, r12, this.f20354c, this.f20352a.isEmpty());
        this.f20352a.add(r13);
        long r14 = r13.b();
        if (r14 != (-1)) goto L8;
        this.f20355d = -1;
        return;
    L8:
        long r15 = this.f20355d;
        if (r15 == (-1)) goto L19;
        this.f20355d = r15 + r14;
        return;
    L19:
        return;
    L13:
        throw new NullPointerException("Part body must not be null.");
    L15:
        throw new NullPointerException("Transfer encoding must not be null.");
    L17:
        throw new NullPointerException("Part name must not be null.");
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return null;
    }

    public int g() {
        return this.f20352a.size();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.f20355d;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        if (this.f20355d != (-1)) goto L31;
        return null;
    L31:
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();     // Catch: Throwable -> L12
        writeTo(r10);     // Catch: Throwable -> L11
        ByteArrayInputStream r11 = new ByteArrayInputStream(r10.toByteArray());     // Catch: Throwable -> L11
        String r12 = b.b(r11);     // Catch: Throwable -> L20
        r10.close();     // Catch: Throwable -> L18
    L27:
        r11.close();     // Catch: Throwable -> L19
    L10:
        return r12;
    L13:
        if (r10 != null) goto L35;
    L15:
        if (r11 != null) goto L25;
    L17:
        return null;
    L25:
        r11.close();     // Catch: Throwable -> L22
        goto L17
    L35:
        r10.close();     // Catch: Throwable -> L21
    L11:
        r11 = null;
    L12:
        r11 = null;
        r10 = null;
        goto L13
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return "multipart/form-data; boundary=" + this.f20354c;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r10) {
        Iterator r11 = this.f20352a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((a) r11.next()).c(r10);
        goto L4
    L6:
        r10.write(this.f20353b);
    }

    public e(String r10) {
        this.f20352a = new LinkedList();
        this.f20354c = r10;
        byte[] r11 = e(r10, false, true);
        this.f20353b = r11;
        this.f20355d = r11.length;
    }
}
