package Ua;

import Za.C1196p;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u0002:\u0004@ABCB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001a\u0010\u0004J%\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\"\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u00132\n\u0010 \u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0013H\u0016¢\u0006\u0004\b$\u0010%J!\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020&2\n\u0010 \u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b*\u0010+J\u001d\u0010,\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\rH\u0004¢\u0006\u0004\b.\u0010\u0004R$\u00104\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00106\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b5\u00101R\u0014\u00108\u001a\u00020\u00138TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b7\u0010%R\u0013\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:098\u0002X\u0082\u0004R\u0013\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<098\u0002X\u0082\u0004R\u000b\u0010?\u001a\u00020>8\u0002X\u0082\u0004¨\u0006D"}, d2 = {"LUa/f0;", "LUa/g0;", "LUa/T;", "<init>", "()V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "task", "", "N1", "(Ljava/lang/Runnable;)Z", "K1", "()Ljava/lang/Runnable;", "LY8/t;", "M1", "J1", "LUa/f0$c;", "Y1", "(LUa/f0$c;)Z", "", "now", "delayedTask", "", "V1", "(JLUa/f0$c;)I", "S1", "shutdown", "timeMillis", "LUa/l;", "continuation", "v0", "(JLUa/l;)V", "block", "LUa/a0;", "W1", "(JLjava/lang/Runnable;)LUa/a0;", "D1", "()J", "Lkotlin/coroutines/d;", "context", "h1", "(Lkotlin/coroutines/d;Ljava/lang/Runnable;)V", "L1", "(Ljava/lang/Runnable;)V", "U1", "(JLUa/f0$c;)V", "T1", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "X1", "(Z)V", "isCompleted", "R1", "isEmpty", "y1", "nextTime", "LOa/e;", "", "_queue", "LUa/f0$d;", "_delayed", "LOa/a;", "_isCompleted", "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.f0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC1055f0 extends AbstractC1057g0 implements T {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6375e = AtomicReferenceFieldUpdater.newUpdater(AbstractC1055f0.class, Object.class, "_queue$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6376f = AtomicReferenceFieldUpdater.newUpdater(AbstractC1055f0.class, Object.class, "_delayed$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6377g = AtomicIntegerFieldUpdater.newUpdater(AbstractC1055f0.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile;
    private volatile /* synthetic */ Object _queue$volatile;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"LUa/f0$a;", "LUa/f0$c;", "", "nanoTime", "LUa/l;", "LY8/t;", "cont", "<init>", "(LUa/f0;JLUa/l;)V", "run", "()V", "", "toString", "()Ljava/lang/String;", "c", "LUa/l;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: Ua.f0$a */
    public final class a extends c {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC1066l<Y8.t> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j10, InterfaceC1066l<? super Y8.t> interfaceC1066l) {
            super(j10);
            this.cont = interfaceC1066l;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cont.t(AbstractC1055f0.this, Y8.t.f7040a);
        }

        @Override // Ua.AbstractC1055f0.c
        public String toString() {
            return super.toString() + this.cont;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u00060\u0004j\u0002`\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"LUa/f0$b;", "LUa/f0$c;", "", "nanoTime", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "<init>", "(JLjava/lang/Runnable;)V", "LY8/t;", "run", "()V", "", "toString", "()Ljava/lang/String;", "c", "Ljava/lang/Runnable;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: Ua.f0$b */
    public static final class b extends c {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final Runnable block;

        public b(long j10, Runnable runnable) {
            super(j10);
            this.block = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.block.run();
        }

        @Override // Ua.AbstractC1055f0.c
        public String toString() {
            return super.toString() + this.block;
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u00052\u00060\u0006j\u0002`\u0007B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010*\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R0\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010+2\f\u0010,\u001a\b\u0012\u0002\b\u0003\u0018\u00010+8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b \u0010-\"\u0004\b$\u0010.¨\u00060"}, d2 = {"LUa/f0$c;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "LUa/a0;", "LZa/O;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "", "nanoTime", "<init>", "(J)V", "other", "", "c", "(LUa/f0$c;)I", "now", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(J)Z", "LUa/f0$d;", "delayed", "LUa/f0;", "eventLoop", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(JLUa/f0$d;LUa/f0;)I", "LY8/t;", "dispose", "()V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "J", "_heap", "Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "I", "getIndex", "()I", "setIndex", "(I)V", "index", "LZa/N;", UxipConstants.f30680s, "()LZa/N;", "(LZa/N;)V", "heap", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: Ua.f0$c */
    public static abstract class c implements Runnable, Comparable<c>, InterfaceC1045a0, Za.O {
        private volatile Object _heap;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public long nanoTime;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public int index = -1;

        public c(long j10) {
            this.nanoTime = j10;
        }

        @Override // Za.O
        public Za.N<?> a() {
            Object obj = this._heap;
            if (obj instanceof Za.N) {
                return (Za.N) obj;
            }
            return null;
        }

        @Override // Za.O
        public void b(Za.N<?> n10) {
            if (this._heap == C1061i0.f6384a) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            this._heap = n10;
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(c other) {
            long j10 = this.nanoTime - other.nanoTime;
            if (j10 > 0) {
                return 1;
            }
            return j10 < 0 ? -1 : 0;
        }

        @Override // Ua.InterfaceC1045a0
        public final void dispose() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj == C1061i0.f6384a) {
                        return;
                    }
                    d dVar = obj instanceof d ? (d) obj : null;
                    if (dVar != null) {
                        dVar.h(this);
                    }
                    this._heap = C1061i0.f6384a;
                    Y8.t tVar = Y8.t.f7040a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // Za.O
        public int getIndex() {
            return this.index;
        }

        public final int i(long now, d delayed, AbstractC1055f0 eventLoop) {
            synchronized (this) {
                if (this._heap == C1061i0.f6384a) {
                    return 2;
                }
                synchronized (delayed) {
                    try {
                        c cVarB = delayed.b();
                        if (eventLoop.g()) {
                            return 1;
                        }
                        if (cVarB == null) {
                            delayed.timeNow = now;
                        } else {
                            long j10 = cVarB.nanoTime;
                            if (j10 - now < 0) {
                                now = j10;
                            }
                            if (now - delayed.timeNow > 0) {
                                delayed.timeNow = now;
                            }
                        }
                        long j11 = this.nanoTime;
                        long j12 = delayed.timeNow;
                        if (j11 - j12 < 0) {
                            this.nanoTime = j12;
                        }
                        delayed.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final boolean j(long now) {
            return now - this.nanoTime >= 0;
        }

        @Override // Za.O
        public void setIndex(int i10) {
            this.index = i10;
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"LUa/f0$d;", "LZa/N;", "LUa/f0$c;", "", "timeNow", "<init>", "(J)V", "c", "J", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: Ua.f0$d */
    public static final class d extends Za.N<c> {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public long timeNow;

        public d(long j10) {
            this.timeNow = j10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g() {
        return f6377g.get(this) == 1;
    }

    @Override // Ua.AbstractC1053e0
    public long D1() {
        if (E1()) {
            return 0L;
        }
        M1();
        Runnable runnableK1 = K1();
        if (runnableK1 == null) {
            return y1();
        }
        runnableK1.run();
        return 0L;
    }

    public final void J1() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6375e;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (f6375e.compareAndSet(this, null, C1061i0.f6385b)) {
                    return;
                }
            } else if (obj instanceof C1196p) {
                ((C1196p) obj).d();
                return;
            } else {
                if (obj == C1061i0.f6385b) {
                    return;
                }
                C1196p c1196p = new C1196p(8, true);
                kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type java.lang.Runnable");
                c1196p.a((Runnable) obj);
                if (f6375e.compareAndSet(this, obj, c1196p)) {
                    return;
                }
            }
        }
    }

    public final Runnable K1() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6375e;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof C1196p) {
                kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                C1196p c1196p = (C1196p) obj;
                Object objM = c1196p.m();
                if (objM != C1196p.f7751h) {
                    return (Runnable) objM;
                }
                f6375e.compareAndSet(this, obj, c1196p.l());
            } else {
                if (obj == C1061i0.f6385b) {
                    return null;
                }
                if (f6375e.compareAndSet(this, obj, null)) {
                    kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type java.lang.Runnable");
                    return (Runnable) obj;
                }
            }
        }
    }

    public void L1(Runnable task) {
        M1();
        if (N1(task)) {
            H1();
        } else {
            O.f6337h.L1(task);
        }
    }

    public final void M1() {
        c cVarI;
        d dVar = (d) f6376f.get(this);
        if (dVar == null || dVar.e()) {
            return;
        }
        C1046b.a();
        long jNanoTime = System.nanoTime();
        do {
            synchronized (dVar) {
                try {
                    c cVarB = dVar.b();
                    cVarI = null;
                    if (cVarB != null) {
                        c cVar = cVarB;
                        if (cVar.j(jNanoTime) ? N1(cVar) : false) {
                            cVarI = dVar.i(0);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (cVarI != null);
    }

    public final boolean N1(Runnable task) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6375e;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (g()) {
                return false;
            }
            if (obj == null) {
                if (f6375e.compareAndSet(this, null, task)) {
                    return true;
                }
            } else if (obj instanceof C1196p) {
                kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                C1196p c1196p = (C1196p) obj;
                int iA = c1196p.a(task);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    f6375e.compareAndSet(this, obj, c1196p.l());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == C1061i0.f6385b) {
                    return false;
                }
                C1196p c1196p2 = new C1196p(8, true);
                kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type java.lang.Runnable");
                c1196p2.a((Runnable) obj);
                c1196p2.a(task);
                if (f6375e.compareAndSet(this, obj, c1196p2)) {
                    return true;
                }
            }
        }
    }

    public boolean R1() {
        if (!C1()) {
            return false;
        }
        d dVar = (d) f6376f.get(this);
        if (dVar != null && !dVar.e()) {
            return false;
        }
        Object obj = f6375e.get(this);
        if (obj == null) {
            return true;
        }
        return obj instanceof C1196p ? ((C1196p) obj).j() : obj == C1061i0.f6385b;
    }

    public final void S1() {
        c cVarJ;
        C1046b.a();
        long jNanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) f6376f.get(this);
            if (dVar == null || (cVarJ = dVar.j()) == null) {
                return;
            } else {
                G1(jNanoTime, cVarJ);
            }
        }
    }

    public final void T1() {
        f6375e.set(this, null);
        f6376f.set(this, null);
    }

    public /* bridge */ InterfaceC1045a0 U(long j10, Runnable runnable, kotlin.coroutines.d dVar) {
        return super.U(j10, runnable, dVar);
    }

    public final void U1(long now, c delayedTask) {
        int iV1 = V1(now, delayedTask);
        if (iV1 == 0) {
            if (Y1(delayedTask)) {
                H1();
            }
        } else if (iV1 == 1) {
            G1(now, delayedTask);
        } else if (iV1 != 2) {
            throw new IllegalStateException("unexpected result");
        }
    }

    public final int V1(long now, c delayedTask) {
        if (g()) {
            return 1;
        }
        d dVar = (d) f6376f.get(this);
        if (dVar == null) {
            f6376f.compareAndSet(this, null, new d(now));
            Object obj = f6376f.get(this);
            kotlin.jvm.internal.p.f(obj);
            dVar = (d) obj;
        }
        return delayedTask.i(now, dVar, this);
    }

    public final InterfaceC1045a0 W1(long timeMillis, Runnable block) {
        long jC = C1061i0.c(timeMillis);
        if (jC >= 4611686018427387903L) {
            return C0.f6325a;
        }
        C1046b.a();
        long jNanoTime = System.nanoTime();
        b bVar = new b(jC + jNanoTime, block);
        U1(jNanoTime, bVar);
        return bVar;
    }

    public final void X1(boolean z10) {
        f6377g.set(this, z10 ? 1 : 0);
    }

    public final boolean Y1(c task) {
        d dVar = (d) f6376f.get(this);
        return (dVar != null ? dVar.f() : null) == task;
    }

    @Override // Ua.I
    public final void h1(kotlin.coroutines.d context, Runnable block) {
        L1(block);
    }

    @Override // Ua.AbstractC1053e0
    public void shutdown() {
        O0.f6339a.c();
        X1(true);
        J1();
        while (D1() <= 0) {
        }
        S1();
    }

    @Override // Ua.T
    public void v0(long timeMillis, InterfaceC1066l<? super Y8.t> continuation) {
        long jC = C1061i0.c(timeMillis);
        if (jC < 4611686018427387903L) {
            C1046b.a();
            long jNanoTime = System.nanoTime();
            a aVar = new a(jC + jNanoTime, continuation);
            U1(jNanoTime, aVar);
            C1072o.a(continuation, aVar);
        }
    }

    @Override // Ua.AbstractC1053e0
    public long y1() {
        c cVarF;
        if (super.y1() == 0) {
            return 0L;
        }
        Object obj = f6375e.get(this);
        if (obj != null) {
            if (!(obj instanceof C1196p)) {
                return obj == C1061i0.f6385b ? Long.MAX_VALUE : 0L;
            }
            if (!((C1196p) obj).j()) {
                return 0L;
            }
        }
        d dVar = (d) f6376f.get(this);
        if (dVar == null || (cVarF = dVar.f()) == null) {
            return Long.MAX_VALUE;
        }
        long j10 = cVarF.nanoTime;
        C1046b.a();
        return C5685n.g(j10 - System.nanoTime(), 0L);
    }
}
