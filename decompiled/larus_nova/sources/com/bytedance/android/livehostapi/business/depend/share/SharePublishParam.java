package com.bytedance.android.livehostapi.business.depend.share;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u001a\u0010\u001c\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001a\u0010\u001f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u001a\u0010\"\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001a\u0010%\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\u001a\u0010(\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/SharePublishParam;", "", "()V", "activityVideoType", "", "getActivityVideoType", "()I", "setActivityVideoType", "(I)V", "contentType", "", "getContentType", "()Ljava/lang/String;", "setContentType", "(Ljava/lang/String;)V", "musicId", "getMusicId", "setMusicId", "onPublishLaunch", "Lkotlin/Function0;", "", "getOnPublishLaunch", "()Lkotlin/jvm/functions/Function0;", "setOnPublishLaunch", "(Lkotlin/jvm/functions/Function0;)V", "publishJumpScheme", "getPublishJumpScheme", "setPublishJumpScheme", "publishJumpTitle", "getPublishJumpTitle", "setPublishJumpTitle", "relatedReviewContent", "getRelatedReviewContent", "setRelatedReviewContent", "shareFromKey", "getShareFromKey", "setShareFromKey", "shareFromType", "getShareFromType", "setShareFromType", "shareTicketExtraJson", "getShareTicketExtraJson", "setShareTicketExtraJson", "showOutsitePushAuthPanel", "", "getShowOutsitePushAuthPanel", "()Z", "setShowOutsitePushAuthPanel", "(Z)V", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SharePublishParam {
    private int activityVideoType;
    private String contentType;
    private String musicId;
    private Function0<Unit> onPublishLaunch;
    private String publishJumpScheme;
    private String publishJumpTitle;
    private String relatedReviewContent;
    private String shareFromKey;
    private String shareFromType;
    private String shareTicketExtraJson;
    private boolean showOutsitePushAuthPanel;

    public SharePublishParam() {
        this.shareTicketExtraJson = "";
        this.publishJumpTitle = "";
        this.publishJumpScheme = "";
        this.musicId = "";
        this.shareFromKey = "";
        this.shareFromType = "";
        this.relatedReviewContent = "";
        this.contentType = "";
    }

    public final int getActivityVideoType() {
        return this.activityVideoType;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getMusicId() {
        return this.musicId;
    }

    public final Function0<Unit> getOnPublishLaunch() {
        return this.onPublishLaunch;
    }

    public final String getPublishJumpScheme() {
        return this.publishJumpScheme;
    }

    public final String getPublishJumpTitle() {
        return this.publishJumpTitle;
    }

    public final String getRelatedReviewContent() {
        return this.relatedReviewContent;
    }

    public final String getShareFromKey() {
        return this.shareFromKey;
    }

    public final String getShareFromType() {
        return this.shareFromType;
    }

    public final String getShareTicketExtraJson() {
        return this.shareTicketExtraJson;
    }

    public final boolean getShowOutsitePushAuthPanel() {
        return this.showOutsitePushAuthPanel;
    }

    public final void setActivityVideoType(int r100) {
        this.activityVideoType = r100;
    }

    public final void setContentType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.contentType = r100;
    }

    public final void setMusicId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.musicId = r100;
    }

    public final void setOnPublishLaunch(Function0<Unit> r100) {
        this.onPublishLaunch = r100;
    }

    public final void setPublishJumpScheme(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.publishJumpScheme = r100;
    }

    public final void setPublishJumpTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.publishJumpTitle = r100;
    }

    public final void setRelatedReviewContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.relatedReviewContent = r100;
    }

    public final void setShareFromKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.shareFromKey = r100;
    }

    public final void setShareFromType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.shareFromType = r100;
    }

    public final void setShareTicketExtraJson(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.shareTicketExtraJson = r100;
    }

    public final void setShowOutsitePushAuthPanel(boolean r100) {
        this.showOutsitePushAuthPanel = r100;
    }
}
