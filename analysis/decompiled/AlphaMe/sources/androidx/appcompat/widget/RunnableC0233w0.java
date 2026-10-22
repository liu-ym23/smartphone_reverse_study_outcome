package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.stepos.alphame.utils.Property;

/* renamed from: androidx.appcompat.widget.w0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0233w0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3190a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractViewOnTouchListenerC0235x0 f3191b;

    public /* synthetic */ RunnableC0233w0(AbstractViewOnTouchListenerC0235x0 abstractViewOnTouchListenerC0235x0, int i4) {
        this.f3190a = i4;
        this.f3191b = abstractViewOnTouchListenerC0235x0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f3190a;
        AbstractViewOnTouchListenerC0235x0 abstractViewOnTouchListenerC0235x0 = this.f3191b;
        switch (i4) {
            case 0:
                ViewParent parent = abstractViewOnTouchListenerC0235x0.f3199d.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                abstractViewOnTouchListenerC0235x0.a();
                View view = abstractViewOnTouchListenerC0235x0.f3199d;
                if (view.isEnabled() && !view.isLongClickable() && abstractViewOnTouchListenerC0235x0.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 0);
                    view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    abstractViewOnTouchListenerC0235x0.f3202g = true;
                    break;
                }
                break;
        }
    }
}
