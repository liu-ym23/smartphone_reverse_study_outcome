package com.bytedance.android.live.profit.format.voicechat.message;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/message/MessageType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AGENT_STATE", "WARMUP_TOPIC", "UNKNOWN", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MessageType extends Enum<MessageType> {
    public static final MessageType AGENT_STATE = null;
    public static final a Companion = null;
    public static final MessageType UNKNOWN = null;
    public static final MessageType WARMUP_TOPIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageType[] f87663a = null;
    private final String type;

    public static final class a {
        public a() {
        }
    }

    static {
        MessageType r100 = new MessageType("AGENT_STATE", 0, "agent_state");
        AGENT_STATE = r100;
        MessageType r101 = new MessageType("WARMUP_TOPIC", 1, "warmup_topic");
        WARMUP_TOPIC = r101;
        MessageType r102 = new MessageType("UNKNOWN", 2, "unknown");
        UNKNOWN = r102;
        f87663a = new MessageType[]{r100, r101, r102};
        Companion = new a();
    }

    public static MessageType valueOf(String r100) {
        return (MessageType) r27.a.a(MessageType.class, r100);
    }

    public static MessageType[] values() {
        return (MessageType[]) f87663a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public MessageType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
