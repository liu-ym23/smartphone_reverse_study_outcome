package com.bytedance.android.anniex.utils;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.m0;
import com.lynx.devtoolwrapper.ScreenshotMode;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f41400a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f41401b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f41402c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f41403d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f41404e = false;

    static {
        s26.d r100 = s26.d.f540305c;
        m0 r101 = (m0) s26.d.f540305c.c(m0.class);
        if (r101 == null) goto L5;
        com.bytedance.ies.bullet.service.base.d r102 = r101.a0();
    L6:
        Map<String, Map<Class<?>, Object>> r103 = x26.a.f562251a;
        w26.g r104 = (w26.g) x26.a.a(w26.g.class);
        if (r104 == null) goto L13;
        w26.e r105 = (w26.e) r104.n0(w26.e.class);
        if (r105 == null) goto L13;
        List<String> r106 = r105.m();
        if (r106 == null) goto L13;
    L14:
        f41400a = CollectionsKt.plus(r106, CollectionsKt.emptyList());
        w26.g r107 = (w26.g) x26.a.a(w26.g.class);
        if (r107 == null) goto L21;
        w26.e r108 = (w26.e) r107.n0(w26.e.class);
        if (r108 == null) goto L21;
        List<String> r109 = r108.i();
        if (r109 == null) goto L21;
    L22:
        f41401b = CollectionsKt.plus(r109, CollectionsKt.emptyList());
        w26.g r110 = (w26.g) x26.a.a(w26.g.class);
        if (r110 == null) goto L29;
        w26.e r111 = (w26.e) r110.n0(w26.e.class);
        if (r111 == null) goto L29;
        List<String> r112 = r111.g();
        if (r112 == null) goto L29;
    L30:
        f41402c = CollectionsKt.plus(r112, CollectionsKt.emptyList());
        w26.g r113 = (w26.g) x26.a.a(w26.g.class);
        if (r113 == null) goto L37;
        w26.e r114 = (w26.e) r113.n0(w26.e.class);
        if (r114 == null) goto L37;
        List<String> r115 = r114.c();
        if (r115 == null) goto L37;
    L38:
        f41403d = CollectionsKt.plus(r115, CollectionsKt.emptyList());
        boolean r116 = false;
        if (r102 != null) goto L41;
    L43:
        boolean r117 = false;
    L44:
        if (r117 == false) goto L55;
        w26.g r118 = (w26.g) x26.a.a(w26.g.class);
        if (r118 == null) goto L52;
        w26.e r119 = (w26.e) r118.n0(w26.e.class);
        if (r119 == null) goto L52;
        Boolean r120 = r119.W();
        if (r120 == null) goto L52;
        boolean r121 = r120.booleanValue();
    L53:
        if (r121 == false) goto L55;
        r116 = true;
    L52:
        r121 = true;
    L55:
        f41404e = r116;
        return;
    L41:
        if (r102.B0 != true) goto L43;
        r117 = true;
    L37:
        r115 = new ArrayList();
    L29:
        r112 = new ArrayList();
    L21:
        r109 = new ArrayList();
    L13:
        r106 = new ArrayList();
        goto L14
    L5:
        r102 = null;
        goto L6
    }

    public static final boolean a(String r100) {
        if (Intrinsics.areEqual(r100, BytedCertConstant.CertKey.FLOW) == false) goto L14;
        Map<String, Map<Class<?>, Object>> r101 = x26.a.f562251a;
        w26.g r102 = (w26.g) x26.a.a(w26.g.class);
        if (r102 == null) goto L11;
        w26.e r103 = (w26.e) r102.n0(w26.e.class);
        if (r103 == null) goto L11;
        Boolean r104 = r103.S();
        if (r104 == null) goto L11;
        boolean r105 = r104.booleanValue();
    L12:
        if (r105 == false) goto L14;
        return true;
    L11:
        r105 = true;
    L14:
        return false;
    }

    public static final String getType(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        String r101 = r100.getScheme();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r103 = r100.getAuthority();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        String r104 = r100.getPath();
        if (r104 == null) goto L13;
        r102 = r104;
    L13:
        if (Intrinsics.areEqual(r101, "http") == false) goto L15;
        return "_unknown";
    L15:
        if (Intrinsics.areEqual(r101, "https") == false) goto L18;
        return "_unknown";
    L18:
        if (StringsKt.endsWith$default(r103, "_popup", false, 2, null) == false) goto L21;
    L39:
        return "_popup";
    L21:
        if (StringsKt.endsWith$default(r103, "_page", false, 2, null) == true) goto L37;
        if (Intrinsics.areEqual(r103, ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == true) goto L37;
        if (Intrinsics.areEqual(r103, "webview") == true) goto L37;
        if (StringsKt.endsWith$default(r102, "_popup", false, 2, null) == true) goto L39;
        if (StringsKt.endsWith$default(r102, "_page", false, 2, null) == true) goto L37;
        if (Intrinsics.areEqual(r102, ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == true) goto L37;
        if (Intrinsics.areEqual(r102, "webview") == true) goto L37;
        return "_unknown";
    L37:
        return "_page";
    }

    public static final boolean b(h r100, Uri r101, boolean r102, List<String> r103, List<String> r104, String r105) {
        if (r102 == true) goto L5;
        return false;
    L5:
        String r106 = a36.b.a(r101, "default_bid");
        if (r106 != null) goto L8;
        r106 = r101.toString();
    L8:
        Iterator<T> r107 = r103.iterator();
    L10:
        if (r107.hasNext() == false) goto L15;
        if (StringsKt.contains$default(r106, (String) r107.next(), false, 2, null) == false) goto L10;
        return false;
    L15:
        if (Intrinsics.areEqual(r100.f41411a, r105) == false) goto L17;
        return true;
    L17:
        Iterator<T> r108 = r104.iterator();
    L19:
        if (r108.hasNext() == false) goto L24;
        if (StringsKt.contains$default(r106, (String) r108.next(), false, 2, null) == false) goto L19;
        r100.f41411a = r105;
        return true;
    L24:
        return false;
    }
}
