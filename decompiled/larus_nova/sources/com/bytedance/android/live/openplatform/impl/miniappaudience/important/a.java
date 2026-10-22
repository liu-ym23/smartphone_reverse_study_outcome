package com.bytedance.android.live.openplatform.impl.miniappaudience.important;

import com.bytedance.android.live.room.api.messagewindow.builder.card.c;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.live.room.api.messagewindow.state.source.CardDataState;
import io.reactivex.functions.Consumer;
import jc1.k;
import r71.f;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceImportantCardContextService f84892a;

    public a(AudienceImportantCardContextService r100) {
        this.f84892a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        final f r101 = (f) r100;
        if (r101.f536401a == 33) goto L6;
        return;
    L6:
        if (this.f84892a.f84891b != null) goto L9;
        qo0.a.c("AudienceImportantCardContextService", "important card is not initialized, create card");
        AudienceImportantCardContextService r102 = this.f84892a;
        r102.getClass();
        r102.f84891b = ((IMsgWindowService) k.n(IMsgWindowService.class)).commonCardBuilder().a(new AudienceImportantCardContextService$createExplainCard$1(r101)).b();
    L9:
        if (r101.f536402b != CardDataState.SHOW) goto L13;
        qo0.a.c("AudienceImportantCardContextService", "show important card");
        c r103 = this.f84892a.f84891b;
        if (r103 == null) goto L15;
        r103.c(null);
        return;
    L15:
        return;
    L13:
        int r104 = qo0.a.f534145a;
        qo0.a.c("AudienceImportantCardContextService", "important card state is changed, state: " + r101.f536402b);
    }
}
