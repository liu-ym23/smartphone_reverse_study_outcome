package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.android.SystemUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/r;", "", "", "singleIconScSchema", "Ljava/lang/String;", "getSingleIconScSchema", "()Ljava/lang/String;", "", "retryAddInterval", "J", "getRetryAddInterval", "()J", "checkPermissionFailDuration", "getCheckPermissionFailDuration", "checkShortcutResultDelay", "getCheckShortcutResultDelay", "", "", "shortcutResultStrategy", "Ljava/util/Map;", "getShortcutResultStrategy", "()Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("check_permission_fail_duration")
    private final long checkPermissionFailDuration;

    @SerializedName("check_shortcut_result_delay")
    private final long checkShortcutResultDelay;

    @SerializedName("retry_add_interval")
    private final long retryAddInterval;

    @SerializedName("shortcut_result_strategy")
    private final Map<String, Integer> shortcutResultStrategy;

    @SerializedName("single_icon_sc_schema")
    private final String singleIconScSchema;

    public static final class a {
    }

    static {
    }

    public r() {
        Map<String, Integer> r100 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(SystemUtils.PRODUCT_HUAWEI, 1)});
        this.singleIconScSchema = null;
        this.retryAddInterval = 30000;
        this.checkPermissionFailDuration = 750;
        this.checkShortcutResultDelay = 100;
        this.shortcutResultStrategy = r100;
    }
}
