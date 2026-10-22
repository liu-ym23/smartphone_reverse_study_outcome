package com.bytedance.android.live.liveinteract.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/model/LinkScreenCastType;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "", "typeValue", "I", "getTypeValue", "()I", "CAST_TYPE_UNKNOWN", "CAST_TYPE_GAME", "CAST_TYPE_MINI_APP", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkScreenCastType extends Enum<LinkScreenCastType> {
    public static final LinkScreenCastType CAST_TYPE_GAME = null;
    public static final LinkScreenCastType CAST_TYPE_MINI_APP = null;
    public static final LinkScreenCastType CAST_TYPE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkScreenCastType[] f75462a = null;
    private final String typeName;
    private final int typeValue;

    static {
        LinkScreenCastType r100 = new LinkScreenCastType("CAST_TYPE_UNKNOWN", 0, "未知类型", 0);
        CAST_TYPE_UNKNOWN = r100;
        LinkScreenCastType r101 = new LinkScreenCastType("CAST_TYPE_GAME", 1, "小游戏", 1);
        CAST_TYPE_GAME = r101;
        LinkScreenCastType r102 = new LinkScreenCastType("CAST_TYPE_MINI_APP", 2, "小程序", 2);
        CAST_TYPE_MINI_APP = r102;
        f75462a = new LinkScreenCastType[]{r100, r101, r102};
    }

    public static LinkScreenCastType valueOf(String r100) {
        return (LinkScreenCastType) r27.a.a(LinkScreenCastType.class, r100);
    }

    public static LinkScreenCastType[] values() {
        return (LinkScreenCastType[]) f75462a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public final int getTypeValue() {
        return this.typeValue;
    }

    public LinkScreenCastType(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.typeName = r102;
        this.typeValue = r103;
    }
}
