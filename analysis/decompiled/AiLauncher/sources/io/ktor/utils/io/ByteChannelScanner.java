package io.ktor.utils.io;

import La.D;
import com.fasterxml.jackson.core.JsonFactory;
import e9.InterfaceC4014c;
import fb.C4074a;
import fb.v;
import g9.InterfaceC4112d;
import gb.C4114a;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\u00020\u0017*\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\u0012H\u0080@¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010!R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006."}, d2 = {"Lio/ktor/utils/io/ByteChannelScanner;", "", "Lio/ktor/utils/io/ByteReadChannel;", "channel", "Lgb/a;", "matchString", "Lio/ktor/utils/io/ByteWriteChannel;", "writeChannel", "", "limit", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lgb/a;Lio/ktor/utils/io/ByteWriteChannel;J)V", "", "buildPartialMatchTable", "()[I", "LY8/t;", "advanceToNextPotentialMatch", "(Le9/c;)Ljava/lang/Object;", "", "checkFullMatch", "extra", "checkBounds", "(J)V", "", "toSingleLineString", "(Lgb/a;)Ljava/lang/String;", "ignoreMissing", "findNext$ktor_io", "(ZLe9/c;)Ljava/lang/Object;", "findNext", "Lio/ktor/utils/io/ByteReadChannel;", "Lgb/a;", "Lio/ktor/utils/io/ByteWriteChannel;", "J", "Lfb/v;", "input", "Lfb/v;", "partialMatchTable", "[I", "Lfb/a;", "partialMatchBuffer", "Lfb/a;", "bytesRead", "", "matchIndex", "I", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteChannelScanner {
    private long bytesRead;
    private final ByteReadChannel channel;
    private final v input;
    private final long limit;
    private int matchIndex;
    private final C4114a matchString;
    private final C4074a partialMatchBuffer;
    private final int[] partialMatchTable;
    private final ByteWriteChannel writeChannel;

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteChannelScanner", f = "ByteChannelScanner.kt", l = {99, 105, 110}, m = "advanceToNextPotentialMatch")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteChannelScanner$advanceToNextPotentialMatch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelScanner.this.advanceToNextPotentialMatch(this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.ByteChannelScanner", f = "ByteChannelScanner.kt", l = {124, 142}, m = "checkFullMatch")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteChannelScanner$checkFullMatch$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44221 extends ContinuationImpl {
        byte B$0;
        int I$0;
        long J$0;
        int label;
        /* synthetic */ Object result;

        public C44221(InterfaceC4014c<? super C44221> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelScanner.this.checkFullMatch(this);
        }
    }

    public ByteChannelScanner(ByteReadChannel channel, C4114a matchString, ByteWriteChannel writeChannel, long j10) {
        p.i(channel, "channel");
        p.i(matchString, "matchString");
        p.i(writeChannel, "writeChannel");
        this.channel = channel;
        this.matchString = matchString;
        this.writeChannel = writeChannel;
        this.limit = j10;
        if (matchString.i() <= 0) {
            throw new IllegalArgumentException("Empty match string not permitted for scanning");
        }
        this.input = channel.getReadBuffer();
        this.partialMatchTable = buildPartialMatchTable();
        this.partialMatchBuffer = new C4074a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        if (r1 == r3) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d1, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelKt.flushIfNeeded(r0, r2) == r3) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ab -> B:18:0x0044). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object advanceToNextPotentialMatch(e9.InterfaceC4014c<? super Y8.t> r18) throws java.lang.Throwable {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof io.ktor.utils.io.ByteChannelScanner.AnonymousClass1
            if (r2 == 0) goto L17
            r2 = r1
            io.ktor.utils.io.ByteChannelScanner$advanceToNextPotentialMatch$1 r2 = (io.ktor.utils.io.ByteChannelScanner.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            io.ktor.utils.io.ByteChannelScanner$advanceToNextPotentialMatch$1 r2 = new io.ktor.utils.io.ByteChannelScanner$advanceToNextPotentialMatch$1
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = f9.C4063a.g()
            int r4 = r2.label
            r5 = 0
            r6 = 3
            r7 = 2
            r8 = 1
            if (r4 == 0) goto L41
            if (r4 == r8) goto L3d
            if (r4 == r7) goto L41
            if (r4 != r6) goto L35
            kotlin.C4849c.b(r1)
            goto Ld4
        L35:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3d:
            kotlin.C4849c.b(r1)
            goto L59
        L41:
            kotlin.C4849c.b(r1)
        L44:
            fb.v r1 = r0.input
            boolean r1 = r1.k()
            if (r1 == 0) goto L65
            io.ktor.utils.io.ByteReadChannel r1 = r0.channel
            r2.label = r8
            r4 = 0
            java.lang.Object r1 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r1, r5, r2, r8, r4)
            if (r1 != r3) goto L59
            goto Ld3
        L59:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L62
            goto L65
        L62:
            Y8.t r0 = Y8.t.f7040a
            return r0
        L65:
            fb.v r9 = r0.input
            gb.a r1 = r0.matchString
            byte r10 = r1.c(r5)
            r15 = 6
            r16 = 0
            r11 = 0
            r13 = 0
            long r9 = fb.x.b(r9, r10, r11, r13, r15, r16)
            r11 = -1
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.io.Buffer"
            if (r1 != 0) goto Lae
            fb.v r1 = r0.input
            kotlin.jvm.internal.p.g(r1, r4)
            fb.a r1 = (fb.C4074a) r1
            long r11 = r1.n()
            r0.checkBounds(r11)
            long r11 = r0.bytesRead
            fb.v r1 = r0.input
            fb.a r1 = (fb.C4074a) r1
            io.ktor.utils.io.ByteWriteChannel r4 = r0.writeChannel
            fb.s r4 = r4.getWriteBuffer()
            long r13 = r1.B(r4)
            long r11 = r11 + r13
            r0.bytesRead = r11
            io.ktor.utils.io.ByteWriteChannel r1 = r0.writeChannel
            r2.J$0 = r9
            r2.label = r7
            java.lang.Object r1 = io.ktor.utils.io.ByteWriteChannelKt.flushIfNeeded(r1, r2)
            if (r1 != r3) goto L44
            goto Ld3
        Lae:
            r0.checkBounds(r9)
            long r7 = r0.bytesRead
            fb.v r1 = r0.input
            io.ktor.utils.io.ByteWriteChannel r5 = r0.writeChannel
            fb.s r5 = r5.getWriteBuffer()
            kotlin.jvm.internal.p.g(r5, r4)
            fb.a r5 = (fb.C4074a) r5
            long r4 = r1.readAtMostTo(r5, r9)
            long r7 = r7 + r4
            r0.bytesRead = r7
            io.ktor.utils.io.ByteWriteChannel r0 = r0.writeChannel
            r2.J$0 = r9
            r2.label = r6
            java.lang.Object r0 = io.ktor.utils.io.ByteWriteChannelKt.flushIfNeeded(r0, r2)
            if (r0 != r3) goto Ld4
        Ld3:
            return r3
        Ld4:
            Y8.t r0 = Y8.t.f7040a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelScanner.advanceToNextPotentialMatch(e9.c):java.lang.Object");
    }

    private final int[] buildPartialMatchTable() {
        int[] iArr = new int[this.matchString.i()];
        int i10 = this.matchString.i();
        int i11 = 0;
        for (int i12 = 1; i12 < i10; i12++) {
            while (i11 > 0 && this.matchString.c(i12) != this.matchString.c(i11)) {
                i11 = iArr[i11 - 1];
            }
            if (this.matchString.c(i12) == this.matchString.c(i11)) {
                i11++;
            }
            iArr[i12] = i11;
        }
        return iArr;
    }

    private final void checkBounds(long extra) throws IOException {
        if (this.bytesRead + extra <= this.limit) {
            return;
        }
        throw new IOException("Limit of " + this.limit + " bytes exceeded while searching for \"" + toSingleLineString(this.matchString) + JsonFactory.DEFAULT_QUOTE_CHAR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
    
        if (r14 == r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c5, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeByte(r13.writeChannel, r14, r0) != r1) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0043 -> B:27:0x0060). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004e -> B:22:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object checkFullMatch(e9.InterfaceC4014c<? super java.lang.Boolean> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelScanner.checkFullMatch(e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object findNext$ktor_io$default(ByteChannelScanner byteChannelScanner, boolean z10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return byteChannelScanner.findNext$ktor_io(z10, interfaceC4014c);
    }

    private final String toSingleLineString(C4114a c4114a) {
        return D.T(gb.c.b(c4114a), "\n", "\\n", false, 4, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0092, code lost:
    
        if (r11.flush(r0) == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d1, code lost:
    
        if (r11 != r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00be A[PHI: r10
      0x00be: PHI (r10v2 boolean) = (r10v3 boolean), (r10v6 boolean) binds: [B:27:0x0072, B:22:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d1 -> B:43:0x00d4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object findNext$ktor_io(boolean r10, e9.InterfaceC4014c<? super java.lang.Long> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelScanner.findNext$ktor_io(boolean, e9.c):java.lang.Object");
    }

    public /* synthetic */ ByteChannelScanner(ByteReadChannel byteReadChannel, C4114a c4114a, ByteWriteChannel byteWriteChannel, long j10, int i10, i iVar) {
        this(byteReadChannel, c4114a, byteWriteChannel, (i10 & 8) != 0 ? Long.MAX_VALUE : j10);
    }
}
