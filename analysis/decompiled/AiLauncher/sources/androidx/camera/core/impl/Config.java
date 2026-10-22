package androidx.camera.core.impl;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public interface Config {

    public enum OptionPriority {
        ALWAYS_OVERRIDE,
        HIGH_PRIORITY_REQUIRED,
        REQUIRED,
        OPTIONAL
    }

    public static abstract class a<T> {
        public static <T> a<T> a(String str, Class<?> cls) {
            return b(str, cls, null);
        }

        public static <T> a<T> b(String str, Class<?> cls, Object obj) {
            return new d(str, cls, obj);
        }

        public abstract String c();

        public abstract Object d();

        public abstract Class<T> e();
    }

    public interface b {
        boolean a(a<?> aVar);
    }

    static boolean C(OptionPriority optionPriority, OptionPriority optionPriority2) {
        OptionPriority optionPriority3 = OptionPriority.REQUIRED;
        return optionPriority == optionPriority3 && optionPriority2 == optionPriority3;
    }

    static void J(u uVar, Config config, Config config2, a<?> aVar) {
        if (!Objects.equals(aVar, s.f11494y)) {
            uVar.q(aVar, config2.h(aVar), config2.a(aVar));
            return;
        }
        X.c cVar = (X.c) config2.g(aVar, null);
        uVar.q(aVar, config2.h(aVar), M.l.a((X.c) config.g(aVar, null), cVar));
    }

    static Config X(Config config, Config config2) {
        if (config == null && config2 == null) {
            return v.i0();
        }
        u uVarL0 = config2 != null ? u.l0(config2) : u.k0();
        if (config != null) {
            Iterator<a<?>> it = config.e().iterator();
            while (it.hasNext()) {
                J(uVarL0, config2, config, it.next());
            }
        }
        return v.j0(uVarL0);
    }

    <ValueT> ValueT a(a<ValueT> aVar);

    boolean b(a<?> aVar);

    void c(String str, b bVar);

    <ValueT> ValueT d(a<ValueT> aVar, OptionPriority optionPriority);

    Set<a<?>> e();

    Set<OptionPriority> f(a<?> aVar);

    <ValueT> ValueT g(a<ValueT> aVar, ValueT valuet);

    OptionPriority h(a<?> aVar);
}
