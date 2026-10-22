package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/DisplayPosition;", "", "", "value", "I", "getValue", "()I", "UnusedPosition", "GiftPanelTopBar", "ComboTray", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DisplayPosition extends Enum<DisplayPosition> {
    public static final DisplayPosition ComboTray = null;
    public static final DisplayPosition GiftPanelTopBar = null;
    public static final DisplayPosition UnusedPosition = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DisplayPosition[] f153553a = null;
    private final int value;

    static {
        DisplayPosition r100 = new DisplayPosition("UnusedPosition", 0, 0);
        UnusedPosition = r100;
        DisplayPosition r101 = new DisplayPosition("GiftPanelTopBar", 1, 1);
        GiftPanelTopBar = r101;
        DisplayPosition r102 = new DisplayPosition("ComboTray", 2, 2);
        ComboTray = r102;
        f153553a = new DisplayPosition[]{r100, r101, r102};
    }

    public static DisplayPosition valueOf(String r100) {
        return (DisplayPosition) r27.a.a(DisplayPosition.class, r100);
    }

    public static DisplayPosition[] values() {
        return (DisplayPosition[]) f153553a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public DisplayPosition(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
