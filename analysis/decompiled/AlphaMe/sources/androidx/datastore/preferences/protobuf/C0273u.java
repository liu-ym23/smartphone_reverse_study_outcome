package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0273u {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f3539c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final k0 f3540a = new k0(16);

    /* renamed from: b, reason: collision with root package name */
    public boolean f3541b;

    static {
        new C0273u(0);
    }

    public C0273u() {
    }

    public static void b(AbstractC0268o abstractC0268o, H0 h02, int i4, Object obj) {
        if (h02 == H0.f3412d) {
            abstractC0268o.X(i4, 3);
            ((AbstractC0247b) obj).c(abstractC0268o);
            abstractC0268o.X(i4, 4);
            return;
        }
        abstractC0268o.X(i4, h02.f3416b);
        switch (h02.ordinal()) {
            case 0:
                abstractC0268o.Q(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                abstractC0268o.O(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                abstractC0268o.b0(((Long) obj).longValue());
                break;
            case 3:
                abstractC0268o.b0(((Long) obj).longValue());
                break;
            case 4:
                abstractC0268o.S(((Integer) obj).intValue());
                break;
            case 5:
                abstractC0268o.Q(((Long) obj).longValue());
                break;
            case 6:
                abstractC0268o.O(((Integer) obj).intValue());
                break;
            case 7:
                abstractC0268o.I(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof AbstractC0259h)) {
                    abstractC0268o.W((String) obj);
                    break;
                } else {
                    abstractC0268o.M((AbstractC0259h) obj);
                    break;
                }
            case 9:
                ((AbstractC0247b) obj).c(abstractC0268o);
                break;
            case 10:
                abstractC0268o.U((AbstractC0247b) obj);
                break;
            case 11:
                if (!(obj instanceof AbstractC0259h)) {
                    byte[] bArr = (byte[]) obj;
                    abstractC0268o.K(bArr.length, bArr);
                    break;
                } else {
                    abstractC0268o.M((AbstractC0259h) obj);
                    break;
                }
            case 12:
                abstractC0268o.Z(((Integer) obj).intValue());
                break;
            case 13:
                abstractC0268o.S(((Integer) obj).intValue());
                break;
            case 14:
                abstractC0268o.O(((Integer) obj).intValue());
                break;
            case 15:
                abstractC0268o.Q(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                abstractC0268o.Z((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                abstractC0268o.b0((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public final void a() {
        if (this.f3541b) {
            return;
        }
        k0 k0Var = this.f3540a;
        if (!k0Var.f3504d) {
            if (k0Var.f3502b.size() > 0) {
                B0.g.y(k0Var.h(0).getKey());
                throw null;
            }
            Iterator it = k0Var.i().iterator();
            if (it.hasNext()) {
                B0.g.y(((Map.Entry) it.next()).getKey());
                throw null;
            }
        }
        if (!k0Var.f3504d) {
            k0Var.f3503c = k0Var.f3503c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(k0Var.f3503c);
            k0Var.f3506f = k0Var.f3506f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(k0Var.f3506f);
            k0Var.f3504d = true;
        }
        this.f3541b = true;
    }

    public final Object clone() {
        C0273u c0273u = new C0273u();
        k0 k0Var = this.f3540a;
        if (k0Var.f3502b.size() > 0) {
            Map.Entry entryH = k0Var.h(0);
            B0.g.y(entryH.getKey());
            entryH.getValue();
            throw null;
        }
        Iterator it = k0Var.i().iterator();
        if (!it.hasNext()) {
            return c0273u;
        }
        Map.Entry entry = (Map.Entry) it.next();
        B0.g.y(entry.getKey());
        entry.getValue();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0273u)) {
            return false;
        }
        return this.f3540a.equals(((C0273u) obj).f3540a);
    }

    public final int hashCode() {
        return this.f3540a.hashCode();
    }

    public C0273u(int i4) {
        a();
        a();
    }
}
