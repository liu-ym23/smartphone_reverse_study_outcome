package com.bytedance.vmsdk.jsbridge;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class JSModule {
    protected Context mContext;
    protected Object mParam;

    public JSModule(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public JSModule(Context r3, Object r4) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.mParam = r4;
    }
}
