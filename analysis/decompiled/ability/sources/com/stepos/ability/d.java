package com.stepos.ability;

import androidx.fragment.app.Fragment;
import com.stepos.ability.App_HiltComponents$FragmentC;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;

/* loaded from: classes3.dex */
public final class d implements App_HiltComponents$FragmentC.Builder {

    /* renamed from: a, reason: collision with root package name */
    public final DaggerApp_HiltComponents_SingletonC$SingletonCImpl f3079a;
    public final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl b;
    public final DaggerApp_HiltComponents_SingletonC$ActivityCImpl c;
    public Fragment d;

    public d(DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl, DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl, DaggerApp_HiltComponents_SingletonC$ActivityCImpl daggerApp_HiltComponents_SingletonC$ActivityCImpl) {
        this.f3079a = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
        this.b = daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl;
        this.c = daggerApp_HiltComponents_SingletonC$ActivityCImpl;
    }

    @Override // dagger.hilt.android.internal.builders.FragmentComponentBuilder
    public final FragmentComponent build() {
        com.stepos.ability.task.executor.e.r(Fragment.class, this.d);
        final DaggerApp_HiltComponents_SingletonC$ActivityCImpl daggerApp_HiltComponents_SingletonC$ActivityCImpl = this.c;
        final Fragment fragment = this.d;
        final DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl = this.f3079a;
        final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl = this.b;
        return new App_HiltComponents$FragmentC(daggerApp_HiltComponents_SingletonC$SingletonCImpl, daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl, daggerApp_HiltComponents_SingletonC$ActivityCImpl, fragment) { // from class: com.stepos.ability.DaggerApp_HiltComponents_SingletonC$FragmentCImpl
            private final DaggerApp_HiltComponents_SingletonC$ActivityCImpl activityCImpl;
            private final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl activityRetainedCImpl;
            private final DaggerApp_HiltComponents_SingletonC$FragmentCImpl fragmentCImpl = this;
            private final DaggerApp_HiltComponents_SingletonC$SingletonCImpl singletonCImpl;

            {
                this.singletonCImpl = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
                this.activityRetainedCImpl = daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl;
                this.activityCImpl = daggerApp_HiltComponents_SingletonC$ActivityCImpl;
            }

            @Override // dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories.FragmentEntryPoint
            public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
                return this.activityCImpl.getHiltInternalFactoryFactory();
            }

            @Override // dagger.hilt.android.internal.managers.ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint
            public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
                return new i(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.fragmentCImpl);
            }
        };
    }

    @Override // dagger.hilt.android.internal.builders.FragmentComponentBuilder
    public final FragmentComponentBuilder fragment(Fragment fragment) {
        fragment.getClass();
        this.d = fragment;
        return this;
    }
}
