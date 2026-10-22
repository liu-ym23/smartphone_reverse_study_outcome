package com.stepos.policy.sdk.bean;

import B0.g;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import com.stepos.activeview.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u008b\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0006HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u00064"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyData;", "", "category", "", "effectTime", "id", "", "languageType", "name", "policyUid", "policyUrl", "regrantFlag", Constants.JSON_KEY_VERSION, "versionDesc", "versionName", "viewType", "policyMd5", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getEffectTime", "getId", "()I", "getLanguageType", "getName", "getPolicyMd5", "getPolicyUid", "getPolicyUrl", "getRegrantFlag", "getVersion", "getVersionDesc", "getVersionName", "getViewType", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PolicyData {

    @NotNull
    private final String category;

    @NotNull
    private final String effectTime;
    private final int id;

    @NotNull
    private final String languageType;

    @NotNull
    private final String name;

    @NotNull
    private final String policyMd5;

    @NotNull
    private final String policyUid;

    @NotNull
    private final String policyUrl;
    private final int regrantFlag;
    private final int version;

    @NotNull
    private final String versionDesc;

    @NotNull
    private final String versionName;

    @NotNull
    private final String viewType;

    public PolicyData(@NotNull String category, @NotNull String effectTime, int i4, @NotNull String languageType, @NotNull String name, @NotNull String policyUid, @NotNull String policyUrl, int i5, int i6, @NotNull String versionDesc, @NotNull String versionName, @NotNull String viewType, @NotNull String policyMd5) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(effectTime, "effectTime");
        Intrinsics.checkNotNullParameter(languageType, "languageType");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(policyUid, "policyUid");
        Intrinsics.checkNotNullParameter(policyUrl, "policyUrl");
        Intrinsics.checkNotNullParameter(versionDesc, "versionDesc");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(policyMd5, "policyMd5");
        this.category = category;
        this.effectTime = effectTime;
        this.id = i4;
        this.languageType = languageType;
        this.name = name;
        this.policyUid = policyUid;
        this.policyUrl = policyUrl;
        this.regrantFlag = i5;
        this.version = i6;
        this.versionDesc = versionDesc;
        this.versionName = versionName;
        this.viewType = viewType;
        this.policyMd5 = policyMd5;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getVersionDesc() {
        return this.versionDesc;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getViewType() {
        return this.viewType;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final String getPolicyMd5() {
        return this.policyMd5;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getEffectTime() {
        return this.effectTime;
    }

    /* renamed from: component3, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getLanguageType() {
        return this.languageType;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getPolicyUid() {
        return this.policyUid;
    }

    @NotNull
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

    @NotNull
    public final PolicyData copy(@NotNull String category, @NotNull String effectTime, int id, @NotNull String languageType, @NotNull String name, @NotNull String policyUid, @NotNull String policyUrl, int regrantFlag, int version, @NotNull String versionDesc, @NotNull String versionName, @NotNull String viewType, @NotNull String policyMd5) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(effectTime, "effectTime");
        Intrinsics.checkNotNullParameter(languageType, "languageType");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(policyUid, "policyUid");
        Intrinsics.checkNotNullParameter(policyUrl, "policyUrl");
        Intrinsics.checkNotNullParameter(versionDesc, "versionDesc");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(policyMd5, "policyMd5");
        return new PolicyData(category, effectTime, id, languageType, name, policyUid, policyUrl, regrantFlag, version, versionDesc, versionName, viewType, policyMd5);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolicyData)) {
            return false;
        }
        PolicyData policyData = (PolicyData) other;
        return Intrinsics.areEqual(this.category, policyData.category) && Intrinsics.areEqual(this.effectTime, policyData.effectTime) && this.id == policyData.id && Intrinsics.areEqual(this.languageType, policyData.languageType) && Intrinsics.areEqual(this.name, policyData.name) && Intrinsics.areEqual(this.policyUid, policyData.policyUid) && Intrinsics.areEqual(this.policyUrl, policyData.policyUrl) && this.regrantFlag == policyData.regrantFlag && this.version == policyData.version && Intrinsics.areEqual(this.versionDesc, policyData.versionDesc) && Intrinsics.areEqual(this.versionName, policyData.versionName) && Intrinsics.areEqual(this.viewType, policyData.viewType) && Intrinsics.areEqual(this.policyMd5, policyData.policyMd5);
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getEffectTime() {
        return this.effectTime;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getLanguageType() {
        return this.languageType;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPolicyMd5() {
        return this.policyMd5;
    }

    @NotNull
    public final String getPolicyUid() {
        return this.policyUid;
    }

    @NotNull
    public final String getPolicyUrl() {
        return this.policyUrl;
    }

    public final int getRegrantFlag() {
        return this.regrantFlag;
    }

    public final int getVersion() {
        return this.version;
    }

    @NotNull
    public final String getVersionDesc() {
        return this.versionDesc;
    }

    @NotNull
    public final String getVersionName() {
        return this.versionName;
    }

    @NotNull
    public final String getViewType() {
        return this.viewType;
    }

    public int hashCode() {
        return this.policyMd5.hashCode() + AbstractC0351g.d(this.viewType, AbstractC0351g.d(this.versionName, AbstractC0351g.d(this.versionDesc, g.d(this.version, g.d(this.regrantFlag, AbstractC0351g.d(this.policyUrl, AbstractC0351g.d(this.policyUid, AbstractC0351g.d(this.name, AbstractC0351g.d(this.languageType, g.d(this.id, AbstractC0351g.d(this.effectTime, this.category.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    @NotNull
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
        return g.q(sb, this.policyMd5, CoreConstants.RIGHT_PARENTHESIS_CHAR);
    }
}
