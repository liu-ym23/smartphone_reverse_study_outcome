package com.baidu.naviapi.worker;

import com.baidu.naviapi.okhttp.log.BNLogUtil;
import com.baidu.naviapi.open.INaviMsgCallback;
import com.baidu.naviapi.open.MsgBean;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<INaviMsgCallback> f32707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f32708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f32709c;

    /* JADX INFO: renamed from: com.baidu.naviapi.worker.a$a, reason: collision with other inner class name */
    public class RunnableC0661a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f32710a;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_naviapi_worker_a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_naviapi_worker_a$a__run$___twin___() {
            a.a(this.f32710a);
        }

        public RunnableC0661a(a r100) {
            this.f32710a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_naviapi_worker_a$a_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0661a r100) {
            r100.com_baidu_naviapi_worker_a$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f32711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f32712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f32713c;

        public b() {
            this.f32712b = new AtomicInteger(1);
            SecurityManager r100 = System.getSecurityManager();
            if (r100 == null) goto L5;
            ThreadGroup r101 = r100.getThreadGroup();
        L6:
            this.f32711a = r101;
            this.f32713c = "BNAConsumer-" + new AtomicInteger(1).getAndIncrement() + "-thread-";
            return;
        L5:
            r101 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(this.f32711a, r100, this.f32713c + this.f32712b.getAndIncrement(), 0);
            if (r101.isDaemon() == false) goto L6;
            r101.setDaemon(false);
        L6:
            if (r101.getPriority() == 5) goto L8;
            ThreadMethodProxy.setPriority(r101, 5);
        L8:
            return r101;
        }
    }

    public void b() {
        this.f32708b = true;
        com.baidu.naviapi.worker.b.f32714c.a();
    }

    public final void a() {
    L3:
        if (this.f32708b == true) goto L13;
        com.baidu.naviapi.worker.b r100 = com.baidu.naviapi.worker.b.f32714c;
        MsgBean r101 = r100.b();
        if (r101 == null) goto L12;
        List<INaviMsgCallback> r102 = this.f32707a;
        if (r102 == null) goto L12;
        Iterator<INaviMsgCallback> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L3;
        r103.next().onMessage(r101);
    L12:
        r100.c();
        goto L3
    }

    public void c() {
        BNLogUtil.logI("BNAConsumer", "Consumer run");
        this.f32709c.execute(new RunnableC0661a(this));
    }

    public a() {
        this.f32708b = false;
        this.f32709c = new PThreadPoolExecutor(0, Integer.MAX_VALUE, 1, TimeUnit.SECONDS, new SynchronousQueue(), new b());
    }

    public static /* synthetic */ void a(a r100) {
        r100.a();
    }

    public void a(List<INaviMsgCallback> r100) {
        this.f32707a = r100;
    }
}
