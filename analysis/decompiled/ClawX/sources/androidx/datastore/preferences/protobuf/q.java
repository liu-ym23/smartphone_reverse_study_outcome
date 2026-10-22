package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f543c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final w0 f544a = w0.f();

    /* renamed from: b, reason: collision with root package name */
    public boolean f545b;

    static {
        new q(0);
    }

    public q() {
    }

    public static void b(l lVar, p1 p1Var, int i8, Object obj) {
        if (p1Var == p1.d) {
            lVar.J0(i8, 3);
            ((a) obj).b(lVar);
            lVar.J0(i8, 4);
        }
        lVar.J0(i8, p1Var.f542b);
        switch (p1Var.ordinal()) {
            case 0:
                lVar.D0(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                lVar.B0(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                lVar.N0(((Long) obj).longValue());
                break;
            case 3:
                lVar.N0(((Long) obj).longValue());
                break;
            case 4:
                lVar.F0(((Integer) obj).intValue());
                break;
            case 5:
                lVar.D0(((Long) obj).longValue());
                break;
            case 6:
                lVar.B0(((Integer) obj).intValue());
                break;
            case 7:
                lVar.v0(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof g)) {
                    lVar.I0((String) obj);
                    break;
                } else {
                    lVar.z0((g) obj);
                    break;
                }
            case 9:
                ((a) obj).b(lVar);
                break;
            case 10:
                a aVar = (a) obj;
                lVar.getClass();
                lVar.L0(((v) aVar).a(null));
                aVar.b(lVar);
                break;
            case BERTags.EMBEDDED_PDV /* 11 */:
                if (!(obj instanceof g)) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    lVar.L0(length);
                    lVar.w0(bArr, 0, length);
                    break;
                } else {
                    lVar.z0((g) obj);
                    break;
                }
            case 12:
                lVar.L0(((Integer) obj).intValue());
                break;
            case BERTags.RELATIVE_OID /* 13 */:
                lVar.F0(((Integer) obj).intValue());
                break;
            case BERTags.TIME /* 14 */:
                lVar.B0(((Integer) obj).intValue());
                break;
            case 15:
                lVar.D0(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                lVar.L0((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                lVar.N0((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public final void a() {
        if (this.f545b) {
            return;
        }
        w0 w0Var = this.f544a;
        int size = w0Var.f575a.size();
        for (int i8 = 0; i8 < size; i8++) {
            Map.Entry entryC = w0Var.c(i8);
            if (entryC.getValue() instanceof v) {
                v vVar = (v) entryC.getValue();
                vVar.getClass();
                r0 r0Var = r0.f559c;
                r0Var.getClass();
                r0Var.a(vVar.getClass()).b(vVar);
                vVar.h();
            }
        }
        if (!w0Var.f577c) {
            if (w0Var.f575a.size() > 0) {
                w0Var.c(0).getKey().getClass();
                throw new ClassCastException();
            }
            Iterator it = w0Var.d().iterator();
            if (it.hasNext()) {
                ((Map.Entry) it.next()).getKey().getClass();
                throw new ClassCastException();
            }
        }
        if (!w0Var.f577c) {
            w0Var.f576b = w0Var.f576b.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(w0Var.f576b);
            w0Var.f578e = w0Var.f578e.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(w0Var.f578e);
            w0Var.f577c = true;
        }
        this.f545b = true;
    }

    public final Object clone() {
        q qVar = new q();
        w0 w0Var = this.f544a;
        if (w0Var.f575a.size() > 0) {
            Map.Entry entryC = w0Var.c(0);
            if (entryC.getKey() != null) {
                throw new ClassCastException();
            }
            entryC.getValue();
            throw null;
        }
        Iterator it = w0Var.d().iterator();
        if (!it.hasNext()) {
            return qVar;
        }
        Map.Entry entry = (Map.Entry) it.next();
        if (entry.getKey() != null) {
            throw new ClassCastException();
        }
        entry.getValue();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return this.f544a.equals(((q) obj).f544a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f544a.hashCode();
    }

    public q(int i8) {
        a();
        a();
    }
}
