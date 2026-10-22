package com.bytedance.vmsdk.jsbridge;

import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class PromiseImpl implements Promise {
    private static final String DEFAULT_ERROR = "EUNSPECIFIED";
    private Callback mReject;
    private Callback mResolve;

    public PromiseImpl(Callback r3, Callback r4) {
        Callback r5 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.aiagent.plugin");
        Callback r6 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.aiagent.plugin");
        this.mResolve = r5;
        this.mReject = r6;
    }

    @Override // com.bytedance.vmsdk.jsbridge.Promise
    public void resolve(Object r3) {
        Callback r2 = this.mResolve;
        if (r2 == null) goto L6;
        r2.invoke(new Object[]{r3});
        return;
    }

    @Override // com.bytedance.vmsdk.jsbridge.Promise
    @Deprecated
    public void reject(String r2) {
        reject(DEFAULT_ERROR, r2);
    }

    @Override // com.bytedance.vmsdk.jsbridge.Promise
    public void reject(String r3, String r4) {
        if (this.mReject == null) goto L8;
        if (r3 != null) goto L6;
        r3 = DEFAULT_ERROR;
    L6:
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.putString(MonitorConstants.CODE, r3);
        r0.putString("message", r4);
        this.mReject.invoke(new Object[]{r0});
        return;
    }
}
