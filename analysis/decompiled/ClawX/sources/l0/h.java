package l0;

import androidx.datastore.preferences.protobuf.q0;
import androidx.datastore.preferences.protobuf.s0;
import androidx.datastore.preferences.protobuf.t;
import androidx.datastore.preferences.protobuf.t0;
import androidx.datastore.preferences.protobuf.u;
import androidx.datastore.preferences.protobuf.v;
import androidx.datastore.preferences.protobuf.w;
import androidx.datastore.preferences.protobuf.x;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.Set;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends v {
    private static final h DEFAULT_INSTANCE;
    private static volatile q0 PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private w strings_ = s0.d;

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        v.j(h.class, hVar);
    }

    public static void l(h hVar, Set set) {
        w wVar = hVar.strings_;
        if (!((androidx.datastore.preferences.protobuf.b) wVar).f450a) {
            s0 s0Var = (s0) wVar;
            int i8 = s0Var.f565c;
            hVar.strings_ = s0Var.h(i8 == 0 ? 10 : i8 * 2);
        }
        RandomAccess randomAccess = hVar.strings_;
        Charset charset = x.f579a;
        if (randomAccess instanceof ArrayList) {
            ((ArrayList) randomAccess).ensureCapacity(set.size() + ((s0) randomAccess).f565c);
        }
        s0 s0Var2 = (s0) randomAccess;
        int i9 = s0Var2.f565c;
        for (Object obj : set) {
            if (obj == null) {
                String str = "Element at index " + (s0Var2.f565c - i9) + " is null.";
                for (int i10 = s0Var2.f565c - 1; i10 >= i9; i10--) {
                    s0Var2.remove(i10);
                }
                throw new NullPointerException(str);
            }
            s0Var2.add(obj);
        }
    }

    public static h m() {
        return DEFAULT_INSTANCE;
    }

    public static g o() {
        return (g) ((t) DEFAULT_INSTANCE.c(5));
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
                return new t0(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new h();
            case 4:
                return new g(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q0 q0Var = PARSER;
                if (q0Var != null) {
                    return q0Var;
                }
                synchronized (h.class) {
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

    public final w n() {
        return this.strings_;
    }
}
