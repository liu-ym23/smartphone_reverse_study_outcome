package androidx.datastore.preferences.protobuf;

import java.lang.invoke.VarHandle;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f1179c = 0;

    /* renamed from: a, reason: collision with root package name */
    public y0 f1180a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1181b;

    static {
        y0 y0VarF = y0.f();
        q qVar = new q();
        qVar.f1180a = y0VarF;
        qVar.a();
        qVar.a();
        VarHandle.storeStoreFence();
    }

    public static void b(l lVar, r1 r1Var, int i, Object obj) {
        if (r1Var == r1.f1189h) {
            lVar.B(i, 3);
            ((a) obj).b(lVar);
            lVar.B(i, 4);
        }
        lVar.B(i, r1Var.f1192f);
        switch (r1Var.ordinal()) {
            case 0:
                lVar.u(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                lVar.s(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                lVar.F(((Long) obj).longValue());
                break;
            case 3:
                lVar.F(((Long) obj).longValue());
                break;
            case 4:
                lVar.w(((Integer) obj).intValue());
                break;
            case 5:
                lVar.u(((Long) obj).longValue());
                break;
            case 6:
                lVar.s(((Integer) obj).intValue());
                break;
            case 7:
                lVar.m(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof f)) {
                    lVar.A((String) obj);
                    break;
                } else {
                    lVar.q((f) obj);
                    break;
                }
            case 9:
                ((a) obj).b(lVar);
                break;
            case 10:
                a aVar = (a) obj;
                lVar.getClass();
                lVar.D(((v) aVar).a(null));
                aVar.b(lVar);
                break;
            case 11:
                if (!(obj instanceof f)) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    lVar.D(length);
                    lVar.n(bArr, 0, length);
                    break;
                } else {
                    lVar.q((f) obj);
                    break;
                }
            case 12:
                lVar.D(((Integer) obj).intValue());
                break;
            case 13:
                lVar.w(((Integer) obj).intValue());
                break;
            case 14:
                lVar.s(((Integer) obj).intValue());
                break;
            case 15:
                lVar.u(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                lVar.D((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                lVar.F((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public final void a() {
        y0 y0Var = this.f1180a;
        if (this.f1181b) {
            return;
        }
        int size = y0Var.f1224c.size();
        for (int i = 0; i < size; i++) {
            Map.Entry entryC = y0Var.c(i);
            if (entryC.getValue() instanceof v) {
                v vVar = (v) entryC.getValue();
                vVar.getClass();
                t0 t0Var = t0.f1207c;
                t0Var.getClass();
                t0Var.a(vVar.getClass()).makeImmutable(vVar);
                vVar.h();
            }
        }
        if (!y0Var.f1226g) {
            if (y0Var.f1224c.size() > 0) {
                y0Var.c(0).getKey().getClass();
                od.f.j();
                return;
            } else {
                Iterator it = y0Var.d().iterator();
                if (it.hasNext()) {
                    ((Map.Entry) it.next()).getKey().getClass();
                    od.f.j();
                    return;
                }
            }
        }
        if (!y0Var.f1226g) {
            y0Var.f1225f = y0Var.f1225f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(y0Var.f1225f);
            y0Var.i = y0Var.i.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(y0Var.i);
            y0Var.f1226g = true;
        }
        this.f1181b = true;
    }

    public final Object clone() {
        q qVar = new q();
        qVar.f1180a = y0.f();
        y0 y0Var = this.f1180a;
        if (y0Var.f1224c.size() > 0) {
            Map.Entry entryC = y0Var.c(0);
            if (entryC.getKey() != null) {
                od.f.j();
                return null;
            }
            entryC.getValue();
            throw null;
        }
        Iterator it = y0Var.d().iterator();
        if (!it.hasNext()) {
            return qVar;
        }
        Map.Entry entry = (Map.Entry) it.next();
        if (entry.getKey() != null) {
            od.f.j();
            return null;
        }
        entry.getValue();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return this.f1180a.equals(((q) obj).f1180a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1180a.hashCode();
    }
}
