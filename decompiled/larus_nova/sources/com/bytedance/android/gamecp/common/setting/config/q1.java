package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/q1;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "gameDetailIntroImageCountHorizontal", "I", "b", "()I", "gameDetailIntroImageCountVertical", "c", "", "", "Lcom/bytedance/android/gamecp/common/setting/config/r1;", "itemConfigs", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q1 {

    @SerializedName("icon_enable")
    private final boolean enable;

    @SerializedName("detail_image_horizontal_count")
    private final int gameDetailIntroImageCountHorizontal;

    @SerializedName("detail_image_vertical_count")
    private final int gameDetailIntroImageCountVertical;

    @SerializedName("item_configs")
    private final Map<String, r1> itemConfigs;

    public q1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q1) == false) goto L14;
        q1 r101 = (q1) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.gameDetailIntroImageCountHorizontal == r101.gameDetailIntroImageCountHorizontal) goto L10;
        return false;
    L10:
        if (this.gameDetailIntroImageCountVertical == r101.gameDetailIntroImageCountVertical) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemConfigs, r101.itemConfigs) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((((r101 * 31) + this.gameDetailIntroImageCountHorizontal) * 31) + this.gameDetailIntroImageCountVertical) * 31;
        Map<String, r1> r103 = this.itemConfigs;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "GamePromoteIconPreloadConfig(enable=" + this.enable + ", gameDetailIntroImageCountHorizontal=" + this.gameDetailIntroImageCountHorizontal + ", gameDetailIntroImageCountVertical=" + this.gameDetailIntroImageCountVertical + ", itemConfigs=" + this.itemConfigs + ")";
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.gameDetailIntroImageCountHorizontal;
    }

    public final int c() {
        return this.gameDetailIntroImageCountVertical;
    }

    public final Map<String, r1> d() {
        return this.itemConfigs;
    }

    public q1(Object r100) {
        this.enable = false;
        this.gameDetailIntroImageCountHorizontal = 0;
        this.gameDetailIntroImageCountVertical = 0;
        this.itemConfigs = null;
    }
}
