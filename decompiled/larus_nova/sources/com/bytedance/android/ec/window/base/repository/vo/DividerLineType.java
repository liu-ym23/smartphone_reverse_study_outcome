package com.bytedance.android.ec.window.base.repository.vo;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/vo/DividerLineType;", "", "", "type", "I", "getType", "()I", "DASHED_LINE", "SOLID_LINE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DividerLineType extends Enum<DividerLineType> {
    public static final DividerLineType DASHED_LINE = null;
    public static final DividerLineType SOLID_LINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DividerLineType[] f49451a = null;
    private final int type;

    static {
        DividerLineType r100 = new DividerLineType("DASHED_LINE", 0, 1);
        DASHED_LINE = r100;
        DividerLineType r101 = new DividerLineType("SOLID_LINE", 1, 2);
        SOLID_LINE = r101;
        f49451a = new DividerLineType[]{r100, r101};
    }

    public static DividerLineType valueOf(String r100) {
        return (DividerLineType) r27.a.a(DividerLineType.class, r100);
    }

    public static DividerLineType[] values() {
        return (DividerLineType[]) f49451a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public DividerLineType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
