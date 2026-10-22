package kotlin.reflect.jvm.internal.impl.utils;

import Ia.c;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;

/* loaded from: classes5.dex */
public class WrappedValues {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f36106a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f36107b = false;

    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable th) {
            super("Rethrow stored exception", th);
        }
    }

    public static class a {
        public String toString() {
            return "NULL_VALUE";
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f36108a;

        public /* synthetic */ b(Throwable th, a aVar) {
            this(th);
        }

        public static /* synthetic */ void a(int i10) {
            String str = i10 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 1 ? 3 : 2];
            if (i10 != 1) {
                objArr[0] = "throwable";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            }
            if (i10 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            } else {
                objArr[1] = "getThrowable";
            }
            if (i10 != 1) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 1) {
                throw new IllegalStateException(str2);
            }
        }

        public Throwable b() {
            Throwable th = this.f36108a;
            if (th == null) {
                a(1);
            }
            return th;
        }

        public String toString() {
            return this.f36108a.toString();
        }

        public b(Throwable th) {
            if (th == null) {
                a(0);
            }
            this.f36108a = th;
        }
    }

    public static /* synthetic */ void a(int i10) {
        String str = (i10 == 1 || i10 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 1 || i10 == 2) ? 2 : 3];
        if (i10 == 1 || i10 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        } else if (i10 != 3) {
            objArr[0] = UxipConstants.f30680s;
        } else {
            objArr[0] = "throwable";
        }
        if (i10 == 1 || i10 == 2) {
            objArr[1] = "escapeNull";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        }
        if (i10 != 1 && i10 != 2) {
            if (i10 == 3) {
                objArr[2] = "escapeThrowable";
            } else if (i10 != 4) {
                objArr[2] = "unescapeNull";
            } else {
                objArr[2] = "unescapeExceptionOrNull";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static <V> Object b(V v10) {
        if (v10 == null && (v10 = (V) f36106a) == null) {
            a(1);
        }
        return v10;
    }

    public static Object c(Throwable th) {
        if (th == null) {
            a(3);
        }
        return new b(th, null);
    }

    public static <V> V d(Object obj) {
        if (obj == null) {
            a(4);
        }
        return (V) e(f(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V e(Object obj) {
        if (obj == 0) {
            a(0);
        }
        if (obj == f36106a) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V f(Object obj) {
        if (!(obj instanceof b)) {
            return obj;
        }
        Throwable thB = ((b) obj).b();
        if (f36107b && c.a(thB)) {
            throw new WrappedProcessCanceledException(thB);
        }
        throw c.b(thB);
    }
}
