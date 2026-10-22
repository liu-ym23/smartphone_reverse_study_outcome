package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\b\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/b3;", "", "", "enable", "I", "getEnable", "()I", "executePeriod", "getExecutePeriod", "", "", "core", "Ljava/util/List;", "getCore", "()Ljava/util/List;", "Lcom/bytedance/android/gamecp/common/setting/config/b3$g;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "getStrategy", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "e", "f", ce.f26391f, "h", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b3 {

    @SerializedName("core")
    private final List<String> core;

    @SerializedName("enable")
    private final int enable;

    @SerializedName("period")
    private final int executePeriod;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private final List<g> strategy;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/b3$b;", "", "Lcom/bytedance/android/gamecp/common/setting/config/b3$f;", "performance", "Lcom/bytedance/android/gamecp/common/setting/config/b3$f;", "getPerformance", "()Lcom/bytedance/android/gamecp/common/setting/config/b3$f;", "Lcom/bytedance/android/gamecp/common/setting/config/b3$c;", "env", "Lcom/bytedance/android/gamecp/common/setting/config/b3$c;", "getEnv", "()Lcom/bytedance/android/gamecp/common/setting/config/b3$c;", "", "maxHitCount", "I", "getMaxHitCount", "()I", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("env")
        private final c env;

        @SerializedName("hit_count")
        private final int maxHitCount;

        @SerializedName("performance")
        private final f performance;

        public b() {
            this.maxHitCount = 3;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/b3$c;", "", "", "isWifi", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "Lcom/bytedance/android/gamecp/common/setting/config/b3$h;", "cpuUsage", "Lcom/bytedance/android/gamecp/common/setting/config/b3$h;", "getCpuUsage", "()Lcom/bytedance/android/gamecp/common/setting/config/b3$h;", Scraps.BATTERY, "getBattery", "memoryUsage", "getMemoryUsage", "netLevel", "getNetLevel", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName(Scraps.BATTERY)
        private final h battery;

        @SerializedName("cpu_usage")
        private final h cpuUsage;

        @SerializedName(ParamKeyConstants.WebViewConstants.IS_WIFI)
        private final Integer isWifi;

        @SerializedName("memory_usage")
        private final h memoryUsage;

        @SerializedName("net_level")
        private final h netLevel;

        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/b3$d;", "", "Lcom/bytedance/android/gamecp/common/setting/config/b3$h;", "lossRate", "Lcom/bytedance/android/gamecp/common/setting/config/b3$h;", "getLossRate", "()Lcom/bytedance/android/gamecp/common/setting/config/b3$h;", "rtt", "getRtt", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("loss_rate")
        private final h lossRate;

        @SerializedName("rtt")
        private final h rtt;

        public d() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/b3$e;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "", "direction", "I", "getDirection", "()I", "setDirection", "(I)V", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "getMin", "setMin", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "getMax", "setMax", "dlt", "getDlt", "setDlt", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class e {

        @SerializedName("direction")
        private int direction;

        @SerializedName("dlt")
        private int dlt;

        @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX)
        private int max;

        @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN)
        private int min;

        @SerializedName("type")
        private String type;

        public e() {
            this.type = "";
        }

        public final String getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/b3$f;", "", "Lcom/bytedance/android/gamecp/common/setting/config/b3$h;", "block", "Lcom/bytedance/android/gamecp/common/setting/config/b3$h;", "getBlock", "()Lcom/bytedance/android/gamecp/common/setting/config/b3$h;", "Lcom/bytedance/android/gamecp/common/setting/config/b3$d;", SRStrategy.KEY_ORIGIN_RESOLUTION, "Lcom/bytedance/android/gamecp/common/setting/config/b3$d;", "getOr", "()Lcom/bytedance/android/gamecp/common/setting/config/b3$d;", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class f {

        @SerializedName("block")
        private final h block;

        /* JADX INFO: renamed from: or, reason: collision with root package name */
        @SerializedName(SRStrategy.KEY_ORIGIN_RESOLUTION)
        private final d f56736or;

        public f() {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/b3$g;", "", "", "priority", "I", "getPriority", "()I", "", "strategyId", "J", "getStrategyId", "()J", ControlRule.KEY_STRATEGY_TYPE, "getStrategyType", "Lcom/bytedance/android/gamecp/common/setting/config/b3$b;", "condition", "Lcom/bytedance/android/gamecp/common/setting/config/b3$b;", "getCondition", "()Lcom/bytedance/android/gamecp/common/setting/config/b3$b;", "", "Lcom/bytedance/android/gamecp/common/setting/config/b3$e;", BdpAppEventConstant.PARAMS_OUTPUT, "Ljava/util/List;", "getOutput", "()Ljava/util/List;", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class g {

        @SerializedName("condition")
        private final b condition;

        @SerializedName(BdpAppEventConstant.PARAMS_OUTPUT)
        private final List<e> output;

        @SerializedName("priority")
        private final int priority;

        @SerializedName("strategy_Id")
        private final long strategyId;

        @SerializedName(GearStrategy.GEAR_STRATEGY_KEY_STRATEGY_TYPE)
        private final int strategyType;

        public g() {
            this.priority = 1;
            this.output = CollectionsKt.emptyList();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/b3$h;", "", "", OnekeyLoginConstants.CU_KEY_OPERATOR, "Ljava/lang/String;", "getOperator", "()Ljava/lang/String;", "", "value", "D", "getValue", "()D", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class h {

        @SerializedName(OnekeyLoginConstants.CU_KEY_OPERATOR)
        private final String operator;

        @SerializedName("value")
        private final double value;

        public h() {
            this.operator = "";
        }
    }

    static {
    }

    public b3() {
        this.core = CollectionsKt.emptyList();
        this.strategy = CollectionsKt.emptyList();
    }
}
