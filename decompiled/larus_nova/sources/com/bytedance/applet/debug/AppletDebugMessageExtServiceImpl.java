package com.bytedance.applet.debug;

import com.bytedance.ai.debug.IAISDKDebugService;
import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/debug/AppletDebugMessageExtServiceImpl;", "Lcom/larus/bmhome/chat/api/IMessageExtService;", "<init>", "()V", "setSendMessageExt", "", "map", "", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "metadata", "Lcom/larus/bmhome/chat/api/IMessageExtService$QueryData;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletDebugMessageExtServiceImpl implements IMessageExtService {

    public static final class a {
    }

    static {
    }

    public AppletDebugMessageExtServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.api.IMessageExtService
    public final String service() {
        return "";
    }

    @Override // com.larus.bmhome.chat.api.IMessageExtService
    public final void b(Map r100, IMessageExtService.a r101) {
        Intrinsics.checkNotNullParameter(r100, "map");
    }

    @Override // com.larus.bmhome.chat.api.IMessageExtService
    public final void a(Map<String, String> r100, e r101, IMessageExtService.a r102) {
        Intrinsics.checkNotNullParameter(r100, "map");
        IAISDKDebugService.Companion r103 = IAISDKDebugService.f36186a;
        IAISDKDebugService.DebugMode r104 = r103.getDebugMode();
        boolean r105 = true;
        if (r104 != IAISDKDebugService.DebugMode.LEGACY_SCAN_PREVIEW) goto L13;
        boolean r106 = AppletDebugManager.f191566a;
        String r107 = r103.o();
        if (r107 != null) goto L7;
    L10:
        if (r105 == true) goto L25;
        FLogger.f375446a.i("AppletDebugMessageExtServiceImpl", "debugConfig: " + r107);
        r100.put("mini_app_debug_info", r107);
        return;
    L25:
        return;
    L7:
        if (r107.length() == 0) goto L10;
        r105 = false;
        goto L10
    L13:
        if (r104 != IAISDKDebugService.DebugMode.SCAN_PREVIEW) goto L15;
    L16:
        String r108 = r103.b();
        if (r108 != null) goto L19;
    L22:
        if (r105 == true) goto L28;
        FLogger.f375446a.i("AppletDebugMessageExtServiceImpl", "remoteDebugConfig: " + r108);
        r100.put("doubao_miniapp_debug_info", r108);
        r100.put("doubao_miniapp_debug_flag", "true");
        return;
    L28:
        return;
    L19:
        if (r108.length() == 0) goto L22;
        r105 = false;
        goto L22
    L15:
        if (r104 == IAISDKDebugService.DebugMode.LOCAL_DEBUG) goto L16;
    }
}
