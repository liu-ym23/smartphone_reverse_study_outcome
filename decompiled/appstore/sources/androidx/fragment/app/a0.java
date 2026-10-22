package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f3298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f3299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f3300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3302e;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f3303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a0 f3304b;

        public a(a0 r10, View r11) {
            this.f3304b = r10;
            this.f3303a = r11;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
            this.f3303a.removeOnAttachStateChangeListener(this);
            ViewCompat.m0(this.f3303a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3305a = null;

        static {
            int[] r10 = new int[Lifecycle.State.values().length];
            f3305a = r10;
            r10[Lifecycle.State.RESUMED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f3305a[Lifecycle.State.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f3305a[Lifecycle.State.CREATED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f3305a[Lifecycle.State.INITIALIZED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public a0(r r10, c0 r11, Fragment r12) {
        this.f3301d = false;
        this.f3302e = -1;
        this.f3298a = r10;
        this.f3299b = r11;
        this.f3300c = r12;
    }

    public void a() {
        if (FragmentManager.L0(3) == false) goto L5;
        Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f3300c);
    L5:
        Bundle r10 = this.f3300c.mSavedFragmentState;
        if (r10 == null) goto L8;
        Bundle r11 = r10.getBundle("savedInstanceState");
    L9:
        this.f3300c.performActivityCreated(r11);
        this.f3298a.a(this.f3300c, r11, false);
        return;
    L8:
        r11 = null;
        goto L9
    }

    public void b() {
        Fragment r10 = FragmentManager.l0(this.f3300c.mContainer);
        Fragment r11 = this.f3300c.getParentFragment();
        if (r10 != null) goto L5;
    L7:
        int r12 = this.f3299b.j(this.f3300c);
        Fragment r13 = this.f3300c;
        r13.mContainer.addView(r13.mView, r12);
        return;
    L5:
        if (r10.equals(r11) == true) goto L7;
        Fragment r14 = this.f3300c;
        FragmentStrictMode.q(r14, r10, r14.mContainerId);
        goto L7
    }

    public void c() {
        if (FragmentManager.L0(3) == false) goto L5;
        Log.d("FragmentManager", "moveto ATTACHED: " + this.f3300c);
    L5:
        Fragment r10 = this.f3300c;
        Fragment r11 = r10.mTarget;
        a0 r12 = null;
        if (r11 == null) goto L12;
        a0 r13 = this.f3299b.n(r11.mWho);
        if (r13 == null) goto L11;
        Fragment r14 = this.f3300c;
        r14.mTargetWho = r14.mTarget.mWho;
        r14.mTarget = null;
        r12 = r13;
    L19:
        if (r12 == null) goto L21;
        r12.m();
    L21:
        Fragment r15 = this.f3300c;
        r15.mHost = r15.mFragmentManager.y0();
        Fragment r16 = this.f3300c;
        r16.mParentFragment = r16.mFragmentManager.B0();
        this.f3298a.g(this.f3300c, false);
        this.f3300c.performAttach();
        this.f3298a.b(this.f3300c, false);
        return;
    L11:
        throw new IllegalStateException("Fragment " + this.f3300c + " declared target fragment " + this.f3300c.mTarget + " that does not belong to this FragmentManager!");
    L12:
        String r17 = r10.mTargetWho;
        if (r17 == null) goto L19;
        r12 = this.f3299b.n(r17);
        if (r12 != null) goto L19;
        throw new IllegalStateException("Fragment " + this.f3300c + " declared target fragment " + this.f3300c.mTargetWho + " that does not belong to this FragmentManager!");
    }

    public int d() {
        Fragment r10 = this.f3300c;
        if (r10.mFragmentManager == null) goto L5;
        int r11 = this.f3302e;
        int r12 = b.f3305a[r10.mMaxState.ordinal()];
        if (r12 == 1) goto L15;
        if (r12 == 2) goto L14;
        if (r12 == 3) goto L13;
        if (r12 == 4) goto L12;
        r11 = Math.min(r11, -1);
        goto L15
    L12:
        r11 = Math.min(r11, 0);
        goto L15
    L13:
        r11 = Math.min(r11, 1);
        goto L15
    L14:
        r11 = Math.min(r11, 5);
    L15:
        Fragment r13 = this.f3300c;
        if (r13.mFromLayout == false) goto L29;
        if (r13.mInLayout == false) goto L25;
        r11 = Math.max(this.f3302e, 2);
        View r14 = this.f3300c.mView;
        if (r14 == null) goto L29;
        if (r14.getParent() != null) goto L29;
        r11 = Math.min(r11, 2);
        goto L29
    L25:
        if (this.f3302e >= 4) goto L27;
        r11 = Math.min(r11, r13.mState);
        goto L29
    L27:
        r11 = Math.min(r11, 1);
    L29:
        if (this.f3300c.mAdded == true) goto L31;
        r11 = Math.min(r11, 1);
    L31:
        Fragment r15 = this.f3300c;
        ViewGroup r16 = r15.mContainer;
        if (r16 == null) goto L34;
        SpecialEffectsController.Operation.LifecycleImpact r17 = SpecialEffectsController.r(r16, r15.getParentFragmentManager()).p(this);
    L36:
        if (r17 != SpecialEffectsController.Operation.LifecycleImpact.ADDING) goto L39;
        r11 = Math.min(r11, 6);
    L47:
        Fragment r18 = this.f3300c;
        if (r18.mDeferStart == false) goto L53;
        if (r18.mState >= 5) goto L53;
        r11 = Math.min(r11, 4);
    L53:
        if (FragmentManager.L0(2) == false) goto L55;
        Log.v("FragmentManager", "computeExpectedState() of " + r11 + " for " + this.f3300c);
    L55:
        return r11;
    L39:
        if (r17 != SpecialEffectsController.Operation.LifecycleImpact.REMOVING) goto L41;
        r11 = Math.max(r11, 3);
        goto L47
    L41:
        Fragment r19 = this.f3300c;
        if (r19.mRemoving == false) goto L47;
        if (r19.isInBackStack() == false) goto L46;
        r11 = Math.min(r11, 1);
        goto L47
    L46:
        r11 = Math.min(r11, -1);
        goto L47
    L34:
        r17 = null;
        goto L36
    L5:
        return r10.mState;
    }

    public void e() {
        if (FragmentManager.L0(3) == false) goto L5;
        Log.d("FragmentManager", "moveto CREATED: " + this.f3300c);
    L5:
        Bundle r10 = this.f3300c.mSavedFragmentState;
        if (r10 == null) goto L8;
        Bundle r11 = r10.getBundle("savedInstanceState");
    L9:
        Fragment r12 = this.f3300c;
        if (r12.mIsCreated == true) goto L12;
        this.f3298a.h(r12, r11, false);
        this.f3300c.performCreate(r11);
        this.f3298a.c(this.f3300c, r11, false);
        return;
    L12:
        r12.mState = 1;
        r12.restoreChildFragmentState();
        return;
    L8:
        r11 = null;
        goto L9
    }

    public void f() {
        if (this.f3300c.mFromLayout == false) goto L6;
        return;
    L6:
        if (FragmentManager.L0(3) == false) goto L8;
        Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f3300c);
    L8:
        Bundle r10 = this.f3300c.mSavedFragmentState;
        ViewGroup r11 = null;
        if (r10 == null) goto L11;
        Bundle r12 = r10.getBundle("savedInstanceState");
    L12:
        LayoutInflater r13 = this.f3300c.performGetLayoutInflater(r12);
        Fragment r14 = this.f3300c;
        ViewGroup r15 = r14.mContainer;
        if (r15 == null) goto L15;
        r11 = r15;
    L34:
        Fragment r16 = this.f3300c;
        r16.mContainer = r11;
        r16.performCreateView(r13, r11, r12);
        if (this.f3300c.mView != null) goto L37;
    L58:
        this.f3300c.mState = 2;
        return;
    L37:
        if (FragmentManager.L0(3) == false) goto L39;
        Log.d("FragmentManager", "moveto VIEW_CREATED: " + this.f3300c);
    L39:
        this.f3300c.mView.setSaveFromParentEnabled(false);
        Fragment r17 = this.f3300c;
        r17.mView.setTag(R$id.fragment_container_view_tag, r17);
        if (r11 == null) goto L42;
        b();
    L42:
        Fragment r18 = this.f3300c;
        if (r18.mHidden == false) goto L46;
        r18.mView.setVisibility(8);
    L46:
        if (ViewCompat.S(this.f3300c.mView) == false) goto L48;
        ViewCompat.m0(this.f3300c.mView);
    L49:
        this.f3300c.performViewCreated();
        r r19 = this.f3298a;
        Fragment r20 = this.f3300c;
        r19.m(r20, r20.mView, r12, false);
        int r21 = this.f3300c.mView.getVisibility();
        this.f3300c.setPostOnViewCreatedAlpha(this.f3300c.mView.getAlpha());
        Fragment r22 = this.f3300c;
        if (r22.mContainer == null) goto L58;
        if (r21 != 0) goto L58;
        View r23 = r22.mView.findFocus();
        if (r23 == null) goto L57;
        this.f3300c.setFocusedView(r23);
        if (FragmentManager.L0(2) == false) goto L57;
        Log.v("FragmentManager", "requestFocus: Saved focused view " + r23 + " for Fragment " + this.f3300c);
    L57:
        this.f3300c.mView.setAlpha(0.0f);
        goto L58
    L48:
        View r24 = this.f3300c.mView;
        r24.addOnAttachStateChangeListener(new a(this, r24));
        goto L49
    L15:
        int r25 = r14.mContainerId;
        if (r25 == 0) goto L34;
        if (r25 == (-1)) goto L33;
        r11 = (ViewGroup) r14.mFragmentManager.s0().b(this.f3300c.mContainerId);
        if (r11 != null) goto L30;
        Fragment r26 = this.f3300c;
        if (r26.mRestored == true) goto L34;
        String r27 = r26.getResources().getResourceName(this.f3300c.mContainerId);     // Catch: Resources.NotFoundException -> L26
    L28:
        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f3300c.mContainerId) + " (" + r27 + ") for fragment " + this.f3300c);
    L26:
        r27 = "unknown";
        goto L28
    L30:
        if ((r11 instanceof FragmentContainerView) == true) goto L34;
        FragmentStrictMode.p(this.f3300c, r11);
        goto L34
    L33:
        throw new IllegalArgumentException("Cannot create fragment " + this.f3300c + " for a container view with no id");
    L11:
        r12 = null;
        goto L12
    }

    public void g() {
        if (FragmentManager.L0(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom CREATED: " + this.f3300c);
    L5:
        Fragment r10 = this.f3300c;
        boolean r11 = true;
        if (r10.mRemoving == true) goto L8;
    L10:
        boolean r12 = false;
    L12:
        if (r12 == false) goto L16;
        Fragment r13 = this.f3300c;
        if (r13.mBeingSaved == true) goto L16;
        this.f3299b.B(r13.mWho, null);
    L16:
        if (r12 == false) goto L18;
    L28:
        FragmentHostCallback r14 = this.f3300c.mHost;
        if ((r14 instanceof ViewModelStoreOwner) == false) goto L32;
        r11 = this.f3299b.p().o();
    L34:
        if (r12 == true) goto L36;
    L37:
        if (r11 == false) goto L39;
    L38:
        this.f3299b.p().g(this.f3300c, false);
    L39:
        this.f3300c.performDestroy();
        this.f3298a.d(this.f3300c, false);
        Iterator r15 = this.f3299b.k().iterator();
    L41:
        if (r15.hasNext() == false) goto L47;
        a0 r16 = (a0) r15.next();
        if (r16 == null) goto L41;
        Fragment r17 = r16.k();
        if (this.f3300c.mWho.equals(r17.mTargetWho) == false) goto L41;
        r17.mTarget = this.f3300c;
        r17.mTargetWho = null;
        goto L41
    L47:
        Fragment r18 = this.f3300c;
        String r19 = r18.mTargetWho;
        if (r19 == null) goto L50;
        r18.mTarget = this.f3299b.f(r19);
    L50:
        this.f3299b.s(this);
        return;
    L36:
        if (this.f3300c.mBeingSaved == false) goto L38;
    L32:
        if ((r14.e() instanceof Activity) == false) goto L34;
        r11 = true ^ ((Activity) r14.e()).isChangingConfigurations();
        goto L34
    L18:
        if (this.f3299b.p().r(this.f3300c) == true) goto L28;
        String r20 = this.f3300c.mTargetWho;
        if (r20 == null) goto L27;
        Fragment r21 = this.f3299b.f(r20);
        if (r21 == null) goto L27;
        if (r21.mRetainInstance == false) goto L27;
        this.f3300c.mTarget = r21;
    L27:
        this.f3300c.mState = 0;
        return;
    L8:
        if (r10.isInBackStack() == true) goto L10;
        r12 = true;
        goto L12
    }

    public void h() {
        if (FragmentManager.L0(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f3300c);
    L5:
        Fragment r10 = this.f3300c;
        ViewGroup r11 = r10.mContainer;
        if (r11 == null) goto L10;
        View r12 = r10.mView;
        if (r12 == null) goto L10;
        r11.removeView(r12);
    L10:
        this.f3300c.performDestroyView();
        this.f3298a.n(this.f3300c, false);
        Fragment r13 = this.f3300c;
        r13.mContainer = null;
        r13.mView = null;
        r13.mViewLifecycleOwner = null;
        r13.mViewLifecycleOwnerLiveData.p(null);
        this.f3300c.mInLayout = false;
    }

    public void i() {
        if (FragmentManager.L0(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom ATTACHED: " + this.f3300c);
    L5:
        this.f3300c.performDetach();
        this.f3298a.e(this.f3300c, false);
        Fragment r10 = this.f3300c;
        r10.mState = -1;
        r10.mHost = null;
        r10.mParentFragment = null;
        r10.mFragmentManager = null;
        if (r10.mRemoving == false) goto L11;
        if (r10.isInBackStack() == true) goto L11;
    L13:
        if (FragmentManager.L0(3) == false) goto L15;
        Log.d("FragmentManager", "initState called for fragment: " + this.f3300c);
    L15:
        this.f3300c.initState();
        return;
    L11:
        if (this.f3299b.p().r(this.f3300c) == true) goto L13;
    }

    public void j() {
        Fragment r10 = this.f3300c;
        if (r10.mFromLayout == true) goto L5;
        return;
    L5:
        if (r10.mInLayout == true) goto L7;
        return;
    L7:
        if (r10.mPerformedCreateView == false) goto L9;
        return;
    L9:
        if (FragmentManager.L0(3) == false) goto L11;
        Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f3300c);
    L11:
        Bundle r11 = this.f3300c.mSavedFragmentState;
        if (r11 == null) goto L14;
        Bundle r12 = r11.getBundle("savedInstanceState");
    L15:
        Fragment r13 = this.f3300c;
        r13.performCreateView(r13.performGetLayoutInflater(r12), null, r12);
        View r14 = this.f3300c.mView;
        if (r14 == null) goto L25;
        r14.setSaveFromParentEnabled(false);
        Fragment r15 = this.f3300c;
        r15.mView.setTag(R$id.fragment_container_view_tag, r15);
        Fragment r16 = this.f3300c;
        if (r16.mHidden == false) goto L20;
        r16.mView.setVisibility(8);
    L20:
        this.f3300c.performViewCreated();
        r r17 = this.f3298a;
        Fragment r18 = this.f3300c;
        r17.m(r18, r18.mView, r12, false);
        this.f3300c.mState = 2;
        return;
    L25:
        return;
    L14:
        r12 = null;
        goto L15
    }

    public Fragment k() {
        return this.f3300c;
    }

    public final boolean l(View r10) {
        if (r10 != this.f3300c.mView) goto L5;
        return true;
    L5:
        ViewParent r11 = r10.getParent();
    L6:
        if (r11 == null) goto L11;
        if (r11 == this.f3300c.mView) goto L9;
        r11 = r11.getParent();
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    public void m() {
        if (this.f3301d == false) goto L98;
        if (FragmentManager.L0(2) == false) goto L119;
        Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
        return;
    L119:
        return;
    L98:
        this.f3301d = true;     // Catch: Throwable -> L17
        boolean r10 = false;
    L10:
        int r11 = d();     // Catch: Throwable -> L17
        Fragment r12 = this.f3300c;     // Catch: Throwable -> L17
        int r13 = r12.mState;     // Catch: Throwable -> L17
        if (r11 == r13) goto L64;
        if (r11 <= r13) goto L32;
        switch((r13 + 1)) {
            case 0: goto L30;
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L16;
            default: goto L63;
        };     // Catch: Throwable -> L17
    L16:
        p();     // Catch: Throwable -> L17
        goto L63
    L19:
        r12.mState = 6;     // Catch: Throwable -> L17
        goto L63
    L20:
        u();     // Catch: Throwable -> L17
        goto L63
    L27:
        a();     // Catch: Throwable -> L17
        goto L63
    L28:
        j();     // Catch: Throwable -> L17
        f();     // Catch: Throwable -> L17
        goto L63
    L29:
        e();     // Catch: Throwable -> L17
        goto L63
    L30:
        c();     // Catch: Throwable -> L17
    L63:
        r10 = true;
        goto L10
    L22:
        if (r12.mView == null) goto L26;
        ViewGroup r14 = r12.mContainer;     // Catch: Throwable -> L17
        if (r14 == null) goto L26;
        SpecialEffectsController.r(r14, r12.getParentFragmentManager()).f(SpecialEffectsController.Operation.State.from(this.f3300c.mView.getVisibility()), this);     // Catch: Throwable -> L17
    L26:
        this.f3300c.mState = 4;     // Catch: Throwable -> L17
        goto L63
    L32:
        switch((r13 - 1)) {
            case -1: goto L62;
            case 0: goto L57;
            case 1: goto L55;
            case 2: goto L54;
            case 3: goto L38;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L34;
            default: goto L63;
        };     // Catch: Throwable -> L17
    L34:
        n();     // Catch: Throwable -> L17
        goto L63
    L35:
        r12.mState = 5;     // Catch: Throwable -> L17
        goto L63
    L36:
        v();     // Catch: Throwable -> L17
        goto L63
    L54:
        r12.mInLayout = false;     // Catch: Throwable -> L17
        r12.mState = 2;     // Catch: Throwable -> L17
        goto L63
    L55:
        h();     // Catch: Throwable -> L17
        this.f3300c.mState = 1;     // Catch: Throwable -> L17
        goto L63
    L62:
        i();     // Catch: Throwable -> L17
        goto L63
    L38:
        if (FragmentManager.L0(3) == false) goto L40;
        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f3300c);     // Catch: Throwable -> L17
    L40:
        Fragment r15 = this.f3300c;     // Catch: Throwable -> L17
        if (r15.mBeingSaved == false) goto L44;
        this.f3299b.B(r15.mWho, r());     // Catch: Throwable -> L17
    L48:
        Fragment r16 = this.f3300c;     // Catch: Throwable -> L17
        if (r16.mView == null) goto L53;
        ViewGroup r17 = r16.mContainer;     // Catch: Throwable -> L17
        if (r17 == null) goto L53;
        SpecialEffectsController.r(r17, r16.getParentFragmentManager()).h(this);     // Catch: Throwable -> L17
    L53:
        this.f3300c.mState = 3;     // Catch: Throwable -> L17
        goto L63
    L44:
        if (r15.mView == null) goto L48;
        if (r15.mSavedViewState != null) goto L48;
        s();     // Catch: Throwable -> L17
        goto L48
    L57:
        if (r12.mBeingSaved == true) goto L59;
    L61:
        g();     // Catch: Throwable -> L17
        goto L63
    L59:
        if (this.f3299b.q(r12.mWho) != null) goto L61;
        this.f3299b.B(this.f3300c.mWho, r());     // Catch: Throwable -> L17
        goto L61
    L64:
        if (r10 == false) goto L66;
    L80:
        Fragment r18 = this.f3300c;     // Catch: Throwable -> L17
        if (r18.mHiddenChanged == true) goto L83;
    L94:
        this.f3301d = false;
        return;
    L83:
        if (r18.mView == null) goto L90;
        ViewGroup r19 = r18.mContainer;     // Catch: Throwable -> L17
        if (r19 == null) goto L90;
        SpecialEffectsController r20 = SpecialEffectsController.r(r19, r18.getParentFragmentManager());     // Catch: Throwable -> L17
        if (this.f3300c.mHidden == false) goto L89;
        r20.g(this);     // Catch: Throwable -> L17
        goto L90
    L89:
        r20.i(this);     // Catch: Throwable -> L17
    L90:
        Fragment r21 = this.f3300c;     // Catch: Throwable -> L17
        FragmentManager r22 = r21.mFragmentManager;     // Catch: Throwable -> L17
        if (r22 == null) goto L93;
        r22.J0(r21);     // Catch: Throwable -> L17
    L93:
        Fragment r23 = this.f3300c;     // Catch: Throwable -> L17
        r23.mHiddenChanged = false;     // Catch: Throwable -> L17
        r23.onHiddenChanged(r23.mHidden);     // Catch: Throwable -> L17
        this.f3300c.mChildFragmentManager.I();     // Catch: Throwable -> L17
        goto L94
    L66:
        if (r13 != (-1)) goto L80;
        if (r12.mRemoving == false) goto L80;
        if (r12.isInBackStack() == true) goto L80;
        if (this.f3300c.mBeingSaved == true) goto L80;
        if (FragmentManager.L0(3) == false) goto L76;
        Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f3300c);     // Catch: Throwable -> L17
    L76:
        this.f3299b.p().g(this.f3300c, true);     // Catch: Throwable -> L17
        this.f3299b.s(this);     // Catch: Throwable -> L17
        if (FragmentManager.L0(3) == false) goto L79;
        Log.d("FragmentManager", "initState called for fragment: " + this.f3300c);     // Catch: Throwable -> L17
    L79:
        this.f3300c.initState();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.f3301d = false;
        throw th;
    }

    public void n() {
        if (FragmentManager.L0(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom RESUMED: " + this.f3300c);
    L5:
        this.f3300c.performPause();
        this.f3298a.f(this.f3300c, false);
    }

    public void o(ClassLoader r10) {
        Bundle r11 = this.f3300c.mSavedFragmentState;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.setClassLoader(r10);
        if (this.f3300c.mSavedFragmentState.getBundle("savedInstanceState") != null) goto L8;
        this.f3300c.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
    L8:
        Fragment r12 = this.f3300c;
        r12.mSavedViewState = r12.mSavedFragmentState.getSparseParcelableArray("viewState");
        Fragment r13 = this.f3300c;
        r13.mSavedViewRegistryState = r13.mSavedFragmentState.getBundle("viewRegistryState");
        FragmentState r14 = (FragmentState) this.f3300c.mSavedFragmentState.getParcelable(WsConstants.KEY_CONNECTION_STATE);
        if (r14 == null) goto L14;
        Fragment r15 = this.f3300c;
        r15.mTargetWho = r14.mTargetWho;
        r15.mTargetRequestCode = r14.mTargetRequestCode;
        Boolean r16 = r15.mSavedUserVisibleHint;
        if (r16 == null) goto L13;
        r15.mUserVisibleHint = r16.booleanValue();
        this.f3300c.mSavedUserVisibleHint = null;
        goto L14
    L13:
        r15.mUserVisibleHint = r14.mUserVisibleHint;
    L14:
        Fragment r17 = this.f3300c;
        if (r17.mUserVisibleHint == true) goto L18;
        r17.mDeferStart = true;
        return;
    }

    public void p() {
        if (FragmentManager.L0(3) == false) goto L5;
        Log.d("FragmentManager", "moveto RESUMED: " + this.f3300c);
    L5:
        View r10 = this.f3300c.getFocusedView();
        if (r10 != null) goto L8;
    L16:
        this.f3300c.setFocusedView(null);
        this.f3300c.performResume();
        this.f3298a.i(this.f3300c, false);
        this.f3299b.B(this.f3300c.mWho, null);
        Fragment r11 = this.f3300c;
        r11.mSavedFragmentState = null;
        r11.mSavedViewState = null;
        r11.mSavedViewRegistryState = null;
        return;
    L8:
        if (l(r10) == false) goto L16;
        boolean r12 = r10.requestFocus();
        if (FragmentManager.L0(2) == false) goto L16;
        StringBuilder r13 = new StringBuilder();
        r13.append("requestFocus: Restoring focused view ");
        r13.append(r10);
        r13.append(" ");
        if (r12 == false) goto L14;
        String r14 = "succeeded";
    L15:
        r13.append(r14);
        r13.append(" on Fragment ");
        r13.append(this.f3300c);
        r13.append(" resulting in focused view ");
        r13.append(this.f3300c.mView.findFocus());
        Log.v("FragmentManager", r13.toString());
        goto L16
    L14:
        r14 = "failed";
        goto L15
    }

    public Fragment.SavedState q() {
        if (this.f3300c.mState > (-1)) goto L5;
        return null;
    L5:
        return new Fragment.SavedState(r());
    }

    public Bundle r() {
        Bundle r10 = new Bundle();
        Fragment r11 = this.f3300c;
        if (r11.mState != (-1)) goto L7;
        Bundle r12 = r11.mSavedFragmentState;
        if (r12 == null) goto L7;
        r10.putAll(r12);
    L7:
        r10.putParcelable(WsConstants.KEY_CONNECTION_STATE, new FragmentState(this.f3300c));
        if (this.f3300c.mState <= (-1)) goto L27;
        Bundle r13 = new Bundle();
        this.f3300c.performSaveInstanceState(r13);
        if (r13.isEmpty() == true) goto L12;
        r10.putBundle("savedInstanceState", r13);
    L12:
        this.f3298a.j(this.f3300c, r13, false);
        Bundle r14 = new Bundle();
        this.f3300c.mSavedStateRegistryController.e(r14);
        if (r14.isEmpty() == true) goto L15;
        r10.putBundle("registryState", r14);
    L15:
        Bundle r15 = this.f3300c.mChildFragmentManager.w1();
        if (r15.isEmpty() == true) goto L19;
        r10.putBundle("childFragmentManager", r15);
    L19:
        if (this.f3300c.mView == null) goto L21;
        s();
    L21:
        SparseArray<Parcelable> r16 = this.f3300c.mSavedViewState;
        if (r16 == null) goto L24;
        r10.putSparseParcelableArray("viewState", r16);
    L24:
        Bundle r17 = this.f3300c.mSavedViewRegistryState;
        if (r17 == null) goto L27;
        r10.putBundle("viewRegistryState", r17);
    L27:
        Bundle r18 = this.f3300c.mArguments;
        if (r18 == null) goto L30;
        r10.putBundle("arguments", r18);
    L30:
        return r10;
    }

    public void s() {
        if (this.f3300c.mView != null) goto L6;
        return;
    L6:
        if (FragmentManager.L0(2) == false) goto L8;
        Log.v("FragmentManager", "Saving view state for fragment " + this.f3300c + " with view " + this.f3300c.mView);
    L8:
        SparseArray<Parcelable> r10 = new SparseArray();
        this.f3300c.mView.saveHierarchyState(r10);
        if (r10.size() <= 0) goto L11;
        this.f3300c.mSavedViewState = r10;
    L11:
        Bundle r11 = new Bundle();
        this.f3300c.mViewLifecycleOwner.d(r11);
        if (r11.isEmpty() == true) goto L15;
        this.f3300c.mSavedViewRegistryState = r11;
        return;
    }

    public void t(int r10) {
        this.f3302e = r10;
    }

    public void u() {
        if (FragmentManager.L0(3) == false) goto L5;
        Log.d("FragmentManager", "moveto STARTED: " + this.f3300c);
    L5:
        this.f3300c.performStart();
        this.f3298a.k(this.f3300c, false);
    }

    public void v() {
        if (FragmentManager.L0(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom STARTED: " + this.f3300c);
    L5:
        this.f3300c.performStop();
        this.f3298a.l(this.f3300c, false);
    }

    public a0(r r10, c0 r11, ClassLoader r12, p r13, Bundle r14) {
        this.f3301d = false;
        this.f3302e = -1;
        this.f3298a = r10;
        this.f3299b = r11;
        Fragment r15 = ((FragmentState) r14.getParcelable(WsConstants.KEY_CONNECTION_STATE)).instantiate(r13, r12);
        this.f3300c = r15;
        r15.mSavedFragmentState = r14;
        Bundle r16 = r14.getBundle("arguments");
        if (r16 == null) goto L5;
        r16.setClassLoader(r12);
    L5:
        r15.setArguments(r16);
        if (FragmentManager.L0(2) == false) goto L9;
        Log.v("FragmentManager", "Instantiated fragment " + r15);
        return;
    }

    public a0(r r10, c0 r11, Fragment r12, Bundle r13) {
        this.f3301d = false;
        this.f3302e = -1;
        this.f3298a = r10;
        this.f3299b = r11;
        this.f3300c = r12;
        r12.mSavedViewState = null;
        r12.mSavedViewRegistryState = null;
        r12.mBackStackNesting = 0;
        r12.mInLayout = false;
        r12.mAdded = false;
        Fragment r14 = r12.mTarget;
        if (r14 == null) goto L5;
        String r15 = r14.mWho;
    L6:
        r12.mTargetWho = r15;
        r12.mTarget = null;
        r12.mSavedFragmentState = r13;
        r12.mArguments = r13.getBundle("arguments");
        return;
    L5:
        r15 = null;
        goto L6
    }
}
