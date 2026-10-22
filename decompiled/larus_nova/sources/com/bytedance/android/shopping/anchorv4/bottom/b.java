package com.bytedance.android.shopping.anchorv4.bottom;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f165790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f165791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f165792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f165793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f165794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f165795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f165796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f165797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f165798i;

    public b() {
        this(null, null, null, null, null, 0, false, 127);
    }

    public final boolean a() {
        if (a2.d(this.f165793d) != null) goto L6;
        return false;
    L6:
        if (a2.d(this.f165795f) != null) goto L8;
        return false;
    L8:
        String r100 = this.f165794e;
        if (r100 != null) goto L11;
    L32:
        return false;
    L11:
        if (a2.d(r100) == null) goto L32;
        Integer r101 = this.f165792c;
        if (r101 == null) goto L32;
        if (r101.intValue() != 2) goto L32;
        if (Intrinsics.areEqual(this.f165796g, Boolean.TRUE) == false) goto L32;
        String r102 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));     // Catch: Exception -> L30
        com.bytedance.android.ec.sdk.helper.q r103 = com.bytedance.android.ec.sdk.helper.q.f48131a;
        String r104 = r103.getString(this.f165790a, "");
        int r105 = r103.getInt(this.f165791b, 0);
        if (a2.b(r104) == true) goto L24;
    L26:
        r103.putString(this.f165790a, r102);
        int r106 = 1;
    L27:
        r103.d(this.f165791b, r106);
        if (ECSettingKeys.S().contains(String.valueOf(r106)) == false) goto L32;
        return true;
    L24:
        if (Intrinsics.areEqual(r102, r104) == false) goto L26;
        r106 = r105 + 1;
    L30:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L32
    }

    public b(Integer r100, String r101, String r102, String r103, Boolean r104, int r105, boolean r106, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r110 & 32) == 0) goto L21;
        r105 = 1;
    L21:
        if ((r110 & 64) == 0) goto L23;
        r106 = false;
    L23:
        this.f165792c = r100;
        this.f165793d = r101;
        this.f165794e = r102;
        this.f165795f = r103;
        this.f165796g = r104;
        this.f165797h = r105;
        this.f165798i = r106;
        this.f165790a = "add_cart_guide_show_date";
        this.f165791b = "add_cart_guide_show_times";
    }
}
