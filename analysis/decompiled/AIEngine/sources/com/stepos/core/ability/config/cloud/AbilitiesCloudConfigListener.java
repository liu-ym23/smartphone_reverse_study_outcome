package com.stepos.core.ability.config.cloud;

import com.stepos.core.ability.AbilityManager;
import com.stepos.core.ability.config.AbilityConfigLoader;
import com.stepos.core.common.cloudconfig.CloudConfigResult;
import com.stepos.core.common.cloudconfig.ICloudConfigListener;
import gc.a;
import java.util.List;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AbilitiesCloudConfigListener implements ICloudConfigListener {
    private final String fileName = "abilities.json";
    private final String key = "key_ability_config";

    @Override // com.stepos.core.common.cloudconfig.ICloudConfigListener
    public List<String> dumpApplyState() {
        return AbilityManager.INSTANCE.dumpCloudConfig();
    }

    @Override // com.stepos.core.common.cloudconfig.ICloudConfigListener
    public String getFileName() {
        return this.fileName;
    }

    @Override // com.stepos.core.common.cloudconfig.ICloudConfigListener
    public String getKey() {
        return this.key;
    }

    @Override // com.stepos.core.common.cloudconfig.ICloudConfigListener
    public String getLocalName() {
        return ICloudConfigListener.DefaultImpls.getLocalName(this);
    }

    @Override // com.stepos.core.common.cloudconfig.ICloudConfigListener
    public CloudConfigResult onConfigReceived(String key, byte[] bytes) {
        g.f(key, "key");
        g.f(bytes, "bytes");
        AbilityManager.INSTANCE.applyCloudConfig(bytes);
        return CloudConfigResult.SUCCESS;
    }

    @Override // com.stepos.core.common.cloudconfig.ICloudConfigListener
    public boolean validate(byte[] bytes) {
        Object objA;
        g.f(bytes, "bytes");
        try {
            objA = Boolean.valueOf(!AbilityConfigLoader.INSTANCE.parseAbilities(new String(bytes, a.f9106b)).isEmpty());
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }
}
