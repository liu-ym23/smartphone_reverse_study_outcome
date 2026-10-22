package com.bytedance.android.live.profit.format.voicechat.model;

import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.larus.voicecall.impl.subtitle.SubtitleListUpdateType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/model/VoiceChatState;", "", "", "state", "Ljava/lang/String;", "getState", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CONNECTING", "WAITING", "LISTENING", "THINKING", "SPEAKING", "TIME_UP", "UNKNOWN", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VoiceChatState extends Enum<VoiceChatState> {
    public static final VoiceChatState CONNECTING = null;
    public static final a Companion = null;
    public static final VoiceChatState LISTENING = null;
    public static final VoiceChatState SPEAKING = null;
    public static final VoiceChatState THINKING = null;
    public static final VoiceChatState TIME_UP = null;
    public static final VoiceChatState UNKNOWN = null;
    public static final VoiceChatState WAITING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceChatState[] f87666a = null;
    private final String state;

    public static final class a {
        public a() {
        }
    }

    static {
        VoiceChatState r100 = new VoiceChatState("CONNECTING", 0, PTYSocketStateCallback.CONNECTING);
        CONNECTING = r100;
        VoiceChatState r101 = new VoiceChatState("WAITING", 1, "waiting");
        WAITING = r101;
        VoiceChatState r102 = new VoiceChatState("LISTENING", 2, "listening");
        LISTENING = r102;
        VoiceChatState r103 = new VoiceChatState("THINKING", 3, SubtitleListUpdateType.THINKING);
        THINKING = r103;
        VoiceChatState r104 = new VoiceChatState("SPEAKING", 4, "speaking");
        SPEAKING = r104;
        VoiceChatState r105 = new VoiceChatState("TIME_UP", 5, "time_up");
        TIME_UP = r105;
        VoiceChatState r106 = new VoiceChatState("UNKNOWN", 6, "unknown");
        UNKNOWN = r106;
        f87666a = new VoiceChatState[]{r100, r101, r102, r103, r104, r105, r106};
        Companion = new a();
    }

    public static VoiceChatState valueOf(String r100) {
        return (VoiceChatState) r27.a.a(VoiceChatState.class, r100);
    }

    public static VoiceChatState[] values() {
        return (VoiceChatState[]) f87666a.clone();
    }

    public final String getState() {
        return this.state;
    }

    public VoiceChatState(String r100, int r101, String r102) {
        super(r100, r101);
        this.state = r102;
    }
}
