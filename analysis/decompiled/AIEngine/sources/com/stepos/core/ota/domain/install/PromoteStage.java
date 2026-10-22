package com.stepos.core.ota.domain.install;

import com.stepos.core.ota.domain.OtaError;
import com.stepos.core.ota.domain.install.StageOutcome;
import com.stepos.core.ota.domain.port.ModelStorage;
import kotlin.Result;
import kotlin.jvm.internal.g;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PromoteStage implements InstallStage {
    private final String name;
    private final ModelStorage storage;

    public PromoteStage(ModelStorage storage) {
        g.f(storage, "storage");
        this.storage = storage;
        this.name = "Promote";
    }

    @Override // com.stepos.core.ota.domain.install.InstallStage
    public Object execute(InstallContext installContext, b<? super StageOutcome> bVar) {
        this.storage.deleteDir(installContext.getTargetDir());
        Object objMo112promoteAtomicallygIAlus = this.storage.mo112promoteAtomicallygIAlus(installContext.getTempDir(), installContext.getTargetDir());
        if (!(objMo112promoteAtomicallygIAlus instanceof Result.Failure)) {
            return StageOutcome.Proceed.INSTANCE;
        }
        this.storage.deleteDir(installContext.getTempDir());
        return new StageOutcome.Fail(new OtaError.StorageFailed(installContext.getManifest().getOtaId(), Result.b(objMo112promoteAtomicallygIAlus)));
    }

    @Override // com.stepos.core.ota.domain.install.InstallStage
    public String getName() {
        return this.name;
    }
}
