package com.aiassistant.security.guard;

import android.content.Context;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AssistantSecurityGuardManager {
    public AssistantSecurityGuardManager() {
    }

    public void registerSettingsEventObserver(IAssistantSettingsEventObserver r2) {
        IAssistantSettingsEventObserver r1 = (IAssistantSettingsEventObserver) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantSettingsEventObserver.class, "com.obric.aiagent.plugin");
        throw new RuntimeException("Stub!!");
    }

    public void unregisterSettingsEventObserver(IAssistantSettingsEventObserver r2) {
        IAssistantSettingsEventObserver r1 = (IAssistantSettingsEventObserver) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantSettingsEventObserver.class, "com.obric.aiagent.plugin");
        throw new RuntimeException("Stub!!");
    }

    public void bdSettingsEventStart(Context r1, int r2, Bundle r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        throw new RuntimeException("Stub!!");
    }

    public void bdSettingsEventEnd(Context r1, int r2, Bundle r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        throw new RuntimeException("Stub!!");
    }
}
