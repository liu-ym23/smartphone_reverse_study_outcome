package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.gift.model.h2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f130475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h2 f130476b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f130475a, r101.f130475a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f130476b, r101.f130476b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f130475a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        h2 r104 = this.f130476b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CurrentGiftEffect(type=" + this.f130475a + ", gift=" + this.f130476b + ")";
    }

    public final String getType() {
        return this.f130475a;
    }

    public d(String r100, h2 r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f130475a = r100;
        this.f130476b = r101;
    }
}
