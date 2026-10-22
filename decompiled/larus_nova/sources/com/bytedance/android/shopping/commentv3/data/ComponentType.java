package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/ComponentType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "TAB_FILTER", "COMMENT_FILTER_FIRST", "COMMENT_FILTER_SECOND", "COMMENT_NPS", "SORT_HEADER", "COMMENT_HEAD", "COMMENT_MEDIA", "COMMENT_BROWSE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ComponentType extends Enum<ComponentType> {
    public static final ComponentType COMMENT_BROWSE = null;
    public static final ComponentType COMMENT_FILTER_FIRST = null;
    public static final ComponentType COMMENT_FILTER_SECOND = null;
    public static final ComponentType COMMENT_HEAD = null;
    public static final ComponentType COMMENT_MEDIA = null;
    public static final ComponentType COMMENT_NPS = null;
    public static final ComponentType SORT_HEADER = null;
    public static final ComponentType TAB_FILTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComponentType[] f172719a = null;
    private final String type;

    public static ComponentType valueOf(String r100) {
        return (ComponentType) r27.a.a(ComponentType.class, r100);
    }

    public static ComponentType[] values() {
        return (ComponentType[]) f172719a.clone();
    }

    static {
        ComponentType r100 = new ComponentType("TAB_FILTER", 0, "tab_filter_component");
        TAB_FILTER = r100;
        ComponentType r101 = new ComponentType("COMMENT_FILTER_FIRST", 1, "comment_filter_first_component");
        COMMENT_FILTER_FIRST = r101;
        ComponentType r102 = new ComponentType("COMMENT_FILTER_SECOND", 2, "comment_filter_second_component");
        COMMENT_FILTER_SECOND = r102;
        ComponentType r103 = new ComponentType("COMMENT_NPS", 3, "comment_nps_component");
        COMMENT_NPS = r103;
        ComponentType r104 = new ComponentType("SORT_HEADER", 4, "sort_header_component");
        SORT_HEADER = r104;
        ComponentType r105 = new ComponentType("COMMENT_HEAD", 5, "comment_header_component");
        COMMENT_HEAD = r105;
        ComponentType r106 = new ComponentType("COMMENT_MEDIA", 6, "comment_media_component");
        COMMENT_MEDIA = r106;
        ComponentType r107 = new ComponentType("COMMENT_BROWSE", 7, "comment_browse_component");
        COMMENT_BROWSE = r107;
        f172719a = new ComponentType[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final String getType() {
        return this.type;
    }

    public ComponentType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
