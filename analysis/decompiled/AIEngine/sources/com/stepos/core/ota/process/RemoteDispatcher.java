package com.stepos.core.ota.process;

import com.stepos.core.ota.OtaDispatcher;
import com.stepos.core.ota.domain.PauseReason;
import com.stepos.core.ota.domain.TriggerSource;
import java.util.Set;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RemoteDispatcher implements OtaDispatcher {
    public static final RemoteDispatcher INSTANCE = new RemoteDispatcher();

    private RemoteDispatcher() {
    }

    @Override // com.stepos.core.ota.OtaDispatcher
    public boolean attach(String abilityId, TriggerSource source) {
        g.f(abilityId, "abilityId");
        g.f(source, "source");
        return OtaProcessClient.INSTANCE.attach(abilityId, source);
    }

    @Override // com.stepos.core.ota.OtaDispatcher
    public boolean cancel(String abilityId) {
        g.f(abilityId, "abilityId");
        return OtaProcessClient.INSTANCE.cancel(abilityId);
    }

    @Override // com.stepos.core.ota.OtaDispatcher
    public boolean checkUpdate(String abilityId, TriggerSource source) {
        g.f(abilityId, "abilityId");
        g.f(source, "source");
        return OtaProcessClient.INSTANCE.checkUpdate(abilityId, source);
    }

    @Override // com.stepos.core.ota.OtaDispatcher
    public boolean detach(String abilityId, String clientTag) {
        g.f(abilityId, "abilityId");
        g.f(clientTag, "clientTag");
        return OtaProcessClient.INSTANCE.detach(abilityId, clientTag);
    }

    @Override // com.stepos.core.ota.OtaDispatcher
    public boolean download(String abilityId, TriggerSource source, String str, Set<String> plugins, boolean z) {
        g.f(abilityId, "abilityId");
        g.f(source, "source");
        g.f(plugins, "plugins");
        return OtaProcessClient.INSTANCE.download(abilityId, source, str, plugins, z);
    }

    @Override // com.stepos.core.ota.OtaDispatcher
    public boolean pause(String abilityId, PauseReason reason) {
        g.f(abilityId, "abilityId");
        g.f(reason, "reason");
        return OtaProcessClient.INSTANCE.pause(abilityId, reason);
    }

    @Override // com.stepos.core.ota.OtaDispatcher
    public boolean resume(String abilityId, TriggerSource source) {
        g.f(abilityId, "abilityId");
        g.f(source, "source");
        return OtaProcessClient.INSTANCE.resume(abilityId, source);
    }
}
