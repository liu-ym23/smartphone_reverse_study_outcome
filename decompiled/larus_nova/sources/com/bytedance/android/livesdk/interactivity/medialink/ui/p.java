package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.UILayout;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.WindowLayoutType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class p implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f138320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f138321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f138322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f138323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f138324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f138325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f138326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Integer, Boolean> f138327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<UILayout, Boolean> f138328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<WindowLayoutType, Boolean> f138329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<? super Boolean, Unit> f138330k;

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean b() {
        return this.f138321b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean c() {
        return this.f138325f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean d() {
        return this.f138324e;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean e() {
        return this.f138323d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean f() {
        return this.f138326g;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean a(UILayout r100) {
        Intrinsics.checkNotNullParameter(r100, "uiLayout");
        return this.f138328i.invoke(r100).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean g(WindowLayoutType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return this.f138329j.invoke(r100).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final void h(boolean r100) {
        this.f138330k.invoke(Boolean.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean i(int r100) {
        return this.f138327h.invoke(Integer.valueOf(r100)).booleanValue();
    }

    public final void j(boolean r100) {
        this.f138321b = r100;
        q r101 = this.f138320a;
        if (r101 == null) goto L6;
        r101.a(this);
        return;
    }

    public p(View r100, boolean r101, boolean r102, Function1 r103, Function1 r104, Function1 r105, int r110) {
        if ((r110 & 4) == 0) goto L6;
        r101 = false;
    L6:
        if ((r110 & 8) == 0) goto L9;
        r102 = false;
    L9:
        if ((r110 & 16) == 0) goto L11;
        boolean r106 = true;
    L13:
        if ((r110 & 32) == 0) goto L16;
        r103 = MediaWindowComponent$1.INSTANCE;
    L16:
        if ((r110 & 64) == 0) goto L19;
        r104 = MediaWindowComponent$2.INSTANCE;
    L19:
        if ((r110 & 128) == 0) goto L22;
        r105 = MediaWindowComponent$3.INSTANCE;
    L22:
        if ((r110 & 256) == 0) goto L24;
        MediaWindowComponent$4 r111 = MediaWindowComponent$4.INSTANCE;
    L25:
        Intrinsics.checkNotNullParameter(r103, "validInWindowCount");
        Intrinsics.checkNotNullParameter(r104, "validWhenUILayout");
        Intrinsics.checkNotNullParameter(r105, "validWhenWindowLayoutType");
        Intrinsics.checkNotNullParameter(r111, "onShowSet");
        this.f138322c = r100;
        this.f138323d = false;
        this.f138324e = r101;
        this.f138325f = r102;
        this.f138326g = r106;
        this.f138327h = r103;
        this.f138328i = r104;
        this.f138329j = r105;
        this.f138330k = r111;
        return;
    L24:
        r111 = null;
        goto L25
    L11:
        r106 = false;
        goto L13
    }
}
