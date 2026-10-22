package com.obric.autogui.agents.vlm.models.impl.d;

import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.n.j;
import d.n.m;

/* JADX INFO: compiled from: IStandardModelStepParser.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: compiled from: IStandardModelStepParser.kt */
    public interface a {

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.d.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IStandardModelStepParser.kt */
        public static final class C0691a {
            public static com.obric.autogui.agents.vlm.models.impl.g a(a r2) {
                return (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(m.d(((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin")).d()), com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
            }
        }

        boolean a();

        String b();

        int c();

        j<com.obric.autogui.agents.vlm.models.impl.g> d();

        com.obric.autogui.agents.vlm.models.impl.g e();
    }

    a a(com.obric.autogui.agents.vlm.models.impl.d.C0690d r1, JsonObject r2);
}
