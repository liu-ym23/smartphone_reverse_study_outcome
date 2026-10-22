package Za;

import Ua.InterfaceC1045a0;
import Ua.InterfaceC1066l;
import Ua.T;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u00016B!\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0017¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ,\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\r\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH\u0002¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0003\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010.\u001a\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00103\u001a\u00060/j\u0002`08\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u000b\u00105\u001a\u0002048\u0002X\u0082\u0004¨\u00067"}, d2 = {"LZa/k;", "LUa/I;", "LUa/T;", "dispatcher", "", "parallelism", "", "name", "<init>", "(LUa/I;ILjava/lang/String;)V", "s1", "(ILjava/lang/String;)LUa/I;", "Lkotlin/coroutines/d;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "LY8/t;", "h1", "(Lkotlin/coroutines/d;Ljava/lang/Runnable;)V", "k1", "toString", "()Ljava/lang/String;", "", "timeMillis", "LUa/l;", "continuation", "v0", "(JLUa/l;)V", "LUa/a0;", "U", "(JLjava/lang/Runnable;Lkotlin/coroutines/d;)LUa/a0;", "", "A1", "()Z", "z1", "()Ljava/lang/Runnable;", "c", "LUa/I;", Const.INTENT_KEY_UMID, "I", "e", "Ljava/lang/String;", "LZa/o;", "f", "LZa/o;", "queue", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/lang/Object;", "workerAllocationLock", "LOa/c;", "runningWorkers", Const.INTENT_KEY_APIKEY, "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Za.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1191k extends Ua.I implements T {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f7737h = AtomicIntegerFieldUpdater.newUpdater(C1191k.class, "runningWorkers$volatile");

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ T f7738b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Ua.I dispatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int parallelism;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final C1195o<Runnable> queue;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Object workerAllocationLock;
    private volatile /* synthetic */ int runningWorkers$volatile;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00060\u0001j\u0002`\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"LZa/k$a;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "currentTask", "<init>", "(LZa/k;Ljava/lang/Runnable;)V", "LY8/t;", "run", "()V", Const.INTENT_KEY_APIKEY, "Ljava/lang/Runnable;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: Za.k$a */
    public final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public Runnable currentTask;

        public a(Runnable runnable) {
            this.currentTask = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = 0;
            while (true) {
                try {
                    this.currentTask.run();
                } catch (Throwable th) {
                    Ua.K.a(EmptyCoroutineContext.f34779a, th);
                }
                Runnable runnableZ1 = C1191k.this.z1();
                if (runnableZ1 == null) {
                    return;
                }
                try {
                    this.currentTask = runnableZ1;
                    i10++;
                    if (i10 >= 16 && C1189i.d(C1191k.this.dispatcher, C1191k.this)) {
                        C1189i.c(C1191k.this.dispatcher, C1191k.this, this);
                        return;
                    }
                } catch (Throwable th2) {
                    Object obj = C1191k.this.workerAllocationLock;
                    C1191k c1191k = C1191k.this;
                    synchronized (obj) {
                        C1191k.y1().decrementAndGet(c1191k);
                        throw th2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1191k(Ua.I i10, int i11, String str) {
        T t10 = i10 instanceof T ? (T) i10 : null;
        this.f7738b = t10 == null ? Ua.P.a() : t10;
        this.dispatcher = i10;
        this.parallelism = i11;
        this.name = str;
        this.queue = new C1195o<>(false);
        this.workerAllocationLock = new Object();
    }

    public static final /* synthetic */ AtomicIntegerFieldUpdater y1() {
        return f7737h;
    }

    public final boolean A1() {
        synchronized (this.workerAllocationLock) {
            if (f7737h.get(this) >= this.parallelism) {
                return false;
            }
            f7737h.incrementAndGet(this);
            return true;
        }
    }

    @Override // Ua.T
    public InterfaceC1045a0 U(long timeMillis, Runnable block, kotlin.coroutines.d context) {
        return this.f7738b.U(timeMillis, block, context);
    }

    @Override // Ua.I
    public void h1(kotlin.coroutines.d context, Runnable block) {
        Runnable runnableZ1;
        this.queue.a(block);
        if (f7737h.get(this) >= this.parallelism || !A1() || (runnableZ1 = z1()) == null) {
            return;
        }
        try {
            C1189i.c(this.dispatcher, this, new a(runnableZ1));
        } catch (Throwable th) {
            f7737h.decrementAndGet(this);
            throw th;
        }
    }

    @Override // Ua.I
    public void k1(kotlin.coroutines.d context, Runnable block) {
        Runnable runnableZ1;
        this.queue.a(block);
        if (f7737h.get(this) >= this.parallelism || !A1() || (runnableZ1 = z1()) == null) {
            return;
        }
        try {
            this.dispatcher.k1(this, new a(runnableZ1));
        } catch (Throwable th) {
            f7737h.decrementAndGet(this);
            throw th;
        }
    }

    @Override // Ua.I
    public Ua.I s1(int parallelism, String name) {
        C1192l.a(parallelism);
        return parallelism >= this.parallelism ? C1192l.b(this, name) : super.s1(parallelism, name);
    }

    @Override // Ua.I
    /* renamed from: toString */
    public String getName() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        return this.dispatcher + ".limitedParallelism(" + this.parallelism + ')';
    }

    @Override // Ua.T
    public void v0(long timeMillis, InterfaceC1066l<? super Y8.t> continuation) {
        this.f7738b.v0(timeMillis, continuation);
    }

    public final Runnable z1() {
        while (true) {
            Runnable runnableE = this.queue.e();
            if (runnableE != null) {
                return runnableE;
            }
            synchronized (this.workerAllocationLock) {
                f7737h.decrementAndGet(this);
                if (this.queue.c() == 0) {
                    return null;
                }
                f7737h.incrementAndGet(this);
            }
        }
    }
}
