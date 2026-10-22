package io.ktor.util;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.util.NonceKt$nonceGeneratorJob$1", f = "Nonce.kt", l = {76}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class NonceKt$nonceGeneratorJob$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    int I$0;
    int I$1;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    public NonceKt$nonceGeneratorJob$1(InterfaceC4014c<? super NonceKt$nonceGeneratorJob$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new NonceKt$nonceGeneratorJob$1(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((NonceKt$nonceGeneratorJob$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0084 A[Catch: all -> 0x0046, LOOP:1: B:14:0x0082->B:15:0x0084, LOOP_END, TryCatch #0 {all -> 0x0046, blocks: (B:6:0x0031, B:13:0x0079, B:15:0x0084, B:16:0x008d, B:18:0x0099, B:20:0x00aa, B:19:0x00a7), top: B:41:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0099 A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:6:0x0031, B:13:0x0079, B:15:0x0084, B:16:0x008d, B:18:0x0099, B:20:0x00aa, B:19:0x00a7), top: B:41:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a7 A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:6:0x0031, B:13:0x0079, B:15:0x0084, B:16:0x008d, B:18:0x0099, B:20:0x00aa, B:19:0x00a7), top: B:41:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00dd A[Catch: all -> 0x0108, TRY_ENTER, TryCatch #1 {all -> 0x0108, blocks: (B:26:0x0103, B:23:0x00dd, B:29:0x010b, B:31:0x011a), top: B:43:0x0103 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010b A[Catch: all -> 0x0108, TryCatch #1 {all -> 0x0108, blocks: (B:26:0x0103, B:23:0x00dd, B:29:0x010b, B:31:0x011a), top: B:43:0x0103 }] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [Wa.s, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00c9 -> B:22:0x00db). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0100 -> B:43:0x0103). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.NonceKt$nonceGeneratorJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
