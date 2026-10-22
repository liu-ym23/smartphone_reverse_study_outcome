package com.stepos.aiengine.ota;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import b7.s;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.storage.ModelPathStore;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.ota.IModelActivationHost;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.install.ModelWarmupValidator;
import com.stepos.core.ota.install.OtaBucketLegacy;
import com.stepos.core.ota.process.PendingActivationStore;
import java.util.Iterator;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelActivationHostService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public final ModelActivationHostService$binder$1 f5909a = new IModelActivationHost.Stub() { // from class: com.stepos.aiengine.ota.ModelActivationHostService$binder$1
        @Override // com.stepos.core.ota.IModelActivationHost
        public boolean activate(String otaId, int i10, String path, String installer) {
            Object objA;
            g.f(otaId, "otaId");
            g.f(path, "path");
            g.f(installer, "installer");
            ModelActivationHostService modelActivationHostService = this.this$0;
            try {
                ModelCacheImpl modelCacheImpl = s.f3120b;
                boolean z = true;
                if (modelCacheImpl == null) {
                    ModelPathStore.INSTANCE.onDownloadComplete(otaId, path, "");
                } else {
                    int currentVersion = modelCacheImpl.getCurrentVersion(otaId);
                    modelCacheImpl.switchVersion(otaId, i10, path, installer);
                    ModelWarmupValidator modelWarmupValidator = ModelWarmupValidator.INSTANCE;
                    Context applicationContext = modelActivationHostService.getApplicationContext();
                    g.e(applicationContext, "getApplicationContext(...)");
                    if (!modelWarmupValidator.validate(applicationContext, otaId, EmptyList.f10001a)) {
                        if (currentVersion >= 0) {
                            modelCacheImpl.rollback(otaId, currentVersion, "warmup_failed");
                        }
                        AIEngineLogger.w(LogModule.OTA, "ModelActivationHost", "warmup failed, rolled back: " + otaId + " v" + i10 + " -> v" + currentVersion);
                        z = false;
                    }
                }
                objA = Boolean.valueOf(z);
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.e(LogModule.OTA, "ModelActivationHost", "activate failed: ".concat(otaId), thB);
                objA = Boolean.FALSE;
            }
            return ((Boolean) objA).booleanValue();
        }

        @Override // com.stepos.core.ota.IModelActivationHost
        public boolean deactivate(String otaId) {
            Object objA;
            g.f(otaId, "otaId");
            try {
                ModelCacheImpl modelCacheImpl = s.f3120b;
                String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(otaId);
                for (String str : OtaBucketLegacy.INSTANCE.allBucketIds(strResolveAnyToOta)) {
                    if (modelCacheImpl != null) {
                        modelCacheImpl.deactivate(str);
                    }
                    ModelPathStore.INSTANCE.clear(str);
                    PendingActivationStore.INSTANCE.remove(str);
                }
                Iterator<T> it = OtaEngine.INSTANCE.getAbilityIdsForOta(strResolveAnyToOta).iterator();
                while (it.hasNext()) {
                    ModelPathStore.INSTANCE.clear((String) it.next());
                }
                objA = Boolean.TRUE;
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.e(LogModule.OTA, "ModelActivationHost", "deactivate failed: ".concat(otaId), thB);
                objA = Boolean.FALSE;
            }
            return ((Boolean) objA).booleanValue();
        }

        @Override // com.stepos.core.ota.IModelActivationHost
        public int getCurrentVersion(String otaId) {
            g.f(otaId, "otaId");
            ModelCacheImpl modelCacheImpl = s.f3120b;
            if (modelCacheImpl != null) {
                return modelCacheImpl.getCurrentVersion(otaId);
            }
            return -1;
        }
    };

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f5909a;
    }
}
