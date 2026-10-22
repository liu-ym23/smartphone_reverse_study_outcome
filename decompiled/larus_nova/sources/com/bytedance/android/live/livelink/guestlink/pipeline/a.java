package com.bytedance.android.live.livelink.guestlink.pipeline;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.message.guestlink.k;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.multilink.base.model.guestlink.c;
import com.lynx.tasm.LynxError;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements mb6.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GuestLinkPipeLineManager f81258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f81259b;

    public a(GuestLinkPipeLineManager r100, int r101) {
        this.f81258a = r100;
        this.f81259b = r101;
    }

    @Override // mb6.b.c
    public final void C2(long r100, ExtraResponse<? extends c, Extra> r110) {
        Intrinsics.checkNotNullParameter(r110, "response");
        Intrinsics.checkNotNullParameter(r110, "response");
        jy0.b.d("GuestLinkPipeLineManager", "sendJoinChannelReq success, duration: " + r100);
        c r101 = (c) r110.data;
        if (r101 == null) goto L61;
        com.bytedance.android.live.base.model.message.guestlink.a r102 = r101.getChannelInfo();
        if (r102 == null) goto L61;
        List<k> r103 = r102.getLinkedUsers();
        k r104 = null;
        Object r105 = null;
        if (r103 == null) goto L20;
        Iterator<T> r106 = r103.iterator();
    L10:
        if (r106.hasNext() == false) goto L18;
        Object r107 = r106.next();
        IBaseUser r108 = ((k) r107).getUser();
        if (r108 == null) goto L14;
        String r109 = r108.getIdString();
    L16:
        if (Intrinsics.areEqual(r109, rk0.b.a()) == false) goto L10;
        r105 = r107;
        goto L18
    L14:
        r109 = null;
    L18:
        r104 = (k) r105;
    L20:
        if (r104 != null) goto L22;
    L39:
        ec6.a r111 = this.f81258a.f81242m.n();
        if (r111 == null) goto L46;
        sk0.c r112 = r111.r();
        if (r112 == null) goto L46;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r113 = r112.f542321d;
        if (r113 == null) goto L46;
        r113.c(5);
    L46:
        ei6.a r114 = this.f81258a.f81242m.A();
        if (r114 == null) goto L53;
        xi6.c r115 = r114.t();
        if (r115 == null) goto L53;
        com.bytedance.live.livelink.kmp.impl.core.video.b r116 = r115.f();
        if (r116 == null) goto L53;
        r116.e(true);
    L53:
        ec6.a r117 = this.f81258a.f81242m.n();
        if (r117 == null) goto L60;
        sk0.c r118 = r117.r();
        if (r118 == null) goto L60;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r119 = r118.f542321d;
        if (r119 == null) goto L60;
        r119.d("");
    L60:
        this.f81258a.G().b(r102, "joinChannel");
        goto L61
    L22:
        if (r104.getLinkType() != 1) goto L39;
        if (r104.isBackground() == 1) goto L39;
        ec6.a r120 = this.f81258a.f81242m.n();
        if (r120 == null) goto L32;
        sk0.c r121 = r120.r();
        if (r121 == null) goto L32;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r122 = r121.f542321d;
        if (r122 == null) goto L32;
        r122.c(this.f81259b);
    L32:
        ei6.a r123 = this.f81258a.f81242m.A();
        if (r123 == null) goto L53;
        xi6.c r124 = r123.t();
        if (r124 == null) goto L53;
        com.bytedance.live.livelink.kmp.impl.core.video.b r125 = r124.f();
        if (r125 == null) goto L53;
        r125.e(false);
    L61:
        nb6.a r126 = this.f81258a.f81232c;
        if (r126 == null) goto L69;
        CopyOnWriteArraySet<nb6.b> r127 = r126.f518518a;
        if (r127 == null) goto L74;
        Iterator<nb6.b> r128 = r127.iterator();
    L67:
        if (r128.hasNext() == false) goto L75;
        r128.next().f518519a.C2(r100, r110);
        goto L67
    L75:
        return;
    L74:
        return;
    }

    @Override // mb6.b.c
    public final void o1(long r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        jy0.b.b("GuestLinkPipeLineManager", "sendJoinChannelReq failed, duration: " + r100, r101);
        this.f81258a.k("sendJoinChannelReqFailed");
        this.f81258a.f81243n.release();
        this.f81258a.f81241l.w("onJoinChannelFailed");
        this.f81258a.G().a();
        nb6.a r102 = this.f81258a.f81232c;
        if (r102 == null) goto L10;
        CopyOnWriteArraySet<nb6.b> r103 = r102.f518518a;
        if (r103 == null) goto L12;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        ((nb6.b) r104.next()).f518519a.o1(r100, r101);
        goto L8
    L13:
        return;
    L12:
        return;
    }
}
