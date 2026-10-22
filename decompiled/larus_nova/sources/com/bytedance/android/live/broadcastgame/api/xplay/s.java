package com.bytedance.android.live.broadcastgame.api.xplay;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f59527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f59528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f59529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f59530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f59531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f59532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f59533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f59534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public XplayGuestType f59535i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f59536j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f59537k;

    public s(boolean r100, boolean r101, Long r102, int r110) {
        String r103 = "";
        if ((r110 & 1) == 0) goto L5;
        String r104 = "";
    L7:
        if ((r110 & 4) == 0) goto L9;
        Map<String, String> r105 = MapsKt.emptyMap();
    L11:
        if ((r110 & 8) != 0) goto L15;
        r103 = null;
    L15:
        if ((r110 & 64) == 0) goto L18;
        r100 = false;
    L18:
        if ((r110 & 128) == 0) goto L21;
        r101 = false;
    L21:
        if ((r110 & 256) == 0) goto L23;
        XplayGuestType r106 = XplayGuestType.DEFAULT;
    L25:
        if ((r110 & 1024) == 0) goto L27;
        r102 = null;
    L27:
        Intrinsics.checkNotNullParameter(r104, "toolbarSchema");
        Intrinsics.checkNotNullParameter(r105, "extraToServer");
        Intrinsics.checkNotNullParameter(r103, "openId");
        Intrinsics.checkNotNullParameter(r106, "roomGuestType");
        this.f59527a = r104;
        this.f59528b = false;
        this.f59529c = r105;
        this.f59530d = r103;
        this.f59531e = false;
        this.f59532f = false;
        this.f59533g = r100;
        this.f59534h = r101;
        this.f59535i = r106;
        this.f59536j = false;
        this.f59537k = r102;
        return;
    L23:
        r106 = null;
        goto L25
    L9:
        r105 = null;
        goto L11
    L5:
        r104 = null;
        goto L7
    }
}
