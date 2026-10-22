package com.bytedance.android.live.profit.profitCheck;

import com.bytedance.android.live.profit.privilege.model.ReportType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f88473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReportType f88474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f88475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f88476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f88477e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f88473a, r101.f88473a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f88474b, r101.f88474b) == true) goto L10;
        return false;
    L10:
        if (this.f88475c == r101.f88475c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f88476d, r101.f88476d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f88477e, r101.f88477e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        d r100 = this.f88473a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ReportType r104 = this.f88474b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f88475c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        Map<String, String> r109 = this.f88476d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        Map<String, Object> r112 = this.f88477e;
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
        return "ProfitCheckTask(type=" + this.f88473a + ", reportType=" + this.f88474b + ", expireTime=" + this.f88475c + ", traceMetaData=" + this.f88476d + ", traceIndexData=" + this.f88477e + ")";
    }

    public final d getType() {
        return this.f88473a;
    }

    public c(d r100, ReportType r101, long r102, Map<String, String> r103, Map<String, Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "reportType");
        Intrinsics.checkNotNullParameter(r103, "traceMetaData");
        Intrinsics.checkNotNullParameter(r104, "traceIndexData");
        this.f88473a = r100;
        this.f88474b = r101;
        this.f88475c = r102;
        this.f88476d = r103;
        this.f88477e = r104;
    }
}
