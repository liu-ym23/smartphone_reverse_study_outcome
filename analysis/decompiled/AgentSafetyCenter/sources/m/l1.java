package m;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l1 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7987c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ m1 f7988f;

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7987c) {
            case 0:
                ViewParent parent = this.f7988f.f8005h.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                m1 m1Var = this.f7988f;
                m1Var.a();
                View view = m1Var.f8005h;
                if (view.isEnabled() && !view.isLongClickable() && m1Var.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    m1Var.f8007k = true;
                    break;
                }
                break;
        }
    }
}
