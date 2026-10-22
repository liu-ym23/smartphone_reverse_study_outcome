package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.j0;
import androidx.datastore.preferences.protobuf.q0;
import androidx.datastore.preferences.protobuf.r0;
import androidx.datastore.preferences.protobuf.t0;
import androidx.datastore.preferences.protobuf.u;
import androidx.datastore.preferences.protobuf.u0;
import androidx.datastore.preferences.protobuf.y;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends GeneratedMessageLite<c, a> implements j0 {
    private static final c DEFAULT_INSTANCE;
    private static volatile q0<c> PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private u.c<String> strings_ = t0.f1885d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends GeneratedMessageLite.a<c, a> implements j0 {
        public a() {
            super(c.DEFAULT_INSTANCE);
        }
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        GeneratedMessageLite.m(c.class, cVar);
    }

    public static void o(c cVar, Iterable iterable) {
        if (!cVar.strings_.S()) {
            u.c<String> cVar2 = cVar.strings_;
            int size = cVar2.size();
            cVar.strings_ = cVar2.c0(size == 0 ? 10 : size * 2);
        }
        List list = cVar.strings_;
        Charset charset = u.f1888a;
        if (iterable instanceof y) {
            List<?> listC = ((y) iterable).C();
            y yVar = (y) list;
            int size2 = list.size();
            for (Object obj : listC) {
                if (obj == null) {
                    String str = "Element at index " + (yVar.size() - size2) + " is null.";
                    for (int size3 = yVar.size() - 1; size3 >= size2; size3--) {
                        yVar.remove(size3);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof ByteString) {
                    yVar.g0((ByteString) obj);
                } else {
                    yVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof r0) {
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

    public static c p() {
        return DEFAULT_INSTANCE;
    }

    public static a r() {
        return (a) ((GeneratedMessageLite.a) DEFAULT_INSTANCE.i(GeneratedMessageLite.MethodToInvoke.f1744e));
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
                return new u0(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new c();
            case 4:
                return new a();
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q0<c> q0Var = PARSER;
                if (q0Var != null) {
                    return q0Var;
                }
                synchronized (c.class) {
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

    public final u.c q() {
        return this.strings_;
    }
}
