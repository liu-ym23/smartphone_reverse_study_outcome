package com.bytedance.android.ec.store.utils.taskmanager;

import android.os.Looper;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECTaskManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f48688b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, b> f48689a;

    public static final class a {
        public static ECTaskManager a() {
            return (ECTaskManager) ECTaskManager.f48688b.getValue();
        }
    }

    static {
        f48688b = LazyKt.lazy(LazyThreadSafetyMode.NONE, ECTaskManager$Companion$instance$2.INSTANCE);
    }

    public ECTaskManager() {
        this.f48689a = new LinkedHashMap();
    }

    public static void b(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        int r101 = c.f48696c;
        c.b.f48699a.a(ExecutorType.IO, r100);
    }

    public final void c(long r100, TaskPriority r101) {
        Intrinsics.checkNotNullParameter(r101, "priority");
        Map<Long, b> r102 = this.f48689a;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        b r104 = (b) r103.get(Long.valueOf(r100));
        if (r104 == null) goto L6;
        Intrinsics.checkNotNullParameter(r101, "priority");
        r104.f48695b = r101;
        r104.a();
        return;
    }

    public final void a(long r100, TaskPriority r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "priority");
        Intrinsics.checkNotNullParameter(r102, "runnable");
        if (((LinkedHashMap) this.f48689a).get(Long.valueOf(r100)) != null) goto L5;
        this.f48689a.put(Long.valueOf(r100), new b());
    L5:
        b r103 = (b) ((LinkedHashMap) this.f48689a).get(Long.valueOf(r100));
        if (r103 == null) goto L18;
        Intrinsics.checkNotNullParameter(r101, "priority");
        Intrinsics.checkNotNullParameter(r102, "runnable");
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L11;
        ECExceptionMonitor.e(new Throwable("you should invoke PriorityTask.addTask on main thread"));
    L11:
        if (r103.f48694a.containsKey(Integer.valueOf(r101.getValue())) == true) goto L13;
        r103.f48694a.put(Integer.valueOf(r101.getValue()), new ArrayList());
    L13:
        List r104 = (List) ((LinkedHashMap) r103.f48694a).get(Integer.valueOf(r101.getValue()));
        if (r104 == null) goto L16;
        r104.add(r102);
    L16:
        r103.a();
        return;
    }
}
