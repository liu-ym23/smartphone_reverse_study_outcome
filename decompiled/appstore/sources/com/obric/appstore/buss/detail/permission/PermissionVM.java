package com.obric.appstore.buss.detail.permission;

import com.obric.appstore.base.j;
import com.obric.appstore.base.k;
import com.obric.appstore.buss.repo.StoreRepo;
import com.obric.appstore.network.g;
import com.obric.appstore.network.h;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class PermissionVM extends k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f10694i;

    public PermissionVM() {
        this.f10694i = "";
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public Object j(j r10, Continuation r11) {
        if ((r11 instanceof PermissionVM$doLoad$1) == false) goto L7;
        PermissionVM$doLoad$1 r12 = (PermissionVM$doLoad$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        final PermissionVM this = (PermissionVM) r12.L$0;
        c.b(r14);
    L18:
        return h.a((g) r14, new PermissionVM$doLoad$2(this));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        c.b(r14);
        StoreRepo r17 = StoreRepo.f10831a;
        String r18 = this.f10694i;
        r12.L$0 = this;
        r12.label = 1;
        r14 = r17.f(r18, r12);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r12 = new PermissionVM$doLoad$1(this, r11);
        goto L8
    }

    public final String v() {
        return this.f10694i;
    }

    public final void w(String r10) {
        q.g(r10, "<set-?>");
        this.f10694i = r10;
    }
}
