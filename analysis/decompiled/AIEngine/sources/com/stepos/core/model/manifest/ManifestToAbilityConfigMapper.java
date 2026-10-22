package com.stepos.core.model.manifest;

import b7.k;
import com.stepos.base.model.InferenceConfig;
import com.stepos.core.ota.d;
import gc.q;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import p6.a;
import p6.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ManifestToAbilityConfigMapper {
    public static final ManifestToAbilityConfigMapper INSTANCE = new ManifestToAbilityConfigMapper();
    private static final String TAG = "ManifestMapper";

    private ManifestToAbilityConfigMapper() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.base.model.InferenceConfig buildInferenceConfig(java.lang.String r11) {
        /*
            r10 = this;
            int r10 = r11.hashCode()
            switch(r10) {
                case 108269: goto L39;
                case 462432159: goto L2d;
                case 462440101: goto L21;
                case 462441769: goto L15;
                case 715000473: goto L8;
                default: goto L7;
            }
        L7:
            goto L41
        L8:
            java.lang.String r10 = "llama_cpp"
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L11
            goto L41
        L11:
            java.lang.String r10 = "LLAMA_CPP"
        L13:
            r1 = r10
            goto L47
        L15:
            java.lang.String r10 = "qnn_vlm"
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L1e
            goto L41
        L1e:
            java.lang.String r10 = "QNN_VLM"
            goto L13
        L21:
            java.lang.String r10 = "qnn_tts"
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L2a
            goto L41
        L2a:
            java.lang.String r10 = "QNN_TTS"
            goto L13
        L2d:
            java.lang.String r10 = "qnn_llm"
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L36
            goto L41
        L36:
            java.lang.String r10 = "QNN_LLM"
            goto L13
        L39:
            java.lang.String r10 = "mnn"
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L44
        L41:
            java.lang.String r10 = "AUTO"
            goto L13
        L44:
            java.lang.String r10 = "MNN"
            goto L13
        L47:
            com.stepos.base.model.InferenceConfig r0 = new com.stepos.base.model.InferenceConfig
            r8 = 0
            r9 = 510(0x1fe, float:7.15E-43)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.manifest.ManifestToAbilityConfigMapper.buildInferenceConfig(java.lang.String):com.stepos.base.model.InferenceConfig");
    }

    public final a map(ModelManifest manifest) {
        String abilityId;
        g.f(manifest, "manifest");
        if (!g.b(manifest.getManifestType(), ModelManifest.TYPE_LORA)) {
            abilityId = manifest.getAbilityId();
        } else {
            if (q.t0(manifest.getBaseAbilityId())) {
                throw new IllegalArgumentException("lora manifest must have base_ability_id");
            }
            if (q.t0(manifest.getPluginKey())) {
                throw new IllegalArgumentException("lora manifest must have plugin_key");
            }
            abilityId = d.i(manifest.getBaseAbilityId(), "-", manifest.getPluginKey());
        }
        b bVar = b.f11432e;
        b bVarA = b.a.a(manifest.getAbilityType());
        InferenceConfig config = buildInferenceConfig(manifest.getBackend());
        String modelId = manifest.getModelId();
        String modelPath = manifest.getModelFile();
        g.f(modelId, "modelId");
        g.f(modelPath, "modelPath");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i10 = InferenceConfig.f6262i;
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        g.f(config, "config");
        for (String tag : manifest.getTags()) {
            g.f(tag, "tag");
            linkedHashSet2.add(tag);
        }
        k kVar = new k(modelId, modelPath, null, null, null, kotlin.collections.a.R0(linkedHashSet), config, kotlin.collections.a.R0(linkedHashSet2), null, false, null, null, true, true);
        int i11 = a.r;
        return a.C0126a.b(abilityId, bVarA, manifest.getDescription(), kVar, null, 112);
    }

    public final List<a> mapAll(List<ModelManifest> manifests) {
        Object objA;
        g.f(manifests, "manifests");
        ArrayList arrayList = new ArrayList();
        for (ModelManifest modelManifest : manifests) {
            try {
                objA = INSTANCE.map(modelManifest);
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                a0.a.w("Skip manifest ", modelManifest.getAbilityId(), ": ", thB.getMessage(), TAG);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            a aVar = (a) objA;
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
