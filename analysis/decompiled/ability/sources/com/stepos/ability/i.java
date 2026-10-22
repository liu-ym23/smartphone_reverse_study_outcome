package com.stepos.ability;

import android.view.View;
import com.stepos.ability.App_HiltComponents$ViewWithFragmentC;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;

/* loaded from: classes3.dex */
public final class i implements App_HiltComponents$ViewWithFragmentC.Builder {

    /* renamed from: a, reason: collision with root package name */
    public final DaggerApp_HiltComponents_SingletonC$SingletonCImpl f3098a;
    public final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl b;
    public final DaggerApp_HiltComponents_SingletonC$ActivityCImpl c;
    public final DaggerApp_HiltComponents_SingletonC$FragmentCImpl d;
    public View e;

    public i(DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl, DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl, DaggerApp_HiltComponents_SingletonC$ActivityCImpl daggerApp_HiltComponents_SingletonC$ActivityCImpl, DaggerApp_HiltComponents_SingletonC$FragmentCImpl daggerApp_HiltComponents_SingletonC$FragmentCImpl) {
        this.f3098a = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
        this.b = daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl;
        this.c = daggerApp_HiltComponents_SingletonC$ActivityCImpl;
        this.d = daggerApp_HiltComponents_SingletonC$FragmentCImpl;
    }

    @Override // dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder
    public final ViewWithFragmentComponent build() {
        com.stepos.ability.task.executor.e.r(View.class, this.e);
        final DaggerApp_HiltComponents_SingletonC$FragmentCImpl daggerApp_HiltComponents_SingletonC$FragmentCImpl = this.d;
        final View view = this.e;
        final DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl = this.f3098a;
        final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl = this.b;
        final DaggerApp_HiltComponents_SingletonC$ActivityCImpl daggerApp_HiltComponents_SingletonC$ActivityCImpl = this.c;
        return new App_HiltComponents$ViewWithFragmentC(daggerApp_HiltComponents_SingletonC$SingletonCImpl, daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl, daggerApp_HiltComponents_SingletonC$ActivityCImpl, daggerApp_HiltComponents_SingletonC$FragmentCImpl, view) { // from class: com.stepos.ability.DaggerApp_HiltComponents_SingletonC$ViewWithFragmentCImpl
            private final DaggerApp_HiltComponents_SingletonC$ActivityCImpl activityCImpl;
            private final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl activityRetainedCImpl;
            private final DaggerApp_HiltComponents_SingletonC$FragmentCImpl fragmentCImpl;
            private final DaggerApp_HiltComponents_SingletonC$SingletonCImpl singletonCImpl;
            private final DaggerApp_HiltComponents_SingletonC$ViewWithFragmentCImpl viewWithFragmentCImpl = this;

            {
                this.singletonCImpl = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
                this.activityRetainedCImpl = daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl;
                this.activityCImpl = daggerApp_HiltComponents_SingletonC$ActivityCImpl;
                this.fragmentCImpl = daggerApp_HiltComponents_SingletonC$FragmentCImpl;
            }
        };
    }

    @Override // dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder
    public final ViewWithFragmentComponentBuilder view(View view) {
        view.getClass();
        this.e = view;
        return this;
    }
}
