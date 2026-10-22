package com.bytedance.android.livesdk.revenue.broadcast.xplay;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/broadcast/xplay/RevLittleWindowPos;", "", "", "id", "I", "getId", "()I", "TOP", "LEFT", "RIGHT", "RIGHT_BOTTOM", "CUSTOM", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevLittleWindowPos extends Enum<RevLittleWindowPos> {
    public static final RevLittleWindowPos CUSTOM = null;
    public static final RevLittleWindowPos LEFT = null;
    public static final RevLittleWindowPos RIGHT = null;
    public static final RevLittleWindowPos RIGHT_BOTTOM = null;
    public static final RevLittleWindowPos TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevLittleWindowPos[] f157096a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f157097id;

    static {
        RevLittleWindowPos r100 = new RevLittleWindowPos("TOP", 0, 1);
        TOP = r100;
        RevLittleWindowPos r101 = new RevLittleWindowPos("LEFT", 1, 2);
        LEFT = r101;
        RevLittleWindowPos r102 = new RevLittleWindowPos("RIGHT", 2, 3);
        RIGHT = r102;
        RevLittleWindowPos r103 = new RevLittleWindowPos("RIGHT_BOTTOM", 3, 4);
        RIGHT_BOTTOM = r103;
        RevLittleWindowPos r104 = new RevLittleWindowPos("CUSTOM", 4, 5);
        CUSTOM = r104;
        f157096a = new RevLittleWindowPos[]{r100, r101, r102, r103, r104};
    }

    public static RevLittleWindowPos valueOf(String r100) {
        return (RevLittleWindowPos) a.a(RevLittleWindowPos.class, r100);
    }

    public static RevLittleWindowPos[] values() {
        return (RevLittleWindowPos[]) f157096a.clone();
    }

    public final int getId() {
        return this.f157097id;
    }

    public RevLittleWindowPos(String r100, int r101, int r102) {
        super(r100, r101);
        this.f157097id = r102;
    }
}
