package qd;

import android.graphics.BlurMaskFilter;
import android.util.SparseArray;
import bg.h;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f23634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f23635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray f23636c;

    public a(float r10, float r11) {
        this.f23634a = r10;
        this.f23635b = r11;
        this.f23636c = new SparseArray();
    }

    public final void a() {
        this.f23636c.clear();
    }

    public final BlurMaskFilter b(float r10) {
        if (Float.isNaN(r10) == false) goto L5;
    L20:
        return null;
    L5:
        if (Float.isInfinite(r10) == true) goto L20;
        if (r10 <= 0.01f) goto L20;
        int r11 = h.d(yf.b.b(h.c(h.f(r10, this.f23634a), this.f23635b) / this.f23635b), 1);
        BlurMaskFilter r12 = (BlurMaskFilter) this.f23636c.get(r11);
        if (r12 == null) goto L21;
        return r12;
    L21:
        BlurMaskFilter r13 = new BlurMaskFilter(r11 * this.f23635b, BlurMaskFilter.Blur.NORMAL);     // Catch: RuntimeException -> L15
    L16:
        if (r13 != null) goto L18;
        return null;
    L18:
        this.f23636c.put(r11, r13);
        return r13;
    L15:
        r13 = null;
        goto L16
    }
}
