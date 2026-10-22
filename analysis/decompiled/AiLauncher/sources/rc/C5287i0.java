package rc;

/* renamed from: rc.i0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5287i0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public int f39318d;

    /* renamed from: e, reason: collision with root package name */
    public int f39319e;

    /* renamed from: f, reason: collision with root package name */
    public float f39320f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    public AbstractC5276d f39321g;

    /* renamed from: h, reason: collision with root package name */
    public int f39322h;

    /* renamed from: i, reason: collision with root package name */
    public int f39323i;

    /* renamed from: j, reason: collision with root package name */
    public int f39324j;

    /* renamed from: k, reason: collision with root package name */
    public int f39325k;

    public C5287i0(int i10, String str, AbstractC5276d abstractC5276d) {
        this.f39318d = i10 < 1 ? 1 : i10;
        this.f39321g = abstractC5276d;
        this.f39319e = o(str);
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        AbstractC5284h abstractC5284hF = this.f39320f == 0.0f ? this.f39321g.f(y02) : new Q(this.f39321g.f(y02), this.f39320f, this.f39319e);
        abstractC5284hF.f39309h = 12;
        return abstractC5284hF;
    }

    public int i() {
        return this.f39325k;
    }

    public int j() {
        return this.f39324j;
    }

    public int k() {
        return this.f39318d;
    }

    public boolean n() {
        return this.f39323i != 0;
    }

    public final int o(String str) {
        int length = str.length();
        int i10 = 0;
        int i11 = 2;
        boolean z10 = true;
        while (i10 < length) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == 'c') {
                z10 = false;
                i11 = 2;
            } else if (cCharAt == 'l') {
                i11 = 0;
                z10 = false;
            } else if (cCharAt == 'r') {
                z10 = false;
                i11 = 1;
            } else if (cCharAt == '|') {
                if (z10) {
                    this.f39322h = 1;
                } else {
                    this.f39323i = 1;
                }
                while (true) {
                    int i12 = i10 + 1;
                    if (i12 >= length) {
                        i10 = i12;
                        break;
                    }
                    if (str.charAt(i12) != '|') {
                        break;
                    }
                    if (z10) {
                        this.f39322h++;
                    } else {
                        this.f39323i++;
                    }
                    i10 = i12;
                }
            }
            i10++;
        }
        return i11;
    }

    public void p(int i10, int i11) {
        this.f39324j = i10;
        this.f39325k = i11;
    }

    public void q(float f10) {
        this.f39320f = f10;
    }
}
