package com.obric.aiagent.executionengine.capabilitymanager.matcher;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import java.util.List;

/* JADX INFO: compiled from: ICapabilitySource.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface b {

    /* JADX INFO: compiled from: ICapabilitySource.kt */
    public static final class a {
        public static void a(b r2) {
            b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        }
    }

    Object a(d<? super List<com.obric.aiagent.executionengine.capabilitymanager.api.a.b>> r1);

    void a();

    void b();

    com.obric.aiagent.executionengine.capabilitymanager.api.a.a getType();
}
