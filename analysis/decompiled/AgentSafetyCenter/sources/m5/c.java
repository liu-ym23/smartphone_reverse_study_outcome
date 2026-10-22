package m5;

import p5.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8241b;

    public /* synthetic */ c(int i) {
        this.f8241b = i;
    }

    @Override // m5.d
    public final boolean b(p pVar) {
        switch (this.f8241b) {
            case 0:
                return pVar.f9772j.f4289c;
            case 1:
                return pVar.f9772j.f4291e;
            case 2:
                return pVar.f9772j.f4287a == 2;
            case 3:
                int i = pVar.f9772j.f4287a;
                return i == 3 || i == 6;
            default:
                return pVar.f9772j.f4292f;
        }
    }

    @Override // m5.b
    public final int d() {
        switch (this.f8241b) {
            case 0:
                return 6;
            case 1:
                return 5;
            case 2:
                return 7;
            case 3:
                return 7;
            default:
                return 9;
        }
    }

    @Override // m5.b
    public final boolean e(Object obj) {
        boolean zBooleanValue;
        switch (this.f8241b) {
            case 0:
                zBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case 1:
                zBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case 2:
                l5.f fVar = (l5.f) obj;
                fVar.getClass();
                return (fVar.f7740a && fVar.f7741b) ? false : true;
            case 3:
                l5.f fVar2 = (l5.f) obj;
                fVar2.getClass();
                return !fVar2.f7740a || fVar2.f7742c;
            default:
                zBooleanValue = ((Boolean) obj).booleanValue();
                break;
        }
        return !zBooleanValue;
    }
}
