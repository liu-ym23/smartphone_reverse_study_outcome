package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import com.volcengine.zeus.fragment.ReportBaseFragment;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ReportFragment.kt */
/* JADX INFO: loaded from: classes.dex */
public class ReportFragment extends ReportBaseFragment {
    public static final b Companion = null;
    private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_zeus_com_obric_aiagent_plugin";
    private a processListener;

    /* JADX INFO: compiled from: ReportFragment.kt */
    public static final class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = null;

        /* JADX INFO: compiled from: ReportFragment.kt */
        public static final class a {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            private a() {
            }

            public final void a(Activity r3) {
                Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r2, "activity");
                r2.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) ZeusTransformUtils.preCheckCast(new LifecycleCallbacks(), Application.ActivityLifecycleCallbacks.class, "com.obric.aiagent.plugin"));
            }
        }

        static {
            Companion = new a(null);
        }

        public static final void registerIn(Activity r2) {
            Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            Companion.a(r3);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
            d.h.b.o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin"), "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r2) {
            d.h.b.o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r2) {
            d.h.b.o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r2) {
            d.h.b.o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            d.h.b.o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
            d.h.b.o.e(r3, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r2) {
            d.h.b.o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r2) {
            d.h.b.o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
        }

        public LifecycleCallbacks() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity r1, Bundle r2) {
            Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r0, "activity");
            ReportFragment.Companion.a(r0, i.a.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "activity");
            ReportFragment.Companion.a(r1, i.a.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "activity");
            ReportFragment.Companion.a(r1, i.a.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "activity");
            ReportFragment.Companion.a(r1, i.a.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "activity");
            ReportFragment.Companion.a(r1, i.a.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "activity");
            ReportFragment.Companion.a(r1, i.a.ON_DESTROY);
        }
    }

    /* JADX INFO: compiled from: ReportFragment.kt */
    public interface a {
        void a();

        void b();

        void c();
    }

    /* JADX INFO: compiled from: ReportFragment.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public final void a(Activity r5) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "activity");
            if (Build.VERSION.SDK_INT < 29) goto L5;
            LifecycleCallbacks.Companion.a(r4);
        L5:
            FragmentManager r6 = r4.getFragmentManager();
            if (r6.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") != null) goto L9;
            r6.beginTransaction().add((Fragment) ZeusTransformUtils.preCheckCast(new ReportFragment(), Fragment.class, "com.obric.aiagent.plugin"), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            r6.executePendingTransactions();
            return;
        }

        public final void a(Activity r2, i.a r3) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "activity");
            d.h.b.o.e(r3, "event");
            if (ZeusTransformUtils.instanceOf(r1, s.class) == false) goto L7;
            ((s) ZeusTransformUtils.preCheckCast(r1, s.class, "com.obric.aiagent.plugin")).a().a(r3);
            return;
        L7:
            if (ZeusTransformUtils.instanceOf(r1, p.class) == false) goto L12;
            i r4 = ((p) ZeusTransformUtils.preCheckCast(r1, p.class, "com.obric.aiagent.plugin")).getLifecycle();
            if (ZeusTransformUtils.instanceOf(r4, r.class) == false) goto L13;
            ((r) ZeusTransformUtils.preCheckCast(r4, r.class, "com.obric.aiagent.plugin")).a(r3);
            return;
        L13:
            return;
        }

        public final ReportFragment b(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "<this>");
            Fragment r3 = r1.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            d.h.b.o.a(r3, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (ReportFragment) ZeusTransformUtils.preCheckCast(r3, ReportFragment.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = new b(null);
    }

    public static final void dispatch$lifecycle_runtime_release(Activity r2, i.a r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        Companion.a(r4, r3);
    }

    public static final ReportFragment get(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        return Companion.b(r3);
    }

    public static final void injectIfNeededIn(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        Companion.a(r3);
    }

    public ReportFragment() {
    }

    private final void dispatchCreate(a r2) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.a();
        return;
    }

    private final void dispatchStart(a r2) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.b();
        return;
    }

    private final void dispatchResume(a r2) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.c();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityCreated(Bundle r1) {
        super/*android.app.Fragment*/.onActivityCreated(r1);
        dispatchCreate(this.processListener);
        dispatch(i.a.ON_CREATE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onStart() {
        super/*android.app.Fragment*/.onStart();
        dispatchStart(this.processListener);
        dispatch(i.a.ON_START);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        super/*android.app.Fragment*/.onResume();
        dispatchResume(this.processListener);
        dispatch(i.a.ON_RESUME);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPause() {
        super/*android.app.Fragment*/.onPause();
        dispatch(i.a.ON_PAUSE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onStop() {
        super/*android.app.Fragment*/.onStop();
        dispatch(i.a.ON_STOP);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Fragment*/.onDestroy();
        dispatch(i.a.ON_DESTROY);
        this.processListener = null;
    }

    private final void dispatch(i.a r3) {
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        b r0 = Companion;
        Activity r2 = ZeusTransformUtils.getActivity(this, "com.obric.aiagent.plugin");
        d.h.b.o.c(r2, "activity");
        r0.a(r2, r3);
        return;
    }

    public final void setProcessListener(a r3) {
        this.processListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }
}
