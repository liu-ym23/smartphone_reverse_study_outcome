package com.bytedance.android.livesdk.revenue.room;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f157281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f157282b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f157281a, r101.f157281a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f157282b, r101.f157282b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f157281a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f157282b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RevLoginGuideConfig(prompt=" + this.f157281a + ", imageUrl=" + this.f157282b + ")";
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.RETAIN_PROMPT);
        Intrinsics.checkNotNullParameter(r101, "imageUrl");
        this.f157281a = r100;
        this.f157282b = r101;
    }
}
