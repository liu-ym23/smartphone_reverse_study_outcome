package com.bytedance.android.shopping.anchorv3;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/PageInternalFlowStyle;", "", "PageInternalFlowStyleDefault", "PageInternalFlowStyleTile", "PageInternalFlowStyleFirstCartTile", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PageInternalFlowStyle extends Enum<PageInternalFlowStyle> {
    public static final PageInternalFlowStyle PageInternalFlowStyleDefault = null;
    public static final PageInternalFlowStyle PageInternalFlowStyleFirstCartTile = null;
    public static final PageInternalFlowStyle PageInternalFlowStyleTile = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageInternalFlowStyle[] f164394a = null;

    static {
        PageInternalFlowStyle r100 = new PageInternalFlowStyle("PageInternalFlowStyleDefault", 0);
        PageInternalFlowStyleDefault = r100;
        PageInternalFlowStyle r101 = new PageInternalFlowStyle("PageInternalFlowStyleTile", 1);
        PageInternalFlowStyleTile = r101;
        PageInternalFlowStyle r102 = new PageInternalFlowStyle("PageInternalFlowStyleFirstCartTile", 2);
        PageInternalFlowStyleFirstCartTile = r102;
        f164394a = new PageInternalFlowStyle[]{r100, r101, r102};
    }

    public static PageInternalFlowStyle valueOf(String r100) {
        return (PageInternalFlowStyle) r27.a.a(PageInternalFlowStyle.class, r100);
    }

    public static PageInternalFlowStyle[] values() {
        return (PageInternalFlowStyle[]) f164394a.clone();
    }

    public PageInternalFlowStyle(String r100, int r101) {
        super(r100, r101);
    }
}
