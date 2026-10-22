package com.bytedance.android.livesdkapi.log;

import com.ss.android.common.applog.EventVerify;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J\u001c\u0010\t\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bH&J\u001c\u0010\f\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bH&J\b\u0010\r\u001a\u00020\u0007H&J8\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH&JL\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00032\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2$\b\u0002\u0010\u0015\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/log/ILivePlayerAppLogger;", "", "getEndParam", "", "key", "getStartParam", "injectPlayEndParam", "", "value", "injectPlayEndParams", "params", "", "injectPlayStartParams", EventVerify.TYPE_LAUNCH, "logResolutionChange", "oldResolution", "newResolution", "reason", "extra", "teaLog", "eventName", "callback", "Lkotlin/Function1;", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerAppLogger {
    public static final Companion Companion = null;
    public static final String EVENT_PLAY_END = "live_player_play_end";
    public static final String EVENT_PLAY_PLAYING = "live_player_play_playing";
    public static final String EVENT_PLAY_START = "live_player_play_start";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/log/ILivePlayerAppLogger$Companion;", "", "()V", "EVENT_PLAY_END", "", "EVENT_PLAY_PLAYING", "EVENT_PLAY_START", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String EVENT_PLAY_END = "live_player_play_end";
        public static final String EVENT_PLAY_PLAYING = "live_player_play_playing";
        public static final String EVENT_PLAY_START = "live_player_play_start";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void teaLog$default(ILivePlayerAppLogger r100, String r101, Map r102, Function1 r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.teaLog(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: teaLog");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void logResolutionChange$default(ILivePlayerAppLogger r100, String r101, String r102, String r103, Map r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L6;
            r104 = null;
        L6:
            r100.logResolutionChange(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logResolutionChange");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    String getEndParam(String r100);

    String getStartParam(String r100);

    void injectPlayEndParam(String r100, String r101);

    void injectPlayEndParams(Map<String, String> r100);

    void injectPlayStartParams(Map<String, String> r100);

    void launch();

    void logResolutionChange(String r100, String r101, String r102, Map<String, String> r103);

    void teaLog(String r100, Map<String, String> r101, Function1<? super Map<String, String>, Unit> r102);
}
