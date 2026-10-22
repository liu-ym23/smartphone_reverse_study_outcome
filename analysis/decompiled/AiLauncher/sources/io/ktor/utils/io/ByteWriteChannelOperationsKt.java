package io.ktor.utils.io;

import Ua.C1060i;
import Ua.InterfaceC1045a0;
import Ua.M;
import Y8.t;
import ab.C1278a;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import fb.C4074a;
import fb.C4078e;
import fb.InterfaceC4084k;
import fb.s;
import fb.u;
import fb.v;
import g9.InterfaceC4112d;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000Ó\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0007*\u0001Z\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\tH\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\fH\u0086@¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0010\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u001b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b\u001e\u0010\u001f\u001a0\u0010\"\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\tH\u0086@¢\u0006\u0004\b\"\u0010#\u001a\u001c\u0010%\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u001a\u001a\u00020$H\u0086@¢\u0006\u0004\b%\u0010&\u001a$\u0010%\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b%\u0010(\u001a\u001c\u0010)\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b)\u0010\u001f\u001a\u001c\u0010,\u001a\u00020\u0003*\u00020\u00002\u0006\u0010+\u001a\u00020*H\u0086@¢\u0006\u0004\b,\u0010-\u001a\u001c\u0010,\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b,\u0010\u001c\u001a\u001b\u00100\u001a\u00020\u0003*\u00020\u00002\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101\u001a\u0014\u00103\u001a\u00020\u0003*\u000202H\u0086@¢\u0006\u0004\b3\u00104\u001a\u0015\u00107\u001a\u000605j\u0002`6*\u000202¢\u0006\u0004\b7\u00108\u001a'\u0010<\u001a\u00020;*\u0002022\u0014\u0010:\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u00020\u000309¢\u0006\u0004\b<\u0010=\u001a!\u0010<\u001a\u00020\u0003*\u0002022\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00030>H\u0007¢\u0006\u0004\b<\u0010?\u001a\u0011\u0010@\u001a\u00020\u0003*\u000202¢\u0006\u0004\b@\u0010A\u001aI\u0010L\u001a\u00020K*\u00020B2\b\b\u0002\u0010D\u001a\u00020C2\b\b\u0002\u0010F\u001a\u00020E2\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020H\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030I\u0012\u0006\u0012\u0004\u0018\u00010J0G¢\u0006\u0004\bL\u0010M\u001aG\u0010L\u001a\u00020K*\u00020B2\b\b\u0002\u0010D\u001a\u00020C2\u0006\u0010O\u001a\u00020N2\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020H\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030I\u0012\u0006\u0012\u0004\u0018\u00010J0G¢\u0006\u0004\bL\u0010P\u001a>\u0010S\u001a\u00020\t*\u00020\u00002\b\b\u0002\u0010Q\u001a\u00020\t2\u001e\u0010:\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0RH\u0086@¢\u0006\u0004\bS\u0010T\u001a\u0014\u0010U\u001a\u00020\u0003*\u00020\u0000H\u0086@¢\u0006\u0004\bU\u0010V\u001a/\u0010X\u001a\u00020\u0003\"\u0004\b\u0000\u0010W*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000I\u0012\u0006\u0012\u0004\u0018\u00010J09H\u0000¢\u0006\u0004\bX\u0010Y\"\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\\"\u0015\u0010]\u001a\u00020E*\u0002028F¢\u0006\u0006\u001a\u0004\b]\u0010^\"\u0015\u0010_\u001a\u00020E*\u0002028F¢\u0006\u0006\u001a\u0004\b_\u0010^¨\u0006`"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "", UxipConstants.f30680s, "LY8/t;", "writeByte", "(Lio/ktor/utils/io/ByteWriteChannel;BLe9/c;)Ljava/lang/Object;", "", "writeShort", "(Lio/ktor/utils/io/ByteWriteChannel;SLe9/c;)Ljava/lang/Object;", "", "writeInt", "(Lio/ktor/utils/io/ByteWriteChannel;ILe9/c;)Ljava/lang/Object;", "", "writeFloat", "(Lio/ktor/utils/io/ByteWriteChannel;FLe9/c;)Ljava/lang/Object;", "", "writeDouble", "(Lio/ktor/utils/io/ByteWriteChannel;DLe9/c;)Ljava/lang/Object;", "", "writeLong", "(Lio/ktor/utils/io/ByteWriteChannel;JLe9/c;)Ljava/lang/Object;", "", "array", "writeByteArray", "(Lio/ktor/utils/io/ByteWriteChannel;[BLe9/c;)Ljava/lang/Object;", "Lfb/v;", "source", "writeSource", "(Lio/ktor/utils/io/ByteWriteChannel;Lfb/v;Le9/c;)Ljava/lang/Object;", "", "writeString", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "startIndex", "endIndex", "writeFully", "(Lio/ktor/utils/io/ByteWriteChannel;[BIILe9/c;)Ljava/lang/Object;", "Lfb/k;", "writeBuffer", "(Lio/ktor/utils/io/ByteWriteChannel;Lfb/k;Le9/c;)Ljava/lang/Object;", "length", "(Lio/ktor/utils/io/ByteWriteChannel;Lfb/k;JLe9/c;)Ljava/lang/Object;", "writeStringUtf8", "Lfb/a;", ChatTracker.CLICK_COPY, "writePacket", "(Lio/ktor/utils/io/ByteWriteChannel;Lfb/a;Le9/c;)Ljava/lang/Object;", "", "cause", "close", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/Throwable;)V", "Lio/ktor/utils/io/ChannelJob;", "join", "(Lio/ktor/utils/io/ChannelJob;Le9/c;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lio/ktor/utils/io/CancellationException;", "getCancellationException", "(Lio/ktor/utils/io/ChannelJob;)Ljava/util/concurrent/CancellationException;", "Lkotlin/Function1;", "block", "LUa/a0;", "invokeOnCompletion", "(Lio/ktor/utils/io/ChannelJob;Lp9/l;)LUa/a0;", "Lkotlin/Function0;", "(Lio/ktor/utils/io/ChannelJob;Lp9/a;)V", "cancel", "(Lio/ktor/utils/io/ChannelJob;)V", "LUa/M;", "Lkotlin/coroutines/d;", "coroutineContext", "", "autoFlush", "Lkotlin/Function2;", "Lio/ktor/utils/io/WriterScope;", "Le9/c;", "", "Lio/ktor/utils/io/WriterJob;", "writer", "(LUa/M;Lkotlin/coroutines/d;ZLp9/p;)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ByteChannel;", "channel", "(LUa/M;Lkotlin/coroutines/d;Lio/ktor/utils/io/ByteChannel;Lp9/p;)Lio/ktor/utils/io/WriterJob;", "desiredSpace", "Lkotlin/Function3;", "write", "(Lio/ktor/utils/io/ByteWriteChannel;ILp9/q;Le9/c;)Ljava/lang/Object;", "awaitFreeSpace", "(Lio/ktor/utils/io/ByteWriteChannel;Le9/c;)Ljava/lang/Object;", "R", "fireAndForget", "(Lp9/l;)V", "io/ktor/utils/io/ByteWriteChannelOperationsKt$NO_CALLBACK$1", "NO_CALLBACK", "Lio/ktor/utils/io/ByteWriteChannelOperationsKt$NO_CALLBACK$1;", "isCompleted", "(Lio/ktor/utils/io/ChannelJob;)Z", "isCancelled", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteWriteChannelOperationsKt {
    private static final ByteWriteChannelOperationsKt$NO_CALLBACK$1 NO_CALLBACK = new InterfaceC4014c<Object>() { // from class: io.ktor.utils.io.ByteWriteChannelOperationsKt$NO_CALLBACK$1
        private final kotlin.coroutines.d context = EmptyCoroutineContext.f34779a;

        @Override // e9.InterfaceC4014c
        public kotlin.coroutines.d getContext() {
            return this.context;
        }

        @Override // e9.InterfaceC4014c
        public void resumeWith(Object result) {
        }
    };

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteWriteChannelOperationsKt$close$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements InterfaceC5074l<InterfaceC4014c<? super t>, Object> {
        public AnonymousClass1(Object obj) {
            super(1, obj, ByteWriteChannel.class, "flushAndClose", "flushAndClose(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // p9.InterfaceC5074l
        public final Object invoke(InterfaceC4014c<? super t> interfaceC4014c) {
            return ((ByteWriteChannel) this.receiver).flushAndClose(interfaceC4014c);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteWriteChannelOperationsKt", f = "ByteWriteChannelOperations.kt", l = {230}, m = "write")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteWriteChannelOperationsKt$write$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44511 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C44511(InterfaceC4014c<? super C44511> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteWriteChannelOperationsKt.write(null, 0, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteWriteChannelOperationsKt", f = "ByteWriteChannelOperations.kt", l = {122}, m = "writePacket")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteWriteChannelOperationsKt$writePacket$2, reason: invalid class name */
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteWriteChannelOperationsKt.writePacket((ByteWriteChannel) null, (v) null, this);
        }
    }

    public static final Object awaitFreeSpace(ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objFlush = byteWriteChannel.flush(interfaceC4014c);
        return objFlush == C4063a.g() ? objFlush : t.f7040a;
    }

    public static final void cancel(ChannelJob channelJob) {
        p.i(channelJob, "<this>");
        g.Y0(channelJob.getJob(), null, 1, null);
    }

    public static final void close(ByteWriteChannel byteWriteChannel, Throwable th) {
        p.i(byteWriteChannel, "<this>");
        if (th == null) {
            fireAndForget(new AnonymousClass1(byteWriteChannel));
        } else {
            byteWriteChannel.cancel(th);
        }
    }

    public static final <R> void fireAndForget(InterfaceC5074l<? super InterfaceC4014c<? super R>, ? extends Object> interfaceC5074l) {
        p.i(interfaceC5074l, "<this>");
        C1278a.c(interfaceC5074l, NO_CALLBACK);
    }

    public static final CancellationException getCancellationException(ChannelJob channelJob) {
        p.i(channelJob, "<this>");
        return channelJob.getJob().G();
    }

    public static final InterfaceC1045a0 invokeOnCompletion(ChannelJob channelJob, InterfaceC5074l<? super Throwable, t> block) {
        p.i(channelJob, "<this>");
        p.i(block, "block");
        return channelJob.getJob().J(block);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t invokeOnCompletion$lambda$0(InterfaceC5063a interfaceC5063a, Throwable th) {
        interfaceC5063a.invoke();
        return t.f7040a;
    }

    public static final boolean isCancelled(ChannelJob channelJob) {
        p.i(channelJob, "<this>");
        return channelJob.getJob().isCancelled();
    }

    public static final boolean isCompleted(ChannelJob channelJob) {
        p.i(channelJob, "<this>");
        return channelJob.getJob().g();
    }

    public static final Object join(ChannelJob channelJob, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objT0 = channelJob.getJob().T0(interfaceC4014c);
        return objT0 == C4063a.g() ? objT0 : t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object write(io.ktor.utils.io.ByteWriteChannel r8, int r9, p9.q<? super byte[], ? super java.lang.Integer, ? super java.lang.Integer, java.lang.Integer> r10, e9.InterfaceC4014c<? super java.lang.Integer> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteWriteChannelOperationsKt.write(io.ktor.utils.io.ByteWriteChannel, int, p9.q, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object write$default(ByteWriteChannel byteWriteChannel, int i10, q qVar, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return write(byteWriteChannel, i10, qVar, interfaceC4014c);
    }

    public static final Object writeBuffer(ByteWriteChannel byteWriteChannel, InterfaceC4084k interfaceC4084k, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objWritePacket = writePacket(byteWriteChannel, C4078e.b(interfaceC4084k), interfaceC4014c);
        return objWritePacket == C4063a.g() ? objWritePacket : t.f7040a;
    }

    public static final Object writeByte(ByteWriteChannel byteWriteChannel, byte b10, InterfaceC4014c<? super t> interfaceC4014c) {
        byteWriteChannel.getWriteBuffer().H0(b10);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, interfaceC4014c);
        return objFlushIfNeeded == C4063a.g() ? objFlushIfNeeded : t.f7040a;
    }

    public static final Object writeByteArray(ByteWriteChannel byteWriteChannel, byte[] bArr, InterfaceC4014c<? super t> interfaceC4014c) {
        s.y0(byteWriteChannel.getWriteBuffer(), bArr, 0, 0, 6, null);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, interfaceC4014c);
        return objFlushIfNeeded == C4063a.g() ? objFlushIfNeeded : t.f7040a;
    }

    public static final Object writeDouble(ByteWriteChannel byteWriteChannel, double d10, InterfaceC4014c<? super t> interfaceC4014c) {
        u.a(byteWriteChannel.getWriteBuffer(), d10);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, interfaceC4014c);
        return objFlushIfNeeded == C4063a.g() ? objFlushIfNeeded : t.f7040a;
    }

    public static final Object writeFloat(ByteWriteChannel byteWriteChannel, float f10, InterfaceC4014c<? super t> interfaceC4014c) {
        u.b(byteWriteChannel.getWriteBuffer(), f10);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, interfaceC4014c);
        return objFlushIfNeeded == C4063a.g() ? objFlushIfNeeded : t.f7040a;
    }

    public static final Object writeFully(ByteWriteChannel byteWriteChannel, byte[] bArr, int i10, int i11, InterfaceC4014c<? super t> interfaceC4014c) {
        byteWriteChannel.getWriteBuffer().write(bArr, i10, i11);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, interfaceC4014c);
        return objFlushIfNeeded == C4063a.g() ? objFlushIfNeeded : t.f7040a;
    }

    public static /* synthetic */ Object writeFully$default(ByteWriteChannel byteWriteChannel, byte[] bArr, int i10, int i11, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return writeFully(byteWriteChannel, bArr, i10, i11, interfaceC4014c);
    }

    public static final Object writeInt(ByteWriteChannel byteWriteChannel, int i10, InterfaceC4014c<? super t> interfaceC4014c) {
        byteWriteChannel.getWriteBuffer().writeInt(i10);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, interfaceC4014c);
        return objFlushIfNeeded == C4063a.g() ? objFlushIfNeeded : t.f7040a;
    }

    public static final Object writeLong(ByteWriteChannel byteWriteChannel, long j10, InterfaceC4014c<? super t> interfaceC4014c) {
        byteWriteChannel.getWriteBuffer().writeLong(j10);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, interfaceC4014c);
        return objFlushIfNeeded == C4063a.g() ? objFlushIfNeeded : t.f7040a;
    }

    public static final Object writePacket(ByteWriteChannel byteWriteChannel, C4074a c4074a, InterfaceC4014c<? super t> interfaceC4014c) {
        byteWriteChannel.getWriteBuffer().m0(c4074a);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, interfaceC4014c);
        return objFlushIfNeeded == C4063a.g() ? objFlushIfNeeded : t.f7040a;
    }

    public static final Object writeShort(ByteWriteChannel byteWriteChannel, short s10, InterfaceC4014c<? super t> interfaceC4014c) {
        byteWriteChannel.getWriteBuffer().writeShort(s10);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, interfaceC4014c);
        return objFlushIfNeeded == C4063a.g() ? objFlushIfNeeded : t.f7040a;
    }

    public static final Object writeSource(ByteWriteChannel byteWriteChannel, v vVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objWritePacket = writePacket(byteWriteChannel, vVar, interfaceC4014c);
        return objWritePacket == C4063a.g() ? objWritePacket : t.f7040a;
    }

    public static final Object writeString(ByteWriteChannel byteWriteChannel, String str, InterfaceC4014c<? super t> interfaceC4014c) {
        StringsKt.writeText$default(byteWriteChannel.getWriteBuffer(), str, 0, 0, (Charset) null, 14, (Object) null);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, interfaceC4014c);
        return objFlushIfNeeded == C4063a.g() ? objFlushIfNeeded : t.f7040a;
    }

    public static final Object writeStringUtf8(ByteWriteChannel byteWriteChannel, String str, InterfaceC4014c<? super t> interfaceC4014c) {
        StringsKt.writeText$default(byteWriteChannel.getWriteBuffer(), str, 0, 0, (Charset) null, 14, (Object) null);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, interfaceC4014c);
        return objFlushIfNeeded == C4063a.g() ? objFlushIfNeeded : t.f7040a;
    }

    public static final WriterJob writer(M m10, kotlin.coroutines.d coroutineContext, boolean z10, p9.p<? super WriterScope, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        p.i(m10, "<this>");
        p.i(coroutineContext, "coroutineContext");
        p.i(block, "block");
        return writer(m10, coroutineContext, new ByteChannel(false, 1, null), block);
    }

    public static /* synthetic */ WriterJob writer$default(M m10, kotlin.coroutines.d dVar, boolean z10, p9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return writer(m10, dVar, z10, (p9.p<? super WriterScope, ? super InterfaceC4014c<? super t>, ? extends Object>) pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t writer$lambda$2$lambda$1(ByteChannel byteChannel, Throwable th) {
        if (th != null && !byteChannel.isClosedForWrite()) {
            byteChannel.cancel(th);
        }
        return t.f7040a;
    }

    public static final /* synthetic */ void invokeOnCompletion(ChannelJob channelJob, final InterfaceC5063a block) {
        p.i(channelJob, "<this>");
        p.i(block, "block");
        channelJob.getJob().J(new InterfaceC5074l() { // from class: io.ktor.utils.io.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ByteWriteChannelOperationsKt.invokeOnCompletion$lambda$0(block, (Throwable) obj);
            }
        });
    }

    public static final Object writeBuffer(ByteWriteChannel byteWriteChannel, InterfaceC4084k interfaceC4084k, long j10, InterfaceC4014c<? super t> interfaceC4014c) {
        byteWriteChannel.getWriteBuffer().t0(interfaceC4084k, j10);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, interfaceC4014c);
        return objFlushIfNeeded == C4063a.g() ? objFlushIfNeeded : t.f7040a;
    }

    public static final WriterJob writer(M m10, kotlin.coroutines.d coroutineContext, final ByteChannel channel, p9.p<? super WriterScope, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        p.i(m10, "<this>");
        p.i(coroutineContext, "coroutineContext");
        p.i(channel, "channel");
        p.i(block, "block");
        g gVarD = C1060i.d(m10, coroutineContext, null, new ByteWriteChannelOperationsKt$writer$job$1(block, channel, null), 2, null);
        gVarD.J(new InterfaceC5074l() { // from class: io.ktor.utils.io.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ByteWriteChannelOperationsKt.writer$lambda$2$lambda$1(channel, (Throwable) obj);
            }
        });
        return new WriterJob(channel, gVarD);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object writePacket(io.ktor.utils.io.ByteWriteChannel r7, fb.v r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteWriteChannelOperationsKt.AnonymousClass2
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.ByteWriteChannelOperationsKt$writePacket$2 r0 = (io.ktor.utils.io.ByteWriteChannelOperationsKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteWriteChannelOperationsKt$writePacket$2 r0 = new io.ktor.utils.io.ByteWriteChannelOperationsKt$writePacket$2
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            fb.v r7 = (fb.v) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r8 = (io.ktor.utils.io.ByteWriteChannel) r8
            kotlin.C4849c.b(r9)
            r6 = r8
            r8 = r7
            r7 = r6
            goto L3f
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            kotlin.C4849c.b(r9)
        L3f:
            boolean r9 = r8.k()
            if (r9 != 0) goto L5d
            fb.s r9 = r7.getWriteBuffer()
            long r4 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r8)
            r9.t0(r8, r4)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = io.ktor.utils.io.ByteWriteChannelKt.flushIfNeeded(r7, r0)
            if (r9 != r1) goto L3f
            return r1
        L5d:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteWriteChannelOperationsKt.writePacket(io.ktor.utils.io.ByteWriteChannel, fb.v, e9.c):java.lang.Object");
    }

    public static /* synthetic */ WriterJob writer$default(M m10, kotlin.coroutines.d dVar, ByteChannel byteChannel, p9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        return writer(m10, dVar, byteChannel, (p9.p<? super WriterScope, ? super InterfaceC4014c<? super t>, ? extends Object>) pVar);
    }
}
