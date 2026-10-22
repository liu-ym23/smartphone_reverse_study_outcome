package dagger.hilt.android.internal.lifecycle;

import S7.k;
import android.app.Activity;
import android.os.Bundle;
import android.view.SavedStateHandleSupport;
import android.view.SavedStateRegistryOwner;
import android.view.ViewModel;
import android.view.ViewModelProvider;
import android.view.viewmodel.CreationExtras;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dagger.hilt.EntryPoint;
import dagger.hilt.EntryPoints;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.lifecycle.HiltViewModelMap;
import java.io.Closeable;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HiltViewModelFactory implements ViewModelProvider.Factory {
    public static final CreationExtras.Key<k> CREATION_CALLBACK_KEY = new CreationExtras.Key<k>() { // from class: dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.1
    };
    private final ViewModelProvider.Factory delegateFactory;
    private final ViewModelProvider.Factory hiltViewModelFactory;
    private final Map<Class<?>, Boolean> hiltViewModelKeys;

    @EntryPoint
    @InstallIn({ActivityComponent.class})
    public interface ActivityCreatorEntryPoint {
        ViewModelComponentBuilder getViewModelComponentBuilder();

        @HiltViewModelMap.KeySet
        Map<Class<?>, Boolean> getViewModelKeys();
    }

    @EntryPoint
    @InstallIn({ViewModelComponent.class})
    public interface ViewModelFactoriesEntryPoint {
        @HiltViewModelAssistedMap
        Map<Class<?>, Object> getHiltViewModelAssistedMap();

        @HiltViewModelMap
        Map<Class<?>, Provider<ViewModel>> getHiltViewModelMap();
    }

    @InstallIn({ViewModelComponent.class})
    public interface ViewModelModule {
        @HiltViewModelAssistedMap
        Map<Class<?>, Object> hiltViewModelAssistedMap();

        @HiltViewModelMap
        Map<Class<?>, ViewModel> hiltViewModelMap();
    }

    public HiltViewModelFactory(@NonNull Map<Class<?>, Boolean> map, @NonNull ViewModelProvider.Factory factory, @NonNull final ViewModelComponentBuilder viewModelComponentBuilder) {
        this.hiltViewModelKeys = map;
        this.delegateFactory = factory;
        this.hiltViewModelFactory = new ViewModelProvider.Factory() { // from class: dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.2
            private <T extends ViewModel> T createViewModel(@NonNull ViewModelComponent viewModelComponent, @NonNull Class<T> cls, @NonNull CreationExtras creationExtras) {
                Provider<ViewModel> provider = ((ViewModelFactoriesEntryPoint) EntryPoints.get(viewModelComponent, ViewModelFactoriesEntryPoint.class)).getHiltViewModelMap().get(cls);
                k kVar = (k) creationExtras.get(HiltViewModelFactory.CREATION_CALLBACK_KEY);
                Object obj = ((ViewModelFactoriesEntryPoint) EntryPoints.get(viewModelComponent, ViewModelFactoriesEntryPoint.class)).getHiltViewModelAssistedMap().get(cls);
                if (obj == null) {
                    if (kVar != null) {
                        throw new IllegalStateException(androidx.constraintlayout.core.dsl.a.i(new StringBuilder("Found creation callback but class "), cls, " does not have an assisted factory specified in @HiltViewModel."));
                    }
                    if (provider != null) {
                        return (T) provider.get();
                    }
                    throw new IllegalStateException(androidx.constraintlayout.core.dsl.a.i(new StringBuilder("Expected the @HiltViewModel-annotated class "), cls, " to be available in the multi-binding of @HiltViewModelMap but none was found."));
                }
                if (provider != null) {
                    throw new AssertionError(androidx.constraintlayout.core.dsl.a.i(new StringBuilder("Found the @HiltViewModel-annotated class "), cls, " in both the multi-bindings of @HiltViewModelMap and @HiltViewModelAssistedMap."));
                }
                if (kVar != null) {
                    return (T) kVar.invoke(obj);
                }
                throw new IllegalStateException(androidx.constraintlayout.core.dsl.a.i(new StringBuilder("Found @HiltViewModel-annotated class "), cls, " using @AssistedInject but no creation callback was provided in CreationExtras."));
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NonNull
            public <T extends ViewModel> T create(@NonNull Class<T> cls, @NonNull CreationExtras creationExtras) {
                final RetainedLifecycleImpl retainedLifecycleImpl = new RetainedLifecycleImpl();
                T t9 = (T) createViewModel(viewModelComponentBuilder.savedStateHandle(SavedStateHandleSupport.createSavedStateHandle(creationExtras)).viewModelLifecycle(retainedLifecycleImpl).build(), cls, creationExtras);
                t9.addCloseable(new Closeable() { // from class: dagger.hilt.android.internal.lifecycle.a
                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public final void close() {
                        retainedLifecycleImpl.dispatchOnCleared();
                    }
                });
                return t9;
            }
        };
    }

    public static ViewModelProvider.Factory createInternal(@NonNull Activity activity, @NonNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle, @NonNull ViewModelProvider.Factory factory) {
        return createInternal(activity, factory);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls, @NonNull CreationExtras creationExtras) {
        return this.hiltViewModelKeys.containsKey(cls) ? (T) this.hiltViewModelFactory.create(cls, creationExtras) : (T) this.delegateFactory.create(cls, creationExtras);
    }

    public static ViewModelProvider.Factory createInternal(@NonNull Activity activity, @NonNull ViewModelProvider.Factory factory) {
        ActivityCreatorEntryPoint activityCreatorEntryPoint = (ActivityCreatorEntryPoint) EntryPoints.get(activity, ActivityCreatorEntryPoint.class);
        return new HiltViewModelFactory(activityCreatorEntryPoint.getViewModelKeys(), factory, activityCreatorEntryPoint.getViewModelComponentBuilder());
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        if (this.hiltViewModelKeys.containsKey(cls)) {
            return (T) this.hiltViewModelFactory.create(cls);
        }
        return (T) this.delegateFactory.create(cls);
    }
}
