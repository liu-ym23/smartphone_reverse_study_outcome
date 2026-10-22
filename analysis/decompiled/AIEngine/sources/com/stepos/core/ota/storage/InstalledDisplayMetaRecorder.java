package com.stepos.core.ota.storage;

import android.content.Context;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.storage.InstalledModelMetaStore;
import com.stepos.core.ota.display.ModelDisplayResourceStore;
import com.stepos.core.ota.domain.model.ModelManifest;
import gc.q;
import h0.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InstalledDisplayMetaRecorder {
    public static final InstalledDisplayMetaRecorder INSTANCE = new InstalledDisplayMetaRecorder();
    private static final String TAG = "InstalledDisplayMetaRecorder";

    private InstalledDisplayMetaRecorder() {
    }

    public final void record(Context context, ModelManifest manifest) {
        g.f(context, "context");
        g.f(manifest, "manifest");
        if (q.t0(manifest.getOtaId()) || manifest.isPlugin()) {
            return;
        }
        InstalledModelMetaStore installedModelMetaStore = InstalledModelMetaStore.INSTANCE;
        InstalledModelMetaStore.Meta metaReplaceMeta = installedModelMetaStore.replaceMeta(context, manifest.getOtaId(), new InstalledModelMetaStore.Meta(manifest.getSizeBytes(), manifest.getUpdateInfo(), manifest.getUpdateTimeMs()));
        String strRemoteDisplayKey = ModelDisplayResourceStore.INSTANCE.remoteDisplayKey(manifest.getResourceUrl(), manifest.getVersion());
        if (strRemoteDisplayKey == null) {
            strRemoteDisplayKey = "";
        }
        installedModelMetaStore.putDisplayKey(context, manifest.getOtaId(), strRemoteDisplayKey);
        LogModule logModule = LogModule.OTA;
        String otaId = manifest.getOtaId();
        int version = manifest.getVersion();
        long sizeBytes = metaReplaceMeta != null ? metaReplaceMeta.getSizeBytes() : manifest.getSizeBytes();
        StringBuilder sbF = e.f("[", otaId, "] recorded installed display meta v", version, " size=");
        sbF.append(sizeBytes);
        sbF.append(" displayKey=");
        sbF.append(strRemoteDisplayKey);
        AIEngineLogger.i(logModule, TAG, sbF.toString());
    }
}
