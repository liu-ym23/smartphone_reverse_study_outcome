package E2;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final f f458a;
    public static final f b;
    public static final f c;
    public static final ScheduledExecutorService d;
    public static final f e;
    public static final f f;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        if (iAvailableProcessors <= 0) {
            iAvailableProcessors = 1;
        }
        int i = iAvailableProcessors - 1;
        int iMax = Math.max(2, Math.min(i, 6));
        d dVar = new d("TTDefaultExecutors");
        d dVar2 = new d("TTCpuExecutors");
        d dVar3 = new d("TTScheduledExecutors");
        d dVar4 = new d("TTDownLoadExecutors");
        d dVar5 = new d("TTSerialExecutors");
        c cVar = new c();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        LinkedBlockingQueue linkedBlockingQueue3 = new LinkedBlockingQueue();
        a aVar = new a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f fVar = new f(iMax * 2, (iMax * 4) + 1, 30L, timeUnit, linkedBlockingQueue, dVar, aVar);
        f458a = fVar;
        fVar.allowCoreThreadTimeOut(true);
        f fVar2 = new f(Math.max(2, Math.min(i, 3)), (iAvailableProcessors * 2) + 1, 30L, timeUnit, linkedBlockingQueue2, dVar2, aVar);
        b = fVar2;
        fVar2.allowCoreThreadTimeOut(true);
        d = Executors.newScheduledThreadPool(3, dVar3);
        f fVar3 = new f(2, 2, 30L, timeUnit, linkedBlockingQueue3, dVar4, aVar);
        c = fVar3;
        fVar3.allowCoreThreadTimeOut(true);
        f fVar4 = new f(1, 1, new LinkedBlockingQueue(), dVar5);
        e = fVar4;
        fVar4.allowCoreThreadTimeOut(true);
        f fVar5 = new f(0, 3, new LinkedBlockingQueue(), cVar);
        f = fVar5;
        fVar5.allowCoreThreadTimeOut(true);
    }
}
