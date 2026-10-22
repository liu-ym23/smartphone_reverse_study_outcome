package L0;

import androidx.datastore.preferences.PreferencesProto$Value;
import androidx.datastore.preferences.protobuf.E;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.L;
import androidx.datastore.preferences.protobuf.MapFieldLite;
import androidx.datastore.preferences.protobuf.T;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class d extends GeneratedMessageLite<d, a> implements L {
    private static final d DEFAULT_INSTANCE;
    private static volatile T<d> PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private MapFieldLite<String, PreferencesProto$Value> preferences_ = MapFieldLite.i();

    public static final class a extends GeneratedMessageLite.a<d, a> implements L {
        public /* synthetic */ a(c cVar) {
            this();
        }

        public a t(String str, PreferencesProto$Value preferencesProto$Value) {
            str.getClass();
            preferencesProto$Value.getClass();
            o();
            ((d) this.f13448b).E().put(str, preferencesProto$Value);
            return this;
        }

        public a() {
            super(d.DEFAULT_INSTANCE);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final E<String, PreferencesProto$Value> f4260a = E.d(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, PreferencesProto$Value.L());
    }

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        GeneratedMessageLite.A(d.class, dVar);
    }

    public static a I() {
        return DEFAULT_INSTANCE.k();
    }

    public static d J(InputStream inputStream) throws IOException {
        return (d) GeneratedMessageLite.y(DEFAULT_INSTANCE, inputStream);
    }

    public final Map<String, PreferencesProto$Value> E() {
        return G();
    }

    public Map<String, PreferencesProto$Value> F() {
        return Collections.unmodifiableMap(H());
    }

    public final MapFieldLite<String, PreferencesProto$Value> G() {
        if (!this.preferences_.s()) {
            this.preferences_ = this.preferences_.v();
        }
        return this.preferences_;
    }

    public final MapFieldLite<String, PreferencesProto$Value> H() {
        return this.preferences_;
    }

    @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
    public final Object o(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        T bVar;
        int i10 = c.f4259a[methodToInvoke.ordinal()];
        c cVar = null;
        switch (i10) {
            case 1:
                return new d();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.x(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.f4260a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                T<d> t10 = PARSER;
                if (t10 != null) {
                    return t10;
                }
                synchronized (d.class) {
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
