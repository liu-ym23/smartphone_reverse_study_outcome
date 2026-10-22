package com.obric.appstore.buss.detail.developer;

import com.bytedanceos.common.model.IAppInfoKt;
import com.obric.appstore.base.j;
import com.obric.appstore.base.n;
import com.obric.appstore.base.o;
import com.obric.appstore.buss.repo.StoreRepo;
import com.obric.appstore.network.g;
import com.obric.appstore.network.h;
import java.util.List;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class DevelopAppVM extends o {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f10659k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f10660l;

    public DevelopAppVM() {
        this.f10659k = "";
        this.f10660l = "";
    }

    public Object F(n r10, Continuation r11) {
        if ((r11 instanceof DevelopAppVM$doLoad$1) == false) goto L7;
        DevelopAppVM$doLoad$1 r12 = (DevelopAppVM$doLoad$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        c.b(r14);
    L18:
        return h.a((g) r14, DevelopAppVM$doLoad$2.INSTANCE);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        c.b(r14);
        StoreRepo r17 = StoreRepo.f10831a;
        String r18 = this.f10659k;
        String r19 = this.f10660l;
        int r20 = r10.d();
        r12.label = 1;
        r14 = r17.h(r18, r19, r20, r12);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r12 = new DevelopAppVM$doLoad$1(this, r11);
        goto L8
    }

    public final String G() {
        return this.f10659k;
    }

    public final String H() {
        return this.f10660l;
    }

    public final void I(String r10) {
        q.g(r10, "<set-?>");
        this.f10659k = r10;
    }

    public final void J(String r10) {
        q.g(r10, "<set-?>");
        this.f10660l = r10;
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public /* bridge */ /* synthetic */ Object j(j r10, Continuation r11) {
        return F((n) r10, r11);
    }

    @Override // com.obric.appstore.base.IPageLoadViewModel
    public List x(List r10, List r11) {
        q.g(r10, "currList");
        q.g(r11, "moreList");
        return IAppInfoKt.filter(r11, r10);
    }
}
