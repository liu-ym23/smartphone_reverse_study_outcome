package com.stepos.core.ota.download.control;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DebuggableThermalProvider implements ThermalProvider {
    private final CopyOnWriteArrayList<l<Float, n>> listeners = new CopyOnWriteArrayList<>();
    private volatile Float temperature;

    @Override // com.stepos.core.ota.download.control.ThermalProvider
    public Float current() {
        return this.temperature;
    }

    @Override // com.stepos.core.ota.download.control.ThermalProvider
    public void observe(l<? super Float, n> onChange) {
        g.f(onChange, "onChange");
        this.listeners.add(onChange);
        Float f8 = this.temperature;
        if (f8 != null) {
            onChange.invoke(Float.valueOf(f8.floatValue()));
        }
    }

    public final void report(float f8) {
        this.temperature = Float.valueOf(f8);
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            try {
                ((l) it.next()).invoke(Float.valueOf(f8));
                n nVar = n.f10413a;
            } catch (Throwable th) {
                c.a(th);
            }
        }
    }

    @Override // com.stepos.core.ota.download.control.ThermalProvider
    public void stop() {
        this.listeners.clear();
    }
}
