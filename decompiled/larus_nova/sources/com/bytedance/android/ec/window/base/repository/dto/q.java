package com.bytedance.android.ec.window.base.repository.dto;

import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001e\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/dto/q;", "", "", "id", "J", "d", "()J", "", "name", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "isCurrent", "Z", "f", "()Z", "canReverse", "b", "", "defaultSort", "I", "c", "()I", "Lcom/bytedance/android/ec/window/base/repository/dto/a;", IAllianceService.CONTENT_TYPE_BADGE, "Lcom/bytedance/android/ec/window/base/repository/dto/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/window/base/repository/dto/a;", "dataId", "getDataId", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("badge_info")
    private final a badge;

    @SerializedName("can_reverse")
    private final boolean canReverse;

    @SerializedName("data_id")
    private final String dataId;

    @SerializedName("default_sort")
    private final int defaultSort;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final long f49446id;

    @SerializedName("is_current")
    private final boolean isCurrent;

    @SerializedName("name")
    private final String name;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L20;
        q r101 = (q) r100;
        if (this.f49446id == r101.f49446id) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (this.isCurrent == r101.isCurrent) goto L12;
        return false;
    L12:
        if (this.canReverse == r101.canReverse) goto L14;
        return false;
    L14:
        if (this.defaultSort == r101.defaultSort) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.badge, r101.badge) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.dataId, r101.dataId) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        long r100 = this.f49446id;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.name;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        boolean r106 = this.isCurrent;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L9;
        r108 = 1;
    L9:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.canReverse;
        if (r110 == true) goto L13;
        r107 = r110;
    L13:
        int r111 = (((r109 + r107) * 31) + this.defaultSort) * 31;
        a r112 = this.badge;
        if (r112 == null) goto L16;
        int r113 = r112.hashCode();
    L17:
        int r114 = (r111 + r113) * 31;
        String r115 = this.dataId;
        if (r115 == null) goto L21;
        r103 = r115.hashCode();
    L21:
        return r114 + r103;
    L16:
        r113 = 0;
        goto L17
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "StoreV2SortTypeDTO(id=" + this.f49446id + ", name=" + this.name + ", isCurrent=" + this.isCurrent + ", canReverse=" + this.canReverse + ", defaultSort=" + this.defaultSort + ", badge=" + this.badge + ", dataId=" + this.dataId + ")";
    }

    public q() {
        Intrinsics.checkNotNullParameter("", "name");
        this.f49446id = 0;
        this.name = "";
        this.isCurrent = false;
        this.canReverse = false;
        this.defaultSort = 0;
        this.badge = null;
        this.dataId = null;
    }

    public final a a() {
        return this.badge;
    }

    public final boolean b() {
        return this.canReverse;
    }

    public final int c() {
        return this.defaultSort;
    }

    public final long d() {
        return this.f49446id;
    }

    public final String e() {
        return this.name;
    }

    public final boolean f() {
        return this.isCurrent;
    }
}
