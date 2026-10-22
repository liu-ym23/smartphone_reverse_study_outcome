package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f170355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f170356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f170357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f170358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f170359e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f170355a, r101.f170355a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f170356b, r101.f170356b) == true) goto L10;
        return false;
    L10:
        if (Double.compare(this.f170357c, r101.f170357c) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f170358d, r101.f170358d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f170359e, r101.f170359e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f170355a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f170356b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = Double.doubleToLongBits(this.f170357c);
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f170358d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        Map<String, Object> r112 = this.f170359e;
        if (r112 == null) goto L18;
        r101 = r112.hashCode();
    L18:
        return r111 + r101;
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SessionStageData(stageName=" + this.f170355a + ", scheme=" + this.f170356b + ", timestamp=" + this.f170357c + ", triggerSource=" + this.f170358d + ", extraData=" + this.f170359e + ")";
    }

    public c(String r100, String r101, double r102, String r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "stageName");
        Intrinsics.checkNotNullParameter(r101, "scheme");
        Intrinsics.checkNotNullParameter(r103, "triggerSource");
        this.f170355a = r100;
        this.f170356b = r101;
        this.f170357c = r102;
        this.f170358d = r103;
        this.f170359e = r104;
    }
}
