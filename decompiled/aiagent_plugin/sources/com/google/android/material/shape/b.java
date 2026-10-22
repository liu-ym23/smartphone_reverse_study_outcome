package com.google.android.material.shape;

import android.graphics.RectF;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: AdjustedCornerSize.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f13537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f13538b;

    public b(float r4, c r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.aiagent.plugin");
    L4:
        if (ZeusTransformUtils.instanceOf(r6, b.class) == false) goto L6;
        r6 = ((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin")).f13537a;
        r4 = r4 + ((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin")).f13538b;
        goto L4
    L6:
        this.f13537a = r6;
        this.f13538b = r4;
    }

    @Override // com.google.android.material.shape.c
    public float a(RectF r2) {
        return Math.max(0.0f, this.f13537a.a(r2) + this.f13538b);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f13537a.equals(r6.f13537a) == false) goto L14;
        if (this.f13538b != r6.f13538b) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f13537a, Float.valueOf(this.f13538b)});
    }
}
