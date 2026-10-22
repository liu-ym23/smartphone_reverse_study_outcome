package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PersistentAwarenessModels.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GeoFenceRequest implements Parcelable {
    public static final Parcelable.Creator<GeoFenceRequest> CREATOR = null;
    private final String fenceId;
    private final double latitude;
    private final double longitude;
    private final int radius;

    /* JADX INFO: compiled from: PersistentAwarenessModels.kt */
    public static final class Creator implements Parcelable.Creator<GeoFenceRequest> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GeoFenceRequest createFromParcel(Parcel r8) {
            o.e(r8, "parcel");
            return new GeoFenceRequest(r8.readString(), r8.readDouble(), r8.readDouble(), r8.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GeoFenceRequest createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GeoFenceRequest[] newArray(int r1) {
            return new GeoFenceRequest[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GeoFenceRequest[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ GeoFenceRequest copy$default(GeoFenceRequest r4, String r5, double r6, double r8, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.fenceId;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.longitude;
    L8:
        double r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        r8 = r4.latitude;
    L11:
        double r2 = r8;
        if ((r11 & 8) == 0) goto L14;
        r10 = r4.radius;
    L14:
        String r7 = r5;
        return r4.copy(r7, r0, r2, r10);
    }

    public final String component1() {
        return this.fenceId;
    }

    public final double component2() {
        return this.longitude;
    }

    public final double component3() {
        return this.latitude;
    }

    public final int component4() {
        return this.radius;
    }

    public final GeoFenceRequest copy(String r8, double r9, double r11, int r13) {
        o.e(r8, "fenceId");
        return new GeoFenceRequest(r8, r9, r11, r13);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, GeoFenceRequest.class) == true) goto L8;
        return false;
    L8:
        GeoFenceRequest r10 = (GeoFenceRequest) ZeusTransformUtils.preCheckCast(r9, GeoFenceRequest.class, "com.obric.aiagent.plugin");
        if (o.a(this.fenceId, r10.fenceId) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.longitude, r10.longitude) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.latitude, r10.latitude) == 0) goto L18;
        return false;
    L18:
        if (this.radius == r10.radius) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.fenceId.hashCode() * 31) + Double.hashCode(this.longitude)) * 31) + Double.hashCode(this.latitude)) * 31) + Integer.hashCode(this.radius);
    }

    public String toString() {
        return "GeoFenceRequest(fenceId=" + this.fenceId + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", radius=" + this.radius + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        r3.writeString(this.fenceId);
        r3.writeDouble(this.longitude);
        r3.writeDouble(this.latitude);
        r3.writeInt(this.radius);
    }

    public GeoFenceRequest(String r2, double r3, double r5, int r7) {
        o.e(r2, "fenceId");
        this.fenceId = r2;
        this.longitude = r3;
        this.latitude = r5;
        this.radius = r7;
    }

    public final String getFenceId() {
        return this.fenceId;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final int getRadius() {
        return this.radius;
    }
}
