package com.stepos.core.ota.push;

import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.process.OtaRuntime;
import com.stepos.core.ota.storage.ModelsVersionStore;
import com.stepos.core.ota.storage.UserUninstallStore;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaPushEligibility {
    public static final OtaPushEligibility INSTANCE = new OtaPushEligibility();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Skip {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ Skip[] $VALUES;
        public static final Skip NOT_INSTALLED = new Skip("NOT_INSTALLED", 0);
        public static final Skip UP_TO_DATE = new Skip("UP_TO_DATE", 1);
        public static final Skip IN_PROGRESS = new Skip("IN_PROGRESS", 2);
        public static final Skip USER_UNINSTALLED = new Skip("USER_UNINSTALLED", 3);

        private static final /* synthetic */ Skip[] $values() {
            return new Skip[]{NOT_INSTALLED, UP_TO_DATE, IN_PROGRESS, USER_UNINSTALLED};
        }

        static {
            Skip[] skipArr$values = $values();
            $VALUES = skipArr$values;
            $ENTRIES = kotlin.enums.a.a(skipArr$values);
        }

        private Skip(String str, int i10) {
        }

        public static sb.a<Skip> getEntries() {
            return $ENTRIES;
        }

        public static Skip valueOf(String str) {
            return (Skip) Enum.valueOf(Skip.class, str);
        }

        public static Skip[] values() {
            return (Skip[]) $VALUES.clone();
        }
    }

    private OtaPushEligibility() {
    }

    public static /* synthetic */ Skip check$default(OtaPushEligibility otaPushEligibility, String str, int i10, boolean z, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z = false;
        }
        return otaPushEligibility.check(str, i10, z);
    }

    public final Skip check(String otaId, int i10, boolean z) {
        g.f(otaId, "otaId");
        return AutoUpdatePushLogic.INSTANCE.decideEligibility(ModelsVersionStore.INSTANCE.getVersionCode(otaId), i10, isActive(otaId), z, UserUninstallStore.INSTANCE.contains(otaId));
    }

    public final boolean isActive(String otaId) {
        OtaState state;
        g.f(otaId, "otaId");
        OtaStateSnapshot otaStateSnapshot = OtaRuntime.INSTANCE.snapshot().get(otaId);
        return (otaStateSnapshot == null || (state = otaStateSnapshot.getState()) == null || !state.isActive()) ? false : true;
    }

    public final boolean isInstalled(String otaId) {
        g.f(otaId, "otaId");
        return ModelsVersionStore.INSTANCE.getVersionCode(otaId) > 0;
    }
}
