package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.im.LinkMicMethod.UserScores")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b1\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b<\u0010=R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR+\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R+\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\u0018R+\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\u0018R\u001b\u0010 \u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\fR\u001b\u0010#\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u0011R\u001b\u0010&\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010\fR\u001b\u0010)\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010\u0007R\u001b\u0010,\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0005\u001a\u0004\b+\u0010\u0011R\u001b\u0010/\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0005\u001a\u0004\b.\u0010\u0011R\u001b\u00101\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0005\u001a\u0004\b1\u0010\fR\u001b\u00104\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0005\u001a\u0004\b3\u0010\u0007R\u001b\u00107\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0005\u001a\u0004\b6\u0010\u0011R\u001d\u0010;\u001a\u0004\u0018\u00010\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0005\u001a\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleMessageScoreFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/t1;", "", "userId$delegate", "Ljava/lang/Object;", "getUserId", "()Ljava/lang/String;", "userId", "", "isHugeRewardPk$delegate", "isHugeRewardPk", "()Z", "", "<set-?>", "score$delegate", "getScore", "()J", "setScore", "(J)V", com.bytedance.android.ec.core.event.a.KEY_SCORE, "scoreText$delegate", "getScoreText", "setScoreText", "(Ljava/lang/String;)V", "scoreText", "scoreRelativeText$delegate", "getScoreRelativeText", "setScoreRelativeText", "scoreRelativeText", "roomLikeTrigger$delegate", "getRoomLikeTrigger", "roomLikeTrigger", "battleRank$delegate", "getBattleRank", "battleRank", "newScoreOpen$delegate", "getNewScoreOpen", "newScoreOpen", "multiPkTeamScoreText$delegate", "getMultiPkTeamScoreText", "multiPkTeamScoreText", "multiPkTeamScore$delegate", "getMultiPkTeamScore", "multiPkTeamScore", "multiPkTeamRank$delegate", "getMultiPkTeamRank", "multiPkTeamRank", "isMultiPkTeamRelativeText$delegate", "isMultiPkTeamRelativeText", "curAddScoreText$delegate", "getCurAddScoreText", "curAddScoreText", "buffScoreRatio$delegate", "getBuffScoreRatio", "buffScoreRatio", "scoreVersion$delegate", "getScoreVersion", "()Ljava/lang/Long;", "scoreVersion", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleMessageScoreFlexImpl extends FlexModelBase<t1> implements t1, vh7.h {

    @SerializedName("battle_rank")
    protected long _$$battleRank;

    @SerializedName("buff_score_ratio")
    protected long _$$buffScoreRatio;

    @SerializedName("cur_add_score_text")
    protected String _$$curAddScoreText;

    @SerializedName("is_large_pk_score")
    protected boolean _$$isHugeRewardPk;

    @SerializedName("is_multi_pk_relative_text")
    protected boolean _$$isMultiPkTeamRelativeText;

    @SerializedName("multi_pk_team_rank")
    protected long _$$multiPkTeamRank;

    @SerializedName("multi_pk_team_score")
    protected long _$$multiPkTeamScore;

    @SerializedName("multi_pk_team_score_text")
    protected String _$$multiPkTeamScoreText;

    @SerializedName("new_score_open")
    protected boolean _$$newScoreOpen;

    @SerializedName("room_like_trigger")
    protected boolean _$$roomLikeTrigger;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    protected long _$$score;

    @SerializedName("score_relative_text")
    protected String _$$scoreRelativeText;

    @SerializedName("score_blur_text")
    protected String _$$scoreText;

    @SerializedName("score_version")
    protected Long _$$scoreVersion;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String _$$userId;

    public IBattleMessageScoreFlexImpl() {
        super(t1.class);
        this._$$isHugeRewardPk = false;
        this._$$scoreText = "";
        this._$$scoreRelativeText = "";
        this._$$roomLikeTrigger = false;
        this._$$newScoreOpen = false;
        this._$$multiPkTeamScoreText = "";
        this._$$isMultiPkTeamRelativeText = false;
        this._$$curAddScoreText = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.t1, af2.b
    public final long getBattleRank() {
        return this._$$battleRank;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1
    public final long getBuffScoreRatio() {
        return this._$$buffScoreRatio;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1
    public final String getCurAddScoreText() {
        return this._$$curAddScoreText;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1, af2.b
    public final long getMultiPkTeamRank() {
        return this._$$multiPkTeamRank;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1, af2.b
    public final long getMultiPkTeamScore() {
        return this._$$multiPkTeamScore;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1, af2.b
    public final String getMultiPkTeamScoreText() {
        return this._$$multiPkTeamScoreText;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1, af2.b
    public final boolean getNewScoreOpen() {
        return this._$$newScoreOpen;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1
    public final boolean getRoomLikeTrigger() {
        return this._$$roomLikeTrigger;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1
    public final long getScore() {
        return this._$$score;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1, af2.b
    public final String getScoreRelativeText() {
        return this._$$scoreRelativeText;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1, af2.b
    public final String getScoreText() {
        return this._$$scoreText;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1
    public final Long getScoreVersion() {
        return this._$$scoreVersion;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1
    public final String getUserId() {
        return this._$$userId;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1, af2.b
    public final boolean isHugeRewardPk() {
        return this._$$isHugeRewardPk;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1, af2.b
    public final boolean isMultiPkTeamRelativeText() {
        return this._$$isMultiPkTeamRelativeText;
    }

    public IBattleMessageScoreFlexImpl(am3.g r100) {
        super(t1.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L28;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$score = r100.j();
        r102 = r102 | 2;
        goto L3
    L8:
        if (r103 != 17) goto L10;
        this._$$scoreVersion = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r103 != 5000) goto L11;
        this._$$userId = am3.h.c(r100);
        goto L3
    L11:
        switch(r103) {
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            case 14: goto L14;
            case 15: goto L13;
            default: goto L12;
        };
    L13:
        this._$$buffScoreRatio = r100.j();
        r102 = r102 | 256;
        goto L3
    L14:
        this._$$curAddScoreText = am3.h.c(r100);
        goto L3
    L15:
        this._$$isMultiPkTeamRelativeText = am3.h.a(r100);
        r102 = r102 | 128;
        goto L3
    L16:
        this._$$multiPkTeamRank = r100.j();
        r102 = r102 | 64;
        goto L3
    L17:
        this._$$multiPkTeamScore = r100.j();
        r102 = r102 | 32;
        goto L3
    L18:
        this._$$multiPkTeamScoreText = am3.h.c(r100);
        goto L3
    L19:
        this._$$newScoreOpen = am3.h.a(r100);
        r102 = r102 | 16;
        goto L3
    L20:
        this._$$battleRank = r100.j();
        r102 = r102 | 8;
        goto L3
    L21:
        this._$$scoreText = am3.h.c(r100);
        goto L3
    L22:
        this._$$roomLikeTrigger = am3.h.a(r100);
        r102 = r102 | 4;
        goto L3
    L23:
        this._$$isHugeRewardPk = am3.h.a(r100);
        r102 = r102 | 1;
        goto L3
    L24:
        this._$$scoreRelativeText = am3.h.c(r100);
        goto L3
    L12:
        am3.h.d(r104, r100);
        goto L3
    L28:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & 1) != 0) goto L32;
        this._$$isHugeRewardPk = false;
    L32:
        if (this._$$scoreText != null) goto L35;
        this._$$scoreText = "";
    L35:
        if (this._$$scoreRelativeText != null) goto L38;
        this._$$scoreRelativeText = "";
    L38:
        if ((r102 & 4) != 0) goto L41;
        this._$$roomLikeTrigger = false;
    L41:
        if ((r102 & 16) != 0) goto L44;
        this._$$newScoreOpen = false;
    L44:
        if (this._$$multiPkTeamScoreText != null) goto L47;
        this._$$multiPkTeamScoreText = "";
    L47:
        if ((r102 & 128) != 0) goto L50;
        this._$$isMultiPkTeamRelativeText = false;
    L50:
        if (this._$$curAddScoreText != null) goto L90;
        this._$$curAddScoreText = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1
    public final void setScore(long r100) {
        this._$$score = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1
    public final void setScoreRelativeText(String r100) {
        this._$$scoreRelativeText = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.t1
    public final void setScoreText(String r100) {
        this._$$scoreText = r100;
    }
}
