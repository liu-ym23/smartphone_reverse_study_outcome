package com.bytedance.android.livesdk.gift.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/ComboHintScene;", "", "", "scene", "I", "getScene", "()I", "GIFT_EXHIBITION", "SEND_TOGETHER", "SEND_GOLD", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ComboHintScene extends Enum<ComboHintScene> {
    public static final ComboHintScene GIFT_EXHIBITION = null;
    public static final ComboHintScene SEND_GOLD = null;
    public static final ComboHintScene SEND_TOGETHER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComboHintScene[] f126363a = null;
    private final int scene;

    static {
        ComboHintScene r100 = new ComboHintScene("GIFT_EXHIBITION", 0, 1);
        GIFT_EXHIBITION = r100;
        ComboHintScene r101 = new ComboHintScene("SEND_TOGETHER", 1, 2);
        SEND_TOGETHER = r101;
        ComboHintScene r102 = new ComboHintScene("SEND_GOLD", 2, 3);
        SEND_GOLD = r102;
        f126363a = new ComboHintScene[]{r100, r101, r102};
    }

    public static ComboHintScene valueOf(String r100) {
        return (ComboHintScene) r27.a.a(ComboHintScene.class, r100);
    }

    public static ComboHintScene[] values() {
        return (ComboHintScene[]) f126363a.clone();
    }

    public final int getScene() {
        return this.scene;
    }

    public ComboHintScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
