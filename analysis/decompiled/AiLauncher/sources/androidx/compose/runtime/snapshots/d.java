package androidx.compose.runtime.snapshots;

import Y8.t;
import Z8.C1173v;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import androidx.compose.runtime.snapshots.c;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import i0.C4158a;
import j0.C4746d;
import j0.C4748f;
import j0.m;
import j0.p;
import j0.r;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0006\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u000f\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\u000e\u001a\u00020\r2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u00012\n\u0010\f\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\n\u0010\u0012\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a7\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0015*\u00020\u00102\u0006\u0010\u000e\u001a\u00028\u00002\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a#\u0010\u001b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0015*\u00020\u0010*\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0019\u0010 \u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b \u0010!\u001a-\u0010\"\u001a\u00028\u0000\"\b\b\u0000\u0010\u0015*\u00020\u0010*\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\bH\u0001¢\u0006\u0004\b\"\u0010#\u001a5\u0010%\u001a\u00028\u0000\"\b\b\u0000\u0010\u0015*\u00020\u0010*\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010$\u001a\u00028\u0000H\u0000¢\u0006\u0004\b%\u0010&\u001a-\u0010'\u001a\u00028\u0000\"\b\b\u0000\u0010\u0015*\u00020\u0010*\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010#\u001a%\u0010(\u001a\u00028\u0000\"\b\b\u0000\u0010\u0015*\u00020\u0010*\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b(\u0010\u001c\u001a\u001f\u0010*\u001a\u00020)2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b*\u0010+\u001a!\u0010,\u001a\u00028\u0000\"\b\b\u0000\u0010\u0015*\u00020\u00102\u0006\u0010\u000e\u001a\u00028\u0000H\u0001¢\u0006\u0004\b,\u0010-\" \u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100\"\u0018\u00104\u001a\u00060\u0000j\u0002`\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103\"\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\b058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107\"$\u0010A\u001a\u000609j\u0002`:8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b;\u0010<\u0012\u0004\b?\u0010@\u001a\u0004\b=\u0010>\"\u0016\u0010C\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010B\"\u001a\u0010D\u001a\u00060\u0000j\u0002`\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00103\"\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010G\"\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00190I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010J\"4\u0010P\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002090N\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020)0M0L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010O\"(\u0010Q\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020)0.0L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010O\"\u0014\u0010T\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010S\" \u0010X\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b%\u0010U\u0012\u0004\bW\u0010@\u001a\u0004\bV\u0010\n\"\u0016\u0010[\u001a\u00020Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010Z¨\u0006\\"}, d2 = {"", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", M5.b.AUTH_STATUS_INVALID, "", "p", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)I", "Landroidx/compose/runtime/snapshots/c;", "f", "()Landroidx/compose/runtime/snapshots/c;", "currentSnapshot", "candidateSnapshot", "", "r", "(JJLandroidx/compose/runtime/snapshots/SnapshotIdSet;)Z", "Lj0/r;", "data", "snapshot", "s", "(Lj0/r;JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)Z", ExifInterface.GPS_DIRECTION_TRUE, "id", "n", "(Lj0/r;JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)Lj0/r;", "Lj0/p;", VoiceWakeupReceiver.EXTRA_STATE, "o", "(Lj0/r;Lj0/p;)Lj0/r;", "", "m", "()Ljava/lang/Void;", "q", "(Lj0/p;)Lj0/r;", "t", "(Lj0/r;Lj0/p;Landroidx/compose/runtime/snapshots/c;)Lj0/r;", "candidate", "l", "(Lj0/r;Lj0/p;Landroidx/compose/runtime/snapshots/c;Lj0/r;)Lj0/r;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LY8/t;", "k", "(Landroidx/compose/runtime/snapshots/c;Lj0/p;)V", "e", "(Lj0/r;)Lj0/r;", "Lkotlin/Function1;", Const.INTENT_KEY_APIKEY, "Lp9/l;", "emptyLambda", Const.INTENT_KEY_PKGNAME, "J", "INVALID_SNAPSHOT", "Li0/a;", "c", "Li0/a;", "threadSnapshot", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", Const.INTENT_KEY_UMID, "Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/Object;", "getLock$annotations", "()V", "lock", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "openSnapshots", "nextSnapshotId", "Lj0/d;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lj0/d;", "pinningTable", "Lj0/m;", "Lj0/m;", "extraStateObjects", "", "Lkotlin/Function2;", "", "Ljava/util/List;", "applyObservers", "globalWriteObservers", "Landroidx/compose/runtime/snapshots/a;", "Landroidx/compose/runtime/snapshots/a;", "globalSnapshot", "Landroidx/compose/runtime/snapshots/c;", "getSnapshotInitializer", "getSnapshotInitializer$annotations", "snapshotInitializer", "Landroidx/compose/runtime/internal/AtomicInt;", "Landroidx/compose/runtime/internal/AtomicInt;", "pendingApplyObserverCount", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static final long f11788b = 0;

    /* renamed from: e, reason: collision with root package name */
    public static SnapshotIdSet f11791e;

    /* renamed from: f, reason: collision with root package name */
    public static long f11792f;

    /* renamed from: g, reason: collision with root package name */
    public static final C4746d f11793g;

    /* renamed from: h, reason: collision with root package name */
    public static final m<p> f11794h;

    /* renamed from: i, reason: collision with root package name */
    public static List<? extends p9.p<? super Set<? extends Object>, ? super c, t>> f11795i;

    /* renamed from: j, reason: collision with root package name */
    public static List<? extends InterfaceC5074l<Object, t>> f11796j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f11797k;

    /* renamed from: l, reason: collision with root package name */
    public static final c f11798l;

    /* renamed from: m, reason: collision with root package name */
    public static AtomicInt f11799m;

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC5074l<SnapshotIdSet, t> f11787a = new InterfaceC5074l() { // from class: j0.g
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return androidx.compose.runtime.snapshots.d.g((SnapshotIdSet) obj);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public static final C4158a<c> f11789c = new C4158a<>();

    /* renamed from: d, reason: collision with root package name */
    public static final Object f11790d = new Object();

    static {
        SnapshotIdSet.Companion aVar = SnapshotIdSet.INSTANCE;
        f11791e = aVar.a();
        long j10 = 1;
        f11792f = C4748f.c(1) + j10;
        f11793g = new C4746d();
        f11794h = new m<>();
        f11795i = C1173v.m();
        f11796j = C1173v.m();
        long j11 = f11792f;
        f11792f = j10 + j11;
        a aVar2 = new a(j11, aVar.a());
        f11791e = f11791e.l(aVar2.getSnapshotId());
        f11797k = aVar2;
        f11798l = aVar2;
        f11799m = new AtomicInt(0);
    }

    public static final <T extends r> T e(T t10) {
        T t11;
        c.Companion aVar = c.INSTANCE;
        c cVarA = aVar.a();
        T t12 = (T) n(t10, cVarA.getSnapshotId(), cVarA.getInvalid());
        if (t12 != null) {
            return t12;
        }
        synchronized (h()) {
            c cVarA2 = aVar.a();
            t11 = (T) n(t10, cVarA2.getSnapshotId(), cVarA2.getInvalid());
        }
        if (t11 != null) {
            return t11;
        }
        m();
        throw new KotlinNothingValueException();
    }

    public static final c f() {
        c cVarA = f11789c.a();
        return cVarA == null ? f11797k : cVarA;
    }

    public static final t g(SnapshotIdSet snapshotIdSet) {
        return t.f7040a;
    }

    public static final Object h() {
        return f11790d;
    }

    public static final <T extends r> T i(T t10, p pVar) {
        T t11 = (T) q(pVar);
        if (t11 != null) {
            t11.f(Long.MAX_VALUE);
            return t11;
        }
        T t12 = (T) t10.b(Long.MAX_VALUE);
        t12.e(pVar.getFirstStateRecord());
        kotlin.jvm.internal.p.g(t12, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        pVar.prependStateRecord(t12);
        kotlin.jvm.internal.p.g(t12, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return t12;
    }

    public static final <T extends r> T j(T t10, p pVar, c cVar) {
        T t11 = (T) i(t10, pVar);
        t11.a(t10);
        t11.f(cVar.getSnapshotId());
        return t11;
    }

    public static final void k(c cVar, p pVar) {
        cVar.h(cVar.getWriteCount() + 1);
        InterfaceC5074l<Object, t> interfaceC5074lF = cVar.f();
        if (interfaceC5074lF != null) {
            interfaceC5074lF.invoke(pVar);
        }
    }

    public static final <T extends r> T l(T t10, p pVar, c cVar, T t11) {
        T t12;
        if (cVar.c()) {
            cVar.g(pVar);
        }
        long jD = cVar.getSnapshotId();
        if (t11.getSnapshotId() == jD) {
            return t11;
        }
        synchronized (h()) {
            t12 = (T) i(t10, pVar);
        }
        t12.f(jD);
        if (t11.getSnapshotId() != C4748f.c(1)) {
            cVar.g(pVar);
        }
        return t12;
    }

    public static final Void m() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    public static final <T extends r> T n(T t10, long j10, SnapshotIdSet snapshotIdSet) {
        T t11 = null;
        while (t10 != null) {
            if (s(t10, j10, snapshotIdSet) && (t11 == null || kotlin.jvm.internal.p.l(t11.getSnapshotId(), t10.getSnapshotId()) < 0)) {
                t11 = t10;
            }
            t10 = (T) t10.getNext();
        }
        if (t11 != null) {
            return t11;
        }
        return null;
    }

    public static final <T extends r> T o(T t10, p pVar) {
        T t11;
        c.Companion aVar = c.INSTANCE;
        c cVarA = aVar.a();
        InterfaceC5074l<Object, t> interfaceC5074lB = cVarA.b();
        if (interfaceC5074lB != null) {
            interfaceC5074lB.invoke(pVar);
        }
        T t12 = (T) n(t10, cVarA.getSnapshotId(), cVarA.getInvalid());
        if (t12 != null) {
            return t12;
        }
        synchronized (h()) {
            c cVarA2 = aVar.a();
            r firstStateRecord = pVar.getFirstStateRecord();
            kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable");
            t11 = (T) n(firstStateRecord, cVarA2.getSnapshotId(), cVarA2.getInvalid());
            if (t11 == null) {
                m();
                throw new KotlinNothingValueException();
            }
        }
        return t11;
    }

    public static final int p(long j10, SnapshotIdSet snapshotIdSet) {
        int iA;
        long jK = snapshotIdSet.k(j10);
        synchronized (h()) {
            iA = f11793g.a(jK);
        }
        return iA;
    }

    public static final r q(p pVar) {
        long jD = f11793g.d(f11792f) - 1;
        SnapshotIdSet snapshotIdSetA = SnapshotIdSet.INSTANCE.a();
        r rVar = null;
        for (r firstStateRecord = pVar.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext()) {
            if (firstStateRecord.getSnapshotId() != f11788b) {
                if (s(firstStateRecord, jD, snapshotIdSetA)) {
                    if (rVar == null) {
                        rVar = firstStateRecord;
                    } else if (kotlin.jvm.internal.p.l(firstStateRecord.getSnapshotId(), rVar.getSnapshotId()) >= 0) {
                        return rVar;
                    }
                }
            }
            return firstStateRecord;
        }
        return null;
    }

    public static final boolean r(long j10, long j11, SnapshotIdSet snapshotIdSet) {
        return (j11 == f11788b || kotlin.jvm.internal.p.l(j11, j10) > 0 || snapshotIdSet.j(j11)) ? false : true;
    }

    public static final boolean s(r rVar, long j10, SnapshotIdSet snapshotIdSet) {
        return r(j10, rVar.getSnapshotId(), snapshotIdSet);
    }

    public static final <T extends r> T t(T t10, p pVar, c cVar) {
        T t11;
        if (cVar.c()) {
            cVar.g(pVar);
        }
        long jD = cVar.getSnapshotId();
        T t12 = (T) n(t10, jD, cVar.getInvalid());
        if (t12 == null) {
            m();
            throw new KotlinNothingValueException();
        }
        if (t12.getSnapshotId() == cVar.getSnapshotId()) {
            return t12;
        }
        synchronized (h()) {
            t11 = (T) n(pVar.getFirstStateRecord(), jD, cVar.getInvalid());
            if (t11 == null) {
                m();
                throw new KotlinNothingValueException();
            }
            if (t11.getSnapshotId() != jD) {
                t11 = (T) j(t11, pVar, cVar);
            }
        }
        kotlin.jvm.internal.p.g(t11, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.writableRecord");
        if (t12.getSnapshotId() != C4748f.c(1)) {
            cVar.g(pVar);
        }
        return t11;
    }
}
