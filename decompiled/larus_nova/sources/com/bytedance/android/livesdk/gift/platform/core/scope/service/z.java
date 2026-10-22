package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f131860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f131861b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == false) goto L10;
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f131860a, r101.f131860a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f131861b, r101.f131861b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f131860a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f131861b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "EffectModel(scene=" + this.f131860a + ", nodePath=" + this.f131861b + ")";
    }

    public z(String r100, List<String> r101) {
        this.f131860a = r100;
        this.f131861b = r101;
    }
}
