package com.obric.agent.utils;

import android.app.Application;
import android.app.KeyguardManager;
import android.net.ConnectivityManager;
import android.os.PowerManager;
import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ClientPhoneEnvInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15990a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f15991b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.f f15992c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final d.f f15993d = null;

    public static /* synthetic */ KeyguardManager lambda$2WhqiGPYUHwQpRKonzBn2lk1X7g() {
        return e();
    }

    public static /* synthetic */ PowerManager lambda$OyOYFIqXEUmy0p3r69vOMC1ztBg() {
        return d();
    }

    public static /* synthetic */ ConnectivityManager lambda$vXBYKlu28pg9vea73FdGltiDUdE() {
        return c();
    }

    private a() {
    }

    static {
        f15990a = new a();
        f15991b = d.g.a($$Lambda$a$vXBYKlu28pg9vea73FdGltiDUdE.INSTANCE);
        f15992c = d.g.a($$Lambda$a$OyOYFIqXEUmy0p3r69vOMC1ztBg.INSTANCE);
        f15993d = d.g.a($$Lambda$a$2WhqiGPYUHwQpRKonzBn2lk1X7g.INSTANCE);
    }

    public final ConnectivityManager a() {
        return (ConnectivityManager) ZeusTransformUtils.preCheckCast(f15991b.b(), ConnectivityManager.class, "com.obric.aiagent.plugin");
    }

    private static final ConnectivityManager c() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("connectivity");
        if (ZeusTransformUtils.instanceOf(r0, ConnectivityManager.class) == true) goto L7;
        return null;
    L7:
        return (ConnectivityManager) ZeusTransformUtils.preCheckCast(r0, ConnectivityManager.class, "com.obric.aiagent.plugin");
    }

    public final PowerManager b() {
        return (PowerManager) ZeusTransformUtils.preCheckCast(f15992c.b(), PowerManager.class, "com.obric.aiagent.plugin");
    }

    private static final PowerManager d() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("power");
        if (ZeusTransformUtils.instanceOf(r0, PowerManager.class) == true) goto L7;
        return null;
    L7:
        return (PowerManager) ZeusTransformUtils.preCheckCast(r0, PowerManager.class, "com.obric.aiagent.plugin");
    }

    private static final KeyguardManager e() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("keyguard");
        if (ZeusTransformUtils.instanceOf(r0, KeyguardManager.class) == true) goto L7;
        return null;
    L7:
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(r0, KeyguardManager.class, "com.obric.aiagent.plugin");
    }
}
