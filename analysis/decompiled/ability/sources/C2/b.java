package C2;

import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.apm.agent.v2.instrumentation.FragmentTimeAgent;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Integer f283a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public b(long j5, Integer num, String str) {
        this.f283a = num;
        this.b = j5;
        this.c = str;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        try {
            if (FragmentTimeAgent.sRootViewRef != null && FragmentTimeAgent.sRootViewRef.get() != null) {
                View viewFindViewById = ((View) FragmentTimeAgent.sRootViewRef.get()).findViewById(this.f283a.intValue());
                if (FragmentTimeAgent.sCheckVisibilityStartTime == 0) {
                    long unused = FragmentTimeAgent.sCheckVisibilityStartTime = System.currentTimeMillis();
                }
                if (viewFindViewById == null || viewFindViewById.getVisibility() != 0 || viewFindViewById.getWidth() <= 0) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (((View) FragmentTimeAgent.sRootViewRef.get()).getViewTreeObserver().isAlive() && FragmentTimeAgent.sOnGlobalLayoutListener != null) {
                    ((View) FragmentTimeAgent.sRootViewRef.get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentTimeAgent.sOnGlobalLayoutListener);
                }
                ViewTreeObserver.OnGlobalLayoutListener unused2 = FragmentTimeAgent.sOnGlobalLayoutListener = null;
                WeakReference unused3 = FragmentTimeAgent.sRootViewRef = null;
                if (FragmentTimeAgent.sWaitViewTimeoutRunnable != null) {
                    L0.a.f923a.removeCallbacks(FragmentTimeAgent.sWaitViewTimeoutRunnable);
                }
                long j5 = jCurrentTimeMillis - this.b;
                if (jCurrentTimeMillis - FragmentTimeAgent.sCheckVisibilityStartTime <= 1 || j5 >= FragmentTimeAgent.sMaxWaitTime) {
                    return;
                }
                FragmentTimeAgent.reportTraceTime(FragmentTimeAgent.sFragmentName, this.c, this.b, jCurrentTimeMillis);
            }
        } catch (Exception unused4) {
        }
    }
}
