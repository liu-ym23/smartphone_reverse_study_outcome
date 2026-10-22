package stepos.support.v7.widget;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import com.stepos.alphame.R;

/* renamed from: stepos.support.v7.widget.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0891k extends L3.u {

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ C0897q f15096t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0891k(C0897q c0897q, Context context, L3.A a4) {
        super(context, a4, null, false, c0897q.f15115F ? R.attr.steposActionOverflowMenuSplitStyle : R.attr.actionOverflowMenuStyle);
        this.f15096t = c0897q;
        if (!a4.f1244x.e()) {
            View view = c0897q.f15124i;
            this.f1349i = view == null ? (View) c0897q.f15123h : view;
        }
        this.f1352l = c0897q.f15114E;
        int size = a4.f1285e.size();
        boolean z4 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                break;
            }
            MenuItem item = a4.getItem(i4);
            if (item.isVisible() && item.getIcon() != null) {
                z4 = true;
                break;
            }
            i4++;
        }
        this.f1353m = z4;
    }

    @Override // L3.u, android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        super.onDismiss();
        C0897q c0897q = this.f15096t;
        c0897q.f15111B = null;
        c0897q.getClass();
    }
}
