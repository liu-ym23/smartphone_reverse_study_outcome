package pc;

import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class j {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9966c = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_next$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9967f = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_prev$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9968g = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public final boolean b(j jVar, int i) {
        j jVarF;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            jVarF = f();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f9967f;
            if (jVarF == null) {
                Object obj = atomicReferenceFieldUpdater2.get(this);
                while (true) {
                    jVarF = (j) obj;
                    if (!jVarF.i()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater2.get(jVarF);
                }
            }
            if (jVarF instanceof h) {
                return (((h) jVarF).f9964h & i) == 0 && jVarF.b(jVar, i);
            }
            atomicReferenceFieldUpdater2.set(jVar, jVarF);
            atomicReferenceFieldUpdater = f9966c;
            atomicReferenceFieldUpdater.set(jVar, this);
        } while (!atomicReferenceFieldUpdater.compareAndSet(jVarF, this, jVar));
        jVar.g(this);
        return true;
    }

    public final void c(int i) {
        h hVar = new h();
        hVar.f9964h = i;
        VarHandle.storeStoreFence();
        b(hVar, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        if (r5.compareAndSet(r4, r3, ((pc.o) r6).f9979a) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final pc.j f() {
        /*
            r9 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = pc.j.f9967f
            java.lang.Object r1 = r0.get(r9)
            pc.j r1 = (pc.j) r1
            r2 = 0
            r3 = r1
        La:
            r4 = r2
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = pc.j.f9966c
            java.lang.Object r6 = r5.get(r3)
            if (r6 != r9) goto L1e
            if (r1 != r3) goto L16
            goto L1d
        L16:
            boolean r0 = r0.compareAndSet(r9, r1, r3)
            if (r0 != 0) goto L1d
            goto L0
        L1d:
            return r3
        L1e:
            boolean r7 = r9.i()
            if (r7 == 0) goto L25
            return r2
        L25:
            boolean r7 = r6 instanceof pc.o
            if (r7 == 0) goto L3f
            if (r4 == 0) goto L38
            pc.o r6 = (pc.o) r6
            pc.j r6 = r6.f9979a
            boolean r3 = r5.compareAndSet(r4, r3, r6)
            if (r3 != 0) goto L36
            goto L0
        L36:
            r3 = r4
            goto La
        L38:
            java.lang.Object r3 = r0.get(r3)
            pc.j r3 = (pc.j) r3
            goto Lb
        L3f:
            r6.getClass()
            r4 = r6
            pc.j r4 = (pc.j) r4
            r8 = r4
            r4 = r3
            r3 = r8
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: pc.j.f():pc.j");
    }

    public final void g(j jVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        j jVar2;
        do {
            atomicReferenceFieldUpdater = f9967f;
            jVar2 = (j) atomicReferenceFieldUpdater.get(jVar);
            if (f9966c.get(this) != jVar) {
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(jVar, jVar2, this));
        if (i()) {
            jVar.f();
        }
    }

    public final j h() {
        Object obj = f9966c.get(this);
        o oVar = obj instanceof o ? (o) obj : null;
        if (oVar != null) {
            return oVar.f9979a;
        }
        obj.getClass();
        return (j) obj;
    }

    public boolean i() {
        return f9966c.get(this) instanceof o;
    }

    public String toString() {
        return new i(1, 0, kc.w.class, this, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;") + '@' + kc.w.m(this);
    }
}
