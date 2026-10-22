package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.viewmodels.cache.CacheMyAppsRepository;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.obric.appstore.R;
import h7.d;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class UninstallAppsViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f8992d;

    public UninstallAppsViewModel() {
        this.f8992d = kotlin.b.b(UninstallAppsViewModel$uninstallLiveData$2.INSTANCE);
        if (AccountDataCache.b().n() == false) goto L5;
        h();
        return;
    L5:
        MutableLiveData r10 = g();
        String r11 = BaseApplication.c().getString(R.string.appstore_no_user);
        q.f(r11, "getString(...)");
        r10.p(new h.a(r11, -3, null, 4, null));
    }

    public final void f(List r10) {
        q.g(r10, "appList");
        kotlinx.coroutines.h.d(l0.a(this), null, null, new UninstallAppsViewModel$deleteMyApps$1(r10, null), 3, null);
    }

    public final MutableLiveData g() {
        return (MutableLiveData) this.f8992d.getValue();
    }

    public final void h() {
        CacheMyAppsRepository.o(CacheMyAppsRepository.f8997f.a(), false, 1, null);
    }
}
