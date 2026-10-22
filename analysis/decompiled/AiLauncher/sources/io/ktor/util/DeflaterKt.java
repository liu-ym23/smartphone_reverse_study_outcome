package io.ktor.util;

import Ua.C1073o0;
import Ua.CoroutineName;
import Ua.M;
import Ua.Y;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ReaderScope;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.zip.Checksum;
import java.util.zip.Deflater;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001b\u0010\t\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0014\u0010\f\u001a\u00020\u0003*\u00020\u000bH\u0082@¢\u0006\u0004\b\f\u0010\r\u001a$\u0010\u0010\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0000H\u0082@¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0015\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016\u001a6\u0010\u0004\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u00132\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001aH\u0082@¢\u0006\u0004\b\u0004\u0010\u001c\u001a5\u0010\u001f\u001a\u00020\u0017*\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00132\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 \u001a5\u0010\u001f\u001a\u00020\u000b*\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u00132\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010!\"\u0014\u0010#\u001a\u00020\"8\u0000X\u0080T¢\u0006\u0006\n\u0004\b#\u0010$\"\u001a\u0010&\u001a\u00020%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,\"\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010,¨\u0006."}, d2 = {"Ljava/util/zip/Deflater;", "Ljava/nio/ByteBuffer;", "outBuffer", "LY8/t;", "deflateTo", "(Ljava/util/zip/Deflater;Ljava/nio/ByteBuffer;)V", "buffer", "setInputBuffer", "Ljava/util/zip/Checksum;", "updateKeepPosition", "(Ljava/util/zip/Checksum;Ljava/nio/ByteBuffer;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "putGzipHeader", "(Lio/ktor/utils/io/ByteWriteChannel;Le9/c;)Ljava/lang/Object;", "crc", "deflater", "putGzipTrailer", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/util/zip/Checksum;Ljava/util/zip/Deflater;Le9/c;)Ljava/lang/Object;", "Lkotlin/Function0;", "", "predicate", "deflateWhile", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/util/zip/Deflater;Ljava/nio/ByteBuffer;Lp9/a;Le9/c;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "destination", "gzip", "Lio/ktor/utils/io/pool/ObjectPool;", "pool", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;ZLio/ktor/utils/io/pool/ObjectPool;Le9/c;)Ljava/lang/Object;", "Lkotlin/coroutines/d;", "coroutineContext", "deflated", "(Lio/ktor/utils/io/ByteReadChannel;ZLio/ktor/utils/io/pool/ObjectPool;Lkotlin/coroutines/d;)Lio/ktor/utils/io/ByteReadChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;ZLio/ktor/utils/io/pool/ObjectPool;Lkotlin/coroutines/d;)Lio/ktor/utils/io/ByteWriteChannel;", "", "GZIP_MAGIC", ExifInterface.LATITUDE_SOUTH, "", "GZIP_HEADER_PADDING", "[B", "getGZIP_HEADER_PADDING", "()[B", "LUa/L;", "DeflateWriterCoroutineName", "LUa/L;", "DeflateReaderCoroutineName", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DeflaterKt {
    public static final short GZIP_MAGIC = -29921;
    private static final byte[] GZIP_HEADER_PADDING = new byte[7];
    private static final CoroutineName DeflateWriterCoroutineName = new CoroutineName("encoder-deflate-writer");
    private static final CoroutineName DeflateReaderCoroutineName = new CoroutineName("encoder-deflate-reader");

    @InterfaceC4112d(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", l = {77, 82, 87, 93, 96}, m = "deflateTo")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.util.DeflaterKt$deflateTo$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeflaterKt.deflateTo(null, null, false, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", l = {57}, m = "deflateWhile")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.util.DeflaterKt$deflateWhile$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C44121(InterfaceC4014c<? super C44121> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeflaterKt.deflateWhile(null, null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/WriterScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/WriterScope;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.util.DeflaterKt$deflated$1", f = "Deflater.kt", l = {120}, m = "invokeSuspend")
    /* renamed from: io.ktor.util.DeflaterKt$deflated$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44131 extends SuspendLambda implements p9.p<WriterScope, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ boolean $gzip;
        final /* synthetic */ ObjectPool<ByteBuffer> $pool;
        final /* synthetic */ ByteReadChannel $this_deflated;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C44131(ByteReadChannel byteReadChannel, boolean z10, ObjectPool<ByteBuffer> objectPool, InterfaceC4014c<? super C44131> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$this_deflated = byteReadChannel;
            this.$gzip = z10;
            this.$pool = objectPool;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C44131 c44131 = new C44131(this.$this_deflated, this.$gzip, this.$pool, interfaceC4014c);
            c44131.L$0 = obj;
            return c44131;
        }

        @Override // p9.p
        public final Object invoke(WriterScope writerScope, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C44131) create(writerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            WriterScope writerScope = (WriterScope) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ByteReadChannel byteReadChannel = this.$this_deflated;
                ByteWriteChannel channel = writerScope.getChannel();
                boolean z10 = this.$gzip;
                ObjectPool<ByteBuffer> objectPool = this.$pool;
                this.L$0 = g9.h.a(writerScope);
                this.label = 1;
                if (DeflaterKt.deflateTo(byteReadChannel, channel, z10, objectPool, this) == objG) {
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/ReaderScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/ReaderScope;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.util.DeflaterKt$deflated$2", f = "Deflater.kt", l = {135}, m = "invokeSuspend")
    /* renamed from: io.ktor.util.DeflaterKt$deflated$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<ReaderScope, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ boolean $gzip;
        final /* synthetic */ ObjectPool<ByteBuffer> $pool;
        final /* synthetic */ ByteWriteChannel $this_deflated;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ByteWriteChannel byteWriteChannel, boolean z10, ObjectPool<ByteBuffer> objectPool, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$this_deflated = byteWriteChannel;
            this.$gzip = z10;
            this.$pool = objectPool;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_deflated, this.$gzip, this.$pool, interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        public final Object invoke(ReaderScope readerScope, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(readerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ReaderScope readerScope = (ReaderScope) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ByteReadChannel channel = readerScope.getChannel();
                ByteWriteChannel byteWriteChannel = this.$this_deflated;
                boolean z10 = this.$gzip;
                ObjectPool<ByteBuffer> objectPool = this.$pool;
                this.L$0 = g9.h.a(readerScope);
                this.label = 1;
                if (DeflaterKt.deflateTo(channel, byteWriteChannel, z10, objectPool, this) == objG) {
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

    @InterfaceC4112d(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", l = {42, 43, 44}, m = "putGzipHeader")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.util.DeflaterKt$putGzipHeader$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44141 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44141(InterfaceC4014c<? super C44141> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeflaterKt.putGzipHeader(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", l = {48, 49}, m = "putGzipTrailer")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.util.DeflaterKt$putGzipTrailer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C44151(InterfaceC4014c<? super C44151> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeflaterKt.putGzipTrailer(null, null, null, this);
        }
    }

    private static final void deflateTo(Deflater deflater, ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            byteBuffer.position(byteBuffer.position() + deflater.deflate(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()));
        }
    }

    public static /* synthetic */ Object deflateTo$default(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, boolean z10, ObjectPool objectPool, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        return deflateTo(byteReadChannel, byteWriteChannel, z10, objectPool, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deflateTo$lambda$2(Deflater deflater) {
        return !deflater.needsInput();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deflateTo$lambda$4(Deflater deflater) {
        return !deflater.finished();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object deflateWhile(io.ktor.utils.io.ByteWriteChannel r5, java.util.zip.Deflater r6, java.nio.ByteBuffer r7, p9.InterfaceC5063a<java.lang.Boolean> r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.util.DeflaterKt.C44121
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.util.DeflaterKt$deflateWhile$1 r0 = (io.ktor.util.DeflaterKt.C44121) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.util.DeflaterKt$deflateWhile$1 r0 = new io.ktor.util.DeflaterKt$deflateWhile$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r5 = r0.L$3
            p9.a r5 = (p9.InterfaceC5063a) r5
            java.lang.Object r6 = r0.L$2
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r7 = r0.L$1
            java.util.zip.Deflater r7 = (java.util.zip.Deflater) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r8 = (io.ktor.utils.io.ByteWriteChannel) r8
            kotlin.C4849c.b(r9)
            r4 = r8
            r8 = r5
            r5 = r4
            r4 = r7
            r7 = r6
            r6 = r4
            goto L4a
        L3f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L47:
            kotlin.C4849c.b(r9)
        L4a:
            java.lang.Object r9 = r8.invoke()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L70
            r7.clear()
            deflateTo(r6, r7)
            r7.flip()
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.L$3 = r8
            r0.label = r3
            java.lang.Object r9 = io.ktor.utils.io.ByteWriteChannelOperations_jvmKt.writeFully(r5, r7, r0)
            if (r9 != r1) goto L4a
            return r1
        L70:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt.deflateWhile(io.ktor.utils.io.ByteWriteChannel, java.util.zip.Deflater, java.nio.ByteBuffer, p9.a, e9.c):java.lang.Object");
    }

    public static final ByteReadChannel deflated(ByteReadChannel byteReadChannel, boolean z10, ObjectPool<ByteBuffer> pool, kotlin.coroutines.d coroutineContext) {
        kotlin.jvm.internal.p.i(byteReadChannel, "<this>");
        kotlin.jvm.internal.p.i(pool, "pool");
        kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
        return ByteWriteChannelOperationsKt.writer((M) C1073o0.f6391a, coroutineContext.plus(DeflateWriterCoroutineName), true, (p9.p<? super WriterScope, ? super InterfaceC4014c<? super t>, ? extends Object>) new C44131(byteReadChannel, z10, pool, null)).getChannel();
    }

    public static /* synthetic */ ByteReadChannel deflated$default(ByteReadChannel byteReadChannel, boolean z10, ObjectPool objectPool, kotlin.coroutines.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        if ((i10 & 4) != 0) {
            dVar = Y.d();
        }
        return deflated(byteReadChannel, z10, (ObjectPool<ByteBuffer>) objectPool, dVar);
    }

    public static final byte[] getGZIP_HEADER_PADDING() {
        return GZIP_HEADER_PADDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeFully$default(r1, r2, 0, 0, r5, 6, null) != r0) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object putGzipHeader(io.ktor.utils.io.ByteWriteChannel r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.util.DeflaterKt.C44141
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.util.DeflaterKt$putGzipHeader$1 r0 = (io.ktor.util.DeflaterKt.C44141) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            io.ktor.util.DeflaterKt$putGzipHeader$1 r0 = new io.ktor.util.DeflaterKt$putGzipHeader$1
            r0.<init>(r9)
            goto L12
        L1a:
            java.lang.Object r9 = r5.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r5.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L4f
            if (r1 == r4) goto L47
            if (r1 == r3) goto L3d
            if (r1 != r2) goto L35
            java.lang.Object r8 = r5.L$0
            io.ktor.utils.io.ByteWriteChannel r8 = (io.ktor.utils.io.ByteWriteChannel) r8
            kotlin.C4849c.b(r9)
            goto L86
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            java.lang.Object r8 = r5.L$0
            io.ktor.utils.io.ByteWriteChannel r8 = (io.ktor.utils.io.ByteWriteChannel) r8
            kotlin.C4849c.b(r9)
        L44:
            r1 = r8
            r8 = r2
            goto L71
        L47:
            java.lang.Object r8 = r5.L$0
            io.ktor.utils.io.ByteWriteChannel r8 = (io.ktor.utils.io.ByteWriteChannel) r8
            kotlin.C4849c.b(r9)
            goto L64
        L4f:
            kotlin.C4849c.b(r9)
            r9 = -29921(0xffffffffffff8b1f, float:NaN)
            short r9 = (short) r9
            short r9 = java.lang.Short.reverseBytes(r9)
            r5.L$0 = r8
            r5.label = r4
            java.lang.Object r9 = io.ktor.utils.io.ByteWriteChannelOperationsKt.writeShort(r8, r9, r5)
            if (r9 != r0) goto L64
            goto L85
        L64:
            r5.L$0 = r8
            r5.label = r3
            r9 = 8
            java.lang.Object r9 = io.ktor.utils.io.ByteWriteChannelOperationsKt.writeByte(r8, r9, r5)
            if (r9 != r0) goto L44
            goto L85
        L71:
            byte[] r2 = io.ktor.util.DeflaterKt.GZIP_HEADER_PADDING
            java.lang.Object r9 = g9.h.a(r1)
            r5.L$0 = r9
            r5.label = r8
            r3 = 0
            r4 = 0
            r6 = 6
            r7 = 0
            java.lang.Object r8 = io.ktor.utils.io.ByteWriteChannelOperationsKt.writeFully$default(r1, r2, r3, r4, r5, r6, r7)
            if (r8 != r0) goto L86
        L85:
            return r0
        L86:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt.putGzipHeader(io.ktor.utils.io.ByteWriteChannel, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0091, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeInt(r7, r10, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object putGzipTrailer(io.ktor.utils.io.ByteWriteChannel r7, java.util.zip.Checksum r8, java.util.zip.Deflater r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof io.ktor.util.DeflaterKt.C44151
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.util.DeflaterKt$putGzipTrailer$1 r0 = (io.ktor.util.DeflaterKt.C44151) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.util.DeflaterKt$putGzipTrailer$1 r0 = new io.ktor.util.DeflaterKt$putGzipTrailer$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L52
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.L$2
            java.util.zip.Deflater r7 = (java.util.zip.Deflater) r7
            java.lang.Object r7 = r0.L$1
            java.util.zip.Checksum r7 = (java.util.zip.Checksum) r7
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            kotlin.C4849c.b(r10)
            goto L94
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            java.lang.Object r7 = r0.L$2
            r9 = r7
            java.util.zip.Deflater r9 = (java.util.zip.Deflater) r9
            java.lang.Object r7 = r0.L$1
            r8 = r7
            java.util.zip.Checksum r8 = (java.util.zip.Checksum) r8
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            kotlin.C4849c.b(r10)
            goto L71
        L52:
            kotlin.C4849c.b(r10)
            long r5 = r8.getValue()
            int r10 = (int) r5
            int r10 = java.lang.Integer.reverseBytes(r10)
            r0.L$0 = r7
            java.lang.Object r2 = g9.h.a(r8)
            r0.L$1 = r2
            r0.L$2 = r9
            r0.label = r4
            java.lang.Object r10 = io.ktor.utils.io.ByteWriteChannelOperationsKt.writeInt(r7, r10, r0)
            if (r10 != r1) goto L71
            goto L93
        L71:
            int r10 = r9.getTotalIn()
            int r10 = java.lang.Integer.reverseBytes(r10)
            java.lang.Object r2 = g9.h.a(r7)
            r0.L$0 = r2
            java.lang.Object r8 = g9.h.a(r8)
            r0.L$1 = r8
            java.lang.Object r8 = g9.h.a(r9)
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r7 = io.ktor.utils.io.ByteWriteChannelOperationsKt.writeInt(r7, r10, r0)
            if (r7 != r1) goto L94
        L93:
            return r1
        L94:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt.putGzipTrailer(io.ktor.utils.io.ByteWriteChannel, java.util.zip.Checksum, java.util.zip.Deflater, e9.c):java.lang.Object");
    }

    private static final void setInputBuffer(Deflater deflater, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            throw new IllegalArgumentException("buffer need to be array-backed");
        }
        deflater.setInput(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    public static final void updateKeepPosition(Checksum checksum, ByteBuffer buffer) {
        kotlin.jvm.internal.p.i(checksum, "<this>");
        kotlin.jvm.internal.p.i(buffer, "buffer");
        if (!buffer.hasArray()) {
            throw new IllegalArgumentException("buffer need to be array-backed");
        }
        checksum.update(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());
    }

    public static final ByteWriteChannel deflated(ByteWriteChannel byteWriteChannel, boolean z10, ObjectPool<ByteBuffer> pool, kotlin.coroutines.d coroutineContext) {
        kotlin.jvm.internal.p.i(byteWriteChannel, "<this>");
        kotlin.jvm.internal.p.i(pool, "pool");
        kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
        return ByteReadChannelOperationsKt.reader((M) C1073o0.f6391a, coroutineContext.plus(DeflateReaderCoroutineName), true, (p9.p<? super ReaderScope, ? super InterfaceC4014c<? super t>, ? extends Object>) new AnonymousClass2(byteWriteChannel, z10, pool, null)).getChannel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:4|(1:6)(1:7))(0)|8|(4:(2:96|(1:(1:(1:(6:15|88|16|79|80|81)(2:20|21))(6:22|85|23|(3:75|(2:78|79)|77)|80|81))(7:27|28|29|87|52|(2:54|(8:57|36|92|58|(2:60|(1:65))(0)|87|52|(2:68|(2:70|(4:73|(0)|80|81))(1:82))(0)))(0)|77))(11:33|34|35|36|92|58|(0)(0)|87|52|(0)(0)|77))(4:37|94|38|39)|32|83|84)(3:42|(2:90|44)|51)|47|87|52|(0)(0)|77|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x013e, code lost:
    
        if (putGzipHeader(r12, r0) == r1) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b1, code lost:
    
        r15 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01b2, code lost:
    
        r13 = r14;
        r14 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0150, code lost:
    
        r15 = r0;
        r0 = r2;
        r2 = r7;
        r7 = r8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0156 A[Catch: all -> 0x01b1, TRY_LEAVE, TryCatch #1 {all -> 0x01b1, blocks: (B:52:0x0150, B:54:0x0156, B:68:0x01b5, B:70:0x01bb, B:82:0x0221), top: B:87:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0180 A[Catch: all -> 0x01a8, TRY_LEAVE, TryCatch #4 {all -> 0x01a8, blocks: (B:58:0x0178, B:60:0x0180), top: B:92:0x0178 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01b5 A[Catch: all -> 0x01b1, TRY_ENTER, TryCatch #1 {all -> 0x01b1, blocks: (B:52:0x0150, B:54:0x0156, B:68:0x01b5, B:70:0x01bb, B:82:0x0221), top: B:87:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e8 A[Catch: all -> 0x0080, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0080, blocks: (B:23:0x007b, B:75:0x01e8), top: B:85:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v22, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v25, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v0, types: [io.ktor.utils.io.pool.ObjectPool, io.ktor.utils.io.pool.ObjectPool<java.nio.ByteBuffer>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v29, types: [java.util.zip.Deflater] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v15, types: [io.ktor.utils.io.pool.ObjectPool] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object deflateTo(io.ktor.utils.io.ByteReadChannel r11, io.ktor.utils.io.ByteWriteChannel r12, boolean r13, io.ktor.utils.io.pool.ObjectPool<java.nio.ByteBuffer> r14, e9.InterfaceC4014c<? super Y8.t> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt.deflateTo(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, boolean, io.ktor.utils.io.pool.ObjectPool, e9.c):java.lang.Object");
    }

    public static /* synthetic */ ByteWriteChannel deflated$default(ByteWriteChannel byteWriteChannel, boolean z10, ObjectPool objectPool, kotlin.coroutines.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        if ((i10 & 4) != 0) {
            dVar = Y.d();
        }
        return deflated(byteWriteChannel, z10, (ObjectPool<ByteBuffer>) objectPool, dVar);
    }
}
