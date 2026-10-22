package stepos.support.v7.widget;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import com.stepos.ability.R;

/* renamed from: stepos.support.v7.widget.n, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1999n extends Va.z {

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ C2005u f6624s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1999n(C2005u c2005u, Context context, Va.F f) {
        super(context, f, null, false, c2005u.f6635F ? R.attr.steposActionOverflowMenuSplitStyle : androidx.appcompat.R.attr.actionOverflowMenuStyle);
        this.f6624s = c2005u;
        if ((f.f1430x.f1461x & 32) != 32) {
            View view = c2005u.i;
            this.h = view == null ? (View) c2005u.h : view;
        }
        this.k = c2005u.E;
        int size = f.e.size();
        boolean z10 = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = f.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i++;
        }
        this.l = z10;
    }

    @Override // Va.z, android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        super.onDismiss();
        C2005u c2005u = this.f6624s;
        c2005u.f6632B = null;
        c2005u.getClass();
    }
}
