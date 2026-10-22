package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.ui.myapplist.MyAppListData;
import com.obric.appstore.R;
import h7.d;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class MyAppViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f8964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f8965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MyAppListData f8967g;

    public MyAppViewModel() {
        this.f8964d = kotlin.b.b(MyAppViewModel$myAppsNumLiveData$2.INSTANCE);
        this.f8965e = kotlin.b.b(MyAppViewModel$uninstallLiveData$2.INSTANCE);
        this.f8966f = kotlin.b.b(MyAppViewModel$myAppsLiveData$2.INSTANCE);
        String r10 = BaseApplication.c().getString(R.string.myapp_installed_apps);
        q.f(r10, "getString(...)");
        AppInfo r11 = l("section_header_local_app", r10);
        String r12 = BaseApplication.c().getString(R.string.downloading);
        q.f(r12, "getString(...)");
        this.f8967g = new MyAppListData(r11, l("section_header_download_queue", r12), false);
        i();
    }

    public static final /* synthetic */ MyAppListData f(MyAppViewModel r10) {
        return r10.f8967g;
    }

    public final void g() {
        h.d(l0.a(this), null, null, new MyAppViewModel$getMyAppsList$1(this, null), 3, null);
    }

    public final MutableLiveData h() {
        return (MutableLiveData) this.f8966f.getValue();
    }

    public final void i() {
        h.d(l0.a(this), null, null, new MyAppViewModel$getMyAppsNum$1(this, null), 3, null);
    }

    public final MutableLiveData j() {
        return (MutableLiveData) this.f8964d.getValue();
    }

    public final MutableLiveData k() {
        return (MutableLiveData) this.f8965e.getValue();
    }

    public final AppInfo l(String r10, String r11) {
        AppInfo r12 = new AppInfo();
        r12.appCategoryName = "section_header";
        r12.appPackageName = r10;
        r12.appName = r11;
        r12.appVersionName = "section_header_version_name";
        return r12;
    }

    public void m(LifecycleOwner r10) {
        q.g(r10, "owner");
        j().o(r10);
        k().o(r10);
        h().o(r10);
    }
}
