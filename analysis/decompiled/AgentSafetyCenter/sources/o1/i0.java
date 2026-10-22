package o1;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import java.util.ArrayList;
import u1.s1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 extends w0.l implements w, o2.c, s1 {
    public final m0.e A;
    public j B;
    public long C;

    /* renamed from: s, reason: collision with root package name */
    public Object f9048s;

    /* renamed from: t, reason: collision with root package name */
    public Object f9049t;

    /* renamed from: u, reason: collision with root package name */
    public pb.i f9050u;

    /* renamed from: v, reason: collision with root package name */
    public PointerInputEventHandler f9051v;

    /* renamed from: w, reason: collision with root package name */
    public kc.z f9052w;

    /* renamed from: x, reason: collision with root package name */
    public j f9053x = d0.f9016a;

    /* renamed from: y, reason: collision with root package name */
    public final m0.e f9054y;

    /* renamed from: z, reason: collision with root package name */
    public final m0.e f9055z;

    public i0(Object obj, Object obj2, PointerInputEventHandler pointerInputEventHandler) {
        this.f9048s = obj;
        this.f9049t = obj2;
        this.f9051v = pointerInputEventHandler;
        m0.e eVar = new m0.e(new h0[16]);
        this.f9054y = eVar;
        this.f9055z = eVar;
        this.A = new m0.e(new h0[16]);
        this.C = 0L;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // u1.s1
    public final void A() {
        j jVar = this.B;
        if (jVar == null) {
            return;
        }
        ?? r12 = jVar.f9056a;
        int size = r12.size();
        for (int i = 0; i < size; i++) {
            if (((s) r12.get(i)).f9074d) {
                ArrayList arrayList = new ArrayList(r12.size());
                int size2 = r12.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    s sVar = (s) r12.get(i3);
                    long j10 = sVar.f9071a;
                    long j11 = sVar.f9073c;
                    long j12 = sVar.f9072b;
                    float f5 = sVar.f9075e;
                    boolean z10 = sVar.f9074d;
                    arrayList.add(new s(j10, j12, j11, false, f5, j12, j11, z10, z10, sVar.i, 0L));
                }
                j jVar2 = new j(arrayList, null);
                this.f9053x = jVar2;
                B0(jVar2, k.f9059c);
                B0(jVar2, k.f9060f);
                B0(jVar2, k.f9061g);
                this.B = null;
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004c A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:6:0x000d, B:13:0x001b, B:14:0x0020, B:17:0x0023, B:20:0x002f, B:22:0x0037, B:24:0x003b, B:25:0x0040, B:26:0x0043, B:28:0x004c, B:30:0x0054, B:32:0x0058), top: B:41:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B0(o1.j r7, o1.k r8) {
        /*
            r6 = this;
            m0.e r0 = r6.f9055z
            monitor-enter(r0)
            m0.e r1 = r6.A     // Catch: java.lang.Throwable -> L6c
            m0.e r2 = r6.f9054y     // Catch: java.lang.Throwable -> L6c
            int r3 = r1.f8160g     // Catch: java.lang.Throwable -> L6c
            r1.d(r3, r2)     // Catch: java.lang.Throwable -> L6c
            monitor-exit(r0)
            int r0 = r8.ordinal()     // Catch: java.lang.Throwable -> L21
            r1 = 0
            if (r0 == 0) goto L43
            r2 = 1
            if (r0 == r2) goto L23
            r2 = 2
            if (r0 != r2) goto L1b
            goto L43
        L1b:
            androidx.fragment.app.d r7 = new androidx.fragment.app.d     // Catch: java.lang.Throwable -> L21
            r7.<init>()     // Catch: java.lang.Throwable -> L21
            throw r7     // Catch: java.lang.Throwable -> L21
        L21:
            r7 = move-exception
            goto L66
        L23:
            m0.e r0 = r6.A     // Catch: java.lang.Throwable -> L21
            int r3 = r0.f8160g     // Catch: java.lang.Throwable -> L21
            int r3 = r3 - r2
            java.lang.Object[] r0 = r0.f8158c     // Catch: java.lang.Throwable -> L21
            int r2 = r0.length     // Catch: java.lang.Throwable -> L21
            if (r3 >= r2) goto L60
        L2d:
            if (r3 < 0) goto L60
            r2 = r0[r3]     // Catch: java.lang.Throwable -> L21
            o1.h0 r2 = (o1.h0) r2     // Catch: java.lang.Throwable -> L21
            o1.k r4 = r2.f9044h     // Catch: java.lang.Throwable -> L21
            if (r8 != r4) goto L40
            kc.g r4 = r2.f9043g     // Catch: java.lang.Throwable -> L21
            if (r4 == 0) goto L40
            r2.f9043g = r1     // Catch: java.lang.Throwable -> L21
            r4.resumeWith(r7)     // Catch: java.lang.Throwable -> L21
        L40:
            int r3 = r3 + (-1)
            goto L2d
        L43:
            m0.e r0 = r6.A     // Catch: java.lang.Throwable -> L21
            java.lang.Object[] r2 = r0.f8158c     // Catch: java.lang.Throwable -> L21
            int r0 = r0.f8160g     // Catch: java.lang.Throwable -> L21
            r3 = 0
        L4a:
            if (r3 >= r0) goto L60
            r4 = r2[r3]     // Catch: java.lang.Throwable -> L21
            o1.h0 r4 = (o1.h0) r4     // Catch: java.lang.Throwable -> L21
            o1.k r5 = r4.f9044h     // Catch: java.lang.Throwable -> L21
            if (r8 != r5) goto L5d
            kc.g r5 = r4.f9043g     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L5d
            r4.f9043g = r1     // Catch: java.lang.Throwable -> L21
            r5.resumeWith(r7)     // Catch: java.lang.Throwable -> L21
        L5d:
            int r3 = r3 + 1
            goto L4a
        L60:
            m0.e r6 = r6.A
            r6.g()
            return
        L66:
            m0.e r6 = r6.A
            r6.g()
            throw r7
        L6c:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.i0.B0(o1.j, o1.k):void");
    }

    public final void C0() {
        kc.z zVar = this.f9052w;
        if (zVar != null) {
            zVar.u(new v("Pointer input was reset", 0));
            this.f9052w = null;
        }
    }

    @Override // o2.c
    public final float T() {
        return u1.f.u(this).A.T();
    }

    @Override // o2.c
    public final float a() {
        return u1.f.u(this).A.a();
    }

    @Override // u1.l
    public final void c() {
        C0();
    }

    @Override // u1.s1
    public final void l0() {
        C0();
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // u1.s1
    public final void q(j jVar, k kVar, long j10) {
        this.C = j10;
        if (kVar == k.f9059c) {
            this.f9053x = jVar;
        }
        nb.c cVar = null;
        if (this.f9052w == null) {
            this.f9052w = kc.w.u(p0(), null, kc.u.f7484h, new androidx.room.e(this, cVar, 7), 1);
        }
        B0(jVar, kVar);
        ?? r52 = jVar.f9056a;
        int size = r52.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                jVar = null;
                break;
            } else if (!q.b((s) r52.get(i))) {
                break;
            } else {
                i++;
            }
        }
        this.B = jVar;
    }

    @Override // w0.l
    public final void u0() {
        C0();
    }
}
