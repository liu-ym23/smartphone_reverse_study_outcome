package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import p9.InterfaceC5063a;

/* loaded from: classes5.dex */
public class u {

    public static class a<T> extends b<T> implements InterfaceC5063a<T> {

        /* renamed from: b, reason: collision with root package name */
        public final InterfaceC5063a<T> f36165b;

        /* renamed from: c, reason: collision with root package name */
        public volatile SoftReference<Object> f36166c;

        public a(T t10, InterfaceC5063a<T> interfaceC5063a) {
            if (interfaceC5063a == null) {
                d(0);
            }
            this.f36166c = null;
            this.f36165b = interfaceC5063a;
            if (t10 != null) {
                this.f36166c = new SoftReference<>(a(t10));
            }
        }

        public static /* synthetic */ void d(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        @Override // kotlin.reflect.jvm.internal.u.b, p9.InterfaceC5063a
        public T invoke() {
            Object obj;
            SoftReference<Object> softReference = this.f36166c;
            if (softReference != null && (obj = softReference.get()) != null) {
                return c(obj);
            }
            T tInvoke = this.f36165b.invoke();
            this.f36166c = new SoftReference<>(a(tInvoke));
            return tInvoke;
        }
    }

    public static abstract class b<T> {

        /* renamed from: a, reason: collision with root package name */
        public static final Object f36167a = new a();

        public static class a {
        }

        public Object a(T t10) {
            return t10 == null ? f36167a : t10;
        }

        public final T b(Object obj, Object obj2) {
            return invoke();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T c(Object obj) {
            if (obj == f36167a) {
                return null;
            }
            return obj;
        }

        public abstract T invoke();
    }

    public static /* synthetic */ void a(int i10) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"));
    }

    public static <T> a<T> b(T t10, InterfaceC5063a<T> interfaceC5063a) {
        if (interfaceC5063a == null) {
            a(0);
        }
        return new a<>(t10, interfaceC5063a);
    }

    public static <T> a<T> c(InterfaceC5063a<T> interfaceC5063a) {
        if (interfaceC5063a == null) {
            a(1);
        }
        return b(null, interfaceC5063a);
    }
}
