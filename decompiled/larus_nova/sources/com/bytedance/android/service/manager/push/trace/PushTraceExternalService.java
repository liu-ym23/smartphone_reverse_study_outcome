package com.bytedance.android.service.manager.push.trace;

import com.bytedance.android.push.service.manager.annotation.ExternalService;

/* JADX INFO: loaded from: classes3.dex */
@ExternalService
public interface PushTraceExternalService {
    ITraceScene getTraceScene(PushTraceSceneType r100);
}
