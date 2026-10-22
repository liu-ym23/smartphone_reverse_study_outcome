package androidx.datastore.preferences;

import androidx.datastore.preferences.c;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.j0;
import androidx.datastore.preferences.protobuf.q0;
import androidx.datastore.preferences.protobuf.u0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PreferencesProto$Value extends GeneratedMessageLite<PreferencesProto$Value, a> implements j0 {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    private static final PreferencesProto$Value DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile q0<PreferencesProto$Value> PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int bitField0_;
    private int valueCase_ = 0;
    private Object value_;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ValueCase {

        /* renamed from: a, reason: collision with root package name */
        public static final ValueCase f1694a;

        /* renamed from: b, reason: collision with root package name */
        public static final ValueCase f1695b;

        /* renamed from: c, reason: collision with root package name */
        public static final ValueCase f1696c;

        /* renamed from: d, reason: collision with root package name */
        public static final ValueCase f1697d;

        /* renamed from: e, reason: collision with root package name */
        public static final ValueCase f1698e;
        public static final ValueCase h;

        /* renamed from: j, reason: collision with root package name */
        public static final ValueCase f1699j;

        /* renamed from: k, reason: collision with root package name */
        public static final ValueCase f1700k;

        /* renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ ValueCase[] f1701l;

        static {
            ValueCase valueCase = new ValueCase("BOOLEAN", 0);
            f1694a = valueCase;
            ValueCase valueCase2 = new ValueCase("FLOAT", 1);
            f1695b = valueCase2;
            ValueCase valueCase3 = new ValueCase("INTEGER", 2);
            f1696c = valueCase3;
            ValueCase valueCase4 = new ValueCase("LONG", 3);
            f1697d = valueCase4;
            ValueCase valueCase5 = new ValueCase("STRING", 4);
            f1698e = valueCase5;
            ValueCase valueCase6 = new ValueCase("STRING_SET", 5);
            h = valueCase6;
            ValueCase valueCase7 = new ValueCase("DOUBLE", 6);
            f1699j = valueCase7;
            ValueCase valueCase8 = new ValueCase("VALUE_NOT_SET", 7);
            f1700k = valueCase8;
            f1701l = new ValueCase[]{valueCase, valueCase2, valueCase3, valueCase4, valueCase5, valueCase6, valueCase7, valueCase8};
        }

        public ValueCase() {
            throw null;
        }

        public static ValueCase valueOf(String str) {
            return (ValueCase) Enum.valueOf(ValueCase.class, str);
        }

        public static ValueCase[] values() {
            return (ValueCase[]) f1701l.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends GeneratedMessageLite.a<PreferencesProto$Value, a> implements j0 {
        public a() {
            super(PreferencesProto$Value.DEFAULT_INSTANCE);
        }
    }

    static {
        PreferencesProto$Value preferencesProto$Value = new PreferencesProto$Value();
        DEFAULT_INSTANCE = preferencesProto$Value;
        GeneratedMessageLite.m(PreferencesProto$Value.class, preferencesProto$Value);
    }

    public static a E() {
        return (a) ((GeneratedMessageLite.a) DEFAULT_INSTANCE.i(GeneratedMessageLite.MethodToInvoke.f1744e));
    }

    public static void n(PreferencesProto$Value preferencesProto$Value, long j10) {
        preferencesProto$Value.valueCase_ = 4;
        preferencesProto$Value.value_ = Long.valueOf(j10);
    }

    public static void o(PreferencesProto$Value preferencesProto$Value, String str) {
        preferencesProto$Value.getClass();
        preferencesProto$Value.valueCase_ = 5;
        preferencesProto$Value.value_ = str;
    }

    public static void p(PreferencesProto$Value preferencesProto$Value, c.a aVar) {
        preferencesProto$Value.getClass();
        preferencesProto$Value.value_ = aVar.g();
        preferencesProto$Value.valueCase_ = 6;
    }

    public static void q(PreferencesProto$Value preferencesProto$Value, double d8) {
        preferencesProto$Value.valueCase_ = 7;
        preferencesProto$Value.value_ = Double.valueOf(d8);
    }

    public static void s(PreferencesProto$Value preferencesProto$Value, boolean z) {
        preferencesProto$Value.valueCase_ = 1;
        preferencesProto$Value.value_ = Boolean.valueOf(z);
    }

    public static void t(PreferencesProto$Value preferencesProto$Value, float f8) {
        preferencesProto$Value.valueCase_ = 2;
        preferencesProto$Value.value_ = Float.valueOf(f8);
    }

    public static void u(PreferencesProto$Value preferencesProto$Value, int i10) {
        preferencesProto$Value.valueCase_ = 3;
        preferencesProto$Value.value_ = Integer.valueOf(i10);
    }

    public static PreferencesProto$Value w() {
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

    public final c C() {
        return this.valueCase_ == 6 ? (c) this.value_ : c.p();
    }

    public final ValueCase D() {
        switch (this.valueCase_) {
            case 0:
                return ValueCase.f1700k;
            case 1:
                return ValueCase.f1694a;
            case 2:
                return ValueCase.f1695b;
            case 3:
                return ValueCase.f1696c;
            case 4:
                return ValueCase.f1697d;
            case 5:
                return ValueCase.f1698e;
            case 6:
                return ValueCase.h;
            case 7:
                return ValueCase.f1699j;
            default:
                return null;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
    public final Object i(GeneratedMessageLite.MethodToInvoke methodToInvoke) {
        q0 bVar;
        switch (methodToInvoke.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new u0(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000", new Object[]{"value_", "valueCase_", "bitField0_", c.class});
            case 3:
                return new PreferencesProto$Value();
            case 4:
                return new a();
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q0<PreferencesProto$Value> q0Var = PARSER;
                if (q0Var != null) {
                    return q0Var;
                }
                synchronized (PreferencesProto$Value.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new GeneratedMessageLite.b();
                            PARSER = bVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return bVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final boolean v() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
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
