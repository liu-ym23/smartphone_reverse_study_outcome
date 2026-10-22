package com.bytedance.android.sdk.bdticketguard.init;

import com.bytedance.android.sdk.bdticketguard.TicketGuardManager;
import com.bytedance.android.sdk.bdticketguard.c1;
import com.bytedance.android.sdk.bdticketguard.r0;
import com.bytedance.android.sdk.bdticketguard.utils.TGThreadUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class TicketGuardBootFinishManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f163752a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Function0<Boolean> f163753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f163754c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f163755d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TicketGuardBootFinishManager f163756e = null;

    /* JADX INFO: loaded from: classes12.dex */
    public interface a {
        void a();
    }

    static {
        f163752a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TicketGuardBootFinishManager.class), "listeners", "getListeners()Ljava/util/concurrent/CopyOnWriteArrayList;"))};
        f163756e = new TicketGuardBootFinishManager();
        f163754c = new AtomicBoolean(false);
        new AtomicBoolean(false);
        f163755d = LazyKt.lazy(TicketGuardBootFinishManager$listeners$2.INSTANCE);
    }

    public TicketGuardBootFinishManager() {
    }

    public static CopyOnWriteArrayList b() {
        Lazy r100 = f163755d;
        KProperty r101 = f163752a[0];
        return (CopyOnWriteArrayList) r100.getValue();
    }

    public static boolean c() {
        if (f163754c.get() == false) goto L7;
        return true;
    L7:
        return e();
    }

    public static void d() {
        if (f163754c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        r0.c("TicketGuardBootFinishManager", "markBootFinish, true");
        TGThreadUtils r100 = TGThreadUtils.f164077f;
        TicketGuardBootFinishManager$markBootFinish$1 r101 = TicketGuardBootFinishManager$markBootFinish$1.INSTANCE;
        r100.getClass();
        TGThreadUtils.a(r101);
        TicketGuardManager r102 = c1.f163567a;
        TicketGuardManager r103 = c1.f163567a;
        if (r103 != null) goto L8;
        r0.b("TicketGuardBootFinishManager", "executeBootTasks, manager is null");
        return;
    L8:
        Iterator<T> r104 = r103.w().iterator();
    L10:
        if (r104.hasNext() == false) goto L14;
        final e r105 = (e) r104.next();
        Pair<Long, TimeUnit> r106 = r105.a();
        TGThreadUtils r107 = TGThreadUtils.f164077f;
        Function0<Unit> r108 = new TicketGuardBootFinishManager$executeBootTasks$1$1(r105);
        long r109 = r106.getFirst().longValue();
        TimeUnit r110 = r106.getSecond();
        r107.getClass();
        com.bytedance.android.sdk.bdticketguard.utils.f r111 = new com.bytedance.android.sdk.bdticketguard.utils.f(r108);
        Lazy r112 = TGThreadUtils.f164076e;
        KProperty r113 = TGThreadUtils.f164072a[1];
        ((ScheduledExecutorService) r112.getValue()).schedule(new com.bytedance.android.sdk.bdticketguard.utils.g(r111), r109, r110);
        goto L10
    }

    public static boolean e() {
        if (f163754c.get() == false) goto L5;
        return true;
    L5:
        Function0<Boolean> r100 = f163753b;
        if (r100 != null) goto L17;
        r0.f("TicketGuardBootFinishManager", "isAppBootFinishedGetter is null, treat as bootFinished");
        d();
        return true;
    L17:
    L12:
        e = move-exception;
        r0.d(6, "TicketGuardBootFinishManager", "isAppBootFinishedGetter invoke failed, treat as bootFinished", e);
        d();
        return true;
    L8:
        if (r100.invoke().booleanValue() == false) goto L19;
        d();     // Catch: Exception -> L12
        return true;
    L19:
        return false;
    }

    public static void a(final a r100) {
        if (c() == false) goto L6;
        TGThreadUtils r101 = TGThreadUtils.f164077f;
        Function0<Unit> r102 = new TicketGuardBootFinishManager$addBootFinishListener$1(r100);
        r101.getClass();
        TGThreadUtils.a(r102);
        return;
    L6:
        b().add(r100);
        if (c() == true) goto L9;
        return;
    L9:
        if (b().remove(r100) == false) goto L13;
        TGThreadUtils r103 = TGThreadUtils.f164077f;
        Function0<Unit> r104 = new TicketGuardBootFinishManager$addBootFinishListener$2(r100);
        r103.getClass();
        TGThreadUtils.a(r104);
        return;
    }
}
