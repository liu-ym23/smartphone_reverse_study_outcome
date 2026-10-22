package l0;

import androidx.datastore.preferences.protobuf.q0;
import androidx.datastore.preferences.protobuf.t;
import androidx.datastore.preferences.protobuf.t0;
import androidx.datastore.preferences.protobuf.u;
import androidx.datastore.preferences.protobuf.v;
import com.stepos.stepclaw.SecurePrefs;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends v {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    public static final int BYTES_FIELD_NUMBER = 8;
    private static final j DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile q0 PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int valueCase_ = 0;
    private Object value_;

    static {
        j jVar = new j();
        DEFAULT_INSTANCE = jVar;
        v.j(j.class, jVar);
    }

    public static i D() {
        return (i) ((t) DEFAULT_INSTANCE.c(5));
    }

    public static void l(j jVar, long j4) {
        jVar.valueCase_ = 4;
        jVar.value_ = Long.valueOf(j4);
    }

    public static void m(j jVar, String str) {
        jVar.getClass();
        jVar.valueCase_ = 5;
        jVar.value_ = str;
    }

    public static void n(j jVar, h hVar) {
        jVar.getClass();
        jVar.value_ = hVar;
        jVar.valueCase_ = 6;
    }

    public static void o(j jVar, double d) {
        jVar.valueCase_ = 7;
        jVar.value_ = Double.valueOf(d);
    }

    public static void p(j jVar, androidx.datastore.preferences.protobuf.g gVar) {
        jVar.getClass();
        jVar.valueCase_ = 8;
        jVar.value_ = gVar;
    }

    public static void q(j jVar, boolean z) {
        jVar.valueCase_ = 1;
        jVar.value_ = Boolean.valueOf(z);
    }

    public static void r(j jVar, float f3) {
        jVar.valueCase_ = 2;
        jVar.value_ = Float.valueOf(f3);
    }

    public static void s(j jVar, int i8) {
        jVar.valueCase_ = 3;
        jVar.value_ = Integer.valueOf(i8);
    }

    public static j v() {
        return DEFAULT_INSTANCE;
    }

    public final String A() {
        return this.valueCase_ == 5 ? (String) this.value_ : SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
    }

    public final h B() {
        return this.valueCase_ == 6 ? (h) this.value_ : h.m();
    }

    public final int C() {
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
    public final Object c(int i8) {
        q0 uVar;
        switch (m.f.a(i8)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new t0(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", h.class});
            case 3:
                return new j();
            case 4:
                return new i(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q0 q0Var = PARSER;
                if (q0Var != null) {
                    return q0Var;
                }
                synchronized (j.class) {
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
                throw new UnsupportedOperationException();
        }
    }

    public final boolean t() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public final androidx.datastore.preferences.protobuf.g u() {
        return this.valueCase_ == 8 ? (androidx.datastore.preferences.protobuf.g) this.value_ : androidx.datastore.preferences.protobuf.g.f473c;
    }

    public final double w() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public final float x() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public final int y() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public final long z() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }
}
