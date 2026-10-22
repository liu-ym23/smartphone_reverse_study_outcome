package cc7;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.sdk.account.network.dispatcher.IRequest;
import com.bytedance.sdk.account.network.dispatcher.c;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class a extends PthreadThreadV2 implements WeakHandler.IHandler {
    public static final c A = null;
    public static final AtomicInteger B = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final WeakHandler f23314v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final BlockingQueue<IRequest> f23315w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f23316x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile boolean f23317y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f23318z;

    public void l() {
        this.f23314v.removeMessages(0);
    }

    public final void m() {
        Process.setThreadPriority(10);
    L36:
        IRequest r100 = this.f23315w.take();     // Catch: InterruptedException -> L31
        l();     // Catch: InterruptedException -> L31
        if (r100 == null) goto L36;
        if ((r100 instanceof com.bytedance.sdk.account.network.dispatcher.b) == false) goto L36;
        com.bytedance.sdk.account.network.dispatcher.b r101 = (com.bytedance.sdk.account.network.dispatcher.b) r100;
        String r102 = null;
        this.f23317y = true;     // Catch: Throwable -> L22
        a(r101);     // Catch: Throwable -> L22
        if (r101.f269214b.get() == true) goto L11;
        String r103 = ThreadMethodProxy.currentThread().getName();     // Catch: Throwable -> L22
        r102 = r101.f269217e;     // Catch: Throwable -> L20
        if (StringUtils.isEmpty(r102) == false) goto L16;
    L18:
        tb7.a.a(this.f23318z, "thread (inc) count: " + B.incrementAndGet());     // Catch: Throwable -> L20
        r101.run();     // Catch: Throwable -> L20
        n();     // Catch: Throwable -> L20
    L25:
        this.f23317y = false;
        if (StringUtils.isEmpty(r102) == false) goto L28;
    L30:
        tb7.a.a(this.f23318z, "thread (dec) count: " + B.decrementAndGet());
        goto L36
    L28:
        if (StringUtils.isEmpty(r103) == true) goto L30;
        ThreadMethodProxy.setName(ThreadMethodProxy.currentThread(), r103);
        goto L30
    L16:
        if (StringUtils.isEmpty(r103) == true) goto L18;
        ThreadMethodProxy.setName(ThreadMethodProxy.currentThread(), r102);     // Catch: Throwable -> L20
    L20:
        th = th;
        String r104 = r102;
        r102 = r103;
    L24:
        tb7.a.c(this.f23318z, "processLegacyApiThread: ", th);
        r103 = r102;
        r102 = r104;
        goto L25
    L11:
        this.f23317y = false;     // Catch: Throwable -> L22
    L22:
        th = th;
        r104 = null;
    L32:
        if (this.f23316x == false) goto L36;
    }

    static {
        A = c.a();
        B = new AtomicInteger();
    }

    public void n() {
        l();
        this.f23314v.sendEmptyMessageDelayed(0, 2000);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public void run() {
        m();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public void a(com.bytedance.sdk.account.network.dispatcher.b r100) {
        r100.f269215c.removeMessages(0);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r100) {
        if (r100 != null) goto L12;
        return;
    L12:
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r100.what != 0) goto L14;
        A.e();     // Catch: Throwable -> L9
        return;
    }

    public a(BlockingQueue<IRequest> r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r101 = "ApiDispatcher-Thread";
    L5:
        super(r101);
        this.f23314v = new WeakHandler(Looper.getMainLooper(), this);
        this.f23316x = false;
        this.f23317y = false;
        this.f23318z = "ApiDispatcher";
        this.f23315w = r100;
        this.f23318z = r102;
    }
}
