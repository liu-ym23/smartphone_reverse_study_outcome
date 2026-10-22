package com.bytedance.android.live.profit.format.voicechat.trace;

import com.bytedance.android.livesdk.message.model.ek;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/trace/VoiceChatTraceStep;", "", "", "step", "Ljava/lang/String;", "getStep", "()Ljava/lang/String;", "BOOT_CONFIG", "CHAT_START_REQ", "CHAT_CLOSE_REQ", "SEND_GIFT", "CLICK_START", "CHAT_CLOSE", "GIFT_ANIM_START", "GIFT_ANIM_END", "JOIN_ROOM", "FIRST_FRAME", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VoiceChatTraceStep extends Enum<VoiceChatTraceStep> {
    public static final VoiceChatTraceStep BOOT_CONFIG = null;
    public static final VoiceChatTraceStep CHAT_CLOSE = null;
    public static final VoiceChatTraceStep CHAT_CLOSE_REQ = null;
    public static final VoiceChatTraceStep CHAT_START_REQ = null;
    public static final VoiceChatTraceStep CLICK_START = null;
    public static final VoiceChatTraceStep FIRST_FRAME = null;
    public static final VoiceChatTraceStep GIFT_ANIM_END = null;
    public static final VoiceChatTraceStep GIFT_ANIM_START = null;
    public static final VoiceChatTraceStep JOIN_ROOM = null;
    public static final VoiceChatTraceStep SEND_GIFT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceChatTraceStep[] f87688a = null;
    private final String step;

    public static VoiceChatTraceStep valueOf(String r100) {
        return (VoiceChatTraceStep) a.a(VoiceChatTraceStep.class, r100);
    }

    public static VoiceChatTraceStep[] values() {
        return (VoiceChatTraceStep[]) f87688a.clone();
    }

    static {
        VoiceChatTraceStep r100 = new VoiceChatTraceStep("BOOT_CONFIG", 0, "boot_config");
        BOOT_CONFIG = r100;
        VoiceChatTraceStep r101 = new VoiceChatTraceStep("CHAT_START_REQ", 1, "chat_start_req");
        CHAT_START_REQ = r101;
        VoiceChatTraceStep r102 = new VoiceChatTraceStep("CHAT_CLOSE_REQ", 2, "chat_close_req");
        CHAT_CLOSE_REQ = r102;
        VoiceChatTraceStep r103 = new VoiceChatTraceStep("SEND_GIFT", 3, ek.GIFT_SCENE);
        SEND_GIFT = r103;
        VoiceChatTraceStep r104 = new VoiceChatTraceStep("CLICK_START", 4, "click");
        CLICK_START = r104;
        VoiceChatTraceStep r105 = new VoiceChatTraceStep("CHAT_CLOSE", 5, "chat_close");
        CHAT_CLOSE = r105;
        VoiceChatTraceStep r106 = new VoiceChatTraceStep("GIFT_ANIM_START", 6, "animation_start");
        GIFT_ANIM_START = r106;
        VoiceChatTraceStep r107 = new VoiceChatTraceStep("GIFT_ANIM_END", 7, "animation_end");
        GIFT_ANIM_END = r107;
        VoiceChatTraceStep r108 = new VoiceChatTraceStep("JOIN_ROOM", 8, "join_room");
        JOIN_ROOM = r108;
        VoiceChatTraceStep r109 = new VoiceChatTraceStep("FIRST_FRAME", 9, PortraitEngine.LABEL_FIRST_FRAME);
        FIRST_FRAME = r109;
        f87688a = new VoiceChatTraceStep[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public final String getStep() {
        return this.step;
    }

    public VoiceChatTraceStep(String r100, int r101, String r102) {
        super(r100, r101);
        this.step = r102;
    }
}
