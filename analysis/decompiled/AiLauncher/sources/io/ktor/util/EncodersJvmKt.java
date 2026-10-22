package io.ktor.util;

import Ua.C1073o0;
import Ua.CoroutineName;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000F\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0082\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u001a)\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a,\u0010\u0013\u001a\u00020\u0000*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0015\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0017\u0010\u001c\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001b\"\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"", "flag", "", "has", "(II)Z", "Lio/ktor/utils/io/ByteReadChannel;", "source", "gzip", "Lkotlin/coroutines/d;", "coroutineContext", "inflate", "(Lio/ktor/utils/io/ByteReadChannel;ZLkotlin/coroutines/d;)Lio/ktor/utils/io/ByteReadChannel;", "Ljava/util/zip/Inflater;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "Ljava/nio/ByteBuffer;", "buffer", "Ljava/util/zip/Checksum;", "checksum", "inflateTo", "(Ljava/util/zip/Inflater;Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/ByteBuffer;Ljava/util/zip/Checksum;Le9/c;)Ljava/lang/Object;", "GZIP_HEADER_SIZE", "I", "Lio/ktor/util/Encoder;", "Deflate", "Lio/ktor/util/Encoder;", "getDeflate", "()Lio/ktor/util/Encoder;", "GZip", "getGZip", "LUa/L;", "InflateWriterCoroutineName", "LUa/L;", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EncodersJvmKt {
    private static final int GZIP_HEADER_SIZE = 10;
    private static final Encoder Deflate = new Encoder() { // from class: io.ktor.util.EncodersJvmKt$Deflate$1
        @Override // io.ktor.util.Encoder
        public ByteReadChannel decode(ByteReadChannel source, kotlin.coroutines.d coroutineContext) {
            kotlin.jvm.internal.p.i(source, "source");
            kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
            return EncodersJvmKt.inflate(source, false, coroutineContext);
        }

        @Override // io.ktor.util.Encoder
        public ByteReadChannel encode(ByteReadChannel source, kotlin.coroutines.d coroutineContext) {
            kotlin.jvm.internal.p.i(source, "source");
            kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
            return DeflaterKt.deflated$default(source, false, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteWriteChannel encode(ByteWriteChannel source, kotlin.coroutines.d coroutineContext) {
            kotlin.jvm.internal.p.i(source, "source");
            kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
            return DeflaterKt.deflated$default(source, false, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }
    };
    private static final Encoder GZip = new Encoder() { // from class: io.ktor.util.EncodersJvmKt$GZip$1
        @Override // io.ktor.util.Encoder
        public ByteReadChannel decode(ByteReadChannel source, kotlin.coroutines.d coroutineContext) {
            kotlin.jvm.internal.p.i(source, "source");
            kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
            return EncodersJvmKt.inflate$default(source, false, coroutineContext, 2, null);
        }

        @Override // io.ktor.util.Encoder
        public ByteReadChannel encode(ByteReadChannel source, kotlin.coroutines.d coroutineContext) {
            kotlin.jvm.internal.p.i(source, "source");
            kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
            return DeflaterKt.deflated$default(source, true, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteWriteChannel encode(ByteWriteChannel source, kotlin.coroutines.d coroutineContext) {
            kotlin.jvm.internal.p.i(source, "source");
            kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
            return DeflaterKt.deflated$default(source, true, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }
    };
    private static final CoroutineName InflateWriterCoroutineName = new CoroutineName("encoder-inflate-writer");

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/WriterScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/WriterScope;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.util.EncodersJvmKt$inflate$1", f = "EncodersJvm.kt", l = {90, 107, 108, 118, 125, 130, 142}, m = "invokeSuspend")
    /* renamed from: io.ktor.util.EncodersJvmKt$inflate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<WriterScope, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ boolean $gzip;
        final /* synthetic */ ByteReadChannel $source;
        byte B$0;
        byte B$1;
        int I$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        short S$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z10, ByteReadChannel byteReadChannel, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$gzip = z10;
            this.$source = byteReadChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$gzip, this.$source, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(WriterScope writerScope, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(writerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x019e, code lost:
        
            if (io.ktor.utils.io.ByteReadChannelOperationsKt.discardExact(r15, r6, r18) != r2) goto L37;
         */
        /* JADX WARN: Removed duplicated region for block: B:30:0x014b  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x01aa  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x01b1  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0227  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0254 A[Catch: all -> 0x003c, TryCatch #1 {all -> 0x003c, blocks: (B:7:0x0034, B:92:0x0311, B:86:0x02ea, B:88:0x02f0, B:93:0x0328, B:95:0x032c, B:97:0x0334, B:99:0x0354, B:102:0x0359, B:103:0x037d, B:104:0x037e, B:105:0x0385, B:106:0x0386, B:107:0x03a9, B:108:0x03aa, B:112:0x03c4, B:113:0x03cb, B:72:0x028a, B:74:0x0290, B:76:0x0296, B:82:0x02d8, B:64:0x024c, B:66:0x0254, B:69:0x0270, B:71:0x0278, B:83:0x02dd, B:85:0x02e5, B:114:0x03cc, B:17:0x007e, B:63:0x0242), top: B:121:0x000f }] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0278 A[Catch: all -> 0x003c, TryCatch #1 {all -> 0x003c, blocks: (B:7:0x0034, B:92:0x0311, B:86:0x02ea, B:88:0x02f0, B:93:0x0328, B:95:0x032c, B:97:0x0334, B:99:0x0354, B:102:0x0359, B:103:0x037d, B:104:0x037e, B:105:0x0385, B:106:0x0386, B:107:0x03a9, B:108:0x03aa, B:112:0x03c4, B:113:0x03cb, B:72:0x028a, B:74:0x0290, B:76:0x0296, B:82:0x02d8, B:64:0x024c, B:66:0x0254, B:69:0x0270, B:71:0x0278, B:83:0x02dd, B:85:0x02e5, B:114:0x03cc, B:17:0x007e, B:63:0x0242), top: B:121:0x000f }] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0290 A[Catch: all -> 0x003c, TryCatch #1 {all -> 0x003c, blocks: (B:7:0x0034, B:92:0x0311, B:86:0x02ea, B:88:0x02f0, B:93:0x0328, B:95:0x032c, B:97:0x0334, B:99:0x0354, B:102:0x0359, B:103:0x037d, B:104:0x037e, B:105:0x0385, B:106:0x0386, B:107:0x03a9, B:108:0x03aa, B:112:0x03c4, B:113:0x03cb, B:72:0x028a, B:74:0x0290, B:76:0x0296, B:82:0x02d8, B:64:0x024c, B:66:0x0254, B:69:0x0270, B:71:0x0278, B:83:0x02dd, B:85:0x02e5, B:114:0x03cc, B:17:0x007e, B:63:0x0242), top: B:121:0x000f }] */
        /* JADX WARN: Removed duplicated region for block: B:83:0x02dd A[Catch: all -> 0x003c, TryCatch #1 {all -> 0x003c, blocks: (B:7:0x0034, B:92:0x0311, B:86:0x02ea, B:88:0x02f0, B:93:0x0328, B:95:0x032c, B:97:0x0334, B:99:0x0354, B:102:0x0359, B:103:0x037d, B:104:0x037e, B:105:0x0385, B:106:0x0386, B:107:0x03a9, B:108:0x03aa, B:112:0x03c4, B:113:0x03cb, B:72:0x028a, B:74:0x0290, B:76:0x0296, B:82:0x02d8, B:64:0x024c, B:66:0x0254, B:69:0x0270, B:71:0x0278, B:83:0x02dd, B:85:0x02e5, B:114:0x03cc, B:17:0x007e, B:63:0x0242), top: B:121:0x000f }] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x02f0 A[Catch: all -> 0x003c, TryCatch #1 {all -> 0x003c, blocks: (B:7:0x0034, B:92:0x0311, B:86:0x02ea, B:88:0x02f0, B:93:0x0328, B:95:0x032c, B:97:0x0334, B:99:0x0354, B:102:0x0359, B:103:0x037d, B:104:0x037e, B:105:0x0385, B:106:0x0386, B:107:0x03a9, B:108:0x03aa, B:112:0x03c4, B:113:0x03cb, B:72:0x028a, B:74:0x0290, B:76:0x0296, B:82:0x02d8, B:64:0x024c, B:66:0x0254, B:69:0x0270, B:71:0x0278, B:83:0x02dd, B:85:0x02e5, B:114:0x03cc, B:17:0x007e, B:63:0x0242), top: B:121:0x000f }] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0328 A[Catch: all -> 0x003c, TryCatch #1 {all -> 0x003c, blocks: (B:7:0x0034, B:92:0x0311, B:86:0x02ea, B:88:0x02f0, B:93:0x0328, B:95:0x032c, B:97:0x0334, B:99:0x0354, B:102:0x0359, B:103:0x037d, B:104:0x037e, B:105:0x0385, B:106:0x0386, B:107:0x03a9, B:108:0x03aa, B:112:0x03c4, B:113:0x03cb, B:72:0x028a, B:74:0x0290, B:76:0x0296, B:82:0x02d8, B:64:0x024c, B:66:0x0254, B:69:0x0270, B:71:0x0278, B:83:0x02dd, B:85:0x02e5, B:114:0x03cc, B:17:0x007e, B:63:0x0242), top: B:121:0x000f }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0276 -> B:64:0x024c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0278 -> B:72:0x028a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x02b6 -> B:80:0x02bd). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x0310 -> B:92:0x0311). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 1014
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.EncodersJvmKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @InterfaceC4112d(c = "io.ktor.util.EncodersJvmKt", f = "EncodersJvm.kt", l = {178}, m = "inflateTo")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.util.EncodersJvmKt$inflateTo$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44161 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C44161(InterfaceC4014c<? super C44161> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EncodersJvmKt.inflateTo(null, null, null, null, this);
        }
    }

    public static final Encoder getDeflate() {
        return Deflate;
    }

    public static final Encoder getGZip() {
        return GZip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean has(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel inflate(ByteReadChannel byteReadChannel, boolean z10, kotlin.coroutines.d dVar) {
        return ByteWriteChannelOperationsKt.writer$default((M) C1073o0.f6391a, dVar.plus(InflateWriterCoroutineName), false, (p9.p) new AnonymousClass1(z10, byteReadChannel, null), 2, (Object) null).getChannel();
    }

    public static /* synthetic */ ByteReadChannel inflate$default(ByteReadChannel byteReadChannel, boolean z10, kotlin.coroutines.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return inflate(byteReadChannel, z10, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object inflateTo(java.util.zip.Inflater r5, io.ktor.utils.io.ByteWriteChannel r6, java.nio.ByteBuffer r7, java.util.zip.Checksum r8, e9.InterfaceC4014c<? super java.lang.Integer> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.util.EncodersJvmKt.C44161
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.util.EncodersJvmKt$inflateTo$1 r0 = (io.ktor.util.EncodersJvmKt.C44161) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.util.EncodersJvmKt$inflateTo$1 r0 = new io.ktor.util.EncodersJvmKt$inflateTo$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$3
            java.util.zip.Checksum r6 = (java.util.zip.Checksum) r6
            java.lang.Object r6 = r0.L$2
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r6 = (io.ktor.utils.io.ByteWriteChannel) r6
            java.lang.Object r6 = r0.L$0
            java.util.zip.Inflater r6 = (java.util.zip.Inflater) r6
            kotlin.C4849c.b(r9)
            goto L8b
        L3b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L43:
            kotlin.C4849c.b(r9)
            r7.clear()
            byte[] r9 = r7.array()
            int r2 = r7.position()
            int r4 = r7.remaining()
            int r9 = r5.inflate(r9, r2, r4)
            int r2 = r7.position()
            int r2 = r2 + r9
            r7.position(r2)
            r7.flip()
            io.ktor.util.DeflaterKt.updateKeepPosition(r8, r7)
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            java.lang.Object r5 = g9.h.a(r6)
            r0.L$1 = r5
            java.lang.Object r5 = g9.h.a(r7)
            r0.L$2 = r5
            java.lang.Object r5 = g9.h.a(r8)
            r0.L$3 = r5
            r0.I$0 = r9
            r0.label = r3
            java.lang.Object r5 = io.ktor.utils.io.ByteWriteChannelOperations_jvmKt.writeFully(r6, r7, r0)
            if (r5 != r1) goto L8a
            return r1
        L8a:
            r5 = r9
        L8b:
            java.lang.Integer r5 = g9.C4109a.f(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.EncodersJvmKt.inflateTo(java.util.zip.Inflater, io.ktor.utils.io.ByteWriteChannel, java.nio.ByteBuffer, java.util.zip.Checksum, e9.c):java.lang.Object");
    }
}
