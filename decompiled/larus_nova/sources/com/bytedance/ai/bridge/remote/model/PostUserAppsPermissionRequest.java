package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p4.q;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/PostUserAppsPermissionRequest;", "Ljava/io/Serializable;", IFlowAppIntentIDL.PARAM_APPLET_ID, "", "updateScopeInfo", "Lcom/bytedance/ai/bridge/remote/model/ScopeGrantedStatus;", "usingScopeInfos", "", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/bridge/remote/model/ScopeGrantedStatus;Ljava/util/List;)V", "getAppletId", "()Ljava/lang/String;", "getUpdateScopeInfo", "()Lcom/bytedance/ai/bridge/remote/model/ScopeGrantedStatus;", "getUsingScopeInfos", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PostUserAppsPermissionRequest implements Serializable {

    @SerializedName("applet_id")
    private final String appletId;

    @SerializedName("update_scope_info")
    private final q updateScopeInfo;

    @SerializedName("using_scope_infos")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> usingScopeInfos;

    public PostUserAppsPermissionRequest() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PostUserAppsPermissionRequest copy$default(PostUserAppsPermissionRequest r100, String r101, q r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.appletId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.updateScopeInfo;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.usingScopeInfos;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.appletId;
    }

    public final q component2() {
        return this.updateScopeInfo;
    }

    public final List<String> component3() {
        return this.usingScopeInfos;
    }

    public final PostUserAppsPermissionRequest copy(String r100, q r101, List<String> r102) {
        return new PostUserAppsPermissionRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PostUserAppsPermissionRequest) == true) goto L8;
        return false;
    L8:
        PostUserAppsPermissionRequest r101 = (PostUserAppsPermissionRequest) r100;
        if (Intrinsics.areEqual(this.appletId, r101.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.updateScopeInfo, r101.updateScopeInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.usingScopeInfos, r101.usingScopeInfos) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.appletId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        q r104 = this.updateScopeInfo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.usingScopeInfos;
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
        return "PostUserAppsPermissionRequest(appletId=" + this.appletId + ", updateScopeInfo=" + this.updateScopeInfo + ", usingScopeInfos=" + this.usingScopeInfos + ')';
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final q getUpdateScopeInfo() {
        return this.updateScopeInfo;
    }

    public final List<String> getUsingScopeInfos() {
        return this.usingScopeInfos;
    }

    public PostUserAppsPermissionRequest(String r100, q r101, List<String> r102) {
        this.appletId = r100;
        this.updateScopeInfo = r101;
        this.usingScopeInfos = r102;
    }

    public /* synthetic */ PostUserAppsPermissionRequest(String r100, q r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
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
