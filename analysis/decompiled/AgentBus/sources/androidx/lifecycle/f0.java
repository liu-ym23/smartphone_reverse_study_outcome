package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/lifecycle/f0;", "Landroid/app/Fragment;", "<init>", "()V", "a", "androidx/lifecycle/d0", "lifecycle-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class f0 extends Fragment {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f993f = 0;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public static final e0 Companion = new e0();

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            q7.k.e(activity, "activity");
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            q7.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            q7.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            q7.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            q7.k.e(activity, "activity");
            int i2 = f0.f993f;
            d0.a(activity, p.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            q7.k.e(activity, "activity");
            int i2 = f0.f993f;
            d0.a(activity, p.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            q7.k.e(activity, "activity");
            int i2 = f0.f993f;
            d0.a(activity, p.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            q7.k.e(activity, "activity");
            int i2 = f0.f993f;
            d0.a(activity, p.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            q7.k.e(activity, "activity");
            int i2 = f0.f993f;
            d0.a(activity, p.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            q7.k.e(activity, "activity");
            int i2 = f0.f993f;
            d0.a(activity, p.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            q7.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            q7.k.e(activity, "activity");
            q7.k.e(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            q7.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            q7.k.e(activity, "activity");
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        n nVar = p.Companion;
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        n nVar = p.Companion;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        n nVar = p.Companion;
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        n nVar = p.Companion;
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        n nVar = p.Companion;
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        n nVar = p.Companion;
    }
}
