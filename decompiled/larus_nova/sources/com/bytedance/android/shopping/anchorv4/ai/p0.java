package com.bytedance.android.shopping.anchorv4.ai;

import android.view.View;
import com.bytedance.android.ec.base.api.ai.AIChatComponentHandle;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.android.ec.base.api.ai.MiniAppConfig;
import com.bytedance.android.shopping.anchorv4.params.PdpAIConversationContext;

/* JADX INFO: loaded from: classes12.dex */
public interface p0 {
    void a(View r100);

    void associateSnapshot(String r100, String r101);

    AIChatComponentHandle b(String r100);

    boolean c();

    void d(View r100, String r101);

    PdpAIConversationContext e(String r100);

    MiniAppConfig getMiniAppConfig();

    boolean isEnabled();

    void reportLog(AIStateLogRequest r100);
}
