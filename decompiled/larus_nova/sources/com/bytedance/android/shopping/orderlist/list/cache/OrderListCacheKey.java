package com.bytedance.android.shopping.orderlist.list.cache;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/cache/OrderListCacheKey;", "", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "userId", "bizIdentity", "tabId", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "getBizIdentity", "getTabId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListCacheKey implements Serializable {

    @SerializedName("biz_identity")
    private final String bizIdentity;

    @SerializedName("tab_id")
    private final String tabId;

    @SerializedName("user_id")
    private final String userId;

    public static /* synthetic */ OrderListCacheKey copy$default(OrderListCacheKey r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.userId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.bizIdentity;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.tabId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.bizIdentity;
    }

    public final String component3() {
        return this.tabId;
    }

    public final OrderListCacheKey copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "bizIdentity");
        Intrinsics.checkNotNullParameter(r102, "tabId");
        return new OrderListCacheKey(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OrderListCacheKey) == false) goto L12;
        OrderListCacheKey r101 = (OrderListCacheKey) r100;
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bizIdentity, r101.bizIdentity) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tabId, r101.tabId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.userId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.bizIdentity;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.tabId;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "OrderListCacheKey(userId=" + this.userId + ", bizIdentity=" + this.bizIdentity + ", tabId=" + this.tabId + ")";
    }

    public final String getBizIdentity() {
        return this.bizIdentity;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public OrderListCacheKey(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "bizIdentity");
        Intrinsics.checkNotNullParameter(r102, "tabId");
        this.userId = r100;
        this.bizIdentity = r101;
        this.tabId = r102;
    }
}
