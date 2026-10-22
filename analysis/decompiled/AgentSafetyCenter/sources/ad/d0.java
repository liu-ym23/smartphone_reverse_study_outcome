package ad;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public z f453a;

    /* renamed from: b, reason: collision with root package name */
    public x f454b;

    /* renamed from: d, reason: collision with root package name */
    public String f456d;

    /* renamed from: e, reason: collision with root package name */
    public m f457e;

    /* renamed from: g, reason: collision with root package name */
    public h0 f459g;

    /* renamed from: h, reason: collision with root package name */
    public e0 f460h;
    public e0 i;

    /* renamed from: j, reason: collision with root package name */
    public e0 f461j;

    /* renamed from: k, reason: collision with root package name */
    public long f462k;

    /* renamed from: l, reason: collision with root package name */
    public long f463l;

    /* renamed from: m, reason: collision with root package name */
    public ed.e f464m;

    /* renamed from: c, reason: collision with root package name */
    public int f455c = -1;

    /* renamed from: f, reason: collision with root package name */
    public ne.b f458f = new ne.b();

    public static void b(e0 e0Var, String str) {
        if (e0Var != null) {
            if (e0Var.f473k != null) {
                od.f.c(str.concat(".body != null"));
                return;
            }
            if (e0Var.f474l != null) {
                od.f.c(str.concat(".networkResponse != null"));
            } else if (e0Var.f475m != null) {
                od.f.c(str.concat(".cacheResponse != null"));
            } else {
                if (e0Var.f476n == null) {
                    return;
                }
                od.f.c(str.concat(".priorResponse != null"));
            }
        }
    }

    public final e0 a() {
        int i = this.f455c;
        if (i < 0) {
            o.b(this.f455c, "code < 0: ");
            return null;
        }
        z zVar = this.f453a;
        if (zVar == null) {
            od.f.e("request == null");
            return null;
        }
        x xVar = this.f454b;
        if (xVar == null) {
            od.f.e("protocol == null");
            return null;
        }
        String str = this.f456d;
        if (str == null) {
            od.f.e("message == null");
            return null;
        }
        m mVar = this.f457e;
        n nVarD = this.f458f.d();
        h0 h0Var = this.f459g;
        e0 e0Var = this.f460h;
        e0 e0Var2 = this.i;
        e0 e0Var3 = this.f461j;
        long j10 = this.f462k;
        long j11 = this.f463l;
        ed.e eVar = this.f464m;
        e0 e0Var4 = new e0();
        e0Var4.f468c = zVar;
        e0Var4.f469f = xVar;
        e0Var4.f470g = str;
        e0Var4.f471h = i;
        e0Var4.i = mVar;
        e0Var4.f472j = nVarD;
        e0Var4.f473k = h0Var;
        e0Var4.f474l = e0Var;
        e0Var4.f475m = e0Var2;
        e0Var4.f476n = e0Var3;
        e0Var4.f477o = j10;
        e0Var4.f478p = j11;
        e0Var4.f479q = eVar;
        VarHandle.storeStoreFence();
        return e0Var4;
    }
}
