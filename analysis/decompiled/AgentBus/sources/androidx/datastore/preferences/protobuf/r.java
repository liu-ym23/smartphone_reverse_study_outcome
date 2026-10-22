package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f935c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final b1 f936a = new b1(16);

    /* renamed from: b, reason: collision with root package name */
    public boolean f937b;

    static {
        new r(0);
    }

    public r() {
    }

    public static void b(m mVar, a2 a2Var, int i2, Object obj) throws IOException {
        if (a2Var == a2.f800i) {
            mVar.L(i2, 3);
            ((a) obj).b(mVar);
            mVar.L(i2, 4);
        }
        mVar.L(i2, a2Var.f804g);
        switch (a2Var.ordinal()) {
            case 0:
                mVar.F(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                mVar.D(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                mVar.P(((Long) obj).longValue());
                break;
            case 3:
                mVar.P(((Long) obj).longValue());
                break;
            case 4:
                mVar.H(((Integer) obj).intValue());
                break;
            case 5:
                mVar.F(((Long) obj).longValue());
                break;
            case 6:
                mVar.D(((Integer) obj).intValue());
                break;
            case 7:
                mVar.x(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof g)) {
                    mVar.K((String) obj);
                    break;
                } else {
                    mVar.B((g) obj);
                    break;
                }
            case 9:
                ((a) obj).b(mVar);
                break;
            case 10:
                a aVar = (a) obj;
                mVar.getClass();
                mVar.N(((w) aVar).a(null));
                aVar.b(mVar);
                break;
            case 11:
                if (!(obj instanceof g)) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    mVar.N(length);
                    mVar.y(bArr, 0, length);
                    break;
                } else {
                    mVar.B((g) obj);
                    break;
                }
            case 12:
                mVar.N(((Integer) obj).intValue());
                break;
            case 13:
                mVar.H(((Integer) obj).intValue());
                break;
            case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                mVar.D(((Integer) obj).intValue());
                break;
            case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                mVar.F(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                mVar.N((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                mVar.P((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public final void a() {
        b1 b1Var;
        if (this.f937b) {
            return;
        }
        int i2 = 0;
        while (true) {
            b1Var = this.f936a;
            if (i2 >= b1Var.f819g.size()) {
                break;
            }
            Map.Entry entryC = b1Var.c(i2);
            if (entryC.getValue() instanceof w) {
                w wVar = (w) entryC.getValue();
                wVar.getClass();
                w0 w0Var = w0.f962c;
                w0Var.getClass();
                w0Var.a(wVar.getClass()).b(wVar);
                wVar.h();
            }
            i2++;
        }
        if (!b1Var.f821i) {
            if (b1Var.f819g.size() > 0) {
                b1Var.c(0).getKey().getClass();
                throw new ClassCastException();
            }
            Iterator it = b1Var.d().iterator();
            if (it.hasNext()) {
                ((Map.Entry) it.next()).getKey().getClass();
                throw new ClassCastException();
            }
        }
        if (!b1Var.f821i) {
            b1Var.f820h = b1Var.f820h.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(b1Var.f820h);
            b1Var.f823k = b1Var.f823k.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(b1Var.f823k);
            b1Var.f821i = true;
        }
        this.f937b = true;
    }

    public final Object clone() {
        r rVar = new r();
        b1 b1Var = this.f936a;
        if (b1Var.f819g.size() > 0) {
            Map.Entry entryC = b1Var.c(0);
            if (entryC.getKey() != null) {
                throw new ClassCastException();
            }
            entryC.getValue();
            throw null;
        }
        Iterator it = b1Var.d().iterator();
        if (!it.hasNext()) {
            return rVar;
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
        if (obj instanceof r) {
            return this.f936a.equals(((r) obj).f936a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f936a.hashCode();
    }

    public r(int i2) {
        a();
        a();
    }
}
