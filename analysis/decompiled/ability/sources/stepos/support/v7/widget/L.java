package stepos.support.v7.widget;

import androidx.recyclerview.widget.GridLayoutManager;

/* loaded from: classes4.dex */
public final class L extends GridLayoutManager.SpanSizeLookup {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GridLayoutManager f6471a;
    public final /* synthetic */ GridLayoutManager.SpanSizeLookup b;
    public final /* synthetic */ N c;

    public L(N n, GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.c = n;
        this.f6471a = gridLayoutManager;
        this.b = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public final int getSpanSize(int i) {
        N n = this.c;
        int itemViewType = n.getItemViewType(i);
        Object obj = n.f6474a.get(itemViewType);
        GridLayoutManager gridLayoutManager = this.f6471a;
        if (obj == null && n.b.get(itemViewType) == null) {
            GridLayoutManager.SpanSizeLookup spanSizeLookup = this.b;
            if (spanSizeLookup != null) {
                return spanSizeLookup.getSpanSize(i);
            }
            return 1;
        }
        return gridLayoutManager.getSpanCount();
    }
}
