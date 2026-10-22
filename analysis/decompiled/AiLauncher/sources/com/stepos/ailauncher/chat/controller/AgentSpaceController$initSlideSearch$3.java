package com.stepos.ailauncher.chat.controller;

import com.stepos.ailauncher.contract.model.search.TaskSearchHit;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class AgentSpaceController$initSlideSearch$3 extends FunctionReferenceImpl implements InterfaceC5074l<TaskSearchHit, Y8.t> {
    public AgentSpaceController$initSlideSearch$3(Object obj) {
        super(1, obj, AgentSpaceController.class, "openSearchTask", "openSearchTask(Lcom/stepos/ailauncher/contract/model/search/TaskSearchHit;)V", 0);
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Y8.t invoke(TaskSearchHit taskSearchHit) {
        l(taskSearchHit);
        return Y8.t.f7040a;
    }

    public final void l(TaskSearchHit p02) {
        kotlin.jvm.internal.p.i(p02, "p0");
        ((AgentSpaceController) this.receiver).l3(p02);
    }
}
