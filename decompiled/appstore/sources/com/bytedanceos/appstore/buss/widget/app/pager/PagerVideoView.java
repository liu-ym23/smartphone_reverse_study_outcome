package com.bytedanceos.appstore.buss.widget.app.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemVideoAdapter;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.widget.app.base.BaseAppPagerView;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import com.bytedanceos.common.toolbox.ServerElements;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u7.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u000fR&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00130\u00128\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/pager/PagerVideoView;", "Lcom/bytedanceos/appstore/buss/widget/app/base/BaseAppPagerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", ServerElements.LIST, "", "setItems", "(Ljava/util/List;)V", "o", "()V", "n", "m", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "j", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "getAdapter", "()Lcom/chad/library/adapter/base/BaseQuickAdapter;", "adapter", "Lcom/bytedanceos/appstore/buss/widget/recyclerview/CommonRecyclerView;", "k", "Lkotlin/Lazy;", "getRecyclerView", "()Lcom/bytedanceos/appstore/buss/widget/recyclerview/CommonRecyclerView;", "recyclerView", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PagerVideoView extends BaseAppPagerView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BaseQuickAdapter f9237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f9238k;

    public /* synthetic */ PagerVideoView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @Override // com.bytedanceos.appstore.buss.widget.base.BasePagerView
    @NotNull
    public BaseQuickAdapter<CommonAppEntity, BaseViewHolder> getAdapter() {
        return this.f9237j;
    }

    @NotNull
    public final CommonRecyclerView getRecyclerView() {
        return (CommonRecyclerView) this.f9238k.getValue();
    }

    public final void m() {
        BaseQuickAdapter<CommonAppEntity, BaseViewHolder> r10 = getAdapter();
        q.e(r10, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemVideoAdapter");
        ((ItemVideoAdapter) r10).a();
    }

    public final void n() {
        BaseQuickAdapter<CommonAppEntity, BaseViewHolder> r10 = getAdapter();
        q.e(r10, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemVideoAdapter");
        ((ItemVideoAdapter) r10).onPause();
    }

    public final void o() {
        BaseQuickAdapter<CommonAppEntity, BaseViewHolder> r10 = getAdapter();
        q.e(r10, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemVideoAdapter");
        ((ItemVideoAdapter) r10).onResume();
    }

    @Override // com.bytedanceos.appstore.buss.widget.app.base.BaseAppPagerView, com.bytedanceos.appstore.buss.widget.base.BasePagerView
    public void setItems(@NotNull List<? extends CommonAppEntity> r10) {
        q.g(r10, ServerElements.LIST);
        if (getRecyclerView().getAdapter() != null) goto L5;
        a.c(a.f24888a, getRecyclerView(), 0, 2, null);
        LinearLayoutManager r11 = new LinearLayoutManager(getContext());
        r11.setOrientation(0);
        getRecyclerView().setLayoutManager(r11);
        new w7.a(getSpanCount()).b(getRecyclerView());
        getRecyclerView().setHasFixedSize(true);
        super.setItems(r10);
        getRecyclerView().setAdapter(getAdapter());
        return;
    L5:
        super.setItems(r10);
    }

    public PagerVideoView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f9237j = new ItemVideoAdapter();
        this.f9238k = b.b(new PagerVideoView$recyclerView$2(this));
        View.inflate(r10, R.layout.tv_item_view_pager_app_video, this);
    }
}
