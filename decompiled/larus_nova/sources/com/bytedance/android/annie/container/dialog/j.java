package com.bytedance.android.annie.container.dialog;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class j {
    static {
    }

    @JvmStatic
    public static final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        List<String> r101 = AnnieConfigSettingKeys.LIVE_NEW_PANEL_ALLOW_LIST.a();
        if ((!r101.isEmpty()) == false) goto L25;
        Iterator<String> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L25;
        String r103 = r102.next();
        if (StringsKt.startsWith$default(r103, "http", false, 2, null) == true) goto L10;
        r103 = "http://" + r103;
    L10:
        Uri r104 = UriProtector.parse(r103);
        if (r104 == null) goto L6;
        if (r104.getPath() == null) goto L6;
        if (r104.getHost() == null) goto L6;
        if (TextUtils.isEmpty(r104.getPath()) == true) goto L21;
        String r105 = r104.getPath();
        Intrinsics.checkNotNull(r105);
        if (StringsKt.contains$default(r100, r105, false, 2, null) == false) goto L6;
    L21:
        if (TextUtils.isEmpty(r104.getHost()) == true) goto L41;
        String r106 = r104.getHost();
        Intrinsics.checkNotNull(r106);
        if (StringsKt.contains$default(r100, r106, false, 2, null) == false) goto L6;
        return true;
    L41:
        return true;
    L25:
        return false;
    }
}
