package com.smt.obric.appstore.domain.usecase.app.install;

import com.bytedanceos.common.ui.AppPermissionActivity;
import com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppInstallTaskDAO f18144a;

    public a(AppInstallTaskDAO r10) {
        q.g(r10, "dao");
        this.f18144a = r10;
    }

    public final Flow a(String r10) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        return this.f18144a.getByPkg(r10);
    }
}
