package com.bytedance.android.alog;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: FileManager.java */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f4097a = 9;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f4098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f4099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ArrayList<String> f4100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f4101e;

    static {
    }

    static File[] a(String r9, String r10, String r11, final long r12, final long r14) {
        f4098b = r12;
        f4099c = r14;
        f4101e = null;
        f4100d = null;
        if (r12 <= r14) goto L6;
        f4101e = "time interval is invalid";
        return new File[0];
    L6:
        File r0 = new File(r9);
        if (r0.exists() == true) goto L9;
    L30:
        f4101e = "log dir not exists";
        return new File[0];
    L9:
        if (r0.isDirectory() == false) goto L30;
        if (TextUtils.isEmpty(r10) == true) goto L14;
        r10 = r10.replace(':', '-');
    L14:
        StringBuilder r13 = new StringBuilder().append("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__");
        String r3 = "\\S+";
        if (TextUtils.isEmpty(r10) == false) goto L17;
        String r15 = "\\S+";
    L18:
        StringBuilder r16 = r13.append(r15).append("__");
        if (TextUtils.isEmpty(r11) == true) goto L22;
        r3 = Pattern.quote(r11);
    L22:
        final Pattern r4 = Pattern.compile(r16.append(r3).append("\\.alog\\.hot$").toString());
        final ArrayList<String> r17 = new ArrayList();
        File[] r18 = r0.listFiles(new AnonymousClass1(r17, r4, r14, r12));
        if (r18 != null) goto L25;
    L26:
        f4101e = "log file not found";
        f4100d = r17;
    L27:
        if (r18 == null) goto L29;
        return r18;
    L29:
        return new File[0];
    L25:
        if (r18.length != 0) goto L27;
    L17:
        r15 = Pattern.quote(r10);
        goto L18
    }

    static HashMap<String, String> a() {
        HashMap<String, String> r0 = new HashMap();
        r0.put("start", Long.toString(f4098b));
        r0.put("end", Long.toString(f4099c));
        r0.put("reason", f4101e);
        if (f4100d == null) goto L12;
        StringBuilder r1 = new StringBuilder();
        Iterator<String> r2 = f4100d.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
        if (r3.endsWith(".alog.hot") == false) goto L10;
        r3 = r3.substring(0, r3.length() - f4097a);
    L10:
        r1.append(r3).append(";");
        goto L6
    L11:
        r0.put("file", r1.toString());
    L12:
        f4101e = null;
        f4100d = null;
        return r0;
    }
}
