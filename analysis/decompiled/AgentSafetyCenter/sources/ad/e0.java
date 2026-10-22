package ad;

import java.io.Closeable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 implements Closeable {

    /* renamed from: c, reason: collision with root package name */
    public z f468c;

    /* renamed from: f, reason: collision with root package name */
    public x f469f;

    /* renamed from: g, reason: collision with root package name */
    public String f470g;

    /* renamed from: h, reason: collision with root package name */
    public int f471h;
    public m i;

    /* renamed from: j, reason: collision with root package name */
    public n f472j;

    /* renamed from: k, reason: collision with root package name */
    public h0 f473k;

    /* renamed from: l, reason: collision with root package name */
    public e0 f474l;

    /* renamed from: m, reason: collision with root package name */
    public e0 f475m;

    /* renamed from: n, reason: collision with root package name */
    public e0 f476n;

    /* renamed from: o, reason: collision with root package name */
    public long f477o;

    /* renamed from: p, reason: collision with root package name */
    public long f478p;

    /* renamed from: q, reason: collision with root package name */
    public ed.e f479q;

    /* renamed from: r, reason: collision with root package name */
    public c f480r;

    public static String d(e0 e0Var, String str) {
        e0Var.getClass();
        String strA = e0Var.f472j.a(str);
        if (strA == null) {
            return null;
        }
        return strA;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        h0 h0Var = this.f473k;
        if (h0Var != null) {
            h0Var.close();
        } else {
            od.f.e("response is not eligible for a body and must not be closed");
        }
    }

    public final boolean e() {
        int i = this.f471h;
        return 200 <= i && i < 300;
    }

    public final d0 g() {
        d0 d0Var = new d0();
        d0Var.f453a = this.f468c;
        d0Var.f454b = this.f469f;
        d0Var.f455c = this.f471h;
        d0Var.f456d = this.f470g;
        d0Var.f457e = this.i;
        d0Var.f458f = this.f472j.c();
        d0Var.f459g = this.f473k;
        d0Var.f460h = this.f474l;
        d0Var.i = this.f475m;
        d0Var.f461j = this.f476n;
        d0Var.f462k = this.f477o;
        d0Var.f463l = this.f478p;
        d0Var.f464m = this.f479q;
        return d0Var;
    }

    public final String toString() {
        return "Response{protocol=" + this.f469f + ", code=" + this.f471h + ", message=" + this.f470g + ", url=" + ((q) this.f468c.f637b) + '}';
    }
}
