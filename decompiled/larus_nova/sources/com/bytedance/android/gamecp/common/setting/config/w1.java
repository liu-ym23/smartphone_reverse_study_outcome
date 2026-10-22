package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/w1;", "", "", "delayTime", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "enable", "Z", "b", "()Z", "singleInstanceEnable", ce.f26391f, "reuseEnable", "f", "forceUpdateGecko", "d", "loadStrategy", "e", "exitOpt", "c", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w1 {

    @SerializedName("delay_time")
    private final int delayTime;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("exit_opt")
    private final boolean exitOpt;

    @SerializedName("force_update_gecko")
    private final boolean forceUpdateGecko;

    @SerializedName("load_strategy")
    private final int loadStrategy;

    @SerializedName("reuse_enable")
    private final boolean reuseEnable;

    @SerializedName("single_instance_enable")
    private final boolean singleInstanceEnable;

    public w1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof w1) == false) goto L20;
        w1 r101 = (w1) r100;
        if (this.delayTime == r101.delayTime) goto L8;
        return false;
    L8:
        if (this.enable == r101.enable) goto L10;
        return false;
    L10:
        if (this.singleInstanceEnable == r101.singleInstanceEnable) goto L12;
        return false;
    L12:
        if (this.reuseEnable == r101.reuseEnable) goto L14;
        return false;
    L14:
        if (this.forceUpdateGecko == r101.forceUpdateGecko) goto L16;
        return false;
    L16:
        if (this.loadStrategy == r101.loadStrategy) goto L18;
        return false;
    L18:
        if (this.exitOpt == r101.exitOpt) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = this.delayTime * 31;
        boolean r101 = this.enable;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.singleInstanceEnable;
        ?? r106 = r105;
        if (r105 == false) goto L8;
        r106 = 1;
    L8:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.reuseEnable;
        ?? r109 = r108;
        if (r108 == false) goto L11;
        r109 = 1;
    L11:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.forceUpdateGecko;
        ?? r112 = r111;
        if (r111 == false) goto L14;
        r112 = 1;
    L14:
        int r113 = (((r110 + r112) * 31) + this.loadStrategy) * 31;
        boolean r114 = this.exitOpt;
        if (r114 == true) goto L19;
        r102 = r114;
    L19:
        return r113 + r102;
    }

    public final String toString() {
        return "GamePromotePreLoadLynxConfig(delayTime=" + this.delayTime + ", enable=" + this.enable + ", singleInstanceEnable=" + this.singleInstanceEnable + ", reuseEnable=" + this.reuseEnable + ", forceUpdateGecko=" + this.forceUpdateGecko + ", loadStrategy=" + this.loadStrategy + ", exitOpt=" + this.exitOpt + ")";
    }

    public final int a() {
        return this.delayTime;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean c() {
        return this.exitOpt;
    }

    public final boolean d() {
        return this.forceUpdateGecko;
    }

    public final int e() {
        return this.loadStrategy;
    }

    public final boolean f() {
        return this.reuseEnable;
    }

    public final boolean g() {
        return this.singleInstanceEnable;
    }

    public w1(int r100) {
        this.delayTime = 3;
        this.enable = true;
        this.singleInstanceEnable = false;
        this.reuseEnable = true;
        this.forceUpdateGecko = true;
        this.loadStrategy = 0;
        this.exitOpt = false;
    }
}
