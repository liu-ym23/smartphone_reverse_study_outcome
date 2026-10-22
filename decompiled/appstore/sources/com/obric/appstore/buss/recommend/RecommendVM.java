package com.obric.appstore.buss.recommend;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.l0;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.appstore.base.j;
import com.obric.appstore.base.k;
import com.obric.appstore.buss.apps.AppsManager;
import com.obric.appstore.buss.repo.StoreRepo;
import com.obric.appstore.network.entity.template.PageType;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import kotlin.Lazy;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class RecommendVM extends k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b0 f10818i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f10819j;

    public RecommendVM(@NotNull b0 r10) {
        q.g(r10, "savedStateHandle");
        this.f10818i = r10;
        this.f10819j = kotlin.b.b(RecommendVM$hotWord$2.INSTANCE);
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public Object j(j r10, Continuation r11) {
        if ((r11 instanceof RecommendVM$doLoad$1) == false) goto L7;
        RecommendVM$doLoad$1 r12 = (RecommendVM$doLoad$1) r11;
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
        com.obric.appstore.network.g r17 = (com.obric.appstore.network.g) r12.L$0;
        kotlin.c.b(r14);
        return r17;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        kotlin.c.b(r14);
    L19:
        com.obric.appstore.network.g r18 = com.obric.appstore.network.h.a((com.obric.appstore.network.g) r14, RecommendVM$doLoad$res$1.INSTANCE);
        AppsManager r19 = AppsManager.f10585a;
        r12.L$0 = r18;
        r12.label = 2;
        if (r19.r(r12) != r15) goto L23;
        return r15;
    L23:
        return r18;
    L16:
        kotlin.c.b(r14);
        StoreRepo r20 = StoreRepo.f10831a;
        PageType r21 = PageType.HOMEPAGE;
        r12.label = 1;
        r14 = r20.l(r21, r12);
        if (r14 != r15) goto L19;
        return r15;
    L7:
        r12 = new RecommendVM$doLoad$1(this, r11);
        goto L8
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public void u(com.obric.appstore.network.g r10, j r11) {
        q.g(r10, WsConstants.KEY_CONNECTION_STATE);
        q.g(r11, Card.KEY_API_LOAD_PARAMS);
        super.u(r10, r11);
        if ((r10 instanceof com.obric.appstore.network.g.b) == false) goto L6;
        x();
        return;
    }

    public final MutableLiveData v() {
        return (MutableLiveData) this.f10819j.getValue();
    }

    public final b0 w() {
        return this.f10818i;
    }

    public final void x() {
        kotlinx.coroutines.h.d(l0.a(this), null, null, new RecommendVM$updateHotWord$1(this, null), 3, null);
    }
}
