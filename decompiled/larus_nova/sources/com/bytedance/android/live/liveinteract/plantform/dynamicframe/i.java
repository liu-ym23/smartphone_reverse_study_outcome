package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.net.Uri;
import android.view.View;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.sp;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ih0.c f77042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f77043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f77044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f77045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri f77046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f77047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f77048g;

    @Override // b7.a, b7.b
    public final void onRelease() {
        super.onRelease();
        ALogger.i("MultiLinkDynamicWidget", "main HybridCard onRelease, url:" + this.f77046e);
        int r100 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.f77149b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.e(this.f77046e.toString(), PullConfiguration.PROCESS_NAME_MAIN, RootDescription.ROOT_ELEMENT, System.currentTimeMillis() - this.f77044c);
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        super.onLoadSuccess(r100);
        ALogger.i("MultiLinkDynamicWidget", "main HybridCard load success");
        int r101 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.f77149b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.d(this.f77046e.toString(), PullConfiguration.PROCESS_NAME_MAIN, RootDescription.ROOT_ELEMENT, System.currentTimeMillis() - this.f77044c);
        if (this.f77047f == true) goto L14;
        int r102 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        DataCenter r103 = this.f77045d;
        com.bytedance.live.datacontext.m<IRoom> r104 = o3.j(r103).getRoom();
        if (r104 == null) goto L9;
        IRoom r105 = r104.getValue();
        if (r105 == null) goto L9;
        long r106 = r105.getRoomId();
    L10:
        MultiSceneEnterRoomStatisticsUtils r107 = MultiSceneEnterRoomStatisticsUtils.a.a(r103, Long.valueOf(r106));
        if (r107 == null) goto L15;
        r107.recordSubElementShow("lynx_container_load", System.currentTimeMillis());
        return;
    L15:
        return;
    L9:
        r106 = 0;
        goto L10
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "errorMessage");
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard onFallback errorMessage=" + r111);
        int r100 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.f77149b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("card_error", this.f77046e.toString(), PullConfiguration.PROCESS_NAME_MAIN, RootDescription.ROOT_ELEMENT, r110, r111, System.currentTimeMillis() - this.f77044c);
        return super.onFallback(r110, r111);
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "errorMessage");
        super.onInnerFallback(r110, r111);
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard onInnerFallback errorMessage=" + r111);
        int r100 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.f77149b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("card_inner_error", this.f77046e.toString(), PullConfiguration.PROCESS_NAME_MAIN, RootDescription.ROOT_ELEMENT, r110, r111, System.currentTimeMillis() - this.f77044c);
    }

    @Override // b7.a, b7.b
    public final void onContainerError(View r100, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "errorMessage");
        super.onContainerError(r100, r110, r111);
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard onContainerError errorMessage=" + r111);
        int r101 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.f77149b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("container_error", this.f77046e.toString(), PullConfiguration.PROCESS_NAME_MAIN, RootDescription.ROOT_ELEMENT, r110, r111, System.currentTimeMillis() - this.f77044c);
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        super.onLoadFail(r100, r101, r102);
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard load fail reason=" + r102);
        Function0<Unit> r103 = this.f77048g;
        if (r103 == null) goto L5;
        Unit r104 = r103.invoke();
    L5:
        int r105 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.f77149b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b(this.f77046e.toString(), PullConfiguration.PROCESS_NAME_MAIN, RootDescription.ROOT_ELEMENT, System.currentTimeMillis() - this.f77044c, r102);
        if (this.f77043b >= sp.f121243a.getValue().reloadCount()) goto L11;
        this.f77043b++;
        ih0.c r106 = this.f77042a;
        if (r106 == null) goto L12;
        ih0.c.a.a(r106, null, null, 7);
        return;
    L12:
        return;
    }

    public i(DataCenter r100, Uri r101, boolean r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "uri");
        this.f77045d = r100;
        this.f77046e = r101;
        this.f77047f = r102;
        this.f77048g = r103;
    }
}
