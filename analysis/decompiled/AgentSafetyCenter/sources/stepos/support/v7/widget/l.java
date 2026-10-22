package stepos.support.v7.widget;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import com.stepos.agentsafetycenter.R;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class l extends te.t {

    /* renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f12771w = 1;

    /* renamed from: x, reason: collision with root package name */
    public final /* synthetic */ q f12772x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(q qVar, Context context, te.z zVar) {
        super(context, zVar, null, false, qVar.J ? R.attr.steposActionOverflowMenuSplitStyle : R.attr.actionOverflowMenuStyle);
        boolean z10 = false;
        this.f12772x = qVar;
        if ((zVar.f13415x.f13385x & 32) != 32) {
            View view = qVar.f12808m;
            this.f13403l = view == null ? (View) qVar.f12807l : view;
        }
        this.f13406o = qVar.I;
        int size = zVar.f13347e.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = zVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i++;
        }
        this.f13407p = z10;
    }

    @Override // te.t, android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        switch (this.f12771w) {
            case 0:
                super.onDismiss();
                this.f12772x.F = null;
                break;
            default:
                super.onDismiss();
                q qVar = this.f12772x;
                te.l lVar = qVar.f12803g;
                if (lVar != null) {
                    lVar.c(true);
                }
                qVar.E = null;
                qVar.f12808m.setAlpha(1.0f);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(q qVar, Context context, te.l lVar, View view) {
        super(context, lVar, view, true, qVar.J ? R.attr.steposActionOverflowMenuSplitStyle : R.attr.actionOverflowMenuStyle);
        this.f12772x = qVar;
        this.f13413v = qVar.J ? 4 : 3;
        this.f13411t = 8388613;
        this.f13406o = qVar.I;
    }
}
