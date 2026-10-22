package y1;

import com.google.crypto.tink.shaded.protobuf.c0;
import com.google.crypto.tink.shaded.protobuf.w;
import f2.u;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Iterator;
import k2.a1;
import k2.c1;
import k2.d1;
import k2.e1;
import k2.f1;
import k2.q1;
import k2.v0;
import k2.w0;
import k2.x0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final f f6315c;
    public static final f d;

    /* renamed from: e, reason: collision with root package name */
    public static final f f6316e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6317a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6318b;

    static {
        int i8 = 0;
        f6315c = new f(i8, "ENABLED");
        d = new f(i8, "DISABLED");
        f6316e = new f(i8, "DESTROYED");
    }

    public /* synthetic */ f(int i8, Object obj) {
        this.f6317a = i8;
        this.f6318b = obj;
    }

    public synchronized void a(a1 a1Var) {
        e1 e1VarB;
        synchronized (this) {
            e1VarB = b(n.e(a1Var), a1Var.A());
        }
        c1 c1Var = (c1) this.f6318b;
        c1Var.e();
        f1.x((f1) c1Var.f1537b, e1VarB);
    }

    public synchronized e1 b(x0 x0Var, q1 q1Var) {
        int iA;
        synchronized (this) {
            iA = u.a();
            while (d(iA)) {
                iA = u.a();
            }
        }
        return (e1) d1VarF.b();
        if (q1Var == q1.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        d1 d1VarF = e1.F();
        d1VarF.e();
        e1.w((e1) d1VarF.f1537b, x0Var);
        d1VarF.e();
        e1.z((e1) d1VarF.f1537b, iA);
        d1VarF.e();
        e1.y((e1) d1VarF.f1537b);
        d1VarF.e();
        e1.x((e1) d1VarF.f1537b, q1Var);
        return (e1) d1VarF.b();
    }

    public synchronized a4.d c() {
        return a4.d.p((f1) ((c1) this.f6318b).b());
    }

    public synchronized boolean d(int i8) {
        Iterator it = Collections.unmodifiableList(((f1) ((c1) this.f6318b).f1537b).A()).iterator();
        while (it.hasNext()) {
            if (((e1) it.next()).B() == i8) {
                return true;
            }
        }
        return false;
    }

    public x0 e(com.google.crypto.tink.shaded.protobuf.i iVar) throws GeneralSecurityException {
        f2.e eVar = (f2.e) this.f6318b;
        try {
            f2.d dVarD = eVar.d();
            com.google.crypto.tink.shaded.protobuf.a aVarI = dVarD.i(iVar);
            dVarD.k(aVarI);
            com.google.crypto.tink.shaded.protobuf.a aVarD = dVarD.d(aVarI);
            v0 v0VarD = x0.D();
            String strB = eVar.b();
            v0VarD.e();
            x0.w((x0) v0VarD.f1537b, strB);
            try {
                int iB = ((w) aVarD).b(null);
                byte[] bArr = new byte[iB];
                com.google.crypto.tink.shaded.protobuf.l lVar = new com.google.crypto.tink.shaded.protobuf.l(bArr, iB);
                aVarD.f(lVar);
                if (lVar.f1489e - lVar.f1490f != 0) {
                    throw new IllegalStateException("Did not write as much data as expected.");
                }
                com.google.crypto.tink.shaded.protobuf.h hVar = new com.google.crypto.tink.shaded.protobuf.h(bArr);
                v0VarD.e();
                x0.x((x0) v0VarD.f1537b, hVar);
                w0 w0VarE = eVar.e();
                v0VarD.e();
                x0.y((x0) v0VarD.f1537b, w0VarE);
                return (x0) v0VarD.b();
            } catch (IOException e9) {
                throw new RuntimeException(aVarD.c("ByteString"), e9);
            }
        } catch (c0 e10) {
            throw new GeneralSecurityException("Unexpected proto", e10);
        }
    }

    public String toString() {
        switch (this.f6317a) {
            case 0:
                return (String) this.f6318b;
            default:
                return super.toString();
        }
    }

    public f(f2.e eVar, Class cls) {
        this.f6317a = 2;
        if (!eVar.f2556b.keySet().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(a8.b.p("Given internalKeyMananger ", eVar.toString(), " does not support primitive class ", cls.getName()));
        }
        this.f6318b = eVar;
    }
}
