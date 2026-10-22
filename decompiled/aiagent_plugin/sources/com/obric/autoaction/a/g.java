package com.obric.autoaction.a;

import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface g extends h {

    /* JADX INFO: compiled from: IComponent.kt */
    public static final class a {
        public static void a(g r2, View r3, c r4) {
            g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin");
            o.e(r3, "boundView");
            o.e(r4, "componentHost");
            h.a.a((h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin"), r3, r4);
        }

        public static void a(g r2, c r3) {
            g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin");
            o.e(r3, "componentHost");
            h.a.a((h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.aiagent.plugin"), r3);
        }
    }

    View a(ViewGroup r1, c r2);
}
