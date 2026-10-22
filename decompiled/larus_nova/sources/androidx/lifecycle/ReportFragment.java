package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00192\u00020\u0001:\u0003\u0017\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/lifecycle/ReportFragment;", "Landroid/app/Fragment;", "<init>", "()V", "processListener", "Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "dispatchCreate", "", "listener", "dispatchStart", "dispatchResume", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "dispatch", "event", "Landroidx/lifecycle/Lifecycle$Event;", "setProcessListener", "ActivityInitializationListener", "LifecycleCallbacks", "Companion", "lifecycle-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class ReportFragment extends Fragment {
    public static final Companion Companion = null;
    private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    private ActivityInitializationListener processListener;

    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "", WidgetCostModule.TYPE_ON_CREATE, "", WidgetCostModule.TYPE_ON_START, "onResume", "lifecycle-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface ActivityInitializationListener {
        void onCreate();

        void onResume();

        void onStart();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u001d\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\b\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f*\u00020\t8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/lifecycle/ReportFragment$Companion;", "", "<init>", "()V", "REPORT_FRAGMENT_TAG", "", "injectIfNeededIn", "", "activity", "Landroid/app/Activity;", "dispatch", "event", "Landroidx/lifecycle/Lifecycle$Event;", "dispatch$lifecycle_runtime", "reportFragment", "Landroidx/lifecycle/ReportFragment;", "get$annotations", "(Landroid/app/Activity;)V", MonitorConstants.CONNECT_TYPE_GET, "(Landroid/app/Activity;)Landroidx/lifecycle/ReportFragment;", "lifecycle-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void get$annotations(Activity r100) {
        }

        public final ReportFragment get(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Fragment r101 = r100.getFragmentManager().findFragmentByTag(ReportFragment.REPORT_FRAGMENT_TAG);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (ReportFragment) r101;
        }

        @JvmStatic
        public final void injectIfNeededIn(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            if (Build.VERSION.SDK_INT < 29) goto L5;
            LifecycleCallbacks.Companion.registerIn(r100);
        L5:
            FragmentManager r101 = r100.getFragmentManager();
            if (r101.findFragmentByTag(ReportFragment.REPORT_FRAGMENT_TAG) != null) goto L9;
            r101.beginTransaction().add(new ReportFragment(), ReportFragment.REPORT_FRAGMENT_TAG).commit();
            r101.executePendingTransactions();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final void dispatch$lifecycle_runtime(Activity r100, Lifecycle.Event r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "event");
            if ((r100 instanceof LifecycleRegistryOwner) == false) goto L7;
            ((LifecycleRegistryOwner) r100).getLifecycle().handleLifecycleEvent(r101);
            return;
        L7:
            if ((r100 instanceof LifecycleOwner) == false) goto L12;
            Lifecycle r102 = ((LifecycleOwner) r100).getLifecycle();
            if ((r102 instanceof LifecycleRegistry) == false) goto L13;
            ((LifecycleRegistry) r102).handleLifecycleEvent(r101);
            return;
        L13:
            return;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0018"}, d2 = {"Landroidx/lifecycle/ReportFragment$LifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "onActivityPostCreated", "savedInstanceState", "onActivityStarted", "onActivityPostStarted", "onActivityResumed", "onActivityPostResumed", "onActivityPrePaused", "onActivityPaused", "onActivityPreStopped", "onActivityStopped", "onActivitySaveInstanceState", "onActivityPreDestroyed", "onActivityDestroyed", "Companion", "lifecycle-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public static final Companion Companion = null;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Landroidx/lifecycle/ReportFragment$LifecycleCallbacks$Companion;", "", "<init>", "()V", "registerIn", "", "activity", "Landroid/app/Activity;", "lifecycle-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            @JvmStatic
            public final void registerIn(Activity r100) {
                Intrinsics.checkNotNullParameter(r100, "activity");
                r100.registerActivityLifecycleCallbacks(new LifecycleCallbacks());
            }
        }

        static {
            Companion = new Companion(null);
        }

        public LifecycleCallbacks() {
        }

        @JvmStatic
        public static final void registerIn(Activity r100) {
            Companion.registerIn(r100);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime(r100, Lifecycle.Event.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime(r100, Lifecycle.Event.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime(r100, Lifecycle.Event.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime(r100, Lifecycle.Event.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime(r100, Lifecycle.Event.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime(r100, Lifecycle.Event.ON_CREATE);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final void dispatch$lifecycle_runtime(Activity r100, Lifecycle.Event r101) {
        Companion.dispatch$lifecycle_runtime(r100, r101);
    }

    public static final ReportFragment get(Activity r100) {
        return Companion.get(r100);
    }

    @JvmStatic
    public static final void injectIfNeededIn(Activity r100) {
        Companion.injectIfNeededIn(r100);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dispatch(Lifecycle.Event.ON_DESTROY);
        this.processListener = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        dispatch(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        dispatchResume(this.processListener);
        dispatch(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        dispatchStart(this.processListener);
        dispatch(Lifecycle.Event.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        dispatch(Lifecycle.Event.ON_STOP);
    }

    public ReportFragment() {
    }

    private final void dispatch(Lifecycle.Event r100) {
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        Companion.dispatch$lifecycle_runtime(getActivity(), r100);
        return;
    }

    private final void dispatchCreate(ActivityInitializationListener r100) {
        if (r100 == null) goto L5;
        r100.onCreate();
        return;
    }

    private final void dispatchResume(ActivityInitializationListener r100) {
        if (r100 == null) goto L5;
        r100.onResume();
        return;
    }

    private final void dispatchStart(ActivityInitializationListener r100) {
        if (r100 == null) goto L5;
        r100.onStart();
        return;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        dispatchCreate(this.processListener);
        dispatch(Lifecycle.Event.ON_CREATE);
    }

    public final void setProcessListener(ActivityInitializationListener r100) {
        this.processListener = r100;
    }
}
