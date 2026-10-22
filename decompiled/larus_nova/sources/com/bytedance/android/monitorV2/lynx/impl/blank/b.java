package com.bytedance.android.monitorV2.lynx.impl.blank;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f163186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f163187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f.a f163188c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f163186a == r101.f163186a) goto L12;
        return false;
    L12:
        if (this.f163187b == r101.f163187b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f163188c, r101.f163188c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f163186a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f163187b;
        return ((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f163188c.hashCode();
    }

    public final String toString() {
        return "BlankCheck(detectElapse=" + this.f163186a + ", checkElapse=" + this.f163187b + ", checkResult=" + this.f163188c + ')';
    }

    public b() {
        this(0, 0, new f.a(0));
    }

    public b(long r100, long r101, f.a r102) {
        Intrinsics.checkNotNullParameter(r102, "checkResult");
        this.f163186a = r100;
        this.f163187b = r101;
        this.f163188c = r102;
    }
}
