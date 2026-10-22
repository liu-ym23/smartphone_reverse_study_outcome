package com.bytedance.crash.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ReflexHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class t {
    public static int a(String r1, String r2) {
        return ZeusTransformUtils.forName(r1, "com.obric.aiagent.plugin").getField(r2).getInt(null);
    }

    public static Object b(String r1, String r2) {
        return ZeusTransformUtils.forName(r1, "com.obric.aiagent.plugin").getField(r2).get(null);
    }

    public static Method a(String r1, String r2, Class<?>... r3) {
        return ZeusTransformUtils.forName(r1, "com.obric.aiagent.plugin").getMethod(r2, r3);
    }
}
