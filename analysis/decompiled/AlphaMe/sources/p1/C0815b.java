package p1;

import android.os.SystemClock;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import f1.AbstractC0557a;
import java.lang.ref.WeakReference;

/* renamed from: p1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0815b extends com.stepos.statsrpk.c {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f13925h;

    public C0815b(BottomSheetBehavior bottomSheetBehavior) {
        this.f13925h = bottomSheetBehavior;
    }

    @Override // com.stepos.statsrpk.c
    public final void F(int i4) {
        if (i4 == 1) {
            BottomSheetBehavior bottomSheetBehavior = this.f13925h;
            if (bottomSheetBehavior.f10416K) {
                bottomSheetBehavior.n(1);
            }
        }
    }

    @Override // com.stepos.statsrpk.c
    public final void G(View view, int i4, int i5) {
        this.f13925h.f(i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000d  */
    @Override // com.stepos.statsrpk.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H(android.view.View r5, float r6, float r7) {
        /*
            r4 = this;
            r0 = 0
            int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            r2 = 6
            r3 = 3
            com.google.android.material.bottomsheet.BottomSheetBehavior r4 = r4.f13925h
            if (r1 >= 0) goto L1d
            boolean r6 = r4.f10433b
            if (r6 == 0) goto L10
        Ld:
            r2 = r3
            goto Ld4
        L10:
            int r6 = r5.getTop()
            android.os.SystemClock.uptimeMillis()
            int r7 = r4.f10410E
            if (r6 <= r7) goto Ld
            goto Ld4
        L1d:
            boolean r1 = r4.f10414I
            if (r1 == 0) goto L6c
            boolean r1 = r4.o(r5, r7)
            if (r1 == 0) goto L6c
            float r6 = java.lang.Math.abs(r6)
            float r0 = java.lang.Math.abs(r7)
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 >= 0) goto L3a
            int r6 = r4.f10437d
            float r6 = (float) r6
            int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r6 > 0) goto L49
        L3a:
            int r6 = r5.getTop()
            int r7 = r4.f10426V
            int r0 = r4.i()
            int r0 = r0 + r7
            int r0 = r0 / 2
            if (r6 <= r0) goto L4c
        L49:
            r2 = 5
            goto Ld4
        L4c:
            boolean r6 = r4.f10433b
            if (r6 == 0) goto L51
            goto Ld
        L51:
            int r6 = r5.getTop()
            int r7 = r4.i()
            int r6 = r6 - r7
            int r6 = java.lang.Math.abs(r6)
            int r7 = r5.getTop()
            int r0 = r4.f10410E
            int r7 = r7 - r0
            int r7 = java.lang.Math.abs(r7)
            if (r6 >= r7) goto Ld4
            goto Ld
        L6c:
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            r1 = 4
            if (r0 == 0) goto L9a
            float r6 = java.lang.Math.abs(r6)
            float r7 = java.lang.Math.abs(r7)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L7e
            goto L9a
        L7e:
            boolean r6 = r4.f10433b
            if (r6 == 0) goto L84
        L82:
            r2 = r1
            goto Ld4
        L84:
            int r6 = r5.getTop()
            int r7 = r4.f10410E
            int r7 = r6 - r7
            int r7 = java.lang.Math.abs(r7)
            int r0 = r4.f10412G
            int r6 = r6 - r0
            int r6 = java.lang.Math.abs(r6)
            if (r7 >= r6) goto L82
            goto Ld4
        L9a:
            int r6 = r5.getTop()
            boolean r7 = r4.f10433b
            if (r7 == 0) goto Lb5
            int r7 = r4.f10409D
            int r7 = r6 - r7
            int r7 = java.lang.Math.abs(r7)
            int r0 = r4.f10412G
            int r6 = r6 - r0
            int r6 = java.lang.Math.abs(r6)
            if (r7 >= r6) goto L82
            goto Ld
        Lb5:
            int r7 = r4.f10410E
            if (r6 >= r7) goto Lc5
            int r7 = r4.f10412G
            int r7 = r6 - r7
            int r7 = java.lang.Math.abs(r7)
            if (r6 >= r7) goto Ld4
            goto Ld
        Lc5:
            int r7 = r6 - r7
            int r7 = java.lang.Math.abs(r7)
            int r0 = r4.f10412G
            int r6 = r6 - r0
            int r6 = java.lang.Math.abs(r6)
            if (r7 >= r6) goto L82
        Ld4:
            r4.getClass()
            r6 = 1
            r4.p(r5, r2, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.C0815b.H(android.view.View, float, float):void");
    }

    @Override // com.stepos.statsrpk.c
    public final boolean P(int i4, View view) {
        BottomSheetBehavior bottomSheetBehavior = this.f13925h;
        int i5 = bottomSheetBehavior.f10419N;
        if (i5 == 1 || bottomSheetBehavior.f10436c0) {
            return false;
        }
        if (i5 == 3 && bottomSheetBehavior.f10432a0 == i4) {
            WeakReference weakReference = bottomSheetBehavior.f10428X;
            View view2 = weakReference != null ? (View) weakReference.get() : null;
            if (view2 != null && view2.canScrollVertically(-1)) {
                return false;
            }
        }
        SystemClock.uptimeMillis();
        WeakReference weakReference2 = bottomSheetBehavior.f10427W;
        return weakReference2 != null && weakReference2.get() == view;
    }

    @Override // com.stepos.statsrpk.c
    public final int o(View view, int i4) {
        return view.getLeft();
    }

    @Override // com.stepos.statsrpk.c
    public final int p(View view, int i4) {
        return AbstractC0557a.o(i4, this.f13925h.i(), y());
    }

    @Override // com.stepos.statsrpk.c
    public final int y() {
        BottomSheetBehavior bottomSheetBehavior = this.f13925h;
        return bottomSheetBehavior.f10414I ? bottomSheetBehavior.f10426V : bottomSheetBehavior.f10412G;
    }
}
