package com.bytedance.applet.impl;

import com.bytedance.applet.context.ContextManager;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.chat.api.IAppletPayloadProviderService;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin$initAppletPayloadChangeListener$1;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applet/impl/AppletPayloadProviderServiceImpl;", "Lcom/larus/bmhome/chat/api/IAppletPayloadProviderService;", "<init>", "()V", "getAppletPayload", "", "", "conversationId", "botId", RemoteMessageConst.MSGID, "addOnAppletPayloadChangedListener", "", "listener", "Lcom/larus/bmhome/chat/api/OnAppletPayloadChangedListener;", "removeOnAppletPayloadChangedListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPayloadProviderServiceImpl implements IAppletPayloadProviderService {
    public AppletPayloadProviderServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.api.IAppletPayloadProviderService
    public final void a(com.larus.bmhome.chat.api.t0 r100) {
        ContextManager.f191491a.a(r100);
    }

    @Override // com.larus.bmhome.chat.api.IAppletPayloadProviderService
    public final void c(CommonAppletPlugin$initAppletPayloadChangeListener$1 r100) {
        ContextManager.f191491a.c(r100);
    }

    @Override // com.larus.bmhome.chat.api.IAppletPayloadProviderService
    public final Map<String, String> b(String r100, String r101, String r102) {
        ContextManager r103 = ContextManager.f191491a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        return r103.b(r100, r101, r102);
    }
}
