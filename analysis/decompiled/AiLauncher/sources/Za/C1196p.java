package Za;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import io.ktor.http.ContentDisposition;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u0014*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002 \fB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00132\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J3\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00132\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u00132\u0006\u0010\u001d\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010 \u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u00132\u0006\u0010\u001d\u001a\u00020\u001aH\u0002¢\u0006\u0004\b \u0010\u001fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010!R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\"R\u0014\u0010#\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010!R\u0011\u0010%\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b$\u0010\nR\u0011\u0010(\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b&\u0010'R%\u0010*\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00130)8\u0002X\u0082\u0004R\u000b\u0010,\u001a\u00020+8\u0002X\u0082\u0004R\u0013\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00018\u0002X\u0082\u0004¨\u0006."}, d2 = {"LZa/p;", "", ExifInterface.LONGITUDE_EAST, "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", Const.INTENT_KEY_UMID, "()Z", "element", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;)I", "m", "()Ljava/lang/Object;", "l", "()LZa/p;", "index", "Lkotlinx/coroutines/internal/Core;", "e", "(ILjava/lang/Object;)LZa/p;", "oldHead", "newHead", "n", "(II)LZa/p;", "", "k", "()J", VoiceWakeupReceiver.EXTRA_STATE, "c", "(J)LZa/p;", Const.INTENT_KEY_PKGNAME, "I", "Z", "mask", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "isEmpty", Const.INTENT_KEY_BACKGROUND_COMMAND, "()I", ContentDisposition.Parameters.Size, "LOa/e;", "_next", "LOa/d;", "_state", "array", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Za.p, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1196p<E> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7749f = AtomicReferenceFieldUpdater.newUpdater(C1196p.class, Object.class, "_next$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f7750g = AtomicLongFieldUpdater.newUpdater(C1196p.class, "_state$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final C f7751h = new C("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int capacity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean singleConsumer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int mask;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f7755d;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000bJ\u0011\u0010\u000e\u001a\u00020\b*\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0011R\u0014\u0010\u001f\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u0011R\u0014\u0010\"\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u0011R\u0014\u0010#\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u0011¨\u0006$"}, d2 = {"LZa/p$a;", "", "<init>", "()V", "", "other", Const.INTENT_KEY_UMID, "(JJ)J", "", "newHead", Const.INTENT_KEY_PKGNAME, "(JI)J", "newTail", "c", Const.INTENT_KEY_APIKEY, "(J)I", "INITIAL_CAPACITY", "I", "CAPACITY_BITS", "MAX_CAPACITY_MASK", "HEAD_SHIFT", "HEAD_MASK", "J", "TAIL_SHIFT", "TAIL_MASK", "FROZEN_SHIFT", "FROZEN_MASK", "CLOSED_SHIFT", "CLOSED_MASK", "MIN_ADD_SPIN_CAPACITY", "LZa/C;", "REMOVE_FROZEN", "LZa/C;", "ADD_SUCCESS", "ADD_FROZEN", "ADD_CLOSED", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: Za.p$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final int a(long j10) {
            return (j10 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j10, int i10) {
            return d(j10, 1073741823L) | i10;
        }

        public final long c(long j10, int i10) {
            return d(j10, 1152921503533105152L) | (i10 << 30);
        }

        public final long d(long j10, long j11) {
            return j10 & (~j11);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"LZa/p$b;", "", "", "index", "<init>", "(I)V", Const.INTENT_KEY_APIKEY, "I", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: Za.p$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int index;

        public b(int i10) {
            this.index = i10;
        }
    }

    public C1196p(int i10, boolean z10) {
        this.capacity = i10;
        this.singleConsumer = z10;
        int i11 = i10 - 1;
        this.mask = i11;
        this.f7755d = new AtomicReferenceArray(i10);
        if (i11 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i10 & i11) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(E r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = i()
        L4:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L18
            Za.p$a r12 = Za.C1196p.INSTANCE
            int r12 = r12.a(r3)
            return r12
        L18:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r1 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r2 = 30
            long r5 = r5 >> r2
            int r9 = (int) r5
            int r10 = r12.mask
            int r2 = r9 + 2
            r2 = r2 & r10
            r5 = r1 & r10
            r6 = 1
            if (r2 != r5) goto L32
            return r6
        L32:
            boolean r2 = r12.singleConsumer
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 != 0) goto L53
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r12.getF7755d()
            r11 = r9 & r10
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L53
            int r2 = r12.capacity
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L52
            int r9 = r9 - r1
            r1 = r9 & r5
            int r2 = r2 >> 1
            if (r1 <= r2) goto L4
        L52:
            return r6
        L53:
            int r1 = r9 + 1
            r1 = r1 & r5
            r2 = r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = i()
            Za.p$a r5 = Za.C1196p.INSTANCE
            long r5 = r5.c(r3, r2)
            r2 = r12
            boolean r12 = r1.compareAndSet(r2, r3, r5)
            if (r12 == 0) goto L8d
            java.util.concurrent.atomic.AtomicReferenceArray r12 = r2.getF7755d()
            r0 = r9 & r10
            r12.set(r0, r13)
            r12 = r2
        L72:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = i()
            long r0 = r0.get(r12)
            r2 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r0 = r0 & r2
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 == 0) goto L8b
            Za.p r12 = r12.l()
            Za.p r12 = r12.e(r9, r13)
            if (r12 != 0) goto L72
        L8b:
            r12 = 0
            return r12
        L8d:
            r12 = r2
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: Za.C1196p.a(java.lang.Object):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final C1196p<E> b(long state) {
        C1196p<E> c1196p = new C1196p<>(this.capacity * 2, this.singleConsumer);
        int i10 = (int) (1073741823 & state);
        int i11 = (int) ((1152921503533105152L & state) >> 30);
        while (true) {
            int i12 = this.mask;
            if ((i10 & i12) == (i12 & i11)) {
                f7750g.set(c1196p, INSTANCE.d(state, 1152921504606846976L));
                return c1196p;
            }
            Object bVar = getF7755d().get(this.mask & i10);
            if (bVar == null) {
                bVar = new b(i10);
            }
            c1196p.getF7755d().set(c1196p.mask & i10, bVar);
            i10++;
        }
    }

    public final C1196p<E> c(long state) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7749f;
        while (true) {
            C1196p<E> c1196p = (C1196p) atomicReferenceFieldUpdater.get(this);
            if (c1196p != null) {
                return c1196p;
            }
            f7749f.compareAndSet(this, null, b(state));
        }
    }

    public final boolean d() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7750g;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j10) != 0) {
                return false;
            }
            C1196p<E> c1196p = this;
            if (atomicLongFieldUpdater.compareAndSet(c1196p, j10, 2305843009213693952L | j10)) {
                return true;
            }
            this = c1196p;
        }
    }

    public final C1196p<E> e(int index, E element) {
        Object obj = getF7755d().get(this.mask & index);
        if (!(obj instanceof b) || ((b) obj).index != index) {
            return null;
        }
        getF7755d().set(index & this.mask, element);
        return this;
    }

    /* renamed from: f, reason: from getter */
    public final /* synthetic */ AtomicReferenceArray getF7755d() {
        return this.f7755d;
    }

    public final int g() {
        long j10 = f7750g.get(this);
        return 1073741823 & (((int) ((j10 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j10)));
    }

    public final boolean j() {
        long j10 = f7750g.get(this);
        return ((int) (1073741823 & j10)) == ((int) ((j10 & 1152921503533105152L) >> 30));
    }

    public final long k() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7750g;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 1152921504606846976L) != 0) {
                return j10;
            }
            long j11 = 1152921504606846976L | j10;
            C1196p<E> c1196p = this;
            if (atomicLongFieldUpdater.compareAndSet(c1196p, j10, j11)) {
                return j11;
            }
            this = c1196p;
        }
    }

    public final C1196p<E> l() {
        return c(k());
    }

    public final Object m() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7750g;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j10) != 0) {
                return f7751h;
            }
            int i10 = (int) (1073741823 & j10);
            int i11 = this.mask;
            if ((((int) ((1152921503533105152L & j10) >> 30)) & i11) == (i11 & i10)) {
                return null;
            }
            Object obj = this.getF7755d().get(this.mask & i10);
            if (obj == null) {
                if (this.singleConsumer) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i12 = (i10 + 1) & 1073741823;
                C1196p<E> c1196p = this;
                if (f7750g.compareAndSet(c1196p, j10, INSTANCE.b(j10, i12))) {
                    c1196p.getF7755d().set(c1196p.mask & i10, null);
                    return obj;
                }
                if (c1196p.singleConsumer) {
                    C1196p<E> c1196pN = c1196p;
                    do {
                        c1196pN = c1196pN.n(i10, i12);
                    } while (c1196pN != null);
                    return obj;
                }
                this = c1196p;
            }
        }
    }

    public final C1196p<E> n(int oldHead, int newHead) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7750g;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (1073741823 & j10);
            if ((1152921504606846976L & j10) != 0) {
                return this.l();
            }
            C1196p<E> c1196p = this;
            if (f7750g.compareAndSet(c1196p, j10, INSTANCE.b(j10, newHead))) {
                c1196p.getF7755d().set(c1196p.mask & i10, null);
                return null;
            }
            this = c1196p;
        }
    }
}
