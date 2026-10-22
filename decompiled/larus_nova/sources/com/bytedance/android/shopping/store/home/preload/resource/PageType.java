package com.bytedance.android.shopping.store.home.preload.resource;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/home/preload/resource/PageType;", "", "", "pageType", "I", "getPageType", "()I", "DEFAULT", "ISV", "FEATURED", "TAB_KIT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PageType extends Enum<PageType> {
    public static final PageType DEFAULT = null;
    public static final PageType FEATURED = null;
    public static final PageType ISV = null;
    public static final PageType TAB_KIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageType[] f183829a = null;
    private final int pageType;

    static {
        PageType r100 = new PageType("DEFAULT", 0, 0);
        DEFAULT = r100;
        PageType r101 = new PageType("ISV", 1, 1);
        ISV = r101;
        PageType r102 = new PageType("FEATURED", 2, 2);
        FEATURED = r102;
        PageType r103 = new PageType("TAB_KIT", 3, 3);
        TAB_KIT = r103;
        f183829a = new PageType[]{r100, r101, r102, r103};
    }

    public static PageType valueOf(String r100) {
        return (PageType) a.a(PageType.class, r100);
    }

    public static PageType[] values() {
        return (PageType[]) f183829a.clone();
    }

    public final int getPageType() {
        return this.pageType;
    }

    public PageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.pageType = r102;
    }
}
