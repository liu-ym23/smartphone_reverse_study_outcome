package com.stepos.core.deepbinder;

import com.stepos.core.ability.AbilityInfo;
import com.stepos.deepbinder.annotation.type.AutoRecover;
import com.stepos.deepbinder.annotation.type.ServiceName;
import com.stepos.deepbinder.annotation.type.ValidityCheck;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@AutoRecover
@ServiceName("com.stepos.core.ability.deepbinder.AIEngineDeepBinderServiceImpl")
@ValidityCheck
/* loaded from: classes.dex */
public interface IAIEngineDeepBinderService {
    boolean checkCloudEnable(String str);

    boolean checkEnable(String str);

    Boolean checkModelReady(String str);

    boolean containsAbility(String str);

    List<AbilityInfo> getAbilities();

    String getAbilityProperty(String str, String str2);

    int getAbilityState(String str);

    boolean isDeviceSupported(String str);

    int openEnhancedServiceSettings();

    void registerGlobalModelChangeListener(String str, IModelChangeListener iModelChangeListener);

    boolean setAbilityProperty(String str, String str2, String str3);

    void showCTADialog(ICTACallback iCTACallback);

    void unregisterGlobalModelChangeListener(String str);
}
