package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.C1313a;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

@Deprecated
/* loaded from: classes.dex */
public class k extends RecyclerViewAccessibilityDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView f14422a;

    /* renamed from: b, reason: collision with root package name */
    public final C1313a f14423b;

    /* renamed from: c, reason: collision with root package name */
    public final C1313a f14424c;

    public class a extends C1313a {
        public a() {
        }

        @Override // androidx.core.view.C1313a
        public void onInitializeAccessibilityNodeInfo(View view, C0.c cVar) {
            Preference item;
            k.this.f14423b.onInitializeAccessibilityNodeInfo(view, cVar);
            int childAdapterPosition = k.this.f14422a.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = k.this.f14422a.getAdapter();
            if ((adapter instanceof h) && (item = ((h) adapter).getItem(childAdapterPosition)) != null) {
                item.onInitializeAccessibilityNodeInfo(cVar);
            }
        }

        @Override // androidx.core.view.C1313a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            return k.this.f14423b.performAccessibilityAction(view, i10, bundle);
        }
    }

    public k(RecyclerView recyclerView) {
        super(recyclerView);
        this.f14423b = super.getItemDelegate();
        this.f14424c = new a();
        this.f14422a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
    public C1313a getItemDelegate() {
        return this.f14424c;
    }
}
