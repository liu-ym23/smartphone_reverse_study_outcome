package com.bytedanceos.common.toolbox;

import android.text.TextUtils;
import com.bytedanceos.common.model.AppInfo;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f0 {
    public static void a(List r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator r12 = r10.iterator();
        int r13 = 0;
    L6:
        if (r12.hasNext() == false) goto L13;
        AppInfo r14 = (AppInfo) r12.next();
        r13 = r13 + 1;
        String r15 = "&position=" + r11 + "-" + r13;
        if (TextUtils.isEmpty(r14.mJsonData) == true) goto L6;
        r14.mJsonData = c9.a.Q(new JSONObject(r14.mJsonData), r15);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public static void b(List r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L13;
        AppInfo r13 = (AppInfo) r12.next();
        r11 = r11 + 1;
        String r14 = "&position=" + r11;
        r13.appDownloadUrl += r14;
        if (TextUtils.isEmpty(r13.mJsonData) == true) goto L6;
        r13.mJsonData = c9.a.Q(new JSONObject(r13.mJsonData), r14);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public static String c(String r10, int r11) {
        return "&position=" + r10 + "-" + r11;
    }

    public static String d(int r10) {
        return String.valueOf(r10 + 1);
    }

    public static String e(int r10) {
        if (r10 != 0) goto L6;
        return "2";
    L6:
        if (r10 != 1) goto L10;
        return "3";
    L10:
        if (r10 != 2) goto L13;
        return "4";
    L13:
        return "2";
    }
}
