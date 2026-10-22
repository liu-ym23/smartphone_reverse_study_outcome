package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements f, h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14961a;

    /* renamed from: b, reason: collision with root package name */
    public float f14962b;

    public d() {
        this.f14961a = 2;
        this.f14962b = 0.0f;
    }

    @Override // w.f, w.h
    public float a() {
        switch (this.f14961a) {
        }
        return this.f14962b;
    }

    @Override // w.f
    public void b(o2.c cVar, int i, int[] iArr, o2.l lVar, int[] iArr2) {
        switch (this.f14961a) {
            case 0:
                if (lVar != o2.l.f9123c) {
                    k.a(i, iArr, iArr2, true);
                    break;
                } else {
                    k.a(i, iArr, iArr2, false);
                    break;
                }
            default:
                if (lVar != o2.l.f9123c) {
                    k.d(i, iArr, iArr2, true);
                    break;
                } else {
                    k.d(i, iArr, iArr2, false);
                    break;
                }
        }
    }

    @Override // w.h
    public void c(int i, s1.h0 h0Var, int[] iArr, int[] iArr2) {
        switch (this.f14961a) {
            case 0:
                k.a(i, iArr, iArr2, false);
                break;
            default:
                k.d(i, iArr, iArr2, false);
                break;
        }
    }

    public String toString() {
        switch (this.f14961a) {
            case 0:
                return "Arrangement#Center";
            case 1:
                return "Arrangement#SpaceBetween";
            default:
                return super.toString();
        }
    }
}
