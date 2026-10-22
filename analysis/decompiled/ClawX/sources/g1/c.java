package g1;

import android.view.View;
import android.view.ViewParent;
import b8.h;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends h {

    /* renamed from: c, reason: collision with root package name */
    public int f2910c;
    public int d = -1;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f2911e;

    public c(SwipeDismissBehavior swipeDismissBehavior) {
        this.f2911e = swipeDismissBehavior;
    }

    @Override // b8.h
    public final void B(View view, int i8) {
        this.d = i8;
        this.f2910c = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.f2911e;
            swipeDismissBehavior.f1228c = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.f1228c = false;
        }
    }

    @Override // b8.h
    public final void D(View view, int i8, int i9) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.f2911e;
        float f3 = width * swipeDismissBehavior.f1229e;
        float width2 = view.getWidth() * swipeDismissBehavior.f1230f;
        float fAbs = Math.abs(i8 - this.f2910c);
        if (fAbs <= f3) {
            view.setAlpha(1.0f);
        } else if (fAbs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((fAbs - f3) / (width2 - f3))), 1.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    @Override // b8.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.d = r11
            int r11 = r9.getWidth()
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r2 = 0
            com.google.android.material.behavior.SwipeDismissBehavior r3 = r8.f2911e
            r4 = 1
            if (r1 == 0) goto L37
            int r5 = r9.getLayoutDirection()
            if (r5 != r4) goto L18
            r5 = r4
            goto L19
        L18:
            r5 = r2
        L19:
            int r6 = r3.d
            r7 = 2
            if (r6 != r7) goto L1f
            goto L50
        L1f:
            if (r6 != 0) goto L2b
            if (r5 == 0) goto L28
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L65
            goto L50
        L28:
            if (r1 <= 0) goto L65
            goto L50
        L2b:
            if (r6 != r4) goto L65
            if (r5 == 0) goto L32
            if (r1 <= 0) goto L65
            goto L50
        L32:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L65
            goto L50
        L37:
            int r1 = r9.getLeft()
            int r5 = r8.f2910c
            int r1 = r1 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            r6 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r1 = java.lang.Math.abs(r1)
            if (r1 < r5) goto L65
        L50:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L5f
            int r10 = r9.getLeft()
            int r0 = r8.f2910c
            if (r10 >= r0) goto L5d
            goto L5f
        L5d:
            int r0 = r0 + r11
            goto L63
        L5f:
            int r8 = r8.f2910c
            int r0 = r8 - r11
        L63:
            r2 = r4
            goto L67
        L65:
            int r0 = r8.f2910c
        L67:
            i0.e r8 = r3.f1226a
            int r10 = r9.getTop()
            boolean r8 = r8.o(r0, r10)
            if (r8 == 0) goto L7b
            b0.a r8 = new b0.a
            r8.<init>(r3, r9, r2)
            r9.postOnAnimation(r8)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.c.E(android.view.View, float, float):void");
    }

    @Override // b8.h
    public final boolean Q(View view, int i8) {
        int i9 = this.d;
        return (i9 == -1 || i9 == i8) && this.f2911e.r(view);
    }

    @Override // b8.h
    public final int g(View view, int i8) {
        int width;
        int width2;
        int width3;
        boolean z = view.getLayoutDirection() == 1;
        int i9 = this.f2911e.d;
        if (i9 == 0) {
            if (z) {
                width = this.f2910c - view.getWidth();
                width2 = this.f2910c;
            } else {
                width = this.f2910c;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i9 != 1) {
            width = this.f2910c - view.getWidth();
            width2 = this.f2910c + view.getWidth();
        } else if (z) {
            width = this.f2910c;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f2910c - view.getWidth();
            width2 = this.f2910c;
        }
        return Math.min(Math.max(width, i8), width2);
    }

    @Override // b8.h
    public final int h(View view, int i8) {
        return view.getTop();
    }

    @Override // b8.h
    public final int r(View view) {
        return view.getWidth();
    }

    @Override // b8.h
    public final void C(int i8) {
    }
}
