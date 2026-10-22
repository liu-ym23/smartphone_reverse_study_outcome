package com.bytedance.android.shopping.anchorv3.commentv2.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/commentv2/model/CommentNpsVersion;", "", "", "version", "I", "getVersion", "()I", "DEFAULT", "NEW_NPS", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentNpsVersion extends Enum<CommentNpsVersion> {
    public static final CommentNpsVersion DEFAULT = null;
    public static final CommentNpsVersion NEW_NPS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentNpsVersion[] f164722a = null;
    private final int version;

    static {
        CommentNpsVersion r100 = new CommentNpsVersion("DEFAULT", 0, 0);
        DEFAULT = r100;
        CommentNpsVersion r101 = new CommentNpsVersion("NEW_NPS", 1, 1);
        NEW_NPS = r101;
        f164722a = new CommentNpsVersion[]{r100, r101};
    }

    public static CommentNpsVersion valueOf(String r100) {
        return (CommentNpsVersion) r27.a.a(CommentNpsVersion.class, r100);
    }

    public static CommentNpsVersion[] values() {
        return (CommentNpsVersion[]) f164722a.clone();
    }

    public final int getVersion() {
        return this.version;
    }

    public CommentNpsVersion(String r100, int r101, int r102) {
        super(r100, r101);
        this.version = r102;
    }
}
