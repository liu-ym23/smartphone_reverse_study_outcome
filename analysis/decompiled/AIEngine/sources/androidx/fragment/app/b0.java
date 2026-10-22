package androidx.fragment.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.WrongFragmentContainerViolation;
import androidx.lifecycle.t0;
import com.stepos.aiengine.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final v f2079a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f2080b;

    /* renamed from: c, reason: collision with root package name */
    public final Fragment f2081c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2082d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f2083e = -1;

    public b0(v vVar, c0 c0Var, Fragment fragment) {
        this.f2079a = vVar;
        this.f2080b = c0Var;
        this.f2081c = fragment;
    }

    public final void a() {
        View view;
        View view2;
        ArrayList<Fragment> arrayList = this.f2080b.f2090a;
        Fragment fragment = this.f2081c;
        ViewGroup viewGroup = fragment.mContainer;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            int iIndexOf = arrayList.indexOf(fragment);
            int i10 = iIndexOf - 1;
            while (true) {
                if (i10 < 0) {
                    while (true) {
                        iIndexOf++;
                        if (iIndexOf >= arrayList.size()) {
                            break;
                        }
                        Fragment fragment2 = arrayList.get(iIndexOf);
                        if (fragment2.mContainer == viewGroup && (view = fragment2.mView) != null) {
                            iIndexOfChild = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    Fragment fragment3 = arrayList.get(i10);
                    if (fragment3.mContainer == viewGroup && (view2 = fragment3.mView) != null) {
                        iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i10--;
                }
            }
        }
        fragment.mContainer.addView(fragment.mView, iIndexOfChild);
    }

    public final void b() {
        boolean zG = FragmentManager.G(3);
        Fragment fragment = this.f2081c;
        if (zG) {
            Log.d("FragmentManager", "moveto ATTACHED: " + fragment);
        }
        Fragment fragment2 = fragment.mTarget;
        b0 b0Var = null;
        c0 c0Var = this.f2080b;
        if (fragment2 != null) {
            b0 b0Var2 = c0Var.f2091b.get(fragment2.mWho);
            if (b0Var2 == null) {
                throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
            }
            fragment.mTargetWho = fragment.mTarget.mWho;
            fragment.mTarget = null;
            b0Var = b0Var2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (b0Var = c0Var.f2091b.get(str)) == null) {
                StringBuilder sb2 = new StringBuilder("Fragment ");
                sb2.append(fragment);
                sb2.append(" declared target fragment ");
                throw new IllegalStateException(ai.onnxruntime.a.o(sb2, fragment.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (b0Var != null) {
            b0Var.j();
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        fragment.mHost = fragmentManager.f2031u;
        fragment.mParentFragment = fragmentManager.f2033w;
        v vVar = this.f2079a;
        vVar.g(false);
        fragment.performAttach();
        vVar.b(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4, types: [androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact] */
    /* JADX WARN: Type inference failed for: r14v15, types: [androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact] */
    public final int c() {
        Fragment fragment = this.f2081c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int iMin = this.f2083e;
        int iOrdinal = fragment.mMaxState.ordinal();
        int i10 = 0;
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (fragment.mFromLayout) {
            if (fragment.mInLayout) {
                iMin = Math.max(this.f2083e, 2);
                View view = fragment.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f2083e < 4 ? Math.min(iMin, fragment.mState) : Math.min(iMin, 1);
            }
        }
        if (!fragment.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = fragment.mContainer;
        SpecialEffectsController.Operation operation = null;
        if (viewGroup != null) {
            SpecialEffectsController specialEffectsControllerF = SpecialEffectsController.f(viewGroup, fragment.getParentFragmentManager());
            SpecialEffectsController.Operation operationD = specialEffectsControllerF.d(fragment);
            SpecialEffectsController.Operation operation2 = operationD != null ? operationD.f2055b : null;
            ArrayList<SpecialEffectsController.Operation> arrayList = specialEffectsControllerF.f2051c;
            int size = arrayList.size();
            while (true) {
                if (i10 >= size) {
                    break;
                }
                SpecialEffectsController.Operation operation3 = arrayList.get(i10);
                i10++;
                SpecialEffectsController.Operation operation4 = operation3;
                if (operation4.f2056c.equals(fragment) && !operation4.f2059f) {
                    operation = operation4;
                    break;
                }
            }
            operation = (operation == null || !(operation2 == null || operation2 == SpecialEffectsController.Operation.LifecycleImpact.f2061a)) ? operation2 : operation.f2055b;
        }
        if (operation == SpecialEffectsController.Operation.LifecycleImpact.f2062b) {
            iMin = Math.min(iMin, 6);
        } else if (operation == SpecialEffectsController.Operation.LifecycleImpact.f2063c) {
            iMin = Math.max(iMin, 3);
        } else if (fragment.mRemoving) {
            iMin = fragment.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (fragment.mDeferStart && fragment.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (FragmentManager.G(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + fragment);
        }
        return iMin;
    }

    public final void d() {
        boolean zG = FragmentManager.G(3);
        Fragment fragment = this.f2081c;
        if (zG) {
            Log.d("FragmentManager", "moveto CREATED: " + fragment);
        }
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            fragment.mState = 1;
        } else {
            v vVar = this.f2079a;
            vVar.h(false);
            fragment.performCreate(fragment.mSavedFragmentState);
            vVar.c(false);
        }
    }

    public final void e() throws Resources.NotFoundException {
        String resourceName;
        Fragment fragment = this.f2081c;
        if (fragment.mFromLayout) {
            return;
        }
        if (FragmentManager.G(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
        }
        LayoutInflater layoutInflaterPerformGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            int i10 = fragment.mContainerId;
            if (i10 == 0) {
                viewGroup = null;
            } else {
                if (i10 == -1) {
                    throw new IllegalArgumentException(a0.a.i("Cannot create fragment ", fragment, " for a container view with no id"));
                }
                viewGroup = (ViewGroup) fragment.mFragmentManager.f2032v.b(i10);
                if (viewGroup == null) {
                    if (!fragment.mRestored) {
                        try {
                            resourceName = fragment.getResources().getResourceName(fragment.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + resourceName + ") for fragment " + fragment);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    FragmentStrictMode.a aVar = FragmentStrictMode.f2180a;
                    WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, "Attempting to add fragment " + fragment + " to container " + viewGroup + " which is not a FragmentContainerView");
                    FragmentStrictMode.c(wrongFragmentContainerViolation);
                    FragmentStrictMode.a aVarA = FragmentStrictMode.a(fragment);
                    if (aVarA.f2190a.contains(FragmentStrictMode.Flag.f2187k) && FragmentStrictMode.e(aVarA, fragment.getClass(), WrongFragmentContainerViolation.class)) {
                        FragmentStrictMode.b(aVarA, wrongFragmentContainerViolation);
                    }
                }
            }
        }
        fragment.mContainer = viewGroup;
        fragment.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, fragment.mSavedFragmentState);
        View view = fragment.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
            if (viewGroup != null) {
                a();
            }
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            View view2 = fragment.mView;
            WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
            if (view2.isAttachedToWindow()) {
                e0.c.b(fragment.mView);
            } else {
                View view3 = fragment.mView;
                view3.addOnAttachStateChangeListener(new a(view3));
            }
            fragment.performViewCreated();
            this.f2079a.m(false);
            int visibility = fragment.mView.getVisibility();
            fragment.setPostOnViewCreatedAlpha(fragment.mView.getAlpha());
            if (fragment.mContainer != null && visibility == 0) {
                View viewFindFocus = fragment.mView.findFocus();
                if (viewFindFocus != null) {
                    fragment.setFocusedView(viewFindFocus);
                    if (FragmentManager.G(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragment);
                    }
                }
                fragment.mView.setAlpha(0.0f);
            }
        }
        fragment.mState = 2;
    }

    public final void f() {
        Fragment fragmentB;
        boolean zG = FragmentManager.G(3);
        Fragment fragment = this.f2081c;
        if (zG) {
            Log.d("FragmentManager", "movefrom CREATED: " + fragment);
        }
        int i10 = 0;
        boolean zIsChangingConfigurations = true;
        boolean z = fragment.mRemoving && !fragment.isInBackStack();
        c0 c0Var = this.f2080b;
        if (z && !fragment.mBeingSaved) {
            c0Var.i(fragment.mWho, null);
        }
        if (!z) {
            z zVar = c0Var.f2093d;
            if (!((zVar.f2206b.containsKey(fragment.mWho) && zVar.f2209e) ? zVar.f2210f : true)) {
                String str = fragment.mTargetWho;
                if (str != null && (fragmentB = c0Var.b(str)) != null && fragmentB.mRetainInstance) {
                    fragment.mTarget = fragmentB;
                }
                fragment.mState = 0;
                return;
            }
        }
        t<?> tVar = fragment.mHost;
        if (tVar instanceof t0) {
            zIsChangingConfigurations = c0Var.f2093d.f2210f;
        } else {
            o oVar = tVar.f2194b;
            if (oVar != null) {
                zIsChangingConfigurations = true ^ oVar.isChangingConfigurations();
            }
        }
        if ((z && !fragment.mBeingSaved) || zIsChangingConfigurations) {
            c0Var.f2093d.d(fragment);
        }
        fragment.performDestroy();
        this.f2079a.d(false);
        ArrayList arrayListD = c0Var.d();
        int size = arrayListD.size();
        while (i10 < size) {
            Object obj = arrayListD.get(i10);
            i10++;
            b0 b0Var = (b0) obj;
            if (b0Var != null) {
                Fragment fragment2 = b0Var.f2081c;
                if (fragment.mWho.equals(fragment2.mTargetWho)) {
                    fragment2.mTarget = fragment;
                    fragment2.mTargetWho = null;
                }
            }
        }
        String str2 = fragment.mTargetWho;
        if (str2 != null) {
            fragment.mTarget = c0Var.b(str2);
        }
        c0Var.h(this);
    }

    public final void g() {
        View view;
        boolean zG = FragmentManager.G(3);
        Fragment fragment = this.f2081c;
        if (zG) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + fragment);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        fragment.performDestroyView();
        this.f2079a.n(false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.f(null);
        fragment.mInLayout = false;
    }

    public final void h() {
        boolean zG = FragmentManager.G(3);
        Fragment fragment = this.f2081c;
        if (zG) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + fragment);
        }
        fragment.performDetach();
        this.f2079a.e(false);
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            z zVar = this.f2080b.f2093d;
            if (!((zVar.f2206b.containsKey(fragment.mWho) && zVar.f2209e) ? zVar.f2210f : true)) {
                return;
            }
        }
        if (FragmentManager.G(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + fragment);
        }
        fragment.initState();
    }

    public final void i() {
        Fragment fragment = this.f2081c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.G(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
            }
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            View view = fragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.performViewCreated();
                this.f2079a.m(false);
                fragment.mState = 2;
            }
        }
    }

    public final void j() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z = this.f2082d;
        Fragment fragment = this.f2081c;
        if (z) {
            if (FragmentManager.G(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + fragment);
                return;
            }
            return;
        }
        try {
            this.f2082d = true;
            boolean z3 = false;
            while (true) {
                int iC = c();
                int i10 = fragment.mState;
                c0 c0Var = this.f2080b;
                if (iC == i10) {
                    if (!z3 && i10 == -1 && fragment.mRemoving && !fragment.isInBackStack() && !fragment.mBeingSaved) {
                        if (FragmentManager.G(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + fragment);
                        }
                        c0Var.f2093d.d(fragment);
                        c0Var.h(this);
                        if (FragmentManager.G(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + fragment);
                        }
                        fragment.initState();
                    }
                    if (fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            SpecialEffectsController specialEffectsControllerF = SpecialEffectsController.f(viewGroup, fragment.getParentFragmentManager());
                            boolean z10 = fragment.mHidden;
                            SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact = SpecialEffectsController.Operation.LifecycleImpact.f2061a;
                            if (z10) {
                                if (FragmentManager.G(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragment);
                                }
                                specialEffectsControllerF.a(SpecialEffectsController.Operation.State.f2067c, lifecycleImpact, this);
                            } else {
                                if (FragmentManager.G(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragment);
                                }
                                specialEffectsControllerF.a(SpecialEffectsController.Operation.State.f2066b, lifecycleImpact, this);
                            }
                        }
                        FragmentManager fragmentManager = fragment.mFragmentManager;
                        if (fragmentManager != null && fragment.mAdded && FragmentManager.H(fragment)) {
                            fragmentManager.E = true;
                        }
                        fragment.mHiddenChanged = false;
                        fragment.onHiddenChanged(fragment.mHidden);
                        fragment.mChildFragmentManager.n();
                    }
                    this.f2082d = false;
                    return;
                }
                v vVar = this.f2079a;
                if (iC <= i10) {
                    switch (i10 - 1) {
                        case -1:
                            h();
                            break;
                        case 0:
                            if (fragment.mBeingSaved) {
                                if (c0Var.f2092c.get(fragment.mWho) == null) {
                                    m();
                                }
                            }
                            f();
                            break;
                        case 1:
                            g();
                            fragment.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (FragmentManager.G(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                            }
                            if (fragment.mBeingSaved) {
                                m();
                            } else if (fragment.mView != null && fragment.mSavedViewState == null) {
                                n();
                            }
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                SpecialEffectsController specialEffectsControllerF2 = SpecialEffectsController.f(viewGroup2, fragment.getParentFragmentManager());
                                if (FragmentManager.G(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragment);
                                }
                                specialEffectsControllerF2.a(SpecialEffectsController.Operation.State.f2065a, SpecialEffectsController.Operation.LifecycleImpact.f2063c, this);
                            }
                            fragment.mState = 3;
                            break;
                        case 4:
                            if (FragmentManager.G(3)) {
                                Log.d("FragmentManager", "movefrom STARTED: " + fragment);
                            }
                            fragment.performStop();
                            vVar.l(false);
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            if (FragmentManager.G(3)) {
                                Log.d("FragmentManager", "movefrom RESUMED: " + fragment);
                            }
                            fragment.performPause();
                            vVar.f(false);
                            break;
                    }
                } else {
                    switch (i10 + 1) {
                        case 0:
                            b();
                            break;
                        case 1:
                            d();
                            break;
                        case 2:
                            i();
                            e();
                            break;
                        case 3:
                            if (FragmentManager.G(3)) {
                                Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
                            }
                            fragment.performActivityCreated(fragment.mSavedFragmentState);
                            vVar.a(false);
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                SpecialEffectsController specialEffectsControllerF3 = SpecialEffectsController.f(viewGroup3, fragment.getParentFragmentManager());
                                SpecialEffectsController.Operation.State stateB = SpecialEffectsController.Operation.State.b(fragment.mView.getVisibility());
                                if (FragmentManager.G(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragment);
                                }
                                specialEffectsControllerF3.a(stateB, SpecialEffectsController.Operation.LifecycleImpact.f2062b, this);
                            }
                            fragment.mState = 4;
                            break;
                        case 5:
                            if (FragmentManager.G(3)) {
                                Log.d("FragmentManager", "moveto STARTED: " + fragment);
                            }
                            fragment.performStart();
                            vVar.k(false);
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            l();
                            break;
                    }
                }
                z3 = true;
            }
        } catch (Throwable th) {
            this.f2082d = false;
            throw th;
        }
    }

    public final void k(ClassLoader classLoader) {
        Fragment fragment = this.f2081c;
        Bundle bundle = fragment.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        fragment.mSavedViewRegistryState = fragment.mSavedFragmentState.getBundle("android:view_registry_state");
        fragment.mTargetWho = fragment.mSavedFragmentState.getString("android:target_state");
        if (fragment.mTargetWho != null) {
            fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Boolean bool = fragment.mSavedUserVisibleHint;
        if (bool != null) {
            fragment.mUserVisibleHint = bool.booleanValue();
            fragment.mSavedUserVisibleHint = null;
        } else {
            fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        if (fragment.mUserVisibleHint) {
            return;
        }
        fragment.mDeferStart = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            r6 = this;
            r0 = 3
            boolean r0 = androidx.fragment.app.FragmentManager.G(r0)
            java.lang.String r1 = "FragmentManager"
            androidx.fragment.app.Fragment r2 = r6.f2081c
            if (r0 == 0) goto L1c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "moveto RESUMED: "
            r0.<init>(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L1c:
            android.view.View r0 = r2.getFocusedView()
            if (r0 == 0) goto L78
            android.view.View r3 = r2.mView
            if (r0 != r3) goto L27
            goto L31
        L27:
            android.view.ViewParent r3 = r0.getParent()
        L2b:
            if (r3 == 0) goto L78
            android.view.View r4 = r2.mView
            if (r3 != r4) goto L73
        L31:
            boolean r3 = r0.requestFocus()
            r4 = 2
            boolean r4 = androidx.fragment.app.FragmentManager.G(r4)
            if (r4 == 0) goto L78
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "requestFocus: Restoring focused view "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r0 = " "
            r4.append(r0)
            if (r3 == 0) goto L50
            java.lang.String r0 = "succeeded"
            goto L52
        L50:
            java.lang.String r0 = "failed"
        L52:
            r4.append(r0)
            java.lang.String r0 = " on Fragment "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = " resulting in focused view "
            r4.append(r0)
            android.view.View r0 = r2.mView
            android.view.View r0 = r0.findFocus()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.util.Log.v(r1, r0)
            goto L78
        L73:
            android.view.ViewParent r3 = r3.getParent()
            goto L2b
        L78:
            r0 = 0
            r2.setFocusedView(r0)
            r2.performResume()
            androidx.fragment.app.v r6 = r6.f2079a
            r1 = 0
            r6.i(r1)
            r2.mSavedFragmentState = r0
            r2.mSavedViewState = r0
            r2.mSavedViewRegistryState = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.b0.l():void");
    }

    public final void m() {
        Fragment fragment = this.f2081c;
        FragmentState fragmentState = new FragmentState(fragment);
        if (fragment.mState <= -1 || fragmentState.mSavedFragmentState != null) {
            fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
        } else {
            Bundle bundle = new Bundle();
            fragment.performSaveInstanceState(bundle);
            this.f2079a.j(false);
            if (bundle.isEmpty()) {
                bundle = null;
            }
            if (fragment.mView != null) {
                n();
            }
            if (fragment.mSavedViewState != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
            }
            if (fragment.mSavedViewRegistryState != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBundle("android:view_registry_state", fragment.mSavedViewRegistryState);
            }
            if (!fragment.mUserVisibleHint) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
            }
            fragmentState.mSavedFragmentState = bundle;
            if (fragment.mTargetWho != null) {
                if (bundle == null) {
                    fragmentState.mSavedFragmentState = new Bundle();
                }
                fragmentState.mSavedFragmentState.putString("android:target_state", fragment.mTargetWho);
                int i10 = fragment.mTargetRequestCode;
                if (i10 != 0) {
                    fragmentState.mSavedFragmentState.putInt("android:target_req_state", i10);
                }
            }
        }
        this.f2080b.i(fragment.mWho, fragmentState);
    }

    public final void n() {
        Fragment fragment = this.f2081c;
        if (fragment.mView == null) {
            return;
        }
        if (FragmentManager.G(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + fragment + " with view " + fragment.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        fragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            fragment.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        fragment.mViewLifecycleOwner.f2162d.b(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        fragment.mSavedViewRegistryState = bundle;
    }

    public b0(v vVar, c0 c0Var, ClassLoader classLoader, s sVar, FragmentState fragmentState) {
        this.f2079a = vVar;
        this.f2080b = c0Var;
        Fragment fragmentInstantiate = fragmentState.instantiate(sVar, classLoader);
        this.f2081c = fragmentInstantiate;
        if (FragmentManager.G(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentInstantiate);
        }
    }

    public b0(v vVar, c0 c0Var, Fragment fragment, FragmentState fragmentState) {
        this.f2079a = vVar;
        this.f2080b = c0Var;
        this.f2081c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.mSavedFragmentState;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2084a;

        public a(View view) {
            this.f2084a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            View view2 = this.f2084a;
            view2.removeOnAttachStateChangeListener(this);
            WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
            e0.c.b(view2);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }
}
