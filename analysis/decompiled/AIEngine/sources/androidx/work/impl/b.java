package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Trace;
import androidx.datastore.preferences.protobuf.b1;
import androidx.work.a;
import androidx.work.impl.utils.ForceStopRunnable;
import h2.j;
import h2.r;
import i2.h;
import i2.m;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import o2.n;
import r2.i;
import r2.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends r {

    /* renamed from: l, reason: collision with root package name */
    public static b f2874l;

    /* renamed from: m, reason: collision with root package name */
    public static b f2875m;

    /* renamed from: n, reason: collision with root package name */
    public static final Object f2876n;

    /* renamed from: a, reason: collision with root package name */
    public final Context f2877a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.work.a f2878b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkDatabase f2879c;

    /* renamed from: d, reason: collision with root package name */
    public final s2.b f2880d;

    /* renamed from: e, reason: collision with root package name */
    public final List<h> f2881e;

    /* renamed from: f, reason: collision with root package name */
    public final a f2882f;

    /* renamed from: g, reason: collision with root package name */
    public final i f2883g;
    public boolean h = false;

    /* renamed from: i, reason: collision with root package name */
    public BroadcastReceiver.PendingResult f2884i;

    /* renamed from: j, reason: collision with root package name */
    public final n f2885j;

    /* renamed from: k, reason: collision with root package name */
    public final CoroutineScope f2886k;

    static {
        j.f("WorkManagerImpl");
        f2874l = null;
        f2875m = null;
        f2876n = new Object();
    }

    public b(Context context, final androidx.work.a aVar, s2.b bVar, final WorkDatabase workDatabase, final List<h> list, a aVar2, n nVar) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext.isDeviceProtectedStorage()) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        j.a aVar3 = new j.a(aVar.h);
        synchronized (j.f9272a) {
            try {
                if (j.f9273b == null) {
                    j.f9273b = aVar3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f2877a = applicationContext;
        this.f2880d = bVar;
        this.f2879c = workDatabase;
        this.f2882f = aVar2;
        this.f2885j = nVar;
        this.f2878b = aVar;
        this.f2881e = list;
        CoroutineDispatcher coroutineDispatcherB = bVar.b();
        g.e(coroutineDispatcherB, "taskExecutor.taskCoroutineDispatcher");
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(coroutineDispatcherB);
        this.f2886k = CoroutineScope;
        this.f2883g = new i(workDatabase);
        final k kVarC = bVar.c();
        String str = i2.j.f9469a;
        aVar2.a(new i2.b() { // from class: i2.i
            @Override // i2.b
            public final void a(q2.k kVar, boolean z) {
                kVarC.execute(new cb.s(list, kVar, aVar, workDatabase, 3));
            }
        });
        bVar.d(new ForceStopRunnable(applicationContext, this));
        String str2 = m.f9473a;
        g.f(CoroutineScope, "<this>");
        if (r2.j.a(applicationContext, aVar)) {
            FlowKt.launchIn(FlowKt.onEach(FlowKt.distinctUntilChanged(FlowKt.conflate(FlowKt.retryWhen(workDatabase.w().p(), new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1(4, null)))), new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2(applicationContext, null)), CoroutineScope);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b a(Context context) {
        b bVarA;
        Object obj = f2876n;
        synchronized (obj) {
            try {
                synchronized (obj) {
                    bVarA = f2874l;
                    if (bVarA == null) {
                        bVarA = f2875m;
                    }
                }
                return bVarA;
            } catch (Throwable th) {
                throw th;
            } finally {
            }
        }
        if (bVarA == null) {
            Context applicationContext = context.getApplicationContext();
            if (!(applicationContext instanceof a.b)) {
                throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
            }
            b(applicationContext, ((a.b) applicationContext).a());
            bVarA = a(applicationContext);
        }
        return bVarA;
    }

    public static void b(Context context, androidx.work.a aVar) {
        synchronized (f2876n) {
            try {
                b bVar = f2874l;
                if (bVar != null && f2875m != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (bVar == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (f2875m == null) {
                        f2875m = c.a(applicationContext, aVar);
                    }
                    f2874l = f2875m;
                }
            } finally {
            }
        }
    }

    public final void c() {
        synchronized (f2876n) {
            try {
                this.h = true;
                BroadcastReceiver.PendingResult pendingResult = this.f2884i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.f2884i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        b1 b1Var = this.f2878b.f2825m;
        b6.g gVar = new b6.g(this, 13);
        g.f(b1Var, "<this>");
        boolean zA = c2.b.a();
        if (zA) {
            try {
                b1Var.h("ReschedulingWork");
            } catch (Throwable th) {
                if (zA) {
                    Trace.endSection();
                }
                throw th;
            }
        }
        gVar.invoke();
        if (zA) {
            Trace.endSection();
        }
    }
}
