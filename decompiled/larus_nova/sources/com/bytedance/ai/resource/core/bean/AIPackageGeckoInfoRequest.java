package com.bytedance.ai.resource.core.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageGeckoInfoRequest;", "", "appList", "", "Lcom/bytedance/ai/resource/core/bean/PackageRequestItem;", "aid", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getAppList", "()Ljava/util/List;", "getAid", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIPackageGeckoInfoRequest {
    private final String aid;
    private final List<PackageRequestItem> appList;

    /* JADX WARN: Multi-variable type inference failed */
    public AIPackageGeckoInfoRequest() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPackageGeckoInfoRequest copy$default(AIPackageGeckoInfoRequest r100, List r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.appList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.aid;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<PackageRequestItem> component1() {
        return this.appList;
    }

    public final String component2() {
        return this.aid;
    }

    public final AIPackageGeckoInfoRequest copy(List<PackageRequestItem> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "appList");
        Intrinsics.checkNotNullParameter(r101, "aid");
        return new AIPackageGeckoInfoRequest(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIPackageGeckoInfoRequest) == true) goto L8;
        return false;
    L8:
        AIPackageGeckoInfoRequest r101 = (AIPackageGeckoInfoRequest) r100;
        if (Intrinsics.areEqual(this.appList, r101.appList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aid, r101.aid) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.appList.hashCode() * 31) + this.aid.hashCode();
    }

    public String toString() {
        return "AIPackageGeckoInfoRequest(appList=" + this.appList + ", aid=" + this.aid + ')';
    }

    public final String getAid() {
        return this.aid;
    }

    public final List<PackageRequestItem> getAppList() {
        return this.appList;
    }

    public AIPackageGeckoInfoRequest(List<PackageRequestItem> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "appList");
        Intrinsics.checkNotNullParameter(r101, "aid");
        this.appList = r100;
        this.aid = r101;
    }

    public /* synthetic */ AIPackageGeckoInfoRequest(List r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
