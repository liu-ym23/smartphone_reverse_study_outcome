package androidx.datastore.preferences;

import L0.c;
import androidx.datastore.preferences.a;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.L;
import androidx.datastore.preferences.protobuf.T;

/* loaded from: classes.dex */
public final class PreferencesProto$Value extends GeneratedMessageLite<PreferencesProto$Value, a> implements L {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    private static final PreferencesProto$Value DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile T<PreferencesProto$Value> PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int bitField0_;
    private int valueCase_ = 0;
    private Object value_;

    public enum ValueCase {
        BOOLEAN(1),
        FLOAT(2),
        INTEGER(3),
        LONG(4),
        STRING(5),
        STRING_SET(6),
        DOUBLE(7),
        VALUE_NOT_SET(0);

        private final int value;

        ValueCase(int i10) {
            this.value = i10;
        }

        public static ValueCase forNumber(int i10) {
            switch (i10) {
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

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ValueCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    public static final class a extends GeneratedMessageLite.a<PreferencesProto$Value, a> implements L {
        public /* synthetic */ a(c cVar) {
            this();
        }

        public a t(boolean z10) {
            o();
            ((PreferencesProto$Value) this.f13448b).U(z10);
            return this;
        }

        public a u(double d10) {
            o();
            ((PreferencesProto$Value) this.f13448b).V(d10);
            return this;
        }

        public a v(float f10) {
            o();
            ((PreferencesProto$Value) this.f13448b).W(f10);
            return this;
        }

        public a w(int i10) {
            o();
            ((PreferencesProto$Value) this.f13448b).X(i10);
            return this;
        }

        public a x(long j10) {
            o();
            ((PreferencesProto$Value) this.f13448b).Y(j10);
            return this;
        }

        public a y(String str) {
            o();
            ((PreferencesProto$Value) this.f13448b).Z(str);
            return this;
        }

        public a z(a.C0163a c0163a) {
            o();
            ((PreferencesProto$Value) this.f13448b).a0(c0163a);
            return this;
        }

        public a() {
            super(PreferencesProto$Value.DEFAULT_INSTANCE);
        }
    }

    static {
        PreferencesProto$Value preferencesProto$Value = new PreferencesProto$Value();
        DEFAULT_INSTANCE = preferencesProto$Value;
        GeneratedMessageLite.A(PreferencesProto$Value.class, preferencesProto$Value);
    }

    public static PreferencesProto$Value L() {
        return DEFAULT_INSTANCE;
    }

    public static a T() {
        return DEFAULT_INSTANCE.k();
    }

    public boolean K() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public double M() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public float N() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public int O() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public long P() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }

    public String Q() {
        return this.valueCase_ == 5 ? (String) this.value_ : "";
    }

    public androidx.datastore.preferences.a R() {
        return this.valueCase_ == 6 ? (androidx.datastore.preferences.a) this.value_ : androidx.datastore.preferences.a.G();
    }

    public ValueCase S() {
        return ValueCase.forNumber(this.valueCase_);
    }

    public final void U(boolean z10) {
        this.valueCase_ = 1;
        this.value_ = Boolean.valueOf(z10);
    }

    public final void V(double d10) {
        this.valueCase_ = 7;
        this.value_ = Double.valueOf(d10);
    }

    public final void W(float f10) {
        this.valueCase_ = 2;
        this.value_ = Float.valueOf(f10);
    }

    public final void X(int i10) {
        this.valueCase_ = 3;
        this.value_ = Integer.valueOf(i10);
    }

    public final void Y(long j10) {
        this.valueCase_ = 4;
        this.value_ = Long.valueOf(j10);
    }

    public final void Z(String str) {
        str.getClass();
        this.valueCase_ = 5;
        this.value_ = str;
    }

    public final void a0(a.C0163a c0163a) {
        this.value_ = c0163a.build();
        this.valueCase_ = 6;
    }

    @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
    public final Object o(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        T bVar;
        int i10 = c.f4259a[methodToInvoke.ordinal()];
        c cVar = null;
        switch (i10) {
            case 1:
                return new PreferencesProto$Value();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.x(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000", new Object[]{"value_", "valueCase_", "bitField0_", androidx.datastore.preferences.a.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                T<PreferencesProto$Value> t10 = PARSER;
                if (t10 != null) {
                    return t10;
                }
                synchronized (PreferencesProto$Value.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new GeneratedMessageLite.b(DEFAULT_INSTANCE);
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
