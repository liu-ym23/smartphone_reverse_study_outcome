package x3;

import androidx.datastore.preferences.protobuf.r0;
import androidx.datastore.preferences.protobuf.t;
import androidx.datastore.preferences.protobuf.u;
import androidx.datastore.preferences.protobuf.v;
import b8.z;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends v {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    public static final int BYTES_FIELD_NUMBER = 8;
    private static final i DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile r0 PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int valueCase_ = 0;
    private Object value_;

    static {
        i iVar = new i();
        DEFAULT_INSTANCE = iVar;
        v.k(i.class, iVar);
    }

    public static h E() {
        return (h) ((t) DEFAULT_INSTANCE.c(5));
    }

    public static void m(i iVar, long j10) {
        iVar.valueCase_ = 4;
        iVar.value_ = Long.valueOf(j10);
    }

    public static void n(i iVar, String str) {
        iVar.getClass();
        iVar.valueCase_ = 5;
        iVar.value_ = str;
    }

    public static void o(i iVar, g gVar) {
        iVar.getClass();
        iVar.value_ = gVar;
        iVar.valueCase_ = 6;
    }

    public static void p(i iVar, double d7) {
        iVar.valueCase_ = 7;
        iVar.value_ = Double.valueOf(d7);
    }

    public static void q(i iVar, androidx.datastore.preferences.protobuf.f fVar) {
        iVar.getClass();
        iVar.valueCase_ = 8;
        iVar.value_ = fVar;
    }

    public static void r(i iVar, boolean z10) {
        iVar.valueCase_ = 1;
        iVar.value_ = Boolean.valueOf(z10);
    }

    public static void s(i iVar, float f5) {
        iVar.valueCase_ = 2;
        iVar.value_ = Float.valueOf(f5);
    }

    public static void t(i iVar, int i) {
        iVar.valueCase_ = 3;
        iVar.value_ = Integer.valueOf(i);
    }

    public static i w() {
        return DEFAULT_INSTANCE;
    }

    public final long A() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }

    public final String B() {
        return this.valueCase_ == 5 ? (String) this.value_ : "";
    }

    public final g C() {
        return this.valueCase_ == 6 ? (g) this.value_ : g.n();
    }

    public final int D() {
        switch (this.valueCase_) {
            case 0:
                return 9;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            default:
                return 0;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v
    public final Object c(int i) {
        r0 uVar;
        switch (s.f.c(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return v.i(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", g.class});
            case 3:
                return new i();
            case 4:
                return new h(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                r0 r0Var = PARSER;
                if (r0Var != null) {
                    return r0Var;
                }
                synchronized (i.class) {
                    try {
                        uVar = PARSER;
                        if (uVar == null) {
                            uVar = new u();
                            PARSER = uVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return uVar;
            default:
                z.c();
                return null;
        }
    }

    public final boolean u() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public final androidx.datastore.preferences.protobuf.f v() {
        return this.valueCase_ == 8 ? (androidx.datastore.preferences.protobuf.f) this.value_ : androidx.datastore.preferences.protobuf.f.f1105g;
    }

    public final double x() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public final float y() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public final int z() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }
}
