package Q;

import L.g;
import L.j;
import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public final class a extends j {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f1585b;

    public a(b bVar) {
        this.f1585b = bVar;
    }

    @Override // L.j
    public final g a(int i4) {
        return new g(AccessibilityNodeInfo.obtain(this.f1585b.e(i4).f1142a));
    }

    @Override // L.j
    public final g b(int i4) {
        b bVar = this.f1585b;
        int i5 = i4 == 2 ? bVar.f1596h : bVar.f1597i;
        if (i5 == Integer.MIN_VALUE) {
            return null;
        }
        return a(i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    @Override // L.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(int r6, int r7, android.os.Bundle r8) {
        /*
            r5 = this;
            Q.b r5 = r5.f1585b
            android.view.View r0 = r5.f1594f
            r1 = -1
            if (r6 == r1) goto L86
            r8 = 1
            if (r7 == r8) goto L81
            r1 = 2
            if (r7 == r1) goto L7c
            r1 = 64
            r2 = 65536(0x10000, float:9.1835E-41)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 0
            if (r7 == r1) goto L51
            r1 = 128(0x80, float:1.8E-43)
            if (r7 == r1) goto L41
            r1.d r5 = (r1.d) r5
            r0 = 16
            if (r7 != r0) goto L8c
            com.google.android.material.chip.Chip r5 = r5.f14011n
            if (r6 != 0) goto L2a
            boolean r4 = r5.performClick()
            goto L8c
        L2a:
            if (r6 != r8) goto L8c
            r5.playSoundEffect(r4)
            android.view.View$OnClickListener r6 = r5.f10577h
            if (r6 == 0) goto L37
            r6.onClick(r5)
            r4 = r8
        L37:
            boolean r6 = r5.f10588s
            if (r6 == 0) goto L8c
            r1.d r5 = r5.f10587r
            r5.i(r8, r8)
            goto L8c
        L41:
            int r7 = r5.f1596h
            if (r7 != r6) goto L4e
            r5.f1596h = r3
            r0.invalidate()
            r5.i(r6, r2)
            goto L4f
        L4e:
            r8 = r4
        L4f:
            r4 = r8
            goto L8c
        L51:
            android.view.accessibility.AccessibilityManager r7 = r5.f1593e
            boolean r1 = r7.isEnabled()
            if (r1 == 0) goto L4e
            boolean r7 = r7.isTouchExplorationEnabled()
            if (r7 != 0) goto L60
            goto L4e
        L60:
            int r7 = r5.f1596h
            if (r7 == r6) goto L4e
            if (r7 == r3) goto L70
            r5.f1596h = r3
            android.view.View r1 = r5.f1594f
            r1.invalidate()
            r5.i(r7, r2)
        L70:
            r5.f1596h = r6
            r0.invalidate()
            r7 = 32768(0x8000, float:4.5918E-41)
            r5.i(r6, r7)
            goto L4f
        L7c:
            boolean r4 = r5.a(r6)
            goto L8c
        L81:
            boolean r4 = r5.h(r6)
            goto L8c
        L86:
            java.util.WeakHashMap r5 = K.S.f939a
            boolean r4 = r0.performAccessibilityAction(r7, r8)
        L8c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: Q.a.c(int, int, android.os.Bundle):boolean");
    }
}
