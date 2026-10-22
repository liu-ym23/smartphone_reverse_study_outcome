package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p005new.ComponentConfigManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import ot2.d;
import zo1.e;
import zo1.f;
import zo1.h;

/* JADX INFO: loaded from: classes8.dex */
public final class ContainerContextEnv implements o, h, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ComponentConfigManager f116031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f116032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f116033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f116034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f<s> f116035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DataCenter f116036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f116037g;

    @Override // zo1.d
    public final void a() {
        Intrinsics.checkNotNullParameter("onRoomExit", "event");
        f<s> r100 = this.f116035e;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        h r101 = this.f116032b;
        if (r101 == null) goto L8;
        r101.a();
    L8:
        e r102 = this.f116034d;
        if (r102 == null) goto L12;
        r102.a();
        return;
    }

    public ContainerContextEnv() {
        this.f116037g = LazyKt.lazy(new ContainerContextEnv$isAnchor$2(this));
    }

    @Override // zo1.h
    public final boolean c(int r100) {
        h r101 = this.f116032b;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.c(r100) != true) goto L7;
        return true;
    }

    @Override // zo1.h
    public final int g(int r100) {
        h r101 = this.f116032b;
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.g(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o
    public final a0 getToolbarConfig(int r100) {
        ComponentConfigManager r101 = this.f116031a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getToolbarConfig(r100);
    }

    @Override // zo1.h
    public final void h(s r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        h r101 = this.f116032b;
        if (r101 == null) goto L6;
        r101.h(r100);
        return;
    }

    @Override // zo1.e
    public final c0.b j(int r100) {
        e r101 = this.f116034d;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.j(r100);
    }

    @Override // zo1.h
    public final View k(s r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        h r101 = this.f116032b;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.k(r100);
    }

    @Override // zo1.h
    public final View l(int r100) {
        h r101 = this.f116032b;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.l(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o
    public final void register(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        ComponentConfigManager r101 = this.f116031a;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "config");
        r101.d(r100);
        return;
    }
}
