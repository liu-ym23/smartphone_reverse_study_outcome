package bb;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0012\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0006J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ!\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b!\u0010\"J+\u0010#\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000fH\u0002¢\u0006\u0004\b#\u0010\u0013J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0015H\u0002¢\u0006\u0004\b%\u0010&J\u0011\u0010'\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b'\u0010\u0006J\u0015\u0010(\u001a\u00020\u0017*\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b(\u0010)R\u001c\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010+R\u0014\u0010/\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010.R\u0013\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004028\u0002X\u0082\u0004R\u000b\u00105\u001a\u0002048\u0002X\u0082\u0004R\u000b\u00106\u001a\u0002048\u0002X\u0082\u0004R\u000b\u00107\u001a\u0002048\u0002X\u0082\u0004¨\u00068"}, d2 = {"Lbb/k;", "", "<init>", "()V", "Lbb/g;", "k", "()Lbb/g;", "task", "", "fair", Const.INTENT_KEY_APIKEY, "(Lbb/g;Z)Lbb/g;", "", "Lkotlinx/coroutines/scheduling/StealingMode;", "stealingMode", "Lkotlin/jvm/internal/Ref$ObjectRef;", "stolenTaskRef", "", "r", "(ILkotlin/jvm/internal/Ref$ObjectRef;)J", "l", "Lbb/c;", "globalQueue", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lbb/c;)V", Const.INTENT_KEY_PKGNAME, "(Lbb/g;)Lbb/g;", "onlyBlocking", "p", "(Z)Lbb/g;", "o", "index", "q", "(IZ)Lbb/g;", "s", "queue", "n", "(Lbb/c;)Z", "m", "c", "(Lbb/g;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()I", ContentDisposition.Parameters.Size, "e", "bufferSize", "LOa/e;", "lastScheduledTask", "LOa/c;", "producerIndex", "consumerIndex", "blockingTasksInBuffer", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: bb.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1476k {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f15389b = AtomicReferenceFieldUpdater.newUpdater(C1476k.class, Object.class, "lastScheduledTask$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f15390c = AtomicIntegerFieldUpdater.newUpdater(C1476k.class, "producerIndex$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f15391d = AtomicIntegerFieldUpdater.newUpdater(C1476k.class, "consumerIndex$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f15392e = AtomicIntegerFieldUpdater.newUpdater(C1476k.class, "blockingTasksInBuffer$volatile");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AtomicReferenceArray<AbstractRunnableC1472g> buffer = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    public final AbstractRunnableC1472g a(AbstractRunnableC1472g task, boolean fair) {
        if (fair) {
            return b(task);
        }
        AbstractRunnableC1472g abstractRunnableC1472g = (AbstractRunnableC1472g) f15389b.getAndSet(this, task);
        if (abstractRunnableC1472g == null) {
            return null;
        }
        return b(abstractRunnableC1472g);
    }

    public final AbstractRunnableC1472g b(AbstractRunnableC1472g task) {
        if (e() == 127) {
            return task;
        }
        if (task.taskContext) {
            f15392e.incrementAndGet(this);
        }
        int i10 = f15390c.get(this) & 127;
        while (this.buffer.get(i10) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(i10, task);
        f15390c.incrementAndGet(this);
        return null;
    }

    public final void c(AbstractRunnableC1472g abstractRunnableC1472g) {
        if (abstractRunnableC1472g == null || !abstractRunnableC1472g.taskContext) {
            return;
        }
        f15392e.decrementAndGet(this);
    }

    public final int e() {
        return f15390c.get(this) - f15391d.get(this);
    }

    public final int i() {
        Object obj = f15389b.get(this);
        int iE = e();
        return obj != null ? iE + 1 : iE;
    }

    public final void j(C1468c globalQueue) {
        AbstractRunnableC1472g abstractRunnableC1472g = (AbstractRunnableC1472g) f15389b.getAndSet(this, null);
        if (abstractRunnableC1472g != null) {
            globalQueue.a(abstractRunnableC1472g);
        }
        while (n(globalQueue)) {
        }
    }

    public final AbstractRunnableC1472g k() {
        AbstractRunnableC1472g abstractRunnableC1472g = (AbstractRunnableC1472g) f15389b.getAndSet(this, null);
        return abstractRunnableC1472g == null ? m() : abstractRunnableC1472g;
    }

    public final AbstractRunnableC1472g l() {
        return o(true);
    }

    public final AbstractRunnableC1472g m() {
        AbstractRunnableC1472g andSet;
        while (true) {
            int i10 = f15391d.get(this);
            if (i10 - f15390c.get(this) == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (f15391d.compareAndSet(this, i10, i10 + 1) && (andSet = this.buffer.getAndSet(i11, null)) != null) {
                c(andSet);
                return andSet;
            }
        }
    }

    public final boolean n(C1468c queue) {
        AbstractRunnableC1472g abstractRunnableC1472gM = m();
        if (abstractRunnableC1472gM == null) {
            return false;
        }
        queue.a(abstractRunnableC1472gM);
        return true;
    }

    public final AbstractRunnableC1472g o(boolean onlyBlocking) {
        AbstractRunnableC1472g abstractRunnableC1472g;
        do {
            abstractRunnableC1472g = (AbstractRunnableC1472g) f15389b.get(this);
            if (abstractRunnableC1472g == null || abstractRunnableC1472g.taskContext != onlyBlocking) {
                int i10 = f15391d.get(this);
                int i11 = f15390c.get(this);
                while (i10 != i11) {
                    if (onlyBlocking && f15392e.get(this) == 0) {
                        return null;
                    }
                    i11--;
                    AbstractRunnableC1472g abstractRunnableC1472gQ = q(i11, onlyBlocking);
                    if (abstractRunnableC1472gQ != null) {
                        return abstractRunnableC1472gQ;
                    }
                }
                return null;
            }
        } while (!f15389b.compareAndSet(this, abstractRunnableC1472g, null));
        return abstractRunnableC1472g;
    }

    public final AbstractRunnableC1472g p(boolean onlyBlocking) {
        int i10 = f15391d.get(this);
        int i11 = f15390c.get(this);
        while (i10 != i11) {
            if (onlyBlocking && f15392e.get(this) == 0) {
                return null;
            }
            int i12 = i10 + 1;
            AbstractRunnableC1472g abstractRunnableC1472gQ = q(i10, onlyBlocking);
            if (abstractRunnableC1472gQ != null) {
                return abstractRunnableC1472gQ;
            }
            i10 = i12;
        }
        return null;
    }

    public final AbstractRunnableC1472g q(int index, boolean onlyBlocking) {
        int i10 = index & 127;
        AbstractRunnableC1472g abstractRunnableC1472g = this.buffer.get(i10);
        if (abstractRunnableC1472g == null || abstractRunnableC1472g.taskContext != onlyBlocking || !this.buffer.compareAndSet(i10, abstractRunnableC1472g, null)) {
            return null;
        }
        if (onlyBlocking) {
            f15392e.decrementAndGet(this);
        }
        return abstractRunnableC1472g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long r(int stealingMode, Ref$ObjectRef<AbstractRunnableC1472g> stolenTaskRef) {
        T tP;
        if (stealingMode == 3) {
            tP = m();
        } else {
            tP = p(stealingMode == 1);
        }
        if (tP == 0) {
            return s(stealingMode, stolenTaskRef);
        }
        stolenTaskRef.f34820a = tP;
        return -1L;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, bb.g, java.lang.Object] */
    public final long s(int stealingMode, Ref$ObjectRef<AbstractRunnableC1472g> stolenTaskRef) {
        ?? r02;
        do {
            r02 = (AbstractRunnableC1472g) f15389b.get(this);
            if (r02 == 0) {
                return -2L;
            }
            if (((r02.taskContext ? 1 : 2) & stealingMode) == 0) {
                return -2L;
            }
            long jA = C1474i.f15387f.a() - r02.submissionTime;
            long j10 = C1474i.f15383b;
            if (jA < j10) {
                return j10 - jA;
            }
        } while (!f15389b.compareAndSet(this, r02, null));
        stolenTaskRef.f34820a = r02;
        return -1L;
    }
}
