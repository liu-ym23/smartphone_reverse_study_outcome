package com.bytedance.android.shopping.anchorv3.commentv2.model;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class CommentCacheManagerNew$genRspCacheKey$1 extends FunctionReferenceImpl implements Function1<Object, String> {
    public static final CommentCacheManagerNew$genRspCacheKey$1 INSTANCE = null;

    static {
        INSTANCE = new CommentCacheManagerNew$genRspCacheKey$1();
    }

    public CommentCacheManagerNew$genRspCacheKey$1() {
        super(1, Long.TYPE, "toString", "toString()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Object r100) {
        return invoke(((Number) r100).longValue());
    }

    public final String invoke(long r100) {
        return String.valueOf(r100);
    }
}
