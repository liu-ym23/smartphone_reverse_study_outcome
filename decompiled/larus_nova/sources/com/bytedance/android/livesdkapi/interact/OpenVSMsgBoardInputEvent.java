package com.bytedance.android.livesdkapi.interact;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001 Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/interact/OpenVSMsgBoardInputEvent;", "", "callback", "Lcom/bytedance/android/livesdkapi/interact/OpenVSMsgBoardInputEvent$Callback;", "source", "", "showType", "gradientType", "", "tabName", "parentCommentId", "replyCommentId", "replyToUserId", "enterFromMerge", "isSelectToStory", "", "publishTitle", "(Lcom/bytedance/android/livesdkapi/interact/OpenVSMsgBoardInputEvent$Callback;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getCallback", "()Lcom/bytedance/android/livesdkapi/interact/OpenVSMsgBoardInputEvent$Callback;", "getEnterFromMerge", "()Ljava/lang/String;", "getGradientType", "()I", "()Z", "getParentCommentId", "getPublishTitle", "getReplyCommentId", "getReplyToUserId", "getShowType", "getSource", "getTabName", "Callback", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenVSMsgBoardInputEvent {
    private final Callback callback;
    private final String enterFromMerge;
    private final int gradientType;
    private final boolean isSelectToStory;
    private final String parentCommentId;
    private final String publishTitle;
    private final String replyCommentId;
    private final String replyToUserId;
    private final String showType;
    private final String source;
    private final String tabName;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&JN\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/interact/OpenVSMsgBoardInputEvent$Callback;", "", "onCancel", "", "onSend", "content", "", "commentId", "skinId", "badgeId", "parentCommentId", "replyCommentId", "replyUserId", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface Callback {
        void onCancel();

        void onSend(String r100, String r101, String r102, String r103, String r104, String r105, String r106);
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final int getGradientType() {
        return this.gradientType;
    }

    public final String getParentCommentId() {
        return this.parentCommentId;
    }

    public final String getPublishTitle() {
        return this.publishTitle;
    }

    public final String getReplyCommentId() {
        return this.replyCommentId;
    }

    public final String getReplyToUserId() {
        return this.replyToUserId;
    }

    public final String getShowType() {
        return this.showType;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final boolean isSelectToStory() {
        return this.isSelectToStory;
    }

    public OpenVSMsgBoardInputEvent(Callback r100, String r101, String r102, int r103, String r104, String r105, String r106, String r107, String r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.callback = r100;
        this.source = r101;
        this.showType = r102;
        this.gradientType = r103;
        this.tabName = r104;
        this.parentCommentId = r105;
        this.replyCommentId = r106;
        this.replyToUserId = r107;
        this.enterFromMerge = r110;
        this.isSelectToStory = r111;
        this.publishTitle = r112;
    }

    public /* synthetic */ OpenVSMsgBoardInputEvent(Callback r110, String r111, String r112, int r113, String r114, String r115, String r210, String r211, String r212, boolean r213, String r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 512) == 0) goto L5;
        boolean r116 = false;
    L6:
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r116, r214);
        return;
    L5:
        r116 = r213;
        goto L6
    }
}
