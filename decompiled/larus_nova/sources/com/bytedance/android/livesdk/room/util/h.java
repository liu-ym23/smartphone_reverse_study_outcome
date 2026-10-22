package com.bytedance.android.livesdk.room.util;

import android.text.TextUtils;
import com.bytedance.android.livesdk.config.ac;
import com.bytedance.common.utility.collection.CollectionUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f157835a = null;

    static {
        f157835a = (List) ac.f119777a.getValue();
    }

    public static boolean a(String r100, String r101, String r102) {
        List<String> r103 = f157835a;
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L28:
        boolean r104 = false;
    L29:
        if (r104 == false) goto L31;
    L38:
        return true;
    L31:
        if (TextUtils.isEmpty(r100) == false) goto L34;
    L32:
        boolean r105 = false;
    L37:
        if (r105 == false) goto L38;
        return false;
    L34:
        if (TextUtils.equals(r100, "0") == true) goto L32;
        r105 = true;
        goto L37
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L28;
        if (CollectionUtils.isEmpty(r103) == true) goto L28;
        String r106 = r101 + "-" + r102;
        Iterator<String> r107 = r103.iterator();
    L11:
        if (r107.hasNext() == false) goto L28;
        String r108 = r107.next();
        if ("*".equals(r108) == true) goto L27;
        if (r106.equals(r108) == true) goto L27;
        if (r108.startsWith("*") == false) goto L24;
        if (r106.endsWith(r108.replace("*", "")) == true) goto L27;
    L24:
        if (r108.endsWith("*") == false) goto L11;
        if (r106.startsWith(r108.replace("*", "")) == false) goto L11;
    L27:
        r104 = true;
        goto L29
    }
}
