package com.bytedance.reparo.a;

import android.content.Context;
import android.net.Uri;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Constant.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static Uri a(Context r2) {
        return Uri.parse("content://" + ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getPackageName() + ".reparo");
    }
}
