package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.EnumC0327y;
import androidx.lifecycle.u0;
import b0.AbstractC0357c;
import b0.C0356b;
import b0.C0358d;
import b0.EnumC0355a;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final C0301x f3720a;

    /* renamed from: b, reason: collision with root package name */
    public final d0 f3721b;

    /* renamed from: c, reason: collision with root package name */
    public final D f3722c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3723d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f3724e = -1;

    public c0(C0301x c0301x, d0 d0Var, D d4) {
        this.f3720a = c0301x;
        this.f3721b = d0Var;
        this.f3722c = d4;
    }

    public final void a() {
        View view;
        View view2;
        d0 d0Var = this.f3721b;
        d0Var.getClass();
        D d4 = this.f3722c;
        ViewGroup viewGroup = d4.mContainer;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            ArrayList arrayList = d0Var.f3727a;
            int iIndexOf = arrayList.indexOf(d4);
            int i4 = iIndexOf - 1;
            while (true) {
                if (i4 < 0) {
                    while (true) {
                        iIndexOf++;
                        if (iIndexOf >= arrayList.size()) {
                            break;
                        }
                        D d5 = (D) arrayList.get(iIndexOf);
                        if (d5.mContainer == viewGroup && (view = d5.mView) != null) {
                            iIndexOfChild = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    D d6 = (D) arrayList.get(i4);
                    if (d6.mContainer == viewGroup && (view2 = d6.mView) != null) {
                        iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i4--;
                }
            }
        }
        d4.mContainer.addView(d4.mView, iIndexOfChild);
    }

    public final void b() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        D d4 = this.f3722c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto ATTACHED: " + d4);
        }
        D d5 = d4.mTarget;
        c0 c0Var = null;
        d0 d0Var = this.f3721b;
        if (d5 != null) {
            c0 c0Var2 = (c0) d0Var.f3728b.get(d5.mWho);
            if (c0Var2 == null) {
                throw new IllegalStateException("Fragment " + d4 + " declared target fragment " + d4.mTarget + " that does not belong to this FragmentManager!");
            }
            d4.mTargetWho = d4.mTarget.mWho;
            d4.mTarget = null;
            c0Var = c0Var2;
        } else {
            String str = d4.mTargetWho;
            if (str != null && (c0Var = (c0) d0Var.f3728b.get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(d4);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(B0.g.r(sb, d4.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (c0Var != null) {
            c0Var.j();
        }
        Y y4 = d4.mFragmentManager;
        d4.mHost = y4.f3682u;
        d4.mParentFragment = y4.f3684w;
        C0301x c0301x = this.f3720a;
        c0301x.g(false);
        d4.performAttach();
        c0301x.b(false);
    }

    public final int c() {
        q0 q0Var;
        D d4 = this.f3722c;
        if (d4.mFragmentManager == null) {
            return d4.mState;
        }
        int iMin = this.f3724e;
        int iOrdinal = d4.mMaxState.ordinal();
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (d4.mFromLayout) {
            if (d4.mInLayout) {
                iMin = Math.max(this.f3724e, 2);
                View view = d4.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f3724e < 4 ? Math.min(iMin, d4.mState) : Math.min(iMin, 1);
            }
        }
        if (!d4.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = d4.mContainer;
        if (viewGroup != null) {
            r0 r0VarG = r0.g(viewGroup, d4.getParentFragmentManager());
            r0VarG.getClass();
            q0 q0VarD = r0VarG.d(d4);
            i = q0VarD != null ? q0VarD.f3802b : 0;
            Iterator it = r0VarG.f3827c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    q0Var = null;
                    break;
                }
                q0Var = (q0) it.next();
                if (q0Var.f3803c.equals(d4) && !q0Var.f3806f) {
                    break;
                }
            }
            if (q0Var != null && (i == 0 || i == 1)) {
                i = q0Var.f3802b;
            }
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (d4.mRemoving) {
            iMin = d4.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (d4.mDeferStart && d4.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + d4);
        }
        return iMin;
    }

    public final void d() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        D d4 = this.f3722c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto CREATED: " + d4);
        }
        if (d4.mIsCreated) {
            d4.restoreChildFragmentState(d4.mSavedFragmentState);
            d4.mState = 1;
        } else {
            C0301x c0301x = this.f3720a;
            c0301x.h(false);
            d4.performCreate(d4.mSavedFragmentState);
            c0301x.c(false);
        }
    }

    public final void e() throws Resources.NotFoundException {
        String resourceName;
        D fragment = this.f3722c;
        if (fragment.mFromLayout) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
        }
        LayoutInflater layoutInflaterPerformGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup container = fragment.mContainer;
        if (container == null) {
            int i4 = fragment.mContainerId;
            if (i4 == 0) {
                container = null;
            } else {
                if (i4 == -1) {
                    throw new IllegalArgumentException(B0.g.l("Cannot create fragment ", fragment, " for a container view with no id"));
                }
                container = (ViewGroup) fragment.mFragmentManager.f3683v.b(i4);
                if (container == null) {
                    if (!fragment.mRestored) {
                        try {
                            resourceName = fragment.getResources().getResourceName(fragment.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + resourceName + ") for fragment " + fragment);
                    }
                } else if (!(container instanceof FragmentContainerView)) {
                    C0356b c0356b = AbstractC0357c.f4364a;
                    Intrinsics.checkNotNullParameter(fragment, "fragment");
                    Intrinsics.checkNotNullParameter(container, "container");
                    C0358d c0358d = new C0358d(fragment, container, 1);
                    AbstractC0357c.c(c0358d);
                    C0356b c0356bA = AbstractC0357c.a(fragment);
                    if (c0356bA.f4362a.contains(EnumC0355a.f4359h) && AbstractC0357c.e(c0356bA, fragment.getClass(), C0358d.class)) {
                        AbstractC0357c.b(c0356bA, c0358d);
                    }
                }
            }
        }
        fragment.mContainer = container;
        fragment.performCreateView(layoutInflaterPerformGetLayoutInflater, container, fragment.mSavedFragmentState);
        View view = fragment.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
            if (container != null) {
                a();
            }
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            View view2 = fragment.mView;
            WeakHashMap weakHashMap = K.S.f939a;
            if (view2.isAttachedToWindow()) {
                K.H.c(fragment.mView);
            } else {
                View view3 = fragment.mView;
                view3.addOnAttachStateChangeListener(new M(this, view3));
            }
            fragment.performViewCreated();
            this.f3720a.m(false);
            int visibility = fragment.mView.getVisibility();
            fragment.setPostOnViewCreatedAlpha(fragment.mView.getAlpha());
            if (fragment.mContainer != null && visibility == 0) {
                View viewFindFocus = fragment.mView.findFocus();
                if (viewFindFocus != null) {
                    fragment.setFocusedView(viewFindFocus);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragment);
                    }
                }
                fragment.mView.setAlpha(Property.DEFAULT_FLOAT_VALUE);
            }
        }
        fragment.mState = 2;
    }

    public final void f() {
        D dB;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        D d4 = this.f3722c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom CREATED: " + d4);
        }
        boolean zIsChangingConfigurations = true;
        boolean z4 = d4.mRemoving && !d4.isInBackStack();
        d0 d0Var = this.f3721b;
        if (z4 && !d4.mBeingSaved) {
        }
        if (!z4) {
            a0 a0Var = d0Var.f3730d;
            if (a0Var.f3708a.containsKey(d4.mWho) && a0Var.f3711d && !a0Var.f3712e) {
                String str = d4.mTargetWho;
                if (str != null && (dB = d0Var.b(str)) != null && dB.mRetainInstance) {
                    d4.mTarget = dB;
                }
                d4.mState = 0;
                return;
            }
        }
        L l4 = d4.mHost;
        if (l4 instanceof u0) {
            zIsChangingConfigurations = d0Var.f3730d.f3712e;
        } else {
            Context context = l4.f3626b;
            if (context instanceof Activity) {
                zIsChangingConfigurations = true ^ ((Activity) context).isChangingConfigurations();
            }
        }
        if ((z4 && !d4.mBeingSaved) || zIsChangingConfigurations) {
            d0Var.f3730d.d(d4);
        }
        d4.performDestroy();
        this.f3720a.d(false);
        Iterator it = d0Var.d().iterator();
        while (it.hasNext()) {
            c0 c0Var = (c0) it.next();
            if (c0Var != null) {
                String str2 = d4.mWho;
                D d5 = c0Var.f3722c;
                if (str2.equals(d5.mTargetWho)) {
                    d5.mTarget = d4;
                    d5.mTargetWho = null;
                }
            }
        }
        String str3 = d4.mTargetWho;
        if (str3 != null) {
            d4.mTarget = d0Var.b(str3);
        }
        d0Var.h(this);
    }

    public final void g() {
        View view;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        D d4 = this.f3722c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + d4);
        }
        ViewGroup viewGroup = d4.mContainer;
        if (viewGroup != null && (view = d4.mView) != null) {
            viewGroup.removeView(view);
        }
        d4.performDestroyView();
        this.f3720a.n(false);
        d4.mContainer = null;
        d4.mView = null;
        d4.mViewLifecycleOwner = null;
        d4.mViewLifecycleOwnerLiveData.g(null);
        d4.mInLayout = false;
    }

    public final void h() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        D d4 = this.f3722c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + d4);
        }
        d4.performDetach();
        this.f3720a.e(false);
        d4.mState = -1;
        d4.mHost = null;
        d4.mParentFragment = null;
        d4.mFragmentManager = null;
        if (!d4.mRemoving || d4.isInBackStack()) {
            a0 a0Var = this.f3721b.f3730d;
            if (a0Var.f3708a.containsKey(d4.mWho) && a0Var.f3711d && !a0Var.f3712e) {
                return;
            }
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "initState called for fragment: " + d4);
        }
        d4.initState();
    }

    public final void i() {
        D d4 = this.f3722c;
        if (d4.mFromLayout && d4.mInLayout && !d4.mPerformedCreateView) {
            if (Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + d4);
            }
            d4.performCreateView(d4.performGetLayoutInflater(d4.mSavedFragmentState), null, d4.mSavedFragmentState);
            View view = d4.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                d4.mView.setTag(R.id.fragment_container_view_tag, d4);
                if (d4.mHidden) {
                    d4.mView.setVisibility(8);
                }
                d4.performViewCreated();
                this.f3720a.m(false);
                d4.mState = 2;
            }
        }
    }

    public final void j() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z4 = this.f3723d;
        D d4 = this.f3722c;
        if (z4) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + d4);
                return;
            }
            return;
        }
        try {
            this.f3723d = true;
            boolean z5 = false;
            while (true) {
                int iC = c();
                int i4 = d4.mState;
                d0 d0Var = this.f3721b;
                if (iC == i4) {
                    if (!z5 && i4 == -1 && d4.mRemoving && !d4.isInBackStack() && !d4.mBeingSaved) {
                        if (Log.isLoggable("FragmentManager", 3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + d4);
                        }
                        d0Var.f3730d.d(d4);
                        d0Var.h(this);
                        if (Log.isLoggable("FragmentManager", 3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + d4);
                        }
                        d4.initState();
                    }
                    if (d4.mHiddenChanged) {
                        if (d4.mView != null && (viewGroup = d4.mContainer) != null) {
                            r0 r0VarG = r0.g(viewGroup, d4.getParentFragmentManager());
                            if (d4.mHidden) {
                                r0VarG.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + d4);
                                }
                                r0VarG.a(3, 1, this);
                            } else {
                                r0VarG.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + d4);
                                }
                                r0VarG.a(2, 1, this);
                            }
                        }
                        Y y4 = d4.mFragmentManager;
                        if (y4 != null && d4.mAdded && Y.G(d4)) {
                            y4.f3652E = true;
                        }
                        d4.mHiddenChanged = false;
                        d4.onHiddenChanged(d4.mHidden);
                        d4.mChildFragmentManager.n();
                    }
                    this.f3723d = false;
                    return;
                }
                C0301x c0301x = this.f3720a;
                if (iC <= i4) {
                    switch (i4 - 1) {
                        case -1:
                            h();
                            break;
                        case 0:
                            if (d4.mBeingSaved) {
                                if (((FragmentState) d0Var.f3729c.get(d4.mWho)) == null) {
                                    m();
                                }
                            }
                            f();
                            break;
                        case 1:
                            g();
                            d4.mState = 1;
                            break;
                        case 2:
                            d4.mInLayout = false;
                            d4.mState = 2;
                            break;
                        case 3:
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + d4);
                            }
                            if (d4.mBeingSaved) {
                                m();
                            } else if (d4.mView != null && d4.mSavedViewState == null) {
                                n();
                            }
                            if (d4.mView != null && (viewGroup2 = d4.mContainer) != null) {
                                r0 r0VarG2 = r0.g(viewGroup2, d4.getParentFragmentManager());
                                r0VarG2.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + d4);
                                }
                                r0VarG2.a(1, 3, this);
                            }
                            d4.mState = 3;
                            break;
                        case 4:
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Log.d("FragmentManager", "movefrom STARTED: " + d4);
                            }
                            d4.performStop();
                            c0301x.l(false);
                            break;
                        case 5:
                            d4.mState = 5;
                            break;
                        case 6:
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Log.d("FragmentManager", "movefrom RESUMED: " + d4);
                            }
                            d4.performPause();
                            c0301x.f(false);
                            break;
                    }
                } else {
                    switch (i4 + 1) {
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
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + d4);
                            }
                            d4.performActivityCreated(d4.mSavedFragmentState);
                            c0301x.a(false);
                            break;
                        case 4:
                            if (d4.mView != null && (viewGroup3 = d4.mContainer) != null) {
                                r0 r0VarG3 = r0.g(viewGroup3, d4.getParentFragmentManager());
                                int iB = B0.g.b(d4.mView.getVisibility());
                                r0VarG3.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + d4);
                                }
                                r0VarG3.a(iB, 2, this);
                            }
                            d4.mState = 4;
                            break;
                        case 5:
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Log.d("FragmentManager", "moveto STARTED: " + d4);
                            }
                            d4.performStart();
                            c0301x.k(false);
                            break;
                        case 6:
                            d4.mState = 6;
                            break;
                        case 7:
                            l();
                            break;
                    }
                }
                z5 = true;
            }
        } catch (Throwable th) {
            this.f3723d = false;
            throw th;
        }
    }

    public final void k(ClassLoader classLoader) {
        D d4 = this.f3722c;
        Bundle bundle = d4.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        d4.mSavedViewState = d4.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        d4.mSavedViewRegistryState = d4.mSavedFragmentState.getBundle("android:view_registry_state");
        d4.mTargetWho = d4.mSavedFragmentState.getString("android:target_state");
        if (d4.mTargetWho != null) {
            d4.mTargetRequestCode = d4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Boolean bool = d4.mSavedUserVisibleHint;
        if (bool != null) {
            d4.mUserVisibleHint = bool.booleanValue();
            d4.mSavedUserVisibleHint = null;
        } else {
            d4.mUserVisibleHint = d4.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        if (d4.mUserVisibleHint) {
            return;
        }
        d4.mDeferStart = true;
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
            java.lang.String r1 = "FragmentManager"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            androidx.fragment.app.D r2 = r6.f3722c
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
            boolean r4 = android.util.Log.isLoggable(r1, r4)
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
            androidx.fragment.app.x r6 = r6.f3720a
            r1 = 0
            r6.i(r1)
            r2.mSavedFragmentState = r0
            r2.mSavedViewState = r0
            r2.mSavedViewRegistryState = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.c0.l():void");
    }

    public final void m() {
        D d4 = this.f3722c;
        FragmentState fragmentState = new FragmentState(d4);
        if (d4.mState <= -1 || fragmentState.f3615m != null) {
            fragmentState.f3615m = d4.mSavedFragmentState;
        } else {
            Bundle bundle = new Bundle();
            d4.performSaveInstanceState(bundle);
            this.f3720a.j(false);
            if (bundle.isEmpty()) {
                bundle = null;
            }
            if (d4.mView != null) {
                n();
            }
            if (d4.mSavedViewState != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray("android:view_state", d4.mSavedViewState);
            }
            if (d4.mSavedViewRegistryState != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBundle("android:view_registry_state", d4.mSavedViewRegistryState);
            }
            if (!d4.mUserVisibleHint) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android:user_visible_hint", d4.mUserVisibleHint);
            }
            fragmentState.f3615m = bundle;
            if (d4.mTargetWho != null) {
                if (bundle == null) {
                    fragmentState.f3615m = new Bundle();
                }
                fragmentState.f3615m.putString("android:target_state", d4.mTargetWho);
                int i4 = d4.mTargetRequestCode;
                if (i4 != 0) {
                    fragmentState.f3615m.putInt("android:target_req_state", i4);
                }
            }
        }
    }

    public final void n() {
        D d4 = this.f3722c;
        if (d4.mView == null) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + d4 + " with view " + d4.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        d4.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            d4.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        d4.mViewLifecycleOwner.f3790e.c(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        d4.mSavedViewRegistryState = bundle;
    }

    public c0(C0301x c0301x, d0 d0Var, ClassLoader classLoader, T t4, FragmentState fragmentState) {
        this.f3720a = c0301x;
        this.f3721b = d0Var;
        D dA = t4.a(fragmentState.f3603a);
        Bundle bundle = fragmentState.f3612j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        dA.setArguments(bundle);
        dA.mWho = fragmentState.f3604b;
        dA.mFromLayout = fragmentState.f3605c;
        dA.mRestored = true;
        dA.mFragmentId = fragmentState.f3606d;
        dA.mContainerId = fragmentState.f3607e;
        dA.mTag = fragmentState.f3608f;
        dA.mRetainInstance = fragmentState.f3609g;
        dA.mRemoving = fragmentState.f3610h;
        dA.mDetached = fragmentState.f3611i;
        dA.mHidden = fragmentState.f3613k;
        dA.mMaxState = EnumC0327y.values()[fragmentState.f3614l];
        Bundle bundle2 = fragmentState.f3615m;
        if (bundle2 != null) {
            dA.mSavedFragmentState = bundle2;
        } else {
            dA.mSavedFragmentState = new Bundle();
        }
        this.f3722c = dA;
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Instantiated fragment " + dA);
        }
    }

    public c0(C0301x c0301x, d0 d0Var, D d4, FragmentState fragmentState) {
        this.f3720a = c0301x;
        this.f3721b = d0Var;
        this.f3722c = d4;
        d4.mSavedViewState = null;
        d4.mSavedViewRegistryState = null;
        d4.mBackStackNesting = 0;
        d4.mInLayout = false;
        d4.mAdded = false;
        D d5 = d4.mTarget;
        d4.mTargetWho = d5 != null ? d5.mWho : null;
        d4.mTarget = null;
        Bundle bundle = fragmentState.f3615m;
        if (bundle != null) {
            d4.mSavedFragmentState = bundle;
        } else {
            d4.mSavedFragmentState = new Bundle();
        }
    }
}
