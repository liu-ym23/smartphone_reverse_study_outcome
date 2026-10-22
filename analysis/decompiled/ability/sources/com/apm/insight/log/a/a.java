package com.apm.insight.log.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.profileinstaller.ProfileVerifier;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2174a = d.f2184a.a();
    private static final int b = g.f2187a.a();
    private static final int c = e.f2185a.a();
    private static final int d = c.b.a();
    private static final int e = f.b.a();
    private static final int f = EnumC0145a.b.a();
    private static final ArrayList<String> g = new ArrayList<>();
    private static boolean h = false;
    private Context i;

    /* renamed from: j, reason: collision with root package name */
    private int f2175j;
    private String k;
    private String l;
    private int m;
    private int n;
    private String o = null;
    private String p;

    /* renamed from: q, reason: collision with root package name */
    private long f2176q;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.apm.insight.log.a.a$a, reason: collision with other inner class name */
    public static final class EnumC0145a {

        /* renamed from: a, reason: collision with root package name */
        public static final EnumC0145a f2177a = new EnumC0145a("NONE", 0, 0);
        public static final EnumC0145a b = new EnumC0145a("EC_SECP256K1", 1, 1);
        private static EnumC0145a c = new EnumC0145a("EC_SECP256R1", 2, 2);
        private final int d;

        private EnumC0145a(String str, int i, int i6) {
            this.d = i6;
        }

        public final int a() {
            return this.d;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Context f2178a;
        private int b = 0;
        private boolean c = false;
        private String d = null;
        private String e = null;
        private int f = 2097152;
        private int g = 20971520;
        private int h = 7;
        private String i = null;

        /* renamed from: j, reason: collision with root package name */
        private int f2179j = 65536;
        private int k = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        private String l = null;
        private int m = a.f2174a;
        private int n = a.b;
        private int o = a.c;
        private int p = a.d;

        /* renamed from: q, reason: collision with root package name */
        private int f2180q = a.e;

        /* renamed from: r, reason: collision with root package name */
        private int f2181r = a.f;

        /* renamed from: s, reason: collision with root package name */
        private String f2182s = "44817d17adcfd1bc735c022b368acfe0465c4bdbc5c77ca8efd6b578dad1177a65f83813d3f3da839778719efbb83d982737c55597b1a074f105d828a8163b42";

        public b(Context context) {
            Context applicationContext = context.getApplicationContext();
            this.f2178a = applicationContext != null ? applicationContext : context;
        }

        public final b a(int i) {
            this.b = i;
            return this;
        }

        public final b b(String str) {
            this.e = str;
            return this;
        }

        public final b c(int i) {
            this.g = i;
            return this;
        }

        public final b d(int i) {
            this.h = i;
            return this;
        }

        public final b e(int i) {
            this.f2179j = i;
            return this;
        }

        public final b f(int i) {
            this.k = i;
            return this;
        }

        public final b a(boolean z10) {
            this.c = z10;
            return this;
        }

        public final b b(int i) {
            this.f = i;
            return this;
        }

        public final b c(String str) {
            this.i = str;
            return this;
        }

        public final b d(String str) {
            this.f2182s = str;
            return this;
        }

        public final b a(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("-")) {
                    str = str.replace("-", "");
                }
                if (str.contains("_")) {
                    str = str.replace("_", "");
                }
                if (!TextUtils.isEmpty(str)) {
                    this.d = str;
                }
            }
            return this;
        }

        public final b a(d dVar) {
            this.m = dVar.a();
            return this;
        }

        public final b a(g gVar) {
            this.n = gVar.a();
            return this;
        }

        public final b a(e eVar) {
            this.o = eVar.a();
            return this;
        }

        public final b a(c cVar) {
            this.p = cVar.a();
            return this;
        }

        public final b a(f fVar) {
            this.f2180q = fVar.a();
            return this;
        }

        public final b a(EnumC0145a enumC0145a) {
            this.f2181r = enumC0145a.a();
            return this;
        }

        public final a a() {
            if (this.d == null) {
                this.d = "default";
            }
            synchronized (a.g) {
                try {
                    Iterator it = a.g.iterator();
                    while (it.hasNext()) {
                        if (((String) it.next()).equals(this.d)) {
                            return null;
                        }
                    }
                    a.g.add(this.d);
                    if (this.e == null) {
                        this.e = com.apm.insight.log.c.c(this.f2178a).getAbsolutePath();
                    }
                    if (this.i == null) {
                        this.i = com.apm.insight.log.c.d(this.f2178a);
                    }
                    if (this.l == null) {
                        this.l = com.apm.insight.log.c.b(this.f2178a);
                    }
                    int i = (this.f2179j / 4096) << 12;
                    this.f2179j = i;
                    int i6 = (this.k / 4096) << 12;
                    this.k = i6;
                    if (i < 4096) {
                        this.f2179j = 4096;
                    }
                    int i10 = this.f2179j;
                    if (i6 < (i10 << 1)) {
                        this.k = i10 << 1;
                    }
                    return new a(this.f2178a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.f2179j, this.k, this.l, this.m, this.n, this.o, this.p, this.f2180q, this.f2181r, this.f2182s);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class c {
        private final int d;

        /* renamed from: a, reason: collision with root package name */
        public static final c f2183a = new c("NONE", 0, 0);
        private static c c = new c("ZLIB", 1, 1);
        public static final c b = new c("ZSTD", 2, 2);

        private c(String str, int i, int i6) {
            this.d = i6;
        }

        public final int a() {
            return this.d;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class d {
        private final int c;
        private static d b = new d("SPEED", 0, 0);

        /* renamed from: a, reason: collision with root package name */
        public static final d f2184a = new d("SAFE", 1, 1);

        private d(String str, int i, int i6) {
            this.c = i6;
        }

        public final int a() {
            return this.c;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public static final e f2185a = new e("DEFAULT", 0, 0);
        public static final e b = new e("LEGACY", 1, 1);
        private final int c;

        private e(String str, int i, int i6) {
            this.c = i6;
        }

        public final int a() {
            return this.c;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public static final f f2186a = new f("NONE", 0, 0);
        public static final f b = new f("TEA_16", 1, 1);
        private static f c = new f("TEA_32", 2, 2);
        private static f d = new f("TEA_64", 3, 3);
        private final int e;

        private f(String str, int i, int i6) {
            this.e = i6;
        }

        public final int a() {
            return this.e;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public static final g f2187a = new g("RAW", 0, 0);
        private static g b = new g("ISO_8601", 1, 1);
        private final int c;

        private g(String str, int i, int i6) {
            this.c = i6;
        }

        public final int a() {
            return this.c;
        }
    }

    public a(Context context, int i, boolean z10, String str, String str2, int i6, int i10, int i11, String str3, int i12, int i13, String str4, int i14, int i15, int i16, int i17, int i18, int i19, String str5) {
        this.i = context;
        this.f2175j = i;
        this.k = str2;
        this.l = str3;
        this.m = i12;
        this.n = i13 / i12;
        this.p = str;
        this.f2176q = a(i, z10, str, str2, i6, i10, i11, str3, i12, i13, str4, i14, i15, i16, i17, i18, i19, str5);
    }

    private static native long a(int i, boolean z10, String str, String str2, int i6, int i10, int i11, String str3, int i12, int i13, String str4, int i14, int i15, int i16, int i17, int i18, int i19, String str5);

    public static native void a(long j5);

    private static native void a(long j5, int i);

    private static native void a(long j5, int i, String str, String str2);

    private static native void a(long j5, int i, String str, String str2, long j6, long j10);

    private static native void a(long j5, boolean z10);

    public static synchronized void a(com.apm.insight.log.a.e eVar) {
        if (h) {
            return;
        }
        eVar.c();
        h = true;
    }

    private static native void b(long j5);

    private static native void b(long j5, int i);

    private static native void c(long j5);

    private static native void d(long j5);

    private static native long s();

    private static native long t();

    private static native long u();

    private static native long v();

    public final void b() {
        long j5 = this.f2176q;
        if (j5 != 0) {
            b(j5);
        }
    }

    public final void c() {
        long j5 = this.f2176q;
        if (j5 != 0) {
            c(j5);
        }
    }

    public final void d(String str, String str2) {
        a(3, str, str2);
    }

    public final void e(String str, String str2) {
        a(4, str, str2);
    }

    public final void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            a();
        }
    }

    public static HashMap<String, String> d() {
        return com.apm.insight.log.a.b.a();
    }

    public final long e() {
        return this.f2176q;
    }

    public final void b(int i) {
        this.f2175j = i;
        long j5 = this.f2176q;
        if (j5 != 0) {
            b(j5, i);
        }
    }

    public final void c(String str, String str2) {
        a(2, str, str2);
    }

    public final void a() {
        synchronized (this) {
            try {
                long j5 = this.f2176q;
                if (j5 != 0) {
                    this.i = null;
                    this.f2175j = 6;
                    d(j5);
                    this.f2176q = 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(String str, String str2) {
        a(1, str, str2);
    }

    public final void a(int i, String str, String str2) {
        long j5 = this.f2176q;
        if (j5 == 0 || i < this.f2175j || str == null || str2 == null) {
            return;
        }
        a(j5, i, str, str2);
    }

    public final void a(int i, String str, String str2, long j5, long j6) {
        long j10 = this.f2176q;
        if (j10 == 0 || i < this.f2175j || str == null || str2 == null) {
            return;
        }
        a(j10, i, str, str2, j5, j6);
    }

    public final void a(int i) {
        long j5 = this.f2176q;
        if (j5 != 0) {
            a(j5, i);
        }
    }

    public final void a(String str, String str2) {
        a(0, str, str2);
    }

    public final File[] a(long j5, long j6) {
        if (this.o == null) {
            String strB = com.apm.insight.log.c.b();
            this.o = strB;
            if (strB == null) {
                return new File[0];
            }
        }
        return com.apm.insight.log.a.b.a(this.k, this.o, this.p, j5, j6, -1);
    }

    public final File[] a(String str, long j5, long j6) {
        return a((String) null, this.p, j5, j6);
    }

    public final File[] a(String str, String str2, long j5, long j6) {
        return com.apm.insight.log.a.b.a(this.k, str, str2, j5, j6, -1);
    }

    public final File[] a(boolean z10, long j5, long j6, int i) {
        if (z10) {
            String str = this.o;
            strB = str != null ? str : null;
            if (strB == null) {
                strB = com.apm.insight.log.c.b();
            }
            if (strB == null) {
                return new File[0];
            }
        }
        return com.apm.insight.log.a.b.a(this.k, strB, null, j5, j6, i);
    }
}
