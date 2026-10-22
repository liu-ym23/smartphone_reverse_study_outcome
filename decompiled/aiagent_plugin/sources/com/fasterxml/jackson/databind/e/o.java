package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AnnotatedWithParams.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class o extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final q[] f12645e;

    public abstract Class<?> a(int r1);

    public abstract Object a(Object r1);

    public abstract com.fasterxml.jackson.databind.k b(int r1);

    public abstract Object call();

    public abstract Object call(Object[] r1);

    public abstract int e();

    public o(ag r3, q r4, q[] r5) {
        super((ag) ZeusTransformUtils.wrapperContextForParams(r3, ag.class, "com.obric.aiagent.plugin"), r4);
        this.f12645e = r5;
    }

    public n a(int r2, q r3) {
        this.f12645e[r2] = r3;
        return d(r2);
    }

    public final q c(int r2) {
        q[] r1 = this.f12645e;
        if (r1 == null) goto L9;
        if (r2 >= 0) goto L6;
        return null;
    L6:
        if (r2 < r1.length) goto L8;
        return null;
    L8:
        return r1[r2];
    L9:
        return null;
    }

    public final n d(int r8) {
        return new n(this, b(r8), this.f12632b, c(r8), r8);
    }
}
