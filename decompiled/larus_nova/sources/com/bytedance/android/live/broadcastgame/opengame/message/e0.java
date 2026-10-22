package com.bytedance.android.live.broadcastgame.opengame.message;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/message/e0;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "screenShotUri", "getScreenShotUri", "startPageUrl", "getStartPageUrl", "setStartPageUrl", "(Ljava/lang/String;)V", "customizedCoverUri", "getCustomizedCoverUri", "", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "cardContent", "getCardContent", "customizedTitle", "getCustomizedTitle", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e0 {

    @SerializedName("card_content")
    private final String cardContent;

    @SerializedName("customized_cover_uri")
    private final String customizedCoverUri;

    @SerializedName("customized_title")
    private final String customizedTitle;

    @SerializedName("screen_shot_uri")
    private final String screenShotUri;

    @SerializedName("start_page_url")
    private String startPageUrl;

    @SerializedName("status")
    private int status;

    @SerializedName("title")
    private final String title;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e0) == false) goto L20;
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.screenShotUri, r101.screenShotUri) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.startPageUrl, r101.startPageUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.customizedCoverUri, r101.customizedCoverUri) == true) goto L14;
        return false;
    L14:
        if (this.status == r101.status) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.cardContent, r101.cardContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.customizedTitle, r101.customizedTitle) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.screenShotUri;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.startPageUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.customizedCoverUri;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (((r109 + r111) * 31) + this.status) * 31;
        String r113 = this.cardContent;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.customizedTitle;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
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
        return "MiniCardInfo(title=" + this.title + ", screenShotUri=" + this.screenShotUri + ", startPageUrl=" + this.startPageUrl + ", customizedCoverUri=" + this.customizedCoverUri + ", status=" + this.status + ", cardContent=" + this.cardContent + ", customizedTitle=" + this.customizedTitle + ")";
    }

    public e0() {
        Intrinsics.checkNotNullParameter("", "title");
        Intrinsics.checkNotNullParameter("", "screenShotUri");
        Intrinsics.checkNotNullParameter("", "startPageUrl");
        Intrinsics.checkNotNullParameter("", "customizedCoverUri");
        Intrinsics.checkNotNullParameter("", "cardContent");
        Intrinsics.checkNotNullParameter("", "customizedTitle");
        this.title = "";
        this.screenShotUri = "";
        this.startPageUrl = "";
        this.customizedCoverUri = "";
        this.status = 0;
        this.cardContent = "";
        this.customizedTitle = "";
    }
}
