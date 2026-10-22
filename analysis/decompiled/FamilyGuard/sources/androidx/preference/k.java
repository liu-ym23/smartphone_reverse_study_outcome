package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.C0456a;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

@Deprecated
/* loaded from: classes.dex */
public class k extends RecyclerViewAccessibilityDelegate {

    /* renamed from: a, reason: collision with root package name */
    final RecyclerView f11121a;

    /* renamed from: b, reason: collision with root package name */
    final C0456a f11122b;

    /* renamed from: c, reason: collision with root package name */
    final C0456a f11123c;

    class a extends C0456a {
        a() {
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
            Preference preferenceN;
            k.this.f11122b.onInitializeAccessibilityNodeInfo(view, cVar);
            int childAdapterPosition = k.this.f11121a.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = k.this.f11121a.getAdapter();
            if ((adapter instanceof h) && (preferenceN = ((h) adapter).n(childAdapterPosition)) != null) {
                preferenceN.b0(cVar);
            }
        }

        @Override // androidx.core.view.C0456a
        public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
            return k.this.f11122b.performAccessibilityAction(view, i5, bundle);
        }
    }

    public k(RecyclerView recyclerView) {
        super(recyclerView);
        this.f11122b = super.getItemDelegate();
        this.f11123c = new a();
        this.f11121a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
    public C0456a getItemDelegate() {
        return this.f11123c;
    }
}
