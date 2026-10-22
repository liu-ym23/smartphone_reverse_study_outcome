package com.bytedanceos.appstore.buss.widget.app.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemHorizontalLargeAdapter;
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
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014¢\u0006\u0004\b\f\u0010\rRZ\u0010\u001b\u001a:\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000ej\u0004\u0018\u0001`\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR`\u0010 \u001a@\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\"\u00100\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010#\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R\"\u00104\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010#\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R$\u0010<\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001b\u0010B\u001a\u00020=8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR \u0010H\u001a\b\u0012\u0004\u0012\u00020\t0C8\u0014X\u0094\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G¨\u0006I"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/pager/PagerHorizontalLargeView;", "Lcom/bytedanceos/appstore/buss/widget/app/base/BaseAppPagerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", ServerElements.LIST, "", "setItems", "(Ljava/util/List;)V", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "entity", "Lcom/bytedanceos/appstore/buss/utilities/AppOnLongClickListener;", "j", "Lkotlin/jvm/functions/Function2;", "getAppOnLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setAppOnLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "appOnLongClickListener", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "k", "getEditAppOnClickListener", "setEditAppOnClickListener", "editAppOnClickListener", "", "l", "Z", "getShowNoBrief", "()Z", "setShowNoBrief", "(Z)V", "showNoBrief", "m", "getItemCanClick", "setItemCanClick", "itemCanClick", "n", "getEditState", "setEditState", "editState", "o", "getShowPosition", "setShowPosition", "showPosition", "", "p", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "setPageSource", "(Ljava/lang/String;)V", "pageSource", "Lcom/bytedanceos/appstore/buss/widget/recyclerview/CommonRecyclerView;", "q", "Lkotlin/Lazy;", "getRecyclerView", "()Lcom/bytedanceos/appstore/buss/widget/recyclerview/CommonRecyclerView;", "recyclerView", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "r", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "getAdapter", "()Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "adapter", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PagerHorizontalLargeView extends BaseAppPagerView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function2 f9210j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function2 f9211k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f9212l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9213m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f9214n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f9215o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f9216p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f9217q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final BaseProviderMultiAdapter f9218r;

    public /* synthetic */ PagerHorizontalLargeView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
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
    public final Function2<View, CommonAppEntity, Unit> getAppOnLongClickListener() {
        return this.f9210j;
    }

    @Nullable
    public final Function2<View, CommonAppEntity, Unit> getEditAppOnClickListener() {
        return this.f9211k;
    }

    public final boolean getEditState() {
        return this.f9214n;
    }

    public final boolean getItemCanClick() {
        return this.f9213m;
    }

    @Nullable
    public final String getPageSource() {
        return this.f9216p;
    }

    @NotNull
    public final CommonRecyclerView getRecyclerView() {
        return (CommonRecyclerView) this.f9217q.getValue();
    }

    public final boolean getShowNoBrief() {
        return this.f9212l;
    }

    public final boolean getShowPosition() {
        return this.f9215o;
    }

    public final void setAppOnLongClickListener(@Nullable Function2<? super View, ? super CommonAppEntity, Unit> r10) {
        this.f9210j = r10;
    }

    public final void setEditAppOnClickListener(@Nullable Function2<? super View, ? super CommonAppEntity, Unit> r10) {
        this.f9211k = r10;
    }

    public final void setEditState(boolean r10) {
        this.f9214n = r10;
    }

    public final void setItemCanClick(boolean r10) {
        this.f9213m = r10;
    }

    @Override // com.bytedanceos.appstore.buss.widget.app.base.BaseAppPagerView, com.bytedanceos.appstore.buss.widget.base.BasePagerView
    public void setItems(@NotNull List<? extends CommonAppEntity> r10) {
        q.g(r10, ServerElements.LIST);
        if (getRecyclerView().getAdapter() != null) goto L13;
        int r11 = r10.size();
        int r12 = getSpanCount();
        if (r11 > (r12 + 1)) goto L7;
        int r13 = 1;
    L12:
        a.f24888a.b(getRecyclerView(), r13);
        GridLayoutManager r14 = new GridLayoutManager(getContext(), r13);
        r14.setOrientation(0);
        getRecyclerView().setLayoutManager(r14);
        new w7.a(r12).b(getRecyclerView());
        getRecyclerView().setHasFixedSize(true);
        super.setItems(r10);
        getRecyclerView().setAdapter(getAdapter());
        return;
    L7:
        int r15 = r12 + 2;
        r13 = 2;
        if (r11 > ((r12 * 2) + 2)) goto L11;
        if (r15 <= r11) goto L12;
    L11:
        r13 = 3;
        goto L12
    L13:
        super.setItems(r10);
    }

    public final void setPageSource(@Nullable String r10) {
        this.f9216p = r10;
    }

    public final void setShowNoBrief(boolean r10) {
        this.f9212l = r10;
    }

    public final void setShowPosition(boolean r10) {
        this.f9215o = r10;
    }

    public PagerHorizontalLargeView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f9213m = true;
        this.f9216p = "";
        this.f9217q = b.b(new PagerHorizontalLargeView$recyclerView$2(this));
        View.inflate(r10, R.layout.tv_item_view_pager_app_horizontal_large, this);
        ItemHorizontalLargeAdapter r12 = new ItemHorizontalLargeAdapter();
        this.f9210j = r12.a();
        this.f9211k = r12.b();
        this.f9212l = r12.f();
        this.f9213m = r12.d();
        this.f9214n = r12.c();
        this.f9215o = r12.g();
        this.f9216p = r12.e();
        this.f9218r = r12;
    }

    @Override // com.bytedanceos.appstore.buss.widget.base.BasePagerView
    @NotNull
    public BaseQuickAdapter<CommonAppEntity, BaseViewHolder> getAdapter() {
        return this.f9218r;
    }
}
