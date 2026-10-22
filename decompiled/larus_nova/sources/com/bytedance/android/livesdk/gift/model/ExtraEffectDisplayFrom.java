package com.bytedance.android.livesdk.gift.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/ExtraEffectDisplayFrom;", "", "", "value", "I", "getValue", "()I", "DisplayFormDefault", "DisplayFormSequential", "DisplayFormParalell", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ExtraEffectDisplayFrom extends Enum<ExtraEffectDisplayFrom> {
    public static final ExtraEffectDisplayFrom DisplayFormDefault = null;
    public static final ExtraEffectDisplayFrom DisplayFormParalell = null;
    public static final ExtraEffectDisplayFrom DisplayFormSequential = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExtraEffectDisplayFrom[] f126365a = null;
    private final int value;

    static {
        ExtraEffectDisplayFrom r100 = new ExtraEffectDisplayFrom("DisplayFormDefault", 0, 0);
        DisplayFormDefault = r100;
        ExtraEffectDisplayFrom r101 = new ExtraEffectDisplayFrom("DisplayFormSequential", 1, 1);
        DisplayFormSequential = r101;
        ExtraEffectDisplayFrom r102 = new ExtraEffectDisplayFrom("DisplayFormParalell", 2, 2);
        DisplayFormParalell = r102;
        f126365a = new ExtraEffectDisplayFrom[]{r100, r101, r102};
    }

    public static ExtraEffectDisplayFrom valueOf(String r100) {
        return (ExtraEffectDisplayFrom) r27.a.a(ExtraEffectDisplayFrom.class, r100);
    }

    public static ExtraEffectDisplayFrom[] values() {
        return (ExtraEffectDisplayFrom[]) f126365a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ExtraEffectDisplayFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
