package o1;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class c extends com.stepos.statsrpk.c {

    /* renamed from: h, reason: collision with root package name */
    public int f13785h;

    /* renamed from: i, reason: collision with root package name */
    public int f13786i = -1;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f13787j;

    public c(SwipeDismissBehavior swipeDismissBehavior) {
        this.f13787j = swipeDismissBehavior;
    }

    @Override // com.stepos.statsrpk.c
    public final void E(int i4, View view) {
        this.f13786i = i4;
        this.f13785h = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.f13787j;
            swipeDismissBehavior.f10396c = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.f10396c = false;
        }
    }

    @Override // com.stepos.statsrpk.c
    public final void F(int i4) {
        this.f13787j.getClass();
    }

    @Override // com.stepos.statsrpk.c
    public final void G(View view, int i4, int i5) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.f13787j;
        float f4 = width * swipeDismissBehavior.f10399f;
        float width2 = view.getWidth() * swipeDismissBehavior.f10400g;
        float fAbs = Math.abs(i4 - this.f13785h);
        if (fAbs <= f4) {
            view.setAlpha(1.0f);
        } else if (fAbs >= width2) {
            view.setAlpha(Property.DEFAULT_FLOAT_VALUE);
        } else {
            view.setAlpha(Math.min(Math.max(Property.DEFAULT_FLOAT_VALUE, 1.0f - ((fAbs - f4) / (width2 - f4))), 1.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    @Override // com.stepos.statsrpk.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.f13786i = r11
            int r11 = r9.getWidth()
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r2 = 1
            com.google.android.material.behavior.SwipeDismissBehavior r3 = r8.f13787j
            r4 = 0
            if (r1 == 0) goto L37
            int r5 = r9.getLayoutDirection()
            if (r5 != r2) goto L18
            r5 = r2
            goto L19
        L18:
            r5 = r4
        L19:
            int r6 = r3.f10397d
            r7 = 2
            if (r6 != r7) goto L1f
            goto L50
        L1f:
            if (r6 != 0) goto L2b
            if (r5 == 0) goto L28
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L64
            goto L50
        L28:
            if (r1 <= 0) goto L64
            goto L50
        L2b:
            if (r6 != r2) goto L64
            if (r5 == 0) goto L32
            if (r1 <= 0) goto L64
            goto L50
        L32:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L64
            goto L50
        L37:
            int r1 = r9.getLeft()
            int r5 = r8.f13785h
            int r1 = r1 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            float r6 = r3.f10398e
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r1 = java.lang.Math.abs(r1)
            if (r1 < r5) goto L64
        L50:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L5f
            int r10 = r9.getLeft()
            int r0 = r8.f13785h
            if (r10 >= r0) goto L5d
            goto L5f
        L5d:
            int r0 = r0 + r11
            goto L67
        L5f:
            int r8 = r8.f13785h
            int r0 = r8 - r11
            goto L67
        L64:
            int r0 = r8.f13785h
            r2 = r4
        L67:
            Q.e r8 = r3.f10394a
            int r10 = r9.getTop()
            boolean r8 = r8.o(r0, r10)
            if (r8 == 0) goto L7b
            androidx.lifecycle.m0 r8 = new androidx.lifecycle.m0
            r8.<init>(r3, r9, r2)
            r9.postOnAnimation(r8)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.c.H(android.view.View, float, float):void");
    }

    @Override // com.stepos.statsrpk.c
    public final boolean P(int i4, View view) {
        int i5 = this.f13786i;
        return (i5 == -1 || i5 == i4) && this.f13787j.c(view);
    }

    @Override // com.stepos.statsrpk.c
    public final int o(View view, int i4) {
        int width;
        int width2;
        int width3;
        boolean z4 = view.getLayoutDirection() == 1;
        int i5 = this.f13787j.f10397d;
        if (i5 == 0) {
            if (z4) {
                width = this.f13785h - view.getWidth();
                width2 = this.f13785h;
            } else {
                width = this.f13785h;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i5 != 1) {
            width = this.f13785h - view.getWidth();
            width2 = this.f13785h + view.getWidth();
        } else if (z4) {
            width = this.f13785h;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f13785h - view.getWidth();
            width2 = this.f13785h;
        }
        return Math.min(Math.max(width, i4), width2);
    }

    @Override // com.stepos.statsrpk.c
    public final int p(View view, int i4) {
        return view.getTop();
    }

    @Override // com.stepos.statsrpk.c
    public final int x(View view) {
        return view.getWidth();
    }
}
