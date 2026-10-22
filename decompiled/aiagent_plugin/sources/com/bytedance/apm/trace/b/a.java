package com.bytedance.apm.trace.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: ApmPageLoadMappingTool.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, Integer> f4899a;

    static {
        f4899a = new HashMap();
        a();
    }

    public static void a(String r1, int r2) {
        f4899a.put(r1, Integer.valueOf(r2));
    }

    private static void a() {
        a("xx", 12334);
    }

    public static Integer a(String r2) {
        return (Integer) ZeusTransformUtils.preCheckCast(f4899a.get(r2), Integer.class, "com.obric.aiagent.plugin");
    }
}
