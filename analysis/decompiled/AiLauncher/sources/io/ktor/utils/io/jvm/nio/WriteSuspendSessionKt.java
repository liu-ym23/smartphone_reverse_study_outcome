package io.ktor.utils.io.jvm.nio;

import Y8.t;
import e9.InterfaceC4014c;
import fb.C4074a;
import fb.o;
import fb.q;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteWriteChannel;
import java.nio.ByteBuffer;
import kb.C4845d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a8\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0087@¢\u0006\u0004\b\u0007\u0010\b\u001a*\u0010\f\u001a\u00020\u0004*\u00020\u00002\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0086H¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "Lkotlin/Function2;", "Lio/ktor/utils/io/jvm/nio/WriteSuspendSession;", "Le9/c;", "LY8/t;", "", "block", "writeSuspendSession", "(Lio/ktor/utils/io/ByteWriteChannel;Lp9/p;Le9/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "Ljava/nio/ByteBuffer;", "", "writeWhile", "(Lio/ktor/utils/io/ByteWriteChannel;Lp9/l;Le9/c;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WriteSuspendSessionKt {

    @InterfaceC4112d(c = "io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt", f = "WriteSuspendSession.kt", l = {43, 45, 45}, m = "writeSuspendSession")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt$writeSuspendSession$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return WriteSuspendSessionKt.writeSuspendSession(null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt", f = "WriteSuspendSession.kt", l = {59}, m = "writeWhile")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt$writeWhile$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44551 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C44551(InterfaceC4014c<? super C44551> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WriteSuspendSessionKt.writeWhile(null, null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x008d, code lost:
    
        if (r7 == r1) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v0, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, p9.p, p9.p<? super io.ktor.utils.io.jvm.nio.WriteSuspendSession, ? super e9.c<? super Y8.t>, ? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object writeSuspendSession(io.ktor.utils.io.ByteWriteChannel r7, p9.p<? super io.ktor.utils.io.jvm.nio.WriteSuspendSession, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt$writeSuspendSession$1 r0 = (io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt$writeSuspendSession$1 r0 = new io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt$writeSuspendSession$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L62
            if (r2 == r5) goto L4f
            if (r2 == r4) goto L43
            if (r2 == r3) goto L33
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            java.lang.Object r7 = r0.L$2
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object r8 = r0.L$1
            p9.p r8 = (p9.p) r8
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r8 = (io.ktor.utils.io.ByteWriteChannel) r8
            kotlin.C4849c.b(r9)
            goto Laa
        L43:
            java.lang.Object r7 = r0.L$1
            p9.p r7 = (p9.p) r7
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            kotlin.C4849c.b(r9)
            goto L90
        L4f:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            p9.p r8 = (p9.p) r8
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L5c
            goto L7b
        L5c:
            r9 = move-exception
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
            goto L93
        L62:
            kotlin.C4849c.b(r9)
            io.ktor.utils.io.jvm.nio.WriteSuspendSession r9 = new io.ktor.utils.io.jvm.nio.WriteSuspendSession     // Catch: java.lang.Throwable -> L5c
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L5c
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L5c
            java.lang.Object r2 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L5c
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L5c
            r0.label = r5     // Catch: java.lang.Throwable -> L5c
            java.lang.Object r9 = r8.invoke(r9, r0)     // Catch: java.lang.Throwable -> L5c
            if (r9 != r1) goto L7b
            goto La9
        L7b:
            java.lang.Object r9 = g9.h.a(r7)
            r0.L$0 = r9
            java.lang.Object r8 = g9.h.a(r8)
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r7 = r7.flush(r0)
            if (r7 != r1) goto L90
            goto La9
        L90:
            Y8.t r7 = Y8.t.f7040a
            return r7
        L93:
            java.lang.Object r2 = g9.h.a(r8)
            r0.L$0 = r2
            java.lang.Object r9 = g9.h.a(r9)
            r0.L$1 = r9
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r8 = r8.flush(r0)
            if (r8 != r1) goto Laa
        La9:
            return r1
        Laa:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt.writeSuspendSession(io.ktor.utils.io.ByteWriteChannel, p9.p, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object writeWhile(io.ktor.utils.io.ByteWriteChannel r11, p9.InterfaceC5074l<? super java.nio.ByteBuffer, java.lang.Boolean> r12, e9.InterfaceC4014c<? super Y8.t> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt.writeWhile(io.ktor.utils.io.ByteWriteChannel, p9.l, e9.c):java.lang.Object");
    }

    private static final Object writeWhile$$forInline(ByteWriteChannel byteWriteChannel, InterfaceC5074l<? super ByteBuffer, Boolean> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) {
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        while (!ref$BooleanRef.f34815a) {
            C4845d c4845d = C4845d.f34666a;
            C4074a bufferField = byteWriteChannel.getWriteBuffer().getBufferField();
            o oVarK0 = bufferField.k0(1);
            byte[] bArrB = oVarK0.b(false);
            Integer numValueOf = Integer.valueOf(oVarK0.getLimit());
            int iIntValue = Integer.valueOf(bArrB.length).intValue();
            int iIntValue2 = numValueOf.intValue();
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArrB, iIntValue2, iIntValue - iIntValue2);
            p.f(byteBufferWrap);
            ref$BooleanRef.f34815a = !interfaceC5074l.invoke(byteBufferWrap).booleanValue();
            int iIntValue3 = Integer.valueOf(byteBufferWrap.position() - iIntValue2).intValue();
            if (iIntValue3 == 1) {
                oVarK0.D(bArrB, iIntValue3);
                oVarK0.s(oVarK0.getLimit() + iIntValue3);
                bufferField.Y(bufferField.getSizeMut() + iIntValue3);
            } else {
                if (iIntValue3 < 0 || iIntValue3 > oVarK0.h()) {
                    throw new IllegalStateException(("Invalid number of bytes written: " + iIntValue3 + ". Should be in 0.." + oVarK0.h()).toString());
                }
                if (iIntValue3 != 0) {
                    oVarK0.D(bArrB, iIntValue3);
                    oVarK0.s(oVarK0.getLimit() + iIntValue3);
                    bufferField.Y(bufferField.getSizeMut() + iIntValue3);
                } else if (q.b(oVarK0)) {
                    bufferField.U();
                }
            }
            n.c(0);
            byteWriteChannel.flush(interfaceC4014c);
            n.c(1);
        }
        return t.f7040a;
    }
}
