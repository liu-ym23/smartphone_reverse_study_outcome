package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

/* JADX INFO: loaded from: classes8.dex */
public final class o implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f116612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f116613b;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void c(ExtendedToolbarButton r100) {
        this.f116612a.c(r100);
        this.f116613b.c(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final boolean g(ToolbarButton r100) {
        if (this.f116612a.g(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f116613b.g(r100) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void h(ExtendedToolbarButton r100) {
        this.f116612a.h(r100);
        this.f116613b.h(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void i(ExtendedToolbarButton r100) {
        this.f116612a.i(r100);
        this.f116613b.i(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final String j(ToolbarButton r100) {
        if (this.f116612a.j(r100) == null) goto L5;
        c0 r101 = this.f116612a;
    L7:
        return r101.j(r100);
    L5:
        r101 = this.f116613b;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void m(com.bytedance.android.livesdk.chatroom.utils.c0 r100) {
        this.f116612a.m(r100);
        this.f116613b.m(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final boolean n(ToolbarButton r100) {
        if (this.f116612a.n(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f116613b.n(r100) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void o(ToolbarButton r100) {
        this.f116612a.o(r100);
        this.f116613b.o(r100);
    }

    public o(c0 r100, g3 r101) {
        this.f116612a = r100;
        this.f116613b = r101;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void a(ToolbarButton r100, String r101) {
        this.f116612a.a(r100, r101);
        this.f116613b.a(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void b(ToolbarButton r100, e r101) {
        this.f116612a.b(r100, r101);
        this.f116613b.b(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void d(ToolbarButton r100, c0.b r101) {
        this.f116612a.d(r100, r101);
        this.f116613b.d(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void e(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100, c0.b r101) {
        this.f116612a.e(r100, r101);
        this.f116613b.e(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void f(ExtendedToolbarButton r100, c0.b r101) {
        this.f116612a.f(r100, r101);
        this.f116613b.f(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void k(ToolbarButton r100, c0.b r101) {
        this.f116612a.k(r100, r101);
        this.f116613b.k(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void l(ExtendedToolbarButton r100, String r101) {
        this.f116612a.l(r100, r101);
        this.f116613b.l(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void p(ExtendedToolbarButton r100, c0.b r101) {
        this.f116612a.p(r100, r101);
        this.f116613b.p(r100, r101);
    }
}
