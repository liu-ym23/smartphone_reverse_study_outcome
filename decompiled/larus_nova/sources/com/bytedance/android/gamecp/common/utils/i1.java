package com.bytedance.android.gamecp.common.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes44.dex */
public final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Typeface> f57228a = null;

    static {
        f57228a = new HashMap();
    }

    public static Typeface a(Context r100) {
        Typeface r101 = b(r100, "fonts/ByteNumber-Bold.ttf");
        if (r101 == null) goto L6;
        return r101;
    L6:
        return b(r100, "fonts/DIN_Alternate.ttf");
    }

    public static Typeface b(Context r100, String r101) {
        Typeface r102 = null;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        HashMap<String, Typeface> r103 = f57228a;
        if (r103.containsKey(r101) == true) goto L14;
        if (r100 == null) goto L14;
        r102 = Typeface.createFromAsset(r100.getApplicationContext().getAssets(), r101);     // Catch: Throwable -> L10
    L12:
        f57228a.put(r101, r102);
        return r102;
    L10:
        th = move-exception;
        th.printStackTrace();
    L14:
        return r103.get(r101);
    }
}
