package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Deprecated
/* loaded from: classes.dex */
public final class g extends RecyclerViewAccessibilityDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView f2418a;

    /* renamed from: b, reason: collision with root package name */
    public final v0.a f2419b;

    /* renamed from: c, reason: collision with root package name */
    public final a f2420c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends v0.a {
        public a() {
        }

        @Override // v0.a
        public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
            g gVar = g.this;
            gVar.f2419b.onInitializeAccessibilityNodeInfo(view, bVar);
            int childAdapterPosition = gVar.f2418a.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = gVar.f2418a.getAdapter();
            if (adapter instanceof b) {
                ((b) adapter).e(childAdapterPosition);
            }
        }

        @Override // v0.a
        public final boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            return g.this.f2419b.performAccessibilityAction(view, i10, bundle);
        }
    }

    public g(RecyclerView recyclerView) {
        super(recyclerView);
        this.f2419b = super.getItemDelegate();
        this.f2420c = new a();
        this.f2418a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
    public final v0.a getItemDelegate() {
        return this.f2420c;
    }
}
