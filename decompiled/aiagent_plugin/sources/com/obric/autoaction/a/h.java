package com.obric.autoaction.a;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface h extends f {

    /* JADX INFO: compiled from: IComponent.kt */
    public static final class a {
        public static void a(h r2, View r3, c r4) {
            h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
            o.e(r3, "boundView");
            o.e(r4, "componentHost");
        }

        public static void a(h r2, c r3) {
            h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
            o.e(r3, "componentHost");
            f.a.a((f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.aiagent.plugin"), r3);
        }
    }

    void a(View r1, c r2);
}
