package com.android.server.voiceinteraction;

import android.service.voice.ISandboxedDetectionService;
import com.android.internal.infra.ServiceConnector;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SoftwareTrustedHotwordDetectorSession$$ExternalSyntheticLambda0 implements ServiceConnector.VoidJob {
    public /* synthetic */ SoftwareTrustedHotwordDetectorSession$$ExternalSyntheticLambda0() {
    }

    public final void runNoResult(Object r1) {
        ((ISandboxedDetectionService) r1).stopDetection();
    }
}
