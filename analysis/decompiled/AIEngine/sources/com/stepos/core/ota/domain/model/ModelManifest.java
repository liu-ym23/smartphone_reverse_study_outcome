package com.stepos.core.ota.domain.model;

import a0.a;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import gc.q;
import h0.e;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelManifest {
    private final List<String> abilities;
    private final String dekCipher;
    private final List<String> dependencies;
    private final Integrity integrity;
    private final String otaId;
    private final String resourceUrl;
    private final long sizeBytes;
    private final String updateInfo;
    private final long updateTimeMs;
    private final String url;
    private final int version;

    public ModelManifest(String otaId, int i10, String url, long j10, Integrity integrity, List<String> dependencies, List<String> abilities, String updateInfo, long j11, String resourceUrl, String str) {
        g.f(otaId, "otaId");
        g.f(url, "url");
        g.f(integrity, "integrity");
        g.f(dependencies, "dependencies");
        g.f(abilities, "abilities");
        g.f(updateInfo, "updateInfo");
        g.f(resourceUrl, "resourceUrl");
        this.otaId = otaId;
        this.version = i10;
        this.url = url;
        this.sizeBytes = j10;
        this.integrity = integrity;
        this.dependencies = dependencies;
        this.abilities = abilities;
        this.updateInfo = updateInfo;
        this.updateTimeMs = j11;
        this.resourceUrl = resourceUrl;
        this.dekCipher = str;
    }

    public static /* synthetic */ ModelManifest copy$default(ModelManifest modelManifest, String str, int i10, String str2, long j10, Integrity integrity, List list, List list2, String str3, long j11, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = modelManifest.otaId;
        }
        return modelManifest.copy(str, (i11 & 2) != 0 ? modelManifest.version : i10, (i11 & 4) != 0 ? modelManifest.url : str2, (i11 & 8) != 0 ? modelManifest.sizeBytes : j10, (i11 & 16) != 0 ? modelManifest.integrity : integrity, (i11 & 32) != 0 ? modelManifest.dependencies : list, (i11 & 64) != 0 ? modelManifest.abilities : list2, (i11 & TraceIdKeys.MAX_LENGTH) != 0 ? modelManifest.updateInfo : str3, (i11 & 256) != 0 ? modelManifest.updateTimeMs : j11, (i11 & VadSessionManager.FRAME_BYTES) != 0 ? modelManifest.resourceUrl : str4, (i11 & 1024) != 0 ? modelManifest.dekCipher : str5);
    }

    public final String component1() {
        return this.otaId;
    }

    public final String component10() {
        return this.resourceUrl;
    }

    public final String component11() {
        return this.dekCipher;
    }

    public final int component2() {
        return this.version;
    }

    public final String component3() {
        return this.url;
    }

    public final long component4() {
        return this.sizeBytes;
    }

    public final Integrity component5() {
        return this.integrity;
    }

    public final List<String> component6() {
        return this.dependencies;
    }

    public final List<String> component7() {
        return this.abilities;
    }

    public final String component8() {
        return this.updateInfo;
    }

    public final long component9() {
        return this.updateTimeMs;
    }

    public final ModelManifest copy(String otaId, int i10, String url, long j10, Integrity integrity, List<String> dependencies, List<String> abilities, String updateInfo, long j11, String resourceUrl, String str) {
        g.f(otaId, "otaId");
        g.f(url, "url");
        g.f(integrity, "integrity");
        g.f(dependencies, "dependencies");
        g.f(abilities, "abilities");
        g.f(updateInfo, "updateInfo");
        g.f(resourceUrl, "resourceUrl");
        return new ModelManifest(otaId, i10, url, j10, integrity, dependencies, abilities, updateInfo, j11, resourceUrl, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ModelManifest)) {
            return false;
        }
        ModelManifest modelManifest = (ModelManifest) obj;
        return g.b(this.otaId, modelManifest.otaId) && this.version == modelManifest.version && g.b(this.url, modelManifest.url) && this.sizeBytes == modelManifest.sizeBytes && g.b(this.integrity, modelManifest.integrity) && g.b(this.dependencies, modelManifest.dependencies) && g.b(this.abilities, modelManifest.abilities) && g.b(this.updateInfo, modelManifest.updateInfo) && this.updateTimeMs == modelManifest.updateTimeMs && g.b(this.resourceUrl, modelManifest.resourceUrl) && g.b(this.dekCipher, modelManifest.dekCipher);
    }

    public final List<String> getAbilities() {
        return this.abilities;
    }

    public final String getBaseModelId() {
        return q.J0(this.otaId, '.');
    }

    public final String getDekCipher() {
        return this.dekCipher;
    }

    public final List<String> getDependencies() {
        return this.dependencies;
    }

    public final Integrity getIntegrity() {
        return this.integrity;
    }

    public final String getOtaId() {
        return this.otaId;
    }

    public final String getPluginName() {
        if (!isPlugin()) {
            return "";
        }
        String str = this.otaId;
        g.f(str, "<this>");
        int iQ0 = q.q0(str, '.', 0, 6);
        if (iQ0 == -1) {
            return str;
        }
        String strSubstring = str.substring(iQ0 + 1, str.length());
        g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String getResourceUrl() {
        return this.resourceUrl;
    }

    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    public final String getUpdateInfo() {
        return this.updateInfo;
    }

    public final long getUpdateTimeMs() {
        return this.updateTimeMs;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iA = d.a(a.c(d.a(e.b(this.abilities, e.b(this.dependencies, (this.integrity.hashCode() + a.c(d.a(ai.onnxruntime.a.d(this.version, this.otaId.hashCode() * 31, 31), 31, this.url), this.sizeBytes, 31)) * 31, 31), 31), 31, this.updateInfo), this.updateTimeMs, 31), 31, this.resourceUrl);
        String str = this.dekCipher;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public final boolean isPlugin() {
        return q.m0(this.otaId, '.');
    }

    public String toString() {
        String str = this.otaId;
        int i10 = this.version;
        String str2 = this.url;
        long j10 = this.sizeBytes;
        Integrity integrity = this.integrity;
        List<String> list = this.dependencies;
        List<String> list2 = this.abilities;
        String str3 = this.updateInfo;
        long j11 = this.updateTimeMs;
        String str4 = this.resourceUrl;
        String str5 = this.dekCipher;
        StringBuilder sbF = e.f("ModelManifest(otaId=", str, ", version=", i10, ", url=");
        com.stepos.core.ota.d.p(j10, str2, ", sizeBytes=", sbF);
        sbF.append(", integrity=");
        sbF.append(integrity);
        sbF.append(", dependencies=");
        sbF.append(list);
        sbF.append(", abilities=");
        sbF.append(list2);
        sbF.append(", updateInfo=");
        sbF.append(str3);
        a.s(j11, ", updateTimeMs=", ", resourceUrl=", sbF);
        return com.stepos.core.ota.d.j(sbF, str4, ", dekCipher=", str5, ")");
    }

    public ModelManifest(String str, int i10, String str2, long j10, Integrity integrity, List list, List list2, String str3, long j11, String str4, String str5, int i11, kotlin.jvm.internal.e eVar) {
        this(str, i10, str2, j10, integrity, (i11 & 32) != 0 ? EmptyList.f10001a : list, (i11 & 64) != 0 ? EmptyList.f10001a : list2, (i11 & TraceIdKeys.MAX_LENGTH) != 0 ? "" : str3, (i11 & 256) != 0 ? 0L : j11, (i11 & VadSessionManager.FRAME_BYTES) != 0 ? "" : str4, (i11 & 1024) != 0 ? null : str5);
    }
}
