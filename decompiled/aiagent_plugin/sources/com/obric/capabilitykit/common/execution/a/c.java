package com.obric.capabilitykit.common.execution.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.ae;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface c extends d {

    public static final class a {
        public static boolean a(c r2) {
            return d.a.a((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin"));
        }

        public static boolean update(c r6, c r7) {
            c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.aiagent.plugin");
            c r9 = (c) ZeusTransformUtils.wrapperContextForParams(r7, c.class, "com.obric.aiagent.plugin");
            int r0 = 0;
            if (r9 != null) goto L5;
            return false;
        L5:
            List<com.obric.capabilitykit.common.execution.a.a> r10 = r8.a();
            List<com.obric.capabilitykit.common.execution.a.a> r11 = r9.a();
            int r2 = Math.min(r10.size(), r11.size());
        L6:
            if (r0 >= r2) goto L9;
            ((com.obric.capabilitykit.common.execution.a.a) ZeusTransformUtils.preCheckCast(r10.get(r0), com.obric.capabilitykit.common.execution.a.a.class, "com.obric.aiagent.plugin")).a((com.obric.capabilitykit.common.execution.a.a) ZeusTransformUtils.preCheckCast(r11.get(r0), com.obric.capabilitykit.common.execution.a.a.class, "com.obric.aiagent.plugin"));
            r0 = r0 + 1;
            goto L6
        L9:
            if (r2 < r11.size()) goto L11;
            return true;
        L11:
            if (ae.e(r10) == false) goto L17;
            r10.addAll(r11.subList(r2, r11.size()));
            return true;
        L17:
            return true;
        }
    }

    List<com.obric.capabilitykit.common.execution.a.a> a();

    boolean update(c r1);
}
