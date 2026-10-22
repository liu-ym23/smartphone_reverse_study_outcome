package com.obric.oui.texteffects.c;

import android.graphics.BlurMaskFilter;
import android.util.SparseArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.l.n;

/* JADX INFO: compiled from: BlurMaskFilterCache.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f36437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f36438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray<BlurMaskFilter> f36439c;

    public a(float r1, float r2) {
        this.f36437a = r1;
        this.f36438b = r2;
        this.f36439c = new SparseArray();
    }

    public final BlurMaskFilter a(float r6) {
        if (Float.isNaN(r6) == false) goto L5;
    L20:
        return null;
    L5:
        if (Float.isInfinite(r6) == true) goto L20;
        if (r6 <= 0.01f) goto L20;
        int r7 = n.c(d.i.a.a(n.a(n.b(r6, this.f36437a), this.f36438b) / this.f36438b), 1);
        BlurMaskFilter r0 = (BlurMaskFilter) ZeusTransformUtils.preCheckCast(this.f36439c.get(r7), BlurMaskFilter.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L21;
        return r0;
    L21:
        BlurMaskFilter r2 = new BlurMaskFilter(r7 * this.f36438b, BlurMaskFilter.Blur.NORMAL);     // Catch: RuntimeException -> L15
    L16:
        if (r2 != null) goto L18;
        return null;
    L18:
        this.f36439c.put(r7, r2);
        return r2;
    L15:
        r2 = (BlurMaskFilter) ZeusTransformUtils.preCheckCast(null, BlurMaskFilter.class, "com.obric.aiagent.plugin");
        goto L16
    }

    public final void a() {
        this.f36439c.clear();
    }
}
