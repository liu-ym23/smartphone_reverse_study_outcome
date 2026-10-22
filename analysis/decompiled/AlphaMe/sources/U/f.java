package U;

import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.AbstractC0277y;
import androidx.datastore.preferences.protobuf.C0254e0;
import androidx.datastore.preferences.protobuf.C0258g0;
import androidx.datastore.preferences.protobuf.C0263j;
import androidx.datastore.preferences.protobuf.C0265l;
import androidx.datastore.preferences.protobuf.C0278z;
import androidx.datastore.preferences.protobuf.F;
import androidx.datastore.preferences.protobuf.InterfaceC0250c0;
import androidx.datastore.preferences.protobuf.InterfaceC0262i0;
import androidx.datastore.preferences.protobuf.S;
import androidx.datastore.preferences.protobuf.p0;
import androidx.datastore.preferences.protobuf.r;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class f extends A {
    private static final f DEFAULT_INSTANCE;
    private static volatile InterfaceC0250c0 PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private S preferences_ = S.f3437b;

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        A.h(f.class, fVar);
    }

    public static S i(f fVar) {
        S s4 = fVar.preferences_;
        if (!s4.f3438a) {
            fVar.preferences_ = s4.b();
        }
        return fVar.preferences_;
    }

    public static d k() {
        return (d) ((AbstractC0277y) DEFAULT_INSTANCE.d(5));
    }

    public static f l(FileInputStream fileInputStream) {
        f fVar = DEFAULT_INSTANCE;
        C0263j c0263j = new C0263j(fileInputStream);
        r rVarA = r.a();
        A a4 = (A) fVar.d(4);
        try {
            C0254e0 c0254e0 = C0254e0.f3467c;
            c0254e0.getClass();
            InterfaceC0262i0 interfaceC0262i0A = c0254e0.a(a4.getClass());
            C0265l c0265l = c0263j.f3499d;
            if (c0265l == null) {
                c0265l = new C0265l(c0263j);
            }
            interfaceC0262i0A.a(a4, c0265l, rVarA);
            interfaceC0262i0A.d(a4);
            if (a4.g()) {
                return (f) a4;
            }
            throw new F(new p0().getMessage());
        } catch (IOException e4) {
            if (e4.getCause() instanceof F) {
                throw ((F) e4.getCause());
            }
            throw new F(e4.getMessage());
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof F) {
                throw ((F) e5.getCause());
            }
            throw e5;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.A
    public final Object d(int i4) {
        switch (t.h.a(i4)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new C0258g0(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", e.f1884a});
            case 3:
                return new f();
            case 4:
                return new d(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0250c0 c0278z = PARSER;
                if (c0278z == null) {
                    synchronized (f.class) {
                        try {
                            c0278z = PARSER;
                            if (c0278z == null) {
                                c0278z = new C0278z();
                                PARSER = c0278z;
                            }
                        } finally {
                        }
                    }
                }
                return c0278z;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final Map j() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
