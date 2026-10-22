package U;

import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.AbstractC0249c;
import androidx.datastore.preferences.protobuf.AbstractC0259h;
import androidx.datastore.preferences.protobuf.AbstractC0277y;
import androidx.datastore.preferences.protobuf.C;
import androidx.datastore.preferences.protobuf.C0256f0;
import androidx.datastore.preferences.protobuf.C0258g0;
import androidx.datastore.preferences.protobuf.C0278z;
import androidx.datastore.preferences.protobuf.D;
import androidx.datastore.preferences.protobuf.I;
import androidx.datastore.preferences.protobuf.InterfaceC0250c0;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class h extends A {
    private static final h DEFAULT_INSTANCE;
    private static volatile InterfaceC0250c0 PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private C strings_ = C0256f0.f3473d;

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        A.h(h.class, hVar);
    }

    public static void i(h hVar, Set set) {
        C c4 = hVar.strings_;
        if (!((AbstractC0249c) c4).f3464a) {
            int size = c4.size();
            hVar.strings_ = c4.b(size == 0 ? 10 : size * 2);
        }
        List list = hVar.strings_;
        Charset charset = D.f3396a;
        set.getClass();
        if (!(set instanceof I)) {
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(set.size() + list.size());
            }
            int size2 = list.size();
            for (Object obj : set) {
                if (obj == null) {
                    String str = "Element at index " + (list.size() - size2) + " is null.";
                    for (int size3 = list.size() - 1; size3 >= size2; size3--) {
                        list.remove(size3);
                    }
                    throw new NullPointerException(str);
                }
                list.add(obj);
            }
            return;
        }
        List listN = ((I) set).n();
        I i4 = (I) list;
        int size4 = list.size();
        for (Object obj2 : listN) {
            if (obj2 == null) {
                String str2 = "Element at index " + (i4.size() - size4) + " is null.";
                for (int size5 = i4.size() - 1; size5 >= size4; size5--) {
                    i4.remove(size5);
                }
                throw new NullPointerException(str2);
            }
            if (obj2 instanceof AbstractC0259h) {
                i4.l((AbstractC0259h) obj2);
            } else {
                i4.add((String) obj2);
            }
        }
    }

    public static h j() {
        return DEFAULT_INSTANCE;
    }

    public static g l() {
        return (g) ((AbstractC0277y) DEFAULT_INSTANCE.d(5));
    }

    @Override // androidx.datastore.preferences.protobuf.A
    public final Object d(int i4) {
        switch (t.h.a(i4)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new C0258g0(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new h();
            case 4:
                return new g(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0250c0 c0278z = PARSER;
                if (c0278z == null) {
                    synchronized (h.class) {
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

    public final C k() {
        return this.strings_;
    }
}
