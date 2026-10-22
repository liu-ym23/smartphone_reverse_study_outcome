package com.stepos.ability;

import android.app.Activity;
import com.google.common.collect.ImmutableMap;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import java.util.Map;

/* loaded from: classes3.dex */
final class DaggerApp_HiltComponents_SingletonC$ActivityCImpl extends App_HiltComponents$ActivityC {
    private final DaggerApp_HiltComponents_SingletonC$ActivityCImpl activityCImpl = this;
    private final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl activityRetainedCImpl;
    private final DaggerApp_HiltComponents_SingletonC$SingletonCImpl singletonCImpl;

    public DaggerApp_HiltComponents_SingletonC$ActivityCImpl(DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl, DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl, Activity activity) {
        this.singletonCImpl = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
        this.activityRetainedCImpl = daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl;
    }

    @Override // dagger.hilt.android.internal.managers.FragmentComponentManager.FragmentComponentBuilderEntryPoint
    public FragmentComponentBuilder fragmentComponentBuilder() {
        return new d(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl);
    }

    @Override // dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories.ActivityEntryPoint
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
        return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(ImmutableMap.b(), new h(this.singletonCImpl, this.activityRetainedCImpl));
    }

    @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ActivityCreatorEntryPoint
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
        return new h(this.singletonCImpl, this.activityRetainedCImpl);
    }

    @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ActivityCreatorEntryPoint
    public Map<Class<?>, Boolean> getViewModelKeys() {
        return ImmutableMap.b();
    }

    @Override // dagger.hilt.android.internal.managers.ViewComponentManager.ViewComponentBuilderEntryPoint
    public ViewComponentBuilder viewComponentBuilder() {
        return new g(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl);
    }
}
