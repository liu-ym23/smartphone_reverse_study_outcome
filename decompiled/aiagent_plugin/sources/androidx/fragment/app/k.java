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
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.ap;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: FragmentStateManager.java */
/* JADX INFO: loaded from: classes.dex */
class k {
    private static final String TAG = "FragmentManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f1815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f1816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Fragment f1817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1819e;

    /* JADX INFO: renamed from: androidx.fragment.app.k$1, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentStateManager.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1820a = null;

        static {
            int[] r0 = new int[androidx.lifecycle.i.b.values().length];
            f1820a = r0;
            r0[androidx.lifecycle.i.b.f2058e.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f1820a[androidx.lifecycle.i.b.f2057d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f1820a[androidx.lifecycle.i.b.f2056c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f1820a[androidx.lifecycle.i.b.f2055b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    k(f r2, l r3, Fragment r4) {
        this.f1818d = false;
        this.f1819e = -1;
        this.f1815a = r2;
        this.f1816b = r3;
        this.f1817c = r4;
    }

    k(f r2, l r3, ClassLoader r4, FragmentFactory r5, FragmentState r6) {
        this.f1818d = false;
        this.f1819e = -1;
        this.f1815a = r2;
        this.f1816b = r3;
        Fragment r7 = r5.c(r4, r6.mClassName);
        this.f1817c = r7;
        if (r6.mArguments == null) goto L5;
        r6.mArguments.setClassLoader(r4);
    L5:
        r7.setArguments(r6.mArguments);
        r7.mWho = r6.mWho;
        r7.mFromLayout = r6.mFromLayout;
        r7.mRestored = true;
        r7.mFragmentId = r6.mFragmentId;
        r7.mContainerId = r6.mContainerId;
        r7.mTag = r6.mTag;
        r7.mRetainInstance = r6.mRetainInstance;
        r7.mRemoving = r6.mRemoving;
        r7.mDetached = r6.mDetached;
        r7.mHidden = r6.mHidden;
        r7.mMaxState = androidx.lifecycle.i.b.values()[r6.mMaxLifecycleState];
        if (r6.mSavedFragmentState == null) goto L8;
        r7.mSavedFragmentState = r6.mSavedFragmentState;
    L10:
        if (FragmentManager.a(2) == false) goto L13;
        a(TAG, "Instantiated fragment " + r7);
        return;
    L13:
        return;
    L8:
        r7.mSavedFragmentState = new Bundle();
        goto L10
    }

    k(f r3, l r4, Fragment r5, FragmentState r6) {
        this.f1818d = false;
        this.f1819e = -1;
        this.f1815a = r3;
        this.f1816b = r4;
        this.f1817c = r5;
        r5.mSavedViewState = null;
        r5.mSavedViewRegistryState = null;
        r5.mBackStackNesting = 0;
        r5.mInLayout = false;
        r5.mAdded = false;
        if (r5.mTarget == null) goto L5;
        String r7 = r5.mTarget.mWho;
    L6:
        r5.mTargetWho = r7;
        r5.mTarget = null;
        if (r6.mSavedFragmentState == null) goto L9;
        r5.mSavedFragmentState = r6.mSavedFragmentState;
        return;
    L9:
        r5.mSavedFragmentState = new Bundle();
        return;
    L5:
        r7 = null;
        goto L6
    }

    Fragment a() {
        return this.f1817c;
    }

    void a(int r1) {
        this.f1819e = r1;
    }

    int b() {
        if (this.f1817c.mFragmentManager == null) goto L5;
        int r0 = this.f1819e;
        int r1 = AnonymousClass1.f1820a[this.f1817c.mMaxState.ordinal()];
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L13;
        if (r1 == 4) goto L12;
        r0 = Math.min(r0, -1);
        goto L16
    L12:
        r0 = Math.min(r0, 0);
        goto L16
    L13:
        r0 = Math.min(r0, 1);
        goto L16
    L14:
        r0 = Math.min(r0, 5);
    L16:
        if (this.f1817c.mFromLayout == false) goto L29;
        if (this.f1817c.mInLayout == false) goto L25;
        r0 = Math.max(this.f1819e, 2);
        if (this.f1817c.mView == null) goto L29;
        if (this.f1817c.mView.getParent() != null) goto L29;
        r0 = Math.min(r0, 2);
        goto L29
    L25:
        if (this.f1819e >= 4) goto L27;
        r0 = Math.min(r0, this.f1817c.mState);
        goto L29
    L27:
        r0 = Math.min(r0, 1);
    L29:
        if (this.f1817c.mAdded == true) goto L31;
        r0 = Math.min(r0, 1);
    L31:
        t.b.a r2 = null;
        if (FragmentManager.f1731a == false) goto L37;
        if (this.f1817c.mContainer == null) goto L37;
        r2 = t.a(this.f1817c.mContainer, this.f1817c.getParentFragmentManager()).a(this);
    L37:
        if (r2 != t.b.a.f1901b) goto L40;
        r0 = Math.min(r0, 6);
    L49:
        if (this.f1817c.mDeferStart == false) goto L54;
        if (this.f1817c.mState >= 5) goto L54;
        r0 = Math.min(r0, 4);
    L54:
        if (FragmentManager.a(2) == false) goto L56;
        a(TAG, "computeExpectedState() of " + r0 + " for " + this.f1817c);
    L56:
        return r0;
    L40:
        if (r2 != t.b.a.f1902c) goto L43;
        r0 = Math.max(r0, 3);
        goto L49
    L43:
        if (this.f1817c.mRemoving == false) goto L49;
        if (this.f1817c.isInBackStack() == false) goto L47;
        r0 = Math.min(r0, 1);
        goto L49
    L47:
        r0 = Math.min(r0, -1);
        goto L49
    L5:
        return this.f1817c.mState;
    }

    void c() {
        if (this.f1818d == false) goto L75;
        if (FragmentManager.a(2) == false) goto L117;
        a(TAG, "Ignoring re-entrant call to moveToExpectedState() for " + a());
        return;
    L117:
        return;
    L75:
        this.f1818d = true;     // Catch: Throwable -> L72
    L10:
        int r4 = b();     // Catch: Throwable -> L72
        if (r4 == this.f1817c.mState) goto L55;
        if (r4 > this.f1817c.mState) goto L15;
        switch((this.f1817c.mState - 1)) {
            case -1: goto L53;
            case 0: goto L52;
            case 1: goto L51;
            case 2: goto L50;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L33;
            default: goto L10;
        };     // Catch: Throwable -> L72
    L33:
        k();     // Catch: Throwable -> L72
        goto L10
    L34:
        this.f1817c.mState = 5;     // Catch: Throwable -> L72
        goto L10
    L35:
        l();     // Catch: Throwable -> L72
        goto L10
    L37:
        if (FragmentManager.a(3) == false) goto L40;
        b(TAG, "movefrom ACTIVITY_CREATED: " + this.f1817c);     // Catch: Throwable -> L72
    L40:
        if (this.f1817c.mView == null) goto L45;
        if (this.f1817c.mSavedViewState != null) goto L45;
        o();     // Catch: Throwable -> L72
    L45:
        if (this.f1817c.mView != null) goto L47;
    L49:
        this.f1817c.mState = 3;     // Catch: Throwable -> L72
        goto L10
    L47:
        if (this.f1817c.mContainer == null) goto L49;
        t.a(this.f1817c.mContainer, this.f1817c.getParentFragmentManager()).d(this);     // Catch: Throwable -> L72
        goto L49
    L50:
        this.f1817c.mInLayout = false;     // Catch: Throwable -> L72
        this.f1817c.mState = 2;     // Catch: Throwable -> L72
        goto L10
    L51:
        p();     // Catch: Throwable -> L72
        this.f1817c.mState = 1;     // Catch: Throwable -> L72
        goto L10
    L52:
        q();     // Catch: Throwable -> L72
        goto L10
    L53:
        r();     // Catch: Throwable -> L72
        goto L10
    L15:
        switch((this.f1817c.mState + 1)) {
            case 0: goto L29;
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            default: goto L10;
        };     // Catch: Throwable -> L72
    L17:
        j();     // Catch: Throwable -> L72
        goto L10
    L18:
        this.f1817c.mState = 6;     // Catch: Throwable -> L72
        goto L10
    L19:
        i();     // Catch: Throwable -> L72
        goto L10
    L21:
        if (this.f1817c.mView != null) goto L23;
    L25:
        this.f1817c.mState = 4;     // Catch: Throwable -> L72
        goto L10
    L23:
        if (this.f1817c.mContainer == null) goto L25;
        t.a(this.f1817c.mContainer, this.f1817c.getParentFragmentManager()).a(t.b.EnumC0056b.a(this.f1817c.mView.getVisibility()), this);     // Catch: Throwable -> L72
        goto L25
    L26:
        h();     // Catch: Throwable -> L72
        goto L10
    L27:
        d();     // Catch: Throwable -> L72
        g();     // Catch: Throwable -> L72
        goto L10
    L28:
        f();     // Catch: Throwable -> L72
        goto L10
    L29:
        e();     // Catch: Throwable -> L72
        goto L10
    L55:
        if (FragmentManager.f1731a == true) goto L57;
    L70:
        this.f1818d = false;
        return;
    L57:
        if (this.f1817c.mHiddenChanged == false) goto L70;
        if (this.f1817c.mView == null) goto L67;
        if (this.f1817c.mContainer == null) goto L67;
        t r1 = t.a(this.f1817c.mContainer, this.f1817c.getParentFragmentManager());     // Catch: Throwable -> L72
        if (this.f1817c.mHidden == false) goto L65;
        r1.c(this);     // Catch: Throwable -> L72
        goto L67
    L65:
        r1.b(this);     // Catch: Throwable -> L72
    L67:
        if (this.f1817c.mFragmentManager == null) goto L69;
        this.f1817c.mFragmentManager.r(this.f1817c);     // Catch: Throwable -> L72
    L69:
        this.f1817c.mHiddenChanged = false;     // Catch: Throwable -> L72
        Fragment r2 = this.f1817c;     // Catch: Throwable -> L72
        r2.onHiddenChanged(r2.mHidden);     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        this.f1818d = false;
        throw th;
    }

    void d() {
        if (this.f1817c.mFromLayout == true) goto L5;
        return;
    L5:
        if (this.f1817c.mInLayout == true) goto L7;
        return;
    L7:
        if (this.f1817c.mPerformedCreateView == false) goto L9;
        return;
    L9:
        if (FragmentManager.a(3) == false) goto L11;
        b(TAG, "moveto CREATE_VIEW: " + this.f1817c);
    L11:
        Fragment r0 = this.f1817c;
        r0.performCreateView(r0.performGetLayoutInflater(r0.mSavedFragmentState), null, this.f1817c.mSavedFragmentState);
        if (this.f1817c.mView == null) goto L21;
        this.f1817c.mView.setSaveFromParentEnabled(false);
        this.f1817c.mView.setTag(ZeusTransformUtils.mapRes(R.id.fragment_container_view_tag, DbHelper.COL_ID, "fragment_container_view_tag"), this.f1817c);
        if (this.f1817c.mHidden == false) goto L16;
        this.f1817c.mView.setVisibility(8);
    L16:
        this.f1817c.performViewCreated();
        f r1 = this.f1815a;
        Fragment r2 = this.f1817c;
        r1.a(r2, r2.mView, this.f1817c.mSavedFragmentState, false);
        this.f1817c.mState = 2;
        return;
    }

    void a(ClassLoader r4) {
        if (this.f1817c.mSavedFragmentState != null) goto L5;
        return;
    L5:
        this.f1817c.mSavedFragmentState.setClassLoader(r4);
        Fragment r5 = this.f1817c;
        r5.mSavedViewState = r5.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment r6 = this.f1817c;
        r6.mSavedViewRegistryState = r6.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment r7 = this.f1817c;
        r7.mTargetWho = r7.mSavedFragmentState.getString("android:target_state");
        if (this.f1817c.mTargetWho == null) goto L9;
        Fragment r8 = this.f1817c;
        r8.mTargetRequestCode = r8.mSavedFragmentState.getInt("android:target_req_state", 0);
    L9:
        if (this.f1817c.mSavedUserVisibleHint == null) goto L11;
        Fragment r9 = this.f1817c;
        r9.mUserVisibleHint = r9.mSavedUserVisibleHint.booleanValue();
        this.f1817c.mSavedUserVisibleHint = null;
    L13:
        if (this.f1817c.mUserVisibleHint == true) goto L16;
        this.f1817c.mDeferStart = true;
        return;
    L16:
        return;
    L11:
        Fragment r10 = this.f1817c;
        r10.mUserVisibleHint = r10.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        goto L13
    }

    void e() {
        if (FragmentManager.a(3) == false) goto L5;
        b(TAG, "moveto ATTACHED: " + this.f1817c);
    L5:
        k r4 = null;
        if (this.f1817c.mTarget == null) goto L13;
        k r0 = this.f1816b.c(this.f1817c.mTarget.mWho);
        if (r0 == null) goto L11;
        Fragment r1 = this.f1817c;
        r1.mTargetWho = r1.mTarget.mWho;
        this.f1817c.mTarget = null;
        r4 = r0;
    L19:
        if (r4 != null) goto L21;
    L25:
        Fragment r2 = this.f1817c;
        r2.mHost = r2.mFragmentManager.l();
        Fragment r3 = this.f1817c;
        r3.mParentFragment = r3.mFragmentManager.m();
        this.f1815a.a(this.f1817c, false);
        this.f1817c.performAttach();
        this.f1815a.b(this.f1817c, false);
        return;
    L21:
        if (FragmentManager.f1731a == false) goto L23;
    L24:
        r4.c();
        goto L25
    L23:
        if (r4.a().mState >= 1) goto L25;
    L11:
        throw new IllegalStateException("Fragment " + this.f1817c + " declared target fragment " + this.f1817c.mTarget + " that does not belong to this FragmentManager!");
    L13:
        if (this.f1817c.mTargetWho == null) goto L19;
        r4 = this.f1816b.c(this.f1817c.mTargetWho);
        if (r4 != null) goto L19;
        throw new IllegalStateException("Fragment " + this.f1817c + " declared target fragment " + this.f1817c.mTargetWho + " that does not belong to this FragmentManager!");
    }

    void f() {
        if (FragmentManager.a(3) == false) goto L6;
        b(TAG, "moveto CREATED: " + this.f1817c);
    L6:
        if (this.f1817c.mIsCreated == true) goto L8;
        f r0 = this.f1815a;
        Fragment r1 = this.f1817c;
        r0.a(r1, r1.mSavedFragmentState, false);
        Fragment r2 = this.f1817c;
        r2.performCreate(r2.mSavedFragmentState);
        f r3 = this.f1815a;
        Fragment r4 = this.f1817c;
        r3.b(r4, r4.mSavedFragmentState, false);
        return;
    L8:
        Fragment r5 = this.f1817c;
        r5.restoreChildFragmentState(r5.mSavedFragmentState);
        this.f1817c.mState = 1;
    }

    void g() {
        if (this.f1817c.mFromLayout == false) goto L6;
        return;
    L6:
        if (FragmentManager.a(3) == false) goto L8;
        b(TAG, "moveto CREATE_VIEW: " + this.f1817c);
    L8:
        Fragment r0 = this.f1817c;
        LayoutInflater r1 = r0.performGetLayoutInflater(r0.mSavedFragmentState);
        ViewGroup r2 = null;
        if (this.f1817c.mContainer == null) goto L12;
        r2 = this.f1817c.mContainer;
    L27:
        this.f1817c.mContainer = r2;
        Fragment r3 = this.f1817c;
        r3.performCreateView(r1, r2, r3.mSavedFragmentState);
        if (this.f1817c.mView == null) goto L56;
        boolean r4 = false;
        this.f1817c.mView.setSaveFromParentEnabled(false);
        this.f1817c.mView.setTag(ZeusTransformUtils.mapRes(R.id.fragment_container_view_tag, DbHelper.COL_ID, "fragment_container_view_tag"), this.f1817c);
        if (r2 == null) goto L33;
        s();
    L33:
        if (this.f1817c.mHidden == false) goto L36;
        this.f1817c.mView.setVisibility(8);
    L36:
        if (ViewCompat.I(this.f1817c.mView) == false) goto L38;
        ViewCompat.u(this.f1817c.mView);
    L39:
        this.f1817c.performViewCreated();
        f r5 = this.f1815a;
        Fragment r6 = this.f1817c;
        r5.a(r6, r6.mView, this.f1817c.mSavedFragmentState, false);
        int r7 = this.f1817c.mView.getVisibility();
        float r8 = this.f1817c.mView.getAlpha();
        if (FragmentManager.f1731a == false) goto L50;
        this.f1817c.setPostOnViewCreatedAlpha(r8);
        if (this.f1817c.mContainer == null) goto L56;
        if (r7 != 0) goto L56;
        View r9 = this.f1817c.mView.findFocus();
        if (r9 == null) goto L49;
        this.f1817c.setFocusedView(r9);
        if (FragmentManager.a(2) == false) goto L49;
        a(TAG, "requestFocus: Saved focused view " + r9 + " for Fragment " + this.f1817c);
    L49:
        this.f1817c.mView.setAlpha(0.0f);
        goto L56
    L50:
        Fragment r10 = this.f1817c;
        if (r7 == 0) goto L53;
    L55:
        r10.mIsNewlyAdded = r4;
        goto L56
    L53:
        if (r10.mContainer == null) goto L55;
        r4 = true;
        goto L55
    L38:
        final View r11 = this.f1817c.mView;
        r11.addOnAttachStateChangeListener(new FragmentStateManager$1(this, r11));
    L56:
        this.f1817c.mState = 2;
        return;
    L12:
        if (this.f1817c.mContainerId == 0) goto L27;
        if (this.f1817c.mContainerId == (-1)) goto L26;
        r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.f1817c.mFragmentManager.n().a(this.f1817c.mContainerId), ViewGroup.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L27;
        if (this.f1817c.mRestored == true) goto L27;
        String r12 = ZeusTransformUtils.getResources(this.f1817c, "com.obric.aiagent.plugin").getResourceName(this.f1817c.mContainerId);     // Catch: Resources.NotFoundException -> L22
    L24:
        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f1817c.mContainerId) + " (" + r12 + ") for fragment " + this.f1817c);
    L22:
        r12 = SensitiveType.UNKNOWN;
        goto L24
    L26:
        throw new IllegalArgumentException("Cannot create fragment " + this.f1817c + " for a container view with no id");
    }

    void h() {
        if (FragmentManager.a(3) == false) goto L5;
        b(TAG, "moveto ACTIVITY_CREATED: " + this.f1817c);
    L5:
        Fragment r0 = this.f1817c;
        r0.performActivityCreated(r0.mSavedFragmentState);
        f r1 = this.f1815a;
        Fragment r3 = this.f1817c;
        r1.c(r3, r3.mSavedFragmentState, false);
    }

    void i() {
        if (FragmentManager.a(3) == false) goto L5;
        b(TAG, "moveto STARTED: " + this.f1817c);
    L5:
        this.f1817c.performStart();
        this.f1815a.c(this.f1817c, false);
    }

    void j() {
        if (FragmentManager.a(3) == false) goto L5;
        b(TAG, "moveto RESUMED: " + this.f1817c);
    L5:
        View r0 = this.f1817c.getFocusedView();
        if (r0 != null) goto L8;
    L16:
        this.f1817c.setFocusedView(null);
        this.f1817c.performResume();
        this.f1815a.d(this.f1817c, false);
        this.f1817c.mSavedFragmentState = null;
        this.f1817c.mSavedViewState = null;
        this.f1817c.mSavedViewRegistryState = null;
        return;
    L8:
        if (a(r0) == false) goto L16;
        boolean r2 = r0.requestFocus();
        if (FragmentManager.a(2) == false) goto L16;
        StringBuilder r1 = new StringBuilder().append("requestFocus: Restoring focused view ").append(r0).append(" ");
        if (r2 == false) goto L14;
        String r3 = "succeeded";
    L15:
        a(TAG, r1.append(r3).append(" on Fragment ").append(this.f1817c).append(" resulting in focused view ").append(this.f1817c.mView.findFocus()).toString());
        goto L16
    L14:
        r3 = "failed";
        goto L15
    }

    private boolean a(View r3) {
        if (r3 != this.f1817c.mView) goto L5;
        return true;
    L5:
        ViewParent r4 = r3.getParent();
    L6:
        if (r4 == null) goto L11;
        if (r4 == this.f1817c.mView) goto L9;
        r4 = r4.getParent();
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    void k() {
        if (FragmentManager.a(3) == false) goto L5;
        b(TAG, "movefrom RESUMED: " + this.f1817c);
    L5:
        this.f1817c.performPause();
        this.f1815a.e(this.f1817c, false);
    }

    void l() {
        if (FragmentManager.a(3) == false) goto L5;
        b(TAG, "movefrom STARTED: " + this.f1817c);
    L5:
        this.f1817c.performStop();
        this.f1815a.f(this.f1817c, false);
    }

    FragmentState m() {
        FragmentState r0 = new FragmentState(this.f1817c);
        if (this.f1817c.mState > (-1)) goto L5;
    L14:
        r0.mSavedFragmentState = this.f1817c.mSavedFragmentState;
    L15:
        return r0;
    L5:
        if (r0.mSavedFragmentState != null) goto L14;
        r0.mSavedFragmentState = t();
        if (this.f1817c.mTargetWho == null) goto L15;
        if (r0.mSavedFragmentState != null) goto L11;
        r0.mSavedFragmentState = new Bundle();
    L11:
        r0.mSavedFragmentState.putString("android:target_state", this.f1817c.mTargetWho);
        if (this.f1817c.mTargetRequestCode == 0) goto L15;
        r0.mSavedFragmentState.putInt("android:target_req_state", this.f1817c.mTargetRequestCode);
        goto L15
    }

    Fragment.SavedState n() {
        if (this.f1817c.mState <= (-1)) goto L8;
        Bundle r3 = t();
        if (r3 != null) goto L7;
        return null;
    L7:
        return new Fragment.SavedState(r3);
    L8:
        return null;
    }

    private Bundle t() {
        Bundle r0 = new Bundle();
        this.f1817c.performSaveInstanceState(r0);
        this.f1815a.d(this.f1817c, r0, false);
        if (r0.isEmpty() == false) goto L6;
        r0 = null;
    L6:
        if (this.f1817c.mView == null) goto L9;
        o();
    L9:
        if (this.f1817c.mSavedViewState == null) goto L14;
        if (r0 != null) goto L12;
        r0 = new Bundle();
    L12:
        r0.putSparseParcelableArray("android:view_state", this.f1817c.mSavedViewState);
    L14:
        if (this.f1817c.mSavedViewRegistryState == null) goto L19;
        if (r0 != null) goto L17;
        r0 = new Bundle();
    L17:
        r0.putBundle("android:view_registry_state", this.f1817c.mSavedViewRegistryState);
    L19:
        if (this.f1817c.mUserVisibleHint == true) goto L23;
        if (r0 != null) goto L22;
        r0 = new Bundle();
    L22:
        r0.putBoolean("android:user_visible_hint", this.f1817c.mUserVisibleHint);
    L23:
        return r0;
    }

    void o() {
        if (this.f1817c.mView != null) goto L5;
        return;
    L5:
        SparseArray<Parcelable> r0 = new SparseArray();
        this.f1817c.mView.saveHierarchyState(r0);
        if (r0.size() <= 0) goto L8;
        this.f1817c.mSavedViewState = r0;
    L8:
        Bundle r1 = new Bundle();
        this.f1817c.mViewLifecycleOwner.b(r1);
        if (r1.isEmpty() == true) goto L12;
        this.f1817c.mSavedViewRegistryState = r1;
        return;
    }

    void p() {
        if (FragmentManager.a(3) == false) goto L6;
        b(TAG, "movefrom CREATE_VIEW: " + this.f1817c);
    L6:
        if (this.f1817c.mContainer != null) goto L8;
    L10:
        this.f1817c.performDestroyView();
        this.f1815a.g(this.f1817c, false);
        this.f1817c.mContainer = null;
        this.f1817c.mView = null;
        this.f1817c.mViewLifecycleOwner = null;
        this.f1817c.mViewLifecycleOwnerLiveData.b(null);
        this.f1817c.mInLayout = false;
        return;
    L8:
        if (this.f1817c.mView == null) goto L10;
        this.f1817c.mContainer.removeView(this.f1817c.mView);
        goto L10
    }

    void q() {
        if (FragmentManager.a(3) == false) goto L5;
        b(TAG, "movefrom CREATED: " + this.f1817c);
    L5:
        boolean r1 = true;
        if (this.f1817c.mRemoving == true) goto L8;
    L10:
        boolean r0 = false;
    L11:
        if (r0 == false) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L40;
        e<?> r4 = this.f1817c.mHost;
        if (ZeusTransformUtils.instanceOf(r4, ap.class) == false) goto L22;
        r1 = this.f1816b.a().b();
    L24:
        if (r0 == true) goto L26;
        if (r1 == true) goto L26;
    L27:
        this.f1817c.performDestroy();
        this.f1815a.h(this.f1817c, false);
        Iterator<k> r2 = this.f1816b.g().iterator();
    L29:
        if (r2.hasNext() == false) goto L36;
        k r5 = (k) ZeusTransformUtils.preCheckCast(r2.next(), k.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L29;
        Fragment r6 = r5.a();
        if (this.f1817c.mWho.equals(r6.mTargetWho) == false) goto L29;
        r6.mTarget = this.f1817c;
        r6.mTargetWho = null;
        goto L29
    L36:
        if (this.f1817c.mTargetWho == null) goto L38;
        Fragment r7 = this.f1817c;
        r7.mTarget = this.f1816b.e(r7.mTargetWho);
    L38:
        this.f1816b.b(this);
        return;
    L26:
        this.f1816b.a().f(this.f1817c);
        goto L27
    L22:
        if (ZeusTransformUtils.instanceOf((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), Activity.class) == false) goto L24;
        r1 = true ^ ((Activity) ZeusTransformUtils.preCheckCast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin")).isChangingConfigurations();
        goto L24
    L40:
        if (this.f1817c.mTargetWho == null) goto L46;
        Fragment r8 = this.f1816b.e(this.f1817c.mTargetWho);
        if (r8 == null) goto L46;
        if (r8.mRetainInstance == false) goto L46;
        this.f1817c.mTarget = r8;
    L46:
        this.f1817c.mState = 0;
        return;
    L13:
        if (this.f1816b.a().b(this.f1817c) == true) goto L16;
        r3 = false;
        goto L17
    L8:
        if (this.f1817c.isInBackStack() == true) goto L10;
        r0 = true;
        goto L11
    }

    void r() {
        if (FragmentManager.a(3) == false) goto L5;
        b(TAG, "movefrom ATTACHED: " + this.f1817c);
    L5:
        this.f1817c.performDetach();
        boolean r4 = false;
        this.f1815a.i(this.f1817c, false);
        this.f1817c.mState = -1;
        this.f1817c.mHost = null;
        this.f1817c.mParentFragment = null;
        this.f1817c.mFragmentManager = null;
        if (this.f1817c.mRemoving == true) goto L8;
    L10:
        if (r4 == true) goto L14;
        if (this.f1816b.a().b(this.f1817c) == true) goto L14;
        return;
    L14:
        if (FragmentManager.a(3) == false) goto L16;
        b(TAG, "initState called for fragment: " + this.f1817c);
    L16:
        this.f1817c.initState();
        return;
    L8:
        if (this.f1817c.isInBackStack() == true) goto L10;
        r4 = true;
        goto L10
    }

    void s() {
        int r0 = this.f1816b.c(this.f1817c);
        this.f1817c.mContainer.addView(this.f1817c.mView, r0);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
