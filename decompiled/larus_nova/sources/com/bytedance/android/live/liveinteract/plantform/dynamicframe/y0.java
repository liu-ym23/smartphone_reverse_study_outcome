package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.net.Uri;
import android.view.View;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.sp;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class y0 extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ih0.c f77169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f77170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f77171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Uri f77172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f77173e;

    @Override // b7.a, b7.b
    public final void onRelease() {
        super.onRelease();
        ALogger.i("MultiLinkDynamicWidget", "main HybridCard onRelease, url:" + this.f77172d);
        int r100 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.f77149b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.e(String.valueOf(this.f77172d), ChameleonOpenTracker.Stage.RENDER, RootDescription.ROOT_ELEMENT, System.currentTimeMillis() - this.f77171c);
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        super.onLoadSuccess(r100);
        ALogger.i("MultiLinkDynamicWidget", "render HybridCard load success");
    }

    public y0(Uri r100, Function0<Unit> r101) {
        this.f77172d = r100;
        this.f77173e = r101;
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "errorMessage");
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard onFallback errorMessage=" + r111);
        int r100 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.f77149b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("card_error", String.valueOf(this.f77172d), ChameleonOpenTracker.Stage.RENDER, RootDescription.ROOT_ELEMENT, r110, r111, System.currentTimeMillis() - this.f77171c);
        return super.onFallback(r110, r111);
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "errorMessage");
        super.onInnerFallback(r110, r111);
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard onInnerFallback errorMessage=" + r111);
        int r100 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.f77149b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("card_inner_error", String.valueOf(this.f77172d), ChameleonOpenTracker.Stage.RENDER, RootDescription.ROOT_ELEMENT, r110, r111, System.currentTimeMillis() - this.f77171c);
    }

    @Override // b7.a, b7.b
    public final void onLoadStart(View r100, boolean r101) {
        super.onLoadStart(r100, r101);
        this.f77171c = System.currentTimeMillis();
    }

    @Override // b7.a, b7.b
    public final void onContainerError(View r100, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "errorMessage");
        super.onContainerError(r100, r110, r111);
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard onContainerError errorMessage=" + r111);
        int r101 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.f77149b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("container_error", String.valueOf(this.f77172d), ChameleonOpenTracker.Stage.RENDER, RootDescription.ROOT_ELEMENT, r110, r111, System.currentTimeMillis() - this.f77171c);
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r110) {
        super.onLoadFail(r100, r101, r110);
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard load fail reason=" + r110);
        this.f77169a = null;
        Function0<Unit> r102 = this.f77173e;
        if (r102 == null) goto L5;
        Unit r103 = r102.invoke();
    L5:
        int r104 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.f77149b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b(String.valueOf(this.f77172d), ChameleonOpenTracker.Stage.RENDER, RootDescription.ROOT_ELEMENT, System.currentTimeMillis() - this.f77171c, r110);
        if (this.f77170b >= sp.f121243a.getValue().reloadCount()) goto L11;
        this.f77170b++;
        ih0.c r105 = this.f77169a;
        if (r105 == null) goto L12;
        ih0.c.a.a(r105, null, null, 7);
        return;
    L12:
        return;
    }
}
