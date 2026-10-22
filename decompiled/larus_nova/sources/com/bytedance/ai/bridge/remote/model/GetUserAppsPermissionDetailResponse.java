package com.bytedance.ai.bridge.remote.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/GetUserAppsPermissionDetailResponse;", "Ljava/io/Serializable;", "errCode", "", "errMsg", "", "appletsScopeManageInfo", "", "Lcom/bytedance/ai/bridge/remote/model/AppletPermissionDetail;", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getAppletsScopeManageInfo", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetUserAppsPermissionDetailResponse implements Serializable {

    @SerializedName("applets_scope_manage_info")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<AppletPermissionDetail> appletsScopeManageInfo;

    @SerializedName("err_code")
    private final int errCode;

    @SerializedName(LocationMonitorConst.ERR_MSG)
    private final String errMsg;

    public GetUserAppsPermissionDetailResponse() {
        this(0, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetUserAppsPermissionDetailResponse copy$default(GetUserAppsPermissionDetailResponse r100, int r101, String r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.errCode;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.errMsg;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.appletsScopeManageInfo;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.errCode;
    }

    public final String component2() {
        return this.errMsg;
    }

    public final List<AppletPermissionDetail> component3() {
        return this.appletsScopeManageInfo;
    }

    public final GetUserAppsPermissionDetailResponse copy(int r100, String r101, List<AppletPermissionDetail> r102) {
        return new GetUserAppsPermissionDetailResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetUserAppsPermissionDetailResponse) == true) goto L8;
        return false;
    L8:
        GetUserAppsPermissionDetailResponse r101 = (GetUserAppsPermissionDetailResponse) r100;
        if (this.errCode == r101.errCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errMsg, r101.errMsg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appletsScopeManageInfo, r101.appletsScopeManageInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.errCode * 31;
        String r101 = this.errMsg;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<AppletPermissionDetail> r105 = this.appletsScopeManageInfo;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "GetUserAppsPermissionDetailResponse(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", appletsScopeManageInfo=" + this.appletsScopeManageInfo + ')';
    }

    public final List<AppletPermissionDetail> getAppletsScopeManageInfo() {
        return this.appletsScopeManageInfo;
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public GetUserAppsPermissionDetailResponse(int r100, String r101, List<AppletPermissionDetail> r102) {
        this.errCode = r100;
        this.errMsg = r101;
        this.appletsScopeManageInfo = r102;
    }

    public /* synthetic */ GetUserAppsPermissionDetailResponse(int r100, String r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = CollectionsKt.emptyList();
    L11:
        this(r100, r101, r102);
    }
}
