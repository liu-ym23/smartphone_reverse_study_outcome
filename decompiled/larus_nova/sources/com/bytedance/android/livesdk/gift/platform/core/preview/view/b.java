package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f131082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f131083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f131084c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (this.f131082a == r101.f131082a) goto L8;
        return false;
    L8:
        if (this.f131083b == r101.f131083b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f131084c, r101.f131084c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f131082a * 31) + this.f131083b) * 31;
        Function0<Unit> r101 = this.f131084c;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "SelectViewStyleConfig(bottomBackground=" + this.f131082a + ", selectText=" + this.f131083b + ", clickAction=" + this.f131084c + ")";
    }

    public b(int r100, int r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "clickAction");
        this.f131082a = r100;
        this.f131083b = r101;
        this.f131084c = r102;
    }
}
