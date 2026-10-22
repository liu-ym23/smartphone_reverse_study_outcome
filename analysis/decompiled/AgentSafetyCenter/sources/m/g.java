package m;

import android.content.Context;
import android.view.View;
import com.stepos.agentsafetycenter.R;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends l.v {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f7912l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ k f7913m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(k kVar, Context context, l.d0 d0Var, View view) {
        super(context, d0Var, view, false, R.attr.actionOverflowMenuStyle, 0);
        this.f7913m = kVar;
        if ((d0Var.A.f7632x & 32) != 32) {
            View view2 = kVar.f7951m;
            this.f7650e = view2 == null ? (View) kVar.f7950l : view2;
        }
        a1.g gVar = kVar.A;
        this.f7653h = gVar;
        l.t tVar = this.i;
        if (tVar != null) {
            tVar.g(gVar);
        }
    }

    @Override // l.v
    public final void c() {
        switch (this.f7912l) {
            case 0:
                this.f7913m.f7962x = null;
                super.c();
                break;
            default:
                k kVar = this.f7913m;
                l.l lVar = kVar.f7946g;
                if (lVar != null) {
                    lVar.c(true);
                }
                kVar.f7961w = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(k kVar, Context context, l.l lVar, View view) {
        super(context, lVar, view, true, R.attr.actionOverflowMenuStyle, 0);
        this.f7913m = kVar;
        this.f7651f = 8388613;
        a1.g gVar = kVar.A;
        this.f7653h = gVar;
        l.t tVar = this.i;
        if (tVar != null) {
            tVar.g(gVar);
        }
    }
}
