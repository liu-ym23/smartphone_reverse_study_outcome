package com.bytedance.android.shopping.anchorv3.comment.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentMeaninglessUiVersion;", "", "", "version", "I", "getVersion", "()I", "VERSION_V1", "VERSION_V2", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentMeaninglessUiVersion extends Enum<CommentMeaninglessUiVersion> {
    public static final CommentMeaninglessUiVersion VERSION_V1 = null;
    public static final CommentMeaninglessUiVersion VERSION_V2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentMeaninglessUiVersion[] f164528a = null;
    private final int version;

    static {
        CommentMeaninglessUiVersion r100 = new CommentMeaninglessUiVersion("VERSION_V1", 0, 1);
        VERSION_V1 = r100;
        CommentMeaninglessUiVersion r101 = new CommentMeaninglessUiVersion("VERSION_V2", 1, 2);
        VERSION_V2 = r101;
        f164528a = new CommentMeaninglessUiVersion[]{r100, r101};
    }

    public static CommentMeaninglessUiVersion valueOf(String r100) {
        return (CommentMeaninglessUiVersion) a.a(CommentMeaninglessUiVersion.class, r100);
    }

    public static CommentMeaninglessUiVersion[] values() {
        return (CommentMeaninglessUiVersion[]) f164528a.clone();
    }

    public final int getVersion() {
        return this.version;
    }

    public CommentMeaninglessUiVersion(String r100, int r101, int r102) {
        super(r100, r101);
        this.version = r102;
    }
}
