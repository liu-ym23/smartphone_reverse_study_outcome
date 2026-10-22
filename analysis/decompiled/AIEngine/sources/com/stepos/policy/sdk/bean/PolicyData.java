package com.stepos.policy.sdk.bean;

import ai.onnxruntime.a;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyData {
    private final String category;
    private final String effectTime;

    /* renamed from: id, reason: collision with root package name */
    private final int f7962id;
    private final String languageType;
    private final String name;
    private final String policyMd5;
    private final String policyUid;
    private final String policyUrl;
    private final int regrantFlag;
    private final int version;
    private final String versionDesc;
    private final String versionName;
    private final String viewType;

    public PolicyData(String category, String effectTime, int i10, String languageType, String name, String policyUid, String policyUrl, int i11, int i12, String versionDesc, String versionName, String viewType, String policyMd5) {
        g.f(category, "category");
        g.f(effectTime, "effectTime");
        g.f(languageType, "languageType");
        g.f(name, "name");
        g.f(policyUid, "policyUid");
        g.f(policyUrl, "policyUrl");
        g.f(versionDesc, "versionDesc");
        g.f(versionName, "versionName");
        g.f(viewType, "viewType");
        g.f(policyMd5, "policyMd5");
        this.category = category;
        this.effectTime = effectTime;
        this.f7962id = i10;
        this.languageType = languageType;
        this.name = name;
        this.policyUid = policyUid;
        this.policyUrl = policyUrl;
        this.regrantFlag = i11;
        this.version = i12;
        this.versionDesc = versionDesc;
        this.versionName = versionName;
        this.viewType = viewType;
        this.policyMd5 = policyMd5;
    }

    public static /* synthetic */ PolicyData copy$default(PolicyData policyData, String str, String str2, int i10, String str3, String str4, String str5, String str6, int i11, int i12, String str7, String str8, String str9, String str10, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = policyData.category;
        }
        return policyData.copy(str, (i13 & 2) != 0 ? policyData.effectTime : str2, (i13 & 4) != 0 ? policyData.f7962id : i10, (i13 & 8) != 0 ? policyData.languageType : str3, (i13 & 16) != 0 ? policyData.name : str4, (i13 & 32) != 0 ? policyData.policyUid : str5, (i13 & 64) != 0 ? policyData.policyUrl : str6, (i13 & TraceIdKeys.MAX_LENGTH) != 0 ? policyData.regrantFlag : i11, (i13 & 256) != 0 ? policyData.version : i12, (i13 & VadSessionManager.FRAME_BYTES) != 0 ? policyData.versionDesc : str7, (i13 & 1024) != 0 ? policyData.versionName : str8, (i13 & 2048) != 0 ? policyData.viewType : str9, (i13 & 4096) != 0 ? policyData.policyMd5 : str10);
    }

    public final String component1() {
        return this.category;
    }

    public final String component10() {
        return this.versionDesc;
    }

    public final String component11() {
        return this.versionName;
    }

    public final String component12() {
        return this.viewType;
    }

    public final String component13() {
        return this.policyMd5;
    }

    public final String component2() {
        return this.effectTime;
    }

    public final int component3() {
        return this.f7962id;
    }

    public final String component4() {
        return this.languageType;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.policyUid;
    }

    public final String component7() {
        return this.policyUrl;
    }

    public final int component8() {
        return this.regrantFlag;
    }

    public final int component9() {
        return this.version;
    }

    public final PolicyData copy(String category, String effectTime, int i10, String languageType, String name, String policyUid, String policyUrl, int i11, int i12, String versionDesc, String versionName, String viewType, String policyMd5) {
        g.f(category, "category");
        g.f(effectTime, "effectTime");
        g.f(languageType, "languageType");
        g.f(name, "name");
        g.f(policyUid, "policyUid");
        g.f(policyUrl, "policyUrl");
        g.f(versionDesc, "versionDesc");
        g.f(versionName, "versionName");
        g.f(viewType, "viewType");
        g.f(policyMd5, "policyMd5");
        return new PolicyData(category, effectTime, i10, languageType, name, policyUid, policyUrl, i11, i12, versionDesc, versionName, viewType, policyMd5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyData)) {
            return false;
        }
        PolicyData policyData = (PolicyData) obj;
        return g.b(this.category, policyData.category) && g.b(this.effectTime, policyData.effectTime) && this.f7962id == policyData.f7962id && g.b(this.languageType, policyData.languageType) && g.b(this.name, policyData.name) && g.b(this.policyUid, policyData.policyUid) && g.b(this.policyUrl, policyData.policyUrl) && this.regrantFlag == policyData.regrantFlag && this.version == policyData.version && g.b(this.versionDesc, policyData.versionDesc) && g.b(this.versionName, policyData.versionName) && g.b(this.viewType, policyData.viewType) && g.b(this.policyMd5, policyData.policyMd5);
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getEffectTime() {
        return this.effectTime;
    }

    public final int getId() {
        return this.f7962id;
    }

    public final String getLanguageType() {
        return this.languageType;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPolicyMd5() {
        return this.policyMd5;
    }

    public final String getPolicyUid() {
        return this.policyUid;
    }

    public final String getPolicyUrl() {
        return this.policyUrl;
    }

    public final int getRegrantFlag() {
        return this.regrantFlag;
    }

    public final int getVersion() {
        return this.version;
    }

    public final String getVersionDesc() {
        return this.versionDesc;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final String getViewType() {
        return this.viewType;
    }

    public int hashCode() {
        return this.policyMd5.hashCode() + d.a(d.a(d.a(a.d(this.version, a.d(this.regrantFlag, d.a(d.a(d.a(d.a(a.d(this.f7962id, d.a(this.category.hashCode() * 31, 31, this.effectTime), 31), 31, this.languageType), 31, this.name), 31, this.policyUid), 31, this.policyUrl), 31), 31), 31, this.versionDesc), 31, this.versionName), 31, this.viewType);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyData(category=");
        sb2.append(this.category);
        sb2.append(", effectTime=");
        sb2.append(this.effectTime);
        sb2.append(", id=");
        sb2.append(this.f7962id);
        sb2.append(", languageType=");
        sb2.append(this.languageType);
        sb2.append(", name=");
        sb2.append(this.name);
        sb2.append(", policyUid=");
        sb2.append(this.policyUid);
        sb2.append(", policyUrl=");
        sb2.append(this.policyUrl);
        sb2.append(", regrantFlag=");
        sb2.append(this.regrantFlag);
        sb2.append(", version=");
        sb2.append(this.version);
        sb2.append(", versionDesc=");
        sb2.append(this.versionDesc);
        sb2.append(", versionName=");
        sb2.append(this.versionName);
        sb2.append(", viewType=");
        sb2.append(this.viewType);
        sb2.append(", policyMd5=");
        return a.n(sb2, this.policyMd5, ')');
    }
}
