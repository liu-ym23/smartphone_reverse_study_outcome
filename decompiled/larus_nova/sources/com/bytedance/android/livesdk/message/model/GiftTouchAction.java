package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/GiftTouchAction;", "", "", "value", "I", "getValue", "()I", "UnusedTouch", "Display", "Hide", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GiftTouchAction extends Enum<GiftTouchAction> {
    public static final GiftTouchAction Display = null;
    public static final GiftTouchAction Hide = null;
    public static final GiftTouchAction UnusedTouch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GiftTouchAction[] f153555a = null;
    private final int value;

    static {
        GiftTouchAction r100 = new GiftTouchAction("UnusedTouch", 0, 0);
        UnusedTouch = r100;
        GiftTouchAction r101 = new GiftTouchAction("Display", 1, 1);
        Display = r101;
        GiftTouchAction r102 = new GiftTouchAction("Hide", 2, 2);
        Hide = r102;
        f153555a = new GiftTouchAction[]{r100, r101, r102};
    }

    public static GiftTouchAction valueOf(String r100) {
        return (GiftTouchAction) r27.a.a(GiftTouchAction.class, r100);
    }

    public static GiftTouchAction[] values() {
        return (GiftTouchAction[]) f153555a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public GiftTouchAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
