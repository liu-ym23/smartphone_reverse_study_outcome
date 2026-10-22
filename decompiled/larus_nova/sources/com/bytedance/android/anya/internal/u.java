package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.s0;
import com.bytedance.android.anya.t0;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
public final class u<OWNER extends MVIState<?>, STATE extends MVIState<?>> extends c<OWNER, s0<STATE>> implements t0<OWNER, STATE>, ReadOnlyProperty<OWNER, t0<OWNER, STATE>> {
    @Override // com.bytedance.android.anya.internal.c
    public final boolean b(Object r100) {
        s0 r101 = (s0) r100;
        if (c() != r101) goto L5;
    L7:
        return false;
    L5:
        if (((t) c()).q(r101) == false) goto L7;
        return true;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object r100, KProperty r101) {
        MVIState r102 = (MVIState) r100;
        return this;
    }

    public u(final List r100, Function1 r101, Function1 r102) {
        super(new t(null), r101, r102);
        t r103 = (t) c();
        r103.f41712a = new StateListPropertyImpl$$special$$inlined$let$lambda$1(this, r100);
        r103.addAll(r100);
    }
}
