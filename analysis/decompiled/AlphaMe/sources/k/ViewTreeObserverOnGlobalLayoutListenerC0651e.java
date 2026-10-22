package k;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.appcompat.widget.L0;
import androidx.appcompat.widget.T;
import androidx.appcompat.widget.V;
import java.util.ArrayList;
import java.util.Iterator;
import stepos.support.v7.view.menu.ListMenuItemView;

/* renamed from: k.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC0651e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13184a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13185b;

    public /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC0651e(int i4, Object obj) {
        this.f13184a = i4;
        this.f13185b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int i4 = this.f13184a;
        Object obj = this.f13185b;
        switch (i4) {
            case 0:
                ViewOnKeyListenerC0655i viewOnKeyListenerC0655i = (ViewOnKeyListenerC0655i) obj;
                if (viewOnKeyListenerC0655i.e()) {
                    ArrayList arrayList = viewOnKeyListenerC0655i.f13204i;
                    if (arrayList.size() > 0 && !((C0654h) arrayList.get(0)).f13193a.f2845y) {
                        View view = viewOnKeyListenerC0655i.f13211p;
                        if (view != null && view.isShown()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((C0654h) it.next()).f13193a.g();
                            }
                            break;
                        } else {
                            viewOnKeyListenerC0655i.dismiss();
                            break;
                        }
                    }
                }
                break;
            case 1:
                ViewOnKeyListenerC0645F viewOnKeyListenerC0645F = (ViewOnKeyListenerC0645F) obj;
                if (viewOnKeyListenerC0645F.e()) {
                    L0 l02 = viewOnKeyListenerC0645F.f13148i;
                    if (!l02.f2845y) {
                        View view2 = viewOnKeyListenerC0645F.f13153n;
                        if (view2 != null && view2.isShown()) {
                            l02.g();
                            break;
                        } else {
                            viewOnKeyListenerC0645F.dismiss();
                            break;
                        }
                    }
                }
                break;
            case 2:
                V v4 = (V) obj;
                if (!v4.getInternalPopup().e()) {
                    v4.f3020f.n(v4.getTextDirection(), v4.getTextAlignment());
                }
                ViewTreeObserver viewTreeObserver = v4.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                    break;
                }
                break;
            case 3:
                T t4 = (T) obj;
                V v5 = t4.f2965E;
                if (!v5.isAttachedToWindow() || !v5.getGlobalVisibleRect(t4.f2963C)) {
                    t4.dismiss();
                    break;
                } else {
                    t4.s();
                    t4.g();
                    break;
                }
                break;
            default:
                ListMenuItemView listMenuItemView = (ListMenuItemView) obj;
                listMenuItemView.f14683d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (listMenuItemView.f14683d.getLineCount() > 1) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) listMenuItemView.getLayoutParams();
                    layoutParams.height = -1;
                    listMenuItemView.setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
    }
}
