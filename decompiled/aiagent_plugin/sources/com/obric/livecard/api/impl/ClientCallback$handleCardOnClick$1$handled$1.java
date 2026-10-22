package com.obric.livecard.api.impl;

import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import d.h.a.a;
import d.h.b.p;
import d.x;

/* JADX INFO: compiled from: ClientCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
final class ClientCallback$handleCardOnClick$1$handled$1 extends p implements a<Boolean> {
    final /* synthetic */ IslandSession $session;

    ClientCallback$handleCardOnClick$1$handled$1(IslandSession r1) {
        this.$session = r1;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.h.a.a
    public final Boolean invoke() {
        IslandWidget r0 = this.$session.getCollapseWidget();
        if (r0 == null) goto L7;
        a<x> r1 = r0.getOnCardClickCallback();
        if (r1 == null) goto L7;
        r1.invoke();
        boolean r2 = true;
    L9:
        return Boolean.valueOf(r2);
    L7:
        r2 = false;
        goto L9
    }

    @Override // d.h.a.a
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
