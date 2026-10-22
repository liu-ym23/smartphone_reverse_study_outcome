package com.bytedance.ai.bridge.method.device.calendar;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f35454l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f35456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f35457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f35458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f35459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f35460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f35461g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f35462h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f35463i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RepeatInterval f35464j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f35465k;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f35455a, r101.f35455a) == true) goto L12;
        return false;
    L12:
        if (this.f35456b == r101.f35456b) goto L15;
        return false;
    L15:
        if (this.f35457c == r101.f35457c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f35458d, r101.f35458d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f35459e, r101.f35459e) == true) goto L24;
        return false;
    L24:
        if (this.f35460f == r101.f35460f) goto L27;
        return false;
    L27:
        if (this.f35461g == r101.f35461g) goto L30;
        return false;
    L30:
        if (this.f35462h == r101.f35462h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f35463i, r101.f35463i) == true) goto L36;
        return false;
    L36:
        if (this.f35464j == r101.f35464j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f35465k, r101.f35465k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f35455a.hashCode() * 31;
        long r101 = this.f35456b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        int r103 = 1231;
        if (this.f35457c == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (r102 + r104) * 31;
        String r106 = this.f35458d;
        int r107 = 0;
        if (r106 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r105 + r108) * 31;
        String r110 = this.f35459e;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        long r112 = this.f35460f;
        int r113 = (((r109 + r111) * 31) + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        if (this.f35461g == true) goto L18;
        r103 = 1237;
    L18:
        long r114 = this.f35462h;
        int r115 = (((r113 + r103) * 31) + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        String r116 = this.f35463i;
        if (r116 != null) goto L21;
        int r117 = 0;
    L22:
        int r118 = (r115 + r117) * 31;
        RepeatInterval r119 = this.f35464j;
        if (r119 != null) goto L25;
        int r120 = 0;
    L26:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.f35465k;
        if (r122 == null) goto L31;
        r107 = r122.hashCode();
    L31:
        return r121 + r107;
    L25:
        r120 = r119.hashCode();
        goto L26
    L21:
        r117 = r116.hashCode();
        goto L22
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r108 = r106.hashCode();
        goto L10
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "CalendarEventArgs(title=" + this.f35455a + ", startTime=" + this.f35456b + ", allDay=" + this.f35457c + ", description=" + this.f35458d + ", location=" + this.f35459e + ", endTime=" + this.f35460f + ", alarm=" + this.f35461g + ", alarmOffset=" + this.f35462h + ", path=" + this.f35463i + ", repeatInterval=" + this.f35464j + ", repeatEndTime=" + this.f35465k + ')';
    }

    static {
        f35454l = new a();
    }

    public f(String r100, long r101, boolean r102, String r103, String r104, long r105, boolean r110, long r111, String r112, RepeatInterval r113, Long r114) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f35455a = r100;
        this.f35456b = r101;
        this.f35457c = r102;
        this.f35458d = r103;
        this.f35459e = r104;
        this.f35460f = r105;
        this.f35461g = r110;
        this.f35462h = r111;
        this.f35463i = r112;
        this.f35464j = r113;
        this.f35465k = r114;
    }
}
