package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OLocationInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OLocationInfo implements Parcelable {
    public static final Parcelable.Creator<OLocationInfo> CREATOR = null;
    private final double latitude;
    private final double longitude;

    /* JADX INFO: compiled from: OLocationInfo.kt */
    public static final class Creator implements Parcelable.Creator<OLocationInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OLocationInfo createFromParcel(Parcel r5) {
            o.e(r5, "parcel");
            return new OLocationInfo(r5.readDouble(), r5.readDouble());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OLocationInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OLocationInfo[] newArray(int r1) {
            return new OLocationInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OLocationInfo[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ OLocationInfo copy$default(OLocationInfo r0, double r1, double r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.longitude;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.latitude;
    L9:
        return r0.copy(r1, r3);
    }

    public final double component1() {
        return this.longitude;
    }

    public final double component2() {
        return this.latitude;
    }

    public final OLocationInfo copy(double r1, double r3) {
        return new OLocationInfo(r1, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, OLocationInfo.class) == true) goto L8;
        return false;
    L8:
        OLocationInfo r10 = (OLocationInfo) ZeusTransformUtils.preCheckCast(r9, OLocationInfo.class, "com.obric.aiagent.plugin");
        if (Double.compare(this.longitude, r10.longitude) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.latitude, r10.latitude) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Double.hashCode(this.longitude) * 31) + Double.hashCode(this.latitude);
    }

    public String toString() {
        return "OLocationInfo(longitude=" + this.longitude + ", latitude=" + this.latitude + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        r3.writeDouble(this.longitude);
        r3.writeDouble(this.latitude);
    }

    public OLocationInfo(double r1, double r3) {
        this.longitude = r1;
        this.latitude = r3;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final double getLatitude() {
        return this.latitude;
    }
}
