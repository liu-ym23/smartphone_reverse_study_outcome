package com.bytedance.android.btm.impl.util;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class BtmFormatUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f42489a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f42490b = null;

    static {
        f42489a = LazyKt.lazy(BtmFormatUtils$pageBtmPattern$2.INSTANCE);
        f42490b = new Regex("_[ikl][${index}0-9]*");
    }

    public static String a(final String r110) {
        ALogger r100 = ALogger.f41996d;
        Function0<String> r101 = new BtmFormatUtils$format$1(r110);
        r100.getClass();
        com.bytedance.android.btm.api.inner.b r102 = (com.bytedance.android.btm.api.inner.b) ALogger.f41995c.getValue(r100, ALogger.f41993a[0]);
        if (r102 == null) goto L5;
        r102.a("BTMSDK_BTM_utils_BtmFormatUtil_format", r101);
    L5:
        List r103 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
        if (r103.size() != 5) goto L9;
        return r110;
    L9:
        if (r103.size() >= 2) goto L11;
    L27:
        StringBuilder r104 = new StringBuilder();
        r104.append(r110);
        StringBuilder r111 = new StringBuilder(".e");
        AtomicLong r105 = e.f42500a;
        r111.append(UUID.randomUUID().toString());
        r104.append(r111.toString());
        return r104.toString();
    L11:
        if (r103.size() != 2) goto L16;
        if (StringsKt.startsWith$default((String) ListProtector.get(r103, 0), BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, false, 2, null) == false) goto L16;
        r110 = (r110 + ".c0") + ".d0";
    L16:
        if (r103.size() != 3) goto L21;
        if (StringsKt.startsWith$default((String) ListProtector.get(r103, 0), BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, false, 2, null) == false) goto L21;
        r110 = r110 + ".d0";
    L21:
        if (r103.size() != 4) goto L25;
        if (StringsKt.startsWith$default((String) ListProtector.get(r103, 0), BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, false, 2, null) == true) goto L27;
    L25:
        if (StringsKt.startsWith$default((String) ListProtector.get(r103, 0), "c", false, 2, null) == false) goto L27;
        r110 = BtmHostDependManager.F.d() + ".b0." + r110;
        goto L27
    }

    public static String b(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L12;
        return "";
    L12:
        List r111 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
        if (r111.size() >= 2) goto L16;
        return "";
    L16:
        return ((String) ListProtector.get(r111, 0)) + "." + ((String) ListProtector.get(r111, 1));
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L10
    }

    public static String c(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L12;
        return "";
    L12:
        List r111 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
        if (r111.size() >= 2) goto L16;
        return "";
    L16:
        return ((String) ListProtector.get(r111, 0)) + "." + ((String) ListProtector.get(r111, 1)) + ".c0.d0";
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L10
    }

    public static String d(String r100) {
        if (r100 != null) goto L5;
    L18:
        return null;
    L5:
        if (StringsKt.startsWith$default(r100, "aUnknown.", false, 2, null) != true) goto L18;
        List r101 = StringsKt.split$default(r100, new String[]{"."}, false, 0, 6, null);
        if (r101.size() > 1) goto L9;
        return "error";
    L9:
        if (((String) ListProtector.get(r101, 1)).length() <= 1) goto L19;
        String r102 = (String) ListProtector.get(r101, 1);
        if (r102 == null) goto L15;
        return r102.substring(1);
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        return "error";
    }

    public static String e(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return null;
    L11:
        String r102 = g(r100);
        if (Intrinsics.areEqual(r102, g("a0.b0.c0.d0")) == false) goto L14;
        return null;
    L14:
        return r102;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L9
    }

    public static String g(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        List r101 = StringsKt.split$default(r100, new String[]{"."}, false, 0, 6, null);
        if (r101.size() > 4) goto L8;
        return r100;
    L8:
        return ((String) ListProtector.get(r101, 0)) + "." + ((String) ListProtector.get(r101, 1)) + "." + ((String) ListProtector.get(r101, 2)) + "." + ((String) ListProtector.get(r101, 3));
    }

    public static String h(String r100) {
        String r101 = g(r100);
        if (r101 == null) goto L8;
        List r102 = StringsKt.split$default(r101, new String[]{"_i"}, false, 0, 6, null);
        if ((!r102.isEmpty()) == true) goto L7;
        return r101;
    L7:
        return (String) ListProtector.get(r102, 0);
    L8:
        return null;
    }

    public static boolean f(String r110, String r111) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L26;
        if (r111 != null) goto L12;
    L15:
        boolean r101 = true;
    L16:
        if (r101 == true) goto L26;
        List r112 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
        List r102 = StringsKt.split$default(r111, new String[]{"."}, false, 0, 6, null);
        r112.size();
        if (r102.size() != 1) goto L25;
        if (StringsKt.startsWith$default(r111, "b", false, 2, null) == false) goto L25;
        return Intrinsics.areEqual((String) ListProtector.get(r112, 1), (String) ListProtector.get(r102, 0));
    L25:
        return Intrinsics.areEqual((String) ListProtector.get(r112, 1), (String) ListProtector.get(r102, 1));
    L12:
        if (r111.length() == 0) goto L15;
        r101 = false;
    L26:
        return false;
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L9
    }
}
