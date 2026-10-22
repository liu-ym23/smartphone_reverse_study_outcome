package x3;

import androidx.datastore.preferences.protobuf.b0;
import androidx.datastore.preferences.protobuf.r0;
import androidx.datastore.preferences.protobuf.s0;
import androidx.datastore.preferences.protobuf.t;
import androidx.datastore.preferences.protobuf.u;
import androidx.datastore.preferences.protobuf.u0;
import androidx.datastore.preferences.protobuf.v;
import androidx.datastore.preferences.protobuf.w;
import androidx.datastore.preferences.protobuf.x;
import b8.z;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends v {
    private static final g DEFAULT_INSTANCE;
    private static volatile r0 PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private w strings_ = u0.f1210h;

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        v.k(g.class, gVar);
    }

    public static void m(g gVar, Iterable iterable) {
        w wVar = gVar.strings_;
        if (!((u0) wVar).f1211c) {
            u0 u0Var = (u0) wVar;
            int i = u0Var.f1213g;
            gVar.strings_ = u0Var.c(i == 0 ? 10 : i * 2);
        }
        RandomAccess randomAccess = gVar.strings_;
        Charset charset = x.f1218a;
        if (iterable instanceof b0) {
            List underlyingElements = ((b0) iterable).getUnderlyingElements();
            if (randomAccess != null) {
                od.f.j();
                return;
            }
            ((u0) randomAccess).getClass();
            Iterator it = underlyingElements.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                if (next instanceof androidx.datastore.preferences.protobuf.f) {
                    throw null;
                }
                if (!(next instanceof byte[])) {
                    throw null;
                }
                byte[] bArr = (byte[]) next;
                androidx.datastore.preferences.protobuf.f.c(0, bArr.length, bArr);
                throw null;
            }
            return;
        }
        if (iterable instanceof s0) {
            ((u0) randomAccess).addAll((Collection) iterable);
            return;
        }
        if ((randomAccess instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) randomAccess).ensureCapacity(((Collection) iterable).size() + ((u0) randomAccess).f1213g);
        }
        u0 u0Var2 = (u0) randomAccess;
        int i3 = u0Var2.f1213g;
        for (Object obj : iterable) {
            if (obj == null) {
                String str = "Element at index " + (u0Var2.f1213g - i3) + " is null.";
                for (int i10 = u0Var2.f1213g - 1; i10 >= i3; i10--) {
                    u0Var2.remove(i10);
                }
                g5.f.g(str);
                return;
            }
            u0Var2.add(obj);
        }
    }

    public static g n() {
        return DEFAULT_INSTANCE;
    }

    public static f p() {
        return (f) ((t) DEFAULT_INSTANCE.c(5));
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
                return v.i(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new g();
            case 4:
                return new f(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                r0 r0Var = PARSER;
                if (r0Var != null) {
                    return r0Var;
                }
                synchronized (g.class) {
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
                z.c();
                return null;
        }
    }

    public final w o() {
        return this.strings_;
    }
}
