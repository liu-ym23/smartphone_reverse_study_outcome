package com.bytedance.android.live.broadcastgame.api.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/g;", "", "Lcom/bytedance/android/live/broadcastgame/api/model/q0;", "xplayInfo", "Lcom/bytedance/android/live/broadcastgame/api/model/q0;", "b", "()Lcom/bytedance/android/live/broadcastgame/api/model/q0;", "", "version", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "isDebugUnity", "Z", "c", "()Z", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("is_debug_unity")
    private final boolean isDebugUnity;

    @SerializedName("version")
    private final String version;

    @SerializedName("xplay_info")
    private final q0 xplayInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.xplayInfo, r101.xplayInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L10;
        return false;
    L10:
        if (this.isDebugUnity == r101.isDebugUnity) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        q0 r100 = this.xplayInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.version;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.isDebugUnity;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameEngineInfo(xplayInfo=" + this.xplayInfo + ", version=" + this.version + ", isDebugUnity=" + this.isDebugUnity + ")";
    }

    public g() {
        this.xplayInfo = null;
        this.version = null;
        this.isDebugUnity = false;
    }

    public final String a() {
        return this.version;
    }

    public final q0 b() {
        return this.xplayInfo;
    }

    public final boolean c() {
        return this.isDebugUnity;
    }
}
