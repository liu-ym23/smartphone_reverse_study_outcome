package com.stepos.core.ota.download.control;

import android.util.Log;
import com.stepos.core.ota.download.control.StepOsThermalBridge;
import com.stepos.cpuset.c;
import com.stepos.thermal.StepOSThermalManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.d;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class StepOsThermalBridge {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "OtaThermalBridge";
    private StepOSThermalManager.OnThermalChangedListener listener;
    private final ConcurrentHashMap<String, Float> shellTemps;
    private final d shellZones$delegate;
    private final DebuggableThermalProvider sink;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public StepOsThermalBridge(DebuggableThermalProvider sink) {
        g.f(sink, "sink");
        this.sink = sink;
        this.shellTemps = new ConcurrentHashMap<>();
        this.shellZones$delegate = b.b(new c(1));
    }

    private final Set<String> getShellZones() {
        return (Set) this.shellZones$delegate.getValue();
    }

    private final void onChanged(String str, int i10) {
        if (getShellZones().contains(str)) {
            put(str, i10);
            publish();
        }
    }

    private final void publish() {
        Float fValueOf;
        Collection<Float> collectionValues = this.shellTemps.values();
        g.e(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        if (it.hasNext()) {
            float fFloatValue = ((Number) it.next()).floatValue();
            while (it.hasNext()) {
                fFloatValue = Math.max(fFloatValue, ((Number) it.next()).floatValue());
            }
            fValueOf = Float.valueOf(fFloatValue);
        } else {
            fValueOf = null;
        }
        if (fValueOf != null) {
            this.sink.report(fValueOf.floatValue());
        }
    }

    private final void put(String str, int i10) {
        float celsius = toCelsius(i10);
        if (celsius <= -40.0f || celsius >= 150.0f) {
            return;
        }
        this.shellTemps.put(str, Float.valueOf(celsius));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set shellZones_delegate$lambda$0() {
        return l.s0(new String[]{"shell_temp_front", "shell_temp_frame", "shell_temp_back"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start$lambda$5$lambda$4(StepOsThermalBridge stepOsThermalBridge, String str, int i10) {
        g.c(str);
        stepOsThermalBridge.onChanged(str, i10);
    }

    private final float toCelsius(int i10) {
        return i10 > 1000 ? i10 / 1000.0f : i10;
    }

    public final void start() {
        Object objA;
        Object objA2;
        try {
            StepOSThermalManager stepOSThermalManager = StepOSThermalManager.get();
            for (String str : getShellZones()) {
                try {
                    objA2 = Integer.valueOf(stepOSThermalManager.getTemperature(str));
                } catch (Throwable th) {
                    objA2 = kotlin.c.a(th);
                }
                if (objA2 instanceof Result.Failure) {
                    objA2 = null;
                }
                Integer num = (Integer) objA2;
                if (num != null) {
                    put(str, num.intValue());
                }
            }
            StepOSThermalManager.OnThermalChangedListener onThermalChangedListener = new StepOSThermalManager.OnThermalChangedListener() { // from class: d9.a
                public final void onThermalChanged(String str2, int i10) {
                    StepOsThermalBridge.start$lambda$5$lambda$4(this.f8413a, str2, i10);
                }
            };
            this.listener = onThermalChangedListener;
            boolean zRegisterListener = stepOSThermalManager.registerListener(onThermalChangedListener);
            publish();
            objA = Integer.valueOf(zRegisterListener ? Log.i(TAG, "StepOSThermalManager listener registered (shell zones); seed=" + this.shellTemps) : Log.w(TAG, "StepOSThermalManager.registerListener returned false; callbacks may not fire"));
        } catch (Throwable th2) {
            objA = kotlin.c.a(th2);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.w(TAG, "StepOSThermalManager unavailable → thermal source = inject-only", thB);
        }
    }

    public final void stop() {
        try {
            StepOSThermalManager.OnThermalChangedListener onThermalChangedListener = this.listener;
            if (onThermalChangedListener != null) {
                StepOSThermalManager.get().unregisterListener(onThermalChangedListener);
            }
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        this.listener = null;
        this.shellTemps.clear();
    }
}
