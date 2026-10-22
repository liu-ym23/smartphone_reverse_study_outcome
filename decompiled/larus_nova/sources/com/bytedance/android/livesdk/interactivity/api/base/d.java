package com.bytedance.android.livesdk.interactivity.api.base;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageChangeSource;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PublicScreenAreaPageType f132904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f132905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublicScreenAreaPageChangeSource f132906c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f132904a, r101.f132904a) == true) goto L8;
        return false;
    L8:
        if (this.f132905b == r101.f132905b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f132906c, r101.f132906c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        PublicScreenAreaPageType r100 = this.f132904a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f132905b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        PublicScreenAreaPageChangeSource r105 = this.f132906c;
        if (r105 == null) goto L10;
        r101 = r105.hashCode();
    L10:
        return r104 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PublicScreenAreaPageState(pageType=" + this.f132904a + ", currentPageId=" + this.f132905b + ", changeSource=" + this.f132906c + ")";
    }

    public d(PublicScreenAreaPageType r100, long r101, PublicScreenAreaPageChangeSource r102) {
        Intrinsics.checkNotNullParameter(r100, "pageType");
        Intrinsics.checkNotNullParameter(r102, "changeSource");
        this.f132904a = r100;
        this.f132905b = r101;
        this.f132906c = r102;
    }
}
