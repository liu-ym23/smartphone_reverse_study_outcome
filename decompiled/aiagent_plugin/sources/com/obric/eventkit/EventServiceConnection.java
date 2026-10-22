package com.obric.eventkit;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.obric.capabilitykit.PackageUtils;
import com.obric.eventkit.apphost.AppHost;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.eventkit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.z;
import d.n;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EventServiceConnection implements ServiceConnection {
    public static final EventServiceConnection INSTANCE = null;
    private static final int MAX_RETRY_TIMES = 3;
    public static final String SVR_NAME = "com.obric.aiagent.executionengine.TASK_MANAGER_SERVICE";
    private static final String TAG = "EventServiceConnection";
    private static IEventProxy mApi;
    private static a mBindState;
    private static final Handler mHandler = null;
    private static int retryTimes;
    private static final Object stateLock = null;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f33043a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f33044b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f33045c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ a[] f33046d = null;

        static {
            f33043a = new a("NotStart", 0);
            f33044b = new a("Started", 1);
            f33045c = new a("Connected", 2);
            f33046d = a();
        }

        public a(String r1, int r2) {
            super(r1, r2);
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{f33043a, f33044b, f33045c};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f33046d.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    public static final class b implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBinder f33047a;

        public b(IBinder r3) {
            this.f33047a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = EventServiceConnection.access$getStateLock$p();
            monitor-enter(r0);
            EventServiceConnection.INSTANCE.setMBindState(a.f33043a);     // Catch: Throwable -> L8
            EventServiceConnection.access$setMApi$p(null);     // Catch: Throwable -> L8
            monitor-exit(r0);
            this.f33047a.unlinkToDeath(this, 0);
            EventsTaskSdk r3 = EventsTaskSdk.INSTANCE;
            r3.binderDied$eventstaskkit_release();
            r3.onConnectionClosed$eventstaskkit_release();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
        INSTANCE = new EventServiceConnection();
        stateLock = new Object();
        mHandler = new Handler(Looper.getMainLooper());
        mBindState = a.f33043a;
    }

    private EventServiceConnection() {
    }

    public static final /* synthetic */ Object access$getStateLock$p() {
        return stateLock;
    }

    public static final /* synthetic */ void access$setMApi$p(IEventProxy r2) {
        mApi = (IEventProxy) ZeusTransformUtils.wrapperContextForParams(r2, IEventProxy.class, "com.obric.aiagent.plugin");
    }

    private static final void getApi$lambda$21$lambda$17$lambda$16(EventServiceConnection r5) {
        o.e(r5, "this$0");
        Object r0 = stateLock;
        monitor-enter(r0);
        EventServiceConnection r1 = INSTANCE;     // Catch: Throwable -> L12
        if (mBindState == a.f33044b) goto L7;
    L9:
        retryTimes++;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L7:
        if (retryTimes > 3) goto L9;
        Logger.INSTANCE.i(TAG, "events bindService fail timeout 10s");     // Catch: Throwable -> L12
        mBindState = a.f33043a;     // Catch: Throwable -> L12
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), r5, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        r1.getApi$eventstaskkit_release();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void lambda$uqKPnUe8ygC5XtD9eMGH1PamePA(EventServiceConnection r0) {
        getApi$lambda$21$lambda$17$lambda$16(r0);
    }

    public final IEventProxy getApi$eventstaskkit_release() {
        Object r0 = stateLock;
        monitor-enter(r0);
        IEventProxy r1 = mApi;     // Catch: Throwable -> L84
        if (r1 == null) goto L10;
        monitor-exit(r0);
        return r1;
    L10:
        Logger.INSTANCE.i(TAG, "events getApi() " + mApi + ' ' + mBindState);     // Catch: Throwable -> L84
    L57:
        th = move-exception;
        Object r2 = n.f(d.o.a(th));     // Catch: Throwable -> L84
    L65:
        Throwable r3 = n.c(r2);     // Catch: Throwable -> L84
        if (r3 != null) goto L69;
    L79:
        IEventProxy r13 = mApi;     // Catch: Throwable -> L84
        if (r13 != null) goto L82;
        r13 = EmptyEventProxy.INSTANCE;     // Catch: Throwable -> L84
    L82:
        monitor-exit(r0);
        return r13;
    L69:
        Logger.INSTANCE.e(TAG, "bindService throw exception: " + d.a.a(r3));     // Catch: Throwable -> L84
        mBindState = a.f33043a;     // Catch: Throwable -> L84
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), this, "com.obric.aiagent.plugin");     // Catch: Throwable -> L72
        Object r14 = n.f(x.f38692a);     // Catch: Throwable -> L72
    L74:
        Throwable r15 = n.c(r14);     // Catch: Throwable -> L84
        if (r15 == null) goto L79;
        Logger.INSTANCE.e(TAG, "unbindService throw exception: " + d.a.a(r15));     // Catch: Throwable -> L84
        goto L79
    L72:
        th = move-exception;
        r14 = n.f(d.o.a(th));     // Catch: Throwable -> L84
        goto L74
    L12:
        if (mBindState != a.f33043a) goto L62;
        Intent r4 = new Intent(SVR_NAME);     // Catch: Throwable -> L57
        List<ResolveInfo> r5 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().queryIntentServices(r4, 0);     // Catch: Throwable -> L57
        o.c(r5, "packageManager.queryIntentServices(intent, 0)");     // Catch: Throwable -> L57
        ServiceInfo r6 = null;
        Object r7 = null;
        if (r5 == null) goto L28;
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L57
        Iterator<T> r9 = r5.iterator();     // Catch: Throwable -> L57
    L17:
        if (r9.hasNext() == false) goto L21;
        ServiceInfo r10 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r9.next(), ResolveInfo.class, "com.obric.aiagent.plugin")).serviceInfo;     // Catch: Throwable -> L57
        if (r10 == null) goto L17;
        r8.add(r10);     // Catch: Throwable -> L57
        goto L17
    L21:
        Iterator r11 = r8.iterator();     // Catch: Throwable -> L57
    L23:
        if (r11.hasNext() == false) goto L27;
        Object r12 = r11.next();     // Catch: Throwable -> L57
        if (PackageUtils.INSTANCE.checkSignature(((ServiceInfo) ZeusTransformUtils.preCheckCast(r12, ServiceInfo.class, "com.obric.aiagent.plugin")).packageName) == false) goto L23;
        r7 = r12;
    L27:
        r6 = (ServiceInfo) ZeusTransformUtils.preCheckCast(r7, ServiceInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L57
    L28:
        if (r6 == null) goto L30;
        r4.setComponent(new ComponentName(r6.packageName, r6.name));     // Catch: Throwable -> L57
        r4.setPackage(r6.packageName);     // Catch: Throwable -> L57
    L30:
        EventsTaskSdk.INSTANCE.setPendingCallsExecuted$eventstaskkit_release(false);     // Catch: Throwable -> L57
        z.a r16 = new z.a();     // Catch: Throwable -> L57
        int r17 = 0;
    L31:
        if (r17 >= 3) goto L53;
        if (r16.f38499a == true) goto L51;
    L40:
        th = move-exception;
        Object r18 = n.f(d.o.a(th));     // Catch: Throwable -> L57
    L42:
        Throwable r19 = n.c(r18);     // Catch: Throwable -> L57
        if (r19 != null) goto L46;
    L47:
        Boolean r20 = Boolean.FALSE;     // Catch: Throwable -> L57
        if (n.b(r18) == false) goto L50;
        r18 = r20;
    L50:
        r16.f38499a = ((Boolean) ZeusTransformUtils.preCheckCast(r18, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L57
        goto L51
    L46:
        Logger.INSTANCE.e(TAG, "startService attempt " + (r17 + 1) + " failed: " + d.a.a(r19));     // Catch: Throwable -> L57
        goto L47
    L35:
        if (ZeusTransformUtils.startService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), r4, "com.obric.aiagent.plugin") == null) goto L37;
        boolean r21 = true;
    L38:
        r18 = n.f(Boolean.valueOf(r21));     // Catch: Throwable -> L40
    L37:
        r21 = false;
    L51:
        r17 = r17 + 1;     // Catch: Throwable -> L57
        goto L31
    L53:
        if (r16.f38499a == false) goto L61;
        AppHost.Companion r22 = AppHost.Companion;     // Catch: Throwable -> L57
        if (ZeusTransformUtils.bindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r22.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), r4, this, 32, "com.obric.aiagent.plugin") == false) goto L59;
        mBindState = a.f33044b;     // Catch: Throwable -> L57
        mHandler.postDelayed(new $$Lambda$EventServiceConnection$uqKPnUe8ygC5XtD9eMGH1PamePA(this), 10000);     // Catch: Throwable -> L57
        goto L62
    L59:
        Logger.INSTANCE.i(TAG, "bindService fail");     // Catch: Throwable -> L57
        mBindState = a.f33043a;     // Catch: Throwable -> L57
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r22.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), this, "com.obric.aiagent.plugin");     // Catch: Throwable -> L57
        goto L62
    L61:
        throw new IllegalStateException("startService failed after 3 attempts");     // Catch: Throwable -> L57
    L62:
        r2 = n.f(x.f38692a);     // Catch: Throwable -> L57
    L84:
        th = move-exception;
        throw th;
    }

    public final a getMBindState() {
        return mBindState;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName r3) {
        Logger.INSTANCE.i(TAG, "onNullBinding: " + Thread.currentThread().getName());
        Object r4 = stateLock;
        monitor-enter(r4);
        mBindState = a.f33043a;     // Catch: Throwable -> L12
        mApi = null;     // Catch: Throwable -> L12
        monitor-exit(r4);
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), this, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        EventsTaskSdk.INSTANCE.onConnectionClosed$eventstaskkit_release();
        return;
    L8:
        th = move-exception;
        n.f(d.o.a(th));
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r4, IBinder r5) {
        IBinder r3 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
        Logger r6 = Logger.INSTANCE;
        r6.i(TAG, "onServiceConnected: " + Thread.currentThread().getName());
        Object r7 = stateLock;
        monitor-enter(r7);
        mBindState = a.f33045c;     // Catch: Throwable -> L21
        if (r3 != null) goto L26;
        r3 = null;
    L11:
        ITaskManager r8 = ITaskManager.Stub.asInterface(r3);     // Catch: Throwable -> L8
        o.c(r8, "asInterface(binder)");     // Catch: Throwable -> L8
        EventProxy r1 = new EventProxy(r8);     // Catch: Throwable -> L8
        r6.i(TAG, "get ICapabilitySchedule Interface ");     // Catch: Throwable -> L8
        mApi = r1;     // Catch: Throwable -> L8
        retryTimes = 0;     // Catch: Throwable -> L8
        EventsTaskSdk.INSTANCE.onApiInitComplete$eventstaskkit_release();     // Catch: Throwable -> L8
        Object r9 = n.f(x.f38692a);     // Catch: Throwable -> L8
    L14:
        Throwable r10 = n.c(r9);     // Catch: Throwable -> L21
        if (r10 != null) goto L18;
    L19:
        monitor-exit(r7);
        return;
    L18:
        Logger.INSTANCE.e(TAG, "onServiceConnected throw exception: " + d.a.a(r10));     // Catch: Throwable -> L21
        goto L19
    L8:
        th = move-exception;
        r9 = n.f(d.o.a(th));     // Catch: Throwable -> L21
        goto L14
    L26:
        r3.linkToDeath(new b(r3), 0);     // Catch: Throwable -> L8
    L21:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r2) {
        Logger.INSTANCE.i(TAG, "events onServiceDisconnected");
        Object r1 = stateLock;
        monitor-enter(r1);
        mBindState = a.f33043a;     // Catch: Throwable -> L8
        mApi = null;     // Catch: Throwable -> L8
        monitor-exit(r1);
        EventsTaskSdk r3 = EventsTaskSdk.INSTANCE;
        r3.onServiceDisconnected$eventstaskkit_release();
        r3.onConnectionClosed$eventstaskkit_release();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void setMBindState(a r1) {
        o.e(r1, "<set-?>");
        mBindState = r1;
    }
}
