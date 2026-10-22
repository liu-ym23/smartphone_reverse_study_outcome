package com.obric.autogui.platforms.obric.e.a;

import android.content.Context;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.thermal.AOThermalLevel;
import com.obric.autogui.common.api.platform.thermal.IAutoActionThermalStateApi;
import com.obric.autogui.common.api.platform.thermal.IAutoActionThermalStateListener;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: ObricThermalStateManagerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements IAutoActionThermalStateApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f30119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AOThermalLevel f30120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f30121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f f30122e;
    private final a f;

    /* JADX INFO: compiled from: ObricThermalStateManagerImpl.kt */
    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f30123a;

        a(b r1) {
            this.f30123a = r1;
        }

        @Override // com.obric.autogui.platforms.obric.e.a.d
        public void a(AOThermalLevel r2) {
            o.e(r2, "level");
            b.a(this.f30123a, r2);
        }
    }

    public b() {
        this.f30118a = "O-P-ThermalStateMgr";
        this.f30120c = AOThermalLevel.LEVEL_LIGHT;
        this.f = new a(this);
    }

    public static final /* synthetic */ void a(b r0, AOThermalLevel r1) {
        r0.a(r1);
    }

    private final void a(AOThermalLevel r5) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f30120c != r5) goto L6;
        boolean r0 = false;
    L8:
        monitor-exit(this);
        Loog.INSTANCE.i(this.f30118a, " - thermal level changed=" + r0 + ", -> " + r5);
        if (r0 == false) goto L15;
        Set r4 = ServiceManager.get().getServices(IAutoActionThermalStateListener.class);
        o.b(r4, "ServiceManager.get().getServices(T::class.java)");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r6.hasNext() == false) goto L22;
        ((IAutoActionThermalStateListener) ZeusTransformUtils.preCheckCast(r6.next(), IAutoActionThermalStateListener.class, "com.obric.aiagent.plugin")).onThermalLevelChanged(r5);
        goto L13
    L22:
        return;
    L15:
        return;
    L6:
        this.f30120c = r5;     // Catch: Throwable -> L16
        this.f30121d = AOSystemTools.INSTANCE.nowTimeMillis();     // Catch: Throwable -> L16
        r0 = true;
        goto L8
    }

    @Override // com.obric.autogui.common.api.platform.thermal.IAutoActionThermalStateApi
    public void resetThermalState() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L11;
        Loog.INSTANCE.e(this.f30118a, "resetThermalState: appContext is null; cannot reset");
        return;
    L11:
        a().b(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Loog.INSTANCE.e(this.f30118a, "resetThermalState: reset thermal monitor failed", th);
    }

    @Override // com.obric.autogui.common.api.platform.thermal.IAutoActionThermalStateApi
    public void initThermalStateMonitor() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        Loog.INSTANCE.e(this.f30118a, "initThermalStateMonitor: appContext is null; cannot init");
        return;
    L6:
        f r1 = a();
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L9:
        if (this.f30119b == false) goto L14;
        Loog.INSTANCE.i(this.f30118a, "initThermalStateMonitor: already initialised");     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L14:
        this.f30119b = true;     // Catch: Throwable -> L21
        x r2 = x.f38692a;     // Catch: Throwable -> L21
        monitor-exit(this);
        r1.a(r0);     // Catch: Throwable -> L18
        Loog.INSTANCE.i(this.f30118a, "initThermalStateMonitor: " + r1.a() + " initialised");     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Loog.INSTANCE.e(this.f30118a, "initThermalStateMonitor: init thermal monitor failed", th);
    }

    @Override // com.obric.autogui.common.api.platform.thermal.IAutoActionThermalStateApi
    public IAutoActionThermalStateApi.ThermalLevelState getThermalLevelState() {
        monitor-enter(this);
        IAutoActionThermalStateApi.ThermalLevelState r0 = new IAutoActionThermalStateApi.ThermalLevelState(this.f30120c, this.f30121d);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private final f a() {
        monitor-enter(this);
        f r0 = this.f30122e;     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = e.f30129a.a((d) ZeusTransformUtils.preCheckCast(this.f, d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        Loog.INSTANCE.i(this.f30118a, " - [thermal] selected monitor strategy: " + r0.a());     // Catch: Throwable -> L8
        this.f30122e = r0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }
}
