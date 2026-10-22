package androidx.compose.foundation.lazy.layout;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import p.f0;
import p.g0;
import p.n0;
import p.o0;
import w0.m;
import x.n;
import y.w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final f0 f915a;

    /* renamed from: b, reason: collision with root package name */
    public w f916b;

    /* renamed from: c, reason: collision with root package name */
    public final g0 f917c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f918d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f919e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f920f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f921g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f922h;
    public final m i;

    public a() {
        long[] jArr = n0.f9597a;
        this.f915a = new f0();
        int i = o0.f9601a;
        this.f917c = new g0();
        this.f918d = new ArrayList();
        this.f919e = new ArrayList();
        this.f920f = new ArrayList();
        this.f921g = new ArrayList();
        this.f922h = new ArrayList();
        LazyLayoutItemAnimator$DisplayingDisappearingItemsElement lazyLayoutItemAnimator$DisplayingDisappearingItemsElement = new LazyLayoutItemAnimator$DisplayingDisappearingItemsElement();
        lazyLayoutItemAnimator$DisplayingDisappearingItemsElement.f909c = this;
        VarHandle.storeStoreFence();
        this.i = lazyLayoutItemAnimator$DisplayingDisappearingItemsElement;
    }

    public static int e(int[] iArr, n nVar) {
        nVar.getClass();
        int i = iArr[0] + nVar.f15465l;
        iArr[0] = i;
        return Math.max(0, i);
    }

    public final long a() {
        ArrayList arrayList = this.f922h;
        if (arrayList.size() <= 0) {
            return 0L;
        }
        w2.c.d(arrayList.get(0));
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(int r31, int r32, java.util.ArrayList r33, b2.a r34, x.j r35, boolean r36, boolean r37, int r38, int r39) {
        /*
            Method dump skipped, instructions count: 693
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.a.b(int, int, java.util.ArrayList, b2.a, x.j, boolean, boolean, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            r15 = this;
            p.f0 r0 = r15.f915a
            boolean r1 = r0.j()
            if (r1 == 0) goto L50
            java.lang.Object[] r1 = r0.f9554c
            long[] r2 = r0.f9552a
            int r3 = r2.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L4d
            r4 = 0
            r5 = r4
        L13:
            r6 = r2[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L48
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L2d:
            if (r10 >= r8) goto L46
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 < 0) goto L3c
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L2d
        L3c:
            int r15 = r5 << 3
            int r15 = r15 + r10
            r15 = r1[r15]
            w2.c.d(r15)
            r15 = 0
            throw r15
        L46:
            if (r8 != r9) goto L4d
        L48:
            if (r5 == r3) goto L4d
            int r5 = r5 + 1
            goto L13
        L4d:
            r0.a()
        L50:
            y.g r0 = y.g.f15742b
            r15.f916b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.a.c():void");
    }

    public final void d(n nVar, boolean z10) {
        Object objG = this.f915a.g(nVar.f15461g);
        objG.getClass();
        w2.c.d(objG);
        throw null;
    }
}
