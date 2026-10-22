package v0;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class p0 extends e0.b {
    public final RecyclerView d;

    /* renamed from: e, reason: collision with root package name */
    public final o0 f5907e;

    public p0(RecyclerView recyclerView) {
        this.d = recyclerView;
        o0 o0Var = this.f5907e;
        if (o0Var != null) {
            this.f5907e = o0Var;
        } else {
            this.f5907e = new o0(this);
        }
    }

    @Override // e0.b
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.d.u()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().M(accessibilityEvent);
        }
    }

    @Override // e0.b
    public final void d(View view, f0.g gVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f2542a;
        this.f2288a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        RecyclerView recyclerView = this.d;
        if (recyclerView.u() || recyclerView.getLayoutManager() == null) {
            return;
        }
        b0 layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f5793b;
        h0 h0Var = recyclerView2.f758a;
        k0 k0Var = recyclerView2.f759a0;
        if (recyclerView2.canScrollVertically(-1) || layoutManager.f5793b.canScrollHorizontally(-1)) {
            gVar.a(8192);
            accessibilityNodeInfo.setScrollable(true);
        }
        if (layoutManager.f5793b.canScrollVertically(1) || layoutManager.f5793b.canScrollHorizontally(1)) {
            gVar.a(4096);
            accessibilityNodeInfo.setScrollable(true);
        }
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(layoutManager.C(h0Var, k0Var), layoutManager.s(h0Var, k0Var), false, 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0056 A[PHI: r3
      0x0056: PHI (r3v11 int) = (r3v7 int), (r3v15 int) binds: [B:27:0x0072, B:19:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // e0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.view.View r3, int r4, android.os.Bundle r5) {
        /*
            r2 = this;
            boolean r3 = super.g(r3, r4, r5)
            r5 = 1
            if (r3 == 0) goto L8
            return r5
        L8:
            androidx.recyclerview.widget.RecyclerView r2 = r2.d
            boolean r3 = r2.u()
            r0 = 0
            if (r3 != 0) goto L8b
            v0.b0 r3 = r2.getLayoutManager()
            if (r3 == 0) goto L8b
            v0.b0 r2 = r2.getLayoutManager()
            androidx.recyclerview.widget.RecyclerView r3 = r2.f5793b
            v0.h0 r1 = r3.f758a
            r1 = 4096(0x1000, float:5.74E-42)
            if (r4 == r1) goto L58
            r1 = 8192(0x2000, float:1.148E-41)
            if (r4 == r1) goto L2a
            r3 = r0
            r4 = r3
            goto L80
        L2a:
            r4 = -1
            boolean r3 = r3.canScrollVertically(r4)
            if (r3 == 0) goto L3f
            int r3 = r2.f5800j
            int r1 = r2.z()
            int r3 = r3 - r1
            int r1 = r2.w()
            int r3 = r3 - r1
            int r3 = -r3
            goto L40
        L3f:
            r3 = r0
        L40:
            androidx.recyclerview.widget.RecyclerView r1 = r2.f5793b
            boolean r4 = r1.canScrollHorizontally(r4)
            if (r4 == 0) goto L56
            int r4 = r2.f5799i
            int r1 = r2.x()
            int r4 = r4 - r1
            int r1 = r2.y()
            int r4 = r4 - r1
            int r4 = -r4
            goto L80
        L56:
            r4 = r0
            goto L80
        L58:
            boolean r3 = r3.canScrollVertically(r5)
            if (r3 == 0) goto L6b
            int r3 = r2.f5800j
            int r4 = r2.z()
            int r3 = r3 - r4
            int r4 = r2.w()
            int r3 = r3 - r4
            goto L6c
        L6b:
            r3 = r0
        L6c:
            androidx.recyclerview.widget.RecyclerView r4 = r2.f5793b
            boolean r4 = r4.canScrollHorizontally(r5)
            if (r4 == 0) goto L56
            int r4 = r2.f5799i
            int r1 = r2.x()
            int r4 = r4 - r1
            int r1 = r2.y()
            int r4 = r4 - r1
        L80:
            if (r3 != 0) goto L85
            if (r4 != 0) goto L85
            goto L8b
        L85:
            androidx.recyclerview.widget.RecyclerView r2 = r2.f5793b
            r2.E(r4, r3, r5)
            return r5
        L8b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.p0.g(android.view.View, int, android.os.Bundle):boolean");
    }
}
