package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LoadStrategy;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LoadStrategyUnknown", "Request", "RoomData", "RequestWithRoomData", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LoadStrategy extends Enum<LoadStrategy> {
    private static final /* synthetic */ LoadStrategy[] $VALUES = null;
    public static final LoadStrategy LoadStrategyUnknown = null;
    public static final LoadStrategy Request = null;
    public static final LoadStrategy RequestWithRoomData = null;
    public static final LoadStrategy RoomData = null;
    private final int value;

    static {
        LoadStrategy r100 = new LoadStrategy("LoadStrategyUnknown", 0, 0);
        LoadStrategyUnknown = r100;
        LoadStrategy r101 = new LoadStrategy("Request", 1, 1);
        Request = r101;
        LoadStrategy r102 = new LoadStrategy("RoomData", 2, 2);
        RoomData = r102;
        LoadStrategy r103 = new LoadStrategy("RequestWithRoomData", 3, 3);
        RequestWithRoomData = r103;
        $VALUES = new LoadStrategy[]{r100, r101, r102, r103};
    }

    public static LoadStrategy valueOf(String r100) {
        return (LoadStrategy) a.a(LoadStrategy.class, r100);
    }

    public static LoadStrategy[] values() {
        return (LoadStrategy[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private LoadStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
