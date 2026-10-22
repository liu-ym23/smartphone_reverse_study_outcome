package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/IntroduceFromType;", "", "", "type", "I", "getType", "()I", "ENTER", "MESSAGE", "TIMER", "AI", "RULE", UserProfileEvent.POSITION_NONE, "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IntroduceFromType extends Enum<IntroduceFromType> {
    public static final IntroduceFromType AI = null;
    public static final IntroduceFromType ENTER = null;
    public static final IntroduceFromType MESSAGE = null;
    public static final IntroduceFromType NONE = null;
    public static final IntroduceFromType RULE = null;
    public static final IntroduceFromType TIMER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IntroduceFromType[] f57377a = null;
    private final int type;

    static {
        IntroduceFromType r100 = new IntroduceFromType("ENTER", 0, 0);
        ENTER = r100;
        IntroduceFromType r101 = new IntroduceFromType("MESSAGE", 1, 1);
        MESSAGE = r101;
        IntroduceFromType r102 = new IntroduceFromType("TIMER", 2, 2);
        TIMER = r102;
        IntroduceFromType r103 = new IntroduceFromType("AI", 3, 3);
        AI = r103;
        IntroduceFromType r104 = new IntroduceFromType("RULE", 4, 4);
        RULE = r104;
        IntroduceFromType r105 = new IntroduceFromType(UserProfileEvent.POSITION_NONE, 5, 999);
        NONE = r105;
        f57377a = new IntroduceFromType[]{r100, r101, r102, r103, r104, r105};
    }

    public static IntroduceFromType valueOf(String r100) {
        return (IntroduceFromType) r27.a.a(IntroduceFromType.class, r100);
    }

    public static IntroduceFromType[] values() {
        return (IntroduceFromType[]) f57377a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public IntroduceFromType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
