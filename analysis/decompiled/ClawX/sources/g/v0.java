package g;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class v0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2846a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f.a f2847b;

    public /* synthetic */ v0(f.a aVar, int i8) {
        this.f2846a = i8;
        this.f2847b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2846a) {
            case 0:
                ViewParent parent = this.f2847b.d.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                f.a aVar = this.f2847b;
                aVar.a();
                View view = aVar.d;
                if (view.isEnabled() && !view.isLongClickable() && aVar.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    aVar.f2412g = true;
                    break;
                }
                break;
        }
    }
}
