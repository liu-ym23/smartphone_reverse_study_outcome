package androidx.activity;

import K.C0081m;
import K.C0082n;
import K.InterfaceC0078j;
import K.InterfaceC0084p;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.G;
import androidx.fragment.app.S;
import androidx.lifecycle.AbstractC0323u;
import androidx.lifecycle.AbstractC0328z;
import androidx.lifecycle.C0324v;
import androidx.lifecycle.E;
import androidx.lifecycle.EnumC0326x;
import androidx.lifecycle.EnumC0327y;
import androidx.lifecycle.I;
import androidx.lifecycle.InterfaceC0321s;
import androidx.lifecycle.c0;
import androidx.lifecycle.h0;
import androidx.lifecycle.k0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import c.C0384a;
import c.InterfaceC0385b;
import com.stepos.alphame.R;
import d.AbstractC0528b;
import d0.AbstractC0533c;
import d0.C0534d;
import j0.C0631f;
import j0.C0632g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class o extends androidx.core.app.k implements u0, InterfaceC0321s, j0.h, B, androidx.activity.result.h, androidx.core.content.h, androidx.core.content.i, androidx.core.app.z, androidx.core.app.A, InterfaceC0078j {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final androidx.activity.result.g mActivityResultRegistry;

    @LayoutRes
    private int mContentLayoutId;
    private q0 mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;

    @NonNull
    final q mFullyDrawnReporter;
    private final C0082n mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private A mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<J.a> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<J.a> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<J.a> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<J.a> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<J.a> mOnTrimMemoryListeners;
    final m mReportFullyDrawnExecutor;
    final C0632g mSavedStateRegistryController;
    private t0 mViewModelStore;
    final C0384a mContextAwareHelper = new C0384a();
    private final I mLifecycleRegistry = new I(this);

    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.activity.e] */
    public o() {
        int i4 = 0;
        this.mMenuHostHelper = new C0082n(new d(i4, this));
        C0632g c0632gE = E3.b.e(this);
        this.mSavedStateRegistryController = c0632gE;
        this.mOnBackPressedDispatcher = null;
        final G g4 = (G) this;
        n nVar = new n(g4);
        this.mReportFullyDrawnExecutor = nVar;
        this.mFullyDrawnReporter = new q(nVar, new Function0() { // from class: androidx.activity.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                g4.reportFullyDrawn();
                return null;
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new h(g4);
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
        getLifecycle().a(new i(this, 1));
        getLifecycle().a(new i(this, i4));
        getLifecycle().a(new i(this, 2));
        c0632gE.a();
        h0.c(this);
        getSavedStateRegistry().c(ACTIVITY_RESULT_TAG, new f(0, this));
        addOnContextAvailableListener(new g(g4, 0));
    }

    public static void a(o oVar) {
        Bundle bundleA = oVar.getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (bundleA != null) {
            androidx.activity.result.g gVar = oVar.mActivityResultRegistry;
            gVar.getClass();
            ArrayList<Integer> integerArrayList = bundleA.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList == null || integerArrayList == null) {
                return;
            }
            gVar.f2431d = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            Bundle bundle = bundleA.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
            Bundle bundle2 = gVar.f2434g;
            bundle2.putAll(bundle);
            for (int i4 = 0; i4 < stringArrayList.size(); i4++) {
                String str = stringArrayList.get(i4);
                HashMap map = gVar.f2429b;
                boolean zContainsKey = map.containsKey(str);
                HashMap map2 = gVar.f2428a;
                if (zContainsKey) {
                    Integer num = (Integer) map.remove(str);
                    if (!bundle2.containsKey(str)) {
                        map2.remove(num);
                    }
                }
                Integer num2 = integerArrayList.get(i4);
                num2.intValue();
                String str2 = stringArrayList.get(i4);
                map2.put(num2, str2);
                map.put(str2, num2);
            }
        }
    }

    public static Bundle b(o oVar) {
        oVar.getClass();
        Bundle bundle = new Bundle();
        androidx.activity.result.g gVar = oVar.mActivityResultRegistry;
        gVar.getClass();
        HashMap map = gVar.f2429b;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(map.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(map.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(gVar.f2431d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) gVar.f2434g.clone());
        return bundle;
    }

    @Override // K.InterfaceC0078j
    public void addMenuProvider(@NonNull InterfaceC0084p interfaceC0084p) {
        C0082n c0082n = this.mMenuHostHelper;
        c0082n.f991b.add(interfaceC0084p);
        c0082n.f990a.run();
    }

    @Override // androidx.core.content.h
    public final void addOnConfigurationChangedListener(@NonNull J.a aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(@NonNull InterfaceC0385b listener) {
        C0384a c0384a = this.mContextAwareHelper;
        c0384a.getClass();
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (c0384a.f4460b != null) {
            g gVar = (g) listener;
            int i4 = gVar.f2389a;
            o oVar = gVar.f2390b;
            switch (i4) {
                case 0:
                    a(oVar);
                    break;
                default:
                    G.c((G) oVar);
                    break;
            }
        }
        c0384a.f4459a.add(listener);
    }

    @Override // androidx.core.app.z
    public final void addOnMultiWindowModeChangedListener(@NonNull J.a aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(@NonNull J.a aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    @Override // androidx.core.app.A
    public final void addOnPictureInPictureModeChangedListener(@NonNull J.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    @Override // androidx.core.content.i
    public final void addOnTrimMemoryListener(@NonNull J.a aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            l lVar = (l) getLastNonConfigurationInstance();
            if (lVar != null) {
                this.mViewModelStore = lVar.f2396b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new t0();
            }
        }
    }

    @Override // androidx.activity.result.h
    @NonNull
    public final androidx.activity.result.g getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.InterfaceC0321s
    @NonNull
    @CallSuper
    public AbstractC0533c getDefaultViewModelCreationExtras() {
        C0534d c0534d = new C0534d();
        if (getApplication() != null) {
            c0534d.b(o0.f3973a, getApplication());
        }
        c0534d.b(h0.f3945a, this);
        c0534d.b(h0.f3946b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            c0534d.b(h0.f3947c, getIntent().getExtras());
        }
        return c0534d;
    }

    @Override // androidx.lifecycle.InterfaceC0321s
    @NonNull
    public q0 getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new k0(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    @NonNull
    public q getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Nullable
    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        l lVar = (l) getLastNonConfigurationInstance();
        if (lVar != null) {
            return lVar.f2395a;
        }
        return null;
    }

    @Override // androidx.lifecycle.G
    @NonNull
    public AbstractC0328z getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.B
    @NonNull
    public final A getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new A(new j(this));
            getLifecycle().a(new i(this, 3));
        }
        return this.mOnBackPressedDispatcher;
    }

    @Override // j0.h
    @NonNull
    public final C0631f getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f13127b;
    }

    @Override // androidx.lifecycle.u0
    @NonNull
    public t0 getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    @CallSuper
    public void initializeViewTreeOwners() {
        B0.f.r0(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullParameter(decorView, "<this>");
        decorView.setTag(R.id.view_tree_view_model_store_owner, this);
        com.airbnb.lottie.h.E(getWindow().getDecorView(), this);
        View decorView2 = getWindow().getDecorView();
        Intrinsics.checkNotNullParameter(decorView2, "<this>");
        Intrinsics.checkNotNullParameter(this, "onBackPressedDispatcherOwner");
        decorView2.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView3 = getWindow().getDecorView();
        Intrinsics.checkNotNullParameter(decorView3, "<this>");
        Intrinsics.checkNotNullParameter(this, "fullyDrawnReporterOwner");
        decorView3.setTag(R.id.report_drawn, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        if (this.mActivityResultRegistry.a(i4, i5, intent)) {
            return;
        }
        super.onActivityResult(i4, i5, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        getOnBackPressedDispatcher().a();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<J.a> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // androidx.core.app.k, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.b(bundle);
        C0384a c0384a = this.mContextAwareHelper;
        c0384a.getClass();
        Intrinsics.checkNotNullParameter(this, "context");
        c0384a.f4460b = this;
        Iterator it = c0384a.f4459a.iterator();
        while (it.hasNext()) {
            g gVar = (g) ((InterfaceC0385b) it.next());
            int i4 = gVar.f2389a;
            o oVar = gVar.f2390b;
            switch (i4) {
                case 0:
                    a(oVar);
                    break;
                default:
                    G.c((G) oVar);
                    break;
            }
        }
        super.onCreate(bundle);
        int i5 = c0.f3918a;
        y1.f.j(this);
        int i6 = this.mContentLayoutId;
        if (i6 != 0) {
            setContentView(i6);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i4, @NonNull Menu menu) {
        if (i4 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i4, menu);
        C0082n c0082n = this.mMenuHostHelper;
        MenuInflater menuInflater = getMenuInflater();
        Iterator it = c0082n.f991b.iterator();
        while (it.hasNext()) {
            ((S) ((InterfaceC0084p) it.next())).f3641a.j(menu, menuInflater);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        if (super.onMenuItemSelected(i4, menuItem)) {
            return true;
        }
        if (i4 == 0) {
            return this.mMenuHostHelper.a(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    @CallSuper
    public void onMultiWindowModeChanged(boolean z4) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<J.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.l(z4));
        }
    }

    @Override // android.app.Activity
    @CallSuper
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<J.a> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i4, Menu menu) {
        Iterator it = this.mMenuHostHelper.f991b.iterator();
        while (it.hasNext()) {
            ((S) ((InterfaceC0084p) it.next())).f3641a.p(menu);
        }
        super.onPanelClosed(i4, menu);
    }

    @Override // android.app.Activity
    @CallSuper
    public void onPictureInPictureModeChanged(boolean z4) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<J.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.B(z4));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i4, @Nullable View view, @NonNull Menu menu) {
        if (i4 != 0) {
            return true;
        }
        super.onPreparePanel(i4, view, menu);
        Iterator it = this.mMenuHostHelper.f991b.iterator();
        while (it.hasNext()) {
            ((S) ((InterfaceC0084p) it.next())).f3641a.s(menu);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.a(i4, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i4, strArr, iArr);
    }

    @Nullable
    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    @Nullable
    public final Object onRetainNonConfigurationInstance() {
        l lVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        t0 t0Var = this.mViewModelStore;
        if (t0Var == null && (lVar = (l) getLastNonConfigurationInstance()) != null) {
            t0Var = lVar.f2396b;
        }
        if (t0Var == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        l lVar2 = new l();
        lVar2.f2395a = objOnRetainCustomNonConfigurationInstance;
        lVar2.f2396b = t0Var;
        return lVar2;
    }

    @Override // androidx.core.app.k, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        AbstractC0328z lifecycle = getLifecycle();
        if (lifecycle instanceof I) {
            ((I) lifecycle).g();
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.c(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    @CallSuper
    public void onTrimMemory(int i4) {
        super.onTrimMemory(i4);
        Iterator<J.a> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i4));
        }
    }

    @Nullable
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.f4460b;
    }

    @NonNull
    public final <I, O> androidx.activity.result.b registerForActivityResult(@NonNull AbstractC0528b abstractC0528b, @NonNull androidx.activity.result.g gVar, @NonNull androidx.activity.result.a aVar) {
        return gVar.c("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, abstractC0528b, aVar);
    }

    @Override // K.InterfaceC0078j
    public void removeMenuProvider(@NonNull InterfaceC0084p interfaceC0084p) {
        this.mMenuHostHelper.b(interfaceC0084p);
    }

    @Override // androidx.core.content.h
    public final void removeOnConfigurationChangedListener(@NonNull J.a aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(@NonNull InterfaceC0385b listener) {
        C0384a c0384a = this.mContextAwareHelper;
        c0384a.getClass();
        Intrinsics.checkNotNullParameter(listener, "listener");
        c0384a.f4459a.remove(listener);
    }

    @Override // androidx.core.app.z
    public final void removeOnMultiWindowModeChangedListener(@NonNull J.a aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(@NonNull J.a aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    @Override // androidx.core.app.A
    public final void removeOnPictureInPictureModeChangedListener(@NonNull J.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    @Override // androidx.core.content.i
    public final void removeOnTrimMemoryListener(@NonNull J.a aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (Z2.I.x()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.mFullyDrawnReporter.a();
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public abstract void setContentView(int i4);

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.d(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@NonNull Intent intent, int i4) {
        super.startActivityForResult(intent, i4);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender intentSender, int i4, @Nullable Intent intent, int i5, int i6, int i7) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@NonNull Intent intent, int i4, @Nullable Bundle bundle) {
        super.startActivityForResult(intent, i4, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender intentSender, int i4, @Nullable Intent intent, int i5, int i6, int i7, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7, bundle);
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    @CallSuper
    public void onMultiWindowModeChanged(boolean z4, @NonNull Configuration newConfig) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z4, newConfig);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<J.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                J.a next = it.next();
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                next.accept(new androidx.core.app.l(z4));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    @CallSuper
    public void onPictureInPictureModeChanged(boolean z4, @NonNull Configuration newConfig) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z4, newConfig);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<J.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                J.a next = it.next();
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                next.accept(new androidx.core.app.B(z4));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @NonNull
    public final <I, O> androidx.activity.result.b registerForActivityResult(@NonNull AbstractC0528b abstractC0528b, @NonNull androidx.activity.result.a aVar) {
        return registerForActivityResult(abstractC0528b, this.mActivityResultRegistry, aVar);
    }

    public void addMenuProvider(@NonNull final InterfaceC0084p interfaceC0084p, @NonNull androidx.lifecycle.G g4) {
        final C0082n c0082n = this.mMenuHostHelper;
        c0082n.f991b.add(interfaceC0084p);
        c0082n.f990a.run();
        AbstractC0328z lifecycle = g4.getLifecycle();
        HashMap map = c0082n.f992c;
        C0081m c0081m = (C0081m) map.remove(interfaceC0084p);
        if (c0081m != null) {
            c0081m.f987a.b(c0081m.f988b);
            c0081m.f988b = null;
        }
        map.put(interfaceC0084p, new C0081m(lifecycle, new E() { // from class: K.l
            @Override // androidx.lifecycle.E
            public final void a(androidx.lifecycle.G g5, EnumC0326x enumC0326x) {
                EnumC0326x enumC0326x2 = EnumC0326x.ON_DESTROY;
                C0082n c0082n2 = c0082n;
                if (enumC0326x == enumC0326x2) {
                    c0082n2.b(interfaceC0084p);
                } else {
                    c0082n2.getClass();
                }
            }
        }));
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull final InterfaceC0084p interfaceC0084p, @NonNull androidx.lifecycle.G g4, @NonNull final EnumC0327y enumC0327y) {
        final C0082n c0082n = this.mMenuHostHelper;
        c0082n.getClass();
        AbstractC0328z lifecycle = g4.getLifecycle();
        HashMap map = c0082n.f992c;
        C0081m c0081m = (C0081m) map.remove(interfaceC0084p);
        if (c0081m != null) {
            c0081m.f987a.b(c0081m.f988b);
            c0081m.f988b = null;
        }
        map.put(interfaceC0084p, new C0081m(lifecycle, new E() { // from class: K.k
            @Override // androidx.lifecycle.E
            public final void a(androidx.lifecycle.G g5, EnumC0326x enumC0326x) {
                C0082n c0082n2 = c0082n;
                c0082n2.getClass();
                EnumC0326x.Companion.getClass();
                EnumC0327y state = enumC0327y;
                Intrinsics.checkNotNullParameter(state, "state");
                int i4 = AbstractC0323u.$EnumSwitchMapping$0[state.ordinal()];
                EnumC0326x enumC0326x2 = i4 != 1 ? i4 != 2 ? i4 != 3 ? null : EnumC0326x.ON_RESUME : EnumC0326x.ON_START : EnumC0326x.ON_CREATE;
                Runnable runnable = c0082n2.f990a;
                CopyOnWriteArrayList copyOnWriteArrayList = c0082n2.f991b;
                InterfaceC0084p interfaceC0084p2 = interfaceC0084p;
                if (enumC0326x == enumC0326x2) {
                    copyOnWriteArrayList.add(interfaceC0084p2);
                    runnable.run();
                } else if (enumC0326x == EnumC0326x.ON_DESTROY) {
                    c0082n2.b(interfaceC0084p2);
                } else if (enumC0326x == C0324v.a(state)) {
                    copyOnWriteArrayList.remove(interfaceC0084p2);
                    runnable.run();
                }
            }
        }));
    }
}
