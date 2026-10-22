package com.bytedance.android.live.revenue.platform.settings.impl;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements ReadOnlyProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<T> f91655a;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "getValue");
        this.f91655a = r100;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final T getValue(Object r100, KProperty<?> r101) {
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return this.f91655a.invoke();
    }
}
