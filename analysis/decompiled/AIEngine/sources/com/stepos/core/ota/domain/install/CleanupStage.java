package com.stepos.core.ota.domain.install;

import com.stepos.core.ota.domain.install.StageOutcome;
import com.stepos.core.ota.domain.port.ModelStorage;
import com.stepos.core.ota.domain.port.PayloadDecryptor;
import kotlin.c;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CleanupStage implements InstallStage {
    private final PayloadDecryptor decryptor;
    private final String name;
    private final ModelStorage storage;

    public CleanupStage(ModelStorage storage, PayloadDecryptor payloadDecryptor) {
        g.f(storage, "storage");
        this.storage = storage;
        this.decryptor = payloadDecryptor;
        this.name = "Cleanup";
    }

    @Override // com.stepos.core.ota.domain.install.InstallStage
    public Object execute(InstallContext installContext, b<? super StageOutcome> bVar) {
        installContext.releaseResources$ota_release();
        try {
            this.storage.deleteDir(installContext.getDownloadedFilePath());
            n nVar = n.f10413a;
        } catch (Throwable th) {
            c.a(th);
        }
        if (installContext.getEncryptedPayload()) {
            try {
                PayloadDecryptor payloadDecryptor = this.decryptor;
                if (payloadDecryptor != null) {
                    payloadDecryptor.onInstallSucceeded(installContext.getManifest().getOtaId(), installContext.getManifest().getVersion());
                    n nVar2 = n.f10413a;
                }
            } catch (Throwable th2) {
                c.a(th2);
            }
        }
        return StageOutcome.Proceed.INSTANCE;
    }

    @Override // com.stepos.core.ota.domain.install.InstallStage
    public String getName() {
        return this.name;
    }

    public /* synthetic */ CleanupStage(ModelStorage modelStorage, PayloadDecryptor payloadDecryptor, int i10, e eVar) {
        this(modelStorage, (i10 & 2) != 0 ? null : payloadDecryptor);
    }
}
