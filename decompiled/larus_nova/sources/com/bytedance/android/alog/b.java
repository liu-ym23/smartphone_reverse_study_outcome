package com.bytedance.android.alog;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f38370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f38371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ArrayList<String> f38372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f38373d;

    /* JADX INFO: loaded from: classes43.dex */
    public static class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f38374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Pattern f38375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f38376c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f38377d;

        @Override // java.io.FilenameFilter
        public final boolean accept(File r110, String r111) {
            this.f38374a.add(r111);
            Matcher r100 = this.f38375b.matcher(r111);
            if (r100.find() == true) goto L5;
        L21:
            return false;
        L5:
            if (r100.groupCount() != 1) goto L21;
            String r101 = r100.group(1);
            if (r101 != null) goto L10;
            return false;
        L10:
            long r102 = CastLongProtector.parseLong(r101);
            if (r102 <= 0) goto L21;
            if (r102 > this.f38376c) goto L21;
            long r112 = new PolarisFileWrapper(r110, r111).lastModified();
            if (r112 <= 0) goto L21;
            if (r112 < this.f38377d) goto L21;
            return true;
        }

        public a(ArrayList r100, Pattern r101, long r102, long r103) {
            this.f38374a = r100;
            this.f38375b = r101;
            this.f38376c = r102;
            this.f38377d = r103;
        }
    }

    public static File[] a(String r100, String r110, String r111, long r112, long r113) {
        f38370a = r112;
        f38371b = r113;
        f38373d = null;
        f38372c = null;
        if (r112 <= r113) goto L6;
        f38373d = "time interval is invalid";
        return new File[0];
    L6:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L9;
    L30:
        f38373d = "log dir not exists";
        return new File[0];
    L9:
        if (r101.isDirectory() == false) goto L30;
        if (TextUtils.isEmpty(r110) == true) goto L14;
        r110 = r110.replace(':', '-');
    L14:
        StringBuilder r102 = new StringBuilder("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__");
        String r103 = "\\S+";
        if (TextUtils.isEmpty(r110) == false) goto L17;
        String r114 = "\\S+";
    L18:
        r102.append(r114);
        r102.append("__");
        if (TextUtils.isEmpty(r111) == true) goto L22;
        r103 = Pattern.quote(r111);
    L22:
        r102.append(r103);
        r102.append("\\.alog\\.hot$");
        Pattern r104 = PatternProtector.compile(r102.toString());
        ArrayList<String> r105 = new ArrayList();
        File[] r115 = r101.listFiles(new a(r105, r104, r113, r112));
        if (r115 != null) goto L25;
    L26:
        f38373d = "log file not found";
        f38372c = r105;
    L27:
        if (r115 == null) goto L29;
        return r115;
    L29:
        return new File[0];
    L25:
        if (r115.length != 0) goto L27;
    L17:
        r114 = Pattern.quote(r110);
        goto L18
    }
}
