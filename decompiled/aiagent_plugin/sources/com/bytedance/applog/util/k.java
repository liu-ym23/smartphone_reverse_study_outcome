package com.bytedance.applog.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ReflectUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    public static Class<?> a(String r1) {
        return ZeusTransformUtils.forName(r1, "com.obric.aiagent.plugin");
    L4:
        return null;
    }

    public static boolean b(String r0) {
        if (a(r0) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
