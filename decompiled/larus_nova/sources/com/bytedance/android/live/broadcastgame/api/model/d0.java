package com.bytedance.android.live.broadcastgame.api.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/d0;", "", "", "iosForDY", "Ljava/lang/String;", "getIosForDY", "()Ljava/lang/String;", "iosForHS", "getIosForHS", "androidForDY", "getAndroidForDY", "androidForHS", "getAndroidForHS", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d0 {

    @SerializedName("android_1128")
    private final String androidForDY;

    @SerializedName("android_1112")
    private final String androidForHS;

    @SerializedName("ios_1128")
    private final String iosForDY;

    @SerializedName("ios_1112")
    private final String iosForHS;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d0) == false) goto L14;
        d0 r101 = (d0) r100;
        if (Intrinsics.areEqual(this.iosForDY, r101.iosForDY) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.iosForHS, r101.iosForHS) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.androidForDY, r101.androidForDY) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.androidForHS, r101.androidForHS) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.iosForDY;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.iosForHS;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.androidForDY;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.androidForHS;
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
        return "MinSupportVersion(iosForDY=" + this.iosForDY + ", iosForHS=" + this.iosForHS + ", androidForDY=" + this.androidForDY + ", androidForHS=" + this.androidForHS + ")";
    }
}
