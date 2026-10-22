package d7;

import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.entity.AppSubWrap;
import com.bytedanceos.appstore.buss.widget.app.pager.PagerSubView;
import com.chad.library.adapter.base.binder.QuickItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends QuickItemBinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f19117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19118b;

    public l() {
    }

    public void a(BaseViewHolder r10, AppSubWrap r11) {
        q.g(r10, "holder");
        q.g(r11, "data");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.pager.PagerSubView");
        ((PagerSubView) r12).setNewData2(r11);
    }

    public final void b(String r10) {
        this.f19118b = r10;
    }

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        a(r10, (AppSubWrap) r11);
    }

    @Override // com.chad.library.adapter.base.binder.QuickItemBinder
    public int getLayoutId() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.binder.QuickItemBinder, com.chad.library.adapter.base.binder.BaseItemBinder
    public BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        PagerSubView r12 = new PagerSubView(getContext(), null, 2, null);
        r12.setAppSubOnClickListener(this.f19117a);
        r12.setPageSource(this.f19118b);
        return new BaseViewHolder(r12);
    }
}
