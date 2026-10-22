package com.obric.memorydata.sdk.awareness;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.ResultCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ContextAwareness.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33811a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile IContextAwarenessService f33812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ServiceConnection f33813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static IBinder f33814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static IBinder.DeathRecipient f33815e;
    private static final List<ResultCallback<Boolean>> f = null;
    private static volatile Context g;
    private static volatile int h;
    private static final ConcurrentHashMap<String, Set<c<?>>> i = null;
    private static final ConcurrentHashMap<String, IFeatureChangeListener> j = null;
    private static final ConcurrentHashMap<String, Set<com.obric.memorydata.sdk.awareness.b>> k = null;
    private static final ConcurrentHashMap<String, IEventChangeListener> l = null;
    private static final ConcurrentHashMap<b, Set<d>> m = null;
    private static final ConcurrentHashMap<b, IFeatureDurationListener> n = null;

    /* JADX INFO: renamed from: com.obric.memorydata.sdk.awareness.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ContextAwareness.kt */
    private static final class C0916a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f33816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ServiceConnection f33817b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final IBinder f33818c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final IBinder.DeathRecipient f33819d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0916a.class) == true) goto L8;
            return false;
        L8:
            C0916a r6 = (C0916a) ZeusTransformUtils.preCheckCast(r5, C0916a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f33816a, r6.f33816a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f33817b, r6.f33817b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f33818c, r6.f33818c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f33819d, r6.f33819d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            Context r0 = this.f33816a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.f33817b.hashCode()) * 31;
            IBinder r4 = this.f33818c;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            IBinder.DeathRecipient r7 = this.f33819d;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "BindingSnapshot(context=" + this.f33816a + ", connection=" + this.f33817b + ", binder=" + this.f33818c + ", deathRecipient=" + this.f33819d + ')';
        }

        public C0916a(Context r3, ServiceConnection r4, IBinder r5, IBinder.DeathRecipient r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            ServiceConnection r8 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.aiagent.plugin");
            IBinder r9 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
            IBinder.DeathRecipient r10 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r6, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");
            o.e(r8, WsConstants.KEY_CONNECTION);
            this.f33816a = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            this.f33817b = r8;
            this.f33818c = r9;
            this.f33819d = r10;
        }

        public final Context getContext() {
            return this.f33816a;
        }

        public final ServiceConnection a() {
            return this.f33817b;
        }

        public final IBinder b() {
            return this.f33818c;
        }

        public final IBinder.DeathRecipient c() {
            return this.f33819d;
        }
    }

    /* JADX INFO: compiled from: ContextAwareness.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f33820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f33821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f33822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f33823d;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f33820a, r10.f33820a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f33821b, r10.f33821b) == true) goto L15;
            return false;
        L15:
            if (this.f33822c == r10.f33822c) goto L18;
            return false;
        L18:
            if (this.f33823d == r10.f33823d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f33820a.hashCode() * 31) + this.f33821b.hashCode()) * 31) + Long.hashCode(this.f33822c)) * 31) + Boolean.hashCode(this.f33823d);
        }

        public String toString() {
            return "FeatureDurationKey(featureName=" + this.f33820a + ", targetFeatureValue=" + this.f33821b + ", durationSec=" + this.f33822c + ", oneShot=" + this.f33823d + ')';
        }

        public final String a() {
            return this.f33820a;
        }

        public final String b() {
            return this.f33821b;
        }

        public final long c() {
            return this.f33822c;
        }

        public final boolean d() {
            return this.f33823d;
        }
    }

    public static /* synthetic */ x lambda$EifEMWmnhoxcZ2fVXRT588hfUVo(C0916a r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$cfjcQ1IvMTndnxJkB-O6am5IgG4, reason: not valid java name */
    public static /* synthetic */ Boolean m952lambda$cfjcQ1IvMTndnxJkBO6am5IgG4(C0916a r0) {
        return b(r0);
    }

    public static /* synthetic */ void lambda$gkKIpiQPfDqWgERka3PMlUjm0Do() {
        k();
    }

    public static /* synthetic */ boolean lambda$ln8X6YafFI3QYTImsi0C0vDQZ1k(Context r0, Intent r1, ServiceConnection r2, int r3) {
        return a(r0, r1, r2, r3);
    }

    private a() {
    }

    public static final /* synthetic */ void a(IBinder.DeathRecipient r2) {
        f33815e = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(IBinder r2) {
        f33814d = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(IContextAwarenessService r2) {
        f33812b = (IContextAwarenessService) ZeusTransformUtils.wrapperContextForParams(r2, IContextAwarenessService.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(a r0) {
        r0.j();
    }

    public static final /* synthetic */ void a(a r2, ServiceConnection r3, IBinder r4) {
        r2.b((ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.aiagent.plugin"), (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(a r2, List r3, int r4, String r5) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public static final /* synthetic */ List b(a r0) {
        return r0.h();
    }

    public static final /* synthetic */ ServiceConnection c() {
        return f33813c;
    }

    public static final /* synthetic */ IBinder d() {
        return f33814d;
    }

    public static final /* synthetic */ IBinder.DeathRecipient e() {
        return f33815e;
    }

    public static final /* synthetic */ ConcurrentHashMap f() {
        return m;
    }

    public static final /* synthetic */ ConcurrentHashMap g() {
        return n;
    }

    static {
        f33811a = new a();
        f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        h = 64;
        i = new ConcurrentHashMap();
        j = new ConcurrentHashMap();
        k = new ConcurrentHashMap();
        l = new ConcurrentHashMap();
        m = new ConcurrentHashMap();
        n = new ConcurrentHashMap();
    }

    public final void a(com.obric.memorydata.sdk.a.c r2) {
        com.obric.memorydata.sdk.a.c r1 = (com.obric.memorydata.sdk.a.c) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.sdk.a.c.class, "com.obric.aiagent.plugin");
        com.obric.memorydata.sdk.a.d.f33797a.a(r1);
    }

    private final C0916a a(ServiceConnection r5, IBinder r6) {
        ServiceConnection r4 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r5, ServiceConnection.class, "com.obric.aiagent.plugin");
        IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r6, IBinder.class, "com.obric.aiagent.plugin");
        a r8 = f33811a;
        monitor-enter(r8);
        ServiceConnection r0 = f33813c;     // Catch: Throwable -> L18
        C0916a r1 = null;
        if (r0 == null) goto L16;
        if (r4 == null) goto L10;
        if (r4 != r0) goto L16;
    L10:
        if (r7 != null) goto L12;
    L14:
        C0916a r9 = new C0916a(g, r0, f33814d, f33815e);     // Catch: Throwable -> L18
        f33812b = null;     // Catch: Throwable -> L18
        f33813c = null;     // Catch: Throwable -> L18
        f33814d = null;     // Catch: Throwable -> L18
        f33815e = null;     // Catch: Throwable -> L18
        r1 = r9;
        goto L16
    L12:
        if (r7 == f33814d) goto L14;
    L16:
        monitor-exit(r8);
        return r1;
    L18:
        th = move-exception;
        throw th;
    }

    private final void a(final C0916a r1) {
        com.obric.memorydata.sdk.c.a(new $$Lambda$a$cfjcQ1IvMTndnxJkBO6am5IgG4(r1));
        com.obric.memorydata.sdk.c.a(new $$Lambda$a$EifEMWmnhoxcZ2fVXRT588hfUVo(r1));
    }

    private static final Boolean b(C0916a r2) {
        IBinder.DeathRecipient r0 = r2.c();
        if (r0 == null) goto L8;
        IBinder r3 = r2.b();
        if (r3 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r3.unlinkToDeath(r0, 0));
    L8:
        return null;
    }

    private static final x c(C0916a r3) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        ZeusTransformUtils.unbindService(r0, r3.a(), "com.obric.aiagent.plugin");
        return x.f38692a;
    L5:
        return null;
    }

    static /* synthetic */ void a(a r1, ServiceConnection r2, IBinder r3, int r4, Object r5) {
        ServiceConnection r6 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r2, ServiceConnection.class, "com.obric.aiagent.plugin");
        IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        r1.b(r6, r7);
    }

    private final void b(ServiceConnection r3, IBinder r4) {
        C0916a r5 = a((ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.aiagent.plugin"), (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin"));
        if (r5 != null) goto L5;
        return;
    L5:
        a(r5);
        i();
    }

    private final List<ResultCallback<Boolean>> h() {
        List<ResultCallback<Boolean>> r2 = f;
        List<ResultCallback<Boolean>> r0 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"));
        r2.clear();
        return r0;
    }

    private final void a(List<? extends ResultCallback<Boolean>> r3, int r4, String r5) {
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        ResultCallback r6 = (ResultCallback) ZeusTransformUtils.preCheckCast(r2.next(), ResultCallback.class, "com.obric.aiagent.plugin");
        if (r4 != 0) goto L8;
        boolean r1 = true;
    L9:
        r6.onResult(r4, r5, Boolean.valueOf(r1));
        goto L4
    L8:
        r1 = false;
        goto L9
    }

    private final ServiceInfo b(Context r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        Intent r8 = new Intent("com.obric.memorydata.awareness.CONTEXT_AWARENESS_SERVICE").setPackage("com.larus.nova");
        o.c(r8, "setPackage(...)");
        List<ResolveInfo> r9 = r6.getPackageManager().queryIntentServices(r8, 0);
        o.c(r9, "queryIntentServices(...)");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L13;
        Object r11 = r10.next();
        ResolveInfo r4 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r11, ResolveInfo.class, "com.obric.aiagent.plugin");
        if (r4.serviceInfo != null) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L4;
    L14:
        ResolveInfo r12 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r11, ResolveInfo.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L17;
        return null;
    L17:
        return r12.serviceInfo;
    L8:
        if (o.a(r4.serviceInfo.packageName, "com.larus.nova") == false) goto L10;
        r5 = true;
        goto L11
    L13:
        r11 = null;
        goto L14
    }

    public final boolean a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        ServiceInfo r3 = b(r5);
        if (r3 != null) goto L7;
        return false;
    L7:
        return com.obric.memorydata.sdk.a.a.f33795a.a(r5, new ComponentName(r3.packageName, r3.name));
    }

    public static /* synthetic */ void a(a r1, Context r2, ResultCallback r3, int r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        ResultCallback<Boolean> r8 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r3, ResultCallback.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 64;
    L8:
        r1.a(r7, r8, r4);
    }

    public final synchronized void a(Context r11, ResultCallback<Boolean> r12, int r13) {
        monitor-enter(this);
        final Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L49
        ResultCallback<Boolean> r15 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r12, ResultCallback.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L49
        o.e(r14, "context");     // Catch: Throwable -> L49
        g = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L49
        h = r13;     // Catch: Throwable -> L49
        Context r0 = g;     // Catch: Throwable -> L49
        boolean r1 = false;
        if (r0 == null) goto L8;
        ApplicationInfo r2 = r0.getApplicationInfo();     // Catch: Throwable -> L49
        if (r2 == null) goto L8;
        int r3 = r2.flags;     // Catch: Throwable -> L49
    L10:
        if ((r3 & 2) == 0) goto L12;
        boolean r4 = true;
    L13:
        com.obric.memorydata.sdk.a.d.f33797a.a(r4);     // Catch: Throwable -> L49
        if (a(r14) == true) goto L21;
        com.obric.memorydata.sdk.a.d.a(com.obric.memorydata.sdk.a.d.f33797a, "ContextAwareness", "ContextAwarenessService is disabled", null, 4, null);     // Catch: Throwable -> L49
        if (r15 == null) goto L18;
        r15.onResult(407, "ContextAwarenessService is disabled", false);     // Catch: Throwable -> L49
    L18:
        monitor-exit(this);
        return;
    L21:
        if (f33812b == null) goto L27;
        com.obric.memorydata.sdk.a.d.f33797a.a("ContextAwareness", "service already connected");     // Catch: Throwable -> L49
        if (r15 == null) goto L25;
        r15.onResult(0, "ContextAwarenessService is ready", true);     // Catch: Throwable -> L49
    L25:
        monitor-exit(this);
        return;
    L27:
        if (r15 == null) goto L30;
        f.add(r15);     // Catch: Throwable -> L49
    L30:
        if (f33813c != null) goto L46;
        f33813c = (ServiceConnection) ZeusTransformUtils.preCheckCast(new ContextAwareness$init$2(), ServiceConnection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L49
        ServiceInfo r16 = b(r14);     // Catch: Throwable -> L49
        if (r16 != null) goto L36;
        com.obric.memorydata.sdk.a.d.a(com.obric.memorydata.sdk.a.d.f33797a, "ContextAwareness", "No service found for action: com.obric.memorydata.awareness.CONTEXT_AWARENESS_SERVICE in com.larus.nova", null, 4, null);     // Catch: Throwable -> L49
        f33813c = null;     // Catch: Throwable -> L49
        a(h(), 404, "No service found for action");     // Catch: Throwable -> L49
        monitor-exit(this);
        return;
    L36:
        final Intent r5 = new Intent("com.obric.memorydata.awareness.CONTEXT_AWARENESS_SERVICE").setPackage(r16.packageName);     // Catch: Throwable -> L49
        o.c(r5, "setPackage(...)");     // Catch: Throwable -> L49
        final ServiceConnection r6 = f33813c;     // Catch: Throwable -> L49
        if (r6 == null) goto L44;
        final int r17 = r13 | 1;     // Catch: Throwable -> L49
        Boolean r18 = (Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.c.a(new $$Lambda$a$ln8X6YafFI3QYTImsi0C0vDQZ1k(r14, r5, r6, r17)), Boolean.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L49
        if (r18 == null) goto L41;
        r1 = r18.booleanValue();     // Catch: Throwable -> L49
    L41:
        com.obric.memorydata.sdk.a.d.f33797a.a("ContextAwareness", "bindService result: " + r1 + ", flags=" + r17 + ", component=" + r5.getComponent() + ", package=" + r16.packageName);     // Catch: Throwable -> L49
        if (r1 == true) goto L44;
        com.obric.memorydata.sdk.a.d.a(com.obric.memorydata.sdk.a.d.f33797a, "ContextAwareness", "bindService failed, package=" + r16.packageName, null, 4, null);     // Catch: Throwable -> L49
        a r19 = f33811a;     // Catch: Throwable -> L49
        f33813c = null;     // Catch: Throwable -> L49
        r19.a(r19.h(), 404, "bindService failed");     // Catch: Throwable -> L49
    L44:
        monitor-exit(this);
        return;
    L46:
        com.obric.memorydata.sdk.a.d.f33797a.a("ContextAwareness", "service binding in progress, callback queued");     // Catch: Throwable -> L49
        monitor-exit(this);
        return;
    L12:
        r4 = false;
    L8:
        r3 = 0;
    L49:
        th = move-exception;
        throw th;
    }

    private static final boolean a(Context r2, Intent r3, ServiceConnection r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        ServiceConnection r7 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.aiagent.plugin");
        return ZeusTransformUtils.bindService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, r7, r5, "com.obric.aiagent.plugin");
    }

    private final void i() {
        if (g != null) goto L6;
        com.obric.memorydata.sdk.a.d.a(com.obric.memorydata.sdk.a.d.f33797a, "ContextAwareness", "Context is null, cannot reconnect.", null, 4, null);
        return;
    L6:
        new Handler(Looper.getMainLooper()).postDelayed($$Lambda$a$gkKIpiQPfDqWgERka3PMlUjm0Do.INSTANCE, WsConstants.EXIT_DELAY_TIME);
    }

    private static final void k() {
        a r0 = f33811a;
        Context r1 = g;
        if (r1 != null) goto L6;
        com.obric.memorydata.sdk.a.d.f33797a.b("ContextAwareness", "Reconnect canceled after release");
        return;
    L6:
        com.obric.memorydata.sdk.a.d.f33797a.b("ContextAwareness", "Attempting to reconnect...");
        a(r0, r1, null, h, 2, null);
    }

    private final void j() {
        Set<String> r12 = i.keySet();
        o.c(r12, "<get-keys>(...)");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r13.hasNext() == false) goto L18;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");
        Set r5 = (Set) ZeusTransformUtils.preCheckCast(i.get(r1), Set.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L4;
        com.obric.memorydata.sdk.a.d.f33797a.a("ContextAwareness", "Retry registering feature: " + r1);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L4;
        IFeatureChangeListener r6 = (IFeatureChangeListener) ZeusTransformUtils.preCheckCast(j.get(r1), IFeatureChangeListener.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L17;
        IContextAwarenessService r3 = f33812b;     // Catch: RemoteException -> L15
        if (r3 == null) goto L4;
        r3.registerFeature(r1, r6);     // Catch: RemoteException -> L15
    L15:
        e = move-exception;
        com.obric.memorydata.sdk.a.d.f33797a.a("ContextAwareness", "Failed to re-register feature: " + r1, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        x r2 = x.f38692a;
        goto L4
    L17:
        com.obric.memorydata.sdk.a.d.a(com.obric.memorydata.sdk.a.d.f33797a, "ContextAwareness", "RemoteListener for feature " + r1 + " is null", null, 4, null);
        goto L4
    L18:
        Set<String> r14 = k.keySet();
        o.c(r14, "<get-keys>(...)");
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L20:
        if (r15.hasNext() == false) goto L34;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");
        Set r7 = (Set) ZeusTransformUtils.preCheckCast(k.get(r4), Set.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L20;
        com.obric.memorydata.sdk.a.d.f33797a.a("ContextAwareness", "Retry registering event: " + r4);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L20;
        IEventChangeListener r8 = (IEventChangeListener) ZeusTransformUtils.preCheckCast(l.get(r4), IEventChangeListener.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L33;
        IContextAwarenessService r9 = f33812b;     // Catch: RemoteException -> L31
        if (r9 == null) goto L20;
        r9.registerEvent(r4, r8);     // Catch: RemoteException -> L31
    L31:
        e = move-exception;
        com.obric.memorydata.sdk.a.d.f33797a.a("ContextAwareness", "Failed to re-register event: " + r4, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        x r10 = x.f38692a;
        goto L20
    L33:
        com.obric.memorydata.sdk.a.d.a(com.obric.memorydata.sdk.a.d.f33797a, "ContextAwareness", "RemoteListener for event " + r4 + " is null", null, 4, null);
        goto L20
    L34:
        Set<b> r16 = m.keySet();
        o.c(r16, "<get-keys>(...)");
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L36:
        if (r17.hasNext() == false) goto L50;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r17.next(), b.class, "com.obric.aiagent.plugin");
        Set r11 = (Set) ZeusTransformUtils.preCheckCast(m.get(r0), Set.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L36;
        com.obric.memorydata.sdk.a.d.f33797a.a("ContextAwareness", "Retry registering duration feature: " + r0);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L36;
        IFeatureDurationListener r18 = (IFeatureDurationListener) ZeusTransformUtils.preCheckCast(n.get(r0), IFeatureDurationListener.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L49;
        IContextAwarenessService r19 = f33812b;     // Catch: RemoteException -> L47
        if (r19 == null) goto L36;
        r19.registerFeatureDuration(r0.a(), r0.b(), r0.c(), r0.d(), r18);     // Catch: RemoteException -> L47
    L47:
        e = move-exception;
        com.obric.memorydata.sdk.a.d.f33797a.a("ContextAwareness", "Failed to re-register duration feature: " + r0, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        x r20 = x.f38692a;
        goto L36
    L49:
        com.obric.memorydata.sdk.a.d.a(com.obric.memorydata.sdk.a.d.f33797a, "ContextAwareness", "Remote duration listener for " + r0 + " is null", null, 4, null);
        goto L36
    }

    static /* synthetic */ boolean a(a r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 10000;
    L6:
        return r0.a(r1);
    }

    private final boolean a(long r5) {
        long r0 = System.currentTimeMillis();
    L4:
        if (f33812b != null) goto L11;
        if ((System.currentTimeMillis() - r0) >= r5) goto L11;
        Thread.sleep(50);     // Catch: InterruptedException -> L15
    L11:
        if (f33812b == null) goto L13;
        return true;
    L13:
        return false;
    }

    public final MemoryResponse<Location> a(e r8) {
        o.e(r8, "locationType");
        Context r0 = g;
        if (r0 != null) goto L7;
        return new MemoryResponse(404, "Context is null, please call init first", null, 4, null);
    L7:
        if (a(r0) == true) goto L11;
        return new MemoryResponse(407, "ContextAwarenessService is disabled", null, 4, null);
    L11:
        if (f33812b == null) goto L13;
    L32:
        IContextAwarenessService r7 = f33812b;     // Catch: RemoteException -> L29
        o.a(r7);     // Catch: RemoteException -> L29
        MemoryResponse<Location> r9 = r7.getLocation(r8.a());     // Catch: RemoteException -> L29
        if (r9.isSuccess() == false) goto L28;
        if (r9.getData() == null) goto L26;
        if (ZeusTransformUtils.instanceOf(r9.getData(), Location.class) == false) goto L26;
        o.a(r9, "null cannot be cast to non-null type com.obric.memorydata.sdk.MemoryResponse<android.location.Location>");     // Catch: RemoteException -> L29
        return r9;
    L26:
        return new MemoryResponse(405, "Location data is invalid", null, 4, null);
    L28:
        return new MemoryResponse(r9.getCode(), r9.getMessage(), null, 4, null);
    L29:
        e = move-exception;
        e.printStackTrace();
        return new MemoryResponse(400, "RemoteException: " + e.getMessage(), null, 4, null);
    L13:
        if (a(this, 0, 1, null) == true) goto L32;
        return new MemoryResponse(406, "Bind service timeout", null, 4, null);
    }

    public final MemoryResponse<Void> a(String r9, double r10, double r12, String r14, String r15) {
        o.e(r9, "locationType");
        o.e(r14, "name");
        o.e(r15, "detail");
        Context r0 = g;
        if (r0 != null) goto L7;
        return new MemoryResponse(404, "Context is null, please call init first", null, 4, null);
    L7:
        if (a(r0) == true) goto L11;
        return new MemoryResponse(407, "ContextAwarenessService is disabled", null, 4, null);
    L11:
        if (f33812b == null) goto L13;
    L31:
        IContextAwarenessService r1 = f33812b;     // Catch: RuntimeException -> L26 RemoteException -> L28
        if (r1 == null) goto L19;
        MemoryResponse r8 = r1.setLocation(r9, r10, r12, r14, r15);     // Catch: RuntimeException -> L26 RemoteException -> L28
        if (r8 != null) goto L33;
        return new MemoryResponse(404, "service response is null", null, 4, null);
    L33:
        return new MemoryResponse(r8.getCode(), r8.getMessage(), null, 4, null);
    L19:
        return new MemoryResponse(404, "service is null", null, 4, null);
    L28:
        e = move-exception;
        e.printStackTrace();
        return new MemoryResponse(400, "RemoteException: " + e.getMessage(), null, 4, null);
    L26:
        e = move-exception;
        e.printStackTrace();
        return new MemoryResponse(400, "RuntimeException: " + e.getMessage(), null, 4, null);
    L13:
        if (a(this, 0, 1, null) == true) goto L31;
        return new MemoryResponse(406, "Bind service timeout", null, 4, null);
    }

    public final <T> MemoryResponse<T> a(String r8) {
        o.e(r8, "featureName");
        Context r0 = g;
        if (r0 != null) goto L7;
        return new MemoryResponse(404, "Context is null, please call init first", null, 4, null);
    L7:
        if (a(r0) == true) goto L11;
        return new MemoryResponse(407, "ContextAwarenessService is disabled", null, 4, null);
    L11:
        if (f33812b == null) goto L13;
    L28:
        IContextAwarenessService r7 = f33812b;     // Catch: RemoteException -> L25
        o.a(r7);     // Catch: RemoteException -> L25
        MemoryResponse<T> r9 = r7.getFeature(r8);     // Catch: RemoteException -> L25
        if (r9 != null) goto L21;
        return new MemoryResponse(400, "Response is null", null, 4, null);
    L21:
        if (r9.isSuccess() == false) goto L24;
        return r9;
    L24:
        return new MemoryResponse(r9.getCode(), r9.getMessage(), null, 4, null);
    L25:
        e = move-exception;
        e.printStackTrace();
        return new MemoryResponse(400, "RemoteException: " + e.getMessage(), null, 4, null);
    L13:
        if (a(this, 0, 1, null) == true) goto L28;
        return new MemoryResponse(406, "Bind service timeout", null, 4, null);
    }

    public final ConcurrentHashMap<String, Set<c<?>>> a() {
        return i;
    }

    public final ConcurrentHashMap<String, Set<com.obric.memorydata.sdk.awareness.b>> b() {
        return k;
    }

    public final MemoryResponse<Void> a(String r4, String r5, AwarenessConditionConfig r6) {
        o.e(r4, "subscriptionId");
        o.e(r5, "featureName");
        o.e(r6, "condition");
        return a("register_persistent_feature_event", new PersistentAwarenessRegisterRequest(r4, new AwarenessTarget("feature", r5), r6));
    }

    public final MemoryResponse<Void> b(String r4, String r5, AwarenessConditionConfig r6) {
        o.e(r4, "subscriptionId");
        o.e(r5, "eventName");
        o.e(r6, "condition");
        return a("register_persistent_context_event", new PersistentAwarenessRegisterRequest(r4, new AwarenessTarget("event", r5), r6));
    }

    public final MemoryResponse<Void> a(String r10, double r11, double r13, int r15) {
        o.e(r10, "fenceId");
        Bundle r0 = new Bundle();
        r0.putParcelable("geofence_request", (Parcelable) ZeusTransformUtils.preCheckCast(new GeoFenceRequest(r10, r11, r13, r15), Parcelable.class, "com.obric.aiagent.plugin"));
        x r12 = x.f38692a;
        return a("add_geofence", r0);
    }

    public final MemoryResponse<Void> b(String r3) {
        o.e(r3, "fenceId");
        Bundle r0 = new Bundle();
        r0.putString("fence_id", r3);
        x r4 = x.f38692a;
        return a("remove_geofence", r0);
    }

    public final MemoryResponse<Void> c(String r3) {
        o.e(r3, "subscriptionId");
        Bundle r0 = new Bundle();
        r0.putString("subscription_id", r3);
        x r4 = x.f38692a;
        return a("unregister_persistent_subscription", r0);
    }

    private final MemoryResponse<Void> a(String r4, PersistentAwarenessRegisterRequest r5) {
        com.obric.memorydata.sdk.a.d.f33797a.b("ContextAwareness", "registerPersistentSubscription method=" + r4 + " subscriptionId=" + r5.getSubscriptionId() + " target=" + r5.getTarget().getTargetType() + '/' + r5.getTarget().getTargetName());
        Bundle r0 = new Bundle();
        r0.putParcelable("register_request", (Parcelable) ZeusTransformUtils.preCheckCast(r5, Parcelable.class, "com.obric.aiagent.plugin"));
        x r6 = x.f38692a;
        return a(r4, r0);
    }

    private final MemoryResponse<Void> a(String r8, Bundle r9) {
        Context r0 = g;
        if (r0 != null) goto L7;
        return new MemoryResponse(404, "Context is null, please call init first", null, 4, null);
    L7:
        return a(r0, r8, r9);
    }

    private final MemoryResponse<Void> a(Context r10, String r11, Bundle r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L9
        a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        com.obric.memorydata.sdk.a.d.f33797a.b("ContextAwareness", "call awareness provider method=" + r11);     // Catch: Throwable -> L9
        Uri r2 = Uri.parse("content://com.obric.memorydata.awareness.provider");     // Catch: Throwable -> L9
        o.a(r2);     // Catch: Throwable -> L9
        MemoryResponse<Void> r14 = f.f33829a.a(r9.a(r13, r2, r11, r12));     // Catch: Throwable -> L9
        if (r14.isSuccess() == false) goto L6;
        com.obric.memorydata.sdk.a.d.f33797a.b("ContextAwareness", "call awareness provider success method=" + r11);     // Catch: Throwable -> L9
    L7:
        Object r15 = n.f(r14);     // Catch: Throwable -> L9
    L11:
        Throwable r16 = n.c(r15);
        if (r16 == null) goto L16;
        com.obric.memorydata.sdk.a.d.f33797a.a("ContextAwareness", "call provider failed method=" + r11, r16);
        r15 = new MemoryResponse(400, r16.getMessage(), null, 4, null);
    L16:
        return (MemoryResponse) ZeusTransformUtils.preCheckCast(r15, MemoryResponse.class, "com.obric.aiagent.plugin");
    L6:
        com.obric.memorydata.sdk.a.d.f33797a.c("ContextAwareness", "call awareness provider failed method=" + r11 + " code=" + r14.getCode() + " msg=" + r14.getMessage());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        n.a r17 = n.f38560a;
        r15 = n.f(d.o.a(th));
        goto L11
    }

    private final Bundle a(Context r5, Uri r6, String r7, Bundle r8) {
        ContentProviderClient r4 = ((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin")).getContentResolver().acquireUnstableContentProviderClient(r6);
        Bundle r9 = null;
        if (r4 != null) goto L20;
        com.obric.memorydata.sdk.a.d.f33797a.c("ContextAwareness", "acquire awareness provider client failed method=" + r7);
        return null;
    L20:
        r9 = r4.call(r7, null, r8);     // Catch: Throwable -> L8 Exception -> L10 DeadObjectException -> L12
    L7:
        r4.close();
        return r9;
    L12:
        e = move-exception;
        com.obric.memorydata.sdk.a.d.f33797a.a("ContextAwareness", "awareness provider died during call method=" + r7, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        r9 = f.f33829a.a(404, "Provider 进程已死亡，请稍后重试");     // Catch: Throwable -> L8
    L10:
        e = move-exception;
        com.obric.memorydata.sdk.a.d.f33797a.a("ContextAwareness", "awareness provider call failed method=" + r7, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r4.close();
        throw th;
    }
}
