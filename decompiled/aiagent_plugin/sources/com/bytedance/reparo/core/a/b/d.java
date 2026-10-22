package com.bytedance.reparo.core.a.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.reparo.core.i.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProcessUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static String a(Context r2) {
        return i.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    public static boolean b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return TextUtils.equals(r3.getPackageName(), a(r3));
    }
}
