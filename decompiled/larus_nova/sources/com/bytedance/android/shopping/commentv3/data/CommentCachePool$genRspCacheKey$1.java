package com.bytedance.android.shopping.commentv3.data;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class CommentCachePool$genRspCacheKey$1 extends FunctionReferenceImpl implements Function1<Object, String> {
    public static final CommentCachePool$genRspCacheKey$1 INSTANCE = null;

    static {
        INSTANCE = new CommentCachePool$genRspCacheKey$1();
    }

    public CommentCachePool$genRspCacheKey$1() {
        super(1, Intrinsics.Kotlin.class, "toString", "toString(Ljava/lang/Object;)Ljava/lang/String;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Object r100) {
        return invoke2(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Object r100) {
        return String.valueOf(r100);
    }
}
