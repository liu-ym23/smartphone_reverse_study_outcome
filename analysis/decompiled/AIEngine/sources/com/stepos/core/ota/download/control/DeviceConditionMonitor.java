package com.stepos.core.ota.download.control;

import android.util.Log;
import com.stepos.core.ota.download.control.DeviceConditions;
import java.util.Iterator;
import java.util.List;
import kotlin.c;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import zb.a;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DeviceConditionMonitor {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "OtaDlCond";
    private final a<Long> clockMs;
    private volatile DeviceConditions latest;
    private final l<DeviceConditions, n> onConditions;
    private final List<ConditionSource> sources;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceConditionMonitor(List<? extends ConditionSource> sources, a<Long> clockMs, l<? super DeviceConditions, n> onConditions) {
        g.f(sources, "sources");
        g.f(clockMs, "clockMs");
        g.f(onConditions, "onConditions");
        this.sources = sources;
        this.clockMs = clockMs;
        this.onConditions = onConditions;
        this.latest = DeviceConditions.Companion.getEMPTY();
    }

    private final void rebuild() {
        DeviceConditions.Builder builder = DeviceConditions.Companion.builder();
        builder.setSampledAtMs(this.clockMs.invoke().longValue());
        Iterator<T> it = this.sources.iterator();
        while (it.hasNext()) {
            try {
                ((ConditionSource) it.next()).contribute(builder);
                n nVar = n.f10413a;
            } catch (Throwable th) {
                c.a(th);
            }
        }
        this.latest = builder.build();
        Log.d(TAG, "conditions: temp=" + this.latest.get(DeviceConditions.Companion.getTEMPERATURE_C()) + "℃");
        try {
            this.onConditions.invoke(this.latest);
            n nVar2 = n.f10413a;
        } catch (Throwable th2) {
            c.a(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n start$lambda$1$lambda$0(DeviceConditionMonitor deviceConditionMonitor) {
        deviceConditionMonitor.rebuild();
        return n.f10413a;
    }

    public final DeviceConditions current() {
        return this.latest;
    }

    public final void start() {
        Iterator<T> it = this.sources.iterator();
        while (it.hasNext()) {
            ((ConditionSource) it.next()).observe(new b6.g(this, 8));
        }
        rebuild();
    }

    public final void stop() {
        Iterator<T> it = this.sources.iterator();
        while (it.hasNext()) {
            try {
                ((ConditionSource) it.next()).stop();
                n nVar = n.f10413a;
            } catch (Throwable th) {
                c.a(th);
            }
        }
    }
}
