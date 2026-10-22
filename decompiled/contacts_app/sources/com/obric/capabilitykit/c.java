package com.obric.capabilitykit;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
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
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001c\u0010%\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bRQ\u0010\f\u001aB\u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000f0\u000e0\rj \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000f0\u000e`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/AgentServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "SERVER_SERVICE", "", "TAG", "api", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "getApi", "()Lcom/obric/capabilitykit/AbstractCapabilityManager;", "setApi", "(Lcom/obric/capabilitykit/AbstractCapabilityManager;)V", "jobMap", "Ljava/util/LinkedHashMap;", "", "Lkotlin/Pair;", "Lkotlinx/coroutines/Job;", "Lkotlin/collections/LinkedHashMap;", "getJobMap", "()Ljava/util/LinkedHashMap;", "mBindState", "Lcom/obric/capabilitykit/AgentServiceConnection$BindState;", "getMBindState", "()Lcom/obric/capabilitykit/AgentServiceConnection$BindState;", "setMBindState", "(Lcom/obric/capabilitykit/AgentServiceConnection$BindState;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "stateLock", "", "getApi$capabilitykit_release", "onNullBinding", "", "name", "Landroid/content/ComponentName;", "onServiceConnected", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "BindState", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c implements ServiceConnection {
    public static final c a = null;
    private static final String b = "AgentServiceConnection";
    public static final String c = "com.obric.aiagent.executionengine.CAPABILITY_REGISTER_SERVICE";
    private static com.obric.capabilitykit.a d;
    private static final Object e = null;
    private static final CoroutineScope f = null;
    private static final LinkedHashMap<String, Set<Pair<String, Job>>> g = null;
    private static a h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/capabilitykit/AgentServiceConnection$BindState;", "", "(Ljava/lang/String;I)V", "NotStart", "Started", "Connected", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum a extends Enum<a> {
        public static final a a = null;
        public static final a b = null;
        public static final a c = null;
        private static final /* synthetic */ a[] d = null;

        static {
            a = new a("NotStart", 0);
            b = new a("Started", 1);
            c = new a("Connected", 2);
            d = a();
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b, c};
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) d.clone();
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002B\u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001j \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u0003`\u0006J.\u0010\t\u001a\u00020\n2$\u0010\u000b\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u00030\fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"com/obric/capabilitykit/AgentServiceConnection$jobMap$1", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/Pair;", "Lkotlinx/coroutines/Job;", "Lkotlin/collections/LinkedHashMap;", "MAX_SIZE", "", "removeEldestEntry", "", "eldest", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends LinkedHashMap<String, Set<Pair<? extends String, ? extends Job>>> {
        private final int a;

        public b() {
            this.a = 10;
        }

        public /* bridge */ Set<Map.Entry<String, Set<Pair<String, Job>>>> a() {
            return super.entrySet();
        }

        public final /* bridge */ Set<Pair<String, Job>> a(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return b((String) r2);
        }

        public final /* bridge */ Set a(Object r2, Set r3) {
            if ((r2 instanceof String) == true) goto L6;
            return r3;
        L6:
            return a((String) r2, r3);
        }

        public /* bridge */ Set<Pair<String, Job>> a(String r1, Set<Pair<String, Job>> r2) {
            return (Set) super.getOrDefault(r1, r2);
        }

        public /* bridge */ boolean a(String r1) {
            return super.containsKey(r1);
        }

        public /* bridge */ boolean a(Set<Pair<String, Job>> r1) {
            return super.containsValue(r1);
        }

        public /* bridge */ Set<String> b() {
            return super.keySet();
        }

        public final /* bridge */ Set<Pair<String, Job>> b(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return c((String) r2);
        }

        public /* bridge */ Set<Pair<String, Job>> b(String r1) {
            return (Set) super.get(r1);
        }

        public /* bridge */ boolean b(String r1, Set<Pair<String, Job>> r2) {
            return super.remove(r1, r2);
        }

        public /* bridge */ int c() {
            return super.size();
        }

        public /* bridge */ Set<Pair<String, Job>> c(String r1) {
            return (Set) super.remove(r1);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return false;
        L7:
            return a((String) r2);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object r2) {
            if (TypeIntrinsics.isMutableSet(r2) == true) goto L7;
            return false;
        L7:
            return a((Set) r2);
        }

        public /* bridge */ Collection<Set<Pair<String, Job>>> d() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Set<Pair<String, Job>>>> entrySet() {
            return a();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return b((String) r2);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object r2, Object r3) {
            if ((r2 instanceof String) == true) goto L6;
            return r3;
        L6:
            return a((String) r2, (Set) r3);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return b();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return c((String) r2);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object r3, Object r4) {
            if ((r3 instanceof String) == true) goto L6;
            return false;
        L6:
            if (TypeIntrinsics.isMutableSet(r4) == true) goto L9;
            return false;
        L9:
            return b((String) r3, (Set) r4);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Set<Pair<? extends String, ? extends Job>>> r2) {
            Intrinsics.checkNotNullParameter(r2, "eldest");
            if (size() <= this.a) goto L5;
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
    }

    /* JADX INFO: renamed from: com.obric.capabilitykit.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.AgentServiceConnection$onServiceConnected$1$1$2", f = "AgentServiceConnection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0079c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        public C0079c(Continuation<? super C0079c> r2) {
            super(2, r2);
        }

        public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C0079c) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C0079c(r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return a(r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) goto L7;
            ResultKt.throwOnFailure(r1);
            AtomicCapabilitySdk.INSTANCE.onApiInitComplete$capabilitykit_release();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/capabilitykit/AgentServiceConnection$onServiceConnected$1$1$binder$1$1", "Landroid/os/IBinder$DeathRecipient;", "binderDied", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements IBinder.DeathRecipient {
        public final /* synthetic */ IBinder a;

        public d(IBinder r1) {
            this.a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Logger r0 = Logger.INSTANCE;
            StringBuilder r1 = new StringBuilder("binderDied: before, mBindState=");
            c r2 = c.a;
            r0.i(c.b, r1.append(r2.e()).append(", thread=").append(Thread.currentThread().getName()).toString());
            this.a.unlinkToDeath(this, 0);
            Object r4 = c.a();
            monitor-enter(r4);
            r2.a(a.a);     // Catch: Throwable -> L8
            r2.a(null);     // Catch: Throwable -> L8
            monitor-exit(r4);
            r0.i(c.b, "binderDied: done, set mBindState=NotStart, api=null");
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Cf2rZxHqwtd-0XduQ0-cCxclH8E, reason: not valid java name */
    public static /* synthetic */ Thread m339$r8$lambda$Cf2rZxHqwtd0XduQ0cCxclH8E(Runnable r0) {
        return a(r0);
    }

    static {
        a = new c();
        e = new Object();
        ExecutorService r0 = Executors.newSingleThreadExecutor(new c$$ExternalSyntheticLambda0());
        Intrinsics.checkNotNullExpressionValue(r0, "newSingleThreadExecutor …entSvcConn-thread\")\n    }");
        f = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(r0));
        g = new b();
        h = a.a;
    }

    private c() {
    }

    public static final /* synthetic */ Object a() {
        return e;
    }

    private static final Thread a(Runnable r2) {
        return new Thread(r2, "AgentSvcConn-thread");
    }

    public final void a(com.obric.capabilitykit.a r1) {
        d = r1;
    }

    public final void a(a r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        h = r1;
    }

    public final com.obric.capabilitykit.a b() {
        return d;
    }

    public final com.obric.capabilitykit.a c() {
        Object r4 = e;
        monitor-enter(r4);
        Logger r5 = Logger.INSTANCE;     // Catch: Throwable -> L57
        StringBuilder r3 = new StringBuilder("getApi: enter, mBindState=").append(h).append(", api=");     // Catch: Throwable -> L57
        if (d != null) goto L9;
        String r7 = "null";
    L10:
        r5.i(b, r3.append(r7).toString());     // Catch: Throwable -> L57
        com.obric.capabilitykit.a r6 = d;     // Catch: Throwable -> L57
        if (r6 == null) goto L62;
        monitor-exit(r4);
        return r6;
    L62:
        a r8 = h;     // Catch: Throwable -> L33
        a r9 = a.b;     // Catch: Throwable -> L33
        if (r8 != r9) goto L17;
        r5.i(b, "getApi: api is null but mBindState=Started (connecting), wait onServiceConnected");     // Catch: Throwable -> L33
    L31:
        Object r2 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        Throwable r10 = Result.m806exceptionOrNullimpl(r2);     // Catch: Throwable -> L57
        if (r10 != null) goto L39;
    L49:
        monitor-exit(r4);
        com.obric.capabilitykit.a r12 = d;
        if (r12 != null) goto L54;
        r12 = f.a;
    L54:
        if (Intrinsics.areEqual(r12, f.a) == false) goto L56;
        Logger.INSTANCE.i(b, "getApi: return EmptyCapabilityManager, mBindState=" + h);
    L56:
        return r12;
    L39:
        Logger.INSTANCE.e(b, "bindService throw exception: " + ExceptionsKt.stackTraceToString(r10));     // Catch: Throwable -> L57
        h = a.a;     // Catch: Throwable -> L57
        AppHost.Companion.getApplication().unbindService(this);     // Catch: Throwable -> L42
        Object r13 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L42
    L44:
        Throwable r14 = Result.m806exceptionOrNullimpl(r13);     // Catch: Throwable -> L57
        if (r14 == null) goto L49;
        Logger.INSTANCE.e(b, "unbindService throw exception: " + ExceptionsKt.stackTraceToString(r14));     // Catch: Throwable -> L57
        goto L49
    L42:
        th = move-exception;
        r13 = Result.m803constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L44
    L17:
        r5.i(b, "getApi: api is null, try rebind, current mBindState=" + h);     // Catch: Throwable -> L33
        Intent r11 = new Intent(c);     // Catch: Throwable -> L33
        AppHost.Companion r15 = AppHost.Companion;     // Catch: Throwable -> L33
        List<ResolveInfo> r16 = r15.getApplication().getPackageManager().queryIntentServices(r11, 0);     // Catch: Throwable -> L33
        Intrinsics.checkNotNullExpressionValue(r16, "packageManager.queryIntentServices(intent, 0)");     // Catch: Throwable -> L33
        if (r16 != null) goto L20;
    L23:
        boolean r17 = true;
    L24:
        if (r17 == true) goto L26;
        ServiceInfo r18 = r16.get(0).serviceInfo;     // Catch: Throwable -> L33
        r11.setComponent(new ComponentName(r18.packageName, r18.name));     // Catch: Throwable -> L33
    L26:
        AtomicCapabilitySdk.INSTANCE.setPendingCallsExecuted$capabilitykit_release(false);     // Catch: Throwable -> L33
        if (r15.getApplication().bindService(r11, this, 1) == false) goto L29;
        h = r9;     // Catch: Throwable -> L33
        goto L31
    L29:
        r5.i(b, "bindService fail");     // Catch: Throwable -> L33
        h = a.a;     // Catch: Throwable -> L33
        r15.getApplication().unbindService(this);     // Catch: Throwable -> L33
        goto L31
    L20:
        if (r16.isEmpty() == true) goto L23;
        r17 = false;
    L33:
        th = move-exception;
        r2 = Result.m803constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L35
    L9:
        r7 = "non-null";
    L57:
        th = move-exception;
        throw th;
    }

    public final LinkedHashMap<String, Set<Pair<String, Job>>> d() {
        return g;
    }

    public final a e() {
        return h;
    }

    public final CoroutineScope f() {
        return f;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName r3) {
        Logger.INSTANCE.i(b, "onNullBinding: " + Thread.currentThread().getName());
        Object r4 = e;
        monitor-enter(r4);
        h = a.a;     // Catch: Throwable -> L11
        monitor-exit(r4);
        AppHost.Companion.getApplication().unbindService(this);     // Catch: Throwable -> L8
        Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.m803constructorimpl(ResultKt.createFailure(th));
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r9, IBinder r10) {
        Logger r11 = Logger.INSTANCE;
        r11.i(b, "onServiceConnected: " + Thread.currentThread().getName() + ", before mBindState=" + h);
        Object r0 = e;
        monitor-enter(r0);
        if (r10 != null) goto L25;
        r10 = null;
    L10:
        ICapabilityManager r12 = ICapabilityManager.Stub.asInterface(r10);     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r12, "asInterface(binder)");     // Catch: Throwable -> L7
        e r2 = new e(r12);     // Catch: Throwable -> L7
        r11.i(b, "init binder api done");     // Catch: Throwable -> L7
        d = r2;     // Catch: Throwable -> L7
        h = a.c;     // Catch: Throwable -> L7
        Object r13 = Result.m803constructorimpl(BuildersKt.launch$default(f, null, null, new C0079c(null), 3, null));     // Catch: Throwable -> L7
    L13:
        Throwable r14 = Result.m806exceptionOrNullimpl(r13);     // Catch: Throwable -> L20
        if (r14 == null) goto L18;
        h = a.a;     // Catch: Throwable -> L20
        d = null;     // Catch: Throwable -> L20
        Logger.INSTANCE.e(b, "onServiceConnected throw exception, reset to NotStart: " + ExceptionsKt.stackTraceToString(r14));     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        r13 = Result.m803constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L20
        goto L13
    L25:
        r10.linkToDeath(new d(r10), 0);     // Catch: Throwable -> L7
    L20:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r3) {
        Logger r2 = Logger.INSTANCE;
        StringBuilder r0 = new StringBuilder("onServiceDisconnected: before, mBindState=").append(h).append(", api=");
        if (d != null) goto L5;
        String r1 = "null";
    L6:
        r2.i(b, r0.append(r1).append(", thread=").append(Thread.currentThread().getName()).toString());
        Object r4 = e;
        monitor-enter(r4);
        h = a.a;     // Catch: Throwable -> L11
        d = null;     // Catch: Throwable -> L11
        monitor-exit(r4);
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r1 = "non-null";
        goto L6
    }
}
