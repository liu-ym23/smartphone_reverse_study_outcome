package com.ss.bduploader.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: BDVNetClient.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class g {

    /* JADX INFO: compiled from: BDVNetClient.java */
    public interface a {
        void a(JSONObject r1, i r2);
    }

    public void a() {
    }

    public void a(String r1, Map<String, String> r2, a r3) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public void a(String r1, Map<String, String> r2, JSONObject r3, int r4, a r5) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
    }

    public g() {
    }
}
