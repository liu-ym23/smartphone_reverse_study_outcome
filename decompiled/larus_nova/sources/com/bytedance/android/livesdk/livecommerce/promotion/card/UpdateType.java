package com.bytedance.android.livesdk.livecommerce.promotion.card;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/UpdateType;", "", "UPDATE_ALL", "VIEW_RECYCLED", "HOT_ATMOSPHERE", "UPDATE_EXPOSE", "UPDATE_BUTTON_INFO", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum UpdateType extends Enum<UpdateType> {
    public static final UpdateType HOT_ATMOSPHERE = null;
    public static final UpdateType UPDATE_ALL = null;
    public static final UpdateType UPDATE_BUTTON_INFO = null;
    public static final UpdateType UPDATE_EXPOSE = null;
    public static final UpdateType VIEW_RECYCLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UpdateType[] f150033a = null;

    static {
        UpdateType r100 = new UpdateType("UPDATE_ALL", 0);
        UPDATE_ALL = r100;
        UpdateType r101 = new UpdateType("VIEW_RECYCLED", 1);
        VIEW_RECYCLED = r101;
        UpdateType r102 = new UpdateType("HOT_ATMOSPHERE", 2);
        HOT_ATMOSPHERE = r102;
        UpdateType r103 = new UpdateType("UPDATE_EXPOSE", 3);
        UPDATE_EXPOSE = r103;
        UpdateType r104 = new UpdateType("UPDATE_BUTTON_INFO", 4);
        UPDATE_BUTTON_INFO = r104;
        f150033a = new UpdateType[]{r100, r101, r102, r103, r104};
    }

    public static UpdateType valueOf(String r100) {
        return (UpdateType) r27.a.a(UpdateType.class, r100);
    }

    public static UpdateType[] values() {
        return (UpdateType[]) f150033a.clone();
    }

    public UpdateType(String r100, int r101) {
        super(r100, r101);
    }
}
