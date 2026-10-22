package com.obric.autogui.platforms.miui;

import com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MiuiPlatformTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.obric.autogui.platforms.a.b {
    public b() {
    }

    @Override // com.obric.autogui.platforms.a.b
    public IAutoActionSecurityApi e() {
        return (IAutoActionSecurityApi) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.miui.a.a(), IAutoActionSecurityApi.class, "com.obric.aiagent.plugin");
    }
}
