package com.bytedance.android.gamecp.host_api.strategy.card;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"com/bytedance/android/gamecp/host_api/strategy/card/AwemeAction$ActionType", "", "Lcom/bytedance/android/gamecp/host_api/strategy/card/AwemeAction$ActionType;", "", "type", "I", "getType", "()I", "UNDEFINED", "ACTION_DIGG", "ACTION_COLLECT", "ACTION_SHARE", "ACTION_COMMENT", "ACTION_MUTE", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AwemeAction$ActionType extends Enum<AwemeAction$ActionType> {
    public static final AwemeAction$ActionType ACTION_COLLECT = null;
    public static final AwemeAction$ActionType ACTION_COMMENT = null;
    public static final AwemeAction$ActionType ACTION_DIGG = null;
    public static final AwemeAction$ActionType ACTION_MUTE = null;
    public static final AwemeAction$ActionType ACTION_SHARE = null;
    public static final AwemeAction$ActionType UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AwemeAction$ActionType[] f57428a = null;
    private final int type;

    static {
        AwemeAction$ActionType r100 = new AwemeAction$ActionType("UNDEFINED", 0, 0);
        UNDEFINED = r100;
        AwemeAction$ActionType r101 = new AwemeAction$ActionType("ACTION_DIGG", 1, 1);
        ACTION_DIGG = r101;
        AwemeAction$ActionType r102 = new AwemeAction$ActionType("ACTION_COLLECT", 2, 2);
        ACTION_COLLECT = r102;
        AwemeAction$ActionType r103 = new AwemeAction$ActionType("ACTION_SHARE", 3, 3);
        ACTION_SHARE = r103;
        AwemeAction$ActionType r104 = new AwemeAction$ActionType("ACTION_COMMENT", 4, 4);
        ACTION_COMMENT = r104;
        AwemeAction$ActionType r105 = new AwemeAction$ActionType("ACTION_MUTE", 5, 5);
        ACTION_MUTE = r105;
        f57428a = new AwemeAction$ActionType[]{r100, r101, r102, r103, r104, r105};
    }

    public static AwemeAction$ActionType valueOf(String r100) {
        return (AwemeAction$ActionType) a.a(AwemeAction$ActionType.class, r100);
    }

    public static AwemeAction$ActionType[] values() {
        return (AwemeAction$ActionType[]) f57428a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public AwemeAction$ActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
