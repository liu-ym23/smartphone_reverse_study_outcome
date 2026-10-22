package com.obric.autogui.agents.vlm.models.omni.c;

import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppPrewarmConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f28262a = null;

    static {
        f28262a = new g();
    }

    private g() {
    }

    public final boolean a() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("omni.first_app_prewarm.enable", false);
    }

    public final String b() {
        String r3 = AutoActionConfigs.INSTANCE.getStringCfg("omni.first_app_prewarm.prediction_prompt");
        if (r3 == null) goto L13;
        String r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r4 != null) goto L7;
        return null;
    L7:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        return null;
    L12:
        return r4;
    L9:
        r1 = false;
        goto L10
    L13:
        return null;
    }
}
