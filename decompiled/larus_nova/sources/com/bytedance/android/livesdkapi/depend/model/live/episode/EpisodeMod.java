package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class EpisodeMod extends BaseEpisodeMod {

    public static class EpisodeRecordType {
        public static int GUIDE;
        public static int LATEST;
        public static int NORMAL;
        public static int UNKNOWN;

        public EpisodeRecordType() {
        }

        static {
            UNKNOWN = BaseEpisodeMod.EpisodeRecordType.UNKNOWN;
            NORMAL = BaseEpisodeMod.EpisodeRecordType.NORMAL;
            LATEST = BaseEpisodeMod.EpisodeRecordType.LATEST;
            GUIDE = BaseEpisodeMod.EpisodeRecordType.GUIDE;
        }
    }

    public static class EpisodeStageType {
        public static int LIVE;
        public static int PREMIERE;
        public static int RECORD;
        public static int REPLAY;
        public static int UNKNOWN;

        public EpisodeStageType() {
        }

        static {
            UNKNOWN = BaseEpisodeMod.EpisodeStageType.UNKNOWN;
            LIVE = BaseEpisodeMod.EpisodeStageType.LIVE;
            PREMIERE = BaseEpisodeMod.EpisodeStageType.PREMIERE;
            RECORD = BaseEpisodeMod.EpisodeStageType.RECORD;
            REPLAY = BaseEpisodeMod.EpisodeStageType.REPLAY;
        }
    }

    public static class EpisodeStyle {
        public static final int HORIZONTAL = 1;
        public static final int VERTICAL = 2;

        public EpisodeStyle() {
        }
    }

    public static class EpisodeSubType {
        public static int GUIDE;
        public static int MATCH;
        public static int NORMAL;
        public static int UNKNOWN;

        public EpisodeSubType() {
        }

        static {
            UNKNOWN = BaseEpisodeMod.EpisodeSubType.UNKNOWN;
            NORMAL = BaseEpisodeMod.EpisodeSubType.NORMAL;
            GUIDE = BaseEpisodeMod.EpisodeSubType.GUIDE;
            MATCH = BaseEpisodeMod.EpisodeSubType.MATCH;
        }
    }

    public static class EpisodeType {
        public static int FEATURE;
        public static int NORMAL;
        public static int UNKNOWN;

        public EpisodeType() {
        }

        static {
            UNKNOWN = BaseEpisodeMod.EpisodeType.UNKNOWN;
            NORMAL = BaseEpisodeMod.EpisodeType.NORMAL;
            FEATURE = BaseEpisodeMod.EpisodeType.FEATURE;
        }
    }

    public EpisodeMod() {
    }
}
