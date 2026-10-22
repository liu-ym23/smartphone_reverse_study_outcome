package io.ktor.utils.io;

import La.C0951a;
import Y8.t;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import f9.C4063a;
import fb.C4074a;
import fb.s;
import fb.v;
import g9.InterfaceC4112d;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001GB\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJH\u0010\u0011\u001a\u00020\u0007\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\n2\u001a\b\u0004\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r\u0012\u0004\u0012\u00028\u00000\f2\u000e\b\u0004\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0082H¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0014\u001a\u00020\u0007\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\nH\u0082\b¢\u0006\u0004\b\u0014\u0010\tJ\u0019\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J4\u0010\u001a\u001a\u00020\u0007\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\n2\u0006\u0010\u0019\u001a\u00028\u00002\u000e\b\u0004\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0082\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0096@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0007H\u0096@¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\"\u0010\tJ\u000f\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010\tJ\u0010\u0010$\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b$\u0010!J\u0019\u0010%\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b%\u0010\u0018J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001e\u00103\u001a\u000601j\u0002`28\u0002X\u0082\u0004¢\u0006\f\n\u0004\b3\u00104\u0012\u0004\b5\u0010\tR\u0014\u00106\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010.R\u0014\u00107\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010.R\u001a\u0010<\u001a\u0002088VX\u0097\u0004¢\u0006\f\u0012\u0004\b;\u0010\t\u001a\u0004\b9\u0010:R\u001a\u0010A\u001a\u00020=8VX\u0097\u0004¢\u0006\f\u0012\u0004\b@\u0010\t\u001a\u0004\b>\u0010?R\u0016\u0010D\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010+R\u0014\u0010F\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010+¨\u0006H"}, d2 = {"Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/BufferedByteWriteChannel;", "", "autoFlush", "<init>", "(Z)V", "LY8/t;", "moveFlushToReadBuffer", "()V", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "TaskType", "Lkotlin/Function1;", "Le9/c;", "createTask", "Lkotlin/Function0;", "shouldSleep", "sleepWhile", "(Lp9/l;Lp9/a;Le9/c;)Ljava/lang/Object;", "Expected", "resumeSlot", "", "cause", "closeSlot", "(Ljava/lang/Throwable;)V", "slot", "trySuspend", "(Lio/ktor/utils/io/ByteChannel$Slot$Task;Lp9/a;)V", "", "min", "awaitContent", "(ILe9/c;)Ljava/lang/Object;", "flush", "(Le9/c;)Ljava/lang/Object;", "flushWriteBuffer", "close", "flushAndClose", "cancel", "", "toString", "()Ljava/lang/String;", "Z", "getAutoFlush", "()Z", "Lfb/a;", "flushBuffer", "Lfb/a;", "flushBufferSize", "I", "", "Lio/ktor/utils/io/locks/SynchronizedObject;", "flushBufferMutex", "Ljava/lang/Object;", "getFlushBufferMutex$annotations", "_readBuffer", "_writeBuffer", "Lfb/v;", "getReadBuffer", "()Lfb/v;", "getReadBuffer$annotations", "readBuffer", "Lfb/s;", "getWriteBuffer", "()Lfb/s;", "getWriteBuffer$annotations", "writeBuffer", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForWrite", "isClosedForRead", "Slot", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteChannel implements ByteReadChannel, BufferedByteWriteChannel {
    volatile /* synthetic */ Object _closedCause;
    private final C4074a _readBuffer;
    private final C4074a _writeBuffer;
    private final boolean autoFlush;
    private final C4074a flushBuffer;
    private final Object flushBufferMutex;
    private volatile int flushBufferSize;
    volatile /* synthetic */ Object suspensionSlot;
    static final /* synthetic */ AtomicReferenceFieldUpdater suspensionSlot$FU = AtomicReferenceFieldUpdater.newUpdater(ByteChannel.class, Object.class, "suspensionSlot");
    static final /* synthetic */ AtomicReferenceFieldUpdater _closedCause$FU = AtomicReferenceFieldUpdater.newUpdater(ByteChannel.class, Object.class, "_closedCause");

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u0000 \u00022\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0003\b\t\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot;", "", "Companion", "Empty", "Closed", "Task", "Read", "Write", "Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "Lio/ktor/utils/io/ByteChannel$Slot$Empty;", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Slot {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "Lio/ktor/utils/io/ByteChannel$Slot;", "", "cause", "<init>", "(Ljava/lang/Throwable;)V", "component1", "()Ljava/lang/Throwable;", ChatTracker.CLICK_COPY, "(Ljava/lang/Throwable;)Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getCause", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Closed implements Slot {
            private final Throwable cause;

            public Closed(Throwable th) {
                this.cause = th;
            }

            public static /* synthetic */ Closed copy$default(Closed closed, Throwable th, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    th = closed.cause;
                }
                return closed.copy(th);
            }

            /* renamed from: component1, reason: from getter */
            public final Throwable getCause() {
                return this.cause;
            }

            public final Closed copy(Throwable cause) {
                return new Closed(cause);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Closed) && p.d(this.cause, ((Closed) other).cause);
            }

            public final Throwable getCause() {
                return this.cause;
            }

            public int hashCode() {
                Throwable th = this.cause;
                if (th == null) {
                    return 0;
                }
                return th.hashCode();
            }

            public String toString() {
                return "Closed(cause=" + this.cause + ')';
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Companion;", "", "<init>", "()V", "Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "CLOSED", "Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "getCLOSED", "()Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "getCLOSED$annotations", "Lkotlin/Result;", "LY8/t;", "RESUME", "Ljava/lang/Object;", "getRESUME-d1pmJ48", "()Ljava/lang/Object;", "getRESUME-d1pmJ48$annotations", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final Closed CLOSED = new Closed(null);
            private static final Object RESUME;

            static {
                Result.Companion companion = Result.INSTANCE;
                RESUME = Result.b(t.f7040a);
            }

            private Companion() {
            }

            public static /* synthetic */ void getCLOSED$annotations() {
            }

            /* renamed from: getRESUME-d1pmJ48$annotations, reason: not valid java name */
            public static /* synthetic */ void m198getRESUMEd1pmJ48$annotations() {
            }

            public final Closed getCLOSED() {
                return CLOSED;
            }

            /* renamed from: getRESUME-d1pmJ48, reason: not valid java name */
            public final Object m199getRESUMEd1pmJ48() {
                return RESUME;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Empty;", "Lio/ktor/utils/io/ByteChannel$Slot;", "<init>", "()V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Empty implements Slot {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof Empty);
            }

            public int hashCode() {
                return -231472095;
            }

            public String toString() {
                return "Empty";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Read;", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "Le9/c;", "LY8/t;", "continuation", "<init>", "(Le9/c;)V", "", "taskName", "()Ljava/lang/String;", "Le9/c;", "getContinuation", "()Le9/c;", "", "created", "Ljava/lang/Throwable;", "getCreated", "()Ljava/lang/Throwable;", "setCreated", "(Ljava/lang/Throwable;)V", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Read implements Task {
            private final InterfaceC4014c<t> continuation;
            private Throwable created;

            /* JADX WARN: Multi-variable type inference failed */
            public Read(InterfaceC4014c<? super t> continuation) {
                p.i(continuation, "continuation");
                this.continuation = continuation;
                if (ByteChannel_jvmKt.getDEVELOPMENT_MODE()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("ReadTask 0x");
                    String string = Integer.toString(getContinuation().hashCode(), C0951a.a(16));
                    p.h(string, "toString(...)");
                    sb2.append(string);
                    Throwable th = new Throwable(sb2.toString());
                    Y8.d.b(th);
                    setCreated(th);
                }
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public InterfaceC4014c<t> getContinuation() {
                return this.continuation;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public Throwable getCreated() {
                return this.created;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public void resume() {
                super.resume();
            }

            public void setCreated(Throwable th) {
                this.created = th;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public String taskName() {
                return "read";
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public void resume(Throwable th) {
                super.resume(th);
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0006\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0002\u0012\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Task;", "Lio/ktor/utils/io/ByteChannel$Slot;", "", "taskName", "()Ljava/lang/String;", "LY8/t;", "resume", "()V", "", "throwable", "(Ljava/lang/Throwable;)V", "getCreated", "()Ljava/lang/Throwable;", "created", "Le9/c;", "getContinuation", "()Le9/c;", "continuation", "Lio/ktor/utils/io/ByteChannel$Slot$Read;", "Lio/ktor/utils/io/ByteChannel$Slot$Write;", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public interface Task extends Slot {

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class DefaultImpls {
                @Deprecated
                public static void resume(Task task) {
                    Task.super.resume();
                }

                @Deprecated
                public static void resume(Task task, Throwable th) {
                    Task.super.resume(th);
                }
            }

            static /* synthetic */ void resume$default(Task task, Throwable th, int i10, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resume");
                }
                if ((i10 & 1) != 0) {
                    th = null;
                }
                task.resume(th);
            }

            InterfaceC4014c<t> getContinuation();

            Throwable getCreated();

            default void resume() {
                getContinuation().resumeWith(Slot.INSTANCE.m199getRESUMEd1pmJ48());
            }

            String taskName();

            default void resume(Throwable throwable) {
                Object objM199getRESUMEd1pmJ48;
                InterfaceC4014c<t> continuation = getContinuation();
                if (throwable != null) {
                    Result.Companion companion = Result.INSTANCE;
                    objM199getRESUMEd1pmJ48 = Result.b(C4849c.a(throwable));
                } else {
                    objM199getRESUMEd1pmJ48 = Slot.INSTANCE.m199getRESUMEd1pmJ48();
                }
                continuation.resumeWith(objM199getRESUMEd1pmJ48);
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Write;", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "Le9/c;", "LY8/t;", "continuation", "<init>", "(Le9/c;)V", "", "taskName", "()Ljava/lang/String;", "Le9/c;", "getContinuation", "()Le9/c;", "", "created", "Ljava/lang/Throwable;", "getCreated", "()Ljava/lang/Throwable;", "setCreated", "(Ljava/lang/Throwable;)V", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Write implements Task {
            private final InterfaceC4014c<t> continuation;
            private Throwable created;

            /* JADX WARN: Multi-variable type inference failed */
            public Write(InterfaceC4014c<? super t> continuation) {
                p.i(continuation, "continuation");
                this.continuation = continuation;
                if (ByteChannel_jvmKt.getDEVELOPMENT_MODE()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("WriteTask 0x");
                    String string = Integer.toString(getContinuation().hashCode(), C0951a.a(16));
                    p.h(string, "toString(...)");
                    sb2.append(string);
                    Throwable th = new Throwable(sb2.toString());
                    Y8.d.b(th);
                    setCreated(th);
                }
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public InterfaceC4014c<t> getContinuation() {
                return this.continuation;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public Throwable getCreated() {
                return this.created;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public void resume() {
                super.resume();
            }

            public void setCreated(Throwable th) {
                this.created = th;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public String taskName() {
                return "write";
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public void resume(Throwable th) {
                super.resume(th);
            }
        }

        static Closed getCLOSED() {
            return INSTANCE.getCLOSED();
        }

        /* renamed from: getRESUME-d1pmJ48, reason: not valid java name */
        static Object m197getRESUMEd1pmJ48() {
            return INSTANCE.m199getRESUMEd1pmJ48();
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteChannel", f = "ByteChannel.kt", l = {284}, m = "awaitContent")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteChannel$awaitContent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannel.this.awaitContent(0, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteChannel", f = "ByteChannel.kt", l = {284}, m = "flush")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteChannel$flush$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44201 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44201(InterfaceC4014c<? super C44201> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannel.this.flush(this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteChannel", f = "ByteChannel.kt", l = {128}, m = "flushAndClose")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteChannel$flushAndClose$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44211 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44211(InterfaceC4014c<? super C44211> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannel.this.flushAndClose(this);
        }
    }

    public ByteChannel() {
        this(false, 1, null);
    }

    private final void closeSlot(Throwable cause) {
        Slot slot = (Slot) suspensionSlot$FU.getAndSet(this, cause != null ? new Slot.Closed(cause) : Slot.INSTANCE.getCLOSED());
        if (slot instanceof Slot.Task) {
            ((Slot.Task) slot).resume(cause);
        }
    }

    private static /* synthetic */ void getFlushBufferMutex$annotations() {
    }

    @InternalAPI
    public static /* synthetic */ void getReadBuffer$annotations() {
    }

    @InternalAPI
    public static /* synthetic */ void getWriteBuffer$annotations() {
    }

    private final void moveFlushToReadBuffer() {
        synchronized (this.flushBufferMutex) {
            this.flushBuffer.B(this._readBuffer);
            this.flushBufferSize = 0;
            t tVar = t.f7040a;
        }
        Slot slot = (Slot) this.suspensionSlot;
        if ((slot instanceof Slot.Write) && suspensionSlot$FU.compareAndSet(this, slot, Slot.Empty.INSTANCE)) {
            ((Slot.Task) slot).resume();
        }
    }

    private final /* synthetic */ <Expected extends Slot.Task> void resumeSlot() {
        Slot slot = (Slot) this.suspensionSlot;
        p.o(3, "Expected");
        if ((slot instanceof Slot.Task) && suspensionSlot$FU.compareAndSet(this, slot, Slot.Empty.INSTANCE)) {
            ((Slot.Task) slot).resume();
        }
    }

    private final /* synthetic */ <TaskType extends Slot.Task> Object sleepWhile(InterfaceC5074l<? super InterfaceC4014c<? super t>, ? extends TaskType> interfaceC5074l, InterfaceC5063a<Boolean> interfaceC5063a, InterfaceC4014c<? super t> interfaceC4014c) {
        while (interfaceC5063a.invoke().booleanValue()) {
            n.c(0);
            kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
            cVar.I();
            TaskType tasktypeInvoke = interfaceC5074l.invoke(cVar);
            Slot slot = (Slot) this.suspensionSlot;
            boolean z10 = slot instanceof Slot.Closed;
            if (z10 || suspensionSlot$FU.compareAndSet(this, slot, tasktypeInvoke)) {
                p.o(3, "TaskType");
                boolean z11 = slot instanceof Slot.Task;
                if (z11) {
                    Slot.Task task = (Slot.Task) slot;
                    task.resume(new ConcurrentIOException(tasktypeInvoke.taskName(), task.getCreated()));
                } else if (z11) {
                    ((Slot.Task) slot).resume();
                } else if (z10) {
                    tasktypeInvoke.resume(((Slot.Closed) slot).getCause());
                    t tVar = t.f7040a;
                } else if (!p.d(slot, Slot.Empty.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!interfaceC5063a.invoke().booleanValue()) {
                    Slot slot2 = (Slot) this.suspensionSlot;
                    p.o(3, "TaskType");
                    if ((slot2 instanceof Slot.Task) && suspensionSlot$FU.compareAndSet(this, slot2, Slot.Empty.INSTANCE)) {
                        ((Slot.Task) slot2).resume();
                    }
                }
            } else {
                tasktypeInvoke.resume();
                t tVar2 = t.f7040a;
            }
            t tVar3 = t.f7040a;
            if (cVar.C() == C4063a.g()) {
                g9.f.c(interfaceC4014c);
            }
            n.c(1);
        }
        return t.f7040a;
    }

    private final /* synthetic */ <TaskType extends Slot.Task> void trySuspend(TaskType slot, InterfaceC5063a<Boolean> shouldSleep) {
        Slot slot2 = (Slot) this.suspensionSlot;
        boolean z10 = slot2 instanceof Slot.Closed;
        if (!z10 && !suspensionSlot$FU.compareAndSet(this, slot2, slot)) {
            slot.resume();
            return;
        }
        p.o(3, "TaskType");
        boolean z11 = slot2 instanceof Slot.Task;
        if (z11) {
            Slot.Task task = (Slot.Task) slot2;
            task.resume(new ConcurrentIOException(slot.taskName(), task.getCreated()));
        } else if (z11) {
            ((Slot.Task) slot2).resume();
        } else if (z10) {
            slot.resume(((Slot.Closed) slot2).getCause());
            return;
        } else if (!p.d(slot2, Slot.Empty.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        if (shouldSleep.invoke().booleanValue()) {
            return;
        }
        Slot slot3 = (Slot) this.suspensionSlot;
        p.o(3, "TaskType");
        if ((slot3 instanceof Slot.Task) && suspensionSlot$FU.compareAndSet(this, slot3, Slot.Empty.INSTANCE)) {
            ((Slot.Task) slot3).resume();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object awaitContent(int r13, e9.InterfaceC4014c<? super java.lang.Boolean> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannel.awaitContent(int, e9.c):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public void cancel(Throwable cause) {
        if (this._closedCause != null) {
            return;
        }
        CloseToken closeToken = new CloseToken(cause);
        _closedCause$FU.compareAndSet(this, null, closeToken);
        closeSlot(CloseToken.wrapCause$default(closeToken, null, 1, null));
    }

    @Override // io.ktor.utils.io.BufferedByteWriteChannel
    public void close() {
        flushWriteBuffer();
        if (_closedCause$FU.compareAndSet(this, null, CloseTokenKt.getCLOSED())) {
            closeSlot(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.utils.io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object flush(e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannel.flush(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.utils.io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object flushAndClose(e9.InterfaceC4014c<? super Y8.t> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteChannel.C44211
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.utils.io.ByteChannel$flushAndClose$1 r0 = (io.ktor.utils.io.ByteChannel.C44211) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannel$flushAndClose$1 r0 = new io.ktor.utils.io.ByteChannel$flushAndClose$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannel r0 = (io.ktor.utils.io.ByteChannel) r0
            kotlin.C4849c.b(r5)     // Catch: java.lang.Throwable -> L2d
            goto L4e
        L2d:
            r5 = move-exception
            goto L54
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.C4849c.b(r5)
            kotlin.Result$a r5 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r5 = g9.h.a(r4)     // Catch: java.lang.Throwable -> L2d
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L2d
            r5 = 0
            r0.I$0 = r5     // Catch: java.lang.Throwable -> L2d
            r0.label = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r5 = r4.flush(r0)     // Catch: java.lang.Throwable -> L2d
            if (r5 != r1) goto L4e
            return r1
        L4e:
            Y8.t r5 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L2d
            kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> L2d
            goto L5d
        L54:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.C4849c.a(r5)
            kotlin.Result.b(r5)
        L5d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = io.ktor.utils.io.ByteChannel._closedCause$FU
            io.ktor.utils.io.CloseToken r0 = io.ktor.utils.io.CloseTokenKt.getCLOSED()
            r1 = 0
            boolean r5 = r5.compareAndSet(r4, r1, r0)
            if (r5 != 0) goto L6d
            Y8.t r4 = Y8.t.f7040a
            return r4
        L6d:
            r4.closeSlot(r1)
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannel.flushAndClose(e9.c):java.lang.Object");
    }

    @Override // io.ktor.utils.io.BufferedByteWriteChannel
    @InternalAPI
    public void flushWriteBuffer() {
        if (this._writeBuffer.k()) {
            return;
        }
        synchronized (this.flushBufferMutex) {
            int iN = (int) this._writeBuffer.n();
            this.flushBuffer.m0(this._writeBuffer);
            this.flushBufferSize += iN;
            t tVar = t.f7040a;
        }
        Slot slot = (Slot) this.suspensionSlot;
        if ((slot instanceof Slot.Read) && suspensionSlot$FU.compareAndSet(this, slot, Slot.Empty.INSTANCE)) {
            ((Slot.Task) slot).resume();
        }
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public Throwable getClosedCause() {
        CloseToken closeToken = (CloseToken) this._closedCause;
        if (closeToken != null) {
            return CloseToken.wrapCause$default(closeToken, null, 1, null);
        }
        return null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public v getReadBuffer() throws Throwable {
        CloseToken closeToken = (CloseToken) this._closedCause;
        if (closeToken != null) {
            closeToken.throwOrNull(ByteChannel$readBuffer$1.INSTANCE);
        }
        if (this._readBuffer.k()) {
            moveFlushToReadBuffer();
        }
        return this._readBuffer;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public s getWriteBuffer() throws ClosedWriteChannelException {
        CloseToken closeToken;
        if (isClosedForWrite() && ((closeToken = (CloseToken) this._closedCause) == null || closeToken.throwOrNull(ByteChannel$writeBuffer$1.INSTANCE) == null)) {
            throw new ClosedWriteChannelException(null, 1, null);
        }
        return this._writeBuffer;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean isClosedForRead() {
        if (getClosedCause() == null) {
            return isClosedForWrite() && this.flushBufferSize == 0 && this._readBuffer.k();
        }
        return true;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean isClosedForWrite() {
        return this._closedCause != null;
    }

    public String toString() {
        return "ByteChannel[" + hashCode() + ']';
    }

    public ByteChannel(boolean z10) {
        this.autoFlush = z10;
        this.flushBuffer = new C4074a();
        this.flushBufferMutex = new Object();
        this.suspensionSlot = Slot.Empty.INSTANCE;
        this._readBuffer = new C4074a();
        this._writeBuffer = new C4074a();
        this._closedCause = null;
    }

    public /* synthetic */ ByteChannel(boolean z10, int i10, i iVar) {
        this((i10 & 1) != 0 ? false : z10);
    }
}
