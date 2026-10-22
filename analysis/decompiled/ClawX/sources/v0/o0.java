package v0;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o0 extends e0.b {
    public final p0 d;

    /* renamed from: e, reason: collision with root package name */
    public final WeakHashMap f5903e = new WeakHashMap();

    public o0(p0 p0Var) {
        this.d = p0Var;
    }

    @Override // e0.b
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        e0.b bVar = (e0.b) this.f5903e.get(view);
        return bVar != null ? bVar.a(view, accessibilityEvent) : this.f2288a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // e0.b
    public final androidx.emoji2.text.m b(View view) {
        e0.b bVar = (e0.b) this.f5903e.get(view);
        return bVar != null ? bVar.b(view) : super.b(view);
    }

    @Override // e0.b
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        e0.b bVar = (e0.b) this.f5903e.get(view);
        if (bVar != null) {
            bVar.c(view, accessibilityEvent);
        } else {
            super.c(view, accessibilityEvent);
        }
    }

    @Override // e0.b
    public final void d(View view, f0.g gVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f2542a;
        p0 p0Var = this.d;
        RecyclerView recyclerView = p0Var.d;
        RecyclerView recyclerView2 = p0Var.d;
        boolean zU = recyclerView.u();
        View.AccessibilityDelegate accessibilityDelegate = this.f2288a;
        if (zU || recyclerView2.getLayoutManager() == null) {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            return;
        }
        recyclerView2.getLayoutManager().N(view, gVar);
        e0.b bVar = (e0.b) this.f5903e.get(view);
        if (bVar != null) {
            bVar.d(view, gVar);
        } else {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        }
    }

    @Override // e0.b
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        e0.b bVar = (e0.b) this.f5903e.get(view);
        if (bVar != null) {
            bVar.e(view, accessibilityEvent);
        } else {
            super.e(view, accessibilityEvent);
        }
    }

    @Override // e0.b
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        e0.b bVar = (e0.b) this.f5903e.get(viewGroup);
        return bVar != null ? bVar.f(viewGroup, view, accessibilityEvent) : this.f2288a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // e0.b
    public final boolean g(View view, int i8, Bundle bundle) {
        p0 p0Var = this.d;
        RecyclerView recyclerView = p0Var.d;
        RecyclerView recyclerView2 = p0Var.d;
        if (recyclerView.u() || recyclerView2.getLayoutManager() == null) {
            return super.g(view, i8, bundle);
        }
        e0.b bVar = (e0.b) this.f5903e.get(view);
        if (bVar != null) {
            if (bVar.g(view, i8, bundle)) {
                return true;
            }
        } else if (super.g(view, i8, bundle)) {
            return true;
        }
        h0 h0Var = recyclerView2.getLayoutManager().f5793b.f758a;
        return false;
    }

    @Override // e0.b
    public final void h(View view, int i8) {
        e0.b bVar = (e0.b) this.f5903e.get(view);
        if (bVar != null) {
            bVar.h(view, i8);
        } else {
            super.h(view, i8);
        }
    }

    @Override // e0.b
    public final void i(View view, AccessibilityEvent accessibilityEvent) {
        e0.b bVar = (e0.b) this.f5903e.get(view);
        if (bVar != null) {
            bVar.i(view, accessibilityEvent);
        } else {
            super.i(view, accessibilityEvent);
        }
    }
}
