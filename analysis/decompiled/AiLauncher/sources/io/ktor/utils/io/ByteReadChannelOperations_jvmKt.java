package io.ktor.utils.io;

import Y8.t;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import fb.C4074a;
import fb.o;
import g9.InterfaceC4112d;
import gb.C4114a;
import io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt;
import io.ktor.utils.io.core.ByteReadPacketExtensions_jvmKt;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import kb.C4845d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a&\u0010\u0010\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0014\u0010\b\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0016\u0010\b\u001a%\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0017¢\u0006\u0004\b\u0007\u0010\u0019\u001a4\u0010\u001c\u001a\u00020\u0013*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00062\u0014\b\b\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00130\u0017H\u0086H¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Ljava/nio/ByteBuffer;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lio/ktor/utils/io/ByteReadChannel;", "ByteReadChannel", "(Ljava/nio/ByteBuffer;)Lio/ktor/utils/io/ByteReadChannel;", "buffer", "", "readAvailable", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/ByteBuffer;Le9/c;)Ljava/lang/Object;", "Lgb/a;", "ByteString", "(Ljava/nio/ByteBuffer;)Lgb/a;", "Ljava/nio/channels/WritableByteChannel;", "channel", "", "limit", "copyTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/channels/WritableByteChannel;JLe9/c;)Ljava/lang/Object;", "delimiter", "LY8/t;", "skipDelimiter", "(Lio/ktor/utils/io/ByteReadChannel;Lgb/a;Le9/c;)Ljava/lang/Object;", "readFully", "Lkotlin/Function1;", "block", "(Lio/ktor/utils/io/ByteReadChannel;Lp9/l;)I", "min", "consumer", "read", "(Lio/ktor/utils/io/ByteReadChannel;ILp9/l;Le9/c;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteReadChannelOperations_jvmKt {

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", l = {211, 215}, m = "copyTo")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$copyTo$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperations_jvmKt.copyTo(null, null, 0L, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", l = {198, 202}, m = "read")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$read$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44481 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C44481(InterfaceC4014c<? super C44481> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperations_jvmKt.read(null, 0, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", l = {40}, m = "readAvailable")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readAvailable$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C44491(InterfaceC4014c<? super C44491> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperations_jvmKt.readAvailable(null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", l = {130}, m = "readFully")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readFully$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44501 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C44501(InterfaceC4014c<? super C44501> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperations_jvmKt.readFully(null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", l = {114}, m = "skipDelimiter")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$skipDelimiter$2, reason: invalid class name */
    public static final class AnonymousClass2 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return ByteReadChannelOperations_jvmKt.skipDelimiter((ByteReadChannel) null, (C4114a) null, this);
        }
    }

    public static final ByteReadChannel ByteReadChannel(ByteBuffer content) {
        p.i(content, "content");
        C4074a c4074a = new C4074a();
        BytePacketBuilderExtensions_jvmKt.writeFully(c4074a, content);
        return ByteChannelCtorKt.ByteReadChannel(c4074a);
    }

    public static final C4114a ByteString(ByteBuffer buffer) {
        p.i(buffer, "buffer");
        byte[] bArr = new byte[buffer.remaining()];
        buffer.mark();
        buffer.get(bArr);
        buffer.reset();
        return new C4114a(bArr, 0, 0, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0114 -> B:45:0x0119). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyTo(io.ktor.utils.io.ByteReadChannel r9, final java.nio.channels.WritableByteChannel r10, final long r11, e9.InterfaceC4014c<? super java.lang.Long> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperations_jvmKt.copyTo(io.ktor.utils.io.ByteReadChannel, java.nio.channels.WritableByteChannel, long, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, WritableByteChannel writableByteChannel, long j10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return copyTo(byteReadChannel, writableByteChannel, j10, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t copyTo$lambda$3(long j10, Ref$LongRef ref$LongRef, WritableByteChannel writableByteChannel, ByteBuffer bb2) throws IOException {
        p.i(bb2, "bb");
        long j11 = j10 - ref$LongRef.f34819a;
        if (j11 < bb2.remaining()) {
            int iLimit = bb2.limit();
            bb2.limit(bb2.position() + ((int) j11));
            while (bb2.hasRemaining()) {
                writableByteChannel.write(bb2);
            }
            bb2.limit(iLimit);
            ref$LongRef.f34819a += j11;
        } else {
            long jWrite = 0;
            while (bb2.hasRemaining()) {
                jWrite += writableByteChannel.write(bb2);
            }
            ref$LongRef.f34819a += jWrite;
        }
        return t.f7040a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
    
        if (r8 == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ad, code lost:
    
        if (r8 == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object read(io.ktor.utils.io.ByteReadChannel r5, int r6, p9.InterfaceC5074l<? super java.nio.ByteBuffer, Y8.t> r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteReadChannelOperations_jvmKt.C44481
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$read$1 r0 = (io.ktor.utils.io.ByteReadChannelOperations_jvmKt.C44481) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$read$1 r0 = new io.ktor.utils.io.ByteReadChannelOperations_jvmKt$read$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r5 = r0.L$1
            r7 = r5
            p9.l r7 = (p9.InterfaceC5074l) r7
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r5 = (io.ktor.utils.io.ByteReadChannel) r5
            kotlin.C4849c.b(r8)
            goto Lb0
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            int r6 = r0.I$0
            java.lang.Object r5 = r0.L$1
            r7 = r5
            p9.l r7 = (p9.InterfaceC5074l) r7
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r5 = (io.ktor.utils.io.ByteReadChannel) r5
            kotlin.C4849c.b(r8)
            goto L66
        L4d:
            kotlin.C4849c.b(r8)
            if (r6 < 0) goto Lc2
            r8 = 0
            if (r6 <= 0) goto L9e
            r0.L$0 = r5
            r0.L$1 = r7
            r0.I$0 = r6
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r8 = r5.awaitContent(r6, r0)
            if (r8 != r1) goto L66
            goto Laf
        L66:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L76
            fb.v r5 = r5.getReadBuffer()
            io.ktor.utils.io.core.ByteReadPacketExtensions_jvmKt.read(r5, r7)
            goto Lbf
        L76:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Not enough bytes available: required "
            r8.append(r0)
            r8.append(r6)
            java.lang.String r6 = " but "
            r8.append(r6)
            int r5 = io.ktor.utils.io.ByteReadChannelOperationsKt.getAvailableForRead(r5)
            r8.append(r5)
            java.lang.String r5 = " available"
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            r7.<init>(r5)
            throw r7
        L9e:
            r0.L$0 = r5
            r0.L$1 = r7
            r0.I$0 = r6
            r0.I$1 = r8
            r0.label = r3
            r6 = 0
            java.lang.Object r8 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r5, r8, r0, r4, r6)
            if (r8 != r1) goto Lb0
        Laf:
            return r1
        Lb0:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r6 = r8.booleanValue()
            if (r6 == 0) goto Lbf
            fb.v r5 = r5.getReadBuffer()
            io.ktor.utils.io.core.ByteReadPacketExtensions_jvmKt.read(r5, r7)
        Lbf:
            Y8.t r5 = Y8.t.f7040a
            return r5
        Lc2:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "min should be positive or zero"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperations_jvmKt.read(io.ktor.utils.io.ByteReadChannel, int, p9.l, e9.c):java.lang.Object");
    }

    private static final Object read$$forInline(ByteReadChannel byteReadChannel, int i10, InterfaceC5074l<? super ByteBuffer, t> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) throws EOFException {
        if (i10 < 0) {
            throw new IllegalArgumentException("min should be positive or zero");
        }
        if (i10 > 0) {
            n.c(0);
            Object objAwaitContent = byteReadChannel.awaitContent(i10, interfaceC4014c);
            n.c(1);
            if (!((Boolean) objAwaitContent).booleanValue()) {
                throw new EOFException("Not enough bytes available: required " + i10 + " but " + ByteReadChannelOperationsKt.getAvailableForRead(byteReadChannel) + " available");
            }
            ByteReadPacketExtensions_jvmKt.read(byteReadChannel.getReadBuffer(), interfaceC5074l);
        } else {
            n.c(0);
            Object objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel, 0, interfaceC4014c, 1, null);
            n.c(1);
            if (((Boolean) objAwaitContent$default).booleanValue()) {
                ByteReadPacketExtensions_jvmKt.read(byteReadChannel.getReadBuffer(), interfaceC5074l);
            }
        }
        return t.f7040a;
    }

    public static /* synthetic */ Object read$default(ByteReadChannel byteReadChannel, int i10, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i11, Object obj) throws EOFException {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("min should be positive or zero");
        }
        if (i10 > 0) {
            n.c(0);
            Object objAwaitContent = byteReadChannel.awaitContent(i10, interfaceC4014c);
            n.c(1);
            if (!((Boolean) objAwaitContent).booleanValue()) {
                throw new EOFException("Not enough bytes available: required " + i10 + " but " + ByteReadChannelOperationsKt.getAvailableForRead(byteReadChannel) + " available");
            }
            ByteReadPacketExtensions_jvmKt.read(byteReadChannel.getReadBuffer(), interfaceC5074l);
        } else {
            n.c(0);
            Object objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel, 0, interfaceC4014c, 1, null);
            n.c(1);
            if (((Boolean) objAwaitContent$default).booleanValue()) {
                ByteReadPacketExtensions_jvmKt.read(byteReadChannel.getReadBuffer(), interfaceC5074l);
            }
        }
        return t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readAvailable(io.ktor.utils.io.ByteReadChannel r5, java.nio.ByteBuffer r6, e9.InterfaceC4014c<? super java.lang.Integer> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteReadChannelOperations_jvmKt.C44491
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readAvailable$1 r0 = (io.ktor.utils.io.ByteReadChannelOperations_jvmKt.C44491) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readAvailable$1 r0 = new io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readAvailable$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = -1
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 != r4) goto L33
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r5 = (io.ktor.utils.io.ByteReadChannel) r5
            kotlin.C4849c.b(r7)
            goto L62
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.C4849c.b(r7)
            boolean r7 = r5.isClosedForRead()
            if (r7 == 0) goto L49
            java.lang.Integer r5 = g9.C4109a.f(r3)
            return r5
        L49:
            fb.v r7 = r5.getReadBuffer()
            boolean r7 = r7.k()
            if (r7 == 0) goto L62
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            r7 = 0
            r2 = 0
            java.lang.Object r7 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r5, r7, r0, r4, r2)
            if (r7 != r1) goto L62
            return r1
        L62:
            boolean r7 = r5.isClosedForRead()
            if (r7 == 0) goto L6d
            java.lang.Integer r5 = g9.C4109a.f(r3)
            return r5
        L6d:
            fb.v r5 = r5.getReadBuffer()
            int r5 = kotlinx.io.SourcesJvmKt.d(r5, r6)
            java.lang.Integer r5 = g9.C4109a.f(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperations_jvmKt.readAvailable(io.ktor.utils.io.ByteReadChannel, java.nio.ByteBuffer, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0051 -> B:20:0x0054). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readFully(io.ktor.utils.io.ByteReadChannel r5, java.nio.ByteBuffer r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteReadChannelOperations_jvmKt.C44501
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readFully$1 r0 = (io.ktor.utils.io.ByteReadChannelOperations_jvmKt.C44501) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readFully$1 r0 = new io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readFully$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r5 = r0.L$1
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            kotlin.C4849c.b(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L54
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.C4849c.b(r7)
        L3f:
            boolean r7 = r6.hasRemaining()
            if (r7 == 0) goto L84
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            r7 = 0
            r2 = 0
            java.lang.Object r7 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r5, r7, r0, r3, r2)
            if (r7 != r1) goto L54
            return r1
        L54:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L64
            fb.v r7 = r5.getReadBuffer()
            kotlinx.io.SourcesJvmKt.d(r7, r6)
            goto L3f
        L64:
            java.io.EOFException r5 = new java.io.EOFException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Not enough bytes available: expected "
            r7.append(r0)
            int r6 = r6.remaining()
            r7.append(r6)
            java.lang.String r6 = " more bytes"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.<init>(r6)
            throw r5
        L84:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperations_jvmKt.readFully(io.ktor.utils.io.ByteReadChannel, java.nio.ByteBuffer, e9.c):java.lang.Object");
    }

    public static final Object skipDelimiter(ByteReadChannel byteReadChannel, ByteBuffer byteBuffer, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objSkipDelimiter = skipDelimiter(byteReadChannel, ByteString(byteBuffer), interfaceC4014c);
        return objSkipDelimiter == C4063a.g() ? objSkipDelimiter : t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005c -> B:20:0x0061). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object skipDelimiter(io.ktor.utils.io.ByteReadChannel r7, gb.C4114a r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteReadChannelOperations_jvmKt.AnonymousClass2
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$skipDelimiter$2 r0 = (io.ktor.utils.io.ByteReadChannelOperations_jvmKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$skipDelimiter$2 r0 = new io.ktor.utils.io.ByteReadChannelOperations_jvmKt$skipDelimiter$2
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            int r7 = r0.I$1
            int r8 = r0.I$0
            java.lang.Object r2 = r0.L$1
            gb.a r2 = (gb.C4114a) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.C4849c.b(r9)
            goto L61
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            kotlin.C4849c.b(r9)
            int r9 = r8.i()
            r2 = 0
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L49:
            if (r2 >= r7) goto L7b
            r0.L$0 = r8
            r0.L$1 = r9
            r0.I$0 = r2
            r0.I$1 = r7
            r0.label = r3
            java.lang.Object r4 = io.ktor.utils.io.ByteReadChannelOperationsKt.readByte(r8, r0)
            if (r4 != r1) goto L5c
            return r1
        L5c:
            r6 = r4
            r4 = r8
            r8 = r2
            r2 = r9
            r9 = r6
        L61:
            java.lang.Number r9 = (java.lang.Number) r9
            byte r9 = r9.byteValue()
            byte r5 = r2.c(r8)
            if (r9 != r5) goto L73
            int r8 = r8 + 1
            r9 = r2
            r2 = r8
            r8 = r4
            goto L49
        L73:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Delimiter is not found"
            r7.<init>(r8)
            throw r7
        L7b:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperations_jvmKt.skipDelimiter(io.ktor.utils.io.ByteReadChannel, gb.a, e9.c):java.lang.Object");
    }

    public static final int readAvailable(ByteReadChannel byteReadChannel, InterfaceC5074l<? super ByteBuffer, Integer> block) throws EOFException {
        p.i(byteReadChannel, "<this>");
        p.i(block, "block");
        if (byteReadChannel.isClosedForRead() || byteReadChannel.getReadBuffer().k()) {
            return -1;
        }
        C4845d c4845d = C4845d.f34666a;
        C4074a bufferField = byteReadChannel.getReadBuffer().getBufferField();
        if (!bufferField.k()) {
            o head = bufferField.getHead();
            p.f(head);
            byte[] bArrB = head.b(true);
            int pos = head.getPos();
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArrB, pos, head.getLimit() - pos);
            p.f(byteBufferWrap);
            int iIntValue = block.invoke(byteBufferWrap).intValue();
            if (iIntValue == 0) {
                return iIntValue;
            }
            if (iIntValue >= 0) {
                if (iIntValue <= head.j()) {
                    bufferField.skip(iIntValue);
                    return iIntValue;
                }
                throw new IllegalStateException("Returned too many bytes");
            }
            throw new IllegalStateException("Returned negative read bytes count");
        }
        throw new IllegalArgumentException("Buffer is empty");
    }
}
