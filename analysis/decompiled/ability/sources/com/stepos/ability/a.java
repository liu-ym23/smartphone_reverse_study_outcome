package com.stepos.ability;

import android.app.Activity;
import com.stepos.ability.App_HiltComponents$ActivityC;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;

/* loaded from: classes3.dex */
public final class a implements App_HiltComponents$ActivityC.Builder {

    /* renamed from: a, reason: collision with root package name */
    public final DaggerApp_HiltComponents_SingletonC$SingletonCImpl f3059a;
    public final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl b;
    public Activity c;

    public a(DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl, DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl) {
        this.f3059a = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
        this.b = daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl;
    }

    @Override // dagger.hilt.android.internal.builders.ActivityComponentBuilder
    public final ActivityComponentBuilder activity(Activity activity) {
        activity.getClass();
        this.c = activity;
        return this;
    }

    @Override // dagger.hilt.android.internal.builders.ActivityComponentBuilder
    public final ActivityComponent build() {
        com.stepos.ability.task.executor.e.r(Activity.class, this.c);
        return new DaggerApp_HiltComponents_SingletonC$ActivityCImpl(this.f3059a, this.b, this.c);
    }
}
