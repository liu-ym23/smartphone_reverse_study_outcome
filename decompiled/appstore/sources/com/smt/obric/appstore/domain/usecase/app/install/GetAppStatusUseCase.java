package com.smt.obric.appstore.domain.usecase.app.install;

import com.bytedanceos.common.ui.AppPermissionActivity;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import com.smt.obric.appstore.domain.oapplet.InstalledOApplets;
import com.smt.obric.appstore.domain.oapplet.OAppletUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes4.dex */
public final class GetAppStatusUseCase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppInstallActor f18122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18123b;

    public GetAppStatusUseCase(AppInstallActor r10, boolean r11) {
        q.g(r10, "installActor");
        this.f18122a = r10;
        this.f18123b = r11;
    }

    public static final /* synthetic */ boolean a(GetAppStatusUseCase r10) {
        return r10.f18123b;
    }

    public final Flow b(final String r10, final Long r11) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        if (OAppletUtil.f18065a.g(r10) == false) goto L5;
        final StateFlow r12 = InstalledOApplets.f18057a.f();
        final Flow r13 = new GetAppStatusUseCase$invoke$$inlined$map$1(r12, r10);
        Flow r14 = new GetAppStatusUseCase$invoke$$inlined$map$2(r13, r10);
    L6:
        final StateFlow r15 = this.f18122a.S();
        return kotlinx.coroutines.flow.c.i(r14, new GetAppStatusUseCase$invoke$$inlined$map$4(r15, r10, r11), new GetAppStatusUseCase$invoke$1(this, r11, r10, null));
    L5:
        final StateFlow r16 = le.a.f21945a.b();
        r14 = kotlinx.coroutines.flow.c.L(new GetAppStatusUseCase$invoke$$inlined$map$3(r16, r10), new GetAppStatusUseCase$invoke$installedPkg$4(null));
        goto L6
    }

    public /* synthetic */ GetAppStatusUseCase(AppInstallActor r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = true;
    L5:
        this(r10, r11);
    }
}
