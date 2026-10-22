package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class b extends f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f5037b;

    public b() {
        this.f5037b = 3.0f;
    }

    public static float h(float r10, float r11, float r12, float r13) {
        float r14 = r12 - r10;
        float r15 = r13 - r11;
        return (float) Math.sqrt((r14 * r14) + (r15 * r15));
    }

    @Override // androidx.transition.q
    public long c(ViewGroup r10, Transition r11, s r12, s r13) {
        if (r12 != null) goto L7;
        if (r13 != null) goto L7;
        return 0;
    L7:
        if (r13 != null) goto L9;
    L12:
        int r14 = -1;
    L13:
        int r15 = f(r12);
        int r16 = g(r12);
        Rect r17 = r11.getEpicenter();
        if (r17 == null) goto L16;
        int r18 = r17.centerX();
        int r19 = r17.centerY();
    L17:
        float r110 = h(r15, r16, r18, r19) / h(0.0f, 0.0f, r10.getWidth(), r10.getHeight());
        long r20 = r11.getDuration();
        if (r20 >= 0) goto L21;
        r20 = 300;
    L21:
        return Math.round(((r20 * ((long) r14)) / this.f5037b) * r110);
    L16:
        int[] r21 = new int[2];
        r10.getLocationOnScreen(r21);
        int r22 = Math.round((r21[0] + (r10.getWidth() / 2)) + r10.getTranslationX());
        r19 = Math.round((r21[1] + (r10.getHeight() / 2)) + r10.getTranslationY());
        r18 = r22;
        goto L17
    L9:
        if (e(r12) == 0) goto L12;
        r12 = r13;
        r14 = 1;
        goto L13
    }
}
