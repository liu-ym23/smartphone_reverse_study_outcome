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
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final LifecycleRegistry mFragmentLifecycleRegistry;
    final FragmentController mFragments;
    boolean mResumed;
    boolean mStopped;

    public class a extends FragmentHostCallback implements OnConfigurationChangedProvider, OnTrimMemoryProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, ViewModelStoreOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, SavedStateRegistryOwner, FragmentOnAttachListener, MenuHost {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f3174f;

        public a(FragmentActivity r10) {
            this.f3174f = r10;
            super(r10);
        }

        @Override // androidx.core.view.MenuHost
        public void addMenuProvider(MenuProvider r10) {
            this.f3174f.addMenuProvider(r10);
        }

        @Override // androidx.core.content.OnConfigurationChangedProvider
        public void addOnConfigurationChangedListener(Consumer r10) {
            this.f3174f.addOnConfigurationChangedListener(r10);
        }

        @Override // androidx.core.app.OnMultiWindowModeChangedProvider
        public void addOnMultiWindowModeChangedListener(Consumer r10) {
            this.f3174f.addOnMultiWindowModeChangedListener(r10);
        }

        @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
        public void addOnPictureInPictureModeChangedListener(Consumer r10) {
            this.f3174f.addOnPictureInPictureModeChangedListener(r10);
        }

        @Override // androidx.core.content.OnTrimMemoryProvider
        public void addOnTrimMemoryListener(Consumer r10) {
            this.f3174f.addOnTrimMemoryListener(r10);
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        public View b(int r10) {
            return this.f3174f.findViewById(r10);
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        public boolean c() {
            Window r10 = this.f3174f.getWindow();
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.peekDecorView() == null) goto L7;
            return true;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void g(String r10, FileDescriptor r11, PrintWriter r12, String[] r13) {
            this.f3174f.dump(r10, r11, r12, r13);
        }

        @Override // androidx.activity.result.ActivityResultRegistryOwner
        public ActivityResultRegistry getActivityResultRegistry() {
            return this.f3174f.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.LifecycleOwner
        public Lifecycle getLifecycle() {
            return this.f3174f.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.OnBackPressedDispatcherOwner
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return this.f3174f.getOnBackPressedDispatcher();
        }

        @Override // androidx.savedstate.SavedStateRegistryOwner
        public SavedStateRegistry getSavedStateRegistry() {
            return this.f3174f.getSavedStateRegistry();
        }

        @Override // androidx.lifecycle.ViewModelStoreOwner
        public ViewModelStore getViewModelStore() {
            return this.f3174f.getViewModelStore();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public /* bridge */ /* synthetic */ Object h() {
            return o();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public LayoutInflater i() {
            return this.f3174f.getLayoutInflater().cloneInContext(this.f3174f);
        }

        @Override // androidx.core.view.MenuHost
        public void invalidateMenu() {
            this.f3174f.invalidateMenu();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean k(String r10) {
            return ActivityCompat.t(this.f3174f, r10);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void n() {
            invalidateMenu();
        }

        public FragmentActivity o() {
            return this.f3174f;
        }

        @Override // androidx.fragment.app.FragmentOnAttachListener
        public void onAttachFragment(FragmentManager r10, Fragment r11) {
            this.f3174f.onAttachFragment(r11);
        }

        @Override // androidx.core.view.MenuHost
        public void removeMenuProvider(MenuProvider r10) {
            this.f3174f.removeMenuProvider(r10);
        }

        @Override // androidx.core.content.OnConfigurationChangedProvider
        public void removeOnConfigurationChangedListener(Consumer r10) {
            this.f3174f.removeOnConfigurationChangedListener(r10);
        }

        @Override // androidx.core.app.OnMultiWindowModeChangedProvider
        public void removeOnMultiWindowModeChangedListener(Consumer r10) {
            this.f3174f.removeOnMultiWindowModeChangedListener(r10);
        }

        @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
        public void removeOnPictureInPictureModeChangedListener(Consumer r10) {
            this.f3174f.removeOnPictureInPictureModeChangedListener(r10);
        }

        @Override // androidx.core.content.OnTrimMemoryProvider
        public void removeOnTrimMemoryListener(Consumer r10) {
            this.f3174f.removeOnTrimMemoryListener(r10);
        }

        @Override // androidx.core.view.MenuHost
        public void addMenuProvider(MenuProvider r10, LifecycleOwner r11) {
            this.f3174f.addMenuProvider(r10, r11);
        }

        @Override // androidx.core.view.MenuHost
        public void addMenuProvider(MenuProvider r10, LifecycleOwner r11, Lifecycle.State r12) {
            this.f3174f.addMenuProvider(r10, r11, r12);
        }
    }

    public FragmentActivity() {
        this.mFragments = FragmentController.b(new a(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        m();
    }

    public static /* synthetic */ void i(FragmentActivity r10, Context r11) {
        r10.q(r11);
    }

    public static /* synthetic */ void j(FragmentActivity r10, Configuration r11) {
        r10.o(r11);
    }

    public static /* synthetic */ Bundle k(FragmentActivity r10) {
        return r10.n();
    }

    public static /* synthetic */ void l(FragmentActivity r10, Intent r11) {
        r10.p(r11);
    }

    private void m() {
        getSavedStateRegistry().h(LIFECYCLE_TAG, new k(this));
        addOnConfigurationChangedListener(new l(this));
        addOnNewIntentListener(new m(this));
        addOnContextAvailableListener(new n(this));
    }

    public static boolean r(FragmentManager r10, Lifecycle.State r11) {
        Iterator r12 = r10.x0().iterator();
        boolean r13 = false;
    L4:
        if (r12.hasNext() == false) goto L19;
        Fragment r14 = (Fragment) r12.next();
        if (r14 == null) goto L4;
        if (r14.getHost() == null) goto L11;
        r13 = r13 | r(r14.getChildFragmentManager(), r11);
    L11:
        FragmentViewLifecycleOwner r15 = r14.mViewLifecycleOwner;
        if (r15 == null) goto L17;
        if (r15.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED) == false) goto L17;
        r14.mViewLifecycleOwner.e(r11);
        r13 = true;
    L17:
        if (r14.mLifecycleRegistry.b().isAtLeast(Lifecycle.State.STARTED) == false) goto L4;
        r14.mLifecycleRegistry.n(r11);
        r13 = true;
        goto L4
    L19:
        return r13;
    }

    @Nullable
    public final View dispatchFragmentsOnCreateView(@Nullable View r10, @NonNull String r11, @NonNull Context r12, @NonNull AttributeSet r13) {
        return this.mFragments.n(r10, r11, r12, r13);
    }

    @Override // android.app.Activity
    public void dump(@NonNull String r10, @Nullable FileDescriptor r11, @NonNull PrintWriter r12, @Nullable String[] r13) {
        super.dump(r10, r11, r12, r13);
        if (shouldDumpInternalState(r13) == true) goto L5;
        return;
    L5:
        r12.print(r10);
        r12.print("Local FragmentActivity ");
        r12.print(Integer.toHexString(System.identityHashCode(this)));
        r12.println(" State:");
        String r14 = r10 + "  ";
        r12.print(r14);
        r12.print("mCreated=");
        r12.print(this.mCreated);
        r12.print(" mResumed=");
        r12.print(this.mResumed);
        r12.print(" mStopped=");
        r12.print(this.mStopped);
        if (getApplication() == null) goto L8;
        LoaderManager.b(this).a(r14, r11, r12, r13);
    L8:
        this.mFragments.l().W(r10, r11, r12, r13);
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.l();
    }

    @NonNull
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.b(this);
    }

    public void markFragmentsCreated() {
    L3:
        if (r(getSupportFragmentManager(), Lifecycle.State.CREATED) == true) goto L3;
    }

    public final /* synthetic */ Bundle n() {
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    public final /* synthetic */ void o(Configuration r10) {
        this.mFragments.m();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @CallSuper
    public void onActivityResult(int r10, int r11, @Nullable Intent r12) {
        this.mFragments.m();
        super.onActivityResult(r10, r11, r12);
    }

    @MainThread
    @Deprecated
    public void onAttachFragment(@NonNull Fragment r10) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.mFragments.e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View r10, @NonNull String r11, @NonNull Context r12, @NonNull AttributeSet r13) {
        View r14 = dispatchFragmentsOnCreateView(r10, r11, r12, r13);
        if (r14 == null) goto L5;
        return r14;
    L5:
        return super.onCreateView(r10, r11, r12, r13);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r10, @NonNull MenuItem r11) {
        if (super.onMenuItemSelected(r10, r11) == false) goto L7;
        return true;
    L7:
        if (r10 == 6) goto L9;
        return false;
    L9:
        return this.mFragments.d(r11);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.g();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @CallSuper
    public void onRequestPermissionsResult(int r10, @NonNull String[] r11, @NonNull int[] r12) {
        this.mFragments.m();
        super.onRequestPermissionsResult(r10, r11, r12);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.m();
        super.onResume();
        this.mResumed = true;
        this.mFragments.k();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.mFragments.h();
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.m();
        super.onStart();
        this.mStopped = false;
        if (this.mCreated == true) goto L5;
        this.mCreated = true;
        this.mFragments.c();
    L5:
        this.mFragments.k();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
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
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public final /* synthetic */ void p(Intent r10) {
        this.mFragments.m();
    }

    public final /* synthetic */ void q(Context r10) {
        this.mFragments.a(null);
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback r10) {
        ActivityCompat.r(this, r10);
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback r10) {
        ActivityCompat.s(this, r10);
    }

    public void startActivityFromFragment(@NonNull Fragment r10, @NonNull Intent r11, int r12) {
        startActivityFromFragment(r10, r11, r12, null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(@NonNull Fragment r10, @NonNull IntentSender r11, int r12, @Nullable Intent r13, int r14, int r15, int r16, @Nullable Bundle r17) throws IntentSender.SendIntentException {
        if (r12 != (-1)) goto L6;
        ActivityCompat.v(this, r11, r12, r13, r14, r15, r16, r17);
        return;
    L6:
        r10.startIntentSenderForResult(r11, r12, r13, r14, r15, r16, r17);
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.n(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.o(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.w(this);
    }

    @Override // androidx.core.app.ActivityCompat.RequestPermissionsRequestCodeValidator
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int r10) {
    }

    public void startActivityFromFragment(@NonNull Fragment r10, @NonNull Intent r11, int r12, @Nullable Bundle r13) {
        if (r12 != (-1)) goto L6;
        ActivityCompat.u(this, r11, -1, r13);
        return;
    L6:
        r10.startActivityForResult(r11, r12, r13);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String r10, @NonNull Context r11, @NonNull AttributeSet r12) {
        View r13 = dispatchFragmentsOnCreateView(null, r10, r11, r12);
        if (r13 == null) goto L5;
        return r13;
    L5:
        return super.onCreateView(r10, r11, r12);
    }

    public FragmentActivity(int r10) {
        super(r10);
        this.mFragments = FragmentController.b(new a(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        m();
    }
}
