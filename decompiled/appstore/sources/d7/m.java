package d7;

import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.entity.AppSubEntity;
import com.bytedanceos.appstore.buss.widget.app.item.ItemSubVideoView;
import com.chad.library.adapter.base.binder.QuickItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends QuickItemBinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ItemSubVideoView f19119a;

    public m() {
    }

    public void a(BaseViewHolder r10, AppSubEntity r11) {
        q.g(r10, "holder");
        q.g(r11, "data");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.item.ItemSubVideoView");
        ItemSubVideoView r13 = (ItemSubVideoView) r12;
        this.f19119a = r13;
        if (r13 == null) goto L6;
        r13.setNewData(r11);
        return;
    }

    public final void b() {
        ItemSubVideoView r10 = this.f19119a;
        if (r10 == null) goto L6;
        r10.b();
        return;
    }

    public final void c() {
        ItemSubVideoView r10 = this.f19119a;
        if (r10 == null) goto L6;
        r10.c();
        return;
    }

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        a(r10, (AppSubEntity) r11);
    }

    public final void d() {
        ItemSubVideoView r10 = this.f19119a;
        if (r10 == null) goto L6;
        r10.d();
        return;
    }

    @Override // com.chad.library.adapter.base.binder.QuickItemBinder
    public int getLayoutId() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.binder.QuickItemBinder, com.chad.library.adapter.base.binder.BaseItemBinder
    public BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        return new BaseViewHolder(new ItemSubVideoView(getContext(), null, 2, null));
    }
}
