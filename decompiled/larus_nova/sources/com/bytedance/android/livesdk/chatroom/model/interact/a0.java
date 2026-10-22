package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b*\bg\u0018\u0000 S2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0004TUVWR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\u0007\u0010\u0005\"\u0004\b\b\u0010\tR\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\u00168&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010!\u001a\u00020\u00168&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010 R\u001e\u0010'\u001a\u0004\u0018\u00010\"8&@&X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b(\u0010\u0005\"\u0004\b)\u0010\tR\u001a\u0010-\u001a\u00020\u00168&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\u000b\u001a\u0004\b+\u0010\u0018R\u001a\u00102\u001a\u00020.8&X§\u0004¢\u0006\f\u0012\u0004\b1\u0010\u000b\u001a\u0004\b/\u00100R$\u00106\u001a\u0004\u0018\u00010\"8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b5\u0010\u000b\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&R\u001e\u00109\u001a\u0004\u0018\u00010\"8&@&X¦\u000e¢\u0006\f\u001a\u0004\b7\u0010$\"\u0004\b8\u0010&R\"\u0010>\u001a\u00020\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b=\u0010\u000b\u001a\u0004\b:\u0010\u000f\"\u0004\b;\u0010<R\"\u0010B\u001a\u00020\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bA\u0010\u000b\u001a\u0004\b?\u0010\u000f\"\u0004\b@\u0010<R\"\u0010F\u001a\u00020\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bE\u0010\u000b\u001a\u0004\bC\u0010\u000f\"\u0004\bD\u0010<R\"\u0010J\u001a\u00020\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bI\u0010\u000b\u001a\u0004\bG\u0010\u000f\"\u0004\bH\u0010<R\"\u0010N\u001a\u00020\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\bM\u0010\u000b\u001a\u0004\bK\u0010\u0018\"\u0004\bL\u0010 R\"\u0010R\u001a\u00020\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\bQ\u0010\u000b\u001a\u0004\bO\u0010\u0018\"\u0004\bP\u0010 ¨\u0006X"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/a0;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/a0$d;", "getResultsFlex", "()Ljava/util/List;", "resultsFlex", "getResults", "setResults", "(Ljava/util/List;)V", "getResults$annotations", "()V", "results", "", "getBattleId", "()J", "getBattleId$annotations", "battleId", "", "getChestOn", "()Z", "chestOn", "", "getBattleStatus", "()I", "getBattleStatus$annotations", "battleStatus", "getCurrentTime", "getCurrentTime$annotations", "currentTime", "getFinishReason", "setFinishReason", "(I)V", "finishReason", "", "getFinishToast", "()Ljava/lang/String;", "setFinishToast", "(Ljava/lang/String;)V", "finishToast", "getRawResults", "setRawResults", "rawResults", "getScoreType", "getScoreType$annotations", "scoreType", "Lcom/bytedance/android/livesdk/chatroom/model/interact/d0;", "getGuestBattleUIInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/d0;", "getGuestBattleUIInfo$annotations", "guestBattleUIInfo", "getDressId", "setDressId", "getDressId$annotations", "dressId", "getSourceFrom", "setSourceFrom", "sourceFrom", "getFinishTime", "setFinishTime", "(J)V", "getFinishTime$annotations", "finishTime", "getShowDuration", "setShowDuration", "getShowDuration$annotations", "showDuration", "getLoserNum", "setLoserNum", "getLoserNum$annotations", "loserNum", "getUiType", "setUiType", "getUiType$annotations", "uiType", "getBattleStage", "setBattleStage", "getBattleStage$annotations", "battleStage", "getMode", "setMode", "getMode$annotations", "mode", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "c", "d", "e", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a0 extends vh7.c<a0> {
    public static final a Companion = null;
    public static final String TAG = "GuestBattleV";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f106948a = null;

        public a() {
        }

        static {
            f106948a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/a0$c;", "Lvh7/c;", "", "getGiftFromUserId", "()J", "giftFromUserId", "", "getGiftFromUserOpenId", "()Ljava/lang/String;", "giftFromUserOpenId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface c extends vh7.c<c> {
        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        long getGiftFromUserId();

        String getGiftFromUserOpenId();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u0000 Y2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001ZJ\b\u0010\u0002\u001a\u00020\u0000H&R\u0014\u0010\u0006\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u00020\u00178&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\"\u001a\u00020\u001d8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010%\u001a\u00020\u001d8&@&X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001c\u0010(\u001a\u00020\u001d8&@&X¦\u000e¢\u0006\f\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001c\u0010+\u001a\u00020\u001d8&@&X¦\u000e¢\u0006\f\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001c\u00101\u001a\u00020,8&@&X¦\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00102\u001a\u00020\u001d8&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u001fR\u001c\u00106\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0005\"\u0004\b4\u00105R\u001c\u00109\u001a\u00020,8&@&X¦\u000e¢\u0006\f\u001a\u0004\b7\u0010.\"\u0004\b8\u00100R\u001c\u0010<\u001a\u00020,8&@&X¦\u000e¢\u0006\f\u001a\u0004\b:\u0010.\"\u0004\b;\u00100R\u001c\u0010?\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b=\u0010\t\"\u0004\b>\u0010\u0015R\u001e\u0010B\u001a\u0004\u0018\u00010\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b@\u0010\t\"\u0004\bA\u0010\u0015R\u001e\u0010E\u001a\u0004\u0018\u00010\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\bC\u0010\t\"\u0004\bD\u0010\u0015R\u001c\u0010I\u001a\u00020\u000f8&@&X¦\u000e¢\u0006\f\u001a\u0004\bF\u0010\u0011\"\u0004\bG\u0010HR\u001c\u0010L\u001a\u00020\u001d8&@&X¦\u000e¢\u0006\f\u001a\u0004\bJ\u0010\u001f\"\u0004\bK\u0010!R\u001c\u0010O\u001a\u00020\u001d8&@&X¦\u000e¢\u0006\f\u001a\u0004\bM\u0010\u001f\"\u0004\bN\u0010!R\u001c\u0010U\u001a\u00020P8&@&X¦\u000e¢\u0006\f\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001c\u0010X\u001a\u00020\u001d8&@&X¦\u000e¢\u0006\f\u001a\u0004\bV\u0010\u001f\"\u0004\bW\u0010!¨\u0006["}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/a0$d;", "Lvh7/c;", "copy", "", "getGuestIdFlex", "()J", "guestIdFlex", "", "getGuestIdFlexStr", "()Ljava/lang/String;", "guestIdFlexStr", "getScoreFlex", "scoreFlex", "getScoreFuzzyFlex", "scoreFuzzyFlex", "Lcom/bytedance/android/livesdk/chatroom/model/interact/a0$e;", "getContributorsFlex", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/a0$e;", "contributorsFlex", "getGuestIdStr", "setGuestIdStr", "(Ljava/lang/String;)V", "guestIdStr", "Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "getQuickInteract", "()Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "setQuickInteract", "(Lcom/bytedance/android/live/liveinteract/plantform/model/l;)V", "quickInteract", "", "getFirstCrown", "()Z", "setFirstCrown", "(Z)V", "firstCrown", "getCrown", "setCrown", "crown", "getPoop", "setPoop", "poop", "getFirstPoop", "setFirstPoop", "firstPoop", "", "getLevel", "()I", "setLevel", "(I)V", "level", "isRankNormal", "getScoreNum", "setScoreNum", "(J)V", "scoreNum", "getRole", "setRole", "role", "getRank", "setRank", "rank", "getNickName", "setNickName", "nickName", "getScore", "setScore", com.bytedance.android.ec.core.event.a.KEY_SCORE, "getScoreFuzzy", "setScoreFuzzy", "scoreFuzzy", "getContributors", "setContributors", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/a0$e;)V", "contributors", "getRankFirst", "setRankFirst", "rankFirst", "getRankLast", "setRankLast", "rankLast", "Lcom/bytedance/android/livesdk/chatroom/model/interact/f0;", "getCrownInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/f0;", "setCrownInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/f0;)V", "crownInfo", "getShowFirstEffect", "setShowFirstEffect", "showFirstEffect", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface d extends vh7.c<d> {
        public static final a Companion = null;
        public static final int GUEST_ROLE_CROWN = 1;
        public static final int GUEST_ROLE_NONE = 0;
        public static final int GUEST_ROLE_POOP = 2;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f106949a = null;

            public a() {
            }

            static {
                f106949a = new a();
            }
        }

        static {
            Companion = a.f106949a;
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        d copy();

        e getContributors();

        e getContributorsFlex();

        boolean getCrown();

        f0 getCrownInfo();

        boolean getFirstCrown();

        boolean getFirstPoop();

        long getGuestIdFlex();

        String getGuestIdFlexStr();

        String getGuestIdStr();

        int getLevel();

        String getNickName();

        boolean getPoop();

        com.bytedance.android.live.liveinteract.plantform.model.l getQuickInteract();

        int getRank();

        boolean getRankFirst();

        boolean getRankLast();

        int getRole();

        String getScore();

        String getScoreFlex();

        String getScoreFuzzy();

        String getScoreFuzzyFlex();

        long getScoreNum();

        boolean getShowFirstEffect();

        boolean isRankNormal();

        void setContributors(e r100);

        void setCrown(boolean r100);

        void setCrownInfo(f0 r100);

        void setFirstCrown(boolean r100);

        void setFirstPoop(boolean r100);

        void setGuestIdStr(String r100);

        void setLevel(int r100);

        void setNickName(String r100);

        void setPoop(boolean r100);

        void setQuickInteract(com.bytedance.android.live.liveinteract.plantform.model.l r100);

        void setRank(int r100);

        void setRankFirst(boolean r100);

        void setRankLast(boolean r100);

        void setRole(int r100);

        void setScore(String r100);

        void setScoreFuzzy(String r100);

        void setScoreNum(long r100);

        void setShowFirstEffect(boolean r100);
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/a0$e;", "Lvh7/c;", "", "", "getUserIdsFlex", "()Ljava/util/List;", "userIdsFlex", "", "getUserIds", "userIds", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface e extends vh7.c<e> {
        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        List<String> getUserIds();

        List<Long> getUserIdsFlex();
    }

    static {
        Companion = a.f106948a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_id")
    long getBattleId();

    @FieldName(name = "battle_stage")
    int getBattleStage();

    @FieldName(name = "status")
    int getBattleStatus();

    boolean getChestOn();

    @FieldName(name = "current_time")
    long getCurrentTime();

    @FieldName(name = "dress_id")
    String getDressId();

    int getFinishReason();

    @FieldName(name = "finish_time")
    long getFinishTime();

    String getFinishToast();

    @FieldName(name = "ui_info")
    d0 getGuestBattleUIInfo();

    @FieldName(name = "loser_num")
    long getLoserNum();

    @FieldName(name = "mode")
    int getMode();

    List<d> getRawResults();

    @FieldName(name = "results")
    List<d> getResults();

    List<d> getResultsFlex();

    @FieldName(name = "score_type")
    int getScoreType();

    @FieldName(name = "show_duration")
    long getShowDuration();

    String getSourceFrom();

    @FieldName(name = "ui_type")
    long getUiType();

    @FieldName(name = "battle_stage#setter")
    void setBattleStage(int r100);

    @FieldName(name = "dress_id#setter")
    void setDressId(String r100);

    void setFinishReason(int r100);

    @FieldName(name = "finish_time#setter")
    void setFinishTime(long r100);

    void setFinishToast(String r100);

    @FieldName(name = "loser_num#setter")
    void setLoserNum(long r100);

    @FieldName(name = "mode#setter")
    void setMode(int r100);

    void setRawResults(List<? extends d> r100);

    @FieldName(name = "results#setter")
    void setResults(List<? extends d> r100);

    @FieldName(name = "show_duration#setter")
    void setShowDuration(long r100);

    void setSourceFrom(String r100);

    @FieldName(name = "ui_type#setter")
    void setUiType(long r100);
}
