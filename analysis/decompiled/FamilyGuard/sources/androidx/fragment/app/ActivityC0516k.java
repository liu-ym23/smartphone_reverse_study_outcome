package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.core.app.a;
import androidx.core.view.InterfaceC0468m;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.C0541v;
import androidx.lifecycle.W;
import androidx.lifecycle.X;
import c.InterfaceC0570b;
import c0.C0574d;
import c0.InterfaceC0576f;
import d.AbstractC0643d;
import d.InterfaceC0644e;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.fragment.app.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ActivityC0516k extends androidx.activity.h implements a.c {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final C0541v mFragmentLifecycleRegistry;
    final C0519n mFragments;
    boolean mResumed;
    boolean mStopped;

    /* renamed from: androidx.fragment.app.k$a */
    class a extends p<ActivityC0516k> implements androidx.core.content.b, androidx.core.content.c, androidx.core.app.n, androidx.core.app.o, X, androidx.activity.r, InterfaceC0644e, InterfaceC0576f, B, InterfaceC0468m {
        public a() {
            super(ActivityC0516k.this);
        }

        @Override // androidx.fragment.app.B
        public void a(x xVar, ComponentCallbacksC0511f componentCallbacksC0511f) {
            ActivityC0516k.this.onAttachFragment(componentCallbacksC0511f);
        }

        @Override // androidx.core.view.InterfaceC0468m
        public void addMenuProvider(androidx.core.view.r rVar) {
            ActivityC0516k.this.addMenuProvider(rVar);
        }

        @Override // androidx.core.content.b
        public void addOnConfigurationChangedListener(D.a<Configuration> aVar) {
            ActivityC0516k.this.addOnConfigurationChangedListener(aVar);
        }

        @Override // androidx.core.app.n
        public void addOnMultiWindowModeChangedListener(D.a<androidx.core.app.g> aVar) {
            ActivityC0516k.this.addOnMultiWindowModeChangedListener(aVar);
        }

        @Override // androidx.core.app.o
        public void addOnPictureInPictureModeChangedListener(D.a<androidx.core.app.q> aVar) {
            ActivityC0516k.this.addOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // androidx.core.content.c
        public void addOnTrimMemoryListener(D.a<Integer> aVar) {
            ActivityC0516k.this.addOnTrimMemoryListener(aVar);
        }

        @Override // androidx.fragment.app.p, androidx.fragment.app.AbstractC0518m
        public View c(int i5) {
            return ActivityC0516k.this.findViewById(i5);
        }

        @Override // androidx.fragment.app.p, androidx.fragment.app.AbstractC0518m
        public boolean d() {
            Window window = ActivityC0516k.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // d.InterfaceC0644e
        public AbstractC0643d getActivityResultRegistry() {
            return ActivityC0516k.this.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.InterfaceC0539t
        public AbstractC0533m getLifecycle() {
            return ActivityC0516k.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.r
        public androidx.activity.p getOnBackPressedDispatcher() {
            return ActivityC0516k.this.getOnBackPressedDispatcher();
        }

        @Override // c0.InterfaceC0576f
        public C0574d getSavedStateRegistry() {
            return ActivityC0516k.this.getSavedStateRegistry();
        }

        @Override // androidx.lifecycle.X
        public W getViewModelStore() {
            return ActivityC0516k.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.p
        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            ActivityC0516k.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.p
        public LayoutInflater j() {
            return ActivityC0516k.this.getLayoutInflater().cloneInContext(ActivityC0516k.this);
        }

        @Override // androidx.fragment.app.p
        public void n() {
            o();
        }

        public void o() {
            ActivityC0516k.this.invalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.p
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public ActivityC0516k i() {
            return ActivityC0516k.this;
        }

        @Override // androidx.core.view.InterfaceC0468m
        public void removeMenuProvider(androidx.core.view.r rVar) {
            ActivityC0516k.this.removeMenuProvider(rVar);
        }

        @Override // androidx.core.content.b
        public void removeOnConfigurationChangedListener(D.a<Configuration> aVar) {
            ActivityC0516k.this.removeOnConfigurationChangedListener(aVar);
        }

        @Override // androidx.core.app.n
        public void removeOnMultiWindowModeChangedListener(D.a<androidx.core.app.g> aVar) {
            ActivityC0516k.this.removeOnMultiWindowModeChangedListener(aVar);
        }

        @Override // androidx.core.app.o
        public void removeOnPictureInPictureModeChangedListener(D.a<androidx.core.app.q> aVar) {
            ActivityC0516k.this.removeOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // androidx.core.content.c
        public void removeOnTrimMemoryListener(D.a<Integer> aVar) {
            ActivityC0516k.this.removeOnTrimMemoryListener(aVar);
        }
    }

    public ActivityC0516k() {
        this.mFragments = C0519n.b(new a());
        this.mFragmentLifecycleRegistry = new C0541v(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().h(LIFECYCLE_TAG, new C0574d.c() { // from class: androidx.fragment.app.g
            @Override // c0.C0574d.c
            public final Bundle a() {
                return ActivityC0516k.r(this.f10694a);
            }
        });
        addOnConfigurationChangedListener(new D.a() { // from class: androidx.fragment.app.h
            @Override // D.a
            public final void accept(Object obj) {
                this.f10695a.mFragments.m();
            }
        });
        addOnNewIntentListener(new D.a() { // from class: androidx.fragment.app.i
            @Override // D.a
            public final void accept(Object obj) {
                this.f10696a.mFragments.m();
            }
        });
        addOnContextAvailableListener(new InterfaceC0570b() { // from class: androidx.fragment.app.j
            @Override // c.InterfaceC0570b
            public final void a(Context context) {
                this.f10697a.mFragments.a(null);
            }
        });
    }

    private static boolean markState(x xVar, AbstractC0533m.b bVar) {
        boolean zMarkState = false;
        for (ComponentCallbacksC0511f componentCallbacksC0511f : xVar.r0()) {
            if (componentCallbacksC0511f != null) {
                if (componentCallbacksC0511f.E() != null) {
                    zMarkState |= markState(componentCallbacksC0511f.v(), bVar);
                }
                K k5 = componentCallbacksC0511f.f10624W;
                if (k5 != null && k5.getLifecycle().b().d(AbstractC0533m.b.STARTED)) {
                    componentCallbacksC0511f.f10624W.f(bVar);
                    zMarkState = true;
                }
                if (componentCallbacksC0511f.f10623V.b().d(AbstractC0533m.b.STARTED)) {
                    componentCallbacksC0511f.f10623V.n(bVar);
                    zMarkState = true;
                }
            }
        }
        return zMarkState;
    }

    public static /* synthetic */ Bundle r(ActivityC0516k activityC0516k) {
        activityC0516k.markFragmentsCreated();
        activityC0516k.mFragmentLifecycleRegistry.i(AbstractC0533m.a.ON_STOP);
        return new Bundle();
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
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
                androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.mFragments.l().U(str, fileDescriptor, printWriter, strArr);
        }
    }

    public x getSupportFragmentManager() {
        return this.mFragments.l();
    }

    @Deprecated
    public androidx.loader.app.a getSupportLoaderManager() {
        return androidx.loader.app.a.b(this);
    }

    void markFragmentsCreated() {
        while (markState(getSupportFragmentManager(), AbstractC0533m.b.CREATED)) {
        }
    }

    @Override // androidx.activity.h, android.app.Activity
    protected void onActivityResult(int i5, int i6, Intent intent) {
        this.mFragments.m();
        super.onActivityResult(i5, i6, intent);
    }

    @Deprecated
    public void onAttachFragment(ComponentCallbacksC0511f componentCallbacksC0511f) {
    }

    @Override // androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.i(AbstractC0533m.a.ON_CREATE);
        this.mFragments.e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mFragments.f();
        this.mFragmentLifecycleRegistry.i(AbstractC0533m.a.ON_DESTROY);
    }

    @Override // androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        if (super.onMenuItemSelected(i5, menuItem)) {
            return true;
        }
        if (i5 == 6) {
            return this.mFragments.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.g();
        this.mFragmentLifecycleRegistry.i(AbstractC0533m.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        this.mFragments.m();
        super.onRequestPermissionsResult(i5, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.mFragments.m();
        super.onResume();
        this.mResumed = true;
        this.mFragments.k();
    }

    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.i(AbstractC0533m.a.ON_RESUME);
        this.mFragments.h();
    }

    @Override // android.app.Activity
    protected void onStart() {
        this.mFragments.m();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.k();
        this.mFragmentLifecycleRegistry.i(AbstractC0533m.a.ON_START);
        this.mFragments.i();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.m();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.j();
        this.mFragmentLifecycleRegistry.i(AbstractC0533m.a.ON_STOP);
    }

    public void setEnterSharedElementCallback(androidx.core.app.s sVar) {
        androidx.core.app.a.r(this, sVar);
    }

    public void setExitSharedElementCallback(androidx.core.app.s sVar) {
        androidx.core.app.a.s(this, sVar);
    }

    public void startActivityFromFragment(ComponentCallbacksC0511f componentCallbacksC0511f, Intent intent, int i5) {
        startActivityFromFragment(componentCallbacksC0511f, intent, i5, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(ComponentCallbacksC0511f componentCallbacksC0511f, IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) throws IntentSender.SendIntentException {
        if (i5 == -1) {
            androidx.core.app.a.u(this, intentSender, i5, intent, i6, i7, i8, bundle);
        } else {
            componentCallbacksC0511f.S1(intentSender, i5, intent, i6, i7, i8, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.a.n(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.a.o(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.a.v(this);
    }

    @Override // androidx.core.app.a.c
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i5) {
    }

    public void startActivityFromFragment(ComponentCallbacksC0511f componentCallbacksC0511f, Intent intent, int i5, Bundle bundle) {
        if (i5 == -1) {
            androidx.core.app.a.t(this, intent, -1, bundle);
        } else {
            componentCallbacksC0511f.R1(intent, i5, bundle);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    public ActivityC0516k(int i5) {
        super(i5);
        this.mFragments = C0519n.b(new a());
        this.mFragmentLifecycleRegistry = new C0541v(this);
        this.mStopped = true;
        init();
    }
}
