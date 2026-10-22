package com.stepos.policy.sdk.bean;

import B0.g;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import com.stepos.activeview.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyRecordBaseInfo;", "", "category", "", "policyId", Constants.JSON_KEY_VERSION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getPolicyId", "setPolicyId", "getVersion", "setVersion", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PolicyRecordBaseInfo {

    @NotNull
    private String category;

    @NotNull
    private String policyId;

    @NotNull
    private String version;

    public PolicyRecordBaseInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PolicyRecordBaseInfo copy$default(PolicyRecordBaseInfo policyRecordBaseInfo, String str, String str2, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = policyRecordBaseInfo.category;
        }
        if ((i4 & 2) != 0) {
            str2 = policyRecordBaseInfo.policyId;
        }
        if ((i4 & 4) != 0) {
            str3 = policyRecordBaseInfo.version;
        }
        return policyRecordBaseInfo.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getPolicyId() {
        return this.policyId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    public final PolicyRecordBaseInfo copy(@NotNull String category, @NotNull String policyId, @NotNull String version) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(policyId, "policyId");
        Intrinsics.checkNotNullParameter(version, "version");
        return new PolicyRecordBaseInfo(category, policyId, version);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolicyRecordBaseInfo)) {
            return false;
        }
        PolicyRecordBaseInfo policyRecordBaseInfo = (PolicyRecordBaseInfo) other;
        return Intrinsics.areEqual(this.category, policyRecordBaseInfo.category) && Intrinsics.areEqual(this.policyId, policyRecordBaseInfo.policyId) && Intrinsics.areEqual(this.version, policyRecordBaseInfo.version);
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getPolicyId() {
        return this.policyId;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.version.hashCode() + AbstractC0351g.d(this.policyId, this.category.hashCode() * 31, 31);
    }

    public final void setCategory(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.category = str;
    }

    public final void setPolicyId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.policyId = str;
    }

    public final void setVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("PolicyRecordBaseInfo(category=");
        sb.append(this.category);
        sb.append(", policyId=");
        sb.append(this.policyId);
        sb.append(", version=");
        return g.q(sb, this.version, CoreConstants.RIGHT_PARENTHESIS_CHAR);
    }

    public PolicyRecordBaseInfo(@NotNull String category, @NotNull String policyId, @NotNull String version) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(policyId, "policyId");
        Intrinsics.checkNotNullParameter(version, "version");
        this.category = category;
        this.policyId = policyId;
        this.version = version;
    }

    public /* synthetic */ PolicyRecordBaseInfo(String str, String str2, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? "" : str3);
    }
}
