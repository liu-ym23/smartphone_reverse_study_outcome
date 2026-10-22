package com.bytedance.android.ec.window.base.search.recyclerview.vo;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/window/base/search/recyclerview/vo/WindowSearchResultItemType;", "", "", "typeValue", "I", "getTypeValue", "()I", "SEARCH_RESULT", "RECOMMENDED_RESULT", "RECOMMEND_NOTICE", "FOOTER_VIEW", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowSearchResultItemType extends Enum<WindowSearchResultItemType> {
    public static final WindowSearchResultItemType FOOTER_VIEW = null;
    public static final WindowSearchResultItemType RECOMMENDED_RESULT = null;
    public static final WindowSearchResultItemType RECOMMEND_NOTICE = null;
    public static final WindowSearchResultItemType SEARCH_RESULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowSearchResultItemType[] f49554a = null;
    private final int typeValue;

    static {
        WindowSearchResultItemType r100 = new WindowSearchResultItemType("SEARCH_RESULT", 0, 1);
        SEARCH_RESULT = r100;
        WindowSearchResultItemType r101 = new WindowSearchResultItemType("RECOMMENDED_RESULT", 1, 2);
        RECOMMENDED_RESULT = r101;
        WindowSearchResultItemType r102 = new WindowSearchResultItemType("RECOMMEND_NOTICE", 2, 3);
        RECOMMEND_NOTICE = r102;
        WindowSearchResultItemType r103 = new WindowSearchResultItemType("FOOTER_VIEW", 3, 4);
        FOOTER_VIEW = r103;
        f49554a = new WindowSearchResultItemType[]{r100, r101, r102, r103};
    }

    public static WindowSearchResultItemType valueOf(String r100) {
        return (WindowSearchResultItemType) a.a(WindowSearchResultItemType.class, r100);
    }

    public static WindowSearchResultItemType[] values() {
        return (WindowSearchResultItemType[]) f49554a.clone();
    }

    public final int getTypeValue() {
        return this.typeValue;
    }

    public WindowSearchResultItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeValue = r102;
    }
}
