package com.chad.library.adapter.base.module;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.apm.constant.CommonKey;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.LoadMoreListenerImp;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.loadmore.BaseLoadMoreView;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020 H\u0000¢\u0006\u0002\b-J\u0006\u0010.\u001a\u00020+J\u0012\u0010/\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0006\u00102\u001a\u00020\u0006J\b\u00103\u001a\u00020+H\u0002J\u0010\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u000206H\u0002J\u0006\u00107\u001a\u00020+J\u0012\u00108\u001a\u00020+2\b\b\u0002\u00109\u001a\u00020\u0006H\u0007J\u0006\u0010:\u001a\u00020+J\u0006\u0010;\u001a\u00020+J\r\u0010<\u001a\u00020+H\u0000¢\u0006\u0002\b=J\u0012\u0010>\u001a\u00020+2\b\u0010?\u001a\u0004\u0018\u00010$H\u0016J\u0015\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020BH\u0000¢\u0006\u0002\bCR\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u001e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u0011\u0010\u0014\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010&\u001a\u00020 2\u0006\u0010\r\u001a\u00020 @FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010)¨\u0006D"}, d2 = {"Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;", "Lcom/chad/library/adapter/base/listener/LoadMoreListenerImp;", "baseQuickAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;)V", "enableLoadMoreEndClick", "", "getEnableLoadMoreEndClick", "()Z", "setEnableLoadMoreEndClick", "(Z)V", "isAutoLoadMore", "setAutoLoadMore", CommonKey.KEY_VALUE, "isEnableLoadMore", "setEnableLoadMore", "isEnableLoadMoreIfNotFullPage", "setEnableLoadMoreIfNotFullPage", "<set-?>", "isLoadEndMoreGone", "isLoading", "Lcom/chad/library/adapter/base/loadmore/LoadMoreStatus;", "loadMoreStatus", "getLoadMoreStatus", "()Lcom/chad/library/adapter/base/loadmore/LoadMoreStatus;", "loadMoreView", "Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "getLoadMoreView", "()Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "setLoadMoreView", "(Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;)V", "loadMoreViewPosition", "", "getLoadMoreViewPosition", "()I", "mLoadMoreListener", "Lcom/chad/library/adapter/base/listener/OnLoadMoreListener;", "mNextLoadEnable", "preLoadNumber", "getPreLoadNumber", "setPreLoadNumber", "(I)V", "autoLoadMore", "", "position", "autoLoadMore$com_github_CymChad_brvah", "checkDisableLoadMoreIfNotFullPage", "getTheBiggestNumber", "numbers", "", "hasLoadMoreView", "invokeLoadMoreListener", "isFullScreen", "llm", "Landroidx/recyclerview/widget/LinearLayoutManager;", "loadMoreComplete", "loadMoreEnd", "gone", "loadMoreFail", "loadMoreToLoading", "reset", "reset$com_github_CymChad_brvah", "setOnLoadMoreListener", "listener", "setupViewHolder", "viewHolder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "setupViewHolder$com_github_CymChad_brvah", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
public class BaseLoadMoreModule implements LoadMoreListenerImp {
    private final BaseQuickAdapter<?, ?> baseQuickAdapter;
    private boolean enableLoadMoreEndClick;
    private boolean isAutoLoadMore;
    private boolean isEnableLoadMore;
    private boolean isEnableLoadMoreIfNotFullPage;
    private boolean isLoadEndMoreGone;

    @NotNull
    private LoadMoreStatus loadMoreStatus;

    @NotNull
    private BaseLoadMoreView loadMoreView;
    private OnLoadMoreListener mLoadMoreListener;
    private boolean mNextLoadEnable;
    private int preLoadNumber;

    public BaseLoadMoreModule(@NotNull BaseQuickAdapter<?, ?> r10) {
        q.h(r10, "baseQuickAdapter");
        this.baseQuickAdapter = r10;
        this.mNextLoadEnable = true;
        this.loadMoreStatus = LoadMoreStatus.Complete;
        this.loadMoreView = LoadMoreModuleConfig.getDefLoadMoreView();
        this.isAutoLoadMore = true;
        this.isEnableLoadMoreIfNotFullPage = true;
        this.preLoadNumber = 1;
    }

    public static final /* synthetic */ BaseQuickAdapter access$getBaseQuickAdapter$p(BaseLoadMoreModule r10) {
        return r10.baseQuickAdapter;
    }

    public static final /* synthetic */ LoadMoreStatus access$getLoadMoreStatus$p(BaseLoadMoreModule r10) {
        return r10.loadMoreStatus;
    }

    public static final /* synthetic */ OnLoadMoreListener access$getMLoadMoreListener$p(BaseLoadMoreModule r10) {
        return r10.mLoadMoreListener;
    }

    public static final /* synthetic */ boolean access$getMNextLoadEnable$p(BaseLoadMoreModule r10) {
        return r10.mNextLoadEnable;
    }

