package com.stepos.core;

import android.os.Bundle;
import com.stepos.aiengine.model.IDownloader;
import com.stepos.aiengine.model.IModelManager;
import com.stepos.core.ability.AbilityInfo;
import com.stepos.core.deepbinder.ICTACallback;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0012\u0010\nJ!\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H&¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0006H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b \u0010!J\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/stepos/core/IAIEngine;", "", "", "Lcom/stepos/core/ability/AbilityInfo;", "getAbilities", "()Ljava/util/List;", "", "id", "", "containsAbility", "(Ljava/lang/String;)Z", "isDeviceSupported", "", "getAbilityState", "(Ljava/lang/String;)I", "checkModelReady", "(Ljava/lang/String;)Ljava/lang/Boolean;", "checkEnable", "checkCloudEnable", "name", "getAbilityProperty", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", UxipConstants.f30680s, "setAbilityProperty", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "algorithm", "Lcom/stepos/aiengine/model/IModelManager;", "getModelManager", "(Ljava/lang/String;)Lcom/stepos/aiengine/model/IModelManager;", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/model/IDownloader;", "getDownloader", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/model/IDownloader;", "Lcom/stepos/core/deepbinder/ICTACallback;", "callback", "LY8/t;", "showCTADialog", "(Lcom/stepos/core/deepbinder/ICTACallback;)V", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAIEngine {
    boolean checkCloudEnable(String id);

    boolean checkEnable(String id);

    Boolean checkModelReady(String id);

    boolean containsAbility(String id);

    List<AbilityInfo> getAbilities();

    String getAbilityProperty(String id, String name);

    int getAbilityState(String id);

    IDownloader getDownloader(Bundle args);

    IModelManager getModelManager(String algorithm);

    boolean isDeviceSupported(String id);

    boolean setAbilityProperty(String id, String name, String value);

    void showCTADialog(ICTACallback callback);
}
