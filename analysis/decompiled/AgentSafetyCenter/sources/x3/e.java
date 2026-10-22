package x3;

import androidx.datastore.preferences.protobuf.c1;
import androidx.datastore.preferences.protobuf.i0;
import androidx.datastore.preferences.protobuf.j;
import androidx.datastore.preferences.protobuf.n;
import androidx.datastore.preferences.protobuf.r0;
import androidx.datastore.preferences.protobuf.t;
import androidx.datastore.preferences.protobuf.t0;
import androidx.datastore.preferences.protobuf.u;
import androidx.datastore.preferences.protobuf.v;
import androidx.datastore.preferences.protobuf.w0;
import androidx.datastore.preferences.protobuf.x;
import androidx.datastore.preferences.protobuf.z;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends v {
    private static final e DEFAULT_INSTANCE;
    private static volatile r0 PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private i0 preferences_ = i0.f1131f;

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        v.k(e.class, eVar);
    }

    public static i0 m(e eVar) {
        i0 i0Var = eVar.preferences_;
        if (!i0Var.f1132c) {
            eVar.preferences_ = i0Var.b();
        }
        return eVar.preferences_;
    }

    public static c o() {
        return (c) ((t) DEFAULT_INSTANCE.c(5));
    }

    public static e p(FileInputStream fileInputStream) {
        e eVar = DEFAULT_INSTANCE;
        androidx.datastore.preferences.protobuf.h hVar = new androidx.datastore.preferences.protobuf.h();
        hVar.f1127j = Reader.READ_DONE;
        Charset charset = x.f1218a;
        hVar.f1121c = fileInputStream;
        hVar.f1122d = new byte[4096];
        hVar.f1123e = 0;
        hVar.f1125g = 0;
        hVar.i = 0;
        VarHandle.storeStoreFence();
        n nVarA = n.a();
        v vVarJ = eVar.j();
        try {
            t0 t0Var = t0.f1207c;
            t0Var.getClass();
            w0 w0VarA = t0Var.a(vVarJ.getClass());
            w0VarA.e(vVarJ, j.b(hVar), nVarA);
            w0VarA.makeImmutable(vVarJ);
            if (v.f(vVarJ, true)) {
                return (e) vVarJ;
            }
            throw new z(new c1().getMessage());
        } catch (c1 e10) {
            throw new z(e10.getMessage());
        } catch (z e11) {
            if (e11.f1228c) {
                throw new z(e11.getMessage(), e11);
            }
            throw e11;
        } catch (IOException e12) {
            if (e12.getCause() instanceof z) {
                throw ((z) e12.getCause());
            }
            throw new z(e12.getMessage(), e12);
        } catch (RuntimeException e13) {
            if (e13.getCause() instanceof z) {
                throw ((z) e13.getCause());
            }
            throw e13;
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
                return v.i(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", d.f15573a});
            case 3:
                return new e();
            case 4:
                return new c(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                r0 r0Var = PARSER;
                if (r0Var != null) {
                    return r0Var;
                }
                synchronized (e.class) {
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
                b8.z.c();
                return null;
        }
    }

    public final Map n() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
