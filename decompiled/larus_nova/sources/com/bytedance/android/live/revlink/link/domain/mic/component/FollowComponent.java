package com.bytedance.android.live.revlink.link.domain.mic.component;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.revenue.user.RevLiveFollowScene;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class FollowComponent implements e, s51.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f98453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NextLiveData<Boolean> f98454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f98455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d f98456d;

    @Override // s51.a
    public final void attach() {
        if (Intrinsics.areEqual(this.f98455c, this.f98456d.eg()) == false) goto L5;
        return;
    L5:
        cy0.e.f465759a.getClass();
        cy0.j r100 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r101 = com.bytedance.android.scope.m.b(r100).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r101);
        Single<IBaseUser> r102 = ((com.bytedance.android.livesdk.revenue.service.user.a) ((com.bytedance.live.kmp.core.c) r101)).tm(this.f98455c);
        if (r102 == null) goto L15;
        int r103 = p.f267522a;
        Single<IBaseUser> r104 = r102.subscribeOn(Schedulers.io());
        if (r104 == null) goto L16;
        Single<IBaseUser> r105 = r104.observeOn(AndroidSchedulers.mainThread());
        if (r105 == null) goto L17;
        Disposable r106 = r105.subscribe(new c(this), d.f98464a);
        if (r106 == null) goto L18;
        com.bytedance.revenue.platform.api.core.rx.f.a(r106, this.f98453a);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // s51.a
    public final void detach() {
        this.f98453a.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.domain.mic.component.e
    public final int g() {
        Boolean r100 = this.f98454b.getValue();
        if (Intrinsics.areEqual(r100, Boolean.FALSE) == false) goto L6;
        int r101 = s11.a.f540144b;
        return 1;
    L6:
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L8;
        int r102 = s11.a.f540144b;
        return 2;
    L8:
        int r103 = s11.a.f540144b;
        return 0;
    }

    public FollowComponent(String r100, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f98455c = r100;
        this.f98456d = r101;
        this.f98453a = new CompositeDisposable();
        this.f98454b = new NextLiveData();
    }

    public static final void b(FollowComponent r100, Throwable r101) {
        r100.getClass();
        if ((r101 instanceof ApiServerException) == false) goto L5;
        int r102 = ToastUtil.f90810a;
        ToastUtil.b(((ApiServerException) r101).getPrompt(), 0);
        return;
    L5:
        int r103 = ToastUtil.f90810a;
        int r104 = w11.a.f557889a;
        ToastUtil.a(R.string.ttlive_live_profile_action_error, 0);
    }

    public final void h(boolean r100, final String r101) {
        Intrinsics.checkNotNullParameter(r101, "requestSource");
        if (Intrinsics.areEqual(Boolean.valueOf(r100), this.f98454b.getValue()) == false) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        com.bytedance.revenue.platform.api.core.rx.f.a(this.f98456d.getCommonService().e(this.f98455c, RevLiveFollowScene.MultiAnchorPanel, new FollowComponent$follow$1(this, r101), new FollowComponent$follow$2(this)), this.f98453a);
    L8:
        this.f98456d.getMultiAnchorLinkLogUtils().A(this.f98455c, "shortcut_button", r100);
        return;
    L7:
        this.f98456d.getCommonService().b(this.f98455c, r101, FollowComponent$follow$3.INSTANCE, new FollowComponent$follow$4(this));
        goto L8
    }
}
