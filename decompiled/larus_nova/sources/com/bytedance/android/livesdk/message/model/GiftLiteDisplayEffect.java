package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/GiftLiteDisplayEffect;", "", "", "value", "J", "getValue", "()J", "LiteUnused", "LiteTray", "LiteEffect", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GiftLiteDisplayEffect extends Enum<GiftLiteDisplayEffect> {
    public static final GiftLiteDisplayEffect LiteEffect = null;
    public static final GiftLiteDisplayEffect LiteTray = null;
    public static final GiftLiteDisplayEffect LiteUnused = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GiftLiteDisplayEffect[] f153554a = null;
    private final long value;

    static {
        GiftLiteDisplayEffect r100 = new GiftLiteDisplayEffect("LiteUnused", 0, 0);
        LiteUnused = r100;
        GiftLiteDisplayEffect r101 = new GiftLiteDisplayEffect("LiteTray", 1, 1);
        LiteTray = r101;
        GiftLiteDisplayEffect r102 = new GiftLiteDisplayEffect("LiteEffect", 2, 2);
        LiteEffect = r102;
        f153554a = new GiftLiteDisplayEffect[]{r100, r101, r102};
    }

    public static GiftLiteDisplayEffect valueOf(String r100) {
        return (GiftLiteDisplayEffect) r27.a.a(GiftLiteDisplayEffect.class, r100);
    }

    public static GiftLiteDisplayEffect[] values() {
        return (GiftLiteDisplayEffect[]) f153554a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public GiftLiteDisplayEffect(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
