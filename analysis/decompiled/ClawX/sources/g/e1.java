package g;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e1 implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j1 f2690a;

    public e1(j1 j1Var) {
        this.f2690a = j1Var;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        j1 j1Var = this.f2690a;
        b1 b1Var = j1Var.f2749o;
        Handler handler = j1Var.f2753s;
        x xVar = j1Var.f2757w;
        int action = motionEvent.getAction();
        int x7 = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && xVar != null && xVar.isShowing() && x7 >= 0 && x7 < xVar.getWidth() && y >= 0 && y < xVar.getHeight()) {
            handler.postDelayed(b1Var, 250L);
            return false;
        }
        if (action != 1) {
            return false;
        }
        handler.removeCallbacks(b1Var);
        return false;
    }
}
