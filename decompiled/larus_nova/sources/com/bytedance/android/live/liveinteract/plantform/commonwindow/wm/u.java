package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.linkbase.api.LoadDurationItemId;
import com.bytedance.android.livesdk.config.zb0;
import com.bytedance.android.livesdk.utils.d5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class u implements tf0.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f76110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f76111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f76112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f76113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f76114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f76115f;

    public static final class a {
    }

    static {
    }

    public u() {
    }

    @Override // tf0.m
    public final void a(tf0.f r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        long r101 = System.currentTimeMillis();
        if (d5.c(r100.c()) > r101) goto L8;
        r101 = d5.c(r100.c());
    L8:
        String r102 = r100.a();
        if (Intrinsics.areEqual(r102, LoadDurationItemId.JSB_RECEIVE_LAYOUT_INFO.getValue()) == false) goto L12;
        this.f76115f = r101;
        return;
    L12:
        if (Intrinsics.areEqual(r102, LoadDurationItemId.RENDER_LYNX_SWITCH_LAYOUT_END.getValue()) == false) goto L16;
        b(r101);
        return;
    }

    public final void b(long r110) {
        long r100 = this.f76113d;
        if (r100 > 0) goto L5;
        return;
    L5:
        long r101 = this.f76111b;
        if (r101 <= 0) goto L8;
        long r102 = this.f76112c - r101;
        long r103 = r100 - r101;
        long r104 = this.f76114e - r101;
        long r111 = this.f76115f - r101;
        long r112 = r110 - r101;
    L10:
        if (zb0.f121750a.getValue().longValue() <= 0) goto L12;
        f2.c("切换接口回包到达：" + r102 + " \n到达switcher：" + r103 + " \n开始发送LayoutInfo：" + r104 + " \nLynx收到LayoutInfo：" + r111 + " \n 布局切换成功:" + r112, 0);
    L12:
        this.f76110a = true;
        this.f76111b = 0;
        this.f76112c = 0;
        this.f76113d = 0;
        this.f76114e = 0;
        this.f76115f = 0;
        return;
    L8:
        r104 = this.f76114e - r100;
        r111 = this.f76115f - r100;
        r112 = r110 - r100;
        r103 = 0;
        r102 = 0;
        goto L10
    }
}
