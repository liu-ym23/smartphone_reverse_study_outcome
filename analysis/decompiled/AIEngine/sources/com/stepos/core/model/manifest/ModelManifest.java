package com.stepos.core.model.manifest;

import ai.onnxruntime.a;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.List;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelManifest {
    public static final String BACKEND_LLAMA_CPP = "llama_cpp";
    public static final String BACKEND_MNN = "mnn";
    public static final String BACKEND_NONE = "none";
    public static final String BACKEND_QNN_LLM = "qnn_llm";
    public static final String BACKEND_QNN_TTS = "qnn_tts";
    public static final String BACKEND_QNN_VLM = "qnn_vlm";
    public static final Companion Companion = new Companion(null);
    public static final String TYPE_LORA = "lora";
    public static final String TYPE_MODEL = "model";
    private final String abilityId;
    private final String abilityType;
    private final String backend;
    private final String baseAbilityId;
    private final String description;
    private final String manifestType;
    private final String modelFile;
    private final String modelId;
    private final String pluginKey;
    private final List<String> tags;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public ModelManifest(String abilityId, String manifestType, String abilityType, String description, String modelId, String modelFile, String backend, List<String> tags, String baseAbilityId, String pluginKey) {
        g.f(abilityId, "abilityId");
        g.f(manifestType, "manifestType");
        g.f(abilityType, "abilityType");
        g.f(description, "description");
        g.f(modelId, "modelId");
        g.f(modelFile, "modelFile");
        g.f(backend, "backend");
        g.f(tags, "tags");
        g.f(baseAbilityId, "baseAbilityId");
        g.f(pluginKey, "pluginKey");
        this.abilityId = abilityId;
        this.manifestType = manifestType;
        this.abilityType = abilityType;
        this.description = description;
        this.modelId = modelId;
        this.modelFile = modelFile;
        this.backend = backend;
        this.tags = tags;
        this.baseAbilityId = baseAbilityId;
        this.pluginKey = pluginKey;
    }

    public static /* synthetic */ ModelManifest copy$default(ModelManifest modelManifest, String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, String str8, String str9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = modelManifest.abilityId;
        }
        if ((i10 & 2) != 0) {
            str2 = modelManifest.manifestType;
        }
        if ((i10 & 4) != 0) {
            str3 = modelManifest.abilityType;
        }
        if ((i10 & 8) != 0) {
            str4 = modelManifest.description;
        }
        if ((i10 & 16) != 0) {
            str5 = modelManifest.modelId;
        }
        if ((i10 & 32) != 0) {
            str6 = modelManifest.modelFile;
        }
        if ((i10 & 64) != 0) {
            str7 = modelManifest.backend;
        }
        if ((i10 & TraceIdKeys.MAX_LENGTH) != 0) {
            list = modelManifest.tags;
        }
        if ((i10 & 256) != 0) {
            str8 = modelManifest.baseAbilityId;
        }
        if ((i10 & VadSessionManager.FRAME_BYTES) != 0) {
            str9 = modelManifest.pluginKey;
        }
        String str10 = str8;
        String str11 = str9;
        String str12 = str7;
        List list2 = list;
        String str13 = str5;
        String str14 = str6;
        return modelManifest.copy(str, str2, str3, str4, str13, str14, str12, list2, str10, str11);
    }

    public final String component1() {
        return this.abilityId;
    }

    public final String component10() {
        return this.pluginKey;
    }

    public final String component2() {
        return this.manifestType;
    }

    public final String component3() {
        return this.abilityType;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.modelId;
    }

    public final String component6() {
        return this.modelFile;
    }

    public final String component7() {
        return this.backend;
    }

    public final List<String> component8() {
        return this.tags;
    }

    public final String component9() {
        return this.baseAbilityId;
    }

    public final ModelManifest copy(String abilityId, String manifestType, String abilityType, String description, String modelId, String modelFile, String backend, List<String> tags, String baseAbilityId, String pluginKey) {
        g.f(abilityId, "abilityId");
        g.f(manifestType, "manifestType");
        g.f(abilityType, "abilityType");
        g.f(description, "description");
        g.f(modelId, "modelId");
        g.f(modelFile, "modelFile");
        g.f(backend, "backend");
        g.f(tags, "tags");
        g.f(baseAbilityId, "baseAbilityId");
        g.f(pluginKey, "pluginKey");
        return new ModelManifest(abilityId, manifestType, abilityType, description, modelId, modelFile, backend, tags, baseAbilityId, pluginKey);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ModelManifest)) {
            return false;
        }
        ModelManifest modelManifest = (ModelManifest) obj;
        return g.b(this.abilityId, modelManifest.abilityId) && g.b(this.manifestType, modelManifest.manifestType) && g.b(this.abilityType, modelManifest.abilityType) && g.b(this.description, modelManifest.description) && g.b(this.modelId, modelManifest.modelId) && g.b(this.modelFile, modelManifest.modelFile) && g.b(this.backend, modelManifest.backend) && g.b(this.tags, modelManifest.tags) && g.b(this.baseAbilityId, modelManifest.baseAbilityId) && g.b(this.pluginKey, modelManifest.pluginKey);
    }

    public final String getAbilityId() {
        return this.abilityId;
    }

    public final String getAbilityType() {
        return this.abilityType;
    }

    public final String getBackend() {
        return this.backend;
    }

    public final String getBaseAbilityId() {
        return this.baseAbilityId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getManifestType() {
        return this.manifestType;
    }

    public final String getModelFile() {
        return this.modelFile;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final String getPluginKey() {
        return this.pluginKey;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        return this.pluginKey.hashCode() + d.a(h0.e.b(this.tags, d.a(d.a(d.a(d.a(d.a(d.a(this.abilityId.hashCode() * 31, 31, this.manifestType), 31, this.abilityType), 31, this.description), 31, this.modelId), 31, this.modelFile), 31, this.backend), 31), 31, this.baseAbilityId);
    }

    public String toString() {
        String str = this.abilityId;
        String str2 = this.manifestType;
        String str3 = this.abilityType;
        String str4 = this.description;
        String str5 = this.modelId;
        String str6 = this.modelFile;
        String str7 = this.backend;
        List<String> list = this.tags;
        String str8 = this.baseAbilityId;
        String str9 = this.pluginKey;
        StringBuilder sbS = a.s("ModelManifest(abilityId=", str, ", manifestType=", str2, ", abilityType=");
        a.z(sbS, str3, ", description=", str4, ", modelId=");
        a.z(sbS, str5, ", modelFile=", str6, ", backend=");
        sbS.append(str7);
        sbS.append(", tags=");
        sbS.append(list);
        sbS.append(", baseAbilityId=");
        return com.stepos.core.ota.d.j(sbS, str8, ", pluginKey=", str9, ")");
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public ModelManifest(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.util.List r19, java.lang.String r20, java.lang.String r21, int r22, kotlin.jvm.internal.e r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 2
            if (r1 == 0) goto L8
            java.lang.String r13 = "model"
        L8:
            r2 = r13
            r13 = r0 & 8
            java.lang.String r1 = ""
            if (r13 == 0) goto L11
            r4 = r1
            goto L12
        L11:
            r4 = r15
        L12:
            r13 = r0 & 64
            if (r13 == 0) goto L1a
            java.lang.String r13 = "none"
            r7 = r13
            goto L1c
        L1a:
            r7 = r18
        L1c:
            r13 = r0 & 128(0x80, float:1.8E-43)
            if (r13 == 0) goto L24
            kotlin.collections.EmptyList r13 = kotlin.collections.EmptyList.f10001a
            r8 = r13
            goto L26
        L24:
            r8 = r19
        L26:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L2c
            r9 = r1
            goto L2e
        L2c:
            r9 = r20
        L2e:
            r13 = r0 & 512(0x200, float:7.17E-43)
            if (r13 == 0) goto L3b
            r10 = r1
            r0 = r11
            r3 = r14
            r5 = r16
            r6 = r17
            r1 = r12
            goto L44
        L3b:
            r10 = r21
            r0 = r11
            r1 = r12
            r3 = r14
            r5 = r16
            r6 = r17
        L44:
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.manifest.ModelManifest.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, int, kotlin.jvm.internal.e):void");
    }
}
