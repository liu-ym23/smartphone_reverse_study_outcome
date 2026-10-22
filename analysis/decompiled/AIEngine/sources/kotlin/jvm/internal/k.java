package kotlin.jvm.internal;

import java.util.List;
import java.util.Map;
import zb.l;
import zb.m;
import zb.n;
import zb.o;
import zb.p;
import zb.q;
import zb.r;
import zb.s;
import zb.t;
import zb.u;
import zb.v;
import zb.w;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k {
    public static List a(Object obj) {
        if ((obj instanceof ac.a) && !(obj instanceof ac.c)) {
            e(obj, "kotlin.collections.MutableList");
            throw null;
        }
        try {
            return (List) obj;
        } catch (ClassCastException e10) {
            g.j(e10, k.class.getName());
            throw e10;
        }
    }

    public static Map b(Object obj) {
        if ((obj instanceof ac.a) && !(obj instanceof ac.d)) {
            e(obj, "kotlin.collections.MutableMap");
            throw null;
        }
        try {
            return (Map) obj;
        } catch (ClassCastException e10) {
            g.j(e10, k.class.getName());
            throw e10;
        }
    }

    public static void c(int i10, Object obj) {
        if (obj == null || d(i10, obj)) {
            return;
        }
        e(obj, "kotlin.jvm.functions.Function" + i10);
        throw null;
    }

    public static boolean d(int i10, Object obj) {
        if (obj instanceof lb.c) {
            if ((obj instanceof f ? ((f) obj).getArity() : obj instanceof zb.a ? 0 : obj instanceof l ? 1 : obj instanceof p ? 2 : obj instanceof q ? 3 : obj instanceof r ? 4 : obj instanceof s ? 5 : obj instanceof t ? 6 : obj instanceof u ? 7 : obj instanceof v ? 8 : obj instanceof w ? 9 : obj instanceof zb.b ? 10 : obj instanceof zb.c ? 11 : obj instanceof zb.d ? 12 : obj instanceof zb.e ? 13 : obj instanceof zb.f ? 14 : obj instanceof zb.g ? 15 : obj instanceof zb.h ? 16 : obj instanceof zb.i ? 17 : obj instanceof zb.j ? 18 : obj instanceof zb.k ? 19 : obj instanceof m ? 20 : obj instanceof n ? 21 : obj instanceof o ? 22 : -1) == i10) {
                return true;
            }
        }
        return false;
    }

    public static void e(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(com.stepos.core.ota.d.i(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        g.j(classCastException, k.class.getName());
        throw classCastException;
    }
}
