package com.bytedance.android.live.liveinteract.api.utils;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f71520c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ti6.f f71521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.link.model.bridge.k f71522b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L10;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f71521a, r101.f71521a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f71522b, r101.f71522b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        ti6.f r100 = this.f71521a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.livesdk.link.model.bridge.k r104 = this.f71522b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RegionWrapper(region=" + this.f71521a + ", linkUser=" + this.f71522b + ")";
    }

    public k(ti6.f r100) {
        Intrinsics.checkNotNullParameter(r100, EffectConfiguration.KEY_REGION);
        this.f71521a = r100;
        this.f71522b = null;
    }
}
