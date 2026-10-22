package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/j1;", "", "", "enable", "Z", "b", "()Z", "", "Lcom/bytedance/android/gamecp/common/setting/config/q0;", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j1 {

    @SerializedName("recovery_config")
    private final List<q0> configs;

    @SerializedName("enable")
    private final boolean enable;

    public j1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j1) == false) goto L10;
        j1 r101 = (j1) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.configs, r101.configs) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        List<q0> r103 = this.configs;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "GameDownloadRecoveryConfig(enable=" + this.enable + ", configs=" + this.configs + ")";
    }

    public final List<q0> a() {
        return this.configs;
    }

    public final boolean b() {
        return this.enable;
    }

    public j1(Object r100) {
        ArrayList r101 = new ArrayList();
        this.enable = true;
        this.configs = r101;
    }
}
