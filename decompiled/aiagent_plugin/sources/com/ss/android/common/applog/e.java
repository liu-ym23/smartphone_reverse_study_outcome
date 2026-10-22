package com.ss.android.common.applog;

import android.text.TextUtils;
import com.bytedance.bdinstall.ai;
import com.bytedance.bdinstall.aw;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BDTrackerNetworkClientWrapper.java */
/* JADX INFO: loaded from: classes4.dex */
public class e implements ai {
    public e() {
    }

    @Override // com.bytedance.bdinstall.ai
    public String a(String r3, Map<String, String> r4) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        return com.bytedance.common.utility.g.a().a(r3, r2, null);
    L5:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, com.bytedance.common.utility.b.class) == false) goto L11;
        com.bytedance.common.utility.b r5 = (com.bytedance.common.utility.b) ZeusTransformUtils.preCheckCast(e, com.bytedance.common.utility.b.class, "com.obric.aiagent.plugin");
        throw new aw(r5.a(), r5.getCause());
    L11:
        throw new aw(400, e.getCause());
    }

    @Override // com.bytedance.bdinstall.ai
    public String a(String r2, byte[] r3, Map<String, String> r4) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        return com.bytedance.common.utility.g.a().a(r2, r3, r1, null);
    L5:
        e = move-exception;
        throw new aw(e.a(), e.getCause());
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
    public byte[] b(String r2, byte[] r3, Map<String, String> r4) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        return com.bytedance.common.utility.g.a().b(r2, r3, r1, null);
    L5:
        e = move-exception;
        throw new aw(e.a(), e.getCause());
    }
}
