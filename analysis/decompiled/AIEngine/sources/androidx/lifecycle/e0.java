package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class e0 extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2264a = 0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static void a(Activity activity, Lifecycle.Event event) {
            kotlin.jvm.internal.g.f(event, "event");
            if (activity instanceof t) {
                ((t) activity).getLifecycle().f(event);
            } else if (activity instanceof q) {
                Lifecycle lifecycle = ((q) activity).getLifecycle();
                if (lifecycle instanceof s) {
                    ((s) lifecycle).f(event);
                }
            }
        }

        public static void b(Activity activity) {
            b.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new b());
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new e0(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a();

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class a {
        }

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            kotlin.jvm.internal.g.f(activity, "activity");
            activity.registerActivityLifecycleCallbacks(new b());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.g.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            kotlin.jvm.internal.g.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.g.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.g.f(activity, "activity");
            int i10 = e0.f2264a;
            a.a(activity, Lifecycle.Event.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            kotlin.jvm.internal.g.f(activity, "activity");
            int i10 = e0.f2264a;
            a.a(activity, Lifecycle.Event.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            kotlin.jvm.internal.g.f(activity, "activity");
            int i10 = e0.f2264a;
            a.a(activity, Lifecycle.Event.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            kotlin.jvm.internal.g.f(activity, "activity");
            int i10 = e0.f2264a;
            a.a(activity, Lifecycle.Event.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            kotlin.jvm.internal.g.f(activity, "activity");
            int i10 = e0.f2264a;
            a.a(activity, Lifecycle.Event.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            kotlin.jvm.internal.g.f(activity, "activity");
            int i10 = e0.f2264a;
            a.a(activity, Lifecycle.Event.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.g.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.g.f(activity, "activity");
            kotlin.jvm.internal.g.f(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            kotlin.jvm.internal.g.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.g.f(activity, "activity");
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Lifecycle.Event.a aVar = Lifecycle.Event.Companion;
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Lifecycle.Event.a aVar = Lifecycle.Event.Companion;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        Lifecycle.Event.a aVar = Lifecycle.Event.Companion;
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        Lifecycle.Event.a aVar = Lifecycle.Event.Companion;
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        Lifecycle.Event.a aVar = Lifecycle.Event.Companion;
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        Lifecycle.Event.a aVar = Lifecycle.Event.Companion;
    }
}
