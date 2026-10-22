package com.bytedance.android.shopping.anchorv3.commentv2.model;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class CommentViewModelV2$mediaViewPool$2 extends Lambda implements Function0<RecyclerView.RecycledViewPool> {
    public static final CommentViewModelV2$mediaViewPool$2 INSTANCE = null;

    static {
        INSTANCE = new CommentViewModelV2$mediaViewPool$2();
    }

    public CommentViewModelV2$mediaViewPool$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final RecyclerView.RecycledViewPool invoke() {
        RecyclerView.RecycledViewPool r100 = new RecyclerView.RecycledViewPool();
        r100.setMaxRecycledViews(1, 2);
        r100.setMaxRecycledViews(2, 9);
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ RecyclerView.RecycledViewPool invoke() {
        return invoke();
    }
}
