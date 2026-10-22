package com.bytedance.android.gamecp.business.comment.data;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.gamecp.host_api.model.user.User;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.CommentInfo")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0016\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\tR\u0016\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\tR\u0016\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\tR\u0016\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/data/s;", "", "", "replyId", "Ljava/lang/String;", "commentId", "gameId", "", GXTemplateKey.GAIAX_LAYER, "J", "Lcom/bytedance/android/gamecp/host_api/model/user/User;", "user", "Lcom/bytedance/android/gamecp/host_api/model/user/User;", "parentReplyId", "replyUser", "replyToReplyId", "content", "createTime", "likeCount", "childReplyCount", "relationTypeFlag", "", "commentStatus", "I", "Lcom/bytedance/android/gamecp/business/comment/data/m;", "userExtra", "Lcom/bytedance/android/gamecp/business/comment/data/m;", "", "isOwnReply", "Ljava/lang/Boolean;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s implements vh7.h {

    @SerializedName("comment_count")
    public long childReplyCount;

    @SerializedName("eval_id")
    public String commentId;

    @SerializedName("comment_status")
    public int commentStatus;

    @SerializedName("content")
    public String content;

    @SerializedName("create_time")
    public long createTime;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName("is_own_reply")
    public Boolean isOwnReply;

    @SerializedName(GXTemplateKey.GAIAX_LAYER)
    public long layer;

    @SerializedName("like_count")
    public long likeCount;

    @SerializedName("reply_to_comment_id")
    public String parentReplyId;

    @SerializedName("relation_type_flag")
    public long relationTypeFlag;

    @SerializedName("comment_id")
    public String replyId;

    @SerializedName("reply_to_reply_id")
    public String replyToReplyId;

    @SerializedName("reply_to_game_user")
    public User replyUser;

    @SerializedName("game_user")
    public User user;

    @SerializedName("user_extra")
    public m userExtra;

    public s() {
        this.replyId = "";
        this.commentId = "";
        this.parentReplyId = "";
        this.replyToReplyId = "";
        this.commentStatus = -1;
        this.isOwnReply = Boolean.FALSE;
    }

    public s(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L23;
        switch(r103) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L6;
            case 6: goto L18;
            case 7: goto L6;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L15;
            case 11: goto L14;
            case 12: goto L13;
            case 13: goto L12;
            case 14: goto L11;
            case 15: goto L10;
            case 16: goto L9;
            case 17: goto L8;
            case 18: goto L7;
            default: goto L6;
        };
    L7:
        this.isOwnReply = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        this.replyUser = new User(r100);
        goto L3
    L9:
        this.user = new User(r100);
        goto L3
    L10:
        this.userExtra = new m(r100);
        goto L3
    L11:
        this.commentStatus = r100.i();
        r102 = r102 | true;
        goto L3
    L12:
        this.relationTypeFlag = r100.j();
        goto L3
    L13:
        this.childReplyCount = r100.j();
        goto L3
    L14:
        this.likeCount = r100.j();
        goto L3
    L15:
        this.createTime = r100.j();
        goto L3
    L16:
        this.content = am3.h.c(r100);
        goto L3
    L17:
        this.replyToReplyId = am3.h.c(r100);
        goto L3
    L18:
        this.parentReplyId = am3.h.c(r100);
        goto L3
    L19:
        this.layer = r100.j();
        goto L3
    L20:
        this.gameId = am3.h.c(r100);
        goto L3
    L21:
        this.commentId = am3.h.c(r100);
        goto L3
    L22:
        this.replyId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L23:
        r100.d(r101);
        if (this.replyId != null) goto L27;
        this.replyId = "";
    L27:
        if (this.commentId != null) goto L30;
        this.commentId = "";
    L30:
        if (this.parentReplyId != null) goto L33;
        this.parentReplyId = "";
    L33:
        if (this.replyToReplyId != null) goto L36;
        this.replyToReplyId = "";
    L36:
        if ((r102 & true) == true) goto L39;
        this.commentStatus = -1;
    L39:
        if (this.isOwnReply != null) goto L78;
        this.isOwnReply = Boolean.FALSE;
        return;
    }
}
