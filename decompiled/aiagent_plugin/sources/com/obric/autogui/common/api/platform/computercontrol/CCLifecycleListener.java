package com.obric.autogui.common.api.platform.computercontrol;

import android.content.IntentSender;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ComputerControlModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface CCLifecycleListener {

    /* JADX INFO: compiled from: ComputerControlModels.kt */
    public static final class DefaultImpls {
        public static void onApplicationAccessChanged(CCLifecycleListener r2, CCSessionAccessor r3, String r4, CCApplicationAccessResult r5) {
            CCLifecycleListener r6 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r2, CCLifecycleListener.class, "com.obric.aiagent.plugin");
            o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
            o.e(r4, "packageName");
            o.e(r5, "result");
        }

        public static void onApplicationAccessPending(CCLifecycleListener r2, CCSessionAccessor r3, IntentSender r4) {
            CCLifecycleListener r5 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r2, CCLifecycleListener.class, "com.obric.aiagent.plugin");
            o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
            o.e(r4, "intentSender");
        }
    }

    void onApplicationAccessChanged(CCSessionAccessor r1, String r2, CCApplicationAccessResult r3);

    void onApplicationAccessPending(CCSessionAccessor r1, IntentSender r2);

    void onStateChanged(CCSessionAccessor r1, CCSessionState r2);
}
