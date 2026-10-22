package com.bytedance.ai.bridge.accountInfo;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/accountInfo/AbsGetAccountInfoMethodIDL$MiniProgramAccountInfo;", "", "appId", "", "envVersion", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getEnvVersion", "getVersion", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AbsGetAccountInfoMethodIDL$MiniProgramAccountInfo {

    @SerializedName("appId")
    private final String appId;

    @SerializedName("envVersion")
    private final String envVersion;

    @SerializedName("version")
    private final String version;

    public static /* synthetic */ AbsGetAccountInfoMethodIDL$MiniProgramAccountInfo copy$default(AbsGetAccountInfoMethodIDL$MiniProgramAccountInfo r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.appId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.envVersion;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.version;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.envVersion;
    }

    public final String component3() {
        return this.version;
    }

    public final AbsGetAccountInfoMethodIDL$MiniProgramAccountInfo copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "envVersion");
        Intrinsics.checkNotNullParameter(r102, "version");
        return new AbsGetAccountInfoMethodIDL$MiniProgramAccountInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AbsGetAccountInfoMethodIDL$MiniProgramAccountInfo) == true) goto L8;
        return false;
    L8:
        AbsGetAccountInfoMethodIDL$MiniProgramAccountInfo r101 = (AbsGetAccountInfoMethodIDL$MiniProgramAccountInfo) r100;
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.envVersion, r101.envVersion) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.appId.hashCode() * 31) + this.envVersion.hashCode()) * 31) + this.version.hashCode();
    }

    public String toString() {
        return "MiniProgramAccountInfo(appId=" + this.appId + ", envVersion=" + this.envVersion + ", version=" + this.version + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getEnvVersion() {
        return this.envVersion;
    }

    public final String getVersion() {
        return this.version;
    }

    public AbsGetAccountInfoMethodIDL$MiniProgramAccountInfo(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "envVersion");
        Intrinsics.checkNotNullParameter(r102, "version");
        this.appId = r100;
        this.envVersion = r101;
        this.version = r102;
    }
}
