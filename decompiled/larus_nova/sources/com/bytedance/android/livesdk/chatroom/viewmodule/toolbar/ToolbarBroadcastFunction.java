package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarBroadcastFunction;", "", "PAID_LIVE_TICKET", "COMMERCE", "TRANSFORM_WIDGET", "GROUP_PURCHASE", "MINI_APP", "WELFARE", "GAME_PROMOTE", "MIX_MINI_APP", "MINI_GAME", "LITTLE_GAME", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ToolbarBroadcastFunction extends Enum<ToolbarBroadcastFunction> {
    public static final ToolbarBroadcastFunction COMMERCE = null;
    public static final ToolbarBroadcastFunction GAME_PROMOTE = null;
    public static final ToolbarBroadcastFunction GROUP_PURCHASE = null;
    public static final ToolbarBroadcastFunction LITTLE_GAME = null;
    public static final ToolbarBroadcastFunction MINI_APP = null;
    public static final ToolbarBroadcastFunction MINI_GAME = null;
    public static final ToolbarBroadcastFunction MIX_MINI_APP = null;
    public static final ToolbarBroadcastFunction PAID_LIVE_TICKET = null;
    public static final ToolbarBroadcastFunction TRANSFORM_WIDGET = null;
    public static final ToolbarBroadcastFunction WELFARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToolbarBroadcastFunction[] f115699a = null;

    static {
        ToolbarBroadcastFunction r100 = new ToolbarBroadcastFunction("PAID_LIVE_TICKET", 0);
        PAID_LIVE_TICKET = r100;
        ToolbarBroadcastFunction r101 = new ToolbarBroadcastFunction("COMMERCE", 1);
        COMMERCE = r101;
        ToolbarBroadcastFunction r102 = new ToolbarBroadcastFunction("TRANSFORM_WIDGET", 2);
        TRANSFORM_WIDGET = r102;
        ToolbarBroadcastFunction r103 = new ToolbarBroadcastFunction("GROUP_PURCHASE", 3);
        GROUP_PURCHASE = r103;
        ToolbarBroadcastFunction r104 = new ToolbarBroadcastFunction("MINI_APP", 4);
        MINI_APP = r104;
        ToolbarBroadcastFunction r105 = new ToolbarBroadcastFunction("WELFARE", 5);
        WELFARE = r105;
        ToolbarBroadcastFunction r106 = new ToolbarBroadcastFunction("GAME_PROMOTE", 6);
        GAME_PROMOTE = r106;
        ToolbarBroadcastFunction r107 = new ToolbarBroadcastFunction("MIX_MINI_APP", 7);
        MIX_MINI_APP = r107;
        ToolbarBroadcastFunction r108 = new ToolbarBroadcastFunction("MINI_GAME", 8);
        MINI_GAME = r108;
        ToolbarBroadcastFunction r109 = new ToolbarBroadcastFunction("LITTLE_GAME", 9);
        LITTLE_GAME = r109;
        f115699a = new ToolbarBroadcastFunction[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public static ToolbarBroadcastFunction valueOf(String r100) {
        return (ToolbarBroadcastFunction) r27.a.a(ToolbarBroadcastFunction.class, r100);
    }

    public static ToolbarBroadcastFunction[] values() {
        return (ToolbarBroadcastFunction[]) f115699a.clone();
    }

    public ToolbarBroadcastFunction(String r100, int r101) {
        super(r100, r101);
    }
}
