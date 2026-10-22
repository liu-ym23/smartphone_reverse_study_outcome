package androidx.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
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
import androidx.core.os.BuildCompat;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
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
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements ContextAware, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnNewIntentProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, MenuHost, FullyDrawnReporterOwner {
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
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<Consumer<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Integer>> mOnTrimMemoryListeners;
    final ReportFullyDrawnExecutor mReportFullyDrawnExecutor;
    final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    static class Api19Impl {
        private Api19Impl() {
        }

        static void cancelPendingInputEvents(View r0) {
            r0.cancelPendingInputEvents();
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity r0) {
            return r0.getOnBackInvokedDispatcher();
        }
    }

    static final class NonConfigurationInstances {
        Object custom;
        ViewModelStore viewModelStore;

        NonConfigurationInstances() {
        }
    }

    private interface ReportFullyDrawnExecutor extends Executor {
        void activityDestroyed();

        void viewCreated(View r1);
    }

    static class ReportFullyDrawnExecutorApi1 implements ReportFullyDrawnExecutor {
        final Handler mHandler;

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void activityDestroyed() {
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void viewCreated(View r1) {
        }

        ReportFullyDrawnExecutorApi1() {
            this.mHandler = createHandler();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r1) {
            this.mHandler.postAtFrontOfQueue(r1);
        }

        private Handler createHandler() {
            Looper r1 = Looper.myLooper();
            if (r1 != null) goto L6;
            r1 = Looper.getMainLooper();
        L6:
            return new Handler(r1);
        }
    }

    class ReportFullyDrawnExecutorApi16Impl implements ReportFullyDrawnExecutor, ViewTreeObserver.OnDrawListener, Runnable {
        final long mEndWatchTimeMillis;
        boolean mOnDrawScheduled;
        Runnable mRunnable;
        final /* synthetic */ ComponentActivity this$0;

        ReportFullyDrawnExecutorApi16Impl(ComponentActivity r5) {
            this.this$0 = r5;
            this.mEndWatchTimeMillis = SystemClock.uptimeMillis() + 10000;
            this.mOnDrawScheduled = false;
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void viewCreated(View r2) {
            if (this.mOnDrawScheduled == true) goto L6;
            this.mOnDrawScheduled = true;
            r2.getViewTreeObserver().addOnDrawListener(this);
            return;
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void activityDestroyed() {
            this.this$0.getWindow().getDecorView().removeCallbacks(this);
            this.this$0.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r2) {
            this.mRunnable = r2;
            View r3 = this.this$0.getWindow().getDecorView();
            if (this.mOnDrawScheduled == true) goto L5;
            r3.postOnAnimation(new ComponentActivity$ReportFullyDrawnExecutorApi16Impl$$ExternalSyntheticLambda0(this));
            return;
        L5:
            if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
            r3.invalidate();
            return;
        L7:
            r3.postInvalidate();
        }

        /* JADX INFO: renamed from: lambda$execute$0$androidx-activity-ComponentActivity$ReportFullyDrawnExecutorApi16Impl, reason: not valid java name */
        /* synthetic */ void m4x96b76666() {
            Runnable r0 = this.mRunnable;
            if (r0 == null) goto L6;
            r0.run();
            this.mRunnable = null;
            return;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable r0 = this.mRunnable;
            if (r0 == null) goto L8;
            r0.run();
            this.mRunnable = null;
            if (this.this$0.mFullyDrawnReporter.isFullyDrawnReported() == false) goto L11;
            this.mOnDrawScheduled = false;
            this.this$0.getWindow().getDecorView().post(this);
            return;
        L11:
            return;
        L8:
            if (SystemClock.uptimeMillis() <= this.mEndWatchTimeMillis) goto L13;
            this.mOnDrawScheduled = false;
            this.this$0.getWindow().getDecorView().post(this);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    static /* synthetic */ void access$001(ComponentActivity r0) {
        super.onBackPressed();
    }

    /* JADX INFO: renamed from: lambda$new$0$androidx-activity-ComponentActivity, reason: not valid java name */
    /* synthetic */ Unit m1lambda$new$0$androidxactivityComponentActivity() {
        reportFullyDrawn();
        return null;
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new ContextAwareHelper();
        this.mMenuHostHelper = new MenuHostHelper(new ComponentActivity$$ExternalSyntheticLambda0(this));
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController r0 = SavedStateRegistryController.create(this);
        this.mSavedStateRegistryController = r0;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new AnonymousClass1(this));
        ReportFullyDrawnExecutor r1 = createFullyDrawnExecutor();
        this.mReportFullyDrawnExecutor = r1;
        this.mFullyDrawnReporter = new FullyDrawnReporter(r1, new ComponentActivity$$ExternalSyntheticLambda1(this));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new AnonymousClass2(this);
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) goto L7;
        getLifecycle().addObserver(new AnonymousClass3(this));
        getLifecycle().addObserver(new AnonymousClass4(this));
        getLifecycle().addObserver(new AnonymousClass5(this));
        r0.performAttach();
        SavedStateHandleSupport.enableSavedStateHandles(this);
        getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, new ComponentActivity$$ExternalSyntheticLambda2(this));
        addOnContextAvailableListener(new ComponentActivity$$ExternalSyntheticLambda3(this));
        return;
    L7:
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    /* JADX INFO: renamed from: lambda$new$1$androidx-activity-ComponentActivity, reason: not valid java name */
    /* synthetic */ Bundle m2lambda$new$1$androidxactivityComponentActivity() {
        Bundle r0 = new Bundle();
        this.mActivityResultRegistry.onSaveInstanceState(r0);
        return r0;
    }

    /* JADX INFO: renamed from: lambda$new$2$androidx-activity-ComponentActivity, reason: not valid java name */
    /* synthetic */ void m3lambda$new$2$androidxactivityComponentActivity(Context r2) {
        Bundle r3 = getSavedStateRegistry().consumeRestoredStateForKey(ACTIVITY_RESULT_TAG);
        if (r3 == null) goto L6;
        this.mActivityResultRegistry.onRestoreInstanceState(r3);
        return;
    }

    public ComponentActivity(int r1) {
        this();
        this.mContentLayoutId = r1;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r2) {
        this.mSavedStateRegistryController.performRestore(r2);
        this.mContextAwareHelper.dispatchOnContextAvailable(this);
        super.onCreate(r2);
        ReportFragment.injectIfNeededIn(this);
        if (BuildCompat.isAtLeastT() == false) goto L5;
        this.mOnBackPressedDispatcher.setOnBackInvokedDispatcher(Api33Impl.getOnBackInvokedDispatcher(this));
    L5:
        int r3 = this.mContentLayoutId;
        if (r3 == 0) goto L9;
        setContentView(r3);
        return;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle r3) {
        Lifecycle r0 = getLifecycle();
        if ((r0 instanceof LifecycleRegistry) == false) goto L5;
        ((LifecycleRegistry) r0).setCurrentState(Lifecycle.State.CREATED);
    L5:
        super.onSaveInstanceState(r3);
        this.mSavedStateRegistryController.performSave(r3);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        Object r0 = onRetainCustomNonConfigurationInstance();
        ViewModelStore r1 = this.mViewModelStore;
        if (r1 != null) goto L7;
        NonConfigurationInstances r2 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r2 == null) goto L7;
        r1 = r2.viewModelStore;
    L7:
        if (r1 != null) goto L11;
        if (r0 != null) goto L11;
        return null;
    L11:
        NonConfigurationInstances r3 = new NonConfigurationInstances();
        r3.custom = r0;
        r3.viewModelStore = r1;
        return r3;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances r0 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.custom;
    }

    @Override // android.app.Activity
    public void setContentView(int r3) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(r3);
    }

    @Override // android.app.Activity
    public void setContentView(View r3) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(r3);
    }

    @Override // android.app.Activity
    public void setContentView(View r3, ViewGroup.LayoutParams r4) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(r3, r4);
    }

    @Override // android.app.Activity
    public void addContentView(View r3, ViewGroup.LayoutParams r4) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.addContentView(r3, r4);
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.set(getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.set(getWindow().getDecorView(), this);
        ViewTreeFullyDrawnReporterOwner.set(getWindow().getDecorView(), this);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.peekAvailableContext();
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void addOnContextAvailableListener(OnContextAvailableListener r1) {
        this.mContextAwareHelper.addOnContextAvailableListener(r1);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void removeOnContextAvailableListener(OnContextAvailableListener r1) {
        this.mContextAwareHelper.removeOnContextAvailableListener(r1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r1, View r2, Menu r3) {
        if (r1 != 0) goto L6;
        super.onPreparePanel(r1, r2, r3);
        this.mMenuHostHelper.onPrepareMenu(r3);
        return true;
    L6:
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r1, Menu r2) {
        if (r1 != 0) goto L6;
        super.onCreatePanelMenu(r1, r2);
        this.mMenuHostHelper.onCreateMenu(r2, getMenuInflater());
        return true;
    L6:
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r2, MenuItem r3) {
        if (super.onMenuItemSelected(r2, r3) == false) goto L6;
        return true;
    L6:
        if (r2 == 0) goto L8;
        return false;
    L8:
        return this.mMenuHostHelper.onMenuItemSelected(r3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r2, Menu r3) {
        this.mMenuHostHelper.onMenuClosed(r3);
        super.onPanelClosed(r2, r3);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider r1) {
        this.mMenuHostHelper.addMenuProvider(r1);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider r1, LifecycleOwner r2) {
        this.mMenuHostHelper.addMenuProvider(r1, r2);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider r1, LifecycleOwner r2, Lifecycle.State r3) {
        this.mMenuHostHelper.addMenuProvider(r1, r2, r3);
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(MenuProvider r1) {
        this.mMenuHostHelper.removeMenuProvider(r1);
    }

    @Override // androidx.core.view.MenuHost
    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (getApplication() == null) goto L7;
        ensureViewModelStore();
        return this.mViewModelStore;
    L7:
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore != null) goto L11;
        NonConfigurationInstances r0 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r0 == null) goto L8;
        this.mViewModelStore = r0.viewModelStore;
    L8:
        if (this.mViewModelStore != null) goto L12;
        this.mViewModelStore = new ViewModelStore();
        return;
    L12:
        return;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory != null) goto L10;
        Application r1 = getApplication();
        if (getIntent() == null) goto L7;
        Bundle r2 = getIntent().getExtras();
    L8:
        this.mDefaultFactory = new SavedStateViewModelFactory(r1, this, r2);
        goto L10
    L7:
        r2 = null;
    L10:
        return this.mDefaultFactory;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras r0 = new MutableCreationExtras();
        if (getApplication() == null) goto L5;
        r0.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, getApplication());
    L5:
        r0.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        r0.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getIntent() != null) goto L8;
    L10:
        return r0;
    L8:
        if (getIntent().getExtras() == null) goto L10;
        r0.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getIntent().getExtras());
        goto L10
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Override // androidx.activity.FullyDrawnReporterOwner
    public FullyDrawnReporter getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent r1, int r2) {
        super.startActivityForResult(r1, r2);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender r1, int r2, Intent r3, int r4, int r5, int r6) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(r1, r2, r3, r4, r5, r6);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender r1, int r2, Intent r3, int r4, int r5, int r6, Bundle r7) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(r1, r2, r3, r4, r5, r6, r7);
    }

    @Override // android.app.Activity
    @Deprecated
    protected void onActivityResult(int r2, int r3, Intent r4) {
        if (this.mActivityResultRegistry.dispatchResult(r2, r3, r4) == true) goto L6;
        super.onActivityResult(r2, r3, r4);
        return;
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int r4, String[] r5, int[] r6) {
        if (this.mActivityResultRegistry.dispatchResult(r4, -1, new Intent().putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS, r5).putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS, r6)) == true) goto L6;
        super.onRequestPermissionsResult(r4, r5, r6);
        return;
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r3, ActivityResultRegistry r4, ActivityResultCallback<O> r5) {
        return r4.register("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, r3, r5);
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r2, ActivityResultCallback<O> r3) {
        return registerForActivityResult(r2, this.mActivityResultRegistry, r3);
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        Iterator<Consumer<Configuration>> r1 = this.mOnConfigurationChangedListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().accept(r2);
        goto L4
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(Consumer<Configuration> r1) {
        this.mOnConfigurationChangedListeners.add(r1);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(Consumer<Configuration> r1) {
        this.mOnConfigurationChangedListeners.remove(r1);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int r3) {
        super.onTrimMemory(r3);
        Iterator<Consumer<Integer>> r2 = this.mOnTrimMemoryListeners.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().accept(Integer.valueOf(r3));
        goto L4
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(Consumer<Integer> r1) {
        this.mOnTrimMemoryListeners.add(r1);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(Consumer<Integer> r1) {
        this.mOnTrimMemoryListeners.remove(r1);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent r2) {
        super.onNewIntent(r2);
        Iterator<Consumer<Intent>> r1 = this.mOnNewIntentListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().accept(r2);
        goto L4
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void addOnNewIntentListener(Consumer<Intent> r1) {
        this.mOnNewIntentListeners.add(r1);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void removeOnNewIntentListener(Consumer<Intent> r1) {
        this.mOnNewIntentListeners.remove(r1);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean r3) {
        if (this.mDispatchingOnMultiWindowModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<MultiWindowModeChangedInfo>> r2 = this.mOnMultiWindowModeChangedListeners.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r2.next().accept(new MultiWindowModeChangedInfo(r3));
        goto L7
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean r3, Configuration r4) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        super.onMultiWindowModeChanged(r3, r4);     // Catch: Throwable -> L9
        this.mDispatchingOnMultiWindowModeChanged = false;
        Iterator<Consumer<MultiWindowModeChangedInfo>> r2 = this.mOnMultiWindowModeChangedListeners.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().accept(new MultiWindowModeChangedInfo(r3, r4));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnMultiWindowModeChanged = false;
        throw th;
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void addOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> r1) {
        this.mOnMultiWindowModeChangedListeners.add(r1);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void removeOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> r1) {
        this.mOnMultiWindowModeChangedListeners.remove(r1);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean r3) {
        if (this.mDispatchingOnPictureInPictureModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<PictureInPictureModeChangedInfo>> r2 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r2.next().accept(new PictureInPictureModeChangedInfo(r3));
        goto L7
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean r3, Configuration r4) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        super.onPictureInPictureModeChanged(r3, r4);     // Catch: Throwable -> L9
        this.mDispatchingOnPictureInPictureModeChanged = false;
        Iterator<Consumer<PictureInPictureModeChangedInfo>> r2 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().accept(new PictureInPictureModeChangedInfo(r3, r4));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        throw th;
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void addOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> r1) {
        this.mOnPictureInPictureModeChangedListeners.add(r1);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void removeOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> r1) {
        this.mOnPictureInPictureModeChangedListeners.remove(r1);
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

    private ReportFullyDrawnExecutor createFullyDrawnExecutor() {
        return new ReportFullyDrawnExecutorApi16Impl(this);
    }
}
