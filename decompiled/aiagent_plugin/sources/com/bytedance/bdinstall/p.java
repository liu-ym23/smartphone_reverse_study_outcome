package com.bytedance.bdinstall;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: DefaultClient.java */
/* JADX INFO: loaded from: classes.dex */
public class p implements ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f6435a;

    public p() {
        this.f6435a = new q();
    }

    @Override // com.bytedance.bdinstall.ai
    public String a(String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        com.bytedance.bdinstall.e.a r2 = this.f6435a.a(r3, r5);
        if (r2 != null) goto L5;
        return "";
    L5:
        return r2.b();
    }

    @Override // com.bytedance.bdinstall.ai
    public String a(String r3, byte[] r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        com.bytedance.bdinstall.e.a r2 = this.f6435a.a(r3, r4, r6);
        if (r2 != null) goto L5;
        return "";
    L5:
        return r2.b();
    }

    @Override // com.bytedance.bdinstall.ai
    public String a(String r1, byte[] r2, String r3) {
        com.bytedance.bdinstall.e.a r0 = this.f6435a.a(r1, r2, r3);
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.b();
    }

    @Override // com.bytedance.bdinstall.ai
    public byte[] b(String r3, byte[] r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        return this.f6435a.b(r3, r4, r6);
    }
}
