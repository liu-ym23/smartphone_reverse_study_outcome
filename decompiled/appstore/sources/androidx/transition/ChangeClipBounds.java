package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class ChangeClipBounds extends Transition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f4936a = null;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f4937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChangeClipBounds f4938b;

        public a(ChangeClipBounds r10, View r11) {
            this.f4938b = r10;
            this.f4937a = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            ViewCompat.w0(this.f4937a, null);
        }
    }

    static {
        f4936a = new String[]{"android:clipBounds:clip"};
    }

    public ChangeClipBounds(@NonNull Context r10, @NonNull AttributeSet r11) {
        super(r10, r11);
    }

    private void captureValues(s r10) {
        View r11 = r10.f5086b;
        if (r11.getVisibility() != 8) goto L5;
        return;
    L5:
        Rect r12 = ViewCompat.t(r11);
        r10.f5085a.put("android:clipBounds:clip", r12);
        if (r12 != null) goto L9;
        Rect r13 = new Rect(0, 0, r11.getWidth(), r11.getHeight());
        r10.f5085a.put("android:clipBounds:bounds", r13);
        return;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(s r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(s r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r10, s r11, s r12) {
        ObjectAnimator r13 = null;
        if (r11 == null) goto L28;
        if (r12 == null) goto L28;
        if (r11.f5085a.containsKey("android:clipBounds:clip") == false) goto L28;
        if (r12.f5085a.containsKey("android:clipBounds:clip") == false) goto L28;
        Rect r14 = (Rect) r11.f5085a.get("android:clipBounds:clip");
        Rect r15 = (Rect) r12.f5085a.get("android:clipBounds:clip");
        if (r15 != null) goto L13;
        boolean r16 = true;
    L14:
        if (r14 != null) goto L18;
        if (r15 != null) goto L18;
        return null;
    L18:
        if (r14 != null) goto L20;
        r14 = (Rect) r11.f5085a.get("android:clipBounds:bounds");
    L23:
        if (r14.equals(r15) == false) goto L25;
        return null;
    L25:
        ViewCompat.w0(r12.f5086b, r14);
        l r17 = new l(new Rect());
        r13 = ObjectAnimator.ofObject(r12.f5086b, y.f5105c, r17, new Rect[]{r14, r15});
        if (r16 == false) goto L28;
        r13.addListener(new a(this, r12.f5086b));
        goto L28
    L20:
        if (r15 != null) goto L23;
        r15 = (Rect) r12.f5085a.get("android:clipBounds:bounds");
        goto L23
    L13:
        r16 = false;
    L28:
        return r13;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f4936a;
    }
}
