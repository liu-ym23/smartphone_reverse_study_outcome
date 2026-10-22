package com.bytedance.crash.runtime;

import android.text.TextUtils;
import com.bytedance.crash.o.r;
import org.json.JSONArray;

/* JADX INFO: compiled from: AllDefaultUrls.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7741a = "https://mon.zijieapi.com";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f7742b = "http";

    static {
    }

    public static void a(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        r.b("setDomainName:" + r3);
        if (r3.startsWith(f7742b) == true) goto L8;
        f7741a = "https://" + r3;
    L9:
        r.b("setDomainName:" + f7741a);
        return;
    L8:
        f7741a = r3;
        goto L9
    }

    public static void a(String r3, JSONArray r4) {
        if (TextUtils.isEmpty(r3) == true) goto L24;
        if (r4 == null) goto L24;
        if (r4.length() == 0) goto L24;
        if (r3.equals(f7741a) == false) goto L12;
        r.b("setDomainName: same domain");
        return;
    L12:
        boolean r0 = false;
        int r1 = 0;
    L14:
        if (r1 >= r4.length()) goto L19;
        if (r3.equals(r4.optString(r1)) == true) goto L17;
        r1 = r1 + 1;
        goto L14
    L17:
        r0 = true;
    L19:
        if (r0 == true) goto L22;
        r.b("setDomainName: check valid fail");
        return;
    L22:
        r.b("setDomainName begin:" + r3);
        f7741a = r3;
        return;
    L24:
        r.b("setDomainName: invalid param");
    }

    public static String a() {
        return f7741a;
    }
}
