package androidx.activity;

import V3.v;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
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
import androidx.activity.h;
import androidx.core.view.C0471p;
import androidx.core.view.InterfaceC0468m;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.C0541v;
import androidx.lifecycle.H;
import androidx.lifecycle.InterfaceC0531k;
import androidx.lifecycle.InterfaceC0537q;
import androidx.lifecycle.InterfaceC0539t;
import androidx.lifecycle.M;
import androidx.lifecycle.P;
import androidx.lifecycle.U;
import androidx.lifecycle.W;
import androidx.lifecycle.X;
import androidx.lifecycle.Y;
import androidx.lifecycle.Z;
import c.C0569a;
import c.InterfaceC0570b;
import c0.C0574d;
import c0.C0575e;
import c0.C0577g;
import c0.InterfaceC0576f;
import d.AbstractC0642c;
import d.AbstractC0643d;
import d.C0645f;
import d.InterfaceC0641b;
import d.InterfaceC0644e;
import e.AbstractC0674a;
import g0.C0729a;
import i4.InterfaceC0761a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class h extends androidx.core.app.f implements InterfaceC0539t, X, InterfaceC0531k, InterfaceC0576f, r, InterfaceC0644e, androidx.core.content.b, androidx.core.content.c, androidx.core.app.n, androidx.core.app.o, InterfaceC0468m, n {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final AbstractC0643d mActivityResultRegistry;
    private int mContentLayoutId;
    final C0569a mContextAwareHelper;
    private U.c mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final m mFullyDrawnReporter;
    private final C0541v mLifecycleRegistry;
    private final C0471p mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private p mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<D.a<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<D.a<androidx.core.app.g>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<D.a<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<D.a<androidx.core.app.q>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<D.a<Integer>> mOnTrimMemoryListeners;
    final j mReportFullyDrawnExecutor;
    final C0575e mSavedStateRegistryController;
    private W mViewModelStore;

    class a extends AbstractC0643d {

        /* renamed from: androidx.activity.h$a$a, reason: collision with other inner class name */
        class RunnableC0101a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f7353a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AbstractC0674a.C0207a f7354b;

            RunnableC0101a(int i5, AbstractC0674a.C0207a c0207a) {
                this.f7353a = i5;
                this.f7354b = c0207a;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.f7353a, this.f7354b.a());
            }
        }

        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f7356a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ IntentSender.SendIntentException f7357b;

            b(int i5, IntentSender.SendIntentException sendIntentException) {
                this.f7356a = i5;
                this.f7357b = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b(this.f7356a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f7357b));
            }
        }

        a() {
        }

        @Override // d.AbstractC0643d
        public <I, O> void f(int i5, AbstractC0674a<I, O> abstractC0674a, I i6, androidx.core.app.c cVar) {
            Bundle bundleExtra;
            int i7;
            h hVar = h.this;
            AbstractC0674a.C0207a<O> c0207aB = abstractC0674a.b(hVar, i6);
            if (c0207aB != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0101a(i5, c0207aB));
                return;
            }
            Intent intentA = abstractC0674a.a(hVar, i6);
            if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
                intentA.setExtrasClassLoader(hVar.getClassLoader());
            }
            if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            } else {
                bundleExtra = null;
            }
            Bundle bundle = bundleExtra;
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
                String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                androidx.core.app.a.q(hVar, stringArrayExtra, i5);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
                androidx.core.app.a.t(hVar, intentA, i5, bundle);
                return;
            }
            C0645f c0645f = (C0645f) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                i7 = i5;
            } catch (IntentSender.SendIntentException e6) {
                e = e6;
                i7 = i5;
            }
            try {
                androidx.core.app.a.u(hVar, c0645f.A(), i7, c0645f.a(), c0645f.c(), c0645f.f(), 0, bundle);
            } catch (IntentSender.SendIntentException e7) {
                e = e7;
                new Handler(Looper.getMainLooper()).post(new b(i7, e));
            }
        }
    }

    class b implements InterfaceC0537q {
        b() {
        }

        @Override // androidx.lifecycle.InterfaceC0537q
        public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
            if (aVar == AbstractC0533m.a.ON_STOP) {
                Window window = h.this.getWindow();
                View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                if (viewPeekDecorView != null) {
                    g.a(viewPeekDecorView);
                }
            }
        }
    }

    class c implements InterfaceC0537q {
        c() {
        }

        @Override // androidx.lifecycle.InterfaceC0537q
        public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
            if (aVar == AbstractC0533m.a.ON_DESTROY) {
                h.this.mContextAwareHelper.b();
                if (!h.this.isChangingConfigurations()) {
                    h.this.getViewModelStore().a();
                }
                h.this.mReportFullyDrawnExecutor.f();
            }
        }
    }

    class d implements InterfaceC0537q {
        d() {
        }

        @Override // androidx.lifecycle.InterfaceC0537q
        public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
            h.this.ensureViewModelStore();
            h.this.getLifecycle().d(this);
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h.super.onBackPressed();
            } catch (IllegalStateException e6) {
                if (!TextUtils.equals(e6.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e6;
                }
            } catch (NullPointerException e7) {
                if (!TextUtils.equals(e7.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e7;
                }
            }
        }
    }

    class f implements InterfaceC0537q {
        f() {
        }

        @Override // androidx.lifecycle.InterfaceC0537q
        public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
            if (aVar == AbstractC0533m.a.ON_CREATE) {
                h.this.mOnBackPressedDispatcher.n(C0102h.a((h) interfaceC0539t));
            }
        }
    }

    static class g {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* renamed from: androidx.activity.h$h, reason: collision with other inner class name */
    static class C0102h {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    static final class i {

        /* renamed from: a, reason: collision with root package name */
        Object f7364a;

        /* renamed from: b, reason: collision with root package name */
        W f7365b;

        i() {
        }
    }

    private interface j extends Executor {
        void G(View view);

        void f();
    }

    class k implements j, ViewTreeObserver.OnDrawListener, Runnable {

        /* renamed from: b, reason: collision with root package name */
        Runnable f7367b;

        /* renamed from: a, reason: collision with root package name */
        final long f7366a = SystemClock.uptimeMillis() + 10000;

        /* renamed from: c, reason: collision with root package name */
        boolean f7368c = false;

        k() {
        }

        public static /* synthetic */ void a(k kVar) {
            Runnable runnable = kVar.f7367b;
            if (runnable != null) {
                runnable.run();
                kVar.f7367b = null;
            }
        }

        @Override // androidx.activity.h.j
        public void G(View view) {
            if (this.f7368c) {
                return;
            }
            this.f7368c = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f7367b = runnable;
            View decorView = h.this.getWindow().getDecorView();
            if (!this.f7368c) {
                decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.k.a(this.f7370a);
                    }
                });
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // androidx.activity.h.j
        public void f() {
            h.this.getWindow().getDecorView().removeCallbacks(this);
            h.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f7367b;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.f7366a) {
                    this.f7368c = false;
                    h.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.f7367b = null;
            if (h.this.mFullyDrawnReporter.c()) {
                this.f7368c = false;
                h.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public h() {
        this.mContextAwareHelper = new C0569a();
        this.mMenuHostHelper = new C0471p(new Runnable() { // from class: androidx.activity.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f7348a.invalidateMenu();
            }
        });
        this.mLifecycleRegistry = new C0541v(this);
        C0575e c0575eA = C0575e.a(this);
        this.mSavedStateRegistryController = c0575eA;
        this.mOnBackPressedDispatcher = null;
        j jVarCreateFullyDrawnExecutor = createFullyDrawnExecutor();
        this.mReportFullyDrawnExecutor = jVarCreateFullyDrawnExecutor;
        this.mFullyDrawnReporter = new m(jVarCreateFullyDrawnExecutor, new InterfaceC0761a() { // from class: androidx.activity.e
            @Override // i4.InterfaceC0761a
            public final Object invoke() {
                return h.o(this.f7349a);
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new a();
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        getLifecycle().a(new b());
        getLifecycle().a(new c());
        getLifecycle().a(new d());
        c0575eA.c();
        M.c(this);
        getSavedStateRegistry().h(ACTIVITY_RESULT_TAG, new C0574d.c() { // from class: androidx.activity.f
            @Override // c0.C0574d.c
            public final Bundle a() {
                return h.n(this.f7350a);
            }
        });
        addOnContextAvailableListener(new InterfaceC0570b() { // from class: androidx.activity.g
            @Override // c.InterfaceC0570b
            public final void a(Context context) {
                h.m(this.f7351a, context);
            }
        });
    }

    private j createFullyDrawnExecutor() {
        return new k();
    }

    public static /* synthetic */ void m(h hVar, Context context) {
        Bundle bundleB = hVar.getSavedStateRegistry().b(ACTIVITY_RESULT_TAG);
        if (bundleB != null) {
            hVar.mActivityResultRegistry.g(bundleB);
        }
    }

    public static /* synthetic */ Bundle n(h hVar) {
        hVar.getClass();
        Bundle bundle = new Bundle();
        hVar.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    public static /* synthetic */ v o(h hVar) {
        hVar.reportFullyDrawn();
        return null;
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.G(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.core.view.InterfaceC0468m
    public void addMenuProvider(androidx.core.view.r rVar) {
        this.mMenuHostHelper.c(rVar);
    }

    @Override // androidx.core.content.b
    public final void addOnConfigurationChangedListener(D.a<Configuration> aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(InterfaceC0570b interfaceC0570b) {
        this.mContextAwareHelper.a(interfaceC0570b);
    }

    @Override // androidx.core.app.n
    public final void addOnMultiWindowModeChangedListener(D.a<androidx.core.app.g> aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(D.a<Intent> aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    @Override // androidx.core.app.o
    public final void addOnPictureInPictureModeChangedListener(D.a<androidx.core.app.q> aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    @Override // androidx.core.content.c
    public final void addOnTrimMemoryListener(D.a<Integer> aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            i iVar = (i) getLastNonConfigurationInstance();
            if (iVar != null) {
                this.mViewModelStore = iVar.f7365b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new W();
            }
        }
    }

    @Override // d.InterfaceC0644e
    public final AbstractC0643d getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.InterfaceC0531k
    public W.a getDefaultViewModelCreationExtras() {
        W.b bVar = new W.b();
        if (getApplication() != null) {
            bVar.c(U.a.f10846h, getApplication());
        }
        bVar.c(M.f10823a, this);
        bVar.c(M.f10824b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            bVar.c(M.f10825c, getIntent().getExtras());
        }
        return bVar;
    }

    @Override // androidx.lifecycle.InterfaceC0531k
    public U.c getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new P(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    public m getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        i iVar = (i) getLastNonConfigurationInstance();
        if (iVar != null) {
            return iVar.f7364a;
        }
        return null;
    }

    @Override // androidx.core.app.f, androidx.lifecycle.InterfaceC0539t
    public AbstractC0533m getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.r
    public final p getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new p(new e());
            getLifecycle().a(new f());
        }
        return this.mOnBackPressedDispatcher;
    }

    @Override // c0.InterfaceC0576f
    public final C0574d getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // androidx.lifecycle.X
    public W getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    public void initializeViewTreeOwners() {
        Y.a(getWindow().getDecorView(), this);
        Z.a(getWindow().getDecorView(), this);
        C0577g.a(getWindow().getDecorView(), this);
        u.a(getWindow().getDecorView(), this);
        t.a(getWindow().getDecorView(), this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    @Deprecated
    protected void onActivityResult(int i5, int i6, Intent intent) {
        if (this.mActivityResultRegistry.b(i5, i6, intent)) {
            return;
        }
        super.onActivityResult(i5, i6, intent);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().k();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<D.a<Configuration>> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        H.e(this);
        int i5 = this.mContentLayoutId;
        if (i5 != 0) {
            setContentView(i5);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i5, Menu menu) {
        if (i5 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i5, menu);
        this.mMenuHostHelper.f(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        if (super.onMenuItemSelected(i5, menuItem)) {
            return true;
        }
        if (i5 == 0) {
            return this.mMenuHostHelper.h(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z5) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<D.a<androidx.core.app.g>> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.g(z5));
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<D.a<Intent>> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i5, Menu menu) {
        this.mMenuHostHelper.g(menu);
        super.onPanelClosed(i5, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z5) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<D.a<androidx.core.app.q>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.q(z5));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i5, View view, Menu menu) {
        if (i5 != 0) {
            return true;
        }
        super.onPreparePanel(i5, view, menu);
        this.mMenuHostHelper.i(menu);
        return true;
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.b(i5, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i5, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        i iVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        W w5 = this.mViewModelStore;
        if (w5 == null && (iVar = (i) getLastNonConfigurationInstance()) != null) {
            w5 = iVar.f7365b;
        }
        if (w5 == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        i iVar2 = new i();
        iVar2.f7364a = objOnRetainCustomNonConfigurationInstance;
        iVar2.f7365b = w5;
        return iVar2;
    }

    @Override // androidx.core.app.f, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        AbstractC0533m lifecycle = getLifecycle();
        if (lifecycle instanceof C0541v) {
            ((C0541v) lifecycle).n(AbstractC0533m.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i5) {
        super.onTrimMemory(i5);
        Iterator<D.a<Integer>> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i5));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final <I, O> AbstractC0642c<I> registerForActivityResult(AbstractC0674a<I, O> abstractC0674a, AbstractC0643d abstractC0643d, InterfaceC0641b<O> interfaceC0641b) {
        return abstractC0643d.i("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, abstractC0674a, interfaceC0641b);
    }

    @Override // androidx.core.view.InterfaceC0468m
    public void removeMenuProvider(androidx.core.view.r rVar) {
        this.mMenuHostHelper.j(rVar);
    }

    @Override // androidx.core.content.b
    public final void removeOnConfigurationChangedListener(D.a<Configuration> aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(InterfaceC0570b interfaceC0570b) {
        this.mContextAwareHelper.e(interfaceC0570b);
    }

    @Override // androidx.core.app.n
    public final void removeOnMultiWindowModeChangedListener(D.a<androidx.core.app.g> aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(D.a<Intent> aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    @Override // androidx.core.app.o
    public final void removeOnPictureInPictureModeChangedListener(D.a<androidx.core.app.q> aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    @Override // androidx.core.content.c
    public final void removeOnTrimMemoryListener(D.a<Integer> aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (C0729a.d()) {
                C0729a.a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.mFullyDrawnReporter.b();
        } finally {
            C0729a.b();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i5) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.G(getWindow().getDecorView());
        super.setContentView(i5);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i5) {
        super.startActivityForResult(intent, i5);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8);
    }

    public void addMenuProvider(androidx.core.view.r rVar, InterfaceC0539t interfaceC0539t) {
        this.mMenuHostHelper.d(rVar, interfaceC0539t);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i5, Bundle bundle) {
        super.startActivityForResult(intent, i5, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8, bundle);
    }

    public void addMenuProvider(androidx.core.view.r rVar, InterfaceC0539t interfaceC0539t, AbstractC0533m.b bVar) {
        this.mMenuHostHelper.e(rVar, interfaceC0539t, bVar);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z5, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z5, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<D.a<androidx.core.app.g>> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new androidx.core.app.g(z5, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z5, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z5, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<D.a<androidx.core.app.q>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new androidx.core.app.q(z5, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public final <I, O> AbstractC0642c<I> registerForActivityResult(AbstractC0674a<I, O> abstractC0674a, InterfaceC0641b<O> interfaceC0641b) {
        return registerForActivityResult(abstractC0674a, this.mActivityResultRegistry, interfaceC0641b);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.G(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.G(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    public h(int i5) {
        this();
        this.mContentLayoutId = i5;
    }
}
