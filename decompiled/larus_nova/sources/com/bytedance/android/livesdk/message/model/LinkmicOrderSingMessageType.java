package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkmicOrderSingMessageType;", "", "", "value", "I", "getValue", "()I", "TPYE_MESSAGE_UNKNOWN", "TYPE_MESSAGE_CREATE", "TYPE_MESSAGE_FINISH", "TYPE_MESSAGE_SING_ACTION_TOAST", "TYPE_MESSAGE_SING_ACTION", "TYPE_MESSAGE_MV_ACTION_CONTENT", "TYPE_MESSAGE_AI_LYRICS", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicOrderSingMessageType extends Enum<LinkmicOrderSingMessageType> {
    public static final LinkmicOrderSingMessageType TPYE_MESSAGE_UNKNOWN = null;
    public static final LinkmicOrderSingMessageType TYPE_MESSAGE_AI_LYRICS = null;
    public static final LinkmicOrderSingMessageType TYPE_MESSAGE_CREATE = null;
    public static final LinkmicOrderSingMessageType TYPE_MESSAGE_FINISH = null;
    public static final LinkmicOrderSingMessageType TYPE_MESSAGE_MV_ACTION_CONTENT = null;
    public static final LinkmicOrderSingMessageType TYPE_MESSAGE_SING_ACTION = null;
    public static final LinkmicOrderSingMessageType TYPE_MESSAGE_SING_ACTION_TOAST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkmicOrderSingMessageType[] f153573a = null;
    private final int value;

    static {
        LinkmicOrderSingMessageType r100 = new LinkmicOrderSingMessageType("TPYE_MESSAGE_UNKNOWN", 0, 0);
        TPYE_MESSAGE_UNKNOWN = r100;
        LinkmicOrderSingMessageType r101 = new LinkmicOrderSingMessageType("TYPE_MESSAGE_CREATE", 1, 1);
        TYPE_MESSAGE_CREATE = r101;
        LinkmicOrderSingMessageType r102 = new LinkmicOrderSingMessageType("TYPE_MESSAGE_FINISH", 2, 2);
        TYPE_MESSAGE_FINISH = r102;
        LinkmicOrderSingMessageType r103 = new LinkmicOrderSingMessageType("TYPE_MESSAGE_SING_ACTION_TOAST", 3, 3);
        TYPE_MESSAGE_SING_ACTION_TOAST = r103;
        LinkmicOrderSingMessageType r104 = new LinkmicOrderSingMessageType("TYPE_MESSAGE_SING_ACTION", 4, 4);
        TYPE_MESSAGE_SING_ACTION = r104;
        LinkmicOrderSingMessageType r105 = new LinkmicOrderSingMessageType("TYPE_MESSAGE_MV_ACTION_CONTENT", 5, 5);
        TYPE_MESSAGE_MV_ACTION_CONTENT = r105;
        LinkmicOrderSingMessageType r106 = new LinkmicOrderSingMessageType("TYPE_MESSAGE_AI_LYRICS", 6, 6);
        TYPE_MESSAGE_AI_LYRICS = r106;
        f153573a = new LinkmicOrderSingMessageType[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static LinkmicOrderSingMessageType valueOf(String r100) {
        return (LinkmicOrderSingMessageType) r27.a.a(LinkmicOrderSingMessageType.class, r100);
    }

    public static LinkmicOrderSingMessageType[] values() {
        return (LinkmicOrderSingMessageType[]) f153573a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LinkmicOrderSingMessageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
