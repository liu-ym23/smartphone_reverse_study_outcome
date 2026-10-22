package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class Explode extends Visibility {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f4974b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f4975c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f4976a;

    static {
        f4974b = new DecelerateInterpolator();
        f4975c = new AccelerateInterpolator();
    }

    public Explode(@NonNull Context r10, @NonNull AttributeSet r11) {
        super(r10, r11);
        this.f4976a = new int[2];
        setPropagation(new b());
    }

    private void captureValues(s r10) {
        View r11 = r10.f5086b;
        r11.getLocationOnScreen(this.f4976a);
        int[] r12 = this.f4976a;
        int r13 = r12[0];
        int r14 = r12[1];
        int r15 = r11.getWidth() + r13;
        int r16 = r11.getHeight() + r14;
        r10.f5085a.put("android:explode:screenBounds", new Rect(r13, r14, r15, r16));
    }

    public static float t(float r10, float r11) {
        return (float) Math.sqrt((r10 * r10) + (r11 * r11));
    }

    public static float u(View r10, int r11, int r12) {
        return t(Math.max(r11, r10.getWidth() - r11), Math.max(r12, r10.getHeight() - r12));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(s r10) {
        super.captureEndValues(r10);
        captureValues(r10);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(s r10) {
        super.captureStartValues(r10);
        captureValues(r10);
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup r11, View r12, s r13, s r14) {
        if (r14 != null) goto L5;
        return null;
    L5:
        Rect r15 = (Rect) r14.f5085a.get("android:explode:screenBounds");
        float r10 = r12.getTranslationX();
        float r16 = r12.getTranslationY();
        v(r11, r15, this.f4976a);
        int[] r17 = this.f4976a;
        return u.a(r12, r14, r15.left, r15.top, r10 + r17[0], r16 + r17[1], r10, r16, f4974b, this);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup r11, View r12, s r13, s r14) {
        if (r13 != null) goto L5;
        return null;
    L5:
        Rect r15 = (Rect) r13.f5085a.get("android:explode:screenBounds");
        int r10 = r15.left;
        int r16 = r15.top;
        float r17 = r12.getTranslationX();
        float r18 = r12.getTranslationY();
        int[] r19 = (int[]) r13.f5086b.getTag(R$id.transition_position);
        if (r19 == null) goto L8;
        int r20 = r19[0];
        float r21 = (r20 - r15.left) + r17;
        int r22 = r19[1];
        float r23 = (r22 - r15.top) + r18;
        r15.offsetTo(r20, r22);
    L9:
        v(r11, r15, this.f4976a);
        int[] r110 = this.f4976a;
        return u.a(r12, r13, r10, r16, r17, r18, r21 + r110[0], r23 + r110[1], f4975c, this);
    L8:
        r21 = r17;
        r23 = r18;
        goto L9
    }

    public final void v(View r13, Rect r14, int[] r15) {
        r13.getLocationOnScreen(this.f4976a);
        int[] r10 = this.f4976a;
        int r11 = r10[0];
        int r12 = r10[1];
        Rect r16 = getEpicenter();
        if (r16 != null) goto L5;
        int r17 = ((r13.getWidth() / 2) + r11) + Math.round(r13.getTranslationX());
        int r18 = ((r13.getHeight() / 2) + r12) + Math.round(r13.getTranslationY());
    L6:
        float r19 = r14.centerX() - r17;
        float r110 = r14.centerY() - r18;
        if (r19 == 0.0f) goto L9;
    L11:
        float r20 = t(r19, r110);
        float r111 = u(r13, r17 - r11, r18 - r12);
        r15[0] = Math.round((r19 / r20) * r111);
        r15[1] = Math.round(r111 * (r110 / r20));
        return;
    L9:
        if (r110 != 0.0f) goto L11;
        r19 = ((float) (Math.random() * 2.0d)) - 1.0f;
        r110 = ((float) (Math.random() * 2.0d)) - 1.0f;
        goto L11
    L5:
        int r21 = r16.centerX();
        r18 = r16.centerY();
        r17 = r21;
        goto L6
    }
}
