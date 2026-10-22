package com.obric.aiagent.os.libs;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: NetworkStateInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NetworkCapability {

    @SerializedName("bssid")
    private final String bssid;

    @SerializedName("freq")
    private final Integer freq;

    @SerializedName("linkspeed")
    private final Integer linkSpeed;

    @SerializedName("rssi")
    private final Integer rssi;

    @SerializedName("rxLinkspeed")
    private final Integer rxLinkSpeed;

    @SerializedName("ssid")
    private final String ssid;

    public NetworkCapability() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ NetworkCapability copy$default(NetworkCapability r4, String r5, String r6, Integer r7, Integer r8, Integer r9, Integer r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.ssid;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.bssid;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.freq;
    L11:
        Integer r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.rssi;
    L14:
        Integer r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.linkSpeed;
    L17:
        Integer r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.rxLinkSpeed;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.ssid;
    }

    public final String component2() {
        return this.bssid;
    }

    public final Integer component3() {
        return this.freq;
    }

    public final Integer component4() {
        return this.rssi;
    }

    public final Integer component5() {
        return this.linkSpeed;
    }

    public final Integer component6() {
        return this.rxLinkSpeed;
    }

    public final NetworkCapability copy(String r8, String r9, Integer r10, Integer r11, Integer r12, Integer r13) {
        return new NetworkCapability(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, NetworkCapability.class) == true) goto L8;
        return false;
    L8:
        NetworkCapability r6 = (NetworkCapability) ZeusTransformUtils.preCheckCast(r5, NetworkCapability.class, "com.obric.aiagent.plugin");
        if (o.a(this.ssid, r6.ssid) == true) goto L12;
        return false;
    L12:
        if (o.a(this.bssid, r6.bssid) == true) goto L15;
        return false;
    L15:
        if (o.a(this.freq, r6.freq) == true) goto L18;
        return false;
    L18:
        if (o.a(this.rssi, r6.rssi) == true) goto L21;
        return false;
    L21:
        if (o.a(this.linkSpeed, r6.linkSpeed) == true) goto L24;
        return false;
    L24:
        if (o.a(this.rxLinkSpeed, r6.rxLinkSpeed) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.ssid;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.bssid;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.freq;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.rssi;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.linkSpeed;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.rxLinkSpeed;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "NetworkCapability(ssid=" + this.ssid + ", bssid=" + this.bssid + ", freq=" + this.freq + ", rssi=" + this.rssi + ", linkSpeed=" + this.linkSpeed + ", rxLinkSpeed=" + this.rxLinkSpeed + ')';
    }

    public NetworkCapability(String r1, String r2, Integer r3, Integer r4, Integer r5, Integer r6) {
        this.ssid = r1;
        this.bssid = r2;
        this.freq = r3;
        this.rssi = r4;
        this.linkSpeed = r5;
        this.rxLinkSpeed = r6;
    }

    public /* synthetic */ NetworkCapability(String r2, String r3, Integer r4, Integer r5, Integer r6, Integer r7, int r8, h r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = null;
    L20:
        this(r2, r3, r4, r5, r6, r7);
    }

    public final String getSsid() {
        return this.ssid;
    }

    public final String getBssid() {
        return this.bssid;
    }

    public final Integer getFreq() {
        return this.freq;
    }

    public final Integer getRssi() {
        return this.rssi;
    }

    public final Integer getLinkSpeed() {
        return this.linkSpeed;
    }

    public final Integer getRxLinkSpeed() {
        return this.rxLinkSpeed;
    }
}
