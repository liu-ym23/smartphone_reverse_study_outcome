package com.bytedance.android.shopping.yata.biz.popup;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import hl3.f;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityBlockingQueue<hl3.a> f187514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityBlockingQueue<hl3.a> f187515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f187516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f187517d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.yata.biz.popup.b$b, reason: collision with other inner class name */
    public final class C2745b implements Comparator<hl3.a> {
        public C2745b() {
        }

        @Override // java.util.Comparator
        public final int compare(hl3.a r100, hl3.a r101) {
            Intrinsics.checkNotNullParameter(r100, DevicePlans.DEVICE_PLAN_OPPO1);
            Intrinsics.checkNotNullParameter(r101, DevicePlans.DEVICE_PLAN_OPPO2);
            return 0;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f187518a;

        public c(b r100) {
            this.f187518a = r100;
        }

        public final void a() {
        L3:
            if (this.f187518a.f187515b.size() <= 0) goto L13;
            final hl3.a r100 = this.f187518a.f187515b.poll();
            if (r100 == null) goto L3;
            final b r101 = this.f187518a;
            r101.getClass();
            Function0<Boolean> r102 = new PopupQueue$handle$1(r101, r100);
            Function1<hl3.a, Unit> r103 = new PopupQueue$handle$2(r101);
            if (r101.f187514a.isEmpty() == true) goto L8;
            if (r101.f187514a.size() <= 10) goto L12;
            r103.invoke2((hl3.a) CollectionsKt.last(r101.f187514a));
        L12:
            r102.invoke2();
            goto L3
        L8:
            r102.invoke2();
            goto L3
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
    }

    public final hl3.a c() {
        if (this.f187514a.size() > 0) goto L7;
        return null;
    L7:
        return (hl3.a) CollectionsKt.last(this.f187514a);
    }

    public b() {
        this.f187514a = new PriorityBlockingQueue(10, new C2745b());
        this.f187515b = new PriorityBlockingQueue(11, new C2745b());
        this.f187516c = new Handler(Looper.getMainLooper());
        this.f187517d = new c(this);
    }

    public final void b() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        this.f187517d.run();
        return;
    L5:
        this.f187516c.removeCallbacksAndMessages(null);
        this.f187516c.post(this.f187517d);
    }

    @Override // hl3.f
    public final void a(com.bytedance.android.shopping.yata.biz.popup.a r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        this.f187514a.remove(r100);
        if (this.f187514a.isEmpty() == false) goto L6;
        b();
        return;
    }
}