    public static final /* synthetic */ int access$getTheBiggestNumber(BaseLoadMoreModule r10, int[] r11) {
        return r10.getTheBiggestNumber(r11);
    }

    public static final /* synthetic */ boolean access$isFullScreen(BaseLoadMoreModule r10, LinearLayoutManager r11) {
        return r10.isFullScreen(r11);
    }

    public static final /* synthetic */ void access$setLoadMoreStatus$p(BaseLoadMoreModule r10, LoadMoreStatus r11) {
        r10.loadMoreStatus = r11;
    }

    public static final /* synthetic */ void access$setMLoadMoreListener$p(BaseLoadMoreModule r10, OnLoadMoreListener r11) {
        r10.mLoadMoreListener = r11;
    }

    public static final /* synthetic */ void access$setMNextLoadEnable$p(BaseLoadMoreModule r10, boolean r11) {
        r10.mNextLoadEnable = r11;
    }

    private final int getTheBiggestNumber(int[] r10) {
        int r11 = -1;
        if (r10 != null) goto L5;
    L13:
        return r11;
    L5:
        if (r10.length == 0) goto L13;
        int r12 = r10.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L13;
        int r14 = r10[r13];
        if (r14 <= r11) goto L12;
        r11 = r14;
    L12:
        r13 = r13 + 1;
        goto L8
    }

    private final void invokeLoadMoreListener() {
        this.loadMoreStatus = LoadMoreStatus.Loading;
        RecyclerView r10 = this.baseQuickAdapter.getWeakRecyclerView().get();
        if (r10 == null) goto L5;
        r10.post(new BaseLoadMoreModule$invokeLoadMoreListener$$inlined$let$lambda$1(this));
        return;
    L5:
        OnLoadMoreListener r11 = this.mLoadMoreListener;
        if (r11 == null) goto L10;
        r11.onLoadMore();
        return;
    }

