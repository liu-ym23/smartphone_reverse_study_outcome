package com.stepos.ailauncher.chat.controller;

import com.stepos.agentframework.chatcore.SessionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class SessionCenterListController$bind$sessionMenus$1 extends FunctionReferenceImpl implements InterfaceC5063a<SessionHandler> {
    public SessionCenterListController$bind$sessionMenus$1(Object obj) {
        super(0, obj, SessionCenterListController.class, "sessionHandler", "sessionHandler()Lcom/stepos/agentframework/chatcore/SessionHandler;", 0);
    }

    @Override // p9.InterfaceC5063a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final SessionHandler invoke() {
        return ((SessionCenterListController) this.receiver).z0();
    }
}
