package com.obric.autoaction.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface f extends androidx.lifecycle.d {

    /* JADX INFO: compiled from: IComponent.kt */
    public static final class a {
        public static void a(f r2, c r3) {
            f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.aiagent.plugin");
            o.e(r3, "componentHost");
        }
    }

    void a(c r1);
}
