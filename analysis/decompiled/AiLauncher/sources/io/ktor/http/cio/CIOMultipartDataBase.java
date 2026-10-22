package io.ktor.http.cio;

import Ua.M;
import Wa.r;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.cio.MultipartEvent;
import io.ktor.http.content.MultiPartData;
import io.ktor.http.content.PartData;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;

@InternalAPI
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0096@¢\u0006\u0004\b\u0019\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lio/ktor/http/cio/CIOMultipartDataBase;", "Lio/ktor/http/content/MultiPartData;", "LUa/M;", "Lkotlin/coroutines/d;", "coroutineContext", "Lio/ktor/utils/io/ByteReadChannel;", "channel", "", "contentType", "", "contentLength", "formFieldLimit", "<init>", "(Lkotlin/coroutines/d;Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/CharSequence;Ljava/lang/Long;J)V", "Lio/ktor/http/content/PartData;", "readPartSuspend", "(Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/cio/MultipartEvent;", "event", "eventToData", "(Lio/ktor/http/cio/MultipartEvent;Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/cio/MultipartEvent$MultipartPart;", "part", "partToData", "(Lio/ktor/http/cio/MultipartEvent$MultipartPart;Le9/c;)Ljava/lang/Object;", "readPart", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "previousPart", "Lio/ktor/http/content/PartData;", "LWa/r;", "events", "LWa/r;", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CIOMultipartDataBase implements MultiPartData, M {
    private final kotlin.coroutines.d coroutineContext;
    private final r<MultipartEvent> events;
    private PartData previousPart;

    @InterfaceC4112d(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", l = {62}, m = "eventToData")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.cio.CIOMultipartDataBase$eventToData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return CIOMultipartDataBase.this.eventToData(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", l = {75, 82}, m = "partToData")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.cio.CIOMultipartDataBase$partToData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42821 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C42821(InterfaceC4014c<? super C42821> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOMultipartDataBase.this.partToData(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", l = {39, 45}, m = "readPart")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.cio.CIOMultipartDataBase$readPart$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42831 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C42831(InterfaceC4014c<? super C42831> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOMultipartDataBase.this.readPart(this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", l = {51, 52}, m = "readPartSuspend")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.cio.CIOMultipartDataBase$readPartSuspend$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42841 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C42841(InterfaceC4014c<? super C42841> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOMultipartDataBase.this.readPartSuspend(this);
        }
    }

    public CIOMultipartDataBase(kotlin.coroutines.d coroutineContext, ByteReadChannel channel, CharSequence contentType, Long l10, long j10) {
        p.i(coroutineContext, "coroutineContext");
        p.i(channel, "channel");
        p.i(contentType, "contentType");
        this.coroutineContext = coroutineContext;
        this.events = MultipartKt.parseMultipart(this, channel, contentType, l10, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object eventToData(io.ktor.http.cio.MultipartEvent r5, e9.InterfaceC4014c<? super io.ktor.http.content.PartData> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.http.cio.CIOMultipartDataBase.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.http.cio.CIOMultipartDataBase$eventToData$1 r0 = (io.ktor.http.cio.CIOMultipartDataBase.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.http.cio.CIOMultipartDataBase$eventToData$1 r0 = new io.ktor.http.cio.CIOMultipartDataBase$eventToData$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.http.cio.MultipartEvent r5 = (io.ktor.http.cio.MultipartEvent) r5
            kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L2e
            goto L4d
        L2e:
            r4 = move-exception
            goto L55
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.C4849c.b(r6)
            boolean r6 = r5 instanceof io.ktor.http.cio.MultipartEvent.MultipartPart     // Catch: java.lang.Throwable -> L2e
            if (r6 == 0) goto L50
            r6 = r5
            io.ktor.http.cio.MultipartEvent$MultipartPart r6 = (io.ktor.http.cio.MultipartEvent.MultipartPart) r6     // Catch: java.lang.Throwable -> L2e
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L2e
            r0.label = r3     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r6 = r4.partToData(r6, r0)     // Catch: java.lang.Throwable -> L2e
            if (r6 != r1) goto L4d
            return r1
        L4d:
            io.ktor.http.content.PartData r6 = (io.ktor.http.content.PartData) r6     // Catch: java.lang.Throwable -> L2e
            return r6
        L50:
            r5.release()     // Catch: java.lang.Throwable -> L2e
            r4 = 0
            return r4
        L55:
            r5.release()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.CIOMultipartDataBase.eventToData(io.ktor.http.cio.MultipartEvent, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object partToData(final io.ktor.http.cio.MultipartEvent.MultipartPart r7, e9.InterfaceC4014c<? super io.ktor.http.content.PartData> r8) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.CIOMultipartDataBase.partToData(io.ktor.http.cio.MultipartEvent$MultipartPart, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t partToData$lambda$4$lambda$3(MultipartEvent.MultipartPart multipartPart) throws InterruptedException {
        multipartPart.release();
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t partToData$lambda$6(MultipartEvent.MultipartPart multipartPart) throws InterruptedException {
        multipartPart.release();
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
    
        if (r7 != r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004d A[Catch: ClosedReceiveChannelException -> 0x0063, PHI: r7
      0x004d: PHI (r7v2 java.lang.Object) = (r7v6 java.lang.Object), (r7v1 java.lang.Object) binds: [B:21:0x004a, B:17:0x0039] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {ClosedReceiveChannelException -> 0x0063, blocks: (B:13:0x002d, B:26:0x005e, B:20:0x0040, B:23:0x004d, B:17:0x0039), top: B:30:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005b -> B:26:0x005e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readPartSuspend(e9.InterfaceC4014c<? super io.ktor.http.content.PartData> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof io.ktor.http.cio.CIOMultipartDataBase.C42841
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.http.cio.CIOMultipartDataBase$readPartSuspend$1 r0 = (io.ktor.http.cio.CIOMultipartDataBase.C42841) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.http.cio.CIOMultipartDataBase$readPartSuspend$1 r0 = new io.ktor.http.cio.CIOMultipartDataBase$readPartSuspend$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3d
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r2 = r0.L$0
            io.ktor.http.cio.MultipartEvent r2 = (io.ktor.http.cio.MultipartEvent) r2
            kotlin.C4849c.b(r7)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L63
            goto L5e
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.C4849c.b(r7)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L63
            goto L4d
        L3d:
            kotlin.C4849c.b(r7)
        L40:
            Wa.r<io.ktor.http.cio.MultipartEvent> r7 = r6.events     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L63
            r0.L$0 = r3     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L63
            r0.label = r5     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L63
            java.lang.Object r7 = r7.receive(r0)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L63
            if (r7 != r1) goto L4d
            goto L5d
        L4d:
            io.ktor.http.cio.MultipartEvent r7 = (io.ktor.http.cio.MultipartEvent) r7     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L63
            java.lang.Object r2 = g9.h.a(r7)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L63
            r0.L$0 = r2     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L63
            r0.label = r4     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L63
            java.lang.Object r7 = r6.eventToData(r7, r0)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L63
            if (r7 != r1) goto L5e
        L5d:
            return r1
        L5e:
            io.ktor.http.content.PartData r7 = (io.ktor.http.content.PartData) r7     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L63
            if (r7 == 0) goto L40
            return r7
        L63:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.CIOMultipartDataBase.readPartSuspend(e9.c):java.lang.Object");
    }

    @Override // Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
    
        if (r6 == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0073 -> B:31:0x0076). Please report as a decompilation issue!!! */
    @Override // io.ktor.http.content.MultiPartData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object readPart(e9.InterfaceC4014c<? super io.ktor.http.content.PartData> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.http.cio.CIOMultipartDataBase.C42831
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.http.cio.CIOMultipartDataBase$readPart$1 r0 = (io.ktor.http.cio.CIOMultipartDataBase.C42831) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.http.cio.CIOMultipartDataBase$readPart$1 r0 = new io.ktor.http.cio.CIOMultipartDataBase$readPart$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.C4849c.b(r6)
            return r6
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r2 = r0.L$0
            io.ktor.http.cio.MultipartEvent r2 = (io.ktor.http.cio.MultipartEvent) r2
            kotlin.C4849c.b(r6)
            goto L76
        L3c:
            kotlin.C4849c.b(r6)
            io.ktor.http.content.PartData r6 = r5.previousPart
            if (r6 == 0) goto L4c
            p9.a r6 = r6.getDispose()
            if (r6 == 0) goto L4c
            r6.invoke()
        L4c:
            Wa.r<io.ktor.http.cio.MultipartEvent> r6 = r5.events
            java.lang.Object r6 = r6.s()
            java.lang.Object r6 = kotlinx.coroutines.channels.a.f(r6)
            io.ktor.http.cio.MultipartEvent r6 = (io.ktor.http.cio.MultipartEvent) r6
            if (r6 != 0) goto L67
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = r5.readPartSuspend(r0)
            if (r5 != r1) goto L66
            goto L75
        L66:
            return r5
        L67:
            java.lang.Object r2 = g9.h.a(r6)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r6 = r5.eventToData(r6, r0)
            if (r6 != r1) goto L76
        L75:
            return r1
        L76:
            io.ktor.http.content.PartData r6 = (io.ktor.http.content.PartData) r6
            if (r6 == 0) goto L4c
            r5.previousPart = r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.CIOMultipartDataBase.readPart(e9.c):java.lang.Object");
    }

    public /* synthetic */ CIOMultipartDataBase(kotlin.coroutines.d dVar, ByteReadChannel byteReadChannel, CharSequence charSequence, Long l10, long j10, int i10, kotlin.jvm.internal.i iVar) {
        this(dVar, byteReadChannel, charSequence, l10, (i10 & 16) != 0 ? 65536L : j10);
    }
}
