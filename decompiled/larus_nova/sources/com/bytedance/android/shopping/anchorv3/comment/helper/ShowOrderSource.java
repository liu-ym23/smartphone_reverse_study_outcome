package com.bytedance.android.shopping.anchorv3.comment.helper;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/helper/ShowOrderSource;", "", "", "source", "I", "getSource", "()I", "setSource", "(I)V", "HAS_COMMENT_SHOW_ORDER", "COMMENT_PUBLISH_SHOW_ORDER", "COMMENT_LIST_SHOR_ORDER", "EVALUATOR_SHOW_ORDER_TASK", "OTHER_PAGE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShowOrderSource extends Enum<ShowOrderSource> {
    public static final ShowOrderSource COMMENT_LIST_SHOR_ORDER = null;
    public static final ShowOrderSource COMMENT_PUBLISH_SHOW_ORDER = null;
    public static final ShowOrderSource EVALUATOR_SHOW_ORDER_TASK = null;
    public static final ShowOrderSource HAS_COMMENT_SHOW_ORDER = null;
    public static final ShowOrderSource OTHER_PAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShowOrderSource[] f164526a = null;
    private int source;

    static {
        ShowOrderSource r100 = new ShowOrderSource("HAS_COMMENT_SHOW_ORDER", 0, 1);
        HAS_COMMENT_SHOW_ORDER = r100;
        ShowOrderSource r101 = new ShowOrderSource("COMMENT_PUBLISH_SHOW_ORDER", 1, 2);
        COMMENT_PUBLISH_SHOW_ORDER = r101;
        ShowOrderSource r102 = new ShowOrderSource("COMMENT_LIST_SHOR_ORDER", 2, 3);
        COMMENT_LIST_SHOR_ORDER = r102;
        ShowOrderSource r103 = new ShowOrderSource("EVALUATOR_SHOW_ORDER_TASK", 3, 4);
        EVALUATOR_SHOW_ORDER_TASK = r103;
        ShowOrderSource r104 = new ShowOrderSource("OTHER_PAGE", 4, 5);
        OTHER_PAGE = r104;
        f164526a = new ShowOrderSource[]{r100, r101, r102, r103, r104};
    }

    public static ShowOrderSource valueOf(String r100) {
        return (ShowOrderSource) a.a(ShowOrderSource.class, r100);
    }

    public static ShowOrderSource[] values() {
        return (ShowOrderSource[]) f164526a.clone();
    }

    public final int getSource() {
        return this.source;
    }

    public final void setSource(int r100) {
        this.source = r100;
    }

    public ShowOrderSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.source = r102;
    }
}
