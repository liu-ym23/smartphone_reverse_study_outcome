package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class LocationCondition implements Parcelable, Condition {
    public static final Parcelable.Creator<LocationCondition> CREATOR = null;
    private final String addrName;
    private final String addrType;
    private final Double latitude;
    private final Double longitude;
    private final String mode;
    private final Integer radius;
    private final String type;

    public static final class Creator implements Parcelable.Creator<LocationCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LocationCondition createFromParcel(Parcel r11) {
            int r10 = r11.readInt();
            o.e(r11, "parcel");
            String r2 = r11.readString();
            String r3 = r11.readString();
            if (r11.readInt() != 0) goto L5;
            Double r5 = null;
        L7:
            if (r11.readInt() != 0) goto L9;
            Double r6 = null;
        L11:
            if (r11.readInt() != 0) goto L13;
            Integer r7 = null;
        L14:
            LocationCondition r0 = new LocationCondition(r2, r3, r5, r6, r7, r11.readString(), r11.readString());
            int r1 = Math.min(r10, 0);
            ClassLoader r4 = Creator.class.getClassLoader();
            int r8 = 1;
        L15:
            if (r8 > r1) goto L17;
            r8 = r8 + 1;
        L17:
            if (r8 > r10) goto L19;
            com.obric.a.a.a(r11, r4);
            r8 = r8 + 1;
            goto L17
        L19:
            return r0;
        L13:
            r7 = Integer.valueOf(r11.readInt());
            goto L14
        L9:
            r6 = Double.valueOf(r11.readDouble());
            goto L11
        L5:
            r5 = Double.valueOf(r11.readDouble());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LocationCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LocationCondition[] newArray(int r1) {
            return new LocationCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LocationCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public LocationCondition(String r2, String r3, Double r4, Double r5, Integer r6, String r7, String r8) {
        o.e(r2, "mode");
        o.e(r3, "type");
        this.mode = r2;
        this.type = r3;
        this.longitude = r4;
        this.latitude = r5;
        this.radius = r6;
        this.addrName = r7;
        this.addrType = r8;
    }

    public /* synthetic */ LocationCondition(String r11, String r12, Double r13, Double r14, Integer r15, String r16, String r17, int r18, h r19) {
        if ((r18 & 4) == 0) goto L5;
        Double r5 = null;
    L7:
        if ((r18 & 8) == 0) goto L9;
        Double r6 = null;
    L11:
        if ((r18 & 16) == 0) goto L13;
        Integer r7 = null;
    L15:
        if ((r18 & 32) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r18 & 64) == 0) goto L21;
        String r9 = null;
    L22:
        this(r11, r12, r5, r6, r7, r8, r9);
        return;
    L21:
        r9 = r17;
        goto L22
    L17:
        r8 = r16;
        goto L19
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public static /* synthetic */ LocationCondition copy$default(LocationCondition r5, String r6, String r7, Double r8, Double r9, Integer r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.mode;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.type;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.longitude;
    L11:
        Double r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.latitude;
    L14:
        Double r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.radius;
    L17:
        Integer r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.addrName;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.addrType;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.mode;
    }

    public final String component2() {
        return this.type;
    }

    public final Double component3() {
        return this.longitude;
    }

    public final Double component4() {
        return this.latitude;
    }

    public final Integer component5() {
        return this.radius;
    }

    public final String component6() {
        return this.addrName;
    }

    public final String component7() {
        return this.addrType;
    }

    public final LocationCondition copy(String r9, String r10, Double r11, Double r12, Integer r13, String r14, String r15) {
        o.e(r9, "mode");
        o.e(r10, "type");
        return new LocationCondition(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LocationCondition.class) == true) goto L8;
        return false;
    L8:
        LocationCondition r6 = (LocationCondition) ZeusTransformUtils.preCheckCast(r5, LocationCondition.class, "com.obric.aiagent.plugin");
        if (o.a(this.mode, r6.mode) == true) goto L12;
        return false;
    L12:
        if (o.a(this.type, r6.type) == true) goto L15;
        return false;
    L15:
        if (o.a(this.longitude, r6.longitude) == true) goto L18;
        return false;
    L18:
        if (o.a(this.latitude, r6.latitude) == true) goto L21;
        return false;
    L21:
        if (o.a(this.radius, r6.radius) == true) goto L24;
        return false;
    L24:
        if (o.a(this.addrName, r6.addrName) == true) goto L27;
        return false;
    L27:
        if (o.a(this.addrType, r6.addrType) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final String getAddrName() {
        return this.addrName;
    }

    public final String getAddrType() {
        return this.addrType;
    }

    public final Double getLatitude() {
        return this.latitude;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final String getMode() {
        return this.mode;
    }

    public final Integer getRadius() {
        return this.radius;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = ((this.mode.hashCode() * 31) + this.type.hashCode()) * 31;
        Double r1 = this.longitude;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Double r5 = this.latitude;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.radius;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.addrName;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.addrType;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "LocationCondition(mode=" + this.mode + ", type=" + this.type + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", radius=" + this.radius + ", addrName=" + this.addrName + ", addrType=" + this.addrType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        int r7 = 0;
        r5.writeInt(0);
        o.e(r5, "out");
        r5.writeString(this.mode);
        r5.writeString(this.type);
        Double r0 = this.longitude;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L6:
        Double r1 = this.latitude;
        if (r1 != null) goto L9;
        r5.writeInt(0);
    L10:
        Integer r2 = this.radius;
        if (r2 == null) goto L14;
        r5.writeInt(1);
        r7 = r2.intValue();
    L14:
        r5.writeInt(r7);
        r5.writeString(this.addrName);
        r5.writeString(this.addrType);
        return;
    L9:
        r5.writeInt(1);
        r5.writeDouble(r1.doubleValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeDouble(r0.doubleValue());
        goto L6
    }
}
