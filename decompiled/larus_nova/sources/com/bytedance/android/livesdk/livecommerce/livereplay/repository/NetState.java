package com.bytedance.android.livesdk.livecommerce.livereplay.repository;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/repository/NetState;", "", "SUCCESS", "ERROR", "PAGE_TIMESTAMP_EMPTY", "COUNT_EMPTY", "PAGE_SIZE_ERROR", "REPLAY_CARDS_EMPTY", "LOAD_MORE_ERROR", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum NetState extends Enum<NetState> {
    public static final NetState COUNT_EMPTY = null;
    public static final NetState ERROR = null;
    public static final NetState LOAD_MORE_ERROR = null;
    public static final NetState PAGE_SIZE_ERROR = null;
    public static final NetState PAGE_TIMESTAMP_EMPTY = null;
    public static final NetState REPLAY_CARDS_EMPTY = null;
    public static final NetState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetState[] f149347a = null;

    static {
        NetState r100 = new NetState("SUCCESS", 0);
        SUCCESS = r100;
        NetState r101 = new NetState("ERROR", 1);
        ERROR = r101;
        NetState r102 = new NetState("PAGE_TIMESTAMP_EMPTY", 2);
        PAGE_TIMESTAMP_EMPTY = r102;
        NetState r103 = new NetState("COUNT_EMPTY", 3);
        COUNT_EMPTY = r103;
        NetState r104 = new NetState("PAGE_SIZE_ERROR", 4);
        PAGE_SIZE_ERROR = r104;
        NetState r105 = new NetState("REPLAY_CARDS_EMPTY", 5);
        REPLAY_CARDS_EMPTY = r105;
        NetState r106 = new NetState("LOAD_MORE_ERROR", 6);
        LOAD_MORE_ERROR = r106;
        f149347a = new NetState[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static NetState valueOf(String r100) {
        return (NetState) r27.a.a(NetState.class, r100);
    }

    public static NetState[] values() {
        return (NetState[]) f149347a.clone();
    }

    public NetState(String r100, int r101) {
        super(r100, r101);
    }
}
