package r6;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;
import t.i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends i1 {

    /* renamed from: a, reason: collision with root package name */
    public int f10467a;

    /* renamed from: b, reason: collision with root package name */
    public int f10468b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ SwipeDismissBehavior f10469c;

    @Override // t.i1
    public final int b(int i, View view) {
        int width;
        int width2;
        boolean z10 = view.getLayoutDirection() == 1;
        int i3 = this.f10469c.f2406d;
        if (i3 == 0) {
            width = this.f10467a;
            if (z10) {
                width -= view.getWidth();
                width2 = this.f10467a;
            } else {
                width2 = view.getWidth() + width;
            }
        } else {
            int i10 = this.f10467a;
            if (i3 != 1) {
                width = i10 - view.getWidth();
                width2 = this.f10467a + view.getWidth();
            } else if (z10) {
                width2 = view.getWidth() + i10;
                width = i10;
            } else {
                width = i10 - view.getWidth();
                width2 = this.f10467a;
            }
        }
        return Math.min(Math.max(width, i), width2);
    }

    @Override // t.i1
    public final int c(int i, View view) {
        return view.getTop();
    }

    @Override // t.i1
    public final int f(View view) {
        return view.getWidth();
    }

    @Override // t.i1
    public final void j(int i, View view) {
        SwipeDismissBehavior swipeDismissBehavior = this.f10469c;
        this.f10468b = i;
        this.f10467a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            swipeDismissBehavior.f2405c = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.f2405c = false;
        }
    }

    @Override // t.i1
    public final void l(View view, int i, int i3) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.f10469c;
        float f5 = width * swipeDismissBehavior.f2407e;
        float width2 = view.getWidth() * swipeDismissBehavior.f2408f;
        float fAbs = Math.abs(i - this.f10467a);
        if (fAbs <= f5) {
            view.setAlpha(1.0f);
        } else if (fAbs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((fAbs - f5) / (width2 - f5))), 1.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    @Override // t.i1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(android.view.View r8, float r9, float r10) {
        /*
            r7 = this;
            r10 = -1
            r7.f10468b = r10
            int r10 = r8.getWidth()
            com.google.android.material.behavior.SwipeDismissBehavior r0 = r7.f10469c
            r1 = 0
            int r2 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r2 == 0) goto L36
            int r3 = r8.getLayoutDirection()
            r4 = 1
            if (r3 != r4) goto L17
            r3 = r4
            goto L18
        L17:
            r3 = 0
        L18:
            int r5 = r0.f2406d
            r6 = 2
            if (r5 != r6) goto L1e
            goto L4f
        L1e:
            if (r5 != 0) goto L2a
            if (r3 == 0) goto L27
            int r2 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r2 >= 0) goto L63
            goto L4f
        L27:
            if (r2 <= 0) goto L63
            goto L4f
        L2a:
            if (r5 != r4) goto L63
            if (r3 == 0) goto L31
            if (r2 <= 0) goto L63
            goto L4f
        L31:
            int r2 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r2 >= 0) goto L63
            goto L4f
        L36:
            int r2 = r8.getLeft()
            int r3 = r7.f10467a
            int r2 = r2 - r3
            int r3 = r8.getWidth()
            float r3 = (float) r3
            r4 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 * r4
            int r3 = java.lang.Math.round(r3)
            int r2 = java.lang.Math.abs(r2)
            if (r2 < r3) goto L63
        L4f:
            int r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r9 < 0) goto L5e
            int r9 = r8.getLeft()
            int r1 = r7.f10467a
            if (r9 >= r1) goto L5c
            goto L5e
        L5c:
            int r1 = r1 + r10
            goto L65
        L5e:
            int r7 = r7.f10467a
            int r1 = r7 - r10
            goto L65
        L63:
            int r1 = r7.f10467a
        L65:
            u3.b r7 = r0.f2403a
            int r9 = r8.getTop()
            boolean r7 = r7.p(r1, r9)
            if (r7 == 0) goto L82
            com.stepos.statsrpk.service.d r7 = new com.stepos.statsrpk.service.d
            r9 = 12
            r7.<init>(r9)
            r7.f2886g = r0
            r7.f2885f = r8
            java.lang.invoke.VarHandle.storeStoreFence()
            r8.postOnAnimation(r7)
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r6.c.m(android.view.View, float, float):void");
    }

    @Override // t.i1
    public final boolean t(int i, View view) {
        int i3 = this.f10468b;
        return (i3 == -1 || i3 == i) && this.f10469c.c();
    }

    @Override // t.i1
    public final void k(int i) {
    }
}
