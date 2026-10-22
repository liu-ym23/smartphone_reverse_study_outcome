package com.bytedance.android.ec.sdk.plugin.initializer;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes44.dex */
public final class LocalConstConfigInitializer extends com.bytedance.android.ec.sdk.initalizer.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f48158b;

    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object b() {
        return Boxing.boxBoolean(true);
    }

    public LocalConstConfigInitializer() {
        this.f48158b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, LocalConstConfigInitializer$configs$2.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005b -> B:22:0x005e). Please report as a decompilation issue!!! */
    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object c(Continuation<? super Unit> r100) {
        if ((r100 instanceof LocalConstConfigInitializer$init$1) == false) goto L7;
        LocalConstConfigInitializer$init$1 r101 = (LocalConstConfigInitializer$init$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L15;
        int r106 = r101.I$1;
        int r107 = r101.I$0;
        com.bytedance.android.ec.ab.opt.b[] r108 = (com.bytedance.android.ec.ab.opt.b[]) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L25
    L22:
        r106 = r106 + 1;     // Catch: Throwable -> L25
    L18:
        if (r106 >= r107) goto L23;
        com.bytedance.android.ec.ab.opt.b r109 = r108[r106];     // Catch: Throwable -> L25
        r101.L$0 = r108;     // Catch: Throwable -> L25
        r101.I$0 = r107;     // Catch: Throwable -> L25
        r101.I$1 = r106;     // Catch: Throwable -> L25
        r101.label = 1;     // Catch: Throwable -> L25
        if (r109.a(r101) != r104) goto L22;
        return r104;
    L23:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L28:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L25
        com.bytedance.android.ec.ab.opt.b[] r111 = (com.bytedance.android.ec.ab.opt.b[]) this.f48158b.getValue();     // Catch: Throwable -> L25
        r108 = r111;
        r107 = r111.length;     // Catch: Throwable -> L25
        r106 = 0;
    L25:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new LocalConstConfigInitializer$init$1(this, r100);
        goto L8
    }
}
