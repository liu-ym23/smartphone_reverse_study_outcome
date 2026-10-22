package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.CommentWallInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00108\u001a\u00020\u0006J\b\u00109\u001a\u0004\u0018\u00010\u0006J\u0010\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0006R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0012\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R \u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\u001e\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R \u0010,\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\b\"\u0004\b.\u0010\nR\u001a\u0010/\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\b\"\u0004\b7\u0010\n¨\u0006="}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/CommentPinContent;", "", "()V", "_commenterId", "", "_commenterOpenId", "", "get_commenterOpenId", "()Ljava/lang/String;", "set_commenterOpenId", "(Ljava/lang/String;)V", "_operatorOpenUid", "get_operatorOpenUid", "set_operatorOpenUid", "_operatorUid", "commentMsgId", "getCommentMsgId", "()J", "setCommentMsgId", "(J)V", "commentPinEndTime", "getCommentPinEndTime", "setCommentPinEndTime", "commentPinStartTime", "getCommentPinStartTime", "setCommentPinStartTime", "content", "getContent", "setContent", "contentType", "getContentType", "setContentType", "countDownStyle", "", "getCountDownStyle", "()I", "setCountDownStyle", "(I)V", "eventTime", "getEventTime", "setEventTime", "id", "getId", "setId", "nickName", "getNickName", "setNickName", "reviewSuccess", "", "getReviewSuccess", "()Z", "setReviewSuccess", "(Z)V", "scene", "getScene", "setScene", "getCommenterId", "getOperatorUid", "setCommenterId", "", "uid", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentPinContent implements h {

    @SerializedName("commenter_id")
    protected long _commenterId;

    @SerializedName("commenter_open_id")
    protected String _commenterOpenId;

    @SerializedName("operator_openid")
    protected String _operatorOpenUid;

    @SerializedName("operator_id")
    protected long _operatorUid;

    @SerializedName("comment_msg_id")
    protected long commentMsgId;

    @SerializedName("end_time")
    protected long commentPinEndTime;

    @SerializedName("msg_time")
    protected long commentPinStartTime;

    @SerializedName("content")
    protected String content;
    private String contentType;

    @SerializedName("countdown_style")
    protected int countDownStyle;

    @SerializedName("event_time")
    protected long eventTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected long f162580id;

    @SerializedName("commenter_nickname")
    protected String nickName;
    private boolean reviewSuccess;
    private String scene;

    public final String getCommenterId() {
        o0.a r100 = o0.f58946a;
        Long r101 = Long.valueOf(this._commenterId);
        String r102 = this._commenterOpenId;
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    public final String getOperatorUid() {
        o0.a r100 = o0.f58946a;
        Long r101 = Long.valueOf(this._operatorUid);
        String r102 = this._operatorOpenUid;
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    public CommentPinContent() {
        this.scene = "";
        this.contentType = "";
    }

    public final long getCommentMsgId() {
        return this.commentMsgId;
    }

    public final long getCommentPinEndTime() {
        return this.commentPinEndTime;
    }

    public final long getCommentPinStartTime() {
        return this.commentPinStartTime;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final int getCountDownStyle() {
        return this.countDownStyle;
    }

    public final long getEventTime() {
        return this.eventTime;
    }

    public final long getId() {
        return this.f162580id;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final boolean getReviewSuccess() {
        return this.reviewSuccess;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String get_commenterOpenId() {
        return this._commenterOpenId;
    }

    public final String get_operatorOpenUid() {
        return this._operatorOpenUid;
    }

    public CommentPinContent(g r100) {
        this.scene = "";
        this.contentType = "";
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L23;
        if (r102 != 5000) goto L8;
        this._operatorOpenUid = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 5001) goto L9;
        this._commenterOpenId = am3.h.c(r100);
        goto L3
    L9:
        switch(r102) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            default: goto L10;
        };
    L11:
        this._operatorUid = r100.j();
        goto L3
    L12:
        this.countDownStyle = r100.i();
        goto L3
    L13:
        this.commentPinEndTime = r100.j();
        goto L3
    L14:
        this.commentPinStartTime = r100.j();
        goto L3
    L15:
        this.eventTime = r100.j();
        goto L3
    L16:
        this.nickName = am3.h.c(r100);
        goto L3
    L17:
        this._commenterId = r100.j();
        goto L3
    L18:
        this.commentMsgId = r100.j();
        goto L3
    L19:
        this.f162580id = r100.j();
        goto L3
    L20:
        this.content = am3.h.c(r100);
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L23:
        r100.d(r101);
    }

    public final void setCommentMsgId(long r100) {
        this.commentMsgId = r100;
    }

    public final void setCommentPinEndTime(long r100) {
        this.commentPinEndTime = r100;
    }

    public final void setCommentPinStartTime(long r100) {
        this.commentPinStartTime = r100;
    }

    public final void setCommenterId(String r100) {
        o0.f58946a.getClass();
        this._commenterId = 0;
        this._commenterOpenId = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setContentType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.contentType = r100;
    }

    public final void setCountDownStyle(int r100) {
        this.countDownStyle = r100;
    }

    public final void setEventTime(long r100) {
        this.eventTime = r100;
    }

    public final void setId(long r100) {
        this.f162580id = r100;
    }

    public final void setNickName(String r100) {
        this.nickName = r100;
    }

    public final void setReviewSuccess(boolean r100) {
        this.reviewSuccess = r100;
    }

    public final void setScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scene = r100;
    }

    public final void set_commenterOpenId(String r100) {
        this._commenterOpenId = r100;
    }

    public final void set_operatorOpenUid(String r100) {
        this._operatorOpenUid = r100;
    }
}
