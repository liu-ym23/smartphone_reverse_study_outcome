package androidx.appcompat.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public final class F0 implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ G0 f2818a;

    public F0(G0 g02) {
        this.f2818a = g02;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        int action = motionEvent.getAction();
        int x4 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        G0 g02 = this.f2818a;
        if (action == 0 && (popupWindow = g02.f2846z) != null && popupWindow.isShowing() && x4 >= 0 && x4 < g02.f2846z.getWidth() && y4 >= 0 && y4 < g02.f2846z.getHeight()) {
            g02.f2842v.postDelayed(g02.f2838r, 250L);
            return false;
        }
        if (action != 1) {
            return false;
        }
        g02.f2842v.removeCallbacks(g02.f2838r);
        return false;
    }
}
