package com.bytedance.android.btm.impl.monitor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f42203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f42204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f42205d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f42202a, r101.f42202a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f42203b, r101.f42203b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f42204c, r101.f42204c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f42205d, r101.f42205d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f42202a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Object r104 = this.f42203b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f42204c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f42205d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "LogData(tag=" + this.f42202a + ", msg=" + this.f42203b + ", realSendTime=" + this.f42204c + ", errorCodeLevel=" + this.f42205d + ")";
    }

    public e(String r100, Object r101, Long r102, Integer r103) {
        this.f42202a = r100;
        this.f42203b = r101;
        this.f42204c = r102;
        this.f42205d = r103;
    }

    public /* synthetic */ e(String r100, Object r101, Long r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102, null);
    }
}
