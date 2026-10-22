package com.bytedance.android.ec.core.anchorv3;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.facebook.common.executors.HandlerExecutorServiceImpl;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class PdpMessageOptImageHelper {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f43755e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f43756f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f43757g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Boolean f43758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f43759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Runnable> f43760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f43761d;

    public static final class a extends HandlerExecutorServiceImpl {

        /* JADX INFO: renamed from: com.bytedance.android.ec.core.anchorv3.PdpMessageOptImageHelper$a$a, reason: collision with other inner class name */
        public static final class RunnableC0790a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f43762a;

            public RunnableC0790a(Runnable r100) {
                this.f43762a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Runnable r100 = this.f43762a;     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.run();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public a(Handler r100) {
            super(r100);
        }

        @Override // com.facebook.common.executors.HandlerExecutorServiceImpl, java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            Lazy r101 = UIUtils.f45548a;
            UIUtils.c().postAtFrontOfQueue(new RunnableC0790a(r100));
        }
    }

    public static final class b {
        public b() {
        }

        public static void a(Object r100, Executor r101) {
            Intrinsics.checkNotNullParameter(r100, "controller");
            if ((r100 instanceof com.bytedance.android.ecom.arch.slice.render.widget.fresco.h) == false) goto L11;
            com.bytedance.android.ecom.arch.slice.render.widget.fresco.h r102 = (com.bytedance.android.ecom.arch.slice.render.widget.fresco.h) r100;     // Catch: Exception -> L17
            if (r101 != null) goto L8;
            r101 = PdpMessageOptImageHelper.f43756f;     // Catch: Exception -> L17
        L8:
            if (r101 == null) goto L10;
            r102.f50943b = r101;     // Catch: Exception -> L17
            return;
        L10:
            r102.getClass();     // Catch: Exception -> L17
            return;
        L11:
            Field r103 = (Field) PdpMessageOptImageHelper.f43755e.getValue();     // Catch: Exception -> L17
            if (r103 == null) goto L21;
            if (r101 != null) goto L15;
            r101 = PdpMessageOptImageHelper.f43756f;     // Catch: Exception -> L17
        L15:
            r103.set(r100, r101);     // Catch: Exception -> L17
            return;
        L21:
            return;
        }
    }

    public static final class c extends HandlerExecutorServiceImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdpMessageOptImageHelper f43763a;

        @Override // com.facebook.common.executors.HandlerExecutorServiceImpl, java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            if (r100 == null) goto L17;
            Lazy r101 = UIUtils.f45548a;
            if (UIUtils.d() == false) goto L6;
            r100.run();
            return;
        L6:
            List<Runnable> r102 = this.f43763a.f43760c;
            monitor-enter(r102);
        L14:
            th = move-exception;
            throw th;
        L9:
            if (Intrinsics.areEqual(this.f43763a.f43758a, Boolean.TRUE) == false) goto L11;
            ((ArrayList) this.f43763a.f43760c).add(r100);     // Catch: Throwable -> L14
        L12:
            monitor-exit(r102);
            return;
        L11:
            this.f43763a.f43759b.postAtFrontOfQueue(r100);     // Catch: Throwable -> L14
            goto L12
        }

        public c(PdpMessageOptImageHelper r100, Handler r101) {
            this.f43763a = r100;
            super(r101);
        }
    }

    static {
        f43757g = new b();
        f43755e = LazyKt.lazy(PdpMessageOptImageHelper$Companion$fieldUIExecutor$2.INSTANCE);
        Lazy r100 = UIUtils.f45548a;
        f43756f = new a(UIUtils.c());
    }

    public final boolean a() {
        if (((ArrayList) this.f43760c).size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b() {
        boolean r100 = PdpMessageOpt.f43751a;
        PdpMessageOpt.e("pending image size=" + ((ArrayList) this.f43760c).size());
        List<Runnable> r101 = this.f43760c;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (a() == false) goto L7;
        ArrayList r102 = new ArrayList(this.f43760c);     // Catch: Throwable -> L16
        ((ArrayList) this.f43760c).clear();     // Catch: Throwable -> L16
    L8:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r101);
        if (r102 == null) goto L15;
        Iterator r104 = r102.iterator();
    L13:
        if (r104.hasNext() == false) goto L22;
        ((Runnable) r104.next()).run();
        goto L13
    L22:
        return;
    L15:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public PdpMessageOptImageHelper() {
        Handler r100 = new Handler(Looper.getMainLooper());
        this.f43759b = r100;
        this.f43760c = new ArrayList();
        this.f43761d = new c(this, r100);
    }
}
