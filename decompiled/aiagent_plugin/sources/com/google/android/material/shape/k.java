package com.google.android.material.shape;

import android.graphics.RectF;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: RelativeCornerSize.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f13548a;

    public k(float r1) {
        this.f13548a = r1;
    }

    @Override // com.google.android.material.shape.c
    public float a(RectF r1) {
        return this.f13548a * r1.height();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin");
        if (this.f13548a != r6.f13548a) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f13548a)});
    }
}
