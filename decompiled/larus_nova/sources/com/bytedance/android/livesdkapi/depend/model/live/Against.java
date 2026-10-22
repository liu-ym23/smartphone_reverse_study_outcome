package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketballStage;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IESportsStage;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IGoalStageDetail;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b]\u0010^J\b\u0010\u0004\u001a\u00020\u0003H\u0016R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR$\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R$\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0007\u001a\u0004\b\u001d\u0010\t\"\u0004\b\u001e\u0010\u000bR\"\u0010\u001f\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\"\u0010)\u001a\u00020(8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020(8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\"\u00102\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b2\u0010 \u001a\u0004\b3\u0010\"\"\u0004\b4\u0010$R\"\u00105\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b5\u0010 \u001a\u0004\b6\u0010\"\"\u0004\b7\u0010$R\"\u00108\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b8\u0010 \u001a\u0004\b9\u0010\"\"\u0004\b:\u0010$R$\u0010<\u001a\u0004\u0018\u00010;8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010B\u001a\u0004\u0018\u00010;8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bB\u0010=\u001a\u0004\bC\u0010?\"\u0004\bD\u0010AR$\u0010F\u001a\u0004\u0018\u00010E8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010M\u001a\u0004\u0018\u00010L8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010T\u001a\u0004\u0018\u00010S8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010Z\u001a\u0004\u0018\u00010S8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bZ\u0010U\u001a\u0004\b[\u0010W\"\u0004\b\\\u0010Y¨\u0006_"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/Against;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IAgainst;", "", "getTimestampMill", "", "leftName", "Ljava/lang/String;", "getLeftName", "()Ljava/lang/String;", "setLeftName", "(Ljava/lang/String;)V", "Lpy/k;", "leftLogo", "Lpy/k;", "getLeftLogo", "()Lpy/k;", "setLeftLogo", "(Lpy/k;)V", "leftGoal", "getLeftGoal", "setLeftGoal", "rightName", "getRightName", "setRightName", "rightLogo", "getRightLogo", "setRightLogo", "rightGoal", "getRightGoal", "setRightGoal", "timestamp", "J", "getTimestamp", "()J", "setTimestamp", "(J)V", "diffSei2absSecond", "getDiffSei2absSecond", "setDiffSei2absSecond", "", "finalGoalStage", "I", "getFinalGoalStage", "()I", "setFinalGoalStage", "(I)V", "currentGoalStage", "getCurrentGoalStage", "setCurrentGoalStage", "version", "getVersion", "setVersion", "leftTeamId", "getLeftTeamId", "setLeftTeamId", "rightTeamId", "getRightTeamId", "setRightTeamId", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IGoalStageDetail;", "leftGoalStageDetail", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IGoalStageDetail;", "getLeftGoalStageDetail", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IGoalStageDetail;", "setLeftGoalStageDetail", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IGoalStageDetail;)V", "rightGoalStageDetail", "getRightGoalStageDetail", "setRightGoalStageDetail", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketballStage;", "basketCurrentGoalStage", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketballStage;", "getBasketCurrentGoalStage", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketballStage;", "setBasketCurrentGoalStage", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketballStage;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IESportsStage;", "esportCurrentGoalStage", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IESportsStage;", "getEsportCurrentGoalStage", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IESportsStage;", "setEsportCurrentGoalStage", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IESportsStage;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketBallGoalStageDetail;", "leftScoreDetail", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketBallGoalStageDetail;", "getLeftScoreDetail", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketBallGoalStageDetail;", "setLeftScoreDetail", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketBallGoalStageDetail;)V", "rightScoreDetail", "getRightScoreDetail", "setRightScoreDetail", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Against extends FlexModelBase<IAgainst> implements IAgainst, h {

    @SerializedName("basketball_stage")
    protected IBasketballStage basketCurrentGoalStage;

    @SerializedName("current_goal_stage")
    protected int currentGoalStage;

    @SerializedName("diff_sei2abs_second")
    protected long diffSei2absSecond;

    @SerializedName("esport_stage")
    protected IESportsStage esportCurrentGoalStage;

    @SerializedName("final_goal_stage")
    protected int finalGoalStage;

    @SerializedName("left_goal")
    protected String leftGoal;

    @SerializedName("left_goal_stage_detail")
    protected IGoalStageDetail leftGoalStageDetail;

    @SerializedName("left_logo")
    protected k leftLogo;

    @SerializedName("left_name")
    protected String leftName;

    @SerializedName("left_score_detail")
    protected IBasketBallGoalStageDetail leftScoreDetail;

    @SerializedName("left_team_id")
    protected long leftTeamId;

    @SerializedName("right_goal")
    protected String rightGoal;

    @SerializedName("right_goal_stage_detail")
    protected IGoalStageDetail rightGoalStageDetail;

    @SerializedName("right_logo")
    protected k rightLogo;

    @SerializedName("right_name")
    protected String rightName;

    @SerializedName("right_score_detail")
    protected IBasketBallGoalStageDetail rightScoreDetail;

    @SerializedName("right_team_id")
    protected long rightTeamId;

    @SerializedName("timestamp")
    protected long timestamp;

    @SerializedName("version")
    protected long version;

    public Against() {
        super(IAgainst.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainstEx
    public long getTimestampMill() {
        return (getTimestamp() + getDiffSei2absSecond()) * ((long) 1000);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public IBasketballStage getBasketCurrentGoalStage() {
        return this.basketCurrentGoalStage;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public int getCurrentGoalStage() {
        return this.currentGoalStage;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public long getDiffSei2absSecond() {
        return this.diffSei2absSecond;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public IESportsStage getEsportCurrentGoalStage() {
        return this.esportCurrentGoalStage;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public int getFinalGoalStage() {
        return this.finalGoalStage;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public String getLeftGoal() {
        return this.leftGoal;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public IGoalStageDetail getLeftGoalStageDetail() {
        return this.leftGoalStageDetail;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public k getLeftLogo() {
        return this.leftLogo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public String getLeftName() {
        return this.leftName;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public IBasketBallGoalStageDetail getLeftScoreDetail() {
        return this.leftScoreDetail;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public long getLeftTeamId() {
        return this.leftTeamId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public String getRightGoal() {
        return this.rightGoal;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public IGoalStageDetail getRightGoalStageDetail() {
        return this.rightGoalStageDetail;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public k getRightLogo() {
        return this.rightLogo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public String getRightName() {
        return this.rightName;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public IBasketBallGoalStageDetail getRightScoreDetail() {
        return this.rightScoreDetail;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public long getRightTeamId() {
        return this.rightTeamId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public long getVersion() {
        return this.version;
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [com.bytedance.android.livesdkapi.depend.model.live.matchroom.IGoalStageDetail, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v21, types: [com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v23, types: [com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v25, types: [com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketballStage, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v27, types: [com.bytedance.android.livesdkapi.depend.model.live.matchroom.IESportsStage, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.livesdkapi.depend.model.live.matchroom.IGoalStageDetail, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, py.k] */
    public Against(g r100) {
        super(IAgainst.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L27;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L7;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L7;
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L17;
            case 13: goto L16;
            case 14: goto L15;
            case 15: goto L14;
            case 16: goto L13;
            case 17: goto L12;
            case 18: goto L7;
            case 19: goto L7;
            case 20: goto L7;
            case 21: goto L7;
            case 22: goto L11;
            case 23: goto L10;
            case 24: goto L9;
            case 25: goto L8;
            default: goto L7;
        };
    L8:
        this.esportCurrentGoalStage = f.a(r100, IESportsStage.class);
        goto L3
    L9:
        this.basketCurrentGoalStage = f.a(r100, IBasketballStage.class);
        goto L3
    L10:
        this.rightScoreDetail = f.a(r100, IBasketBallGoalStageDetail.class);
        goto L3
    L11:
        this.leftScoreDetail = f.a(r100, IBasketBallGoalStageDetail.class);
        goto L3
    L12:
        this.currentGoalStage = r100.i();
        goto L3
    L13:
        this.finalGoalStage = r100.i();
        goto L3
    L14:
        this.diffSei2absSecond = r100.j();
        goto L3
    L15:
        this.rightTeamId = r100.j();
        goto L3
    L16:
        this.leftTeamId = r100.j();
        goto L3
    L17:
        this.version = r100.j();
        goto L3
    L18:
        this.timestamp = r100.j();
        goto L3
    L19:
        this.rightGoalStageDetail = f.a(r100, IGoalStageDetail.class);
        goto L3
    L20:
        this.rightGoal = am3.h.c(r100);
        goto L3
    L21:
        this.rightLogo = f.a(r100, k.class);
        goto L3
    L22:
        this.rightName = am3.h.c(r100);
        goto L3
    L23:
        this.leftGoalStageDetail = f.a(r100, IGoalStageDetail.class);
        goto L3
    L24:
        this.leftGoal = am3.h.c(r100);
        goto L3
    L25:
        this.leftLogo = f.a(r100, k.class);
        goto L3
    L26:
        this.leftName = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L27:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setBasketCurrentGoalStage(IBasketballStage r100) {
        this.basketCurrentGoalStage = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setCurrentGoalStage(int r100) {
        this.currentGoalStage = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setDiffSei2absSecond(long r100) {
        this.diffSei2absSecond = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setEsportCurrentGoalStage(IESportsStage r100) {
        this.esportCurrentGoalStage = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setFinalGoalStage(int r100) {
        this.finalGoalStage = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setLeftGoal(String r100) {
        this.leftGoal = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setLeftGoalStageDetail(IGoalStageDetail r100) {
        this.leftGoalStageDetail = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setLeftLogo(k r100) {
        this.leftLogo = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setLeftName(String r100) {
        this.leftName = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setLeftScoreDetail(IBasketBallGoalStageDetail r100) {
        this.leftScoreDetail = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setLeftTeamId(long r100) {
        this.leftTeamId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setRightGoal(String r100) {
        this.rightGoal = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setRightGoalStageDetail(IGoalStageDetail r100) {
        this.rightGoalStageDetail = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setRightLogo(k r100) {
        this.rightLogo = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setRightName(String r100) {
        this.rightName = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setRightScoreDetail(IBasketBallGoalStageDetail r100) {
        this.rightScoreDetail = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setRightTeamId(long r100) {
        this.rightTeamId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setTimestamp(long r100) {
        this.timestamp = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst
    public void setVersion(long r100) {
        this.version = r100;
    }
}
