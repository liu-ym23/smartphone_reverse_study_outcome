package com.chad.library.adapter.base.loadmore;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0014\u0010\u0013\u001a\u00020\u0004*\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0016"}, d2 = {"Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "", "()V", "convert", "", "holder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "position", "", "loadMoreStatus", "Lcom/chad/library/adapter/base/loadmore/LoadMoreStatus;", "getLoadComplete", "Landroid/view/View;", "getLoadEndView", "getLoadFailView", "getLoadingView", "getRootView", "parent", "Landroid/view/ViewGroup;", "isVisible", "visible", "", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
public abstract class BaseLoadMoreView {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[LoadMoreStatus.values().length];
            $EnumSwitchMapping$0 = r10;
            r10[LoadMoreStatus.Complete.ordinal()] = 1;
            r10[LoadMoreStatus.Loading.ordinal()] = 2;
            r10[LoadMoreStatus.Fail.ordinal()] = 3;
            r10[LoadMoreStatus.End.ordinal()] = 4;
        }
    }

    public BaseLoadMoreView() {
    }

    private final void isVisible(@NotNull View r10, boolean r11) {
        if (r11 == false) goto L4;
        int r12 = 0;
    L5:
        r10.setVisibility(r12);
        return;
    L4:
        r12 = 8;
        goto L5
    }

    public void convert(@NotNull BaseViewHolder r10, int r11, @NotNull LoadMoreStatus r12) {
        q.h(r10, "holder");
        q.h(r12, "loadMoreStatus");
        int r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        if (r13 != 1) goto L5;
        isVisible(getLoadingView(r10), false);
        isVisible(getLoadComplete(r10), true);
        isVisible(getLoadFailView(r10), false);
        isVisible(getLoadEndView(r10), false);
        return;
    L5:
        if (r13 != 2) goto L7;
        isVisible(getLoadingView(r10), true);
        isVisible(getLoadComplete(r10), false);
        isVisible(getLoadFailView(r10), false);
        isVisible(getLoadEndView(r10), false);
        return;
    L7:
        if (r13 != 3) goto L9;
        isVisible(getLoadingView(r10), false);
        isVisible(getLoadComplete(r10), false);
        isVisible(getLoadFailView(r10), true);
        isVisible(getLoadEndView(r10), false);
        return;
    L9:
        if (r13 != 4) goto L19;
        isVisible(getLoadingView(r10), false);
        isVisible(getLoadComplete(r10), false);
        isVisible(getLoadFailView(r10), false);
        isVisible(getLoadEndView(r10), true);
        return;
    }

    @NotNull
    public abstract View getLoadComplete(@NotNull BaseViewHolder r10);

    @NotNull
    public abstract View getLoadEndView(@NotNull BaseViewHolder r10);

    @NotNull
    public abstract View getLoadFailView(@NotNull BaseViewHolder r10);

    @NotNull
    public abstract View getLoadingView(@NotNull BaseViewHolder r10);

    @NotNull
    public abstract View getRootView(@NotNull ViewGroup r10);
}
