package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import java.util.Set;

/* loaded from: classes.dex */
public interface x extends Config {
    @Override // androidx.camera.core.impl.Config
    default <ValueT> ValueT a(Config.a<ValueT> aVar) {
        return (ValueT) getConfig().a(aVar);
    }

    @Override // androidx.camera.core.impl.Config
    default boolean b(Config.a<?> aVar) {
        return getConfig().b(aVar);
    }

    @Override // androidx.camera.core.impl.Config
    default void c(String str, Config.b bVar) {
        getConfig().c(str, bVar);
    }

    @Override // androidx.camera.core.impl.Config
    default <ValueT> ValueT d(Config.a<ValueT> aVar, Config.OptionPriority optionPriority) {
        return (ValueT) getConfig().d(aVar, optionPriority);
    }

    @Override // androidx.camera.core.impl.Config
    default Set<Config.a<?>> e() {
        return getConfig().e();
    }

    @Override // androidx.camera.core.impl.Config
    default Set<Config.OptionPriority> f(Config.a<?> aVar) {
        return getConfig().f(aVar);
    }

    @Override // androidx.camera.core.impl.Config
    default <ValueT> ValueT g(Config.a<ValueT> aVar, ValueT valuet) {
        return (ValueT) getConfig().g(aVar, valuet);
    }

    Config getConfig();

    @Override // androidx.camera.core.impl.Config
    default Config.OptionPriority h(Config.a<?> aVar) {
        return getConfig().h(aVar);
    }
}
