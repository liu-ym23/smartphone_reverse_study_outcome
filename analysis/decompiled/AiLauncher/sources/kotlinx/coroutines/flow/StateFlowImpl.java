package kotlinx.coroutines.flow;

import Xa.b;
import Xa.k;
import Xa.u;
import Xa.v;
import Y8.t;
import Ya.h;
import Za.C;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.ContentDisposition;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.channels.BufferOverflow;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u001a\u001a\u00020\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b!\u0010\"J-\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b)\u0010*J!\u0010-\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u00052\u0006\u0010,\u001a\u00020\u0005H\u0002¢\u0006\u0004\b-\u0010\u000eR\u0016\u0010/\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010.R$\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u0010\tR\u0011\u00104\u001a\b\u0012\u0004\u0012\u00020\u0005038\u0002X\u0082\u0004¨\u00065"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "LYa/a;", "LXa/v;", "LXa/k;", "", "LYa/h;", "initialState", "<init>", "(Ljava/lang/Object;)V", "expect", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "", Const.INTENT_KEY_UMID, "(Ljava/lang/Object;Ljava/lang/Object;)Z", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;)Z", "LY8/t;", "emit", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "e", "()V", "LXa/c;", "collector", "", "collect", "(LXa/c;Le9/c;)Ljava/lang/Object;", "o", "()LXa/v;", "", ContentDisposition.Parameters.Size, "", "p", "(I)[LXa/v;", "Lkotlin/coroutines/d;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "LXa/b;", Const.INTENT_KEY_PKGNAME, "(Lkotlin/coroutines/d;ILkotlinx/coroutines/channels/BufferOverflow;)LXa/b;", "expectedState", "newState", "r", "I", "sequence", "getValue", "()Ljava/lang/Object;", "setValue", "LOa/e;", "_state", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StateFlowImpl<T> extends Ya.a<v> implements k<T>, b, h<T> {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36653f = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int sequence;

    @InterfaceC4112d(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {389, 401, 406}, m = "collect", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.StateFlowImpl$collect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f36655a;

        /* renamed from: b, reason: collision with root package name */
        public Object f36656b;

        /* renamed from: c, reason: collision with root package name */
        public Object f36657c;

        /* renamed from: d, reason: collision with root package name */
        public Object f36658d;

        /* renamed from: e, reason: collision with root package name */
        public Object f36659e;

        /* renamed from: f, reason: collision with root package name */
        public /* synthetic */ Object f36660f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ StateFlowImpl<T> f36661g;

        /* renamed from: h, reason: collision with root package name */
        public int f36662h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StateFlowImpl<T> stateFlowImpl, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
            this.f36661g = stateFlowImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f36660f = obj;
            this.f36662h |= Integer.MIN_VALUE;
            return this.f36661g.collect(null, this);
        }
    }

    public StateFlowImpl(Object obj) {
        this._state$volatile = obj;
    }

    @Override // Xa.j
    public boolean a(T value) {
        setValue(value);
        return true;
    }

    @Override // Ya.h
    public b<T> b(d context, int capacity, BufferOverflow onBufferOverflow) {
        return u.d(this, context, capacity, onBufferOverflow);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
    
        if (((kotlinx.coroutines.flow.SubscribedFlowCollector) r10).b(r0) == r1) goto L55;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:36:0x009b, B:53:0x00d6], limit reached: 57 */
    /* JADX WARN: Path cross not found for [B:53:0x00d6, B:36:0x009b], limit reached: 57 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5 A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:14:0x003a, B:36:0x009b, B:38:0x00a5, B:40:0x00aa, B:51:0x00d0, B:53:0x00d6, B:42:0x00b0, B:46:0x00b7, B:21:0x0057, B:24:0x0065, B:35:0x008c), top: B:60:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00aa A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:14:0x003a, B:36:0x009b, B:38:0x00a5, B:40:0x00aa, B:51:0x00d0, B:53:0x00d6, B:42:0x00b0, B:46:0x00b7, B:21:0x0057, B:24:0x0065, B:35:0x008c), top: B:60:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d6 A[Catch: all -> 0x003e, TRY_LEAVE, TryCatch #1 {all -> 0x003e, blocks: (B:14:0x003a, B:36:0x009b, B:38:0x00a5, B:40:0x00aa, B:51:0x00d0, B:53:0x00d6, B:42:0x00b0, B:46:0x00b7, B:21:0x0057, B:24:0x0065, B:35:0x008c), top: B:60:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2, types: [Ya.c] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00d4 -> B:36:0x009b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00ea -> B:36:0x009b). Please report as a decompilation issue!!! */
    @Override // Xa.o, Xa.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(Xa.c<? super T> r10, e9.InterfaceC4014c<?> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.collect(Xa.c, e9.c):java.lang.Object");
    }

    @Override // Xa.k
    public boolean d(T expect, T update) {
        if (expect == null) {
            expect = (T) Ya.k.f7051a;
        }
        if (update == null) {
            update = (T) Ya.k.f7051a;
        }
        return r(expect, update);
    }

    @Override // Xa.j
    public void e() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // Xa.j, Xa.c
    public Object emit(T t10, InterfaceC4014c<? super t> interfaceC4014c) {
        setValue(t10);
        return t.f7040a;
    }

    @Override // Xa.k, Xa.t
    public T getValue() {
        C c10 = Ya.k.f7051a;
        T t10 = (T) f36653f.get(this);
        if (t10 == c10) {
            return null;
        }
        return t10;
    }

    @Override // Ya.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public v j() {
        return new v();
    }

    @Override // Ya.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public v[] k(int size) {
        return new v[size];
    }

    public final boolean r(Object expectedState, Object newState) {
        int i10;
        v[] vVarArrN;
        synchronized (this) {
            Object obj = f36653f.get(this);
            if (expectedState != null && !p.d(obj, expectedState)) {
                return false;
            }
            if (p.d(obj, newState)) {
                return true;
            }
            f36653f.set(this, newState);
            int i11 = this.sequence;
            if ((i11 & 1) != 0) {
                this.sequence = i11 + 2;
                return true;
            }
            int i12 = i11 + 1;
            this.sequence = i12;
            v[] vVarArrN2 = n();
            t tVar = t.f7040a;
            while (true) {
                v[] vVarArr = vVarArrN2;
                if (vVarArr != null) {
                    for (v vVar : vVarArr) {
                        if (vVar != null) {
                            vVar.g();
                        }
                    }
                }
                synchronized (this) {
                    i10 = this.sequence;
                    if (i10 == i12) {
                        this.sequence = i12 + 1;
                        return true;
                    }
                    vVarArrN = n();
                    t tVar2 = t.f7040a;
                }
                vVarArrN2 = vVarArrN;
                i12 = i10;
            }
        }
    }

    @Override // Xa.k
    public void setValue(T t10) {
        if (t10 == null) {
            t10 = (T) Ya.k.f7051a;
        }
        r(null, t10);
    }
}
