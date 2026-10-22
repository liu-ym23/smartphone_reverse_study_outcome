package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u000278B\u0007¢\u0006\u0004\b6\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R$\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u001c\u00100\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u0010\u001a\u0004\b1\u0010\u0012R\u001a\u00102\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006R\u001c\u00104\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u0010\u001a\u0004\b5\u0010\u0012¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/SeasonBriefInfo;", "", "", "seasonType", "I", "getSeasonType", "()I", "getSeasonType$annotations", "()V", "updatingStatus", "getUpdatingStatus", "getUpdatingStatus$annotations", "episodeCount", "getEpisodeCount", "", "releaseTime", "Ljava/lang/String;", "getReleaseTime", "()Ljava/lang/String;", "runningTime", "getRunningTime", "directors", "getDirectors", "actors", "getActors", "previewText", "getPreviewText", "setPreviewText", "(Ljava/lang/String;)V", "Lpy/k;", "background", "Lpy/k;", "getBackground", "()Lpy/k;", "setBackground", "(Lpy/k;)V", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "users", "Ljava/util/List;", "getUsers", "()Ljava/util/List;", "setUsers", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeActors;", "episodeActors", "getEpisodeActors", "setEpisodeActors", "introduce", "getIntroduce", "multiSeasonOrder", "getMultiSeasonOrder", "multiSeasonTag", "getMultiSeasonTag", "<init>", "SeasonTypeEnum", "UpdatingStatusEnum", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SeasonBriefInfo implements h {

    @SerializedName("actors")
    protected String actors;

    @SerializedName("background")
    protected k background;

    @SerializedName("directors")
    protected String directors;

    @SerializedName("episode_actors")
    protected List<EpisodeActors> episodeActors;

    @SerializedName("episode_count")
    protected int episodeCount;

    @SerializedName("introduce")
    protected String introduce;

    @SerializedName("multi_season_order")
    protected int multiSeasonOrder;

    @SerializedName("multi_season_tag")
    protected String multiSeasonTag;

    @SerializedName("previewT_text")
    protected String previewText;

    @SerializedName("release_time")
    protected String releaseTime;

    @SerializedName("running_time")
    protected String runningTime;

    @SerializedName("season_type")
    protected int seasonType;

    @SerializedName("updating_status")
    protected int updatingStatus;

    @SerializedName("users")
    protected List<? extends IBaseUser> users;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/SeasonBriefInfo$SeasonTypeEnum;", "", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SeasonTypeEnum {
        public static final Companion Companion = null;
        public static final int SEASON_TYPE_MOVIE = 3;
        public static final int SEASON_TYPE_TELEPLAY = 2;
        public static final int SEASON_TYPE_UNKNOWN = 0;
        public static final int SEASON_TYPE_VS = 1;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/SeasonBriefInfo$SeasonTypeEnum$Companion;", "", "()V", "SEASON_TYPE_MOVIE", "", "SEASON_TYPE_TELEPLAY", "SEASON_TYPE_UNKNOWN", "SEASON_TYPE_VS", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final int SEASON_TYPE_MOVIE = 3;
            public static final int SEASON_TYPE_TELEPLAY = 2;
            public static final int SEASON_TYPE_UNKNOWN = 0;
            public static final int SEASON_TYPE_VS = 1;

            private Companion() {
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/SeasonBriefInfo$UpdatingStatusEnum;", "", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    public @interface UpdatingStatusEnum {
        public static final Companion Companion = null;
        public static final int UPDATING_STATUS_OVER = 2;
        public static final int UPDATING_STATUS_UNKNOWN = 0;
        public static final int UPDATING_STATUS_UPDATING = 1;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/SeasonBriefInfo$UpdatingStatusEnum$Companion;", "", "()V", "UPDATING_STATUS_OVER", "", "UPDATING_STATUS_UNKNOWN", "UPDATING_STATUS_UPDATING", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final int UPDATING_STATUS_OVER = 2;
            public static final int UPDATING_STATUS_UNKNOWN = 0;
            public static final int UPDATING_STATUS_UPDATING = 1;

            private Companion() {
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    public SeasonBriefInfo() {
    }

    public static /* synthetic */ void getSeasonType$annotations() {
    }

    public static /* synthetic */ void getUpdatingStatus$annotations() {
    }

    public final String getActors() {
        return this.actors;
    }

    public final k getBackground() {
        return this.background;
    }

    public final String getDirectors() {
        return this.directors;
    }

    public final List<EpisodeActors> getEpisodeActors() {
        return this.episodeActors;
    }

    public final int getEpisodeCount() {
        return this.episodeCount;
    }

    public final String getIntroduce() {
        return this.introduce;
    }

    public final int getMultiSeasonOrder() {
        return this.multiSeasonOrder;
    }

    public final String getMultiSeasonTag() {
        return this.multiSeasonTag;
    }

    public final String getPreviewText() {
        return this.previewText;
    }

    public final String getReleaseTime() {
        return this.releaseTime;
    }

    public final String getRunningTime() {
        return this.runningTime;
    }

    public final int getSeasonType() {
        return this.seasonType;
    }

    public final int getUpdatingStatus() {
        return this.updatingStatus;
    }

    public final List<IBaseUser> getUsers() {
        return this.users;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, py.k] */
    public SeasonBriefInfo(g r100) {
        this.users = new ArrayList();
        this.episodeActors = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L22;
        switch(r102) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            case 14: goto L7;
            default: goto L6;
        };
    L7:
        this.multiSeasonTag = am3.h.c(r100);
        goto L3
    L8:
        this.multiSeasonOrder = (int) r100.j();
        goto L3
    L9:
        this.introduce = am3.h.c(r100);
        goto L3
    L10:
        List r103 = this.episodeActors;
        Object r104 = new EpisodeActors(r100);
    L12:
        r103.add(r104);
        goto L3
    L11:
        r103 = this.users;
        r104 = f.a(r100, IBaseUser.class);
        goto L12
    L13:
        this.background = f.a(r100, k.class);
        goto L3
    L14:
        this.previewText = am3.h.c(r100);
        goto L3
    L15:
        this.actors = am3.h.c(r100);
        goto L3
    L16:
        this.directors = am3.h.c(r100);
        goto L3
    L17:
        this.runningTime = am3.h.c(r100);
        goto L3
    L18:
        this.releaseTime = am3.h.c(r100);
        goto L3
    L19:
        this.episodeCount = (int) r100.j();
        goto L3
    L20:
        this.updatingStatus = r100.i();
        goto L3
    L21:
        this.seasonType = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L22:
        r100.d(r101);
    }

    public final void setBackground(k r100) {
        this.background = r100;
    }

    public final void setEpisodeActors(List<EpisodeActors> r100) {
        this.episodeActors = r100;
    }

    public final void setPreviewText(String r100) {
        this.previewText = r100;
    }

    public final void setUsers(List<? extends IBaseUser> r100) {
        this.users = r100;
    }
}
