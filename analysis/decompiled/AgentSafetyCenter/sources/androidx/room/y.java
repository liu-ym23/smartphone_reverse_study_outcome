package androidx.room;

import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1652a;

    /* renamed from: b, reason: collision with root package name */
    public final Serializable f1653b;

    /* renamed from: c, reason: collision with root package name */
    public final Serializable f1654c;

    /* JADX WARN: Removed duplicated region for block: B:38:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public y(android.content.Context r8, java.lang.String r9, java.util.Map r10) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.y.<init>(android.content.Context, java.lang.String, java.util.Map):void");
    }

    public z4.j a() {
        u uVar = (u) this.f1652a;
        uVar.a();
        if (((AtomicBoolean) this.f1653b).compareAndSet(false, true)) {
            return (z4.j) ((jb.k) this.f1654c).getValue();
        }
        String strB = b();
        uVar.getClass();
        uVar.a();
        uVar.b();
        return uVar.j().w().g(strB);
    }

    public abstract String b();

    public void c(z4.j jVar) {
        jVar.getClass();
        if (jVar == ((z4.j) ((jb.k) this.f1654c).getValue())) {
            ((AtomicBoolean) this.f1653b).set(false);
        }
    }

    public y(u uVar) {
        uVar.getClass();
        this.f1652a = uVar;
        this.f1653b = new AtomicBoolean(false);
        ab.e eVar = new ab.e(2);
        eVar.f393f = this;
        VarHandle.storeStoreFence();
        this.f1654c = new jb.k(eVar);
    }
}
