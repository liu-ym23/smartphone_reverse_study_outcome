package com.bytedance.android.shopping.utils;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f187045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vh3.a f187046b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a0) == false) goto L10;
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f187045a, r101.f187045a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f187046b, r101.f187046b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f187045a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        vh3.a r104 = this.f187046b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PdpSkuEventParams(sceneType=" + this.f187045a + ", skuInfo=" + this.f187046b + ")";
    }

    public a0(String r100) {
        Intrinsics.checkNotNullParameter(r100, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        this.f187045a = r100;
        this.f187046b = null;
    }
}
