package com.stepos.ailauncher.common.startup;

import Y8.t;
import Z8.C1165m;
import Z8.F;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0010\"\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0016J\u001f\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000fH\u0002¢\u0006\u0004\b \u0010\u0003J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0!H\u0002¢\u0006\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010+\u001a\n **\u0004\u0018\u00010)0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u001a008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002030-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010/R \u00106\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002050-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010/R\u0018\u00107\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R8\u0010?\u001a&\u0012\f\u0012\n **\u0004\u0018\u00010\u001a0\u001a **\u0012\u0012\f\u0012\n **\u0004\u0018\u00010\u001a0\u001a\u0018\u00010>0=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lcom/stepos/ailauncher/common/startup/g;", "", "<init>", "()V", "Lcom/stepos/ailauncher/common/startup/h;", "task", "s", "(Lcom/stepos/ailauncher/common/startup/h;)Lcom/stepos/ailauncher/common/startup/g;", "Lkotlin/Function0;", "", Const.JSON_KEY_PROVIDER, "v", "(Lp9/a;)Lcom/stepos/ailauncher/common/startup/g;", "Landroid/content/Context;", "context", "LY8/t;", "w", "(Landroid/content/Context;)V", "q", "p", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/common/startup/h;)V", "n", "t", "u", "", "id", "", "timeoutMs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;J)Z", "y", "", "x", "()Ljava/util/List;", "TAG", "Ljava/lang/String;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "executor", "Ljava/util/concurrent/ExecutorService;", "Ljava/util/concurrent/ConcurrentHashMap;", "tasks", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "registrationOrder", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CountDownLatch;", "doneLatches", "Ljava/util/concurrent/atomic/AtomicInteger;", "startedFlags", "appContext", "Landroid/content/Context;", RobotInfo.STATUS_STARTED, "Z", "privacyProvider", "Lp9/a;", "", "", "pendingPrivacyTasks", "Ljava/util/Set;", "DEFAULT_AWAIT_TIMEOUT_MS", "J", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g {
    private static final long DEFAULT_AWAIT_TIMEOUT_MS = 10000;
    private static final String TAG = "AppStartup";
    private static volatile Context appContext;
    private static volatile boolean started;
    public static final g INSTANCE = new g();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final ExecutorService executor = Executors.newCachedThreadPool(new c());
    private static final ConcurrentHashMap<String, h> tasks = new ConcurrentHashMap<>();
    private static final CopyOnWriteArrayList<String> registrationOrder = new CopyOnWriteArrayList<>();
    private static final ConcurrentHashMap<String, CountDownLatch> doneLatches = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, AtomicInteger> startedFlags = new ConcurrentHashMap<>();
    private static volatile InterfaceC5063a<Boolean> privacyProvider = new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.startup.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return Boolean.valueOf(g.r());
        }
    };
    private static final Set<String> pendingPrivacyTasks = Collections.newSetFromMap(new ConcurrentHashMap());

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InitStrategy.values().length];
            try {
                iArr[InitStrategy.MAIN_IMMEDIATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InitStrategy.MAIN_IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InitStrategy.BACKGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InitStrategy.DELAYED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[InitStrategy.LAZY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Runnable {
        final /* synthetic */ h $task$inlined;

        public b(h hVar) {
            this.$task$inlined = hVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g.INSTANCE.t(this.$task$inlined);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/ailauncher/common/startup/g$c", "Ljava/util/concurrent/ThreadFactory;", "Ljava/lang/Runnable;", "r", "Ljava/lang/Thread;", "newThread", "(Ljava/lang/Runnable;)Ljava/lang/Thread;", "Ljava/util/concurrent/atomic/AtomicInteger;", "index", "Ljava/util/concurrent/atomic/AtomicInteger;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements ThreadFactory {
        private final AtomicInteger index = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            p.i(r10, "r");
            Thread thread = new Thread(r10, "app-startup-" + this.index.getAndIncrement());
            thread.setPriority(5);
            return thread;
        }
    }

    public static final void j(final h hVar) {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.stepos.ailauncher.common.startup.e
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                return g.k(hVar);
            }
        });
    }

    public static final boolean k(h hVar) {
        INSTANCE.n(hVar);
        return false;
    }

    public static final void l(h hVar) {
        INSTANCE.t(hVar);
    }

    public static final void m(h hVar) {
        if (hVar.getDelayMillis() > 0) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Thread.sleep(hVar.getDelayMillis());
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        INSTANCE.t(hVar);
    }

    public static final void o(h hVar) {
        INSTANCE.t(hVar);
    }

    public static final boolean r() {
        return false;
    }

    public final boolean h(String id, long timeoutMs) {
        CountDownLatch countDownLatch = doneLatches.get(id);
        if (countDownLatch == null) {
            return true;
        }
        try {
            return countDownLatch.await(timeoutMs, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final void i(final h task) {
        int i10 = a.$EnumSwitchMapping$0[task.getStrategy().ordinal()];
        if (i10 == 1) {
            if (p.d(Looper.myLooper(), Looper.getMainLooper())) {
                INSTANCE.t(task);
                return;
            } else {
                mainHandler.post(new b(task));
                return;
            }
        }
        if (i10 == 2) {
            mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.common.startup.b
                @Override // java.lang.Runnable
                public final void run() {
                    g.j(task);
                }
            });
            return;
        }
        if (i10 == 3) {
            executor.execute(new Runnable() { // from class: com.stepos.ailauncher.common.startup.c
                @Override // java.lang.Runnable
                public final void run() {
                    g.l(task);
                }
            });
        } else if (i10 == 4) {
            executor.execute(new Runnable() { // from class: com.stepos.ailauncher.common.startup.d
                @Override // java.lang.Runnable
                public final void run() {
                    g.m(task);
                }
            });
        } else if (i10 != 5) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void n(final h task) {
        List<String> listC = task.c();
        if (!(listC instanceof Collection) || !listC.isEmpty()) {
            Iterator<T> it = listC.iterator();
            while (it.hasNext()) {
                CountDownLatch countDownLatch = doneLatches.get((String) it.next());
                if (countDownLatch == null || countDownLatch.getCount() != 0) {
                    executor.execute(new Runnable() { // from class: com.stepos.ailauncher.common.startup.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            g.o(task);
                        }
                    });
                    return;
                }
            }
        }
        t(task);
    }

    public final boolean p() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            Boolean boolInvoke = privacyProvider.invoke();
            boolInvoke.booleanValue();
            objB = Result.b(boolInvoke);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void q() {
        if (!started) {
            C4148a.u(TAG, "notifyPrivacyGranted before start ignored", false, 4, null);
            return;
        }
        Set<String> pendingPrivacyTasks2 = pendingPrivacyTasks;
        p.h(pendingPrivacyTasks2, "pendingPrivacyTasks");
        List listM1 = F.m1(pendingPrivacyTasks2);
        pendingPrivacyTasks2.clear();
        if (listM1.isEmpty()) {
            C4148a.k(TAG, "notifyPrivacyGranted: no deferred tasks", false, 4, null);
            return;
        }
        C4148a.k(TAG, "privacy granted, flush " + listM1.size() + " deferred tasks: " + listM1, false, 4, null);
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            h hVar = tasks.get((String) it.next());
            if (hVar != null) {
                INSTANCE.i(hVar);
            }
        }
    }

    public final g s(h task) {
        p.i(task, "task");
        if (started) {
            C4148a.u(TAG, "register after start ignored: " + task.getId(), false, 4, null);
            return this;
        }
        if (tasks.putIfAbsent(task.getId(), task) == null) {
            doneLatches.put(task.getId(), new CountDownLatch(1));
            startedFlags.put(task.getId(), new AtomicInteger(0));
            registrationOrder.add(task.getId());
            return this;
        }
        C4148a.u(TAG, "duplicate task ignored: " + task.getId(), false, 4, null);
        return this;
    }

    public final void t(h task) {
        AtomicInteger atomicInteger = startedFlags.get(task.getId());
        if (atomicInteger == null || !atomicInteger.compareAndSet(0, 1)) {
            return;
        }
        u(task);
    }

    public final void u(h task) {
        long jElapsedRealtime;
        String id;
        String name;
        StringBuilder sb2;
        for (String str : task.c()) {
            if (!h(str, 10000L)) {
                C4148a.u(TAG, "task " + task.getId() + " dep '" + str + "' not done in time, run anyway", false, 4, null);
            }
        }
        Context context = appContext;
        if (context == null) {
            C4148a.u(TAG, "context null, skip task " + task.getId(), false, 4, null);
            CountDownLatch countDownLatch = doneLatches.get(task.getId());
            if (countDownLatch != null) {
                countDownLatch.countDown();
                return;
            }
            return;
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        try {
            task.a(context);
            jElapsedRealtime = SystemClock.elapsedRealtime() - jElapsedRealtime2;
            CountDownLatch countDownLatch2 = doneLatches.get(task.getId());
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
            id = task.getId();
            name = Thread.currentThread().getName();
            sb2 = new StringBuilder();
        } catch (Throwable th) {
            try {
                C4148a.g(TAG, "task " + task.getId() + " failed", th, false, 8, null);
                jElapsedRealtime = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                CountDownLatch countDownLatch3 = doneLatches.get(task.getId());
                if (countDownLatch3 != null) {
                    countDownLatch3.countDown();
                }
                id = task.getId();
                name = Thread.currentThread().getName();
                sb2 = new StringBuilder();
            } catch (Throwable th2) {
                long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                CountDownLatch countDownLatch4 = doneLatches.get(task.getId());
                if (countDownLatch4 != null) {
                    countDownLatch4.countDown();
                }
                C4148a.k(TAG, "task " + task.getId() + " done in " + jElapsedRealtime3 + "ms thread=" + Thread.currentThread().getName(), false, 4, null);
                throw th2;
            }
        }
        sb2.append("task ");
        sb2.append(id);
        sb2.append(" done in ");
        sb2.append(jElapsedRealtime);
        sb2.append("ms thread=");
        sb2.append(name);
        C4148a.k(TAG, sb2.toString(), false, 4, null);
    }

    public final g v(InterfaceC5063a<Boolean> provider) {
        p.i(provider, "provider");
        privacyProvider = provider;
        com.stepos.ailauncher.common.privacy.b.INSTANCE.d(provider);
        return this;
    }

    public final void w(Context context) {
        p.i(context, "context");
        if (started) {
            C4148a.u(TAG, "start ignored: already started", false, 4, null);
            return;
        }
        started = true;
        appContext = context.getApplicationContext();
        y();
        List<String> listX = x();
        C4148a.k(TAG, "start: " + listX.size() + " tasks, privacyGranted=" + p() + ", order=" + listX, false, 4, null);
        for (String str : listX) {
            h hVar = tasks.get(str);
            if (hVar != null && hVar.getStrategy() != InitStrategy.LAZY) {
                if (!hVar.getRequiresPrivacy() || p()) {
                    i(hVar);
                } else {
                    pendingPrivacyTasks.add(str);
                    C4148a.k(TAG, "task " + str + " gated by privacy, deferred until consent", false, 4, null);
                }
            }
        }
    }

    public final List<String> x() {
        List<String> listM1 = F.m1(registrationOrder);
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        Iterator<T> it = listM1.iterator();
        while (it.hasNext()) {
            map.put((String) it.next(), 0);
        }
        for (String str : listM1) {
            h hVar = tasks.get(str);
            if (hVar != null) {
                for (String str2 : hVar.c()) {
                    if (tasks.containsKey(str2)) {
                        Object arrayList = map2.get(str2);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            map2.put(str2, arrayList);
                        }
                        p.f(str);
                        ((List) arrayList).add(str);
                        Integer num = (Integer) map.get(str);
                        map.put(str, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listM1) {
            Integer num2 = (Integer) map.get((String) obj);
            if ((num2 != null ? num2.intValue() : 0) == 0) {
                arrayList2.add(obj);
            }
        }
        C1165m c1165m = new C1165m(arrayList2);
        ArrayList arrayList3 = new ArrayList(listM1.size());
        while (!c1165m.isEmpty()) {
            String str3 = (String) c1165m.removeFirst();
            arrayList3.add(str3);
            List<String> list = (List) map2.get(str3);
            if (list != null) {
                for (String str4 : list) {
                    Integer num3 = (Integer) map.get(str4);
                    int iIntValue = (num3 != null ? num3.intValue() : 0) - 1;
                    map.put(str4, Integer.valueOf(iIntValue));
                    if (iIntValue == 0) {
                        c1165m.add(str4);
                    }
                }
            }
        }
        if (arrayList3.size() == listM1.size()) {
            return arrayList3;
        }
        C4148a.h(TAG, "dependency cycle detected, fallback to registration order", false, 4, null);
        return listM1;
    }

    public final void y() {
        for (h hVar : tasks.values()) {
            p.h(hVar, "next(...)");
            h hVar2 = hVar;
            for (String str : hVar2.c()) {
                h hVar3 = tasks.get(str);
                if (hVar3 == null) {
                    C4148a.u(TAG, "task " + hVar2.getId() + " depends on missing '" + str + "'", false, 4, null);
                } else if (!hVar2.getRequiresPrivacy() && hVar3.getRequiresPrivacy()) {
                    C4148a.h(TAG, "task " + hVar2.getId() + " (non-gated) depends on privacy-gated '" + str + "'; mark " + hVar2.getId() + " requiresPrivacy=true to avoid await timeout when consent absent", false, 4, null);
                }
            }
        }
    }
}
