package com.bytedance.android.livesdk.dislike.preload.loader.watchlater;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/preload/loader/watchlater/LongPanelWidgetType;", "", "", "id", "I", "getId", "()I", "DEFAULT", "ADD_WATCH_LATER", "CANCEL_WATCH_LATER", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LongPanelWidgetType extends Enum<LongPanelWidgetType> {
    public static final LongPanelWidgetType ADD_WATCH_LATER = null;
    public static final LongPanelWidgetType CANCEL_WATCH_LATER = null;
    public static final LongPanelWidgetType DEFAULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LongPanelWidgetType[] f122208a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f122209id;

    static {
        LongPanelWidgetType r100 = new LongPanelWidgetType("DEFAULT", 0, 0);
        DEFAULT = r100;
        LongPanelWidgetType r101 = new LongPanelWidgetType("ADD_WATCH_LATER", 1, 1);
        ADD_WATCH_LATER = r101;
        LongPanelWidgetType r102 = new LongPanelWidgetType("CANCEL_WATCH_LATER", 2, 2);
        CANCEL_WATCH_LATER = r102;
        f122208a = new LongPanelWidgetType[]{r100, r101, r102};
    }

    public static LongPanelWidgetType valueOf(String r100) {
        return (LongPanelWidgetType) r27.a.a(LongPanelWidgetType.class, r100);
    }

    public static LongPanelWidgetType[] values() {
        return (LongPanelWidgetType[]) f122208a.clone();
    }

    public final int getId() {
        return this.f122209id;
    }

    public LongPanelWidgetType(String r100, int r101, int r102) {
        super(r100, r101);
        this.f122209id = r102;
    }
}
