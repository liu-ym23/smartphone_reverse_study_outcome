package com.amap.api.mapcore.util;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class b8 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b8 f27075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final /* synthetic */ boolean f27076e = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Map<String, List<String>>> f27077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, List<String>> f27078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f27079c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f27080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f27081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f27082c;

        public a(URL r100) {
            this.f27080a = r100.getProtocol();
            this.f27081b = r100.getHost();
            this.f27082c = r100.getPath();
        }

        public a(String r100, String r101) {
            this.f27080a = null;
            this.f27081b = r100;
            this.f27082c = r101;
        }
    }

    static {
        f27076e = true;
    }

    public static synchronized b8 a() {
        monitor-enter(b8.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f27075d != null) goto L7;
        f27075d = new b8();     // Catch: Throwable -> L10
    L7:
        b8 r100 = f27075d;     // Catch: Throwable -> L10
        monitor-exit(b8.class);
        return r100;
    }

    public b8() {
        this.f27077a = new HashMap();
        this.f27078b = new HashMap();
        this.f27079c = new ArrayList();
    }

    public boolean a(String r100) {
        if (r100 != null) goto L5;
    L99:
        return false;
    L5:
        if (r100.length() == 0) goto L99;
        a r101 = null;
        a r102 = new a(new URL(r100));     // Catch: MalformedURLException -> L10
    L33:
        if (r102 == null) goto L48;
        String r103 = r102.f27082c;
        if (r103 != null) goto L39;
    L47:
        r101 = r102;
        goto L48
    L39:
        if (r103.length() == 0) goto L47;
    L41:
        String r104 = r102.f27082c;
        if (r104.charAt(r104.length() - 1) != '/') goto L45;
        String r105 = r102.f27082c;
        r102.f27082c = r105.substring(0, r105.length() - 1);
    L45:
        if (r102.f27082c.charAt(0) != '/') goto L47;
        r102.f27082c = r102.f27082c.substring(1);
    L48:
        if (r101 != null) goto L50;
        return false;
    L50:
        monitor-enter(this);
    L96:
        th = move-exception;
        throw th;
    L52:
        if (r101.f27082c.length() == 0) goto L94;
        Map<String, List<String>> r106 = this.f27078b;     // Catch: Throwable -> L96
        String r107 = r101.f27080a;     // Catch: Throwable -> L96
        if (r107 != null) goto L57;
    L59:
        List<String> r108 = this.f27079c;     // Catch: Throwable -> L96
        boolean r109 = f27076e;     // Catch: Throwable -> L96
        if (r109 == true) goto L65;
        if (r106 != null) goto L65;
        throw new AssertionError();     // Catch: Throwable -> L96
    L65:
        String r110 = r101.f27081b;     // Catch: Throwable -> L96
        if (r110 != null) goto L68;
    L70:
        if (r109 == true) goto L75;
        if (r108 != null) goto L75;
        throw new AssertionError();     // Catch: Throwable -> L96
    L75:
        Iterator<String> r111 = r108.iterator();     // Catch: Throwable -> L96
    L77:
        if (r111.hasNext() == false) goto L94;
        String r112 = r111.next();     // Catch: Throwable -> L96
        String r113 = r101.f27082c;     // Catch: Throwable -> L96
        String[] r114 = r112.split(HTTP.URL_DEFAULT);     // Catch: Throwable -> L96
        String[] r115 = r113.split(HTTP.URL_DEFAULT);     // Catch: Throwable -> L96
        if (r115.length < r114.length) goto L88;
        int r116 = 0;
    L83:
        if (r116 >= r114.length) goto L90;
        if (r114[r116].equals("*") == true) goto L89;
        if (r114[r116].equals(r115[r116]) == false) goto L88;
    L89:
        r116 = r116 + 1;
        goto L83
    L90:
        boolean r117 = true;
    L91:
        if (r117 == false) goto L77;
        monitor-exit(this);
        return true;
    L88:
        r117 = false;
        goto L91
    L68:
        if (r106.containsKey(r110) == false) goto L70;
        r108 = r106.get(r101.f27081b);     // Catch: Throwable -> L96
        goto L70
    L57:
        if (this.f27077a.containsKey(r107) == false) goto L59;
        r106 = this.f27077a.get(r101.f27080a);     // Catch: Throwable -> L96
    L94:
        monitor-exit(this);
        return false;
    L11:
        if (r100.contains("://") == false) goto L14;
        r102 = null;
    L14:
        if (r100.startsWith(HTTP.URL_DEFAULT) == false) goto L16;
        r100 = r100.substring(1);
        goto L14
    L16:
        String[] r118 = r100.split(HTTP.URL_DEFAULT);
        if (r118[0].contains(".") == false) goto L19;
        String r119 = r118[0];
        int r120 = 1;
    L20:
        StringBuilder r121 = new StringBuilder();
    L22:
        if (r120 >= r118.length) goto L28;
        if (r121.length() <= 0) goto L26;
        r121.append(HTTP.URL_DEFAULT);
    L26:
        r121.append(r118[r120]);
        r120 = r120 + 1;
        goto L22
    L28:
        if (r121.length() > 0) goto L30;
    L32:
        r102 = new a(r119, r121.toString());
        goto L33
    L30:
        if (r121.charAt(r121.length() - 1) != '/') goto L32;
        r121.deleteCharAt(r121.length() - 1);
        goto L32
    L19:
        r119 = null;
        r120 = 0;
        goto L20
    }
}
