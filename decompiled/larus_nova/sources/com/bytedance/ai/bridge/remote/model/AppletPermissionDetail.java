package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003Jv\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0007HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R&\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/AppletPermissionDetail;", "Ljava/io/Serializable;", IFlowAppIntentIDL.PARAM_APPLET_ID, "", "iconUrl", "appletName", "appletType", "", "scopesStatus", "", "Lcom/bytedance/ai/bridge/remote/model/ScopePermissionInfo;", "recentGrantedTime", "", "grantedScopeNames", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Long;Ljava/util/List;)V", "getAppletId", "()Ljava/lang/String;", "getIconUrl", "getAppletName", "getAppletType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScopesStatus", "()Ljava/util/Map;", "getRecentGrantedTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getGrantedScopeNames", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Long;Ljava/util/List;)Lcom/bytedance/ai/bridge/remote/model/AppletPermissionDetail;", "equals", "", "other", "", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPermissionDetail implements Serializable {

    @SerializedName("applet_id")
    private final String appletId;

    @SerializedName("applet_name")
    private final String appletName;

    @SerializedName("applet_type")
    private final Integer appletType;

    @SerializedName("granted_scope_names")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> grantedScopeNames;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("recent_granted_time")
    private final Long recentGrantedTime;

    @SerializedName("scopes_status")
    private final Map<String, ScopePermissionInfo> scopesStatus;

    public AppletPermissionDetail() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppletPermissionDetail copy$default(AppletPermissionDetail r100, String r101, String r102, String r103, Integer r104, Map r110, Long r111, List r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.appletId;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.iconUrl;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.appletName;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.appletType;
    L14:
        Integer r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.scopesStatus;
    L17:
        Map r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.recentGrantedTime;
    L20:
        Long r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.grantedScopeNames;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.appletId;
    }

    public final String component2() {
        return this.iconUrl;
    }

    public final String component3() {
        return this.appletName;
    }

    public final Integer component4() {
        return this.appletType;
    }

    public final Map<String, ScopePermissionInfo> component5() {
        return this.scopesStatus;
    }

    public final Long component6() {
        return this.recentGrantedTime;
    }

    public final List<String> component7() {
        return this.grantedScopeNames;
    }

    public final AppletPermissionDetail copy(String r110, String r111, String r112, Integer r113, Map<String, ScopePermissionInfo> r114, Long r115, List<String> r116) {
        return new AppletPermissionDetail(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppletPermissionDetail) == true) goto L8;
        return false;
    L8:
        AppletPermissionDetail r101 = (AppletPermissionDetail) r100;
        if (Intrinsics.areEqual(this.appletId, r101.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appletName, r101.appletName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appletType, r101.appletType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.scopesStatus, r101.scopesStatus) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.recentGrantedTime, r101.recentGrantedTime) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.grantedScopeNames, r101.grantedScopeNames) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.appletId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.iconUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.appletName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.appletType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, ScopePermissionInfo> r113 = this.scopesStatus;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.recentGrantedTime;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.grantedScopeNames;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "AppletPermissionDetail(appletId=" + this.appletId + ", iconUrl=" + this.iconUrl + ", appletName=" + this.appletName + ", appletType=" + this.appletType + ", scopesStatus=" + this.scopesStatus + ", recentGrantedTime=" + this.recentGrantedTime + ", grantedScopeNames=" + this.grantedScopeNames + ')';
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final String getAppletName() {
        return this.appletName;
    }

    public final Integer getAppletType() {
        return this.appletType;
    }

    public final List<String> getGrantedScopeNames() {
        return this.grantedScopeNames;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final Long getRecentGrantedTime() {
        return this.recentGrantedTime;
    }

    public final Map<String, ScopePermissionInfo> getScopesStatus() {
        return this.scopesStatus;
    }

    public AppletPermissionDetail(String r100, String r101, String r102, Integer r103, Map<String, ScopePermissionInfo> r104, Long r105, List<String> r106) {
        this.appletId = r100;
        this.iconUrl = r101;
        this.appletName = r102;
        this.appletType = r103;
        this.scopesStatus = r104;
        this.recentGrantedTime = r105;
        this.grantedScopeNames = r106;
    }

    public /* synthetic */ AppletPermissionDetail(String r100, String r101, String r102, Integer r103, Map r110, Long r111, List r112, int r113, DefaultConstructorMarker r114) {
        Long r104 = null;
        if ((r113 & 1) == 0) goto L5;
        String r115 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        Integer r107 = null;
    L19:
        if ((r113 & 16) == 0) goto L21;
        Map r108 = null;
    L23:
        if ((r113 & 32) != 0) goto L27;
        r104 = r111;
    L27:
        if ((r113 & 64) == 0) goto L29;
        r112 = CollectionsKt.emptyList();
    L29:
        this(r115, r105, r106, r107, r108, r104, r112);
        return;
    L21:
        r108 = r110;
        goto L23
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
