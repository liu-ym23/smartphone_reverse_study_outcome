package com.bytedance.dataplatform;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: ExperimentPanel.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f7946a;

    /* JADX INFO: compiled from: ExperimentPanel.java */
    public interface a {
        <T> T a(String r1, Type r2);
    }

    static {
    }

    static void a(a r2) {
        f7946a = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
    }

    static <T> T a(String r2, Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
        a r0 = f7946a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.a(r2, r4);
    }
}
