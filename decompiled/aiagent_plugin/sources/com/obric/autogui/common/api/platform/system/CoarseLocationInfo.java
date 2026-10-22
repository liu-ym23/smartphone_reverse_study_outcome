package com.obric.autogui.common.api.platform.system;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: LocationInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CoarseLocationInfo {
    private final boolean isSucceeded;
    private final Double latitude;
    private final Double longitude;
    private final String name;
    private final long refreshedAt;
    private final String representation;

    public static /* synthetic */ CoarseLocationInfo copy$default(CoarseLocationInfo r5, boolean r6, String r7, String r8, long r9, Double r11, Double r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.isSucceeded;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.representation;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.name;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.refreshedAt;
    L14:
        long r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r11 = r5.longitude;
    L17:
        Double r3 = r11;
        if ((r13 & 32) == 0) goto L20;
        r12 = r5.latitude;
    L20:
        boolean r10 = r6;
        return r5.copy(r10, r15, r0, r1, r3, r12);
    }

    public final boolean component1() {
        return this.isSucceeded;
    }

    public final String component2() {
        return this.representation;
    }

    public final String component3() {
        return this.name;
    }

    public final long component4() {
        return this.refreshedAt;
    }

    public final Double component5() {
        return this.longitude;
    }

    public final Double component6() {
        return this.latitude;
    }

    public final CoarseLocationInfo copy(boolean r9, String r10, String r11, long r12, Double r14, Double r15) {
        o.e(r10, "representation");
        o.e(r11, "name");
        return new CoarseLocationInfo(r9, r10, r11, r12, r14, r15);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, CoarseLocationInfo.class) == true) goto L8;
        return false;
    L8:
        CoarseLocationInfo r10 = (CoarseLocationInfo) ZeusTransformUtils.preCheckCast(r9, CoarseLocationInfo.class, "com.obric.aiagent.plugin");
        if (this.isSucceeded == r10.isSucceeded) goto L12;
        return false;
    L12:
        if (o.a(this.representation, r10.representation) == true) goto L15;
        return false;
    L15:
        if (o.a(this.name, r10.name) == true) goto L18;
        return false;
    L18:
        if (this.refreshedAt == r10.refreshedAt) goto L21;
        return false;
    L21:
        if (o.a(this.longitude, r10.longitude) == true) goto L24;
        return false;
    L24:
        if (o.a(this.latitude, r10.latitude) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((Boolean.hashCode(this.isSucceeded) * 31) + this.representation.hashCode()) * 31) + this.name.hashCode()) * 31) + Long.hashCode(this.refreshedAt)) * 31;
        Double r1 = this.longitude;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Double r5 = this.latitude;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "CoarseLocationInfo(isSucceeded=" + this.isSucceeded + ", representation=" + this.representation + ", name=" + this.name + ", refreshedAt=" + this.refreshedAt + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ')';
    }

    public CoarseLocationInfo(boolean r2, String r3, String r4, long r5, Double r7, Double r8) {
        o.e(r3, "representation");
        o.e(r4, "name");
        this.isSucceeded = r2;
        this.representation = r3;
        this.name = r4;
        this.refreshedAt = r5;
        this.longitude = r7;
        this.latitude = r8;
    }

    public /* synthetic */ CoarseLocationInfo(boolean r10, String r11, String r12, long r13, Double r15, Double r16, int r17, h r18) {
        if ((r17 & 4) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r17 & 16) == 0) goto L9;
        Double r7 = null;
    L11:
        if ((r17 & 32) == 0) goto L13;
        Double r8 = null;
    L14:
        this(r10, r11, r4, r13, r7, r8);
        return;
    L13:
        r8 = r16;
        goto L14
    L9:
        r7 = r15;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }

    public final boolean isSucceeded() {
        return this.isSucceeded;
    }

    public final String getRepresentation() {
        return this.representation;
    }

    public final String getName() {
        return this.name;
    }

    public final long getRefreshedAt() {
        return this.refreshedAt;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final Double getLatitude() {
        return this.latitude;
    }
}
