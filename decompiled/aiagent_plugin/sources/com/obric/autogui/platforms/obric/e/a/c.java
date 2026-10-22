package com.obric.autogui.platforms.obric.e.a;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.thermal.AOThermalLevel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.s;
import java.util.Map;

/* JADX INFO: compiled from: PowerManagerThermalMonitorStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f30124a = null;
    private static final Map<Integer, AOThermalLevel> f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f30125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f30126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f30127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PowerManager.OnThermalStatusChangedListener f30128e;

    /* JADX INFO: compiled from: PowerManagerThermalMonitorStrategy.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: lambda$xmwCL-XDsisCnJV6Te_VyOyw4To, reason: not valid java name */
    public static /* synthetic */ void m851lambda$xmwCLXDsisCnJV6Te_VyOyw4To(c r0, int r1) {
        a(r0, r1);
    }

    public c(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        o.e(r4, "thermalLevelEmitter");
        this.f30125b = r4;
        this.f30126c = "PowerManagerThermalMonitor";
        this.f30127d = "O-P-PowerThermal";
        this.f30128e = new $$Lambda$c$xmwCLXDsisCnJV6Te_VyOyw4To(this);
    }

    @Override // com.obric.autogui.platforms.obric.e.a.f
    public String a() {
        return this.f30126c;
    }

    private static final void a(c r0, int r1) {
        r0.a(r1);
    }

    @Override // com.obric.autogui.platforms.obric.e.a.f
    public void a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        PowerManager r7 = a(r6, "init");
        if (r7 != null) goto L11;
        return;
    L11:
        r7.addThermalStatusListener(this.f30128e);     // Catch: Throwable -> L8
        Loog.INSTANCE.i(this.f30127d, "init: thermal status listener registered");     // Catch: Throwable -> L8
        a(r7, "init");
        return;
    L8:
        th = move-exception;
        Loog.INSTANCE.e(this.f30127d, "init: addThermalStatusListener failed", th);
    }

    @Override // com.obric.autogui.platforms.obric.e.a.f
    public void b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        PowerManager r5 = a(r4, "reset");
        if (r5 != null) goto L5;
        return;
    L5:
        a(r5, "reset");
    }

    private final PowerManager a(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        Loog.INSTANCE.w(this.f30127d, r6 + ": PowerManager thermal API requires API 29+");
        return null;
    L6:
        PowerManager r8 = (PowerManager) ZeusTransformUtils.preCheckCast(r7.getSystemService(PowerManager.class), PowerManager.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L10;
        Loog.INSTANCE.e(this.f30127d, r6 + ": cannot acquire PowerManager");
        return null;
    L10:
        return r8;
    }

    private final void a(PowerManager r5, String r6) {
        int r7 = r5.getCurrentThermalStatus();     // Catch: Throwable -> L4
        Loog.INSTANCE.i(this.f30127d, r6 + ": current thermal status=" + r7);     // Catch: Throwable -> L4
        a(r7);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Loog.INSTANCE.e(this.f30127d, r6 + ": currentThermalStatus failed", th);
    }

    private final void a(int r6) {
        AOThermalLevel r0 = (AOThermalLevel) ZeusTransformUtils.preCheckCast(f.get(Integer.valueOf(r6)), AOThermalLevel.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = AOThermalLevel.LEVEL_LIGHT;
    L5:
        Loog.INSTANCE.i(this.f30127d, "onThermalStatusUpdated: rawStatus=" + r6 + ", mappedLevel=" + r0);
        this.f30125b.a(r0);
    }

    static {
        f30124a = new a(null);
        f = ao.a(new m[]{s.a(1, AOThermalLevel.LEVEL_LIGHT), s.a(2, AOThermalLevel.LEVEL_MODERATE), s.a(3, AOThermalLevel.LEVEL_SEVERE), s.a(4, AOThermalLevel.LEVEL_CRITICAL), s.a(5, AOThermalLevel.LEVEL_EMERGENCY), s.a(6, AOThermalLevel.LEVEL_SHUTDOWN)});
    }
}
