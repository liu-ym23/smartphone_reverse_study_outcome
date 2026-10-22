package com.bytedance.android.live.revenue.platform.preference.impl;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements com.bytedance.tools.kcp.spongepreference.runtime.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<T> f91566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, Unit> f91567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f91568c;

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public final T getValue(Object r100, KProperty<?> r101) {
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return this.f91566a.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends T> r100, Function1<? super T, Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "getValue");
        Intrinsics.checkNotNullParameter(r101, "setValue");
        Intrinsics.checkNotNullParameter(r102, "_clearValue");
        this.f91566a = r100;
        this.f91567b = r101;
        this.f91568c = r102;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public final void setValue(Object r100, KProperty<?> r101, T r102) {
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f91567b.invoke(r102);
    }
}
