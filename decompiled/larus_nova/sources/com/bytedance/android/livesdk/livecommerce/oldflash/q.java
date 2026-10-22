package com.bytedance.android.livesdk.livecommerce.oldflash;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f149642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f149643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f149644c;

    public static final class a {
    }

    static {
    }

    public final void b(String r100) {
        com.bytedance.android.livesdk.livecommerce.event.x r101 = new com.bytedance.android.livesdk.livecommerce.event.x(this.f149642a, this.f149643b, this.f149644c);
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.f("attribute_name", r100);
        r101.k();
    }

    public final void a(boolean r100, String r101) {
        com.bytedance.android.livesdk.livecommerce.event.a0 r102 = new com.bytedance.android.livesdk.livecommerce.event.a0(this.f149642a, this.f149643b, this.f149644c);
        if (r100 == false) goto L5;
        String r103 = "auto";
    L6:
        r102.f("auto_type", r103);
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        r102.f("attribute_name", r101);
        r102.k();
        return;
    L5:
        r103 = "manual";
        goto L6
    }

    public q(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "productType");
        this.f149642a = r100;
        this.f149643b = r101;
        this.f149644c = r102;
    }

    public final void c(String r100, String r101, boolean r102) {
        com.bytedance.android.livesdk.livecommerce.event.x r103 = new com.bytedance.android.livesdk.livecommerce.event.x(this.f149642a, this.f149643b, this.f149644c);
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r103.f("attribute_name", r100);
        r103.f(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r101);
        if (r102 == false) goto L8;
        String r104 = "auto";
    L9:
        r103.f("auto_type", r104);
        r103.k();
        return;
    L8:
        r104 = "manual";
        goto L9
    }
}
