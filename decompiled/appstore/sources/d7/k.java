package d7;

import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.widget.app.pager.PagerHorizontalView;
import com.chad.library.adapter.base.binder.QuickItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends QuickItemBinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19116a;

    public k(String r10) {
        this.f19116a = r10;
    }

    public void a(BaseViewHolder r10, AppEntityWrap r11) {
        q.g(r10, "holder");
        q.g(r11, "data");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.pager.PagerHorizontalView");
        PagerHorizontalView r13 = (PagerHorizontalView) r12;
        r13.setRow(r10.getAdapterPosition() + 1);
        r13.setNewData2(r11);
    }

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        a(r10, (AppEntityWrap) r11);
    }

    @Override // com.chad.library.adapter.base.binder.QuickItemBinder
    public int getLayoutId() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.binder.QuickItemBinder, com.chad.library.adapter.base.binder.BaseItemBinder
    public BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        return new BaseViewHolder(new PagerHorizontalView(getContext(), null, this.f19116a, 2, null));
    }
}
