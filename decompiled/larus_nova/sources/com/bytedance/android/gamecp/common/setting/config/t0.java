package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/t0;", "", "", "enable", "Z", "b", "()Z", "", "quicABTest", "I", "c", "()I", "", "domain", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t0 {

    @SerializedName("download_quic_domain")
    private final String domain;

    @SerializedName("download_quic_enable")
    private final boolean enable;

    @SerializedName("download_quic_abtest")
    private final int quicABTest;

    public t0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t0) == false) goto L12;
        t0 r101 = (t0) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.quicABTest == r101.quicABTest) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.domain, r101.domain) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((r101 * 31) + this.quicABTest) * 31;
        String r103 = this.domain;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "DownloadQuicConfig(enable=" + this.enable + ", quicABTest=" + this.quicABTest + ", domain=" + this.domain + ")";
    }

    public final String a() {
        return this.domain;
    }

    public final boolean b() {
        return this.enable;
    }

    public final int c() {
        return this.quicABTest;
    }

    public t0(int r100) {
        Intrinsics.checkNotNullParameter("lf3-apk-channel.bytesmanager.com", "domain");
        this.enable = false;
        this.quicABTest = 0;
        this.domain = "lf3-apk-channel.bytesmanager.com";
    }
}
