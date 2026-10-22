package com.obric.memorydata.sdk.awareness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.n;
import d.o;

/* JADX INFO: compiled from: LocationInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LocationInfo implements Parcelable {
    public static final CREATOR CREATOR = null;

    @SerializedName("aoi_info")
    private final AoiInfo aoiInfo;

    @SerializedName("location_type")
    private final String locationType;

    @SerializedName("update_source")
    private final String updateSource;

    /* JADX INFO: compiled from: LocationInfo.kt */
    public static final class AoiInfo implements Parcelable {
        public static final CREATOR CREATOR = null;

        @SerializedName("aoi_id")
        private final String aoiId;

        @SerializedName("aoi_name")
        private final String aoiName;

        @SerializedName("aoi_type")
        private final String aoiType;

        /* JADX INFO: compiled from: LocationInfo.kt */
        public static final class CREATOR implements Parcelable.Creator<AoiInfo> {
            public /* synthetic */ CREATOR(h r1) {
                this();
            }

            private CREATOR() {
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ AoiInfo createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ AoiInfo[] newArray(int r1) {
                return newArray(r1);
            }

            public final AoiInfo fromJson(String r4) {
                CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
                if (r0 != null) goto L5;
            L8:
                boolean r1 = true;
            L9:
                Object r2 = null;
                if (r1 == false) goto L26;
                return null;
            L26:
                n.a r3 = n.f38560a;     // Catch: Throwable -> L18
                CREATOR r5 = (CREATOR) ZeusTransformUtils.preCheckCast(this, CREATOR.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
                AoiInfo r6 = (AoiInfo) ZeusTransformUtils.preCheckCast(b.a().fromJson(r4, AoiInfo.class), AoiInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
                if (r6 == null) goto L15;
                AoiInfo r7 = b.a(r6);     // Catch: Throwable -> L18
            L16:
                Object r8 = n.f(r7);     // Catch: Throwable -> L18
            L21:
                if (n.b(r8) == true) goto L25;
                r2 = r8;
            L25:
                return (AoiInfo) ZeusTransformUtils.preCheckCast(r2, AoiInfo.class, "com.obric.aiagent.plugin");
            L15:
                r7 = null;
            L18:
                th = move-exception;
                n.a r9 = n.f38560a;
                r8 = n.f(o.a(th));
                goto L21
            L5:
                if (d.o.o.d(r0) == true) goto L8;
                r1 = false;
                goto L9
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AoiInfo createFromParcel(Parcel r7) {
                d.h.b.o.e(r7, "parcel");
                AoiInfo r6 = fromJson(r7.readString());
                if (r6 == null) goto L5;
                return r6;
            L5:
                return new AoiInfo(null, null, null, 7, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AoiInfo[] newArray(int r1) {
                return new AoiInfo[r1];
            }
        }

        static {
            CREATOR = new CREATOR(null);
        }

        public AoiInfo() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ AoiInfo copy$default(AoiInfo r0, String r1, String r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.aoiId;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.aoiName;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.aoiType;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public static final AoiInfo fromJson(String r1) {
            return CREATOR.fromJson(r1);
        }

        public final String component1() {
            return this.aoiId;
        }

        public final String component2() {
            return this.aoiName;
        }

        public final String component3() {
            return this.aoiType;
        }

        public final AoiInfo copy(String r1, String r2, String r3) {
            d.h.b.o.e(r1, "aoiId");
            d.h.b.o.e(r2, "aoiName");
            d.h.b.o.e(r3, "aoiType");
            return new AoiInfo(r1, r2, r3);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AoiInfo.class) == true) goto L8;
            return false;
        L8:
            AoiInfo r6 = (AoiInfo) ZeusTransformUtils.preCheckCast(r5, AoiInfo.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.aoiId, r6.aoiId) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.aoiName, r6.aoiName) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.aoiType, r6.aoiType) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.aoiId.hashCode() * 31) + this.aoiName.hashCode()) * 31) + this.aoiType.hashCode();
        }

        public String toString() {
            return "AoiInfo(aoiId=" + this.aoiId + ", aoiName=" + this.aoiName + ", aoiType=" + this.aoiType + ')';
        }

        public AoiInfo(String r2, String r3, String r4) {
            d.h.b.o.e(r2, "aoiId");
            d.h.b.o.e(r3, "aoiName");
            d.h.b.o.e(r4, "aoiType");
            this.aoiId = r2;
            this.aoiName = r3;
            this.aoiType = r4;
        }

        public /* synthetic */ AoiInfo(String r2, String r3, String r4, int r5, h r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = "";
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = "";
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = "";
        L11:
            this(r2, r3, r4);
        }

        public final String getAoiId() {
            return this.aoiId;
        }

        public final String getAoiName() {
            return this.aoiName;
        }

        public final String getAoiType() {
            return this.aoiType;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            d.h.b.o.e(r1, "parcel");
            r1.writeString(toJson());
        }

        public final String toJson() {
            String r1 = b.a().toJson(this);
            d.h.b.o.c(r1, "toJson(...)");
            return r1;
        }
    }

    /* JADX INFO: compiled from: LocationInfo.kt */
    public static final class CREATOR implements Parcelable.Creator<LocationInfo> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LocationInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LocationInfo[] newArray(int r1) {
            return newArray(r1);
        }

        public final LocationInfo fromJson(String r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            Object r2 = null;
            if (r1 == false) goto L26;
            return null;
        L26:
            n.a r3 = n.f38560a;     // Catch: Throwable -> L18
            CREATOR r5 = (CREATOR) ZeusTransformUtils.preCheckCast(this, CREATOR.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
            LocationInfo r6 = (LocationInfo) ZeusTransformUtils.preCheckCast(b.a().fromJson(r4, LocationInfo.class), LocationInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
            if (r6 == null) goto L15;
            LocationInfo r7 = LocationInfo.access$withCompatibleDefaults(r6);     // Catch: Throwable -> L18
        L16:
            Object r8 = n.f(r7);     // Catch: Throwable -> L18
        L21:
            if (n.b(r8) == true) goto L25;
            r2 = r8;
        L25:
            return (LocationInfo) ZeusTransformUtils.preCheckCast(r2, LocationInfo.class, "com.obric.aiagent.plugin");
        L15:
            r7 = null;
        L18:
            th = move-exception;
            n.a r9 = n.f38560a;
            r8 = n.f(o.a(th));
            goto L21
        L5:
            if (d.o.o.d(r0) == true) goto L8;
            r1 = false;
            goto L9
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationInfo createFromParcel(Parcel r7) {
            d.h.b.o.e(r7, "parcel");
            LocationInfo r6 = fromJson(r7.readString());
            if (r6 == null) goto L5;
            return r6;
        L5:
            return new LocationInfo(null, null, null, 7, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationInfo[] newArray(int r1) {
            return new LocationInfo[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public LocationInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ LocationInfo copy$default(LocationInfo r0, String r1, AoiInfo r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.locationType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.aoiInfo;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.updateSource;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public static final LocationInfo fromJson(String r1) {
        return CREATOR.fromJson(r1);
    }

    public final String component1() {
        return this.locationType;
    }

    public final AoiInfo component2() {
        return this.aoiInfo;
    }

    public final String component3() {
        return this.updateSource;
    }

    public final LocationInfo copy(String r1, AoiInfo r2, String r3) {
        d.h.b.o.e(r3, "updateSource");
        return new LocationInfo(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LocationInfo.class) == true) goto L8;
        return false;
    L8:
        LocationInfo r6 = (LocationInfo) ZeusTransformUtils.preCheckCast(r5, LocationInfo.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.locationType, r6.locationType) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.aoiInfo, r6.aoiInfo) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.updateSource, r6.updateSource) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.locationType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        AoiInfo r4 = this.aoiInfo;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + this.updateSource.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "LocationInfo(locationType=" + this.locationType + ", aoiInfo=" + this.aoiInfo + ", updateSource=" + this.updateSource + ')';
    }

    public LocationInfo(String r2, AoiInfo r3, String r4) {
        d.h.b.o.e(r4, "updateSource");
        this.locationType = r2;
        this.aoiInfo = r3;
        this.updateSource = r4;
    }

    public /* synthetic */ LocationInfo(String r2, AoiInfo r3, String r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }

    public static final /* synthetic */ LocationInfo access$withCompatibleDefaults(LocationInfo r0) {
        return r0.withCompatibleDefaults();
    }

    public final String getLocationType() {
        return this.locationType;
    }

    public final AoiInfo getAoiInfo() {
        return this.aoiInfo;
    }

    public final String getUpdateSource() {
        return this.updateSource;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        d.h.b.o.e(r1, "parcel");
        r1.writeString(toJson());
    }

    public final String toJson() {
        String r1 = b.a().toJson(this);
        d.h.b.o.c(r1, "toJson(...)");
        return r1;
    }

    private final LocationInfo withCompatibleDefaults() {
        String r1 = this.locationType;
        AoiInfo r2 = this.aoiInfo;
        if (r2 == null) goto L5;
        AoiInfo r3 = b.a(r2);
    L6:
        String r4 = this.updateSource;
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        return new LocationInfo(r1, r3, r4);
    L5:
        r3 = null;
        goto L6
    }
}
