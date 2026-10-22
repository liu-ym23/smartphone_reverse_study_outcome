package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.view.OneShotPreDrawListener;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class FragmentAnim {

    static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        EndViewTransitionAnimation(Animation r2, ViewGroup r3, View r4) {
            super(false);
            this.mAnimating = true;
            this.mParent = r3;
            this.mChild = r4;
            addAnimation(r2);
            r3.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long r3, Transformation r5) {
            this.mAnimating = true;
            if (this.mEnded == false) goto L7;
            return !this.mTransitionEnded;
        L7:
            if (super.getTransformation(r3, r5) == true) goto L9;
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        L9:
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long r3, Transformation r5, float r6) {
            this.mAnimating = true;
            if (this.mEnded == false) goto L7;
            return !this.mTransitionEnded;
        L7:
            if (super.getTransformation(r3, r5, r6) == true) goto L9;
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        L9:
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mEnded == false) goto L5;
        L7:
            this.mParent.endViewTransition(this.mChild);
            this.mTransitionEnded = true;
            return;
        L5:
            if (this.mAnimating == false) goto L7;
            this.mAnimating = false;
            this.mParent.post(this);
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f1728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Animator f1729b;

        a(Animation r2) {
            this.f1728a = r2;
            this.f1729b = null;
            if (r2 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animation cannot be null");
        }

        a(Animator r2) {
            this.f1728a = null;
            this.f1729b = r2;
            if (r2 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animator cannot be null");
        }
    }

    static a a(Context r8, Fragment r9, boolean r10, boolean r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        int r0 = r9.getNextTransition();
        int r13 = a(r9, r10, r11);
        boolean r2 = false;
        r9.setAnimations(0, 0, 0, 0);
        if (r9.mContainer == null) goto L8;
        if (r9.mContainer.getTag(ZeusTransformUtils.mapRes(R.id.visible_removing_fragment_view_tag, DbHelper.COL_ID, "visible_removing_fragment_view_tag")) == null) goto L8;
        r9.mContainer.setTag(ZeusTransformUtils.mapRes(R.id.visible_removing_fragment_view_tag, DbHelper.COL_ID, "visible_removing_fragment_view_tag"), null);
    L8:
        if (r9.mContainer != null) goto L10;
    L12:
        Animation r3 = r9.onCreateAnimation(r0, r10, r13);
        if (r3 != null) goto L15;
        Animator r14 = r9.onCreateAnimator(r0, r10, r13);
        if (r14 != null) goto L19;
        if (r13 != 0) goto L23;
        if (r0 == 0) goto L23;
        r13 = a(r0, r10);
    L23:
        if (r13 == 0) goto L45;
        boolean r15 = "anim".equals(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getResourceTypeName(r13));
        if (r15 == true) goto L49;
    L33:
        if (r2 == true) goto L45;
        Animator r16 = AnimatorInflater.loadAnimator(r12, r13);     // Catch: RuntimeException -> L38
        if (r16 == null) goto L45;
        return new a(r16);
    L38:
        e = move-exception;
        if (r15 == true) goto L44;
        Animation r17 = AnimationUtils.loadAnimation(r12, r13);
        if (r17 == null) goto L45;
        return new a(r17);
    L44:
        throw e;
    L49:
        Animation r18 = AnimationUtils.loadAnimation(r12, r13);     // Catch: Resources.NotFoundException -> L31 RuntimeException -> L46
        if (r18 == null) goto L30;
        return new a(r18);
        goto L33
    L30:
        r2 = true;
    L31:
        e = move-exception;
        throw e;
    L45:
        return null;
    L19:
        return new a(r14);
    L15:
        return new a(r3);
    L10:
        if (r9.mContainer.getLayoutTransition() == null) goto L12;
        return null;
    }

    private static int a(Fragment r0, boolean r1, boolean r2) {
        if (r2 == false) goto L8;
        if (r1 == false) goto L7;
        return r0.getPopEnterAnim();
    L7:
        return r0.getPopExitAnim();
    L8:
        if (r1 == false) goto L12;
        return r0.getEnterAnim();
    L12:
        return r0.getExitAnim();
    }

    static void a(final Fragment r6, a r7, n.a r8) {
        final n.a r4 = (n.a) ZeusTransformUtils.wrapperContextForParams(r8, n.a.class, "com.obric.aiagent.plugin");
        final View r2 = r6.mView;
        final ViewGroup r1 = r6.mContainer;
        r1.startViewTransition(r2);
        final androidx.core.os.f r5 = new androidx.core.os.f();
        r5.a(new AnonymousClass1(r6));
        r4.a(r6, r5);
        if (r7.f1728a == null) goto L5;
        EndViewTransitionAnimation r9 = new EndViewTransitionAnimation(r7.f1728a, r1, r2);
        r6.setAnimatingAway(r6.mView);
        r9.setAnimationListener(new AnonymousClass2(r1, r6, r4, r5));
        r6.mView.startAnimation(r9);
        return;
    L5:
        Animator r10 = r7.f1729b;
        r6.setAnimator(r7.f1729b);
        r10.addListener(new AnonymousClass3(r1, r2, r6, r4, r5));
        r10.setTarget(r6.mView);
        r10.start();
    }

    private static int a(int r2, boolean r3) {
        if (r2 != 4097) goto L5;
        if (r3 == false) goto L19;
        int r4 = R.animator.fragment_open_enter;
        String r5 = "fragment_open_enter";
    L21:
        return ZeusTransformUtils.mapRes(r4, "animator", r5);
    L19:
        r4 = R.animator.fragment_open_exit;
        r5 = "fragment_open_exit";
        goto L21
    L5:
        if (r2 != 4099) goto L7;
        if (r3 == false) goto L15;
        int r6 = R.animator.fragment_fade_enter;
        String r7 = "fragment_fade_enter";
    L24:
        return ZeusTransformUtils.mapRes(r6, "animator", r7);
    L15:
        r6 = R.animator.fragment_fade_exit;
        r7 = "fragment_fade_exit";
        goto L24
    L7:
        if (r2 == 8194) goto L9;
        return -1;
    L9:
        if (r3 == false) goto L11;
        int r8 = R.animator.fragment_close_enter;
        String r9 = "fragment_close_enter";
    L23:
        return ZeusTransformUtils.mapRes(r8, "animator", r9);
    L11:
        r8 = R.animator.fragment_close_exit;
        r9 = "fragment_close_exit";
        goto L23
    }
}
