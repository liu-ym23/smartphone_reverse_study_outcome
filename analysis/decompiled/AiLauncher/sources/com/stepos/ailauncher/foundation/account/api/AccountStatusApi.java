package com.stepos.ailauncher.foundation.account.api;

import Ac.f;
import com.stepos.ailauncher.network.ApiResponse;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/foundation/account/api/AccountStatusApi;", "", "Lcom/stepos/ailauncher/network/ApiResponse;", "Lcom/stepos/ailauncher/foundation/account/api/BlockStatusDto;", "fetchStatus", "(Le9/c;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AccountStatusApi {
    @f("/ai-user-service/api/v1/safety/audit/block-status")
    Object fetchStatus(InterfaceC4014c<? super ApiResponse<BlockStatusDto>> interfaceC4014c);
}
