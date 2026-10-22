package r;

/* loaded from: classes.dex */
public final class b implements c, g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8843a;

    /* renamed from: b, reason: collision with root package name */
    public final float f8844b;

    public b(int i2) {
        this.f8843a = i2;
        switch (i2) {
            case 1:
                this.f8844b = 0;
                break;
            case 2:
                this.f8844b = 0;
                break;
            case 3:
                this.f8844b = 0;
                break;
            default:
                this.f8844b = 0;
                break;
        }
    }

    @Override // r.c, r.g
    public final float a() {
        switch (this.f8843a) {
        }
        return this.f8844b;
    }

    @Override // r.c
    public final void b(i1.m0 m0Var, int i2, int[] iArr, d2.l lVar, int[] iArr2) {
        switch (this.f8843a) {
            case 0:
                if (lVar != d2.l.f2793f) {
                    i.a(i2, iArr, iArr2, true);
                    break;
                } else {
                    i.a(i2, iArr, iArr2, false);
                    break;
                }
            case 1:
                if (lVar != d2.l.f2793f) {
                    i.d(i2, iArr, iArr2, true);
                    break;
                } else {
                    i.d(i2, iArr, iArr2, false);
                    break;
                }
            case 2:
                if (lVar != d2.l.f2793f) {
                    i.e(i2, iArr, iArr2, true);
                    break;
                } else {
                    i.e(i2, iArr, iArr2, false);
                    break;
                }
            default:
                if (lVar != d2.l.f2793f) {
                    i.f(i2, iArr, iArr2, true);
                    break;
                } else {
                    i.f(i2, iArr, iArr2, false);
                    break;
                }
        }
    }

    @Override // r.g
    public final void c(int i2, i1.m0 m0Var, int[] iArr, int[] iArr2) {
        switch (this.f8843a) {
            case 0:
                i.a(i2, iArr, iArr2, false);
                break;
            case 1:
                i.d(i2, iArr, iArr2, false);
                break;
            case 2:
                i.e(i2, iArr, iArr2, false);
                break;
            default:
                i.f(i2, iArr, iArr2, false);
                break;
        }
    }

    public final String toString() {
        switch (this.f8843a) {
            case 0:
                return "Arrangement#Center";
            case 1:
                return "Arrangement#SpaceAround";
            case 2:
                return "Arrangement#SpaceBetween";
            default:
                return "Arrangement#SpaceEvenly";
        }
    }
}
