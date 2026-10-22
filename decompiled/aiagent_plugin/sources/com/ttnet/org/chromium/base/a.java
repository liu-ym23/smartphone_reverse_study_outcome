package com.ttnet.org.chromium.base;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ApiCompatibilityUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static int a(Context r2, String r3, int r4, int r5) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).checkPermission(r3, r4, r5);
    L5:
        return -1;
    }
}
