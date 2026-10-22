package com.stepos.policy.sdk.bean;

import B0.g;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006$"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyServiceConfigBean;", "", "id", "", "serviceId", "code", "", "businessType", "appId", "idType", "publicFlag", "deleteType", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAppId", "()Ljava/lang/String;", "getBusinessType", "getCode", "getDeleteType", "()I", "getIdType", "getPublicFlag", "getServiceId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PolicyServiceConfigBean {

    @NotNull
    private final String appId;

    @NotNull
    private final String businessType;

    @NotNull
    private final String code;
    private final int deleteType;
    private int id;

    @NotNull
    private final String idType;
    private final int publicFlag;
    private final int serviceId;

    public PolicyServiceConfigBean() {
        this(0, 0, null, null, null, null, 0, 0, 255, null);
    }

    /* renamed from: component1, reason: from getter */
    private final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getServiceId() {
        return this.serviceId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getBusinessType() {
        return this.businessType;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getIdType() {
        return this.idType;
    }

    /* renamed from: component7, reason: from getter */
    public final int getPublicFlag() {
        return this.publicFlag;
    }

    /* renamed from: component8, reason: from getter */
    public final int getDeleteType() {
        return this.deleteType;
    }

    @NotNull
    public final PolicyServiceConfigBean copy(int id, int serviceId, @NotNull String code, @NotNull String businessType, @NotNull String appId, @NotNull String idType, int publicFlag, int deleteType) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(idType, "idType");
        return new PolicyServiceConfigBean(id, serviceId, code, businessType, appId, idType, publicFlag, deleteType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolicyServiceConfigBean)) {
            return false;
        }
        PolicyServiceConfigBean policyServiceConfigBean = (PolicyServiceConfigBean) other;
        return this.id == policyServiceConfigBean.id && this.serviceId == policyServiceConfigBean.serviceId && Intrinsics.areEqual(this.code, policyServiceConfigBean.code) && Intrinsics.areEqual(this.businessType, policyServiceConfigBean.businessType) && Intrinsics.areEqual(this.appId, policyServiceConfigBean.appId) && Intrinsics.areEqual(this.idType, policyServiceConfigBean.idType) && this.publicFlag == policyServiceConfigBean.publicFlag && this.deleteType == policyServiceConfigBean.deleteType;
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    public final String getBusinessType() {
        return this.businessType;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    public final int getDeleteType() {
        return this.deleteType;
    }

    @NotNull
    public final String getIdType() {
        return this.idType;
    }

    public final int getPublicFlag() {
        return this.publicFlag;
    }

    public final int getServiceId() {
        return this.serviceId;
    }

    public int hashCode() {
        return Integer.hashCode(this.deleteType) + g.d(this.publicFlag, AbstractC0351g.d(this.idType, AbstractC0351g.d(this.appId, AbstractC0351g.d(this.businessType, AbstractC0351g.d(this.code, g.d(this.serviceId, Integer.hashCode(this.id) * 31, 31), 31), 31), 31), 31), 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("PolicyServiceConfigBean(id=");
        sb.append(this.id);
        sb.append(", serviceId=");
        sb.append(this.serviceId);
        sb.append(", code=");
        sb.append(this.code);
        sb.append(", businessType=");
        sb.append(this.businessType);
        sb.append(", appId=");
        sb.append(this.appId);
        sb.append(", idType=");
        sb.append(this.idType);
        sb.append(", publicFlag=");
        sb.append(this.publicFlag);
        sb.append(", deleteType=");
        return g.o(sb, this.deleteType, CoreConstants.RIGHT_PARENTHESIS_CHAR);
    }

    public PolicyServiceConfigBean(int i4, int i5, @NotNull String code, @NotNull String businessType, @NotNull String appId, @NotNull String idType, int i6, int i7) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(idType, "idType");
        this.id = i4;
        this.serviceId = i5;
        this.code = code;
        this.businessType = businessType;
        this.appId = appId;
        this.idType = idType;
        this.publicFlag = i6;
        this.deleteType = i7;
    }

    public /* synthetic */ PolicyServiceConfigBean(int i4, int i5, String str, String str2, String str3, String str4, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 0 : i4, (i8 & 2) != 0 ? 0 : i5, (i8 & 4) != 0 ? "" : str, (i8 & 8) != 0 ? "" : str2, (i8 & 16) != 0 ? "" : str3, (i8 & 32) != 0 ? "" : str4, (i8 & 64) != 0 ? 0 : i6, (i8 & 128) != 0 ? 0 : i7);
    }
}
