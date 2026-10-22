package com.bytedance.android.livesdkapi.depend.model.live.matchroom;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0015\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R$\u0010\u0019\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0007R$\u0010\u001d\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010!\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\t\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007R\"\u0010(\u001a\u00020\"8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\t\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010,\u001a\u00020\"8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\t\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\"\u00103\u001a\u00020-8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010\t\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00107\u001a\u00020-8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b6\u0010\t\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\"\u0010;\u001a\u00020\"8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b:\u0010\t\u001a\u0004\b8\u0010$\"\u0004\b9\u0010&R\"\u0010?\u001a\u00020\"8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b>\u0010\t\u001a\u0004\b<\u0010$\"\u0004\b=\u0010&R\"\u0010C\u001a\u00020\"8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bB\u0010\t\u001a\u0004\b@\u0010$\"\u0004\bA\u0010&R$\u0010J\u001a\u0004\u0018\u00010D8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bI\u0010\t\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010N\u001a\u0004\u0018\u00010D8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bM\u0010\t\u001a\u0004\bK\u0010F\"\u0004\bL\u0010HR$\u0010U\u001a\u0004\u0018\u00010O8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bT\u0010\t\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010\\\u001a\u0004\u0018\u00010V8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b[\u0010\t\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010c\u001a\u0004\u0018\u00010]8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bb\u0010\t\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010g\u001a\u0004\u0018\u00010]8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bf\u0010\t\u001a\u0004\bd\u0010_\"\u0004\be\u0010a¨\u0006h"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IAgainst;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IAgainstEx;", "", "getLeftName", "()Ljava/lang/String;", "setLeftName", "(Ljava/lang/String;)V", "getLeftName$annotations", "()V", "leftName", "Lpy/k;", "getLeftLogo", "()Lpy/k;", "setLeftLogo", "(Lpy/k;)V", "getLeftLogo$annotations", "leftLogo", "getLeftGoal", "setLeftGoal", "getLeftGoal$annotations", "leftGoal", "getRightName", "setRightName", "getRightName$annotations", "rightName", "getRightLogo", "setRightLogo", "getRightLogo$annotations", "rightLogo", "getRightGoal", "setRightGoal", "getRightGoal$annotations", "rightGoal", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "getTimestamp$annotations", "timestamp", "getDiffSei2absSecond", "setDiffSei2absSecond", "getDiffSei2absSecond$annotations", "diffSei2absSecond", "", "getFinalGoalStage", "()I", "setFinalGoalStage", "(I)V", "getFinalGoalStage$annotations", "finalGoalStage", "getCurrentGoalStage", "setCurrentGoalStage", "getCurrentGoalStage$annotations", "currentGoalStage", "getVersion", "setVersion", "getVersion$annotations", "version", "getLeftTeamId", "setLeftTeamId", "getLeftTeamId$annotations", "leftTeamId", "getRightTeamId", "setRightTeamId", "getRightTeamId$annotations", "rightTeamId", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IGoalStageDetail;", "getLeftGoalStageDetail", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IGoalStageDetail;", "setLeftGoalStageDetail", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IGoalStageDetail;)V", "getLeftGoalStageDetail$annotations", "leftGoalStageDetail", "getRightGoalStageDetail", "setRightGoalStageDetail", "getRightGoalStageDetail$annotations", "rightGoalStageDetail", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketballStage;", "getBasketCurrentGoalStage", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketballStage;", "setBasketCurrentGoalStage", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketballStage;)V", "getBasketCurrentGoalStage$annotations", "basketCurrentGoalStage", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IESportsStage;", "getEsportCurrentGoalStage", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IESportsStage;", "setEsportCurrentGoalStage", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IESportsStage;)V", "getEsportCurrentGoalStage$annotations", "esportCurrentGoalStage", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketBallGoalStageDetail;", "getLeftScoreDetail", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketBallGoalStageDetail;", "setLeftScoreDetail", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketBallGoalStageDetail;)V", "getLeftScoreDetail$annotations", "leftScoreDetail", "getRightScoreDetail", "setRightScoreDetail", "getRightScoreDetail$annotations", "rightScoreDetail", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IAgainst extends c<IAgainst>, IAgainstEx {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "basketball_stage")
        public static /* synthetic */ void getBasketCurrentGoalStage$annotations() {
        }

        @FieldName(name = "current_goal_stage")
        public static /* synthetic */ void getCurrentGoalStage$annotations() {
        }

        @FieldName(name = "diff_sei2abs_second")
        public static /* synthetic */ void getDiffSei2absSecond$annotations() {
        }

        @FieldName(name = "esport_stage")
        public static /* synthetic */ void getEsportCurrentGoalStage$annotations() {
        }

        @FieldName(name = "final_goal_stage")
        public static /* synthetic */ void getFinalGoalStage$annotations() {
        }

        @FieldName(name = "left_goal")
        public static /* synthetic */ void getLeftGoal$annotations() {
        }

        @FieldName(name = "left_goal_stage_detail")
        public static /* synthetic */ void getLeftGoalStageDetail$annotations() {
        }

        @FieldName(name = "left_logo")
        public static /* synthetic */ void getLeftLogo$annotations() {
        }

        @FieldName(name = "left_name")
        public static /* synthetic */ void getLeftName$annotations() {
        }

        @FieldName(name = "left_score_detail")
        public static /* synthetic */ void getLeftScoreDetail$annotations() {
        }

        @FieldName(name = "left_team_id")
        public static /* synthetic */ void getLeftTeamId$annotations() {
        }

        @FieldName(name = "right_goal")
        public static /* synthetic */ void getRightGoal$annotations() {
        }

        @FieldName(name = "right_goal_stage_detail")
        public static /* synthetic */ void getRightGoalStageDetail$annotations() {
        }

        @FieldName(name = "right_logo")
        public static /* synthetic */ void getRightLogo$annotations() {
        }

        @FieldName(name = "right_name")
        public static /* synthetic */ void getRightName$annotations() {
        }

        @FieldName(name = "right_score_detail")
        public static /* synthetic */ void getRightScoreDetail$annotations() {
        }

        @FieldName(name = "right_team_id")
        public static /* synthetic */ void getRightTeamId$annotations() {
        }

        @FieldName(name = "timestamp")
        public static /* synthetic */ void getTimestamp$annotations() {
        }

        @FieldName(name = "version")
        public static /* synthetic */ void getVersion$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "basketball_stage")
    IBasketballStage getBasketCurrentGoalStage();

    @FieldName(name = "current_goal_stage")
    int getCurrentGoalStage();

    @FieldName(name = "diff_sei2abs_second")
    long getDiffSei2absSecond();

    @FieldName(name = "esport_stage")
    IESportsStage getEsportCurrentGoalStage();

    @FieldName(name = "final_goal_stage")
    int getFinalGoalStage();

    @FieldName(name = "left_goal")
    String getLeftGoal();

    @FieldName(name = "left_goal_stage_detail")
    IGoalStageDetail getLeftGoalStageDetail();

    @FieldName(name = "left_logo")
    k getLeftLogo();

    @FieldName(name = "left_name")
    String getLeftName();

    @FieldName(name = "left_score_detail")
    IBasketBallGoalStageDetail getLeftScoreDetail();

    @FieldName(name = "left_team_id")
    long getLeftTeamId();

    @FieldName(name = "right_goal")
    String getRightGoal();

    @FieldName(name = "right_goal_stage_detail")
    IGoalStageDetail getRightGoalStageDetail();

    @FieldName(name = "right_logo")
    k getRightLogo();

    @FieldName(name = "right_name")
    String getRightName();

    @FieldName(name = "right_score_detail")
    IBasketBallGoalStageDetail getRightScoreDetail();

    @FieldName(name = "right_team_id")
    long getRightTeamId();

    @FieldName(name = "timestamp")
    long getTimestamp();

    @FieldName(name = "version")
    long getVersion();

    @FieldName(name = "basketball_stage#setter")
    void setBasketCurrentGoalStage(IBasketballStage r100);

    @FieldName(name = "current_goal_stage#setter")
    void setCurrentGoalStage(int r100);

    @FieldName(name = "diff_sei2abs_second#setter")
    void setDiffSei2absSecond(long r100);

    @FieldName(name = "esport_stage#setter")
    void setEsportCurrentGoalStage(IESportsStage r100);

    @FieldName(name = "final_goal_stage#setter")
    void setFinalGoalStage(int r100);

    @FieldName(name = "left_goal#setter")
    void setLeftGoal(String r100);

    @FieldName(name = "left_goal_stage_detail#setter")
    void setLeftGoalStageDetail(IGoalStageDetail r100);

    @FieldName(name = "left_logo#setter")
    void setLeftLogo(k r100);

    @FieldName(name = "left_name#setter")
    void setLeftName(String r100);

    @FieldName(name = "left_score_detail#setter")
    void setLeftScoreDetail(IBasketBallGoalStageDetail r100);

    @FieldName(name = "left_team_id#setter")
    void setLeftTeamId(long r100);

    @FieldName(name = "right_goal#setter")
    void setRightGoal(String r100);

    @FieldName(name = "right_goal_stage_detail#setter")
    void setRightGoalStageDetail(IGoalStageDetail r100);

    @FieldName(name = "right_logo#setter")
    void setRightLogo(k r100);

    @FieldName(name = "right_name#setter")
    void setRightName(String r100);

    @FieldName(name = "right_score_detail#setter")
    void setRightScoreDetail(IBasketBallGoalStageDetail r100);

    @FieldName(name = "right_team_id#setter")
    void setRightTeamId(long r100);

    @FieldName(name = "timestamp#setter")
    void setTimestamp(long r100);

    @FieldName(name = "version#setter")
    void setVersion(long r100);
}
