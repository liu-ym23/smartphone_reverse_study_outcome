package stepos.support.v7.widget;

import androidx.recyclerview.widget.GridLayoutManager;

/* loaded from: classes2.dex */
public final class G extends GridLayoutManager.SpanSizeLookup {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GridLayoutManager f14821a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GridLayoutManager.SpanSizeLookup f14822b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ I f14823c;

    public G(I i4, GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.f14823c = i4;
        this.f14821a = gridLayoutManager;
        this.f14822b = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public final int getSpanSize(int i4) {
        I i5 = this.f14823c;
        int itemViewType = i5.getItemViewType(i4);
        Object objC = i5.f14827a.c(itemViewType);
        GridLayoutManager gridLayoutManager = this.f14821a;
        if (objC == null && i5.f14828b.c(itemViewType) == null) {
            GridLayoutManager.SpanSizeLookup spanSizeLookup = this.f14822b;
            if (spanSizeLookup != null) {
                return spanSizeLookup.getSpanSize(i4);
            }
            return 1;
        }
        return gridLayoutManager.getSpanCount();
    }
}
