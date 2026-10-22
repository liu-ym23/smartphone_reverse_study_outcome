package com.bytedance.ai.applet.app.foundation.performance;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f34361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f34363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f34364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f34365e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f34361a == r101.f34361a) goto L12;
        return false;
    L12:
        if (this.f34362b == r101.f34362b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f34363c, r101.f34363c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f34364d, r101.f34364d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f34365e, r101.f34365e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f34361a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f34362b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        Long r104 = this.f34363c;
        int r105 = 0;
        if (r104 != null) goto L5;
        int r106 = 0;
    L6:
        int r107 = (r103 + r106) * 31;
        Long r108 = this.f34364d;
        if (r108 != null) goto L9;
        int r109 = 0;
    L10:
        int r110 = (r107 + r109) * 31;
        Long r111 = this.f34365e;
        if (r111 == null) goto L15;
        r105 = r111.hashCode();
    L15:
        return r110 + r105;
    L9:
        r109 = r108.hashCode();
        goto L10
    L5:
        r106 = r104.hashCode();
        goto L6
    }

    public final String toString() {
        return "FirstRenderTiming(startTime=" + this.f34361a + ", endTime=" + this.f34362b + ", viewLayerReadyTime=" + this.f34363c + ", viewLayerRenderStartTime=" + this.f34364d + ", viewLayerRenderEndTime=" + this.f34365e + ')';
    }

    public final boolean a(long r110) {
        long r100 = this.f34361a;
        if (r100 >= r110) goto L5;
        return false;
    L5:
        if (this.f34362b < r100) goto L38;
        List r111 = CollectionsKt.listOfNotNull(new Long[]{this.f34363c, this.f34364d, this.f34365e});
        if ((r111 instanceof Collection) == true) goto L10;
    L12:
        Iterator r112 = r111.iterator();
    L14:
        if (r112.hasNext() == false) goto L11;
        long r101 = ((Number) r112.next()).longValue();
        long r102 = this.f34361a;
        if (r101 <= this.f34362b) goto L18;
    L20:
        boolean r113 = false;
    L22:
        if ((!r113) == false) goto L14;
        boolean r114 = true;
    L24:
        if (r114 == false) goto L26;
        return false;
    L26:
        Long r115 = this.f34364d;
        Long r116 = this.f34365e;
        if (r115 == null) goto L31;
        if (r116 == null) goto L31;
        if (r116.longValue() >= r115.longValue()) goto L31;
        return false;
    L31:
        return true;
    L18:
        if (r102 > r101) goto L20;
        r113 = true;
    L11:
        r114 = false;
        goto L24
    L10:
        if (r111.isEmpty() == false) goto L12;
    L38:
        return false;
    }

    public o(long r100, long r101, Long r102, Long r103, Long r104) {
        this.f34361a = r100;
        this.f34362b = r101;
        this.f34363c = r102;
        this.f34364d = r103;
        this.f34365e = r104;
    }
}
