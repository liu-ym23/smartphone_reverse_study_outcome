package com.bytedance.android.shopping.store.mall.follows;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/DisplayType;", "", "", "value", "I", "getValue", "()I", EffectConstants.NORMAL, "FILTER_CARD_FIRST", "CONTENT_CARD_BOTTOM_WITH_FILTER", "CONTENT_CARD_LAST", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DisplayType extends Enum<DisplayType> {
    public static final DisplayType CONTENT_CARD_BOTTOM_WITH_FILTER = null;
    public static final DisplayType CONTENT_CARD_LAST = null;
    public static final DisplayType FILTER_CARD_FIRST = null;
    public static final DisplayType NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DisplayType[] f185522a = null;
    private final int value;

    static {
        DisplayType r100 = new DisplayType(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        DisplayType r101 = new DisplayType("FILTER_CARD_FIRST", 1, 1);
        FILTER_CARD_FIRST = r101;
        DisplayType r102 = new DisplayType("CONTENT_CARD_BOTTOM_WITH_FILTER", 2, 2);
        CONTENT_CARD_BOTTOM_WITH_FILTER = r102;
        DisplayType r103 = new DisplayType("CONTENT_CARD_LAST", 3, 3);
        CONTENT_CARD_LAST = r103;
        f185522a = new DisplayType[]{r100, r101, r102, r103};
    }

    public static DisplayType valueOf(String r100) {
        return (DisplayType) a.a(DisplayType.class, r100);
    }

    public static DisplayType[] values() {
        return (DisplayType[]) f185522a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public DisplayType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
