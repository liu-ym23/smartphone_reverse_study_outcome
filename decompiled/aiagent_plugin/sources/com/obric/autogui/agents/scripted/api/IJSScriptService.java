package com.obric.autogui.agents.scripted.api;

import android.content.Context;
import com.bytedance.vmsdk.worker.JsWorker;
import com.obric.autogui.resourcemanage.n;
import d.c.d;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: IJSScriptService.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IJSScriptService extends b {
    n clearLocalResource(Context r1, String r2);

    String getMainJSCodeByAbility(Context r1, String r2);

    String getScriptEngine(Context r1);

    JsWorker getScriptJSWorker(Context r1);

    Object getSupportedAbilityList(Context r1, Set<String> r2, String r3, d<? super List<a>> r4);

    boolean isScriptEnable();

    void requestResourceRecoveryOnScriptStartFailed(Context r1);
}
