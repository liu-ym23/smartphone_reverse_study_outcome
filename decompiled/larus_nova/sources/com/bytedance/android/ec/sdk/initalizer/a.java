package com.bytedance.android.ec.sdk.initalizer;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f48143a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.ec.sdk.initalizer.a$a, reason: collision with other inner class name */
    public static final class C0835a {
        public C0835a() {
        }
    }

    static {
        new C0835a();
    }

    public a() {
    }

    public abstract Object b();

    public abstract Object c(Continuation<? super Unit> r100);

    public static final Object a(a r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof ECBizInitializer$run$1) == false) goto L7;
        ECBizInitializer$run$1 r102 = (ECBizInitializer$run$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L30:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (a) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L24
    L22:
        boolean r107 = ((Boolean) r104).booleanValue();     // Catch: Throwable -> L24
    L25:
        if (r107 == false) goto L30;
        r102.L$0 = null;
        r102.label = 2;
        if (r100.c(r102) != r105) goto L30;
        return r105;
    L18:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;     // Catch: Throwable -> L24
        r102.label = 1;     // Catch: Throwable -> L24
        r104 = r100.b();     // Catch: Throwable -> L24
        if (r104 != r105) goto L22;
        return r105;
    L24:
        r107 = false;
    L7:
        r102 = new ECBizInitializer$run$1(r100, r101);
        goto L8
    }
}
