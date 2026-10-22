package com.stepos.policy.sdk.bean;

import B7.a;
import androidx.autofill.HintConstants;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u008b\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0006HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u00064"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyData;", "", QueryAlgorithmBundle.KEY_CATEGORY, "", "effectTime", "id", "", "languageType", HintConstants.AUTOFILL_HINT_NAME, "policyUid", "policyUrl", "regrantFlag", "version", "versionDesc", "versionName", "viewType", "policyMd5", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getEffectTime", "getId", "()I", "getLanguageType", "getName", "getPolicyMd5", "getPolicyUid", "getPolicyUrl", "getRegrantFlag", "getVersion", "getVersionDesc", "getVersionName", "getViewType", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PolicyData {
    private final String category;
    private final String effectTime;
    private final int id;
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

    public PolicyData(String category, String effectTime, int i, String languageType, String name, String policyUid, String policyUrl, int i6, int i10, String versionDesc, String versionName, String viewType, String policyMd5) {
        k.f(category, "category");
        k.f(effectTime, "effectTime");
        k.f(languageType, "languageType");
        k.f(name, "name");
        k.f(policyUid, "policyUid");
        k.f(policyUrl, "policyUrl");
        k.f(versionDesc, "versionDesc");
        k.f(versionName, "versionName");
        k.f(viewType, "viewType");
        k.f(policyMd5, "policyMd5");
        this.category = category;
        this.effectTime = effectTime;
        this.id = i;
        this.languageType = languageType;
        this.name = name;
        this.policyUid = policyUid;
        this.policyUrl = policyUrl;
        this.regrantFlag = i6;
        this.version = i10;
        this.versionDesc = versionDesc;
        this.versionName = versionName;
        this.viewType = viewType;
        this.policyMd5 = policyMd5;
    }

    public static /* synthetic */ PolicyData copy$default(PolicyData policyData, String str, String str2, int i, String str3, String str4, String str5, String str6, int i6, int i10, String str7, String str8, String str9, String str10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = policyData.category;
        }
        return policyData.copy(str, (i11 & 2) != 0 ? policyData.effectTime : str2, (i11 & 4) != 0 ? policyData.id : i, (i11 & 8) != 0 ? policyData.languageType : str3, (i11 & 16) != 0 ? policyData.name : str4, (i11 & 32) != 0 ? policyData.policyUid : str5, (i11 & 64) != 0 ? policyData.policyUrl : str6, (i11 & 128) != 0 ? policyData.regrantFlag : i6, (i11 & 256) != 0 ? policyData.version : i10, (i11 & 512) != 0 ? policyData.versionDesc : str7, (i11 & 1024) != 0 ? policyData.versionName : str8, (i11 & 2048) != 0 ? policyData.viewType : str9, (i11 & 4096) != 0 ? policyData.policyMd5 : str10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component10, reason: from getter */
    public final String getVersionDesc() {
        return this.versionDesc;
    }

    /* renamed from: component11, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* renamed from: component12, reason: from getter */
    public final String getViewType() {
        return this.viewType;
    }

    /* renamed from: component13, reason: from getter */
    public final String getPolicyMd5() {
        return this.policyMd5;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEffectTime() {
        return this.effectTime;
    }

    /* renamed from: component3, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLanguageType() {
        return this.languageType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPolicyUid() {
        return this.policyUid;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPolicyUrl() {
        return this.policyUrl;
    }

    /* renamed from: component8, reason: from getter */
    public final int getRegrantFlag() {
        return this.regrantFlag;
    }

    /* renamed from: component9, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final PolicyData copy(String category, String effectTime, int id, String languageType, String name, String policyUid, String policyUrl, int regrantFlag, int version, String versionDesc, String versionName, String viewType, String policyMd5) {
        k.f(category, "category");
        k.f(effectTime, "effectTime");
        k.f(languageType, "languageType");
        k.f(name, "name");
        k.f(policyUid, "policyUid");
        k.f(policyUrl, "policyUrl");
        k.f(versionDesc, "versionDesc");
        k.f(versionName, "versionName");
        k.f(viewType, "viewType");
        k.f(policyMd5, "policyMd5");
        return new PolicyData(category, effectTime, id, languageType, name, policyUid, policyUrl, regrantFlag, version, versionDesc, versionName, viewType, policyMd5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolicyData)) {
            return false;
        }
        PolicyData policyData = (PolicyData) other;
        return k.b(this.category, policyData.category) && k.b(this.effectTime, policyData.effectTime) && this.id == policyData.id && k.b(this.languageType, policyData.languageType) && k.b(this.name, policyData.name) && k.b(this.policyUid, policyData.policyUid) && k.b(this.policyUrl, policyData.policyUrl) && this.regrantFlag == policyData.regrantFlag && this.version == policyData.version && k.b(this.versionDesc, policyData.versionDesc) && k.b(this.versionName, policyData.versionName) && k.b(this.viewType, policyData.viewType) && k.b(this.policyMd5, policyData.policyMd5);
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getEffectTime() {
        return this.effectTime;
    }

    public final int getId() {
        return this.id;
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
        return this.policyMd5.hashCode() + a.c(a.c(a.c(androidx.constraintlayout.core.dsl.a.a(this.version, androidx.constraintlayout.core.dsl.a.a(this.regrantFlag, a.c(a.c(a.c(a.c(androidx.constraintlayout.core.dsl.a.a(this.id, a.c(this.category.hashCode() * 31, 31, this.effectTime), 31), 31, this.languageType), 31, this.name), 31, this.policyUid), 31, this.policyUrl), 31), 31), 31, this.versionDesc), 31, this.versionName), 31, this.viewType);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PolicyData(category=");
        sb.append(this.category);
        sb.append(", effectTime=");
        sb.append(this.effectTime);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", languageType=");
        sb.append(this.languageType);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", policyUid=");
        sb.append(this.policyUid);
        sb.append(", policyUrl=");
        sb.append(this.policyUrl);
        sb.append(", regrantFlag=");
        sb.append(this.regrantFlag);
        sb.append(", version=");
        sb.append(this.version);
        sb.append(", versionDesc=");
        sb.append(this.versionDesc);
        sb.append(", versionName=");
        sb.append(this.versionName);
        sb.append(", viewType=");
        sb.append(this.viewType);
        sb.append(", policyMd5=");
        return a.g(')', this.policyMd5, sb);
    }
}
