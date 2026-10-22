package kotlin.jvm.internal;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class d0 {
    public static void a(int i8, Object obj) {
        if (obj == null || b(i8, obj)) {
            return;
        }
        d(obj, "kotlin.jvm.functions.Function" + i8);
        throw null;
    }

    public static boolean b(int i8, Object obj) {
        if (obj instanceof b5.d) {
            if ((obj instanceof l ? ((l) obj).getArity() : obj instanceof p5.a ? 0 : obj instanceof p5.l ? 1 : obj instanceof p5.p ? 2 : obj instanceof p5.q ? 3 : obj instanceof p5.s ? 5 : -1) == i8) {
                return true;
            }
        }
        return false;
    }

    public static final b5.o c(Object[] array) {
        p.e(array, "array");
        return new b5.o(array);
    }

    public static void d(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(a8.b.o(obj == null ? AbstractJsonLexerKt.NULL : obj.getClass().getName(), " cannot be cast to ", str));
        p.j(classCastException, d0.class.getName());
        throw classCastException;
    }
}
