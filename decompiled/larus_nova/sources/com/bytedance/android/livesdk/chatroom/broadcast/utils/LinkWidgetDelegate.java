package com.bytedance.android.livesdk.chatroom.broadcast.utils;

import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.revlink.impl.control.LinkRevControlWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.e1;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.larus.nova.R;
import kc0.r;

/* JADX INFO: loaded from: classes7.dex */
public final class LinkWidgetDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f105380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f105381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.live.revenue.core.b f105382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f105383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclableWidgetManager f105384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f105385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f105386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f105387h;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if (this.f105381b == false) goto L6;
        return;
    L6:
        if (this.f105382c != null) goto L8;
        return;
    L8:
        if (this.f105384e == null) goto L31;
        r r100 = this.f105380a;
        if (r100 == null) goto L30;
        LinkRevControlWidget r101 = r100.getWidget();
        if (r101 == null) goto L32;
        RecyclableWidgetManager r102 = this.f105384e;
        if (r102 == null) goto L18;
        r102.load(R.id.interact_revenue_container, r101, this.f105383d);
    L18:
        this.f105381b = true;
        e r103 = this.f105387h;
        if (r103 == null) goto L21;
        r103.run();
    L21:
        this.f105387h = null;
        f r104 = this.f105386g;
        if (r104 == null) goto L24;
        r104.run();
    L24:
        this.f105386g = null;
        d r105 = this.f105385f;
        if (r105 == null) goto L27;
        r105.run();
    L27:
        this.f105385f = null;
        return;
    L32:
        return;
    L30:
        return;
    }

    public LinkWidgetDelegate() {
        this.f105383d = true;
    }

    public final void b(RoomContext r100) {
        if (e1.f123284a.getValue().booleanValue() == false) goto L8;
        if (r100 == null) goto L13;
        i<Boolean> r101 = r100.getRevenueInstanceInitialized();
        if (r101 == null) goto L14;
        r101.c(new LinkWidgetDelegate$onRoomContextReady$1(this));
        return;
    L14:
        return;
    L13:
        return;
    L8:
        if (r100 == null) goto L16;
        j<com.bytedance.android.live.revenue.core.b> r102 = r100.getRevenueInstance();
        if (r102 == null) goto L17;
        r102.c(new LinkWidgetDelegate$onRoomContextReady$2(this));
        return;
    L17:
        return;
    }

    public final void c(RecyclableWidgetManager r100) {
        this.f105383d = true;
        this.f105384e = r100;
        a();
    }
}
