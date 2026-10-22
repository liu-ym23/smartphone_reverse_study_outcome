package com.bytedance.android.live.broadcastgame.api.xplay;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/xplay/LittleWindowPos;", "", "", "id", "I", "getId", "()I", "TOP", "LEFT", "RIGHT", "RIGHT_BOTTOM", "CUSTOM", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LittleWindowPos extends Enum<LittleWindowPos> {
    public static final LittleWindowPos CUSTOM = null;
    public static final LittleWindowPos LEFT = null;
    public static final LittleWindowPos RIGHT = null;
    public static final LittleWindowPos RIGHT_BOTTOM = null;
    public static final LittleWindowPos TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LittleWindowPos[] f59432a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f59433id;

    static {
        LittleWindowPos r100 = new LittleWindowPos("TOP", 0, 1);
        TOP = r100;
        LittleWindowPos r101 = new LittleWindowPos("LEFT", 1, 2);
        LEFT = r101;
        LittleWindowPos r102 = new LittleWindowPos("RIGHT", 2, 3);
        RIGHT = r102;
        LittleWindowPos r103 = new LittleWindowPos("RIGHT_BOTTOM", 3, 4);
        RIGHT_BOTTOM = r103;
        LittleWindowPos r104 = new LittleWindowPos("CUSTOM", 4, 5);
        CUSTOM = r104;
        f59432a = new LittleWindowPos[]{r100, r101, r102, r103, r104};
    }

    public static LittleWindowPos valueOf(String r100) {
        return (LittleWindowPos) r27.a.a(LittleWindowPos.class, r100);
    }

    public static LittleWindowPos[] values() {
        return (LittleWindowPos[]) f59432a.clone();
    }

    public final int getId() {
        return this.f59433id;
    }

    public LittleWindowPos(String r100, int r101, int r102) {
        super(r100, r101);
        this.f59433id = r102;
    }
}
