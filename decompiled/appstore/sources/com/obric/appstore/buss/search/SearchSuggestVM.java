package com.obric.appstore.buss.search;

import com.obric.appstore.base.k;
import com.obric.appstore.buss.repo.StoreRepo;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
public final class SearchSuggestVM extends k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile String f10868i;

    public SearchSuggestVM() {
        this.f10868i = "";
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public Object j(com.obric.appstore.base.j r10, Continuation r11) {
        if ((r11 instanceof SearchSuggestVM$doLoad$1) == false) goto L7;
        SearchSuggestVM$doLoad$1 r12 = (SearchSuggestVM$doLoad$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        kotlin.c.b(r14);
    L26:
        return r14;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SearchSuggestVM this = (SearchSuggestVM) r12.L$0;
        kotlin.c.b(r14);
    L23:
        StoreRepo r17 = StoreRepo.f10831a;
        String r18 = this.f10868i;
        r12.L$0 = null;
        r12.label = 2;
        r14 = r17.o(r18, r12);
        if (r14 != r15) goto L26;
        return r15;
    L16:
        kotlin.c.b(r14);
        if (this.f10868i.length() == 0) goto L19;
        r12.L$0 = this;
        r12.label = 1;
        if (DelayKt.b(200, r12) != r15) goto L23;
        return r15;
    L19:
        return new com.obric.appstore.network.g.d(t.i());
    L7:
        r12 = new SearchSuggestVM$doLoad$1(this, r11);
        goto L8
    }

    public final String v() {
        return this.f10868i;
    }

    public final void w(String r10) {
        q.g(r10, "<set-?>");
        this.f10868i = r10;
    }
}
