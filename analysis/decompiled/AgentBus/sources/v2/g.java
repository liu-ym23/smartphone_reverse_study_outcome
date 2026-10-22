package v2;

import androidx.datastore.preferences.protobuf.d0;
import androidx.datastore.preferences.protobuf.u;
import androidx.datastore.preferences.protobuf.u0;
import androidx.datastore.preferences.protobuf.v;
import androidx.datastore.preferences.protobuf.v0;
import androidx.datastore.preferences.protobuf.w;
import androidx.datastore.preferences.protobuf.x;
import androidx.datastore.preferences.protobuf.x0;
import androidx.datastore.preferences.protobuf.y;
import androidx.datastore.preferences.protobuf.y0;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final class g extends w {
    private static final g DEFAULT_INSTANCE;
    private static volatile u0 PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private x strings_ = x0.f965i;

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        w.j(g.class, gVar);
    }

    public static void l(g gVar, Iterable iterable) {
        x xVar = gVar.strings_;
        if (!((androidx.datastore.preferences.protobuf.b) xVar).f805f) {
            int size = xVar.size();
            gVar.strings_ = xVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
        }
        List list = gVar.strings_;
        Charset charset = y.f968a;
        if (iterable instanceof d0) {
            List underlyingElements = ((d0) iterable).getUnderlyingElements();
            d0 d0Var = (d0) list;
            int size2 = list.size();
            for (Object obj : underlyingElements) {
                if (obj == null) {
                    String str = "Element at index " + (d0Var.size() - size2) + " is null.";
                    for (int size3 = d0Var.size() - 1; size3 >= size2; size3--) {
                        d0Var.remove(size3);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof androidx.datastore.preferences.protobuf.g) {
                    d0Var.d((androidx.datastore.preferences.protobuf.g) obj);
                } else {
                    d0Var.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof v0) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
        }
        int size4 = list.size();
        for (Object obj2 : iterable) {
            if (obj2 == null) {
                String str2 = "Element at index " + (list.size() - size4) + " is null.";
                for (int size5 = list.size() - 1; size5 >= size4; size5--) {
                    list.remove(size5);
                }
                throw new NullPointerException(str2);
            }
            list.add(obj2);
        }
    }

    public static g m() {
        return DEFAULT_INSTANCE;
    }

    public static f o() {
        return (f) ((u) DEFAULT_INSTANCE.c(5));
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
                return new y0(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new g();
            case 4:
                return new f(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                u0 u0Var = PARSER;
                if (u0Var != null) {
                    return u0Var;
                }
                synchronized (g.class) {
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

    public final x n() {
        return this.strings_;
    }
}
