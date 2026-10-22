package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.C1399q;
import android.view.LayoutInflater;
import android.view.Lifecycle;
import android.view.MenuItem;
import android.view.V;
import android.view.View;
import android.view.W;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.a;
import androidx.core.view.InterfaceC1325m;
import c.InterfaceC1480b;
import d.AbstractC3939e;
import d.InterfaceC3940f;
import g1.e;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class r extends b.q implements a.d {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final C1399q mFragmentLifecycleRegistry;
    final u mFragments;
    boolean mResumed;
    boolean mStopped;

    public class a extends w<r> implements androidx.core.content.c, androidx.core.content.d, androidx.core.app.n, androidx.core.app.o, W, b.L, InterfaceC3940f, g1.h, H, InterfaceC1325m {
        public a() {
            super(r.this);
        }

        @Override // androidx.fragment.app.H
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            r.this.onAttachFragment(fragment);
        }

        @Override // androidx.core.view.InterfaceC1325m
        public void addMenuProvider(androidx.core.view.r rVar) {
            r.this.addMenuProvider(rVar);
        }

        @Override // androidx.core.content.c
        public void addOnConfigurationChangedListener(B0.a<Configuration> aVar) {
            r.this.addOnConfigurationChangedListener(aVar);
        }

        @Override // androidx.core.app.n
        public void addOnMultiWindowModeChangedListener(B0.a<androidx.core.app.g> aVar) {
            r.this.addOnMultiWindowModeChangedListener(aVar);
        }

        @Override // androidx.core.app.o
        public void addOnPictureInPictureModeChangedListener(B0.a<androidx.core.app.q> aVar) {
            r.this.addOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // androidx.core.content.d
        public void addOnTrimMemoryListener(B0.a<Integer> aVar) {
            r.this.addOnTrimMemoryListener(aVar);
        }

        @Override // androidx.fragment.app.w, androidx.fragment.app.AbstractC1381t
        public View c(int i10) {
            return r.this.findViewById(i10);
        }

        @Override // androidx.fragment.app.w, androidx.fragment.app.AbstractC1381t
        public boolean d() {
            Window window = r.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // d.InterfaceC3940f
        public AbstractC3939e getActivityResultRegistry() {
            return r.this.getActivityResultRegistry();
        }

        @Override // android.view.LifecycleOwner
        public Lifecycle getLifecycle() {
            return r.this.mFragmentLifecycleRegistry;
        }

        @Override // b.L
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return r.this.getOnBackPressedDispatcher();
        }

        @Override // g1.h
        public g1.e getSavedStateRegistry() {
            return r.this.getSavedStateRegistry();
        }

        @Override // android.view.W
        public V getViewModelStore() {
            return r.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.w
        public void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            r.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.w
        public LayoutInflater k() {
            return r.this.getLayoutInflater().cloneInContext(r.this);
        }

        @Override // androidx.fragment.app.w
        public boolean m(String str) {
            return androidx.core.app.a.u(r.this, str);
        }

        @Override // androidx.fragment.app.w
        public void p() {
            q();
        }

        public void q() {
            r.this.invalidateMenu();
        }

        @Override // androidx.fragment.app.w
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public r j() {
            return r.this;
        }

        @Override // androidx.core.view.InterfaceC1325m
        public void removeMenuProvider(androidx.core.view.r rVar) {
            r.this.removeMenuProvider(rVar);
        }

        @Override // androidx.core.content.c
        public void removeOnConfigurationChangedListener(B0.a<Configuration> aVar) {
            r.this.removeOnConfigurationChangedListener(aVar);
        }

        @Override // androidx.core.app.n
        public void removeOnMultiWindowModeChangedListener(B0.a<androidx.core.app.g> aVar) {
            r.this.removeOnMultiWindowModeChangedListener(aVar);
        }

        @Override // androidx.core.app.o
        public void removeOnPictureInPictureModeChangedListener(B0.a<androidx.core.app.q> aVar) {
            r.this.removeOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // androidx.core.content.d
        public void removeOnTrimMemoryListener(B0.a<Integer> aVar) {
            r.this.removeOnTrimMemoryListener(aVar);
        }
    }

    public r() {
        this.mFragments = u.b(new a());
        this.mFragmentLifecycleRegistry = new C1399q(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().c(LIFECYCLE_TAG, new e.b() { // from class: androidx.fragment.app.n
            @Override // g1.e.b
            public final Bundle a() {
                return r.p(this.f14114a);
            }
        });
        addOnConfigurationChangedListener(new B0.a() { // from class: androidx.fragment.app.o
            @Override // B0.a
            public final void accept(Object obj) {
                this.f14115a.mFragments.m();
            }
        });
        addOnNewIntentListener(new B0.a() { // from class: androidx.fragment.app.p
            @Override // B0.a
            public final void accept(Object obj) {
                this.f14116a.mFragments.m();
            }
        });
        addOnContextAvailableListener(new InterfaceC1480b() { // from class: androidx.fragment.app.q
            @Override // c.InterfaceC1480b
            public final void a(Context context) {
                this.f14117a.mFragments.a(null);
            }
        });
    }

    private static boolean markState(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean zMarkState = false;
        for (Fragment fragment : fragmentManager.z0()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    zMarkState |= markState(fragment.getChildFragmentManager(), state);
                }
                O o10 = fragment.mViewLifecycleOwner;
                if (o10 != null && o10.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.mViewLifecycleOwner.f(state);
                    zMarkState = true;
                }
                if (fragment.mLifecycleRegistry.getState().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.mLifecycleRegistry.n(state);
                    zMarkState = true;
                }
            }
        }
        return zMarkState;
    }

    public static /* synthetic */ Bundle p(r rVar) {
        rVar.markFragmentsCreated();
        rVar.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.n(view, str, context, attributeSet);
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
                X0.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.mFragments.l().Z(str, fileDescriptor, printWriter, strArr);
        }
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.l();
    }

    @Deprecated
    public X0.a getSupportLoaderManager() {
        return X0.a.b(this);
    }

    public void markFragmentsCreated() {
        while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED)) {
        }
    }

    @Override // b.q, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        this.mFragments.m();
        super.onActivityResult(i10, i11, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_CREATE);
        this.mFragments.e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_DESTROY);
    }

    @Override // b.q, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 6) {
            return this.mFragments.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.g();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // b.q, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        this.mFragments.m();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.m();
        super.onResume();
        this.mResumed = true;
        this.mFragments.k();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_RESUME);
        this.mFragments.h();
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.m();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.k();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_START);
        this.mFragments.i();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.m();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.j();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(androidx.core.app.s sVar) {
        androidx.core.app.a.s(this, sVar);
    }

    public void setExitSharedElementCallback(androidx.core.app.s sVar) {
        androidx.core.app.a.t(this, sVar);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i10) {
        startActivityFromFragment(fragment, intent, i10, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        if (i10 == -1) {
            androidx.core.app.a.w(this, intentSender, i10, intent, i11, i12, i13, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.a.o(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.a.p(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.a.x(this);
    }

    @Override // androidx.core.app.a.d
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i10) {
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i10, Bundle bundle) {
        if (i10 == -1) {
            androidx.core.app.a.v(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i10, bundle);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    public r(int i10) {
        super(i10);
        this.mFragments = u.b(new a());
        this.mFragmentLifecycleRegistry = new C1399q(this);
        this.mStopped = true;
        init();
    }
}
