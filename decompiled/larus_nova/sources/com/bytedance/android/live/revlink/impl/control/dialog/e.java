package com.bytedance.android.live.revlink.impl.control.dialog;

import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f92380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f92381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IRivalRankRecommendResponse f92382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f92383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f92384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f92385f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L18;
        e r101 = (e) r100;
        if (this.f92380a == r101.f92380a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f92381b, r101.f92381b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f92382c, r101.f92382c) == true) goto L12;
        return false;
    L12:
        if (this.f92383d == r101.f92383d) goto L14;
        return false;
    L14:
        if (this.f92384e == r101.f92384e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f92385f, r101.f92385f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f92380a * 31;
        String r101 = this.f92381b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        IRivalRankRecommendResponse r105 = this.f92382c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        long r107 = this.f92383d;
        int r108 = (((r104 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f92384e;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        Map<String, String> r111 = this.f92385f;
        if (r111 == null) goto L14;
        r102 = r111.hashCode();
    L14:
        return r110 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "RecommendCacheData(loadType=" + this.f92380a + ", activityId=" + this.f92381b + ", resp=" + this.f92382c + ", startLoadingTs=" + this.f92383d + ", loadedTs=" + this.f92384e + ", logMap=" + this.f92385f + ")";
    }

    public /* synthetic */ e(int r110, String r111, IRivalRankRecommendResponse r112, long r113, long r114) {
        this(r110, r111, r112, r113, r114, null);
    }

    public e(int r100, String r101, IRivalRankRecommendResponse r102, long r103, long r104, Map<String, String> r105) {
        Intrinsics.checkNotNullParameter(r101, "activityId");
        Intrinsics.checkNotNullParameter(r102, "resp");
        this.f92380a = r100;
        this.f92381b = r101;
        this.f92382c = r102;
        this.f92383d = r103;
        this.f92384e = r104;
        this.f92385f = r105;
    }
}
