package com.bytedance.android.shopping.anchorv3.comment;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/PostSource;", "", "CLICK", "NOT_CLICK", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PostSource extends Enum<PostSource> {
    public static final PostSource CLICK = null;
    public static final PostSource NOT_CLICK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PostSource[] f164497a = null;

    static {
        PostSource r100 = new PostSource("CLICK", 0);
        CLICK = r100;
        PostSource r101 = new PostSource("NOT_CLICK", 1);
        NOT_CLICK = r101;
        f164497a = new PostSource[]{r100, r101};
    }

    public static PostSource valueOf(String r100) {
        return (PostSource) r27.a.a(PostSource.class, r100);
    }

    public static PostSource[] values() {
        return (PostSource[]) f164497a.clone();
    }

    public PostSource(String r100, int r101) {
        super(r100, r101);
    }
}
