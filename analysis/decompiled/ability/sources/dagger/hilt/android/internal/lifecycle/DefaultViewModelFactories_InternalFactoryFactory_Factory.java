package dagger.hilt.android.internal.lifecycle;

import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import java.util.Map;
import y7.InterfaceC2137b;

/* loaded from: classes2.dex */
public final class DefaultViewModelFactories_InternalFactoryFactory_Factory implements InterfaceC2137b {
    private final InterfaceC2137b keySetProvider;
    private final InterfaceC2137b viewModelComponentBuilderProvider;

    private DefaultViewModelFactories_InternalFactoryFactory_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        this.keySetProvider = interfaceC2137b;
        this.viewModelComponentBuilderProvider = interfaceC2137b2;
    }

    public static DefaultViewModelFactories_InternalFactoryFactory_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        return new DefaultViewModelFactories_InternalFactoryFactory_Factory(interfaceC2137b, interfaceC2137b2);
    }

    public static DefaultViewModelFactories.InternalFactoryFactory newInstance(Map<Class<?>, Boolean> map, ViewModelComponentBuilder viewModelComponentBuilder) {
        return new DefaultViewModelFactories.InternalFactoryFactory(map, viewModelComponentBuilder);
    }

    @Override // javax.inject.Provider
    public DefaultViewModelFactories.InternalFactoryFactory get() {
        return newInstance((Map) this.keySetProvider.get(), (ViewModelComponentBuilder) this.viewModelComponentBuilderProvider.get());
    }
}
