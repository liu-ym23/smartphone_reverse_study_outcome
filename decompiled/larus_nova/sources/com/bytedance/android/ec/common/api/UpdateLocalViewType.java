package com.bytedance.android.ec.common.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/common/api/UpdateLocalViewType;", "", "UPDATE_ALL", "UPDATE_PRICE_INFO", "VIEW_RECYCLED", "HOT_ATMOSPHERE", "UPDATE_EXPOSE", "UPDATE_BUTTON_INFO", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum UpdateLocalViewType extends Enum<UpdateLocalViewType> {
    public static final UpdateLocalViewType HOT_ATMOSPHERE = null;
    public static final UpdateLocalViewType UPDATE_ALL = null;
    public static final UpdateLocalViewType UPDATE_BUTTON_INFO = null;
    public static final UpdateLocalViewType UPDATE_EXPOSE = null;
    public static final UpdateLocalViewType UPDATE_PRICE_INFO = null;
    public static final UpdateLocalViewType VIEW_RECYCLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UpdateLocalViewType[] f42823a = null;

    static {
        UpdateLocalViewType r100 = new UpdateLocalViewType("UPDATE_ALL", 0);
        UPDATE_ALL = r100;
        UpdateLocalViewType r101 = new UpdateLocalViewType("UPDATE_PRICE_INFO", 1);
        UPDATE_PRICE_INFO = r101;
        UpdateLocalViewType r102 = new UpdateLocalViewType("VIEW_RECYCLED", 2);
        VIEW_RECYCLED = r102;
        UpdateLocalViewType r103 = new UpdateLocalViewType("HOT_ATMOSPHERE", 3);
        HOT_ATMOSPHERE = r103;
        UpdateLocalViewType r104 = new UpdateLocalViewType("UPDATE_EXPOSE", 4);
        UPDATE_EXPOSE = r104;
        UpdateLocalViewType r105 = new UpdateLocalViewType("UPDATE_BUTTON_INFO", 5);
        UPDATE_BUTTON_INFO = r105;
        f42823a = new UpdateLocalViewType[]{r100, r101, r102, r103, r104, r105};
    }

    public static UpdateLocalViewType valueOf(String r100) {
        return (UpdateLocalViewType) a.a(UpdateLocalViewType.class, r100);
    }

    public static UpdateLocalViewType[] values() {
        return (UpdateLocalViewType[]) f42823a.clone();
    }

    public UpdateLocalViewType(String r100, int r101) {
        super(r100, r101);
    }
}
