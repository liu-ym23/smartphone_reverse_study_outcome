package com.bytedance.android.annie.util;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    public static void a(String r100) {
        Application r101 = com.bytedance.android.annie.ng.g.f39669a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        Toast r102 = Toast.makeText(r101, r100, 0);
        r102.setGravity(17, 0, 0);
        r102.show();
        return;
    }

    public static void b(Context r100, int r101) {
        if (r100 != null) goto L4;
        r100 = com.bytedance.android.annie.ng.g.f39669a;
    L4:
        if (r100 == null) goto L11;
        String r102 = r100.getString(r101);
        if (TextUtils.isEmpty(r102) == true) goto L12;
        Toast.makeText(r100, r102, 0).show();
        return;
    L12:
        return;
    }
}
