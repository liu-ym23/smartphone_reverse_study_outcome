package com.stepos.core;

import android.os.Bundle;
import com.stepos.aiengine.model.IDownloader;
import com.stepos.aiengine.model.IModelManager;
import com.stepos.core.ability.AbilityInfo;
import com.stepos.core.deepbinder.ICTACallback;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IAIEngine {
    boolean checkCloudEnable(String str);

    boolean checkEnable(String str);

    Boolean checkModelReady(String str);

    boolean containsAbility(String str);

    List<AbilityInfo> getAbilities();

    String getAbilityProperty(String str, String str2);

    int getAbilityState(String str);

    IDownloader getDownloader(Bundle bundle);

    IModelManager getModelManager(String str);

    boolean isDeviceSupported(String str);

    boolean setAbilityProperty(String str, String str2, String str3);

    void showCTADialog(ICTACallback iCTACallback);
}
