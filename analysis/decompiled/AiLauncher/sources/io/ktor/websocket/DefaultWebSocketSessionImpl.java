package io.ktor.websocket;

import Ua.C1056g;
import Ua.C1060i;
import Ua.C1086v0;
import Ua.C1087w;
import Ua.CoroutineName;
import Ua.InterfaceC1083u;
import Ua.InterfaceC1089x;
import Ua.M;
import Ua.Q;
import Ua.Y;
import Wa.r;
import Wa.s;
import Y8.t;
import Z8.F;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.zyql.ai.selector.config.PictureConfig;
import com.zyql.ai.selector.widget.longimage.SubsamplingScaleImageView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineStart;
import p9.p;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0001eB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J&\u0010\u0018\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010#\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H\u0082@¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b'\u0010&J!\u0010+\u001a\u00020\u00112\u0010\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0(H\u0016¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u00020\u00112\b\b\u0002\u0010.\u001a\u00020-H\u0086@¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b1\u0010\u0013J\u000f\u00102\u001a\u00020\u0011H\u0017¢\u0006\u0004\b2\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00103R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u0014048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020!078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020!078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00109R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001e\u0010?\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010B\u001a\u00020A8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER*\u0010\u0005\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00048\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR*\u0010\u0006\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00048\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010G\u001a\u0004\bL\u0010I\"\u0004\bM\u0010KR\"\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140N8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020!0S8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020!0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u001e\u0010\\\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R$\u0010a\u001a\u00020\u001a2\u0006\u0010]\u001a\u00020\u001a8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b^\u0010\u001c\"\u0004\b_\u0010`R$\u0010d\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bb\u0010I\"\u0004\bc\u0010K¨\u0006f"}, d2 = {"Lio/ktor/websocket/DefaultWebSocketSessionImpl;", "Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/websocket/WebSocketSession;", "raw", "", "pingIntervalMillis", "timeoutMillis", "<init>", "(Lio/ktor/websocket/WebSocketSession;JJ)V", "LWa/s;", "Lio/ktor/websocket/Frame$Ping;", "ponger", "Lkotlinx/coroutines/g;", "runIncomingProcessor", "(LWa/s;)Lkotlinx/coroutines/g;", "runOutgoingProcessor", "()Lkotlinx/coroutines/g;", "LY8/t;", "outgoingProcessorLoop", "(Le9/c;)Ljava/lang/Object;", "Lio/ktor/websocket/CloseReason;", "reason", "", "exception", "sendCloseSequence", "(Lio/ktor/websocket/CloseReason;Ljava/lang/Throwable;Le9/c;)Ljava/lang/Object;", "", "tryClose", "()Z", "runOrCancelPinger", "()V", "Lfb/s;", "packet", "Lio/ktor/websocket/Frame;", "frame", "checkMaxFrameSize", "(Lfb/s;Lio/ktor/websocket/Frame;Le9/c;)Ljava/lang/Object;", "processIncomingExtensions", "(Lio/ktor/websocket/Frame;)Lio/ktor/websocket/Frame;", "processOutgoingExtensions", "", "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", "start", "(Ljava/util/List;)V", "", "message", "goingAway", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "flush", "terminate", "Lio/ktor/websocket/WebSocketSession;", "LUa/u;", "closeReasonRef", "LUa/u;", "LWa/g;", "filtered", "LWa/g;", "outgoingToBeProcessed", "LUa/x;", "context", "LUa/x;", "", "_extensions", "Ljava/util/List;", "Lkotlin/coroutines/d;", "coroutineContext", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "newValue", "J", "getPingIntervalMillis", "()J", "setPingIntervalMillis", "(J)V", "getTimeoutMillis", "setTimeoutMillis", "LUa/Q;", "closeReason", "LUa/Q;", "getCloseReason", "()LUa/Q;", "LWa/r;", "getIncoming", "()LWa/r;", "incoming", "getOutgoing", "()LWa/s;", "outgoing", "getExtensions", "()Ljava/util/List;", "extensions", UxipConstants.f30680s, "getMasking", "setMasking", "(Z)V", "masking", "getMaxFrameSize", "setMaxFrameSize", "maxFrameSize", "Companion", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultWebSocketSessionImpl implements DefaultWebSocketSession, WebSocketSession {
    private final List<WebSocketExtension<?>> _extensions;
    private final Q<CloseReason> closeReason;
    private final InterfaceC1083u<CloseReason> closeReasonRef;
    private volatile /* synthetic */ int closed;
    private final InterfaceC1089x context;
    private final kotlin.coroutines.d coroutineContext;
    private final Wa.g<Frame> filtered;
    private final Wa.g<Frame> outgoingToBeProcessed;
    private long pingIntervalMillis;
    volatile /* synthetic */ Object pinger;
    private final WebSocketSession raw;
    private volatile /* synthetic */ int started;
    private long timeoutMillis;
    private static final Frame.Pong EmptyPong = new Frame.Pong(new byte[0], NonDisposableHandle.INSTANCE);
    static final /* synthetic */ AtomicReferenceFieldUpdater pinger$FU = AtomicReferenceFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, Object.class, "pinger");
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, AlipayXuiIsland.REASON_CLOSED);
    private static final /* synthetic */ AtomicIntegerFieldUpdater started$FU = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, RobotInfo.STATUS_STARTED);

    @InterfaceC4112d(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", l = {361}, m = "checkMaxFrameSize")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketSessionImpl.this.checkMaxFrameSize(null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", l = {286, 290, 300}, m = "outgoingProcessorLoop")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$outgoingProcessorLoop$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C44561(InterfaceC4014c<? super C44561> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketSessionImpl.this.outgoingProcessorLoop(this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1", f = "DefaultWebSocketSession.kt", l = {406, 207, 260, 213, 214, 216, 231, 246, 260, 260, 260, 260}, m = "invokeSuspend")
    /* renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44571 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ s<Frame.Ping> $ponger;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C44571(s<? super Frame.Ping> sVar, InterfaceC4014c<? super C44571> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$ponger = sVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C44571 c44571 = DefaultWebSocketSessionImpl.this.new C44571(this.$ponger, interfaceC4014c);
            c44571.L$0 = obj;
            return c44571;
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C44571) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:83:0x03e3, code lost:
        
            if (io.ktor.websocket.WebSocketSessionKt.close(r7, r9, r36) == r3) goto L49;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 13, insn: 0x00c6: MOVE (r4 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:18:0x00c3 */
        /* JADX WARN: Not initialized variable reg: 14, insn: 0x00c7: MOVE (r6 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:18:0x00c3 */
        /* JADX WARN: Path cross not found for [B:138:0x056a, B:257:0x052c], limit reached: 296 */
        /* JADX WARN: Path cross not found for [B:257:0x052c, B:138:0x056a], limit reached: 296 */
        /* JADX WARN: Removed duplicated region for block: B:138:0x056a  */
        /* JADX WARN: Removed duplicated region for block: B:185:0x06dd  */
        /* JADX WARN: Removed duplicated region for block: B:220:0x0793  */
        /* JADX WARN: Removed duplicated region for block: B:223:0x07a5  */
        /* JADX WARN: Removed duplicated region for block: B:238:0x0852  */
        /* JADX WARN: Removed duplicated region for block: B:241:0x0864  */
        /* JADX WARN: Removed duplicated region for block: B:257:0x052c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:278:0x02a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x028c  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0383  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0393  */
        /* JADX WARN: Type inference failed for: r10v30, types: [Wa.s, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v31, types: [T, fb.s] */
        /* JADX WARN: Type inference failed for: r8v30, types: [T, io.ktor.websocket.Frame] */
        /* JADX WARN: Type inference failed for: r8v83 */
        /* JADX WARN: Type inference failed for: r8v84 */
        /* JADX WARN: Type inference failed for: r9v16, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x047c -> B:166:0x069f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:137:0x055c -> B:167:0x06a7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:163:0x0691 -> B:253:0x0695). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r37) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 2244
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.C44571.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1", f = "DefaultWebSocketSession.kt", l = {SubsamplingScaleImageView.ORIENTATION_270, 281, 281, 281, 274, 281, 281, 278, 281, 281}, m = "invokeSuspend")
    /* renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44581 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        Object L$0;
        int label;

        public C44581(InterfaceC4014c<? super C44581> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return DefaultWebSocketSessionImpl.this.new C44581(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C44581) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0070, code lost:
        
            if (r10 != r1) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
        
            if (io.ktor.websocket.WebSocketSessionKt.close$default(r11, null, r10, 1, null) == r1) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00ce, code lost:
        
            if (io.ktor.websocket.WebSocketSessionKt.close$default(r11, null, r10, 1, null) != r1) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x010a, code lost:
        
            if (io.ktor.websocket.WebSocketSessionKt.close$default(r10, null, r7, 1, null) == r1) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0146, code lost:
        
            if (io.ktor.websocket.WebSocketSessionKt.close$default(r10, null, r7, 1, null) != r1) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x015f, code lost:
        
            if (io.ktor.websocket.WebSocketSessionKt.close$default(r10, null, r7, 1, null) != r1) goto L62;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0161 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r10v0, types: [e9.c, io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1] */
        /* JADX WARN: Type inference failed for: r10v1, types: [e9.c, io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1] */
        /* JADX WARN: Type inference failed for: r10v14, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1] */
        /* JADX WARN: Type inference failed for: r10v17, types: [e9.c, io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1] */
        /* JADX WARN: Type inference failed for: r10v2 */
        /* JADX WARN: Type inference failed for: r10v20 */
        /* JADX WARN: Type inference failed for: r10v28, types: [e9.c, io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1] */
        /* JADX WARN: Type inference failed for: r10v30, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v34 */
        /* JADX WARN: Type inference failed for: r10v35 */
        /* JADX WARN: Type inference failed for: r10v8 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 384
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.C44581.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @InterfaceC4112d(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", l = {315}, m = "sendCloseSequence")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44591 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C44591(InterfaceC4014c<? super C44591> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketSessionImpl.this.sendCloseSequence(null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$start$2", f = "DefaultWebSocketSession.kt", l = {DidiCardView.FINISHED_SUMMARY_WIDTH_DP, PictureConfig.PREVIEW_VIDEO_CODE}, m = "invokeSuspend")
    /* renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$start$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ kotlinx.coroutines.g $incomingJob;
        final /* synthetic */ kotlinx.coroutines.g $outgoingJob;
        int label;
        final /* synthetic */ DefaultWebSocketSessionImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(kotlinx.coroutines.g gVar, kotlinx.coroutines.g gVar2, DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$incomingJob = gVar;
            this.$outgoingJob = gVar2;
            this.this$0 = defaultWebSocketSessionImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$incomingJob, this.$outgoingJob, this.this$0, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
        
            if (r5.T0(r4) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.C4849c.b(r5)
                goto L37
            L12:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L1a:
                kotlin.C4849c.b(r5)
                goto L2c
            L1e:
                kotlin.C4849c.b(r5)
                kotlinx.coroutines.g r5 = r4.$incomingJob
                r4.label = r3
                java.lang.Object r5 = r5.T0(r4)
                if (r5 != r0) goto L2c
                goto L36
            L2c:
                kotlinx.coroutines.g r5 = r4.$outgoingJob
                r4.label = r2
                java.lang.Object r5 = r5.T0(r4)
                if (r5 != r0) goto L37
            L36:
                return r0
            L37:
                io.ktor.websocket.DefaultWebSocketSessionImpl r4 = r4.this$0
                Ua.x r4 = io.ktor.websocket.DefaultWebSocketSessionImpl.access$getContext$p(r4)
                r5 = 0
                kotlinx.coroutines.g.a.a(r4, r5, r3, r5)
                Y8.t r4 = Y8.t.f7040a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public DefaultWebSocketSessionImpl(WebSocketSession raw, long j10, long j11) {
        kotlin.jvm.internal.p.i(raw, "raw");
        this.raw = raw;
        this.pinger = null;
        InterfaceC1083u<CloseReason> interfaceC1083uC = C1087w.c(null, 1, null);
        this.closeReasonRef = interfaceC1083uC;
        this.filtered = Wa.j.b(8, null, null, 6, null);
        this.outgoingToBeProcessed = Wa.j.b(UtilsKt.getOUTGOING_CHANNEL_CAPACITY(), null, null, 6, null);
        this.closed = 0;
        InterfaceC1089x interfaceC1089xA = C1086v0.a((kotlinx.coroutines.g) raw.getCoroutineContext().get(kotlinx.coroutines.g.INSTANCE));
        this.context = interfaceC1089xA;
        this._extensions = new ArrayList();
        this.started = 0;
        this.coroutineContext = raw.getCoroutineContext().plus(interfaceC1089xA).plus(new CoroutineName("ws-default"));
        this.pingIntervalMillis = j10;
        this.timeoutMillis = j11;
        this.closeReason = interfaceC1083uC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object checkMaxFrameSize(fb.s r9, io.ktor.websocket.Frame r10, e9.InterfaceC4014c<? super Y8.t> r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r11 instanceof io.ktor.websocket.DefaultWebSocketSessionImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1 r0 = (io.ktor.websocket.DefaultWebSocketSessionImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1 r0 = new io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2d:
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            io.ktor.websocket.Frame r9 = (io.ktor.websocket.Frame) r9
            java.lang.Object r9 = r0.L$0
            fb.s r9 = (fb.s) r9
            kotlin.C4849c.b(r11)
            goto L96
        L3b:
            kotlin.C4849c.b(r11)
            byte[] r11 = r10.getData()
            int r11 = r11.length
            if (r9 == 0) goto L4a
            int r2 = io.ktor.utils.io.core.BytePacketBuilderKt.getSize(r9)
            goto L4b
        L4a:
            r2 = 0
        L4b:
            int r11 = r11 + r2
            long r4 = (long) r11
            long r6 = r8.getMaxFrameSize()
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L9d
            if (r9 == 0) goto L5a
            r9.close()
        L5a:
            io.ktor.websocket.CloseReason r2 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r4 = io.ktor.websocket.CloseReason.Codes.TOO_BIG
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Frame is too big: "
            r5.append(r6)
            r5.append(r11)
            java.lang.String r6 = ". Max size is "
            r5.append(r6)
            long r6 = r8.getMaxFrameSize()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r2.<init>(r4, r5)
            java.lang.Object r9 = g9.h.a(r9)
            r0.L$0 = r9
            java.lang.Object r9 = g9.h.a(r10)
            r0.L$1 = r9
            r0.I$0 = r11
            r0.label = r3
            java.lang.Object r8 = io.ktor.websocket.WebSocketSessionKt.close(r8, r2, r0)
            if (r8 != r1) goto L95
            return r1
        L95:
            r8 = r11
        L96:
            io.ktor.websocket.FrameTooBigException r9 = new io.ktor.websocket.FrameTooBigException
            long r10 = (long) r8
            r9.<init>(r10)
            throw r9
        L9d:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.checkMaxFrameSize(fb.s, io.ktor.websocket.Frame, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object goingAway$default(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, String str, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "Server is going down";
        }
        return defaultWebSocketSessionImpl.goingAway(str, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c5, code lost:
    
        if (sendCloseSequence$default(r12, r7, null, r9, 2, null) == r1) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00f5 -> B:14:0x003b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object outgoingProcessorLoop(e9.InterfaceC4014c<? super Y8.t> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.outgoingProcessorLoop(e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Frame processIncomingExtensions(Frame frame) {
        Iterator<T> it = getExtensions().iterator();
        while (it.hasNext()) {
            frame = ((WebSocketExtension) it.next()).processIncomingFrame(frame);
        }
        return frame;
    }

    private final Frame processOutgoingExtensions(Frame frame) {
        Iterator<T> it = getExtensions().iterator();
        while (it.hasNext()) {
            frame = ((WebSocketExtension) it.next()).processOutgoingFrame(frame);
        }
        return frame;
    }

    private final kotlinx.coroutines.g runIncomingProcessor(s<? super Frame.Ping> ponger) {
        return C1060i.d(this, DefaultWebSocketSessionKt.IncomingProcessorCoroutineName.plus(Y.d()), null, new C44571(ponger, null), 2, null);
    }

    private final void runOrCancelPinger() {
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl;
        s<Frame.Pong> sVarPinger;
        long pingIntervalMillis = getPingIntervalMillis();
        if (this.closed == 0 && pingIntervalMillis > 0) {
            defaultWebSocketSessionImpl = this;
            sVarPinger = PingPongKt.pinger(defaultWebSocketSessionImpl, this.raw.getOutgoing(), pingIntervalMillis, getTimeoutMillis(), new DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1(this, null));
        } else {
            defaultWebSocketSessionImpl = this;
            sVarPinger = null;
        }
        s sVar = (s) pinger$FU.getAndSet(defaultWebSocketSessionImpl, sVarPinger);
        if (sVar != null) {
            s.a(sVar, null, 1, null);
        }
        if (sVarPinger != null) {
            kotlinx.coroutines.channels.a.j(sVarPinger.mo0trySendJP2dKIU(EmptyPong));
        }
        if (defaultWebSocketSessionImpl.closed == 0 || sVarPinger == null) {
            return;
        }
        defaultWebSocketSessionImpl.runOrCancelPinger();
    }

    private final kotlinx.coroutines.g runOutgoingProcessor() {
        return C1056g.c(this, DefaultWebSocketSessionKt.OutgoingProcessorCoroutineName.plus(Y.d()), CoroutineStart.UNDISPATCHED, new C44581(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendCloseSequence(io.ktor.websocket.CloseReason r7, java.lang.Throwable r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.sendCloseSequence(io.ktor.websocket.CloseReason, java.lang.Throwable, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object sendCloseSequence$default(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, CloseReason closeReason, Throwable th, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            th = null;
        }
        return defaultWebSocketSessionImpl.sendCloseSequence(closeReason, th, interfaceC4014c);
    }

    private final boolean tryClose() {
        return closed$FU.compareAndSet(this, 0, 1);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object flush(InterfaceC4014c<? super t> interfaceC4014c) {
        Object objFlush = this.raw.flush(interfaceC4014c);
        return objFlush == C4063a.g() ? objFlush : t.f7040a;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public Q<CloseReason> getCloseReason() {
        return this.closeReason;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession, io.ktor.websocket.WebSocketSession, Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return this._extensions;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public r<Frame> getIncoming() {
        return this.filtered;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return this.raw.getMasking();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return this.raw.getMaxFrameSize();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public s<Frame> getOutgoing() {
        return this.outgoingToBeProcessed;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    public final Object goingAway(String str, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objSendCloseSequence$default = sendCloseSequence$default(this, new CloseReason(CloseReason.Codes.GOING_AWAY, str), null, interfaceC4014c, 2, null);
        return objSendCloseSequence$default == C4063a.g() ? objSendCloseSequence$default : t.f7040a;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object send(Frame frame, InterfaceC4014c<? super t> interfaceC4014c) {
        return super.send(frame, interfaceC4014c);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z10) {
        this.raw.setMasking(z10);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j10) {
        this.raw.setMaxFrameSize(j10);
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setPingIntervalMillis(long j10) {
        this.pingIntervalMillis = j10;
        runOrCancelPinger();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setTimeoutMillis(long j10) {
        this.timeoutMillis = j10;
        runOrCancelPinger();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void start(List<? extends WebSocketExtension<?>> negotiatedExtensions) {
        kotlin.jvm.internal.p.i(negotiatedExtensions, "negotiatedExtensions");
        if (!started$FU.compareAndSet(this, 0, 1)) {
            throw new IllegalStateException(("WebSocket session " + this + " is already started.").toString());
        }
        vc.c logger = DefaultWebSocketSessionKt.getLOGGER();
        if (LoggerJvmKt.isTraceEnabled(logger)) {
            logger.trace("Starting default WebSocketSession(" + this + ") with negotiated extensions: " + F.A0(negotiatedExtensions, null, null, null, 0, null, null, 63, null));
        }
        this._extensions.addAll(negotiatedExtensions);
        runOrCancelPinger();
        C1060i.d(this, null, null, new AnonymousClass2(runIncomingProcessor(PingPongKt.ponger(this, getOutgoing())), runOutgoingProcessor(), this, null), 3, null);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void terminate() {
        kotlinx.coroutines.g.Y0(this.context, null, 1, null);
        kotlinx.coroutines.d.e(this.raw, null, 1, null);
    }
}
