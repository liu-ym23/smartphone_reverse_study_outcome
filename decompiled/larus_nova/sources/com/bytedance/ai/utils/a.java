package com.bytedance.ai.utils;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f37625a = 0;

    /* JADX INFO: renamed from: com.bytedance.ai.utils.a$a, reason: collision with other inner class name */
    public static final class C0714a {
        public static String a() {
            h2.a r100 = f2.b.f475099c;
            boolean r101 = false;
            if (r100 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == true) goto L16;
            if (r100 != null) goto L11;
        L13:
            if (r101 == true) goto L16;
            return "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source";
        L11:
            if (r100.f483577p != true) goto L13;
            r101 = true;
        L16:
            return "https://tosv.byted.org/obj/gecko-internal";
        L5:
            if (r100.f483575n != true) goto L7;
            r102 = true;
            goto L8
        }

        public static boolean b() {
            h2.a r100 = f2.b.f475099c;
            if (r100 != null) goto L5;
        L7:
            boolean r101 = false;
        L8:
            if (r101 == true) goto L15;
            if (r100 != null) goto L11;
        L13:
            boolean r102 = false;
        L14:
            if (r102 == true) goto L15;
            return false;
        L11:
            if (r100.f483577p != true) goto L13;
            r102 = true;
        L15:
            return true;
        L5:
            if (r100.f483575n != true) goto L7;
            r101 = true;
            goto L8
        }
    }

    static {
    }
}
