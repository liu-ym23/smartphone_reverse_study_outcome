package com.android.ttcjpaysdk.kmp.common.container.biz;

import com.android.ttcjpaysdk.kmp.common.container.caijingbid.IKmpBizExtension;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/container/biz/IBizExtensionProvider;", "Lcom/bytedance/kmp/spi/IKmpService;", "getBizExtends", "", "", "Lkotlin/Function0;", "Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IKmpBizExtension;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBizExtensionProvider extends pd6.a {
    Map<String, Function0<IKmpBizExtension>> getBizExtends();
}
