package com.stepos.core.common.runtime;

import com.stepos.core.common.cloudconfig.CloudConfigResult;
import com.stepos.core.common.cloudconfig.ICloudConfigListener;
import gc.a;
import java.util.List;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EngineRuntimeCloudConfigListener implements ICloudConfigListener {
    private final String fileName = "engine_runtime.json";
    private final String key = "key_engine_runtime";

    @Override // com.stepos.core.common.cloudconfig.ICloudConfigListener
    public List<String> dumpApplyState() {
        return ICloudConfigListener.DefaultImpls.dumpApplyState(this);
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
        EngineRuntimeConfig.INSTANCE.apply(bytes);
        return CloudConfigResult.SUCCESS;
    }

    @Override // com.stepos.core.common.cloudconfig.ICloudConfigListener
    public boolean validate(byte[] bytes) {
        Object objA;
        g.f(bytes, "bytes");
        try {
            objA = Boolean.valueOf(new JSONObject(new String(bytes, a.f9106b)).has("memoryRelease"));
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
