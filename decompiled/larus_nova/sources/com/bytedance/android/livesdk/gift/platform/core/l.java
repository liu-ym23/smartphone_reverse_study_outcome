package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.gift.model.c2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c2 f130727a;

    public l() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f130727a, ((l) r100).f130727a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        c2 r100 = this.f130727a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "GiftStructInfo(giftTip=" + this.f130727a + ")";
    }

    public l(c2 r100) {
        this.f130727a = r100;
    }
}
