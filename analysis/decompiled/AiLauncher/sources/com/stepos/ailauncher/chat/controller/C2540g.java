package com.stepos.ailauncher.chat.controller;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.controller.InterfaceC2538f;
import com.stepos.ailauncher.chat.view.SidebarAgentItem;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/chat/view/s8;", "Lcom/stepos/ailauncher/chat/controller/f;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/view/s8;)Lcom/stepos/ailauncher/chat/controller/f;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.controller.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2540g {
    public static final InterfaceC2538f a(SidebarAgentItem sidebarAgentItem) {
        kotlin.jvm.internal.p.i(sidebarAgentItem, "<this>");
        if (sidebarAgentItem.getIsPrimary()) {
            return InterfaceC2538f.a.INSTANCE;
        }
        if (!sidebarAgentItem.getInstalled()) {
            return new InterfaceC2538f.Proxy(sidebarAgentItem.getAgentId(), sidebarAgentItem.getDeviceId(), sidebarAgentItem.getDisplayName());
        }
        String assetId = sidebarAgentItem.getAssetId();
        if (La.H.x0(assetId)) {
            assetId = null;
        }
        if (assetId != null) {
            return new InterfaceC2538f.Installed(assetId, sidebarAgentItem.getDisplayName());
        }
        return null;
    }
}
