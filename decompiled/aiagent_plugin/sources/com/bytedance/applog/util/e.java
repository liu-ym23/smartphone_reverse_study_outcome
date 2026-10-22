package com.bytedance.applog.util;

import android.text.TextUtils;
import com.bytedance.bdinstall.ai;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: DefaultClient.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.k.a f6032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.applog.c f6033b;

    public e(com.bytedance.applog.c r1) {
        this.f6033b = r1;
        this.f6032a = r1.V();
    }

    @Override // com.bytedance.bdinstall.ai
    public String a(String r3, Map<String, String> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        return this.f6032a.a(0, r3, (HashMap) ZeusTransformUtils.preCheckCast(r5, HashMap.class, "com.obric.aiagent.plugin"), null);
    }

    @Override // com.bytedance.bdinstall.ai
    public String a(String r3, byte[] r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        return this.f6032a.a(1, r3, (HashMap) ZeusTransformUtils.preCheckCast(r6, HashMap.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.bytedance.bdinstall.ai
    public String a(String r3, byte[] r4, String r5) {
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r5) == true) goto L6;
        r0.put(DownloadHelper.CONTENT_TYPE, r5);
    L6:
        return a(r3, r4, r0);
    }

    @Override // com.bytedance.bdinstall.ai
    public byte[] b(String r3, byte[] r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        return this.f6032a.b(1, r3, (HashMap) ZeusTransformUtils.preCheckCast(r6, HashMap.class, "com.obric.aiagent.plugin"), r4);
    }
}
