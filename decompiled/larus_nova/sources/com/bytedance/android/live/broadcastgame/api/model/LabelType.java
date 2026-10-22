package com.bytedance.android.live.broadcastgame.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/LabelType;", "", "", "id", "I", "getId", "()I", "TASK", "GAME_TYPE", "GAME_VALUE", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LabelType extends Enum<LabelType> {
    public static final LabelType GAME_TYPE = null;
    public static final LabelType GAME_VALUE = null;
    public static final LabelType TASK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LabelType[] f59327a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f59328id;

    static {
        LabelType r100 = new LabelType("TASK", 0, 1);
        TASK = r100;
        LabelType r101 = new LabelType("GAME_TYPE", 1, 2);
        GAME_TYPE = r101;
        LabelType r102 = new LabelType("GAME_VALUE", 2, 3);
        GAME_VALUE = r102;
        f59327a = new LabelType[]{r100, r101, r102};
    }

    public static LabelType valueOf(String r100) {
        return (LabelType) r27.a.a(LabelType.class, r100);
    }

    public static LabelType[] values() {
        return (LabelType[]) f59327a.clone();
    }

    public final int getId() {
        return this.f59328id;
    }

    public LabelType(String r100, int r101, int r102) {
        super(r100, r101);
        this.f59328id = r102;
    }
}
