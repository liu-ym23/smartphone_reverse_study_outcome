package kotlinx.coroutines.flow.internal;

import Ua.M;
import Ua.N;
import Wa.r;
import Xa.b;
import Xa.c;
import Y8.t;
import Ya.h;
import Z8.F;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import p9.p;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0015\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H¤@¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u0013\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u001d\u001a\u00020\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0096@¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010!R\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010%R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b&\u0010'R6\u0010-\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140)\u0012\u0006\u0012\u0004\u0018\u00010*0(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlow;", ExifInterface.GPS_DIRECTION_TRUE, "LYa/h;", "Lkotlin/coroutines/d;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlin/coroutines/d;ILkotlinx/coroutines/channels/BufferOverflow;)V", "LXa/b;", "k", "()LXa/b;", Const.INTENT_KEY_PKGNAME, "(Lkotlin/coroutines/d;ILkotlinx/coroutines/channels/BufferOverflow;)LXa/b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lkotlin/coroutines/d;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "LWa/p;", "scope", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LWa/p;Le9/c;)Ljava/lang/Object;", "LUa/M;", "LWa/r;", "n", "(LUa/M;)LWa/r;", "LXa/c;", "collector", "collect", "(LXa/c;Le9/c;)Ljava/lang/Object;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/String;", "toString", Const.INTENT_KEY_APIKEY, "Lkotlin/coroutines/d;", "I", "c", "Lkotlinx/coroutines/channels/BufferOverflow;", "Lkotlin/Function2;", "Le9/c;", "", "l", "()Lp9/p;", "collectToFun", "m", "()I", "produceCapacity", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ChannelFlow<T> implements h<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final d context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int capacity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final BufferOverflow onBufferOverflow;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {119}, m = "invokeSuspend", v = 1)
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlow$collect$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f36677a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f36678b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c<T> f36679c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ChannelFlow<T> f36680d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(c<? super T> cVar, ChannelFlow<T> channelFlow, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f36679c = cVar;
            this.f36680d = channelFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f36679c, this.f36680d, interfaceC4014c);
            anonymousClass2.f36678b = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            M m10 = (M) this.f36678b;
            Object objG = C4063a.g();
            int i10 = this.f36677a;
            if (i10 == 0) {
                C4849c.b(obj);
                c<T> cVar = this.f36679c;
                r<T> rVarN = this.f36680d.n(m10);
                this.f36678b = g9.h.a(m10);
                this.f36677a = 1;
                if (Xa.d.u(cVar, rVarN, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return t.f7040a;
        }
    }

    public ChannelFlow(d dVar, int i10, BufferOverflow bufferOverflow) {
        this.context = dVar;
        this.capacity = i10;
        this.onBufferOverflow = bufferOverflow;
    }

    public static /* synthetic */ <T> Object h(ChannelFlow<T> channelFlow, c<? super T> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objF = kotlinx.coroutines.d.f(new AnonymousClass2(cVar, channelFlow, null), interfaceC4014c);
        return objF == C4063a.g() ? objF : t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    @Override // Ya.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Xa.b<T> b(kotlin.coroutines.d r2, int r3, kotlinx.coroutines.channels.BufferOverflow r4) {
        /*
            r1 = this;
            kotlin.coroutines.d r0 = r1.context
            kotlin.coroutines.d r2 = r2.plus(r0)
            kotlinx.coroutines.channels.BufferOverflow r0 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            if (r4 == r0) goto Lb
            goto L25
        Lb:
            int r4 = r1.capacity
            r0 = -3
            if (r4 != r0) goto L11
            goto L23
        L11:
            if (r3 != r0) goto L15
        L13:
            r3 = r4
            goto L23
        L15:
            r0 = -2
            if (r4 != r0) goto L19
            goto L23
        L19:
            if (r3 != r0) goto L1c
            goto L13
        L1c:
            int r3 = r3 + r4
            if (r3 < 0) goto L20
            goto L23
        L20:
            r3 = 2147483647(0x7fffffff, float:NaN)
        L23:
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.onBufferOverflow
        L25:
            kotlin.coroutines.d r0 = r1.context
            boolean r0 = kotlin.jvm.internal.p.d(r2, r0)
            if (r0 == 0) goto L36
            int r0 = r1.capacity
            if (r3 != r0) goto L36
            kotlinx.coroutines.channels.BufferOverflow r0 = r1.onBufferOverflow
            if (r4 != r0) goto L36
            return r1
        L36:
            kotlinx.coroutines.flow.internal.ChannelFlow r1 = r1.j(r2, r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlow.b(kotlin.coroutines.d, int, kotlinx.coroutines.channels.BufferOverflow):Xa.b");
    }

    @Override // Xa.b
    public Object collect(c<? super T> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return h(this, cVar, interfaceC4014c);
    }

    public String g() {
        return null;
    }

    public abstract Object i(Wa.p<? super T> pVar, InterfaceC4014c<? super t> interfaceC4014c);

    public abstract ChannelFlow<T> j(d context, int capacity, BufferOverflow onBufferOverflow);

    public b<T> k() {
        return null;
    }

    public final p<Wa.p<? super T>, InterfaceC4014c<? super t>, Object> l() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public final int m() {
        int i10 = this.capacity;
        if (i10 == -3) {
            return -2;
        }
        return i10;
    }

    public r<T> n(M scope) {
        return ProduceKt.d(scope, this.context, m(), this.onBufferOverflow, CoroutineStart.ATOMIC, null, l(), 16, null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strG = g();
        if (strG != null) {
            arrayList.add(strG);
        }
        if (this.context != EmptyCoroutineContext.f34779a) {
            arrayList.add("context=" + this.context);
        }
        if (this.capacity != -3) {
            arrayList.add("capacity=" + this.capacity);
        }
        if (this.onBufferOverflow != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.onBufferOverflow);
        }
        return N.a(this) + '[' + F.A0(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
