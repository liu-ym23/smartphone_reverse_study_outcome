package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class t implements qh0.a<rh0.a>, qh0.d<rh0.a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f77405g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qh0.d<rh0.a> f77406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f77407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qh0.f.h f77408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final qh0.a<rh0.a> f77409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j1 f77410e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<? super String, ? super String, Unit> f77411f;

    public static final class a {
    }

    static {
    }

    public final void c() {
        if (this.f77407b == false) goto L5;
        return;
    L5:
        this.f77407b = true;
        long r100 = System.currentTimeMillis();
        qh0.f.h r101 = this.f77408c;
        InteractLinkFullLinkMonitor.q0(r101.f532911c, r101.f532914f);
        int r102 = eg0.c.f472602a;
        IRoom r103 = this.f77408c.f532913e;
        if (r103 == null) goto L8;
        long r104 = r103.getId();
    L9:
        long r105 = r104;
        String r106 = String.valueOf(d5.c(this.f77408c.f532914f));
        qh0.f.h r107 = this.f77408c;
        String r108 = r107.f532914f;
        int r109 = r107.f532911c;
        String r110 = r107.f532915g;
        if (r110 != null) goto L12;
        r110 = "";
    L12:
        ((ObservableSubscribeProxy) eg0.c.a(r105, r106, r108, r109, r110).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(ContextUtil.contextToFragmentActivity(this.f77408c.getContext())))).subscribe(new u(this, r100), new v(this, r100));
        return;
    L8:
        r104 = 0;
        goto L9
    }

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        this.f77406a = r100;
        qh0.a<rh0.a> r101 = this.f77409d;
        if (r101 == null) goto L5;
        r101.a(this);
        return;
    L5:
        com.bytedance.android.scope.m r102 = com.bytedance.android.scope.m.f163449e;
        f00.a.C5839a r103 = f00.a.f474945b;
        nz.t r104 = (nz.t) r102.d(r103, nz.t.class);
        if (r104 != null) goto L8;
    L12:
        ((IMiddlewareBroadcastService) va1.b.a.f553922a.a(IMiddlewareBroadcastService.class)).init();
    L13:
        c();
        return;
    L8:
        if (r104.isOpen() != true) goto L12;
        nz.t r105 = (nz.t) r102.d(r103, nz.t.class);
        if (r105 == null) goto L13;
        r105.init();
        goto L13
    }

    @Override // qh0.d
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        qh0.d<rh0.a> r101 = this.f77406a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.b(r100);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r100) {
        LivePluginSPIManager.f85856e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new w(this, r100)).callbackOnMainThread().syncCallbackIfReady(true).requireByUser("ServerCameraChecker");
    }

    public t(qh0.f.h r100, qh0.a<rh0.a> r101, j1 r102, Function2<? super String, ? super String, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "createConfig");
        this.f77408c = r100;
        this.f77409d = r101;
        this.f77410e = r102;
        this.f77411f = r103;
    }
}
