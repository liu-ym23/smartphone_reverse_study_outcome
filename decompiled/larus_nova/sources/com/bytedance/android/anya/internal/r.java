package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
public final class r<OWNER extends MVIState<?>, T> extends c<OWNER, T> implements r0<OWNER, T>, ReadOnlyProperty<OWNER, r0<OWNER, T>> {
    @Override // kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object r100, KProperty r101) {
        MVIState r102 = (MVIState) r100;
        return this;
    }

    public r(Object r100, Function1 r101, Function1 r102) {
        super(r100, r101, r102);
    }
}
