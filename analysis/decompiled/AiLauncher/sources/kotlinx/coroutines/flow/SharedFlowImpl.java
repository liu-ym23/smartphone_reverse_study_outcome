package kotlinx.coroutines.flow;

import Ua.C1072o;
import Ua.InterfaceC1045a0;
import Xa.j;
import Xa.q;
import Y8.t;
import Ya.c;
import Ya.h;
import Za.C;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.f;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.channels.BufferOverflow;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u0001BB\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0001\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ9\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001c2\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00028\u0000H\u0082@¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J/\u0010,\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0015H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0012H\u0002¢\u0006\u0004\b.\u0010\u0014J\u0019\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u0003H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u0003H\u0002¢\u0006\u0004\b2\u00103J\u0019\u00105\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020\u0015H\u0002¢\u0006\u0004\b5\u00106J\u0018\u00107\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b7\u00108J3\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001090\u001c2\u0014\u0010:\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001090\u001cH\u0002¢\u0006\u0004\b;\u0010<J\u001e\u0010@\u001a\u00020?2\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000=H\u0096@¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\bB\u0010\u0011J\u0018\u0010C\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00028\u0000H\u0096@¢\u0006\u0004\bC\u0010#J\u000f\u0010D\u001a\u00020\u0015H\u0000¢\u0006\u0004\bD\u0010EJ%\u0010G\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001090\u001c2\u0006\u0010F\u001a\u00020\u0015H\u0000¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0003H\u0014¢\u0006\u0004\bI\u0010JJ\u001f\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001c2\u0006\u0010K\u001a\u00020\u0007H\u0014¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\u0012H\u0016¢\u0006\u0004\bN\u0010\u0014J-\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000R2\u0006\u0010P\u001a\u00020O2\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\bS\u0010TR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010\u001aR\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010\u001aR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR \u0010Z\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010;R\u0016\u0010^\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010;R\u0016\u0010`\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010\u001aR\u0016\u0010b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010\u001aR\u0014\u0010d\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bc\u0010ER\u0014\u0010g\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\be\u0010fR\u0014\u0010i\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010fR\u0014\u0010k\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010ER\u0014\u0010m\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bl\u0010ER\u001a\u0010q\u001a\u00028\u00008DX\u0084\u0004¢\u0006\f\u0012\u0004\bp\u0010\u0014\u001a\u0004\bn\u0010o¨\u0006r"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "LYa/a;", "LXa/q;", "LXa/j;", "", "LYa/h;", "", "replay", "bufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", UxipConstants.f30680s, "", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/Object;)Z", "LY8/t;", "F", "()V", "", "newHead", "C", "(J)V", "item", "I", "(Ljava/lang/Object;)V", "", "curBuffer", "curSize", "newSize", "R", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "H", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/SharedFlowImpl$a;", "emitter", "z", "(Lkotlinx/coroutines/flow/SharedFlowImpl$a;)V", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", ExifInterface.LONGITUDE_WEST, "(JJJJ)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "slot", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(LXa/q;)Ljava/lang/Object;", "U", "(LXa/q;)J", "index", "N", "(J)Ljava/lang/Object;", "y", "(LXa/q;Le9/c;)Ljava/lang/Object;", "Le9/c;", "resumesIn", "J", "([Le9/c;)[Le9/c;", "LXa/c;", "collector", "", "collect", "(LXa/c;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "emit", "Y", "()J", "oldIndex", "X", "(J)[Le9/c;", "D", "()LXa/q;", ContentDisposition.Parameters.Size, ExifInterface.LONGITUDE_EAST, "(I)[LXa/q;", "e", "Lkotlin/coroutines/d;", "context", "capacity", "LXa/b;", Const.INTENT_KEY_PKGNAME, "(Lkotlin/coroutines/d;ILkotlinx/coroutines/channels/BufferOverflow;)LXa/b;", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lkotlinx/coroutines/channels/BufferOverflow;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "[Ljava/lang/Object;", "buffer", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "replayIndex", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "minCollectorIndex", "k", "bufferSize", "l", "queueSize", "L", "head", "P", "()I", "replaySize", "Q", "totalSize", "K", "bufferEndIndex", "O", "queueEndIndex", "M", "()Ljava/lang/Object;", "getLastReplayedLocked$annotations", "lastReplayedLocked", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SharedFlowImpl<T> extends Ya.a<q> implements j<T>, Xa.b, h<T> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int replay;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final int bufferCapacity;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final BufferOverflow onBufferOverflow;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public Object[] buffer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public long replayIndex;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public long minCollectorIndex;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public int bufferSize;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public int queueSize;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$a;", "LUa/a0;", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "flow", "", "index", "", UxipConstants.f30680s, "Le9/c;", "LY8/t;", "cont", "<init>", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Le9/c;)V", "dispose", "()V", Const.INTENT_KEY_APIKEY, "Lkotlinx/coroutines/flow/SharedFlowImpl;", Const.INTENT_KEY_PKGNAME, "J", "c", "Ljava/lang/Object;", Const.INTENT_KEY_UMID, "Le9/c;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements InterfaceC1045a0 {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final SharedFlowImpl<?> flow;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public long index;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final Object value;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC4014c<t> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public a(SharedFlowImpl<?> sharedFlowImpl, long j10, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
            this.flow = sharedFlowImpl;
            this.index = j10;
            this.value = obj;
            this.cont = interfaceC4014c;
        }

        @Override // Ua.InterfaceC1045a0
        public void dispose() {
            this.flow.z(this);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36621a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f36621a = iArr;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {387, 394, 397}, m = "collect$suspendImpl", v = 1)
    /* renamed from: kotlinx.coroutines.flow.SharedFlowImpl$collect$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f36622a;

        /* renamed from: b, reason: collision with root package name */
        public Object f36623b;

        /* renamed from: c, reason: collision with root package name */
        public Object f36624c;

        /* renamed from: d, reason: collision with root package name */
        public Object f36625d;

        /* renamed from: e, reason: collision with root package name */
        public Object f36626e;

        /* renamed from: f, reason: collision with root package name */
        public /* synthetic */ Object f36627f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ SharedFlowImpl<T> f36628g;

        /* renamed from: h, reason: collision with root package name */
        public int f36629h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SharedFlowImpl<T> sharedFlowImpl, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
            this.f36628g = sharedFlowImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f36627f = obj;
            this.f36629h |= Integer.MIN_VALUE;
            return SharedFlowImpl.B(this.f36628g, null, this);
        }
    }

    public SharedFlowImpl(int i10, int i11, BufferOverflow bufferOverflow) {
        this.replay = i10;
        this.bufferCapacity = i11;
        this.onBufferOverflow = bufferOverflow;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0092, code lost:
    
        if (((kotlinx.coroutines.flow.SubscribedFlowCollector) r9).b(r0) == r1) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ <T> java.lang.Object B(kotlinx.coroutines.flow.SharedFlowImpl<T> r8, Xa.c<? super T> r9, e9.InterfaceC4014c<?> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.B(kotlinx.coroutines.flow.SharedFlowImpl, Xa.c, e9.c):java.lang.Object");
    }

    public static /* synthetic */ <T> Object G(SharedFlowImpl<T> sharedFlowImpl, T t10, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objH;
        return (!sharedFlowImpl.a(t10) && (objH = sharedFlowImpl.H(t10, interfaceC4014c)) == C4063a.g()) ? objH : t.f7040a;
    }

    public final void A() {
        if (this.bufferCapacity != 0 || this.queueSize > 1) {
            Object[] objArr = this.buffer;
            p.f(objArr);
            while (this.queueSize > 0 && Xa.p.f(objArr, (L() + Q()) - 1) == Xa.p.f6900a) {
                this.queueSize--;
                Xa.p.g(objArr, L() + Q(), null);
            }
        }
    }

    public final void C(long newHead) {
        c[] cVarArr;
        if (this.nCollectors != 0 && (cVarArr = this.slots) != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    q qVar = (q) cVar;
                    long j10 = qVar.index;
                    if (0 <= j10 && j10 < newHead) {
                        qVar.index = newHead;
                    }
                }
            }
        }
        this.minCollectorIndex = newHead;
    }

    @Override // Ya.a
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public q j() {
        return new q();
    }

    @Override // Ya.a
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public q[] k(int size) {
        return new q[size];
    }

    public final void F() {
        Object[] objArr = this.buffer;
        p.f(objArr);
        Xa.p.g(objArr, L(), null);
        this.bufferSize--;
        long jL = L() + 1;
        if (this.replayIndex < jL) {
            this.replayIndex = jL;
        }
        if (this.minCollectorIndex < jL) {
            C(jL);
        }
    }

    public final Object H(T t10, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        SharedFlowImpl<T> sharedFlowImpl;
        Throwable th;
        InterfaceC4014c<t>[] interfaceC4014cArrJ;
        a aVar;
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        InterfaceC4014c<t>[] interfaceC4014cArrJ2 = Ya.b.f7045a;
        synchronized (this) {
            try {
                if (S(t10)) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        cVar.resumeWith(Result.b(t.f7040a));
                        interfaceC4014cArrJ = J(interfaceC4014cArrJ2);
                        aVar = null;
                        sharedFlowImpl = this;
                    } catch (Throwable th2) {
                        th = th2;
                        sharedFlowImpl = this;
                        throw th;
                    }
                } else {
                    sharedFlowImpl = this;
                    try {
                        aVar = new a(sharedFlowImpl, L() + Q(), t10, cVar);
                        sharedFlowImpl.I(aVar);
                        sharedFlowImpl.queueSize++;
                        if (sharedFlowImpl.bufferCapacity == 0) {
                            interfaceC4014cArrJ2 = sharedFlowImpl.J(interfaceC4014cArrJ2);
                        }
                        interfaceC4014cArrJ = interfaceC4014cArrJ2;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                if (aVar != null) {
                    C1072o.a(cVar, aVar);
                }
                for (InterfaceC4014c<t> interfaceC4014c2 : interfaceC4014cArrJ) {
                    if (interfaceC4014c2 != null) {
                        Result.Companion companion2 = Result.INSTANCE;
                        interfaceC4014c2.resumeWith(Result.b(t.f7040a));
                    }
                }
                Object objC = cVar.C();
                if (objC == C4063a.g()) {
                    f.c(interfaceC4014c);
                }
                return objC == C4063a.g() ? objC : t.f7040a;
            } catch (Throwable th4) {
                th = th4;
                sharedFlowImpl = this;
            }
        }
    }

    public final void I(Object item) {
        int iQ = Q();
        Object[] objArrR = this.buffer;
        if (objArrR == null) {
            objArrR = R(null, 0, 2);
        } else if (iQ >= objArrR.length) {
            objArrR = R(objArrR, iQ, objArrR.length * 2);
        }
        Xa.p.g(objArrR, L() + iQ, item);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object, java.lang.Object[]] */
    public final InterfaceC4014c<t>[] J(InterfaceC4014c<t>[] resumesIn) {
        c[] cVarArr;
        q qVar;
        InterfaceC4014c<? super t> interfaceC4014c;
        int length = resumesIn.length;
        if (this.nCollectors != 0 && (cVarArr = this.slots) != null) {
            int length2 = cVarArr.length;
            int i10 = 0;
            resumesIn = resumesIn;
            while (i10 < length2) {
                c cVar = cVarArr[i10];
                if (cVar != null && (interfaceC4014c = (qVar = (q) cVar).cont) != null && U(qVar) >= 0) {
                    int length3 = resumesIn.length;
                    resumesIn = resumesIn;
                    if (length >= length3) {
                        ?? CopyOf = Arrays.copyOf(resumesIn, Math.max(2, resumesIn.length * 2));
                        p.h(CopyOf, "copyOf(...)");
                        resumesIn = CopyOf;
                    }
                    resumesIn[length] = interfaceC4014c;
                    qVar.cont = null;
                    length++;
                }
                i10++;
                resumesIn = resumesIn;
            }
        }
        return resumesIn;
    }

    public final long K() {
        return L() + this.bufferSize;
    }

    public final long L() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    public final T M() {
        Object[] objArr = this.buffer;
        p.f(objArr);
        return (T) Xa.p.f(objArr, (this.replayIndex + P()) - 1);
    }

    public final Object N(long index) {
        Object[] objArr = this.buffer;
        p.f(objArr);
        Object objF = Xa.p.f(objArr, index);
        return objF instanceof a ? ((a) objF).value : objF;
    }

    public final long O() {
        return L() + this.bufferSize + this.queueSize;
    }

    public final int P() {
        return (int) ((L() + this.bufferSize) - this.replayIndex);
    }

    public final int Q() {
        return this.bufferSize + this.queueSize;
    }

    public final Object[] R(Object[] curBuffer, int curSize, int newSize) {
        if (newSize <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr = new Object[newSize];
        this.buffer = objArr;
        if (curBuffer != null) {
            long jL = L();
            for (int i10 = 0; i10 < curSize; i10++) {
                long j10 = i10 + jL;
                Xa.p.g(objArr, j10, Xa.p.f(curBuffer, j10));
            }
        }
        return objArr;
    }

    public final boolean S(T value) {
        if (getNCollectors() == 0) {
            return T(value);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int i10 = b.f36621a[this.onBufferOverflow.ordinal()];
            if (i10 == 1) {
                return false;
            }
            if (i10 == 2) {
                return true;
            }
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        I(value);
        int i11 = this.bufferSize + 1;
        this.bufferSize = i11;
        if (i11 > this.bufferCapacity) {
            F();
        }
        if (P() > this.replay) {
            W(this.replayIndex + 1, this.minCollectorIndex, K(), O());
        }
        return true;
    }

    public final boolean T(T value) {
        if (this.replay == 0) {
            return true;
        }
        I(value);
        int i10 = this.bufferSize + 1;
        this.bufferSize = i10;
        if (i10 > this.replay) {
            F();
        }
        this.minCollectorIndex = L() + this.bufferSize;
        return true;
    }

    public final long U(q slot) {
        long j10 = slot.index;
        if (j10 >= K() && (this.bufferCapacity > 0 || j10 > L() || this.queueSize == 0)) {
            return -1L;
        }
        return j10;
    }

    public final Object V(q slot) {
        Object obj;
        InterfaceC4014c<t>[] interfaceC4014cArrX = Ya.b.f7045a;
        synchronized (this) {
            try {
                long jU = U(slot);
                if (jU < 0) {
                    obj = Xa.p.f6900a;
                } else {
                    long j10 = slot.index;
                    Object objN = N(jU);
                    slot.index = jU + 1;
                    interfaceC4014cArrX = X(j10);
                    obj = objN;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (InterfaceC4014c<t> interfaceC4014c : interfaceC4014cArrX) {
            if (interfaceC4014c != null) {
                Result.Companion companion = Result.INSTANCE;
                interfaceC4014c.resumeWith(Result.b(t.f7040a));
            }
        }
        return obj;
    }

    public final void W(long newReplayIndex, long newMinCollectorIndex, long newBufferEndIndex, long newQueueEndIndex) {
        long jMin = Math.min(newMinCollectorIndex, newReplayIndex);
        for (long jL = L(); jL < jMin; jL++) {
            Object[] objArr = this.buffer;
            p.f(objArr);
            Xa.p.g(objArr, jL, null);
        }
        this.replayIndex = newReplayIndex;
        this.minCollectorIndex = newMinCollectorIndex;
        this.bufferSize = (int) (newBufferEndIndex - jMin);
        this.queueSize = (int) (newQueueEndIndex - newBufferEndIndex);
    }

    public final InterfaceC4014c<t>[] X(long oldIndex) {
        long j10;
        long j11;
        InterfaceC4014c<t>[] interfaceC4014cArr;
        InterfaceC4014c<t>[] interfaceC4014cArr2;
        c[] cVarArr;
        if (oldIndex > this.minCollectorIndex) {
            return Ya.b.f7045a;
        }
        long jL = L();
        long j12 = this.bufferSize + jL;
        if (this.bufferCapacity == 0 && this.queueSize > 0) {
            j12++;
        }
        if (this.nCollectors != 0 && (cVarArr = this.slots) != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    long j13 = ((q) cVar).index;
                    if (0 <= j13 && j13 < j12) {
                        j12 = j13;
                    }
                }
            }
        }
        if (j12 <= this.minCollectorIndex) {
            return Ya.b.f7045a;
        }
        long jK = K();
        int iMin = getNCollectors() > 0 ? Math.min(this.queueSize, this.bufferCapacity - ((int) (jK - j12))) : this.queueSize;
        InterfaceC4014c<t>[] interfaceC4014cArr3 = Ya.b.f7045a;
        long j14 = this.queueSize + jK;
        if (iMin > 0) {
            InterfaceC4014c<t>[] interfaceC4014cArr4 = new InterfaceC4014c[iMin];
            Object[] objArr = this.buffer;
            p.f(objArr);
            j11 = 1;
            long j15 = jK;
            int i10 = 0;
            while (true) {
                if (jK >= j14) {
                    j10 = j12;
                    interfaceC4014cArr2 = interfaceC4014cArr4;
                    break;
                }
                Object objF = Xa.p.f(objArr, jK);
                j10 = j12;
                C c10 = Xa.p.f6900a;
                if (objF != c10) {
                    p.g(objF, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) objF;
                    int i11 = i10 + 1;
                    interfaceC4014cArr2 = interfaceC4014cArr4;
                    interfaceC4014cArr2[i10] = aVar.cont;
                    Xa.p.g(objArr, jK, c10);
                    Xa.p.g(objArr, j15, aVar.value);
                    j15++;
                    if (i11 >= iMin) {
                        break;
                    }
                    i10 = i11;
                } else {
                    interfaceC4014cArr2 = interfaceC4014cArr4;
                }
                jK++;
                j12 = j10;
                interfaceC4014cArr4 = interfaceC4014cArr2;
            }
            jK = j15;
            interfaceC4014cArr = interfaceC4014cArr2;
        } else {
            j10 = j12;
            j11 = 1;
            interfaceC4014cArr = interfaceC4014cArr3;
        }
        long jMax = Math.max(this.replayIndex, Math.max(jL, jK - this.replay));
        if (this.bufferCapacity == 0 && jMax < j14) {
            Object[] objArr2 = this.buffer;
            p.f(objArr2);
            if (p.d(Xa.p.f(objArr2, jMax), Xa.p.f6900a)) {
                jK += j11;
                jMax += j11;
            }
        }
        long j16 = jK;
        W(jMax, getNCollectors() == 0 ? j16 : j10, j16, j14);
        A();
        return !(interfaceC4014cArr.length == 0) ? J(interfaceC4014cArr) : interfaceC4014cArr;
    }

    public final long Y() {
        long j10 = this.replayIndex;
        if (j10 < this.minCollectorIndex) {
            this.minCollectorIndex = j10;
        }
        return j10;
    }

    @Override // Xa.j
    public boolean a(T value) {
        int i10;
        boolean z10;
        InterfaceC4014c<t>[] interfaceC4014cArrJ = Ya.b.f7045a;
        synchronized (this) {
            if (S(value)) {
                interfaceC4014cArrJ = J(interfaceC4014cArrJ);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        for (InterfaceC4014c<t> interfaceC4014c : interfaceC4014cArrJ) {
            if (interfaceC4014c != null) {
                Result.Companion companion = Result.INSTANCE;
                interfaceC4014c.resumeWith(Result.b(t.f7040a));
            }
        }
        return z10;
    }

    @Override // Ya.h
    public Xa.b<T> b(d context, int capacity, BufferOverflow onBufferOverflow) {
        return Xa.p.e(this, context, capacity, onBufferOverflow);
    }

    @Override // Xa.o, Xa.b
    public Object collect(Xa.c<? super T> cVar, InterfaceC4014c<?> interfaceC4014c) {
        return B(this, cVar, interfaceC4014c);
    }

    @Override // Xa.j
    public void e() throws Throwable {
        SharedFlowImpl<T> sharedFlowImpl;
        synchronized (this) {
            try {
                sharedFlowImpl = this;
                try {
                    sharedFlowImpl.W(K(), this.minCollectorIndex, K(), O());
                    t tVar = t.f7040a;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                sharedFlowImpl = this;
            }
        }
    }

    @Override // Xa.j, Xa.c
    public Object emit(T t10, InterfaceC4014c<? super t> interfaceC4014c) {
        return G(this, t10, interfaceC4014c);
    }

    public final Object y(q qVar, InterfaceC4014c<? super t> interfaceC4014c) {
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        synchronized (this) {
            try {
                if (U(qVar) < 0) {
                    qVar.cont = cVar;
                } else {
                    Result.Companion companion = Result.INSTANCE;
                    cVar.resumeWith(Result.b(t.f7040a));
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            f.c(interfaceC4014c);
        }
        return objC == C4063a.g() ? objC : t.f7040a;
    }

    public final void z(a emitter) {
        synchronized (this) {
            try {
                if (emitter.index >= L()) {
                    Object[] objArr = this.buffer;
                    p.f(objArr);
                    if (Xa.p.f(objArr, emitter.index) == emitter) {
                        Xa.p.g(objArr, emitter.index, Xa.p.f6900a);
                        A();
                    }
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
