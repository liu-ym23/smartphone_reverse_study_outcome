package com.obric.appstore.buss.recommend;

import com.obric.appstore.base.j;
import com.obric.appstore.base.k;
import com.obric.appstore.buss.repo.StoreRepo;
import com.obric.appstore.network.entity.template.PageType;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class GameRecommendVM extends k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PageType f10804i;

    public GameRecommendVM() {
        this.f10804i = PageType.APPS_PAGE;
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public Object j(j r10, Continuation r11) {
        if ((r11 instanceof GameRecommendVM$doLoad$1) == false) goto L7;
        GameRecommendVM$doLoad$1 r12 = (GameRecommendVM$doLoad$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        kotlin.c.b(r14);
    L18:
        return com.obric.appstore.network.h.a((com.obric.appstore.network.g) r14, GameRecommendVM$doLoad$2.INSTANCE);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r14);
        StoreRepo r17 = StoreRepo.f10831a;
        PageType r18 = this.f10804i;
        r12.label = 1;
        r14 = r17.k(r18, r12);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r12 = new GameRecommendVM$doLoad$1(this, r11);
        goto L8
    }

    public final PageType v() {
        return this.f10804i;
    }

    public final void w(PageType r10) {
        q.g(r10, "<set-?>");
        this.f10804i = r10;
    }
}
