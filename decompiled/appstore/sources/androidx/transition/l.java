package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public class l implements TypeEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f5069a;

    public l() {
    }

    public Rect a(float r10, Rect r11, Rect r12) {
        int r13 = r11.left;
        int r14 = r13 + ((int) ((r12.left - r13) * r10));
        int r15 = r11.top;
        int r16 = r15 + ((int) ((r12.top - r15) * r10));
        int r17 = r11.right;
        int r18 = r17 + ((int) ((r12.right - r17) * r10));
        int r19 = r11.bottom;
        int r20 = r19 + ((int) ((r12.bottom - r19) * r10));
        Rect r21 = this.f5069a;
        if (r21 == null) goto L5;
        r21.set(r14, r16, r18, r20);
        return this.f5069a;
    L5:
        return new Rect(r14, r16, r18, r20);
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Object evaluate(float r10, Object r11, Object r12) {
        return a(r10, (Rect) r11, (Rect) r12);
    }

    public l(Rect r10) {
        this.f5069a = r10;
    }
}
