package com.stepos.ailauncher.foundation.appstore.api;

import Ac.f;
import Ac.t;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/api/AppDetailApi;", "", "", "packageName", "Lcom/stepos/ailauncher/foundation/appstore/api/AppStoreResponse;", "Lcom/stepos/ailauncher/foundation/appstore/api/AppDetailDto;", "detail", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AppDetailApi {
    @f("apps/public/detail")
    Object detail(@t("package_name") String str, InterfaceC4014c<? super AppStoreResponse<AppDetailDto>> interfaceC4014c);
}
