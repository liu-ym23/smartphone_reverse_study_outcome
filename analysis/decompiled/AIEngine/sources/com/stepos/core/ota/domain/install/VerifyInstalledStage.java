package com.stepos.core.ota.domain.install;

import ai.onnxruntime.a;
import com.stepos.core.ota.domain.OtaError;
import com.stepos.core.ota.domain.install.StageOutcome;
import com.stepos.core.ota.domain.port.ModelStorage;
import kotlin.jvm.internal.g;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VerifyInstalledStage implements InstallStage {
    private final String name;
    private final ModelStorage storage;

    public VerifyInstalledStage(ModelStorage storage) {
        g.f(storage, "storage");
        this.storage = storage;
        this.name = "VerifyInstalled";
    }

    @Override // com.stepos.core.ota.domain.install.InstallStage
    public Object execute(InstallContext installContext, b<? super StageOutcome> bVar) {
        if (this.storage.payloadBytes(installContext.getTargetDir()) > 0) {
            return StageOutcome.Proceed.INSTANCE;
        }
        this.storage.deleteDir(installContext.getTargetDir());
        return new StageOutcome.Fail(new OtaError.EmptyPayload(installContext.getManifest().getOtaId(), a.k("installed dir empty: ", installContext.getTargetDir())));
    }

    @Override // com.stepos.core.ota.domain.install.InstallStage
    public String getName() {
        return this.name;
    }
}
