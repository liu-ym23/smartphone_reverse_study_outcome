package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0004-./0B\u0007¢\u0006\u0004\b+\u0010,R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R$\u0010!\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData$MatchDrawer;", "drawer", "Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData$MatchDrawer;", "getDrawer", "()Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData$MatchDrawer;", "setDrawer", "(Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData$MatchDrawer;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/MatchData;", "match", "Lcom/bytedance/android/livesdkapi/depend/model/live/MatchData;", "getMatch", "()Lcom/bytedance/android/livesdkapi/depend/model/live/MatchData;", "setMatch", "(Lcom/bytedance/android/livesdkapi/depend/model/live/MatchData;)V", "Lpy/k;", "drawerLabel", "Lpy/k;", "getDrawerLabel", "()Lpy/k;", "setDrawerLabel", "(Lpy/k;)V", "", "onlineCount", "Ljava/lang/String;", "getOnlineCount", "()Ljava/lang/String;", "setOnlineCount", "(Ljava/lang/String;)V", "officialLabel", "getOfficialLabel", "setOfficialLabel", "scoreBoardBackground", "getScoreBoardBackground", "setScoreBoardBackground", "Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData$MatchUserInfo;", "matchUserInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData$MatchUserInfo;", "getMatchUserInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData$MatchUserInfo;", "setMatchUserInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData$MatchUserInfo;)V", "<init>", "()V", "MatchDetail", "MatchDrawer", "MatchUserInfo", "TeamInfo", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchRoomData implements h {

    @SerializedName("drawer")
    protected MatchDrawer drawer;

    @SerializedName("drawer_label")
    protected k drawerLabel;

    @SerializedName("match")
    protected MatchData match;

    @SerializedName("match_user_info")
    protected MatchUserInfo matchUserInfo;

    @SerializedName("drawer_official_label")
    protected k officialLabel;

    @SerializedName("pcu_str")
    protected String onlineCount;

    @SerializedName("match_background")
    protected k scoreBoardBackground;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData$MatchDetail;", "", "", "teamAName", "Ljava/lang/String;", "getTeamAName", "()Ljava/lang/String;", "setTeamAName", "(Ljava/lang/String;)V", "Lpy/k;", "teamAIcon", "Lpy/k;", "getTeamAIcon", "()Lpy/k;", "setTeamAIcon", "(Lpy/k;)V", "teamAScore", "getTeamAScore", "setTeamAScore", "teamBName", "getTeamBName", "setTeamBName", "teamBIcon", "getTeamBIcon", "setTeamBIcon", "teamBScore", "getTeamBScore", "setTeamBScore", "", "timestamp", "J", "getTimestamp", "()J", "setTimestamp", "(J)V", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MatchDetail implements h {

        @SerializedName("left_logo")
        protected k teamAIcon;

        @SerializedName("left_name")
        protected String teamAName;

        @SerializedName("left_goal")
        protected String teamAScore;

        @SerializedName("right_logo")
        protected k teamBIcon;

        @SerializedName("right_name")
        protected String teamBName;

        @SerializedName("right_goal")
        protected String teamBScore;

        @SerializedName("timestamp")
        protected long timestamp;

        public MatchDetail() {
        }

        public final k getTeamAIcon() {
            return this.teamAIcon;
        }

        public final String getTeamAName() {
            return this.teamAName;
        }

        public final String getTeamAScore() {
            return this.teamAScore;
        }

        public final k getTeamBIcon() {
            return this.teamBIcon;
        }

        public final String getTeamBName() {
            return this.teamBName;
        }

        public final String getTeamBScore() {
            return this.teamBScore;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
        /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, py.k] */
        public MatchDetail(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L27;
            if (r102 != 1) goto L8;
            this.teamAName = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.teamAIcon = f.a(r100, k.class);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.teamAScore = am3.h.c(r100);
            goto L3
        L12:
            if (r102 != 6) goto L14;
            this.teamBName = am3.h.c(r100);
            goto L3
        L14:
            if (r102 != 7) goto L16;
            this.teamBIcon = f.a(r100, k.class);
            goto L3
        L16:
            if (r102 != 8) goto L18;
            this.teamBScore = am3.h.c(r100);
            goto L3
        L18:
            if (r102 != 11) goto L19;
            this.timestamp = r100.j();
            goto L3
        L19:
            am3.h.e(r100);
            goto L3
        L27:
            r100.d(r101);
        }

        public final void setTeamAIcon(k r100) {
            this.teamAIcon = r100;
        }

        public final void setTeamAName(String r100) {
            this.teamAName = r100;
        }

        public final void setTeamAScore(String r100) {
            this.teamAScore = r100;
        }

        public final void setTeamBIcon(k r100) {
            this.teamBIcon = r100;
        }

        public final void setTeamBName(String r100) {
            this.teamBName = r100;
        }

        public final void setTeamBScore(String r100) {
            this.teamBScore = r100;
        }

        public final void setTimestamp(long r100) {
            this.timestamp = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData$MatchDrawer;", "", "", "entranceName", "Ljava/lang/String;", "getEntranceName", "()Ljava/lang/String;", "setEntranceName", "(Ljava/lang/String;)V", "Lpy/k;", "entranceIcon", "Lpy/k;", "getEntranceIcon", "()Lpy/k;", "setEntranceIcon", "(Lpy/k;)V", "drawerTitle", "getDrawerTitle", "setDrawerTitle", "drawerBackground", "getDrawerBackground", "setDrawerBackground", "returnEntryText", "getReturnEntryText", "setReturnEntryText", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MatchDrawer implements h {

        @SerializedName("drawer_background")
        protected k drawerBackground;

        @SerializedName("drawer_title")
        protected String drawerTitle;

        @SerializedName("entry_icon")
        protected k entranceIcon;

        @SerializedName("entry_name")
        protected String entranceName;

        @SerializedName("return_btn_text")
        protected String returnEntryText;

        public MatchDrawer() {
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
        /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
        public MatchDrawer(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L21;
            if (r102 != 1) goto L8;
            this.entranceName = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.entranceIcon = f.a(r100, k.class);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.drawerTitle = am3.h.c(r100);
            goto L3
        L12:
            if (r102 != 4) goto L14;
            this.drawerBackground = f.a(r100, k.class);
            goto L3
        L14:
            if (r102 != 5) goto L15;
            this.returnEntryText = am3.h.c(r100);
            goto L3
        L15:
            am3.h.e(r100);
            goto L3
        L21:
            r100.d(r101);
        }

        public final k getDrawerBackground() {
            return this.drawerBackground;
        }

        public final String getDrawerTitle() {
            return this.drawerTitle;
        }

        public final k getEntranceIcon() {
            return this.entranceIcon;
        }

        public final String getEntranceName() {
            return this.entranceName;
        }

        public final String getReturnEntryText() {
            return this.returnEntryText;
        }

        public final void setDrawerBackground(k r100) {
            this.drawerBackground = r100;
        }

        public final void setDrawerTitle(String r100) {
            this.drawerTitle = r100;
        }

        public final void setEntranceIcon(k r100) {
            this.entranceIcon = r100;
        }

        public final void setEntranceName(String r100) {
            this.entranceName = r100;
        }

        public final void setReturnEntryText(String r100) {
            this.returnEntryText = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R,\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData$MatchUserInfo;", "", "()V", "isActivityAccount", "", "()Z", "setActivityAccount", "(Z)V", "needRetry", "getNeedRetry", "setNeedRetry", "teamInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData$TeamInfo;", "getTeamInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData$TeamInfo;", "setTeamInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData$TeamInfo;)V", "userQuizInfo", "", "", "getUserQuizInfo", "()Ljava/util/Map;", "setUserQuizInfo", "(Ljava/util/Map;)V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MatchUserInfo implements h {

        @SerializedName("is_activity_account")
        protected boolean isActivityAccount;

        @SerializedName("need_retry")
        protected boolean needRetry;

        @SerializedName("user_team_info")
        protected TeamInfo teamInfo;

        @SerializedName("user_quiz_info")
        protected Map<Long, Long> userQuizInfo;

        public MatchUserInfo() {
        }

        public final boolean getNeedRetry() {
            return this.needRetry;
        }

        public final TeamInfo getTeamInfo() {
            return this.teamInfo;
        }

        public final Map<Long, Long> getUserQuizInfo() {
            return this.userQuizInfo;
        }

        public final boolean isActivityAccount() {
            return this.isActivityAccount;
        }

        public MatchUserInfo(g r110) {
            this.userQuizInfo = new HashMap();
            long r100 = r110.c();
        L3:
            int r101 = r110.f();
            if (r101 == (-1)) goto L33;
            if (r101 != 1) goto L8;
            this.teamInfo = new TeamInfo(r110);
            goto L3
        L8:
            if (r101 != 2) goto L10;
            long r102 = r110.c();
            Long r103 = null;
            Long r104 = null;
        L17:
            int r105 = r110.f();
            if (r105 == (-1)) goto L24;
            if (r105 != 1) goto L20;
            r103 = Long.valueOf(r110.j());
            goto L17
        L20:
            if (r105 != 2) goto L21;
            r104 = Long.valueOf(r110.j());
            goto L17
        L21:
            am3.h.e(r110);
            goto L17
        L24:
            r110.d(r102);
            Map<Long, Long> r106 = this.userQuizInfo;
            if (r103 == null) goto L31;
            if (r104 == null) goto L29;
            r106.put(r103, r104);
            goto L3
        L29:
            throw new IllegalStateException("Value must not be null");
        L31:
            throw new IllegalStateException("Key must not be null");
        L10:
            if (r101 != 3) goto L12;
            this.isActivityAccount = am3.h.a(r110);
            goto L3
        L12:
            if (r101 != 4) goto L13;
            this.needRetry = am3.h.a(r110);
            goto L3
        L13:
            am3.h.e(r110);
            goto L3
        L33:
            r110.d(r100);
        }

        public final void setActivityAccount(boolean r100) {
            this.isActivityAccount = r100;
        }

        public final void setNeedRetry(boolean r100) {
            this.needRetry = r100;
        }

        public final void setTeamInfo(TeamInfo r100) {
            this.teamInfo = r100;
        }

        public final void setUserQuizInfo(Map<Long, Long> r100) {
            this.userQuizInfo = r100;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010#\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001f¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/MatchRoomData$TeamInfo;", "", "", "teamId", "J", "getTeamId", "()J", "setTeamId", "(J)V", "", "teamIdStr", "Ljava/lang/String;", "getTeamIdStr", "()Ljava/lang/String;", "setTeamIdStr", "(Ljava/lang/String;)V", "teamName", "getTeamName", "setTeamName", "schemaUrl", "getSchemaUrl", "setSchemaUrl", "systemMessage", "getSystemMessage", "setSystemMessage", "Lpy/k;", "teamIcon", "Lpy/k;", "getTeamIcon", "()Lpy/k;", "setTeamIcon", "(Lpy/k;)V", "teamBadge", "getTeamBadge", "setTeamBadge", "teamBackground", "getTeamBackground", "setTeamBackground", "teamAvatarBox", "getTeamAvatarBox", "setTeamAvatarBox", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TeamInfo implements h {

        @SerializedName(a.KEY_SCHEMA_URL)
        protected String schemaUrl;

        @SerializedName("system_msg")
        protected String systemMessage;

        @SerializedName("team_avatar_box")
        protected k teamAvatarBox;

        @SerializedName("team_background")
        protected k teamBackground;

        @SerializedName("team_badge")
        protected k teamBadge;

        @SerializedName("team_icon")
        protected k teamIcon;

        @SerializedName("team_id")
        protected long teamId;

        @SerializedName("team_id_str")
        protected String teamIdStr;

        @SerializedName("team_name")
        protected String teamName;

        public TeamInfo() {
        }

        public final String getSchemaUrl() {
            return this.schemaUrl;
        }

        public final String getSystemMessage() {
            return this.systemMessage;
        }

        public final k getTeamAvatarBox() {
            return this.teamAvatarBox;
        }

        public final k getTeamBackground() {
            return this.teamBackground;
        }

        public final k getTeamBadge() {
            return this.teamBadge;
        }

        public final k getTeamIcon() {
            return this.teamIcon;
        }

        public final long getTeamId() {
            return this.teamId;
        }

        public final String getTeamIdStr() {
            return this.teamIdStr;
        }

        public final String getTeamName() {
            return this.teamName;
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object, py.k] */
        /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
        /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
        /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, py.k] */
        public TeamInfo(g r100) {
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
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            this.teamAvatarBox = f.a(r100, k.class);
            goto L3
        L8:
            this.teamIdStr = am3.h.c(r100);
            goto L3
        L9:
            this.systemMessage = am3.h.c(r100);
            goto L3
        L10:
            this.teamBackground = f.a(r100, k.class);
            goto L3
        L11:
            this.teamBadge = f.a(r100, k.class);
            goto L3
        L12:
            this.teamIcon = f.a(r100, k.class);
            goto L3
        L13:
            this.schemaUrl = am3.h.c(r100);
            goto L3
        L14:
            this.teamName = am3.h.c(r100);
            goto L3
        L15:
            this.teamId = r100.j();
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L16:
            r100.d(r101);
        }

        public final void setSchemaUrl(String r100) {
            this.schemaUrl = r100;
        }

        public final void setSystemMessage(String r100) {
            this.systemMessage = r100;
        }

        public final void setTeamAvatarBox(k r100) {
            this.teamAvatarBox = r100;
        }

        public final void setTeamBackground(k r100) {
            this.teamBackground = r100;
        }

        public final void setTeamBadge(k r100) {
            this.teamBadge = r100;
        }

        public final void setTeamIcon(k r100) {
            this.teamIcon = r100;
        }

        public final void setTeamId(long r100) {
            this.teamId = r100;
        }

        public final void setTeamIdStr(String r100) {
            this.teamIdStr = r100;
        }

        public final void setTeamName(String r100) {
            this.teamName = r100;
        }
    }

    public MatchRoomData() {
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, py.k] */
    public MatchRoomData(g r100) {
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
        this.matchUserInfo = new MatchUserInfo(r100);
        goto L3
    L8:
        this.scoreBoardBackground = f.a(r100, k.class);
        goto L3
    L9:
        this.officialLabel = f.a(r100, k.class);
        goto L3
    L10:
        this.onlineCount = am3.h.c(r100);
        goto L3
    L11:
        this.drawerLabel = f.a(r100, k.class);
        goto L3
    L12:
        this.match = new MatchData(r100);
        goto L3
    L13:
        this.drawer = new MatchDrawer(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
    }

    public final MatchDrawer getDrawer() {
        return this.drawer;
    }

    public final k getDrawerLabel() {
        return this.drawerLabel;
    }

    public final MatchData getMatch() {
        return this.match;
    }

    public final MatchUserInfo getMatchUserInfo() {
        return this.matchUserInfo;
    }

    public final k getOfficialLabel() {
        return this.officialLabel;
    }

    public final String getOnlineCount() {
        return this.onlineCount;
    }

    public final k getScoreBoardBackground() {
        return this.scoreBoardBackground;
    }

    public final void setDrawer(MatchDrawer r100) {
        this.drawer = r100;
    }

    public final void setDrawerLabel(k r100) {
        this.drawerLabel = r100;
    }

    public final void setMatch(MatchData r100) {
        this.match = r100;
    }

    public final void setMatchUserInfo(MatchUserInfo r100) {
        this.matchUserInfo = r100;
    }

    public final void setOfficialLabel(k r100) {
        this.officialLabel = r100;
    }

    public final void setOnlineCount(String r100) {
        this.onlineCount = r100;
    }

    public final void setScoreBoardBackground(k r100) {
        this.scoreBoardBackground = r100;
    }
}
