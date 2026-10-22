package com.bytedanceos.appstore.buss.widget.app.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemVerticalAdapter;
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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001#B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR \u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/pager/PagerVerticalView;", "Lcom/bytedanceos/appstore/buss/widget/app/base/BaseAppPagerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "pageSource", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Ljava/lang/String;)V", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", ServerElements.LIST, "", "setItems", "(Ljava/util/List;)V", "j", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "setPageSource", "(Ljava/lang/String;)V", "Lcom/bytedanceos/appstore/buss/widget/recyclerview/CommonRecyclerView;", "k", "Lkotlin/Lazy;", "getRecyclerView", "()Lcom/bytedanceos/appstore/buss/widget/recyclerview/CommonRecyclerView;", "recyclerView", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "l", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "getAdapter", "()Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "adapter", "m", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PagerVerticalView extends BaseAppPagerView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f9233m = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f9234j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f9235k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final BaseProviderMultiAdapter f9236l;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f9233m = new a(null);
    }

    public /* synthetic */ PagerVerticalView(Context r10, AttributeSet r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = "";
    L8:
        this(r10, r11, r12);
    }

    @Override // com.bytedanceos.appstore.buss.widget.base.BasePagerView
    /* JADX INFO: renamed from: getAdapter, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ BaseQuickAdapter<CommonAppEntity, BaseViewHolder> getAdapter2() {
        return getAdapter();
    }

    @Nullable
    public final String getPageSource() {
        return this.f9234j;
    }

    @NotNull
    public final CommonRecyclerView getRecyclerView() {
        return (CommonRecyclerView) this.f9235k.getValue();
    }

    @Override // com.bytedanceos.appstore.buss.widget.app.base.BaseAppPagerView, com.bytedanceos.appstore.buss.widget.base.BasePagerView
    public void setItems(@NotNull List<? extends CommonAppEntity> r10) {
        q.g(r10, ServerElements.LIST);
        if (getRecyclerView().getAdapter() != null) goto L9;
        u7.a.c(u7.a.f24888a, getRecyclerView(), 0, 2, null);
        LinearLayoutManager r11 = new LinearLayoutManager(getContext());
        r11.setOrientation(0);
        getRecyclerView().setLayoutManager(r11);
        new w7.a(getSpanCount() * 3).b(getRecyclerView());
        getRecyclerView().setHasFixedSize(true);
        super.setItems(r10);
        getRecyclerView().setAdapter(getAdapter());
        if (i() == true) goto L7;
        ViewGroup.LayoutParams r12 = getRecyclerView().getLayoutParams();
        q.e(r12, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        r13.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.dp_42);
        getRecyclerView().setLayoutParams(r13);
    L8:
        getRecyclerView().setPageSource(this.f9234j);
        getRecyclerView().setPosition(getRow());
        getRecyclerView().setWidgetType("widget_pager_vertical");
        setWidgetType("widget_pager_vertical");
        return;
    L7:
        ViewGroup.LayoutParams r14 = getRecyclerView().getLayoutParams();
        q.e(r14, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        r15.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.dp_18);
        getRecyclerView().setLayoutParams(r15);
        goto L8
    L9:
        super.setItems(r10);
    }

    public final void setPageSource(@Nullable String r10) {
        this.f9234j = r10;
    }

    public PagerVerticalView(Context r10, AttributeSet r11, String r12) {
        q.g(r10, "context");
        super(r10, r11);
        this.f9234j = r12;
        this.f9235k = b.b(new PagerVerticalView$recyclerView$2(this));
        this.f9236l = new ItemVerticalAdapter(r12);
        View.inflate(r10, R.layout.tv_item_view_pager_app_vertical, this);
    }

    @Override // com.bytedanceos.appstore.buss.widget.base.BasePagerView
    @NotNull
    public BaseQuickAdapter<CommonAppEntity, BaseViewHolder> getAdapter() {
        return this.f9236l;
    }
}
