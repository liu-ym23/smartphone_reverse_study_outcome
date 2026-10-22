package e2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class b implements IActivityLifeObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f19270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f19272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f19273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f19274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f19275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f19276g;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f19277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Integer f19278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f19279c;

        public a(b r10, WeakReference r11, Integer r12) {
            this.f19279c = r10;
            this.f19277a = r11;
            this.f19278b = r12;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f19277a.get() != null) goto L5;
            return;
        L5:
            View r10 = ((View) this.f19277a.get()).findViewById(this.f19278b.intValue());
            if (r10 != null) goto L8;
            return;
        L8:
            if (r10.getVisibility() == 0) goto L10;
            return;
        L10:
            if (r10.getWidth() <= 0) goto L29;
            ViewTreeObserver r11 = ((View) this.f19277a.get()).getViewTreeObserver();
            if (r11.isAlive() == false) goto L17;
            if (b.a(this.f19279c) == null) goto L17;
            r11.removeOnGlobalLayoutListener(b.a(this.f19279c));
        L17:
            if (b.c(this.f19279c) == null) goto L19;
            b.e(this.f19279c).removeCallbacks(b.c(this.f19279c));
            b.d(this.f19279c, null);
        L19:
            b.b(this.f19279c, null);
            if (b.f(this.f19279c) <= 0) goto L30;
            long r12 = System.currentTimeMillis();
            long r13 = r12 - b.f(this.f19279c);
            b.g(this.f19279c, 0);
            if (r13 < b.h(this.f19279c)) goto L24;
            return;
        L24:
            if (r13 <= 0) goto L32;
            AutoPageTraceHelper.reportViewIdStats(r12, b.i(this.f19279c));
            MonitorTool.reportTraceTime(b.i(this.f19279c), "activityOnCreateToViewShow", r13);
            return;
        L32:
            return;
        L30:
            return;
        }
    }

    /* JADX INFO: renamed from: e2.b$b, reason: collision with other inner class name */
    public class RunnableC0238b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f19280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f19281b;

        public RunnableC0238b(b r10, WeakReference r11) {
            this.f19281b = r10;
            this.f19280a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.a(this.f19281b) != null) goto L5;
            return;
        L5:
            if (this.f19280a.get() == null) goto L9;
            ((View) this.f19280a.get()).getViewTreeObserver().removeOnGlobalLayoutListener(b.a(this.f19281b));
            return;
        }
    }

    public b() {
        this.f19270a = -1;
        this.f19274e = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener a(b r10) {
        return r10.f19272c;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener b(b r10, ViewTreeObserver.OnGlobalLayoutListener r11) {
        r10.f19272c = r11;
        return r11;
    }

    public static /* synthetic */ Runnable c(b r10) {
        return r10.f19273d;
    }

    public static /* synthetic */ Runnable d(b r10, Runnable r11) {
        r10.f19273d = r11;
        return r11;
    }

    public static /* synthetic */ Handler e(b r10) {
        return r10.f19274e;
    }

    public static /* synthetic */ long f(b r10) {
        return r10.f19270a;
    }

    public static /* synthetic */ long g(b r10, long r11) {
        r10.f19270a = r11;
        return r11;
    }

    public static /* synthetic */ long h(b r10) {
        return r10.f19275f;
    }

    public static /* synthetic */ String i(b r10) {
        return r10.f19271b;
    }

    public final void j(Activity r10) {
        this.f19270a = System.currentTimeMillis();
        String r11 = r10.getClass().getCanonicalName();
        this.f19271b = r11;
        Integer r12 = h2.a.c(r11);
        if (r12 != null) goto L5;
        return;
    L5:
        WeakReference r13 = new WeakReference(r10.getWindow().getDecorView());
        this.f19272c = new a(this, r13, r12);
        ((View) r13.get()).getViewTreeObserver().addOnGlobalLayoutListener(this.f19272c);
        RunnableC0238b r14 = new RunnableC0238b(this, r13);
        this.f19273d = r14;
        this.f19274e.postDelayed(r14, this.f19275f);
    }

    public void k(long r10, boolean r11) {
        this.f19275f = r10;
        this.f19276g = r11;
        ActivityLifeObserver.getInstance().register(this);
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityCreated(Activity r10, Bundle r11) {
        if (this.f19276g == true) goto L8;
        return;
    L8:
        j(r10);     // Catch: Exception -> L7
        return;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityPause(Activity r10) {
        this.f19270a = 0;
        if (this.f19272c == null) goto L6;
        r10.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f19272c);     // Catch: Exception -> L10
        this.f19272c = null;     // Catch: Exception -> L10
    L6:
        Runnable r11 = this.f19273d;     // Catch: Exception -> L10
        if (r11 == null) goto L13;
        this.f19274e.removeCallbacks(r11);     // Catch: Exception -> L10
        this.f19273d = null;     // Catch: Exception -> L10
        return;
    L13:
        return;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityResume(Activity r10) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityStarted(Activity r10) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r10) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onChange(Activity r10, Fragment r11) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r10) {
    }
}
