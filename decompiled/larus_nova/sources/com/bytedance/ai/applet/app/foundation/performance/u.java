package com.bytedance.ai.applet.app.foundation.performance;

import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f34381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34383c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (this.f34381a == r101.f34381a) goto L12;
        return false;
    L12:
        if (this.f34382b == r101.f34382b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f34383c, r101.f34383c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f34381a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f34382b;
        return ((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f34383c.hashCode();
    }

    public final String toString() {
        return "ScriptEvaluationTiming(startTime=" + this.f34381a + ", endTime=" + this.f34382b + ", moduleName=" + this.f34383c + ')';
    }

    public u(long r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, TextureRenderKeys.KEY_MODULE_NAME);
        this.f34381a = r100;
        this.f34382b = r101;
        this.f34383c = r102;
    }
}
