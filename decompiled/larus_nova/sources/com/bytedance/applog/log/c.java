package com.bytedance.applog.log;

import com.bytedance.android.ec.slice.SliceInitService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, i> f192456c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f192457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f192458b;

    static {
        f192456c = new ConcurrentHashMap();
    }

    public c() {
        ArrayList r100 = new ArrayList();
        this.f192458b = r100;
        r100.add("logger@" + hashCode());
    }

    public static String u(String r100, Object... r101) {
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L30
        if (r101.length != 0) goto L5;
    L27:
        r102.append(r100);     // Catch: Throwable -> L30
    L28:
        return r102.toString();
    L5:
        if (r100.contains(SliceInitService.DEFAULT_SWITCH) == false) goto L27;
        int r103 = r100.length();     // Catch: Throwable -> L30
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r104 >= r103) goto L28;
        char r106 = r100.charAt(r104);     // Catch: Throwable -> L30
        if (r104 >= (r103 - 1)) goto L12;
        char r107 = r100.charAt(r104 + 1);     // Catch: Throwable -> L30
    L14:
        if (r106 == '{') goto L16;
    L25:
        r102.append(r106);     // Catch: Throwable -> L30
    L26:
        r104 = r104 + 1;     // Catch: Throwable -> L30
        goto L8
    L16:
        if (r107 != '}') goto L25;
        if (r105 >= r101.length) goto L24;
        int r108 = r105 + 1;     // Catch: Throwable -> L30
        Object r109 = r101[r105];     // Catch: Throwable -> L30
        if (r109 == null) goto L22;
        String r110 = r109.toString();     // Catch: Throwable -> L30
    L23:
        r102.append(r110);     // Catch: Throwable -> L30
        r105 = r108;
        goto L24
    L22:
        r110 = "";
    L24:
        r104 = r104 + 1;     // Catch: Throwable -> L30
        goto L26
    L12:
        r107 = ' ';
    L36:
        return r100;
    }

    public void v(int r100, int r101, List<String> r102, Throwable r103, String r110, Object... r111) {
        boolean r104 = true;
        if (l.f192477a.isEmpty() == true) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L10;
        return;
    L10:
        k r106 = new k();
        r106.f192475g = System.currentTimeMillis();
        r106.f192469a = this.f192457a;
        r106.f192472d = r100;
        r106.f192471c = r101;
        r106.f192470b = ThreadMethodProxy.currentThread().getName();
        r106.f192476h = r103;
        if (r102 != null) goto L13;
    L15:
        List<String> r107 = this.f192458b;
    L16:
        r106.f192473e = r107;
        r106.f192474f = u(r110, r111);
        l.a(r106);
        String r108 = this.f192457a;
        if (r108 != null) goto L19;
    L21:
        r104 = false;
    L22:
        if (r104 == false) goto L24;
        j r109 = (j) ((ConcurrentHashMap) l.f192478b).get(r108);
    L25:
        if (r109 == null) goto L28;
        r109.a(r106);
        return;
    L28:
        return;
    L24:
        r109 = null;
        goto L25
    L19:
        if (r108.isEmpty() == true) goto L21;
    L13:
        if (r102.size() <= 0) goto L15;
        ArrayList r112 = new ArrayList();
        r112.addAll(this.f192458b);
        r112.addAll(r102);
        r107 = r112;
        goto L16
    L5:
        if (((ConcurrentHashMap) l.f192478b).isEmpty() == false) goto L7;
        r105 = true;
        goto L8
    }
}
