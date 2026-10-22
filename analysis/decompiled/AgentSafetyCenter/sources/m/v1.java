package m;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v1 implements View.OnTouchListener {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ w1 f8096c;

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        w1 w1Var = this.f8096c;
        s1 s1Var = w1Var.f8130v;
        Handler handler = w1Var.f8134z;
        int action = motionEvent.getAction();
        int x6 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (action == 0 && (popupWindow = w1Var.D) != null && popupWindow.isShowing() && x6 >= 0 && x6 < w1Var.D.getWidth() && y10 >= 0 && y10 < w1Var.D.getHeight()) {
            handler.postDelayed(s1Var, 250L);
            return false;
        }
        if (action != 1) {
            return false;
        }
        handler.removeCallbacks(s1Var);
        return false;
    }
}
