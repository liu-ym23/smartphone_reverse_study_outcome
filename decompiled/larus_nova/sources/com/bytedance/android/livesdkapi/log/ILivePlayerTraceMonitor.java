package com.bytedance.android.livesdkapi.log;

import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/log/ILivePlayerTraceMonitor;", "", "injectPlayEndParam", "", "key", "", "value", "append", "", "insertPlayEndParamToEvent", "data", "Lorg/json/JSONObject;", "reportTrace", "eventType", "extras", "extraIndexes", "", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerTraceMonitor {
    public static final Companion Companion = null;
    public static final String EVENT_END = "ttlive_live_player_play_end";
    public static final String EVENT_EXCEPTION = "ttlive_live_player_exception";
    public static final String EVENT_PLAY_MUTE = "ttlive_live_player_mute";
    public static final String EVENT_START = "ttlive_live_player_play_start";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/log/ILivePlayerTraceMonitor$Companion;", "", "()V", "EVENT_END", "", "EVENT_EXCEPTION", "EVENT_PLAY_MUTE", "EVENT_START", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String EVENT_END = "ttlive_live_player_play_end";
        public static final String EVENT_EXCEPTION = "ttlive_live_player_exception";
        public static final String EVENT_PLAY_MUTE = "ttlive_live_player_mute";
        public static final String EVENT_START = "ttlive_live_player_play_start";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void injectPlayEndParam$default(ILivePlayerTraceMonitor r100, String r101, String r102, boolean r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = false;
        L6:
            r100.injectPlayEndParam(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: injectPlayEndParam");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void injectPlayEndParam(String r100, String r101, boolean r102);

    void insertPlayEndParamToEvent(JSONObject r100);

    void reportTrace(String r100, JSONObject r101, Map<String, ? extends Object> r102);
}
