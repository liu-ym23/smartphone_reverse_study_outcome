package g9;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Ljava/lang/StackTraceElement;", "c", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)Ljava/lang/StackTraceElement;", "Lg9/d;", Const.INTENT_KEY_APIKEY, "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)Lg9/d;", "", Const.INTENT_KEY_PKGNAME, "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)I", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class e {
    public static final InterfaceC4112d a(BaseContinuationImpl baseContinuationImpl) {
        return (InterfaceC4112d) baseContinuationImpl.getClass().getAnnotation(InterfaceC4112d.class);
    }

    public static final int b(BaseContinuationImpl baseContinuationImpl) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement c(BaseContinuationImpl baseContinuationImpl) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        String strC;
        p.i(baseContinuationImpl, "<this>");
        InterfaceC4112d interfaceC4112dA = a(baseContinuationImpl);
        if (interfaceC4112dA == null || interfaceC4112dA.v() < 1) {
            return null;
        }
        int iB = b(baseContinuationImpl);
        int i10 = iB < 0 ? -1 : interfaceC4112dA.l()[iB];
        String strB = g.f32707a.b(baseContinuationImpl);
        if (strB == null) {
            strC = interfaceC4112dA.c();
        } else {
            strC = strB + JsonPointer.SEPARATOR + interfaceC4112dA.c();
        }
        return new StackTraceElement(strC, interfaceC4112dA.m(), interfaceC4112dA.f(), i10);
    }
}
