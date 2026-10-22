package com.bytedance.android.service.manager.client.ai;

import com.bytedance.android.push.service.manager.annotation.ExternalService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@ExternalService
public interface IClientAiExternalService {
    void init();

    boolean isClientAiReady();

    void registerClientAICallback(IClientAICallback r100);

    void runTask(JSONObject r100);
}
