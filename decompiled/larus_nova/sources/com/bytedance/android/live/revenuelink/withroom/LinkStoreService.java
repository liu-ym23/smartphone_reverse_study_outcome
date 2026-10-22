package com.bytedance.android.live.revenuelink.withroom;

import com.bytedance.android.live.revenuelink.connect.ConnectDataContext;
import com.bytedance.android.live.revenuelink.connect.e;
import com.bytedance.android.live.revenuelink.connect.k;
import com.bytedance.android.live.revenuelink.j;
import com.bytedance.android.live.revenuelink.rtc.AnchorRtcManager;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.scope.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import yz0.f;
import yz0.g;

/* JADX INFO: loaded from: classes47.dex */
public final class LinkStoreService implements a, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConnectDataContext f91989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnchorRtcManager f91990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f91991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f91992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f91993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f91994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f91995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f91996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f91997i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f91998j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p11.c f91999k;

    @Override // com.bytedance.android.live.revenuelink.withroom.a
    public final com.bytedance.android.live.revenuelink.connect.o z8() {
        return (com.bytedance.android.live.revenuelink.connect.o) this.f91994f.getValue();
    }

    @Override // com.bytedance.android.live.revenuelink.withroom.a
    public final com.bytedance.android.live.revenuelink.connect.g getAnchorConnectUtils() {
        return (com.bytedance.android.live.revenuelink.connect.a) this.f91991c.getValue();
    }

    @Override // com.bytedance.android.live.revenuelink.withroom.a
    public final com.bytedance.android.live.revenuelink.f getRevenueLinkTraceMonitor() {
        return (j) this.f91993e.getValue();
    }

    @Override // com.bytedance.android.live.revenuelink.withroom.a
    public final com.bytedance.android.live.revenuelink.rtc.f m0() {
        return (com.bytedance.android.live.revenuelink.rtc.f) this.f91995g.getValue();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (this.f91996h.isAnchor() == false) goto L11;
        this.f91989a = new ConnectDataContext(this, this.f91998j, this.f91996h);
        IRoomBase r100 = this.f91996h.getRoom();
        if (r100 == null) goto L10;
        this.f91990b = new AnchorRtcManager((IRoom) r100, this, this.f91999k, this.f91996h);
        if (((Boolean) com.bytedance.android.live.revenuelink.a.f91711b.getValue(null, com.bytedance.android.live.revenuelink.a.f91710a[0])).booleanValue() == false) goto L12;
        c r101 = this.f91997i;
        Intrinsics.checkNotNullParameter(r101, "revRoomService");
        r101.getRoomContext().setRevnueLinkHasLoad(true);
        return;
    L12:
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.IRoomKt /* = com.bytedance.android.livesdkapi.depend.model.live.IRoom */");
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        ConnectDataContext r100 = this.f91989a;
        if (r100 == null) goto L5;
        r100.onStop();
    L5:
        AnchorRtcManager r101 = this.f91990b;
        if (r101 == null) goto L9;
        r101.t();
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.withroom.a
    public final k z0() {
        return (e) this.f91992d.getValue();
    }

    @Override // com.bytedance.android.live.revenuelink.withroom.a
    public final com.bytedance.android.live.revenuelink.connect.f Z0() {
        return this.f91989a;
    }

    public LinkStoreService(g r100, c r101, f r102, p11.c r103) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "revRoomService");
        Intrinsics.checkNotNullParameter(r102, "messageService");
        Intrinsics.checkNotNullParameter(r103, "pkService");
        this.f91996h = r100;
        this.f91997i = r101;
        this.f91998j = r102;
        this.f91999k = r103;
        this.f91991c = LazyKt.lazy(new LinkStoreService$anchorConnectUtils$2(this));
        this.f91992d = LazyKt.lazy(new LinkStoreService$connectStateMonitor$2(this));
        this.f91993e = LazyKt.lazy(new LinkStoreService$revenueLinkTraceMonitor$2(this));
        this.f91994f = LazyKt.lazy(new LinkStoreService$multiChannelMonitor$2(this));
        this.f91995g = LazyKt.lazy(new LinkStoreService$anchorLinkRtcService$2(this));
    }
}
