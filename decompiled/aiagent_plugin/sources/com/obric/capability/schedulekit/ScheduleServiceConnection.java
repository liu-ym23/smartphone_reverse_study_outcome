package com.obric.capability.schedulekit;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.common.ICapabilitySchedule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.z;
import d.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ScheduleServiceConnection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ScheduleServiceConnection implements ServiceConnection {
    public static final ScheduleServiceConnection INSTANCE = null;
    public static final String SVR_NAME = "com.obric.capability.schedule.SCHEDULE_SERVICE";
    private static final String TAG = "ScheduleServiceConnection";
    private static d mApi;
    private static a mBindState;
    private static final Object stateLock = null;

    /* JADX INFO: compiled from: ScheduleServiceConnection.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f31842a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f31843b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f31844c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f31845d = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f31842a, f31843b, f31844c};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f31845d.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f31842a = new a("NotStart", 0);
            f31843b = new a("Started", 1);
            f31844c = new a("Connected", 2);
            f31845d = a();
        }
    }

    private ScheduleServiceConnection() {
    }

    public static final /* synthetic */ Object access$getStateLock$p() {
        return stateLock;
    }

    public static final /* synthetic */ void access$setMApi$p(d r2) {
        mApi = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
    }

    static {
        INSTANCE = new ScheduleServiceConnection();
        stateLock = new Object();
        mBindState = a.f31842a;
    }

    public final a getMBindState() {
        return mBindState;
    }

    public final void setMBindState(a r1) {
        o.e(r1, "<set-?>");
        mBindState = r1;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName r4) {
        com.obric.capability.schedulekit.c.c.f31906a.i(TAG, "onNullBinding: " + Thread.currentThread().getName());
        Object r5 = stateLock;
        monitor-enter(r5);
        mBindState = a.f31842a;     // Catch: Throwable -> L12
        mApi = null;     // Catch: Throwable -> L12
        x r0 = x.f38692a;     // Catch: Throwable -> L12
        monitor-exit(r5);
        n.a r6 = n.f38560a;     // Catch: Throwable -> L8
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.capability.schedulekit.a.c.f31868a.a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), (ServiceConnection) ZeusTransformUtils.preCheckCast((ScheduleServiceConnection) ZeusTransformUtils.preCheckCast(this, ScheduleServiceConnection.class, "com.obric.aiagent.plugin"), ServiceConnection.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        com.obric.capability.schedulekit.a.f31846a.a();
        return;
    L8:
        th = move-exception;
        n.a r7 = n.f38560a;
        n.f(d.o.a(th));
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r4, IBinder r5) {
        final IBinder r3 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
        com.obric.capability.schedulekit.c.c.f31906a.i(TAG, "onServiceConnected: " + Thread.currentThread().getName());
        Object r6 = stateLock;
        monitor-enter(r6);
        mBindState = a.f31844c;     // Catch: Throwable -> L18
        n.a r7 = n.f38560a;     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        r3.linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(new ScheduleServiceConnection$onServiceConnected$1$1$binder$1$1(r3), IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0);     // Catch: Throwable -> L11
    L9:
        ICapabilitySchedule r8 = ICapabilitySchedule.Stub.asInterface(r3);     // Catch: Throwable -> L11
        o.c(r8, "asInterface(binder)");     // Catch: Throwable -> L11
        g r9 = new g(r8);     // Catch: Throwable -> L11
        com.obric.capability.schedulekit.c.c.f31906a.i(TAG, "get ICapabilitySchedule Interface ");     // Catch: Throwable -> L11
        mApi = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        com.obric.capability.schedulekit.a.f31846a.b();     // Catch: Throwable -> L11
        Object r10 = n.f(x.f38692a);     // Catch: Throwable -> L11
    L13:
        Throwable r11 = n.c(r10);     // Catch: Throwable -> L18
        if (r11 == null) goto L16;
        com.obric.capability.schedulekit.c.c.f31906a.e(TAG, "onServiceConnected throw exception: " + d.a.a(r11));     // Catch: Throwable -> L18
    L16:
        monitor-exit(r6);
        return;
    L8:
        r3 = null;
    L11:
        th = move-exception;
        n.a r12 = n.f38560a;     // Catch: Throwable -> L18
        r10 = n.f(d.o.a(th));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r2) {
        com.obric.capability.schedulekit.c.c.f31906a.i(TAG, "onServiceDisconnected");
        Object r1 = stateLock;
        monitor-enter(r1);
        mBindState = a.f31842a;     // Catch: Throwable -> L8
        mApi = null;     // Catch: Throwable -> L8
        x r3 = x.f38692a;     // Catch: Throwable -> L8
        monitor-exit(r1);
        com.obric.capability.schedulekit.a.f31846a.a();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final d getApi$capabilityschedulekit_release(int r13) {
        Object r0 = stateLock;
        monitor-enter(r0);
        d r1 = mApi;     // Catch: Throwable -> L74
        if (r1 == null) goto L77;
        monitor-exit(r0);
        return r1;
    L77:
        n.a r2 = n.f38560a;     // Catch: Throwable -> L57
        if (mBindState != a.f31842a) goto L55;
        com.obric.capability.schedulekit.c.c.f31906a.i(TAG, "start to bind service");     // Catch: Throwable -> L57
        Intent r3 = new Intent(SVR_NAME);     // Catch: Throwable -> L57
        List<ResolveInfo> r4 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.capability.schedulekit.a.c.f31868a.a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().queryIntentServices(r3, 0);     // Catch: Throwable -> L57
        o.c(r4, "packageManager.queryIntentServices(intent, 0)");     // Catch: Throwable -> L57
        ServiceInfo r5 = null;
        Object r6 = null;
        if (r4 == null) goto L25;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L57
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L57
        Iterator r9 = r7.iterator();     // Catch: Throwable -> L57
    L14:
        if (r9.hasNext() == false) goto L18;
        ServiceInfo r10 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r9.next(), ResolveInfo.class, "com.obric.aiagent.plugin")).serviceInfo;     // Catch: Throwable -> L57
        if (r10 == null) goto L14;
        r8.add(r10);     // Catch: Throwable -> L57
        goto L14
    L18:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L57
    L20:
        if (r11.hasNext() == false) goto L24;
        Object r12 = r11.next();     // Catch: Throwable -> L57
        if (PackageUtils.INSTANCE.checkSignature(((ServiceInfo) ZeusTransformUtils.preCheckCast(r12, ServiceInfo.class, "com.obric.aiagent.plugin")).packageName) == false) goto L20;
        r6 = r12;
    L24:
        r5 = (ServiceInfo) ZeusTransformUtils.preCheckCast(r6, ServiceInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L57
    L25:
        if (r5 == null) goto L27;
        r3.setComponent(new ComponentName(r5.packageName, r5.name));     // Catch: Throwable -> L57
        r3.setPackage(r5.packageName);     // Catch: Throwable -> L57
    L27:
        com.obric.capability.schedulekit.a.f31846a.a(false);     // Catch: Throwable -> L57
        z.a r14 = new z.a();     // Catch: Throwable -> L57
        int r15 = 0;
    L28:
        if (r15 >= 3) goto L48;
        if (r14.f38499a == true) goto L46;
        n.a r16 = n.f38560a;     // Catch: Throwable -> L37
        if (ZeusTransformUtils.startService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.capability.schedulekit.a.c.f31868a.a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), r3, "com.obric.aiagent.plugin") == null) goto L34;
        boolean r17 = true;
    L35:
        Object r18 = n.f(Boolean.valueOf(r17));     // Catch: Throwable -> L37
    L39:
        Throwable r19 = n.c(r18);     // Catch: Throwable -> L57
        if (r19 == null) goto L43;
        com.obric.capability.schedulekit.c.c.f31906a.e(TAG, "startService attempt " + (r15 + 1) + " failed: " + d.a.a(r19));     // Catch: Throwable -> L57
    L43:
        if (n.b(r18) == false) goto L45;
        r18 = false;
    L45:
        r14.f38499a = ((Boolean) ZeusTransformUtils.preCheckCast(r18, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L57
        goto L46
    L34:
        r17 = false;
    L37:
        th = move-exception;
        n.a r20 = n.f38560a;     // Catch: Throwable -> L57
        r18 = n.f(d.o.a(th));     // Catch: Throwable -> L57
    L46:
        r15 = r15 + 1;     // Catch: Throwable -> L57
        goto L28
    L48:
        if (r14.f38499a == false) goto L54;
        if (ZeusTransformUtils.bindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.capability.schedulekit.a.c.f31868a.a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), r3, (ServiceConnection) ZeusTransformUtils.preCheckCast(this, ServiceConnection.class, "com.obric.aiagent.plugin"), r13, "com.obric.aiagent.plugin") == false) goto L52;
        mBindState = a.f31843b;     // Catch: Throwable -> L57
        goto L55
    L52:
        com.obric.capability.schedulekit.c.c.f31906a.i(TAG, "bindService fail");     // Catch: Throwable -> L57
        mBindState = a.f31842a;     // Catch: Throwable -> L57
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.capability.schedulekit.a.c.f31868a.a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), (ServiceConnection) ZeusTransformUtils.preCheckCast(this, ServiceConnection.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L57
        goto L55
    L54:
        throw new IllegalStateException("startService failed after 3 attempts");     // Catch: Throwable -> L57
    L55:
        Object r110 = n.f(x.f38692a);     // Catch: Throwable -> L57
    L59:
        Throwable r111 = n.c(r110);     // Catch: Throwable -> L74
        if (r111 == null) goto L69;
        com.obric.capability.schedulekit.c.c.f31906a.e(TAG, "bindService throw exception: " + d.a.a(r111));     // Catch: Throwable -> L74
        mBindState = a.f31842a;     // Catch: Throwable -> L74
        n.a r112 = n.f38560a;     // Catch: Throwable -> L64
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.capability.schedulekit.a.c.f31868a.a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), (ServiceConnection) ZeusTransformUtils.preCheckCast(this, ServiceConnection.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L64
        Object r113 = n.f(x.f38692a);     // Catch: Throwable -> L64
    L66:
        Throwable r114 = n.c(r113);     // Catch: Throwable -> L74
        if (r114 == null) goto L69;
        com.obric.capability.schedulekit.c.c.f31906a.e(TAG, "unbindService throw exception: " + d.a.a(r114));     // Catch: Throwable -> L74
        goto L69
    L64:
        th = move-exception;
        n.a r115 = n.f38560a;     // Catch: Throwable -> L74
        r113 = n.f(d.o.a(th));     // Catch: Throwable -> L74
    L69:
        d r116 = mApi;     // Catch: Throwable -> L74
        if (r116 != null) goto L72;
        r116 = (d) ZeusTransformUtils.preCheckCast(b.f31875a, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L74
    L72:
        monitor-exit(r0);
        return r116;
    L57:
        th = move-exception;
        n.a r21 = n.f38560a;     // Catch: Throwable -> L74
        r110 = n.f(d.o.a(th));     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        throw th;
    }
}
