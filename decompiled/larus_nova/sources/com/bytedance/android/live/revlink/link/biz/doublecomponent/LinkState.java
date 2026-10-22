package com.bytedance.android.live.revlink.link.biz.doublecomponent;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/revlink/link/biz/doublecomponent/LinkState;", "", "DISABLED", "SELF_JOIN", "SELF_JOIN_SUCCEED", "TURN_ON_ENGINE", "TURN_ON_ENGINE_SUCCEED", "CONNECTION_SUCCEED", "FINISH", "FINISH_SUCCEED", "FINISH_FAILED", "TURN_OFF_ENGINE", "TURN_OFF_ENGINE_SUCCEED", "UNLOADED", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkState extends Enum<LinkState> {
    public static final LinkState CONNECTION_SUCCEED = null;
    public static final LinkState DISABLED = null;
    public static final LinkState FINISH = null;
    public static final LinkState FINISH_FAILED = null;
    public static final LinkState FINISH_SUCCEED = null;
    public static final LinkState SELF_JOIN = null;
    public static final LinkState SELF_JOIN_SUCCEED = null;
    public static final LinkState TURN_OFF_ENGINE = null;
    public static final LinkState TURN_OFF_ENGINE_SUCCEED = null;
    public static final LinkState TURN_ON_ENGINE = null;
    public static final LinkState TURN_ON_ENGINE_SUCCEED = null;
    public static final LinkState UNLOADED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkState[] f98176a = null;

    static {
        LinkState r100 = new LinkState("DISABLED", 0);
        DISABLED = r100;
        LinkState r101 = new LinkState("SELF_JOIN", 1);
        SELF_JOIN = r101;
        LinkState r102 = new LinkState("SELF_JOIN_SUCCEED", 2);
        SELF_JOIN_SUCCEED = r102;
        LinkState r103 = new LinkState("TURN_ON_ENGINE", 3);
        TURN_ON_ENGINE = r103;
        LinkState r104 = new LinkState("TURN_ON_ENGINE_SUCCEED", 4);
        TURN_ON_ENGINE_SUCCEED = r104;
        LinkState r105 = new LinkState("CONNECTION_SUCCEED", 5);
        CONNECTION_SUCCEED = r105;
        LinkState r106 = new LinkState("FINISH", 6);
        FINISH = r106;
        LinkState r107 = new LinkState("FINISH_SUCCEED", 7);
        FINISH_SUCCEED = r107;
        LinkState r108 = new LinkState("FINISH_FAILED", 8);
        FINISH_FAILED = r108;
        LinkState r109 = new LinkState("TURN_OFF_ENGINE", 9);
        TURN_OFF_ENGINE = r109;
        LinkState r110 = new LinkState("TURN_OFF_ENGINE_SUCCEED", 10);
        TURN_OFF_ENGINE_SUCCEED = r110;
        LinkState r111 = new LinkState("UNLOADED", 11);
        UNLOADED = r111;
        f98176a = new LinkState[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111};
    }

    public static LinkState valueOf(String r100) {
        return (LinkState) r27.a.a(LinkState.class, r100);
    }

    public static LinkState[] values() {
        return (LinkState[]) f98176a.clone();
    }

    public LinkState(String r100, int r101) {
        super(r100, r101);
    }
}
