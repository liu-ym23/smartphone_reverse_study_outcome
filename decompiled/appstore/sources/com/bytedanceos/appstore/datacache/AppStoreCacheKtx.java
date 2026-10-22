package com.bytedanceos.appstore.datacache;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class AppStoreCacheKtx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f9351a;

    public AppStoreCacheKtx() {
        this.f9351a = d0.b();
    }

    public static final /* synthetic */ Object a(AppStoreCacheKtx r10, Continuation r11) {
        return r10.c(r11);
    }

    public static final /* synthetic */ CoroutineScope b(AppStoreCacheKtx r10) {
        return r10.f9351a;
    }

    public final Object c(Continuation r10) {
        Object r11 = AppInstallActor.f17891n.a().await(r10);
        if (r11 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r11;
    L6:
        return Unit.f21064a;
    }

    public final void d(AppInfo r10) {
        q.g(r10, "appInfo");
        h.d(this.f9351a, null, null, new AppStoreCacheKtx$enqueueSysAppAutoUpdate$1(this, r10, null), 3, null);
    }

    public final com.smt.obric.appstore.domain.app.entity.a e(String r10, boolean r11) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        return (com.smt.obric.appstore.domain.app.entity.a) h.f(null, new AppStoreCacheKtx$getInAppSysAppUpdateInstallTaskBlocking$1(this, r10, r11, null), 1, null);
    }
}
