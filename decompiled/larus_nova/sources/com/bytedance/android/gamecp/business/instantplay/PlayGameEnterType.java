package com.bytedance.android.gamecp.business.instantplay;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/business/instantplay/PlayGameEnterType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "MOBILE_GAME", "CLOUD_GAME", "PC_GAME", "SIMULATOR", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayGameEnterType extends Enum<PlayGameEnterType> {
    public static final PlayGameEnterType CLOUD_GAME = null;
    public static final PlayGameEnterType MOBILE_GAME = null;
    public static final PlayGameEnterType PC_GAME = null;
    public static final PlayGameEnterType SIMULATOR = null;
    public static final PlayGameEnterType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayGameEnterType[] f56115a = null;
    private final int value;

    static {
        PlayGameEnterType r100 = new PlayGameEnterType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        PlayGameEnterType r101 = new PlayGameEnterType("MOBILE_GAME", 1, 1);
        MOBILE_GAME = r101;
        PlayGameEnterType r102 = new PlayGameEnterType("CLOUD_GAME", 2, 2);
        CLOUD_GAME = r102;
        PlayGameEnterType r103 = new PlayGameEnterType("PC_GAME", 3, 3);
        PC_GAME = r103;
        PlayGameEnterType r104 = new PlayGameEnterType("SIMULATOR", 4, 4);
        SIMULATOR = r104;
        f56115a = new PlayGameEnterType[]{r100, r101, r102, r103, r104};
    }

    public static PlayGameEnterType valueOf(String r100) {
        return (PlayGameEnterType) r27.a.a(PlayGameEnterType.class, r100);
    }

    public static PlayGameEnterType[] values() {
        return (PlayGameEnterType[]) f56115a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PlayGameEnterType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
