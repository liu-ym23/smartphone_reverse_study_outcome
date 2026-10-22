package com.fasterxml.jackson.a.h;

import com.fasterxml.jackson.a.h.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JacksonFeatureSet.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i<F extends h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f12109a;

    public i(int r1) {
        this.f12109a = r1;
    }

    public static <F extends h> i<F> a(F[] r5) {
        int r1 = 0;
        if (r5.length > 31) goto L13;
        int r0 = r5.length;
        int r2 = 0;
    L5:
        if (r1 >= r0) goto L11;
        F r3 = r5[r1];
        if (r3.b() == false) goto L9;
        r2 = r2 | r3.c();
    L9:
        r1 = r1 + 1;
        goto L5
    L11:
        return new i(r2);
    L13:
        throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", new Object[]{r5[0].getClass().getName(), Integer.valueOf(r5.length)}));
    }

    public i<F> a(F r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        int r0 = this.f12109a;
        int r5 = r4.c() | r0;
        if (r5 != this.f12109a) goto L6;
        return this;
    L6:
        return new i(r5);
    }

    public boolean b(F r3) {
        int r4 = ((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin")).c();
        if ((this.f12109a & r4) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
