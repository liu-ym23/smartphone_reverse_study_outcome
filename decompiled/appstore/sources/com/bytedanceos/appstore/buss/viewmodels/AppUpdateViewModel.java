package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import com.bytedanceos.common.eventbus.AddUpdateEvent;
import h7.d;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class AppUpdateViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f8933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f8934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8937h;

    public AppUpdateViewModel() {
        this.f8933d = kotlin.b.b(AppUpdateViewModel$diskFullLiveData$2.INSTANCE);
        this.f8934e = kotlin.b.b(AppUpdateViewModel$updateAppsLiveData$2.INSTANCE);
        this.f8935f = kotlin.b.b(AppUpdateViewModel$ignoreAppsSizeLiveData$2.INSTANCE);
        this.f8936g = kotlin.b.b(AppUpdateViewModel$recommendLiveData$2.INSTANCE);
        this.f8937h = kotlin.b.b(AppUpdateViewModel$btnStatusLiveData$2.INSTANCE);
        EventBus.getDefault().register(this);
        l();
    }

    @Override // androidx.lifecycle.k0
    public void d() {
        super.d();
        if (EventBus.getDefault().isRegistered(this) == false) goto L6;
        EventBus.getDefault().unregister(this);
        return;
    }

    public final MutableLiveData f() {
        return (MutableLiveData) this.f8937h.getValue();
    }

    public final MutableLiveData g() {
        return (MutableLiveData) this.f8933d.getValue();
    }

    public final MutableLiveData h() {
        return (MutableLiveData) this.f8935f.getValue();
    }

    public final MutableLiveData i() {
        return (MutableLiveData) this.f8936g.getValue();
    }

    public final void j() {
        h.d(l0.a(this), null, null, new AppUpdateViewModel$getUpdateApps$1(this, null), 3, null);
    }

    public final MutableLiveData k() {
        return (MutableLiveData) this.f8934e.getValue();
    }

    public final void l() {
        h.d(l0.a(this), null, null, new AppUpdateViewModel$getUpdateRecommendList$1(this, null), 3, null);
    }

    public void m(LifecycleOwner r10) {
        q.g(r10, "owner");
        g().o(r10);
        k().o(r10);
        h().o(r10);
        i().o(r10);
        f().o(r10);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull AddUpdateEvent r10) {
        q.g(r10, "event");
        j();
    }
}
