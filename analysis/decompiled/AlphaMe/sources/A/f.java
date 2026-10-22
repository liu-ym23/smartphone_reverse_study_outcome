package A;

import K.J;
import K.S;
import android.view.View;
import java.util.Comparator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class f implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f25a;

    public /* synthetic */ f(int i4) {
        this.f25a = i4;
    }

    public final int a(View view, View view2) {
        switch (this.f25a) {
            case 0:
                WeakHashMap weakHashMap = S.f939a;
                float fM = J.m(view);
                float fM2 = J.m(view2);
                if (fM > fM2) {
                    return -1;
                }
                return fM < fM2 ? 1 : 0;
            case 1:
            default:
                return view.getTop() - view2.getTop();
            case 2:
                r0.c cVar = (r0.c) view.getLayoutParams();
                r0.c cVar2 = (r0.c) view2.getLayoutParams();
                boolean z4 = cVar.f14002a;
                if (z4 != cVar2.f14002a) {
                    return z4 ? 1 : -1;
                }
                return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
    
        if (r6 < r7) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.compare((int) r4, (int) r5) < 0) goto L10;
     */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int compare(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            int r0 = r6.f25a
            r1 = 0
            r2 = -1
            r3 = 1
            switch(r0) {
                case 0: goto L90;
                case 1: goto L86;
                case 2: goto L7d;
                case 3: goto L8;
                case 4: goto L5c;
                case 5: goto L8;
                case 6: goto L53;
                case 7: goto L4a;
                default: goto L8;
            }
        L8:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r6 = "a"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r6)
            java.lang.String r6 = "b"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r6)
            int r6 = r7.length()
            int r0 = r8.length()
            int r6 = java.lang.Math.min(r6, r0)
            r0 = 4
        L23:
            if (r0 >= r6) goto L3c
            char r4 = r7.charAt(r0)
            char r5 = r8.charAt(r0)
            if (r4 == r5) goto L39
            int r6 = kotlin.jvm.internal.Intrinsics.compare(r4, r5)
            if (r6 >= 0) goto L37
        L35:
            r1 = r2
            goto L49
        L37:
            r1 = r3
            goto L49
        L39:
            int r0 = r0 + 1
            goto L23
        L3c:
            int r6 = r7.length()
            int r7 = r8.length()
            if (r6 == r7) goto L49
            if (r6 >= r7) goto L37
            goto L35
        L49:
            return r1
        L4a:
            java.lang.Comparable r7 = (java.lang.Comparable) r7
            java.lang.Comparable r8 = (java.lang.Comparable) r8
            int r6 = r7.compareTo(r8)
            return r6
        L53:
            android.view.View r7 = (android.view.View) r7
            android.view.View r8 = (android.view.View) r8
            int r6 = r6.a(r7, r8)
            return r6
        L5c:
            com.google.android.gms.location.ActivityTransition r7 = (com.google.android.gms.location.ActivityTransition) r7
            com.google.android.gms.location.ActivityTransition r8 = (com.google.android.gms.location.ActivityTransition) r8
            com.stepos.statsrpk.c.l(r7)
            com.stepos.statsrpk.c.l(r8)
            int r6 = r7.f10010a
            int r0 = r8.f10010a
            if (r6 == r0) goto L70
            if (r6 < r0) goto L7c
            r2 = r3
            goto L7c
        L70:
            int r6 = r7.f10011b
            int r7 = r8.f10011b
            if (r6 != r7) goto L77
            goto L7b
        L77:
            if (r6 >= r7) goto L7a
            goto L7c
        L7a:
            r1 = r3
        L7b:
            r2 = r1
        L7c:
            return r2
        L7d:
            android.view.View r7 = (android.view.View) r7
            android.view.View r8 = (android.view.View) r8
            int r6 = r6.a(r7, r8)
            return r6
        L86:
            r0.b r7 = (r0.b) r7
            r0.b r8 = (r0.b) r8
            int r6 = r7.f14000a
            int r7 = r8.f14000a
            int r6 = r6 - r7
            return r6
        L90:
            android.view.View r7 = (android.view.View) r7
            android.view.View r8 = (android.view.View) r8
            int r6 = r6.a(r7, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: A.f.compare(java.lang.Object, java.lang.Object):int");
    }
}
