package com.bytedance.android.live.broadcastgame.api.xplay;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/xplay/LittleWindowStyle;", "", "Large", "Small", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LittleWindowStyle extends Enum<LittleWindowStyle> {
    public static final LittleWindowStyle Large = null;
    public static final LittleWindowStyle Small = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LittleWindowStyle[] f59434a = null;

    static {
        LittleWindowStyle r100 = new LittleWindowStyle("Large", 0);
        Large = r100;
        LittleWindowStyle r101 = new LittleWindowStyle("Small", 1);
        Small = r101;
        f59434a = new LittleWindowStyle[]{r100, r101};
    }

    public static LittleWindowStyle valueOf(String r100) {
        return (LittleWindowStyle) r27.a.a(LittleWindowStyle.class, r100);
    }

    public static LittleWindowStyle[] values() {
        return (LittleWindowStyle[]) f59434a.clone();
    }

    public LittleWindowStyle(String r100, int r101) {
        super(r100, r101);
    }
}
