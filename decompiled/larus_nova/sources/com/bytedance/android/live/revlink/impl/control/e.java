package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes47.dex */
public final class e extends com.bytedance.android.livesdk.common.k<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkCrossRoomDataHolder f92405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f92406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f92407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IRoom f92408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f92409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.room.a f92410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ld.a f92411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.c f92412i;

    public static final class a {
    }

    public interface b {
        void Ab();
    }

    static {
    }

    public final void a(long r100) {
        com.bytedance.android.live.revlink.impl.global.c r101 = this.f92407d;
        if (r101 == null) goto L5;
        com.bytedance.android.live.revenuelink.connect.f r102 = r101.Z0();
    L6:
        if (r102 == null) goto L11;
        com.bytedance.android.live.revenuelink.connect.l r103 = r102.linkInManager();
        if (r103 == null) goto L12;
        r103.b(new fy.d(r100, 1, "control_widget_detach"));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public e(com.bytedance.android.live.revlink.impl.global.c r100, IRoom r101, boolean r102, LiveMode r103, com.bytedance.android.livesdk.revenue.room.a r104, ld.a r105, com.bytedance.android.livesdk.revenue.service.room.c r106) {
        this.f92407d = r100;
        this.f92408e = r101;
        this.f92409f = r102;
        this.f92410g = r104;
        this.f92411h = r105;
        this.f92412i = r106;
        if (r100 == null) goto L5;
        LinkCrossRoomDataHolder r107 = r100.getLinkCrossRoomDataHolder();
    L6:
        this.f92405b = r107;
        this.f92406c = new CompositeDisposable();
        return;
    L5:
        r107 = null;
        goto L6
    }
}
