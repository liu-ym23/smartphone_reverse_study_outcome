package x0;

import android.graphics.Rect;
import android.view.autofill.AutofillManager;
import jb.v;
import xb.r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends yb.l implements r {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f15503c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f15504f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, int i) {
        super(4);
        this.f15503c = bVar;
        this.f15504f = i;
    }

    @Override // xb.r
    public final Object c(Object obj, Object obj2, Object obj3, Object obj4) {
        int iIntValue = ((Number) obj).intValue();
        int iIntValue2 = ((Number) obj2).intValue();
        int iIntValue3 = ((Number) obj3).intValue();
        int iIntValue4 = ((Number) obj4).intValue();
        b bVar = this.f15503c;
        stepos.support.v7.app.f fVar = bVar.f15505a;
        ((AutofillManager) fVar.f12315f).notifyViewEntered(bVar.f15507c, this.f15504f, new Rect(iIntValue, iIntValue2, iIntValue3, iIntValue4));
        return v.f6774a;
    }
}
