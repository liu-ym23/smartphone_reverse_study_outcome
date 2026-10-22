package com.obric.capabilitykit.common;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class VersionInfo {

    @SerializedName("Version")
    private final int version;

    public VersionInfo(int r1) {
        this.version = r1;
    }

    public static /* synthetic */ VersionInfo copy$default(VersionInfo r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.version;
    L6:
        return r0.copy(r1);
    }

    public final int component1() {
        return this.version;
    }

    public final VersionInfo copy(int r1) {
        return new VersionInfo(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, VersionInfo.class) == true) goto L8;
        return false;
    L8:
        VersionInfo r6 = (VersionInfo) ZeusTransformUtils.preCheckCast(r5, VersionInfo.class, "com.obric.aiagent.plugin");
        if (this.version == r6.version) goto L11;
        return false;
    L11:
        return true;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return Integer.hashCode(this.version);
    }

    public String toString() {
        return "VersionInfo(version=" + this.version + ')';
    }
}
