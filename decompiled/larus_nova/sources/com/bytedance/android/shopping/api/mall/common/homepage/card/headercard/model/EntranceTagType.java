package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/EntranceTagType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Price", "PlainText", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EntranceTagType extends Enum<EntranceTagType> {
    private static final /* synthetic */ EntranceTagType[] $VALUES = null;
    public static final EntranceTagType PlainText = null;
    public static final EntranceTagType Price = null;
    private final int value;

    static {
        EntranceTagType r100 = new EntranceTagType("Price", 0, 1);
        Price = r100;
        EntranceTagType r101 = new EntranceTagType("PlainText", 1, 2);
        PlainText = r101;
        $VALUES = new EntranceTagType[]{r100, r101};
    }

    public static EntranceTagType valueOf(String r100) {
        return (EntranceTagType) a.a(EntranceTagType.class, r100);
    }

    public static EntranceTagType[] values() {
        return (EntranceTagType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private EntranceTagType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
