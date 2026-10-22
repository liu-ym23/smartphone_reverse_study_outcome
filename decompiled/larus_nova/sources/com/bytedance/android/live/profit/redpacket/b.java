package com.bytedance.android.live.profit.redpacket;

import android.util.Property;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> extends Property<Unit, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f88583a;

    public static final class a {
    }

    static {
    }

    @Override // android.util.Property
    public final Object get(Unit r100) {
        return this.f88583a;
    }

    public b(T r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "TClass");
        super(r101, "dummyProperty");
        this.f88583a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public final void set(Unit r100, Object r101) {
        this.f88583a = r101;
    }
}
