package com.bytedance.android.window.shop.eventcard.handler;

import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "shoppingABKey", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class LynxABReadHandler$handleEvent$reader$2 extends FunctionReferenceImpl implements Function1<String, Object> {
    public LynxABReadHandler$handleEvent$reader$2(dp3.a r100) {
        super(1, r100, dp3.a.class, "readShopAB", "readShopAB(Ljava/lang/String;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((dp3.a) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, "shoppingABKey");
        int r101 = p.f45243a;
        Object r102 = "";
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r104 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r105 = jj4.a.a(r100, String.class, "", false);     // Catch: Throwable -> L7
        if (r105 != null) goto L16;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
        return r105;
    L16:
        return r105;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == true) goto L13;
        r102 = r107;
    L13:
        return r102;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(String r100) {
        return invoke2(r100);
    }
}
