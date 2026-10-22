package com.bytedance.android.live.profit.scoreboard;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/g;", "", "", "index", "I", "getIndex", "()I", "", "giftName", "Ljava/lang/String;", "getGiftName", "()Ljava/lang/String;", "icon", "getIcon", "value", "getValue", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g {

    @SerializedName("gift_name")
    private final String giftName;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("index")
    private final int index;

    @SerializedName("value")
    private final int value;

    public g() {
        this(0, "", "", 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L14;
        g r101 = (g) r100;
        if (this.index == r101.index) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.giftName, r101.giftName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
        return false;
    L12:
        if (this.value == r101.value) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r100 = this.index * 31;
        String r101 = this.giftName;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.icon;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return ((r104 + r102) * 31) + this.value;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "Gift(index=" + this.index + ", giftName=" + this.giftName + ", icon=" + this.icon + ", value=" + this.value + ")";
    }

    public g(int r100, String r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "giftName");
        Intrinsics.checkNotNullParameter(r102, "icon");
        this.index = r100;
        this.giftName = r101;
        this.icon = r102;
        this.value = r103;
    }
}
