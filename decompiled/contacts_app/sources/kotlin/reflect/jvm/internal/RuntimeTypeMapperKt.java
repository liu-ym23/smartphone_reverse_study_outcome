package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class RuntimeTypeMapperKt {
    public static final /* synthetic */ String access$getSignature(Method r0) {
        return getSignature(r0);
    }

    private static final String getSignature(Method r12) {
        StringBuilder r0 = new StringBuilder().append(r12.getName());
        Class<?>[] r1 = r12.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r1, "parameterTypes");
        StringBuilder r2 = r0.append(ArraysKt.joinToString$default(r1, "", "(", ")", 0, null, RuntimeTypeMapperKt$signature$1.INSTANCE, 24, null));
        Class<?> r13 = r12.getReturnType();
        Intrinsics.checkNotNullExpressionValue(r13, "returnType");
        return r2.append(ReflectClassUtilKt.getDesc(r13)).toString();
    }
}
