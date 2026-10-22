package com.bytedance.common.utility;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: NetworkClient.java */
/* JADX INFO: loaded from: classes.dex */
class e extends g {
    e() {
    }

    @Override // com.bytedance.common.utility.g
    public String a(String r1, Map<String, String> r2, g.a r3) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        throw new IOException("not implemented");
    }

    @Override // com.bytedance.common.utility.g
    public String a(String r1, byte[] r2, Map<String, String> r3, g.a r4) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        throw new b(0, "not implemented");
    }
}
