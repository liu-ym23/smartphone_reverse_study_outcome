package io.ktor.http.cio;

import La.z;
import Ua.C1073o0;
import Ua.M;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ReaderJob;
import io.ktor.utils.io.ReaderScope;
import io.ktor.utils.io.WriterJob;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.pool.DefaultPool;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\b\u001a\u001f\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\t\u001a \u0010\u0005\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0005\u0010\r\u001a!\u0010\u0013\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014\u001a \u0010\u0013\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0013\u0010\u0015\u001a\u0013\u0010\u0016\u001a\u00020\f*\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a,\u0010\u001d\u001a\u00020\u001a*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0082@¢\u0006\u0004\b\u001d\u0010\u001e\"\u0014\u0010\u001f\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 \"\u0014\u0010!\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010 \"\u001e\u0010%\u001a\f\u0012\b\u0012\u00060#j\u0002`$0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&\"\u0014\u0010(\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)\"\u0014\u0010*\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+\"\u0014\u0010,\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+*\n\u0010-\"\u00020\u00032\u00020\u0003*\n\u0010.\"\u00020\u00112\u00020\u0011¨\u0006/"}, d2 = {"LUa/M;", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/WriterJob;", "Lio/ktor/http/cio/DecoderJob;", "decodeChunked", "(LUa/M;Lio/ktor/utils/io/ByteReadChannel;)Lio/ktor/utils/io/WriterJob;", "", "contentLength", "(LUa/M;Lio/ktor/utils/io/ByteReadChannel;J)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ByteWriteChannel;", "out", "LY8/t;", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Le9/c;)Ljava/lang/Object;", "output", "Lkotlin/coroutines/d;", "coroutineContext", "Lio/ktor/utils/io/ReaderJob;", "Lio/ktor/http/cio/EncoderJob;", "encodeChunked", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/d;)Lio/ktor/utils/io/ReaderJob;", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/ByteReadChannel;Le9/c;)Ljava/lang/Object;", "rethrowCloseCause", "(Lio/ktor/utils/io/ByteReadChannel;)V", "", "memory", "", "startIndex", "endIndex", "writeChunk", "(Lio/ktor/utils/io/ByteWriteChannel;[BIILe9/c;)Ljava/lang/Object;", "MAX_CHUNK_SIZE_LENGTH", "I", "CHUNK_BUFFER_POOL_SIZE", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "ChunkSizeBufferPool", "Lio/ktor/utils/io/pool/ObjectPool;", "", "CrLfShort", ExifInterface.LATITUDE_SOUTH, "CrLf", "[B", "LastChunkBytes", "DecoderJob", "EncoderJob", "ktor-http-cio"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChunkedTransferEncodingKt {
    private static final int CHUNK_BUFFER_POOL_SIZE = 2048;
    private static final short CrLfShort = 3338;
    private static final int MAX_CHUNK_SIZE_LENGTH = 128;
    private static final ObjectPool<StringBuilder> ChunkSizeBufferPool = new DefaultPool<StringBuilder>() { // from class: io.ktor.http.cio.ChunkedTransferEncodingKt$ChunkSizeBufferPool$1
        @Override // io.ktor.utils.io.pool.DefaultPool
        public StringBuilder clearInstance(StringBuilder instance) {
            p.i(instance, "instance");
            z.q(instance);
            return instance;
        }

        @Override // io.ktor.utils.io.pool.DefaultPool
        public StringBuilder produceInstance() {
            return new StringBuilder(128);
        }
    };
    private static final byte[] CrLf = StringsKt.toByteArray$default(ServerSentEventKt.END_OF_LINE, null, 1, null);
    private static final byte[] LastChunkBytes = StringsKt.toByteArray$default("0\r\n\r\n", null, 1, null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/WriterScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/WriterScope;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$1", f = "ChunkedTransferEncoding.kt", l = {54}, m = "invokeSuspend")
    /* renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<WriterScope, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ ByteReadChannel $input;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ByteReadChannel byteReadChannel, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$input = byteReadChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$input, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(WriterScope writerScope, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(writerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            WriterScope writerScope = (WriterScope) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ByteReadChannel byteReadChannel = this.$input;
                ByteWriteChannel channel = writerScope.getChannel();
                this.L$0 = g9.h.a(writerScope);
                this.label = 1;
                if (ChunkedTransferEncodingKt.decodeChunked(byteReadChannel, channel, this) == objG) {
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

    @InterfaceC4112d(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", l = {72, 81, 82, 87, 101, 101}, m = "decodeChunked")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$2, reason: invalid class name */
    public static final class AnonymousClass2 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedTransferEncodingKt.decodeChunked((ByteReadChannel) null, (ByteWriteChannel) null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/ReaderScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/ReaderScope;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.http.cio.ChunkedTransferEncodingKt$encodeChunked$1", f = "ChunkedTransferEncoding.kt", l = {122}, m = "invokeSuspend")
    /* renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$encodeChunked$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42851 extends SuspendLambda implements p9.p<ReaderScope, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ ByteWriteChannel $output;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C42851(ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super C42851> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$output = byteWriteChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C42851 c42851 = new C42851(this.$output, interfaceC4014c);
            c42851.L$0 = obj;
            return c42851;
        }

        @Override // p9.p
        public final Object invoke(ReaderScope readerScope, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C42851) create(readerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ReaderScope readerScope = (ReaderScope) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ByteWriteChannel byteWriteChannel = this.$output;
                ByteReadChannel channel = readerScope.getChannel();
                this.L$0 = g9.h.a(readerScope);
                this.label = 1;
                if (ChunkedTransferEncodingKt.encodeChunked(byteWriteChannel, channel, this) == objG) {
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

    @InterfaceC4112d(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", l = {175, 135, 140, 146, 146}, m = "encodeChunked")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$encodeChunked$2, reason: invalid class name and case insensitive filesystem */
    public static final class C42862 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        int I$6;
        int I$7;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C42862(InterfaceC4014c<? super C42862> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedTransferEncodingKt.encodeChunked(null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", l = {164, DidiCardView.FINISHED_SUMMARY_WIDTH_DP, 167, 168, 169}, m = "writeChunk")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$writeChunk$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42871 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C42871(InterfaceC4014c<? super C42871> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedTransferEncodingKt.writeChunk(null, null, 0, 0, this);
        }
    }

    public static final WriterJob decodeChunked(M m10, ByteReadChannel input) {
        p.i(m10, "<this>");
        p.i(input, "input");
        return decodeChunked(m10, input, -1L);
    }

    public static final ReaderJob encodeChunked(ByteWriteChannel output, kotlin.coroutines.d coroutineContext) {
        p.i(output, "output");
        p.i(coroutineContext, "coroutineContext");
        return ByteReadChannelOperationsKt.reader((M) C1073o0.f6391a, coroutineContext, false, (p9.p<? super ReaderScope, ? super InterfaceC4014c<? super t>, ? extends Object>) new C42851(output, null));
    }

    private static final void rethrowCloseCause(ByteReadChannel byteReadChannel) throws Throwable {
        Throwable closedCause = byteReadChannel instanceof ByteChannel ? ((ByteChannel) byteReadChannel).getClosedCause() : null;
        if (closedCause != null) {
            throw closedCause;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0115, code lost:
    
        if (r1.flush(r5) != r0) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006e A[PHI: r1 r9 r10 r11 r12
      0x006e: PHI (r1v7 io.ktor.utils.io.ByteWriteChannel) = (r1v6 io.ktor.utils.io.ByteWriteChannel), (r1v14 io.ktor.utils.io.ByteWriteChannel) binds: [B:32:0x00dd, B:20:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r9v4 int) = (r9v3 int), (r9v11 int) binds: [B:32:0x00dd, B:20:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r10v4 int) = (r10v3 int), (r10v10 int) binds: [B:32:0x00dd, B:20:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r11v3 int) = (r11v2 int), (r11v7 int) binds: [B:32:0x00dd, B:20:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r12v4 byte[]) = (r12v3 byte[]), (r12v11 byte[]) binds: [B:32:0x00dd, B:20:0x005d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fd A[PHI: r1 r9 r10 r11 r12
      0x00fd: PHI (r1v8 io.ktor.utils.io.ByteWriteChannel) = (r1v7 io.ktor.utils.io.ByteWriteChannel), (r1v16 io.ktor.utils.io.ByteWriteChannel) binds: [B:35:0x00fa, B:19:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x00fd: PHI (r9v5 int) = (r9v4 int), (r9v12 int) binds: [B:35:0x00fa, B:19:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x00fd: PHI (r10v5 int) = (r10v4 int), (r10v11 int) binds: [B:35:0x00fa, B:19:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x00fd: PHI (r11v4 int) = (r11v3 int), (r11v8 int) binds: [B:35:0x00fa, B:19:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x00fd: PHI (r12v5 byte[]) = (r12v4 byte[]), (r12v13 byte[]) binds: [B:35:0x00fa, B:19:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object writeChunk(io.ktor.utils.io.ByteWriteChannel r9, byte[] r10, int r11, int r12, e9.InterfaceC4014c<? super java.lang.Integer> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.ChunkedTransferEncodingKt.writeChunk(io.ktor.utils.io.ByteWriteChannel, byte[], int, int, e9.c):java.lang.Object");
    }

    public static final WriterJob decodeChunked(M m10, ByteReadChannel input, long j10) {
        p.i(m10, "<this>");
        p.i(input, "input");
        return ByteWriteChannelOperationsKt.writer$default(m10, m10.getCoroutineContext(), false, (p9.p) new AnonymousClass1(input, null), 2, (Object) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d4, code lost:
    
        if (r1.getReadBuffer().k() == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d6, code lost:
    
        r3.L$0 = r14;
        r3.L$1 = r1;
        r3.L$2 = r1;
        r3.L$3 = null;
        r3.L$4 = null;
        r3.L$5 = null;
        r3.L$6 = null;
        r3.L$7 = null;
        r3.L$8 = null;
        r3.L$9 = null;
        r3.L$10 = null;
        r3.I$0 = 0;
        r3.label = r8 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f4, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.awaitContent$default(r1, 0, r3, r8 ? 1 : 0, null) != r2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f8, code lost:
    
        r11 = r1;
        r12 = r11;
        r1 = r3;
        r3 = 0;
        r13 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0109, code lost:
    
        r12 = r1;
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01d2, code lost:
    
        rethrowCloseCause(r1);
        r15 = io.ktor.http.cio.ChunkedTransferEncodingKt.LastChunkBytes;
        r3.L$0 = r14;
        r3.L$1 = r1;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.L$4 = null;
        r3.L$5 = null;
        r3.L$6 = null;
        r3.L$7 = null;
        r3.L$8 = null;
        r3.L$9 = null;
        r3.L$10 = null;
        r3.label = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01f0, code lost:
    
        r18 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01fe, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeFully$default(r14, r15, 0, 0, r18, 6, null) != r2) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0201, code lost:
    
        r3 = r1;
        r6 = r14;
        r1 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0218, code lost:
    
        if (r6.flush(r1) == r2) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x021e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x021f, code lost:
    
        r3 = r1;
        r6 = r14;
        r1 = r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01d2 A[EDGE_INSN: B:116:0x01d2->B:78:0x01d2 BREAK  A[LOOP:0: B:106:0x00c0->B:119:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c6 A[Catch: all -> 0x0102, TRY_ENTER, TryCatch #1 {all -> 0x0102, blocks: (B:64:0x0198, B:67:0x01a6, B:69:0x01ac, B:70:0x01b1, B:71:0x01b8, B:72:0x01b9, B:73:0x01c0, B:37:0x00c6, B:39:0x00cc, B:41:0x00d6), top: B:103:0x0198 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0111 A[Catch: all -> 0x0142, TryCatch #0 {all -> 0x0142, blocks: (B:50:0x010b, B:52:0x0111, B:54:0x0126, B:56:0x013b, B:59:0x0146, B:75:0x01c7, B:76:0x01ce), top: B:101:0x010b }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x013b -> B:103:0x0198). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x018a -> B:63:0x0192). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x01cf -> B:106:0x00c0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object encodeChunked(io.ktor.utils.io.ByteWriteChannel r21, io.ktor.utils.io.ByteReadChannel r22, e9.InterfaceC4014c<? super Y8.t> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.ChunkedTransferEncodingKt.encodeChunked(io.ktor.utils.io.ByteWriteChannel, io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x01a3, code lost:
    
        if (r9.flushAndClose(r0) != r1) goto L72;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00db A[Catch: all -> 0x006a, TryCatch #2 {all -> 0x006a, blocks: (B:15:0x0065, B:55:0x0140, B:57:0x0148, B:33:0x00d3, B:35:0x00db, B:37:0x00e1, B:39:0x00e7, B:45:0x00fa, B:48:0x010e, B:51:0x0123, B:52:0x0124, B:42:0x00f2, B:67:0x017b, B:68:0x0182, B:63:0x0157, B:64:0x015e, B:65:0x015f, B:66:0x017a, B:20:0x007d, B:23:0x0092, B:26:0x00a8), top: B:87:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0148 A[Catch: all -> 0x006a, TryCatch #2 {all -> 0x006a, blocks: (B:15:0x0065, B:55:0x0140, B:57:0x0148, B:33:0x00d3, B:35:0x00db, B:37:0x00e1, B:39:0x00e7, B:45:0x00fa, B:48:0x010e, B:51:0x0123, B:52:0x0124, B:42:0x00f2, B:67:0x017b, B:68:0x0182, B:63:0x0157, B:64:0x015e, B:65:0x015f, B:66:0x017a, B:20:0x007d, B:23:0x0092, B:26:0x00a8), top: B:87:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015f A[Catch: all -> 0x006a, TryCatch #2 {all -> 0x006a, blocks: (B:15:0x0065, B:55:0x0140, B:57:0x0148, B:33:0x00d3, B:35:0x00db, B:37:0x00e1, B:39:0x00e7, B:45:0x00fa, B:48:0x010e, B:51:0x0123, B:52:0x0124, B:42:0x00f2, B:67:0x017b, B:68:0x0182, B:63:0x0157, B:64:0x015e, B:65:0x015f, B:66:0x017a, B:20:0x007d, B:23:0x0092, B:26:0x00a8), top: B:87:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0183 A[PHI: r2 r7 r9 r10
      0x0183: PHI (r2v14 java.lang.StringBuilder) = (r2v20 java.lang.StringBuilder), (r2v21 java.lang.StringBuilder) binds: [B:34:0x00d9, B:61:0x0152] A[DONT_GENERATE, DONT_INLINE]
      0x0183: PHI (r7v11 long) = (r7v9 long), (r7v12 long) binds: [B:34:0x00d9, B:61:0x0152] A[DONT_GENERATE, DONT_INLINE]
      0x0183: PHI (r9v14 io.ktor.utils.io.ByteWriteChannel) = (r9v10 io.ktor.utils.io.ByteWriteChannel), (r9v15 io.ktor.utils.io.ByteWriteChannel) binds: [B:34:0x00d9, B:61:0x0152] A[DONT_GENERATE, DONT_INLINE]
      0x0183: PHI (r10v13 io.ktor.utils.io.ByteReadChannel) = (r10v10 io.ktor.utils.io.ByteReadChannel), (r10v14 io.ktor.utils.io.ByteReadChannel) binds: [B:34:0x00d9, B:61:0x0152] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Appendable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x013c -> B:55:0x0140). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object decodeChunked(io.ktor.utils.io.ByteReadChannel r12, io.ktor.utils.io.ByteWriteChannel r13, e9.InterfaceC4014c<? super Y8.t> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.ChunkedTransferEncodingKt.decodeChunked(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, e9.c):java.lang.Object");
    }
}
