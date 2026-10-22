package N;

import N.g;
import androidx.datastore.preferences.protobuf.AbstractC0504y;
import androidx.datastore.preferences.protobuf.T;
import androidx.datastore.preferences.protobuf.a0;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class h extends AbstractC0504y<h, a> implements T {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    private static final h DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile a0<h> PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int bitField0_;
    private int valueCase_ = 0;
    private Object value_;

    public static final class a extends AbstractC0504y.a<h, a> implements T {
        /* synthetic */ a(e eVar) {
            this();
        }

        public a B(boolean z5) {
            w();
            ((h) this.f10264b).c0(z5);
            return this;
        }

        public a C(double d6) {
            w();
            ((h) this.f10264b).d0(d6);
            return this;
        }

        public a D(float f5) {
            w();
            ((h) this.f10264b).e0(f5);
            return this;
        }

        public a E(int i5) {
            w();
            ((h) this.f10264b).f0(i5);
            return this;
        }

        public a F(long j5) {
            w();
            ((h) this.f10264b).g0(j5);
            return this;
        }

        public a G(String str) {
            w();
            ((h) this.f10264b).h0(str);
            return this;
        }

        public a H(g.a aVar) {
            w();
            ((h) this.f10264b).i0(aVar);
            return this;
        }

        private a() {
            super(h.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        BOOLEAN(1),
        FLOAT(2),
        INTEGER(3),
        LONG(4),
        STRING(5),
        STRING_SET(6),
        DOUBLE(7),
        VALUE_NOT_SET(0);


        /* renamed from: a, reason: collision with root package name */
        private final int f4182a;

        b(int i5) {
            this.f4182a = i5;
        }

        public static b b(int i5) {
            switch (i5) {
                case 0:
                    return VALUE_NOT_SET;
                case 1:
                    return BOOLEAN;
                case 2:
                    return FLOAT;
                case 3:
                    return INTEGER;
                case 4:
                    return LONG;
                case 5:
                    return STRING;
                case 6:
                    return STRING_SET;
                case 7:
                    return DOUBLE;
                default:
                    return null;
            }
        }
    }

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        AbstractC0504y.I(h.class, hVar);
    }

    private h() {
    }

    public static h T() {
        return DEFAULT_INSTANCE;
    }

    public static a b0() {
        return DEFAULT_INSTANCE.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(boolean z5) {
        this.valueCase_ = 1;
        this.value_ = Boolean.valueOf(z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(double d6) {
        this.valueCase_ = 7;
        this.value_ = Double.valueOf(d6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(float f5) {
        this.valueCase_ = 2;
        this.value_ = Float.valueOf(f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(int i5) {
        this.valueCase_ = 3;
        this.value_ = Integer.valueOf(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(long j5) {
        this.valueCase_ = 4;
        this.value_ = Long.valueOf(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(String str) {
        str.getClass();
        this.valueCase_ = 5;
        this.value_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(g.a aVar) {
        this.value_ = aVar.build();
        this.valueCase_ = 6;
    }

    public boolean S() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public double U() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public float V() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public int W() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public long X() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }

    public String Y() {
        return this.valueCase_ == 5 ? (String) this.value_ : BuildConfig.FLAVOR;
    }

    public g Z() {
        return this.valueCase_ == 6 ? (g) this.value_ : g.O();
    }

    public b a0() {
        return b.b(this.valueCase_);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0504y
    protected final Object w(AbstractC0504y.f fVar, Object obj, Object obj2) {
        a0 bVar;
        int i5 = e.f4171a[fVar.ordinal()];
        e eVar = null;
        switch (i5) {
            case 1:
                return new h();
            case 2:
                return new a(eVar);
            case 3:
                return AbstractC0504y.F(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000", new Object[]{"value_", "valueCase_", "bitField0_", g.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                a0<h> a0Var = PARSER;
                if (a0Var != null) {
                    return a0Var;
                }
                synchronized (h.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new AbstractC0504y.b(DEFAULT_INSTANCE);
                            PARSER = bVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return bVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
