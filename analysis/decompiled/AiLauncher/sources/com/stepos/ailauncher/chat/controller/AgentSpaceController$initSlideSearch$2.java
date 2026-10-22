package com.stepos.ailauncher.chat.controller;

import com.stepos.ailauncher.contract.model.search.SessionSearchHit;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class AgentSpaceController$initSlideSearch$2 extends FunctionReferenceImpl implements InterfaceC5074l<SessionSearchHit, Y8.t> {
    public AgentSpaceController$initSlideSearch$2(Object obj) {
        super(1, obj, AgentSpaceController.class, "openSearchSession", "openSearchSession(Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;)V", 0);
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Y8.t invoke(SessionSearchHit sessionSearchHit) {
        l(sessionSearchHit);
        return Y8.t.f7040a;
    }

    public final void l(SessionSearchHit p02) {
        kotlin.jvm.internal.p.i(p02, "p0");
        ((AgentSpaceController) this.receiver).k3(p02);
    }
}
