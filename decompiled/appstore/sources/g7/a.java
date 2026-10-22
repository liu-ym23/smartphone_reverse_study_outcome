package g7;

import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.widget.AppItemFirstRecommendView;
import com.chad.library.adapter.base.binder.QuickItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends QuickItemBinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f19993a;

    public a() {
    }

    public void a(BaseViewHolder r10, CommonAppEntity r11) {
        q.g(r10, "holder");
        q.g(r11, "data");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.AppItemFirstRecommendView");
        ((AppItemFirstRecommendView) r12).setNewData(r11);
    }

    public final void b(Function2 r10) {
        this.f19993a = r10;
    }

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        a(r10, (CommonAppEntity) r11);
    }

    @Override // com.chad.library.adapter.base.binder.QuickItemBinder
    public int getLayoutId() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.binder.QuickItemBinder, com.chad.library.adapter.base.binder.BaseItemBinder
    public BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        AppItemFirstRecommendView r12 = new AppItemFirstRecommendView(getContext());
        r12.setAppOnClickListener(this.f19993a);
        return new BaseViewHolder(r12);
    }
}
