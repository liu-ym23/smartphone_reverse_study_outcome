package io.ktor.network.util;

import Ua.C1060i;
import Ua.CoroutineName;
import Ua.M;
import Ua.U;
import Ua.W0;
import Y8.t;
import com.stepos.ailauncher.chat.trace.g;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001aR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lio/ktor/network/util/Timeout;", "", "", "name", "", "timeoutMs", "Lkotlin/Function0;", "clock", "LUa/M;", "scope", "Lkotlin/Function1;", "Le9/c;", "LY8/t;", "onTimeout", "<init>", "(Ljava/lang/String;JLp9/a;LUa/M;Lp9/l;)V", "Lkotlinx/coroutines/g;", "initTimeoutJob", "()Lkotlinx/coroutines/g;", "start", "()V", g.ACTION_STOP, "finish", "Ljava/lang/String;", "J", "Lp9/a;", "LUa/M;", "Lp9/l;", "workerJob", "Lkotlinx/coroutines/g;", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Timeout {
    private final InterfaceC5063a<Long> clock;
    volatile /* synthetic */ int isStarted;
    volatile /* synthetic */ long lastActivityTime;
    private final String name;
    private final InterfaceC5074l<InterfaceC4014c<? super t>, Object> onTimeout;
    private final M scope;
    private final long timeoutMs;
    private kotlinx.coroutines.g workerJob;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.network.util.Timeout$initTimeoutJob$1", f = "Utils.kt", l = {55, 57, 58}, m = "invokeSuspend")
    /* renamed from: io.ktor.network.util.Timeout$initTimeoutJob$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        long J$0;
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return Timeout.this.new AnonymousClass1(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0 && i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                    return t.f7040a;
                }
                C4849c.b(obj);
                InterfaceC5074l interfaceC5074l = Timeout.this.onTimeout;
                this.label = 3;
                if (interfaceC5074l.invoke(this) == objG) {
                    return objG;
                }
                return t.f7040a;
            }
            C4849c.b(obj);
            while (true) {
                if (Timeout.this.isStarted == 0) {
                    Timeout timeout = Timeout.this;
                    timeout.lastActivityTime = ((Number) timeout.clock.invoke()).longValue();
                }
                long jLongValue = (Timeout.this.lastActivityTime + Timeout.this.timeoutMs) - ((Number) Timeout.this.clock.invoke()).longValue();
                if (jLongValue > 0 || Timeout.this.isStarted == 0) {
                    this.J$0 = jLongValue;
                    this.label = 1;
                    if (U.a(jLongValue, this) == objG) {
                        break;
                    }
                } else {
                    this.label = 2;
                    if (W0.a(this) == objG) {
                    }
                }
            }
            return objG;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Timeout(String name, long j10, InterfaceC5063a<Long> clock, M scope, InterfaceC5074l<? super InterfaceC4014c<? super t>, ? extends Object> onTimeout) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(clock, "clock");
        kotlin.jvm.internal.p.i(scope, "scope");
        kotlin.jvm.internal.p.i(onTimeout, "onTimeout");
        this.name = name;
        this.timeoutMs = j10;
        this.clock = clock;
        this.scope = scope;
        this.onTimeout = onTimeout;
        this.lastActivityTime = 0L;
        this.isStarted = 0;
        this.workerJob = initTimeoutJob();
    }

    private final kotlinx.coroutines.g initTimeoutJob() {
        if (this.timeoutMs == Long.MAX_VALUE) {
            return null;
        }
        M m10 = this.scope;
        return C1060i.d(m10, m10.getCoroutineContext().plus(new CoroutineName("Timeout " + this.name)), null, new AnonymousClass1(null), 2, null);
    }

    public final void finish() {
        kotlinx.coroutines.g gVar = this.workerJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
    }

    public final void start() {
        this.lastActivityTime = this.clock.invoke().longValue();
        this.isStarted = 1;
    }

    public final void stop() {
        this.isStarted = 0;
    }
}
