package com.bytedance.android.shopping.anchorv4.dto.meta;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/meta/SupermarketType;", "", "", "type", "I", "getType", "()I", "TYPE_POP", "TYPE_RETAIL", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SupermarketType extends Enum<SupermarketType> {
    public static final SupermarketType TYPE_POP = null;
    public static final SupermarketType TYPE_RETAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SupermarketType[] f166529a = null;
    private final int type;

    static {
        SupermarketType r100 = new SupermarketType("TYPE_POP", 0, 1);
        TYPE_POP = r100;
        SupermarketType r101 = new SupermarketType("TYPE_RETAIL", 1, 2);
        TYPE_RETAIL = r101;
        f166529a = new SupermarketType[]{r100, r101};
    }

    public static SupermarketType valueOf(String r100) {
        return (SupermarketType) a.a(SupermarketType.class, r100);
    }

    public static SupermarketType[] values() {
        return (SupermarketType[]) f166529a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public SupermarketType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
