package com.obric.aiagent.performance;

import android.app.Application;
import android.content.Context;
import com.google.gson.Gson;
import com.obric.aiagent.assistant.idl.IFlowAppStateIDL;
import com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL;
import com.obric.aiagent.assistant.idl.s;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ICloudConfig;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.performance.power.monitor.constants.ObricPerformancePowerMonitorConfig;
import com.obric.performance.power.monitor.constants.d;
import com.obric.performance.power.monitor.constants.e;
import com.obric.performance.power.monitor.constants.f;
import com.obric.performance.power.monitor.cpu.exception.CPUExceptionDiagnosisConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.o;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: PerformanceMonitorImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PerformanceMonitorImpl implements IPerformanceMonitor {

    /* JADX INFO: compiled from: PerformanceMonitorImpl.kt */
    public static final class a implements d {
        a() {
        }

        @Override // com.obric.performance.power.monitor.constants.d
        public void a(String r1, JSONObject r2) {
            o.e(r1, "eventName");
            o.e(r2, "data");
            com.obric.aiagent.flow.applog.a.f18577a.a(r1, r2);
        }
    }

    /* JADX INFO: compiled from: PerformanceMonitorImpl.kt */
    public static final class b implements com.obric.performance.power.monitor.constants.c {
        b() {
        }

        @Override // com.obric.performance.power.monitor.constants.c
        public void a(d.h.a.b<? super Boolean, x> r3) {
            final d.h.a.b r2 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            o.e(r2, "listener");
            IFlowAppStateIDL r4 = s.a(aa.b(IFlowAppStateIDL.class));
            if (r4 == null) goto L6;
            r4.registerAppStateListener((IFlowOnAppStateChangedListenerIDL) ZeusTransformUtils.preCheckCast(new PerformanceMonitorImpl$init$appBackgroundDelegate$1$addOnAppBackGroundListener$1(r2), IFlowOnAppStateChangedListenerIDL.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // com.obric.performance.power.monitor.constants.c
        public boolean a() {
            IFlowAppStateIDL r0 = s.a(aa.b(IFlowAppStateIDL.class));
            if (r0 != null) goto L7;
            return true;
        L7:
            return r0.isAppBackground();
        }

        @Override // com.obric.performance.power.monitor.constants.c
        public String b() {
            IFlowAppStateIDL r0 = s.a(aa.b(IFlowAppStateIDL.class));
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getCurrentActivity();
        }
    }

    /* JADX INFO: compiled from: PerformanceMonitorImpl.kt */
    public static final class c implements e {
        public static /* synthetic */ void lambda$hJO3k7czVZtB2cDsoQHXpjjXyxU(d.h.a.b r0, boolean r1) {
            a(r0, r1);
        }

        c() {
        }

        @Override // com.obric.performance.power.monitor.constants.e
        public void a(d.h.a.b<? super Boolean, x> r2) {
            final d.h.a.b r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
            o.e(r1, "listener");
            com.obric.aiagent.utils.a.b.f22307a.a(new $$Lambda$PerformanceMonitorImpl$c$hJO3k7czVZtB2cDsoQHXpjjXyxU(r1));
        }

        private static final void a(d.h.a.b r2, boolean r3) {
            ((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(Boolean.valueOf(r3));
        }

        @Override // com.obric.performance.power.monitor.constants.e
        public boolean a() {
            return com.obric.aiagent.utils.a.b.f22307a.a();
        }
    }

    public PerformanceMonitorImpl() {
    }

    @Override // com.obric.aiagent.performance.IPerformanceMonitor
    public void init() {
        ILogDepend.Companion.d("PerformanceMonitorImpl", "init");
        Gson r0 = new Gson();
        JSONObject r2 = ICloudConfig.Companion.getSettingsConfig("obric_performance_power_monitor_config");
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.toString();
    L6:
        ObricPerformancePowerMonitorConfig r1 = (ObricPerformancePowerMonitorConfig) ZeusTransformUtils.preCheckCast(r0.fromJson(r4, ObricPerformancePowerMonitorConfig.class), ObricPerformancePowerMonitorConfig.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L9;
        r1 = new ObricPerformancePowerMonitorConfig(false, false, 0, 0, 0.0f, 0.0f, 63, null);
    L9:
        ObricPerformancePowerMonitorConfig r18 = r1;
        b r5 = new b();
        c r6 = new c();
        if (r18.getAiagentEnabled() == false) goto L12;
        com.obric.performance.power.monitor.a r7 = com.obric.performance.power.monitor.a.f36932a;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r8, "getApplicationContext(...)");
        r7.a(new f(r8, r18, (d) ZeusTransformUtils.preCheckCast(new a(), d.class, "com.obric.aiagent.plugin"), (com.obric.performance.power.monitor.constants.c) ZeusTransformUtils.preCheckCast(r5, com.obric.performance.power.monitor.constants.c.class, "com.obric.aiagent.plugin"), (e) ZeusTransformUtils.preCheckCast(r6, e.class, "com.obric.aiagent.plugin")));
    L13:
        Gson r9 = new Gson();
        JSONObject r10 = ICloudConfig.Companion.getSettingsConfig("obric_performance_cpu_exception_diagnosis_config");
        if (r10 == null) goto L16;
        r3 = r10.toString();
    L16:
        CPUExceptionDiagnosisConfig r11 = (CPUExceptionDiagnosisConfig) ZeusTransformUtils.preCheckCast(r9.fromJson(r3, CPUExceptionDiagnosisConfig.class), CPUExceptionDiagnosisConfig.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L20;
        r11 = new CPUExceptionDiagnosisConfig(false, false, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 0, 0, 0, false, null, null, null, 32767, null);
    L20:
        if (r11.getAiagentEnable() == false) goto L22;
        com.obric.performance.power.monitor.cpu.exception.a.f36974a.a(r11, (com.obric.performance.power.monitor.constants.c) ZeusTransformUtils.preCheckCast(r5, com.obric.performance.power.monitor.constants.c.class, "com.obric.aiagent.plugin"), (e) ZeusTransformUtils.preCheckCast(r6, e.class, "com.obric.aiagent.plugin"));
        return;
    L22:
        ILogDepend.Companion.d("PerformanceMonitorImpl", "cpu exception diagnosis aiagent disabled, return");
        return;
    L12:
        ILogDepend.Companion.d("PerformanceMonitorImpl", "PowerMonitor aiagent disabled, return");
        goto L13
    L5:
        r4 = null;
        goto L6
    }
}
