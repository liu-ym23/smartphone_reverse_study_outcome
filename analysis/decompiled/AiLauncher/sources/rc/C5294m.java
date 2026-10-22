package rc;

/* renamed from: rc.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5294m extends AbstractC5300p {

    /* renamed from: e, reason: collision with root package name */
    public final char f39354e;

    /* renamed from: f, reason: collision with root package name */
    public String f39355f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f39356g;

    public C5294m(char c10, String str, boolean z10) {
        this.f39354e = c10;
        this.f39355f = str;
        this.f39356g = z10;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        String strO;
        if (this.f39355f == null && (strO = y02.o()) != null) {
            this.f39355f = strO;
        }
        boolean zK = y02.k();
        C5296n c5296n = new C5296n(o(y02.n(), y02.m(), zK));
        return (zK && Character.isLowerCase(this.f39354e)) ? new L0(c5296n, 0.800000011920929d, 0.800000011920929d) : c5296n;
    }

    @Override // rc.AbstractC5300p
    public C5298o i(Z0 z02) {
        return o(z02, 0, false).b();
    }

    public final C5292l o(Z0 z02, int i10, boolean z10) {
        char upperCase = this.f39354e;
        if (z10 && Character.isLowerCase(upperCase)) {
            upperCase = Character.toUpperCase(this.f39354e);
        }
        String str = this.f39355f;
        return str == null ? z02.z(upperCase, i10) : z02.F(upperCase, str, i10);
    }

    public char p() {
        return this.f39354e;
    }

    public boolean q() {
        return this.f39356g;
    }

    public String toString() {
        return "CharAtom: '" + this.f39354e + "'";
    }

    public C5294m(char c10, String str) {
        this(c10, str, false);
    }
}
