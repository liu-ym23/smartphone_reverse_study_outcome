package com.bytedance.android.live.profit.scoreboard;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/n1;", "", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "avatar", "getAvatar", "point", "getPoint", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class n1 {

    @SerializedName("avatar")
    private final String avatar;

    @SerializedName("name")
    private final String name;

    @SerializedName("points")
    private final String point;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n1) == false) goto L12;
        n1 r101 = (n1) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.point, r101.point) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.avatar;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.point;
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

    public final String toString() {
        return "User(name=" + this.name + ", avatar=" + this.avatar + ", point=" + this.point + ")";
    }

    public n1() {
        this("", "", "0");
    }

    public n1(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "avatar");
        Intrinsics.checkNotNullParameter(r102, "point");
        this.name = r100;
        this.avatar = r101;
        this.point = r102;
    }
}
