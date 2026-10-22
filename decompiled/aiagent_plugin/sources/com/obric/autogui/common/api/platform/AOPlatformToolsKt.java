package com.obric.autogui.common.api.platform;

import d.f;
import d.g;

/* JADX INFO: compiled from: AOPlatformTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOPlatformToolsKt {
    private static final f<AOPlatformToolsInterface> sPlatTools = null;

    public static final /* synthetic */ f access$getSPlatTools$p() {
        return sPlatTools;
    }

    public static /* synthetic */ AOPlatformToolsInterface lambda$jG3Gao9tDt5rF921V_BpkjbDpsI() {
        return sPlatTools$lambda$0();
    }

    static {
        sPlatTools = g.a($$Lambda$AOPlatformToolsKt$jG3Gao9tDt5rF921V_BpkjbDpsI.INSTANCE);
    }

    private static final AOPlatformToolsInterface sPlatTools$lambda$0() {
        return AOPlatform.INSTANCE.getPlatform().getTools();
    }
}
