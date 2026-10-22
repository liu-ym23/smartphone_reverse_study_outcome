package com.bytedance.android.live.profit.privilege.model.danmu;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002J\u0019\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\t\u0010\t\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\f\u001a\u00020\nHÆ\u0003J\t\u0010\u000e\u001a\u00020\rHÆ\u0003JU\u0010\u0015\u001a\u00020\u00002\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\rHÆ\u0001J\t\u0010\u0016\u001a\u00020\rHÖ\u0001J\t\u0010\u0017\u001a\u00020\nHÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003R'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u0010\u0010\u001eR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\u0012\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0013\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b#\u0010\"R\u0017\u0010\u0014\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/danmu/DanmakuTabList;", "", "", "isEmpty", "", "Lcom/bytedance/android/live/profit/privilege/model/danmu/b;", "Lcom/bytedance/revenue/platform/api/core/KmpMutableList;", "component1", "component2", "component3", "", "component4", "component5", "", "component6", "list", "isPrivilegeBarrageAvailable", "hasAdminTab", "adminTabIndex", "shadowType", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "copy", "toString", "hashCode", "other", "equals", "Ljava/util/List;", "getList", "()Ljava/util/List;", "Z", "()Z", "getHasAdminTab", "I", "getAdminTabIndex", "()I", "getShadowType", "Ljava/lang/String;", "getErrorReason", "()Ljava/lang/String;", "<init>", "(Ljava/util/List;ZZIILjava/lang/String;)V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DanmakuTabList {
    private final int adminTabIndex;
    private final String errorReason;
    private final boolean hasAdminTab;
    private final boolean isPrivilegeBarrageAvailable;
    private final List<b> list;
    private final int shadowType;

    public DanmakuTabList() {
        this(null, false, false, 0, 0, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DanmakuTabList copy$default(DanmakuTabList r100, List r101, boolean r102, boolean r103, int r104, int r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.list;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.isPrivilegeBarrageAvailable;
    L8:
        boolean r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.hasAdminTab;
    L11:
        boolean r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.adminTabIndex;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.shadowType;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.errorReason;
    L20:
        List r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final List<b> component1() {
        return this.list;
    }

    public final boolean component2() {
        return this.isPrivilegeBarrageAvailable;
    }

    public final boolean component3() {
        return this.hasAdminTab;
    }

    public final int component4() {
        return this.adminTabIndex;
    }

    public final int component5() {
        return this.shadowType;
    }

    public final String component6() {
        return this.errorReason;
    }

    public final DanmakuTabList copy(List<b> r100, boolean r110, boolean r111, int r112, int r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Intrinsics.checkNotNullParameter(r114, HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON);
        return new DanmakuTabList(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DanmakuTabList) == false) goto L18;
        DanmakuTabList r101 = (DanmakuTabList) r100;
        if (Intrinsics.areEqual(this.list, r101.list) == true) goto L8;
        return false;
    L8:
        if (this.isPrivilegeBarrageAvailable == r101.isPrivilegeBarrageAvailable) goto L10;
        return false;
    L10:
        if (this.hasAdminTab == r101.hasAdminTab) goto L12;
        return false;
    L12:
        if (this.adminTabIndex == r101.adminTabIndex) goto L14;
        return false;
    L14:
        if (this.shadowType == r101.shadowType) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.errorReason, r101.errorReason) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        List<b> r100 = this.list;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.isPrivilegeBarrageAvailable;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.hasAdminTab;
        if (r108 == true) goto L13;
        r105 = r108;
    L13:
        int r109 = (((((r107 + r105) * 31) + this.adminTabIndex) * 31) + this.shadowType) * 31;
        String r110 = this.errorReason;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "DanmakuTabList(list=" + this.list + ", isPrivilegeBarrageAvailable=" + this.isPrivilegeBarrageAvailable + ", hasAdminTab=" + this.hasAdminTab + ", adminTabIndex=" + this.adminTabIndex + ", shadowType=" + this.shadowType + ", errorReason=" + this.errorReason + ")";
    }

    public final boolean isEmpty() {
        return this.list.isEmpty();
    }

    public final int getAdminTabIndex() {
        return this.adminTabIndex;
    }

    public final String getErrorReason() {
        return this.errorReason;
    }

    public final boolean getHasAdminTab() {
        return this.hasAdminTab;
    }

    public final List<b> getList() {
        return this.list;
    }

    public final int getShadowType() {
        return this.shadowType;
    }

    public final boolean isPrivilegeBarrageAvailable() {
        return this.isPrivilegeBarrageAvailable;
    }

    public DanmakuTabList(List<b> r100, boolean r101, boolean r102, int r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Intrinsics.checkNotNullParameter(r105, HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON);
        this.list = r100;
        this.isPrivilegeBarrageAvailable = r101;
        this.hasAdminTab = r102;
        this.adminTabIndex = r103;
        this.shadowType = r104;
        this.errorReason = r105;
    }

    public /* synthetic */ DanmakuTabList(List r100, boolean r101, boolean r102, int r103, int r104, String r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r111 & 2) == 0) goto L8;
        boolean r113 = true;
    L9:
        int r105 = 0;
        if ((r111 & 4) == 0) goto L12;
        boolean r106 = false;
    L14:
        if ((r111 & 8) == 0) goto L16;
        int r107 = -1;
    L18:
        if ((r111 & 16) != 0) goto L22;
        r105 = r104;
    L22:
        if ((r111 & 32) == 0) goto L24;
        r110 = "";
    L24:
        String r108 = r110;
        this(r100, r113, r106, r107, r105, r108);
        return;
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L9
    }
}
