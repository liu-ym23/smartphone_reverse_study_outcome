package n6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public s f4132a;

    /* renamed from: b, reason: collision with root package name */
    public r f4133b;
    public String d;

    /* renamed from: e, reason: collision with root package name */
    public j f4135e;

    /* renamed from: h, reason: collision with root package name */
    public c7.u f4138h;

    /* renamed from: i, reason: collision with root package name */
    public u f4139i;

    /* renamed from: j, reason: collision with root package name */
    public u f4140j;

    /* renamed from: k, reason: collision with root package name */
    public u f4141k;

    /* renamed from: l, reason: collision with root package name */
    public long f4142l;

    /* renamed from: m, reason: collision with root package name */
    public long f4143m;

    /* renamed from: n, reason: collision with root package name */
    public r6.g f4144n;

    /* renamed from: c, reason: collision with root package name */
    public int f4134c = -1;

    /* renamed from: g, reason: collision with root package name */
    public w f4137g = w.f4162a;

    /* renamed from: o, reason: collision with root package name */
    public z f4145o = z.f4173a;

    /* renamed from: f, reason: collision with root package name */
    public androidx.fragment.app.l f4136f = new androidx.fragment.app.l(1);

    public static void b(String str, u uVar) {
        if (uVar != null) {
            if (uVar.f4153j != null) {
                throw new IllegalArgumentException(str.concat(".networkResponse != null").toString());
            }
            if (uVar.f4154k != null) {
                throw new IllegalArgumentException(str.concat(".cacheResponse != null").toString());
            }
            if (uVar.f4155l != null) {
                throw new IllegalArgumentException(str.concat(".priorResponse != null").toString());
            }
        }
    }

    public final u a() {
        int i8 = this.f4134c;
        if (i8 < 0) {
            throw new IllegalStateException(("code < 0: " + this.f4134c).toString());
        }
        s sVar = this.f4132a;
        if (sVar == null) {
            throw new IllegalStateException("request == null");
        }
        r rVar = this.f4133b;
        if (rVar == null) {
            throw new IllegalStateException("protocol == null");
        }
        String str = this.d;
        if (str != null) {
            return new u(sVar, rVar, str, i8, this.f4135e, this.f4136f.a(), this.f4137g, this.f4138h, this.f4139i, this.f4140j, this.f4141k, this.f4142l, this.f4143m, this.f4144n, this.f4145o);
        }
        throw new IllegalStateException("message == null");
    }
}
