package com.bytedance.android.live.revlink.impl.mergepk.pkdouble;

import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.o9;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.w2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o9 f93006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f93007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PkDoubleAnchorDataContext.d f93008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f93009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f93010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w2 f93011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f93012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IBattleConfigSetting f93013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p0 f93014i;

    public g(PkDoubleAnchorDataContext.d r100, int r101, w2 r102, boolean r103, IBattleConfigSetting r110, int r111) {
        if ((r111 & 8) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 16) == 0) goto L8;
        r101 = 0;
    L8:
        String r104 = "";
        if ((r111 & 32) == 0) goto L11;
        Object r105 = "";
    L13:
        if ((r111 & 64) != 0) goto L17;
        r104 = null;
    L17:
        if ((r111 & 256) == 0) goto L20;
        r102 = null;
    L20:
        if ((r111 & 4096) == 0) goto L23;
        r103 = false;
    L23:
        if ((r111 & 8192) == 0) goto L25;
        r110 = null;
    L25:
        Intrinsics.checkNotNullParameter(r105, "linkmicID");
        Intrinsics.checkNotNullParameter(r104, "linkConnectionType");
        this.f93006a = null;
        this.f93007b = null;
        this.f93008c = r100;
        this.f93009d = r101;
        this.f93010e = 0;
        this.f93011f = r102;
        this.f93012g = r103;
        this.f93013h = r110;
        this.f93014i = null;
        return;
    L11:
        r105 = null;
        goto L13
    }
}
