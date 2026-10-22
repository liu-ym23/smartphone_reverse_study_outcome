package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0533m;

/* loaded from: classes.dex */
public class H extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    public static final b f10809b = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private a f10810a;

    public interface a {
        void a();

        void b();

        void onResume();
    }

    public static final class b {
        public /* synthetic */ b(j4.g gVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Activity activity, AbstractC0533m.a aVar) {
            j4.k.g(activity, "activity");
            j4.k.g(aVar, "event");
            if (activity instanceof InterfaceC0542w) {
                ((InterfaceC0542w) activity).getLifecycle().i(aVar);
            } else if (activity instanceof InterfaceC0539t) {
                AbstractC0533m lifecycle = ((InterfaceC0539t) activity).getLifecycle();
                if (lifecycle instanceof C0541v) {
                    ((C0541v) lifecycle).i(aVar);
                }
            }
        }

        public final void b(Activity activity) {
            j4.k.g(activity, "activity");
            c.Companion.a(activity);
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new H(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }

        private b() {
        }
    }

    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a(null);

        public static final class a {
            public /* synthetic */ a(j4.g gVar) {
                this();
            }

            public final void a(Activity activity) {
                j4.k.g(activity, "activity");
                activity.registerActivityLifecycleCallbacks(new c());
            }

            private a() {
            }
        }

        public static final void registerIn(Activity activity) {
            Companion.a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            j4.k.g(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            j4.k.g(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            j4.k.g(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            j4.k.g(activity, "activity");
            H.f10809b.a(activity, AbstractC0533m.a.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            j4.k.g(activity, "activity");
            H.f10809b.a(activity, AbstractC0533m.a.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            j4.k.g(activity, "activity");
            H.f10809b.a(activity, AbstractC0533m.a.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            j4.k.g(activity, "activity");
            H.f10809b.a(activity, AbstractC0533m.a.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            j4.k.g(activity, "activity");
            H.f10809b.a(activity, AbstractC0533m.a.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            j4.k.g(activity, "activity");
            H.f10809b.a(activity, AbstractC0533m.a.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            j4.k.g(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            j4.k.g(activity, "activity");
            j4.k.g(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            j4.k.g(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            j4.k.g(activity, "activity");
        }
    }

    private final void a(AbstractC0533m.a aVar) {
    }

    private final void b(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    private final void c(a aVar) {
        if (aVar != null) {
            aVar.onResume();
        }
    }

    private final void d(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    public static final void e(Activity activity) {
        f10809b.b(activity);
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f10810a);
        a(AbstractC0533m.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(AbstractC0533m.a.ON_DESTROY);
        this.f10810a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(AbstractC0533m.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c(this.f10810a);
        a(AbstractC0533m.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        d(this.f10810a);
        a(AbstractC0533m.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(AbstractC0533m.a.ON_STOP);
    }
}
