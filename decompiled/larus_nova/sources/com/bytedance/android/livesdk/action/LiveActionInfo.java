package com.bytedance.android.livesdk.action;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes7.dex */
public class LiveActionInfo {
    private BaseActionMethod mActionMethod;
    private String mActionName;
    private ThreadMode mActionThread;

    public BaseActionMethod getActionMethod() {
        return this.mActionMethod;
    }

    public String getActionName() {
        return this.mActionName;
    }

    public ThreadMode getActionThread() {
        return this.mActionThread;
    }

    public LiveActionInfo(BaseActionMethod r100) {
        this.mActionMethod = r100;
        ActionMethod r101 = (ActionMethod) r100.getClass().getAnnotation(ActionMethod.class);
        String r102 = r101.value();
        this.mActionName = r102;
        if (TextUtils.isEmpty(r102) == true) goto L7;
        this.mActionThread = r101.thread();
        return;
    L7:
        throw new IllegalArgumentException("action name can't be null");
    }
}
