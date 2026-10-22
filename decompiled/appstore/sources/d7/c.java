package d7;

import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.widget.app.item.ItemHorizontalView;
import com.chad.library.adapter.base.binder.QuickItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends QuickItemBinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f19102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2 f19103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2 f19104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2 f19105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f19106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f19107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f19108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f19109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f19110i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f19111j;

    public c(String r10) {
        this.f19108g = true;
        this.f19111j = r10;
    }

    public void a(BaseViewHolder r10, CommonAppEntity r11) {
        q.g(r10, "holder");
        q.g(r11, "data");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.item.ItemHorizontalView");
        ItemHorizontalView r13 = (ItemHorizontalView) r12;
        r13.setEditState(this.f19109h);
        r13.setSetLeftMargin(this.f19110i);
        ItemHorizontalView.f(r13, r11, 0, 2, null);
    }

    public final boolean b() {
        return this.f19109h;
    }

    public final void c(Function2 r10) {
        this.f19102a = r10;
    }

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        a(r10, (CommonAppEntity) r11);
    }

    public final void d(Function2 r10) {
        this.f19103b = r10;
    }

    public final void e(Function2 r10) {
        this.f19105d = r10;
    }

    public final void f(Function2 r10) {
        this.f19104c = r10;
    }

    public final void g(boolean r10) {
        this.f19110i = r10;
    }

    @Override // com.chad.library.adapter.base.binder.QuickItemBinder
    public int getLayoutId() {
        return 0;
    }

    public final void h(boolean r10) {
        this.f19107f = r10;
    }

    @Override // com.chad.library.adapter.base.binder.QuickItemBinder, com.chad.library.adapter.base.binder.BaseItemBinder
    public BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        ItemHorizontalView r12 = new ItemHorizontalView(getContext(), null, 2, null);
        r12.setAppClickListener(this.f19102a);
        r12.setAppOnLongClickListener(this.f19103b);
        r12.setEditAppOnClickListener(this.f19104c);
        r12.setDownloadBtnClickListener(this.f19105d);
        r12.setShowNoBrief(this.f19106e);
        r12.setShowAppSource(this.f19107f);
        r12.setItemCanClick(this.f19108g);
        r12.setSetLeftMargin(this.f19110i);
        r12.setPageSource(this.f19111j);
        return new BaseViewHolder(r12);
    }

    public /* synthetic */ c(String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = "";
    L5:
        this(r10);
    }
}
