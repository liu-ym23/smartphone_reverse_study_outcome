package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.u0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
public final class SubStatePropertyImpl<OWNER extends MVIState<?>, STATE extends MVIState<?>> extends c<OWNER, STATE> implements u0<OWNER, STATE>, ReadOnlyProperty<OWNER, u0<OWNER, STATE>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class<STATE> f41637f;

    @Override // com.bytedance.android.anya.internal.c
    public final String toString() {
        return "{ \"name\": \"" + this.f41672a + "@s\", \"value\": " + ((MVIState) this.f41673b) + ", \"type\": \"" + this.f41637f.getCanonicalName() + "\" } ";
    }

    @Override // com.bytedance.android.anya.internal.c
    public final boolean b(Object r100) {
        MVIState r101 = (MVIState) r100;
        if (Intrinsics.areEqual(r101.getClass(), this.f41637f) == false) goto L7;
        STATE r102 = c();
        i.a(r102, r101);
        return !r102.modifiedProperties.isEmpty();
    L7:
        throw new IllegalStateException(("Incoming state value type [" + r101.getClass() + "] is different from previous [" + this.f41637f + ']').toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(MVIState<?> r100) {
        this.f41673b = r100;
        r100.notifyParentNodeChange = new SubStatePropertyImpl$initValue$1(this);
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object r100, KProperty r101) {
        MVIState r102 = (MVIState) r100;
        return this;
    }

    public SubStatePropertyImpl(Class r100, MVIState r101, final Function1 r102, Function1 r103) {
        super(r101, r102, r103);
        this.f41637f = r100;
        if (r101 == null) goto L6;
        r101.notifyParentNodeChange = new AnonymousClass1(this, r102);
        return;
    }
}
