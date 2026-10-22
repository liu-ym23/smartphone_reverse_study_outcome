package androidx.transition;

import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes.dex */
public class c implements TypeEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f5038a;

    public c(float[] r10) {
        this.f5038a = r10;
    }

    public float[] a(float r10, float[] r11, float[] r12) {
        float[] r13 = this.f5038a;
        if (r13 != null) goto L5;
        r13 = new float[r11.length];
    L5:
        int r14 = 0;
    L7:
        if (r14 >= r13.length) goto L9;
        float r15 = r11[r14];
        r13[r14] = r15 + ((r12[r14] - r15) * r10);
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Object evaluate(float r10, Object r11, Object r12) {
        return a(r10, (float[]) r11, (float[]) r12);
    }
}
