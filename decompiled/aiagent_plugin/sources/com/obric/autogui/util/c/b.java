package com.obric.autogui.util.c;

import com.obric.autogui.common.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: IState.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: compiled from: IState.kt */
    public static final class a {
        public static void a(b r2) {
            b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        }

        public static Object a(b r2, b r3, d<? super x> r4) {
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return x.f38692a;
        }
    }

    Object a(b r1, d<? super x> r2);

    void a(b r1);

    Object b(b r1, d<? super e> r2);

    void b(b r1);

    void c();
}
