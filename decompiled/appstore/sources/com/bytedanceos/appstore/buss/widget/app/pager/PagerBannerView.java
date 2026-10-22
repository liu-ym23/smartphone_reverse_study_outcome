package com.bytedanceos.appstore.buss.widget.app.pager;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemBannerAdapter;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.widget.app.base.BaseAppPagerView;
import com.bytedanceos.appstore.buss.widget.recyclerbanner.BannerPagerRecyclerView;
import com.bytedanceos.appstore.buss.widget.recyclerbanner.BaseRecyclerBannerAdapter;
import com.bytedanceos.common.toolbox.ServerElements;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.R;
import f9.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R2\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001bj\b\u0012\u0004\u0012\u00020\b`\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010)\u001a\b\u0012\u0004\u0012\u00020\r0$8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010+\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/pager/PagerBannerView;", "Lcom/bytedanceos/appstore/buss/widget/app/base/BaseAppPagerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "pageName", "", "row", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Ljava/lang/String;I)V", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", ServerElements.LIST, "", "setItems", "(Ljava/util/List;)V", "m", "()V", "j", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "setPageSource", "(Ljava/lang/String;)V", "pageSource", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "k", "Ljava/util/ArrayList;", "getExposePosition", "()Ljava/util/ArrayList;", "setExposePosition", "(Ljava/util/ArrayList;)V", "exposePosition", "Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BaseRecyclerBannerAdapter;", "l", "Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BaseRecyclerBannerAdapter;", "getAdapter", "()Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BaseRecyclerBannerAdapter;", "adapter", "Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BannerPagerRecyclerView;", "Lkotlin/Lazy;", "getRecyclerView", "()Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BannerPagerRecyclerView;", "recyclerView", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PagerBannerView extends BaseAppPagerView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f9205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f9206k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final BaseRecyclerBannerAdapter f9207l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f9208m;

    public static final class a implements BannerPagerRecyclerView.BannerExposeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PagerBannerView f9209a;

        public a(PagerBannerView r10) {
            this.f9209a = r10;
        }

        @Override // com.bytedanceos.appstore.buss.widget.recyclerbanner.BannerPagerRecyclerView.BannerExposeListener
        public void onBannerExpose() {
            this.f9209a.m();
        }
    }

    public /* synthetic */ PagerBannerView(Context r10, AttributeSet r11, String r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = "";
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 0;
    L11:
        this(r10, r11, r12, r13);
    }

    @Override // com.bytedanceos.appstore.buss.widget.base.BasePagerView
    /* JADX INFO: renamed from: getAdapter, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ BaseQuickAdapter<CommonAppEntity, BaseViewHolder> getAdapter2() {
        return getAdapter();
    }

    @NotNull
    public final ArrayList<Integer> getExposePosition() {
        return this.f9206k;
    }

    @Nullable
    public final String getPageSource() {
        return this.f9205j;
    }

    @NotNull
    public final BannerPagerRecyclerView getRecyclerView() {
        return (BannerPagerRecyclerView) this.f9208m.getValue();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedanceos.appstore.buss.widget.recyclerbanner.BaseRecyclerBannerAdapter] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedanceos.appstore.buss.widget.recyclerbanner.BaseRecyclerBannerAdapter] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.bytedanceos.appstore.buss.widget.recyclerbanner.BaseRecyclerBannerAdapter] */
    /* JADX WARN: Type inference failed for: r4v10, types: [com.bytedanceos.appstore.buss.widget.recyclerbanner.BaseRecyclerBannerAdapter] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedanceos.appstore.buss.widget.recyclerbanner.BaseRecyclerBannerAdapter] */
    public final void m() {
        RecyclerView.LayoutManager r10 = getRecyclerView().getLayoutManager();
        q.e(r10, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int r11 = ((LinearLayoutManager) r10).findFirstCompletelyVisibleItemPosition();
        RecyclerView.LayoutManager r12 = getRecyclerView().getLayoutManager();
        q.e(r12, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int r13 = ((LinearLayoutManager) r12).findLastCompletelyVisibleItemPosition();
        if (r11 <= r13) goto L5;
        return;
    L5:
        if (this.f9206k.contains(Integer.valueOf(r11 % getAdapter().a())) == true) goto L18;
        if (r11 < 0) goto L18;
        this.f9206k.add(Integer.valueOf(r11 % getAdapter().a()));
        CommonAppEntity r14 = getAdapter().getItem(r11 % getAdapter().a());
        q.f(r14, "getItem(...)");
        CommonAppEntity r15 = r14;
        if ("2".equals(r15.getAppType()) == false) goto L11;
        String r16 = "type_topic";
    L17:
        Bundle r17 = new Bundle();
        r17.putString("banner_title", getAdapter().getItem(r11 % getAdapter().a()).getName());
        r17.putString("banner_page_name", this.f9205j);
        r17.putString("banner_jump_type", r16);
        StringBuilder r18 = new StringBuilder();
        r18.append(getRow());
        r18.append('_');
        r18.append((r11 % getAdapter().a()) + 1);
        r17.putString("banner_position", r18.toString());
        b.b("exposure_banner", r17);
        goto L18
    L11:
        if ("1".equals(r15.getAppType()) == false) goto L14;
        r16 = "type_app";
        goto L17
    L14:
        if ("3".equals(r15.getAppType()) == false) goto L16;
        r16 = "type_webview";
        goto L17
    L16:
        r16 = null;
    L18:
        if (r11 == r13) goto L22;
        r11 = r11 + 1;
        goto L5
    }

    public final void setExposePosition(@NotNull ArrayList<Integer> r10) {
        q.g(r10, "<set-?>");
        this.f9206k = r10;
    }

    @Override // com.bytedanceos.appstore.buss.widget.app.base.BaseAppPagerView, com.bytedanceos.appstore.buss.widget.base.BasePagerView
    public void setItems(@NotNull List<? extends CommonAppEntity> r10) {
        q.g(r10, ServerElements.LIST);
        if (getRecyclerView().getAdapter() != null) goto L5;
        u7.a.c(u7.a.f24888a, getRecyclerView(), 0, 2, null);
        getRecyclerView().setHasFixedSize(true);
        getRecyclerView().setSpansPerPage(getSpanCount());
        BaseQuickAdapter<CommonAppEntity, BaseViewHolder> r11 = getAdapter();
        q.e(r11, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemBannerAdapter");
        ((ItemBannerAdapter) r11).g(getRow());
        super.setItems(r10);
        a r12 = new a(this);
        getRecyclerView().setAdapter(getAdapter());
        ((ItemBannerAdapter) getAdapter()).f(r12);
        getRecyclerView().setPageSource(this.f9205j);
        getRecyclerView().setPosition(getRow());
        getRecyclerView().setWidgetType("widget_pager_banner");
        getRecyclerView().setOnBannerExposeListener(r12);
        return;
    L5:
        super.setItems(r10);
    }

    public final void setPageSource(@Nullable String r10) {
        this.f9205j = r10;
    }

    public PagerBannerView(Context r10, AttributeSet r11, String r12, int r13) {
        q.g(r10, "context");
        super(r10, r11);
        this.f9205j = r12;
        this.f9206k = new ArrayList();
        this.f9207l = new ItemBannerAdapter(r12, r13);
        this.f9208m = kotlin.b.b(new PagerBannerView$recyclerView$2(this));
        View.inflate(r10, R.layout.tv_item_view_pager_banner, this);
    }

    @Override // com.bytedanceos.appstore.buss.widget.base.BasePagerView
    @NotNull
    public BaseQuickAdapter<CommonAppEntity, BaseViewHolder> getAdapter() {
        return this.f9207l;
    }
}
