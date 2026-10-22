package cc7;

import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends a {
    @Override // cc7.a
    public final void l() {
        this.f23314v.removeMessages(1);
    }

    @Override // cc7.a
    public final void n() {
        l();
        this.f23314v.sendEmptyMessageDelayed(1, 2000);
    }

    @Override // cc7.a, com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(BlockingQueue r100) {
        super(r100, "Account-DownloadDispatcher-Thread", "DownloadDispatcher");
    }

    @Override // cc7.a
    public final void a(com.bytedance.sdk.account.network.dispatcher.b r100) {
        r100.f269215c.removeMessages(1);
    }

    @Override // cc7.a, com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 != null) goto L12;
        return;
    L12:
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r100.what != 1) goto L14;
        a.A.d();     // Catch: Throwable -> L9
        return;
    }
}
