package d7;

import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.widget.app.item.ItemSearchTipKeywordView;
import com.chad.library.adapter.base.binder.QuickItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends QuickItemBinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f19113a;

    public g() {
    }

    public void a(BaseViewHolder r10, String r11) {
        q.g(r10, "holder");
        q.g(r11, "data");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.item.ItemSearchTipKeywordView");
        ((ItemSearchTipKeywordView) r12).setNewData(r11);
    }

    public final void b(Function2 r10) {
        this.f19113a = r10;
    }

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        a(r10, (String) r11);
    }

    @Override // com.chad.library.adapter.base.binder.QuickItemBinder
    public int getLayoutId() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.binder.QuickItemBinder, com.chad.library.adapter.base.binder.BaseItemBinder
    public BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        ItemSearchTipKeywordView r12 = new ItemSearchTipKeywordView(getContext(), null, 2, null);
        r12.setAppOnClickListener(this.f19113a);
        return new BaseViewHolder(r12);
    }
}
