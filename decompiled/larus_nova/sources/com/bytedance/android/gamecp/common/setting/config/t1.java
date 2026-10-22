package com.bytedance.android.gamecp.common.setting.config;

import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/t1;", "", "", "lynxUrl", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "Lcom/bytedance/android/gamecp/common/setting/config/t2;", "settingKeys", "Ljava/util/List;", "b", "()Ljava/util/List;", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t1 {

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String lynxUrl;

    @SerializedName("setting_keys")
    private final List<t2> settingKeys;

    public t1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t1) == false) goto L10;
        t1 r101 = (t1) r100;
        if (Intrinsics.areEqual(this.lynxUrl, r101.lynxUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.settingKeys, r101.settingKeys) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.lynxUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<t2> r104 = this.settingKeys;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GamePromoteLynxConfig(lynxUrl=" + this.lynxUrl + ", settingKeys=" + this.settingKeys + ")";
    }

    public final String a() {
        return this.lynxUrl;
    }

    public final List<t2> b() {
        return this.settingKeys;
    }

    public t1(Object r100) {
        ArrayList r101 = new ArrayList();
        this.lynxUrl = null;
        this.settingKeys = r101;
    }
}
