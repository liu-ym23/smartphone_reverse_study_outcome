package com.stepos.core.ota.adapter;

import com.stepos.core.common.telemetry.b;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.domain.port.ModelStorage;
import com.stepos.core.ota.install.OtaBucketLegacy;
import com.stepos.core.ota.storage.ModelsVersionStore;
import fc.f;
import java.io.File;
import kotlin.c;
import kotlin.jvm.internal.g;
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FileSystemModelStorage implements ModelStorage {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean payloadBytes$lambda$2(File it) {
        g.f(it, "it");
        return it.isFile();
    }

    @Override // com.stepos.core.ota.domain.port.ModelStorage
    public String bucketDir(String modelId) {
        g.f(modelId, "modelId");
        return OtaEngine.INSTANCE.bucketDirOf(modelId);
    }

    @Override // com.stepos.core.ota.domain.port.ModelStorage
    public void deleteDir(String path) {
        g.f(path, "path");
        File file = new File(path);
        if (file.exists()) {
            d.T(file);
        }
    }

    @Override // com.stepos.core.ota.domain.port.ModelStorage
    public int installedVersion(String otaId) {
        g.f(otaId, "otaId");
        return OtaBucketLegacy.INSTANCE.effectiveVersion(otaId);
    }

    @Override // com.stepos.core.ota.domain.port.ModelStorage
    public long payloadBytes(String path) {
        g.f(path, "path");
        File file = new File(path);
        long length = 0;
        if (!file.exists()) {
            return 0L;
        }
        if (file.isFile()) {
            return file.length();
        }
        f.a aVar = new f.a(new f(d.b0(file), new b(10)));
        while (aVar.hasNext()) {
            length += ((File) aVar.next()).length();
        }
        return length;
    }

    @Override // com.stepos.core.ota.domain.port.ModelStorage
    /* renamed from: promoteAtomically-gIAlu-s, reason: not valid java name */
    public Object mo112promoteAtomicallygIAlus(String tempDir, String targetDir) {
        g.f(tempDir, "tempDir");
        g.f(targetDir, "targetDir");
        try {
            File file = new File(tempDir);
            File file2 = new File(targetDir);
            if (file.renameTo(file2)) {
                return file2.getAbsolutePath();
            }
            throw new IllegalStateException(("atomic rename failed: " + tempDir + " -> " + targetDir).toString());
        } catch (Throwable th) {
            return c.a(th);
        }
    }

    @Override // com.stepos.core.ota.domain.port.ModelStorage
    public void setInstalledVersion(String otaId, int i10) {
        g.f(otaId, "otaId");
        ModelsVersionStore.INSTANCE.setVersionCode(otaId, i10);
    }

    @Override // com.stepos.core.ota.domain.port.ModelStorage
    public void setPluginVersion(String baseOtaId, String plugin, int i10) {
        g.f(baseOtaId, "baseOtaId");
        g.f(plugin, "plugin");
        ModelsVersionStore.INSTANCE.setPluginVersion(baseOtaId, plugin, i10);
    }
}
