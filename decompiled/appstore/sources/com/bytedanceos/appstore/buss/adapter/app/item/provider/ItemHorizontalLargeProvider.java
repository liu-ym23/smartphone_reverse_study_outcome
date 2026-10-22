package com.bytedanceos.appstore.buss.adapter.app.item.provider;

import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.bytedanceos.appstore.buss.widget.app.item.ItemHorizontalLargeView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import e7.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010RZ\u0010\u001e\u001a:\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011j\u0004\u0018\u0001`\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR`\u0010\"\u001a@\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010-\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\"\u00100\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\"\u00103\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010%\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R$\u0010:\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010=\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0014\u0010?\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010<¨\u0006@"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/item/provider/ItemHorizontalLargeProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "b", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;)V", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "entity", "Lcom/bytedanceos/appstore/buss/utilities/AppOnLongClickListener;", "a", "Lkotlin/jvm/functions/Function2;", "getAppOnLongClickListener", "()Lkotlin/jvm/functions/Function2;", "d", "(Lkotlin/jvm/functions/Function2;)V", "appOnLongClickListener", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "getEditAppOnClickListener", "e", "editAppOnClickListener", "", "c", "Z", "getShowNoBrief", "()Z", "i", "(Z)V", "showNoBrief", "getItemCanClick", "g", "itemCanClick", "getEditState", "f", "editState", "getShowPosition", "j", "showPosition", "", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "h", "(Ljava/lang/String;)V", "pageSource", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemHorizontalLargeProvider extends BaseItemProvider<CommonAppEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f8356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2 f8357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f8362g;

    public ItemHorizontalLargeProvider() {
        this.f8359d = true;
        this.f8362g = "";
    }

    public static /* synthetic */ void a(View r10) {
        c(r10);
    }

    public static final void c(View r10) {
    }

    public void b(BaseViewHolder r10, CommonAppEntity r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.item.ItemHorizontalLargeView");
        ItemHorizontalLargeView r13 = (ItemHorizontalLargeView) r12;
        if (this.f8361f == false) goto L5;
        int r14 = r10.getLayoutPosition();
    L6:
        r13.d(r11, r14);
        return;
    L5:
        r14 = -1;
        goto L6
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, CommonAppEntity r11) {
        b(r10, r11);
    }

    public final void d(Function2 r10) {
        this.f8356a = r10;
    }

    public final void e(Function2 r10) {
        this.f8357b = r10;
    }

    public final void f(boolean r10) {
        this.f8360e = r10;
    }

    public final void g(boolean r10) {
        this.f8359d = r10;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.HORIZONTAL_LARGE.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return 0;
    }

    public final void h(String r10) {
        this.f8362g = r10;
    }

    public final void i(boolean r10) {
        this.f8358c = r10;
    }

    public final void j(boolean r10) {
        this.f8361f = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        ItemHorizontalLargeView r12 = new ItemHorizontalLargeView(getContext(), null, 2, 0 == true ? 1 : 0);
        r12.setAppOnLongClickListener(this.f8356a);
        r12.setEditAppOnClickListener(this.f8357b);
        r12.setShowNoBrief(this.f8358c);
        r12.setItemCanClick(this.f8359d);
        r12.setEditState(this.f8360e);
        r12.setPageSource(this.f8362g);
        r12.setOnClickListener(new a());
        return new BaseViewHolder(r12);
    }
}
