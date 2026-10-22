package k1;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: k1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnTouchListenerC0796a implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private final Dialog f17841a;

    /* renamed from: b, reason: collision with root package name */
    private final int f17842b;

    /* renamed from: c, reason: collision with root package name */
    private final int f17843c;

    /* renamed from: d, reason: collision with root package name */
    private final int f17844d;

    public ViewOnTouchListenerC0796a(Dialog dialog, Rect rect) {
        this.f17841a = dialog;
        this.f17842b = rect.left;
        this.f17843c = rect.top;
        this.f17844d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = this.f17842b + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        if (new RectF(left, this.f17843c + viewFindViewById.getTop(), width, viewFindViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        view.performClick();
        return this.f17841a.onTouchEvent(motionEventObtain);
    }
}
