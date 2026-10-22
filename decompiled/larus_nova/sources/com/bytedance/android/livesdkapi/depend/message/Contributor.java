package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.RoomUserSeqMessage.Contributor")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R \u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/Contributor;", "", "()V", "exactlyScore", "", "getExactlyScore", "()Ljava/lang/String;", "setExactlyScore", "(Ljava/lang/String;)V", "isHidden", "", "()Z", "setHidden", "(Z)V", "mDelta", "", "getMDelta", "()J", "setMDelta", "(J)V", "mRank", "getMRank", "setMRank", "mScore", "getMScore", "setMScore", "mUser", "Lcom/bytedance/android/live/base/model/user/User;", "getMUser", "()Lcom/bytedance/android/live/base/model/user/User;", "setMUser", "(Lcom/bytedance/android/live/base/model/user/User;)V", "scoreDescription", "getScoreDescription", "setScoreDescription", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Contributor implements h {

    @SerializedName("exactly_score")
    protected String exactlyScore;

    @SerializedName("is_hidden")
    protected boolean isHidden;

    @SerializedName("delta")
    protected long mDelta;

    @SerializedName("rank")
    protected long mRank;

    @SerializedName(a.KEY_SCORE)
    protected long mScore;

    @SerializedName("user")
    protected User mUser;

    @SerializedName("score_description")
    protected String scoreDescription;

    public Contributor() {
    }

    public final String getExactlyScore() {
        return this.exactlyScore;
    }

    public final long getMDelta() {
        return this.mDelta;
    }

    public final long getMRank() {
        return this.mRank;
    }

    public final long getMScore() {
        return this.mScore;
    }

    public final User getMUser() {
        return this.mUser;
    }

    public final String getScoreDescription() {
        return this.scoreDescription;
    }

    public final boolean isHidden() {
        return this.isHidden;
    }

    public Contributor(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.exactlyScore = am3.h.c(r100);
        goto L3
    L8:
        this.scoreDescription = am3.h.c(r100);
        goto L3
    L9:
        this.isHidden = am3.h.a(r100);
        goto L3
    L10:
        this.mDelta = r100.j();
        goto L3
    L11:
        this.mRank = r100.j();
        goto L3
    L12:
        this.mUser = new User(r100);
        goto L3
    L13:
        this.mScore = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
    }

    public final void setExactlyScore(String r100) {
        this.exactlyScore = r100;
    }

    public final void setHidden(boolean r100) {
        this.isHidden = r100;
    }

    public final void setMDelta(long r100) {
        this.mDelta = r100;
    }

    public final void setMRank(long r100) {
        this.mRank = r100;
    }

    public final void setMScore(long r100) {
        this.mScore = r100;
    }

    public final void setMUser(User r100) {
        this.mUser = r100;
    }

    public final void setScoreDescription(String r100) {
        this.scoreDescription = r100;
    }
}
