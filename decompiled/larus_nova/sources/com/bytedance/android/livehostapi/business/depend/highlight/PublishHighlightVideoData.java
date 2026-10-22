package com.bytedance.android.livehostapi.business.depend.highlight;

import android.app.Activity;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0010HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015¨\u00068"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/highlight/PublishHighlightVideoData;", "", "mp4Url", "", "activity", "Landroid/app/Activity;", "shootWay", "enterFrom", "mentionUserId", "mentionUserNickname", "highlightId", "roomId", "authorId", "hashtag", ContainerPosition.BODY, "callback", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostBusiness$OnLiveHighlightPublish;", "(Ljava/lang/String;Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/livehostapi/business/IMiddlewareHostBusiness$OnLiveHighlightPublish;)V", "getActivity", "()Landroid/app/Activity;", "getAuthorId", "()Ljava/lang/String;", "getBody", "getCallback", "()Lcom/bytedance/android/livehostapi/business/IMiddlewareHostBusiness$OnLiveHighlightPublish;", "getEnterFrom", "getHashtag", "getHighlightId", "highlightsContentType", "getHighlightsContentType", "setHighlightsContentType", "(Ljava/lang/String;)V", "getMentionUserId", "getMentionUserNickname", "getMp4Url", "getRoomId", "getShootWay", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublishHighlightVideoData {
    private final Activity activity;
    private final String authorId;
    private final String body;
    private final IMiddlewareHostBusiness.OnLiveHighlightPublish callback;
    private final String enterFrom;
    private final String hashtag;
    private final String highlightId;
    private String highlightsContentType;
    private final String mentionUserId;
    private final String mentionUserNickname;
    private final String mp4Url;
    private final String roomId;
    private final String shootWay;

    public static /* synthetic */ PublishHighlightVideoData copy$default(PublishHighlightVideoData r110, String r111, Activity r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212, String r213, String r214, IMiddlewareHostBusiness.OnLiveHighlightPublish r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.mp4Url;
    L7:
        if ((r216 & 2) == 0) goto L9;
        Activity r101 = r110.activity;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.shootWay;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.enterFrom;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.mentionUserId;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.mentionUserNickname;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.highlightId;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.roomId;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.authorId;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r118 = r110.hashtag;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r119 = r110.body;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        IMiddlewareHostBusiness.OnLiveHighlightPublish r108 = r110.callback;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.mp4Url;
    }

    public final String component10() {
        return this.hashtag;
    }

    public final String component11() {
        return this.body;
    }

    public final IMiddlewareHostBusiness.OnLiveHighlightPublish component12() {
        return this.callback;
    }

    public final Activity component2() {
        return this.activity;
    }

    public final String component3() {
        return this.shootWay;
    }

    public final String component4() {
        return this.enterFrom;
    }

    public final String component5() {
        return this.mentionUserId;
    }

    public final String component6() {
        return this.mentionUserNickname;
    }

    public final String component7() {
        return this.highlightId;
    }

    public final String component8() {
        return this.roomId;
    }

    public final String component9() {
        return this.authorId;
    }

    public final PublishHighlightVideoData copy(String r110, Activity r111, String r112, String r113, String r114, String r210, String r211, String r212, String r213, String r214, String r215, IMiddlewareHostBusiness.OnLiveHighlightPublish r216) {
        Intrinsics.checkNotNullParameter(r110, "mp4Url");
        Intrinsics.checkNotNullParameter(r111, "activity");
        Intrinsics.checkNotNullParameter(r112, "shootWay");
        Intrinsics.checkNotNullParameter(r113, "enterFrom");
        Intrinsics.checkNotNullParameter(r114, "mentionUserId");
        Intrinsics.checkNotNullParameter(r210, "mentionUserNickname");
        Intrinsics.checkNotNullParameter(r211, "highlightId");
        Intrinsics.checkNotNullParameter(r212, "roomId");
        Intrinsics.checkNotNullParameter(r213, "authorId");
        Intrinsics.checkNotNullParameter(r214, "hashtag");
        Intrinsics.checkNotNullParameter(r215, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r216, "callback");
        return new PublishHighlightVideoData(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PublishHighlightVideoData) == false) goto L30;
        PublishHighlightVideoData r101 = (PublishHighlightVideoData) r100;
        if (Intrinsics.areEqual(this.mp4Url, r101.mp4Url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.activity, r101.activity) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shootWay, r101.shootWay) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.mentionUserId, r101.mentionUserId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.mentionUserNickname, r101.mentionUserNickname) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.highlightId, r101.highlightId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.hashtag, r101.hashtag) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.body, r101.body) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.callback, r101.callback) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        String r100 = this.mp4Url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Activity r104 = this.activity;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.shootWay;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.enterFrom;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.mentionUserId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.mentionUserNickname;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.highlightId;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.roomId;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.authorId;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.hashtag;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.body;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        IMiddlewareHostBusiness.OnLiveHighlightPublish r134 = this.callback;
        if (r134 == null) goto L50;
        r101 = r134.hashCode();
    L50:
        return r133 + r101;
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
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

    public String toString() {
        return "PublishHighlightVideoData(mp4Url=" + this.mp4Url + ", activity=" + this.activity + ", shootWay=" + this.shootWay + ", enterFrom=" + this.enterFrom + ", mentionUserId=" + this.mentionUserId + ", mentionUserNickname=" + this.mentionUserNickname + ", highlightId=" + this.highlightId + ", roomId=" + this.roomId + ", authorId=" + this.authorId + ", hashtag=" + this.hashtag + ", body=" + this.body + ", callback=" + this.callback + ")";
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getBody() {
        return this.body;
    }

    public final IMiddlewareHostBusiness.OnLiveHighlightPublish getCallback() {
        return this.callback;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getHashtag() {
        return this.hashtag;
    }

    public final String getHighlightId() {
        return this.highlightId;
    }

    public final String getHighlightsContentType() {
        return this.highlightsContentType;
    }

    public final String getMentionUserId() {
        return this.mentionUserId;
    }

    public final String getMentionUserNickname() {
        return this.mentionUserNickname;
    }

    public final String getMp4Url() {
        return this.mp4Url;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getShootWay() {
        return this.shootWay;
    }

    public final void setHighlightsContentType(String r100) {
        this.highlightsContentType = r100;
    }

    public PublishHighlightVideoData(String r100, Activity r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, IMiddlewareHostBusiness.OnLiveHighlightPublish r113) {
        Intrinsics.checkNotNullParameter(r100, "mp4Url");
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r102, "shootWay");
        Intrinsics.checkNotNullParameter(r103, "enterFrom");
        Intrinsics.checkNotNullParameter(r104, "mentionUserId");
        Intrinsics.checkNotNullParameter(r105, "mentionUserNickname");
        Intrinsics.checkNotNullParameter(r106, "highlightId");
        Intrinsics.checkNotNullParameter(r107, "roomId");
        Intrinsics.checkNotNullParameter(r110, "authorId");
        Intrinsics.checkNotNullParameter(r111, "hashtag");
        Intrinsics.checkNotNullParameter(r112, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r113, "callback");
        this.mp4Url = r100;
        this.activity = r101;
        this.shootWay = r102;
        this.enterFrom = r103;
        this.mentionUserId = r104;
        this.mentionUserNickname = r105;
        this.highlightId = r106;
        this.roomId = r107;
        this.authorId = r110;
        this.hashtag = r111;
        this.body = r112;
        this.callback = r113;
    }
}
