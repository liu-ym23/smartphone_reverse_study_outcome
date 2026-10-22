package com.stepos.ability;

import com.stepos.ability.App_HiltComponents$ActivityRetainedC;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import y7.C2136a;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class b implements App_HiltComponents$ActivityRetainedC.Builder {

    /* renamed from: a, reason: collision with root package name */
    public final DaggerApp_HiltComponents_SingletonC$SingletonCImpl f3061a;
    public SavedStateHandleHolder b;

    public b(DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl) {
        this.f3061a = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
    }

    @Override // dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder
    public final ActivityRetainedComponent build() {
        com.stepos.ability.task.executor.e.r(SavedStateHandleHolder.class, this.b);
        final DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl = this.f3061a;
        final SavedStateHandleHolder savedStateHandleHolder = this.b;
        return new App_HiltComponents$ActivityRetainedC(daggerApp_HiltComponents_SingletonC$SingletonCImpl, savedStateHandleHolder) { // from class: com.stepos.ability.DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl
            private final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl activityRetainedCImpl = this;
            InterfaceC2137b provideActivityRetainedLifecycleProvider;
            private final DaggerApp_HiltComponents_SingletonC$SingletonCImpl singletonCImpl;

            {
                this.singletonCImpl = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
                initialize(savedStateHandleHolder);
            }

            private void initialize(SavedStateHandleHolder savedStateHandleHolder2) {
                this.provideActivityRetainedLifecycleProvider = C2136a.a(new c());
            }

            @Override // dagger.hilt.android.internal.managers.ActivityComponentManager.ActivityComponentBuilderEntryPoint
            public ActivityComponentBuilder activityComponentBuilder() {
                return new a(this.singletonCImpl, this.activityRetainedCImpl);
            }

            @Override // dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.ActivityRetainedLifecycleEntryPoint
            public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
                return (ActivityRetainedLifecycle) this.provideActivityRetainedLifecycleProvider.get();
            }
        };
    }

    @Override // dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder
    public final ActivityRetainedComponentBuilder savedStateHandleHolder(SavedStateHandleHolder savedStateHandleHolder) {
        savedStateHandleHolder.getClass();
        this.b = savedStateHandleHolder;
        return this;
    }
}
