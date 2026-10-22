package com.bytedance.android.livesdk.chatroom.msgboard;

import am3.g;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/msgboard/VSMsgBoardCommentListSyncData;", "", "()V", "comments", "", "", "getComments", "()Ljava/util/List;", "setComments", "(Ljava/util/List;)V", "nextTimeStamp", "", "getNextTimeStamp", "()J", "setNextTimeStamp", "(J)V", "totalCommentNumber", "", "getTotalCommentNumber", "()I", "setTotalCommentNumber", "(I)V", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSMsgBoardCommentListSyncData implements h {

    @SerializedName("comments")
    protected List<String> comments;

    @SerializedName("next_timestamp")
    protected long nextTimeStamp;

    @SerializedName("total_comment_number")
    protected int totalCommentNumber;

    public VSMsgBoardCommentListSyncData() {
    }

    public final List<String> getComments() {
        return this.comments;
    }

    public final long getNextTimeStamp() {
        return this.nextTimeStamp;
    }

    public final int getTotalCommentNumber() {
        return this.totalCommentNumber;
    }

    public VSMsgBoardCommentListSyncData(g r100) {
        this.comments = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.comments.add(am3.h.c(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.nextTimeStamp = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.totalCommentNumber = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setComments(List<String> r100) {
        this.comments = r100;
    }

    public final void setNextTimeStamp(long r100) {
        this.nextTimeStamp = r100;
    }

    public final void setTotalCommentNumber(int r100) {
        this.totalCommentNumber = r100;
    }
}
