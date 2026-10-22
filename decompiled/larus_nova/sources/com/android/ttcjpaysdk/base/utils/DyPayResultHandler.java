package com.android.ttcjpaysdk.base.utils;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\rH\u0096\u0002¢\u0006\u0002\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/DyPayResultHandler;", "Ljava/lang/reflect/InvocationHandler;", "callback", "Lcom/android/ttcjpaysdk/ttcjpayapi/IH5PayCallback;", "(Lcom/android/ttcjpaysdk/ttcjpayapi/IH5PayCallback;)V", "getCallback", "()Lcom/android/ttcjpaysdk/ttcjpayapi/IH5PayCallback;", AbsMethodDelegate.TAG_INVOKE, "", "proxy", e.f25671s, "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyPayResultHandler implements InvocationHandler {
    private final IH5PayCallback callback;

    public final IH5PayCallback getCallback() {
        return this.callback;
    }

    public DyPayResultHandler(IH5PayCallback r100) {
        this.callback = r100;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r100, Method r101, Object[] r102) {
        Intrinsics.checkNotNullParameter(r100, "proxy");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "args");
        int r103 = 0;
        Object r104 = r102[0];     // Catch: Exception -> L17
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");     // Catch: Exception -> L17
        Map r105 = (Map) r104;     // Catch: Exception -> L17
        String r106 = (String) r105.get("resultCode");     // Catch: Exception -> L17
        if (Intrinsics.areEqual(r106, "0") == false) goto L7;
    L10:
        String r107 = (String) r105.get("errorMsg");     // Catch: Exception -> L17
        if (r107 != null) goto L13;
        r107 = "";
    L13:
        IH5PayCallback r108 = this.callback;     // Catch: Exception -> L17
        if (r108 == null) goto L23;
        r108.onResult(r103, r107);     // Catch: Exception -> L17
        return null;
    L23:
        return null;
    L7:
        if (Intrinsics.areEqual(r106, "1") == false) goto L9;
        r103 = 4;
        goto L10
    L9:
        r103 = 2;
    L17:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJOuterPayUtils#invoke", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJOuterPayUtils#invoke", e);
        return null;
    }
}
