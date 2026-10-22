package com.bytedance.android.shopping.anchorv3.commentv2.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/commentv2/api/SliceDataTypeEnum;", "", "", "type", "I", "getType", "()I", "TYPE_DEFAULT", "TYPE_TAB_CARD", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SliceDataTypeEnum extends Enum<SliceDataTypeEnum> {
    public static final SliceDataTypeEnum TYPE_DEFAULT = null;
    public static final SliceDataTypeEnum TYPE_TAB_CARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SliceDataTypeEnum[] f164720a = null;
    private final int type;

    static {
        SliceDataTypeEnum r100 = new SliceDataTypeEnum("TYPE_DEFAULT", 0, 0);
        TYPE_DEFAULT = r100;
        SliceDataTypeEnum r101 = new SliceDataTypeEnum("TYPE_TAB_CARD", 1, 1);
        TYPE_TAB_CARD = r101;
        f164720a = new SliceDataTypeEnum[]{r100, r101};
    }

    public static SliceDataTypeEnum valueOf(String r100) {
        return (SliceDataTypeEnum) a.a(SliceDataTypeEnum.class, r100);
    }

    public static SliceDataTypeEnum[] values() {
        return (SliceDataTypeEnum[]) f164720a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public SliceDataTypeEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
