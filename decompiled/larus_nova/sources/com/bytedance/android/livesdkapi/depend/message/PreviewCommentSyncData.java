package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PreviewCommentSyncData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010(\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\u0013H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\u001a\u0010 \u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR\u001a\u0010#\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000e¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/PreviewCommentSyncData;", "", "()V", "count", "", "getCount", "()I", "setCount", "(I)V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "hideReason", "getHideReason", "setHideReason", "hotComment", "", "getHotComment", "()Ljava/lang/String;", "setHotComment", "(Ljava/lang/String;)V", "isShowing", "", "()Z", "setShowing", "(Z)V", "seqId", "getSeqId", "setSeqId", "showTime", "getShowTime", "setShowTime", "stopTime", "getStopTime", "setStopTime", "equals", "other", "hashCode", "toString", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewCommentSyncData implements h {
    public static final Companion Companion = null;
    public static final long FREQUENCY_CONTROL_FIVE_MINUTES = 300000;
    public static final long FREQUENCY_CONTROL_THIRTY_SECONDS = 30000;
    public static final int HIDE_REASON_ENTER_ROOM = 3;
    public static final int HIDE_REASON_SLIDE_OUT = 2;
    public static final int HIDE_REASON_TIME_OUT = 1;
    public static final String SYNC_KEY = "PreviewCommentSyncData";
    private int count;

    @SerializedName("hot_comment_time")
    protected long createTime;
    private int hideReason;

    @SerializedName("hot_comment")
    protected String hotComment;
    private boolean isShowing;

    @SerializedName("hot_comment_sequence_id")
    protected long seqId;
    private long showTime;
    private long stopTime;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/PreviewCommentSyncData$Companion;", "", "()V", "FREQUENCY_CONTROL_FIVE_MINUTES", "", "FREQUENCY_CONTROL_THIRTY_SECONDS", "HIDE_REASON_ENTER_ROOM", "", "HIDE_REASON_SLIDE_OUT", "HIDE_REASON_TIME_OUT", "SYNC_KEY", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public int hashCode() {
        String r100 = this.hotComment;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.seqId;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public String toString() {
        return "PreviewCommentSyncData{ hotComment =" + this.hotComment + " createTime = " + this.createTime + " seqId = " + this.seqId + " isShowing " + this.isShowing + " showTime = " + this.showTime + " stopTime = " + this.stopTime + " hideReason = " + this.hideReason + " count = " + this.count + i.f25855d;
    }

    public PreviewCommentSyncData() {
        this.hotComment = "";
    }

    public final int getCount() {
        return this.count;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final int getHideReason() {
        return this.hideReason;
    }

    public final String getHotComment() {
        return this.hotComment;
    }

    public final long getSeqId() {
        return this.seqId;
    }

    public final long getShowTime() {
        return this.showTime;
    }

    public final long getStopTime() {
        return this.stopTime;
    }

    public final boolean isShowing() {
        return this.isShowing;
    }

    public PreviewCommentSyncData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.hotComment = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.createTime = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.seqId = r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.hotComment != null) goto L31;
        this.hotComment = "";
        return;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(PreviewCommentSyncData.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L21;
        PreviewCommentSyncData r102 = (PreviewCommentSyncData) r100;
        if ((!Intrinsics.areEqual(this.hotComment, r102.hotComment)) == false) goto L17;
        return false;
    L17:
        if (this.seqId == r102.seqId) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.message.PreviewCommentSyncData");
    L8:
        r101 = null;
        goto L10
    }

    public final void setCount(int r100) {
        this.count = r100;
    }

    public final void setCreateTime(long r100) {
        this.createTime = r100;
    }

    public final void setHideReason(int r100) {
        this.hideReason = r100;
    }

    public final void setHotComment(String r100) {
        this.hotComment = r100;
    }

    public final void setSeqId(long r100) {
        this.seqId = r100;
    }

    public final void setShowTime(long r100) {
        this.showTime = r100;
    }

    public final void setShowing(boolean r100) {
        this.isShowing = r100;
    }

    public final void setStopTime(long r100) {
        this.stopTime = r100;
    }
}
