package com.bytedance.android.service.manager.push.trace;

/* JADX INFO: loaded from: classes3.dex */
public class PushTraceExternalServiceImplOfMock implements PushTraceExternalService {
    public PushTraceExternalServiceImplOfMock() {
    }

    @Override // com.bytedance.android.service.manager.push.trace.PushTraceExternalService
    public ITraceScene getTraceScene(PushTraceSceneType r100) {
        return new ITraceSceneImplOfMock();
    }
}
