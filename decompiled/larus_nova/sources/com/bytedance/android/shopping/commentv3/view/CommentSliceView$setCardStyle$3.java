package com.bytedance.android.shopping.commentv3.view;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "p1", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class CommentSliceView$setCardStyle$3 extends FunctionReferenceImpl implements Function1<Integer, Integer> {
    public CommentSliceView$setCardStyle$3(CommentSliceView r100) {
        super(1, r100, CommentSliceView.class, "slcDp2Px", "slcDp2Px(I)I", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Integer r100) {
        return Integer.valueOf(invoke(r100.intValue()));
    }

    public final int invoke(int r100) {
        return ((CommentSliceView) this.receiver).c(r100);
    }
}
