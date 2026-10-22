package com.android.server.ondeviceintelligence;

import android.service.ondeviceintelligence.IOnDeviceIntelligenceService;
import com.android.internal.infra.ServiceConnector;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class OnDeviceIntelligenceManagerService$4$$ExternalSyntheticLambda3 implements ServiceConnector.VoidJob {
    public /* synthetic */ OnDeviceIntelligenceManagerService$4$$ExternalSyntheticLambda3() {
    }

    public final void runNoResult(Object r1) {
        ((IOnDeviceIntelligenceService) r1).notifyInferenceServiceDisconnected();
    }
}
