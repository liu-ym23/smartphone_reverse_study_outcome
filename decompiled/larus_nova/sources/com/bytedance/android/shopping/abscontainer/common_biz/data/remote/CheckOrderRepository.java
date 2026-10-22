package com.bytedance.android.shopping.abscontainer.common_biz.data.remote;

import com.bytedance.android.shopping.abscontainer.common_biz.platform.net.PlatformCheckOrderAPI;
import com.bytedance.retrofit2.SsResponse;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import r43.f;

/* JADX INFO: loaded from: classes12.dex */
public final class CheckOrderRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CheckOrderRepository f164292a = null;

    public CheckOrderRepository() {
    }

    static {
        f164292a = new CheckOrderRepository();
    }

    public final Object a(String r100, Map<String, String> r101, Map<String, ? extends Object> r102, Continuation<? super f> r103) {
        if ((r103 instanceof CheckOrderRepository$checkPayStatus$1) == false) goto L7;
        CheckOrderRepository$checkPayStatus$1 r104 = (CheckOrderRepository$checkPayStatus$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L15;
        if (r108 != 1) goto L14;
        ResultKt.throwOnFailure(r106);     // Catch: Exception -> L21
    L19:
        return (f) ((SsResponse) r106).body();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r106);
        PlatformCheckOrderAPI.f164349a.getClass();     // Catch: Exception -> L21
        PlatformCheckOrderAPI r109 = PlatformCheckOrderAPI.a.f164350a;     // Catch: Exception -> L21
        r104.label = 1;     // Catch: Exception -> L21
        r106 = r109.checkPayStatus(r100, r101, r102, r104);     // Catch: Exception -> L21
        if (r106 != r107) goto L19;
        return r107;
    L22:
        return new f(0);
    L7:
        r104 = new CheckOrderRepository$checkPayStatus$1(this, r103);
        goto L8
    }
}
