package com.bytedance.android.live.saas.middleware.monitor.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/monitor/config/OutContextInfo;", "", "aid", "", "deviceId", "", "appVersion", "channel", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAid", "()I", "setAid", "(I)V", "getAppVersion", "()Ljava/lang/String;", "setAppVersion", "(Ljava/lang/String;)V", "getChannel", "setChannel", "getDeviceId", "setDeviceId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class OutContextInfo {
    private int aid;
    private String appVersion;
    private String channel;
    private String deviceId;

    public static /* synthetic */ OutContextInfo copy$default(OutContextInfo r100, int r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.aid;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.deviceId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.appVersion;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.channel;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.aid;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final String component3() {
        return this.appVersion;
    }

    public final String component4() {
        return this.channel;
    }

    public final OutContextInfo copy(int r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "deviceId");
        Intrinsics.checkNotNullParameter(r102, "appVersion");
        Intrinsics.checkNotNullParameter(r103, "channel");
        return new OutContextInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OutContextInfo) == false) goto L14;
        OutContextInfo r101 = (OutContextInfo) r100;
        if (this.aid == r101.aid) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.appVersion, r101.appVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.channel, r101.channel) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r100 = this.aid * 31;
        String r101 = this.deviceId;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.appVersion;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.channel;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "OutContextInfo(aid=" + this.aid + ", deviceId=" + this.deviceId + ", appVersion=" + this.appVersion + ", channel=" + this.channel + ")";
    }

    public final int getAid() {
        return this.aid;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setAid(int r100) {
        this.aid = r100;
    }

    public final void setAppVersion(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.appVersion = r100;
    }

    public final void setChannel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.channel = r100;
    }

    public final void setDeviceId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deviceId = r100;
    }

    public OutContextInfo(int r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "deviceId");
        Intrinsics.checkNotNullParameter(r102, "appVersion");
        Intrinsics.checkNotNullParameter(r103, "channel");
        this.aid = r100;
        this.deviceId = r101;
        this.appVersion = r102;
        this.channel = r103;
    }

    public /* synthetic */ OutContextInfo(int r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = "";
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = "";
    L11:
        this(r100, r101, r102, r103);
    }
}
