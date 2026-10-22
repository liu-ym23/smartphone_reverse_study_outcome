package androidx.activity;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements ContextAware, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnNewIntentProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, MenuHost, FullyDrawnReporterOwner {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final ContextAwareHelper mContextAwareHelper;
    private ViewModelProvider.Factory mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final FullyDrawnReporter mFullyDrawnReporter;
    private final LifecycleRegistry mLifecycleRegistry;
    private final MenuHostHelper mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<Consumer<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Integer>> mOnTrimMemoryListeners;
    final ReportFullyDrawnExecutor mReportFullyDrawnExecutor;
    final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    /* JADX INFO: loaded from: classes2.dex */
    public static class Api19Impl {
        private Api19Impl() {
        }

        public static void cancelPendingInputEvents(View r100) {
            r100.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static class Api33Impl {
        private Api33Impl() {
        }

        public static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity r100) {
            return r100.getOnBackInvokedDispatcher();
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class NonConfigurationInstances {
        Object custom;
        ViewModelStore viewModelStore;

        public NonConfigurationInstances() {
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface ReportFullyDrawnExecutor extends Executor {
        void activityDestroyed();

        void viewCreated(View r100);
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static class ReportFullyDrawnExecutorApi1 implements ReportFullyDrawnExecutor {
        final Handler mHandler;

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void activityDestroyed() {
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void viewCreated(View r100) {
        }

        public ReportFullyDrawnExecutorApi1() {
            this.mHandler = createHandler();
        }

        private Handler createHandler() {
            Looper r100 = Looper.myLooper();
            if (r100 != null) goto L6;
            r100 = Looper.getMainLooper();
        L6:
            return new Handler(r100);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            this.mHandler.postAtFrontOfQueue(r100);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class ReportFullyDrawnExecutorApi16Impl implements ReportFullyDrawnExecutor, ViewTreeObserver.OnDrawListener, Runnable {
        final long mEndWatchTimeMillis;
        boolean mOnDrawScheduled;
        Runnable mRunnable;
        final /* synthetic */ ComponentActivity this$0;

        public static /* synthetic */ void a(ReportFullyDrawnExecutorApi16Impl r100) {
            r100.lambda$execute$0();
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        private /* synthetic */ void lambda$execute$0() {
            Runnable r100 = this.mRunnable;
            if (r100 == null) goto L6;
            r100.run();
            this.mRunnable = null;
            return;
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void activityDestroyed() {
            INVOKEVIRTUAL_androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.this$0.getWindow()).removeCallbacks(this);
            INVOKEVIRTUAL_androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.this$0.getWindow()).getViewTreeObserver().removeOnDrawListener(this);
        }

        public void androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl__run$___twin___() {
            INVOKEVIRTUAL_androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.this$0.getWindow()).getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable r100 = this.mRunnable;
            if (r100 == null) goto L8;
            r100.run();
            this.mRunnable = null;
            if (this.this$0.mFullyDrawnReporter.isFullyDrawnReported() == false) goto L11;
            this.mOnDrawScheduled = false;
            INVOKEVIRTUAL_androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.this$0.getWindow()).post(this);
            return;
        L11:
            return;
        L8:
            if (SystemClock.uptimeMillis() <= this.mEndWatchTimeMillis) goto L13;
            this.mOnDrawScheduled = false;
            INVOKEVIRTUAL_androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.this$0.getWindow()).post(this);
            return;
        }

        public ReportFullyDrawnExecutorApi16Impl(ComponentActivity r100) {
            this.this$0 = r100;
            this.mEndWatchTimeMillis = SystemClock.uptimeMillis() + 10000;
            this.mOnDrawScheduled = false;
        }

        public static View INVOKEVIRTUAL_androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
            View r101 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L7:
            return r101;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_apm_impl_protector_RunnableLancet_run(ReportFullyDrawnExecutorApi16Impl r100) {
            r100.androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            this.mRunnable = r100;
            View r101 = INVOKEVIRTUAL_androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.this$0.getWindow());
            if (this.mOnDrawScheduled == true) goto L5;
            r101.postOnAnimation(new e(this));
            return;
        L5:
            if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
            r101.invalidate();
            return;
        L7:
            r101.postInvalidate();
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void viewCreated(View r100) {
            if (this.mOnDrawScheduled == true) goto L6;
            this.mOnDrawScheduled = true;
            r100.getViewTreeObserver().addOnDrawListener(this);
            return;
        }
    }

    public static /* synthetic */ void access$000(androidx.core.app.ComponentActivity r100, Configuration r101) {
        super.onConfigurationChanged(r101);
    }

    public static /* synthetic */ Bundle t1(ComponentActivity r100) {
        return r100.lambda$new$1();
    }

    public static /* synthetic */ void u1(ComponentActivity r100, Context r101) {
        r100.lambda$new$2(r101);
    }

    public static /* synthetic */ Unit v1(ComponentActivity r100) {
        return r100.lambda$new$0();
    }

    public void androidx_activity_ComponentActivity__finish$___twin___() {
        super.finish();
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        androidx_activity_ComponentActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r100) {
        androidx_activity_ComponentActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r100);
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    private ReportFullyDrawnExecutor createFullyDrawnExecutor() {
        return new ReportFullyDrawnExecutorApi16Impl(this);
    }

    private /* synthetic */ Bundle lambda$new$1() {
        Bundle r100 = new Bundle();
        this.mActivityResultRegistry.onSaveInstanceState(r100);
        return r100;
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore != null) goto L11;
        NonConfigurationInstances r100 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r100 == null) goto L8;
        this.mViewModelStore = r100.viewModelStore;
    L8:
        if (this.mViewModelStore != null) goto L12;
        this.mViewModelStore = new ViewModelStore();
        return;
    L12:
        return;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras r100 = new MutableCreationExtras();
        if (getApplication() == null) goto L5;
        r100.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, getApplication());
    L5:
        r100.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        r100.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getIntent() != null) goto L8;
    L10:
        return r100;
    L8:
        if (getIntent().getExtras() == null) goto L10;
        r100.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getIntent().getExtras());
        goto L10
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory != null) goto L10;
        Application r100 = getApplication();
        if (getIntent() == null) goto L7;
        Bundle r101 = getIntent().getExtras();
    L8:
        this.mDefaultFactory = new SavedStateViewModelFactory(r100, this, r101);
        goto L10
    L7:
        r101 = null;
    L10:
        return this.mDefaultFactory;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher != null) goto L6;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new AnonymousClass5(this));
        getLifecycle().addObserver(new AnonymousClass6(this));
    L6:
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Override // androidx.activity.contextaware.ContextAware
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.peekAvailableContext();
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new ContextAwareHelper();
        this.mMenuHostHelper = new MenuHostHelper(new a(this));
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController r100 = SavedStateRegistryController.create(this);
        this.mSavedStateRegistryController = r100;
        this.mOnBackPressedDispatcher = null;
        ReportFullyDrawnExecutor r101 = createFullyDrawnExecutor();
        this.mReportFullyDrawnExecutor = r101;
        this.mFullyDrawnReporter = new FullyDrawnReporter(r101, new b(this));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new AnonymousClass1(this);
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) goto L10;
        int r102 = Build.VERSION.SDK_INT;
        getLifecycle().addObserver(new AnonymousClass2(this));
        getLifecycle().addObserver(new AnonymousClass3(this));
        getLifecycle().addObserver(new AnonymousClass4(this));
        r100.performAttach();
        SavedStateHandleSupport.enableSavedStateHandles(this);
        if (r102 > 23) goto L7;
        getLifecycle().addObserver(new ImmLeaksCleaner(this));
    L7:
        getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, new c(this));
        addOnContextAvailableListener(new d(this));
        return;
    L10:
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    private /* synthetic */ Unit lambda$new$0() {
        reportFullyDrawn();
        return null;
    }

    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances r100 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.custom;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (getApplication() == null) goto L7;
        ensureViewModelStore();
        return this.mViewModelStore;
    L7:
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void initializeViewTreeOwners() {
        ViewTreeLifecycleOwner.set(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
        ViewTreeViewModelStoreOwner.set(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
        ViewTreeSavedStateRegistryOwner.set(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
        ViewTreeOnBackPressedDispatcherOwner.set(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
        ViewTreeFullyDrawnReporterOwner.set(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        getOnBackPressedDispatcher().onBackPressed();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        Object r100 = onRetainCustomNonConfigurationInstance();
        ViewModelStore r101 = this.mViewModelStore;
        if (r101 != null) goto L7;
        NonConfigurationInstances r102 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r102 == null) goto L7;
        r101 = r102.viewModelStore;
    L7:
        if (r101 != null) goto L11;
        if (r100 != null) goto L11;
        return null;
    L11:
        NonConfigurationInstances r103 = new NonConfigurationInstances();
        r103.custom = r100;
        r103.viewModelStore = r101;
        return r103;
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
    L8:
        th = move-exception;
        Trace.endSection();
        throw th;
    L3:
        if (Trace.isEnabled() == false) goto L5;
        Trace.beginSection("reportFullyDrawn() for ComponentActivity");     // Catch: Throwable -> L8
    L5:
        super.reportFullyDrawn();     // Catch: Throwable -> L8
        this.mFullyDrawnReporter.fullyDrawnReported();     // Catch: Throwable -> L8
        Trace.endSection();
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.activity.FullyDrawnReporterOwner
    public FullyDrawnReporter getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.core.view.MenuHost
    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    public ComponentActivity(int r100) {
        this();
        this.mContentLayoutId = r100;
    }

    public static View INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static /* synthetic */ void access$001(ComponentActivity r100) {
        super.onBackPressed();
    }

    public static /* synthetic */ OnBackPressedDispatcher access$100(ComponentActivity r100) {
        return r100.mOnBackPressedDispatcher;
    }

    public static void androidx_activity_ComponentActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(ComponentActivity r110) {
        r110.androidx_activity_ComponentActivity__finish$___twin___();
        if ((r110 instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((r110 instanceof ChatWindowActivity) == false) goto L8;
        return;
    L8:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(r110.getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(r110);     // Catch: Throwable -> L53
        if (r103 != null) goto L13;
    L16:
        r102.put(r110, Long.valueOf(r101));     // Catch: Throwable -> L53
        monitor-exit(r102);     // Catch: Throwable -> L53
    L50:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L19:
        if (((FragmentActivity) r110).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L23;
        r100.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) r110).getLifecycle().getCurrentState());     // Catch: Throwable -> L50
        return;
    L23:
        if (r110.isFinishing() == true) goto L27;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L50
        return;
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(r110) == true) goto L31;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L50
        return;
    L31:
        if (ActivityLancet.isOnlyActivityInTask(r110) == true) goto L35;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L50
        return;
    L35:
        if (ActivityLancet.isExcludedActivity(r110) == false) goto L39;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L50
        return;
    L39:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L41;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L50
        return;
    L41:
        Intent r104 = r110.getPackageManager().getLaunchIntentForPackage(r110.getPackageName());     // Catch: Throwable -> L50
        if (r104 != null) goto L44;
        return;
    L44:
        r104.addFlags(268435456);     // Catch: Throwable -> L50
        r104.addFlags(2097152);     // Catch: Throwable -> L50
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r110);     // Catch: Throwable -> L50
        r110.startActivity(r104);     // Catch: Throwable -> L47
        r110.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L47
    L61:
        return;
    L47:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L50
        return;
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L53
        return;
    L53:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$2(Context r100) {
        Bundle r101 = getSavedStateRegistry().consumeRestoredStateForKey(ACTIVITY_RESULT_TAG);
        if (r101 == null) goto L6;
        this.mActivityResultRegistry.onRestoreInstanceState(r101);
        return;
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider r100) {
        this.mMenuHostHelper.addMenuProvider(r100);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(Consumer<Configuration> r100) {
        this.mOnConfigurationChangedListeners.add(r100);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void addOnContextAvailableListener(OnContextAvailableListener r100) {
        this.mContextAwareHelper.addOnContextAvailableListener(r100);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void addOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> r100) {
        this.mOnMultiWindowModeChangedListeners.add(r100);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void addOnNewIntentListener(Consumer<Intent> r100) {
        this.mOnNewIntentListeners.add(r100);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void addOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> r100) {
        this.mOnPictureInPictureModeChangedListeners.add(r100);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(Consumer<Integer> r100) {
        this.mOnTrimMemoryListeners.add(r100);
    }

    public void androidx_activity_ComponentActivity__onCreate$___twin___(Bundle r100) {
        this.mSavedStateRegistryController.performRestore(r100);
        this.mContextAwareHelper.dispatchOnContextAvailable(this);
        super.onCreate(r100);
        ReportFragment.injectIfNeededIn(this);
        int r101 = this.mContentLayoutId;
        if (r101 == 0) goto L6;
        setContentView(r101);
        return;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        INVOKESPECIAL_androidx_activity_ComponentActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r100);
        Iterator<Consumer<Configuration>> r101 = this.mOnConfigurationChangedListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().accept(r100);
        goto L4
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean r100) {
        if (this.mDispatchingOnMultiWindowModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<MultiWindowModeChangedInfo>> r101 = this.mOnMultiWindowModeChangedListeners.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().accept(new MultiWindowModeChangedInfo(r100));
        goto L7
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent r100) {
        super.onNewIntent(r100);
        Iterator<Consumer<Intent>> r101 = this.mOnNewIntentListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().accept(r100);
        goto L4
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean r100) {
        if (this.mDispatchingOnPictureInPictureModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<PictureInPictureModeChangedInfo>> r101 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().accept(new PictureInPictureModeChangedInfo(r100));
        goto L7
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle r100) {
        Lifecycle r101 = getLifecycle();
        if ((r101 instanceof LifecycleRegistry) == false) goto L5;
        ((LifecycleRegistry) r101).setCurrentState(Lifecycle.State.CREATED);
    L5:
        super.onSaveInstanceState(r100);
        this.mSavedStateRegistryController.performSave(r100);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int r100) {
        super.onTrimMemory(r100);
        Iterator<Consumer<Integer>> r101 = this.mOnTrimMemoryListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().accept(Integer.valueOf(r100));
        goto L4
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(MenuProvider r100) {
        this.mMenuHostHelper.removeMenuProvider(r100);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(Consumer<Configuration> r100) {
        this.mOnConfigurationChangedListeners.remove(r100);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void removeOnContextAvailableListener(OnContextAvailableListener r100) {
        this.mContextAwareHelper.removeOnContextAvailableListener(r100);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void removeOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> r100) {
        this.mOnMultiWindowModeChangedListeners.remove(r100);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void removeOnNewIntentListener(Consumer<Intent> r100) {
        this.mOnNewIntentListeners.remove(r100);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void removeOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> r100) {
        this.mOnPictureInPictureModeChangedListeners.remove(r100);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(Consumer<Integer> r100) {
        this.mOnTrimMemoryListeners.remove(r100);
    }

    @Override // android.app.Activity
    public void setContentView(int r100) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()));
        super.setContentView(r100);
    }

    @Override // android.app.Activity
    public void setContentView(View r100) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()));
        super.setContentView(r100);
    }

    public static void INVOKESPECIAL_androidx_activity_ComponentActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(androidx.core.app.ComponentActivity r100, Configuration r101) {
        access$000(r100, r101);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L22;
        int r102 = r100.getRequestedOrientation();     // Catch: Throwable -> L17
        if (r101 == null) goto L8;
        Integer r103 = Integer.valueOf(r101.orientation);     // Catch: Throwable -> L17
    L9:
        if (r103 != null) goto L12;
    L14:
        if (r102 != 3) goto L24;
        r100.setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:" + r100.getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L12:
        if (r103.intValue() != r102) goto L14;
        return;
    L8:
        r103 = null;
        goto L9
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
    }

    public static void androidx_activity_ComponentActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(ComponentActivity r100, Bundle r101) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(r100.getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(r100) == false) goto L8;
        v19.f.c(r100.getTheme());     // Catch: Throwable -> L10
    L8:
        r100.androidx_activity_ComponentActivity__onCreate$___twin___(r101);
    }

    @Override // android.app.Activity
    public void addContentView(View r100, ViewGroup.LayoutParams r101) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()));
        super.addContentView(r100, r101);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider r100, LifecycleOwner r101) {
        this.mMenuHostHelper.addMenuProvider(r100, r101);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r100, Menu r101) {
        if (r100 != 0) goto L6;
        super.onCreatePanelMenu(r100, r101);
        this.mMenuHostHelper.onCreateMenu(r101, getMenuInflater());
        return true;
    L6:
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r100, MenuItem r101) {
        if (super.onMenuItemSelected(r100, r101) == false) goto L6;
        return true;
    L6:
        if (r100 == 0) goto L8;
        return false;
    L8:
        return this.mMenuHostHelper.onMenuItemSelected(r101);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean r100, Configuration r101) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        super.onMultiWindowModeChanged(r100, r101);     // Catch: Throwable -> L9
        this.mDispatchingOnMultiWindowModeChanged = false;
        Iterator<Consumer<MultiWindowModeChangedInfo>> r102 = this.mOnMultiWindowModeChangedListeners.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r102.next().accept(new MultiWindowModeChangedInfo(r100, r101));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnMultiWindowModeChanged = false;
        throw th;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r100, Menu r101) {
        this.mMenuHostHelper.onMenuClosed(r101);
        super.onPanelClosed(r100, r101);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean r100, Configuration r101) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        super.onPictureInPictureModeChanged(r100, r101);     // Catch: Throwable -> L9
        this.mDispatchingOnPictureInPictureModeChanged = false;
        Iterator<Consumer<PictureInPictureModeChangedInfo>> r102 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r102.next().accept(new PictureInPictureModeChangedInfo(r100, r101));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        throw th;
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r100, ActivityResultCallback<O> r101) {
        return registerForActivityResult(r100, this.mActivityResultRegistry, r101);
    }

    @Override // android.app.Activity
    public void setContentView(View r100, ViewGroup.LayoutParams r101) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()));
        super.setContentView(r100, r101);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent r100, int r101) {
        super.startActivityForResult(r100, r101);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider r100, LifecycleOwner r101, Lifecycle.State r102) {
        this.mMenuHostHelper.addMenuProvider(r100, r101, r102);
    }

    @Override // android.app.Activity
    public void onActivityResult(int r100, int r101, Intent r102) {
        if (this.mActivityResultRegistry.dispatchResult(r100, r101, r102) == true) goto L6;
        super.onActivityResult(r100, r101, r102);
        return;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r100, View r101, Menu r102) {
        if (r100 != 0) goto L6;
        super.onPreparePanel(r100, r101, r102);
        this.mMenuHostHelper.onPrepareMenu(r102);
        return true;
    L6:
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int r100, String[] r101, int[] r102) {
        if (this.mActivityResultRegistry.dispatchResult(r100, -1, new Intent().putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS, r101).putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS, r102)) == false) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        androidx_activity_ComponentActivity_androidx_core_app_ComponentActivity_onRequestPermissionsResult_super(this, r100, r101, r102);
        return;
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r100, ActivityResultRegistry r101, ActivityResultCallback<O> r102) {
        return r101.register("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, r100, r102);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent r100, int r101, Bundle r102) {
        super.startActivityForResult(r100, r101, r102);
    }

    private static void androidx_activity_ComponentActivity_androidx_core_app_ComponentActivity_onRequestPermissionsResult_super(androidx.core.app.ComponentActivity r110, int r111, String[] r210, int[] r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111), r210, r211};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(102611);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102611, "androidx/core/app/ComponentActivity", "onRequestPermissionsResult", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        super.onRequestPermissionsResult(r111, r210, r211);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender r100, int r101, Intent r102, int r103, int r104, int r105) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(r100, r101, r102, r103, r104, r105);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender r100, int r101, Intent r102, int r103, int r104, int r105, Bundle r106) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(r100, r101, r102, r103, r104, r105, r106);
    }
}
