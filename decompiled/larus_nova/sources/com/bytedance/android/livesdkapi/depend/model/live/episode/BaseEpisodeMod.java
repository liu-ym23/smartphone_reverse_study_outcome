package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class BaseEpisodeMod extends FlexModelBase<IBaseEpisodeMod> implements IBaseEpisodeMod {

    @SerializedName("episode_record_type")
    public int episodeRecordType;

    @SerializedName("episode_stage")
    public int episodeStage;

    @SerializedName("episode_sub_type")
    public int episodeSubType;

    @SerializedName("episode_type")
    public int episodeType;

    public static class EpisodeRecordType {
        public static int GUIDE = 3;
        public static int LATEST = 2;
        public static int NORMAL = 1;
        public static int UNKNOWN;

        public EpisodeRecordType() {
        }
    }

    public static class EpisodeStageType {
        public static int LIVE = 1;
        public static int PREMIERE = 2;
        public static int RECORD = 3;
        public static int REPLAY = 4;
        public static int UNKNOWN;

        public EpisodeStageType() {
        }
    }

    public static class EpisodeStyle {
        public static final int HORIZONTAL = 1;
        public static final int VERTICAL = 2;

        public EpisodeStyle() {
        }
    }

    public static class EpisodeSubType {
        public static int GUIDE = 2;
        public static int MATCH = 3;
        public static int NORMAL = 1;
        public static int UNKNOWN;

        public EpisodeSubType() {
        }
    }

    public static class EpisodeType {
        public static int FEATURE = 2;
        public static int NORMAL = 1;
        public static int UNKNOWN;

        public EpisodeType() {
        }
    }

    public BaseEpisodeMod() {
        super(IBaseEpisodeMod.class);
    }

    public String getLogStage() {
        int r100 = this.episodeStage;
        if (r100 != EpisodeStageType.LIVE) goto L6;
        return "live";
    L6:
        int r101 = EpisodeStageType.RECORD;
        if (r100 != r101) goto L10;
        return "record";
    L10:
        if (r100 != r101) goto L13;
        return EnterRoomExtra.VS_TYPE_PREMIERE;
    L13:
        return "unknown";
    }

    public String toString() {
        return "{\"episodeStage\":" + this.episodeStage + ", \"episodeType\":" + this.episodeType + ", \"episodeRecordType\":" + this.episodeRecordType + ", \"episodeSubType\":" + this.episodeSubType + '}';
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod
    public int getEpisodeRecordType() {
        return this.episodeRecordType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod
    public int getEpisodeStage() {
        return this.episodeStage;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod
    public int getEpisodeSubType() {
        return this.episodeSubType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod
    public int getEpisodeType() {
        return this.episodeType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod
    public void setEpisodeRecordType(int r100) {
        this.episodeRecordType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod
    public void setEpisodeStage(int r100) {
        this.episodeStage = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod
    public void setEpisodeSubType(int r100) {
        this.episodeSubType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod
    public void setEpisodeType(int r100) {
        this.episodeType = r100;
    }
}
