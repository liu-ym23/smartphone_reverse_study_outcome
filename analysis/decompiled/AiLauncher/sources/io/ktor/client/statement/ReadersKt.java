package io.ktor.client.statement;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0087@¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u0000H\u0086@¢\u0006\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lio/ktor/client/statement/HttpResponse;", "", "count", "", "readBytes", "(Lio/ktor/client/statement/HttpResponse;ILe9/c;)Ljava/lang/Object;", "readRawBytes", "(Lio/ktor/client/statement/HttpResponse;Le9/c;)Ljava/lang/Object;", "LY8/t;", "discardRemaining", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReadersKt {

    @InterfaceC4112d(c = "io.ktor.client.statement.ReadersKt", f = "Readers.kt", l = {17}, m = "readBytes")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.statement.ReadersKt$readBytes$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadersKt.readBytes(null, 0, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.statement.ReadersKt", f = "Readers.kt", l = {53}, m = "readBytes")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.statement.ReadersKt$readBytes$3, reason: invalid class name */
    public static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadersKt.readBytes(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.statement.ReadersKt", f = "Readers.kt", l = {35}, m = "readRawBytes")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.statement.ReadersKt$readRawBytes$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42751 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C42751(InterfaceC4014c<? super C42751> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadersKt.readRawBytes(null, this);
        }
    }

    public static final Object discardRemaining(HttpResponse httpResponse, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objDiscard$default = ByteReadChannelOperationsKt.discard$default(httpResponse.getRawContent(), 0L, interfaceC4014c, 1, null);
        return objDiscard$default == C4063a.g() ? objDiscard$default : t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readBytes(io.ktor.client.statement.HttpResponse r8, int r9, e9.InterfaceC4014c<? super byte[]> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof io.ktor.client.statement.ReadersKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.client.statement.ReadersKt$readBytes$1 r0 = (io.ktor.client.statement.ReadersKt.AnonymousClass1) r0
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
            io.ktor.client.statement.ReadersKt$readBytes$1 r0 = new io.ktor.client.statement.ReadersKt$readBytes$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r5.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L37
            java.lang.Object r8 = r5.L$2
            byte[] r8 = (byte[]) r8
            java.lang.Object r8 = r5.L$1
            byte[] r8 = (byte[]) r8
            java.lang.Object r9 = r5.L$0
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            kotlin.C4849c.b(r10)
            return r8
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            kotlin.C4849c.b(r10)
            r10 = r2
            byte[] r2 = new byte[r9]
            io.ktor.utils.io.ByteReadChannel r1 = r8.getRawContent()
            java.lang.Object r8 = g9.h.a(r8)
            r5.L$0 = r8
            r5.L$1 = r2
            java.lang.Object r8 = g9.h.a(r2)
            r5.L$2 = r8
            r5.I$0 = r9
            r8 = 0
            r5.I$1 = r8
            r5.label = r10
            r3 = 0
            r4 = 0
            r6 = 6
            r7 = 0
            java.lang.Object r8 = io.ktor.utils.io.ByteReadChannelOperationsKt.readFully$default(r1, r2, r3, r4, r5, r6, r7)
            if (r8 != r0) goto L69
            return r0
        L69:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.ReadersKt.readBytes(io.ktor.client.statement.HttpResponse, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readRawBytes(io.ktor.client.statement.HttpResponse r4, e9.InterfaceC4014c<? super byte[]> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.client.statement.ReadersKt.C42751
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.client.statement.ReadersKt$readRawBytes$1 r0 = (io.ktor.client.statement.ReadersKt.C42751) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.statement.ReadersKt$readRawBytes$1 r0 = new io.ktor.client.statement.ReadersKt$readRawBytes$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            io.ktor.client.statement.HttpResponse r4 = (io.ktor.client.statement.HttpResponse) r4
            kotlin.C4849c.b(r5)
            goto L4b
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r5)
            io.ktor.utils.io.ByteReadChannel r5 = r4.getRawContent()
            java.lang.Object r4 = g9.h.a(r4)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = io.ktor.utils.io.ByteReadChannelOperationsKt.readRemaining(r5, r0)
            if (r5 != r1) goto L4b
            return r1
        L4b:
            fb.v r5 = (fb.v) r5
            byte[] r4 = fb.x.c(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.ReadersKt.readRawBytes(io.ktor.client.statement.HttpResponse, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readBytes(io.ktor.client.statement.HttpResponse r4, e9.InterfaceC4014c<? super byte[]> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.client.statement.ReadersKt.AnonymousClass3
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.client.statement.ReadersKt$readBytes$3 r0 = (io.ktor.client.statement.ReadersKt.AnonymousClass3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.statement.ReadersKt$readBytes$3 r0 = new io.ktor.client.statement.ReadersKt$readBytes$3
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            io.ktor.client.statement.HttpResponse r4 = (io.ktor.client.statement.HttpResponse) r4
            kotlin.C4849c.b(r5)
            goto L4b
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r5)
            io.ktor.utils.io.ByteReadChannel r5 = r4.getRawContent()
            java.lang.Object r4 = g9.h.a(r4)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = io.ktor.utils.io.ByteReadChannelOperationsKt.readRemaining(r5, r0)
            if (r5 != r1) goto L4b
            return r1
        L4b:
            fb.v r5 = (fb.v) r5
            byte[] r4 = fb.x.c(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.ReadersKt.readBytes(io.ktor.client.statement.HttpResponse, e9.c):java.lang.Object");
    }
}
