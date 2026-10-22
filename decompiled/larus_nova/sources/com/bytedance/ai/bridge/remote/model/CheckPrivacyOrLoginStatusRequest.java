package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u000fHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/CheckPrivacyOrLoginStatusRequest;", "Ljava/io/Serializable;", b.f276376z, "", "versionTag", "checkTypeEnum", "Lcom/bytedance/ai/bridge/remote/model/CheckType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/bridge/remote/model/CheckType;)V", "getAppKey", "()Ljava/lang/String;", "getVersionTag", "getCheckTypeEnum", "()Lcom/bytedance/ai/bridge/remote/model/CheckType;", "checkType", "", "getCheckType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckPrivacyOrLoginStatusRequest implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient CheckType f36082a;

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("check_type")
    private final Integer checkType;

    @SerializedName("version_tag")
    private final String versionTag;

    public CheckPrivacyOrLoginStatusRequest() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CheckPrivacyOrLoginStatusRequest copy$default(CheckPrivacyOrLoginStatusRequest r100, String r101, String r102, CheckType r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.appKey;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.versionTag;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.f36082a;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.appKey;
    }

    public final String component2() {
        return this.versionTag;
    }

    public final CheckType component3() {
        return this.f36082a;
    }

    public final CheckPrivacyOrLoginStatusRequest copy(String r100, String r101, CheckType r102) {
        return new CheckPrivacyOrLoginStatusRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CheckPrivacyOrLoginStatusRequest) == true) goto L8;
        return false;
    L8:
        CheckPrivacyOrLoginStatusRequest r101 = (CheckPrivacyOrLoginStatusRequest) r100;
        if (Intrinsics.areEqual(this.appKey, r101.appKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.versionTag, r101.versionTag) == true) goto L15;
        return false;
    L15:
        if (this.f36082a == r101.f36082a) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.appKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.versionTag;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        CheckType r107 = this.f36082a;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CheckPrivacyOrLoginStatusRequest(appKey=" + this.appKey + ", versionTag=" + this.versionTag + ", checkTypeEnum=" + this.f36082a + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final Integer getCheckType() {
        return this.checkType;
    }

    public final CheckType getCheckTypeEnum() {
        return this.f36082a;
    }

    public final String getVersionTag() {
        return this.versionTag;
    }

    public CheckPrivacyOrLoginStatusRequest(String r100, String r101, CheckType r102) {
        this.appKey = r100;
        this.versionTag = r101;
        this.f36082a = r102;
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf(r102.getValue());
    L6:
        this.checkType = r103;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public /* synthetic */ CheckPrivacyOrLoginStatusRequest(String r100, String r101, CheckType r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
