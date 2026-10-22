package com.stepos.core.ota.domain.install;

import com.stepos.core.ota.domain.install.StageOutcome;
import com.stepos.core.ota.domain.model.ModelManifest;
import com.stepos.core.ota.domain.port.ModelStorage;
import kotlin.jvm.internal.g;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RegisterVersionStage implements InstallStage {
    private final String name;
    private final ModelStorage storage;

    public RegisterVersionStage(ModelStorage storage) {
        g.f(storage, "storage");
        this.storage = storage;
        this.name = "RegisterVersion";
    }

    @Override // com.stepos.core.ota.domain.install.InstallStage
    public Object execute(InstallContext installContext, b<? super StageOutcome> bVar) {
        ModelManifest manifest = installContext.getManifest();
        if (manifest.isPlugin()) {
            this.storage.setPluginVersion(manifest.getBaseModelId(), manifest.getPluginName(), manifest.getVersion());
        } else {
            this.storage.setInstalledVersion(manifest.getOtaId(), manifest.getVersion());
        }
        return StageOutcome.Proceed.INSTANCE;
    }

    @Override // com.stepos.core.ota.domain.install.InstallStage
    public String getName() {
        return this.name;
    }
}
