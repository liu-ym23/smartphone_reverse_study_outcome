package com.bytedance.android.window.shop.repository.dto;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/SplitConfigTypes;", "", "", "type", "I", "getType", "()I", "HIDE", "SHOW", "SHOW2HIDE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SplitConfigTypes extends Enum<SplitConfigTypes> {
    public static final SplitConfigTypes HIDE = null;
    public static final SplitConfigTypes SHOW = null;
    public static final SplitConfigTypes SHOW2HIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SplitConfigTypes[] f189419a = null;
    private final int type;

    static {
        SplitConfigTypes r100 = new SplitConfigTypes("HIDE", 0, 0);
        HIDE = r100;
        SplitConfigTypes r101 = new SplitConfigTypes("SHOW", 1, 1);
        SHOW = r101;
        SplitConfigTypes r102 = new SplitConfigTypes("SHOW2HIDE", 2, 2);
        SHOW2HIDE = r102;
        f189419a = new SplitConfigTypes[]{r100, r101, r102};
    }

    public static SplitConfigTypes valueOf(String r100) {
        return (SplitConfigTypes) r27.a.a(SplitConfigTypes.class, r100);
    }

    public static SplitConfigTypes[] values() {
        return (SplitConfigTypes[]) f189419a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public SplitConfigTypes(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
