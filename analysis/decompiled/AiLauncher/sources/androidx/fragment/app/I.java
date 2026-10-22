package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Lifecycle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.W;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;

/* loaded from: classes.dex */
public class I {

    /* renamed from: a, reason: collision with root package name */
    public final y f13981a;

    /* renamed from: b, reason: collision with root package name */
    public final J f13982b;

    /* renamed from: c, reason: collision with root package name */
    public final Fragment f13983c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13984d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f13985e = -1;

    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f13986a;

        public a(View view) {
            this.f13986a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f13986a.removeOnAttachStateChangeListener(this);
            androidx.core.view.N.e0(this.f13986a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13988a;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            f13988a = iArr;
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13988a[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13988a[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13988a[Lifecycle.State.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public I(y yVar, J j10, Fragment fragment) {
        this.f13981a = yVar;
        this.f13982b = j10;
        this.f13983c = fragment;
    }

    public void a() {
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f13983c);
        }
        Bundle bundle = this.f13983c.mSavedFragmentState;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        this.f13983c.performActivityCreated(bundle2);
        this.f13981a.a(this.f13983c, bundle2, false);
    }

    public void b() {
        Fragment fragmentO0 = FragmentManager.o0(this.f13983c.mContainer);
        Fragment parentFragment = this.f13983c.getParentFragment();
        if (fragmentO0 != null && !fragmentO0.equals(parentFragment)) {
            Fragment fragment = this.f13983c;
            FragmentStrictMode.o(fragment, fragmentO0, fragment.mContainerId);
        }
        int iJ = this.f13982b.j(this.f13983c);
        Fragment fragment2 = this.f13983c;
        fragment2.mContainer.addView(fragment2.mView, iJ);
    }

    public void c() {
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f13983c);
        }
        Fragment fragment = this.f13983c;
        Fragment fragment2 = fragment.mTarget;
        I iN = null;
        if (fragment2 != null) {
            I iN2 = this.f13982b.n(fragment2.mWho);
            if (iN2 == null) {
                throw new IllegalStateException("Fragment " + this.f13983c + " declared target fragment " + this.f13983c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f13983c;
            fragment3.mTargetWho = fragment3.mTarget.mWho;
            fragment3.mTarget = null;
            iN = iN2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (iN = this.f13982b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f13983c + " declared target fragment " + this.f13983c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (iN != null) {
            iN.m();
        }
        Fragment fragment4 = this.f13983c;
        fragment4.mHost = fragment4.mFragmentManager.A0();
        Fragment fragment5 = this.f13983c;
        fragment5.mParentFragment = fragment5.mFragmentManager.D0();
        this.f13981a.g(this.f13983c, false);
        this.f13983c.performAttach();
        this.f13981a.b(this.f13983c, false);
    }

    public int d() {
        Fragment fragment = this.f13983c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int iMin = this.f13985e;
        int i10 = b.f13988a[fragment.mMaxState.ordinal()];
        if (i10 != 1) {
            iMin = i10 != 2 ? i10 != 3 ? i10 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        Fragment fragment2 = this.f13983c;
        if (fragment2.mFromLayout) {
            if (fragment2.mInLayout) {
                iMin = Math.max(this.f13985e, 2);
                View view = this.f13983c.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f13985e < 4 ? Math.min(iMin, fragment2.mState) : Math.min(iMin, 1);
            }
        }
        Fragment fragment3 = this.f13983c;
        if (fragment3.mInDynamicContainer && fragment3.mContainer == null) {
            iMin = Math.min(iMin, 4);
        }
        if (!this.f13983c.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        Fragment fragment4 = this.f13983c;
        ViewGroup viewGroup = fragment4.mContainer;
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpactS = viewGroup != null ? SpecialEffectsController.u(viewGroup, fragment4.getParentFragmentManager()).s(this) : null;
        if (lifecycleImpactS == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (lifecycleImpactS == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment5 = this.f13983c;
            if (fragment5.mRemoving) {
                iMin = fragment5.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment6 = this.f13983c;
        if (fragment6.mDeferStart && fragment6.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (this.f13983c.mTransitioning) {
            iMin = Math.max(iMin, 3);
        }
        if (FragmentManager.N0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.f13983c);
        }
        return iMin;
    }

    public void e() {
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f13983c);
        }
        Bundle bundle = this.f13983c.mSavedFragmentState;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        Fragment fragment = this.f13983c;
        if (fragment.mIsCreated) {
            fragment.mState = 1;
            fragment.restoreChildFragmentState();
        } else {
            this.f13981a.h(fragment, bundle2, false);
            this.f13983c.performCreate(bundle2);
            this.f13981a.c(this.f13983c, bundle2, false);
        }
    }

    public void f() throws Resources.NotFoundException {
        String resourceName;
        if (this.f13983c.mFromLayout) {
            return;
        }
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f13983c);
        }
        Bundle bundle = this.f13983c.mSavedFragmentState;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater layoutInflaterPerformGetLayoutInflater = this.f13983c.performGetLayoutInflater(bundle2);
        Fragment fragment = this.f13983c;
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i10 = fragment.mContainerId;
            if (i10 != 0) {
                if (i10 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f13983c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment.mFragmentManager.u0().c(this.f13983c.mContainerId);
                if (viewGroup == null) {
                    Fragment fragment2 = this.f13983c;
                    if (!fragment2.mRestored && !fragment2.mInDynamicContainer) {
                        try {
                            resourceName = fragment2.getResources().getResourceName(this.f13983c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f13983c.mContainerId) + " (" + resourceName + ") for fragment " + this.f13983c);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    FragmentStrictMode.n(this.f13983c, viewGroup);
                }
            }
        }
        Fragment fragment3 = this.f13983c;
        fragment3.mContainer = viewGroup;
        fragment3.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, bundle2);
        if (this.f13983c.mView != null) {
            if (FragmentManager.N0(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + this.f13983c);
            }
            this.f13983c.mView.setSaveFromParentEnabled(false);
            Fragment fragment4 = this.f13983c;
            fragment4.mView.setTag(R$id.fragment_container_view_tag, fragment4);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment5 = this.f13983c;
            if (fragment5.mHidden) {
                fragment5.mView.setVisibility(8);
            }
            if (this.f13983c.mView.isAttachedToWindow()) {
                androidx.core.view.N.e0(this.f13983c.mView);
            } else {
                View view = this.f13983c.mView;
                view.addOnAttachStateChangeListener(new a(view));
            }
            this.f13983c.performViewCreated();
            y yVar = this.f13981a;
            Fragment fragment6 = this.f13983c;
            yVar.m(fragment6, fragment6.mView, bundle2, false);
            int visibility = this.f13983c.mView.getVisibility();
            this.f13983c.setPostOnViewCreatedAlpha(this.f13983c.mView.getAlpha());
            Fragment fragment7 = this.f13983c;
            if (fragment7.mContainer != null && visibility == 0) {
                View viewFindFocus = fragment7.mView.findFocus();
                if (viewFindFocus != null) {
                    this.f13983c.setFocusedView(viewFindFocus);
                    if (FragmentManager.N0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f13983c);
                    }
                }
                this.f13983c.mView.setAlpha(0.0f);
            }
        }
        this.f13983c.mState = 2;
    }

    public void g() {
        Fragment fragmentF;
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f13983c);
        }
        Fragment fragment = this.f13983c;
        boolean zIsChangingConfigurations = true;
        boolean z10 = fragment.mRemoving && !fragment.isInBackStack();
        if (z10) {
            Fragment fragment2 = this.f13983c;
            if (!fragment2.mBeingSaved) {
                this.f13982b.B(fragment2.mWho, null);
            }
        }
        if (!z10 && !this.f13982b.p().q(this.f13983c)) {
            String str = this.f13983c.mTargetWho;
            if (str != null && (fragmentF = this.f13982b.f(str)) != null && fragmentF.mRetainInstance) {
                this.f13983c.mTarget = fragmentF;
            }
            this.f13983c.mState = 0;
            return;
        }
        w<?> wVar = this.f13983c.mHost;
        if (wVar instanceof W) {
            zIsChangingConfigurations = this.f13982b.p().n();
        } else if (wVar.getContext() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) wVar.getContext()).isChangingConfigurations();
        }
        if ((z10 && !this.f13983c.mBeingSaved) || zIsChangingConfigurations) {
            this.f13982b.p().f(this.f13983c, false);
        }
        this.f13983c.performDestroy();
        this.f13981a.d(this.f13983c, false);
        for (I i10 : this.f13982b.k()) {
            if (i10 != null) {
                Fragment fragmentK = i10.k();
                if (this.f13983c.mWho.equals(fragmentK.mTargetWho)) {
                    fragmentK.mTarget = this.f13983c;
                    fragmentK.mTargetWho = null;
                }
            }
        }
        Fragment fragment3 = this.f13983c;
        String str2 = fragment3.mTargetWho;
        if (str2 != null) {
            fragment3.mTarget = this.f13982b.f(str2);
        }
        this.f13982b.s(this);
    }

    public void h() {
        View view;
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f13983c);
        }
        Fragment fragment = this.f13983c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f13983c.performDestroyView();
        this.f13981a.n(this.f13983c, false);
        Fragment fragment2 = this.f13983c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.k(null);
        this.f13983c.mInLayout = false;
    }

    public void i() {
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f13983c);
        }
        this.f13983c.performDetach();
        this.f13981a.e(this.f13983c, false);
        Fragment fragment = this.f13983c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if ((!fragment.mRemoving || fragment.isInBackStack()) && !this.f13982b.p().q(this.f13983c)) {
            return;
        }
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + this.f13983c);
        }
        this.f13983c.initState();
    }

    public void j() {
        Fragment fragment = this.f13983c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.N0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f13983c);
            }
            Bundle bundle = this.f13983c.mSavedFragmentState;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            Fragment fragment2 = this.f13983c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(bundle2), null, bundle2);
            View view = this.f13983c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f13983c;
                fragment3.mView.setTag(R$id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f13983c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f13983c.performViewCreated();
                y yVar = this.f13981a;
                Fragment fragment5 = this.f13983c;
                yVar.m(fragment5, fragment5.mView, bundle2, false);
                this.f13983c.mState = 2;
            }
        }
    }

    public Fragment k() {
        return this.f13983c;
    }

    public final boolean l(View view) {
        if (view == this.f13983c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f13983c.mView) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f13984d) {
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f13984d = true;
            boolean z10 = false;
            while (true) {
                int iD = d();
                Fragment fragment = this.f13983c;
                int i10 = fragment.mState;
                if (iD == i10) {
                    if (!z10 && i10 == -1 && fragment.mRemoving && !fragment.isInBackStack() && !this.f13983c.mBeingSaved) {
                        if (FragmentManager.N0(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f13983c);
                        }
                        this.f13982b.p().f(this.f13983c, true);
                        this.f13982b.s(this);
                        if (FragmentManager.N0(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + this.f13983c);
                        }
                        this.f13983c.initState();
                    }
                    Fragment fragment2 = this.f13983c;
                    if (fragment2.mHiddenChanged) {
                        if (fragment2.mView != null && (viewGroup = fragment2.mContainer) != null) {
                            SpecialEffectsController specialEffectsControllerU = SpecialEffectsController.u(viewGroup, fragment2.getParentFragmentManager());
                            if (this.f13983c.mHidden) {
                                specialEffectsControllerU.k(this);
                            } else {
                                specialEffectsControllerU.m(this);
                            }
                        }
                        Fragment fragment3 = this.f13983c;
                        FragmentManager fragmentManager = fragment3.mFragmentManager;
                        if (fragmentManager != null) {
                            fragmentManager.L0(fragment3);
                        }
                        Fragment fragment4 = this.f13983c;
                        fragment4.mHiddenChanged = false;
                        fragment4.onHiddenChanged(fragment4.mHidden);
                        this.f13983c.mChildFragmentManager.L();
                    }
                    this.f13984d = false;
                    return;
                }
                if (iD <= i10) {
                    switch (i10 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (fragment.mBeingSaved && this.f13982b.q(fragment.mWho) == null) {
                                this.f13982b.B(this.f13983c.mWho, r());
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.f13983c.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (FragmentManager.N0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f13983c);
                            }
                            Fragment fragment5 = this.f13983c;
                            if (fragment5.mBeingSaved) {
                                this.f13982b.B(fragment5.mWho, r());
                            } else if (fragment5.mView != null && fragment5.mSavedViewState == null) {
                                s();
                            }
                            Fragment fragment6 = this.f13983c;
                            if (fragment6.mView != null && (viewGroup2 = fragment6.mContainer) != null) {
                                SpecialEffectsController.u(viewGroup2, fragment6.getParentFragmentManager()).l(this);
                            }
                            this.f13983c.mState = 3;
                            break;
                        case 4:
                            v();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i10 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                SpecialEffectsController.u(viewGroup3, fragment.getParentFragmentManager()).j(SpecialEffectsController.Operation.State.from(this.f13983c.mView.getVisibility()), this);
                            }
                            this.f13983c.mState = 4;
                            break;
                        case 5:
                            u();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z10 = true;
            }
        } catch (Throwable th) {
            this.f13984d = false;
            throw th;
        }
    }

    public void n() {
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f13983c);
        }
        this.f13983c.performPause();
        this.f13981a.f(this.f13983c, false);
    }

    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f13983c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (this.f13983c.mSavedFragmentState.getBundle("savedInstanceState") == null) {
            this.f13983c.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
        }
        try {
            Fragment fragment = this.f13983c;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("viewState");
            Fragment fragment2 = this.f13983c;
            fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("viewRegistryState");
            FragmentState fragmentState = (FragmentState) this.f13983c.mSavedFragmentState.getParcelable(VoiceWakeupReceiver.EXTRA_STATE);
            if (fragmentState != null) {
                Fragment fragment3 = this.f13983c;
                fragment3.mTargetWho = fragmentState.mTargetWho;
                fragment3.mTargetRequestCode = fragmentState.mTargetRequestCode;
                Boolean bool = fragment3.mSavedUserVisibleHint;
                if (bool != null) {
                    fragment3.mUserVisibleHint = bool.booleanValue();
                    this.f13983c.mSavedUserVisibleHint = null;
                } else {
                    fragment3.mUserVisibleHint = fragmentState.mUserVisibleHint;
                }
            }
            Fragment fragment4 = this.f13983c;
            if (fragment4.mUserVisibleHint) {
                return;
            }
            fragment4.mDeferStart = true;
        } catch (BadParcelableException e10) {
            throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + k(), e10);
        }
    }

    public void p() {
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f13983c);
        }
        View focusedView = this.f13983c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean zRequestFocus = focusedView.requestFocus();
            if (FragmentManager.N0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(focusedView);
                sb2.append(" ");
                sb2.append(zRequestFocus ? "succeeded" : "failed");
                sb2.append(" on Fragment ");
                sb2.append(this.f13983c);
                sb2.append(" resulting in focused view ");
                sb2.append(this.f13983c.mView.findFocus());
                Log.v("FragmentManager", sb2.toString());
            }
        }
        this.f13983c.setFocusedView(null);
        this.f13983c.performResume();
        this.f13981a.i(this.f13983c, false);
        this.f13982b.B(this.f13983c.mWho, null);
        Fragment fragment = this.f13983c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public Fragment.SavedState q() {
        if (this.f13983c.mState > -1) {
            return new Fragment.SavedState(r());
        }
        return null;
    }

    public Bundle r() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        Fragment fragment = this.f13983c;
        if (fragment.mState == -1 && (bundle = fragment.mSavedFragmentState) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable(VoiceWakeupReceiver.EXTRA_STATE, new FragmentState(this.f13983c));
        if (this.f13983c.mState > 0) {
            Bundle bundle3 = new Bundle();
            this.f13983c.performSaveInstanceState(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.f13981a.j(this.f13983c, bundle3, false);
            Bundle bundle4 = new Bundle();
            this.f13983c.mSavedStateRegistryController.e(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle bundleS1 = this.f13983c.mChildFragmentManager.s1();
            if (!bundleS1.isEmpty()) {
                bundle2.putBundle("childFragmentManager", bundleS1);
            }
            if (this.f13983c.mView != null) {
                s();
            }
            SparseArray<Parcelable> sparseArray = this.f13983c.mSavedViewState;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = this.f13983c.mSavedViewRegistryState;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = this.f13983c.mArguments;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public void s() {
        if (this.f13983c.mView == null) {
            return;
        }
        if (FragmentManager.N0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.f13983c + " with view " + this.f13983c.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f13983c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f13983c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f13983c.mViewLifecycleOwner.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f13983c.mSavedViewRegistryState = bundle;
    }

    public void t(int i10) {
        this.f13985e = i10;
    }

    public void u() {
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f13983c);
        }
        this.f13983c.performStart();
        this.f13981a.k(this.f13983c, false);
    }

    public void v() {
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f13983c);
        }
        this.f13983c.performStop();
        this.f13981a.l(this.f13983c, false);
    }

    public I(y yVar, J j10, ClassLoader classLoader, v vVar, Bundle bundle) {
        this.f13981a = yVar;
        this.f13982b = j10;
        Fragment fragmentInstantiate = ((FragmentState) bundle.getParcelable(VoiceWakeupReceiver.EXTRA_STATE)).instantiate(vVar, classLoader);
        this.f13983c = fragmentInstantiate;
        fragmentInstantiate.mSavedFragmentState = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        fragmentInstantiate.setArguments(bundle2);
        if (FragmentManager.N0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentInstantiate);
        }
    }

    public I(y yVar, J j10, Fragment fragment, Bundle bundle) {
        this.f13981a = yVar;
        this.f13982b = j10;
        this.f13983c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        fragment.mSavedFragmentState = bundle;
        fragment.mArguments = bundle.getBundle("arguments");
    }
}
