package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import r27.a;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.BattleUserInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R&\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleUserInfo;", "", "()V", "battleConsecutiveRecordInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleConsecutiveRecordInfo;", "getBattleConsecutiveRecordInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/BattleConsecutiveRecordInfo;", "setBattleConsecutiveRecordInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/BattleConsecutiveRecordInfo;)V", "grade", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGrade;", "getGrade", "()Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGrade;", "setGrade", "(Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGrade;)V", "gradeChange", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGradeChange;", "getGradeChange", "()Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGradeChange;", "setGradeChange", "(Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGradeChange;)V", "multiPkTeamId", "", "getMultiPkTeamId", "()J", "setMultiPkTeamId", "(J)V", "pkResult", "", "getPkResult", "()I", "setPkResult", "(I)V", "pkRole", "getPkRole", "setPkRole", "tagList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleRivalTag;", "getTagList", "()Ljava/util/List;", "setTagList", "(Ljava/util/List;)V", "teamCoachScore", "", "getTeamCoachScore", "()Ljava/lang/String;", "setTeamCoachScore", "(Ljava/lang/String;)V", "userInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/BaseUserInfo;", "getUserInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/BaseUserInfo;", "setUserInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/BaseUserInfo;)V", "PKResult", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BattleUserInfo implements h {

    @SerializedName("consecutive_record")
    protected BattleConsecutiveRecordInfo battleConsecutiveRecordInfo;

    @SerializedName("grade")
    protected BattleStarActivityGrade grade;

    @SerializedName("grade_change")
    protected BattleStarActivityGradeChange gradeChange;

    @SerializedName("multi_pk_team_id")
    protected long multiPkTeamId;

    @SerializedName("pk_result")
    protected int pkResult;

    @SerializedName("pk_role")
    protected int pkRole;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    protected List<BattleRivalTag> tagList;

    @SerializedName("team_coach_score")
    protected String teamCoachScore;

    @SerializedName("user")
    protected BaseUserInfo userInfo;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleUserInfo$PKResult;", "", "(Ljava/lang/String;I)V", "PKUnCompute", "PKVictory", "PKFail", "PKTie", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PKResult extends Enum<PKResult> {
        private static final /* synthetic */ PKResult[] $VALUES = null;
        public static final PKResult PKFail = null;
        public static final PKResult PKTie = null;
        public static final PKResult PKUnCompute = null;
        public static final PKResult PKVictory = null;

        static {
            PKResult r100 = new PKResult("PKUnCompute", 0);
            PKUnCompute = r100;
            PKResult r101 = new PKResult("PKVictory", 1);
            PKVictory = r101;
            PKResult r102 = new PKResult("PKFail", 2);
            PKFail = r102;
            PKResult r103 = new PKResult("PKTie", 3);
            PKTie = r103;
            $VALUES = new PKResult[]{r100, r101, r102, r103};
        }

        public static PKResult valueOf(String r100) {
            return (PKResult) a.a(PKResult.class, r100);
        }

        public static PKResult[] values() {
            return (PKResult[]) $VALUES.clone();
        }

        private PKResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    public BattleUserInfo() {
    }

    public final BattleConsecutiveRecordInfo getBattleConsecutiveRecordInfo() {
        return this.battleConsecutiveRecordInfo;
    }

    public final BattleStarActivityGrade getGrade() {
        return this.grade;
    }

    public final BattleStarActivityGradeChange getGradeChange() {
        return this.gradeChange;
    }

    public final long getMultiPkTeamId() {
        return this.multiPkTeamId;
    }

    public final int getPkResult() {
        return this.pkResult;
    }

    public final int getPkRole() {
        return this.pkRole;
    }

    public final List<BattleRivalTag> getTagList() {
        return this.tagList;
    }

    public final String getTeamCoachScore() {
        return this.teamCoachScore;
    }

    public final BaseUserInfo getUserInfo() {
        return this.userInfo;
    }

    public BattleUserInfo(g r100) {
        this.tagList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L6;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.multiPkTeamId = r100.j();
        goto L3
    L8:
        this.pkResult = r100.i();
        goto L3
    L9:
        this.pkRole = r100.i();
        goto L3
    L10:
        this.teamCoachScore = am3.h.c(r100);
        goto L3
    L11:
        this.gradeChange = new BattleStarActivityGradeChange(r100);
        goto L3
    L12:
        this.grade = new BattleStarActivityGrade(r100);
        goto L3
    L13:
        this.battleConsecutiveRecordInfo = new BattleConsecutiveRecordInfo(r100);
        goto L3
    L14:
        this.tagList.add(new BattleRivalTag(r100));
        goto L3
    L15:
        this.userInfo = new BaseUserInfo(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
    }

    public final void setBattleConsecutiveRecordInfo(BattleConsecutiveRecordInfo r100) {
        this.battleConsecutiveRecordInfo = r100;
    }

    public final void setGrade(BattleStarActivityGrade r100) {
        this.grade = r100;
    }

    public final void setGradeChange(BattleStarActivityGradeChange r100) {
        this.gradeChange = r100;
    }

    public final void setMultiPkTeamId(long r100) {
        this.multiPkTeamId = r100;
    }

    public final void setPkResult(int r100) {
        this.pkResult = r100;
    }

    public final void setPkRole(int r100) {
        this.pkRole = r100;
    }

    public final void setTagList(List<BattleRivalTag> r100) {
        this.tagList = r100;
    }

    public final void setTeamCoachScore(String r100) {
        this.teamCoachScore = r100;
    }

    public final void setUserInfo(BaseUserInfo r100) {
        this.userInfo = r100;
    }
}
