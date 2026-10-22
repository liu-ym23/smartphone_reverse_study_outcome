package com.stepos.ability;

import android.view.SavedStateHandle;
import android.view.ViewModel;
import com.google.common.collect.ImmutableMap;
import com.stepos.ability.App_HiltComponents$ViewModelC;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class h implements App_HiltComponents$ViewModelC.Builder {

    /* renamed from: a, reason: collision with root package name */
    public final DaggerApp_HiltComponents_SingletonC$SingletonCImpl f3097a;
    public final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl b;
    public SavedStateHandle c;
    public ViewModelLifecycle d;

    public h(DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl, DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl) {
        this.f3097a = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
        this.b = daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl;
    }

    @Override // dagger.hilt.android.internal.builders.ViewModelComponentBuilder
    public final ViewModelComponent build() {
        com.stepos.ability.task.executor.e.r(SavedStateHandle.class, this.c);
        com.stepos.ability.task.executor.e.r(ViewModelLifecycle.class, this.d);
        final SavedStateHandle savedStateHandle = this.c;
        final ViewModelLifecycle viewModelLifecycle = this.d;
        final DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl = this.f3097a;
        final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl = this.b;
        return new App_HiltComponents$ViewModelC(daggerApp_HiltComponents_SingletonC$SingletonCImpl, daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl, savedStateHandle, viewModelLifecycle) { // from class: com.stepos.ability.DaggerApp_HiltComponents_SingletonC$ViewModelCImpl
            private final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl activityRetainedCImpl;
            private final DaggerApp_HiltComponents_SingletonC$SingletonCImpl singletonCImpl;
            private final DaggerApp_HiltComponents_SingletonC$ViewModelCImpl viewModelCImpl = this;

            {
                this.singletonCImpl = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
                this.activityRetainedCImpl = daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl;
            }

            @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ViewModelFactoriesEntryPoint
            public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
                return ImmutableMap.b();
            }

            @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ViewModelFactoriesEntryPoint
            public Map<Class<?>, Provider<ViewModel>> getHiltViewModelMap() {
                return ImmutableMap.b();
            }
        };
    }

    @Override // dagger.hilt.android.internal.builders.ViewModelComponentBuilder
    public final ViewModelComponentBuilder savedStateHandle(SavedStateHandle savedStateHandle) {
        savedStateHandle.getClass();
        this.c = savedStateHandle;
        return this;
    }

    @Override // dagger.hilt.android.internal.builders.ViewModelComponentBuilder
    public final ViewModelComponentBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
        viewModelLifecycle.getClass();
        this.d = viewModelLifecycle;
        return this;
    }
}
