package com.stepos.policy.sdk.bean;

import androidx.activity.b;
import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import k0.a;
import s.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyData {
    private final String category;
    private final String effectTime;

    /* renamed from: id, reason: collision with root package name */
    private final int f2787id;
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

    public PolicyData(String str, String str2, int i, String str3, String str4, String str5, String str6, int i3, int i10, String str7, String str8, String str9, String str10) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        str7.getClass();
        str8.getClass();
        str9.getClass();
        str10.getClass();
        this.category = str;
        this.effectTime = str2;
        this.f2787id = i;
        this.languageType = str3;
        this.name = str4;
        this.policyUid = str5;
        this.policyUrl = str6;
        this.regrantFlag = i3;
        this.version = i10;
        this.versionDesc = str7;
        this.versionName = str8;
        this.viewType = str9;
        this.policyMd5 = str10;
    }

    public static /* synthetic */ PolicyData copy$default(PolicyData policyData, String str, String str2, int i, String str3, String str4, String str5, String str6, int i3, int i10, String str7, String str8, String str9, String str10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = policyData.category;
        }
        return policyData.copy(str, (i11 & 2) != 0 ? policyData.effectTime : str2, (i11 & 4) != 0 ? policyData.f2787id : i, (i11 & 8) != 0 ? policyData.languageType : str3, (i11 & 16) != 0 ? policyData.name : str4, (i11 & 32) != 0 ? policyData.policyUid : str5, (i11 & 64) != 0 ? policyData.policyUrl : str6, (i11 & 128) != 0 ? policyData.regrantFlag : i3, (i11 & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0 ? policyData.version : i10, (i11 & 512) != 0 ? policyData.versionDesc : str7, (i11 & 1024) != 0 ? policyData.versionName : str8, (i11 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? policyData.viewType : str9, (i11 & 4096) != 0 ? policyData.policyMd5 : str10);
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
        return this.f2787id;
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

    public final PolicyData copy(String str, String str2, int i, String str3, String str4, String str5, String str6, int i3, int i10, String str7, String str8, String str9, String str10) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        str7.getClass();
        str8.getClass();
        str9.getClass();
        str10.getClass();
        return new PolicyData(str, str2, i, str3, str4, str5, str6, i3, i10, str7, str8, str9, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyData)) {
            return false;
        }
        PolicyData policyData = (PolicyData) obj;
        return k.a(this.category, policyData.category) && k.a(this.effectTime, policyData.effectTime) && this.f2787id == policyData.f2787id && k.a(this.languageType, policyData.languageType) && k.a(this.name, policyData.name) && k.a(this.policyUid, policyData.policyUid) && k.a(this.policyUrl, policyData.policyUrl) && this.regrantFlag == policyData.regrantFlag && this.version == policyData.version && k.a(this.versionDesc, policyData.versionDesc) && k.a(this.versionName, policyData.versionName) && k.a(this.viewType, policyData.viewType) && k.a(this.policyMd5, policyData.policyMd5);
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getEffectTime() {
        return this.effectTime;
    }

    public final int getId() {
        return this.f2787id;
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
        return this.policyMd5.hashCode() + b.d(b.d(b.d(f.b(this.version, f.b(this.regrantFlag, b.d(b.d(b.d(b.d(f.b(this.f2787id, b.d(this.category.hashCode() * 31, 31, this.effectTime), 31), 31, this.languageType), 31, this.name), 31, this.policyUid), 31, this.policyUrl), 31), 31), 31, this.versionDesc), 31, this.versionName), 31, this.viewType);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyData(category=");
        sb2.append(this.category);
        sb2.append(", effectTime=");
        sb2.append(this.effectTime);
        sb2.append(", id=");
        sb2.append(this.f2787id);
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
        return a.s(sb2, this.policyMd5, ')');
    }
}
