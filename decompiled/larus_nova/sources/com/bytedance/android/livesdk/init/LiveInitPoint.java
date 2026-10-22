package com.bytedance.android.livesdk.init;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "", "PRE_INIT", "COMPLETE_INIT", "COMPLETE_AFTER", "ENTER_ROOM", "LAZY", "live-spi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveInitPoint extends Enum<LiveInitPoint> {
    public static final LiveInitPoint COMPLETE_AFTER = null;
    public static final LiveInitPoint COMPLETE_INIT = null;
    public static final LiveInitPoint ENTER_ROOM = null;
    public static final LiveInitPoint LAZY = null;
    public static final LiveInitPoint PRE_INIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveInitPoint[] f132649a = null;

    static {
        LiveInitPoint r100 = new LiveInitPoint("PRE_INIT", 0);
        PRE_INIT = r100;
        LiveInitPoint r101 = new LiveInitPoint("COMPLETE_INIT", 1);
        COMPLETE_INIT = r101;
        LiveInitPoint r102 = new LiveInitPoint("COMPLETE_AFTER", 2);
        COMPLETE_AFTER = r102;
        LiveInitPoint r103 = new LiveInitPoint("ENTER_ROOM", 3);
        ENTER_ROOM = r103;
        LiveInitPoint r104 = new LiveInitPoint("LAZY", 4);
        LAZY = r104;
        f132649a = new LiveInitPoint[]{r100, r101, r102, r103, r104};
    }

    public static LiveInitPoint valueOf(String r100) {
        return (LiveInitPoint) r27.a.a(LiveInitPoint.class, r100);
    }

    public static LiveInitPoint[] values() {
        return (LiveInitPoint[]) f132649a.clone();
    }

    public LiveInitPoint(String r100, int r101) {
        super(r100, r101);
    }
}
