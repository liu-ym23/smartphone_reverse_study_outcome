package com.bytedance.android.sdk.bdticketguard.init;

import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import com.bytedance.android.sdk.bdticketguard.r0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class TicketInitTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f163760a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<InitTask, c> f163761b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<InitTask, ReentrantLock> f163762c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f163763d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<InitTask, Long> f163764e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f163765f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f163766g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final TicketInitTaskManager f163767h = null;

    static {
        int r100 = 0;
        f163760a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TicketInitTaskManager.class), "enableInitOpt", "getEnableInitOpt()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TicketInitTaskManager.class), "enableInitRefactor", "getEnableInitRefactor()Z"))};
        f163767h = new TicketInitTaskManager();
        f163761b = new ConcurrentHashMap();
        f163762c = new ConcurrentHashMap();
        f163763d = new AtomicBoolean(false);
        f163764e = new ConcurrentHashMap();
        f163765f = LazyKt.lazy(TicketInitTaskManager$enableInitOpt$2.INSTANCE);
        f163766g = LazyKt.lazy(TicketInitTaskManager$enableInitRefactor$2.INSTANCE);
        InitTask[] r101 = InitTask.values();
        int r102 = r101.length;
    L3:
        if (r100 >= r102) goto L5;
        InitTask r103 = r101[r100];
        f163761b.put(r103, c.d.f163776b);
        f163762c.put(r103, new ReentrantLock());
        r100 = r100 + 1;
        goto L3
    }

    public TicketInitTaskManager() {
    }

    public static boolean b() {
        Lazy r100 = f163765f;
        KProperty r101 = f163760a[0];
        return ((Boolean) r100.getValue()).booleanValue();
    }

    public static boolean c() {
        Lazy r100 = f163766g;
        KProperty r101 = f163760a[1];
        return ((Boolean) r100.getValue()).booleanValue();
    }

    public static void d() {
        int r100 = 0;
        if (f163763d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        int r101 = r0.f163979a;
        r0.c("TicketInitTaskManager", "TicketInitTaskManager onAllTaskCompleted, taskStates=" + f163761b);
        if (j.a(i.f163785a.f163789d) == true) goto L8;
        i.f163785a = i.a.a(i.f163785a, 0, 0, System.currentTimeMillis(), 0, 0, 119);
        r0.c("TicketInitTimeManager", "recordInitFinishTime: " + i.f163785a + "}\n" + i.a());
    L8:
        InitTask[] r102 = InitTask.values();
        int r103 = r102.length;
    L9:
        if (r100 >= r103) goto L15;
        InitTask r104 = r102[r100];
        String r105 = r104.getType();
        Long r106 = (Long) ((ConcurrentHashMap) f163764e).get(r104);
        if (r106 == null) goto L13;
        long r107 = r106.longValue();
    L14:
        String.valueOf(((ConcurrentHashMap) f163761b).get(r104));
        i.f163785a.f163792g.put(r105, Long.valueOf(Math.max(r107, -1)));
        r100 = r100 + 1;
        goto L9
    L13:
        r107 = -1;
        goto L14
    L15:
        boolean r108 = b();
        KProperty[] r109 = TicketGuardEventHelper.f163511a;
        JSONObject r110 = new JSONObject(i.a());
        TicketGuardEventHelper.f163517g.getClass();
        r110.put("is_enable_init_opt", r108 ? 1 : 0);
        TicketGuardEventHelper.B("bd_ticket_guard_init_finish", r110);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        r0.d(6, "TicketGuardEventHelper", "Monitor init finish failed! ", e);
    }

    public static void e(InitTask r100, c.f r101) {
        int r102 = r0.f163979a;
        r0.c("TicketInitTaskManager", "TicketInitTaskManager updateInitTaskState. task: " + r100 + ", state: " + r101);
        ReentrantLock r103 = (ReentrantLock) ((ConcurrentHashMap) f163762c).get(r100);
        if (r103 == null) goto L26;
        r103.lock();
        Map<InitTask, c> r104 = f163761b;     // Catch: Throwable -> L23
        ((ConcurrentHashMap) r104).put(r100, r101);     // Catch: Throwable -> L23
        if ((r101 instanceof c.f) == false) goto L21;
        f163767h.getClass();     // Catch: Throwable -> L23
        Collection r105 = ((ConcurrentHashMap) r104).values();     // Catch: Throwable -> L23
        if ((r105 instanceof Collection) == true) goto L10;
    L12:
        Iterator r106 = r105.iterator();     // Catch: Throwable -> L23
    L14:
        if (r106.hasNext() == false) goto L18;
        if ((((c) r106.next()) instanceof c.f) == true) goto L14;
        boolean r107 = false;
    L19:
        if (r107 == false) goto L21;
        d();     // Catch: Throwable -> L23
    L18:
        r107 = true;
        goto L19
    L10:
        if (r105.isEmpty() == false) goto L12;
    L21:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r103.unlock();
        return;
    L23:
        th = move-exception;
        r103.unlock();
        throw th;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.sdk.bdticketguard.init.TicketInitTaskManager$doInitializeLocked$1] */
    public static void a(final InitTask r100, final Function2 r101, Function1 r110) {
        ?? r102 = new TicketInitTaskManager$doInitializeLocked$1(r100, r101);
        Function0<Unit> r103 = new TicketInitTaskManager$doInitializeLocked$2(r100, r101);
        Map<InitTask, c> r104 = f163761b;
        Object r105 = ((ConcurrentHashMap) r104).get(r100);
        if (r105 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        c.g r106 = c.g.f163778b;
        if (Intrinsics.areEqual((c) r105, r106) == false) goto L9;
        r102.invoke(true);
        return;
    L9:
        ReentrantLock r107 = (ReentrantLock) ((ConcurrentHashMap) f163762c).get(r100);
        if (r107 == null) goto L47;
        r107.lock();
        f163767h.getClass();     // Catch: Throwable -> L44
        Object r108 = ((ConcurrentHashMap) r104).get(r100);     // Catch: Throwable -> L44
        if (r108 != null) goto L15;
        Intrinsics.throwNpe();     // Catch: Throwable -> L44
    L15:
        c r109 = (c) r108;     // Catch: Throwable -> L44
        if (Intrinsics.areEqual(r109, r106) == false) goto L20;
        r102.invoke(true);     // Catch: Throwable -> L44
        r107.unlock();
        return;
    L20:
        long r111 = System.currentTimeMillis();     // Catch: Throwable -> L44
        if (Intrinsics.areEqual(r109, c.e.f163777b) == false) goto L24;
        c.f r112 = (c.f) r110.invoke(c.b.f163775b);     // Catch: Throwable -> L44
    L31:
        long r113 = System.currentTimeMillis() - r111;     // Catch: Throwable -> L44
        ((ConcurrentHashMap) f163764e).put(r100, Long.valueOf(r113));     // Catch: Throwable -> L44
        if (r112 != null) goto L34;
        Intrinsics.throwNpe();     // Catch: Throwable -> L44
    L34:
        e(r100, r112);     // Catch: Throwable -> L44
        if ((r112 instanceof c.g) == false) goto L38;
        r102.invoke(false);     // Catch: Throwable -> L44
    L41:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L44
        r107.unlock();
        return;
    L38:
        if ((r112 instanceof c.b) == false) goto L40;
        r103.invoke2();     // Catch: Throwable -> L44
        goto L41
    L40:
        int r115 = r0.f163979a;     // Catch: Throwable -> L44
        r0.c("TicketInitTaskManager", "TicketInitTaskManager doInitialize " + r100 + " pending");     // Catch: Throwable -> L44
        goto L41
    L24:
        if ((r109 instanceof c.InterfaceC2499c) == true) goto L26;
        r109 = null;
    L26:
        c r116 = (c.InterfaceC2499c) r109;     // Catch: Throwable -> L44
        if (r116 != null) goto L30;
        r116 = c.b.f163775b;     // Catch: Throwable -> L44
    L30:
        r112 = (c.f) r110.invoke(r116);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        r107.unlock();
        throw th;
    L47:
        r103.invoke2();
    }
}
