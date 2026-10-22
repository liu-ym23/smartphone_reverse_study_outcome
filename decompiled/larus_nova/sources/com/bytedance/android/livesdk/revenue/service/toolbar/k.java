package com.bytedance.android.livesdk.revenue.service.toolbar;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarConstants;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k implements com.bytedance.android.livesdk.chatroom.viewmodel.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f157469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f157470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RevToolbarConstants f157471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f157472d;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
    public final ToolbarButton c() {
        l r100 = this.f157469a;
        RevToolbarConstants r101 = this.f157471c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$toToolbarButton");
        if (j.f157467a[r101.ordinal()] == 1) goto L5;
        ToolbarButton r102 = null;
    L6:
        Intrinsics.checkNotNull(r102);
        return r102;
    L5:
        r102 = ToolbarButton.GIFT;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
    public final com.bytedance.android.livesdk.chatroom.viewmodel.a getInfo() {
        l r100 = this.f157469a;
        RevToolbarConstants r101 = this.f157471c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$toAnimationSchedulerListener");
        if (j.f157468b[r101.ordinal()] == 1) goto L5;
        com.bytedance.android.livesdk.chatroom.viewmodel.a.c r102 = null;
    L6:
        Intrinsics.checkNotNull(r102);
        return r102;
    L5:
        r102 = com.bytedance.android.livesdk.chatroom.viewmodel.a.c.f114775b;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
    public final boolean b() {
        return this.f157472d;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
    public final boolean a(long r100) {
        return ((Boolean) this.f157470b.invoke(Long.valueOf(r100))).booleanValue();
    }

    public k(l r100, Function1 r101, RevToolbarConstants r102) {
        this.f157469a = r100;
        this.f157470b = r101;
        this.f157471c = r102;
        this.f157472d = false;
    }
}
