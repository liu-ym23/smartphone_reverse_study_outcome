package com.bytedance.ai.bridge.remote.model;

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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/GetUserAppsPermissionDetailRequest;", "Ljava/io/Serializable;", "appletsList", "", "Lcom/bytedance/ai/bridge/remote/model/AppletPermissionQuery;", "language", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getAppletsList", "()Ljava/util/List;", "getLanguage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetUserAppsPermissionDetailRequest implements Serializable {

    @SerializedName("applets_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<AppletPermissionQuery> appletsList;

    @SerializedName("language")
    private final String language;

    /* JADX WARN: Multi-variable type inference failed */
    public GetUserAppsPermissionDetailRequest() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetUserAppsPermissionDetailRequest copy$default(GetUserAppsPermissionDetailRequest r100, List r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.appletsList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.language;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<AppletPermissionQuery> component1() {
        return this.appletsList;
    }

    public final String component2() {
        return this.language;
    }

    public final GetUserAppsPermissionDetailRequest copy(List<AppletPermissionQuery> r100, String r101) {
        return new GetUserAppsPermissionDetailRequest(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetUserAppsPermissionDetailRequest) == true) goto L8;
        return false;
    L8:
        GetUserAppsPermissionDetailRequest r101 = (GetUserAppsPermissionDetailRequest) r100;
        if (Intrinsics.areEqual(this.appletsList, r101.appletsList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.language, r101.language) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<AppletPermissionQuery> r100 = this.appletsList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.language;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GetUserAppsPermissionDetailRequest(appletsList=" + this.appletsList + ", language=" + this.language + ')';
    }

    public final List<AppletPermissionQuery> getAppletsList() {
        return this.appletsList;
    }

    public final String getLanguage() {
        return this.language;
    }

    public GetUserAppsPermissionDetailRequest(List<AppletPermissionQuery> r100, String r101) {
        this.appletsList = r100;
        this.language = r101;
    }

    public /* synthetic */ GetUserAppsPermissionDetailRequest(List r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
