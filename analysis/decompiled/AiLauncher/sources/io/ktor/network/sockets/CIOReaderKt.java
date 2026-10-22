package io.ktor.network.sockets;

import Ua.CoroutineName;
import Ua.M;
import Ua.Y;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.network.selector.SelectInterest;
import io.ktor.network.selector.Selectable;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.sockets.SocketOptions;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterJob;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import p9.p;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a?\u0010\u0011\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016\u001a \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"LUa/M;", "Lio/ktor/utils/io/ByteChannel;", "channel", "Ljava/nio/channels/ReadableByteChannel;", "nioChannel", "Lio/ktor/network/selector/Selectable;", "selectable", "Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "socketOptions", "Lio/ktor/utils/io/WriterJob;", "attachForReadingImpl", "(LUa/M;Lio/ktor/utils/io/ByteChannel;Ljava/nio/channels/ReadableByteChannel;Lio/ktor/network/selector/Selectable;Lio/ktor/network/selector/SelectorManager;Lio/ktor/utils/io/pool/ObjectPool;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;)Lio/ktor/utils/io/WriterJob;", "attachForReadingDirectImpl", "(LUa/M;Lio/ktor/utils/io/ByteChannel;Ljava/nio/channels/ReadableByteChannel;Lio/ktor/network/selector/Selectable;Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ByteWriteChannel;", "", "readFrom", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/channels/ReadableByteChannel;Le9/c;)Ljava/lang/Object;", "LY8/t;", "selectForRead", "(Lio/ktor/network/selector/Selectable;Lio/ktor/network/selector/SelectorManager;Le9/c;)Ljava/lang/Object;", "ktor-network"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CIOReaderKt {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/WriterScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/WriterScope;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.network.sockets.CIOReaderKt$attachForReadingDirectImpl$1", f = "CIOReader.kt", l = {96, 105, 108, 109, 96, 105, 108, 109}, m = "invokeSuspend")
    /* renamed from: io.ktor.network.sockets.CIOReaderKt$attachForReadingDirectImpl$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<WriterScope, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ ByteChannel $channel;
        final /* synthetic */ ReadableByteChannel $nioChannel;
        final /* synthetic */ Selectable $selectable;
        final /* synthetic */ SelectorManager $selector;
        final /* synthetic */ SocketOptions.TCPClientSocketOptions $socketOptions;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Selectable selectable, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, ByteChannel byteChannel, ReadableByteChannel readableByteChannel, SelectorManager selectorManager, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$selectable = selectable;
            this.$socketOptions = tCPClientSocketOptions;
            this.$channel = byteChannel;
            this.$nioChannel = readableByteChannel;
            this.$selector = selectorManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$selectable, this.$socketOptions, this.$channel, this.$nioChannel, this.$selector, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(WriterScope writerScope, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(writerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:83:0x02e4, code lost:
        
            if (r14 != r0) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x02ed, code lost:
        
            if (((java.lang.Number) r14).intValue() != 0) goto L87;
         */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0181 A[Catch: all -> 0x00d1, TryCatch #1 {all -> 0x00d1, blocks: (B:88:0x02f1, B:43:0x0179, B:45:0x0181, B:47:0x018b, B:51:0x01b8, B:53:0x01c0, B:55:0x01c7, B:58:0x01ee, B:61:0x0215, B:64:0x023c, B:67:0x0246, B:93:0x02fd, B:94:0x0300, B:96:0x0308, B:105:0x032f, B:90:0x02f7, B:91:0x02fa, B:21:0x00cc, B:26:0x00f3, B:29:0x0116, B:32:0x0137, B:35:0x0147, B:37:0x0153, B:40:0x015f, B:7:0x0036, B:85:0x02e7, B:79:0x02a2, B:82:0x02c4, B:87:0x02ef, B:68:0x0249, B:72:0x0272, B:74:0x027a, B:76:0x0280, B:12:0x005d, B:15:0x0080, B:18:0x00a2), top: B:118:0x000d, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x01c0 A[Catch: all -> 0x00d1, TryCatch #1 {all -> 0x00d1, blocks: (B:88:0x02f1, B:43:0x0179, B:45:0x0181, B:47:0x018b, B:51:0x01b8, B:53:0x01c0, B:55:0x01c7, B:58:0x01ee, B:61:0x0215, B:64:0x023c, B:67:0x0246, B:93:0x02fd, B:94:0x0300, B:96:0x0308, B:105:0x032f, B:90:0x02f7, B:91:0x02fa, B:21:0x00cc, B:26:0x00f3, B:29:0x0116, B:32:0x0137, B:35:0x0147, B:37:0x0153, B:40:0x015f, B:7:0x0036, B:85:0x02e7, B:79:0x02a2, B:82:0x02c4, B:87:0x02ef, B:68:0x0249, B:72:0x0272, B:74:0x027a, B:76:0x0280, B:12:0x005d, B:15:0x0080, B:18:0x00a2), top: B:118:0x000d, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01c5  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0213  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0215 A[Catch: all -> 0x00d1, PHI: r2 r3 r4 r5 r6 r7 r8 r11 r12
          0x0215: PHI (r2v15 int) = (r2v8 int), (r2v16 int) binds: [B:26:0x00f3, B:59:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r3v14 int) = (r3v6 int), (r3v15 int) binds: [B:26:0x00f3, B:59:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r4v13 int) = (r4v4 int), (r4v14 int) binds: [B:26:0x00f3, B:59:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r5v20 io.ktor.network.selector.SelectorManager) = (r5v8 io.ktor.network.selector.SelectorManager), (r5v21 io.ktor.network.selector.SelectorManager) binds: [B:26:0x00f3, B:59:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r6v19 io.ktor.network.selector.Selectable) = (r6v7 io.ktor.network.selector.Selectable), (r6v20 io.ktor.network.selector.Selectable) binds: [B:26:0x00f3, B:59:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r7v19 java.nio.channels.ReadableByteChannel) = (r7v7 java.nio.channels.ReadableByteChannel), (r7v20 java.nio.channels.ReadableByteChannel) binds: [B:26:0x00f3, B:59:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r8v20 io.ktor.utils.io.ByteChannel) = (r8v7 io.ktor.utils.io.ByteChannel), (r8v21 io.ktor.utils.io.ByteChannel) binds: [B:26:0x00f3, B:59:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r11v19 io.ktor.network.util.Timeout) = (r11v8 io.ktor.network.util.Timeout), (r11v20 io.ktor.network.util.Timeout) binds: [B:26:0x00f3, B:59:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r12v14 io.ktor.network.util.Timeout) = (r12v4 io.ktor.network.util.Timeout), (r12v15 io.ktor.network.util.Timeout) binds: [B:26:0x00f3, B:59:0x0211] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x00d1, blocks: (B:88:0x02f1, B:43:0x0179, B:45:0x0181, B:47:0x018b, B:51:0x01b8, B:53:0x01c0, B:55:0x01c7, B:58:0x01ee, B:61:0x0215, B:64:0x023c, B:67:0x0246, B:93:0x02fd, B:94:0x0300, B:96:0x0308, B:105:0x032f, B:90:0x02f7, B:91:0x02fa, B:21:0x00cc, B:26:0x00f3, B:29:0x0116, B:32:0x0137, B:35:0x0147, B:37:0x0153, B:40:0x015f, B:7:0x0036, B:85:0x02e7, B:79:0x02a2, B:82:0x02c4, B:87:0x02ef, B:68:0x0249, B:72:0x0272, B:74:0x027a, B:76:0x0280, B:12:0x005d, B:15:0x0080, B:18:0x00a2), top: B:118:0x000d, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x023a  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0244  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x027a A[Catch: all -> 0x003b, TryCatch #2 {all -> 0x003b, blocks: (B:7:0x0036, B:85:0x02e7, B:79:0x02a2, B:82:0x02c4, B:87:0x02ef, B:68:0x0249, B:72:0x0272, B:74:0x027a, B:76:0x0280, B:12:0x005d, B:15:0x0080, B:18:0x00a2), top: B:118:0x000d, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x027e  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x02c3  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x02c4 A[Catch: all -> 0x003b, PHI: r2 r3 r4 r5 r6 r7 r8 r11 r12
          0x02c4: PHI (r2v19 int) = (r2v12 int), (r2v20 int) binds: [B:12:0x005d, B:80:0x02c1] A[DONT_GENERATE, DONT_INLINE]
          0x02c4: PHI (r3v20 int) = (r3v11 int), (r3v21 int) binds: [B:12:0x005d, B:80:0x02c1] A[DONT_GENERATE, DONT_INLINE]
          0x02c4: PHI (r4v19 int) = (r4v10 int), (r4v20 int) binds: [B:12:0x005d, B:80:0x02c1] A[DONT_GENERATE, DONT_INLINE]
          0x02c4: PHI (r5v32 io.ktor.network.selector.SelectorManager) = (r5v17 io.ktor.network.selector.SelectorManager), (r5v33 io.ktor.network.selector.SelectorManager) binds: [B:12:0x005d, B:80:0x02c1] A[DONT_GENERATE, DONT_INLINE]
          0x02c4: PHI (r6v24 io.ktor.network.selector.Selectable) = (r6v16 io.ktor.network.selector.Selectable), (r6v25 io.ktor.network.selector.Selectable) binds: [B:12:0x005d, B:80:0x02c1] A[DONT_GENERATE, DONT_INLINE]
          0x02c4: PHI (r7v24 java.nio.channels.ReadableByteChannel) = (r7v16 java.nio.channels.ReadableByteChannel), (r7v25 java.nio.channels.ReadableByteChannel) binds: [B:12:0x005d, B:80:0x02c1] A[DONT_GENERATE, DONT_INLINE]
          0x02c4: PHI (r8v25 io.ktor.utils.io.ByteChannel) = (r8v17 io.ktor.utils.io.ByteChannel), (r8v26 io.ktor.utils.io.ByteChannel) binds: [B:12:0x005d, B:80:0x02c1] A[DONT_GENERATE, DONT_INLINE]
          0x02c4: PHI (r11v25 io.ktor.network.util.Timeout) = (r11v16 io.ktor.network.util.Timeout), (r11v26 io.ktor.network.util.Timeout) binds: [B:12:0x005d, B:80:0x02c1] A[DONT_GENERATE, DONT_INLINE]
          0x02c4: PHI (r12v21 io.ktor.network.util.Timeout) = (r12v11 io.ktor.network.util.Timeout), (r12v22 io.ktor.network.util.Timeout) binds: [B:12:0x005d, B:80:0x02c1] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {all -> 0x003b, blocks: (B:7:0x0036, B:85:0x02e7, B:79:0x02a2, B:82:0x02c4, B:87:0x02ef, B:68:0x0249, B:72:0x0272, B:74:0x027a, B:76:0x0280, B:12:0x005d, B:15:0x0080, B:18:0x00a2), top: B:118:0x000d, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x02fb  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01c0 -> B:89:0x02f4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01c5 -> B:89:0x02f4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0242 -> B:58:0x01ee). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0244 -> B:89:0x02f4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x027a -> B:87:0x02ef). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x027e -> B:87:0x02ef). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x02e4 -> B:85:0x02e7). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 870
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.CIOReaderKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/WriterScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/WriterScope;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.network.sockets.CIOReaderKt$attachForReadingImpl$1", f = "CIOReader.kt", l = {42, 44, 42, 44, 55}, m = "invokeSuspend")
    /* renamed from: io.ktor.network.sockets.CIOReaderKt$attachForReadingImpl$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43051 extends SuspendLambda implements p<WriterScope, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ ByteBuffer $buffer;
        final /* synthetic */ ByteChannel $channel;
        final /* synthetic */ ReadableByteChannel $nioChannel;
        final /* synthetic */ ObjectPool<ByteBuffer> $pool;
        final /* synthetic */ Selectable $selectable;
        final /* synthetic */ SelectorManager $selector;
        final /* synthetic */ SocketOptions.TCPClientSocketOptions $socketOptions;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C43051(SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, ByteChannel byteChannel, Selectable selectable, ByteBuffer byteBuffer, ObjectPool<ByteBuffer> objectPool, ReadableByteChannel readableByteChannel, SelectorManager selectorManager, InterfaceC4014c<? super C43051> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$socketOptions = tCPClientSocketOptions;
            this.$channel = byteChannel;
            this.$selectable = selectable;
            this.$buffer = byteBuffer;
            this.$pool = objectPool;
            this.$nioChannel = readableByteChannel;
            this.$selector = selectorManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43051 c43051 = new C43051(this.$socketOptions, this.$channel, this.$selectable, this.$buffer, this.$pool, this.$nioChannel, this.$selector, interfaceC4014c);
            c43051.L$0 = obj;
            return c43051;
        }

        @Override // p9.p
        public final Object invoke(WriterScope writerScope, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C43051) create(writerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:86:0x02a5, code lost:
        
            if (io.ktor.utils.io.ByteWriteChannelOperations_jvmKt.writeFully(r5, r6, r19) == r0) goto L87;
         */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0137 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:10:0x0027, B:88:0x02a8, B:38:0x0116, B:41:0x012f, B:43:0x0137, B:47:0x0169, B:51:0x01a0, B:72:0x023a, B:74:0x023f, B:76:0x0246, B:85:0x0272, B:55:0x01a9, B:71:0x0237, B:90:0x02b5, B:91:0x02b8, B:25:0x00bb, B:28:0x00e4, B:31:0x00ec, B:33:0x00f0, B:36:0x00fc, B:57:0x01af, B:59:0x01b7, B:63:0x01f0, B:68:0x0231, B:70:0x0235, B:17:0x0061, B:22:0x0090), top: B:101:0x0013, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0194  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x01a4  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01a7  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01a9 A[Catch: all -> 0x0032, TRY_LEAVE, TryCatch #0 {all -> 0x0032, blocks: (B:10:0x0027, B:88:0x02a8, B:38:0x0116, B:41:0x012f, B:43:0x0137, B:47:0x0169, B:51:0x01a0, B:72:0x023a, B:74:0x023f, B:76:0x0246, B:85:0x0272, B:55:0x01a9, B:71:0x0237, B:90:0x02b5, B:91:0x02b8, B:25:0x00bb, B:28:0x00e4, B:31:0x00ec, B:33:0x00f0, B:36:0x00fc, B:57:0x01af, B:59:0x01b7, B:63:0x01f0, B:68:0x0231, B:70:0x0235, B:17:0x0061, B:22:0x0090), top: B:101:0x0013, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x01b7 A[Catch: all -> 0x0068, TryCatch #1 {all -> 0x0068, blocks: (B:57:0x01af, B:59:0x01b7, B:63:0x01f0, B:68:0x0231, B:70:0x0235, B:17:0x0061, B:22:0x0090), top: B:101:0x0013, outer: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0219  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0230  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0235 A[Catch: all -> 0x0068, TRY_LEAVE, TryCatch #1 {all -> 0x0068, blocks: (B:57:0x01af, B:59:0x01b7, B:63:0x01f0, B:68:0x0231, B:70:0x0235, B:17:0x0061, B:22:0x0090), top: B:101:0x0013, outer: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x023f A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:10:0x0027, B:88:0x02a8, B:38:0x0116, B:41:0x012f, B:43:0x0137, B:47:0x0169, B:51:0x01a0, B:72:0x023a, B:74:0x023f, B:76:0x0246, B:85:0x0272, B:55:0x01a9, B:71:0x0237, B:90:0x02b5, B:91:0x02b8, B:25:0x00bb, B:28:0x00e4, B:31:0x00ec, B:33:0x00f0, B:36:0x00fc, B:57:0x01af, B:59:0x01b7, B:63:0x01f0, B:68:0x0231, B:70:0x0235, B:17:0x0061, B:22:0x0090), top: B:101:0x0013, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0272 A[Catch: all -> 0x0032, TRY_ENTER, TryCatch #0 {all -> 0x0032, blocks: (B:10:0x0027, B:88:0x02a8, B:38:0x0116, B:41:0x012f, B:43:0x0137, B:47:0x0169, B:51:0x01a0, B:72:0x023a, B:74:0x023f, B:76:0x0246, B:85:0x0272, B:55:0x01a9, B:71:0x0237, B:90:0x02b5, B:91:0x02b8, B:25:0x00bb, B:28:0x00e4, B:31:0x00ec, B:33:0x00f0, B:36:0x00fc, B:57:0x01af, B:59:0x01b7, B:63:0x01f0, B:68:0x0231, B:70:0x0235, B:17:0x0061, B:22:0x0090), top: B:101:0x0013, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:89:0x02b1  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01a7 -> B:41:0x012f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x02a5 -> B:88:0x02a8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x02b1 -> B:57:0x01af). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 736
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.CIOReaderKt.C43051.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.sockets.CIOReaderKt", f = "CIOReader.kt", l = {133}, m = "readFrom")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.sockets.CIOReaderKt$readFrom$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C43061(InterfaceC4014c<? super C43061> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOReaderKt.readFrom(null, null, this);
        }
    }

    public static final WriterJob attachForReadingDirectImpl(M m10, ByteChannel channel, ReadableByteChannel nioChannel, Selectable selectable, SelectorManager selector, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        kotlin.jvm.internal.p.i(m10, "<this>");
        kotlin.jvm.internal.p.i(channel, "channel");
        kotlin.jvm.internal.p.i(nioChannel, "nioChannel");
        kotlin.jvm.internal.p.i(selectable, "selectable");
        kotlin.jvm.internal.p.i(selector, "selector");
        return ByteWriteChannelOperationsKt.writer(m10, Y.b().plus(new CoroutineName("cio-from-nio-reader")), channel, new AnonymousClass1(selectable, tCPClientSocketOptions, channel, nioChannel, selector, null));
    }

    public static /* synthetic */ WriterJob attachForReadingDirectImpl$default(M m10, ByteChannel byteChannel, ReadableByteChannel readableByteChannel, Selectable selectable, SelectorManager selectorManager, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            tCPClientSocketOptions = null;
        }
        return attachForReadingDirectImpl(m10, byteChannel, readableByteChannel, selectable, selectorManager, tCPClientSocketOptions);
    }

    public static final WriterJob attachForReadingImpl(M m10, ByteChannel channel, ReadableByteChannel nioChannel, Selectable selectable, SelectorManager selector, ObjectPool<ByteBuffer> pool, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        kotlin.jvm.internal.p.i(m10, "<this>");
        kotlin.jvm.internal.p.i(channel, "channel");
        kotlin.jvm.internal.p.i(nioChannel, "nioChannel");
        kotlin.jvm.internal.p.i(selectable, "selectable");
        kotlin.jvm.internal.p.i(selector, "selector");
        kotlin.jvm.internal.p.i(pool, "pool");
        return ByteWriteChannelOperationsKt.writer(m10, Y.b().plus(new CoroutineName("cio-from-nio-reader")), channel, new C43051(tCPClientSocketOptions, channel, selectable, pool.borrow(), pool, nioChannel, selector, null));
    }

    public static /* synthetic */ WriterJob attachForReadingImpl$default(M m10, ByteChannel byteChannel, ReadableByteChannel readableByteChannel, Selectable selectable, SelectorManager selectorManager, ObjectPool objectPool, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            tCPClientSocketOptions = null;
        }
        return attachForReadingImpl(m10, byteChannel, readableByteChannel, selectable, selectorManager, objectPool, tCPClientSocketOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readFrom(io.ktor.utils.io.ByteWriteChannel r7, final java.nio.channels.ReadableByteChannel r8, e9.InterfaceC4014c<? super java.lang.Integer> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.network.sockets.CIOReaderKt.C43061
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.network.sockets.CIOReaderKt$readFrom$1 r0 = (io.ktor.network.sockets.CIOReaderKt.C43061) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            io.ktor.network.sockets.CIOReaderKt$readFrom$1 r0 = new io.ktor.network.sockets.CIOReaderKt$readFrom$1
            r0.<init>(r9)
            goto L12
        L1a:
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L37
            java.lang.Object r7 = r4.L$2
            kotlin.jvm.internal.Ref$IntRef r7 = (kotlin.jvm.internal.Ref$IntRef) r7
            java.lang.Object r8 = r4.L$1
            java.nio.channels.ReadableByteChannel r8 = (java.nio.channels.ReadableByteChannel) r8
            java.lang.Object r8 = r4.L$0
            io.ktor.utils.io.ByteWriteChannel r8 = (io.ktor.utils.io.ByteWriteChannel) r8
            kotlin.C4849c.b(r9)
            goto L68
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            kotlin.C4849c.b(r9)
            kotlin.jvm.internal.Ref$IntRef r9 = new kotlin.jvm.internal.Ref$IntRef
            r9.<init>()
            io.ktor.network.sockets.a r3 = new io.ktor.network.sockets.a
            r3.<init>()
            java.lang.Object r1 = g9.h.a(r7)
            r4.L$0 = r1
            java.lang.Object r8 = g9.h.a(r8)
            r4.L$1 = r8
            r4.L$2 = r9
            r4.label = r2
            r2 = 0
            r5 = 1
            r6 = 0
            r1 = r7
            java.lang.Object r7 = io.ktor.utils.io.ByteWriteChannelOperations_jvmKt.write$default(r1, r2, r3, r4, r5, r6)
            if (r7 != r0) goto L67
            return r0
        L67:
            r7 = r9
        L68:
            int r7 = r7.f34818a
            java.lang.Integer r7 = g9.C4109a.f(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.CIOReaderKt.readFrom(io.ktor.utils.io.ByteWriteChannel, java.nio.channels.ReadableByteChannel, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t readFrom$lambda$0(Ref$IntRef ref$IntRef, ReadableByteChannel readableByteChannel, ByteBuffer buffer) {
        kotlin.jvm.internal.p.i(buffer, "buffer");
        ref$IntRef.f34818a = readableByteChannel.read(buffer);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object selectForRead(Selectable selectable, SelectorManager selectorManager, InterfaceC4014c<? super t> interfaceC4014c) {
        SelectInterest selectInterest = SelectInterest.READ;
        selectable.interestOp(selectInterest, true);
        Object objSelect = selectorManager.select(selectable, selectInterest, interfaceC4014c);
        return objSelect == C4063a.g() ? objSelect : t.f7040a;
    }
}
