package com.obric.aiagent.product.platform.impl.e;

import android.os.IBinder;
import com.obric.aiagent.product.platform.api.sleepmode.IObricSleepModeManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: AssistantSleepModeManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements IObricSleepModeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0404a f18839a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f18840b;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistantSleepModeManagerImpl.kt */
    public static final class C0404a {
        public /* synthetic */ C0404a(h r1) {
            this();
        }

        private C0404a() {
        }
    }

    static {
        f18839a = new C0404a(null);
    }

    public a() {
    }

    @Override // com.obric.aiagent.product.platform.api.sleepmode.IObricSleepModeManager
    public boolean inSleepMode() {
        Object r4 = a();     // Catch: Throwable -> L8
        if (r4 != null) goto L6;
        return false;
    L6:
        Method r1 = r4.getClass().getMethod("inSleepMode", new Class[0]);     // Catch: Throwable -> L8
        r1.setAccessible(true);     // Catch: Throwable -> L8
        Object r5 = r1.invoke(r4, new Object[0]);     // Catch: Throwable -> L8
        o.a(r5, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L8
        return ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.sleepmode.IObricSleepModeManager
    public void forceExitSleepMode(String r8, String r9) {
        o.e(r8, "pkgName");
        o.e(r9, "event");
        Object r7 = a();     // Catch: Throwable -> L8
        if (r7 != null) goto L6;
        return;
    L6:
        Method r0 = r7.getClass().getMethod("forceExitSleepMode", new Class[]{String.class, String.class});     // Catch: Throwable -> L8
        r0.setAccessible(true);     // Catch: Throwable -> L8
        r0.invoke(r7, new Object[]{r8, r9});     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
    }

    private final Object a() {
        monitor-enter(this);
        Object r0 = this.f18840b;     // Catch: Throwable -> L18
        if (r0 == null) goto L7;
        monitor-exit(this);
        return r0;
    L7:
        Object r1 = null;
        Method r2 = ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.aiagent.plugin").getMethod("getService", new Class[]{String.class});     // Catch: Throwable -> L14
        r2.setAccessible(true);     // Catch: Throwable -> L14
        Object r3 = r2.invoke(null, new Object[]{"poweradvisor"});     // Catch: Throwable -> L14
        Object r4 = ZeusTransformUtils.forName("android.os.IPowerAdvisor$Stub", "com.obric.aiagent.plugin").getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r3});     // Catch: Throwable -> L14
        if (r4 == null) goto L12;
        this.f18840b = r4;     // Catch: Throwable -> L14
        r1 = r4;
        goto L12
    L12:
        monitor-exit(this);
        return r1;
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L18
        return null;
    L18:
        th = move-exception;
        throw th;
    }
}
