package ab;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public w f671a;

    /* renamed from: b, reason: collision with root package name */
    public u f672b;

    /* renamed from: d, reason: collision with root package name */
    public String f674d;

    /* renamed from: e, reason: collision with root package name */
    public l f675e;

    /* renamed from: g, reason: collision with root package name */
    public b0 f677g;

    /* renamed from: h, reason: collision with root package name */
    public z f678h;

    /* renamed from: i, reason: collision with root package name */
    public z f679i;

    /* renamed from: j, reason: collision with root package name */
    public z f680j;

    /* renamed from: k, reason: collision with root package name */
    public long f681k;

    /* renamed from: l, reason: collision with root package name */
    public long f682l;

    /* renamed from: m, reason: collision with root package name */
    public c1.o f683m;

    /* renamed from: c, reason: collision with root package name */
    public int f673c = -1;

    /* renamed from: f, reason: collision with root package name */
    public m f676f = new m();

    public static void b(z zVar, String str) {
        if (zVar != null) {
            if (zVar.f690l != null) {
                throw new IllegalArgumentException(str.concat(".body != null").toString());
            }
            if (zVar.f691m != null) {
                throw new IllegalArgumentException(str.concat(".networkResponse != null").toString());
            }
            if (zVar.f692n != null) {
                throw new IllegalArgumentException(str.concat(".cacheResponse != null").toString());
            }
            if (zVar.f693o != null) {
                throw new IllegalArgumentException(str.concat(".priorResponse != null").toString());
            }
        }
    }

    public final z a() {
        int i2 = this.f673c;
        if (i2 < 0) {
            throw new IllegalStateException(("code < 0: " + this.f673c).toString());
        }
        w wVar = this.f671a;
        if (wVar == null) {
            throw new IllegalStateException("request == null");
        }
        u uVar = this.f672b;
        if (uVar == null) {
            throw new IllegalStateException("protocol == null");
        }
        String str = this.f674d;
        if (str != null) {
            return new z(wVar, uVar, str, i2, this.f675e, this.f676f.d(), this.f677g, this.f678h, this.f679i, this.f680j, this.f681k, this.f682l, this.f683m);
        }
        throw new IllegalStateException("message == null");
    }
}
