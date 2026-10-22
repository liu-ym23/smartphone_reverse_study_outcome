package s1;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: s1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnTouchListenerC0854a implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final Dialog f14224a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14225b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14226c;

    public ViewOnTouchListenerC0854a(Dialog dialog, Rect rect) {
        this.f14224a = dialog;
        this.f14225b = rect.left;
        this.f14226c = rect.top;
        ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = viewFindViewById.getLeft() + this.f14225b;
        int width = viewFindViewById.getWidth() + left;
        if (new RectF(left, viewFindViewById.getTop() + this.f14226c, width, viewFindViewById.getHeight() + r4).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        view.performClick();
        return this.f14224a.onTouchEvent(motionEventObtain);
    }
}
