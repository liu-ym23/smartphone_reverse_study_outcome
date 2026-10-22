package com.obric.eventkit.task.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ConditionTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class WifiCondition implements Parcelable, Condition {
    public static final Parcelable.Creator<WifiCondition> CREATOR = null;
    private final String bssid;
    private final String ssid;

    /* JADX INFO: compiled from: ConditionTask.kt */
    public static final class Creator implements Parcelable.Creator<WifiCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WifiCondition createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            return new WifiCondition(r2.readString(), r2.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WifiCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WifiCondition[] newArray(int r1) {
            return new WifiCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WifiCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ WifiCondition copy$default(WifiCondition r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.ssid;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.bssid;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.ssid;
    }

    public final String component2() {
        return this.bssid;
    }

    public final WifiCondition copy(String r1, String r2) {
        o.e(r1, "ssid");
        return new WifiCondition(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, WifiCondition.class) == true) goto L8;
        return false;
    L8:
        WifiCondition r6 = (WifiCondition) ZeusTransformUtils.preCheckCast(r5, WifiCondition.class, "com.obric.aiagent.plugin");
        if (o.a(this.ssid, r6.ssid) == true) goto L12;
        return false;
    L12:
        if (o.a(this.bssid, r6.bssid) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.ssid.hashCode() * 31;
        String r1 = this.bssid;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "WifiCondition(ssid=" + this.ssid + ", bssid=" + this.bssid + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(this.ssid);
        r1.writeString(this.bssid);
    }

    public WifiCondition(String r2, String r3) {
        o.e(r2, "ssid");
        this.ssid = r2;
        this.bssid = r3;
    }

    public /* synthetic */ WifiCondition(String r1, String r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final String getSsid() {
        return this.ssid;
    }

    public final String getBssid() {
        return this.bssid;
    }
}
