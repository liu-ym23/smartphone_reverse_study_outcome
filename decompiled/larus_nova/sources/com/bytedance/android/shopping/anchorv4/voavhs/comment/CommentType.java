package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/CommentType;", "", "TYPE_SHOP", "TYPE_PRODUCT", "TYPE_BUYERS_SHOW", "TYPE_COMMENT_REGION", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentType extends Enum<CommentType> {
    public static final CommentType TYPE_BUYERS_SHOW = null;
    public static final CommentType TYPE_COMMENT_REGION = null;
    public static final CommentType TYPE_PRODUCT = null;
    public static final CommentType TYPE_SHOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentType[] f168122a = null;

    static {
        CommentType r100 = new CommentType("TYPE_SHOP", 0);
        TYPE_SHOP = r100;
        CommentType r101 = new CommentType("TYPE_PRODUCT", 1);
        TYPE_PRODUCT = r101;
        CommentType r102 = new CommentType("TYPE_BUYERS_SHOW", 2);
        TYPE_BUYERS_SHOW = r102;
        CommentType r103 = new CommentType("TYPE_COMMENT_REGION", 3);
        TYPE_COMMENT_REGION = r103;
        f168122a = new CommentType[]{r100, r101, r102, r103};
    }

    public static CommentType valueOf(String r100) {
        return (CommentType) r27.a.a(CommentType.class, r100);
    }

    public static CommentType[] values() {
        return (CommentType[]) f168122a.clone();
    }

    public CommentType(String r100, int r101) {
        super(r100, r101);
    }
}
