package com.bytedance.android.live.revlink.impl.pk.utils;

/* JADX INFO: loaded from: classes47.dex */
public final enum SearchSourceFlag extends Enum<SearchSourceFlag> {
    public static final SearchSourceFlag INVITE_LINKING = null;
    public static final SearchSourceFlag MAIN_LINK = null;
    public static final SearchSourceFlag UNDEFINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchSourceFlag[] f97088a = null;

    static {
        SearchSourceFlag r100 = new SearchSourceFlag("UNDEFINE", 0);
        UNDEFINE = r100;
        SearchSourceFlag r101 = new SearchSourceFlag("MAIN_LINK", 1);
        MAIN_LINK = r101;
        SearchSourceFlag r102 = new SearchSourceFlag("INVITE_LINKING", 2);
        INVITE_LINKING = r102;
        f97088a = new SearchSourceFlag[]{r100, r101, r102};
    }

    public static SearchSourceFlag[] values() {
        return (SearchSourceFlag[]) f97088a.clone();
    }

    public static SearchSourceFlag valueOf(String r100) {
        return (SearchSourceFlag) r27.a.a(SearchSourceFlag.class, r100);
    }

    public SearchSourceFlag(String r100, int r101) {
        super(r100, r101);
    }
}
