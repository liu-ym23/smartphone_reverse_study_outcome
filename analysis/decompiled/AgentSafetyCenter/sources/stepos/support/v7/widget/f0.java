package stepos.support.v7.widget;

import androidx.recyclerview.widget.GridLayoutManager;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class f0 extends GridLayoutManager.SpanSizeLookup {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GridLayoutManager f12749a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GridLayoutManager.SpanSizeLookup f12750b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h0 f12751c;

    public f0(h0 h0Var, GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.f12751c = h0Var;
        this.f12749a = gridLayoutManager;
        this.f12750b = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public final int getSpanSize(int i) {
        h0 h0Var = this.f12751c;
        int itemViewType = h0Var.getItemViewType(i);
        Object objB = h0Var.f12759a.b(itemViewType);
        GridLayoutManager gridLayoutManager = this.f12749a;
        if (objB != null) {
            return gridLayoutManager.getSpanCount();
        }
        if (h0Var.f12760b.b(itemViewType) != null) {
            return gridLayoutManager.getSpanCount();
        }
        GridLayoutManager.SpanSizeLookup spanSizeLookup = this.f12750b;
        if (spanSizeLookup != null) {
            return spanSizeLookup.getSpanSize(i);
        }
        return 1;
    }
}
