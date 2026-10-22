package com.bytedance.android.livesdk.gift.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/GiftTopicClickType;", "", "", "value", "I", "getValue", "()I", "ClientDefault", "Recommend", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GiftTopicClickType extends Enum<GiftTopicClickType> {
    public static final GiftTopicClickType ClientDefault = null;
    public static final GiftTopicClickType Recommend = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GiftTopicClickType[] f126368a = null;
    private final int value;

    static {
        GiftTopicClickType r100 = new GiftTopicClickType("ClientDefault", 0, 0);
        ClientDefault = r100;
        GiftTopicClickType r101 = new GiftTopicClickType("Recommend", 1, 1);
        Recommend = r101;
        f126368a = new GiftTopicClickType[]{r100, r101};
    }

    public static GiftTopicClickType valueOf(String r100) {
        return (GiftTopicClickType) r27.a.a(GiftTopicClickType.class, r100);
    }

    public static GiftTopicClickType[] values() {
        return (GiftTopicClickType[]) f126368a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public GiftTopicClickType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
