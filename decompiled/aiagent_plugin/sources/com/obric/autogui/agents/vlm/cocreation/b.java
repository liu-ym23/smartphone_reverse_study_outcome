package com.obric.autogui.agents.vlm.cocreation;

import com.obric.autogui.common.api.cocreation.OmniLabelingTaskTriggerTypes;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o.o;

/* JADX INFO: compiled from: OmniLabelingTaskTriggerPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final String a(String r4, String r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L10:
        if (r7 == true) goto L12;
        return OmniLabelingTaskTriggerTypes.MY_TASK;
    L12:
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        if (o.c((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(OmniLabelingTaskTriggerTypes.AUTOMATIC, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L20;
        return OmniLabelingTaskTriggerTypes.PROACTIVE;
    L20:
        return OmniLabelingTaskTriggerTypes.AUTOMATIC;
    L5:
        if (r6.length() == 0) goto L8;
        r7 = false;
        goto L10
    }
}
