package stepos.support.v7.widget;

import androidx.recyclerview.widget.GridLayoutManager;
import stepos.support.v7.widget.StepOSRecyclerView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m extends GridLayoutManager.SpanSizeLookup {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GridLayoutManager f12815a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GridLayoutManager.SpanSizeLookup f12816b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f12817c;

    public m(n nVar, GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.f12817c = nVar;
        this.f12815a = gridLayoutManager;
        this.f12816b = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public final int getSpanSize(int i10) {
        n nVar = this.f12817c;
        int itemViewType = nVar.getItemViewType(i10);
        StepOSRecyclerView.b bVarC = nVar.f12820a.c(itemViewType);
        GridLayoutManager gridLayoutManager = this.f12815a;
        if (bVarC != null) {
            return gridLayoutManager.getSpanCount();
        }
        if (nVar.f12821b.c(itemViewType) != null) {
            return gridLayoutManager.getSpanCount();
        }
        GridLayoutManager.SpanSizeLookup spanSizeLookup = this.f12816b;
        if (spanSizeLookup != null) {
            return spanSizeLookup.getSpanSize(i10);
        }
        return 1;
    }
}
