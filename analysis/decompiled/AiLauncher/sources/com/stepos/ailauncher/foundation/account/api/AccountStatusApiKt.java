package com.stepos.ailauncher.foundation.account.api;

import com.stepos.ailauncher.contract.model.AccountStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toAccountStatus", "Lcom/stepos/ailauncher/contract/model/AccountStatus;", "Lcom/stepos/ailauncher/foundation/account/api/BlockStatusDto;", "foundation_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AccountStatusApiKt {
    public static final AccountStatus toAccountStatus(BlockStatusDto blockStatusDto) {
        p.i(blockStatusDto, "<this>");
        return p.d(blockStatusDto.getExceeded(), Boolean.TRUE) ? new AccountStatus.Banned(blockStatusDto.getMuteStartAt(), blockStatusDto.getMuteEndAt()) : AccountStatus.Available.INSTANCE;
    }
}
