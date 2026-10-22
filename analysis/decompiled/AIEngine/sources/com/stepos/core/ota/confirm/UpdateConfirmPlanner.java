package com.stepos.core.ota.confirm;

import android.content.Context;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.confirm.DownloadConfirmPlanner;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;
import sb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class UpdateConfirmPlanner {
    public static final UpdateConfirmPlanner INSTANCE = new UpdateConfirmPlanner();
    private static final String TAG = "UpdateConfirmPlanner";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Input {
        private final DownloadConfirmPlanner.Plan basePlan;
        private final boolean wifiAutoUpdate;

        public Input(DownloadConfirmPlanner.Plan basePlan, boolean z) {
            g.f(basePlan, "basePlan");
            this.basePlan = basePlan;
            this.wifiAutoUpdate = z;
        }

        public static /* synthetic */ Input copy$default(Input input, DownloadConfirmPlanner.Plan plan, boolean z, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                plan = input.basePlan;
            }
            if ((i10 & 2) != 0) {
                z = input.wifiAutoUpdate;
            }
            return input.copy(plan, z);
        }

        public final DownloadConfirmPlanner.Plan component1() {
            return this.basePlan;
        }

        public final boolean component2() {
            return this.wifiAutoUpdate;
        }

        public final Input copy(DownloadConfirmPlanner.Plan basePlan, boolean z) {
            g.f(basePlan, "basePlan");
            return new Input(basePlan, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Input)) {
                return false;
            }
            Input input = (Input) obj;
            return this.basePlan == input.basePlan && this.wifiAutoUpdate == input.wifiAutoUpdate;
        }

        public final DownloadConfirmPlanner.Plan getBasePlan() {
            return this.basePlan;
        }

        public final boolean getWifiAutoUpdate() {
            return this.wifiAutoUpdate;
        }

        public int hashCode() {
            return Boolean.hashCode(this.wifiAutoUpdate) + (this.basePlan.hashCode() * 31);
        }

        public String toString() {
            return "Input(basePlan=" + this.basePlan + ", wifiAutoUpdate=" + this.wifiAutoUpdate + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class UpdatePlan {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ UpdatePlan[] $VALUES;
        public static final UpdatePlan NO_NETWORK = new UpdatePlan(ModelFlowMeta.PLAN_NO_NETWORK, 0);
        public static final UpdatePlan CELLULAR_AUTO_OFF = new UpdatePlan("CELLULAR_AUTO_OFF", 1);
        public static final UpdatePlan CELLULAR_AUTO_ON = new UpdatePlan("CELLULAR_AUTO_ON", 2);
        public static final UpdatePlan WIFI_AUTO_OFF = new UpdatePlan("WIFI_AUTO_OFF", 3);
        public static final UpdatePlan WIFI_AUTO_ON = new UpdatePlan("WIFI_AUTO_ON", 4);

        private static final /* synthetic */ UpdatePlan[] $values() {
            return new UpdatePlan[]{NO_NETWORK, CELLULAR_AUTO_OFF, CELLULAR_AUTO_ON, WIFI_AUTO_OFF, WIFI_AUTO_ON};
        }

        static {
            UpdatePlan[] updatePlanArr$values = $values();
            $VALUES = updatePlanArr$values;
            $ENTRIES = kotlin.enums.a.a(updatePlanArr$values);
        }

        private UpdatePlan(String str, int i10) {
        }

        public static a<UpdatePlan> getEntries() {
            return $ENTRIES;
        }

        public static UpdatePlan valueOf(String str) {
            return (UpdatePlan) Enum.valueOf(UpdatePlan.class, str);
        }

        public static UpdatePlan[] values() {
            return (UpdatePlan[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DownloadConfirmPlanner.Plan.values().length];
            try {
                iArr[DownloadConfirmPlanner.Plan.NO_NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DownloadConfirmPlanner.Plan.CONFIRM_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DownloadConfirmPlanner.Plan.CONFIRM_THEN_CELLULAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private UpdateConfirmPlanner() {
    }

    public final UpdatePlan plan(Input input) {
        g.f(input, "input");
        int i10 = WhenMappings.$EnumSwitchMapping$0[input.getBasePlan().ordinal()];
        if (i10 == 1) {
            return UpdatePlan.NO_NETWORK;
        }
        if (i10 == 2) {
            return input.getWifiAutoUpdate() ? UpdatePlan.WIFI_AUTO_ON : UpdatePlan.WIFI_AUTO_OFF;
        }
        if (i10 == 3) {
            return input.getWifiAutoUpdate() ? UpdatePlan.CELLULAR_AUTO_ON : UpdatePlan.CELLULAR_AUTO_OFF;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final UpdatePlan planFor(Context context) {
        g.f(context, "context");
        DownloadConfirmPlanner.Plan planPlanFor = DownloadConfirmPlanner.INSTANCE.planFor(context);
        boolean zIsWlanAutoUpgradeEnabled = CTAPermissionManager.INSTANCE.isWlanAutoUpgradeEnabled();
        UpdatePlan updatePlanPlan = plan(new Input(planPlanFor, zIsWlanAutoUpgradeEnabled));
        AIEngineLogger.i(LogModule.OTA, TAG, "planFor: basePlan=" + planPlanFor + " wifiAuto=" + zIsWlanAutoUpgradeEnabled + " -> " + updatePlanPlan);
        return updatePlanPlan;
    }
}
