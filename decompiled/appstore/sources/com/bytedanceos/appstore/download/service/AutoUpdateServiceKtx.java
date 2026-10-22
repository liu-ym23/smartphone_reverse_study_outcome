package com.bytedanceos.appstore.download.service;

import com.bytedanceos.common.model.AppInfo;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import com.smt.obric.appstore.domain.usecase.app.install.CancelAppInstallUseCase;
import com.smt.obric.appstore.domain.usecase.app.install.EnqueueAppInstallTaskUseCase;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoUpdateServiceKtx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f9414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EnqueueAppInstallTaskUseCase f9415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CancelAppInstallUseCase f9416c;

    public AutoUpdateServiceKtx() {
        this.f9414a = d0.b();
        AppInstallActor.Companion r10 = AppInstallActor.f17891n;
        this.f9415b = new EnqueueAppInstallTaskUseCase(r10.b());
        this.f9416c = new CancelAppInstallUseCase(r10.b());
    }

    public static final /* synthetic */ EnqueueAppInstallTaskUseCase a(AutoUpdateServiceKtx r10) {
        return r10.f9415b;
    }

    public final void b(AppInfo r10) {
        q.g(r10, "appInfo");
        h.d(this.f9414a, null, null, new AutoUpdateServiceKtx$enqueueWiFiAutoUpdate$1(this, r10, null), 3, null);
    }
}
