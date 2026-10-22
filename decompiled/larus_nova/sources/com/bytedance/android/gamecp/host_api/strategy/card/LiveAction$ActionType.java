package com.bytedance.android.gamecp.host_api.strategy.card;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"com/bytedance/android/gamecp/host_api/strategy/card/LiveAction$ActionType", "", "Lcom/bytedance/android/gamecp/host_api/strategy/card/LiveAction$ActionType;", "", "type", "I", "getType", "()I", "ACTION_MUTE", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveAction$ActionType extends Enum<LiveAction$ActionType> {
    public static final LiveAction$ActionType ACTION_MUTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveAction$ActionType[] f57431a = null;
    private final int type;

    static {
        LiveAction$ActionType r100 = new LiveAction$ActionType();
        ACTION_MUTE = r100;
        f57431a = new LiveAction$ActionType[]{r100};
    }

    public static LiveAction$ActionType valueOf(String r100) {
        return (LiveAction$ActionType) a.a(LiveAction$ActionType.class, r100);
    }

    public static LiveAction$ActionType[] values() {
        return (LiveAction$ActionType[]) f57431a.clone();
    }

    public LiveAction$ActionType() {
        super("ACTION_MUTE", 0);
        this.type = 5;
    }

    public final int getType() {
        return this.type;
    }
}
