package l0;

import androidx.datastore.preferences.protobuf.a1;
import androidx.datastore.preferences.protobuf.h0;
import androidx.datastore.preferences.protobuf.n;
import androidx.datastore.preferences.protobuf.q0;
import androidx.datastore.preferences.protobuf.r0;
import androidx.datastore.preferences.protobuf.t;
import androidx.datastore.preferences.protobuf.t0;
import androidx.datastore.preferences.protobuf.u;
import androidx.datastore.preferences.protobuf.u0;
import androidx.datastore.preferences.protobuf.v;
import androidx.datastore.preferences.protobuf.z;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends v {
    private static final f DEFAULT_INSTANCE;
    private static volatile q0 PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private h0 preferences_ = h0.f484b;

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        v.j(f.class, fVar);
    }

    public static h0 l(f fVar) {
        h0 h0Var = fVar.preferences_;
        if (!h0Var.f485a) {
            fVar.preferences_ = h0Var.b();
        }
        return fVar.preferences_;
    }

    public static d n() {
        return (d) ((t) DEFAULT_INSTANCE.c(5));
    }

    public static f o(FileInputStream fileInputStream) {
        f fVar = DEFAULT_INSTANCE;
        androidx.datastore.preferences.protobuf.i iVar = new androidx.datastore.preferences.protobuf.i(fileInputStream);
        n nVarA = n.a();
        v vVarI = fVar.i();
        try {
            r0 r0Var = r0.f559c;
            r0Var.getClass();
            u0 u0VarA = r0Var.a(vVarI.getClass());
            androidx.datastore.preferences.protobuf.j jVar = (androidx.datastore.preferences.protobuf.j) iVar.f86b;
            if (jVar == null) {
                jVar = new androidx.datastore.preferences.protobuf.j(iVar);
            }
            u0VarA.h(vVarI, jVar, nVarA);
            u0VarA.b(vVarI);
            if (v.f(vVarI, true)) {
                return (f) vVarI;
            }
            throw new z(new a1().getMessage());
        } catch (a1 e9) {
            throw new z(e9.getMessage());
        } catch (z e10) {
            if (e10.f587a) {
                throw new z(e10.getMessage(), e10);
            }
            throw e10;
        } catch (IOException e11) {
            if (e11.getCause() instanceof z) {
                throw ((z) e11.getCause());
            }
            throw new z(e11.getMessage(), e11);
        } catch (RuntimeException e12) {
            if (e12.getCause() instanceof z) {
                throw ((z) e12.getCause());
            }
            throw e12;
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
                return new t0(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", e.f3732a});
            case 3:
                return new f();
            case 4:
                return new d(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q0 q0Var = PARSER;
                if (q0Var != null) {
                    return q0Var;
                }
                synchronized (f.class) {
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

    public final Map m() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
