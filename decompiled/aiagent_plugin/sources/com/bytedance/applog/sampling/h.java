package com.bytedance.applog.sampling;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SamplingTeaHashDid.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends a {
    h(int r3, Set<String> r4, Map<String, List<Set<String>>> r5, Map<String, List<Map<String, Object>>> r6) {
        super(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.applog.sampling.a
    boolean a(b r7) {
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.aiagent.plugin");
        int r0 = a();
        if (r0 >= 0) goto L6;
        return true;
    L6:
        if (r0 <= 0) goto L8;
        return false;
    L8:
        if (r8 != null) goto L10;
    L16:
        return false;
    L10:
        if (TextUtils.isEmpty(r8.a()) == true) goto L16;
        if (TextUtils.isEmpty(r8.b()) == true) goto L16;
        return !com.bytedance.applog.sampling.a.c.a(r8.a() + ":" + r8.b(), 10000, this.f5964a);
    }
}
