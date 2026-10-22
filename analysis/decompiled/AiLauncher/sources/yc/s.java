package yc;

import android.annotation.TargetApi;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* loaded from: classes5.dex */
public class s {

    @TargetApi(24)
    @IgnoreJRERequirement
    public static final class a extends s {
        @Override // yc.s
        public Object b(Method method, Class<?> cls, Object obj, Object[] objArr) throws Throwable {
            return l.a(method, cls, obj, objArr);
        }

        @Override // yc.s
        public boolean c(Method method) {
            return method.isDefault();
        }
    }

    @IgnoreJRERequirement
    public static class b extends s {
        @Override // yc.s
        public String a(Method method, int i10) {
            Parameter parameter = method.getParameters()[i10];
            if (!parameter.isNamePresent()) {
                return super.a(method, i10);
            }
            return "parameter '" + parameter.getName() + '\'';
        }

        @Override // yc.s
        public Object b(Method method, Class<?> cls, Object obj, Object[] objArr) throws Throwable {
            return l.a(method, cls, obj, objArr);
        }

        @Override // yc.s
        public boolean c(Method method) {
            return method.isDefault();
        }
    }

    public String a(Method method, int i10) {
        return "parameter #" + (i10 + 1);
    }

    public Object b(Method method, Class<?> cls, Object obj, Object[] objArr) throws Throwable {
        throw new AssertionError();
    }

    public boolean c(Method method) {
        return false;
    }
}
