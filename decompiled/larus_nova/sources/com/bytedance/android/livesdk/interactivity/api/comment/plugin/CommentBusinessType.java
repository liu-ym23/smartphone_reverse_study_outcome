package com.bytedance.android.livesdk.interactivity.api.comment.plugin;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/plugin/CommentBusinessType;", "", "Normal", "Danmu", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentBusinessType extends Enum<CommentBusinessType> {
    public static final CommentBusinessType Danmu = null;
    public static final CommentBusinessType Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentBusinessType[] f133045a = null;

    static {
        CommentBusinessType r100 = new CommentBusinessType("Normal", 0);
        Normal = r100;
        CommentBusinessType r101 = new CommentBusinessType("Danmu", 1);
        Danmu = r101;
        f133045a = new CommentBusinessType[]{r100, r101};
    }

    public static CommentBusinessType valueOf(String r100) {
        return (CommentBusinessType) a.a(CommentBusinessType.class, r100);
    }

    public static CommentBusinessType[] values() {
        return (CommentBusinessType[]) f133045a.clone();
    }

    public CommentBusinessType(String r100, int r101) {
        super(r100, r101);
    }
}
