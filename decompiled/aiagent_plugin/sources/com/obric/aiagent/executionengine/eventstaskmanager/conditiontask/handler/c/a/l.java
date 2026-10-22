package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LocationMonitorMetricCalculator.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface l {

    /* JADX INFO: compiled from: LocationMonitorMetricCalculator.kt */
    public static final class a {
        public static float b(l r2) {
            l r3 = (l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.aiagent.plugin");
            return 0.0f;
        }

        public static float c(l r2) {
            l r3 = (l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.aiagent.plugin");
            return 0.0f;
        }

        public static String a(l r2) {
            return "normalized_" + ((l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.aiagent.plugin")).a();
        }
    }

    Float a(ae r1);

    Float a(Float r1, ae r2);

    String a();

    float b();

    String c();

    float d();
}
