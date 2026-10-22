package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.livecommerce.event.w0;
import com.bytedance.android.livesdk.livecommerce.room.LiveRoomProvider;
import com.bytedance.android.livesdk.livecommerce.room.widgets.start_live.StartLivePromotionButton;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class RealStartLiveController implements com.bytedance.android.livesdk.livecommerce.room.api.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StartLivePromotionButton f151441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f151442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.api.e f151443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f151444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.ec.adapter.api.state.c f151445e;

    public RealStartLiveController() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void onCreate() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void onDestroyView() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void onStart() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void onStop() {
    }

    public final void c() {
        StartLivePromotionButton r100 = this.f151441a;
        if (r100 == null) goto L52;
        com.bytedance.android.ec.adapter.api.state.c r101 = this.f151445e;
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        com.bytedance.android.ec.adapter.api.state.c r103 = this.f151445e;
        if (r103 == null) goto L17;
        Bundle r104 = r103.f42716d;
        if (r104 == null) goto L17;
        int r105 = com.bytedance.android.ec.adapter.api.state.c.f42712e;
        if (r104.getBoolean("EXTRA_BOOL_ENABLE_SHOW_COMMERCE_SALE") != true) goto L17;
        boolean r106 = true;
    L18:
        com.bytedance.android.ec.adapter.api.state.c r107 = this.f151445e;
        if (r107 == null) goto L25;
        Bundle r108 = r107.f42716d;
        if (r108 == null) goto L25;
        int r109 = com.bytedance.android.ec.adapter.api.state.c.f42712e;
        if (r108.getBoolean("EXTRA_BOOL_HAS_LAST_ROOM") != true) goto L25;
        boolean r110 = true;
    L27:
        if (hh2.f.f() == true) goto L29;
        if (r106 == true) goto L35;
        if (r110 == true) goto L35;
    L34:
        boolean r111 = false;
    L37:
        if (r102 == false) goto L46;
        if (r111 == false) goto L46;
        if (this.f151442b == true) goto L53;
        com.bytedance.android.livesdk.livecommerce.room.api.e r112 = this.f151443c;
        if (r112 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L44:
        r112.O(r100);
        this.f151442b = true;
        w0 r113 = new w0();
        r113.f(MapMonitorConst.BIZ_NAME, "开播前购物车图标");
        r113.k();
        return;
    L53:
        return;
    L46:
        if (this.f151442b == false) goto L55;
        com.bytedance.android.livesdk.livecommerce.room.api.e r114 = this.f151443c;
        if (r114 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L50:
        r114.K(r100);
        this.f151442b = false;
        return;
    L55:
        return;
    L35:
        r111 = true;
        goto L37
    L29:
        if (com.bytedance.android.livesdk.livecommerce.room.f.c(Boolean.TRUE) == true) goto L34;
    L25:
        r110 = false;
    L17:
        r106 = false;
        goto L18
    L7:
        if (r101.f42714b.invoke().booleanValue() != true) goto L9;
        r102 = true;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void onViewCreated() {
        Context r100 = this.f151444d;
        Intrinsics.checkNotNull(r100);
        com.bytedance.android.livesdk.livecommerce.room.api.e r101 = this.f151443c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L5:
        StartLivePromotionButton r102 = new StartLivePromotionButton(r100, r101, new AnonymousClass1(this));
        this.f151441a = r102;
        this.f151442b = false;
        com.bytedance.android.livesdk.livecommerce.room.api.e r103 = this.f151443c;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L8:
        r103.L(r102, xd.h.f563268a);
        if (this.f151445e == null) goto L12;
        c();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void onDestroy() {
        if (EComABUtils.isLiveStartMemoryLeakSwitch() == false) goto L5;
        this.f151444d = null;
    L5:
        Lazy r100 = LiveRoomProvider.f151373a;
        LiveRoomProvider.f151378f = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void a(com.bytedance.android.ec.adapter.api.state.c r100) {
        Intrinsics.checkNotNullParameter(r100, UserInfo.USERSTATE);
        this.f151445e = r100;
        c();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void b(ak2.j r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f151443c = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f151444d = r100;
    }
}
