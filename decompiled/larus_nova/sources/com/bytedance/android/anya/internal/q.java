package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.o0;
import com.bytedance.android.anya.x;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
public final class q<OWNER extends MVIState<?>, STATE extends x<?>> extends c<OWNER, STATE> implements o0<OWNER, STATE>, ReadOnlyProperty<OWNER, o0<OWNER, STATE>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class<STATE> f41705f;

    @Override // com.bytedance.android.anya.internal.c
    public final String toString() {
        return "{ \"name\": \"" + this.f41672a + "@r\", \"value\": " + ((x) this.f41673b) + " }";
    }

    @Override // com.bytedance.android.anya.internal.c
    public final boolean b(Object r100) {
        x r101 = (x) r100;
        if (Intrinsics.areEqual(r101.getClass(), this.f41705f) == false) goto L7;
        STATE r102 = c();
        i.a(r102, r101);
        return !r102.modifiedProperties.isEmpty();
    L7:
        throw new IllegalStateException(("Incoming state value type [" + x.class + "] is different from previous [" + this.f41705f + ']').toString());
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object r100, KProperty r101) {
        MVIState r102 = (MVIState) r100;
        return this;
    }

    public q(Class r100, x r101, Function1 r102, Function1 r103) {
        super(r101, r102, r103);
        this.f41705f = r100;
    }
}
