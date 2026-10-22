package a4;

import com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl;
import f4.i1;
import f8.n0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import m.x;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f173a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f174b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f175c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f176d;

    public e(b9.f fVar, b9.g gVar, n0 n0Var) {
        this.f173a = 2;
        this.f174b = fVar;
        this.f175c = gVar;
        this.f176d = n0Var;
    }

    public n3.j a() {
        OfflineQueueDatabase_Impl offlineQueueDatabase_Impl = (OfflineQueueDatabase_Impl) this.f174b;
        offlineQueueDatabase_Impl.a();
        if (((AtomicBoolean) this.f175c).compareAndSet(false, true)) {
            return (n3.j) ((c7.o) this.f176d).getValue();
        }
        String strB = b();
        offlineQueueDatabase_Impl.a();
        if (offlineQueueDatabase_Impl.h().N().i() || offlineQueueDatabase_Impl.f2674i.get() == null) {
            return offlineQueueDatabase_Impl.h().N().d(strB);
        }
        throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
    }

    public abstract String b();

    public abstract e9.c c();

    public int d() {
        return 1;
    }

    public abstract String e();

    public Object f(com.google.crypto.tink.shaded.protobuf.a aVar, Class cls) {
        b4.c cVar = (b4.c) ((Map) this.f176d).get(cls);
        if (cVar != null) {
            return cVar.a(aVar);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public abstract d g();

    public abstract i1 h();

    public abstract com.google.crypto.tink.shaded.protobuf.a i(com.google.crypto.tink.shaded.protobuf.h hVar);

    public void j(n3.j jVar) {
        q7.k.e(jVar, "statement");
        if (jVar == ((n3.j) ((c7.o) this.f176d).getValue())) {
            ((AtomicBoolean) this.f175c).set(false);
        }
    }

    public abstract void k(com.google.crypto.tink.shaded.protobuf.a aVar);

    public String toString() {
        switch (this.f173a) {
            case 2:
                return getClass().getSimpleName() + ": " + c();
            default:
                return super.toString();
        }
    }

    public e(OfflineQueueDatabase_Impl offlineQueueDatabase_Impl) {
        this.f173a = 1;
        this.f174b = offlineQueueDatabase_Impl;
        this.f175c = new AtomicBoolean(false);
        this.f176d = s7.a.H(new a8.c(6, this));
    }

    public e(Class cls, b4.c[] cVarArr) {
        this.f173a = 0;
        this.f174b = cls;
        HashMap map = new HashMap();
        for (b4.c cVar : cVarArr) {
            Class cls2 = cVar.f1487a;
            if (!map.containsKey(cls2)) {
                map.put(cls2, cVar);
            } else {
                throw new IllegalArgumentException(x.j(cls2, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
            }
        }
        if (cVarArr.length > 0) {
            this.f175c = cVarArr[0].f1487a;
        } else {
            this.f175c = Void.class;
        }
        this.f176d = Collections.unmodifiableMap(map);
    }
}
