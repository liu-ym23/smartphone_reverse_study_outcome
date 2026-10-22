package com.bytedance.ai.bridge.remote.model;

import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
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

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/AppletPermissionQuery;", "Ljava/io/Serializable;", IFlowAppIntentIDL.PARAM_APPLET_ID, "", ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getAppletId", "()Ljava/lang/String;", "getScopes", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPermissionQuery implements Serializable {

    @SerializedName("applet_id")
    private final String appletId;

    @SerializedName(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE)
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> scopes;

    /* JADX WARN: Multi-variable type inference failed */
    public AppletPermissionQuery() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppletPermissionQuery copy$default(AppletPermissionQuery r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.appletId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.scopes;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.appletId;
    }

    public final List<String> component2() {
        return this.scopes;
    }

    public final AppletPermissionQuery copy(String r100, List<String> r101) {
        return new AppletPermissionQuery(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppletPermissionQuery) == true) goto L8;
        return false;
    L8:
        AppletPermissionQuery r101 = (AppletPermissionQuery) r100;
        if (Intrinsics.areEqual(this.appletId, r101.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scopes, r101.scopes) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.appletId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.scopes;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AppletPermissionQuery(appletId=" + this.appletId + ", scopes=" + this.scopes + ')';
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final List<String> getScopes() {
        return this.scopes;
    }

    public AppletPermissionQuery(String r100, List<String> r101) {
        this.appletId = r100;
        this.scopes = r101;
    }

    public /* synthetic */ AppletPermissionQuery(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        this(r100, r101);
    }
}
