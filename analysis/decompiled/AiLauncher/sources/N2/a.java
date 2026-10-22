package N2;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes2.dex */
public class a implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final Dialog f4788a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4789b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4790c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4791d;

    public a(Dialog dialog, Rect rect) {
        this.f4788a = dialog;
        this.f4789b = rect.left;
        this.f4790c = rect.top;
        this.f4791d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = this.f4789b + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        if (new RectF(left, this.f4790c + viewFindViewById.getTop(), width, viewFindViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        view.performClick();
        return this.f4788a.onTouchEvent(motionEventObtain);
    }
}
