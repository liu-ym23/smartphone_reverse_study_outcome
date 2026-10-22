package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class n extends f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f5070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5071c;

    public n() {
        this.f5070b = 3.0f;
        this.f5071c = 80;
    }

    @Override // androidx.transition.q
    public long c(ViewGroup r17, Transition r18, s r19, s r20) {
        s r10 = r19;
        if (r10 != null) goto L6;
        if (r20 != null) goto L6;
        return 0;
    L6:
        Rect r11 = r18.getEpicenter();
        if (r20 != null) goto L9;
    L12:
        int r13 = -1;
    L13:
        int r12 = f(r10);
        int r14 = g(r10);
        int[] r15 = new int[2];
        r17.getLocationOnScreen(r15);
        int r16 = r15[0] + Math.round(r17.getTranslationX());
        int r21 = r15[1] + Math.round(r17.getTranslationY());
        int r22 = r16 + r17.getWidth();
        int r23 = r21 + r17.getHeight();
        if (r11 == null) goto L16;
        int r24 = r11.centerX();
        int r110 = r11.centerY();
    L17:
        float r25 = h(r17, r12, r14, r24, r110, r16, r21, r22, r23) / i(r17);
        long r26 = r18.getDuration();
        if (r26 >= 0) goto L21;
        r26 = 300;
    L21:
        return Math.round(((r26 * ((long) r13)) / this.f5070b) * r25);
    L16:
        r24 = (r16 + r22) / 2;
        r110 = (r21 + r23) / 2;
        goto L17
    L9:
        if (e(r10) == 0) goto L12;
        r10 = r20;
        r13 = 1;
        goto L13
    }

    public final int h(View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
        int r19 = this.f5071c;
        if (r19 != 8388611) goto L9;
        if (ViewCompat.A(r10) != 1) goto L7;
    L6:
        r19 = 5;
    L13:
        if (r19 == 3) goto L24;
        if (r19 == 5) goto L28;
        if (r19 == 48) goto L27;
        if (r19 == 80) goto L26;
        return 0;
    L26:
        return Math.abs(r13 - r11) + (r12 - r16);
    L27:
        return Math.abs(r13 - r11) + (r18 - r12);
    L28:
        return Math.abs(r14 - r12) + (r11 - r15);
    L24:
        return Math.abs(r14 - r12) + (r17 - r11);
    L7:
        r19 = 3;
        goto L13
    L9:
        if (r19 != 8388613) goto L13;
        if (ViewCompat.A(r10) != 1) goto L6;
        goto L6
    }

    public final int i(ViewGroup r10) {
        int r11 = this.f5071c;
        if (r11 == 3) goto L13;
        if (r11 == 5) goto L13;
        if (r11 == 8388611) goto L13;
        if (r11 == 8388613) goto L13;
        return r10.getHeight();
    L13:
        return r10.getWidth();
    }

    public void j(int r10) {
        this.f5071c = r10;
    }
}
