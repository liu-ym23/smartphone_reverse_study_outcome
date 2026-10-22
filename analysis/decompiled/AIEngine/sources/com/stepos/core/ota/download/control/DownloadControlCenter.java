package com.stepos.core.ota.download.control;

import android.content.Context;
import androidx.compose.runtime.i;
import androidx.datastore.preferences.protobuf.b1;
import androidx.lifecycle.j0;
import java.io.File;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import wb.d;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadControlCenter {
    public static final Companion Companion = new Companion(null);
    private static volatile DownloadControlCenter instance;
    private final Context appContext;
    private final ThermalConfigStore configStore;
    private final DownloadController controller;
    private final DeviceConditionMonitor monitor;
    private final a<n> onConditionsChanged;
    private final StepOsThermalBridge thermalBridge;
    private final DebuggableThermalProvider thermalProvider;
    private final ThermalDownloadStrategy thermalStrategy;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final DownloadControlCenter getInstance() {
            return DownloadControlCenter.instance;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DownloadControlCenter(Context context, a<Long> clockMs, a<n> onConditionsChanged) {
        g.f(context, "context");
        g.f(clockMs, "clockMs");
        g.f(onConditionsChanged, "onConditionsChanged");
        this.onConditionsChanged = onConditionsChanged;
        Context appContext = context.getApplicationContext();
        this.appContext = appContext;
        DebuggableThermalProvider debuggableThermalProvider = new DebuggableThermalProvider();
        this.thermalProvider = debuggableThermalProvider;
        ThermalConfigStore thermalConfigStore = new ThermalConfigStore(null, 1, 0 == true ? 1 : 0);
        g.e(appContext, "appContext");
        ThermalConfigStore.loadFromAssets$default(thermalConfigStore, appContext, null, 2, null);
        this.configStore = thermalConfigStore;
        ThermalDownloadStrategy thermalDownloadStrategy = new ThermalDownloadStrategy(clockMs, new j0(this, 6));
        this.thermalStrategy = thermalDownloadStrategy;
        this.controller = new DownloadController(b1.P(thermalDownloadStrategy), null, 2, null);
        this.monitor = new DeviceConditionMonitor(b1.P(new ThermalConditionSource(debuggableThermalProvider)), clockMs, new i(this, 7));
        this.thermalBridge = new StepOsThermalBridge(debuggableThermalProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n monitor$lambda$2(DownloadControlCenter downloadControlCenter, DeviceConditions it) {
        g.f(it, "it");
        downloadControlCenter.onConditionsChanged.invoke();
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThermalRateConfig thermalStrategy$lambda$1(DownloadControlCenter downloadControlCenter) {
        return downloadControlCenter.configStore.active();
    }

    public final DeviceConditions currentConditions() {
        return this.monitor.current();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dump(java.io.PrintWriter r6) {
        /*
            r5 = this;
            java.lang.String r0 = "w"
            kotlin.jvm.internal.g.f(r6, r0)
            com.stepos.core.ota.download.control.DeviceConditions r0 = r5.currentConditions()
            com.stepos.core.ota.download.control.ThermalConfigStore r1 = r5.configStore
            com.stepos.core.ota.download.control.ThermalRateConfig r1 = r1.active()
            java.lang.String r2 = "Download control:"
            r6.println(r2)
            com.stepos.core.ota.download.control.DeviceConditions$Companion r2 = com.stepos.core.ota.download.control.DeviceConditions.Companion
            com.stepos.core.ota.download.control.ConditionKey r2 = r2.getTEMPERATURE_C()
            java.lang.Object r2 = r0.get(r2)
            java.lang.Float r2 = (java.lang.Float) r2
            if (r2 == 0) goto L39
            float r2 = r2.floatValue()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = "℃"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            if (r2 != 0) goto L3b
        L39:
            java.lang.String r2 = "unknown"
        L3b:
            java.lang.String r3 = "  temperature = "
            java.lang.String r2 = r3.concat(r2)
            r6.println(r2)
            java.lang.String r2 = r1.getActive()
            java.util.Map r1 = r1.getSchemes()
            java.util.Set r1 = r1.keySet()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "  scheme      = "
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = "  (available="
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = ")"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r6.println(r1)
            com.stepos.core.ota.download.control.DownloadController r1 = r5.controller
            java.util.List r1 = r1.strategyIds()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "  strategies  = "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r6.println(r1)
            com.stepos.core.ota.download.control.DownloadController r1 = r5.controller
            com.stepos.core.ota.domain.TriggerSource r2 = com.stepos.core.ota.domain.TriggerSource.USER
            com.stepos.core.ota.download.control.DownloadVerdict r1 = r1.decide(r0, r2)
            java.lang.String r1 = r1.describe()
            java.lang.String r2 = "  verdict(USER)   = "
            com.stepos.core.ota.d.r(r2, r1, r6)
            com.stepos.core.ota.download.control.DownloadController r5 = r5.controller
            com.stepos.core.ota.domain.TriggerSource r1 = com.stepos.core.ota.domain.TriggerSource.SILENT
            com.stepos.core.ota.download.control.DownloadVerdict r5 = r5.decide(r0, r1)
            java.lang.String r5 = r5.describe()
            java.lang.String r0 = "  verdict(SILENT) = "
            com.stepos.core.ota.d.r(r0, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.download.control.DownloadControlCenter.dump(java.io.PrintWriter):void");
    }

    public final DownloadController getController() {
        return this.controller;
    }

    public final DebuggableThermalProvider getThermalProvider() {
        return this.thermalProvider;
    }

    public final ThermalDownloadStrategy getThermalStrategy() {
        return this.thermalStrategy;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleDump(java.io.PrintWriter r5, java.util.List<java.lang.String> r6) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.download.control.DownloadControlCenter.handleDump(java.io.PrintWriter, java.util.List):void");
    }

    public final void injectTemperature(float f8) {
        this.thermalProvider.report(f8);
    }

    public final boolean loadConfigFile(String path) {
        Object objA;
        g.f(path, "path");
        try {
            objA = d.Z(new File(path), gc.a.f9106b);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (!(objA instanceof Result.Failure)) {
            objA = Boolean.valueOf(updateThermalConfig((String) objA));
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final void reloadThermalConfig() {
        ThermalConfigStore thermalConfigStore = this.configStore;
        Context appContext = this.appContext;
        g.e(appContext, "appContext");
        ThermalConfigStore.loadFromAssets$default(thermalConfigStore, appContext, null, 2, null);
        this.onConditionsChanged.invoke();
    }

    public final boolean selectScheme(String name) {
        g.f(name, "name");
        boolean zSelectScheme = this.configStore.selectScheme(name);
        if (zSelectScheme) {
            this.onConditionsChanged.invoke();
        }
        return zSelectScheme;
    }

    public final boolean setRateForTemp(float f8, int i10) {
        boolean rateForTemp = this.configStore.setRateForTemp(f8, i10);
        if (rateForTemp) {
            this.onConditionsChanged.invoke();
        }
        return rateForTemp;
    }

    public final void start() {
        instance = this;
        this.monitor.start();
        this.thermalBridge.start();
    }

    public final void stop() {
        this.thermalBridge.stop();
        this.monitor.stop();
        if (instance == this) {
            instance = null;
        }
    }

    public final boolean updateThermalConfig(String json) {
        g.f(json, "json");
        boolean zUpdate = this.configStore.update(json);
        if (zUpdate) {
            this.onConditionsChanged.invoke();
        }
        return zUpdate;
    }
}
