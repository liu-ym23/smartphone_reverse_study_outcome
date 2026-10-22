package com.bytedance.android.livesdkapi.roomplayer;

import androidx.lifecycle.LifecycleOwner;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerException;", "", "Companion", "Observers", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerException {
    public static final String ASYNC_STREAM_ERROR = "async_stream_error";
    public static final String BLACK_SCREEN = "black_screen";
    public static final String CHECK_MIXED_AUDIO_DESC_ON_DETACH_FROM_WINDOW = "onDetachFromWindow";
    public static final String CHECK_MIXED_AUDIO_DESC_ON_PREPARED = "onPrepared";
    public static final String CHECK_MIXED_AUDIO_DESC_ON_RESET_PLAYER = "ResetPlayer";
    public static final String CHECK_MIXED_AUDIO_ON_TTVIDEO_ENGINE_CHECKED = "tt_video_engine";
    public static final int CHECK_MIXED_AUDIO_TRIGGER_LIVE_PLAY = 1;
    public static final int CHECK_MIXED_AUDIO_TRIGGER_LIVE_UNMUTE = 3;
    public static final int CHECK_MIXED_AUDIO_TRIGGER_ON_DETACH_FROM_WINDOW = 2;
    public static final int CHECK_MIXED_AUDIO_TRIGGER_ON_PREPARED = 1;
    public static final int CHECK_MIXED_AUDIO_TRIGGER_ON_RESET_PLAYER = 3;
    public static final int CHECK_MIXED_AUDIO_TRIGGER_ON_TTVIDEO_ENGINE = 4;
    public static final int CHECK_MIXED_AUDIO_TRIGGER_VIDEO_PLAY = 2;
    public static final Companion Companion = null;
    public static final String KEY_EXCEPTION_REASON = "exception_reason";
    public static final String KEY_EXCEPTION_TYPE = "exception_type";
    public static final String LIVE_MIXED_LIVE = "live_mixed_live";
    public static final String LIVE_MIXED_OTHER = "live_mixed_other";
    public static final String LIVE_MIXED_VIDEO = "live_mixed_video";
    public static final String MIXED_AUDIO = "mixed_audio";
    public static final String MUTE_EXCEPTION = "mute_audio";
    public static final String RENDER_EXCEPTION = "render_exception";
    public static final String STALL = "stall";
    public static final String TRAFFIC_CONSUMPTION = "traffic_consumption";
    public static final String VIDEO_MIXED_LIVE = "video_mixed_live";
    public static final String WIDGET_LIFECYCLE_ERROR = "widget_lifecycle_error";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerException$Companion;", "", "()V", "ASYNC_STREAM_ERROR", "", "BLACK_SCREEN", "CHECK_MIXED_AUDIO_DESC_ON_DETACH_FROM_WINDOW", "CHECK_MIXED_AUDIO_DESC_ON_PREPARED", "CHECK_MIXED_AUDIO_DESC_ON_RESET_PLAYER", "CHECK_MIXED_AUDIO_ON_TTVIDEO_ENGINE_CHECKED", "CHECK_MIXED_AUDIO_TRIGGER_LIVE_PLAY", "", "CHECK_MIXED_AUDIO_TRIGGER_LIVE_UNMUTE", "CHECK_MIXED_AUDIO_TRIGGER_ON_DETACH_FROM_WINDOW", "CHECK_MIXED_AUDIO_TRIGGER_ON_PREPARED", "CHECK_MIXED_AUDIO_TRIGGER_ON_RESET_PLAYER", "CHECK_MIXED_AUDIO_TRIGGER_ON_TTVIDEO_ENGINE", "CHECK_MIXED_AUDIO_TRIGGER_VIDEO_PLAY", "KEY_EXCEPTION_REASON", "KEY_EXCEPTION_TYPE", "LIVE_MIXED_LIVE", "LIVE_MIXED_OTHER", "LIVE_MIXED_VIDEO", "MIXED_AUDIO", "MUTE_EXCEPTION", "RENDER_EXCEPTION", "STALL", "TRAFFIC_CONSUMPTION", "VIDEO_MIXED_LIVE", "WIDGET_LIFECYCLE_ERROR", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String ASYNC_STREAM_ERROR = "async_stream_error";
        public static final String BLACK_SCREEN = "black_screen";
        public static final String CHECK_MIXED_AUDIO_DESC_ON_DETACH_FROM_WINDOW = "onDetachFromWindow";
        public static final String CHECK_MIXED_AUDIO_DESC_ON_PREPARED = "onPrepared";
        public static final String CHECK_MIXED_AUDIO_DESC_ON_RESET_PLAYER = "ResetPlayer";
        public static final String CHECK_MIXED_AUDIO_ON_TTVIDEO_ENGINE_CHECKED = "tt_video_engine";
        public static final int CHECK_MIXED_AUDIO_TRIGGER_LIVE_PLAY = 1;
        public static final int CHECK_MIXED_AUDIO_TRIGGER_LIVE_UNMUTE = 3;
        public static final int CHECK_MIXED_AUDIO_TRIGGER_ON_DETACH_FROM_WINDOW = 2;
        public static final int CHECK_MIXED_AUDIO_TRIGGER_ON_PREPARED = 1;
        public static final int CHECK_MIXED_AUDIO_TRIGGER_ON_RESET_PLAYER = 3;
        public static final int CHECK_MIXED_AUDIO_TRIGGER_ON_TTVIDEO_ENGINE = 4;
        public static final int CHECK_MIXED_AUDIO_TRIGGER_VIDEO_PLAY = 2;
        public static final String KEY_EXCEPTION_REASON = "exception_reason";
        public static final String KEY_EXCEPTION_TYPE = "exception_type";
        public static final String LIVE_MIXED_LIVE = "live_mixed_live";
        public static final String LIVE_MIXED_OTHER = "live_mixed_other";
        public static final String LIVE_MIXED_VIDEO = "live_mixed_video";
        public static final String MIXED_AUDIO = "mixed_audio";
        public static final String MUTE_EXCEPTION = "mute_audio";
        public static final String RENDER_EXCEPTION = "render_exception";
        public static final String STALL = "stall";
        public static final String TRAFFIC_CONSUMPTION = "traffic_consumption";
        public static final String VIDEO_MIXED_LIVE = "video_mixed_live";
        public static final String WIDGET_LIFECYCLE_ERROR = "widget_lifecycle_error";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u0007H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerException$Observers;", "", "observeException", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface Observers {
        void observeException(LifecycleOwner r100, Observer<Map<String, String>> r101);
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
