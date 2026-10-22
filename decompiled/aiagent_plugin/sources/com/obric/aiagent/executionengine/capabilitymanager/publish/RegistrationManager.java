package com.obric.aiagent.executionengine.capabilitymanager.publish;

import android.os.Bundle;
import com.obric.aiagent.executionengine.capabilitymanager.api.publish.IRegistrationManagerApi;

/* JADX INFO: compiled from: RegistrationClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RegistrationManager implements IRegistrationManagerApi {
    public RegistrationManager() {
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.api.publish.IRegistrationManagerApi
    public void notifyResult(int r1, String r2) {
        b.f16563a.a(r1, r2);
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.api.publish.IRegistrationManagerApi
    public void notifyResultBundled(Bundle r1) {
        b.f16563a.a(r1);
    }
}
