package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/EXGaugeLevel;", "", "", "value", "I", "getValue", "()I", "INNATE", "HEATED", "OVERHEATED", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EXGaugeLevel extends Enum<EXGaugeLevel> {
    public static final EXGaugeLevel HEATED = null;
    public static final EXGaugeLevel INNATE = null;
    public static final EXGaugeLevel OVERHEATED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EXGaugeLevel[] f126779a = null;
    private final int value;

    static {
        EXGaugeLevel r100 = new EXGaugeLevel("INNATE", 0, 0);
        INNATE = r100;
        EXGaugeLevel r101 = new EXGaugeLevel("HEATED", 1, 1);
        HEATED = r101;
        EXGaugeLevel r102 = new EXGaugeLevel("OVERHEATED", 2, 2);
        OVERHEATED = r102;
        f126779a = new EXGaugeLevel[]{r100, r101, r102};
    }

    public static EXGaugeLevel valueOf(String r100) {
        return (EXGaugeLevel) r27.a.a(EXGaugeLevel.class, r100);
    }

    public static EXGaugeLevel[] values() {
        return (EXGaugeLevel[]) f126779a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public EXGaugeLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
