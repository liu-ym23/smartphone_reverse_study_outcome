package com.bytedance.android.livesdk.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f5 implements vlc.e, ylc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vlc.f f158949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ vlc.e f158950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ylc.b f158951c;

    @Override // vlc.d
    public final void B(tlc.d r100) {
        this.f158950b.B(r100);
    }

    @Override // vlc.e
    public final void E(tlc.a r100, vlc.i r101) {
        this.f158950b.E(r100, r101);
    }

    @Override // vlc.d
    public final void F(vlc.h r100) {
        this.f158950b.F(r100);
    }

    @Override // vlc.e
    public final void G(tlc.e r100, r42.c.a r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        this.f158950b.G(r100, r101);
    }

    @Override // ylc.b
    public final void a(String r100, ylc.c r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f158951c.a(r100, r101);
    }

    @Override // vlc.d
    public final void addMessageListener(int r100, vlc.l r101) {
        this.f158950b.addMessageListener(r100, r101);
    }

    @Override // vlc.d
    public final void addMessageListener(String r100, vlc.l r101) {
        this.f158950b.addMessageListener(r100, r101);
    }

    @Override // ylc.b
    public final com.ss.ugc.live.sdk.message.wrsc.data.a b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f158951c.b(r100);
    }

    @Override // ylc.b
    public final void f(ylc.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f158951c.f(r100);
    }

    @Override // ylc.b
    public final long getRoomId() {
        return this.f158951c.getRoomId();
    }

    @Override // vlc.d
    public final void h(vlc.b r100) {
        this.f158950b.h(r100);
    }

    @Override // vlc.e
    public final boolean isPaused() {
        return this.f158950b.isPaused();
    }

    @Override // vlc.e
    public final boolean isRunning() {
        return this.f158950b.isRunning();
    }

    @Override // vlc.d
    public final void j(tlc.d r100, boolean r101) {
        this.f158950b.j(r100, r101);
    }

    @Override // vlc.d
    public final void k(vlc.j r100) {
        this.f158950b.k(r100);
    }

    @Override // vlc.d
    public final void n(vlc.h r100) {
        this.f158950b.n(r100);
    }

    @Override // vlc.e
    public final amc.e q() {
        return this.f158950b.q();
    }

    @Override // vlc.d
    public final void r(boolean r100) {
        this.f158950b.r(r100);
    }

    @Override // vlc.d
    public final void release() {
        this.f158950b.release();
    }

    @Override // vlc.d
    public final void removeMessageListener(int r100, vlc.l r101) {
        this.f158950b.removeMessageListener(r100, r101);
    }

    @Override // vlc.d
    public final void removeMessageListener(String r100, vlc.l r101) {
        this.f158950b.removeMessageListener(r100, r101);
    }

    @Override // vlc.d
    public final void removeMessageListener(vlc.l r100) {
        this.f158950b.removeMessageListener(r100);
    }

    @Override // vlc.d
    public final void startMessage() {
        this.f158950b.startMessage();
    }

    @Override // vlc.d
    public final void v(vlc.j r100) {
        this.f158950b.v(r100);
    }

    @Override // vlc.e
    public final void z(long r100, com.ss.ugc.live.sdk.msg.network.f r101, ac2.f.a r102) {
        this.f158950b.z(r100, r101, r102);
    }

    public f5(com.ss.ugc.live.sdk.msg.d r100, ylc.e r101, vlc.f r102) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        Intrinsics.checkNotNullParameter(r101, "wrdsManager");
        this.f158950b = r100;
        this.f158951c = r101;
        this.f158949a = r102;
    }
}
