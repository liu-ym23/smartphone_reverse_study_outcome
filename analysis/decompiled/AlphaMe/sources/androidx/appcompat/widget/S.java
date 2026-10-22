package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public final class S implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2909a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2910b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2911c;

    public /* synthetic */ S(int i4, Object obj, Object obj2) {
        this.f2909a = i4;
        this.f2911c = obj;
        this.f2910b = obj2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        int i4 = this.f2909a;
        Object obj = this.f2910b;
        switch (i4) {
            case 0:
                ViewTreeObserver viewTreeObserver = ((T) this.f2911c).f2965E.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) obj);
                    break;
                }
                break;
            default:
                ((View) obj).setAlpha(1.0f);
                break;
        }
    }
}
