package com.android.ttcjpaysdk.kmp.common.container.caijingbid;

import com.android.ttcjpaysdk.kmp.common.container.biz.IKmpDyVerifyBizExtensionService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/KmpCaiJingBid;", "", "<init>", "()V", "getExtension", "Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IKmpBizExtension;", "biz", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpCaiJingBid {
    public static final int $stable = 0;
    public static final KmpCaiJingBid INSTANCE = null;

    static {
        INSTANCE = new KmpCaiJingBid();
    }

    private KmpCaiJingBid() {
    }

    public final IKmpBizExtension getExtension(String r100) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        b r101 = c.f528682a;
        IKmpDyVerifyBizExtensionService r102 = (IKmpDyVerifyBizExtensionService) c.a(Reflection.getOrCreateKotlinClass(IKmpDyVerifyBizExtensionService.class));
        if (r102 == null) goto L9;
        Map<String, Function0<IKmpBizExtension>> r103 = r102.getBizExtends();
        if (r103 == null) goto L9;
        Function0<IKmpBizExtension> r104 = r103.get(r100);
        if (r104 == null) goto L9;
        return r104.invoke();
    L9:
        return null;
    }
}
