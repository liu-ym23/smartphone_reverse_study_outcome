package com.bytedance.android.gamecp.business.download.custommade;

import android.os.Build;
import com.bytedance.android.gamecp.business.m0;
import com.bytedance.android.gamecp.common.setting.config.o0;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f52641a = 0;

    static {
    }

    public static boolean a(List r110) {
        List r100 = r110;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return false;
    L11:
        String r103 = RomUtils.getName();
        String r104 = RomUtils.getVersion();
        int r105 = Build.VERSION.SDK_INT;
        String r106 = m0.c();
        boolean r107 = RomUtils.isHarmony();
        yr.c.a("CustomInstaller", "rom name:" + r103 + " rom version:" + r104 + " deviceBrand:" + Build.BRAND + ",deviceModel:" + Build.MODEL + " OS_VERSION:" + Build.VERSION.RELEASE + " hmVersion:" + r106 + " isHmDevice: " + r107);
        Iterator r108 = r110.iterator();
    L13:
        if (r108.hasNext() == false) goto L104;
        o0 r109 = (o0) r108.next();
        yr.c.a("CustomInstaller", r109.f() + " | " + r109.g() + " | " + r109.a() + " | " + r109.b() + " | " + r109.d() + " | " + r109.e() + " | " + r109.c());
        String r111 = r109.e();
        if (r111 != null) goto L17;
    L20:
        boolean r112 = true;
    L21:
        if (r112 == false) goto L23;
        boolean r113 = true;
    L24:
        String r114 = r109.c();
        if (r114 != null) goto L27;
    L30:
        boolean r115 = true;
    L31:
        if (r115 == true) goto L36;
        if (r107 == true) goto L35;
    L37:
        boolean r116 = false;
    L38:
        String r117 = r109.d();
        if (r117 == null) goto L43;
        Integer r118 = StringsKt.toIntOrNull(r117);
        if (r118 == null) goto L43;
        int r119 = r118.intValue();
    L44:
        if (r105 < r119) goto L46;
        boolean r120 = true;
    L47:
        String r121 = r109.f();
        if (r121 != null) goto L50;
    L53:
        boolean r122 = true;
    L54:
        if (r122 == false) goto L56;
        boolean r123 = true;
    L57:
        String r124 = r109.g();
        if (r124 != null) goto L60;
    L63:
        boolean r125 = true;
    L64:
        if (r125 == false) goto L66;
        boolean r126 = true;
    L67:
        String r127 = r109.a();
        if (r127 != null) goto L70;
    L73:
        boolean r128 = true;
    L74:
        if (r128 == true) goto L84;
        String r129 = r109.a();
        Intrinsics.checkNotNull(r129);
        if (StringsKt.startsWith(r129, Build.BRAND, true) == true) goto L84;
        String r130 = r109.a();
        Intrinsics.checkNotNull(r130);
        if (StringsKt.startsWith(r130, Build.MANUFACTURER, true) == true) goto L84;
        String r131 = r109.a();
        Intrinsics.checkNotNull(r131);
        if (StringsKt.equals(r131, m0.d(), true) == true) goto L84;
        boolean r132 = false;
    L85:
        String r133 = r109.b();
        if (r133 != null) goto L88;
    L91:
        boolean r134 = true;
    L92:
        if (r134 == false) goto L94;
        boolean r135 = true;
    L95:
        if (r113 == false) goto L103;
        if (r123 == false) goto L103;
        if (r126 == false) goto L103;
        if (r132 == false) goto L103;
        if (r135 == false) goto L103;
        if (r120 == false) goto L103;
        if (r116 == false) goto L103;
        return true;
    L103:
        r101 = false;
        goto L13
    L94:
        r135 = StringsKt.equals(r109.b(), Build.MODEL, true);
        goto L95
    L88:
        if (r133.length() == 0) goto L91;
        r134 = false;
    L84:
        r132 = true;
        goto L85
    L70:
        if (r127.length() == 0) goto L73;
        r128 = false;
        goto L74
    L66:
        r126 = StringsKt.equals(r109.g(), r104, true);
        goto L67
    L60:
        if (r124.length() == 0) goto L63;
        r125 = false;
        goto L64
    L56:
        r123 = StringsKt.equals(r109.f(), r103, true);
        goto L57
    L50:
        if (r121.length() == 0) goto L53;
        r122 = false;
        goto L54
    L46:
        r120 = false;
    L43:
        r119 = 0;
        goto L44
    L35:
        if (StringsKt.equals(r109.c(), r106, true) == false) goto L37;
    L36:
        r116 = true;
        goto L38
    L27:
        if (r114.length() == 0) goto L30;
        r115 = false;
        goto L31
    L23:
        r113 = StringsKt.equals(r109.e(), String.valueOf(r105), true);
        goto L24
    L17:
        if (r111.length() == 0) goto L20;
        r112 = false;
        goto L21
    L104:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }
}
