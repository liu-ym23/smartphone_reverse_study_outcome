package com.stepos.core.ota.confirm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.download.ModelFlowMeta;
import kotlin.jvm.internal.g;
import sb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadConfirmPlanner {
    public static final DownloadConfirmPlanner INSTANCE = new DownloadConfirmPlanner();
    private static final String TAG = "DlConfirmPlanner";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Input {
        private final boolean hasNetwork;
        private final boolean isWifi;

        public Input(boolean z, boolean z3) {
            this.hasNetwork = z;
            this.isWifi = z3;
        }

        public static /* synthetic */ Input copy$default(Input input, boolean z, boolean z3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z = input.hasNetwork;
            }
            if ((i10 & 2) != 0) {
                z3 = input.isWifi;
            }
            return input.copy(z, z3);
        }

        public final boolean component1() {
            return this.hasNetwork;
        }

        public final boolean component2() {
            return this.isWifi;
        }

        public final Input copy(boolean z, boolean z3) {
            return new Input(z, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Input)) {
                return false;
            }
            Input input = (Input) obj;
            return this.hasNetwork == input.hasNetwork && this.isWifi == input.isWifi;
        }

        public final boolean getHasNetwork() {
            return this.hasNetwork;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isWifi) + (Boolean.hashCode(this.hasNetwork) * 31);
        }

        public final boolean isWifi() {
            return this.isWifi;
        }

        public String toString() {
            return "Input(hasNetwork=" + this.hasNetwork + ", isWifi=" + this.isWifi + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Plan {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ Plan[] $VALUES;
        public static final Plan NO_NETWORK = new Plan(ModelFlowMeta.PLAN_NO_NETWORK, 0);
        public static final Plan CONFIRM_ONLY = new Plan("CONFIRM_ONLY", 1);
        public static final Plan CONFIRM_THEN_CELLULAR = new Plan("CONFIRM_THEN_CELLULAR", 2);

        private static final /* synthetic */ Plan[] $values() {
            return new Plan[]{NO_NETWORK, CONFIRM_ONLY, CONFIRM_THEN_CELLULAR};
        }

        static {
            Plan[] planArr$values = $values();
            $VALUES = planArr$values;
            $ENTRIES = kotlin.enums.a.a(planArr$values);
        }

        private Plan(String str, int i10) {
        }

        public static a<Plan> getEntries() {
            return $ENTRIES;
        }

        public static Plan valueOf(String str) {
            return (Plan) Enum.valueOf(Plan.class, str);
        }

        public static Plan[] values() {
            return (Plan[]) $VALUES.clone();
        }
    }

    private DownloadConfirmPlanner() {
    }

    private final boolean isNetworkConnected(Context context) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        boolean z = false;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        boolean zHasCapability = networkCapabilities.hasCapability(12);
        boolean zHasCapability2 = networkCapabilities.hasCapability(16);
        boolean zHasTransport = networkCapabilities.hasTransport(0);
        if (zHasCapability && (zHasCapability2 || zHasTransport)) {
            z = true;
        }
        AIEngineLogger.d(LogModule.OTA, TAG, "isNetworkConnected: internet=" + zHasCapability + " validated=" + zHasCapability2 + " cellular=" + zHasTransport + " -> " + z);
        return z;
    }

    private final boolean isWifiConnected(Context context) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        return (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasTransport(1) || !networkCapabilities.hasCapability(12)) ? false : true;
    }

    public final Plan plan(Input input) {
        g.f(input, "input");
        return !input.getHasNetwork() ? Plan.NO_NETWORK : input.isWifi() ? Plan.CONFIRM_ONLY : Plan.CONFIRM_THEN_CELLULAR;
    }

    public final Plan planFor(Context context) {
        g.f(context, "context");
        boolean zIsNetworkConnected = isNetworkConnected(context);
        boolean zIsWifiConnected = isWifiConnected(context);
        Plan plan = plan(new Input(zIsNetworkConnected, zIsWifiConnected));
        AIEngineLogger.i(LogModule.OTA, TAG, "planFor: hasNet=" + zIsNetworkConnected + " isWifi=" + zIsWifiConnected + " -> " + plan);
        return plan;
    }
}
