package av;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.gamecp.common.track.monitor.page.GPFragmentLifeCycleListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f16341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f16342d;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f16341c.a(r100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f16341c.b(r100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f16341c.d(r100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        int r101 = this.f16339a + 1;
        this.f16339a = r101;
        if (this.f16340b == true) goto L9;
        if (r101 <= 0) goto L10;
        this.f16340b = true;
        a r102 = this.f16342d;
        if (r102 == null) goto L11;
        r100.getApplicationContext();
        r102.c();
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        int r101 = this.f16339a - 1;
        this.f16339a = r101;
        if (this.f16340b == false) goto L9;
        if (r101 > 0) goto L10;
        this.f16340b = false;
        a r102 = this.f16342d;
        if (r102 == null) goto L11;
        r100.getApplicationContext();
        r102.c();
        return;
    L11:
        return;
    L10:
        return;
    }

    public b(e r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "pageLifeCycle");
        this.f16341c = r100;
        this.f16342d = r101;
        this.f16339a = 1;
        this.f16340b = true;
        boolean r102 = com.bytedance.android.gamecp.common.utils.e.a();
        this.f16340b = r102;
        this.f16339a = r102 ? 1 : 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if ((r100 instanceof FragmentActivity) == true) goto L5;
        r100 = null;
    L5:
        FragmentActivity r102 = (FragmentActivity) r100;
        if (r102 == null) goto L11;
        FragmentManager r103 = r102.getSupportFragmentManager();
        if (r103 == null) goto L12;
        r103.registerFragmentLifecycleCallbacks(new GPFragmentLifeCycleListener(this.f16341c), true);
        return;
    L12:
        return;
    }
}
