package com.bytedance.android.ec.store.search.recyclerview.vo;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/store/search/recyclerview/vo/SearchResultItemType;", "", "", "typeValue", "I", "getTypeValue", "()I", "SEARCH_RESULT", "RECOMMENDED_RESULT", "RECOMMEND_NOTICE", "FOOTER_VIEW", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SearchResultItemType extends Enum<SearchResultItemType> {
    public static final SearchResultItemType FOOTER_VIEW = null;
    public static final SearchResultItemType RECOMMENDED_RESULT = null;
    public static final SearchResultItemType RECOMMEND_NOTICE = null;
    public static final SearchResultItemType SEARCH_RESULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchResultItemType[] f48571a = null;
    private final int typeValue;

    static {
        SearchResultItemType r100 = new SearchResultItemType("SEARCH_RESULT", 0, 1);
        SEARCH_RESULT = r100;
        SearchResultItemType r101 = new SearchResultItemType("RECOMMENDED_RESULT", 1, 2);
        RECOMMENDED_RESULT = r101;
        SearchResultItemType r102 = new SearchResultItemType("RECOMMEND_NOTICE", 2, 3);
        RECOMMEND_NOTICE = r102;
        SearchResultItemType r103 = new SearchResultItemType("FOOTER_VIEW", 3, 4);
        FOOTER_VIEW = r103;
        f48571a = new SearchResultItemType[]{r100, r101, r102, r103};
    }

    public static SearchResultItemType valueOf(String r100) {
        return (SearchResultItemType) a.a(SearchResultItemType.class, r100);
    }

    public static SearchResultItemType[] values() {
        return (SearchResultItemType[]) f48571a.clone();
    }

    public final int getTypeValue() {
        return this.typeValue;
    }

    public SearchResultItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeValue = r102;
    }
}
