package com.bytedance.bdturing.ttnet;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TTNetHttpClient implements b {
    private Context context;

    public TTNetHttpClient(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.context = ZeusTransformUtils.wrapperContext(null, "com.obric.aiagent.plugin");
        this.context = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.bdturing.ttnet.b
    public byte[] get(String r3, Map<String, String> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.a(this.context, r3, r5);
        return c.a(r3, null, null, r5);
    }

    @Override // com.bytedance.bdturing.ttnet.b
    public byte[] post(String r3, Map<String, String> r4, byte[] r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.a(this.context, r3, r6);
        return c.a(r3, null, null, r5, r6);
    }
}
