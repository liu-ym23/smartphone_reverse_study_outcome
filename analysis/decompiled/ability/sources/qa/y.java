package qa;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class y extends U {
    public final /* synthetic */ int d;
    public final String e;
    public final C1849a f;
    public final boolean g;

    public y(int i, String str, boolean z10) {
        this.d = i;
        switch (i) {
            case 1:
                C1849a c1849a = C1849a.b;
                Objects.requireNonNull(str, "name == null");
                this.e = str;
                this.f = c1849a;
                this.g = z10;
                break;
            case 2:
                C1849a c1849a2 = C1849a.b;
                Objects.requireNonNull(str, "name == null");
                this.e = str;
                this.f = c1849a2;
                this.g = z10;
                break;
            default:
                C1849a c1849a3 = C1849a.b;
                Objects.requireNonNull(str, "name == null");
                this.e = str;
                this.f = c1849a3;
                this.g = z10;
                break;
        }
    }

    @Override // qa.U
    public final void a(I i, Object obj) {
        switch (this.d) {
            case 0:
                if (obj != null) {
                    this.f.getClass();
                    String string = obj.toString();
                    if (string != null) {
                        i.a(this.e, string, this.g);
                        break;
                    }
                }
                break;
            case 1:
                if (obj != null) {
                    this.f.getClass();
                    String string2 = obj.toString();
                    if (string2 != null) {
                        i.b(this.e, string2, this.g);
                        break;
                    }
                }
                break;
            default:
                if (obj != null) {
                    this.f.getClass();
                    String string3 = obj.toString();
                    if (string3 != null) {
                        i.d(this.e, string3, this.g);
                        break;
                    }
                }
                break;
        }
    }
}
