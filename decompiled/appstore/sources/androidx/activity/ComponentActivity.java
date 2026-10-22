package androidx.activity;

import android.annotation.SuppressLint;
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
import android.text.TextUtils;
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
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.e0;
import androidx.lifecycle.g0;
import androidx.lifecycle.o0;
import androidx.lifecycle.p0;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements ContextAware, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnNewIntentProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, MenuHost, FullyDrawnReporterOwner {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;

    @LayoutRes
    private int mContentLayoutId;
    final ContextAwareHelper mContextAwareHelper;
    private ViewModelProvider.Factory mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;

    @NonNull
    final FullyDrawnReporter mFullyDrawnReporter;
    private final LifecycleRegistry mLifecycleRegistry;
    private final MenuHostHelper mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<Consumer<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer<androidx.core.app.e>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer<androidx.core.app.k>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Integer>> mOnTrimMemoryListeners;
    final ReportFullyDrawnExecutor mReportFullyDrawnExecutor;
    final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    public interface ReportFullyDrawnExecutor extends Executor {
        void activityDestroyed();

        void viewCreated(@NonNull View r10);
    }

    public class a extends ActivityResultRegistry {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f108h;

        /* JADX INFO: renamed from: androidx.activity.ComponentActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0004a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f109a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ActivityResultContract.a f110b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f111c;

            public RunnableC0004a(a r10, int r11, ActivityResultContract.a r12) {
                this.f111c = r10;
                this.f109a = r11;
                this.f110b = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f111c.c(this.f109a, this.f110b.a());
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f112a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ IntentSender.SendIntentException f113b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f114c;

            public b(a r10, int r11, IntentSender.SendIntentException r12) {
                this.f114c = r10;
                this.f112a = r11;
                this.f113b = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f114c.b(this.f112a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f113b));
            }
        }

        public a(ComponentActivity r10) {
            this.f108h = r10;
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public void f(int r10, ActivityResultContract r11, Object r12, androidx.core.app.b r13) {
            ComponentActivity r14 = this.f108h;
            ActivityResultContract.a r15 = r11.b(r14, r12);
            if (r15 == null) goto L6;
            new Handler(Looper.getMainLooper()).post(new RunnableC0004a(this, r10, r15));
            return;
        L6:
            Intent r16 = r11.a(r14, r12);
            if (r16.getExtras() == null) goto L12;
            if (r16.getExtras().getClassLoader() != null) goto L12;
            r16.setExtrasClassLoader(r14.getClassLoader());
        L12:
            if (r16.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE") == false) goto L14;
            Bundle r17 = r16.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            r16.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            Bundle r18 = r17;
        L16:
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(r16.getAction()) == false) goto L22;
            String[] r19 = r16.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (r19 != null) goto L20;
            r19 = new String[0];
        L20:
            ActivityCompat.q(r14, r19, r10);
            return;
        L22:
            if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(r16.getAction()) == false) goto L28;
            IntentSenderRequest r110 = (IntentSenderRequest) r16.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            ActivityCompat.v(r14, r110.getIntentSender(), r10, r110.getFillInIntent(), r110.getFlagsMask(), r110.getFlagsValues(), 0, r18);     // Catch: IntentSender.SendIntentException -> L26
            return;
        L26:
            e = move-exception;
            new Handler(Looper.getMainLooper()).post(new b(this, r10, e));
            return;
        L28:
            ActivityCompat.u(r14, r16, r10, r18);
            return;
        L14:
            r18 = null;
            goto L16
        }
    }

    public class b implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f115a;

        public b(ComponentActivity r10) {
            this.f115a = r10;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
            if (r11 != Lifecycle.Event.ON_STOP) goto L11;
            Window r12 = this.f115a.getWindow();
            if (r12 == null) goto L7;
            View r13 = r12.peekDecorView();
        L8:
            if (r13 == null) goto L12;
            g.a(r13);
            return;
        L12:
            return;
        L7:
            r13 = null;
            goto L8
        }
    }

    public class c implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f116a;

        public c(ComponentActivity r10) {
            this.f116a = r10;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
            if (r11 != Lifecycle.Event.ON_DESTROY) goto L9;
            this.f116a.mContextAwareHelper.a();
            if (this.f116a.isChangingConfigurations() == true) goto L7;
            this.f116a.getViewModelStore().a();
        L7:
            this.f116a.mReportFullyDrawnExecutor.activityDestroyed();
            return;
        }
    }

    public class d implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f117a;

        public d(ComponentActivity r10) {
            this.f117a = r10;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
            this.f117a.ensureViewModelStore();
            this.f117a.getLifecycle().d(this);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f118a;

        public e(ComponentActivity r10) {
            this.f118a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.access$001(this.f118a);     // Catch: NullPointerException -> L4 IllegalStateException -> L6
        L18:
            return;
        L6:
            e = move-exception;
            if (TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState") == false) goto L15;
            return;
        L15:
            throw e;
        L4:
            e = move-exception;
            if (TextUtils.equals(e.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference") == true) goto L19;
            throw e;
        }
    }

    public class f implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f119a;

        public f(ComponentActivity r10) {
            this.f119a = r10;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
            if (r11 == Lifecycle.Event.ON_CREATE) goto L5;
            return;
        L5:
            if (Build.VERSION.SDK_INT < 33) goto L9;
            ComponentActivity.access$100(this.f119a).l(h.a((ComponentActivity) r10));
            return;
        }
    }

    public static class g {
        public static void a(View r10) {
            r10.cancelPendingInputEvents();
        }
    }

    public static class h {
        @DoNotInline
        public static OnBackInvokedDispatcher a(Activity r10) {
            return r10.getOnBackInvokedDispatcher();
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ViewModelStore f121b;

        public i() {
        }
    }

    public class j implements ReportFullyDrawnExecutor, ViewTreeObserver.OnDrawListener, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f123b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f124c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f125d;

        public j(ComponentActivity r10) {
            this.f125d = r10;
            this.f122a = SystemClock.uptimeMillis() + 10000;
            this.f124c = false;
        }

        public static /* synthetic */ void a(j r10) {
            r10.b();
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void activityDestroyed() {
            this.f125d.getWindow().getDecorView().removeCallbacks(this);
            this.f125d.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        public final /* synthetic */ void b() {
            Runnable r10 = this.f123b;
            if (r10 == null) goto L6;
            r10.run();
            this.f123b = null;
            return;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r10) {
            this.f123b = r10;
            View r11 = this.f125d.getWindow().getDecorView();
            if (this.f124c == true) goto L5;
            r11.postOnAnimation(new androidx.activity.g(this));
            return;
        L5:
            if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
            r11.invalidate();
            return;
        L7:
            r11.postInvalidate();
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable r10 = this.f123b;
            if (r10 == null) goto L8;
            r10.run();
            this.f123b = null;
            if (this.f125d.mFullyDrawnReporter.d() == false) goto L11;
            this.f124c = false;
            this.f125d.getWindow().getDecorView().post(this);
            return;
        L11:
            return;
        L8:
            if (SystemClock.uptimeMillis() <= this.f122a) goto L13;
            this.f124c = false;
            this.f125d.getWindow().getDecorView().post(this);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f125d.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void viewCreated(View r10) {
            if (this.f124c == true) goto L6;
            this.f124c = true;
            r10.getViewTreeObserver().addOnDrawListener(this);
            return;
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new ContextAwareHelper();
        this.mMenuHostHelper = new MenuHostHelper(new androidx.activity.c(this));
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController r10 = SavedStateRegistryController.a(this);
        this.mSavedStateRegistryController = r10;
        this.mOnBackPressedDispatcher = null;
        ReportFullyDrawnExecutor r11 = e();
        this.mReportFullyDrawnExecutor = r11;
        this.mFullyDrawnReporter = new FullyDrawnReporter(r11, new androidx.activity.d(this));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new a(this);
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) goto L7;
        getLifecycle().a(new b(this));
        getLifecycle().a(new c(this));
        getLifecycle().a(new d(this));
        r10.c();
        e0.c(this);
        getSavedStateRegistry().h(ACTIVITY_RESULT_TAG, new androidx.activity.e(this));
        addOnContextAvailableListener(new androidx.activity.f(this));
        return;
    L7:
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public static /* synthetic */ void access$001(ComponentActivity r10) {
        super.onBackPressed();
    }

    public static /* synthetic */ OnBackPressedDispatcher access$100(ComponentActivity r10) {
        return r10.mOnBackPressedDispatcher;
    }

    public static /* synthetic */ void b(ComponentActivity r10, Context r11) {
        r10.h(r11);
    }

    public static /* synthetic */ Bundle c(ComponentActivity r10) {
        return r10.g();
    }

    public static /* synthetic */ Unit d(ComponentActivity r10) {
        return r10.f();
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View r10, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams r11) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.addContentView(r10, r11);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider r10) {
        this.mMenuHostHelper.c(r10);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(@NonNull Consumer<Configuration> r10) {
        this.mOnConfigurationChangedListeners.add(r10);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void addOnContextAvailableListener(@NonNull OnContextAvailableListener r10) {
        this.mContextAwareHelper.addOnContextAvailableListener(r10);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void addOnMultiWindowModeChangedListener(@NonNull Consumer<androidx.core.app.e> r10) {
        this.mOnMultiWindowModeChangedListeners.add(r10);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void addOnNewIntentListener(@NonNull Consumer<Intent> r10) {
        this.mOnNewIntentListeners.add(r10);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void addOnPictureInPictureModeChangedListener(@NonNull Consumer<androidx.core.app.k> r10) {
        this.mOnPictureInPictureModeChangedListeners.add(r10);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(@NonNull Consumer<Integer> r10) {
        this.mOnTrimMemoryListeners.add(r10);
    }

    public final ReportFullyDrawnExecutor e() {
        return new j(this);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore != null) goto L11;
        i r10 = (i) getLastNonConfigurationInstance();
        if (r10 == null) goto L8;
        this.mViewModelStore = r10.f121b;
    L8:
        if (this.mViewModelStore != null) goto L12;
        this.mViewModelStore = new ViewModelStore();
        return;
    L12:
        return;
    }

    public final /* synthetic */ Unit f() {
        reportFullyDrawn();
        return null;
    }

    public final /* synthetic */ Bundle g() {
        Bundle r10 = new Bundle();
        this.mActivityResultRegistry.h(r10);
        return r10;
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    @NonNull
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    @CallSuper
    public CreationExtras getDefaultViewModelCreationExtras() {
        androidx.lifecycle.viewmodel.a r10 = new androidx.lifecycle.viewmodel.a();
        if (getApplication() == null) goto L5;
        r10.c(ViewModelProvider.a.f3486g, getApplication());
    L5:
        r10.c(e0.f3520a, this);
        r10.c(e0.f3521b, this);
        if (getIntent() != null) goto L8;
    L10:
        return r10;
    L8:
        if (getIntent().getExtras() == null) goto L10;
        r10.c(e0.f3522c, getIntent().getExtras());
        goto L10
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory != null) goto L10;
        Application r10 = getApplication();
        if (getIntent() == null) goto L7;
        Bundle r11 = getIntent().getExtras();
    L8:
        this.mDefaultFactory = new g0(r10, this, r11);
        goto L10
    L7:
        r11 = null;
    L10:
        return this.mDefaultFactory;
    }

    @Override // androidx.activity.FullyDrawnReporterOwner
    @NonNull
    public FullyDrawnReporter getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Nullable
    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        i r10 = (i) getLastNonConfigurationInstance();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f120a;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    @NonNull
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher != null) goto L6;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new e(this));
        getLifecycle().a(new f(this));
    L6:
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        if (getApplication() == null) goto L7;
        ensureViewModelStore();
        return this.mViewModelStore;
    L7:
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public final /* synthetic */ void h(Context r10) {
        Bundle r11 = getSavedStateRegistry().b(ACTIVITY_RESULT_TAG);
        if (r11 == null) goto L6;
        this.mActivityResultRegistry.g(r11);
        return;
    }

    @CallSuper
    public void initializeViewTreeOwners() {
        o0.a(getWindow().getDecorView(), this);
        p0.a(getWindow().getDecorView(), this);
        androidx.savedstate.c.a(getWindow().getDecorView(), this);
        r.a(getWindow().getDecorView(), this);
        q.a(getWindow().getDecorView(), this);
    }

    @Override // androidx.core.view.MenuHost
    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    @CallSuper
    @Deprecated
    public void onActivityResult(int r10, int r11, @Nullable Intent r12) {
        if (this.mActivityResultRegistry.b(r10, r11, r12) == true) goto L6;
        super.onActivityResult(r10, r11, r12);
        return;
    }

    @Override // android.app.Activity
    @CallSuper
    @MainThread
    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().k();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration r10) {
        super.onConfigurationChanged(r10);
        Iterator<Consumer<Configuration>> r11 = this.mOnConfigurationChangedListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().accept(r10);
        goto L4
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        this.mSavedStateRegistryController.d(r10);
        this.mContextAwareHelper.b(this);
        super.onCreate(r10);
        ReportFragment.d(this);
        int r11 = this.mContentLayoutId;
        if (r11 == 0) goto L6;
        setContentView(r11);
        return;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r10, @NonNull Menu r11) {
        if (r10 != 0) goto L6;
        super.onCreatePanelMenu(r10, r11);
        this.mMenuHostHelper.h(r11, getMenuInflater());
        return true;
    L6:
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r10, @NonNull MenuItem r11) {
        if (super.onMenuItemSelected(r10, r11) == false) goto L6;
        return true;
    L6:
        if (r10 == 0) goto L8;
        return false;
    L8:
        return this.mMenuHostHelper.j(r11);
    }

    @Override // android.app.Activity
    @CallSuper
    public void onMultiWindowModeChanged(boolean r10) {
        if (this.mDispatchingOnMultiWindowModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<androidx.core.app.e>> r11 = this.mOnMultiWindowModeChangedListeners.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r11.next().accept(new androidx.core.app.e(r10));
        goto L7
    }

    @Override // android.app.Activity
    @CallSuper
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent r10) {
        super.onNewIntent(r10);
        Iterator<Consumer<Intent>> r11 = this.mOnNewIntentListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().accept(r10);
        goto L4
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r10, @NonNull Menu r11) {
        this.mMenuHostHelper.i(r11);
        super.onPanelClosed(r10, r11);
    }

    @Override // android.app.Activity
    @CallSuper
    public void onPictureInPictureModeChanged(boolean r10) {
        if (this.mDispatchingOnPictureInPictureModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<androidx.core.app.k>> r11 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r11.next().accept(new androidx.core.app.k(r10));
        goto L7
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r10, @Nullable View r11, @NonNull Menu r12) {
        if (r10 != 0) goto L6;
        super.onPreparePanel(r10, r11, r12);
        this.mMenuHostHelper.k(r12);
        return true;
    L6:
        return true;
    }

    @Override // android.app.Activity
    @CallSuper
    @Deprecated
    public void onRequestPermissionsResult(int r10, @NonNull String[] r11, @NonNull int[] r12) {
        if (this.mActivityResultRegistry.b(r10, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", r11).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", r12)) == true) goto L6;
        super.onRequestPermissionsResult(r10, r11, r12);
        return;
    }

    @Nullable
    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    @Nullable
    public final Object onRetainNonConfigurationInstance() {
        Object r10 = onRetainCustomNonConfigurationInstance();
        ViewModelStore r11 = this.mViewModelStore;
        if (r11 != null) goto L7;
        i r12 = (i) getLastNonConfigurationInstance();
        if (r12 == null) goto L7;
        r11 = r12.f121b;
    L7:
        if (r11 != null) goto L11;
        if (r10 != null) goto L11;
        return null;
    L11:
        i r13 = new i();
        r13.f120a = r10;
        r13.f121b = r11;
        return r13;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    @CallSuper
    public void onSaveInstanceState(@NonNull Bundle r10) {
        Lifecycle r11 = getLifecycle();
        if ((r11 instanceof LifecycleRegistry) == false) goto L5;
        ((LifecycleRegistry) r11).n(Lifecycle.State.CREATED);
    L5:
        super.onSaveInstanceState(r10);
        this.mSavedStateRegistryController.e(r10);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    @CallSuper
    public void onTrimMemory(int r10) {
        super.onTrimMemory(r10);
        Iterator<Consumer<Integer>> r11 = this.mOnTrimMemoryListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().accept(Integer.valueOf(r10));
        goto L4
    }

    @Override // androidx.activity.contextaware.ContextAware
    @Nullable
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.c();
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    public final <I, O> ActivityResultLauncher registerForActivityResult(@NonNull ActivityResultContract r10, @NonNull ActivityResultRegistry r11, @NonNull ActivityResultCallback<O> r12) {
        return r11.j("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, r10, r12);
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(@NonNull MenuProvider r10) {
        this.mMenuHostHelper.l(r10);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(@NonNull Consumer<Configuration> r10) {
        this.mOnConfigurationChangedListeners.remove(r10);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void removeOnContextAvailableListener(@NonNull OnContextAvailableListener r10) {
        this.mContextAwareHelper.removeOnContextAvailableListener(r10);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void removeOnMultiWindowModeChangedListener(@NonNull Consumer<androidx.core.app.e> r10) {
        this.mOnMultiWindowModeChangedListeners.remove(r10);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void removeOnNewIntentListener(@NonNull Consumer<Intent> r10) {
        this.mOnNewIntentListeners.remove(r10);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void removeOnPictureInPictureModeChangedListener(@NonNull Consumer<androidx.core.app.k> r10) {
        this.mOnPictureInPictureModeChangedListeners.remove(r10);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(@NonNull Consumer<Integer> r10) {
        this.mOnTrimMemoryListeners.remove(r10);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
    L5:
        th = move-exception;
        g0.a.b();
        throw th;
    L3:
        if (g0.a.d() == false) goto L7;
        g0.a.a("reportFullyDrawn() for ComponentActivity");     // Catch: Throwable -> L5
    L7:
        super.reportFullyDrawn();     // Catch: Throwable -> L5
        this.mFullyDrawnReporter.c();     // Catch: Throwable -> L5
        g0.a.b();
    }

    @Override // android.app.Activity
    public void setContentView(@LayoutRes int r10) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(r10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@NonNull Intent r10, int r11) {
        super.startActivityForResult(r10, r11);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender r10, int r11, @Nullable Intent r12, int r13, int r14, int r15) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(r10, r11, r12, r13, r14, r15);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider r10, @NonNull LifecycleOwner r11) {
        this.mMenuHostHelper.d(r10, r11);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@NonNull Intent r10, int r11, @Nullable Bundle r12) {
        super.startActivityForResult(r10, r11, r12);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender r10, int r11, @Nullable Intent r12, int r13, int r14, int r15, @Nullable Bundle r16) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // androidx.core.view.MenuHost
    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull MenuProvider r10, @NonNull LifecycleOwner r11, @NonNull Lifecycle.State r12) {
        this.mMenuHostHelper.e(r10, r11, r12);
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    @CallSuper
    public void onMultiWindowModeChanged(boolean r10, @NonNull Configuration r11) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        super.onMultiWindowModeChanged(r10, r11);     // Catch: Throwable -> L9
        this.mDispatchingOnMultiWindowModeChanged = false;
        Iterator<Consumer<androidx.core.app.e>> r12 = this.mOnMultiWindowModeChangedListeners.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r12.next().accept(new androidx.core.app.e(r10, r11));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnMultiWindowModeChanged = false;
        throw th;
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    @CallSuper
    public void onPictureInPictureModeChanged(boolean r10, @NonNull Configuration r11) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        super.onPictureInPictureModeChanged(r10, r11);     // Catch: Throwable -> L9
        this.mDispatchingOnPictureInPictureModeChanged = false;
        Iterator<Consumer<androidx.core.app.k>> r12 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r12.next().accept(new androidx.core.app.k(r10, r11));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        throw th;
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    public final <I, O> ActivityResultLauncher registerForActivityResult(@NonNull ActivityResultContract r10, @NonNull ActivityResultCallback<O> r11) {
        return registerForActivityResult(r10, this.mActivityResultRegistry, r11);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View r10) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(r10);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View r10, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams r11) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(r10, r11);
    }

    public ComponentActivity(int r10) {
        this();
        this.mContentLayoutId = r10;
    }
}
