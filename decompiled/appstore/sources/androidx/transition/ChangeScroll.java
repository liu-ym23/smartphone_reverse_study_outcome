package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ChangeScroll extends Transition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f4943a = null;

    static {
        f4943a = new String[]{"android:changeScroll:x", "android:changeScroll:y"};
    }

    public ChangeScroll(@NonNull Context r10, @NonNull AttributeSet r11) {
        super(r10, r11);
    }

    private void captureValues(s r10) {
        r10.f5085a.put("android:changeScroll:x", Integer.valueOf(r10.f5086b.getScrollX()));
        r10.f5085a.put("android:changeScroll:y", Integer.valueOf(r10.f5086b.getScrollY()));
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
        if (r11 == null) goto L14;
        if (r12 == null) goto L15;
        View r14 = r12.f5086b;
        int r15 = ((Integer) r11.f5085a.get("android:changeScroll:x")).intValue();
        int r16 = ((Integer) r12.f5085a.get("android:changeScroll:x")).intValue();
        int r17 = ((Integer) r11.f5085a.get("android:changeScroll:y")).intValue();
        int r18 = ((Integer) r12.f5085a.get("android:changeScroll:y")).intValue();
        if (r15 == r16) goto L9;
        r14.setScrollX(r15);
        ObjectAnimator r19 = ObjectAnimator.ofInt(r14, "scrollX", new int[]{r15, r16});
    L10:
        if (r17 == r18) goto L13;
        r14.setScrollY(r17);
        r13 = ObjectAnimator.ofInt(r14, "scrollY", new int[]{r17, r18});
    L13:
        return r.c(r19, r13);
    L9:
        r19 = null;
        goto L10
    L15:
        return null;
    L14:
        return null;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f4943a;
    }
}
