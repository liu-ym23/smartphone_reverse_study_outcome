package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/e1;", "", "", "midwayPromoteForbid", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "previousPromoteForbid", "b", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e1 {

    @SerializedName("midway_promote_forbid")
    private final boolean midwayPromoteForbid;

    @SerializedName("previous_promote_forbid")
    private final boolean previousPromoteForbid;

    public e1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e1) == false) goto L10;
        e1 r101 = (e1) r100;
        if (this.midwayPromoteForbid == r101.midwayPromoteForbid) goto L8;
        return false;
    L8:
        if (this.previousPromoteForbid == r101.previousPromoteForbid) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.midwayPromoteForbid;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.previousPromoteForbid;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public final String toString() {
        return "GameCpEntranceForbidConfig(midwayPromoteForbid=" + this.midwayPromoteForbid + ", previousPromoteForbid=" + this.previousPromoteForbid + ")";
    }

    public final boolean a() {
        return this.midwayPromoteForbid;
    }

    public final boolean b() {
        return this.previousPromoteForbid;
    }

    public e1(int r100) {
        this.midwayPromoteForbid = false;
        this.previousPromoteForbid = false;
    }
}
