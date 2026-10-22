package com.bytedance.android.ec.live.api.commerce.userinfo;

import com.bytedance.android.shopping.anchorv3.utils.o;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/c;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/ec/live/api/commerce/userinfo/c;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ECUserInfo$userInfo$2 extends Lambda implements Function0<c> {
    final /* synthetic */ b this$0;

    public ECUserInfo$userInfo$2(b r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final c invoke() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        this.this$0.getClass();     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl((c) GsonProtectorUtils.fromJson(o.a(), null, c.class));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        ye.a.b(r103);
    L11:
        if (Result.m9455isFailureimpl(r102) == true) goto L15;
        r100 = r102;
    L15:
        return (c) r100;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ c invoke() {
        return invoke();
    }
}
