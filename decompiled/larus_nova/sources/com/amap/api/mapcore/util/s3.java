package com.amap.api.mapcore.util;

import androidx.collection.SieveCacheKt;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: loaded from: classes28.dex */
public class s3 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f27955a;

        public int a(int r100) {
            return (int) (((((long) r100) * ((long) 1103515245)) + ((long) 12345)) & SieveCacheKt.NodeLinkMask);
        }

        public a(String r100, int r101) {
            this.f27955a = a(r100, r101, r100.length());
        }

        public String a(int r100, String r101) {
            StringBuilder r102 = new StringBuilder();
            int r103 = this.f27955a.length();
            int r104 = r101.length();
            int r105 = 0;
        L3:
            if (r105 >= r104) goto L9;
            char r106 = r101.charAt(r105);
            this.f27955a.getClass();
            int r107 = this.f27955a.indexOf(r106);
            if (r107 < 0) goto L9;
            this.f27955a.getClass();
            String r108 = this.f27955a;
            r102.append(r108.charAt(((r107 + r100) + r105) % r103));
            r105 = r105 + 1;
        L9:
            if (r102.length() == r104) goto L15;
            return null;
        L15:
            return r102.toString();
        }

        public String a(String r100, int r101, int r102) {
            StringBuffer r103 = new StringBuffer(r100);
            int r104 = r100.length();
            int r105 = 0;
        L3:
            if (r105 >= r102) goto L6;
            int r106 = a(r101);
            int r107 = r106 % r104;
            r101 = a(r106);
            int r108 = r101 % r104;
            char r109 = r103.charAt(r107);
            r103.setCharAt(r107, r103.charAt(r108));
            r103.setCharAt(r108, r109);
            r105 = r105 + 1;
            goto L3
        L6:
            return r103.toString();
        }
    }

    public static String a() {
        Random r100 = new Random();
        int r101 = r100.nextInt(10);
        Locale r102 = Locale.US;
        String r103 = String.format(r102, "%05d", new Object[]{Integer.valueOf(r101)});
        int r104 = r100.nextInt(10);
        int r105 = r100.nextInt(100);
        return new a("0123456789", r105).a(r104, r103) + String.format(r102, "%01d", new Object[]{Integer.valueOf(r104)}) + String.format(r102, "%02d", new Object[]{Integer.valueOf(r105)});
    }
}
