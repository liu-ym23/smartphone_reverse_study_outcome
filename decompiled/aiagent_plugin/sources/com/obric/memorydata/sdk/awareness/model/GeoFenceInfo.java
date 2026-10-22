package com.obric.memorydata.sdk.awareness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.n;
import d.o;

/* JADX INFO: compiled from: GeoFenceInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GeoFenceInfo implements Parcelable {
    public static final CREATOR CREATOR = null;

    @SerializedName("fence_id")
    private final String fenceId;

    /* JADX INFO: compiled from: GeoFenceInfo.kt */
    public static final class CREATOR implements Parcelable.Creator<GeoFenceInfo> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GeoFenceInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GeoFenceInfo[] newArray(int r1) {
            return newArray(r1);
        }

        public final GeoFenceInfo fromJson(String r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            Object r2 = null;
            if (r1 == false) goto L29;
            return null;
        L29:
            n.a r3 = n.f38560a;     // Catch: Throwable -> L21
            CREATOR r5 = (CREATOR) ZeusTransformUtils.preCheckCast(this, CREATOR.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
            GeoFenceInfo r6 = (GeoFenceInfo) ZeusTransformUtils.preCheckCast(a.a().fromJson(r4, GeoFenceInfo.class), GeoFenceInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
            if (r6 != null) goto L15;
            GeoFenceInfo r7 = null;
        L19:
            Object r8 = n.f(r7);     // Catch: Throwable -> L21
        L24:
            if (n.b(r8) == true) goto L28;
            r2 = r8;
        L28:
            return (GeoFenceInfo) ZeusTransformUtils.preCheckCast(r2, GeoFenceInfo.class, "com.obric.aiagent.plugin");
        L15:
            String r9 = r6.getFenceId();     // Catch: Throwable -> L21
            if (r9 != null) goto L18;
            r9 = "";
        L18:
            r7 = new GeoFenceInfo(r9);     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            n.a r10 = n.f38560a;
            r8 = n.f(o.a(th));
            goto L24
        L5:
            if (d.o.o.d(r0) == true) goto L8;
            r1 = false;
            goto L9
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        public GeoFenceInfo createFromParcel(Parcel r2) {
            d.h.b.o.e(r2, "parcel");
            GeoFenceInfo r1 = fromJson(r2.readString());
            if (r1 != null) goto L6;
            String r0 = null;
            return new GeoFenceInfo(r0, 1, 0 == true ? 1 : 0);
        L6:
            return r1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeoFenceInfo[] newArray(int r1) {
            return new GeoFenceInfo[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GeoFenceInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ GeoFenceInfo copy$default(GeoFenceInfo r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.fenceId;
    L6:
        return r0.copy(r1);
    }

    public static final GeoFenceInfo fromJson(String r1) {
        return CREATOR.fromJson(r1);
    }

    public final String component1() {
        return this.fenceId;
    }

    public final GeoFenceInfo copy(String r1) {
        d.h.b.o.e(r1, "fenceId");
        return new GeoFenceInfo(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GeoFenceInfo.class) == true) goto L8;
        return false;
    L8:
        GeoFenceInfo r6 = (GeoFenceInfo) ZeusTransformUtils.preCheckCast(r5, GeoFenceInfo.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.fenceId, r6.fenceId) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.fenceId.hashCode();
    }

    public String toString() {
        return "GeoFenceInfo(fenceId=" + this.fenceId + ')';
    }

    public GeoFenceInfo(String r2) {
        d.h.b.o.e(r2, "fenceId");
        this.fenceId = r2;
    }

    public /* synthetic */ GeoFenceInfo(String r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }

    public final String getFenceId() {
        return this.fenceId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        d.h.b.o.e(r1, "parcel");
        r1.writeString(toJson());
    }

    public final String toJson() {
        String r1 = a.a().toJson(this);
        d.h.b.o.c(r1, "toJson(...)");
        return r1;
    }
}
