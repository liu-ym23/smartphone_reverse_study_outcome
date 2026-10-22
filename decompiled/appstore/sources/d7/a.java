package d7;

import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.entity.GiftAllEntity;
import com.bytedanceos.appstore.buss.widget.app.item.ItemGiftAllView;
import com.chad.library.adapter.base.binder.QuickItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends QuickItemBinder {
    public a() {
    }

    public void a(BaseViewHolder r10, GiftAllEntity r11) {
        q.g(r10, "holder");
        q.g(r11, "data");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.item.ItemGiftAllView");
        ((ItemGiftAllView) r12).setNewData(r11);
    }

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        a(r10, (GiftAllEntity) r11);
    }

    @Override // com.chad.library.adapter.base.binder.QuickItemBinder
    public int getLayoutId() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.binder.QuickItemBinder, com.chad.library.adapter.base.binder.BaseItemBinder
    public BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        return new BaseViewHolder(new ItemGiftAllView(getContext(), null, 2, null));
    }
}
