package z9;

import K9.C0925f;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Method;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ljava/lang/reflect/Method;", "", Const.INTENT_KEY_UMID, "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "signature", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Z0 {
    public static final CharSequence a(Class cls) {
        kotlin.jvm.internal.p.f(cls);
        return C0925f.f(cls);
    }

    public static final String d(Method method) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        kotlin.jvm.internal.p.h(parameterTypes, "getParameterTypes(...)");
        sb2.append(Z8.r.w0(parameterTypes, "", "(", ")", 0, null, Y0.f45335a, 24, null));
        Class<?> returnType = method.getReturnType();
        kotlin.jvm.internal.p.h(returnType, "getReturnType(...)");
        sb2.append(C0925f.f(returnType));
        return sb2.toString();
    }
}
