package com.stepos.core.ota.push;

import android.content.Context;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.data.OtaRemoteModel;
import com.stepos.core.ota.install.InstalledPathResolver;
import com.stepos.core.ota.install.OtaBucketLegacy;
import com.stepos.core.ota.push.PendingAutoUpdateStore;
import com.stepos.core.ota.remote.RemoteModelsRepository;
import com.stepos.core.ota.storage.UserUninstallStore;
import h0.e;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class UpdatablePendingScanner {
    public static final UpdatablePendingScanner INSTANCE = new UpdatablePendingScanner();
    private static final String TAG = "UpdatablePendingScanner";

    private UpdatablePendingScanner() {
    }

    private final void diag(String str) {
        e.k("[DIAG] ", str, LogModule.OTA, TAG);
    }

    public static /* synthetic */ boolean seed$default(UpdatablePendingScanner updatablePendingScanner, Context context, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        return updatablePendingScanner.seed(context, z);
    }

    public final boolean seed(Context context, boolean z) {
        Object objA;
        g.f(context, "context");
        boolean z3 = false;
        if (!CTAPermissionManager.INSTANCE.isModelOtaAllowed()) {
            diag("seed skipped: CTA not granted force=" + z);
            return false;
        }
        try {
            OtaEngine otaEngine = OtaEngine.INSTANCE;
            diag("seed fetch force=" + z + " ok=" + otaEngine.fetchAllKnownModels(context, z));
            for (String str : otaEngine.getAllOtaNames()) {
                OtaRemoteModel otaRemoteModel = RemoteModelsRepository.get(str);
                if (otaRemoteModel != null) {
                    String str2 = (String) kotlin.collections.a.u0(OtaEngine.INSTANCE.getAbilityIdsForOta(str));
                    if (str2 == null) {
                        str2 = str;
                    }
                    int iEffectiveVersion = OtaBucketLegacy.INSTANCE.effectiveVersion(str);
                    if (!UserUninstallStore.INSTANCE.contains(str) && InstalledPathResolver.INSTANCE.isUsable(str2, str, true) && iEffectiveVersion < otaRemoteModel.getVersion_code()) {
                        PendingAutoUpdateStore.INSTANCE.put(new PendingAutoUpdateStore.Record(str, otaRemoteModel.getVersion_code(), false, otaRemoteModel.getFile_size(), null, System.currentTimeMillis(), false, 64, null));
                        diag("seed pending otaId=" + str + " localVer=" + iEffectiveVersion + " remoteVer=" + otaRemoteModel.getVersion_code() + " size=" + otaRemoteModel.getFile_size());
                        z3 = true;
                    }
                }
            }
            AIEngineLogger.i(LogModule.OTA, TAG, "seed done force=" + z + " wrote=" + z3);
            diag("seed done force=" + z + " wrote=" + z3);
            objA = Boolean.valueOf(z3);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.OTA, TAG, "seed failed force=" + z, thB);
            INSTANCE.diag("seed failed force=" + z + " err=" + thB.getClass().getSimpleName() + ":" + thB.getMessage());
        }
        Boolean bool = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = bool;
        }
        return ((Boolean) objA).booleanValue();
    }
}
