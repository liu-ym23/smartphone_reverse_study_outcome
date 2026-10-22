package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.s0;
import androidx.lifecycle.t0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class o extends b.k implements androidx.core.app.a {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final androidx.lifecycle.s mFragmentLifecycleRegistry;
    final r mFragments;
    boolean mResumed;
    boolean mStopped;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends t<o> implements androidx.core.content.c, androidx.core.content.d, androidx.core.app.j, androidx.core.app.k, t0, b.s, d.g, w1.d, a0, v0.h {
        public a() {
            super(o.this);
        }

        @Override // androidx.fragment.app.a0
        public final void a(Fragment fragment) {
            o.this.onAttachFragment(fragment);
        }

        @Override // v0.h
        public final void addMenuProvider(v0.l lVar) {
            o.this.addMenuProvider(lVar);
        }

        @Override // androidx.core.content.c
        public final void addOnConfigurationChangedListener(u0.a<Configuration> aVar) {
            o.this.addOnConfigurationChangedListener(aVar);
        }

        @Override // androidx.core.app.j
        public final void addOnMultiWindowModeChangedListener(u0.a<androidx.core.app.d> aVar) {
            o.this.addOnMultiWindowModeChangedListener(aVar);
        }

        @Override // androidx.core.app.k
        public final void addOnPictureInPictureModeChangedListener(u0.a<androidx.core.app.m> aVar) {
            o.this.addOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // androidx.core.content.d
        public final void addOnTrimMemoryListener(u0.a<Integer> aVar) {
            o.this.addOnTrimMemoryListener(aVar);
        }

        @Override // androidx.fragment.app.q
        public final View b(int i10) {
            return o.this.findViewById(i10);
        }

        @Override // androidx.fragment.app.q
        public final boolean c() {
            Window window = o.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.fragment.app.t
        public final void d(PrintWriter printWriter, String[] strArr) {
            o.this.dump("  ", null, printWriter, strArr);
        }

        @Override // androidx.fragment.app.t
        public final o e() {
            return o.this;
        }

        @Override // androidx.fragment.app.t
        public final LayoutInflater f() {
            o oVar = o.this;
            return oVar.getLayoutInflater().cloneInContext(oVar);
        }

        @Override // androidx.fragment.app.t
        public final boolean g(String str) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
                return false;
            }
            o oVar = o.this;
            if (i10 >= 32) {
                return oVar.shouldShowRequestPermissionRationale(str);
            }
            if (i10 != 31) {
                return oVar.shouldShowRequestPermissionRationale(str);
            }
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(oVar.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return oVar.shouldShowRequestPermissionRationale(str);
            }
        }

        @Override // d.g
        public final d.d getActivityResultRegistry() {
            return o.this.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.q
        public final Lifecycle getLifecycle() {
            return o.this.mFragmentLifecycleRegistry;
        }

        @Override // b.s
        public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return o.this.getOnBackPressedDispatcher();
        }

        @Override // w1.d
        public final w1.b getSavedStateRegistry() {
            return o.this.getSavedStateRegistry();
        }

        @Override // androidx.lifecycle.t0
        public final s0 getViewModelStore() {
            return o.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.t
        public final void h() {
            o.this.invalidateOptionsMenu();
        }

        @Override // v0.h
        public final void removeMenuProvider(v0.l lVar) {
            o.this.removeMenuProvider(lVar);
        }

        @Override // androidx.core.content.c
        public final void removeOnConfigurationChangedListener(u0.a<Configuration> aVar) {
            o.this.removeOnConfigurationChangedListener(aVar);
        }

        @Override // androidx.core.app.j
        public final void removeOnMultiWindowModeChangedListener(u0.a<androidx.core.app.d> aVar) {
            o.this.removeOnMultiWindowModeChangedListener(aVar);
        }

        @Override // androidx.core.app.k
        public final void removeOnPictureInPictureModeChangedListener(u0.a<androidx.core.app.m> aVar) {
            o.this.removeOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // androidx.core.content.d
        public final void removeOnTrimMemoryListener(u0.a<Integer> aVar) {
            o.this.removeOnTrimMemoryListener(aVar);
        }
    }

    public o() {
        this.mFragments = new r(new a());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.s(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().c(LIFECYCLE_TAG, new l(this, 0));
        addOnConfigurationChangedListener(new x(this, 2));
        addOnNewIntentListener(new m(this, 0));
        addOnContextAvailableListener(new c.b() { // from class: androidx.fragment.app.n
            @Override // c.b
            public final void a(b.k kVar) {
                this.f2169a.lambda$init$3(kVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$init$0() {
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.f(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(Configuration configuration) {
        this.mFragments.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(Intent intent) {
        this.mFragments.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$init$3(Context context) {
        a aVar = this.mFragments.f2178a;
        aVar.f2196d.b(aVar, aVar, null);
    }

    private static boolean markState(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean zMarkState = false;
        for (Fragment fragment : fragmentManager.f2015c.f()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    zMarkState |= markState(fragment.getChildFragmentManager(), state);
                }
                k0 k0Var = fragment.mViewLifecycleOwner;
                if (k0Var != null) {
                    k0Var.b();
                    if (k0Var.f2161c.f2310d.a(Lifecycle.State.f2217d)) {
                        fragment.mViewLifecycleOwner.f2161c.h(state);
                        zMarkState = true;
                    }
                }
                if (fragment.mLifecycleRegistry.f2310d.a(Lifecycle.State.f2217d)) {
                    fragment.mLifecycleRegistry.h(state);
                    zMarkState = true;
                }
            }
        }
        return zMarkState;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f2178a.f2196d.f2018f.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (shouldDumpInternalState(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print(" mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            if (getApplication() != null) {
                s1.a.a(this).b(printWriter, str2);
            }
            this.mFragments.f2178a.f2196d.u(str, fileDescriptor, printWriter, strArr);
        }
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.f2178a.f2196d;
    }

    @Deprecated
    public s1.a getSupportLoaderManager() {
        return s1.a.a(this);
    }

    public void markFragmentsCreated() {
        while (markState(getSupportFragmentManager(), Lifecycle.State.f2216c)) {
        }
    }

    @Override // b.k, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        this.mFragments.a();
        super.onActivityResult(i10, i11, intent);
    }

    @Override // b.k, androidx.core.app.c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.f(Lifecycle.Event.ON_CREATE);
        y yVar = this.mFragments.f2178a.f2196d;
        yVar.F = false;
        yVar.G = false;
        yVar.M.f2211g = false;
        yVar.t(1);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f2178a.f2196d.k();
        this.mFragmentLifecycleRegistry.f(Lifecycle.Event.ON_DESTROY);
    }

    @Override // b.k, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 6) {
            return this.mFragments.f2178a.f2196d.i(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f2178a.f2196d.t(5);
        this.mFragmentLifecycleRegistry.f(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // b.k, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        this.mFragments.a();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.f2178a.f2196d.x(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.f(Lifecycle.Event.ON_RESUME);
        y yVar = this.mFragments.f2178a.f2196d;
        yVar.F = false;
        yVar.G = false;
        yVar.M.f2211g = false;
        yVar.t(7);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            y yVar = this.mFragments.f2178a.f2196d;
            yVar.F = false;
            yVar.G = false;
            yVar.M.f2211g = false;
            yVar.t(4);
        }
        this.mFragments.f2178a.f2196d.x(true);
        this.mFragmentLifecycleRegistry.f(Lifecycle.Event.ON_START);
        y yVar2 = this.mFragments.f2178a.f2196d;
        yVar2.F = false;
        yVar2.G = false;
        yVar2.M.f2211g = false;
        yVar2.t(5);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        y yVar = this.mFragments.f2178a.f2196d;
        yVar.G = true;
        yVar.M.f2211g = true;
        yVar.t(4);
        this.mFragmentLifecycleRegistry.f(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(androidx.core.app.o oVar) {
        setEnterSharedElementCallback((SharedElementCallback) null);
    }

    public void setExitSharedElementCallback(androidx.core.app.o oVar) {
        setExitSharedElementCallback((SharedElementCallback) null);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        if (i10 == -1) {
            startActivityForResult(intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i10, bundle);
        }
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        if (i10 == -1) {
            startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        finishAfterTransition();
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        postponeEnterTransition();
    }

    public void supportStartPostponedEnterTransition() {
        startPostponedEnterTransition();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10) {
        startActivityFromFragment(fragment, intent, i10, (Bundle) null);
    }

    public o(int i10) {
        super(i10);
        this.mFragments = new r(new a());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.s(this);
        this.mStopped = true;
        init();
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // androidx.core.app.a
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i10) {
    }
}
