package com.bytedance.android.live.revenuelink;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f91831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveTracingMonitorKt.EventModule f91832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f91833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f91834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f91835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f91836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f91837g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L20;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f91831a, r101.f91831a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f91832b, r101.f91832b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f91833c, r101.f91833c) == true) goto L12;
        return false;
    L12:
        if (this.f91834d == r101.f91834d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f91835e, r101.f91835e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f91836f, r101.f91836f) == true) goto L18;
        return false;
    L18:
        if (this.f91837g == r101.f91837g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f91831a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        LiveTracingMonitorKt.EventModule r104 = this.f91832b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f91833c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.f91834d) * 31;
        String r110 = this.f91835e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f91836f;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        int r114 = (r112 + r101) * 31;
        long r115 = this.f91837g;
        return r114 + ((int) (r115 ^ (r115 >>> 32)));
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LinkMonitorMeta(event=" + this.f91831a + ", module=" + this.f91832b + ", index=" + this.f91833c + ", statusCode=" + this.f91834d + ", statusMsg=" + this.f91835e + ", logId=" + this.f91836f + ", channelId=" + this.f91837g + ")";
    }

    public g(String r100, LiveTracingMonitorKt.EventModule r101, Map<String, Object> r102, int r103, String r104, String r105, long r106) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r102, "index");
        this.f91831a = r100;
        this.f91832b = r101;
        this.f91833c = r102;
        this.f91834d = r103;
        this.f91835e = r104;
        this.f91836f = r105;
        this.f91837g = r106;
    }
}
