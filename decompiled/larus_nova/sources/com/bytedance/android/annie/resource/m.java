package com.bytedance.android.annie.resource;

import com.bytedance.android.annie.Annie;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.File;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class m {
    static {
    }

    @JvmStatic
    public static final String b() {
        if (com.bytedance.android.annie.ng.g.f39675g == true) goto L5;
        return EffectConstants.CHANNEL_TEST;
    L5:
        String r100 = com.bytedance.android.annie.ng.g.b().f39658b.f522317b;
        if (r100 == null) goto L9;
        StringsKt.isBlank(r100);
        return r100;
    L9:
        return EffectConstants.CHANNEL_TEST;
    }

    @JvmStatic
    public static final String c() {
        String r100 = null;
        String r101 = ((f9.b) Annie.getService$default(f9.b.class, null, 2, null)).getHostGeckoCacheDir();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return r101;
    L11:
        StringBuilder r103 = new StringBuilder();
        File r104 = com.bytedance.android.annie.ng.g.a().getFilesDir();
        if (r104 == null) goto L14;
        r100 = r104.getAbsolutePath();
    L14:
        r103.append(r100);
        r103.append(File.separator);
        r103.append("offlineX");
        return r103.toString();
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    @JvmStatic
    public static final String a(g r100) {
        String r101 = "";
        if (r100 == null) goto L5;
        CharSequence r102 = "";
    L6:
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L18;
        if (r100 != null) goto L16;
        r101 = null;
    L16:
        Intrinsics.checkNotNull(r101);
        return r101;
    L18:
        Boolean r104 = o8.c.f522321c;
        Pair r105 = o8.c.a.b();
        boolean r106 = ((Boolean) r105.component1()).booleanValue();
        if (((Boolean) r105.component2()).booleanValue() == false) goto L21;
        return "68f927652a5370ec9f4ae1dbaf56fd85";
    L21:
        if (r106 == false) goto L23;
        return "36723dc3e85a23e701d1697d57de07ed";
    L23:
        return "5fb33cde3ebff01c8433ddc22aac0816";
    L8:
        if (StringsKt.isBlank(r102) == true) goto L11;
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
