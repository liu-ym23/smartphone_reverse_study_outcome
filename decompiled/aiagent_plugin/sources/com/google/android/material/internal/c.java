package com.google.android.material.internal;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ContextUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static Activity getActivity(Context r2) {
        Object r3 = ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
    L3:
        Context r4 = (Context) r3;
        if (ZeusTransformUtils.instanceOf(r4, ContextWrapper.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r4, Activity.class) == true) goto L8;
        r3 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r4, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        goto L3
    L8:
        return (Activity) ZeusTransformUtils.preCheckCast(r4, Activity.class, "com.obric.aiagent.plugin");
    L10:
        return null;
    }
}
