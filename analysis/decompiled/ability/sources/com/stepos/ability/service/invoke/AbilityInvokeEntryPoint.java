package com.stepos.ability.service.invoke;

import com.stepos.ability.api.ability.calltool.ICallTool;
import com.stepos.ability.commoninternal.ability.IAbilityManager;
import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import kotlin.Metadata;

@EntryPoint
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/service/invoke/AbilityInvokeEntryPoint;", "", "callTool", "Lcom/stepos/ability/api/ability/calltool/ICallTool;", "abilityManager", "Lcom/stepos/ability/commoninternal/ability/IAbilityManager;", "service_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@InstallIn({SingletonComponent.class})
/* loaded from: classes3.dex */
public interface AbilityInvokeEntryPoint {
    IAbilityManager abilityManager();

    ICallTool callTool();
}
