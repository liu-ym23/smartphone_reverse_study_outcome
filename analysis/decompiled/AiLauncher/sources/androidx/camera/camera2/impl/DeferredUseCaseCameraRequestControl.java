package androidx.camera.camera2.impl;

import Ua.C1056g;
import Ua.C1060i;
import Ua.C1071n0;
import Ua.Q;
import Y8.t;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.l;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import t.y0;
import w.Result3A;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ=\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J=\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J/\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\u00162\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J1\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\"\u001a\u00020!2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000b0\tH\u0016¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u0011H\u0016¢\u0006\u0004\b(\u0010)J\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020'0\u00112\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0015\u0010.\u001a\b\u0012\u0004\u0012\u00020'0\u0011H\u0016¢\u0006\u0004\b.\u0010)JC\u00106\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001050\u00110\u00162\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0\u00162\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0016¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u001aH\u0096@¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0012H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0003H\u0002¢\u0006\u0004\b<\u0010=R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006H"}, d2 = {"Landroidx/camera/camera2/impl/DeferredUseCaseCameraRequestControl;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "LX8/a;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl;", "implProvider", "Lt/y0;", "threads", "<init>", "(LX8/a;Lt/y0;)V", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "", "values", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl$Type;", "type", "Landroidx/camera/core/impl/Config$OptionPriority;", "optionPriority", "LUa/Q;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/Map;Landroidx/camera/camera2/impl/UseCaseCameraRequestControl$Type;Landroidx/camera/core/impl/Config$OptionPriority;)LUa/Q;", "l", "", "keys", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;Landroidx/camera/camera2/impl/UseCaseCameraRequestControl$Type;)LUa/Q;", "", "isPrimary", "", "Landroidx/camera/core/UseCase;", "runningUseCases", Const.INTENT_KEY_PKGNAME, "(ZLjava/util/Collection;)LUa/Q;", "Landroidx/camera/core/impl/Config;", "config", "", "tags", "n", "(Landroidx/camera/core/impl/Config;Ljava/util/Map;)LUa/Q;", "Lw/N;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()LUa/Q;", "Lw/a;", "aeMode", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)LUa/Q;", "f", "Landroidx/camera/core/impl/l;", "captureSequence", "", "captureMode", "flashType", "flashMode", "Ljava/lang/Void;", "e", "(Ljava/util/List;III)Ljava/util/List;", "k", "(Le9/c;)Ljava/lang/Object;", "close", "()V", "p", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl;", Const.INTENT_KEY_APIKEY, "LX8/a;", "Lt/y0;", "c", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl;", "impl", "Ljava/util/concurrent/atomic/AtomicBoolean;", Const.INTENT_KEY_UMID, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isClosed", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeferredUseCaseCameraRequestControl implements UseCaseCameraRequestControl {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final X8.a<UseCaseCameraRequestControlImpl> implProvider;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public volatile UseCaseCameraRequestControlImpl impl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean isClosed;

    public DeferredUseCaseCameraRequestControl(X8.a<UseCaseCameraRequestControlImpl> implProvider, y0 threads) {
        p.i(implProvider, "implProvider");
        p.i(threads, "threads");
        this.implProvider = implProvider;
        this.threads = threads;
        this.isClosed = new AtomicBoolean(false);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<t> b(boolean isPrimary, Collection<? extends UseCase> runningUseCases) {
        p.i(runningUseCases, "runningUseCases");
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        return useCaseCameraRequestControlImpl != null ? useCaseCameraRequestControlImpl.b(isPrimary, runningUseCases) : C1060i.b(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$updateRepeatingRequestAsync$$inlined$runOnSequential$1(this, null, isPrimary, runningUseCases), 3, null);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public void close() {
        if (this.isClosed.getAndSet(true)) {
            return;
        }
        C1060i.d(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$close$$inlined$confineLaunch$1(null, this), 3, null);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public List<Q<Void>> e(List<l> captureSequence, int captureMode, int flashType, int flashMode) {
        p.i(captureSequence, "captureSequence");
        int size = captureSequence.size();
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl != null) {
            return useCaseCameraRequestControlImpl.e(captureSequence, captureMode, flashType, flashMode);
        }
        Q qB = C1060i.b(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$issueSingleCaptureAsync$$inlined$runOnSequentialList$1(this, null, captureSequence, captureMode, flashType, flashMode), 3, null);
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(C1060i.b(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$runOnSequentialList$2$1(qB, i10, null), 3, null));
        }
        return arrayList;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<Result3A> f() {
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        return useCaseCameraRequestControlImpl != null ? useCaseCameraRequestControlImpl.f() : C1060i.b(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$cancelFocusAndMeteringAsync$$inlined$runOnSequential$1(this, null), 3, null);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<Result3A> g() {
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        return useCaseCameraRequestControlImpl != null ? useCaseCameraRequestControlImpl.g() : C1060i.b(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$setTorchOnAsync$$inlined$runOnSequential$1(this, null), 3, null);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<t> h(Map<CaptureRequest.Key<?>, ? extends Object> values, UseCaseCameraRequestControl.Type type, Config.OptionPriority optionPriority) {
        p.i(values, "values");
        p.i(type, "type");
        p.i(optionPriority, "optionPriority");
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        return useCaseCameraRequestControlImpl != null ? useCaseCameraRequestControlImpl.h(values, type, optionPriority) : C1060i.b(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$setParametersAsync$$inlined$runOnSequential$1(this, null, values, type, optionPriority), 3, null);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<t> i(List<? extends CaptureRequest.Key<?>> keys, UseCaseCameraRequestControl.Type type) {
        p.i(keys, "keys");
        p.i(type, "type");
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        return useCaseCameraRequestControlImpl != null ? useCaseCameraRequestControlImpl.i(keys, type) : C1060i.b(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$removeParametersAsync$$inlined$runOnSequential$1(this, null, keys, type), 3, null);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<Result3A> j(int aeMode) {
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        return useCaseCameraRequestControlImpl != null ? useCaseCameraRequestControlImpl.j(aeMode) : C1060i.b(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$setTorchOffAsyncMtizInI$$inlined$runOnSequential$1(this, null, aeMode), 3, null);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Object k(InterfaceC4014c<? super Boolean> interfaceC4014c) {
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        return useCaseCameraRequestControlImpl != null ? useCaseCameraRequestControlImpl.k(interfaceC4014c) : C1056g.j(C1071n0.b(this.threads.getSequentialExecutor()), new DeferredUseCaseCameraRequestControl$awaitSurfaceSetup$$inlined$runOnSequentialSuspend$1(this, null), interfaceC4014c);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<t> l(Map<CaptureRequest.Key<?>, ? extends Object> values, UseCaseCameraRequestControl.Type type, Config.OptionPriority optionPriority) {
        p.i(values, "values");
        p.i(type, "type");
        p.i(optionPriority, "optionPriority");
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        return useCaseCameraRequestControlImpl != null ? useCaseCameraRequestControlImpl.l(values, type, optionPriority) : C1060i.b(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$submitParameters$$inlined$runOnSequential$1(this, null, values, type, optionPriority), 3, null);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<t> n(Config config, Map<String, ? extends Object> tags) {
        p.i(config, "config");
        p.i(tags, "tags");
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        return useCaseCameraRequestControlImpl != null ? useCaseCameraRequestControlImpl.n(config, tags) : C1060i.b(this.threads.getSequentialScope(), null, null, new DeferredUseCaseCameraRequestControl$updateCamera2ConfigAsync$$inlined$runOnSequential$1(this, null, config, tags), 3, null);
    }

    public final UseCaseCameraRequestControlImpl p() {
        if (this.isClosed.get()) {
            throw new CancellationException("UseCaseCameraRequestControl is closed");
        }
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.impl;
        if (useCaseCameraRequestControlImpl != null) {
            return useCaseCameraRequestControlImpl;
        }
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl2 = this.implProvider.get();
        if (this.isClosed.get()) {
            useCaseCameraRequestControlImpl2.close();
            throw new CancellationException("UseCaseCameraRequestControl closed during initialization");
        }
        this.impl = useCaseCameraRequestControlImpl2;
        p.f(useCaseCameraRequestControlImpl2);
        return useCaseCameraRequestControlImpl2;
    }
}
