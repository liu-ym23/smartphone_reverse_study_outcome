package com.stepos.policy.sdk.bean;

import androidx.recyclerview.widget.RecyclerView;
import com.stepos.minor.Minor;
import j4.k;

/* loaded from: classes.dex */
public final class PolicyData {
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

    public PolicyData(String str, String str2, int i5, String str3, String str4, String str5, String str6, int i6, int i7, String str7, String str8, String str9, String str10) {
        k.g(str, "category");
        k.g(str2, "effectTime");
        k.g(str3, "languageType");
        k.g(str4, Minor.COLUMN_NAME);
        k.g(str5, "policyUid");
        k.g(str6, "policyUrl");
        k.g(str7, "versionDesc");
        k.g(str8, "versionName");
        k.g(str9, "viewType");
        k.g(str10, "policyMd5");
        this.category = str;
        this.effectTime = str2;
        this.id = i5;
        this.languageType = str3;
        this.name = str4;
        this.policyUid = str5;
        this.policyUrl = str6;
        this.regrantFlag = i6;
        this.version = i7;
        this.versionDesc = str7;
        this.versionName = str8;
        this.viewType = str9;
        this.policyMd5 = str10;
    }

    public static /* synthetic */ PolicyData copy$default(PolicyData policyData, String str, String str2, int i5, String str3, String str4, String str5, String str6, int i6, int i7, String str7, String str8, String str9, String str10, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = policyData.category;
        }
        return policyData.copy(str, (i8 & 2) != 0 ? policyData.effectTime : str2, (i8 & 4) != 0 ? policyData.id : i5, (i8 & 8) != 0 ? policyData.languageType : str3, (i8 & 16) != 0 ? policyData.name : str4, (i8 & 32) != 0 ? policyData.policyUid : str5, (i8 & 64) != 0 ? policyData.policyUrl : str6, (i8 & 128) != 0 ? policyData.regrantFlag : i6, (i8 & 256) != 0 ? policyData.version : i7, (i8 & 512) != 0 ? policyData.versionDesc : str7, (i8 & 1024) != 0 ? policyData.versionName : str8, (i8 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? policyData.viewType : str9, (i8 & RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT) != 0 ? policyData.policyMd5 : str10);
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
        return this.id;
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

    public final PolicyData copy(String str, String str2, int i5, String str3, String str4, String str5, String str6, int i6, int i7, String str7, String str8, String str9, String str10) {
        k.g(str, "category");
        k.g(str2, "effectTime");
        k.g(str3, "languageType");
        k.g(str4, Minor.COLUMN_NAME);
        k.g(str5, "policyUid");
        k.g(str6, "policyUrl");
        k.g(str7, "versionDesc");
        k.g(str8, "versionName");
        k.g(str9, "viewType");
        k.g(str10, "policyMd5");
        return new PolicyData(str, str2, i5, str3, str4, str5, str6, i6, i7, str7, str8, str9, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyData)) {
            return false;
        }
        PolicyData policyData = (PolicyData) obj;
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
        return (((((((((((((((((((((((this.category.hashCode() * 31) + this.effectTime.hashCode()) * 31) + Integer.hashCode(this.id)) * 31) + this.languageType.hashCode()) * 31) + this.name.hashCode()) * 31) + this.policyUid.hashCode()) * 31) + this.policyUrl.hashCode()) * 31) + Integer.hashCode(this.regrantFlag)) * 31) + Integer.hashCode(this.version)) * 31) + this.versionDesc.hashCode()) * 31) + this.versionName.hashCode()) * 31) + this.viewType.hashCode()) * 31) + this.policyMd5.hashCode();
    }

    public String toString() {
        return "PolicyData(category=" + this.category + ", effectTime=" + this.effectTime + ", id=" + this.id + ", languageType=" + this.languageType + ", name=" + this.name + ", policyUid=" + this.policyUid + ", policyUrl=" + this.policyUrl + ", regrantFlag=" + this.regrantFlag + ", version=" + this.version + ", versionDesc=" + this.versionDesc + ", versionName=" + this.versionName + ", viewType=" + this.viewType + ", policyMd5=" + this.policyMd5 + ')';
    }
}
