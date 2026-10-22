package androidx.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.core.app.o;
import androidx.core.view.h;
import androidx.core.view.j;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.ad;
import androidx.lifecycle.ag;
import androidx.lifecycle.am;
import androidx.lifecycle.ao;
import androidx.lifecycle.ap;
import androidx.lifecycle.aq;
import androidx.lifecycle.ar;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.p;
import androidx.lifecycle.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements d, androidx.activity.result.d, ap, g, p, androidx.savedstate.c {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final androidx.activity.result.c mActivityResultRegistry;
    private int mContentLayoutId;
    final androidx.activity.a.a mContextAwareHelper;
    private am.b mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    private final r mLifecycleRegistry;
    private final h mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<androidx.core.util.a<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<androidx.core.app.g>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<o>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<Integer>> mOnTrimMemoryListeners;
    final androidx.savedstate.b mSavedStateRegistryController;
    private ao mViewModelStore;

    static class a {
        static void a(View r0) {
            r0.cancelPendingInputEvents();
        }
    }

    static class b {
        static OnBackInvokedDispatcher a(Activity r2) {
            return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).getOnBackInvokedDispatcher();
        }
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ao f125b;

        c() {
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    static /* synthetic */ void access$001(ComponentActivity r2) {
        super.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentActivity() {
        this.mContextAwareHelper = new androidx.activity.a.a();
        this.mMenuHostHelper = new h(new $$Lambda$6vUCJMIem6_TsIeNg4KPj4HWSJA(this));
        this.mLifecycleRegistry = new r(this);
        androidx.savedstate.b r0 = androidx.savedstate.b.a(this);
        this.mSavedStateRegistryController = r0;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new AnonymousClass1(this));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new AnonymousClass2(this);
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) goto L15;
        if (Build.VERSION.SDK_INT < 19) goto L7;
        getLifecycle().a(new AnonymousClass3(this));
    L7:
        getLifecycle().a(new AnonymousClass4(this));
        getLifecycle().a(new AnonymousClass5(this));
        r0.b();
        ad.a(this);
        if (19 <= Build.VERSION.SDK_INT) goto L10;
    L12:
        getSavedStateRegistry().a(ACTIVITY_RESULT_TAG, new $$Lambda$ComponentActivity$Wl8cUWFOdVF_K0Mj_K8gyR0iDU(this));
        addOnContextAvailableListener(new $$Lambda$ComponentActivity$9ZiiF6nfLyBDqQpVNRWhzqlg10(this));
        return;
    L10:
        if (Build.VERSION.SDK_INT > 23) goto L12;
        getLifecycle().a(new ImmLeaksCleaner(this));
        goto L12
    L15:
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public /* synthetic */ Bundle lambda$new$0$ComponentActivity() {
        Bundle r0 = new Bundle();
        this.mActivityResultRegistry.a(r0);
        return r0;
    }

    public /* synthetic */ void lambda$new$1$ComponentActivity(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Bundle r5 = getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (r5 == null) goto L6;
        this.mActivityResultRegistry.b(r5);
        return;
    }

    public ComponentActivity(int r1) {
        this();
        this.mContentLayoutId = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.core.app.ComponentActivity
    public void onCreate(Bundle r2) {
        this.mSavedStateRegistryController.a(r2);
        this.mContextAwareHelper.a(this);
        super.onCreate(r2);
        ReportFragment.injectIfNeededIn(this);
        if (androidx.core.os.a.a() == false) goto L5;
        this.mOnBackPressedDispatcher.a(b.a(this));
    L5:
        int r3 = this.mContentLayoutId;
        if (r3 == 0) goto L9;
        setContentView(r3);
        return;
    }

    @Override // androidx.core.app.ComponentActivity
    public void onSaveInstanceState(Bundle r4) {
        i r0 = getLifecycle();
        if (ZeusTransformUtils.instanceOf(r0, r.class) == false) goto L5;
        ((r) ZeusTransformUtils.preCheckCast(r0, r.class, "com.obric.aiagent.plugin")).b(i.b.f2056c);
    L5:
        super.onSaveInstanceState(r4);
        this.mSavedStateRegistryController.b(r4);
    }

    public final Object onRetainNonConfigurationInstance() {
        Object r0 = onRetainCustomNonConfigurationInstance();
        ao r1 = this.mViewModelStore;
        if (r1 != null) goto L7;
        c r4 = (c) ZeusTransformUtils.preCheckCast(getLastNonConfigurationInstance(), c.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L7;
        r1 = r4.f125b;
    L7:
        if (r1 != null) goto L11;
        if (r0 != null) goto L11;
        return null;
    L11:
        c r5 = new c();
        r5.f124a = r0;
        r5.f125b = r1;
        return r5;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        c r2 = (c) ZeusTransformUtils.preCheckCast(getLastNonConfigurationInstance(), c.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.f124a;
    }

    public void setContentView(int r1) {
        initViewTreeOwners();
        super.setContentView(r1);
    }

    public void setContentView(View r1) {
        initViewTreeOwners();
        super.setContentView(r1);
    }

    public void setContentView(View r1, ViewGroup.LayoutParams r2) {
        initViewTreeOwners();
        super.setContentView(r1, r2);
    }

    public void addContentView(View r1, ViewGroup.LayoutParams r2) {
        initViewTreeOwners();
        super.addContentView(r1, r2);
    }

    private void initViewTreeOwners() {
        aq.a(getWindow().getDecorView(), this);
        ar.a(getWindow().getDecorView(), this);
        androidx.savedstate.d.a(getWindow().getDecorView(), this);
        f.a(getWindow().getDecorView(), this);
    }

    public Context peekAvailableContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mContextAwareHelper.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    public final void addOnContextAvailableListener(androidx.activity.a.b r3) {
        androidx.activity.a.b r4 = (androidx.activity.a.b) ZeusTransformUtils.wrapperContextForParams(r3, androidx.activity.a.b.class, "com.obric.aiagent.plugin");
        this.mContextAwareHelper.a(r4);
    }

    public final void removeOnContextAvailableListener(androidx.activity.a.b r3) {
        androidx.activity.a.b r4 = (androidx.activity.a.b) ZeusTransformUtils.wrapperContextForParams(r3, androidx.activity.a.b.class, "com.obric.aiagent.plugin");
        this.mContextAwareHelper.b(r4);
    }

    public boolean onPreparePanel(int r3, View r4, Menu r5) {
        Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.aiagent.plugin");
        if (r3 != 0) goto L7;
        super.onPreparePanel(r3, r4, r6);
        this.mMenuHostHelper.a(r6);
        return true;
    L7:
        return true;
    }

    public boolean onCreatePanelMenu(int r3, Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        if (r3 != 0) goto L7;
        super.onCreatePanelMenu(r3, r5);
        this.mMenuHostHelper.a(r5, getMenuInflater());
        return true;
    L7:
        return true;
    }

    public boolean onMenuItemSelected(int r3, MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.aiagent.plugin");
        if (super.onMenuItemSelected(r3, r5) == false) goto L6;
        return true;
    L6:
        if (r3 == 0) goto L8;
        return false;
    L8:
        return this.mMenuHostHelper.a(r5);
    }

    public void onPanelClosed(int r3, Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        this.mMenuHostHelper.b(r5);
        super.onPanelClosed(r3, r5);
    }

    public void addMenuProvider(j r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        this.mMenuHostHelper.a(r4);
    }

    public void addMenuProvider(j r3, p r4) {
        j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
        this.mMenuHostHelper.a(r5, r6);
    }

    public void addMenuProvider(j r3, p r4, i.b r5) {
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        p r7 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
        this.mMenuHostHelper.a(r6, r7, r5);
    }

    public void removeMenuProvider(j r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        this.mMenuHostHelper.b(r4);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.p
    public i getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.lifecycle.ap
    public ao getViewModelStore() {
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")) == null) goto L7;
        ensureViewModelStore();
        return this.mViewModelStore;
    L7:
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore != null) goto L11;
        c r0 = (c) ZeusTransformUtils.preCheckCast(getLastNonConfigurationInstance(), c.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L8;
        this.mViewModelStore = r0.f125b;
    L8:
        if (this.mViewModelStore != null) goto L12;
        this.mViewModelStore = new ao();
        return;
    L12:
        return;
    }

    @Override // androidx.lifecycle.g
    public am.b getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory != null) goto L10;
        Application r1 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        if (getIntent() == null) goto L7;
        Bundle r2 = getIntent().getExtras();
    L8:
        this.mDefaultFactory = new ag(r1, this, r2);
        goto L10
    L7:
        r2 = null;
    L10:
        return this.mDefaultFactory;
    }

    @Override // androidx.lifecycle.g
    public androidx.lifecycle.a.a getDefaultViewModelCreationExtras() {
        androidx.lifecycle.a.d r0 = new androidx.lifecycle.a.d();
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")) == null) goto L5;
        r0.a(am.a.f2029b, (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));
    L5:
        r0.a(ad.f1994a, this);
        r0.a(ad.f1995b, this);
        if (getIntent() != null) goto L8;
    L10:
        return r0;
    L8:
        if (getIntent().getExtras() == null) goto L10;
        r0.a(ad.f1996c, getIntent().getExtras());
        goto L10
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.c();
    }

    @Override // androidx.activity.d
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.c
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.a();
    }

    @Deprecated
    public void startActivityForResult(Intent r1, int r2) {
        super.startActivityForResult(r1, r2);
    }

    @Deprecated
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender r1, int r2, Intent r3, int r4, int r5, int r6) {
        super.startIntentSenderForResult(r1, r2, r3, r4, r5, r6);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender r1, int r2, Intent r3, int r4, int r5, int r6, Bundle r7) {
        super.startIntentSenderForResult(r1, r2, r3, r4, r5, r6, r7);
    }

    @Deprecated
    public void onActivityResult(int r2, int r3, Intent r4) {
        if (this.mActivityResultRegistry.a(r2, r3, r4) == true) goto L6;
        super.onActivityResult(r2, r3, r4);
        return;
    }

    @Deprecated
    public void onRequestPermissionsResult(int r4, String[] r5, int[] r6) {
        if (this.mActivityResultRegistry.a(r4, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", r5).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", r6)) == false) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        super.onRequestPermissionsResult(r4, r5, r6);
        return;
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.a.a<I, O> r3, androidx.activity.result.c r4, androidx.activity.result.a<O> r5) {
        return r4.a("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, r3, (androidx.activity.result.a) ZeusTransformUtils.wrapperContextForParams(r5, androidx.activity.result.a.class, "com.obric.aiagent.plugin"));
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.a.a<I, O> r3, androidx.activity.result.a<O> r4) {
        androidx.activity.result.a<O> r5 = (androidx.activity.result.a) ZeusTransformUtils.wrapperContextForParams(r4, androidx.activity.result.a.class, "com.obric.aiagent.plugin");
        return registerForActivityResult(r3, this.mActivityResultRegistry, r5);
    }

    @Override // androidx.activity.result.d
    public final androidx.activity.result.c getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    public void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        Iterator<androidx.core.util.a<Configuration>> r3 = this.mOnConfigurationChangedListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((androidx.core.util.a) ZeusTransformUtils.preCheckCast(r3.next(), androidx.core.util.a.class, "com.obric.aiagent.plugin")).accept(r4);
        goto L4
    }

    public final void addOnConfigurationChangedListener(androidx.core.util.a<Configuration> r3) {
        androidx.core.util.a<Configuration> r4 = (androidx.core.util.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.util.a.class, "com.obric.aiagent.plugin");
        this.mOnConfigurationChangedListeners.add(r4);
    }

    public final void removeOnConfigurationChangedListener(androidx.core.util.a<Configuration> r3) {
        androidx.core.util.a r4 = (androidx.core.util.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.util.a.class, "com.obric.aiagent.plugin");
        this.mOnConfigurationChangedListeners.remove(r4);
    }

    public void onTrimMemory(int r4) {
        super.onTrimMemory(r4);
        Iterator<androidx.core.util.a<Integer>> r3 = this.mOnTrimMemoryListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((androidx.core.util.a) ZeusTransformUtils.preCheckCast(r3.next(), androidx.core.util.a.class, "com.obric.aiagent.plugin")).accept(Integer.valueOf(r4));
        goto L4
    }

    public final void addOnTrimMemoryListener(androidx.core.util.a<Integer> r3) {
        androidx.core.util.a<Integer> r4 = (androidx.core.util.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.util.a.class, "com.obric.aiagent.plugin");
        this.mOnTrimMemoryListeners.add(r4);
    }

    public final void removeOnTrimMemoryListener(androidx.core.util.a<Integer> r3) {
        androidx.core.util.a r4 = (androidx.core.util.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.util.a.class, "com.obric.aiagent.plugin");
        this.mOnTrimMemoryListeners.remove(r4);
    }

    public void onNewIntent(Intent r4) {
        super.onNewIntent(r4);
        Iterator<androidx.core.util.a<Intent>> r3 = this.mOnNewIntentListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((androidx.core.util.a) ZeusTransformUtils.preCheckCast(r3.next(), androidx.core.util.a.class, "com.obric.aiagent.plugin")).accept(r4);
        goto L4
    }

    public final void addOnNewIntentListener(androidx.core.util.a<Intent> r3) {
        androidx.core.util.a<Intent> r4 = (androidx.core.util.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.util.a.class, "com.obric.aiagent.plugin");
        this.mOnNewIntentListeners.add(r4);
    }

    public final void removeOnNewIntentListener(androidx.core.util.a<Intent> r3) {
        androidx.core.util.a r4 = (androidx.core.util.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.util.a.class, "com.obric.aiagent.plugin");
        this.mOnNewIntentListeners.remove(r4);
    }

    public void onMultiWindowModeChanged(boolean r4) {
        if (this.mDispatchingOnMultiWindowModeChanged == false) goto L5;
        return;
    L5:
        Iterator<androidx.core.util.a<androidx.core.app.g>> r3 = this.mOnMultiWindowModeChangedListeners.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((androidx.core.util.a) ZeusTransformUtils.preCheckCast(r3.next(), androidx.core.util.a.class, "com.obric.aiagent.plugin")).accept(new androidx.core.app.g(r4));
        goto L7
    }

    public void onMultiWindowModeChanged(boolean r4, Configuration r5) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        super.onMultiWindowModeChanged(r4, r5);     // Catch: Throwable -> L9
        this.mDispatchingOnMultiWindowModeChanged = false;
        Iterator<androidx.core.util.a<androidx.core.app.g>> r3 = this.mOnMultiWindowModeChangedListeners.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        ((androidx.core.util.a) ZeusTransformUtils.preCheckCast(r3.next(), androidx.core.util.a.class, "com.obric.aiagent.plugin")).accept(new androidx.core.app.g(r4, r5));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnMultiWindowModeChanged = false;
        throw th;
    }

    public final void addOnMultiWindowModeChangedListener(androidx.core.util.a<androidx.core.app.g> r3) {
        androidx.core.util.a<androidx.core.app.g> r4 = (androidx.core.util.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.util.a.class, "com.obric.aiagent.plugin");
        this.mOnMultiWindowModeChangedListeners.add(r4);
    }

    public final void removeOnMultiWindowModeChangedListener(androidx.core.util.a<androidx.core.app.g> r3) {
        androidx.core.util.a r4 = (androidx.core.util.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.util.a.class, "com.obric.aiagent.plugin");
        this.mOnMultiWindowModeChangedListeners.remove(r4);
    }

    public void onPictureInPictureModeChanged(boolean r4) {
        if (this.mDispatchingOnPictureInPictureModeChanged == false) goto L5;
        return;
    L5:
        Iterator<androidx.core.util.a<o>> r3 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((androidx.core.util.a) ZeusTransformUtils.preCheckCast(r3.next(), androidx.core.util.a.class, "com.obric.aiagent.plugin")).accept(new o(r4));
        goto L7
    }

    public void onPictureInPictureModeChanged(boolean r4, Configuration r5) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        super.onPictureInPictureModeChanged(r4, r5);     // Catch: Throwable -> L9
        this.mDispatchingOnPictureInPictureModeChanged = false;
        Iterator<androidx.core.util.a<o>> r3 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        ((androidx.core.util.a) ZeusTransformUtils.preCheckCast(r3.next(), androidx.core.util.a.class, "com.obric.aiagent.plugin")).accept(new o(r4, r5));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        throw th;
    }

    public final void addOnPictureInPictureModeChangedListener(androidx.core.util.a<o> r3) {
        androidx.core.util.a<o> r4 = (androidx.core.util.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.util.a.class, "com.obric.aiagent.plugin");
        this.mOnPictureInPictureModeChangedListeners.add(r4);
    }

    public final void removeOnPictureInPictureModeChangedListener(androidx.core.util.a<o> r3) {
        androidx.core.util.a r4 = (androidx.core.util.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.util.a.class, "com.obric.aiagent.plugin");
        this.mOnPictureInPictureModeChangedListeners.remove(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reportFullyDrawn() {
    L15:
        th = move-exception;
        androidx.d.a.b();
        throw th;
    L3:
        if (androidx.d.a.a() == false) goto L6;
        androidx.d.a.a("reportFullyDrawn() for ComponentActivity");     // Catch: Throwable -> L15
    L6:
        if (Build.VERSION.SDK_INT <= 19) goto L9;
        super.reportFullyDrawn();     // Catch: Throwable -> L15
    L13:
        androidx.d.a.b();
        return;
    L9:
        if (Build.VERSION.SDK_INT != 19) goto L13;
        if (androidx.core.content.a.b(this, "android.permission.UPDATE_DEVICE_STATS") != 0) goto L13;
        super.reportFullyDrawn();     // Catch: Throwable -> L15
        goto L13
    }
}
