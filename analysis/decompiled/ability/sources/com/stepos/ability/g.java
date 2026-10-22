package com.stepos.ability;

import android.view.View;
import com.stepos.ability.App_HiltComponents$ViewC;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;

/* loaded from: classes3.dex */
public final class g implements App_HiltComponents$ViewC.Builder {

    /* renamed from: a, reason: collision with root package name */
    public final DaggerApp_HiltComponents_SingletonC$SingletonCImpl f3096a;
    public final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl b;
    public final DaggerApp_HiltComponents_SingletonC$ActivityCImpl c;
    public View d;

    public g(DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl, DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl, DaggerApp_HiltComponents_SingletonC$ActivityCImpl daggerApp_HiltComponents_SingletonC$ActivityCImpl) {
        this.f3096a = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
        this.b = daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl;
        this.c = daggerApp_HiltComponents_SingletonC$ActivityCImpl;
    }

    @Override // dagger.hilt.android.internal.builders.ViewComponentBuilder
    public final ViewComponent build() {
        com.stepos.ability.task.executor.e.r(View.class, this.d);
        final DaggerApp_HiltComponents_SingletonC$ActivityCImpl daggerApp_HiltComponents_SingletonC$ActivityCImpl = this.c;
        final View view = this.d;
        final DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl = this.f3096a;
        final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl = this.b;
        return new App_HiltComponents$ViewC(daggerApp_HiltComponents_SingletonC$SingletonCImpl, daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl, daggerApp_HiltComponents_SingletonC$ActivityCImpl, view) { // from class: com.stepos.ability.DaggerApp_HiltComponents_SingletonC$ViewCImpl
            private final DaggerApp_HiltComponents_SingletonC$ActivityCImpl activityCImpl;
            private final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl activityRetainedCImpl;
            private final DaggerApp_HiltComponents_SingletonC$SingletonCImpl singletonCImpl;
            private final DaggerApp_HiltComponents_SingletonC$ViewCImpl viewCImpl = this;

            {
                this.singletonCImpl = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
                this.activityRetainedCImpl = daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl;
                this.activityCImpl = daggerApp_HiltComponents_SingletonC$ActivityCImpl;
            }
        };
    }

    @Override // dagger.hilt.android.internal.builders.ViewComponentBuilder
    public final ViewComponentBuilder view(View view) {
        view.getClass();
        this.d = view;
        return this;
    }
}
