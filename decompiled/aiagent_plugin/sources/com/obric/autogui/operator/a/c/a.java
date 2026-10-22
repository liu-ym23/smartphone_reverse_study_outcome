package com.obric.autogui.operator.a.c;

import com.obric.autogui.operator.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;

/* JADX INFO: compiled from: PreCheck.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PreCheck.kt */
    public static final class C0768a {
        public static void a(a r2, e r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "step");
        }

        public static void b(a r2, e r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "step");
        }

        public static Object a(a r2, d<? super Boolean> r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return d.c.b.a.b.a(true);
        }
    }

    Object a(d<? super Boolean> r1);

    Object a(String r1, e r2, com.obric.autogui.operator.b.a r3, d<? super com.obric.autogui.common.e> r4);

    String a();

    void a(e r1);

    void b(e r1);
}
