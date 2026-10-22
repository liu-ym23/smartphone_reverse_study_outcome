package M1;

import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ScrollView;
import e5.c;

/* loaded from: classes.dex */
public class a extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    private final c f3996a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f3997b;

    public boolean a() {
        return this.f3996a.Q();
    }

    @Override // android.widget.ScrollView
    public void fling(int i5) {
        super.fling(i5);
        this.f3996a.C(0, i5);
    }

    public c getSpringAnimationHelper() {
        return this.f3996a;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (!this.f3996a.Y(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        ViewParent parent = getParent();
        if (parent != null && this.f3997b) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    public void setBottomOverScrollEnable(boolean z5) {
        this.f3996a.b0(z5);
    }

    public void setOverScrollEnable(boolean z5) {
        this.f3996a.g0(z5);
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z5) {
        this.f3997b = z5;
    }

    public void setTopOverScrollEnable(boolean z5) {
        this.f3996a.j0(z5);
    }
}
