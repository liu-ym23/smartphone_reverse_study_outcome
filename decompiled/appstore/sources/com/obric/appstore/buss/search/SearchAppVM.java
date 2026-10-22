package com.obric.appstore.buss.search;

import androidx.lifecycle.b0;
import com.bytedanceos.common.model.IAppInfoKt;
import com.bytedanceos.common.utils.PerformanceMonitor;
import com.obric.appstore.base.n;
import com.obric.appstore.base.o;
import com.obric.appstore.buss.repo.StoreRepo;
import com.obric.appstore.network.entity.PageListResp;
import java.util.List;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class SearchAppVM extends o {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b0 f10844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile String f10845l;

    public SearchAppVM(@NotNull b0 r10) {
        q.g(r10, "savedStateHandle");
        this.f10844k = r10;
        this.f10845l = "";
    }

    public Object F(n r10, Continuation r11) {
        if ((r11 instanceof SearchAppVM$doLoad$1) == false) goto L7;
        SearchAppVM$doLoad$1 r12 = (SearchAppVM$doLoad$1) r11;
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
        int r17 = r12.I$0;
        kotlin.c.b(r14);
    L29:
        com.obric.appstore.network.g r18 = (com.obric.appstore.network.g) r14;
        if (r17 == 0) goto L32;
        PerformanceMonitor.end(PerformanceMonitor.Event.SEARCH);
    L32:
        return r14;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r19 = r12.I$0;
        r10 = (n) r12.L$1;
        SearchAppVM r20 = (SearchAppVM) r12.L$0;
        kotlin.c.b(r14);
        int r21 = r19;
        SearchAppVM this = r20;
    L25:
        String r22 = this.f10845l;
        int r23 = r10.d();
        r12.L$0 = null;
        r12.L$1 = null;
        r12.I$0 = r21;
        r12.label = 2;
        Object r24 = this.I(r22, r23, r12);
        if (r24 != r15) goto L28;
        return r15;
    L28:
        int r25 = r21;
        r14 = r24;
        r17 = r25;
        goto L29
    L16:
        kotlin.c.b(r14);
        if (this.f10845l.length() <= 0) goto L19;
        r21 = 1;
    L20:
        if (r21 == 0) goto L22;
        PerformanceMonitor.start(PerformanceMonitor.Event.SEARCH);
    L22:
        r12.L$0 = this;
        r12.L$1 = r10;
        r12.I$0 = r21;
        r12.label = 1;
        if (DelayKt.b(200, r12) != r15) goto L25;
        return r15;
    L19:
        r21 = 0;
    L7:
        r12 = new SearchAppVM$doLoad$1(this, r11);
        goto L8
    }

    public final String G() {
        return this.f10845l;
    }

    public final b0 H() {
        return this.f10844k;
    }

    public final Object I(String r10, int r11, Continuation r12) {
        if (r10.length() != 0) goto L7;
        return new com.obric.appstore.network.g.d(new PageListResp(t.i(), false, 2, null));
    L7:
        return StoreRepo.f10831a.m(r10, r11, r12);
    }

    public final void J(String r10) {
        q.g(r10, "<set-?>");
        this.f10845l = r10;
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public /* bridge */ /* synthetic */ Object j(com.obric.appstore.base.j r10, Continuation r11) {
        return F((n) r10, r11);
    }

    @Override // com.obric.appstore.base.IPageLoadViewModel
    public List x(List r10, List r11) {
        q.g(r10, "currList");
        q.g(r11, "moreList");
        return IAppInfoKt.filter(r11, r10);
    }
}
