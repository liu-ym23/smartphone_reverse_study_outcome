package com.bytedance.android.live.soloktv.util;

import com.bytedance.android.livesdk.config.jh1;
import com.bytedance.android.livesdk.config.kh1;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<jh1> f101618a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f101619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f101620c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f101621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f101622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f101623f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f101624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f101625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f101626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f101627d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f101624a, r101.f101624a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f101625b, r101.f101625b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f101626c, r101.f101626c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f101627d, r101.f101627d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f101624a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f101625b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f101626c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f101627d;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "PublishContentData(authorName=" + this.f101624a + ", songId=" + this.f101625b + ", songName=" + this.f101626c + ", uid=" + this.f101627d + ")";
        }

        public a(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "authorName");
            Intrinsics.checkNotNullParameter(r101, "songId");
            Intrinsics.checkNotNullParameter(r102, "songName");
            Intrinsics.checkNotNullParameter(r103, "uid");
            this.f101624a = r100;
            this.f101625b = r101;
            this.f101626c = r102;
            this.f101627d = r103;
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f101628a = null;

            static {
                f101628a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.soloktv.util.l$b$b, reason: collision with other inner class name */
        public static final class C1546b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1546b f101629a = null;

            static {
                f101629a = new C1546b();
            }

            public C1546b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f101630a = null;

            static {
                f101630a = new c();
            }

            public c() {
            }
        }

        public static final class d extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f101631a = null;

            static {
                f101631a = new d();
            }

            public d() {
            }
        }

        public b() {
        }
    }

    static {
        f101618a = (List) vm2.h.f556081J.getValue(null, vm2.h.f556082a[34]);
        f101619b = "";
        f101620c = new ArrayList();
        f101623f = "";
    }

    public static boolean a(jh1 r110) {
        if (r110.e().length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L13:
        long r101 = 0;
        long r102 = CastLongProtector.parseLong(r110.e());     // Catch: Exception -> L19
        r101 = CastLongProtector.parseLong(r110.d());     // Catch: Exception -> L17
    L18:
        long r111 = r101;
        r101 = r102;
        long r103 = r111;
    L20:
        long r104 = System.currentTimeMillis();
        if ((r101 + 1) <= r104) goto L24;
        return false;
    L24:
        if (r103 <= r104) goto L31;
        return true;
    L31:
        return false;
    L19:
        r103 = 0;
        goto L20
    L8:
        if (r110.d().length() != 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L13;
        return true;
    L10:
        r105 = false;
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    public static void c(a r110) {
        List<jh1> r100 = f101618a;
        if (r100 != null) goto L5;
        return;
    L5:
        ((ArrayList) f101620c).clear();
        Iterator<jh1> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L65;
        jh1 r102 = r101.next();
        String r103 = r102.getType();
        String r104 = null;
        switch(r103.hashCode()) {
            case 48: goto L42;
            case 49: goto L32;
            case 50: goto L22;
            case 51: goto L12;
            default: goto L7;
        };
    L12:
        if (r103.equals("3") == false) goto L7;
        List<String> r105 = r102.b();
        if (r110 == null) goto L17;
        r104 = r110.f101627d;
    L17:
        if (CollectionsKt.contains(r105, r104) == false) goto L7;
        if (a(r102) == false) goto L7;
        b(r102.a(), r110);
        goto L7
    L22:
        if (r103.equals("2") == false) goto L7;
        List<String> r106 = r102.b();
        if (r110 == null) goto L27;
        r104 = r110.f101624a;
    L27:
        if (CollectionsKt.contains(r106, r104) == false) goto L7;
        if (a(r102) == false) goto L7;
        b(r102.a(), r110);
        goto L7
    L32:
        if (r103.equals("1") == false) goto L7;
        List<String> r107 = r102.b();
        if (r110 == null) goto L37;
        r104 = r110.f101625b;
    L37:
        if (CollectionsKt.contains(r107, r104) == false) goto L7;
        if (a(r102) == false) goto L7;
        b(r102.a(), r110);
        goto L7
    L42:
        if (r103.equals("0") == false) goto L7;
        List<kh1> r108 = r102.c();
        StringBuilder r109 = new StringBuilder();
        Iterator<kh1> r111 = r108.iterator();
    L45:
        if (r111.hasNext() == false) goto L64;
        kh1 r112 = r111.next();
        String r113 = r112.a();
        switch(r113.hashCode()) {
            case 48: goto L62;
            case 49: goto L56;
            case 50: goto L50;
            default: goto L45;
        };
    L50:
        if (r113.equals("2") == false) goto L45;
        if (r110 == null) goto L53;
        String r114 = r110.f101624a;
    L54:
        r109.append(r114);
        goto L45
    L53:
        r114 = null;
        goto L54
    L56:
        if (r113.equals("1") == false) goto L45;
        if (r110 == null) goto L59;
        String r115 = r110.f101626c;
    L60:
        r109.append(r115);
        goto L45
    L59:
        r115 = null;
        goto L60
    L62:
        if (r113.equals("0") == false) goto L45;
        r109.append(r112.b());
        goto L45
    L64:
        f101619b = r109.toString();
        b(r102.a(), r110);
        goto L7
    }

    public static void b(List r100, a r101) {
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L27;
        kh1 r104 = (kh1) r103.next();
        String r105 = r104.a();
        String r106 = "";
        switch(r105.hashCode()) {
            case 48: goto L25;
            case 49: goto L17;
            case 50: goto L9;
            default: goto L4;
        };
    L9:
        if (r105.equals("2") == false) goto L4;
        if (r101 == null) goto L15;
        String r107 = r101.f101624a;
        if (r107 == null) goto L15;
        r106 = r107;
    L15:
        r102.add(r106);
        goto L4
    L17:
        if (r105.equals("1") == false) goto L4;
        if (r101 == null) goto L23;
        String r108 = r101.f101626c;
        if (r108 == null) goto L23;
        r106 = r108;
    L23:
        r102.add(r106);
        goto L4
    L25:
        if (r105.equals("0") == false) goto L4;
        r102.add(r104.b());
        goto L4
    L27:
        ((ArrayList) f101620c).addAll(r102);
    }
}
