package com.bytedanceos.appstore.utils;

import com.bytedanceos.common.model.AppInfo;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class AppStoreCommonUtilKtx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f9532a;

    public AppStoreCommonUtilKtx() {
        this.f9532a = d0.b();
    }

    public final void a(AppInfo r10) {
        q.g(r10, "appInfo");
        h.d(this.f9532a, null, null, new AppStoreCommonUtilKtx$startWiFiDownload$1(r10, null), 3, null);
    }
}
