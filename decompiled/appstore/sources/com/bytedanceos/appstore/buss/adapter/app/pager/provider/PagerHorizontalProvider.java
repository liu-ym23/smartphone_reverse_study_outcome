package com.bytedanceos.appstore.buss.adapter.app.pager.provider;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.adapter.app.base.BasePagerProvider;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.bytedanceos.appstore.buss.widget.app.pager.PagerHorizontalView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012RZ\u0010!\u001a:\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013j\u0004\u0018\u0001`\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R`\u0010%\u001a@\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\"\u0010,\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010/\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010'\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\"\u00102\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010'\u001a\u0004\b1\u0010)\"\u0004\b0\u0010+R\"\u00105\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010'\u001a\u0004\b3\u0010)\"\u0004\b4\u0010+R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010\u0006R\u0014\u0010<\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010;¨\u0006?"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/pager/provider/PagerHorizontalProvider;", "Lcom/bytedanceos/appstore/buss/adapter/app/base/BasePagerProvider;", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "", "pageSource", "<init>", "(Ljava/lang/String;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "b", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;)V", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "entity", "Lcom/bytedanceos/appstore/buss/utilities/AppOnLongClickListener;", "a", "Lkotlin/jvm/functions/Function2;", "getAppOnLongClickListener", "()Lkotlin/jvm/functions/Function2;", "c", "(Lkotlin/jvm/functions/Function2;)V", "appOnLongClickListener", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "getEditAppOnClickListener", "d", "editAppOnClickListener", "", "Z", "getShowNoBrief", "()Z", "g", "(Z)V", "showNoBrief", "getItemCanClick", "f", "itemCanClick", "e", "getEditState", "editState", "getShowPosition", "h", "showPosition", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "setPageSource", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PagerHorizontalProvider extends BasePagerProvider<AppEntityWrap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f8384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2 f8385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f8390g;

    /* JADX WARN: Multi-variable type inference failed */
    public PagerHorizontalProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public void b(BaseViewHolder r10, AppEntityWrap r11) {
        q.g(r10, "holder");
        q.g(r11, "item");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.pager.PagerHorizontalView");
        PagerHorizontalView r13 = (PagerHorizontalView) r12;
        r13.setRow(r10.getAdapterPosition() + 1);
        r13.setNewData2(r11);
    }

    public final void c(Function2 r10) {
        this.f8384a = r10;
    }

    @Override // com.bytedanceos.appstore.buss.adapter.app.base.BasePagerProvider, com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        b(r10, (AppEntityWrap) r11);
    }

    public final void d(Function2 r10) {
        this.f8385b = r10;
    }

    public final void e(boolean r10) {
        this.f8388e = r10;
    }

    public final void f(boolean r10) {
        this.f8387d = r10;
    }

    public final void g(boolean r10) {
        this.f8386c = r10;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.PAGER_HORIZONTAL.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return 0;
    }

    public final void h(boolean r10) {
        this.f8389f = r10;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        AttributeSet r12 = null;
        PagerHorizontalView r13 = new PagerHorizontalView(getContext(), r12, this.f8390g, 2, null);
        r13.setAppOnLongClickListener(this.f8384a);
        r13.setEditAppOnClickListener(this.f8385b);
        r13.setShowNoBrief(this.f8386c);
        r13.setItemCanClick(this.f8387d);
        r13.setEditState(this.f8388e);
        r13.setShowPosition(this.f8389f);
        r13.getRecyclerView().setRecycledViewPool(a().a());
        return new BaseViewHolder(r13);
    }

    public PagerHorizontalProvider(String r10) {
        this.f8387d = true;
        this.f8390g = r10;
    }

    public /* synthetic */ PagerHorizontalProvider(String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = "";
    L5:
        this(r10);
    }
}
