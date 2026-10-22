package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ReportFragment extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3473b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActivityInitializationListener f3474a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "", "onCreate", "", "onResume", "onStart", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ActivityInitializationListener {
        void onCreate();

        void onResume();

        void onStart();
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Activity r10, Lifecycle.Event r11) {
            kotlin.jvm.internal.q.g(r10, "activity");
            kotlin.jvm.internal.q.g(r11, "event");
            if ((r10 instanceof LifecycleRegistryOwner) == false) goto L7;
            ((LifecycleRegistryOwner) r10).getLifecycle().handleLifecycleEvent(r11);
            return;
        L7:
            if ((r10 instanceof LifecycleOwner) == false) goto L12;
            Lifecycle r12 = ((LifecycleOwner) r10).getLifecycle();
            if ((r12 instanceof LifecycleRegistry) == false) goto L13;
            ((LifecycleRegistry) r12).handleLifecycleEvent(r11);
            return;
        L13:
            return;
        }

        public final void b(Activity r10) {
            kotlin.jvm.internal.q.g(r10, "activity");
            b.Companion.a(r10);
            FragmentManager r11 = r10.getFragmentManager();
            if (r11.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") != null) goto L6;
            r11.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            r11.executePendingTransactions();
            return;
        }

        public a() {
        }
    }

    public static final class b implements Application.ActivityLifecycleCallbacks {

        @NotNull
        public static final a Companion = null;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public final void a(Activity r10) {
                kotlin.jvm.internal.q.g(r10, "activity");
                r10.registerActivityLifecycleCallbacks(new b());
            }

            public a() {
            }
        }

        static {
            Companion = new a(null);
        }

        public b() {
        }

        @JvmStatic
        public static final void registerIn(@NotNull Activity r10) {
            Companion.a(r10);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity r10, @Nullable Bundle r11) {
            kotlin.jvm.internal.q.g(r10, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity r10) {
            kotlin.jvm.internal.q.g(r10, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity r10) {
            kotlin.jvm.internal.q.g(r10, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(@NotNull Activity r10, @Nullable Bundle r11) {
            kotlin.jvm.internal.q.g(r10, "activity");
            ReportFragment.f3473b.a(r10, Lifecycle.Event.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(@NotNull Activity r10) {
            kotlin.jvm.internal.q.g(r10, "activity");
            ReportFragment.f3473b.a(r10, Lifecycle.Event.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(@NotNull Activity r10) {
            kotlin.jvm.internal.q.g(r10, "activity");
            ReportFragment.f3473b.a(r10, Lifecycle.Event.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(@NotNull Activity r10) {
            kotlin.jvm.internal.q.g(r10, "activity");
            ReportFragment.f3473b.a(r10, Lifecycle.Event.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(@NotNull Activity r10) {
            kotlin.jvm.internal.q.g(r10, "activity");
            ReportFragment.f3473b.a(r10, Lifecycle.Event.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(@NotNull Activity r10) {
            kotlin.jvm.internal.q.g(r10, "activity");
            ReportFragment.f3473b.a(r10, Lifecycle.Event.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity r10) {
            kotlin.jvm.internal.q.g(r10, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity r10, @NotNull Bundle r11) {
            kotlin.jvm.internal.q.g(r10, "activity");
            kotlin.jvm.internal.q.g(r11, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity r10) {
            kotlin.jvm.internal.q.g(r10, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity r10) {
            kotlin.jvm.internal.q.g(r10, "activity");
        }
    }

    static {
        f3473b = new a(null);
    }

    public ReportFragment() {
    }

    public static final void d(Activity r10) {
        f3473b.b(r10);
    }

    private final void dispatch(Lifecycle.Event r10) {
    }

    public final void a(ActivityInitializationListener r10) {
        if (r10 == null) goto L5;
        r10.onCreate();
        return;
    }

    public final void b(ActivityInitializationListener r10) {
        if (r10 == null) goto L5;
        r10.onResume();
        return;
    }

    public final void c(ActivityInitializationListener r10) {
        if (r10 == null) goto L5;
        r10.onStart();
        return;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle r10) {
        super.onActivityCreated(r10);
        a(this.f3474a);
        dispatch(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dispatch(Lifecycle.Event.ON_DESTROY);
        this.f3474a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        dispatch(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        b(this.f3474a);
        dispatch(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        c(this.f3474a);
        dispatch(Lifecycle.Event.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        dispatch(Lifecycle.Event.ON_STOP);
    }
}
