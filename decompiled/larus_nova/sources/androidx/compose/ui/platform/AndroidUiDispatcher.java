package androidx.compose.ui.platform;

import android.os.Handler;
import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0017\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0015\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u0011H\u0000¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u0011H\u0000¢\u0006\u0002\b#J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006-"}, d2 = {"Landroidx/compose/ui/platform/AndroidUiDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "choreographer", "Landroid/view/Choreographer;", "handler", "Landroid/os/Handler;", "<init>", "(Landroid/view/Choreographer;Landroid/os/Handler;)V", "getChoreographer", "()Landroid/view/Choreographer;", "lock", "", "toRunTrampolined", "Lkotlin/collections/ArrayDeque;", "Ljava/lang/Runnable;", "toRunOnFrame", "", "Landroid/view/Choreographer$FrameCallback;", "spareToRunOnFrame", "scheduledTrampolineDispatch", "", "scheduledFrameDispatch", "dispatchCallback", "androidx/compose/ui/platform/AndroidUiDispatcher$dispatchCallback$1", "Landroidx/compose/ui/platform/AndroidUiDispatcher$dispatchCallback$1;", "nextTask", "performTrampolineDispatch", "", "performFrameDispatch", "frameTimeNanos", "", "postFrameCallback", "callback", "postFrameCallback$ui_release", "removeFrameCallback", "removeFrameCallback$ui_release", "frameClock", "Landroidx/compose/runtime/MonotonicFrameClock;", "getFrameClock", "()Landroidx/compose/runtime/MonotonicFrameClock;", "dispatch", PerfLog.PARAM_KEY_CONTEXT_ID, "Lkotlin/coroutines/CoroutineContext;", "block", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidUiDispatcher extends CoroutineDispatcher {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Lazy<CoroutineContext> Main$delegate = null;
    private static final ThreadLocal<CoroutineContext> currentThread = null;
    private final Choreographer choreographer;
    private final AndroidUiDispatcher$dispatchCallback$1 dispatchCallback;
    private final MonotonicFrameClock frameClock;
    private final Handler handler;
    private final Object lock;
    private boolean scheduledFrameDispatch;
    private boolean scheduledTrampolineDispatch;
    private List<Choreographer.FrameCallback> spareToRunOnFrame;
    private List<Choreographer.FrameCallback> toRunOnFrame;
    private final ArrayDeque<Runnable> toRunTrampolined;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/platform/AndroidUiDispatcher$Companion;", "", "<init>", "()V", "Main", "Lkotlin/coroutines/CoroutineContext;", "getMain", "()Lkotlin/coroutines/CoroutineContext;", "Main$delegate", "Lkotlin/Lazy;", "currentThread", "Ljava/lang/ThreadLocal;", "CurrentThread", "getCurrentThread", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CoroutineContext getCurrentThread() {
            if (AndroidUiDispatcher_androidKt.access$isMainThread() == true) goto L7;
            CoroutineContext r100 = (CoroutineContext) AndroidUiDispatcher.access$getCurrentThread$cp().get();
            if (r100 == null) goto L9;
            return r100;
        L9:
            throw new IllegalStateException("no AndroidUiDispatcher for this thread".toString());
        L7:
            return getMain();
        }

        public final CoroutineContext getMain() {
            return (CoroutineContext) AndroidUiDispatcher.access$getMain$delegate$cp().getValue();
        }
    }

    public /* synthetic */ AndroidUiDispatcher(Choreographer r100, Handler r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        Main$delegate = LazyKt.lazy(AndroidUiDispatcher$Companion$Main$2.INSTANCE);
        currentThread = new AndroidUiDispatcher$Companion$currentThread$1();
    }

    private final Runnable nextTask() {
        Object r100 = this.lock;
        monitor-enter(r100);
        Runnable r101 = this.toRunTrampolined.removeFirstOrNull();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    private final void performTrampolineDispatch() {
    L2:
        Runnable r100 = nextTask();
    L3:
        if (r100 == null) goto L5;
        r100.run();
        r100 = nextTask();
        goto L3
    L5:
        Object r101 = this.lock;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (this.toRunTrampolined.isEmpty() == false) goto L11;
        boolean r102 = false;
        this.scheduledTrampolineDispatch = false;     // Catch: Throwable -> L15
    L12:
        monitor-exit(r101);
        if (r102 == true) goto L2;
        return;
    L11:
        r102 = true;
        goto L12
    }

    public static final /* synthetic */ ThreadLocal access$getCurrentThread$cp() {
        return currentThread;
    }

    public static final /* synthetic */ Lazy access$getMain$delegate$cp() {
        return Main$delegate;
    }

    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    public final MonotonicFrameClock getFrameClock() {
        return this.frameClock;
    }

    public static final /* synthetic */ Handler access$getHandler$p(AndroidUiDispatcher r100) {
        return r100.handler;
    }

    public static final /* synthetic */ Object access$getLock$p(AndroidUiDispatcher r100) {
        return r100.lock;
    }

    public static final /* synthetic */ List access$getToRunOnFrame$p(AndroidUiDispatcher r100) {
        return r100.toRunOnFrame;
    }

    public static final /* synthetic */ void access$performTrampolineDispatch(AndroidUiDispatcher r100) {
        r100.performTrampolineDispatch();
    }

    private final void performFrameDispatch(long r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.scheduledFrameDispatch == true) goto L8;
        monitor-exit(r101);
        return;
    L8:
        int r102 = 0;
        this.scheduledFrameDispatch = false;     // Catch: Throwable -> L16
        List<Choreographer.FrameCallback> r103 = this.toRunOnFrame;     // Catch: Throwable -> L16
        this.toRunOnFrame = this.spareToRunOnFrame;     // Catch: Throwable -> L16
        this.spareToRunOnFrame = r103;     // Catch: Throwable -> L16
        monitor-exit(r101);
        int r104 = r103.size();
    L12:
        if (r102 >= r104) goto L14;
        ((Choreographer.FrameCallback) ListProtector.get(r103, r102)).doFrame(r100);
        r102 = r102 + 1;
        goto L12
    L14:
        r103.clear();
    }

    public final void postFrameCallback$ui_release(Choreographer.FrameCallback r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        this.toRunOnFrame.add(r100);     // Catch: Throwable -> L10
        if (this.scheduledFrameDispatch == true) goto L7;
        this.scheduledFrameDispatch = true;     // Catch: Throwable -> L10
        this.choreographer.postFrameCallback(this.dispatchCallback);     // Catch: Throwable -> L10
    L7:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r101);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void removeFrameCallback$ui_release(Choreographer.FrameCallback r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        this.toRunOnFrame.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private AndroidUiDispatcher(Choreographer r100, Handler r101) {
        this.choreographer = r100;
        this.handler = r101;
        this.lock = new Object();
        this.toRunTrampolined = new ArrayDeque();
        this.toRunOnFrame = new ArrayList();
        this.spareToRunOnFrame = new ArrayList();
        this.dispatchCallback = new AndroidUiDispatcher$dispatchCallback$1(this);
        this.frameClock = new AndroidUiFrameClock(r100, this);
    }

    public static final /* synthetic */ void access$performFrameDispatch(AndroidUiDispatcher r100, long r101) {
        r100.performFrameDispatch(r101);
    }

    public static final /* synthetic */ void access$setScheduledFrameDispatch$p(AndroidUiDispatcher r100, boolean r101) {
        r100.scheduledFrameDispatch = r101;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext r100, Runnable r101) {
        Object r102 = this.lock;
        monitor-enter(r102);
        this.toRunTrampolined.addLast(r101);     // Catch: Throwable -> L12
        if (this.scheduledTrampolineDispatch == true) goto L9;
        this.scheduledTrampolineDispatch = true;     // Catch: Throwable -> L12
        this.handler.post(this.dispatchCallback);     // Catch: Throwable -> L12
        if (this.scheduledFrameDispatch == true) goto L9;
        this.scheduledFrameDispatch = true;     // Catch: Throwable -> L12
        this.choreographer.postFrameCallback(this.dispatchCallback);     // Catch: Throwable -> L12
    L9:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r102);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
