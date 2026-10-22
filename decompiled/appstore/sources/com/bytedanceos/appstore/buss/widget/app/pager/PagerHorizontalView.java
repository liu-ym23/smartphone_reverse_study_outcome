package com.bytedanceos.appstore.buss.widget.app.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemHorizontalAdapter;
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
import kotlin.Unit;
import kotlin.b;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u7.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014¢\u0006\u0004\b\u000e\u0010\u000fRZ\u0010\u001d\u001a:\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010j\u0004\u0018\u0001`\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR`\u0010\"\u001a@\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010.\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010%\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\"\u00102\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010%\u001a\u0004\b0\u0010'\"\u0004\b1\u0010)R\"\u00106\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010%\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020=8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR \u0010H\u001a\b\u0012\u0004\u0012\u00020\u000b0C8\u0014X\u0094\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G¨\u0006I"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/pager/PagerHorizontalView;", "Lcom/bytedanceos/appstore/buss/widget/app/base/BaseAppPagerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "pageSource", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Ljava/lang/String;)V", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", ServerElements.LIST, "", "setItems", "(Ljava/util/List;)V", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "entity", "Lcom/bytedanceos/appstore/buss/utilities/AppOnLongClickListener;", "j", "Lkotlin/jvm/functions/Function2;", "getAppOnLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setAppOnLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "appOnLongClickListener", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "k", "getEditAppOnClickListener", "setEditAppOnClickListener", "editAppOnClickListener", "", "l", "Z", "getShowNoBrief", "()Z", "setShowNoBrief", "(Z)V", "showNoBrief", "m", "getItemCanClick", "setItemCanClick", "itemCanClick", "n", "getEditState", "setEditState", "editState", "o", "getShowPosition", "setShowPosition", "showPosition", "p", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "setPageSource", "(Ljava/lang/String;)V", "Lcom/bytedanceos/appstore/buss/widget/recyclerview/CommonRecyclerView;", "q", "Lkotlin/Lazy;", "getRecyclerView", "()Lcom/bytedanceos/appstore/buss/widget/recyclerview/CommonRecyclerView;", "recyclerView", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "r", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "getAdapter", "()Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "adapter", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PagerHorizontalView extends BaseAppPagerView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function2 f9219j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function2 f9220k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f9221l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9222m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f9223n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f9224o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f9225p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f9226q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final BaseProviderMultiAdapter f9227r;

    public /* synthetic */ PagerHorizontalView(Context r10, AttributeSet r11, String r12, int r13, DefaultConstructorMarker r14) {
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
    public final Function2<View, CommonAppEntity, Unit> getAppOnLongClickListener() {
        return this.f9219j;
    }

    @Nullable
    public final Function2<View, CommonAppEntity, Unit> getEditAppOnClickListener() {
        return this.f9220k;
    }

    public final boolean getEditState() {
        return this.f9223n;
    }

    public final boolean getItemCanClick() {
        return this.f9222m;
    }

    @Nullable
    public final String getPageSource() {
        return this.f9225p;
    }

    @NotNull
    public final CommonRecyclerView getRecyclerView() {
        return (CommonRecyclerView) this.f9226q.getValue();
    }

    public final boolean getShowNoBrief() {
        return this.f9221l;
    }

    public final boolean getShowPosition() {
        return this.f9224o;
    }

    public final void setAppOnLongClickListener(@Nullable Function2<? super View, ? super CommonAppEntity, Unit> r10) {
        this.f9219j = r10;
    }

    public final void setEditAppOnClickListener(@Nullable Function2<? super View, ? super CommonAppEntity, Unit> r10) {
        this.f9220k = r10;
    }

    public final void setEditState(boolean r10) {
        this.f9223n = r10;
    }

    public final void setItemCanClick(boolean r10) {
        this.f9222m = r10;
    }

    @Override // com.bytedanceos.appstore.buss.widget.app.base.BaseAppPagerView, com.bytedanceos.appstore.buss.widget.base.BasePagerView
    public void setItems(@NotNull List<? extends CommonAppEntity> r10) {
        q.g(r10, ServerElements.LIST);
        if (getRecyclerView().getAdapter() != null) goto L16;
        int r11 = r10.size();
        int r12 = getSpanCount();
        if (r11 > (r12 + 1)) goto L7;
        int r13 = 1;
    L12:
        a.f24888a.b(getRecyclerView(), r13);
        GridLayoutManager r14 = new GridLayoutManager(getContext(), r13);
        r14.setOrientation(0);
        getRecyclerView().setLayoutManager(r14);
        getRecyclerView().setHasFixedSize(true);
        new w7.a(r12).b(getRecyclerView());
        getRecyclerView().setPageSource(this.f9225p);
        getRecyclerView().setPosition(getRow());
        getRecyclerView().setWidgetType("widget_pager_horizontal");
        setWidgetType("widget_pager_horizontal");
        super.setItems(r10);
        getRecyclerView().setAdapter(getAdapter());
        if (i() == true) goto L15;
        ViewGroup.LayoutParams r15 = getRecyclerView().getLayoutParams();
        q.e(r15, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        r16.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.dp_24);
        getRecyclerView().setLayoutParams(r16);
        return;
    L15:
        ViewGroup.LayoutParams r17 = getRecyclerView().getLayoutParams();
        q.e(r17, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        r18.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.dp_0);
        getRecyclerView().setLayoutParams(r18);
        return;
    L7:
        int r19 = r12 + 2;
        r13 = 2;
        if (r11 > ((r12 * 2) + 2)) goto L11;
        if (r19 <= r11) goto L12;
    L11:
        r13 = 3;
        goto L12
    L16:
        super.setItems(r10);
    }

    public final void setPageSource(@Nullable String r10) {
        this.f9225p = r10;
    }

    public final void setShowNoBrief(boolean r10) {
        this.f9221l = r10;
    }

    public final void setShowPosition(boolean r10) {
        this.f9224o = r10;
    }

    public PagerHorizontalView(Context r10, AttributeSet r11, String r12) {
        q.g(r10, "context");
        super(r10, r11);
        this.f9222m = true;
        this.f9225p = r12;
        this.f9226q = b.b(new PagerHorizontalView$recyclerView$2(this));
        View.inflate(r10, R.layout.tv_item_view_pager_app_horizontal, this);
        ItemHorizontalAdapter r13 = new ItemHorizontalAdapter(this.f9224o, this.f9219j, r12);
        this.f9220k = r13.a();
        this.f9221l = r13.d();
        this.f9222m = r13.c();
        this.f9223n = r13.b();
        this.f9227r = r13;
    }

    @Override // com.bytedanceos.appstore.buss.widget.base.BasePagerView
    @NotNull
    public BaseQuickAdapter<CommonAppEntity, BaseViewHolder> getAdapter() {
        return this.f9227r;
    }
}
