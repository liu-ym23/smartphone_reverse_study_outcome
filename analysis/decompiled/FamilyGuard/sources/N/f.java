package N;

import androidx.datastore.preferences.protobuf.AbstractC0504y;
import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.L;
import androidx.datastore.preferences.protobuf.T;
import androidx.datastore.preferences.protobuf.a0;
import androidx.datastore.preferences.protobuf.u0;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class f extends AbstractC0504y<f, a> implements T {
    private static final f DEFAULT_INSTANCE;
    private static volatile a0<f> PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private L<String, h> preferences_ = L.g();

    public static final class a extends AbstractC0504y.a<f, a> implements T {
        /* synthetic */ a(e eVar) {
            this();
        }

        public a B(String str, h hVar) {
            str.getClass();
            hVar.getClass();
            w();
            ((f) this.f10264b).M().put(str, hVar);
            return this;
        }

        private a() {
            super(f.DEFAULT_INSTANCE);
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final K<String, h> f4172a = K.d(u0.b.f10165k, BuildConfig.FLAVOR, u0.b.f10167m, h.T());
    }

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        AbstractC0504y.I(f.class, fVar);
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, h> M() {
        return O();
    }

    private L<String, h> O() {
        if (!this.preferences_.k()) {
            this.preferences_ = this.preferences_.p();
        }
        return this.preferences_;
    }

    private L<String, h> P() {
        return this.preferences_;
    }

    public static a Q() {
        return DEFAULT_INSTANCE.t();
    }

    public static f R(InputStream inputStream) {
        return (f) AbstractC0504y.G(DEFAULT_INSTANCE, inputStream);
    }

    public Map<String, h> N() {
        return Collections.unmodifiableMap(P());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0504y
    protected final Object w(AbstractC0504y.f fVar, Object obj, Object obj2) {
        a0 bVar;
        int i5 = e.f4171a[fVar.ordinal()];
        e eVar = null;
        switch (i5) {
            case 1:
                return new f();
            case 2:
                return new a(eVar);
            case 3:
                return AbstractC0504y.F(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.f4172a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                a0<f> a0Var = PARSER;
                if (a0Var != null) {
                    return a0Var;
                }
                synchronized (f.class) {
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
