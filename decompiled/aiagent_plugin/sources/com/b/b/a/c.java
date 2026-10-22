package com.b.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: Pinyin.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static org.a.b.c f3197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static j f3198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static List<h> f3199c;

    /* JADX INFO: renamed from: com.b.b.a.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: Pinyin.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: Pinyin.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        j f3200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<h> f3201b;

        /* synthetic */ a(List r2, AnonymousClass1 r3) {
            this((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"));
        }

        private a(List<h> r3) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L5;
            this.f3201b = new ArrayList(r4);
        L5:
            this.f3200a = new b();
        }

        public a a(h r3) {
            h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L10;
            List<h> r0 = this.f3201b;
            if (r0 != null) goto L8;
            ArrayList r1 = new ArrayList();
            this.f3201b = r1;
            r1.add(r4);
            goto L10
        L8:
            if (r0.contains(r4) == true) goto L10;
            this.f3201b.add(r4);
        L10:
            return this;
        }

        boolean a() {
            if (c() != null) goto L5;
        L7:
            return false;
        L5:
            if (b() == null) goto L7;
            return true;
        }

        j b() {
            return this.f3200a;
        }

        List<h> c() {
            return this.f3201b;
        }
    }

    static {
    }

    public static void a(a r1) {
        if (r1 != null) goto L6;
        f3199c = null;
        f3197a = null;
        f3198b = null;
        return;
    L6:
        if (r1.a() == true) goto L8;
        return;
    L8:
        f3199c = Collections.unmodifiableList(r1.c());
        f3197a = k.a(r1.c());
        f3198b = r1.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a a() {
        return new a(null, 0 == true ? 1 : 0);
    }

    public static String a(char r1) {
        if (b(r1) == false) goto L11;
        if (r1 != 12295) goto L9;
        return "LING";
    L9:
        return g.f3209b[c(r1)];
    L11:
        return String.valueOf(r1);
    }

    public static boolean b(char r1) {
        if (19968 > r1) goto L9;
        if (r1 > 40869) goto L9;
        if (c(r1) <= 0) goto L9;
    L10:
        return true;
    L9:
        if (12295 == r1) goto L10;
        return false;
    }

    private static int c(char r3) {
        int r4 = r3 - 19968;
        if (r4 < 0) goto L8;
        if (r4 >= 7000) goto L8;
        return a(d.f3202a, d.f3203b, r4);
    L8:
        if (7000 > r4) goto L13;
        if (r4 >= 14000) goto L13;
        return a(e.f3204a, e.f3205b, r4 - 7000);
    L13:
        return a(f.f3206a, f.f3207b, r4 - 14000);
    }

    private static short a(byte[] r2, byte[] r3, int r4) {
        int r1 = r4 % 8;
        short r5 = (short) (r3[r4] & 255);
        if ((r2[r4 / 8] & g.f3208a[r1]) != 0) goto L5;
        return r5;
    L5:
        return (short) (r5 | 256);
    }
}
