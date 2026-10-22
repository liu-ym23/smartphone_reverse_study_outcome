package com.bytedanceos.appstore.buss.widget.app.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemBannerSmallAdapter;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.widget.app.base.BaseAppPagerView;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import com.bytedanceos.common.toolbox.ServerElements;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014¢\u0006\u0004\b\f\u0010\rR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR \u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u001c8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/pager/PagerBannerSmallView;", "Lcom/bytedanceos/appstore/buss/widget/app/base/BaseAppPagerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", ServerElements.LIST, "", "setItems", "(Ljava/util/List;)V", "", "j", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "pageName", "Lcom/bytedanceos/appstore/buss/widget/recyclerview/CommonRecyclerView;", "k", "Lkotlin/Lazy;", "getRecyclerView", "()Lcom/bytedanceos/appstore/buss/widget/recyclerview/CommonRecyclerView;", "recyclerView", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "l", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "getAdapter", "()Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "adapter", "m", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PagerBannerSmallView extends BaseAppPagerView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f9201m = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f9202j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f9203k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final BaseProviderMultiAdapter f9204l;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f9201m = new a(null);
    }

    public /* synthetic */ PagerBannerSmallView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @Override // com.bytedanceos.appstore.buss.widget.base.BasePagerView
    /* JADX INFO: renamed from: getAdapter, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ BaseQuickAdapter<CommonAppEntity, BaseViewHolder> getAdapter2() {
        return getAdapter();
    }

    @Nullable
    public final String getPageName() {
        return this.f9202j;
    }

    @NotNull
    public final CommonRecyclerView getRecyclerView() {
        return (CommonRecyclerView) this.f9203k.getValue();
    }

    @Override // com.bytedanceos.appstore.buss.widget.app.base.BaseAppPagerView, com.bytedanceos.appstore.buss.widget.base.BasePagerView
    public void setItems(@NotNull List<? extends CommonAppEntity> r10) {
        q.g(r10, ServerElements.LIST);
        if (getRecyclerView().getAdapter() != null) goto L5;
        u7.a.c(u7.a.f24888a, getRecyclerView(), 0, 2, null);
        LinearLayoutManager r11 = new LinearLayoutManager(getContext());
        r11.setOrientation(0);
        new w7.a(getSpanCount()).b(getRecyclerView());
        getRecyclerView().setLayoutManager(r11);
        getRecyclerView().setHasFixedSize(true);
        BaseQuickAdapter<CommonAppEntity, BaseViewHolder> r12 = getAdapter();
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemBannerSmallAdapter");
        ((ItemBannerSmallAdapter) r12).d(getRow());
        ((ItemBannerSmallAdapter) getAdapter()).c(this.f9202j);
        super.setItems(r10);
        getRecyclerView().setAdapter(getAdapter());
        getRecyclerView().setPageSource(this.f9202j);
        getRecyclerView().setPosition(getRow());
        getRecyclerView().setWidgetType("widget_pager_smaller_banner");
        setWidgetType("widget_pager_smaller_banner");
        return;
    L5:
        super.setItems(r10);
    }

    public final void setPageName(@Nullable String r10) {
        this.f9202j = r10;
    }

    public PagerBannerSmallView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f9202j = "";
        this.f9203k = b.b(new PagerBannerSmallView$recyclerView$2(this));
        this.f9204l = new ItemBannerSmallAdapter();
        View.inflate(r10, R.layout.tv_item_view_pager_banner_small, this);
    }

    @Override // com.bytedanceos.appstore.buss.widget.base.BasePagerView
    @NotNull
    public BaseQuickAdapter<CommonAppEntity, BaseViewHolder> getAdapter() {
        return this.f9204l;
    }
}
