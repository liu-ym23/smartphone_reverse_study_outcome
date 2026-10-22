package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/slice/viewmanagers/u;", "", "", "text", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "tabCount", "I", "b", "()I", "tabType", "d", "Lcom/bytedance/android/shopping/new_cart/slice/viewmanagers/a;", "badgeInfo", "Lcom/bytedance/android/shopping/new_cart/slice/viewmanagers/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/shopping/new_cart/slice/viewmanagers/a;", "tabTip", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("badge_info")
    private final a badgeInfo;

    @SerializedName("tab_counts")
    private final int tabCount;

    @SerializedName("tab_tip")
    private final String tabTip;

    @SerializedName("type")
    private final String tabType;

    @SerializedName("text")
    private final String text;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L16;
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (this.tabCount == r101.tabCount) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tabType, r101.tabType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.badgeInfo, r101.badgeInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.tabTip, r101.tabTip) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.tabCount) * 31;
        String r104 = this.tabType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.badgeInfo;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.tabTip;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TabItem(text=" + this.text + ", tabCount=" + this.tabCount + ", tabType=" + this.tabType + ", badgeInfo=" + this.badgeInfo + ", tabTip=" + this.tabTip + ")";
    }

    public u() {
        this.text = "";
        this.tabCount = 0;
        this.tabType = "";
        this.badgeInfo = null;
        this.tabTip = null;
    }

    public final a a() {
        return this.badgeInfo;
    }

    public final int b() {
        return this.tabCount;
    }

    public final String c() {
        return this.tabTip;
    }

    public final String d() {
        return this.tabType;
    }

    public final String e() {
        return this.text;
    }
}
