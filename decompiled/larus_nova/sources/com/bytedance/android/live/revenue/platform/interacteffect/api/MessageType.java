package com.bytedance.android.live.revenue.platform.interacteffect.api;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/interacteffect/api/MessageType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "MSG_TYPE_LIVE_INTERACTION", "MSG_TYPE_LIVE_GIFT_NOTIFY", "UNKNOWN", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MessageType extends Enum<MessageType> {
    public static final a Companion = null;
    public static final MessageType MSG_TYPE_LIVE_GIFT_NOTIFY = null;
    public static final MessageType MSG_TYPE_LIVE_INTERACTION = null;
    public static final MessageType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageType[] f91480a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.revenue.platform.interacteffect.api.MessageType$a] */
    static {
        MessageType r100 = new MessageType("MSG_TYPE_LIVE_INTERACTION", 0, 40);
        MSG_TYPE_LIVE_INTERACTION = r100;
        MessageType r101 = new MessageType("MSG_TYPE_LIVE_GIFT_NOTIFY", 1, 57);
        MSG_TYPE_LIVE_GIFT_NOTIFY = r101;
        MessageType r102 = new MessageType("UNKNOWN", 2, -1);
        UNKNOWN = r102;
        f91480a = new MessageType[]{r100, r101, r102};
        Companion = new a();
    }

    public static MessageType valueOf(String r100) {
        return (MessageType) r27.a.a(MessageType.class, r100);
    }

    public static MessageType[] values() {
        return (MessageType[]) f91480a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public MessageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
