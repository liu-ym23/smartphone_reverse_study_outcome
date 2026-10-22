package com.bytedance.android.livehostapi.business.castscreen.bean;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastPlayState;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "LOADING", "PLAYING", "PAUSED", "STOP", "COMPLETE", "DISCONNECT", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveCastPlayState extends Enum<LiveCastPlayState> {
    private static final /* synthetic */ LiveCastPlayState[] $VALUES = null;
    public static final LiveCastPlayState COMPLETE = null;
    public static final LiveCastPlayState DISCONNECT = null;
    public static final LiveCastPlayState LOADING = null;
    public static final LiveCastPlayState PAUSED = null;
    public static final LiveCastPlayState PLAYING = null;
    public static final LiveCastPlayState STOP = null;
    public static final LiveCastPlayState UNKNOWN = null;

    static {
        LiveCastPlayState r100 = new LiveCastPlayState("UNKNOWN", 0);
        UNKNOWN = r100;
        LiveCastPlayState r101 = new LiveCastPlayState("LOADING", 1);
        LOADING = r101;
        LiveCastPlayState r102 = new LiveCastPlayState("PLAYING", 2);
        PLAYING = r102;
        LiveCastPlayState r103 = new LiveCastPlayState("PAUSED", 3);
        PAUSED = r103;
        LiveCastPlayState r104 = new LiveCastPlayState("STOP", 4);
        STOP = r104;
        LiveCastPlayState r105 = new LiveCastPlayState("COMPLETE", 5);
        COMPLETE = r105;
        LiveCastPlayState r106 = new LiveCastPlayState("DISCONNECT", 6);
        DISCONNECT = r106;
        $VALUES = new LiveCastPlayState[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static LiveCastPlayState valueOf(String r100) {
        return (LiveCastPlayState) a.a(LiveCastPlayState.class, r100);
    }

    public static LiveCastPlayState[] values() {
        return (LiveCastPlayState[]) $VALUES.clone();
    }

    private LiveCastPlayState(String r100, int r101) {
        super(r100, r101);
    }
}
