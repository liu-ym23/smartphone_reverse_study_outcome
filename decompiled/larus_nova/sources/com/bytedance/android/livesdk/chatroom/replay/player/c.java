package com.bytedance.android.livesdk.chatroom.replay.player;

import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.utils.Error;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nic.p;

/* JADX INFO: loaded from: classes7.dex */
public class c extends com.bytedance.android.livesdk.chatroom.vs_base.player.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<List<com.bytedance.android.livesdk.chatroom.vs_base.player.d>> f109565a;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function0<? extends List<? extends com.bytedance.android.livesdk.chatroom.vs_base.player.d>> r100) {
        Intrinsics.checkNotNullParameter(r100, "listenersProvider");
        this.f109565a = r100;
    }

    @Override // nic.l.a, nic.h
    public final void N(VideoInfo r100) {
        Iterator<T> r101 = this.f109565a.invoke().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r101.next()).N(r100);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
    public final void k0(long r100) {
        Iterator<T> r101 = this.f109565a.invoke().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r101.next()).k0(r100);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void D(oic.f r100, tic.a r101) {
        Iterator<T> r102 = this.f109565a.invoke().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r102.next()).D(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void G(oic.f r100, tic.a r101) {
        Iterator<T> r102 = this.f109565a.invoke().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r102.next()).G(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void I(oic.f r100, tic.a r101) {
        Iterator<T> r102 = this.f109565a.invoke().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r102.next()).I(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.b
    public final void S(boolean r100, int r101) {
        Iterator<T> r102 = this.f109565a.invoke().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r102.next()).S(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void Y(oic.f r100, tic.a r101) {
        Iterator<T> r102 = this.f109565a.invoke().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r102.next()).Y(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void b(oic.f r100, tic.a r101) {
        Iterator<T> r102 = this.f109565a.invoke().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r102.next()).b(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void h(oic.f r100, tic.a r101) {
        Iterator<T> r102 = this.f109565a.invoke().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r102.next()).h(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void o(oic.f r100, tic.a r101) {
        Iterator<T> r102 = this.f109565a.invoke().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r102.next()).o(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void s(oic.f r100, tic.a r101) {
        Iterator<T> r102 = this.f109565a.invoke().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r102.next()).s(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void y(oic.f r100, tic.a r101) {
        Iterator<T> r102 = this.f109565a.invoke().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r102.next()).y(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void F(oic.f r100, tic.a r101, int r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).F(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void J(oic.f r100, tic.a r101, int r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).J(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void K(oic.f r100, tic.a r101, int r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).K(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void Q(oic.f r100, tic.a r101, int r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).Q(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void R(oic.f r100, tic.a r101, boolean r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).R(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void c0(oic.f r100, tic.a r101, long r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).c0(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.d
    public final void g(oic.f r100, tic.a r101, String r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).g(r100, r101, r102);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
    public final void g0(oic.f r100, tic.a r101, long r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).g0(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void j(oic.f r100, tic.a r101, int r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).j(r100, r101, r102);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
    public final void j0(oic.f r100, tic.a r101, long r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).j0(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void k(oic.f r100, tic.a r101, int r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).k(r100, r101, r102);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
    public final void l0(oic.f r100, tic.a r101, long r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).l0(r100, r101, r102);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
    public final void m0(oic.f r100, tic.a r101, long r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).m0(r100, r101, r102);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
    public final void n0(oic.f r100, tic.a r101, long r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).n0(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void v(oic.f r100, tic.a r101, Error r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).v(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void w(oic.f r100, tic.a r101, long r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).w(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void x(oic.f r100, tic.a r101, boolean r102) {
        Iterator<T> r103 = this.f109565a.invoke().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r103.next()).x(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.d
    public final void M(oic.f r100, tic.a r101, String r102, Error r103) {
        Iterator<T> r104 = this.f109565a.invoke().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r104.next()).M(r100, r101, r102, r103);
        goto L4
    }

    @Override // nic.l.a, nic.d
    public final void P(oic.f r100, tic.a r101, int r102, int r103) {
        Iterator<T> r104 = this.f109565a.invoke().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r104.next()).P(r100, r101, r102, r103);
        goto L4
    }

    @Override // nic.l.a, nic.d
    public final void T(oic.f r100, tic.a r101, int r102, String r103) {
        Iterator<T> r104 = this.f109565a.invoke().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r104.next()).T(r100, r101, r102, r103);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void U(oic.f r100, tic.a r101, Resolution r102, int r103) {
        Iterator<T> r104 = this.f109565a.invoke().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r104.next()).U(r100, r101, r102, r103);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void b0(oic.f r100, tic.a r101, int r102, Map r103) {
        Iterator<T> r104 = this.f109565a.invoke().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r104.next()).b0(r100, r101, r102, r103);
        goto L4
    }

    @Override // nic.l.a, nic.b
    public final boolean c(p r100, tic.a r101, boolean r102, int r103) {
        Iterator<T> r104 = this.f109565a.invoke().iterator();
    L4:
        if (r104.hasNext() == false) goto L9;
        if (((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r104.next()).c(r100, r101, r102, r103) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
    public final void h0(oic.f r100, tic.a r110, int r111, long r112) {
        Iterator<T> r101 = this.f109565a.invoke().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r101.next()).h0(r100, r110, r111, r112);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
    public final void i0(oic.f r100, tic.a r110, boolean r111, long r112) {
        Iterator<T> r101 = this.f109565a.invoke().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r101.next()).i0(r100, r110, r111, r112);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void l(oic.f r100, tic.a r101, Resolution r102, boolean r103) {
        Iterator<T> r104 = this.f109565a.invoke().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r104.next()).l(r100, r101, r102, r103);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
    public final void o0(p r110, tic.a r111, long r112, long r113) {
        Iterator<T> r100 = this.f109565a.invoke().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r100.next()).o0(r110, r111, r112, r113);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
    public final void p0(oic.f r100, tic.a r110, VideoEngineInfos r111, long r112) {
        Iterator<T> r101 = this.f109565a.invoke().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r101.next()).p0(r100, r110, r111, r112);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void q(oic.f r100, tic.a r101, int r102, int r103) {
        Iterator<T> r104 = this.f109565a.invoke().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r104.next()).q(r100, r101, r102, r103);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
    public final void q0(oic.f r110, tic.a r111, long r112, long r113) {
        Iterator<T> r100 = this.f109565a.invoke().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r100.next()).q0(r110, r111, r112, r113);
        goto L4
    }

    @Override // nic.l.a, nic.b
    public final void O(p r110, tic.a r111, boolean r112, int r113, boolean r114, boolean r115) {
        Iterator<T> r100 = this.f109565a.invoke().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r100.next()).O(r110, r111, r112, r113, r114, r115);
        goto L4
    }

    @Override // nic.l.a, nic.b
    public final void X(p r110, tic.a r111, nic.e r112, boolean r113, int r114, boolean r115, boolean r116) {
        Iterator<T> r100 = this.f109565a.invoke().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vs_base.player.d) r100.next()).X(r110, r111, r112, r113, r114, r115, r116);
        goto L4
    }
}
