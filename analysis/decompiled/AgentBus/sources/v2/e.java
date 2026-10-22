package v2;

import androidx.datastore.preferences.protobuf.a0;
import androidx.datastore.preferences.protobuf.i1;
import androidx.datastore.preferences.protobuf.k;
import androidx.datastore.preferences.protobuf.l0;
import androidx.datastore.preferences.protobuf.o;
import androidx.datastore.preferences.protobuf.u;
import androidx.datastore.preferences.protobuf.u0;
import androidx.datastore.preferences.protobuf.v;
import androidx.datastore.preferences.protobuf.w;
import androidx.datastore.preferences.protobuf.w0;
import androidx.datastore.preferences.protobuf.y0;
import androidx.datastore.preferences.protobuf.z0;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class e extends w {
    private static final e DEFAULT_INSTANCE;
    private static volatile u0 PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private l0 preferences_ = l0.f898g;

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        w.j(e.class, eVar);
    }

    public static l0 l(e eVar) {
        l0 l0Var = eVar.preferences_;
        if (!l0Var.f899f) {
            eVar.preferences_ = l0Var.b();
        }
        return eVar.preferences_;
    }

    public static c n() {
        return (c) ((u) DEFAULT_INSTANCE.c(5));
    }

    public static e o(InputStream inputStream) {
        e eVar = DEFAULT_INSTANCE;
        androidx.datastore.preferences.protobuf.i iVar = new androidx.datastore.preferences.protobuf.i(inputStream);
        o oVarA = o.a();
        w wVarI = eVar.i();
        try {
            w0 w0Var = w0.f962c;
            w0Var.getClass();
            z0 z0VarA = w0Var.a(wVarI.getClass());
            k kVar = (k) iVar.f882b;
            if (kVar == null) {
                kVar = new k(iVar);
            }
            z0VarA.h(wVarI, kVar, oVarA);
            z0VarA.b(wVarI);
            if (w.f(wVarI, true)) {
                return (e) wVarI;
            }
            throw new a0(new i1().getMessage());
        } catch (a0 e10) {
            if (e10.f794f) {
                throw new a0(e10.getMessage(), e10);
            }
            throw e10;
        } catch (i1 e11) {
            throw new a0(e11.getMessage());
        } catch (IOException e12) {
            if (e12.getCause() instanceof a0) {
                throw ((a0) e12.getCause());
            }
            throw new a0(e12.getMessage(), e12);
        } catch (RuntimeException e13) {
            if (e13.getCause() instanceof a0) {
                throw ((a0) e13.getCause());
            }
            throw e13;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.w
    public final Object c(int i2) {
        u0 vVar;
        switch (n.f.d(i2)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new y0(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", d.f10383a});
            case 3:
                return new e();
            case 4:
                return new c(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                u0 u0Var = PARSER;
                if (u0Var != null) {
                    return u0Var;
                }
                synchronized (e.class) {
                    try {
                        vVar = PARSER;
                        if (vVar == null) {
                            vVar = new v();
                            PARSER = vVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return vVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final Map m() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
