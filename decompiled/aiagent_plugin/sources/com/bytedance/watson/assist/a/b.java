package com.bytedance.watson.assist.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AssistStatFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static c a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return com.bytedance.watson.assist.b.a.a(r3);
    }
}
