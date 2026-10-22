package com.bytedance.android.ecom.bcm.track.impl.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f51158a = 0;

    static {
    }

    public static String a(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L13;
        return "";
    L13:
        if (StringsKt.startsWith$default(r110, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, false, 2, null) == true) goto L15;
        return "";
    L15:
        List r111 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
        if (r111.size() >= 2) goto L19;
        return "";
    L19:
        return ((String) ListProtector.get(r111, 0)) + "." + ((String) ListProtector.get(r111, 1));
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L10
    }

    public static String b(String r100) {
        if (r100 != null) goto L5;
        r100 = null;
    L8:
        if (r100 == null) goto L13;
        List r101 = StringsKt.split$default(r100, new String[]{"_i"}, false, 0, 6, null);
        if ((true ^ r101.isEmpty()) == true) goto L12;
        return r100;
    L12:
        return (String) ListProtector.get(r101, 0);
    L13:
        return "";
    L5:
        List r102 = StringsKt.split$default(r100, new String[]{"."}, false, 0, 6, null);
        if (r102.size() <= 4) goto L8;
        r100 = ((String) ListProtector.get(r102, 0)) + "." + ((String) ListProtector.get(r102, 1)) + "." + ((String) ListProtector.get(r102, 2)) + "." + ((String) ListProtector.get(r102, 3));
        goto L8
    }
}
