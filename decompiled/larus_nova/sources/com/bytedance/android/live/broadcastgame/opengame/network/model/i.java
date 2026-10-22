package com.bytedance.android.live.broadcastgame.opengame.network.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/model/i;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/f;", "image", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/f;", "d", "()Lcom/bytedance/android/live/broadcastgame/opengame/network/model/f;", "", "description", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "title", "e", "btnTitle", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "fadeColor", "c", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("btn_title")
    private final String btnTitle;

    @SerializedName("description")
    private final String description;

    @SerializedName("fade_color")
    private final String fadeColor;

    @SerializedName("CardImage")
    private final f image;

    @SerializedName("title")
    private final String title;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L16;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.btnTitle, r101.btnTitle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fadeColor, r101.fadeColor) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        f r100 = this.image;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.description;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.title;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.btnTitle;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.fadeColor;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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
        return "GameCard(image=" + this.image + ", description=" + this.description + ", title=" + this.title + ", btnTitle=" + this.btnTitle + ", fadeColor=" + this.fadeColor + ")";
    }

    public final String a() {
        return this.btnTitle;
    }

    public final String b() {
        return this.description;
    }

    public final String c() {
        return this.fadeColor;
    }

    public final f d() {
        return this.image;
    }

    public final String e() {
        return this.title;
    }
}
