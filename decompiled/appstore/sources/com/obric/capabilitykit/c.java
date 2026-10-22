package com.obric.capabilitykit;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import cb.n;
import cb.o;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.ICapabilityManager;
import com.obric.capabilitykit.logger.Logger;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;
import kotlinx.coroutines.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11239a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.obric.capabilitykit.a f11240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f11241c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f11242d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LinkedHashMap f11243e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f11244f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/AgentServiceConnection$BindState;", "", "<init>", "(Ljava/lang/String;I)V", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11245a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f11246b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f11247c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f11248d = null;

        static {
            f11245a = new a("NotStart", 0);
            f11246b = new a("Started", 1);
            f11247c = new a("Connected", 2);
            f11248d = a();
        }

        private a(String r10, int r11) {
            super(r10, r11);
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{f11245a, f11246b, f11247c};
        }

        public static a valueOf(String r10) {
            return (a) Enum.valueOf(a.class, r10);
        }

        public static a[] values() {
            return (a[]) f11248d.clone();
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002B\u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001j \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u0003`\u0006J.\u0010\t\u001a\u00020\n2$\u0010\u000b\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u00030\fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"com/obric/capabilitykit/AgentServiceConnection$jobMap$1", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/Pair;", "Lkotlinx/coroutines/Job;", "Lkotlin/collections/LinkedHashMap;", "MAX_SIZE", "", "removeEldestEntry", "", "eldest", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends LinkedHashMap<String, Set<Pair<? extends String, ? extends Job>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11249a;

        public b() {
            this.f11249a = 10;
        }

        public /* bridge */ Set<Map.Entry<String, Set<Pair<String, Job>>>> a() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> b() {
            return super.keySet();
        }

        public /* bridge */ int c() {
            return super.size();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return false;
        L7:
            return a((String) r10);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object r10) {
            if (y.m(r10) == true) goto L7;
            return false;
        L7:
            return a((Set) r10);
        }

        public /* bridge */ Collection<Set<Pair<String, Job>>> d() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Set<Pair<String, Job>>>> entrySet() {
            return a();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return null;
        L7:
            return b((String) r10);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object r10, Object r11) {
            if ((r10 instanceof String) == true) goto L6;
            return r11;
        L6:
            return a((String) r10, (Set) r11);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return b();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return null;
        L7:
            return c((String) r10);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(@NotNull Map.Entry<String, Set<Pair<? extends String, ? extends Job>>> r10) {
            kotlin.jvm.internal.q.g(r10, "eldest");
            if (size() <= this.f11249a) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<Set<Pair<String, Job>>> values() {
            return d();
        }

        public final /* bridge */ Set<Pair<String, Job>> a(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return null;
        L7:
            return b((String) r10);
        }

        public final /* bridge */ Set<Pair<String, Job>> b(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return null;
        L7:
            return c((String) r10);
        }

        public /* bridge */ Set<Pair<String, Job>> c(String r10) {
            return (Set) super.remove(r10);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object r10, Object r11) {
            if ((r10 instanceof String) == true) goto L6;
            return false;
        L6:
            if (y.m(r11) == true) goto L9;
            return false;
        L9:
            return b((String) r10, (Set) r11);
        }

        public final /* bridge */ Set a(Object r10, Set r11) {
            if ((r10 instanceof String) == true) goto L6;
            return r11;
        L6:
            return a((String) r10, r11);
        }

        public /* bridge */ Set<Pair<String, Job>> b(String r10) {
            return (Set) super.get(r10);
        }

        public /* bridge */ Set<Pair<String, Job>> a(String r10, Set<Pair<String, Job>> r11) {
            return (Set) super.getOrDefault(r10, r11);
        }

        public /* bridge */ boolean b(String r10, Set<Pair<String, Job>> r11) {
            return super.remove(r10, r11);
        }

        public /* bridge */ boolean a(String r10) {
            return super.containsKey(r10);
        }

        public /* bridge */ boolean a(Set<Pair<String, Job>> r10) {
            return super.containsValue(r10);
        }
    }

    /* JADX INFO: renamed from: com.obric.capabilitykit.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.AgentServiceConnection$onServiceConnected$1$1$2", f = "AgentServiceConnection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0176c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11250a;

        public C0176c(Continuation<? super C0176c> r10) {
            super(2, r10);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((C0176c) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new C0176c(r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
            return a(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            kotlin.coroutines.intrinsics.a.d();
            if (this.f11250a != 0) goto L7;
            kotlin.c.b(r10);
            AtomicCapabilitySdk.INSTANCE.onApiInitComplete$capabilitykit_release();
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class d implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBinder f11251a;

        public d(IBinder r10) {
            this.f11251a = r10;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Logger r10 = Logger.INSTANCE;
            StringBuilder r11 = new StringBuilder();
            r11.append("binderDied: before, mBindState=");
            c r12 = c.f11239a;
            r11.append(r12.h());
            r11.append(", thread=");
            r11.append(Thread.currentThread().getName());
            r10.i("AgentServiceConnection", r11.toString());
            this.f11251a.unlinkToDeath(this, 0);
            Object r13 = c.b();
            monitor-enter(r13);
            r12.e(a.f11245a);     // Catch: Throwable -> L8
            r12.d(null);     // Catch: Throwable -> L8
            monitor-exit(r13);
            r10.i("AgentServiceConnection", "binderDied: done, set mBindState=NotStart, api=null");
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
        f11239a = new c();
        f11241c = new Object();
        ExecutorService r10 = Executors.newSingleThreadExecutor(new n());
        kotlin.jvm.internal.q.f(r10, "newSingleThreadExecutor …entSvcConn-thread\")\n    }");
        f11242d = d0.a(x0.b(r10));
        f11243e = new b();
        f11244f = a.f11245a;
    }

    public c() {
    }

    public static /* synthetic */ Thread a(Runnable r10) {
        return c(r10);
    }

    public static final /* synthetic */ Object b() {
        return f11241c;
    }

    public static final Thread c(Runnable r10) {
        return new Thread(r10, "AgentSvcConn-thread");
    }

    public final void d(com.obric.capabilitykit.a r10) {
        f11240b = r10;
    }

    public final void e(a r10) {
        kotlin.jvm.internal.q.g(r10, "<set-?>");
        f11244f = r10;
    }

    public final com.obric.capabilitykit.a f() {
        Object r10 = f11241c;
        monitor-enter(r10);
        Logger r11 = Logger.INSTANCE;     // Catch: Throwable -> L48
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L48
        r12.append("getApi: enter, mBindState=");     // Catch: Throwable -> L48
        r12.append(f11244f);     // Catch: Throwable -> L48
        r12.append(", api=");     // Catch: Throwable -> L48
        if (f11240b != null) goto L9;
        String r13 = "null";
    L10:
        r12.append(r13);     // Catch: Throwable -> L48
        r11.i("AgentServiceConnection", r12.toString());     // Catch: Throwable -> L48
        com.obric.capabilitykit.a r14 = f11240b;     // Catch: Throwable -> L48
        if (r14 == null) goto L60;
        monitor-exit(r10);
        return r14;
    L60:
        a r15 = f11244f;     // Catch: Throwable -> L23
        a r16 = a.f11246b;     // Catch: Throwable -> L23
        if (r15 != r16) goto L17;
        r11.i("AgentServiceConnection", "getApi: api is null but mBindState=Started (connecting), wait onServiceConnected");     // Catch: Throwable -> L23
    L30:
        Object r17 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L23
    L33:
        Throwable r18 = Result.m38exceptionOrNullimpl(r17);     // Catch: Throwable -> L48
        if (r18 != null) goto L37;
    L50:
        monitor-exit(r10);
        com.obric.capabilitykit.a r19 = f11240b;
        if (r19 != null) goto L55;
        r19 = cb.p.f6085a;
    L55:
        if (kotlin.jvm.internal.q.b(r19, cb.p.f6085a) == false) goto L57;
        Logger.INSTANCE.i("AgentServiceConnection", "getApi: return EmptyCapabilityManager, mBindState=" + f11244f);
    L57:
        return r19;
    L37:
        Logger.INSTANCE.e("AgentServiceConnection", "bindService throw exception: " + kotlin.a.b(r18));     // Catch: Throwable -> L48
        f11244f = a.f11245a;     // Catch: Throwable -> L48
        AppHost.Companion.getApplication().unbindService(this);     // Catch: Throwable -> L40
        Object r20 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L40
    L42:
        Throwable r21 = Result.m38exceptionOrNullimpl(r20);     // Catch: Throwable -> L48
        if (r21 == null) goto L50;
        Logger.INSTANCE.e("AgentServiceConnection", "unbindService throw exception: " + kotlin.a.b(r21));     // Catch: Throwable -> L48
        goto L50
    L40:
        th = move-exception;
        r20 = Result.m35constructorimpl(kotlin.c.a(th));     // Catch: Throwable -> L48
        goto L42
    L17:
        r11.i("AgentServiceConnection", "getApi: api is null, try rebind, current mBindState=" + f11244f);     // Catch: Throwable -> L23
        Intent r22 = new Intent("com.obric.aiagent.executionengine.CAPABILITY_REGISTER_SERVICE");     // Catch: Throwable -> L23
        AppHost.Companion r23 = AppHost.Companion;     // Catch: Throwable -> L23
        List<ResolveInfo> r24 = r23.getApplication().getPackageManager().queryIntentServices(r22, 0);     // Catch: Throwable -> L23
        kotlin.jvm.internal.q.f(r24, "packageManager.queryIntentServices(intent, 0)");     // Catch: Throwable -> L23
        if (r24 != null) goto L20;
    L25:
        AtomicCapabilitySdk.INSTANCE.setPendingCallsExecuted$capabilitykit_release(false);     // Catch: Throwable -> L23
        if (r23.getApplication().bindService(r22, this, 1) == false) goto L28;
        f11244f = r16;     // Catch: Throwable -> L23
        goto L30
    L28:
        r11.i("AgentServiceConnection", "bindService fail");     // Catch: Throwable -> L23
        f11244f = a.f11245a;     // Catch: Throwable -> L23
        r23.getApplication().unbindService(this);     // Catch: Throwable -> L23
        goto L30
    L20:
        if (r24.isEmpty() == true) goto L25;
        ServiceInfo r25 = r24.get(0).serviceInfo;     // Catch: Throwable -> L23
        r22.setComponent(new ComponentName(r25.packageName, r25.name));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r17 = Result.m35constructorimpl(kotlin.c.a(th));     // Catch: Throwable -> L48
        goto L33
    L9:
        r13 = "non-null";
    L48:
        th = move-exception;
        throw th;
    }

    public final LinkedHashMap g() {
        return f11243e;
    }

    public final a h() {
        return f11244f;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName r10) {
        Logger.INSTANCE.i("AgentServiceConnection", "onNullBinding: " + Thread.currentThread().getName());
        Object r11 = f11241c;
        monitor-enter(r11);
        f11244f = a.f11245a;     // Catch: Throwable -> L11
        monitor-exit(r11);
        AppHost.Companion.getApplication().unbindService(this);     // Catch: Throwable -> L8
        Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.m35constructorimpl(kotlin.c.a(th));
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r10, IBinder r11) {
        Logger r12 = Logger.INSTANCE;
        r12.i("AgentServiceConnection", "onServiceConnected: " + Thread.currentThread().getName() + ", before mBindState=" + f11244f);
        Object r13 = f11241c;
        monitor-enter(r13);
        if (r11 != null) goto L25;
        r11 = null;
    L10:
        ICapabilityManager r14 = ICapabilityManager.Stub.asInterface(r11);     // Catch: Throwable -> L7
        kotlin.jvm.internal.q.f(r14, "asInterface(binder)");     // Catch: Throwable -> L7
        o r15 = new o(r14);     // Catch: Throwable -> L7
        r12.i("AgentServiceConnection", "init binder api done");     // Catch: Throwable -> L7
        f11240b = r15;     // Catch: Throwable -> L7
        f11244f = a.f11247c;     // Catch: Throwable -> L7
        Object r16 = Result.m35constructorimpl(h.d(f11242d, null, null, new C0176c(null), 3, null));     // Catch: Throwable -> L7
    L13:
        Throwable r17 = Result.m38exceptionOrNullimpl(r16);     // Catch: Throwable -> L19
        if (r17 == null) goto L21;
        f11244f = a.f11245a;     // Catch: Throwable -> L19
        f11240b = null;     // Catch: Throwable -> L19
        Logger.INSTANCE.e("AgentServiceConnection", "onServiceConnected throw exception, reset to NotStart: " + kotlin.a.b(r17));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L21:
        monitor-exit(r13);
        return;
    L7:
        th = move-exception;
        r16 = Result.m35constructorimpl(kotlin.c.a(th));     // Catch: Throwable -> L19
        goto L13
    L25:
        r11.linkToDeath(new d(r11), 0);     // Catch: Throwable -> L7
        goto L10
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r10) {
        Logger r11 = Logger.INSTANCE;
        StringBuilder r12 = new StringBuilder();
        r12.append("onServiceDisconnected: before, mBindState=");
        r12.append(f11244f);
        r12.append(", api=");
        if (f11240b != null) goto L5;
        String r13 = "null";
    L6:
        r12.append(r13);
        r12.append(", thread=");
        r12.append(Thread.currentThread().getName());
        r11.i("AgentServiceConnection", r12.toString());
        Object r14 = f11241c;
        monitor-enter(r14);
        f11244f = a.f11245a;     // Catch: Throwable -> L11
        f11240b = null;     // Catch: Throwable -> L11
        monitor-exit(r14);
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r13 = "non-null";
        goto L6
    }
}
