package io.ktor.util.cio;

import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperations_jvmKt;
import io.ktor.utils.io.InternalAPI;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.n;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0087H¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Ljava/nio/ByteBuffer;", "buffer", "Lkotlin/Function1;", "LY8/t;", "block", "pass", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/ByteBuffer;Lp9/l;Le9/c;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReadersJvmKt {

    @InterfaceC4112d(c = "io.ktor.util.cio.ReadersJvmKt", f = "ReadersJvm.kt", l = {19}, m = "pass")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: io.ktor.util.cio.ReadersJvmKt$pass$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return ReadersJvmKt.pass(null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005f -> B:20:0x0062). Please report as a decompilation issue!!! */
    @io.ktor.utils.io.InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object pass(io.ktor.utils.io.ByteReadChannel r4, java.nio.ByteBuffer r5, p9.InterfaceC5074l<? super java.nio.ByteBuffer, Y8.t> r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.util.cio.ReadersJvmKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.util.cio.ReadersJvmKt$pass$1 r0 = (io.ktor.util.cio.ReadersJvmKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.util.cio.ReadersJvmKt$pass$1 r0 = new io.ktor.util.cio.ReadersJvmKt$pass$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            int r4 = r0.I$0
            java.lang.Object r5 = r0.L$2
            p9.l r5 = (p9.InterfaceC5074l) r5
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            kotlin.C4849c.b(r7)
            r7 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            r4 = r2
            goto L62
        L3c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L44:
            kotlin.C4849c.b(r7)
            r7 = 0
        L48:
            boolean r2 = r4.isClosedForRead()
            if (r2 != 0) goto L69
            r5.clear()
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r2 = io.ktor.utils.io.ByteReadChannelOperations_jvmKt.readAvailable(r4, r5, r0)
            if (r2 != r1) goto L62
            return r1
        L62:
            r5.flip()
            r6.invoke(r5)
            goto L48
        L69:
            java.lang.Throwable r4 = r4.getClosedCause()
            if (r4 != 0) goto L72
            Y8.t r4 = Y8.t.f7040a
            return r4
        L72:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.cio.ReadersJvmKt.pass(io.ktor.utils.io.ByteReadChannel, java.nio.ByteBuffer, p9.l, e9.c):java.lang.Object");
    }

    @InternalAPI
    private static final Object pass$$forInline(ByteReadChannel byteReadChannel, ByteBuffer byteBuffer, InterfaceC5074l<? super ByteBuffer, t> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        while (!byteReadChannel.isClosedForRead()) {
            byteBuffer.clear();
            n.c(0);
            ByteReadChannelOperations_jvmKt.readAvailable(byteReadChannel, byteBuffer, interfaceC4014c);
            n.c(1);
            byteBuffer.flip();
            interfaceC5074l.invoke(byteBuffer);
        }
        Throwable closedCause = byteReadChannel.getClosedCause();
        if (closedCause == null) {
            return t.f7040a;
        }
        throw closedCause;
    }
}
