package com.obric.capabilitykit.common.execution.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends d {

    /* JADX INFO: renamed from: com.obric.capabilitykit.common.execution.a.a$a, reason: collision with other inner class name */
    public static final class C0877a {
        public static void a(a r2, a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            o.e(r5, "withAnother");
            if (o.a(r4.a(), r5.a()) == true) goto L5;
            return;
        L5:
            r4.c().putAll(r5.c());
        }

        public static boolean a(a r2) {
            return d.a.a((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin"));
        }
    }

    String a();

    void a(a r1);

    Map<String, b> c();
}
