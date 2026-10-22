package com.bytedance.android.live.effect.sticker.insert;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/android/live/effect/sticker/insert/PermeateStickerStrategy$InsertEffectReadyStatus", "", "Lcom/bytedance/android/live/effect/sticker/insert/PermeateStickerStrategy$InsertEffectReadyStatus;", "SUCCESS", "FAIL", "WAITING", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PermeateStickerStrategy$InsertEffectReadyStatus extends Enum<PermeateStickerStrategy$InsertEffectReadyStatus> {
    public static final PermeateStickerStrategy$InsertEffectReadyStatus FAIL = null;
    public static final PermeateStickerStrategy$InsertEffectReadyStatus SUCCESS = null;
    public static final PermeateStickerStrategy$InsertEffectReadyStatus WAITING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermeateStickerStrategy$InsertEffectReadyStatus[] f68197a = null;

    static {
        PermeateStickerStrategy$InsertEffectReadyStatus r100 = new PermeateStickerStrategy$InsertEffectReadyStatus("SUCCESS", 0);
        SUCCESS = r100;
        PermeateStickerStrategy$InsertEffectReadyStatus r101 = new PermeateStickerStrategy$InsertEffectReadyStatus("FAIL", 1);
        FAIL = r101;
        PermeateStickerStrategy$InsertEffectReadyStatus r102 = new PermeateStickerStrategy$InsertEffectReadyStatus("WAITING", 2);
        WAITING = r102;
        f68197a = new PermeateStickerStrategy$InsertEffectReadyStatus[]{r100, r101, r102};
    }

    public static PermeateStickerStrategy$InsertEffectReadyStatus valueOf(String r100) {
        return (PermeateStickerStrategy$InsertEffectReadyStatus) a.a(PermeateStickerStrategy$InsertEffectReadyStatus.class, r100);
    }

    public static PermeateStickerStrategy$InsertEffectReadyStatus[] values() {
        return (PermeateStickerStrategy$InsertEffectReadyStatus[]) f68197a.clone();
    }

    public PermeateStickerStrategy$InsertEffectReadyStatus(String r100, int r101) {
        super(r100, r101);
    }
}
