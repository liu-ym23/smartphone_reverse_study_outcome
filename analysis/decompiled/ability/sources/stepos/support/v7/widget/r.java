package stepos.support.v7.widget;

import android.content.Context;
import android.view.View;
import androidx.core.view.GravityCompat;
import com.stepos.ability.R;

/* loaded from: classes4.dex */
public final class r extends Va.z {

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ C2005u f6627s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(C2005u c2005u, Context context, Va.n nVar, View view) {
        super(context, nVar, view, true, c2005u.f6635F ? R.attr.steposActionOverflowMenuSplitStyle : androidx.appcompat.R.attr.actionOverflowMenuStyle);
        this.f6627s = c2005u;
        this.f1469r = c2005u.f6635F ? 4 : 3;
        this.p = GravityCompat.END;
        this.k = c2005u.E;
    }

    @Override // Va.z, android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        super.onDismiss();
        C2005u c2005u = this.f6627s;
        Va.n nVar = c2005u.c;
        if (nVar != null) {
            nVar.c(true);
        }
        c2005u.f6631A = null;
        c2005u.i.setAlpha(1.0f);
    }
}