    private final boolean isFullScreen(LinearLayoutManager r10) {
        if ((r10.findLastCompletelyVisibleItemPosition() + 1) == this.baseQuickAdapter.getItemCount()) goto L5;
        return true;
    L5:
        if (r10.findFirstCompletelyVisibleItemPosition() != 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static /* synthetic */ void loadMoreEnd$default(BaseLoadMoreModule r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L6;
        r11 = false;
    L6:
        r10.loadMoreEnd(r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMoreEnd");
    }

    public final void autoLoadMore$com_github_CymChad_brvah(int r10) {
        if (this.isAutoLoadMore == true) goto L6;
        return;
    L6:
        if (hasLoadMoreView() == true) goto L9;
        return;
    L9:
        if (r10 >= (this.baseQuickAdapter.getItemCount() - this.preLoadNumber)) goto L11;
        return;
    L11:
        LoadMoreStatus r11 = this.loadMoreStatus;
        if (r11 == LoadMoreStatus.Complete) goto L15;
        return;
    L15:
        if (r11 != LoadMoreStatus.Loading) goto L18;
        return;
    L18:
        if (this.mNextLoadEnable == true) goto L20;
        return;
    L20:
        invokeLoadMoreListener();
    }

    public final void checkDisableLoadMoreIfNotFullPage() {
        if (this.isEnableLoadMoreIfNotFullPage == false) goto L5;
        return;
    L5:
        this.mNextLoadEnable = false;
        RecyclerView r10 = this.baseQuickAdapter.getWeakRecyclerView().get();
        if (r10 == null) goto L16;
        q.c(r10, "baseQuickAdapter.weakRecyclerView.get() ?: return");
        final RecyclerView.LayoutManager r11 = r10.getLayoutManager();
        if (r11 == null) goto L17;
        q.c(r11, "recyclerView.layoutManager ?: return");
        if ((r11 instanceof LinearLayoutManager) == false) goto L13;
        r10.postDelayed(new AnonymousClass1(this, r11), 50);
        return;
    L13:
        if ((r11 instanceof StaggeredGridLayoutManager) == false) goto L19;
        r10.postDelayed(new AnonymousClass2(this, r11), 50);
        return;
    L19:
        return;
    L17:
        return;
    }

    public final boolean getEnableLoadMoreEndClick() {
        return this.enableLoadMoreEndClick;
    }

    @NotNull
    public final LoadMoreStatus getLoadMoreStatus() {
        return this.loadMoreStatus;
    }

    @NotNull
    public final BaseLoadMoreView getLoadMoreView() {
        return this.loadMoreView;
    }

    public final int getLoadMoreViewPosition() {
        if (this.baseQuickAdapter.hasEmptyView() == false) goto L6;
        return -1;
    L6:
        BaseQuickAdapter<?, ?> r10 = this.baseQuickAdapter;
        return (r10.getHeaderLayoutCount() + r10.getData().size()) + r10.getFooterLayoutCount();
    }

    public final int getPreLoadNumber() {
        return this.preLoadNumber;
    }

    public final boolean hasLoadMoreView() {
        if (this.mLoadMoreListener != null) goto L5;
    L14:
        return false;
    L5:
        if (this.isEnableLoadMore == false) goto L14;
        if (this.loadMoreStatus != LoadMoreStatus.End) goto L13;
        if (this.isLoadEndMoreGone == false) goto L13;
        return false;
    L13:
        return !this.baseQuickAdapter.getData().isEmpty();
    }

    public final boolean isAutoLoadMore() {
        return this.isAutoLoadMore;
    }

    public final boolean isEnableLoadMore() {
        return this.isEnableLoadMore;
    }

    public final boolean isEnableLoadMoreIfNotFullPage() {
        return this.isEnableLoadMoreIfNotFullPage;
    }

    public final boolean isLoadEndMoreGone() {
        return this.isLoadEndMoreGone;
    }

    public final boolean isLoading() {
        if (this.loadMoreStatus != LoadMoreStatus.Loading) goto L5;
        return true;
    L5:
        return false;
    }

    public final void loadMoreComplete() {
        if (hasLoadMoreView() == true) goto L5;
        return;
    L5:
        this.loadMoreStatus = LoadMoreStatus.Complete;
        this.baseQuickAdapter.notifyItemChanged(getLoadMoreViewPosition());
        checkDisableLoadMoreIfNotFullPage();
    }

    @JvmOverloads
    public final void loadMoreEnd() {
        loadMoreEnd$default(this, false, 1, null);
    }

    public final void loadMoreFail() {
        if (hasLoadMoreView() == true) goto L5;
        return;
    L5:
        this.loadMoreStatus = LoadMoreStatus.Fail;
        this.baseQuickAdapter.notifyItemChanged(getLoadMoreViewPosition());
    }

    public final void loadMoreToLoading() {
        LoadMoreStatus r10 = this.loadMoreStatus;
        LoadMoreStatus r11 = LoadMoreStatus.Loading;
        if (r10 != r11) goto L5;
        return;
    L5:
        this.loadMoreStatus = r11;
        this.baseQuickAdapter.notifyItemChanged(getLoadMoreViewPosition());
        invokeLoadMoreListener();
    }

    public final void reset$com_github_CymChad_brvah() {
        if (this.mLoadMoreListener == null) goto L6;
        setEnableLoadMore(true);
        this.loadMoreStatus = LoadMoreStatus.Complete;
        return;
    }

    public final void setAutoLoadMore(boolean r10) {
        this.isAutoLoadMore = r10;
    }

    public final void setEnableLoadMore(boolean r10) {
        boolean r11 = hasLoadMoreView();
        this.isEnableLoadMore = r10;
        boolean r12 = hasLoadMoreView();
        if (r11 == false) goto L6;
        if (r12 == true) goto L9;
        this.baseQuickAdapter.notifyItemRemoved(getLoadMoreViewPosition());
        return;
    L9:
        return;
    L6:
        if (r12 == false) goto L11;
        this.loadMoreStatus = LoadMoreStatus.Complete;
        this.baseQuickAdapter.notifyItemInserted(getLoadMoreViewPosition());
        return;
    }

    public final void setEnableLoadMoreEndClick(boolean r10) {
        this.enableLoadMoreEndClick = r10;
    }

    public final void setEnableLoadMoreIfNotFullPage(boolean r10) {
        this.isEnableLoadMoreIfNotFullPage = r10;
    }

    public final void setLoadMoreView(@NotNull BaseLoadMoreView r10) {
        q.h(r10, "<set-?>");
        this.loadMoreView = r10;
    }

    @Override // com.chad.library.adapter.base.listener.LoadMoreListenerImp
    public void setOnLoadMoreListener(@Nullable OnLoadMoreListener r10) {
        this.mLoadMoreListener = r10;
        setEnableLoadMore(true);
    }

    public final void setPreLoadNumber(int r10) {
        if (r10 <= 1) goto L6;
        this.preLoadNumber = r10;
        return;
    }

    public final void setupViewHolder$com_github_CymChad_brvah(@NotNull BaseViewHolder r10) {
        q.h(r10, "viewHolder");
        r10.itemView.setOnClickListener(new BaseLoadMoreModule$setupViewHolder$1(this));
    }

    @JvmOverloads
    public final void loadMoreEnd(boolean r10) {
        if (hasLoadMoreView() == true) goto L5;
        return;
    L5:
        this.isLoadEndMoreGone = r10;
        this.loadMoreStatus = LoadMoreStatus.End;
        if (r10 == false) goto L8;
        this.baseQuickAdapter.notifyItemRemoved(getLoadMoreViewPosition());
        return;
    L8:
        this.baseQuickAdapter.notifyItemChanged(getLoadMoreViewPosition());
    }
}
