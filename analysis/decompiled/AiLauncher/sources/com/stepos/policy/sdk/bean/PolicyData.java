package com.stepos.policy.sdk.bean;

import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u008b\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0006HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u00064"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyData;", "", QueryAlgorithmBundle.KEY_CATEGORY, "", "effectTime", "id", "", "languageType", "name", "policyUid", "policyUrl", "regrantFlag", "version", "versionDesc", "versionName", "viewType", "policyMd5", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getEffectTime", "getId", "()I", "getLanguageType", "getName", "getPolicyMd5", "getPolicyUid", "getPolicyUrl", "getRegrantFlag", "getVersion", "getVersionDesc", "getVersionName", "getViewType", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
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

    public PolicyData(String category, String effectTime, int i10, String languageType, String name, String policyUid, String policyUrl, int i11, int i12, String versionDesc, String versionName, String viewType, String policyMd5) {
        p.i(category, "category");
        p.i(effectTime, "effectTime");
        p.i(languageType, "languageType");
        p.i(name, "name");
        p.i(policyUid, "policyUid");
        p.i(policyUrl, "policyUrl");
        p.i(versionDesc, "versionDesc");
        p.i(versionName, "versionName");
        p.i(viewType, "viewType");
        p.i(policyMd5, "policyMd5");
        this.category = category;
        this.effectTime = effectTime;
        this.id = i10;
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
        return policyData.copy(str, (i13 & 2) != 0 ? policyData.effectTime : str2, (i13 & 4) != 0 ? policyData.id : i10, (i13 & 8) != 0 ? policyData.languageType : str3, (i13 & 16) != 0 ? policyData.name : str4, (i13 & 32) != 0 ? policyData.policyUid : str5, (i13 & 64) != 0 ? policyData.policyUrl : str6, (i13 & 128) != 0 ? policyData.regrantFlag : i11, (i13 & 256) != 0 ? policyData.version : i12, (i13 & 512) != 0 ? policyData.versionDesc : str7, (i13 & 1024) != 0 ? policyData.versionName : str8, (i13 & 2048) != 0 ? policyData.viewType : str9, (i13 & 4096) != 0 ? policyData.policyMd5 : str10);
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
        p.i(category, "category");
        p.i(effectTime, "effectTime");
        p.i(languageType, "languageType");
        p.i(name, "name");
        p.i(policyUid, "policyUid");
        p.i(policyUrl, "policyUrl");
        p.i(versionDesc, "versionDesc");
        p.i(versionName, "versionName");
        p.i(viewType, "viewType");
        p.i(policyMd5, "policyMd5");
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
        return p.d(this.category, policyData.category) && p.d(this.effectTime, policyData.effectTime) && this.id == policyData.id && p.d(this.languageType, policyData.languageType) && p.d(this.name, policyData.name) && p.d(this.policyUid, policyData.policyUid) && p.d(this.policyUrl, policyData.policyUrl) && this.regrantFlag == policyData.regrantFlag && this.version == policyData.version && p.d(this.versionDesc, policyData.versionDesc) && p.d(this.versionName, policyData.versionName) && p.d(this.viewType, policyData.viewType) && p.d(this.policyMd5, policyData.policyMd5);
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
        return (((((((((((((((((((((((this.category.hashCode() * 31) + this.effectTime.hashCode()) * 31) + Integer.hashCode(this.id)) * 31) + this.languageType.hashCode()) * 31) + this.name.hashCode()) * 31) + this.policyUid.hashCode()) * 31) + this.policyUrl.hashCode()) * 31) + Integer.hashCode(this.regrantFlag)) * 31) + Integer.hashCode(this.version)) * 31) + this.versionDesc.hashCode()) * 31) + this.versionName.hashCode()) * 31) + this.viewType.hashCode()) * 31) + this.policyMd5.hashCode();
    }

    public String toString() {
        return "PolicyData(category=" + this.category + ", effectTime=" + this.effectTime + ", id=" + this.id + ", languageType=" + this.languageType + ", name=" + this.name + ", policyUid=" + this.policyUid + ", policyUrl=" + this.policyUrl + ", regrantFlag=" + this.regrantFlag + ", version=" + this.version + ", versionDesc=" + this.versionDesc + ", versionName=" + this.versionName + ", viewType=" + this.viewType + ", policyMd5=" + this.policyMd5 + ')';
    }
}
