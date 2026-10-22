package com.apm.insight.log.a;

import android.text.TextUtils;
import com.stepos.agentframework.adapter.bff.BffConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2189a = 9;
    private static long b;
    private static long c;
    private static ArrayList<String> d;
    private static String e;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public File f2190a;
        public long b;

        public a(File file, long j5) {
            this.f2190a = file;
            this.b = j5;
        }
    }

    public static File[] a(String str, String str2, String str3, long j5, long j6, int i) {
        b = j5;
        c = j6;
        e = null;
        d = null;
        if (j5 > j6) {
            e = "time interval is invalid";
            return new File[0];
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            e = "log dir not exists";
            return new File[0];
        }
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replace(':', '-');
        }
        StringBuilder sb = new StringBuilder("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__");
        sb.append(TextUtils.isEmpty(str2) ? "\\S+" : Pattern.quote(str2));
        sb.append("__");
        sb.append(TextUtils.isEmpty(str3) ? "\\S+" : Pattern.quote(str3));
        sb.append("\\.vlog$");
        Pattern patternCompile = Pattern.compile(sb.toString());
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList arrayList2 = i > 0 ? new ArrayList() : null;
        File[] fileArrListFiles = file.listFiles(new c(arrayList, patternCompile, j6, j5, arrayList2));
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            e = "log file not found";
            d = arrayList;
        }
        if (i <= 0) {
            return fileArrListFiles == null ? new File[0] : fileArrListFiles;
        }
        Collections.sort(arrayList2, new d());
        int iMin = Math.min(i, arrayList2.size());
        File[] fileArr = new File[iMin];
        for (int i6 = 0; i6 < iMin; i6++) {
            fileArr[i6] = ((a) arrayList2.get(i6)).f2190a;
        }
        return fileArr;
    }

    public static HashMap<String, String> a() {
        HashMap<String, String> map = new HashMap<>();
        map.put("start", Long.toString(b));
        map.put("end", Long.toString(c));
        map.put("reason", e);
        if (d != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.endsWith(".alog.hot")) {
                    next = next.substring(0, next.length() - f2189a);
                }
                sb.append(next);
                sb.append(";");
            }
            map.put(BffConstant.Type.File, sb.toString());
        }
        e = null;
        d = null;
        return map;
    }
}
