package com.bytedance.android.shopping.orderlist.common.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderCommonLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f179948a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f179949b = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f179950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f179951b;

        public a(String r100, Function0 r101) {
            this.f179950a = r100;
            this.f179951b = r101;
        }

        public final void a() {
            dm.a.b r100 = dm.a.f469202a;     // Catch: Exception -> L5
            dm.a.a("order_common_" + this.f179950a).a((String) this.f179951b.invoke());     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            ECExceptionMonitor.e(e);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f179952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f179953b;

        public b(String r100, Function0 r101) {
            this.f179952a = r100;
            this.f179953b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            dm.a.b r100 = dm.a.f469202a;     // Catch: Exception -> L5 Throwable -> L8
            dm.a.a("order_common_" + this.f179952a).b((String) this.f179953b.invoke(), null);     // Catch: Exception -> L5 Throwable -> L8
        L13:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L5:
            e = move-exception;
            ECExceptionMonitor.e(e);     // Catch: Throwable -> L8
            goto L13
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f179954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f179955b;

        public c(String r100, Function0 r101) {
            this.f179954a = r100;
            this.f179955b = r101;
        }

        public final void a() {
            dm.a.b r100 = dm.a.f469202a;     // Catch: Exception -> L5
            dm.a.a("order_common_" + this.f179954a).i((String) this.f179955b.invoke());     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            ECExceptionMonitor.e(e);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f179948a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, OrderCommonLog$orderLogExecutor$2.INSTANCE);
        f179949b = LazyKt.lazy(OrderCommonLog$isDebugOrLocalTest$2.INSTANCE);
    }

    public static void a(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (((Boolean) f179949b.getValue()).booleanValue() == false) goto L6;
        ((ExecutorService) f179948a.getValue()).execute(new a(r100, r101));
        return;
    }

    public static void b(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ((ExecutorService) f179948a.getValue()).execute(new b(r100, r101));
    }

    public static void c(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ((ExecutorService) f179948a.getValue()).execute(new c(r100, r101));
    }
}
