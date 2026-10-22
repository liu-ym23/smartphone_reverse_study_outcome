package androidx.camera.camera2.pipe.core;

import Ua.C1056g;
import Ua.C1060i;
import Ua.I;
import Ua.M;
import Ua.Q;
import Y8.h;
import android.os.Handler;
import android.util.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.concurrent.Executor;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import z.k;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0015\u001a\u00020\u00142\u001c\u0010\u0018\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0016¢\u0006\u0004\b\u0019\u0010\u001aJA\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u001b\u001a\u00020\u00072\u001c\u0010\u0018\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010 R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b,\u0010%\u001a\u0004\b-\u0010'R\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b.\u0010+R\u0017\u0010\u000b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b/\u0010'R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b0\u0010)\u001a\u0004\b1\u0010+R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u0005028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u00104R\u0011\u0010\u000f\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b3\u00107R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b0\u0010'¨\u00068"}, d2 = {"Landroidx/camera/camera2/pipe/core/Threads;", "", "LUa/M;", "cameraPipeScope", "cameraPipeDispatchScope", "Ljava/util/concurrent/Executor;", "blockingExecutor", "LUa/I;", "blockingDispatcher", "backgroundExecutor", "backgroundDispatcher", "lightweightExecutor", "lightweightDispatcher", "Lkotlin/Function0;", "Landroid/os/Handler;", "camera2Handler", "camera2Executor", "<init>", "(LUa/M;LUa/M;Ljava/util/concurrent/Executor;LUa/I;Ljava/util/concurrent/Executor;LUa/I;Ljava/util/concurrent/Executor;LUa/I;Lp9/a;Lp9/a;)V", ExifInterface.GPS_DIRECTION_TRUE, "", "timeoutMs", "Lkotlin/Function1;", "Le9/c;", "block", "n", "(JLp9/l;)Ljava/lang/Object;", "dispatcher", "LUa/Q;", "m", "(LUa/I;Lp9/l;)LUa/Q;", Const.INTENT_KEY_APIKEY, "LUa/M;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()LUa/M;", Const.INTENT_KEY_PKGNAME, "c", "Ljava/util/concurrent/Executor;", "getBlockingExecutor", "()Ljava/util/concurrent/Executor;", Const.INTENT_KEY_UMID, "LUa/I;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()LUa/I;", "e", "getBackgroundExecutor", "f", "l", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "k", "LY8/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LY8/h;", "_camera2Handler", "_camera2Executor", "()Landroid/os/Handler;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Threads {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final M cameraPipeScope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final M cameraPipeDispatchScope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Executor blockingExecutor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final I blockingDispatcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Executor backgroundExecutor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final I backgroundDispatcher;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Executor lightweightExecutor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final I lightweightDispatcher;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final h<Handler> _camera2Handler;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final h<Executor> _camera2Executor;

    public Threads(M cameraPipeScope, M cameraPipeDispatchScope, Executor blockingExecutor, I blockingDispatcher, Executor backgroundExecutor, I backgroundDispatcher, Executor lightweightExecutor, I lightweightDispatcher, final InterfaceC5063a<? extends Handler> camera2Handler, final InterfaceC5063a<? extends Executor> camera2Executor) {
        p.i(cameraPipeScope, "cameraPipeScope");
        p.i(cameraPipeDispatchScope, "cameraPipeDispatchScope");
        p.i(blockingExecutor, "blockingExecutor");
        p.i(blockingDispatcher, "blockingDispatcher");
        p.i(backgroundExecutor, "backgroundExecutor");
        p.i(backgroundDispatcher, "backgroundDispatcher");
        p.i(lightweightExecutor, "lightweightExecutor");
        p.i(lightweightDispatcher, "lightweightDispatcher");
        p.i(camera2Handler, "camera2Handler");
        p.i(camera2Executor, "camera2Executor");
        this.cameraPipeScope = cameraPipeScope;
        this.cameraPipeDispatchScope = cameraPipeDispatchScope;
        this.blockingExecutor = blockingExecutor;
        this.blockingDispatcher = blockingDispatcher;
        this.backgroundExecutor = backgroundExecutor;
        this.backgroundDispatcher = backgroundDispatcher;
        this.lightweightExecutor = lightweightExecutor;
        this.lightweightDispatcher = lightweightDispatcher;
        this._camera2Handler = C4848b.b(new InterfaceC5063a() { // from class: z.u
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Threads.d(camera2Handler);
            }
        });
        this._camera2Executor = C4848b.b(new InterfaceC5063a() { // from class: z.v
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Threads.c(camera2Executor);
            }
        });
    }

    public static final Executor c(InterfaceC5063a interfaceC5063a) {
        return (Executor) interfaceC5063a.invoke();
    }

    public static final Handler d(InterfaceC5063a interfaceC5063a) {
        return (Handler) interfaceC5063a.invoke();
    }

    /* renamed from: f, reason: from getter */
    public final I getBackgroundDispatcher() {
        return this.backgroundDispatcher;
    }

    /* renamed from: g, reason: from getter */
    public final I getBlockingDispatcher() {
        return this.blockingDispatcher;
    }

    public final Executor h() {
        return this._camera2Executor.getValue();
    }

    public final Handler i() {
        return this._camera2Handler.getValue();
    }

    /* renamed from: j, reason: from getter */
    public final M getCameraPipeScope() {
        return this.cameraPipeScope;
    }

    /* renamed from: k, reason: from getter */
    public final I getLightweightDispatcher() {
        return this.lightweightDispatcher;
    }

    /* renamed from: l, reason: from getter */
    public final Executor getLightweightExecutor() {
        return this.lightweightExecutor;
    }

    public final <T> Q<T> m(I dispatcher, InterfaceC5074l<? super InterfaceC4014c<? super T>, ? extends Object> block) {
        return C1060i.b(this.cameraPipeDispatchScope, dispatcher, null, new Threads$runAsyncSupervised$1(block, null), 2, null);
    }

    public final <T> T n(long timeoutMs, InterfaceC5074l<? super InterfaceC4014c<? super T>, ? extends Object> block) {
        p.i(block, "block");
        try {
            return (T) C1056g.e(this.blockingDispatcher, new Threads$runBlockingCheckedOrNull$1(this, block, timeoutMs, null));
        } catch (InterruptedException e10) {
            if (!k.f44508a.c()) {
                return null;
            }
            Log.i("CXCP", "runBlockingCheckedOrNull cancelled by thread interruption", e10);
            return null;
        }
    }
}
