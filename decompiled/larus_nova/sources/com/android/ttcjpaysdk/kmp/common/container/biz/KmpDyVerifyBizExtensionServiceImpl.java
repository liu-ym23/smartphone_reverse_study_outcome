package com.android.ttcjpaysdk.kmp.common.container.biz;

import com.android.ttcjpaysdk.kmp.common.container.caijingbid.IKmpBizExtension;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/container/biz/KmpDyVerifyBizExtensionServiceImpl;", "Lcom/android/ttcjpaysdk/kmp/common/container/biz/IKmpDyVerifyBizExtensionService;", "<init>", "()V", "getBizExtends", "", "", "Lkotlin/Function0;", "Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IKmpBizExtension;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpDyVerifyBizExtensionServiceImpl implements IKmpDyVerifyBizExtensionService {
    public static final int $stable = 0;

    public KmpDyVerifyBizExtensionServiceImpl() {
    }

    public static /* synthetic */ StudentBizExtension u() {
        return getBizExtends$lambda$0();
    }

    private static final StudentBizExtension getBizExtends$lambda$0() {
        return new StudentBizExtension();
    }

    @Override // com.android.ttcjpaysdk.kmp.common.container.biz.IBizExtensionProvider
    public Map<String, Function0<IKmpBizExtension>> getBizExtends() {
        return MapsKt.mapOf(TuplesKt.to(StudentBizExtension.BIZ_NAME, new a()));
    }
}
