package w4;

import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue;
import com.bytedance.retrofit2.SsRunnable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class c implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile IRequestQueue f25363a;

    static {
    }

    public c() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r10) {
        if (r10 == null) goto L27;
        IRequest.Priority r11 = IRequest.Priority.NORMAL;
        if ((r10 instanceof SsRunnable) == false) goto L18;
        SsRunnable r12 = (SsRunnable) r10;
        int r13 = r12.priority();
        if (r13 != 0) goto L9;
        r11 = IRequest.Priority.LOW;
    L17:
        boolean r14 = r12.isStreaming();
        IRequest.Priority r15 = r11;
        int r16 = r12.getRequestDelayTime();
    L20:
        if (f25363a != null) goto L22;
        f25363a = n4.b.a();
    L22:
        com.bytedance.frameworks.baselib.network.dispatcher.a r17 = new com.bytedance.frameworks.baselib.network.dispatcher.a("NetExecutor", r15, r16, r10, r14);
        if (r14 == false) goto L25;
        f25363a.addDownload(r17);
        return;
    L25:
        f25363a.add(r17);
        return;
    L9:
        if (1 == r13) goto L17;
        if (2 != r13) goto L15;
        r11 = IRequest.Priority.HIGH;
        goto L17
    L15:
        if (3 != r13) goto L17;
        r11 = IRequest.Priority.IMMEDIATE;
        goto L17
    L18:
        r14 = false;
        r15 = r11;
        r16 = 0;
        goto L20
    }
}
