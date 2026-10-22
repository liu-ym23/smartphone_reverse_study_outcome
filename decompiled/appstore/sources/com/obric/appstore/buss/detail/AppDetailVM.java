package com.obric.appstore.buss.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.obric.appstore.buss.apps.AppCallback;
import com.obric.appstore.buss.apps.AppsManager;
import com.obric.appstore.buss.repo.StoreRepo;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class AppDetailVM extends com.obric.appstore.base.k implements AppCallback {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AppInfo f10626i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData f10627j;

    public AppDetailVM() {
        this.f10627j = new MutableLiveData();
    }

    @Override // com.obric.appstore.base.ILoadViewModel, androidx.lifecycle.k0
    public void d() {
        super.d();
        AppsManager.f10585a.l(this);
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public Object j(com.obric.appstore.base.j r10, Continuation r11) {
        if ((r11 instanceof AppDetailVM$doLoad$1) == false) goto L7;
        AppDetailVM$doLoad$1 r12 = (AppDetailVM$doLoad$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        AppDetailVM this = (AppDetailVM) r12.L$0;
        kotlin.c.b(r14);
    L23:
        com.obric.appstore.network.g r17 = com.obric.appstore.network.h.a((com.obric.appstore.network.g) r14, AppDetailVM$doLoad$2.INSTANCE);
        if (com.obric.appstore.network.h.b(r17) == false) goto L26;
        AppsManager.f10585a.c(this.f10626i);
    L26:
        return r17;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r14);
        AppInfo r18 = this.f10626i;
        if (r18 == null) goto L17;
        String r19 = r18.appPackageName;
    L18:
        if (r19 != null) goto L20;
        r19 = "";
    L20:
        StoreRepo r20 = StoreRepo.f10831a;
        r12.L$0 = this;
        r12.label = 1;
        r14 = r20.e(r19, r12);
        if (r14 != r15) goto L23;
        return r15;
    L17:
        r19 = null;
    L7:
        r12 = new AppDetailVM$doLoad$1(this, r11);
        goto L8
    }

    @Override // com.obric.appstore.buss.apps.AppCallback
    public void onAppUpdate() {
        a r10 = (a) k().e();
        if (r10 == null) goto L6;
        AppInfo r11 = r10.a();
        if (r11 == null) goto L6;
    L9:
        this.f10627j.p(r11);
        return;
    L6:
        r11 = this.f10626i;
        if (r11 != null) goto L9;
        r11 = new AppInfo();
        goto L9
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public /* bridge */ /* synthetic */ void t(Object r10, com.obric.appstore.base.j r11) {
        x((a) r10, r11);
    }

    public final LiveData v() {
        return this.f10627j;
    }

    public final void w(AppInfo r10) {
        this.f10626i = r10;
        AppsManager.f10585a.j(this);
    }

    public void x(a r10, com.obric.appstore.base.j r11) {
        q.g(r11, Card.KEY_API_LOAD_PARAMS);
        super.t(r10, r11);
        if (r10 == null) goto L16;
        AppInfo r12 = r10.a();
        if (r12 == null) goto L17;
        AppInfo r13 = BaseApplication.c().b().D(r12.appPackageName);
        if (r13 != null) goto L9;
        return;
    L9:
        if (r12.appVersionCode <= r13.appVersionCode) goto L19;
        AppInfo r14 = BaseApplication.c().b().G(r12.appPackageName);
        if (r14 != null) goto L13;
    L14:
        BaseApplication.c().b().g(r12, r13);
        return;
    L13:
        if (r12.appVersionCode > r14.appVersionCode) goto L14;
        return;
    L19:
        return;
    L17:
        return;
    }
}
