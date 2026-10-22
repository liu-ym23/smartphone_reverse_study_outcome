package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties = null;
    private int mMode;

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Mode {
    }

    public class a extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f5022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f5023c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Visibility f5024d;

        public a(Visibility r10, ViewGroup r11, View r12, View r13) {
            this.f5024d = r10;
            this.f5021a = r11;
            this.f5022b = r12;
            this.f5023c = r13;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r10) {
            this.f5023c.setTag(R$id.save_overlay_view, null);
            w.b(this.f5021a).remove(this.f5022b);
            r10.removeListener(this);
        }

        @Override // androidx.transition.o, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r10) {
            w.b(this.f5021a).remove(this.f5022b);
        }

        @Override // androidx.transition.o, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r10) {
            if (this.f5022b.getParent() != null) goto L5;
            w.b(this.f5021a).add(this.f5022b);
            return;
        L5:
            this.f5024d.cancel();
        }
    }

    public static class b extends AnimatorListenerAdapter implements Transition.TransitionListener, AnimatorUtils.AnimatorPauseListenerCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f5025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewGroup f5027c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f5028d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f5029e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f5030f;

        public b(View r10, int r11, boolean r12) {
            this.f5030f = false;
            this.f5025a = r10;
            this.f5026b = r11;
            this.f5027c = (ViewGroup) r10.getParent();
            this.f5028d = r12;
            b(true);
        }

        public final void a() {
            if (this.f5030f == true) goto L7;
            y.i(this.f5025a, this.f5026b);
            ViewGroup r10 = this.f5027c;
            if (r10 == null) goto L7;
            r10.invalidate();
        L7:
            b(false);
        }

        public final void b(boolean r10) {
            if (this.f5028d == true) goto L5;
            return;
        L5:
            if (this.f5029e == r10) goto L11;
            ViewGroup r11 = this.f5027c;
            if (r11 == null) goto L12;
            this.f5029e = r10;
            w.c(r11, r10);
            return;
        L12:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            this.f5030f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationPause(Animator r10) {
            if (this.f5030f == true) goto L6;
            y.i(this.f5025a, this.f5026b);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationResume(Animator r10) {
            if (this.f5030f == true) goto L6;
            y.i(this.f5025a, 0);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition r10) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r10) {
            a();
            r10.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r10) {
            b(false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r10) {
            b(true);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition r10) {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f5032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5033c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5034d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ViewGroup f5035e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ViewGroup f5036f;

        public c() {
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_VISIBILITY, PROPNAME_PARENT};
    }

    public Visibility() {
        this.mMode = 3;
    }

    private void captureValues(s r10) {
        int r11 = r10.f5086b.getVisibility();
        r10.f5085a.put(PROPNAME_VISIBILITY, Integer.valueOf(r11));
        r10.f5085a.put(PROPNAME_PARENT, r10.f5086b.getParent());
        int[] r12 = new int[2];
        r10.f5086b.getLocationOnScreen(r12);
        r10.f5085a.put(PROPNAME_SCREEN_LOCATION, r12);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull s r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull s r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r10, @Nullable s r11, @Nullable s r12) {
        c r13 = s(r11, r12);
        if (r13.f5031a == true) goto L5;
        return null;
    L5:
        if (r13.f5035e != null) goto L9;
        if (r13.f5036f != null) goto L9;
        return null;
    L9:
        if (r13.f5032b == false) goto L13;
        return onAppear(r10, r11, r13.f5033c, r12, r13.f5034d);
    L13:
        return onDisappear(r10, r11, r13.f5033c, r12, r13.f5034d);
    }

    public int getMode() {
        return this.mMode;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(@Nullable s r10, @Nullable s r11) {
        if (r10 != null) goto L6;
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r10 == null) goto L11;
        if (r11 == null) goto L11;
        if (r11.f5085a.containsKey(PROPNAME_VISIBILITY) == r10.f5085a.containsKey(PROPNAME_VISIBILITY)) goto L11;
        return false;
    L11:
        c r12 = s(r10, r11);
        if (r12.f5031a == true) goto L14;
        return false;
    L14:
        if (r12.f5033c != 0) goto L16;
    L17:
        return true;
    L16:
        if (r12.f5034d == 0) goto L17;
        return false;
    }

    public boolean isVisible(s r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = ((Integer) r10.f5085a.get(PROPNAME_VISIBILITY)).intValue();
        View r12 = (View) r10.f5085a.get(PROPNAME_PARENT);
        if (r11 != 0) goto L10;
        if (r12 == null) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public Animator onAppear(ViewGroup r10, View r11, s r12, s r13) {
        return null;
    }

    public Animator onDisappear(ViewGroup r10, View r11, s r12, s r13) {
        return null;
    }

    public final c s(s r10, s r11) {
        c r12 = new c();
        r12.f5031a = false;
        r12.f5032b = false;
        if (r10 != null) goto L5;
    L7:
        r12.f5033c = -1;
        r12.f5035e = null;
    L8:
        if (r11 != null) goto L10;
    L12:
        r12.f5034d = -1;
        r12.f5036f = null;
    L14:
        if (r10 == null) goto L32;
        if (r11 == null) goto L32;
        int r13 = r12.f5033c;
        int r14 = r12.f5034d;
        if (r13 == r14) goto L19;
    L21:
        if (r13 == r14) goto L27;
        if (r13 != 0) goto L24;
        r12.f5032b = false;
        r12.f5031a = true;
    L40:
        return r12;
    L24:
        if (r14 != 0) goto L40;
        r12.f5032b = true;
        r12.f5031a = true;
        goto L40
    L27:
        if (r12.f5036f != null) goto L30;
        r12.f5032b = false;
        r12.f5031a = true;
        goto L40
    L30:
        if (r12.f5035e != null) goto L40;
        r12.f5032b = true;
        r12.f5031a = true;
        goto L40
    L19:
        if (r12.f5035e != r12.f5036f) goto L21;
        return r12;
    L32:
        if (r10 == null) goto L34;
    L36:
        if (r11 != null) goto L40;
        if (r12.f5033c != 0) goto L40;
        r12.f5032b = false;
        r12.f5031a = true;
        goto L40
    L34:
        if (r12.f5034d != 0) goto L36;
        r12.f5032b = true;
        r12.f5031a = true;
        goto L40
    L10:
        if (r11.f5085a.containsKey(PROPNAME_VISIBILITY) == false) goto L12;
        r12.f5034d = ((Integer) r11.f5085a.get(PROPNAME_VISIBILITY)).intValue();
        r12.f5036f = (ViewGroup) r11.f5085a.get(PROPNAME_PARENT);
        goto L14
    L5:
        if (r10.f5085a.containsKey(PROPNAME_VISIBILITY) == false) goto L7;
        r12.f5033c = ((Integer) r10.f5085a.get(PROPNAME_VISIBILITY)).intValue();
        r12.f5035e = (ViewGroup) r10.f5085a.get(PROPNAME_PARENT);
        goto L8
    }

    public void setMode(int r10) {
        if ((r10 & (-4)) != 0) goto L7;
        this.mMode = r10;
        return;
    L7:
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Nullable
    public Animator onAppear(ViewGroup r10, s r11, int r12, s r13, int r14) {
        if ((this.mMode & 1) != 1) goto L12;
        if (r13 == null) goto L12;
        if (r11 != null) goto L11;
        View r15 = (View) r13.f5086b.getParent();
        if (s(getMatchedTransitionValues(r15, false), getTransitionValues(r15, false)).f5031a == false) goto L11;
        return null;
    L11:
        return onAppear(r10, r13.f5086b, r11, r13);
    L12:
        return null;
    }

    @Nullable
    public Animator onDisappear(ViewGroup r18, s r19, int r20, s r21, int r22) {
        if ((this.mMode & 2) == 2) goto L5;
        return null;
    L5:
        if (r19 != null) goto L7;
        return null;
    L7:
        View r10 = r19.f5086b;
        if (r21 == null) goto L10;
        View r11 = r21.f5086b;
    L11:
        int r12 = R$id.save_overlay_view;
        View r13 = (View) r10.getTag(r12);
        if (r13 == null) goto L14;
        View r14 = null;
        boolean r15 = true;
    L45:
        if (r13 == null) goto L54;
        if (r15 == true) goto L48;
        int[] r16 = (int[]) r19.f5085a.get(PROPNAME_SCREEN_LOCATION);
        int r17 = r16[0];
        int r23 = r16[1];
        int[] r24 = new int[2];
        r18.getLocationOnScreen(r24);
        r13.offsetLeftAndRight((r17 - r24[0]) - r13.getLeft());
        r13.offsetTopAndBottom((r23 - r24[1]) - r13.getTop());
        w.b(r18).add(r13);
    L48:
        Animator r25 = onDisappear(r18, r13, r19, r21);
        if (r15 == true) goto L53;
        if (r25 != null) goto L52;
        w.b(r18).remove(r13);
        goto L53
    L52:
        r10.setTag(r12, r13);
        addListener(new a(this, r18, r13, r10));
    L53:
        return r25;
    L54:
        if (r14 == null) goto L60;
        int r26 = r14.getVisibility();
        y.i(r14, 0);
        Animator r27 = onDisappear(r18, r14, r19, r21);
        if (r27 == null) goto L58;
        b r28 = new b(r14, r22, true);
        r27.addListener(r28);
        AnimatorUtils.a(r27, r28);
        addListener(r28);
    L59:
        return r27;
    L58:
        y.i(r14, r26);
        goto L59
    L60:
        return null;
    L14:
        if (r11 != null) goto L16;
    L24:
        if (r11 != null) goto L25;
    L23:
        r11 = null;
        View r110 = null;
        boolean r111 = true;
    L26:
        if (r111 == true) goto L28;
    L35:
        r15 = false;
        View r112 = r110;
        r13 = r11;
        r14 = r112;
        goto L45
    L28:
        if (r10.getParent() != null) goto L31;
    L44:
        r14 = r110;
        r15 = false;
        r13 = r10;
        goto L45
    L31:
        if ((r10.getParent() instanceof View) == false) goto L35;
        View r113 = (View) r10.getParent();
        if (s(getTransitionValues(r113, true), getMatchedTransitionValues(r113, true)).f5031a == true) goto L36;
        r11 = r.a(r18, r10, r113);
        goto L35
    L36:
        int r114 = r113.getId();
        if (r113.getParent() != null) goto L35;
        if (r114 == (-1)) goto L35;
        if (r18.findViewById(r114) == null) goto L35;
        if (this.mCanRemoveViews == false) goto L35;
    L25:
        r110 = null;
        r111 = false;
        goto L26
    L16:
        if (r11.getParent() == null) goto L24;
        if (r22 == 4) goto L22;
        if (r10 != r11) goto L23;
    L22:
        r110 = r11;
        r111 = false;
        r11 = null;
        goto L26
    L10:
        r11 = null;
        goto L11
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(@NonNull Context r10, @NonNull AttributeSet r11) {
        super(r10, r11);
        this.mMode = 3;
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.f4998e);
        int r13 = n.g.c(r12, (XmlResourceParser) r11, "transitionVisibilityMode", 0, 0);
        r12.recycle();
        if (r13 == 0) goto L6;
        setMode(r13);
        return;
    }
}
