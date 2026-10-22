package com.obric.autoaction.app.launcherpage.condition.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: ConditionEventLocationAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConditionLocationItemData implements Parcelable, Serializable {
    public static final Parcelable.Creator<ConditionLocationItemData> CREATOR = null;
    public static final a Companion = null;
    public static final int TYPE_COMPANY = 1;
    public static final int TYPE_CURRENT = 2;
    public static final int TYPE_HOME = 0;
    public static final int TYPE_REC = 3;

    @SerializedName(SensitiveType.ADDRESS)
    private final String address;

    @SerializedName("displayName")
    private final String displayName;

    @SerializedName("isSet")
    private final boolean isSet;

    @SerializedName("latitude")
    private final double latitude;

    @SerializedName("longitude")
    private final double longitude;

    @SerializedName("name")
    private final String name;

    @SerializedName("type")
    private final int type;

    /* JADX INFO: compiled from: ConditionEventLocationAdapter.kt */
    public static final class Creator implements Parcelable.Creator<ConditionLocationItemData> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConditionLocationItemData createFromParcel(Parcel r11) {
            d.h.b.o.e(r11, "parcel");
            int r1 = r11.readInt();
            String r2 = r11.readString();
            String r3 = r11.readString();
            double r4 = r11.readDouble();
            double r6 = r11.readDouble();
            if (r11.readInt() == 0) goto L5;
            boolean r0 = true;
        L7:
            return new ConditionLocationItemData(r1, r2, r3, r4, r6, r0, r11.readString());
        L5:
            r0 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ConditionLocationItemData createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConditionLocationItemData[] newArray(int r1) {
            return new ConditionLocationItemData[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ConditionLocationItemData[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: ConditionEventLocationAdapter.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ ConditionLocationItemData copy$default(ConditionLocationItemData r10, int r11, String r12, String r13, double r14, double r16, boolean r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        int r1 = r10.type;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r2 = r10.name;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r3 = r10.address;
    L15:
        if ((r20 & 8) == 0) goto L17;
        double r4 = r10.longitude;
    L19:
        if ((r20 & 16) == 0) goto L21;
        double r6 = r10.latitude;
    L23:
        if ((r20 & 32) == 0) goto L25;
        boolean r8 = r10.isSet;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r9 = r10.displayName;
    L31:
        return r10.copy(r1, r2, r3, r4, r6, r8, r9);
    L29:
        r9 = r19;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r4 = r14;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.address;
    }

    public final double component4() {
        return this.longitude;
    }

    public final double component5() {
        return this.latitude;
    }

    public final boolean component6() {
        return this.isSet;
    }

    public final String component7() {
        return this.displayName;
    }

    public final ConditionLocationItemData copy(int r12, String r13, String r14, double r15, double r17, boolean r19, String r20) {
        d.h.b.o.e(r13, "name");
        d.h.b.o.e(r14, SensitiveType.ADDRESS);
        return new ConditionLocationItemData(r12, r13, r14, r15, r17, r19, r20);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ConditionLocationItemData.class) == true) goto L8;
        return false;
    L8:
        ConditionLocationItemData r10 = (ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r9, ConditionLocationItemData.class, "com.obric.aiagent.plugin");
        if (this.type == r10.type) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.name, r10.name) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.address, r10.address) == true) goto L18;
        return false;
    L18:
        if (Double.compare(this.longitude, r10.longitude) == 0) goto L21;
        return false;
    L21:
        if (Double.compare(this.latitude, r10.latitude) == 0) goto L24;
        return false;
    L24:
        if (this.isSet == r10.isSet) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.displayName, r10.displayName) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((Integer.hashCode(this.type) * 31) + this.name.hashCode()) * 31) + this.address.hashCode()) * 31) + Double.hashCode(this.longitude)) * 31) + Double.hashCode(this.latitude)) * 31) + Boolean.hashCode(this.isSet)) * 31;
        String r3 = this.displayName;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r0 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        return "ConditionLocationItemData(type=" + this.type + ", name=" + this.name + ", address=" + this.address + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", isSet=" + this.isSet + ", displayName=" + this.displayName + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        d.h.b.o.e(r3, "dest");
        r3.writeInt(this.type);
        r3.writeString(this.name);
        r3.writeString(this.address);
        r3.writeDouble(this.longitude);
        r3.writeDouble(this.latitude);
        r3.writeInt(this.isSet ? 1 : 0);
        r3.writeString(this.displayName);
    }

    public ConditionLocationItemData(int r2, String r3, String r4, double r5, double r7, boolean r9, String r10) {
        d.h.b.o.e(r3, "name");
        d.h.b.o.e(r4, SensitiveType.ADDRESS);
        this.type = r2;
        this.name = r3;
        this.address = r4;
        this.longitude = r5;
        this.latitude = r7;
        this.isSet = r9;
        this.displayName = r10;
    }

    public /* synthetic */ ConditionLocationItemData(int r12, String r13, String r14, double r15, double r17, boolean r19, String r20, int r21, d.h.b.h r22) {
        if ((r21 & 32) == 0) goto L5;
        boolean r9 = true;
    L7:
        if ((r21 & 64) == 0) goto L9;
        String r10 = null;
    L10:
        this(r12, r13, r14, r15, r17, r9, r10);
        return;
    L9:
        r10 = r20;
        goto L10
    L5:
        r9 = r19;
        goto L7
    }

    public final int getType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAddress() {
        return this.address;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final boolean isSet() {
        return this.isSet;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getTitle() {
        String r0 = this.displayName;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.name;
    }

    public final boolean isStrictlySame(ConditionLocationItemData r7) {
        if (r7 != null) goto L6;
        return false;
    L6:
        if (this.type == r7.type) goto L8;
        return false;
    L8:
        if (this.longitude != r7.longitude) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        return false;
    L13:
        if (this.latitude != r7.latitude) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == true) goto L18;
        return false;
    L18:
        return true;
    L15:
        r6 = false;
        goto L16
    L10:
        r1 = false;
        goto L11
    }

    public final boolean isSame(ConditionLocationItemData r6) {
        if (r6 != null) goto L6;
        return false;
    L6:
        if (this.longitude != r6.longitude) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return false;
    L11:
        if (this.latitude != r6.latitude) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == true) goto L16;
        return false;
    L16:
        return true;
    L13:
        r5 = false;
        goto L14
    L8:
        r1 = false;
        goto L9
    }
}
