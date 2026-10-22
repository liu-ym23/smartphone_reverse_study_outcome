package com.bytedance.ai.resource.core.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/ExtraInfo;", "", "deviceId", "", "lane", "channel", "appVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getLane", "getChannel", "getAppVersion", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtraInfo {
    private final String appVersion;
    private final String channel;
    private final String deviceId;
    private final String lane;

    public ExtraInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ExtraInfo copy$default(ExtraInfo r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.deviceId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.lane;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.channel;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.appVersion;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.lane;
    }

    public final String component3() {
        return this.channel;
    }

    public final String component4() {
        return this.appVersion;
    }

    public final ExtraInfo copy(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "deviceId");
        return new ExtraInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ExtraInfo) == true) goto L8;
        return false;
    L8:
        ExtraInfo r101 = (ExtraInfo) r100;
        if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lane, r101.lane) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.channel, r101.channel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appVersion, r101.appVersion) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.deviceId.hashCode() * 31;
        String r101 = this.lane;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.channel;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.appVersion;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ExtraInfo(deviceId=" + this.deviceId + ", lane=" + this.lane + ", channel=" + this.channel + ", appVersion=" + this.appVersion + ')';
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

    public final String getLane() {
        return this.lane;
    }

    public ExtraInfo(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "deviceId");
        this.deviceId = r100;
        this.lane = r101;
        this.channel = r102;
        this.appVersion = r103;
    }

    public /* synthetic */ ExtraInfo(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
