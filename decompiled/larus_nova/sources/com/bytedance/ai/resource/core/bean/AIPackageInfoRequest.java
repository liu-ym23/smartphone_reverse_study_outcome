package com.bytedance.ai.resource.core.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageInfoRequest;", "", "packageList", "", "Lcom/bytedance/ai/resource/core/bean/PackageRequestItem;", "aid", "", "extraInfo", "Lcom/bytedance/ai/resource/core/bean/ExtraInfo;", "<init>", "(Ljava/util/List;Ljava/lang/String;Lcom/bytedance/ai/resource/core/bean/ExtraInfo;)V", "getPackageList", "()Ljava/util/List;", "getAid", "()Ljava/lang/String;", "getExtraInfo", "()Lcom/bytedance/ai/resource/core/bean/ExtraInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIPackageInfoRequest {
    private final String aid;
    private final ExtraInfo extraInfo;
    private final List<PackageRequestItem> packageList;

    public AIPackageInfoRequest() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPackageInfoRequest copy$default(AIPackageInfoRequest r100, List r101, String r102, ExtraInfo r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.packageList;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.aid;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.extraInfo;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<PackageRequestItem> component1() {
        return this.packageList;
    }

    public final String component2() {
        return this.aid;
    }

    public final ExtraInfo component3() {
        return this.extraInfo;
    }

    public final AIPackageInfoRequest copy(List<PackageRequestItem> r100, String r101, ExtraInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "packageList");
        Intrinsics.checkNotNullParameter(r101, "aid");
        return new AIPackageInfoRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIPackageInfoRequest) == true) goto L8;
        return false;
    L8:
        AIPackageInfoRequest r101 = (AIPackageInfoRequest) r100;
        if (Intrinsics.areEqual(this.packageList, r101.packageList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aid, r101.aid) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.packageList.hashCode() * 31) + this.aid.hashCode()) * 31;
        ExtraInfo r101 = this.extraInfo;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "AIPackageInfoRequest(packageList=" + this.packageList + ", aid=" + this.aid + ", extraInfo=" + this.extraInfo + ')';
    }

    public final String getAid() {
        return this.aid;
    }

    public final ExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public final List<PackageRequestItem> getPackageList() {
        return this.packageList;
    }

    public AIPackageInfoRequest(List<PackageRequestItem> r100, String r101, ExtraInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "packageList");
        Intrinsics.checkNotNullParameter(r101, "aid");
        this.packageList = r100;
        this.aid = r101;
        this.extraInfo = r102;
    }

    public /* synthetic */ AIPackageInfoRequest(List r100, String r101, ExtraInfo r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
