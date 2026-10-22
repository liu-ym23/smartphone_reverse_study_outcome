package com.stepos.core.ota.adapter;

import android.content.Context;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.data.OtaRemoteModel;
import com.stepos.core.ota.domain.DownloadPlanFallback;
import com.stepos.core.ota.domain.model.Integrity;
import com.stepos.core.ota.domain.model.ModelManifest;
import com.stepos.core.ota.domain.port.ManifestSource;
import com.stepos.core.ota.install.OtaBucketLegacy;
import com.stepos.core.ota.remote.RemoteModelsRepository;
import com.stepos.core.ota.storage.ModelsVersionStore;
import gc.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import mb.m;
import mb.v;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ManifestSourceAdapter implements ManifestSource {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "ManifestSourceAdapter";
    private final Context context;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public ManifestSourceAdapter(Context context) {
        g.f(context, "context");
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void collectUpdates(String str, Set<String> set, Set<String> set2, List<OtaRemoteModel> list, boolean z) {
        List<OtaRemoteModel> list2 = list;
        Set<String> set3 = set2;
        boolean z3 = z;
        if (set3.add(str)) {
            Set<String> set4 = set;
            ArrayList arrayList = new ArrayList(m.Z(set4, 10));
            Iterator<T> it = set4.iterator();
            while (it.hasNext()) {
                arrayList.add(str + "." + ((String) it.next()));
            }
            List listH0 = kotlin.collections.a.H0(arrayList);
            if (listH0.isEmpty()) {
                listH0 = b1.P(str);
            }
            String strZ0 = kotlin.collections.a.z0(listH0, "|", null, null, null, 62);
            OtaRemoteModel otaRemoteModel = RemoteModelsRepository.get(str);
            int iA0 = v.a0(m.Z(set4, 10));
            if (iA0 < 16) {
                iA0 = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
            for (Object obj : set4) {
                linkedHashMap.put(obj, RemoteModelsRepository.get(str + "." + ((String) obj)));
            }
            if (z3) {
                Iterator it2 = q.D0(strZ0, new String[]{"|"}, 6).iterator();
                while (it2.hasNext()) {
                    RemoteModelsRepository.invalidateTtl((String) it2.next());
                }
            }
            ManifestSourceAdapter manifestSourceAdapter = this;
            RemoteModelsRepository.fetch$default(manifestSourceAdapter.context, strZ0, false, 4, null);
            OtaRemoteModel otaRemoteModel2 = RemoteModelsRepository.get(str);
            OtaRemoteModel otaRemoteModel3 = (OtaRemoteModel) DownloadPlanFallback.INSTANCE.pickLatestOrCached(otaRemoteModel2, otaRemoteModel2 != null ? otaRemoteModel2.getUrl() : null, otaRemoteModel, otaRemoteModel != null ? otaRemoteModel.getUrl() : null);
            if (otaRemoteModel3 == null) {
                LogModule logModule = LogModule.OTA;
                StringBuilder sbS = ai.onnxruntime.a.s("collectUpdates: no remote entry for '", str, "' (fetchType=", strZ0, " forceRefresh=");
                sbS.append(z3);
                sbS.append(") → plan will be empty");
                AIEngineLogger.w(logModule, TAG, sbS.toString());
                return;
            }
            if (z3 && otaRemoteModel3 == otaRemoteModel && (otaRemoteModel2 == null || q.t0(otaRemoteModel2.getUrl()))) {
                AIEngineLogger.w(LogModule.OTA, TAG, "collectUpdates: no latest url for '" + str + "', fallback to last cached url");
            }
            list2.add(otaRemoteModel3);
            for (String str2 : set) {
                OtaRemoteModel otaRemoteModel4 = RemoteModelsRepository.get(str + "." + str2);
                OtaRemoteModel otaRemoteModel5 = (OtaRemoteModel) linkedHashMap.get(str2);
                OtaRemoteModel otaRemoteModel6 = (OtaRemoteModel) DownloadPlanFallback.INSTANCE.pickLatestOrCached(otaRemoteModel4, otaRemoteModel4 != null ? otaRemoteModel4.getUrl() : null, otaRemoteModel5, otaRemoteModel5 != null ? otaRemoteModel5.getUrl() : null);
                if (otaRemoteModel6 != null) {
                    list2.add(otaRemoteModel6);
                }
            }
            List<String> dependencies = otaRemoteModel3.getDependencies();
            if (dependencies == null) {
                dependencies = EmptyList.f10001a;
            }
            Iterator<String> it3 = dependencies.iterator();
            while (it3.hasNext()) {
                manifestSourceAdapter.collectUpdates(it3.next(), EmptySet.f10003a, set3, list2, z3);
                manifestSourceAdapter = this;
                set3 = set2;
                list2 = list;
                z3 = z;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAlreadyInstalled(OtaRemoteModel otaRemoteModel, boolean z) {
        if (z) {
            return false;
        }
        return otaRemoteModel.isPlugin() ? ModelsVersionStore.INSTANCE.getPluginVersion(otaRemoteModel.getBaseModelName(), otaRemoteModel.getPluginName()) >= otaRemoteModel.getVersion_code() : OtaBucketLegacy.INSTANCE.effectiveVersion(OtaEngine.INSTANCE.resolveAnyToOta(otaRemoteModel.getName())) >= otaRemoteModel.getVersion_code();
    }

    public static /* synthetic */ boolean isAlreadyInstalled$default(ManifestSourceAdapter manifestSourceAdapter, OtaRemoteModel otaRemoteModel, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        return manifestSourceAdapter.isAlreadyInstalled(otaRemoteModel, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ModelManifest toManifest(OtaRemoteModel otaRemoteModel) {
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(otaRemoteModel.getName());
        int version_code = otaRemoteModel.getVersion_code();
        String url = otaRemoteModel.getUrl();
        long file_size = otaRemoteModel.getFile_size();
        String md5 = otaRemoteModel.getMd5();
        Integrity integrity = new Integrity(q.t0(md5) ? null : md5, null, null, 6, null);
        List<String> dependencies = otaRemoteModel.getDependencies();
        if (dependencies == null) {
            dependencies = EmptyList.f10001a;
        }
        List<String> list = dependencies;
        List<String> abilities = otaRemoteModel.getAbilities();
        String update_info = otaRemoteModel.getUpdate_info();
        long update_time = otaRemoteModel.getUpdate_time();
        String resource_url = otaRemoteModel.getResource_url();
        String dek_cipher = otaRemoteModel.getDek_cipher();
        return new ModelManifest(strResolveAnyToOta, version_code, url, file_size, integrity, list, abilities, update_info, update_time, resource_url, q.t0(dek_cipher) ? null : dek_cipher);
    }

    @Override // com.stepos.core.ota.domain.port.ManifestSource
    public ModelManifest cached(String otaId) {
        g.f(otaId, "otaId");
        OtaRemoteModel otaRemoteModel = RemoteModelsRepository.get(otaId);
        if (otaRemoteModel != null) {
            return toManifest(otaRemoteModel);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.ota.domain.port.ManifestSource
    /* renamed from: fetch-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo113fetchgIAlus(java.util.List<java.lang.String> r6, qb.b<? super kotlin.Result<? extends java.util.List<com.stepos.core.ota.domain.model.ModelManifest>>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.core.ota.adapter.ManifestSourceAdapter$fetch$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.core.ota.adapter.ManifestSourceAdapter$fetch$1 r0 = (com.stepos.core.ota.adapter.ManifestSourceAdapter$fetch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.adapter.ManifestSourceAdapter$fetch$1 r0 = new com.stepos.core.ota.adapter.ManifestSourceAdapter$fetch$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r7)
            goto L45
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.c.b(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.core.ota.adapter.ManifestSourceAdapter$fetch$2 r2 = new com.stepos.core.ota.adapter.ManifestSourceAdapter$fetch$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.f9987a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.ManifestSourceAdapter.mo113fetchgIAlus(java.util.List, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.ota.domain.port.ManifestSource
    /* renamed from: planUpdates-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo114planUpdatesBWLJW6A(java.lang.String r11, java.util.Set<java.lang.String> r12, boolean r13, qb.b<? super kotlin.Result<? extends java.util.List<com.stepos.core.ota.domain.model.ModelManifest>>> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.stepos.core.ota.adapter.ManifestSourceAdapter$planUpdates$1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.core.ota.adapter.ManifestSourceAdapter$planUpdates$1 r0 = (com.stepos.core.ota.adapter.ManifestSourceAdapter$planUpdates$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.adapter.ManifestSourceAdapter$planUpdates$1 r0 = new com.stepos.core.ota.adapter.ManifestSourceAdapter$planUpdates$1
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r14)
            goto L49
        L27:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L2f:
            kotlin.c.b(r14)
            kotlinx.coroutines.CoroutineDispatcher r14 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.core.ota.adapter.ManifestSourceAdapter$planUpdates$2 r4 = new com.stepos.core.ota.adapter.ManifestSourceAdapter$planUpdates$2
            r9 = 0
            r6 = r10
            r5 = r11
            r7 = r12
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.label = r3
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.withContext(r14, r4, r0)
            if (r14 != r1) goto L49
            return r1
        L49:
            kotlin.Result r14 = (kotlin.Result) r14
            java.lang.Object r10 = r14.f9987a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.ManifestSourceAdapter.mo114planUpdatesBWLJW6A(java.lang.String, java.util.Set, boolean, qb.b):java.lang.Object");
    }
}
