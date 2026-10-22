package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/ScopePermissionInfo;", "Ljava/io/Serializable;", "grantStatus", "", "permissionType", "Lcom/bytedance/ai/bridge/remote/model/PermissionType;", "lastGrantedTime", "", "neededDescription", "", "<init>", "(Ljava/lang/Integer;Lcom/bytedance/ai/bridge/remote/model/PermissionType;Ljava/lang/Long;Ljava/lang/String;)V", "getGrantStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPermissionType", "()Lcom/bytedance/ai/bridge/remote/model/PermissionType;", "getLastGrantedTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNeededDescription", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Lcom/bytedance/ai/bridge/remote/model/PermissionType;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/ai/bridge/remote/model/ScopePermissionInfo;", "equals", "", "other", "", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScopePermissionInfo implements Serializable {

    @SerializedName("grant_status")
    private final Integer grantStatus;

    @SerializedName("last_granted_time")
    private final Long lastGrantedTime;

    @SerializedName("scope_needed_description")
    private final String neededDescription;

    @SerializedName("permission_type")
    private final PermissionType permissionType;

    public ScopePermissionInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ScopePermissionInfo copy$default(ScopePermissionInfo r100, Integer r101, PermissionType r102, Long r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.grantStatus;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.permissionType;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.lastGrantedTime;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.neededDescription;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.grantStatus;
    }

    public final PermissionType component2() {
        return this.permissionType;
    }

    public final Long component3() {
        return this.lastGrantedTime;
    }

    public final String component4() {
        return this.neededDescription;
    }

    public final ScopePermissionInfo copy(Integer r100, PermissionType r101, Long r102, String r103) {
        return new ScopePermissionInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ScopePermissionInfo) == true) goto L8;
        return false;
    L8:
        ScopePermissionInfo r101 = (ScopePermissionInfo) r100;
        if (Intrinsics.areEqual(this.grantStatus, r101.grantStatus) == true) goto L12;
        return false;
    L12:
        if (this.permissionType == r101.permissionType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lastGrantedTime, r101.lastGrantedTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.neededDescription, r101.neededDescription) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.grantStatus;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PermissionType r104 = this.permissionType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.lastGrantedTime;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.neededDescription;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ScopePermissionInfo(grantStatus=" + this.grantStatus + ", permissionType=" + this.permissionType + ", lastGrantedTime=" + this.lastGrantedTime + ", neededDescription=" + this.neededDescription + ')';
    }

    public final Integer getGrantStatus() {
        return this.grantStatus;
    }

    public final Long getLastGrantedTime() {
        return this.lastGrantedTime;
    }

    public final String getNeededDescription() {
        return this.neededDescription;
    }

    public final PermissionType getPermissionType() {
        return this.permissionType;
    }

    public ScopePermissionInfo(Integer r100, PermissionType r101, Long r102, String r103) {
        this.grantStatus = r100;
        this.permissionType = r101;
        this.lastGrantedTime = r102;
        this.neededDescription = r103;
    }

    public /* synthetic */ ScopePermissionInfo(Integer r100, PermissionType r101, Long r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
