package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.a1;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.m0;
import androidx.lifecycle.o0;
import androidx.lifecycle.s0;
import androidx.lifecycle.t0;
import androidx.lifecycle.v0;
import androidx.lifecycle.z0;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class p extends d3.c implements d1, androidx.lifecycle.k, t4.f, g0, d.i {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final d.h mActivityResultRegistry;
    private int mContentLayoutId;
    final c.a mContextAwareHelper;
    private a1 mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final t mFullyDrawnReporter;
    private final androidx.lifecycle.z mLifecycleRegistry;
    private final n3.m mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private e0 mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<m3.a> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<m3.a> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<m3.a> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<m3.a> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<m3.a> mOnTrimMemoryListeners;
    final n mReportFullyDrawnExecutor;
    final t4.e mSavedStateRegistryController;
    private c1 mViewModelStore;

    public p() {
        c.a aVar = new c.a();
        aVar.f2091a = new CopyOnWriteArraySet();
        VarHandle.storeStoreFence();
        this.mContextAwareHelper = aVar;
        a4.t tVar = new a4.t(4);
        tVar.f200f = this;
        VarHandle.storeStoreFence();
        this.mMenuHostHelper = new n3.m(tVar);
        int i = 1;
        this.mLifecycleRegistry = new androidx.lifecycle.z(this, true);
        ab.e eVar = new ab.e(16);
        eVar.f393f = this;
        VarHandle.storeStoreFence();
        v4.b bVar = new v4.b();
        bVar.f14764a = this;
        bVar.f14765b = eVar;
        bVar.f14766c = new r2.i(22);
        bVar.f14767d = new LinkedHashMap();
        bVar.f14771h = true;
        VarHandle.storeStoreFence();
        t4.e eVar2 = new t4.e();
        eVar2.f13169a = bVar;
        t4.d dVar = new t4.d();
        dVar.f13167a = bVar;
        VarHandle.storeStoreFence();
        eVar2.f13170b = dVar;
        VarHandle.storeStoreFence();
        this.mSavedStateRegistryController = eVar2;
        this.mOnBackPressedDispatcher = null;
        o oVar = new o();
        oVar.f692h = this;
        oVar.f689c = SystemClock.uptimeMillis() + 10000;
        int i3 = 0;
        oVar.f691g = false;
        VarHandle.storeStoreFence();
        this.mReportFullyDrawnExecutor = oVar;
        t tVar2 = new t();
        tVar2.f696a = new Object();
        tVar2.f698c = new ArrayList();
        VarHandle.storeStoreFence();
        this.mFullyDrawnReporter = tVar2;
        this.mNextLocalRequestCode = new AtomicInteger();
        i iVar = new i();
        iVar.f680h = this;
        iVar.f2935a = new HashMap();
        iVar.f2936b = new HashMap();
        iVar.f2937c = new HashMap();
        iVar.f2938d = new ArrayList();
        iVar.f2939e = new HashMap();
        iVar.f2940f = new HashMap();
        iVar.f2941g = new Bundle();
        VarHandle.storeStoreFence();
        this.mActivityResultRegistry = iVar;
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) {
            od.f.e("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
            throw null;
        }
        androidx.lifecycle.q lifecycle = getLifecycle();
        j jVar = new j(i);
        jVar.f685f = this;
        VarHandle.storeStoreFence();
        lifecycle.a(jVar);
        androidx.lifecycle.q lifecycle2 = getLifecycle();
        j jVar2 = new j(i3);
        jVar2.f685f = this;
        VarHandle.storeStoreFence();
        lifecycle2.a(jVar2);
        androidx.lifecycle.q lifecycle3 = getLifecycle();
        j jVar3 = new j(2);
        jVar3.f685f = this;
        VarHandle.storeStoreFence();
        lifecycle3.a(jVar3);
        bVar.a();
        androidx.lifecycle.p pVarB = getLifecycle().b();
        if (pVarB != androidx.lifecycle.p.f1419f && pVarB != androidx.lifecycle.p.f1420g) {
            g5.f.s("Failed requirement.");
            throw null;
        }
        if (getSavedStateRegistry().b() == null) {
            t4.d savedStateRegistry = getSavedStateRegistry();
            savedStateRegistry.getClass();
            t0 t0Var = new t0();
            t0Var.f1437a = savedStateRegistry;
            e eVar3 = new e();
            eVar3.f663f = this;
            VarHandle.storeStoreFence();
            t0Var.f1440d = new jb.k(eVar3);
            VarHandle.storeStoreFence();
            getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", t0Var);
            androidx.lifecycle.q lifecycle4 = getLifecycle();
            androidx.lifecycle.e eVar4 = new androidx.lifecycle.e(i);
            eVar4.f1379f = t0Var;
            VarHandle.storeStoreFence();
            lifecycle4.a(eVar4);
        }
        t4.d savedStateRegistry2 = getSavedStateRegistry();
        f fVar = new f(i3);
        fVar.f672b = this;
        VarHandle.storeStoreFence();
        savedStateRegistry2.c(ACTIVITY_RESULT_TAG, fVar);
        g gVar = new g();
        gVar.f675a = this;
        VarHandle.storeStoreFence();
        addOnContextAvailableListener(gVar);
    }

    public static void a(p pVar) {
        Bundle bundleA = pVar.getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (bundleA != null) {
            d.h hVar = pVar.mActivityResultRegistry;
            HashMap map = hVar.f2936b;
            HashMap map2 = hVar.f2935a;
            Bundle bundle = hVar.f2941g;
            ArrayList<Integer> integerArrayList = bundleA.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList == null || integerArrayList == null) {
                return;
            }
            hVar.f2938d = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            bundle.putAll(bundleA.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
            for (int i = 0; i < stringArrayList.size(); i++) {
                String str = stringArrayList.get(i);
                if (map.containsKey(str)) {
                    Integer num = (Integer) map.remove(str);
                    if (!bundle.containsKey(str)) {
                        map2.remove(num);
                    }
                }
                Integer num2 = integerArrayList.get(i);
                num2.intValue();
                String str2 = stringArrayList.get(i);
                map2.put(num2, str2);
                hVar.f2936b.put(str2, num2);
            }
        }
    }

    public static Bundle b(p pVar) {
        Bundle bundle = new Bundle();
        d.h hVar = pVar.mActivityResultRegistry;
        hVar.getClass();
        HashMap map = hVar.f2936b;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(map.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(map.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(hVar.f2938d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) hVar.f2941g.clone());
        return bundle;
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        ((o) this.mReportFullyDrawnExecutor).a(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    public void addMenuProvider(n3.n nVar, androidx.lifecycle.x xVar) {
        n3.m mVar = this.mMenuHostHelper;
        mVar.f8731b.add(nVar);
        mVar.f8730a.run();
        androidx.lifecycle.q lifecycle = xVar.getLifecycle();
        HashMap map = mVar.f8732c;
        n3.l lVar = (n3.l) map.remove(nVar);
        if (lVar != null) {
            lVar.f8727a.c(lVar.f8728b);
            lVar.f8728b = null;
        }
        n3.k kVar = new n3.k();
        kVar.f8722c = mVar;
        kVar.f8723f = nVar;
        VarHandle.storeStoreFence();
        map.put(nVar, new n3.l(lifecycle, kVar));
    }

    public final void addOnConfigurationChangedListener(m3.a aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(c.b bVar) {
        c.a aVar = this.mContextAwareHelper;
        aVar.getClass();
        bVar.getClass();
        p pVar = aVar.f2092b;
        if (pVar != null) {
            bVar.a(pVar);
        }
        aVar.f2091a.add(bVar);
    }

    public final void addOnMultiWindowModeChangedListener(m3.a aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(m3.a aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    public final void addOnPictureInPictureModeChangedListener(m3.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    public final void addOnTrimMemoryListener(m3.a aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            m mVar = (m) getLastNonConfigurationInstance();
            if (mVar != null) {
                this.mViewModelStore = mVar.f688b;
            }
            if (this.mViewModelStore == null) {
                c1 c1Var = new c1();
                c1Var.f1366a = new LinkedHashMap();
                VarHandle.storeStoreFence();
                this.mViewModelStore = c1Var;
            }
        }
    }

    @Override // d.i
    public final d.h getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.k
    public h4.b getDefaultViewModelCreationExtras() {
        h4.c cVar = new h4.c(h4.a.f5289b);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = cVar.f5290a;
        if (application != null) {
            linkedHashMap.put(z0.f1463j, getApplication());
        }
        linkedHashMap.put(s0.f1433a, this);
        linkedHashMap.put(s0.f1434b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            linkedHashMap.put(s0.f1435c, getIntent().getExtras());
        }
        return cVar;
    }

    @Override // androidx.lifecycle.k
    public a1 getDefaultViewModelProviderFactory() {
        z0 z0Var;
        if (this.mDefaultFactory == null) {
            Application application = getApplication();
            Bundle extras = getIntent() != null ? getIntent().getExtras() : null;
            v0 v0Var = new v0();
            v0Var.i = getSavedStateRegistry();
            v0Var.f1446h = getLifecycle();
            v0Var.f1445g = extras;
            v0Var.f1443c = application;
            if (application != null) {
                if (z0.i == null) {
                    z0.i = new z0(application);
                }
                z0Var = z0.i;
                z0Var.getClass();
            } else {
                z0Var = new z0(null);
            }
            v0Var.f1444f = z0Var;
            VarHandle.storeStoreFence();
            this.mDefaultFactory = v0Var;
        }
        return this.mDefaultFactory;
    }

    public t getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        m mVar = (m) getLastNonConfigurationInstance();
        if (mVar != null) {
            return mVar.f687a;
        }
        return null;
    }

    @Override // androidx.lifecycle.x
    public androidx.lifecycle.q getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.g0
    public final e0 getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            k kVar = new k();
            kVar.f686c = this;
            VarHandle.storeStoreFence();
            this.mOnBackPressedDispatcher = new e0(kVar);
            androidx.lifecycle.q lifecycle = getLifecycle();
            j jVar = new j(3);
            jVar.f685f = this;
            VarHandle.storeStoreFence();
            lifecycle.a(jVar);
        }
        return this.mOnBackPressedDispatcher;
    }

    @Override // t4.f
    public final t4.d getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f13170b;
    }

    @Override // androidx.lifecycle.d1
    public c1 getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        od.f.e("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        return null;
    }

    public void initializeViewTreeOwners() {
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        decorView2.getClass();
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        decorView3.getClass();
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        decorView4.getClass();
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        decorView5.getClass();
        decorView5.setTag(R.id.report_drawn, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i3, Intent intent) {
        if (this.mActivityResultRegistry.a(i, i3, intent)) {
            return;
        }
        super.onActivityResult(i, i3, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        getOnBackPressedDispatcher().b();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<m3.a> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // d3.c, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.a(bundle);
        c.a aVar = this.mContextAwareHelper;
        aVar.getClass();
        aVar.f2092b = this;
        Iterator it = aVar.f2091a.iterator();
        while (it.hasNext()) {
            ((c.b) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i = o0.f1417c;
        m0.b(this);
        int i3 = this.mContentLayoutId;
        if (i3 != 0) {
            setContentView(i3);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        n3.m mVar = this.mMenuHostHelper;
        getMenuInflater();
        mVar.a();
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            this.mMenuHostHelper.b();
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z10, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<m3.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                m3.a next = it.next();
                configuration.getClass();
                next.accept(new d3.d(z10));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<m3.a> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        Iterator it = this.mMenuHostHelper.f8731b.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.v vVar = ((androidx.fragment.app.p) ((n3.n) it.next())).f1297a;
            if (vVar.f1320q >= 1) {
                Iterator it2 = vVar.f1307c.c().iterator();
                while (it2.hasNext()) {
                    if (it2.next() != null) {
                        od.f.j();
                        return;
                    }
                }
            }
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z10, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<m3.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                m3.a next = it.next();
                configuration.getClass();
                next.accept(new d3.f(z10));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        this.mMenuHostHelper.c();
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        m mVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        c1 c1Var = this.mViewModelStore;
        if (c1Var == null && (mVar = (m) getLastNonConfigurationInstance()) != null) {
            c1Var = mVar.f688b;
        }
        if (c1Var == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        m mVar2 = new m();
        mVar2.f687a = objOnRetainCustomNonConfigurationInstance;
        mVar2.f688b = c1Var;
        return mVar2;
    }

    @Override // d3.c, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.q lifecycle = getLifecycle();
        if (lifecycle instanceof androidx.lifecycle.z) {
            androidx.lifecycle.z zVar = (androidx.lifecycle.z) lifecycle;
            androidx.lifecycle.p pVar = androidx.lifecycle.p.f1420g;
            zVar.e("setCurrentState");
            zVar.g(pVar);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator<m3.a> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.f2092b;
    }

    public final <I, O> d.c registerForActivityResult(e.b bVar, d.h hVar, d.b bVar2) {
        String str = "activity_rq#" + this.mNextLocalRequestCode.getAndIncrement();
        HashMap map = hVar.f2937c;
        androidx.lifecycle.q lifecycle = getLifecycle();
        if (lifecycle.b().compareTo(androidx.lifecycle.p.f1421h) >= 0) {
            StringBuilder sb2 = new StringBuilder("LifecycleOwner ");
            sb2.append(this);
            androidx.lifecycle.p pVarB = lifecycle.b();
            sb2.append(" is attempting to register while current state is ");
            sb2.append(pVarB);
            sb2.append(". LifecycleOwners must call register before they are STARTED.");
            throw new IllegalStateException(sb2.toString());
        }
        hVar.d(str);
        d.g gVar = (d.g) map.get(str);
        if (gVar == null) {
            gVar = new d.g();
            gVar.f2933a = lifecycle;
            gVar.f2934b = new ArrayList();
            VarHandle.storeStoreFence();
        }
        d.d dVar = new d.d();
        dVar.f2926h = hVar;
        dVar.f2923c = str;
        dVar.f2924f = bVar2;
        dVar.f2925g = bVar;
        VarHandle.storeStoreFence();
        gVar.f2933a.a(dVar);
        gVar.f2934b.add(dVar);
        map.put(str, gVar);
        d.e eVar = new d.e(0);
        eVar.f2930d = hVar;
        eVar.f2928b = str;
        eVar.f2929c = bVar;
        VarHandle.storeStoreFence();
        return eVar;
    }

    public void removeMenuProvider(n3.n nVar) {
        this.mMenuHostHelper.d(nVar);
    }

    public final void removeOnConfigurationChangedListener(m3.a aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(c.b bVar) {
        c.a aVar = this.mContextAwareHelper;
        aVar.getClass();
        bVar.getClass();
        aVar.f2091a.remove(bVar);
    }

    public final void removeOnMultiWindowModeChangedListener(m3.a aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(m3.a aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    public final void removeOnPictureInPictureModeChangedListener(m3.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    public final void removeOnTrimMemoryListener(m3.a aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (c5.a.a()) {
                Trace.beginSection(com.stepos.statsrpk.h.J("reportFullyDrawn() for ComponentActivity"));
            }
            super.reportFullyDrawn();
            t tVar = this.mFullyDrawnReporter;
            synchronized (tVar.f696a) {
                try {
                    tVar.f697b = true;
                    ArrayList arrayList = tVar.f698c;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((xb.a) obj).invoke();
                    }
                    tVar.f698c.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        initializeViewTreeOwners();
        ((o) this.mReportFullyDrawnExecutor).a(getWindow().getDecorView());
        super.setContentView(i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i3, int i10, int i11) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i3, i10, i11);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i3, int i10, int i11, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i3, i10, i11, bundle);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initializeViewTreeOwners();
        ((o) this.mReportFullyDrawnExecutor).a(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        ((o) this.mReportFullyDrawnExecutor).a(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<m3.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new d3.d(z10));
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<m3.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new d3.f(z10));
        }
    }

    public void addMenuProvider(n3.n nVar) {
        n3.m mVar = this.mMenuHostHelper;
        mVar.f8731b.add(nVar);
        mVar.f8730a.run();
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(n3.n nVar, androidx.lifecycle.x xVar, androidx.lifecycle.p pVar) {
        n3.m mVar = this.mMenuHostHelper;
        mVar.getClass();
        androidx.lifecycle.q lifecycle = xVar.getLifecycle();
        HashMap map = mVar.f8732c;
        n3.l lVar = (n3.l) map.remove(nVar);
        if (lVar != null) {
            lVar.f8727a.c(lVar.f8728b);
            lVar.f8728b = null;
        }
        k8.r rVar = new k8.r(1);
        rVar.f7340f = mVar;
        rVar.f7341g = pVar;
        rVar.f7342h = nVar;
        VarHandle.storeStoreFence();
        map.put(nVar, new n3.l(lifecycle, rVar));
    }

    public final <I, O> d.c registerForActivityResult(e.b bVar, d.b bVar2) {
        return registerForActivityResult(bVar, this.mActivityResultRegistry, bVar2);
    }
}
