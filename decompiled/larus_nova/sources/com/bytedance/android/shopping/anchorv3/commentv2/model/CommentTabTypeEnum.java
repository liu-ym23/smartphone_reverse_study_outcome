package com.bytedance.android.shopping.anchorv3.commentv2.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/commentv2/model/CommentTabTypeEnum;", "", "", "type", "J", "getType", "()J", "STAT", "TAG", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentTabTypeEnum extends Enum<CommentTabTypeEnum> {
    public static final CommentTabTypeEnum STAT = null;
    public static final CommentTabTypeEnum TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentTabTypeEnum[] f164725a = null;
    private final long type;

    static {
        CommentTabTypeEnum r100 = new CommentTabTypeEnum("STAT", 0, 1);
        STAT = r100;
        CommentTabTypeEnum r101 = new CommentTabTypeEnum("TAG", 1, 2);
        TAG = r101;
        f164725a = new CommentTabTypeEnum[]{r100, r101};
    }

    public static CommentTabTypeEnum valueOf(String r100) {
        return (CommentTabTypeEnum) r27.a.a(CommentTabTypeEnum.class, r100);
    }

    public static CommentTabTypeEnum[] values() {
        return (CommentTabTypeEnum[]) f164725a.clone();
    }

    public final long getType() {
        return this.type;
    }

    public CommentTabTypeEnum(String r100, int r101, long r102) {
        super(r100, r101);
        this.type = r102;
    }
}
