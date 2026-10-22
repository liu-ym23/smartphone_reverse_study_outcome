package y;

import Ua.C1071n0;
import Ua.CoroutineName;
import Ua.L0;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.h;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import z.C6046d;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011¨\u0006\u0019"}, d2 = {"Ly/a0;", "", "Landroidx/camera/camera2/pipe/h$g;", "threadConfig", "<init>", "(Landroidx/camera/camera2/pipe/h$g;)V", "Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;", "cameraPipeLifetime", "Lkotlinx/coroutines/g;", "cameraPipeJob", "Landroidx/camera/camera2/pipe/core/Threads;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;Lkotlinx/coroutines/g;)Landroidx/camera/camera2/pipe/core/Threads;", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/h$g;", "", Const.INTENT_KEY_PKGNAME, "I", "lightweightThreadCount", "c", "backgroundThreadCount", Const.INTENT_KEY_UMID, "cameraThreadPriority", "e", "defaultThreadPriority", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final h.ThreadConfig threadConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int lightweightThreadCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int backgroundThreadCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int cameraThreadPriority;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int defaultThreadPriority;

    public a0(h.ThreadConfig threadConfig) {
        kotlin.jvm.internal.p.i(threadConfig, "threadConfig");
        this.threadConfig = threadConfig;
        this.lightweightThreadCount = Math.max(4, Runtime.getRuntime().availableProcessors() - 2);
        this.backgroundThreadCount = 4;
        this.cameraThreadPriority = -3;
        this.defaultThreadPriority = -1;
    }

    public static final void h(List list) throws InterruptedException {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ExecutorService) it.next()).shutdownNow();
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ((ExecutorService) it2.next()).awaitTermination(1L, TimeUnit.SECONDS);
        }
    }

    public static final Handler i(a0 a0Var, CameraPipeLifetime cameraPipeLifetime) {
        if (a0Var.threadConfig.getDefaultCameraHandler() != null) {
            return a0Var.threadConfig.getDefaultCameraHandler();
        }
        final HandlerThread handlerThread = new HandlerThread("CXCP-Camera-H", a0Var.cameraThreadPriority);
        handlerThread.start();
        cameraPipeLifetime.d(CameraPipeLifetime.ShutdownType.THREAD, new Runnable() { // from class: y.U
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                a0.j(handlerThread);
            }
        });
        return new Handler(handlerThread.getLooper());
    }

    public static final void j(HandlerThread handlerThread) throws InterruptedException {
        handlerThread.quit();
        handlerThread.join(1000L);
    }

    public static final Executor k(a0 a0Var, CameraPipeLifetime cameraPipeLifetime) {
        if (a0Var.threadConfig.getDefaultCameraExecutor() != null) {
            return a0Var.threadConfig.getDefaultCameraExecutor();
        }
        C6046d c6046d = C6046d.f44499a;
        final ExecutorService executorServiceE = c6046d.e(c6046d.h(c6046d.k(c6046d.g(), "CXCP-Camera-E"), a0Var.cameraThreadPriority), 1);
        cameraPipeLifetime.d(CameraPipeLifetime.ShutdownType.THREAD, new Runnable() { // from class: y.V
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                a0.l(executorServiceE);
            }
        });
        return executorServiceE;
    }

    public static final void l(ExecutorService executorService) throws InterruptedException {
        executorService.shutdownNow();
        executorService.awaitTermination(1L, TimeUnit.SECONDS);
    }

    public static final void m(Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2) {
        kotlinx.coroutines.d.e((Ua.M) ref$ObjectRef.f34820a, null, 1, null);
        kotlinx.coroutines.d.e((Ua.M) ref$ObjectRef2.f34820a, null, 1, null);
    }

    /* JADX WARN: Type inference failed for: r13v12, types: [T, Ua.M] */
    /* JADX WARN: Type inference failed for: r13v4, types: [T, Ua.M] */
    /* JADX WARN: Type inference failed for: r13v7, types: [T, Ua.M] */
    /* JADX WARN: Type inference failed for: r14v2, types: [T, Ua.M] */
    public final Threads g(final CameraPipeLifetime cameraPipeLifetime, kotlinx.coroutines.g cameraPipeJob) {
        kotlin.jvm.internal.p.i(cameraPipeLifetime, "cameraPipeLifetime");
        kotlin.jvm.internal.p.i(cameraPipeJob, "cameraPipeJob");
        final ArrayList arrayList = new ArrayList();
        Executor defaultBlockingExecutor = this.threadConfig.getDefaultBlockingExecutor();
        if (defaultBlockingExecutor == null) {
            C6046d c6046d = C6046d.f44499a;
            defaultBlockingExecutor = c6046d.f(c6046d.h(c6046d.k(c6046d.g(), "CXCP-IO-"), this.defaultThreadPriority), 8);
            arrayList.add(defaultBlockingExecutor);
        }
        Executor executor = defaultBlockingExecutor;
        Ua.I iB = C1071n0.b(executor);
        Executor defaultBackgroundExecutor = this.threadConfig.getDefaultBackgroundExecutor();
        if (defaultBackgroundExecutor == null) {
            C6046d c6046d2 = C6046d.f44499a;
            defaultBackgroundExecutor = c6046d2.f(c6046d2.h(c6046d2.k(c6046d2.g(), "CXCP-BG-"), this.defaultThreadPriority), this.backgroundThreadCount);
            arrayList.add(defaultBackgroundExecutor);
        }
        Executor executor2 = defaultBackgroundExecutor;
        Ua.I iB2 = C1071n0.b(executor2);
        Executor defaultLightweightExecutor = this.threadConfig.getDefaultLightweightExecutor();
        if (defaultLightweightExecutor == null) {
            C6046d c6046d3 = C6046d.f44499a;
            defaultLightweightExecutor = c6046d3.f(c6046d3.h(c6046d3.k(c6046d3.g(), "CXCP-"), this.cameraThreadPriority), this.lightweightThreadCount);
            arrayList.add(defaultLightweightExecutor);
        }
        Executor executor3 = defaultLightweightExecutor;
        Ua.I iB3 = C1071n0.b(executor3);
        cameraPipeLifetime.d(CameraPipeLifetime.ShutdownType.THREAD, new Runnable() { // from class: y.W
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                a0.h(arrayList);
            }
        });
        InterfaceC5063a<Handler> interfaceC5063aE = this.threadConfig.e();
        if (interfaceC5063aE == null) {
            interfaceC5063aE = new InterfaceC5063a() { // from class: y.X
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return a0.i(this.f43719a, cameraPipeLifetime);
                }
            };
        }
        InterfaceC5063a<Handler> interfaceC5063a = interfaceC5063aE;
        InterfaceC5063a interfaceC5063a2 = new InterfaceC5063a() { // from class: y.Y
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return a0.k(this.f43721a, cameraPipeLifetime);
            }
        };
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        if (this.threadConfig.getTestOnlyScope() != null) {
            ref$ObjectRef.f34820a = this.threadConfig.getTestOnlyScope();
            ref$ObjectRef2.f34820a = this.threadConfig.getTestOnlyScope();
        } else {
            ref$ObjectRef.f34820a = kotlinx.coroutines.d.a(L0.a(cameraPipeJob).plus(iB3).plus(new CoroutineName("CXCP")));
            ref$ObjectRef2.f34820a = kotlinx.coroutines.d.a(L0.a(cameraPipeJob).plus(new CoroutineName("CXCP-Dispatch")));
            cameraPipeLifetime.d(CameraPipeLifetime.ShutdownType.SCOPE, new Runnable() { // from class: y.Z
                @Override // java.lang.Runnable
                public final void run() {
                    a0.m(ref$ObjectRef, ref$ObjectRef2);
                }
            });
        }
        return new Threads((Ua.M) ref$ObjectRef.f34820a, (Ua.M) ref$ObjectRef2.f34820a, executor, iB, executor2, iB2, executor3, iB3, interfaceC5063a, interfaceC5063a2);
    }
}
