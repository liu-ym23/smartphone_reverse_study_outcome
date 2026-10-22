package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class Visibility extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f2772a = null;
    private int i;

    private static class DisappearListener extends AnimatorListenerAdapter implements androidx.transition.a.InterfaceC0077a, s.d {
        boolean mCanceled;
        private final int mFinalVisibility;
        private boolean mLayoutSuppressed;
        private final ViewGroup mParent;
        private final boolean mSuppressLayout;
        private final View mView;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r1) {
        }

        @Override // androidx.transition.s.d
        public void onTransitionCancel(s r1) {
        }

        @Override // androidx.transition.s.d
        public void onTransitionStart(s r1) {
        }

        DisappearListener(View r2, int r3, boolean r4) {
            this.mCanceled = false;
            this.mView = r2;
            this.mFinalVisibility = r3;
            this.mParent = (ViewGroup) ZeusTransformUtils.preCheckCast(r2.getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
            this.mSuppressLayout = r4;
            suppressLayout(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.a.InterfaceC0077a
        public void onAnimationPause(Animator r1) {
            if (this.mCanceled == true) goto L6;
            af.a(this.mView, this.mFinalVisibility);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.a.InterfaceC0077a
        public void onAnimationResume(Animator r1) {
            if (this.mCanceled == true) goto L6;
            af.a(this.mView, 0);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r1) {
            hideViewWhenNotCanceled();
        }

        @Override // androidx.transition.s.d
        public void onTransitionEnd(s r1) {
            hideViewWhenNotCanceled();
            r1.b(this);
        }

        @Override // androidx.transition.s.d
        public void onTransitionPause(s r1) {
            suppressLayout(false);
        }

        @Override // androidx.transition.s.d
        public void onTransitionResume(s r1) {
            suppressLayout(true);
        }

        private void hideViewWhenNotCanceled() {
            if (this.mCanceled == true) goto L7;
            af.a(this.mView, this.mFinalVisibility);
            ViewGroup r0 = this.mParent;
            if (r0 == null) goto L7;
            r0.invalidate();
        L7:
            suppressLayout(false);
        }

        private void suppressLayout(boolean r2) {
            if (this.mSuppressLayout == true) goto L5;
            return;
        L5:
            if (this.mLayoutSuppressed == r2) goto L11;
            ViewGroup r0 = this.mParent;
            if (r0 == null) goto L12;
            this.mLayoutSuppressed = r2;
            ab.a(r0, r2);
            return;
        L12:
            return;
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f2778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2779c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2780d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ViewGroup f2781e;
        ViewGroup f;

        a() {
        }
    }

    public Animator a(ViewGroup r1, View r2, w r3, w r4) {
        return null;
    }

    public Animator b(ViewGroup r1, View r2, w r3, w r4) {
        return null;
    }

    static {
        f2772a = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    }

    public Visibility() {
        this.i = 3;
    }

    public void a(int r2) {
        if ((r2 & (-4)) != 0) goto L7;
        this.i = r2;
        return;
    L7:
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Override // androidx.transition.s
    public String[] a() {
        return f2772a;
    }

    private void d(w r3) {
        int r2 = r3.f2870b.getVisibility();
        r3.f2869a.put("android:visibility:visibility", Integer.valueOf(r2));
        r3.f2869a.put("android:visibility:parent", r3.f2870b.getParent());
        int[] r4 = new int[2];
        r3.f2870b.getLocationOnScreen(r4);
        r3.f2869a.put("android:visibility:screenLocation", r4);
    }

    @Override // androidx.transition.s
    public void a(w r1) {
        d(r1);
    }

    @Override // androidx.transition.s
    public void b(w r1) {
        d(r1);
    }

    private a b(w r9, w r10) {
        a r8 = new a();
        r8.f2777a = false;
        r8.f2778b = false;
        if (r9 != null) goto L5;
    L7:
        r8.f2779c = -1;
        r8.f2781e = null;
    L8:
        if (r10 != null) goto L10;
    L12:
        r8.f2780d = -1;
        r8.f = null;
    L14:
        if (r9 == null) goto L35;
        if (r10 == null) goto L35;
        if (r8.f2779c != r8.f2780d) goto L22;
        if (r8.f2781e != r8.f) goto L22;
        return r8;
    L22:
        if (r8.f2779c == r8.f2780d) goto L30;
        if (r8.f2779c != 0) goto L27;
        r8.f2778b = false;
        r8.f2777a = true;
    L43:
        return r8;
    L27:
        if (r8.f2780d != 0) goto L43;
        r8.f2778b = true;
        r8.f2777a = true;
        goto L43
    L30:
        if (r8.f != null) goto L33;
        r8.f2778b = false;
        r8.f2777a = true;
        goto L43
    L33:
        if (r8.f2781e != null) goto L43;
        r8.f2778b = true;
        r8.f2777a = true;
    L35:
        if (r9 == null) goto L37;
    L39:
        if (r10 != null) goto L43;
        if (r8.f2779c != 0) goto L43;
        r8.f2778b = false;
        r8.f2777a = true;
        goto L43
    L37:
        if (r8.f2780d != 0) goto L39;
        r8.f2778b = true;
        r8.f2777a = true;
        goto L43
    L10:
        if (r10.f2869a.containsKey("android:visibility:visibility") == false) goto L12;
        r8.f2780d = ((Integer) ZeusTransformUtils.preCheckCast(r10.f2869a.get("android:visibility:visibility"), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r8.f = (ViewGroup) ZeusTransformUtils.preCheckCast(r10.f2869a.get("android:visibility:parent"), ViewGroup.class, "com.obric.aiagent.plugin");
        goto L14
    L5:
        if (r9.f2869a.containsKey("android:visibility:visibility") == false) goto L7;
        r8.f2779c = ((Integer) ZeusTransformUtils.preCheckCast(r9.f2869a.get("android:visibility:visibility"), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r8.f2781e = (ViewGroup) ZeusTransformUtils.preCheckCast(r9.f2869a.get("android:visibility:parent"), ViewGroup.class, "com.obric.aiagent.plugin");
        goto L8
    }

    @Override // androidx.transition.s
    public Animator a(ViewGroup r9, w r10, w r11) {
        a r0 = b(r10, r11);
        if (r0.f2777a == true) goto L5;
        return null;
    L5:
        if (r0.f2781e != null) goto L9;
        if (r0.f != null) goto L9;
        return null;
    L9:
        if (r0.f2778b == false) goto L13;
        return a(r9, r10, r0.f2779c, r11, r0.f2780d);
    L13:
        return b(r9, r10, r0.f2779c, r11, r0.f2780d);
    }

    public Animator a(ViewGroup r3, w r4, int r5, w r6, int r7) {
        if ((this.i & 1) != 1) goto L12;
        if (r6 == null) goto L12;
        if (r4 != null) goto L11;
        View r8 = (View) ZeusTransformUtils.preCheckCast(r6.f2870b.getParent(), View.class, "com.obric.aiagent.plugin");
        if (b(c(r8, false), b(r8, false)).f2777a == false) goto L11;
        return null;
    L11:
        return a(r3, r6.f2870b, r4, r6);
    L12:
        return null;
    }

    public Animator b(final ViewGroup r18, w r19, int r20, w r21, int r22) {
        View r8 = null;
        if ((this.i & 2) == 2) goto L5;
        return null;
    L5:
        if (r19 != null) goto L7;
        return null;
    L7:
        final View r6 = r19.f2870b;
        if (r21 == null) goto L10;
        View r9 = r21.f2870b;
    L11:
        final View r10 = (View) ZeusTransformUtils.preCheckCast(r6.getTag(ZeusTransformUtils.mapRes(R.id.save_overlay_view, DbHelper.COL_ID, "save_overlay_view")), View.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L14;
        boolean r7 = true;
    L45:
        if (r10 == null) goto L54;
        if (r7 == true) goto L48;
        int[] r4 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r19.f2869a.get("android:visibility:screenLocation"), int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin");
        int r11 = r4[0];
        int r5 = r4[1];
        int[] r12 = new int[2];
        r18.getLocationOnScreen(r12);
        r10.offsetLeftAndRight((r11 - r12[0]) - r10.getLeft());
        r10.offsetTopAndBottom((r5 - r12[1]) - r10.getTop());
        ab.a(r18).a(r10);
    L48:
        Animator r2 = b(r18, r10, r19, r21);
        if (r7 == true) goto L53;
        if (r2 != null) goto L52;
        ab.a(r18).b(r10);
        goto L53
    L52:
        r6.setTag(ZeusTransformUtils.mapRes(R.id.save_overlay_view, DbHelper.COL_ID, "save_overlay_view"), r10);
        a(new AnonymousClass1(this, r18, r10, r6));
    L53:
        return r2;
    L54:
        if (r8 == null) goto L60;
        int r13 = r8.getVisibility();
        af.a(r8, 0);
        Animator r1 = b(r18, r8, r19, r21);
        if (r1 == null) goto L58;
        DisappearListener r3 = new DisappearListener(r8, r22, true);
        r1.addListener(r3);
        androidx.transition.a.a(r1, r3);
        a(r3);
    L59:
        return r1;
    L58:
        af.a(r8, r13);
        goto L59
    L60:
        return null;
    L14:
        if (r9 != null) goto L16;
    L23:
        if (r9 == null) goto L25;
        View r14 = null;
        boolean r16 = false;
    L26:
        if (r16 == true) goto L28;
    L44:
        r8 = r14;
        r7 = false;
        r10 = r9;
        goto L45
    L28:
        if (r6.getParent() != null) goto L31;
    L43:
        r8 = r14;
        r7 = false;
        r10 = r6;
        goto L45
    L31:
        if (ZeusTransformUtils.instanceOf(r6.getParent(), View.class) == false) goto L44;
        View r15 = (View) ZeusTransformUtils.preCheckCast(r6.getParent(), View.class, "com.obric.aiagent.plugin");
        if (b(b(r15, true), c(r15, true)).f2777a == true) goto L35;
        r8 = r14;
        r10 = TransitionUtils.a(r18, r6, r15);
        r7 = false;
        goto L45
    L35:
        int r17 = r15.getId();
        if (r15.getParent() != null) goto L44;
        if (r17 == (-1)) goto L44;
        if (r18.findViewById(r17) == null) goto L44;
        if (this.f == false) goto L44;
    L25:
        r9 = null;
        r14 = null;
        r16 = true;
        goto L26
    L16:
        if (r9.getParent() == null) goto L23;
        if (r22 == 4) goto L22;
        if (r6 != r9) goto L25;
    L22:
        r14 = r9;
        r16 = false;
        r9 = null;
        goto L26
    L10:
        r9 = null;
        goto L11
    }

    @Override // androidx.transition.s
    public boolean a(w r5, w r6) {
        if (r5 != null) goto L6;
        if (r6 != null) goto L6;
        return false;
    L6:
        if (r5 == null) goto L11;
        if (r6 == null) goto L11;
        if (r6.f2869a.containsKey("android:visibility:visibility") == r5.f2869a.containsKey("android:visibility:visibility")) goto L11;
        return false;
    L11:
        a r4 = b(r5, r6);
        if (r4.f2777a == true) goto L14;
        return false;
    L14:
        if (r4.f2779c != 0) goto L16;
    L17:
        return true;
    L16:
        if (r4.f2780d == 0) goto L17;
        return false;
    }
}
