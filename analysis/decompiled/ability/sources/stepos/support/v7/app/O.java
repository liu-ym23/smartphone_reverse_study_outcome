package stepos.support.v7.app;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import stepos.support.v7.view.menu.ListMenuItemView;

/* loaded from: classes4.dex */
public final class O implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6231a;
    public final /* synthetic */ View b;

    public /* synthetic */ O(int i, View view) {
        this.f6231a = i;
        this.b = view;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.f6231a) {
            case 0:
                TextView textView = (TextView) this.b;
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (textView.getLineCount() == 1) {
                    textView.setGravity(17);
                    break;
                }
                break;
            case 1:
                TextView textView2 = (TextView) this.b;
                textView2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                textView2.setGravity(textView2.getLineCount() > 1 ? GravityCompat.START : 17);
                break;
            default:
                ListMenuItemView listMenuItemView = (ListMenuItemView) this.b;
                listMenuItemView.d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (listMenuItemView.d.getLineCount() > 1) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) listMenuItemView.getLayoutParams();
                    layoutParams.height = -1;
                    listMenuItemView.setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
    }
}
