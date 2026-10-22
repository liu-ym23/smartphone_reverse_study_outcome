package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes4.dex */
final class SignatureSerializer {
    public static final SignatureSerializer INSTANCE = null;

    static {
        INSTANCE = new SignatureSerializer();
    }

    private SignatureSerializer() {
    }

    public final String methodDesc(Method r6) {
        Intrinsics.checkNotNullParameter(r6, "method");
        StringBuilder r5 = new StringBuilder("(");
        Class<?>[] r0 = r6.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r0, "method.parameterTypes");
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Class<?> r3 = r0[r2];
        Intrinsics.checkNotNullExpressionValue(r3, "parameterType");
        r5.append(ReflectClassUtilKt.getDesc(r3));
        r2 = r2 + 1;
        goto L3
    L5:
        r5.append(")");
        Class<?> r7 = r6.getReturnType();
        Intrinsics.checkNotNullExpressionValue(r7, "method.returnType");
        r5.append(ReflectClassUtilKt.getDesc(r7));
        String r8 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r8, "sb.toString()");
        return r8;
    }

    public final String constructorDesc(Constructor<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "constructor");
        StringBuilder r4 = new StringBuilder("(");
        Class<?>[] r6 = r5.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r6, "constructor.parameterTypes");
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Class<?> r2 = r6[r1];
        Intrinsics.checkNotNullExpressionValue(r2, "parameterType");
        r4.append(ReflectClassUtilKt.getDesc(r2));
        r1 = r1 + 1;
        goto L3
    L5:
        r4.append(")V");
        String r7 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "sb.toString()");
        return r7;
    }

    public final String fieldDesc(Field r1) {
        Intrinsics.checkNotNullParameter(r1, "field");
        Class<?> r0 = r1.getType();
        Intrinsics.checkNotNullExpressionValue(r0, "field.type");
        return ReflectClassUtilKt.getDesc(r0);
    }
}
