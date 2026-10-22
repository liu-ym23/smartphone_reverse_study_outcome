package com.bytedance.android.gamecp.host_api.model.intruducecard2;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/intruducecard2/IntroduceMsgType;", "", "", "type", "I", "getType", "()I", "UN_KNOW", "TRIGGER_PULL_INTRODUCE_CARD", "UPDATE_DATA", "STOP_INTRODUCE", "REMIND_INTRODUCE", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IntroduceMsgType extends Enum<IntroduceMsgType> {
    public static final IntroduceMsgType REMIND_INTRODUCE = null;
    public static final IntroduceMsgType STOP_INTRODUCE = null;
    public static final IntroduceMsgType TRIGGER_PULL_INTRODUCE_CARD = null;
    public static final IntroduceMsgType UN_KNOW = null;
    public static final IntroduceMsgType UPDATE_DATA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IntroduceMsgType[] f57395a = null;
    private final int type;

    static {
        IntroduceMsgType r100 = new IntroduceMsgType("UN_KNOW", 0, 0);
        UN_KNOW = r100;
        IntroduceMsgType r101 = new IntroduceMsgType("TRIGGER_PULL_INTRODUCE_CARD", 1, 1);
        TRIGGER_PULL_INTRODUCE_CARD = r101;
        IntroduceMsgType r102 = new IntroduceMsgType("UPDATE_DATA", 2, 2);
        UPDATE_DATA = r102;
        IntroduceMsgType r103 = new IntroduceMsgType("STOP_INTRODUCE", 3, 3);
        STOP_INTRODUCE = r103;
        IntroduceMsgType r104 = new IntroduceMsgType("REMIND_INTRODUCE", 4, 4);
        REMIND_INTRODUCE = r104;
        f57395a = new IntroduceMsgType[]{r100, r101, r102, r103, r104};
    }

    public static IntroduceMsgType valueOf(String r100) {
        return (IntroduceMsgType) r27.a.a(IntroduceMsgType.class, r100);
    }

    public static IntroduceMsgType[] values() {
        return (IntroduceMsgType[]) f57395a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public IntroduceMsgType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
