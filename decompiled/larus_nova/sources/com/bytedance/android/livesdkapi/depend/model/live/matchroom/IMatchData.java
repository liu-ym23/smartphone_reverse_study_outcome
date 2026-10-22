package com.bytedance.android.livesdkapi.depend.model.live.matchroom;

import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0015\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\t\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\t\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010(\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\t\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010,\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\t\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0019R\"\u00100\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\t\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0019¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchData;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchDataEx;", "", "getMatchId", "()J", "setMatchId", "(J)V", "getMatchId$annotations", "()V", "matchId", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IAgainst;", "getAgainst", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IAgainst;", "setAgainst", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IAgainst;)V", "getAgainst$annotations", "against", "", "getMatchIdStr", "()Ljava/lang/String;", "getMatchIdStr$annotations", "matchIdStr", "getMatchTitle", "setMatchTitle", "(Ljava/lang/String;)V", "getMatchTitle$annotations", "matchTitle", "", "getMatchStatus", "()I", "setMatchStatus", "(I)V", "getMatchStatus$annotations", "matchStatus", "getStartedTimeUnix", "()Ljava/lang/Long;", "setStartedTimeUnix", "(Ljava/lang/Long;)V", "getStartedTimeUnix$annotations", "startedTimeUnix", "getMatchGroup", "setMatchGroup", "getMatchGroup$annotations", "matchGroup", "getMatchRound", "setMatchRound", "getMatchRound$annotations", "matchRound", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMatchData extends c<IMatchData>, IMatchDataEx {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "against")
        public static /* synthetic */ void getAgainst$annotations() {
        }

        @FieldName(name = "match_group")
        public static /* synthetic */ void getMatchGroup$annotations() {
        }

        @FieldName(name = VSConstants.VS_MATCH_ID)
        public static /* synthetic */ void getMatchId$annotations() {
        }

        @FieldName(name = "match_id_str")
        public static /* synthetic */ void getMatchIdStr$annotations() {
        }

        @FieldName(name = "match_round")
        public static /* synthetic */ void getMatchRound$annotations() {
        }

        @FieldName(name = "match_status")
        public static /* synthetic */ void getMatchStatus$annotations() {
        }

        @FieldName(name = "match_title")
        public static /* synthetic */ void getMatchTitle$annotations() {
        }

        @FieldName(name = "started_time_unix")
        public static /* synthetic */ void getStartedTimeUnix$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "against")
    IAgainst getAgainst();

    @FieldName(name = "match_group")
    String getMatchGroup();

    @FieldName(name = VSConstants.VS_MATCH_ID)
    long getMatchId();

    @FieldName(name = "match_id_str")
    String getMatchIdStr();

    @FieldName(name = "match_round")
    String getMatchRound();

    @FieldName(name = "match_status")
    int getMatchStatus();

    @FieldName(name = "match_title")
    String getMatchTitle();

    @FieldName(name = "started_time_unix")
    Long getStartedTimeUnix();

    @FieldName(name = "against#setter")
    void setAgainst(IAgainst r100);

    @FieldName(name = "match_group#setter")
    void setMatchGroup(String r100);

    @FieldName(name = "match_id#setter")
    void setMatchId(long r100);

    @FieldName(name = "match_round#setter")
    void setMatchRound(String r100);

    @FieldName(name = "match_status#setter")
    void setMatchStatus(int r100);

    @FieldName(name = "match_title#setter")
    void setMatchTitle(String r100);

    @FieldName(name = "started_time_unix#setter")
    void setStartedTimeUnix(Long r100);
}
