package ie;

import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class z extends w0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6102b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6103c;

    /* renamed from: d, reason: collision with root package name */
    public final a f6104d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f6105e;

    public z(String str, int i, boolean z10) {
        this.f6102b = i;
        switch (i) {
            case 1:
                a aVar = a.f5967f;
                Objects.requireNonNull(str, "name == null");
                this.f6103c = str;
                this.f6104d = aVar;
                this.f6105e = z10;
                break;
            default:
                a aVar2 = a.f5967f;
                Objects.requireNonNull(str, "name == null");
                this.f6103c = str;
                this.f6104d = aVar2;
                this.f6105e = z10;
                break;
        }
    }

    @Override // ie.w0
    public final void a(l0 l0Var, Object obj) {
        switch (this.f6102b) {
            case 0:
                if (obj != null) {
                    this.f6104d.getClass();
                    String string = obj.toString();
                    if (string != null) {
                        l0Var.a(this.f6103c, string, this.f6105e);
                        break;
                    }
                }
                break;
            default:
                if (obj != null) {
                    this.f6104d.getClass();
                    String string2 = obj.toString();
                    if (string2 != null) {
                        l0Var.d(this.f6103c, string2, this.f6105e);
                        break;
                    }
                }
                break;
        }
    }
}
