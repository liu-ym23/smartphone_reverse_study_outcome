package com.stepos.core.ota.domain;

import android.content.Context;
import b7.s;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import com.stepos.core.common.storage.InstalledModelMetaStore;
import com.stepos.core.common.storage.ModelPathStore;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.adapter.RemoteModelActivator;
import com.stepos.core.ota.display.ModelDisplayResourceStore;
import com.stepos.core.ota.install.OtaBucketLegacy;
import com.stepos.core.ota.process.OtaProcess;
import com.stepos.core.ota.process.OtaProcessBootstrap;
import com.stepos.core.ota.process.OtaRuntime;
import com.stepos.core.ota.process.PendingActivationStore;
import com.stepos.core.ota.push.PendingAutoUpdateStore;
import com.stepos.core.ota.storage.OtaFailureMarker;
import com.stepos.core.ota.storage.OtaTaskSnapshotStore;
import com.stepos.core.ota.storage.SilentInstallFailureStore;
import com.stepos.core.ota.storage.UserUninstallStore;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;
import mb.m;
import mb.x;
import wb.c;
import wb.c.b;
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelUninstaller {
    private static final int DELETE_RETRY = 3;
    private static final long DELETE_RETRY_DELAY_MS = 250;
    public static final ModelUninstaller INSTANCE = new ModelUninstaller();
    private static final String TAG = "ModelUninstaller";

    private ModelUninstaller() {
    }

    private final void clearRegistration(String str, Set<String> set) {
        Object objA;
        OtaBucketLegacy.INSTANCE.clearAllVersions(str);
        for (String str2 : set) {
            String path = ModelPathStore.INSTANCE.getPath(str2);
            if (path.length() > 0) {
                try {
                    objA = Boolean.valueOf(d.T(new File(path)));
                } catch (Throwable th) {
                    objA = c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    AIEngineLogger.w(LogModule.OTA, TAG, "delete stored path failed: ".concat(path), thB);
                }
            }
            ModelPathStore.INSTANCE.clear(str2);
        }
        for (String str3 : OtaEngine.INSTANCE.getAbilityIdsForOta(str)) {
            String path2 = ModelPathStore.INSTANCE.getPath(str3);
            if (path2.length() > 0) {
                try {
                    d.T(new File(path2));
                } catch (Throwable th2) {
                    c.a(th2);
                }
            }
            ModelPathStore.INSTANCE.clear(str3);
        }
        ModelPathStore.INSTANCE.clear(str);
    }

    private final boolean deleteBucketTree(String modelId, String filesDirAbsolutePath) throws InterruptedException {
        g.f(modelId, "modelId");
        g.f(filesDirAbsolutePath, "filesDirAbsolutePath");
        File file = new File(com.stepos.core.ota.d.i(filesDirAbsolutePath, "/models/", modelId));
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    try {
                        if (file2.isDirectory()) {
                            d.T(file2);
                        } else {
                            file2.delete();
                        }
                    } catch (Throwable th) {
                        c.a(th);
                    }
                }
            }
            for (int i10 = 0; i10 < 3; i10++) {
                if (file.exists() && !d.T(file)) {
                    if (i10 < 2) {
                        Thread.sleep(DELETE_RETRY_DELAY_MS);
                    }
                }
            }
            return (file.exists() && hasModelPayload(file)) ? false : true;
        }
        return true;
    }

    private final boolean hasModelPayload(File file) {
        if (!file.exists()) {
            return false;
        }
        c.b bVar = d.b0(file).new b();
        while (bVar.hasNext()) {
            File next = bVar.next();
            if (next.isFile() && next.length() > 0) {
                File parentFile = next.getParentFile();
                if (!g.b(parentFile != null ? parentFile.getName() : null, ModelDisplayResourceStore.DISPLAY_SUBDIR)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void releaseInferenceCache(Context context, String str, Set<String> set) {
        Object objA;
        Object objA2;
        if (OtaProcess.INSTANCE.isOtaProcess(context)) {
            RemoteModelActivator remoteModelActivatorRemoteActivatorOrNull = OtaProcessBootstrap.INSTANCE.remoteActivatorOrNull();
            for (String str2 : set) {
                if (remoteModelActivatorRemoteActivatorOrNull != null) {
                    try {
                        objA2 = Boolean.valueOf(remoteModelActivatorRemoteActivatorOrNull.deactivateBlocking(str2, 8000L));
                    } catch (Throwable th) {
                        objA2 = kotlin.c.a(th);
                    }
                } else {
                    objA2 = null;
                }
                Throwable thB = Result.b(objA2);
                if (thB != null) {
                    AIEngineLogger.w(LogModule.OTA, TAG, ai.onnxruntime.a.k("remote deactivate failed: ", str2), thB);
                }
            }
            return;
        }
        for (String str3 : set) {
            try {
                ModelCacheImpl modelCacheImpl = s.f3120b;
                if (modelCacheImpl != null) {
                    modelCacheImpl.deactivate(str3);
                    objA = n.f10413a;
                } else {
                    objA = null;
                }
            } catch (Throwable th2) {
                objA = kotlin.c.a(th2);
            }
            Throwable thB2 = Result.b(objA);
            if (thB2 != null) {
                AIEngineLogger.w(LogModule.OTA, TAG, ai.onnxruntime.a.k("local deactivate failed: ", str3), thB2);
            }
        }
    }

    public final boolean uninstall(Context context, String modelId) {
        Object objA;
        Object objA2;
        boolean z;
        boolean z3;
        g.f(context, "context");
        g.f(modelId, "modelId");
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(modelId);
        Context applicationContext = context.getApplicationContext();
        String absolutePath = applicationContext.getFilesDir().getAbsolutePath();
        LinkedHashSet<String> linkedHashSetAllBucketIds = OtaBucketLegacy.INSTANCE.allBucketIds(strResolveAnyToOta);
        LogModule logModule = LogModule.OTA;
        StringBuilder sbS = ai.onnxruntime.a.s("uninstall: modelId=", modelId, " otaId=", strResolveAnyToOta, " buckets=");
        sbS.append(linkedHashSetAllBucketIds);
        AIEngineLogger.i(logModule, TAG, sbS.toString());
        UserUninstallStore.INSTANCE.markAll(x.V(linkedHashSetAllBucketIds, strResolveAnyToOta));
        Iterator<T> it = linkedHashSetAllBucketIds.iterator();
        while (it.hasNext()) {
            PendingAutoUpdateStore.INSTANCE.remove((String) it.next());
        }
        PendingAutoUpdateStore.INSTANCE.remove(strResolveAnyToOta);
        try {
            OtaRuntime.INSTANCE.dispatcher().cancel(strResolveAnyToOta);
            for (String str : linkedHashSetAllBucketIds) {
                if (!g.b(str, strResolveAnyToOta)) {
                    OtaRuntime.INSTANCE.dispatcher().cancel(str);
                }
            }
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.OTA, TAG, ai.onnxruntime.a.k("cancel failed: ", strResolveAnyToOta), thB);
        }
        try {
            new ModelDownloadNotifier(applicationContext).dismissForModel(strResolveAnyToOta);
            objA2 = n.f10413a;
        } catch (Throwable th2) {
            objA2 = kotlin.c.a(th2);
        }
        Throwable thB2 = Result.b(objA2);
        if (thB2 != null) {
            AIEngineLogger.w(LogModule.OTA, TAG, ai.onnxruntime.a.k("dismiss notification failed: ", strResolveAnyToOta), thB2);
        }
        releaseInferenceCache(applicationContext, strResolveAnyToOta, linkedHashSetAllBucketIds);
        clearRegistration(strResolveAnyToOta, linkedHashSetAllBucketIds);
        OtaFailureMarker.INSTANCE.clear(strResolveAnyToOta);
        SilentInstallFailureStore.INSTANCE.clear(strResolveAnyToOta);
        InstalledModelMetaStore.INSTANCE.remove(applicationContext, strResolveAnyToOta);
        for (String str2 : linkedHashSetAllBucketIds) {
            OtaFailureMarker.INSTANCE.clear(str2);
            SilentInstallFailureStore.INSTANCE.clear(str2);
            PendingActivationStore.INSTANCE.remove(str2);
            InstalledModelMetaStore.INSTANCE.remove(applicationContext, str2);
            OtaTaskSnapshotStore.INSTANCE.clear(str2);
        }
        ArrayList arrayList = new ArrayList(m.Z(linkedHashSetAllBucketIds, 10));
        for (String str3 : linkedHashSetAllBucketIds) {
            ModelUninstaller modelUninstaller = INSTANCE;
            g.c(absolutePath);
            arrayList.add(Boolean.valueOf(modelUninstaller.deleteBucketTree(str3, absolutePath)));
        }
        boolean z10 = false;
        if (linkedHashSetAllBucketIds.isEmpty()) {
            z = true;
        } else {
            for (String modelId2 : linkedHashSetAllBucketIds) {
                g.c(absolutePath);
                g.f(modelId2, "modelId");
                if (new File(com.stepos.core.ota.d.i(absolutePath, "/models/", modelId2)).exists()) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        if (linkedHashSetAllBucketIds.isEmpty()) {
            z3 = true;
        } else {
            for (String modelId3 : linkedHashSetAllBucketIds) {
                ModelUninstaller modelUninstaller2 = INSTANCE;
                g.c(absolutePath);
                g.f(modelId3, "modelId");
                if (modelUninstaller2.hasModelPayload(new File(com.stepos.core.ota.d.i(absolutePath, "/models/", modelId3)))) {
                    z3 = false;
                    break;
                }
            }
            z3 = true;
        }
        if (arrayList.isEmpty()) {
            z10 = true;
        } else {
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                Object obj = arrayList.get(i10);
                i10++;
                if (!((Boolean) obj).booleanValue()) {
                    if (z || z3) {
                        break;
                    }
                }
            }
            z10 = true;
        }
        LogModule logModule2 = LogModule.OTA;
        StringBuilder sbS2 = ai.onnxruntime.a.s("uninstall: modelId=", modelId, " otaId=", strResolveAnyToOta, " result=");
        sbS2.append(z10);
        sbS2.append(" allGone=");
        sbS2.append(z);
        sbS2.append(" noPayload=");
        sbS2.append(z3);
        sbS2.append(" deletes=");
        sbS2.append(arrayList);
        AIEngineLogger.i(logModule2, TAG, sbS2.toString());
        return z10;
    }
}
