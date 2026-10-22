package com.baidu.bbalbscesium.j;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.content.UriPermission;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import com.baidu.bbalbscesium.h;
import com.baidu.bbalbscesium.i.i;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public class d extends com.baidu.bbalbscesium.j.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final boolean f30263i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f30264j = "Cesium";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f30265k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f30266l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f30267m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long f30268n = 5;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f30269o = 6;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f30270p = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f30271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private g f30272h;

    public static final class a implements Comparable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String[] f30273b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f30274a;

        static {
            f30273b = new String[]{"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};
        }

        private a(int r100) {
            this.f30274a = r100;
        }

        public static a a(byte r100, boolean r101) {
            int r102 = r100 & UByte.MAX_VALUE;
            if (r101 == false) goto L7;
            int r103 = r102 >> 4;
        L6:
            return a(r103);
        L7:
            r103 = r102 & 15;
            goto L6
        }

        public static a a(int r100) {
            if (r100 < 0) goto L8;
            if (r100 >= 16) goto L8;
            return new a(r100);
        L8:
            throw new IllegalArgumentException("invalid idx " + r100);
        }

        public byte a() {
            return (byte) this.f30274a;
        }

        public int a(a r100) {
            return this.f30274a - r100.f30274a;
        }

        public String b() {
            return f30273b[this.f30274a];
        }

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(Object r100) {
            return a((a) r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L15:
            return false;
        L8:
            if (a.class != r100.getClass()) goto L15;
            if (this.f30274a == ((a) r100).f30274a) goto L16;
            return false;
        L16:
            return true;
        }

        public int hashCode() {
            return this.f30274a;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map f30275a;

        class a implements Comparator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f30276a;

            public a(b r100) {
                this.f30276a = r100;
            }

            public int a(Map.Entry r100, Map.Entry r101) {
                int r102 = ((Integer) r101.getValue()).intValue() - ((Integer) r100.getValue()).intValue();
                if (r102 == 0) goto L6;
                return r102;
            L6:
                return ((a) r100.getKey()).a((a) r101.getKey());
            }

            @Override // java.util.Comparator
            public /* synthetic */ int compare(Object r100, Object r101) {
                return a((Map.Entry) r100, (Map.Entry) r101);
            }
        }

        public b() {
            this.f30275a = new HashMap();
        }

        public List a() {
            ArrayList r100 = new ArrayList(this.f30275a.entrySet());
            Collections.sort(r100, new a(this));
            ArrayList r101 = new ArrayList(6);
            int r102 = Math.min(6, r100.size());
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            Map.Entry r104 = (Map.Entry) ListProtector.get(r100, r103);
            if (((Integer) r104.getValue()).intValue() <= 1) goto L7;
            r101.add(r104.getKey());
        L7:
            r103 = r103 + 1;
            goto L3
        L8:
            return r101;
        }

        public void a(a r100) {
            Integer r101 = (Integer) this.f30275a.get(r100);
            if (r101 != null) goto L5;
            int r102 = 1;
        L6:
            this.f30275a.put(r100, r102);
            return;
        L5:
            r102 = Integer.valueOf(r101.intValue() + 1);
            goto L6
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f30277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a[] f30278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f30279c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f30280d;

        public c(d r100) {
            this.f30280d = r100;
            this.f30277a = 33;
            this.f30278b = new a[33];
        }

        public c(d r100, byte[] r101) {
            this.f30280d = r100;
            this.f30277a = 33;
            this.f30278b = new a[33];
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.length <= 0) goto L12;
            int r102 = 0;
        L8:
            if (r102 >= r101.length) goto L13;
            a r103 = a.a(r101[r102], false);
            a r104 = a.a(r101[r102], true);
            a(r103);
            a(r104);
            r102 = r102 + 1;
            goto L8
        L13:
            return;
        }

        private void a(int r100) {
            a[] r101 = this.f30278b;
            if ((r100 - r101.length) <= 0) goto L10;
            int r102 = r101.length;
            int r103 = r102 + (r102 >> 1);
            if ((r103 - r100) < 0) goto L8;
            r100 = r103;
        L8:
            this.f30278b = (a[]) Arrays.copyOf(r101, r100);
            return;
        }

        public int a() {
            return this.f30279c;
        }

        public void a(a r100) {
            a(this.f30279c + 1);
            a[] r101 = this.f30278b;
            int r102 = this.f30279c;
            this.f30279c = r102 + 1;
            r101[r102] = r100;
        }

        public a b(int r100) {
            if (r100 >= this.f30279c) goto L7;
            return this.f30278b[r100];
        L7:
            throw new IndexOutOfBoundsException("idx " + r100 + " size " + this.f30279c);
        }

        public byte[] b() {
            ByteArrayOutputStream r100 = new ByteArrayOutputStream();
            int r101 = 0;
        L3:
            int r102 = this.f30279c;
            if (r101 >= (r102 / 2)) goto L7;
            int r103 = r101 * 2;
            r100.write((byte) (((b(r103 + 1).a() & UByte.MAX_VALUE) << 4) | (b(r103).a() & UByte.MAX_VALUE)));
            r101 = r101 + 1;
            goto L3
        L7:
            if ((r102 % 2) == 0) goto L10;
            r100.write((byte) (b(r102 - 1).a() & UByte.MAX_VALUE));
        L10:
            return r100.toByteArray();
        }
    }

    /* JADX INFO: renamed from: com.baidu.bbalbscesium.j.d$d, reason: collision with other inner class name */
    public static class C0627d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f30281a;

        /* JADX INFO: renamed from: com.baidu.bbalbscesium.j.d$d$a */
        class a implements Comparator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ C0627d f30282a;

            public a(C0627d r100) {
                this.f30282a = r100;
            }

            public int a(b r100, b r101) {
                return b.a(r100) - b.a(r101);
            }

            @Override // java.util.Comparator
            public /* synthetic */ int compare(Object r100, Object r101) {
                return a((b) r100, (b) r101);
            }
        }

        /* JADX INFO: renamed from: com.baidu.bbalbscesium.j.d$d$b */
        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f30283a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private a f30284b;

            public b(a r100) {
                this.f30284b = r100;
            }

            public static /* synthetic */ int a(b r100) {
                return r100.f30283a;
            }

            public static /* synthetic */ a b(b r100) {
                return r100.f30284b;
            }

            public a a() {
                return this.f30284b;
            }

            public void b() {
                this.f30283a++;
            }
        }

        public C0627d() {
            this.f30281a = new ArrayList();
        }

        public List a() {
            ArrayList r100 = new ArrayList(this.f30281a);
            Collections.sort(r100, new a(this));
            return r100;
        }

        public void a(a r100) {
            this.f30281a.add(new b(r100));
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        byte[] f30285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        byte f30286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        byte[] f30287c;

        public e(byte[] r100, byte r101, byte[] r102) {
            this.f30285a = r100;
            this.f30286b = r101;
            this.f30287c = r102;
        }

        public static e a(h.a r100) {
            byte[] r101 = d.a(r100.b());     // Catch: Exception -> L12
            if (r101.length <= 16) goto L6;
            return null;
        L6:
            byte r102 = r100.e().getBytes("UTF-8")[0];     // Catch: Exception -> L12
            if (r100.c() == null) goto L9;
            byte[] r103 = r100.c().getBytes("UTF-8");     // Catch: Exception -> L12
        L10:
            return new e(r101, r102, r103);
        L9:
            r103 = null;
        L12:
            return null;
        }

        public h.a a() {
            String r100 = com.baidu.bbalbscesium.m.c.a(this.f30285a, "", true);     // Catch: Exception -> L9
            String r101 = new String(new byte[]{this.f30286b}, "UTF-8");     // Catch: Exception -> L9
            byte[] r102 = this.f30287c;     // Catch: Exception -> L9
            if (r102 == null) goto L6;
            String r103 = new String(r102, "UTF-8");     // Catch: Exception -> L9
        L7:
            return h.a(r100, r101, r103);
        L6:
            r103 = null;
        L9:
            return null;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f30289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f30290c;

        public f() {
            this.f30290c = 16;
        }

        public String toString() {
            return "";
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Method f30291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Method f30292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f30293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Method f30294d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Method f30295e;

        public g() {
        }

        public int a(Context r100, Uri r101, int r102, int r103, int r104) throws i.a {
            return ((Integer) this.f30291a.invoke(r100, new Object[]{r101, Integer.valueOf(r102), Integer.valueOf(r103), Integer.valueOf(r104)})).intValue();
        L4:
            e = move-exception;
            throw new i.a(e);
        }

        public void a() {
            String r100 = i.a(com.baidu.bbalbscesium.i.h.a());     // Catch: Exception -> L4
            Class r101 = Integer.TYPE;     // Catch: Exception -> L4
            this.f30291a = i.a(Context.class, r100, new Class[]{Uri.class, r101, r101, r101});     // Catch: Exception -> L4
            this.f30292b = i.a(Context.class, i.a(com.baidu.bbalbscesium.i.h.d()), new Class[]{String.class, Uri.class, r101});     // Catch: Exception -> L4
            this.f30293c = i.a(ContentResolver.class, i.a(com.baidu.bbalbscesium.i.h.g()), new Class[]{Uri.class, r101});     // Catch: Exception -> L4
            this.f30294d = i.a(Context.class, i.a(com.baidu.bbalbscesium.i.h.f()), new Class[]{Uri.class, r101});     // Catch: Exception -> L4
            this.f30295e = i.a(ContentResolver.class, i.a(com.baidu.bbalbscesium.i.h.e()), new Class[]{Uri.class, r101});     // Catch: Exception -> L4
            return;
        }

        public void a(ContentResolver r100, Uri r101, int r102) throws i.a {
            this.f30295e.invoke(r100, new Object[]{r101, Integer.valueOf(r102)});     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            throw new i.a(e);
        }

        public void a(Context r100, Uri r101, int r102) throws i.a {
            this.f30294d.invoke(r100, new Object[]{r101, Integer.valueOf(r102)});     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            throw new i.a(e);
        }

        public void a(Context r100, String r101, Uri r102, int r103) throws i.a {
            this.f30292b.invoke(r100, new Object[]{r101, r102, Integer.valueOf(r103)});     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            throw new i.a(e);
        }

        public void b(ContentResolver r100, Uri r101, int r102) throws i.a {
            this.f30293c.invoke(r100, new Object[]{r101, Integer.valueOf(r102)});     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            throw new i.a(e);
        }
    }

    public d() {
        super(com.baidu.bbalbscesium.j.b.f30211c, com.baidu.bbalbscesium.j.b.f30212d);
        g r100 = new g();
        this.f30272h = r100;
        r100.a();
    }

    private a a(String r100, int r101, List r110, int r111, f r112) {
        Iterator r113 = r110.iterator();
    L4:
        if (r113.hasNext() == false) goto L9;
        C0627d.b r102 = (C0627d.b) r113.next();
        if (a(r100, r101, C0627d.b.b(r102), r111, r112) == false) goto L4;
        r102.b();
        return C0627d.b.b(r102);
    L9:
        return null;
    }

    private String a(String r100, int r101, a r102) {
        return String.format("content://%s/dat/v1/i%d/%s", new Object[]{b(r100), Integer.valueOf(r101), r102.b()});
    }

    private String a(String r100, a r101) {
        return String.format("content://%s/dic/v1/%s", new Object[]{b(r100), r101.b()});
    }

    private void a(UriMatcher r100) {
        r100.addURI(b(this.f30271g.getPackageName()), "dat/v1/*/*", 1);
        r100.addURI(b(this.f30271g.getPackageName()), "dic/v1/*", 2);
    }

    private boolean a(int r100, a r101) {
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return false;
    L7:
        return a(UriProtector.parse(a(this.f30271g.getPackageName(), r100, r101)));
    }

    private boolean a(Uri r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        Context r101 = this.f30271g;
        ContentResolver r102 = r101.getContentResolver();
        this.f30272h.a(r101, r101.getPackageName(), r100, 65);     // Catch: Exception -> L8
        this.f30272h.b(r102, r100, 1);     // Catch: Exception -> L8
        return true;
    L8:
        return false;
    }

    private boolean a(Uri r100, int r101) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        Context r102 = this.f30271g;
        ContentResolver r103 = r102.getContentResolver();
        this.f30272h.a(r102, r100, r101);     // Catch: Exception -> L9
        this.f30272h.a(r103, r100, r101);     // Catch: Exception -> L9
        return true;
    L9:
        return false;
    }

    private boolean a(a r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return false;
    L7:
        return a(UriProtector.parse(a(this.f30271g.getPackageName(), r100)));
    }

    private boolean a(c r110, List r111) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        ContentResolver r100 = this.f30271g.getContentResolver();
        UriMatcher r101 = new UriMatcher(-1);
        a(r101);
        List<UriPermission> r102 = r100.getPersistedUriPermissions();
        if (r102 != null) goto L8;
    L9:
        r102 = r100.getOutgoingPersistedUriPermissions();
    L11:
        if (r102 != null) goto L13;
    L63:
        return true;
    L13:
        if (r102.size() == 0) goto L63;
        Iterator<UriPermission> r103 = r102.iterator();
    L17:
        if (r103.hasNext() == false) goto L50;
        UriPermission r104 = r103.next();
        Uri r105 = r104.getUri();
        int r106 = r101.match(r105);
        List<String> r107 = r105.getPathSegments();
        int r108 = 3;
        if (r106 == 1) goto L22;
        if (r106 == 2) goto L22;
    L28:
        if (r106 == 1) goto L64;
        if (r106 != 2) goto L17;
        String r109 = (String) ListProtector.get(r107, 2);
        Iterator r112 = r111.iterator();
    L43:
        if (r112.hasNext() == false) goto L47;
        if (((a) r112.next()).b().equals(r109) == false) goto L43;
        boolean r113 = true;
    L48:
        if (r113 == true) goto L17;
    L49:
        a(r105, 1);
        goto L17
    L47:
        r113 = false;
        goto L48
    L64:
        int r114 = CastIntegerProtector.valueOf(((String) ListProtector.get(r107, 2)).substring(1)).intValue();     // Catch: Exception -> L32
    L33:
        if (r114 < 0) goto L49;
        if (r114 >= r110.a()) goto L49;
        String r115 = (String) ListProtector.get(r107, 3);
        if (r110.b(r114).b().equals(r115) == true) goto L17;
    L32:
        r114 = -1;
    L22:
        if (r104.isWritePermission() == false) goto L28;
        if (r104.isReadPermission() == true) goto L27;
        r108 = 2;
    L27:
        a(r105, r108);
        goto L17
    L50:
        int r116 = r110.a();
        int r117 = 0;
    L51:
        if (r117 >= r116) goto L56;
        int r118 = r117;
        if (a(this.f30271g.getPackageName(), r118, r110.b(r117), Process.myUid(), null) == false) goto L54;
        r117 = r117 + 1;
        goto L51
    L54:
        return true;
    L56:
        int r119 = r111.size();
        int r120 = 0;
    L57:
        if (r120 >= r119) goto L62;
        if (a(this.f30271g.getPackageName(), (a) ListProtector.get(r111, r120), Process.myUid()) == false) goto L60;
        r120 = r120 + 1;
        goto L57
    L60:
        return true;
    L62:
        return false;
    L8:
        if (r102.size() != 0) goto L11;
        goto L9
    }

    private boolean a(String r100, int r101, a r110, int r111, f r112) {
        Uri r102 = UriProtector.parse(a(r100, r101, r110));
        int r113 = 0;
    L4:
        if (r113 >= 2) goto L12;
        if (r112 != null) goto L19;
    L7:
        int r103 = this.f30272h.a(this.f30271g, r102, 0, r111, 1);     // Catch: Throwable -> L9
    L21:
        Thread.sleep(5);     // Catch: Exception -> L18
    L11:
        r113 = r113 + 1;
    L13:
        if (r103 != 0) goto L15;
        return true;
    L15:
        if (r112 == null) goto L17;
        r112.f30289b++;
    L17:
        return false;
    L19:
        r112.f30288a++;     // Catch: Throwable -> L9
        goto L7
    L12:
        r103 = -1;
        goto L13
    }

    private boolean a(String r100, a r101, int r110) {
        Uri r102 = UriProtector.parse(a(r100, r101));
        int r103 = 0;
    L4:
        if (r103 >= 2) goto L10;
        int r104 = this.f30272h.a(this.f30271g, r102, 0, r110, 1);     // Catch: Throwable -> L7
    L11:
        if (r104 != 0) goto L14;
        return true;
    L14:
        return false;
    L16:
        Thread.sleep(5);     // Catch: Exception -> L15
    L9:
        r103 = r103 + 1;
        goto L4
    L10:
        r104 = -1;
        goto L11
    }

    public static /* synthetic */ byte[] a(String r100) {
        return c(r100);
    }

    private String b(String r100) {
        return r100 + ".cesium";
    }

    private static byte[] c(String r100) {
        if ((r100.length() % 2) != 0) goto L14;
        int r101 = r100.length() / 2;
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L5:
        if (r103 >= r101) goto L12;
        int r104 = r103 * 2;
        int r105 = Character.digit(r100.charAt(r104), 16);
        int r106 = Character.digit(r100.charAt(r104 + 1), 16);
        if (r105 == (-1)) goto L11;
        if (r106 == (-1)) goto L11;
        r102[r103] = (byte) ((r105 * 16) + r106);
        r103 = r103 + 1;
    L11:
        throw new IllegalArgumentException("input is not hexadecimal");
    L12:
        return r102;
    L14:
        throw new IllegalArgumentException("Expected a string of even length");
    }

    @Override // com.baidu.bbalbscesium.j.a
    public com.baidu.bbalbscesium.j.a.f a(com.baidu.bbalbscesium.j.a.e r100, h.a r101) {
        return com.baidu.bbalbscesium.j.a.f.d();
    }

    @Override // com.baidu.bbalbscesium.j.a
    public com.baidu.bbalbscesium.j.a.h a(String r210, com.baidu.bbalbscesium.j.a.g r211) {
        if (Build.VERSION.SDK_INT >= 26) goto L69;
        return com.baidu.bbalbscesium.j.a.h.a();
    L69:
        int r100 = this.f30271g.getPackageManager().getPackageUid(r210, 0);     // Catch: PackageManager.NameNotFoundException -> L9
    L10:
        if (r100 < 0) goto L12;
        f r110 = new f();
        c r111 = new c(this);
        C0627d r112 = new C0627d();
        C0627d r113 = new C0627d();
        int r101 = 0;
    L15:
        if (r101 >= 16) goto L21;
        a r102 = a.a(r101);
        if (a(r210, r102, r100) == false) goto L19;
        r112.a(r102);
    L20:
        r101 = r101 + 1;
        goto L15
    L19:
        r113.a(r102);
        goto L20
    L21:
        int r114 = 0;
    L23:
        if (r114 >= 32) goto L31;
        a r103 = a(r210, r114, r112.a(), r100, r110);
        if (r103 != null) goto L27;
        r103 = a(r210, r114, r113.a(), r100, r110);
    L27:
        if (r103 == null) goto L29;
        r111.a(r103);
        r114 = r114 + 1;
        goto L23
    L29:
        return com.baidu.bbalbscesium.j.a.h.a();
    L31:
        byte[] r115 = r111.b();
        int r116 = 3;
        byte[] r104 = {"0".getBytes()[0], "O".getBytes()[0], "V".getBytes()[0]};
        int r105 = 0;
    L32:
        byte[] r117 = null;
        if (r105 >= r116) goto L40;
        byte r106 = r104[r105];
        a r107 = a.a(r106, false);
        int r118 = r105;
        boolean r119 = true;
        byte[] r120 = r104;
        if (a(r210, 32, r107, r100, r110) == false) goto L39;
        a r121 = a.a(r106, true);
        if (a(r210, 33, r121, r100, r110) == false) goto L39;
        c r108 = new c(this);
        r108.a(r107);
        r108.a(r121);
        Byte r109 = Byte.valueOf(r108.b()[0]);
    L41:
        int r122 = 34;
        if (r109 != null) goto L53;
        c r123 = new c(this);
        int r124 = 32;
    L44:
        if (r124 >= r122) goto L52;
        int r125 = r124;
        c r126 = r123;
        a r127 = a(r210, r124, r112.a(), r100, r110);
        if (r127 != null) goto L48;
        r127 = a(r210, r125, r113.a(), r100, r110);
    L48:
        if (r127 == null) goto L50;
        r126.a(r127);
        r124 = r125 + 1;
        r123 = r126;
        r122 = 34;
        goto L44
    L50:
        return com.baidu.bbalbscesium.j.a.h.a();
    L52:
        Byte r128 = Byte.valueOf(r123.b()[0]);
    L54:
        if (r119 == false) goto L68;
        c r129 = new c(this);
        int r130 = 34;
    L57:
        if (r130 >= 94) goto L65;
        a r131 = a(r210, r130, r112.a(), r100, r110);
        if (r131 != null) goto L61;
        r131 = a(r210, r130, r113.a(), r100, r110);
    L61:
        if (r131 == null) goto L65;
        r129.a(r131);
        r130 = r130 + 1;
    L65:
        if (r129.a() <= 0) goto L68;
        r117 = r129.b();
    L68:
        return com.baidu.bbalbscesium.j.a.h.a(new e(r115, r128.byteValue(), r117).a());
    L53:
        r128 = r109;
        r119 = false;
    L39:
        r105 = r118 + 1;
        r104 = r120;
        r116 = 3;
        goto L32
    L40:
        r119 = true;
        r109 = null;
        goto L41
    L12:
        return com.baidu.bbalbscesium.j.a.h.a();
    L9:
        r100 = -1;
        goto L10
    }

    @Override // com.baidu.bbalbscesium.j.a
    public void a(com.baidu.bbalbscesium.j.a.d r100) {
        this.f30271g = this.f30183a.f30187a;
    }
}
