package com.stepos.core.ota;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.ota.domain.OtaAction;
import com.stepos.core.ota.domain.OtaStore;
import com.stepos.core.ota.domain.PauseReason;
import com.stepos.core.ota.domain.TriggerSource;
import java.util.Set;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class StoreDispatcher implements OtaDispatcher {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "StoreDispatcher";
    private final OtaStore store;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public StoreDispatcher(OtaStore store) {
        g.f(store, "store");
        this.store = store;
    }

    private final boolean serviceEnabled(String str, String str2) {
        if (CTAPermissionManager.INSTANCE.isModelServiceEnabled()) {
            return true;
        }
        AIEngineLogger.w(LogModule.OTA, TAG, str + " blocked by service switch: " + str2 + " (entry layer should have gated this)");
        return false;
    }

    @Override // com.stepos.core.ota.OtaDispatcher
    public boolean attach(String abilityId, TriggerSource source) {
        g.f(abilityId, "abilityId");
        g.f(source, "source");
        return this.store.submit(new OtaAction.Attach(OtaEngine.INSTANCE.resolveAnyToOta(abilityId), source));
    }

    @Override // com.stepos.core.ota.OtaDispatcher
    public boolean cancel(String abilityId) {
        g.f(abilityId, "abilityId");
        return this.store.submit(new OtaAction.Cancel(OtaEngine.INSTANCE.resolveAnyToOta(abilityId)));
    }

    @Override // com.stepos.core.ota.OtaDispatcher
    public boolean checkUpdate(String abilityId, TriggerSource source) {
        g.f(abilityId, "abilityId");
        g.f(source, "source");
        return this.store.submit(new OtaAction.CheckUpdate(OtaEngine.INSTANCE.resolveAnyToOta(abilityId), source, false, 4, null));
    }

    @Override // com.stepos.core.ota.OtaDispatcher
    public boolean detach(String abilityId, String clientTag) {
        g.f(abilityId, "abilityId");
        g.f(clientTag, "clientTag");
        return this.store.submit(new OtaAction.Detach(OtaEngine.INSTANCE.resolveAnyToOta(abilityId), clientTag));
    }

    @Override // com.stepos.core.ota.OtaDispatcher
    public boolean download(String abilityId, TriggerSource source, String str, Set<String> plugins, boolean z) {
        g.f(abilityId, "abilityId");
        g.f(source, "source");
        g.f(plugins, "plugins");
        if (serviceEnabled("download", abilityId)) {
            return this.store.submit(new OtaAction.Download(OtaEngine.INSTANCE.resolveAnyToOta(abilityId), source, str, plugins, z));
        }
        return false;
    }

    @Override // com.stepos.core.ota.OtaDispatcher
    public boolean pause(String abilityId, PauseReason reason) {
        g.f(abilityId, "abilityId");
        g.f(reason, "reason");
        return this.store.submit(new OtaAction.Pause(OtaEngine.INSTANCE.resolveAnyToOta(abilityId), reason));
    }

    @Override // com.stepos.core.ota.OtaDispatcher
    public boolean resume(String abilityId, TriggerSource source) {
        g.f(abilityId, "abilityId");
        g.f(source, "source");
        if (serviceEnabled("resume", abilityId)) {
            return this.store.submit(new OtaAction.Resume(OtaEngine.INSTANCE.resolveAnyToOta(abilityId), source));
        }
        return false;
    }
}
