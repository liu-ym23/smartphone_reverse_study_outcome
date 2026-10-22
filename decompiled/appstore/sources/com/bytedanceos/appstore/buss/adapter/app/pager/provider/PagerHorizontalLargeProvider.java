package com.bytedanceos.appstore.buss.adapter.app.pager.provider;

import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.adapter.app.base.BasePagerProvider;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.bytedanceos.appstore.buss.widget.app.pager.PagerHorizontalLargeView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010RZ\u0010\u001f\u001a:\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011j\u0004\u0018\u0001`\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR`\u0010#\u001a@\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001` 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010/\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010&\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R\"\u00103\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010&\u001a\u0004\b1\u0010(\"\u0004\b2\u0010*R\"\u00107\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010&\u001a\u0004\b5\u0010(\"\u0004\b6\u0010*R$\u0010>\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b%\u0010=R\u0014\u0010A\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010C\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010@¨\u0006D"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/pager/provider/PagerHorizontalLargeProvider;", "Lcom/bytedanceos/appstore/buss/adapter/app/base/BasePagerProvider;", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "b", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;)V", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "entity", "Lcom/bytedanceos/appstore/buss/utilities/AppOnLongClickListener;", "a", "Lkotlin/jvm/functions/Function2;", "getAppOnLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setAppOnLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "appOnLongClickListener", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "getEditAppOnClickListener", "setEditAppOnClickListener", "editAppOnClickListener", "", "c", "Z", "getShowNoBrief", "()Z", "setShowNoBrief", "(Z)V", "showNoBrief", "d", "getItemCanClick", "setItemCanClick", "itemCanClick", "e", "getEditState", "setEditState", "editState", "f", "getShowPosition", "setShowPosition", "showPosition", "", "g", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "pageSource", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PagerHorizontalLargeProvider extends BasePagerProvider<AppEntityWrap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f8377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2 f8378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f8383g;

    public PagerHorizontalLargeProvider() {
        this.f8380d = true;
        this.f8383g = "";
    }

    public void b(BaseViewHolder r10, AppEntityWrap r11) {
        q.g(r10, "holder");
        q.g(r11, "item");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.pager.PagerHorizontalLargeView");
        ((PagerHorizontalLargeView) r12).setNewData2(r11);
    }

    public final void c(String r10) {
        this.f8383g = r10;
    }

    @Override // com.bytedanceos.appstore.buss.adapter.app.base.BasePagerProvider, com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        b(r10, (AppEntityWrap) r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.PAGER_HORIZONTAL_LARGE.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        PagerHorizontalLargeView r12 = new PagerHorizontalLargeView(getContext(), null, 2, 0 == true ? 1 : 0);
        r12.setAppOnLongClickListener(this.f8377a);
        r12.setEditAppOnClickListener(this.f8378b);
        r12.setShowNoBrief(this.f8379c);
        r12.setItemCanClick(this.f8380d);
        r12.setEditState(this.f8381e);
        r12.setShowPosition(this.f8382f);
        r12.setPageSource(this.f8383g);
        r12.getRecyclerView().setRecycledViewPool(a().a());
        return new BaseViewHolder(r12);
    }
}
