package io.ktor.utils.io;

import Ua.C1060i;
import Ua.M;
import Y8.t;
import com.stepos.ailauncher.chat.wake.circle.F;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.zyql.ai.selector.camera.CustomCameraView;
import e9.InterfaceC4014c;
import f9.C4063a;
import fb.C4074a;
import fb.o;
import g9.InterfaceC4112d;
import gb.C4114a;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import java.io.EOFException;
import java.io.IOException;
import kb.C4845d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;
import p9.InterfaceC5074l;
import p9.r;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u0000H\u0086@¢\u0006\u0004\b\t\u0010\u0003\u001a\u0014\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u0014\u0010\r\u001a\u00020\f*\u00020\u0000H\u0086@¢\u0006\u0004\b\r\u0010\u0003\u001a\u0014\u0010\u000f\u001a\u00020\u000e*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000f\u0010\u0003\u001a\u0014\u0010\u0011\u001a\u00020\u0010*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0011\u0010\u0003\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0014\u0010\u0017\u001a\u00020\u0016*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0017\u0010\u0003\u001a\u001c\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0017\u0010\u0015\u001a\u001c\u0010\u001b\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b\u001b\u0010\u001c\u001a \u0010\u001e\u001a\u0004\u0018\u00010\u001d*\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u001e\u0010\u0015\u001a\u001c\u0010\u001f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b\u001f\u0010\u001c\u001a$\u0010\u001f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u001f\u0010!\u001a\u001c\u0010#\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\"\u001a\u00020\nH\u0086@¢\u0006\u0004\b#\u0010\u0015\u001a\u0014\u0010%\u001a\u00020$*\u00020\u0000H\u0086@¢\u0006\u0004\b%\u0010\u0003\u001a\u001c\u0010%\u001a\u00020$*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b%\u0010&\u001a0\u0010*\u001a\u00020\n*\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\n2\b\b\u0002\u0010)\u001a\u00020\nH\u0086@¢\u0006\u0004\b*\u0010+\u001a-\u0010*\u001a\u00020\n*\u00020\u00002\u0006\u0010,\u001a\u00020\n2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0-¢\u0006\u0004\b*\u0010/\u001aI\u00109\u001a\u000208*\u0002002\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u00020\u00012\"\u0010.\u001a\u001e\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001306\u0012\u0006\u0012\u0004\u0018\u00010704¢\u0006\u0004\b9\u0010:\u001aE\u00109\u001a\u000208*\u0002002\u0006\u00102\u001a\u0002012\u0006\u0010\u001a\u001a\u00020;2\"\u0010.\u001a\u001e\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001306\u0012\u0006\u0012\u0004\u0018\u00010704¢\u0006\u0004\b9\u0010<\u001a\u001c\u0010>\u001a\u00020$*\u00020\u00002\u0006\u0010=\u001a\u00020\nH\u0086@¢\u0006\u0004\b>\u0010\u0015\u001a\u001c\u0010@\u001a\u00020\u0013*\u00020\u00002\u0006\u0010?\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b@\u0010&\u001a\u001e\u0010A\u001a\u00020\u000e*\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u000eH\u0086@¢\u0006\u0004\bA\u0010&\u001a*\u0010E\u001a\u00020\u0001*\u00020\u00002\n\u0010D\u001a\u00060Bj\u0002`C2\b\b\u0002\u0010\u0018\u001a\u00020\nH\u0086@¢\u0006\u0004\bE\u0010F\u001a4\u0010E\u001a\u00020\u0001*\u00020\u00002\n\u0010D\u001a\u00060Bj\u0002`C2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010H\u001a\u00020GH\u0087@¢\u0006\u0004\bI\u0010J\u001aF\u0010L\u001a\u00020\n*\u00020\u000020\b\u0004\u0010.\u001a*\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n06\u0012\u0006\u0012\u0004\u0018\u0001070KH\u0086H¢\u0006\u0004\bL\u0010M\u001a0\u0010P\u001a\u00020\u0013*\u00020\u00002\u0006\u0010D\u001a\u00020\u00042\b\b\u0002\u0010N\u001a\u00020\n2\b\b\u0002\u0010O\u001a\u00020\nH\u0086@¢\u0006\u0004\bP\u0010+\u001a\u0013\u0010Q\u001a\u00020\u0013*\u00020\u0000H\u0007¢\u0006\u0004\bQ\u0010R\u001a\u0013\u0010Q\u001a\u00020\u0013*\u00020\u0019H\u0007¢\u0006\u0004\bQ\u0010S\u001a\u0013\u0010Q\u001a\u00020\u0013*\u00020;H\u0007¢\u0006\u0004\bQ\u0010T\u001a8\u0010Y\u001a\u00020\u000e*\u00020\u00002\u0006\u0010V\u001a\u00020U2\u0006\u0010W\u001a\u00020\u00192\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010X\u001a\u00020\u0001H\u0086@¢\u0006\u0004\bY\u0010Z\u001a\u001c\u0010\\\u001a\u00020\u0001*\u00020\u00002\u0006\u0010[\u001a\u00020UH\u0086@¢\u0006\u0004\b\\\u0010]\u001a\u001e\u0010^\u001a\u0004\u0018\u00010U*\u00020\u00002\u0006\u0010\"\u001a\u00020\nH\u0086@¢\u0006\u0004\b^\u0010\u0015\"\u0014\u0010_\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b_\u0010`\"\u0014\u0010a\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\ba\u0010`\"\u001b\u0010e\u001a\u00020\n*\u00020\u00198F¢\u0006\f\u0012\u0004\bd\u0010S\u001a\u0004\bb\u0010c\"\u001b\u0010i\u001a\u00020\n*\u00020\u00008F¢\u0006\f\u0012\u0004\bh\u0010R\u001a\u0004\bf\u0010g¨\u0006j"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "exhausted", "(Lio/ktor/utils/io/ByteReadChannel;Le9/c;)Ljava/lang/Object;", "", "toByteArray", "", "readByte", "", "readShort", "", "readInt", "", "readFloat", "", "readLong", "", "readDouble", "numberOfBytes", "LY8/t;", "awaitUntilReadable", "(Lio/ktor/utils/io/ByteReadChannel;ILe9/c;)Ljava/lang/Object;", "Lfb/a;", "readBuffer", "max", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "copyAndClose", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Le9/c;)Ljava/lang/Object;", "", "readUTF8Line", "copyTo", "limit", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLe9/c;)Ljava/lang/Object;", "count", "readByteArray", "Lfb/v;", "readRemaining", "(Lio/ktor/utils/io/ByteReadChannel;JLe9/c;)Ljava/lang/Object;", "buffer", "offset", "length", "readAvailable", "(Lio/ktor/utils/io/ByteReadChannel;[BIILe9/c;)Ljava/lang/Object;", "min", "Lkotlin/Function1;", "block", "(Lio/ktor/utils/io/ByteReadChannel;ILp9/l;)I", "LUa/M;", "Lkotlin/coroutines/d;", "coroutineContext", "autoFlush", "Lkotlin/Function2;", "Lio/ktor/utils/io/ReaderScope;", "Le9/c;", "", "Lio/ktor/utils/io/ReaderJob;", "reader", "(LUa/M;Lkotlin/coroutines/d;ZLp9/p;)Lio/ktor/utils/io/ReaderJob;", "Lio/ktor/utils/io/ByteChannel;", "(LUa/M;Lkotlin/coroutines/d;Lio/ktor/utils/io/ByteChannel;Lp9/p;)Lio/ktor/utils/io/ReaderJob;", "packet", "readPacket", UxipConstants.f30680s, "discardExact", "discard", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "readUTF8LineTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;ILe9/c;)Ljava/lang/Object;", "Lio/ktor/utils/io/LineEndingMode;", "lineEnding", "readUTF8LineTo-RRvyBJ8", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;IILe9/c;)Ljava/lang/Object;", "Lkotlin/Function4;", "read", "(Lio/ktor/utils/io/ByteReadChannel;Lp9/r;Le9/c;)Ljava/lang/Object;", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "readFully", "rethrowCloseCauseIfNeeded", "(Lio/ktor/utils/io/ByteReadChannel;)V", "(Lio/ktor/utils/io/ByteWriteChannel;)V", "(Lio/ktor/utils/io/ByteChannel;)V", "Lgb/a;", "matchString", "writeChannel", "ignoreMissing", "readUntil", "(Lio/ktor/utils/io/ByteReadChannel;Lgb/a;Lio/ktor/utils/io/ByteWriteChannel;JZLe9/c;)Ljava/lang/Object;", "byteString", "skipIfFound", "(Lio/ktor/utils/io/ByteReadChannel;Lgb/a;Le9/c;)Ljava/lang/Object;", "peek", "CR", "B", "LF", "getAvailableForWrite", "(Lio/ktor/utils/io/ByteWriteChannel;)I", "getAvailableForWrite$annotations", "availableForWrite", "getAvailableForRead", "(Lio/ktor/utils/io/ByteReadChannel;)I", "getAvailableForRead$annotations", "availableForRead", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteReadChannelOperationsKt {
    private static final byte CR = 13;
    private static final byte LF = 10;

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {92}, m = "awaitUntilReadable")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$awaitUntilReadable$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return ByteReadChannelOperationsKt.awaitUntilReadable(null, 0, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {132, 133, 142, 142}, m = "copyAndClose")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$copyAndClose$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44231 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C44231(InterfaceC4014c<? super C44231> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.copyAndClose(null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {171, DidiCardView.FINISHED_TITLE_TRAILING_WIDTH_DP, 179, 179}, m = "copyTo")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$copyTo$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44241 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C44241(InterfaceC4014c<? super C44241> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.copyTo(null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {F.GESTURE_WIDTH_DP, 194, 201, 201}, m = "copyTo")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$copyTo$2, reason: invalid class name */
    public static final class AnonymousClass2 extends ContinuationImpl {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.copyTo(null, null, 0L, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {393}, m = "discard")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$discard$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44251 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44251(InterfaceC4014c<? super C44251> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.discard(null, 0L, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {385}, m = "discardExact")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$discardExact$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44261 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44261(InterfaceC4014c<? super C44261> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.discardExact(null, 0L, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {34}, m = "exhausted")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$exhausted$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44271 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44271(InterfaceC4014c<? super C44271> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.exhausted(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {618}, m = "peek")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$peek$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44281 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44281(InterfaceC4014c<? super C44281> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.peek(null, 0, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {499, 504}, m = "read")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$read$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44291 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C44291(InterfaceC4014c<? super C44291> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.read(null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {CustomCameraView.BUTTON_STATE_BOTH}, m = "readAvailable")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readAvailable$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44301 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C44301(InterfaceC4014c<? super C44301> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readAvailable(null, null, 0, 0, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {102}, m = "readBuffer")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44311 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C44311(InterfaceC4014c<? super C44311> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readBuffer(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {116}, m = "readBuffer")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$3, reason: invalid class name */
    public static final class AnonymousClass3 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readBuffer(null, 0, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {45}, m = "readByte")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readByte$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44321 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C44321(InterfaceC4014c<? super C44321> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readByte(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {209}, m = "readByteArray")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44331 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C44331(InterfaceC4014c<? super C44331> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readByteArray(null, 0, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {87}, m = "readDouble")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readDouble$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44341 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44341(InterfaceC4014c<? super C44341> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readDouble(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {70}, m = "readFloat")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readFloat$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44351 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44351(InterfaceC4014c<? super C44351> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readFloat(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {533}, m = "readFully")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44361 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C44361(InterfaceC4014c<? super C44361> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readFully(null, null, 0, 0, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {59}, m = "readInt")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readInt$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44371 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44371(InterfaceC4014c<? super C44371> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readInt(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {76}, m = "readLong")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readLong$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44381 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44381(InterfaceC4014c<? super C44381> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readLong(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {368}, m = "readPacket")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readPacket$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44391 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C44391(InterfaceC4014c<? super C44391> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readPacket(null, 0, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {219}, m = "readRemaining")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44401 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C44401(InterfaceC4014c<? super C44401> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readRemaining(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {239}, m = "readRemaining")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$2, reason: invalid class name and case insensitive filesystem */
    public static final class C44412 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C44412(InterfaceC4014c<? super C44412> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readRemaining(null, 0L, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {53}, m = "readShort")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readShort$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44421 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44421(InterfaceC4014c<? super C44421> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readShort(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {161}, m = "readUTF8Line")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8Line$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44431 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C44431(InterfaceC4014c<? super C44431> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readUTF8Line(null, 0, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {446, 461, 485}, m = "readUTF8LineTo-RRvyBJ8")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8LineTo$2, reason: invalid class name and case insensitive filesystem */
    public static final class C44442 extends ContinuationImpl {
        byte B$0;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C44442(InterfaceC4014c<? super C44442> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.m200readUTF8LineToRRvyBJ8(null, null, 0, 0, this);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY8/t;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt$reader$1", f = "ByteReadChannelOperations.kt", l = {353}, m = "invokeSuspend")
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$reader$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44451 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ g $job;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C44451(g gVar, InterfaceC4014c<? super C44451> interfaceC4014c) {
            super(1, interfaceC4014c);
            this.$job = gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
            return new C44451(this.$job, interfaceC4014c);
        }

        @Override // p9.InterfaceC5074l
        public final Object invoke(InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C44451) create(interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                g gVar = this.$job;
                this.label = 1;
                if (gVar.T0(this) == objG) {
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

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {598, 599}, m = "skipIfFound")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$skipIfFound$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C44461(InterfaceC4014c<? super C44461> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.skipIfFound(null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {39}, m = "toByteArray")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$toByteArray$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44471 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44471(InterfaceC4014c<? super C44471> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.toByteArray(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object awaitUntilReadable(io.ktor.utils.io.ByteReadChannel r4, int r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteReadChannelOperationsKt$awaitUntilReadable$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$awaitUntilReadable$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$awaitUntilReadable$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.C4849c.b(r6)
            goto L49
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r6)
            java.lang.Object r6 = g9.h.a(r4)
            r0.L$0 = r6
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitContent(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r4 = r6.booleanValue()
            if (r4 == 0) goto L54
            Y8.t r4 = Y8.t.f7040a
            return r4
        L54:
            java.io.EOFException r4 = new java.io.EOFException
            java.lang.String r5 = "Not enough data available"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.awaitUntilReadable(io.ktor.utils.io.ByteReadChannel, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b2, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.awaitContent$default(r7, 0, r0, 1, null) != r1) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084 A[Catch: all -> 0x00b5, TRY_LEAVE, TryCatch #0 {all -> 0x00b5, blocks: (B:27:0x007e, B:29:0x0084, B:38:0x00bb, B:46:0x00de), top: B:55:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bb A[Catch: all -> 0x00b5, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00b5, blocks: (B:27:0x007e, B:29:0x0084, B:38:0x00bb, B:46:0x00de), top: B:55:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r13v0, types: [io.ktor.utils.io.ByteReadChannel] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v2, types: [long] */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v5, types: [long] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00b2 -> B:20:0x0063). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyAndClose(io.ktor.utils.io.ByteReadChannel r13, io.ktor.utils.io.ByteWriteChannel r14, e9.InterfaceC4014c<? super java.lang.Long> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.copyAndClose(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b2, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.awaitContent$default(r7, 0, r0, 1, null) != r1) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084 A[Catch: all -> 0x00b5, TRY_LEAVE, TryCatch #0 {all -> 0x00b5, blocks: (B:27:0x007e, B:29:0x0084), top: B:52:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r13v0, types: [io.ktor.utils.io.ByteReadChannel] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v2, types: [long] */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v5, types: [long] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00b2 -> B:20:0x0063). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyTo(io.ktor.utils.io.ByteReadChannel r13, io.ktor.utils.io.ByteWriteChannel r14, e9.InterfaceC4014c<? super java.lang.Long> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.copyTo(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004d -> B:26:0x0066). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0060 -> B:25:0x0063). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object discard(io.ktor.utils.io.ByteReadChannel r10, long r11, e9.InterfaceC4014c<? super java.lang.Long> r13) throws java.lang.Throwable {
        /*
            boolean r0 = r13 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44251
            if (r0 == 0) goto L13
            r0 = r13
            io.ktor.utils.io.ByteReadChannelOperationsKt$discard$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44251) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$discard$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$discard$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            long r10 = r0.J$1
            long r4 = r0.J$0
            java.lang.Object r12 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r12 = (io.ktor.utils.io.ByteReadChannel) r12
            kotlin.C4849c.b(r13)
            goto L63
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L39:
            kotlin.C4849c.b(r13)
            r4 = r11
        L3d:
            r6 = 0
            int r13 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r13 <= 0) goto L7b
            boolean r13 = r10.isClosedForRead()
            if (r13 != 0) goto L7b
            int r13 = getAvailableForRead(r10)
            if (r13 != 0) goto L66
            r0.L$0 = r10
            r0.J$0 = r4
            r0.J$1 = r11
            r0.label = r3
            r13 = 0
            r2 = 0
            java.lang.Object r13 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r10, r13, r0, r3, r2)
            if (r13 != r1) goto L60
            return r1
        L60:
            r8 = r11
            r12 = r10
            r10 = r8
        L63:
            r8 = r10
            r10 = r12
            r11 = r8
        L66:
            fb.v r13 = r10.getReadBuffer()
            long r6 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r13)
            long r6 = java.lang.Math.min(r11, r6)
            fb.v r13 = r10.getReadBuffer()
            io.ktor.utils.io.core.ByteReadPacketKt.discard(r13, r6)
            long r11 = r11 - r6
            goto L3d
        L7b:
            long r4 = r4 - r11
            java.lang.Long r10 = g9.C4109a.g(r4)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.discard(io.ktor.utils.io.ByteReadChannel, long, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object discard$default(ByteReadChannel byteReadChannel, long j10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return discard(byteReadChannel, j10, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object discardExact(io.ktor.utils.io.ByteReadChannel r4, long r5, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44261
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteReadChannelOperationsKt$discardExact$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44261) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$discardExact$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$discardExact$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            long r5 = r0.J$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.C4849c.b(r7)
            goto L4b
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.C4849c.b(r7)
            java.lang.Object r7 = g9.h.a(r4)
            r0.L$0 = r7
            r0.J$0 = r5
            r0.label = r3
            java.lang.Object r7 = discard(r4, r5, r0)
            if (r7 != r1) goto L4b
            return r1
        L4b:
            java.lang.Number r7 = (java.lang.Number) r7
            long r0 = r7.longValue()
            int r4 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r4 < 0) goto L58
            Y8.t r4 = Y8.t.f7040a
            return r4
        L58:
            java.io.EOFException r4 = new java.io.EOFException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Unable to discard "
            r7.append(r0)
            r7.append(r5)
            java.lang.String r5 = " bytes"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.discardExact(io.ktor.utils.io.ByteReadChannel, long, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object exhausted(io.ktor.utils.io.ByteReadChannel r4, e9.InterfaceC4014c<? super java.lang.Boolean> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44271
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.utils.io.ByteReadChannelOperationsKt$exhausted$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44271) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$exhausted$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$exhausted$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.C4849c.b(r5)
            goto L4f
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r5)
            fb.v r5 = r4.getReadBuffer()
            boolean r5 = r5.k()
            if (r5 == 0) goto L4f
            r0.L$0 = r4
            r0.label = r3
            r5 = 0
            r2 = 0
            java.lang.Object r5 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r4, r5, r0, r3, r2)
            if (r5 != r1) goto L4f
            return r1
        L4f:
            fb.v r4 = r4.getReadBuffer()
            boolean r4 = r4.k()
            java.lang.Boolean r4 = g9.C4109a.a(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.exhausted(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    public static final int getAvailableForRead(ByteReadChannel byteReadChannel) {
        p.i(byteReadChannel, "<this>");
        return (int) byteReadChannel.getReadBuffer().getBufferField().n();
    }

    public static /* synthetic */ void getAvailableForRead$annotations(ByteReadChannel byteReadChannel) {
    }

    public static final int getAvailableForWrite(ByteWriteChannel byteWriteChannel) {
        p.i(byteWriteChannel, "<this>");
        return 1048576 - BytePacketBuilderKt.getSize(byteWriteChannel.getWriteBuffer());
    }

    public static /* synthetic */ void getAvailableForWrite$annotations(ByteWriteChannel byteWriteChannel) {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object peek(io.ktor.utils.io.ByteReadChannel r5, int r6, e9.InterfaceC4014c<? super gb.C4114a> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44281
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteReadChannelOperationsKt$peek$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44281) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$peek$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$peek$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            int r6 = r0.I$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r5 = (io.ktor.utils.io.ByteReadChannel) r5
            kotlin.C4849c.b(r7)
            goto L4f
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.C4849c.b(r7)
            boolean r7 = r5.isClosedForRead()
            if (r7 == 0) goto L42
            return r3
        L42:
            r0.L$0 = r5
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitContent(r6, r0)
            if (r7 != r1) goto L4f
            return r1
        L4f:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L58
            return r3
        L58:
            fb.v r5 = r5.getReadBuffer()
            fb.v r5 = r5.peek()
            gb.a r5 = fb.C4077d.b(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.peek(io.ktor.utils.io.ByteReadChannel, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0093, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.awaitContent$default(r0, 0, r2, 1, null) == r3) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object read(io.ktor.utils.io.ByteReadChannel r16, p9.r<? super byte[], ? super java.lang.Integer, ? super java.lang.Integer, ? super e9.InterfaceC4014c<? super java.lang.Integer>, ? extends java.lang.Object> r17, e9.InterfaceC4014c<? super java.lang.Integer> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.read(io.ktor.utils.io.ByteReadChannel, p9.r, e9.c):java.lang.Object");
    }

    private static final Object read$$forInline(ByteReadChannel byteReadChannel, r<? super byte[], ? super Integer, ? super Integer, ? super InterfaceC4014c<? super Integer>, ? extends Object> rVar, InterfaceC4014c<? super Integer> interfaceC4014c) throws EOFException {
        if (byteReadChannel.isClosedForRead()) {
            return -1;
        }
        if (byteReadChannel.getReadBuffer().k()) {
            n.c(0);
            ByteReadChannel.awaitContent$default(byteReadChannel, 0, interfaceC4014c, 1, null);
            n.c(1);
        }
        if (byteReadChannel.isClosedForRead()) {
            return -1;
        }
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        C4845d c4845d = C4845d.f34666a;
        C4074a c4074aA = byteReadChannel.getReadBuffer().getBufferField();
        if (c4074aA.k()) {
            throw new IllegalArgumentException("Buffer is empty");
        }
        o head = c4074aA.getHead();
        p.f(head);
        byte[] bArrB = head.b(true);
        Integer numValueOf = Integer.valueOf(head.getPos());
        int iIntValue = Integer.valueOf(head.getLimit()).intValue();
        Integer numValueOf2 = Integer.valueOf(numValueOf.intValue());
        Integer numValueOf3 = Integer.valueOf(iIntValue);
        n.c(3);
        int iIntValue2 = ((Number) rVar.invoke(bArrB, numValueOf2, numValueOf3, null)).intValue();
        ref$IntRef.f34818a = iIntValue2;
        int iIntValue3 = Integer.valueOf(iIntValue2).intValue();
        if (iIntValue3 != 0) {
            if (iIntValue3 < 0) {
                throw new IllegalStateException("Returned negative read bytes count");
            }
            if (iIntValue3 > head.j()) {
                throw new IllegalStateException("Returned too many bytes");
            }
            c4074aA.skip(iIntValue3);
        }
        return Integer.valueOf(ref$IntRef.f34818a);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readAvailable(io.ktor.utils.io.ByteReadChannel r5, byte[] r6, int r7, int r8, e9.InterfaceC4014c<? super java.lang.Integer> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44301
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.ByteReadChannelOperationsKt$readAvailable$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44301) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readAvailable$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readAvailable$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = -1
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 != r4) goto L37
            int r8 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r5 = r0.L$1
            r6 = r5
            byte[] r6 = (byte[]) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r5 = (io.ktor.utils.io.ByteReadChannel) r5
            kotlin.C4849c.b(r9)
            goto L6a
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.C4849c.b(r9)
            boolean r9 = r5.isClosedForRead()
            if (r9 == 0) goto L4d
            java.lang.Integer r5 = g9.C4109a.f(r3)
            return r5
        L4d:
            fb.v r9 = r5.getReadBuffer()
            boolean r9 = r9.k()
            if (r9 == 0) goto L6a
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r4
            r9 = 0
            r2 = 0
            java.lang.Object r9 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r5, r9, r0, r4, r2)
            if (r9 != r1) goto L6a
            return r1
        L6a:
            boolean r9 = r5.isClosedForRead()
            if (r9 == 0) goto L75
            java.lang.Integer r5 = g9.C4109a.f(r3)
            return r5
        L75:
            fb.v r5 = r5.getReadBuffer()
            int r5 = io.ktor.utils.io.core.InputKt.readAvailable(r5, r6, r7, r8)
            java.lang.Integer r5 = g9.C4109a.f(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readAvailable(io.ktor.utils.io.ByteReadChannel, byte[], int, int, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object readAvailable$default(ByteReadChannel byteReadChannel, byte[] bArr, int i10, int i11, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        return readAvailable(byteReadChannel, bArr, i10, i11, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readBuffer(io.ktor.utils.io.ByteReadChannel r5, e9.InterfaceC4014c<? super fb.C4074a> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44311
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44311) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r5 = r0.L$1
            fb.a r5 = (fb.C4074a) r5
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            kotlin.C4849c.b(r6)
            r6 = r5
            r5 = r2
            goto L43
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.C4849c.b(r6)
            fb.a r6 = new fb.a
            r6.<init>()
        L43:
            boolean r2 = r5.isClosedForRead()
            if (r2 != 0) goto L5f
            fb.v r2 = r5.getReadBuffer()
            r6.m0(r2)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            r2 = 0
            r4 = 0
            java.lang.Object r2 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r5, r2, r0, r3, r4)
            if (r2 != r1) goto L43
            return r1
        L5f:
            java.lang.Throwable r5 = r5.getClosedCause()
            if (r5 != 0) goto L66
            return r6
        L66:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readBuffer(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readByte(io.ktor.utils.io.ByteReadChannel r6, e9.InterfaceC4014c<? super java.lang.Byte> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44321
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteReadChannelOperationsKt$readByte$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44321) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readByte$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readByte$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$1
            fb.v r6 = (fb.v) r6
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r0 = (io.ktor.utils.io.ByteReadChannel) r0
            kotlin.C4849c.b(r7)
            goto L5c
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.C4849c.b(r7)
            fb.v r7 = r6.getReadBuffer()
            boolean r2 = r7.k()
            if (r2 == 0) goto L6e
            java.lang.Object r2 = g9.h.a(r6)
            r0.L$0 = r2
            r0.L$1 = r7
            r0.label = r3
            r2 = 0
            r4 = 0
            java.lang.Object r6 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r6, r2, r0, r3, r4)
            if (r6 != r1) goto L59
            return r1
        L59:
            r5 = r7
            r7 = r6
            r6 = r5
        L5c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L66
            r7 = r6
            goto L6e
        L66:
            java.io.EOFException r6 = new java.io.EOFException
            java.lang.String r7 = "Not enough data available"
            r6.<init>(r7)
            throw r6
        L6e:
            byte r6 = r7.readByte()
            java.lang.Byte r6 = g9.C4109a.b(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readByte(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v6, types: [fb.s] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0079 -> B:12:0x0042). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readByteArray(io.ktor.utils.io.ByteReadChannel r8, int r9, e9.InterfaceC4014c<? super byte[]> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44331
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44331) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L4c
            if (r2 != r3) goto L44
            int r8 = r0.I$2
            int r9 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$2
            fb.s r4 = (fb.s) r4
            java.lang.Object r5 = r0.L$1
            fb.a r5 = (fb.C4074a) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            kotlin.C4849c.b(r10)
            r7 = r4
            r4 = r8
            r8 = r6
            r6 = r5
            r5 = r7
            r7 = r0
            r0 = r9
            r9 = r2
        L42:
            r2 = r7
            goto L80
        L44:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L4c:
            kotlin.C4849c.b(r10)
            fb.a r10 = new fb.a
            r10.<init>()
            r2 = 0
            r4 = r10
            r5 = r4
            r10 = r2
        L58:
            int r6 = io.ktor.utils.io.core.BytePacketBuilderKt.getSize(r4)
            if (r6 >= r9) goto L8b
            int r6 = io.ktor.utils.io.core.BytePacketBuilderKt.getSize(r4)
            int r6 = r9 - r6
            r0.L$0 = r8
            r0.L$1 = r5
            r0.L$2 = r4
            r0.I$0 = r9
            r0.I$1 = r10
            r0.I$2 = r2
            r0.label = r3
            java.lang.Object r6 = readPacket(r8, r6, r0)
            if (r6 != r1) goto L79
            return r1
        L79:
            r7 = r0
            r0 = r10
            r10 = r6
            r6 = r5
            r5 = r4
            r4 = r2
            goto L42
        L80:
            fb.v r10 = (fb.v) r10
            io.ktor.utils.io.core.BytePacketBuilderKt.writePacket(r5, r10)
            r10 = r0
            r0 = r2
            r2 = r4
            r4 = r5
            r5 = r6
            goto L58
        L8b:
            byte[] r8 = fb.x.c(r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readByteArray(io.ktor.utils.io.ByteReadChannel, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readDouble(io.ktor.utils.io.ByteReadChannel r4, e9.InterfaceC4014c<? super java.lang.Double> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44341
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.utils.io.ByteReadChannelOperationsKt$readDouble$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44341) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readDouble$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readDouble$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.C4849c.b(r5)
            goto L45
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r5)
            r0.L$0 = r4
            r0.label = r3
            r5 = 8
            java.lang.Object r5 = awaitUntilReadable(r4, r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            fb.v r4 = r4.getReadBuffer()
            double r4 = fb.x.f(r4)
            java.lang.Double r4 = g9.C4109a.d(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readDouble(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readFloat(io.ktor.utils.io.ByteReadChannel r4, e9.InterfaceC4014c<? super java.lang.Float> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44351
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.utils.io.ByteReadChannelOperationsKt$readFloat$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44351) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readFloat$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readFloat$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.C4849c.b(r5)
            goto L44
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r5)
            r0.L$0 = r4
            r0.label = r3
            r5 = 4
            java.lang.Object r5 = awaitUntilReadable(r4, r5, r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            fb.v r4 = r4.getReadBuffer()
            float r4 = fb.x.g(r4)
            java.lang.Float r4 = g9.C4109a.e(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readFloat(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005f -> B:30:0x0080). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0076 -> B:29:0x007b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readFully(io.ktor.utils.io.ByteReadChannel r7, byte[] r8, int r9, int r10, e9.InterfaceC4014c<? super Y8.t> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44361
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44361) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            java.lang.String r3 = "Channel is already closed"
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 != r4) goto L39
            int r7 = r0.I$2
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$1
            byte[] r10 = (byte[]) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            kotlin.C4849c.b(r11)
            goto L7b
        L39:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L41:
            kotlin.C4849c.b(r11)
            if (r10 <= r9) goto L53
            boolean r11 = r7.isClosedForRead()
            if (r11 != 0) goto L4d
            goto L53
        L4d:
            java.io.EOFException r7 = new java.io.EOFException
            r7.<init>(r3)
            throw r7
        L53:
            r11 = r10
            r10 = r9
        L55:
            if (r9 >= r11) goto La5
            fb.v r2 = r7.getReadBuffer()
            boolean r2 = r2.k()
            if (r2 == 0) goto L80
            r0.L$0 = r7
            r0.L$1 = r8
            r0.I$0 = r10
            r0.I$1 = r11
            r0.I$2 = r9
            r0.label = r4
            r2 = 0
            r5 = 0
            java.lang.Object r2 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r7, r2, r0, r4, r5)
            if (r2 != r1) goto L76
            return r1
        L76:
            r2 = r7
            r7 = r9
            r9 = r10
            r10 = r8
            r8 = r11
        L7b:
            r11 = r8
            r8 = r10
            r10 = r9
            r9 = r7
            r7 = r2
        L80:
            boolean r2 = r7.isClosedForRead()
            if (r2 != 0) goto L9f
            int r2 = r11 - r9
            fb.v r5 = r7.getReadBuffer()
            long r5 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r5)
            int r5 = (int) r5
            int r2 = java.lang.Math.min(r2, r5)
            fb.v r5 = r7.getReadBuffer()
            int r2 = r2 + r9
            fb.x.i(r5, r8, r9, r2)
            r9 = r2
            goto L55
        L9f:
            java.io.EOFException r7 = new java.io.EOFException
            r7.<init>(r3)
            throw r7
        La5:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readFully(io.ktor.utils.io.ByteReadChannel, byte[], int, int, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object readFully$default(ByteReadChannel byteReadChannel, byte[] bArr, int i10, int i11, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return readFully(byteReadChannel, bArr, i10, i11, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readInt(io.ktor.utils.io.ByteReadChannel r4, e9.InterfaceC4014c<? super java.lang.Integer> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44371
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.utils.io.ByteReadChannelOperationsKt$readInt$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44371) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readInt$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readInt$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.C4849c.b(r5)
            goto L44
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r5)
            r0.L$0 = r4
            r0.label = r3
            r5 = 4
            java.lang.Object r5 = awaitUntilReadable(r4, r5, r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            fb.v r4 = r4.getReadBuffer()
            int r4 = r4.readInt()
            java.lang.Integer r4 = g9.C4109a.f(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readInt(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readLong(io.ktor.utils.io.ByteReadChannel r4, e9.InterfaceC4014c<? super java.lang.Long> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44381
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.utils.io.ByteReadChannelOperationsKt$readLong$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44381) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readLong$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readLong$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.C4849c.b(r5)
            goto L45
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r5)
            r0.L$0 = r4
            r0.label = r3
            r5 = 8
            java.lang.Object r5 = awaitUntilReadable(r4, r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            fb.v r4 = r4.getReadBuffer()
            long r4 = r4.readLong()
            java.lang.Long r4 = g9.C4109a.g(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readLong(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0057 -> B:24:0x006e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006a -> B:23:0x006c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readPacket(io.ktor.utils.io.ByteReadChannel r11, int r12, e9.InterfaceC4014c<? super fb.v> r13) throws java.lang.Throwable {
        /*
            boolean r0 = r13 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44391
            if (r0 == 0) goto L13
            r0 = r13
            io.ktor.utils.io.ByteReadChannelOperationsKt$readPacket$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44391) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readPacket$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readPacket$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            int r11 = r0.I$0
            java.lang.Object r12 = r0.L$1
            fb.a r12 = (fb.C4074a) r12
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            kotlin.C4849c.b(r13)
            goto L6c
        L33:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3b:
            kotlin.C4849c.b(r13)
            fb.a r13 = new fb.a
            r13.<init>()
            r10 = r13
            r13 = r12
            r12 = r10
        L46:
            long r4 = r12.n()
            long r6 = (long) r13
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto La0
            fb.v r2 = r11.getReadBuffer()
            boolean r2 = r2.k()
            if (r2 == 0) goto L6e
            r0.L$0 = r11
            r0.L$1 = r12
            r0.I$0 = r13
            r0.label = r3
            r2 = 0
            r4 = 0
            java.lang.Object r2 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r11, r2, r0, r3, r4)
            if (r2 != r1) goto L6a
            return r1
        L6a:
            r2 = r11
            r11 = r13
        L6c:
            r13 = r11
            r11 = r2
        L6e:
            boolean r2 = r11.isClosedForRead()
            if (r2 != 0) goto La0
            fb.v r2 = r11.getReadBuffer()
            long r4 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r2)
            long r6 = (long) r13
            long r8 = r12.n()
            long r8 = r6 - r8
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 <= 0) goto L94
            fb.v r2 = r11.getReadBuffer()
            long r4 = r12.n()
            long r6 = r6 - r4
            r2.E0(r12, r6)
            goto L46
        L94:
            fb.v r2 = r11.getReadBuffer()
            long r4 = r2.B(r12)
            g9.C4109a.g(r4)
            goto L46
        La0:
            long r0 = r12.n()
            long r2 = (long) r13
            int r11 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r11 < 0) goto Laa
            return r12
        Laa:
            java.io.EOFException r11 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Not enough data available, required "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = " bytes but only "
            r0.append(r13)
            long r12 = r12.n()
            r0.append(r12)
            java.lang.String r12 = " available"
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readPacket(io.ktor.utils.io.ByteReadChannel, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readRemaining(io.ktor.utils.io.ByteReadChannel r5, e9.InterfaceC4014c<? super fb.v> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44401
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44401) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r5 = r0.L$1
            fb.s r5 = (fb.s) r5
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            kotlin.C4849c.b(r6)
            r6 = r5
            r5 = r2
            goto L42
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.C4849c.b(r6)
            fb.s r6 = io.ktor.utils.io.core.BytePacketBuilderKt.BytePacketBuilder()
        L42:
            boolean r2 = r5.isClosedForRead()
            if (r2 != 0) goto L5e
            fb.v r2 = r5.getReadBuffer()
            r6.m0(r2)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            r2 = 0
            r4 = 0
            java.lang.Object r2 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r5, r2, r0, r3, r4)
            if (r2 != r1) goto L42
            return r1
        L5e:
            rethrowCloseCauseIfNeeded(r5)
            fb.a r5 = r6.getBufferField()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readRemaining(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readShort(io.ktor.utils.io.ByteReadChannel r4, e9.InterfaceC4014c<? super java.lang.Short> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44421
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.utils.io.ByteReadChannelOperationsKt$readShort$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44421) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readShort$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readShort$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.C4849c.b(r5)
            goto L44
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r5)
            r0.L$0 = r4
            r0.label = r3
            r5 = 2
            java.lang.Object r5 = awaitUntilReadable(r4, r5, r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            fb.v r4 = r4.getReadBuffer()
            short r4 = r4.readShort()
            java.lang.Short r4 = g9.C4109a.h(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readShort(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readUTF8Line(io.ktor.utils.io.ByteReadChannel r5, int r6, e9.InterfaceC4014c<? super java.lang.String> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44431
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8Line$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44431) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8Line$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8Line$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.L$1
            java.lang.StringBuilder r5 = (java.lang.StringBuilder) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            kotlin.C4849c.b(r7)
            goto L57
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.C4849c.b(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.Object r2 = g9.h.a(r5)
            r0.L$0 = r2
            r0.L$1 = r7
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r5 = readUTF8LineTo(r5, r7, r6, r0)
            if (r5 != r1) goto L54
            return r1
        L54:
            r4 = r7
            r7 = r5
            r5 = r4
        L57:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            if (r6 != 0) goto L61
            r5 = 0
            return r5
        L61:
            java.lang.String r5 = r5.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readUTF8Line(io.ktor.utils.io.ByteReadChannel, int, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object readUTF8Line$default(ByteReadChannel byteReadChannel, int i10, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return readUTF8Line(byteReadChannel, i10, interfaceC4014c);
    }

    public static final Object readUTF8LineTo(ByteReadChannel byteReadChannel, Appendable appendable, int i10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return m200readUTF8LineToRRvyBJ8(byteReadChannel, appendable, i10, LineEndingMode.INSTANCE.m211getAnyf0jXZW8(), interfaceC4014c);
    }

    public static /* synthetic */ Object readUTF8LineTo$default(ByteReadChannel byteReadChannel, Appendable appendable, int i10, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return readUTF8LineTo(byteReadChannel, appendable, i10, interfaceC4014c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a5, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.awaitContent$default(r0, 0, r2, 1, null) == r3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x017a, code lost:
    
        if (r14.n() >= r13) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x017c, code lost:
    
        r2.L$0 = r5;
        r2.L$1 = r8;
        r2.L$2 = r15;
        r2.L$3 = r14;
        r2.I$0 = r13;
        r2.I$1 = r4;
        r2.I$2 = r0;
        r2.label = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0191, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.awaitContent$default(r5, 0, r2, 1, null) != r3) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0193, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01af, code lost:
    
        throw new io.ktor.utils.io.charsets.TooLongLineException("Line exceeds limit of " + r13 + " characters");
     */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x01d2: INVOKE (r15 I:java.lang.AutoCloseable), (r1 I:java.lang.Throwable) STATIC call: n9.a.a(java.lang.AutoCloseable, java.lang.Throwable):void A[MD:(java.lang.AutoCloseable, java.lang.Throwable):void throws java.lang.Exception (m)], block:B:79:0x01d2 */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc A[Catch: all -> 0x004d, LOOP:1: B:37:0x00cc->B:61:0x016c, LOOP_START, TryCatch #1 {all -> 0x004d, blocks: (B:14:0x0047, B:35:0x00c6, B:37:0x00cc, B:39:0x00d6, B:41:0x00e2, B:43:0x00ec, B:48:0x010e, B:50:0x0120, B:52:0x0140, B:51:0x0137, B:57:0x0153, B:61:0x016c, B:62:0x0171, B:64:0x017c, B:67:0x0194, B:68:0x01af, B:69:0x01b0, B:72:0x01bb, B:74:0x01c5, B:21:0x006c), top: B:83:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0120 A[Catch: all -> 0x004d, TryCatch #1 {all -> 0x004d, blocks: (B:14:0x0047, B:35:0x00c6, B:37:0x00cc, B:39:0x00d6, B:41:0x00e2, B:43:0x00ec, B:48:0x010e, B:50:0x0120, B:52:0x0140, B:51:0x0137, B:57:0x0153, B:61:0x016c, B:62:0x0171, B:64:0x017c, B:67:0x0194, B:68:0x01af, B:69:0x01b0, B:72:0x01bb, B:74:0x01c5, B:21:0x006c), top: B:83:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0137 A[Catch: all -> 0x004d, TryCatch #1 {all -> 0x004d, blocks: (B:14:0x0047, B:35:0x00c6, B:37:0x00cc, B:39:0x00d6, B:41:0x00e2, B:43:0x00ec, B:48:0x010e, B:50:0x0120, B:52:0x0140, B:51:0x0137, B:57:0x0153, B:61:0x016c, B:62:0x0171, B:64:0x017c, B:67:0x0194, B:68:0x01af, B:69:0x01b0, B:72:0x01bb, B:74:0x01c5, B:21:0x006c), top: B:83:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c5 A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #1 {all -> 0x004d, blocks: (B:14:0x0047, B:35:0x00c6, B:37:0x00cc, B:39:0x00d6, B:41:0x00e2, B:43:0x00ec, B:48:0x010e, B:50:0x0120, B:52:0x0140, B:51:0x0137, B:57:0x0153, B:61:0x016c, B:62:0x0171, B:64:0x017c, B:67:0x0194, B:68:0x01af, B:69:0x01b0, B:72:0x01bb, B:74:0x01c5, B:21:0x006c), top: B:83:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @io.ktor.utils.io.InternalAPI
    /* renamed from: readUTF8LineTo-RRvyBJ8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m200readUTF8LineToRRvyBJ8(io.ktor.utils.io.ByteReadChannel r20, java.lang.Appendable r21, int r22, int r23, e9.InterfaceC4014c<? super java.lang.Boolean> r24) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.m200readUTF8LineToRRvyBJ8(io.ktor.utils.io.ByteReadChannel, java.lang.Appendable, int, int, e9.c):java.lang.Object");
    }

    /* renamed from: readUTF8LineTo-RRvyBJ8$default, reason: not valid java name */
    public static /* synthetic */ Object m201readUTF8LineToRRvyBJ8$default(ByteReadChannel byteReadChannel, Appendable appendable, int i10, int i11, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        if ((i12 & 4) != 0) {
            i11 = LineEndingMode.INSTANCE.m211getAnyf0jXZW8();
        }
        return m200readUTF8LineToRRvyBJ8(byteReadChannel, appendable, i10, i11, interfaceC4014c);
    }

    private static final void readUTF8LineTo_RRvyBJ8$checkLineEndingAllowed(int i10, int i11) throws IOException {
        if (LineEndingMode.m204containslTjpP64(i10, i11)) {
            return;
        }
        throw new IOException("Unexpected line ending " + ((Object) LineEndingMode.m209toStringimpl(i11)) + ", while expected " + ((Object) LineEndingMode.m209toStringimpl(i10)));
    }

    public static final Object readUntil(ByteReadChannel byteReadChannel, C4114a c4114a, ByteWriteChannel byteWriteChannel, long j10, boolean z10, InterfaceC4014c<? super Long> interfaceC4014c) {
        return new ByteChannelScanner(byteReadChannel, c4114a, byteWriteChannel, j10).findNext$ktor_io(z10, interfaceC4014c);
    }

    public static /* synthetic */ Object readUntil$default(ByteReadChannel byteReadChannel, C4114a c4114a, ByteWriteChannel byteWriteChannel, long j10, boolean z10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = Long.MAX_VALUE;
        }
        long j11 = j10;
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return readUntil(byteReadChannel, c4114a, byteWriteChannel, j11, z10, interfaceC4014c);
    }

    public static final ReaderJob reader(M m10, kotlin.coroutines.d coroutineContext, boolean z10, p9.p<? super ReaderScope, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        p.i(m10, "<this>");
        p.i(coroutineContext, "coroutineContext");
        p.i(block, "block");
        return reader(m10, coroutineContext, new ByteChannel(false, 1, null), block);
    }

    public static /* synthetic */ ReaderJob reader$default(M m10, kotlin.coroutines.d dVar, boolean z10, p9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return reader(m10, dVar, z10, (p9.p<? super ReaderScope, ? super InterfaceC4014c<? super t>, ? extends Object>) pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t reader$lambda$6$lambda$5(ByteChannel byteChannel, Throwable th) {
        if (th != null && !byteChannel.isClosedForRead()) {
            byteChannel.cancel(th);
        }
        return t.f7040a;
    }

    @InternalAPI
    public static final void rethrowCloseCauseIfNeeded(ByteReadChannel byteReadChannel) throws Throwable {
        p.i(byteReadChannel, "<this>");
        Throwable closedCause = byteReadChannel.getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007a, code lost:
    
        if (discard(r7, r5, r0) == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object skipIfFound(io.ktor.utils.io.ByteReadChannel r7, gb.C4114a r8, e9.InterfaceC4014c<? super java.lang.Boolean> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44461
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.ByteReadChannelOperationsKt$skipIfFound$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44461) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$skipIfFound$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$skipIfFound$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            gb.a r7 = (gb.C4114a) r7
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r7 = (io.ktor.utils.io.ByteReadChannel) r7
            kotlin.C4849c.b(r9)
            goto L7d
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            gb.a r8 = (gb.C4114a) r8
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r7 = (io.ktor.utils.io.ByteReadChannel) r7
            kotlin.C4849c.b(r9)
            goto L5d
        L49:
            kotlin.C4849c.b(r9)
            int r9 = r8.i()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = peek(r7, r9, r0)
            if (r9 != r1) goto L5d
            goto L7c
        L5d:
            boolean r9 = kotlin.jvm.internal.p.d(r9, r8)
            if (r9 == 0) goto L82
            int r9 = r8.i()
            long r5 = (long) r9
            java.lang.Object r9 = g9.h.a(r7)
            r0.L$0 = r9
            java.lang.Object r8 = g9.h.a(r8)
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r7 = discard(r7, r5, r0)
            if (r7 != r1) goto L7d
        L7c:
            return r1
        L7d:
            java.lang.Boolean r7 = g9.C4109a.a(r4)
            return r7
        L82:
            r7 = 0
            java.lang.Boolean r7 = g9.C4109a.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.skipIfFound(io.ktor.utils.io.ByteReadChannel, gb.a, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object toByteArray(io.ktor.utils.io.ByteReadChannel r4, e9.InterfaceC4014c<? super byte[]> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44471
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.utils.io.ByteReadChannelOperationsKt$toByteArray$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44471) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$toByteArray$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$toByteArray$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.C4849c.b(r5)
            goto L47
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r5)
            java.lang.Object r5 = g9.h.a(r4)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r5 = readBuffer(r4, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            fb.a r5 = (fb.C4074a) r5
            r4 = 0
            r0 = 0
            byte[] r4 = io.ktor.utils.io.core.BuffersKt.readBytes$default(r5, r4, r3, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.toByteArray(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    public static final ReaderJob reader(M m10, kotlin.coroutines.d coroutineContext, final ByteChannel channel, p9.p<? super ReaderScope, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        p.i(m10, "<this>");
        p.i(coroutineContext, "coroutineContext");
        p.i(channel, "channel");
        p.i(block, "block");
        g gVarD = C1060i.d(m10, coroutineContext, null, new ByteReadChannelOperationsKt$reader$job$1(block, channel, null), 2, null);
        gVarD.J(new InterfaceC5074l() { // from class: io.ktor.utils.io.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ByteReadChannelOperationsKt.reader$lambda$6$lambda$5(channel, (Throwable) obj);
            }
        });
        return new ReaderJob(CloseHookByteWriteChannelKt.onClose(channel, new C44451(gVarD, null)), gVarD);
    }

    @InternalAPI
    public static final void rethrowCloseCauseIfNeeded(ByteWriteChannel byteWriteChannel) throws Throwable {
        p.i(byteWriteChannel, "<this>");
        Throwable closedCause = byteWriteChannel.getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    @InternalAPI
    public static final void rethrowCloseCauseIfNeeded(ByteChannel byteChannel) {
        p.i(byteChannel, "<this>");
        Throwable closedCause = byteChannel.getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    public static final int readAvailable(ByteReadChannel byteReadChannel, int i10, InterfaceC5074l<? super C4074a, Integer> block) {
        p.i(byteReadChannel, "<this>");
        p.i(block, "block");
        if (i10 <= 0) {
            throw new IllegalArgumentException("min should be positive");
        }
        if (i10 <= 1048576) {
            if (getAvailableForRead(byteReadChannel) < i10) {
                return -1;
            }
            return block.invoke(byteReadChannel.getReadBuffer().getBufferField()).intValue();
        }
        throw new IllegalArgumentException(("Min(" + i10 + ") shouldn't be greater than 1048576").toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0057 -> B:25:0x0072). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006c -> B:24:0x006f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readBuffer(io.ktor.utils.io.ByteReadChannel r8, int r9, e9.InterfaceC4014c<? super fb.C4074a> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.AnonymousClass3
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$3 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.AnonymousClass3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$3 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$3
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$1
            fb.a r2 = (fb.C4074a) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.C4849c.b(r10)
            goto L6f
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            kotlin.C4849c.b(r10)
            fb.a r10 = new fb.a
            r10.<init>()
            r2 = r10
            r10 = r9
        L47:
            if (r9 <= 0) goto L89
            boolean r4 = r8.isClosedForRead()
            if (r4 != 0) goto L89
            fb.v r4 = r8.getReadBuffer()
            boolean r4 = r4.k()
            if (r4 == 0) goto L72
            r0.L$0 = r8
            r0.L$1 = r2
            r0.I$0 = r10
            r0.I$1 = r9
            r0.label = r3
            r4 = 0
            r5 = 0
            java.lang.Object r4 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r8, r4, r0, r3, r5)
            if (r4 != r1) goto L6c
            return r1
        L6c:
            r4 = r8
            r8 = r9
            r9 = r10
        L6f:
            r10 = r9
            r9 = r8
            r8 = r4
        L72:
            long r4 = (long) r9
            fb.v r6 = r8.getReadBuffer()
            long r6 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r6)
            long r4 = java.lang.Math.min(r4, r6)
            fb.v r6 = r8.getReadBuffer()
            r6.E0(r2, r4)
            int r4 = (int) r4
            int r9 = r9 - r4
            goto L47
        L89:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readBuffer(io.ktor.utils.io.ByteReadChannel, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readRemaining(io.ktor.utils.io.ByteReadChannel r10, long r11, e9.InterfaceC4014c<? super fb.v> r13) throws java.lang.Throwable {
        /*
            boolean r0 = r13 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C44412
            if (r0 == 0) goto L13
            r0 = r13
            io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$2 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C44412) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$2 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$2
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            long r10 = r0.J$1
            long r4 = r0.J$0
            java.lang.Object r12 = r0.L$1
            fb.s r12 = (fb.s) r12
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            kotlin.C4849c.b(r13)
            r13 = r12
            r11 = r10
            r10 = r2
            goto L48
        L38:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L40:
            kotlin.C4849c.b(r13)
            fb.s r13 = io.ktor.utils.io.core.BytePacketBuilderKt.BytePacketBuilder()
            r4 = r11
        L48:
            boolean r2 = r10.isClosedForRead()
            if (r2 != 0) goto L92
            r6 = 0
            int r2 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r2 <= 0) goto L92
            fb.v r2 = r10.getReadBuffer()
            long r8 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r2)
            int r2 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r2 < 0) goto L76
            fb.v r2 = r10.getReadBuffer()
            long r6 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r2)
            long r6 = r11 - r6
            fb.v r11 = r10.getReadBuffer()
            long r11 = r11.B(r13)
            g9.C4109a.g(r11)
            goto L7d
        L76:
            fb.v r2 = r10.getReadBuffer()
            r2.E0(r13, r11)
        L7d:
            r0.L$0 = r10
            r0.L$1 = r13
            r0.J$0 = r4
            r0.J$1 = r6
            r0.label = r3
            r11 = 0
            r12 = 0
            java.lang.Object r11 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r10, r11, r0, r3, r12)
            if (r11 != r1) goto L90
            return r1
        L90:
            r11 = r6
            goto L48
        L92:
            fb.a r10 = r13.getBufferField()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readRemaining(io.ktor.utils.io.ByteReadChannel, long, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b3, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.awaitContent$default(r1, 0, r12, 1, null) == r2) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00eb, code lost:
    
        if (r0 != r2) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00eb -> B:20:0x0069). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyTo(io.ktor.utils.io.ByteReadChannel r17, io.ktor.utils.io.ByteWriteChannel r18, long r19, e9.InterfaceC4014c<? super java.lang.Long> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.copyTo(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, long, e9.c):java.lang.Object");
    }
}
