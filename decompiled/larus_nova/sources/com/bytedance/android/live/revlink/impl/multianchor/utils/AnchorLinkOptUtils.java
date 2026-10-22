package com.bytedance.android.live.revlink.impl.multianchor.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes47.dex */
public final class AnchorLinkOptUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f94831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f94832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f94833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.c f94834d;

    public final r11.b b() {
        return (r11.b) this.f94832b.getValue();
    }

    public final boolean c() {
        return ((Boolean) this.f94831a.getValue()).booleanValue();
    }

    public final boolean a() {
        com.bytedance.android.livesdk.revenue.service.room.c r100 = this.f94834d;
        if (r100 == null) goto L15;
        com.bytedance.android.livesdk.revenue.room.a r101 = r100.getRoomContext();
        if (r101 == null) goto L15;
        if (r101.getCommonIsAnchor() != true) goto L15;
        if (c() == true) goto L11;
        return false;
    L11:
        if (b().h0() == false) goto L21;
        return true;
    L21:
        return false;
    L15:
        if (((Boolean) this.f94833c.getValue()).booleanValue() == true) goto L17;
        return false;
    L17:
        if (b().h0() == false) goto L23;
        return true;
    L23:
        return false;
    }

    public final boolean e() {
        com.bytedance.android.livesdk.revenue.service.room.c r100 = this.f94834d;
        if (r100 == null) goto L11;
        com.bytedance.android.livesdk.revenue.room.a r101 = r100.getRoomContext();
        if (r101 == null) goto L11;
        if (r101.getCommonIsAnchor() != true) goto L11;
        return c();
    L11:
        return b().C6();
    }

    public final boolean d() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (b().o1() == false) goto L7;
        return true;
    }

    public AnchorLinkOptUtils(com.bytedance.android.livesdk.revenue.service.room.c r100) {
        this.f94834d = r100;
        this.f94831a = LazyKt.lazy(AnchorLinkOptUtils$enable$2.INSTANCE);
        this.f94832b = LazyKt.lazy(AnchorLinkOptUtils$config$2.INSTANCE);
        this.f94833c = LazyKt.lazy(AnchorLinkOptUtils$audienceOpt$2.INSTANCE);
    }
}
