package io.ktor.http.cio;

import La.C0951a;
import Ua.M;
import Wa.r;
import Y8.t;
import Z8.C1168p;
import com.zyql.ai.selector.camera.CustomCameraView;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import gb.C4114a;
import io.ktor.http.ContentType;
import io.ktor.http.cio.internals.CharsKt;
import io.ktor.http.cio.internals.UnsupportedMediaTypeExceptionCIO;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.core.StringsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.channels.ProduceKt;
import p9.p;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0004\u001a2\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\b\u0010\t\u001a\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@¢\u0006\u0004\b\u000b\u0010\f\u001a8\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0012\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0000H\u0082@¢\u0006\u0004\b\u0012\u0010\u0013\u001a1\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019\u001a;\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u001d\u001a;\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00142\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u001f\u001a\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b!\u0010\"\u001a\u0017\u0010$\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b$\u0010%\u001a\u001f\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010)\"\u0014\u0010*\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+\"\u0014\u0010-\u001a\u00020,8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010.\"\u0014\u0010/\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010+¨\u00060"}, d2 = {"Lgb/a;", "boundary", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "", "limit", "parsePreambleImpl", "(Lgb/a;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLe9/c;)Ljava/lang/Object;", "Lio/ktor/http/cio/HttpHeadersMap;", "parsePartHeadersImpl", "(Lio/ktor/utils/io/ByteReadChannel;Le9/c;)Ljava/lang/Object;", "boundaryPrefixed", "headers", "parsePartBodyImpl", "(Lgb/a;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/http/cio/HttpHeadersMap;JLe9/c;)Ljava/lang/Object;", "prefix", "skipIfFoundReadCount", "(Lio/ktor/utils/io/ByteReadChannel;Lgb/a;Le9/c;)Ljava/lang/Object;", "LUa/M;", "maxPartSize", "LWa/r;", "Lio/ktor/http/cio/MultipartEvent;", "parseMultipart", "(LUa/M;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/cio/HttpHeadersMap;J)LWa/r;", "", "contentType", "contentLength", "(LUa/M;Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/CharSequence;Ljava/lang/Long;J)LWa/r;", "totalLength", "(LUa/M;Lgb/a;Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Long;J)LWa/r;", "", "findBoundary", "(Ljava/lang/CharSequence;)I", "", "parseBoundaryInternal", "(Ljava/lang/CharSequence;)[B", "actual", "", "throwLimitExceeded", "(JJ)Ljava/lang/Void;", "CrLf", "Lgb/a;", "", "PrefixChar", "B", "PrefixString", "ktor-http-cio"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MultipartKt {
    private static final C4114a CrLf = new C4114a(StringsKt.toByteArray$default(ServerSentEventKt.END_OF_LINE, null, 1, null), 0, 0, 6, null);
    private static final byte PrefixChar = 45;
    private static final C4114a PrefixString = gb.c.a(PrefixChar, PrefixChar);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LWa/p;", "Lio/ktor/http/cio/MultipartEvent;", "LY8/t;", "<anonymous>", "(LWa/p;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.http.cio.MultipartKt$parseMultipart$1", f = "Multipart.kt", l = {208, 211, 214, 215, 218, 225, 229, 236, 248, 249, 256, 256, CustomCameraView.BUTTON_STATE_BOTH, 261}, m = "invokeSuspend")
    /* renamed from: io.ktor.http.cio.MultipartKt$parseMultipart$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<Wa.p<? super MultipartEvent>, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ C4114a $boundaryPrefixed;
        final /* synthetic */ ByteReadChannel $input;
        final /* synthetic */ long $maxPartSize;
        final /* synthetic */ Long $totalLength;
        long J$0;
        long J$1;
        long J$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ByteReadChannel byteReadChannel, C4114a c4114a, long j10, Long l10, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$input = byteReadChannel;
            this.$boundaryPrefixed = c4114a;
            this.$maxPartSize = j10;
            this.$totalLength = l10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$input, this.$boundaryPrefixed, this.$maxPartSize, this.$totalLength, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(Wa.p<? super MultipartEvent> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(pVar, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x0422, code lost:
        
            if (r5.send(r15, r23) != r13) goto L128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:126:0x0483, code lost:
        
            if (r7.send(r1, r23) == r13) goto L127;
         */
        /* JADX WARN: Removed duplicated region for block: B:102:0x0380 A[PHI: r1 r2 r3 r5 r7 r14 r18
          0x0380: PHI (r1v18 io.ktor.http.cio.HttpHeadersMap) = (r1v3 io.ktor.http.cio.HttpHeadersMap), (r1v19 io.ktor.http.cio.HttpHeadersMap) binds: [B:100:0x037c, B:12:0x0085] A[DONT_GENERATE, DONT_INLINE]
          0x0380: PHI (r2v13 fb.v) = (r2v1 fb.v), (r2v15 fb.v) binds: [B:100:0x037c, B:12:0x0085] A[DONT_GENERATE, DONT_INLINE]
          0x0380: PHI (r3v17 gb.a) = (r3v1 gb.a), (r3v19 gb.a) binds: [B:100:0x037c, B:12:0x0085] A[DONT_GENERATE, DONT_INLINE]
          0x0380: PHI (r5v33 io.ktor.utils.io.CountedByteReadChannel) = (r5v20 io.ktor.utils.io.CountedByteReadChannel), (r5v35 io.ktor.utils.io.CountedByteReadChannel) binds: [B:100:0x037c, B:12:0x0085] A[DONT_GENERATE, DONT_INLINE]
          0x0380: PHI (r7v12 Wa.p) = (r7v2 Wa.p), (r7v1 Wa.p) binds: [B:100:0x037c, B:12:0x0085] A[DONT_GENERATE, DONT_INLINE]
          0x0380: PHI (r14v17 long) = (r14v6 long), (r14v18 long) binds: [B:100:0x037c, B:12:0x0085] A[DONT_GENERATE, DONT_INLINE]
          0x0380: PHI (r18v19 long) = (r18v10 long), (r18v20 long) binds: [B:100:0x037c, B:12:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:107:0x03a6  */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0082 A[PHI: r1 r2 r3 r5 r7 r14 r18
          0x0082: PHI (r1v20 io.ktor.http.cio.HttpHeadersMap) = (r1v18 io.ktor.http.cio.HttpHeadersMap), (r1v22 io.ktor.http.cio.HttpHeadersMap) binds: [B:103:0x039e, B:10:0x006d] A[DONT_GENERATE, DONT_INLINE]
          0x0082: PHI (r2v16 fb.v) = (r2v13 fb.v), (r2v19 fb.v) binds: [B:103:0x039e, B:10:0x006d] A[DONT_GENERATE, DONT_INLINE]
          0x0082: PHI (r3v20 gb.a) = (r3v17 gb.a), (r3v22 gb.a) binds: [B:103:0x039e, B:10:0x006d] A[DONT_GENERATE, DONT_INLINE]
          0x0082: PHI (r5v36 io.ktor.utils.io.CountedByteReadChannel) = (r5v33 io.ktor.utils.io.CountedByteReadChannel), (r5v44 io.ktor.utils.io.CountedByteReadChannel) binds: [B:103:0x039e, B:10:0x006d] A[DONT_GENERATE, DONT_INLINE]
          0x0082: PHI (r7v13 Wa.p) = (r7v12 Wa.p), (r7v1 Wa.p) binds: [B:103:0x039e, B:10:0x006d] A[DONT_GENERATE, DONT_INLINE]
          0x0082: PHI (r14v19 long) = (r14v17 long), (r14v21 long) binds: [B:103:0x039e, B:10:0x006d] A[DONT_GENERATE, DONT_INLINE]
          0x0082: PHI (r18v21 long) = (r18v19 long), (r18v22 long) binds: [B:103:0x039e, B:10:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:120:0x042d  */
        /* JADX WARN: Removed duplicated region for block: B:125:0x0456  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00f0 A[PHI: r0 r2 r4 r5 r7 r8 r9 r10 r11 r12 r14 r18
          0x00f0: PHI (r0v21 long) = (r0v16 long), (r0v32 long) binds: [B:20:0x00ec, B:65:0x02cd] A[DONT_GENERATE, DONT_INLINE]
          0x00f0: PHI (r2v2 boolean) = (r2v0 boolean), (r2v5 boolean) binds: [B:20:0x00ec, B:65:0x02cd] A[DONT_GENERATE, DONT_INLINE]
          0x00f0: PHI (r4v7 io.ktor.http.cio.HttpHeadersMap) = (r4v38 io.ktor.http.cio.HttpHeadersMap), (r4v44 io.ktor.http.cio.HttpHeadersMap) binds: [B:20:0x00ec, B:65:0x02cd] A[DONT_GENERATE, DONT_INLINE]
          0x00f0: PHI (r5v21 io.ktor.http.cio.MultipartEvent$MultipartPart) = (r5v18 io.ktor.http.cio.MultipartEvent$MultipartPart), (r5v23 io.ktor.http.cio.MultipartEvent$MultipartPart) binds: [B:20:0x00ec, B:65:0x02cd] A[DONT_GENERATE, DONT_INLINE]
          0x00f0: PHI (r7v3 Wa.p) = (r7v1 Wa.p), (r7v6 Wa.p) binds: [B:20:0x00ec, B:65:0x02cd] A[DONT_GENERATE, DONT_INLINE]
          0x00f0: PHI (r8v26 Ua.u) = (r8v23 Ua.u), (r8v29 Ua.u) binds: [B:20:0x00ec, B:65:0x02cd] A[DONT_GENERATE, DONT_INLINE]
          0x00f0: PHI (r9v20 io.ktor.utils.io.ByteChannel) = (r9v16 io.ktor.utils.io.ByteChannel), (r9v26 io.ktor.utils.io.ByteChannel) binds: [B:20:0x00ec, B:65:0x02cd] A[DONT_GENERATE, DONT_INLINE]
          0x00f0: PHI (r10v10 fb.v) = (r10v9 fb.v), (r10v12 fb.v) binds: [B:20:0x00ec, B:65:0x02cd] A[DONT_GENERATE, DONT_INLINE]
          0x00f0: PHI (r11v5 gb.a) = (r11v4 gb.a), (r11v7 gb.a) binds: [B:20:0x00ec, B:65:0x02cd] A[DONT_GENERATE, DONT_INLINE]
          0x00f0: PHI (r12v5 io.ktor.utils.io.CountedByteReadChannel) = (r12v4 io.ktor.utils.io.CountedByteReadChannel), (r12v7 io.ktor.utils.io.CountedByteReadChannel) binds: [B:20:0x00ec, B:65:0x02cd] A[DONT_GENERATE, DONT_INLINE]
          0x00f0: PHI (r14v7 java.lang.Object) = (r14v5 java.lang.Object), (r14v12 java.lang.Object) binds: [B:20:0x00ec, B:65:0x02cd] A[DONT_GENERATE, DONT_INLINE]
          0x00f0: PHI (r18v11 long) = (r18v9 long), (r18v12 long) binds: [B:20:0x00ec, B:65:0x02cd] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0136 A[PHI: r0 r2 r3 r4 r5 r7 r8 r9 r10 r18
          0x0136: PHI (r0v34 long) = (r0v14 long), (r0v37 long) binds: [B:25:0x0121, B:55:0x0269] A[DONT_GENERATE, DONT_INLINE]
          0x0136: PHI (r2v6 boolean) = (r2v0 boolean), (r2v7 boolean) binds: [B:25:0x0121, B:55:0x0269] A[DONT_GENERATE, DONT_INLINE]
          0x0136: PHI (r3v10 int) = (r3v0 int), (r3v11 int) binds: [B:25:0x0121, B:55:0x0269] A[DONT_GENERATE, DONT_INLINE]
          0x0136: PHI (r4v13 ??) = (r4v35 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), (r4v42 ??) binds: [B:25:0x0121, B:55:0x0269] A[DONT_GENERATE, DONT_INLINE]
          0x0136: PHI (r5v24 fb.v) = (r5v14 fb.v), (r5v26 fb.v) binds: [B:25:0x0121, B:55:0x0269] A[DONT_GENERATE, DONT_INLINE]
          0x0136: PHI (r7v7 Wa.p) = (r7v1 Wa.p), (r7v8 Wa.p) binds: [B:25:0x0121, B:55:0x0269] A[DONT_GENERATE, DONT_INLINE]
          0x0136: PHI (r8v30 gb.a) = (r8v19 gb.a), (r8v32 gb.a) binds: [B:25:0x0121, B:55:0x0269] A[DONT_GENERATE, DONT_INLINE]
          0x0136: PHI (r9v27 io.ktor.utils.io.CountedByteReadChannel) = (r9v12 io.ktor.utils.io.CountedByteReadChannel), (r9v29 io.ktor.utils.io.CountedByteReadChannel) binds: [B:25:0x0121, B:55:0x0269] A[DONT_GENERATE, DONT_INLINE]
          0x0136: PHI (r10v13 java.lang.Object) = (r10v5 java.lang.Object), (r10v19 java.lang.Object) binds: [B:25:0x0121, B:55:0x0269] A[DONT_GENERATE, DONT_INLINE]
          0x0136: PHI (r18v13 long) = (r18v7 long), (r18v14 long) binds: [B:25:0x0121, B:55:0x0269] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x01e1  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0202 A[PHI: r0 r2 r3 r4 r5 r7 r9 r14 r18
          0x0202: PHI (r0v42 gb.a) = (r0v5 gb.a), (r0v10 gb.a), (r0v35 gb.a), (r0v43 gb.a) binds: [B:36:0x01df, B:41:0x0200, B:58:0x0273, B:77:0x0318] A[DONT_GENERATE, DONT_INLINE]
          0x0202: PHI (r2v9 boolean) = (r2v0 boolean), (r2v0 boolean), (r2v6 boolean), (r2v11 boolean) binds: [B:36:0x01df, B:41:0x0200, B:58:0x0273, B:77:0x0318] A[DONT_GENERATE, DONT_INLINE]
          0x0202: PHI (r3v14 int) = (r3v0 int), (r3v0 int), (r3v10 int), (r3v16 int) binds: [B:36:0x01df, B:41:0x0200, B:58:0x0273, B:77:0x0318] A[DONT_GENERATE, DONT_INLINE]
          0x0202: PHI (r4v16 io.ktor.http.cio.HttpHeadersMap) = 
          (r4v32 io.ktor.http.cio.HttpHeadersMap)
          (r4v0 io.ktor.http.cio.HttpHeadersMap)
          (r4v39 io.ktor.http.cio.HttpHeadersMap)
          (r4v18 io.ktor.http.cio.HttpHeadersMap)
         binds: [B:36:0x01df, B:41:0x0200, B:58:0x0273, B:77:0x0318] A[DONT_GENERATE, DONT_INLINE]
          0x0202: PHI (r5v28 fb.v) = (r5v3 fb.v), (r5v6 fb.v), (r5v24 fb.v), (r5v29 fb.v) binds: [B:36:0x01df, B:41:0x0200, B:58:0x0273, B:77:0x0318] A[DONT_GENERATE, DONT_INLINE]
          0x0202: PHI (r7v10 Wa.p) = (r7v1 Wa.p), (r7v1 Wa.p), (r7v7 Wa.p), (r7v11 Wa.p) binds: [B:36:0x01df, B:41:0x0200, B:58:0x0273, B:77:0x0318] A[DONT_GENERATE, DONT_INLINE]
          0x0202: PHI (r9v31 io.ktor.utils.io.CountedByteReadChannel) = 
          (r9v2 io.ktor.utils.io.CountedByteReadChannel)
          (r9v4 io.ktor.utils.io.CountedByteReadChannel)
          (r9v27 io.ktor.utils.io.CountedByteReadChannel)
          (r9v33 io.ktor.utils.io.CountedByteReadChannel)
         binds: [B:36:0x01df, B:41:0x0200, B:58:0x0273, B:77:0x0318] A[DONT_GENERATE, DONT_INLINE]
          0x0202: PHI (r14v15 long) = (r14v1 long), (r14v3 long), (r14v13 long), (r14v16 long) binds: [B:36:0x01df, B:41:0x0200, B:58:0x0273, B:77:0x0318] A[DONT_GENERATE, DONT_INLINE]
          0x0202: PHI (r18v16 long) = (r18v1 long), (r18v3 long), (r18v13 long), (r18v17 long) binds: [B:36:0x01df, B:41:0x0200, B:58:0x0273, B:77:0x0318] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0208  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0236  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0276  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x02d9 A[Catch: all -> 0x0329, TRY_LEAVE, TryCatch #2 {all -> 0x0329, blocks: (B:68:0x02d3, B:70:0x02d9), top: B:134:0x02d3 }] */
        /* JADX WARN: Removed duplicated region for block: B:83:0x032c  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x034f  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0354  */
        /* JADX WARN: Type inference failed for: r4v13, types: [java.lang.Object, kotlin.jvm.internal.i, kotlinx.coroutines.g] */
        /* JADX WARN: Type inference failed for: r4v35 */
        /* JADX WARN: Type inference failed for: r4v42 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0273 -> B:42:0x0202). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x030b -> B:76:0x0315). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 1196
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.MultipartKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @InterfaceC4112d(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", l = {132, 133, 133, 136}, m = "parsePartBodyImpl")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.cio.MultipartKt$parsePartBodyImpl$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42901 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C42901(InterfaceC4014c<? super C42901> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultipartKt.parsePartBodyImpl(null, null, null, null, 0L, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", l = {113}, m = "parsePartHeadersImpl")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.cio.MultipartKt$parsePartHeadersImpl$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42911 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C42911(InterfaceC4014c<? super C42911> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultipartKt.parsePartHeadersImpl(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", l = {143}, m = "skipIfFoundReadCount")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.cio.MultipartKt$skipIfFoundReadCount$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42921 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C42921(InterfaceC4014c<? super C42921> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultipartKt.skipIfFoundReadCount(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int findBoundary(java.lang.CharSequence r12) {
        /*
            int r0 = r12.length()
            r1 = 0
            r2 = r1
            r3 = r2
            r4 = r3
        L8:
            if (r2 >= r0) goto L5f
            char r5 = r12.charAt(r2)
            r6 = 59
            r7 = 1
            if (r3 == 0) goto L59
            r8 = 44
            r9 = 2
            if (r3 == r7) goto L3a
            r10 = 34
            r11 = 3
            if (r3 == r9) goto L31
            r6 = 4
            if (r3 == r11) goto L25
            if (r3 == r6) goto L23
            goto L5c
        L23:
            r3 = r11
            goto L5c
        L25:
            if (r5 == r10) goto L2e
            r7 = 92
            if (r5 == r7) goto L2c
            goto L5c
        L2c:
            r3 = r6
            goto L5c
        L2e:
            r4 = r1
            r3 = r7
            goto L5c
        L31:
            if (r5 == r10) goto L23
            if (r5 == r8) goto L38
            if (r5 == r6) goto L2e
            goto L5c
        L38:
            r3 = r1
            goto L5c
        L3a:
            r10 = 61
            if (r5 != r10) goto L40
            r3 = r9
            goto L5c
        L40:
            if (r5 != r6) goto L44
            r4 = r1
            goto L5c
        L44:
            if (r5 != r8) goto L47
            goto L38
        L47:
            r6 = 32
            if (r5 == r6) goto L5c
            if (r4 != 0) goto L56
            java.lang.String r5 = "boundary="
            boolean r5 = La.H.g1(r12, r5, r2, r7)
            if (r5 == 0) goto L56
            return r2
        L56:
            int r4 = r4 + 1
            goto L5c
        L59:
            if (r5 != r6) goto L5c
            goto L2e
        L5c:
            int r2 = r2 + 1
            goto L8
        L5f:
            r12 = -1
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.MultipartKt.findBoundary(java.lang.CharSequence):int");
    }

    public static final byte[] parseBoundaryInternal(CharSequence contentType) throws IOException {
        kotlin.jvm.internal.p.i(contentType, "contentType");
        int iFindBoundary = findBoundary(contentType);
        if (iFindBoundary == -1) {
            throw new IOException("Failed to parse multipart: Content-Type's boundary parameter is missing");
        }
        byte[] bArr = new byte[74];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        parseBoundaryInternal$put(ref$IntRef, bArr, (byte) 13);
        parseBoundaryInternal$put(ref$IntRef, bArr, (byte) 10);
        parseBoundaryInternal$put(ref$IntRef, bArr, PrefixChar);
        parseBoundaryInternal$put(ref$IntRef, bArr, PrefixChar);
        int length = contentType.length();
        char c10 = 0;
        for (int i10 = iFindBoundary + 9; i10 < length; i10++) {
            char cCharAt = contentType.charAt(i10);
            int i11 = cCharAt & 65535;
            if ((65535 & cCharAt) > 127) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to parse multipart: wrong boundary byte 0x");
                String string = Integer.toString(i11, C0951a.a(16));
                kotlin.jvm.internal.p.h(string, "toString(...)");
                sb2.append(string);
                sb2.append(" - should be 7bit character");
                throw new IOException(sb2.toString());
            }
            if (c10 != 0) {
                if (c10 == 1) {
                    if (cCharAt == ' ' || cCharAt == ',' || cCharAt == ';') {
                        break;
                    }
                    parseBoundaryInternal$put(ref$IntRef, bArr, (byte) i11);
                } else if (c10 == 2) {
                    if (cCharAt == '\"') {
                        break;
                    }
                    if (cCharAt != '\\') {
                        parseBoundaryInternal$put(ref$IntRef, bArr, (byte) i11);
                    } else {
                        c10 = 3;
                    }
                } else if (c10 == 3) {
                    parseBoundaryInternal$put(ref$IntRef, bArr, (byte) i11);
                    c10 = 2;
                }
            } else if (cCharAt == ' ') {
                continue;
            } else if (cCharAt == '\"') {
                c10 = 2;
            } else {
                if (cCharAt == ',' || cCharAt == ';') {
                    break;
                }
                parseBoundaryInternal$put(ref$IntRef, bArr, (byte) i11);
                c10 = 1;
            }
        }
        int i12 = ref$IntRef.f34818a;
        if (i12 != 4) {
            return C1168p.o(bArr, 0, i12);
        }
        throw new IOException("Empty multipart boundary is not allowed");
    }

    private static final void parseBoundaryInternal$put(Ref$IntRef ref$IntRef, byte[] bArr, byte b10) throws IOException {
        int i10 = ref$IntRef.f34818a;
        if (i10 >= bArr.length) {
            throw new IOException("Failed to parse multipart: boundary shouldn't be longer than 70 characters");
        }
        ref$IntRef.f34818a = i10 + 1;
        bArr[i10] = b10;
    }

    public static final r<MultipartEvent> parseMultipart(M m10, ByteReadChannel input, HttpHeadersMap headers, long j10) throws UnsupportedMediaTypeExceptionCIO {
        kotlin.jvm.internal.p.i(m10, "<this>");
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(headers, "headers");
        CharSequence charSequence = headers.get("Content-Type");
        if (charSequence == null) {
            throw new UnsupportedMediaTypeExceptionCIO("Failed to parse multipart: no Content-Type header");
        }
        CharSequence charSequence2 = headers.get("Content-Length");
        return parseMultipart(m10, input, charSequence, charSequence2 != null ? Long.valueOf(CharsKt.parseDecLong(charSequence2)) : null, j10);
    }

    public static /* synthetic */ r parseMultipart$default(M m10, ByteReadChannel byteReadChannel, HttpHeadersMap httpHeadersMap, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return parseMultipart(m10, byteReadChannel, httpHeadersMap, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01a4, code lost:
    
        if (r10.flush(r6) != r7) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object parsePartBodyImpl(gb.C4114a r18, io.ktor.utils.io.ByteReadChannel r19, io.ktor.utils.io.ByteWriteChannel r20, io.ktor.http.cio.HttpHeadersMap r21, long r22, e9.InterfaceC4014c<? super java.lang.Long> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.MultipartKt.parsePartBodyImpl(gb.a, io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, io.ktor.http.cio.HttpHeadersMap, long, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object parsePartHeadersImpl(io.ktor.utils.io.ByteReadChannel r7, e9.InterfaceC4014c<? super io.ktor.http.cio.HttpHeadersMap> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.http.cio.MultipartKt.C42911
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.http.cio.MultipartKt$parsePartHeadersImpl$1 r0 = (io.ktor.http.cio.MultipartKt.C42911) r0
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
            io.ktor.http.cio.MultipartKt$parsePartHeadersImpl$1 r0 = new io.ktor.http.cio.MultipartKt$parsePartHeadersImpl$1
            r0.<init>(r8)
            goto L12
        L1a:
            java.lang.Object r8 = r4.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L3e
            if (r1 != r2) goto L36
            java.lang.Object r7 = r4.L$1
            io.ktor.http.cio.internals.CharArrayBuilder r7 = (io.ktor.http.cio.internals.CharArrayBuilder) r7
            java.lang.Object r0 = r4.L$0
            io.ktor.utils.io.ByteReadChannel r0 = (io.ktor.utils.io.ByteReadChannel) r0
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L33
            goto L5e
        L33:
            r0 = move-exception
            r8 = r0
            goto L6e
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            kotlin.C4849c.b(r8)
            r8 = r2
            io.ktor.http.cio.internals.CharArrayBuilder r2 = new io.ktor.http.cio.internals.CharArrayBuilder
            r1 = 0
            r2.<init>(r1, r8, r1)
            java.lang.Object r1 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L6b
            r4.L$0 = r1     // Catch: java.lang.Throwable -> L6b
            r4.L$1 = r2     // Catch: java.lang.Throwable -> L6b
            r4.label = r8     // Catch: java.lang.Throwable -> L6b
            r3 = 0
            r5 = 4
            r6 = 0
            r1 = r7
            java.lang.Object r8 = io.ktor.http.cio.HttpParserKt.parseHeaders$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L6b
            if (r8 != r0) goto L5d
            return r0
        L5d:
            r7 = r2
        L5e:
            io.ktor.http.cio.HttpHeadersMap r8 = (io.ktor.http.cio.HttpHeadersMap) r8     // Catch: java.lang.Throwable -> L33
            if (r8 == 0) goto L63
            return r8
        L63:
            java.io.EOFException r8 = new java.io.EOFException     // Catch: java.lang.Throwable -> L33
            java.lang.String r0 = "Failed to parse multipart headers: unexpected end of stream"
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L33
            throw r8     // Catch: java.lang.Throwable -> L33
        L6b:
            r0 = move-exception
            r8 = r0
            r7 = r2
        L6e:
            r7.release()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.MultipartKt.parsePartHeadersImpl(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object parsePreambleImpl(C4114a c4114a, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j10, InterfaceC4014c<? super Long> interfaceC4014c) {
        return ByteReadChannelOperationsKt.readUntil(byteReadChannel, c4114a, byteWriteChannel, j10, true, interfaceC4014c);
    }

    public static /* synthetic */ Object parsePreambleImpl$default(C4114a c4114a, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return parsePreambleImpl(c4114a, byteReadChannel, byteWriteChannel, j10, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object skipIfFoundReadCount(io.ktor.utils.io.ByteReadChannel r4, gb.C4114a r5, e9.InterfaceC4014c<? super java.lang.Long> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.http.cio.MultipartKt.C42921
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.http.cio.MultipartKt$skipIfFoundReadCount$1 r0 = (io.ktor.http.cio.MultipartKt.C42921) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.http.cio.MultipartKt$skipIfFoundReadCount$1 r0 = new io.ktor.http.cio.MultipartKt$skipIfFoundReadCount$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            gb.a r5 = (gb.C4114a) r5
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.C4849c.b(r6)
            goto L4e
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.C4849c.b(r6)
            java.lang.Object r6 = g9.h.a(r4)
            r0.L$0 = r6
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = io.ktor.utils.io.ByteReadChannelOperationsKt.skipIfFound(r4, r5, r0)
            if (r6 != r1) goto L4e
            return r1
        L4e:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r4 = r6.booleanValue()
            if (r4 == 0) goto L5c
            int r4 = r5.i()
            long r4 = (long) r4
            goto L5e
        L5c:
            r4 = 0
        L5e:
            java.lang.Long r4 = g9.C4109a.g(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.MultipartKt.skipIfFoundReadCount(io.ktor.utils.io.ByteReadChannel, gb.a, e9.c):java.lang.Object");
    }

    private static final Void throwLimitExceeded(long j10, long j11) throws IOException {
        throw new IOException("Multipart content length exceeds limit " + j10 + " > " + j11 + "; limit is defined using 'formFieldLimit' argument");
    }

    public static /* synthetic */ r parseMultipart$default(M m10, ByteReadChannel byteReadChannel, CharSequence charSequence, Long l10, long j10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return parseMultipart(m10, byteReadChannel, charSequence, l10, j10);
    }

    public static final r<MultipartEvent> parseMultipart(M m10, ByteReadChannel input, CharSequence contentType, Long l10, long j10) throws UnsupportedMediaTypeExceptionCIO {
        kotlin.jvm.internal.p.i(m10, "<this>");
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(contentType, "contentType");
        if (ContentType.MultiPart.INSTANCE.contains(contentType)) {
            return parseMultipart(m10, new C4114a(parseBoundaryInternal(contentType), 0, 0, 6, null), input, l10, j10);
        }
        throw new UnsupportedMediaTypeExceptionCIO("Failed to parse multipart: Content-Type should be multipart/* but it is " + ((Object) contentType));
    }

    private static final r<MultipartEvent> parseMultipart(M m10, C4114a c4114a, ByteReadChannel byteReadChannel, Long l10, long j10) {
        return ProduceKt.e(m10, null, 0, new AnonymousClass1(byteReadChannel, c4114a, j10, l10, null), 3, null);
    }
}
