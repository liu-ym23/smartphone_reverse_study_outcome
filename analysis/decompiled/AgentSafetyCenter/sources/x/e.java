package x;

import android.view.ViewStructure;
import jb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends yb.l implements xb.r {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15405c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f15406f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Object obj, int i) {
        super(4);
        this.f15405c = i;
        this.f15406f = obj;
    }

    @Override // xb.r
    public final Object c(Object obj, Object obj2, Object obj3, Object obj4) {
        switch (this.f15405c) {
            case 0:
                b bVar = (b) obj;
                ((Number) obj2).intValue();
                k0.s sVar = (k0.s) obj3;
                int iIntValue = ((Number) obj4).intValue();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= sVar.f(bVar) ? 4 : 2;
                }
                if ((iIntValue & 131) == 130 && sVar.B()) {
                    sVar.S();
                } else {
                    ((s0.c) this.f15406f).invoke(bVar, sVar, Integer.valueOf(iIntValue & 14));
                }
                break;
            default:
                int iIntValue2 = ((Number) obj).intValue();
                int iIntValue3 = ((Number) obj2).intValue();
                ((ViewStructure) this.f15406f).setDimens(iIntValue2, iIntValue3, 0, 0, ((Number) obj3).intValue() - iIntValue2, ((Number) obj4).intValue() - iIntValue3);
                break;
        }
        return v.f6774a;
    }
}
