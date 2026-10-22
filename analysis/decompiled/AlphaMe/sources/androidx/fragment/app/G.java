package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.AbstractC0240a;
import androidx.core.app.InterfaceC0243d;
import androidx.core.app.InterfaceC0244e;
import androidx.lifecycle.EnumC0326x;
import androidx.lifecycle.EnumC0327y;
import e0.AbstractC0548a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import stepos.support.v7.app.AbstractActivityC0866k;

/* loaded from: classes.dex */
public abstract class G extends androidx.activity.o implements InterfaceC0243d, InterfaceC0244e {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final K mFragments;
    boolean mResumed;
    final androidx.lifecycle.I mFragmentLifecycleRegistry = new androidx.lifecycle.I(this);
    boolean mStopped = true;

    public G() {
        final AbstractActivityC0866k abstractActivityC0866k = (AbstractActivityC0866k) this;
        this.mFragments = new K(new F(abstractActivityC0866k));
        final int i4 = 1;
        getSavedStateRegistry().c(LIFECYCLE_TAG, new androidx.activity.f(i4, this));
        final int i5 = 0;
        addOnConfigurationChangedListener(new J.a() { // from class: androidx.fragment.app.E
            @Override // J.a
            public final void accept(Object obj) {
                int i6 = i5;
                G g4 = abstractActivityC0866k;
                switch (i6) {
                    case 0:
                        g4.mFragments.a();
                        break;
                    default:
                        g4.mFragments.a();
                        break;
                }
            }
        });
        addOnNewIntentListener(new J.a() { // from class: androidx.fragment.app.E
            @Override // J.a
            public final void accept(Object obj) {
                int i6 = i4;
                G g4 = abstractActivityC0866k;
                switch (i6) {
                    case 0:
                        g4.mFragments.a();
                        break;
                    default:
                        g4.mFragments.a();
                        break;
                }
            }
        });
        addOnContextAvailableListener(new androidx.activity.g(this, 1));
    }

    public static void c(G g4) {
        L l4 = g4.mFragments.f3624a;
        l4.f3628d.b(l4, l4, null);
    }

    public static /* synthetic */ Bundle d(G g4) {
        g4.markFragmentsCreated();
        g4.mFragmentLifecycleRegistry.e(EnumC0326x.ON_STOP);
        return new Bundle();
    }

    public static boolean e(Y y4) {
        boolean zE = false;
        for (D d4 : y4.f3664c.f()) {
            if (d4 != null) {
                if (d4.getHost() != null) {
                    zE |= e(d4.getChildFragmentManager());
                }
                n0 n0Var = d4.mViewLifecycleOwner;
                EnumC0327y enumC0327y = EnumC0327y.f3986d;
                if (n0Var != null) {
                    n0Var.b();
                    if (n0Var.f3789d.f3871d.a(enumC0327y)) {
                        d4.mViewLifecycleOwner.f3789d.g();
                        zE = true;
                    }
                }
                if (d4.mLifecycleRegistry.f3871d.a(enumC0327y)) {
                    d4.mLifecycleRegistry.g();
                    zE = true;
                }
            }
        }
        return zE;
    }

    @Nullable
    public final View dispatchFragmentsOnCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.mFragments.f3624a.f3628d.f3667f.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
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
                AbstractC0548a.a(this).b(str2, printWriter);
            }
            this.mFragments.f3624a.f3628d.u(str, fileDescriptor, printWriter, strArr);
        }
    }

    @NonNull
    public Y getSupportFragmentManager() {
        return this.mFragments.f3624a.f3628d;
    }

    @NonNull
    @Deprecated
    public AbstractC0548a getSupportLoaderManager() {
        return AbstractC0548a.a(this);
    }

    public void markFragmentsCreated() {
        while (e(getSupportFragmentManager())) {
        }
    }

    @Override // androidx.activity.o, android.app.Activity
    @CallSuper
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        this.mFragments.a();
        super.onActivityResult(i4, i5, intent);
    }

    @MainThread
    @Deprecated
    public void onAttachFragment(@NonNull D d4) {
    }

    @Override // androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.e(EnumC0326x.ON_CREATE);
        Z z4 = this.mFragments.f3624a.f3628d;
        z4.f3653F = false;
        z4.f3654G = false;
        z4.f3660M.f3713f = false;
        z4.t(1);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f3624a.f3628d.k();
        this.mFragmentLifecycleRegistry.e(EnumC0326x.ON_DESTROY);
    }

    @Override // androidx.activity.o, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        if (super.onMenuItemSelected(i4, menuItem)) {
            return true;
        }
        if (i4 == 6) {
            return this.mFragments.f3624a.f3628d.i(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f3624a.f3628d.t(5);
        this.mFragmentLifecycleRegistry.e(EnumC0326x.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.o, android.app.Activity
    @CallSuper
    public void onRequestPermissionsResult(int i4, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.mFragments.a();
        super.onRequestPermissionsResult(i4, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.f3624a.f3628d.x(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.e(EnumC0326x.ON_RESUME);
        Z z4 = this.mFragments.f3624a.f3628d;
        z4.f3653F = false;
        z4.f3654G = false;
        z4.f3660M.f3713f = false;
        z4.t(7);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            Z z4 = this.mFragments.f3624a.f3628d;
            z4.f3653F = false;
            z4.f3654G = false;
            z4.f3660M.f3713f = false;
            z4.t(4);
        }
        this.mFragments.f3624a.f3628d.x(true);
        this.mFragmentLifecycleRegistry.e(EnumC0326x.ON_START);
        Z z5 = this.mFragments.f3624a.f3628d;
        z5.f3653F = false;
        z5.f3654G = false;
        z5.f3660M.f3713f = false;
        z5.t(5);
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
        Z z4 = this.mFragments.f3624a.f3628d;
        z4.f3654G = true;
        z4.f3660M.f3713f = true;
        z4.t(4);
        this.mFragmentLifecycleRegistry.e(EnumC0326x.ON_STOP);
    }

    public void setEnterSharedElementCallback(@Nullable androidx.core.app.C c4) {
        AbstractC0240a.c(this, null);
    }

    public void setExitSharedElementCallback(@Nullable androidx.core.app.C c4) {
        AbstractC0240a.d(this, null);
    }

    public void startActivityFromFragment(@NonNull D d4, @SuppressLint({"UnknownNullness"}) Intent intent, int i4, @Nullable Bundle bundle) {
        if (i4 == -1) {
            startActivityForResult(intent, -1, bundle);
        } else {
            d4.startActivityForResult(intent, i4, bundle);
        }
    }

    @Deprecated
    public void startIntentSenderFromFragment(@NonNull D d4, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i4, @Nullable Intent intent, int i5, int i6, int i7, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        if (i4 == -1) {
            startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7, bundle);
        } else {
            d4.startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7, bundle);
        }
    }

    public void supportPostponeEnterTransition() {
        AbstractC0240a.b(this);
    }

    public void supportStartPostponedEnterTransition() {
        AbstractC0240a.e(this);
    }

    @Override // androidx.core.app.InterfaceC0244e
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i4) {
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    public void startActivityFromFragment(@NonNull D d4, @SuppressLint({"UnknownNullness"}) Intent intent, int i4) {
        startActivityFromFragment(d4, intent, i4, (Bundle) null);
    }
}
