package com.bytedance.android.shopping.anchorv3.guessulike.model;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemStyle;", "", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "MORE", "SUB", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ItemStyle extends Enum<ItemStyle> {
    private static final /* synthetic */ ItemStyle[] $VALUES = null;
    public static final ItemStyle MORE = null;
    public static final ItemStyle NORMAL = null;
    public static final ItemStyle SUB = null;

    static {
        ItemStyle r100 = new ItemStyle(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ItemStyle r101 = new ItemStyle("MORE", 1);
        MORE = r101;
        ItemStyle r102 = new ItemStyle("SUB", 2);
        SUB = r102;
        $VALUES = new ItemStyle[]{r100, r101, r102};
    }

    public static ItemStyle valueOf(String r100) {
        return (ItemStyle) a.a(ItemStyle.class, r100);
    }

    public static ItemStyle[] values() {
        return (ItemStyle[]) $VALUES.clone();
    }

    private ItemStyle(String r100, int r101) {
        super(r100, r101);
    }
}
